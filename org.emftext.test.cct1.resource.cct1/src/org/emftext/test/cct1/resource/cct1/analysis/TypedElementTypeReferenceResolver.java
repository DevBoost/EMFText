package org.emftext.test.cct1.resource.cct1.analysis;

public class TypedElementTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.test.cct1.TypedElement, org.emftext.test.cct1.Class> {
	
	private org.emftext.test.cct1.resource.cct1.analysis.Cct1DefaultResolverDelegate<org.emftext.test.cct1.TypedElement, org.emftext.test.cct1.Class> delegate = new org.emftext.test.cct1.resource.cct1.analysis.Cct1DefaultResolverDelegate<org.emftext.test.cct1.TypedElement, org.emftext.test.cct1.Class>();
	
	public void resolve(java.lang.String identifier, org.emftext.test.cct1.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.test.cct1.Class> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.test.cct1.Class element, org.emftext.test.cct1.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
