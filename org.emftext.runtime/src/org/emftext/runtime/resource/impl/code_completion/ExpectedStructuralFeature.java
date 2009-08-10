/**
 * 
 */
package org.emftext.runtime.resource.impl.code_completion;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.impl.AbstractExpectedElement;

/**
 * A representation for a range in a document where a structural feature (e.g.,
 * a reference) is expected.
 */
public class ExpectedStructuralFeature extends AbstractExpectedElement {
	private EStructuralFeature feature;
	private EObject container;
	private String tokenName;

	@Deprecated
	public ExpectedStructuralFeature(EStructuralFeature feature, EObject container, String tokenName) {
		this(0, feature, container, tokenName);
	}
	
	public ExpectedStructuralFeature(int nestingLevel, EStructuralFeature feature, EObject container, String tokenName) {
		super(nestingLevel);
		this.feature = feature;
		this.container = container;
		this.tokenName = tokenName;
	}

	public EStructuralFeature getFeature() {
		return feature;
	}

	public EObject getContainer() {
		return container;
	}
	
	public String getTokenName() {
		return tokenName;
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