package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class TokenPriorityDirectiveTokenReferenceResolver extends AbstractReferenceResolver<TokenPriorityDirective, TokenDefinition> {
	
	@Override	
	protected java.lang.String doDeResolve(TokenDefinition element, TokenPriorityDirective container, EReference reference) {
		return super.doDeResolve(element, container, reference);
	}
	
	@Override	
	protected void doResolve(String identifier, TokenPriorityDirective container, EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<TokenDefinition> result) {
		System.out.println("TokenPriorityDirectiveTokenReferenceResolver.doResolve(" + identifier + ")");
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
}
