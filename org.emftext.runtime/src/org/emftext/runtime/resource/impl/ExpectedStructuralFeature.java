/**
 * 
 */
package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ExpectedStructuralFeature implements IExpectedElement {
	private EStructuralFeature feature;
	private EObject container;

	public ExpectedStructuralFeature(EStructuralFeature feature, EObject container) {
		this.feature = feature;
		this.container = container;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public EObject getContainer() {
		return container;
	}
	
	public String toString() {
		return "EFeature \"" + feature.getName() + "\" in " + container;
	}

	public boolean equals(Object o) {
		if (o instanceof ExpectedStructuralFeature) {
			return this.feature.equals(((ExpectedStructuralFeature) o).feature);
		}
		return false;
	}
}