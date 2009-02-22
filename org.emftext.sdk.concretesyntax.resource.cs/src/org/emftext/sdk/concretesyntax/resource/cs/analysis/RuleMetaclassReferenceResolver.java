package org.emftext.sdk.concretesyntax.resource.cs.analysis; 

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver;

public class RuleMetaclassReferenceResolver extends AbstractReferenceResolver<Rule, GenClass> {
	
	private MetaclassReferenceResolver resolver = new MetaclassReferenceResolver();
	
	@Override
	protected void doResolve(final String identifier, Rule container,
			EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult result) {
		
		resolver.doResolve(identifier, container, reference, position, resolveFuzzy, result, null, false);
	}

	@Override
	public String deResolve(GenClass element, Rule container, EReference reference){
		return resolver.deResolve(element, container, reference);
	}
}
