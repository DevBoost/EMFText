package org.emftext.test.cct1.resource.cct1.analysis;

public class Cct1TEXTTokenResolver extends org.emftext.runtime.resource.impl.AbstractTokenResolver {
	
	private org.emftext.test.cct1.resource.cct1.Cct1DefaultTokenResolver defaultTokenResolver = new org.emftext.test.cct1.resource.cct1.Cct1DefaultTokenResolver();
	
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
