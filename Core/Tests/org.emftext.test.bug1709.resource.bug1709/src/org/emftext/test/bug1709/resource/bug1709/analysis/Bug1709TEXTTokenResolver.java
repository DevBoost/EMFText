/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.bug1709.resource.bug1709.analysis;

public class Bug1709TEXTTokenResolver implements org.emftext.test.bug1709.resource.bug1709.IBug1709TokenResolver {
	
	private org.emftext.test.bug1709.resource.bug1709.analysis.Bug1709DefaultTokenResolver defaultTokenResolver = new org.emftext.test.bug1709.resource.bug1709.analysis.Bug1709DefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.test.bug1709.resource.bug1709.IBug1709TokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
