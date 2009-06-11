package org.emftext.test.code_completion.resource.cct.analysis;

public class TypedElementTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.test.code_completion.TypedElement, org.emftext.test.code_completion.Class> {
	
	private org.emftext.test.code_completion.resource.cct.analysis.CctDefaultResolverDelegate<org.emftext.test.code_completion.TypedElement, org.emftext.test.code_completion.Class> delegate = new org.emftext.test.code_completion.resource.cct.analysis.CctDefaultResolverDelegate<org.emftext.test.code_completion.TypedElement, org.emftext.test.code_completion.Class>();
	
	public void resolve(java.lang.String identifier, org.emftext.test.code_completion.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.test.code_completion.Class> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.test.code_completion.Class element, org.emftext.test.code_completion.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// do nothing - we do not need the options
	}
}
