/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A Cct5ContainmentTrace represents a specific path to a structural feature by
 * navigating over a set of a structural feature from a start class.
 * Cct5ContainmentTraces are used during code completion to reconstruct
 * containment trees that are not created by the parser, for example, if the first
 * character of the contained object has not been typed yet.
 */
public class Cct5ContainmentTrace {
	
	/**
	 * The class where the trace starts.
	 */
	private EClass startClass;
	
	/**
	 * The path of contained features.
	 */
	private org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] path;
	
	public Cct5ContainmentTrace(EClass startClass, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] path) {
		super();
		// Verify arguments
		if (startClass != null) {
			if (path.length > 0) {
				EStructuralFeature feature = path[path.length - 1].getFeature();
				if (!startClass.getEAllStructuralFeatures().contains(feature)) {
					throw new RuntimeException("Metaclass " + startClass.getName() + " must contain feature " + feature.getName());
				}
			}
		}
		this.startClass = startClass;
		this.path = path;
	}
	
	public EClass getStartClass() {
		return startClass;
	}
	
	public org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] getPath() {
		return path;
	}
	
	public String toString() {
		return (startClass == null ? "null" : startClass.getName()) + "->" + org.emftext.test.cct5.resource.cct5.util.Cct5StringUtil.explode(path, "->");
	}
	
}
