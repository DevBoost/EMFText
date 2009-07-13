package org.emftext.test.grammar_features.resource.grammar_features.analysis;

public class PlusNonContainmentReferenceReferenceResolver extends org.emftext.runtime.resource.impl.AbstractReferenceResolver<org.emftext.test.grammar_features.PlusNonContainment, org.emftext.test.grammar_features.X> {
	
	private org.emftext.test.grammar_features.resource.grammar_features.analysis.Grammar_featuresDefaultResolverDelegate<org.emftext.test.grammar_features.PlusNonContainment, org.emftext.test.grammar_features.X> delegate = new org.emftext.test.grammar_features.resource.grammar_features.analysis.Grammar_featuresDefaultResolverDelegate<org.emftext.test.grammar_features.PlusNonContainment, org.emftext.test.grammar_features.X>();
	
	public void resolve(java.lang.String identifier, org.emftext.test.grammar_features.PlusNonContainment container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.runtime.resource.IReferenceResolveResult<org.emftext.test.grammar_features.X> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.test.grammar_features.X element, org.emftext.test.grammar_features.PlusNonContainment container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
