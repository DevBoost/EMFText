package org.emftext.sdk.codegen.generators.code_completion.helpers;

import org.eclipse.emf.ecore.EStructuralFeature;

public class ExpectedFeature implements IExpectedElement {

	private EStructuralFeature ecoreFeature;
	private String scopeID;
	private String message;
	
	public ExpectedFeature(EStructuralFeature ecoreFeature, String scopeID,
			String message) {
		this.ecoreFeature = ecoreFeature;
		this.scopeID = scopeID;
		this.message = message;
	}

	public String toString() {
		return ecoreFeature.getEContainingClass().getEPackage().getNsPrefix() + ":" +
			ecoreFeature.getEContainingClass().getName() + "." +
			ecoreFeature.getName();
	}
}
