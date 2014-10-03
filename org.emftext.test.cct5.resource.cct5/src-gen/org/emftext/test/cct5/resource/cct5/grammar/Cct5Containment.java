/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.grammar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Cct5Containment extends org.emftext.test.cct5.resource.cct5.grammar.Cct5Terminal {
	
	private final EClass[] allowedTypes;
	
	public Cct5Containment(EStructuralFeature feature, org.emftext.test.cct5.resource.cct5.grammar.Cct5Cardinality cardinality, EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.test.cct5.resource.cct5.util.Cct5StringUtil.explode(allowedTypes, ", ", new org.emftext.test.cct5.resource.cct5.ICct5Function1<String, EClass>() {
				public String execute(EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
