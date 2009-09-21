package org.emftext.test.cct1.resource.cct1.analysis;

import org.emftext.test.cct1.resource.cct1.ICct1TokenResolveResult;
import org.emftext.test.cct1.resource.cct1.ICct1TokenResolver;

public class Cct1TEXTTokenResolver implements ICct1TokenResolver {
	
	private org.emftext.test.cct1.resource.cct1.analysis.Cct1DefaultTokenResolver defaultTokenResolver = new org.emftext.test.cct1.resource.cct1.analysis.Cct1DefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ICct1TokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
