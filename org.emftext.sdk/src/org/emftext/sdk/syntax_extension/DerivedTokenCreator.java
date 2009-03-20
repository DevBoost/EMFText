package org.emftext.sdk.syntax_extension;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.generators.AntlrTokenDerivator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.QuotedToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.syntax_analysis.AbstractPostProcessor;

/**
 * The DerivedTokenCreator searches for DerivedPlaceholders in the
 * syntax definition. For each placeholder that has a prefix and a
 * suffix, a new TokenDefinition is created and added to the syntax.
 */
public class DerivedTokenCreator extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		AntlrTokenDerivator tokenDerivator = new AntlrTokenDerivator();

		TreeIterator<EObject> allObjectsIterator = syntax.eAllContents();
		while (allObjectsIterator.hasNext()) {
			EObject next = allObjectsIterator.next();
			if (next instanceof PlaceholderInQuotes) {
				PlaceholderInQuotes placeholder = (PlaceholderInQuotes) next;
				boolean hasPrefix = placeholder.getNormalizedPrefix() != null;
				boolean hasSuffix = placeholder.getNormalizedSuffix() != null;
				if (hasPrefix && hasSuffix) {
					TokenDefinition definition = findToken(syntax, tokenDerivator, placeholder);
					if (definition == null) {
						definition = createNewToken(syntax, tokenDerivator, placeholder);
					}
					placeholder.setToken(definition);
				}
			}
		}
	}

	private TokenDefinition findToken(ConcreteSyntax syntax,
			AntlrTokenDerivator tokenDerivator, PlaceholderInQuotes placeholder) {
		
		for (TokenDefinition next : syntax.getAllTokens()) {
			String expression = tokenDerivator.deriveTokenExpression(placeholder);
			if (expression.equals(next.getRegex())) {
				return next;
			}
		}
		return null;
	}

	private TokenDefinition createNewToken(ConcreteSyntax syntax,
			AntlrTokenDerivator tokenDerivator, PlaceholderInQuotes placeholder) {
		// a token definition must be created
		QuotedToken newToken = ConcretesyntaxFactory.eINSTANCE.createQuotedToken();
		
		String name = tokenDerivator.deriveTokenName(placeholder);
		newToken.setName(name);
		
		String expression = tokenDerivator.deriveTokenExpression(placeholder);
		newToken.setRegex(expression);
		
		newToken.setPrefix(placeholder.getPrefix());
		newToken.setSuffix(placeholder.getSuffix());
		
		syntax.getSyntheticTokens().add(newToken);
		return newToken;
	}
}
