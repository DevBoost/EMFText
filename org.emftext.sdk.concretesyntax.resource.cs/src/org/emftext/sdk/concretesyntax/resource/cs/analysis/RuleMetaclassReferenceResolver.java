package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver;

public class RuleMetaclassReferenceResolver extends ReferenceResolverImpl {
	
	private MetaclassReferenceResolver resolver = new MetaclassReferenceResolver();
	
	@Override
	protected void doResolve(final String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, IResolveResult result) {
		
		resolver.doResolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	@Override
	public String deResolve(EObject element, EObject container, EReference reference){
		return resolver.deResolve(element, container, reference);
	}
}
