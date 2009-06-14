/**
 * 
 */
package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A representation for a range in a document where a structural feature (e.g.,
 * a reference) is expected.
 */
public class ExpectedStructuralFeature extends AbstractExpectedElement {
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
		String simpleName = container == null ? "null" : container.getClass().getSimpleName();
		return super.toString() + " EFeature \"" + feature.getName() + "\" in " + simpleName;
	}

	public boolean equals(Object o) {
		if (o instanceof ExpectedStructuralFeature) {
			return this.feature.equals(((ExpectedStructuralFeature) o).feature);
		}
		return false;
	}
}