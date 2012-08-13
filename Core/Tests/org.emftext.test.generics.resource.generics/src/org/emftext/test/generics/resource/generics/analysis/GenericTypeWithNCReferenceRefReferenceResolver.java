/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.generics.resource.generics.analysis;

public class GenericTypeWithNCReferenceRefReferenceResolver implements org.emftext.test.generics.resource.generics.IGenericsReferenceResolver<org.emftext.test.generics.GenericTypeWithNCReference, org.eclipse.emf.ecore.EObject> {
	
	private org.emftext.test.generics.resource.generics.analysis.GenericsDefaultResolverDelegate<org.emftext.test.generics.GenericTypeWithNCReference, org.eclipse.emf.ecore.EObject> delegate = new org.emftext.test.generics.resource.generics.analysis.GenericsDefaultResolverDelegate<org.emftext.test.generics.GenericTypeWithNCReference, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, org.emftext.test.generics.GenericTypeWithNCReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.test.generics.resource.generics.IGenericsReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, org.emftext.test.generics.GenericTypeWithNCReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
