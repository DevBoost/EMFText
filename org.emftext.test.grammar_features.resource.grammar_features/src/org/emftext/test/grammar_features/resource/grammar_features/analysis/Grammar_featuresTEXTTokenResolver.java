package org.emftext.test.grammar_features.resource.grammar_features.analysis;

public class Grammar_featuresTEXTTokenResolver extends org.emftext.runtime.resource.impl.AbstractTokenResolver {
	
	private org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresDefaultTokenResolver defaultTokenResolver = new org.emftext.test.grammar_features.resource.grammar_features.Grammar_featuresDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.runtime.resource.ITokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
