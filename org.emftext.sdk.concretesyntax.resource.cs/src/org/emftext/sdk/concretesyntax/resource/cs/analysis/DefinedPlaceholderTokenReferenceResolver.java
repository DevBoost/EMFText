package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class DefinedPlaceholderTokenReferenceResolver extends AbstractReferenceResolver {

	@Override
	protected void doResolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy,
			IResolveResult result) {
		if (!(container instanceof DefinedPlaceholder)) {
			return;
		}
		// first look in imports
		EObject root = findRoot(container);
		if (!(root instanceof ConcreteSyntax)) {
			return;
		}
		ConcreteSyntax syntax = (ConcreteSyntax) root;
		for (Import nextImport : syntax.getImports()) {
			ConcreteSyntax nextImportedSyntax = nextImport.getConcreteSyntax();
			if (nextImportedSyntax == null) {
				continue;
			}
			for (TokenDefinition tokenDefinition : nextImportedSyntax.getTokens()) {
				final String tokenName = tokenDefinition.getName();
				if (tokenName.equals(identifier) && !resolveFuzzy) {
					result.addMapping(identifier, tokenDefinition);
					return;
				}
				if (tokenName.startsWith(identifier) && resolveFuzzy) {
					result.addMapping(tokenName, tokenDefinition);
				}
			}
		}
		// the look in the resource itself
		super.doResolve(identifier, container, reference, position, resolveFuzzy,
				result);
	}

}
