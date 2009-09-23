package org.emftext.test.grammar_features.resource.grammar_features.analysis;

import org.emftext.test.grammar_features.resource.grammar_features.IGrammar_featuresTokenResolveResult;
import org.emftext.test.grammar_features.resource.grammar_features.IGrammar_featuresTokenResolver;

public class Grammar_featuresTEXTTokenResolver implements IGrammar_featuresTokenResolver {
	
	private Grammar_featuresDefaultTokenResolver defaultTokenResolver = new Grammar_featuresDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, IGrammar_featuresTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
