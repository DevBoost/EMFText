package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.DefinedPlaceholder;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class DefinedPlaceholderTokenReferenceResolver extends AbstractReferenceResolver<DefinedPlaceholder> {

	@Override
	protected void doResolve(String identifier, DefinedPlaceholder container,
			EReference reference, int position, boolean resolveFuzzy,
			IReferenceResolveResult result) {
		// first look in imported syntaxes for the token
		boolean continueSearch = searchForTokenInImportedSyntaxes(identifier, container, resolveFuzzy,
				result);
		if (!continueSearch) {
			return;
		}
		// then look in the resource itself
		super.doResolve(identifier, container, reference, position, resolveFuzzy,
				result);
	}

	private boolean searchForTokenInImportedSyntaxes(String identifier,
			DefinedPlaceholder container, boolean resolveFuzzy, IReferenceResolveResult result) {
		EObject root = findRoot(container);
		if (!(root instanceof ConcreteSyntax)) {
			return false;
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
					return false;
				}
				if (tokenName.startsWith(identifier) && resolveFuzzy) {
					result.addMapping(tokenName, tokenDefinition);
				}
			}
		}
		return true;
	}

}
