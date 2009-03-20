package org.emftext.sdk.concretesyntax.resource.cs.analysis;

public class PlaceholderTokenReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.sdk.concretesyntax.Placeholder, org.emftext.sdk.concretesyntax.TokenDefinition> {
	
	@Override	
	protected java.lang.String doDeResolve(org.emftext.sdk.concretesyntax.TokenDefinition element, org.emftext.sdk.concretesyntax.Placeholder container, org.eclipse.emf.ecore.EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(java.lang.String identifier, org.emftext.sdk.concretesyntax.Placeholder container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.sdk.concretesyntax.TokenDefinition> result) {
		super.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}
}
