/**
 * 
 */
package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EStructuralFeature;

public class ExpectedStructuralFeature implements IExpectedElement {
	private EStructuralFeature feature;

	public ExpectedStructuralFeature(EStructuralFeature feature) {
		this.feature = feature;
	}

	public String toString() {
		return "EFeature \"" + feature.getName() + "\"";
	}

	public boolean equals(Object o) {
		if (o instanceof ExpectedStructuralFeature) {
			return this.feature.equals(((ExpectedStructuralFeature) o).feature);
		}
		return false;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}
}