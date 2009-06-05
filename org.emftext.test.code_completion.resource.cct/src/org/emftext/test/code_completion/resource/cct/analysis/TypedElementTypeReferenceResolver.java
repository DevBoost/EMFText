package org.emftext.test.code_completion.resource.cct.analysis;

public class TypedElementTypeReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.test.code_completion.TypedElement, org.emftext.test.code_completion.Class> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.test.code_completion.Class element, org.emftext.test.code_completion.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.test.code_completion.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.test.code_completion.Class> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
