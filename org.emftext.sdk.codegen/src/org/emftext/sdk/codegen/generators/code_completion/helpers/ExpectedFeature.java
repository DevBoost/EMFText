package org.emftext.sdk.codegen.generators.code_completion.helpers;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ExpectedFeature implements IExpectedElement {

	private GenFeature genFeature;
	private String scopeID;
	private String message;
	private GenClass genClass;
	
	public ExpectedFeature(GenFeature genFeature, GenClass genClass, String scopeID,
			String message) {
		this.genFeature = genFeature;
		this.genClass = genClass;
		this.scopeID = scopeID;
		this.message = message;
	}
	
	public GenFeature getGenFeature() {
		return genFeature;
	}

	public String getScopeID() {
		return scopeID;
	}

	public GenClass getGenClass() {
		return genClass;
	}

	public String toString() {
		EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		return ecoreFeature.getEContainingClass().getEPackage().getNsPrefix() + ":" +
			ecoreFeature.getEContainingClass().getName() + "." +
			ecoreFeature.getName();
	}
}
