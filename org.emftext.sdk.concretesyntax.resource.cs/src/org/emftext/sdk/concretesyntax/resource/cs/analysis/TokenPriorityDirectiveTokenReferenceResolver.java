package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;

public class TokenPriorityDirectiveTokenReferenceResolver extends AbstractReferenceResolver<TokenPriorityDirective, TokenDefinition> {
	
	public String deResolve(TokenDefinition element, TokenPriorityDirective container, EReference reference) {
		return element.getName();
	}
	
	public void resolve(String identifier, TokenPriorityDirective container, EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<TokenDefinition> result) {
		ConcreteSyntax syntax = (ConcreteSyntax) container.eContainer();
		List<TokenDirective> tokens = syntax.getAllTokenDirectives();
		for (TokenDirective tokenDirective : tokens) {
			if (tokenDirective instanceof TokenDefinition) {
				TokenDefinition token = (TokenDefinition) tokenDirective;
				if (resolveFuzzy) {
					if (token.getName().startsWith(identifier)) {
						result.addMapping(identifier, token);
					}
				} else {
					if (token.getName().equals(identifier)) {
						result.addMapping(identifier, token);
					}
				}
			}
		}
	}

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}
