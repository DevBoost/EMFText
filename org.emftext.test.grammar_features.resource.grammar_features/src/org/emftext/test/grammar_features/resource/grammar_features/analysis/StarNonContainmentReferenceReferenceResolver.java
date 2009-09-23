package org.emftext.test.grammar_features.resource.grammar_features.analysis;

import org.emftext.test.grammar_features.resource.grammar_features.IGrammar_featuresReferenceResolveResult;
import org.emftext.test.grammar_features.resource.grammar_features.IGrammar_featuresReferenceResolver;

public class StarNonContainmentReferenceReferenceResolver implements IGrammar_featuresReferenceResolver<org.emftext.test.grammar_features.StarNonContainment, org.emftext.test.grammar_features.X> {
	
	private org.emftext.test.grammar_features.resource.grammar_features.analysis.Grammar_featuresDefaultResolverDelegate<org.emftext.test.grammar_features.StarNonContainment, org.emftext.test.grammar_features.X> delegate = new org.emftext.test.grammar_features.resource.grammar_features.analysis.Grammar_featuresDefaultResolverDelegate<org.emftext.test.grammar_features.StarNonContainment, org.emftext.test.grammar_features.X>();
	
	public void resolve(java.lang.String identifier, org.emftext.test.grammar_features.StarNonContainment container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, IGrammar_featuresReferenceResolveResult<org.emftext.test.grammar_features.X> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.emftext.test.grammar_features.X element, org.emftext.test.grammar_features.StarNonContainment container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// TODO save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
