/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_extension;

import java.util.Collection;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.AntlrTokenDerivator;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.QuotedTokenDefinition;
import org.emftext.sdk.util.EObjectUtil;

/**
 * The DerivedTokenCreator searches for quoted placeholders in the
 * syntax definition. For each placeholder that has a prefix and a
 * suffix, a new TokenDefinition is created and added to the list of
 * synthetic tokens of the syntax.
 */
public class DerivedTokenCreator extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		AntlrTokenDerivator tokenDerivator = new AntlrTokenDerivator();

		Collection<PlaceholderInQuotes> quotedPlaceholders = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes());
		for (PlaceholderInQuotes placeholder : quotedPlaceholders) {
			boolean hasPrefix = placeholder.getNormalizedPrefix() != null;
			boolean hasSuffix = placeholder.getNormalizedSuffix() != null;
			if (hasPrefix && hasSuffix) {
				CompleteTokenDefinition definition = findToken(syntax, tokenDerivator, placeholder);
				if (definition == null) {
					definition = createNewToken(syntax, tokenDerivator, placeholder);
				}
				placeholder.setToken(definition);
			}
		}
	}

	/**
	 * Searches in the list of the synthetic tokens of the given syntax for
	 * a token definition that has the same regular expression as the given
	 * quoted placeholder.
	 * 
	 * @param syntax the syntax to search in
	 * @param tokenDerivator a helper class that can derive regular expressions for quoted tokens
	 * @param placeholder
	 * 
	 * @return a token with the same regular expression or null if no token is found
	 */
	private CompleteTokenDefinition findToken(
			ConcreteSyntax syntax,
			AntlrTokenDerivator tokenDerivator, 
			PlaceholderInQuotes placeholder) {
		
		String tokenExpression = tokenDerivator.deriveTokenExpression(placeholder);
		for (CompleteTokenDefinition token : syntax.getSyntheticTokens()) {
			String expression = tokenExpression;
			if (expression.equals(token.getRegex())) {
				return token;
			}
		}
		return null;
	}

	/**
	 * Creates a new token definition for the quoted placeholder and adds it
	 * to the list of synthetic tokens of the given syntax specification.
	 * 
	 * @param syntax
	 * @param tokenDerivator
	 * @param placeholder
	 * @return
	 */
	private CompleteTokenDefinition createNewToken(
			ConcreteSyntax syntax,
			AntlrTokenDerivator tokenDerivator, 
			PlaceholderInQuotes placeholder) {
		// a token definition must be created
		QuotedTokenDefinition newToken = ConcretesyntaxFactory.eINSTANCE.createQuotedTokenDefinition();
		
		String name = tokenDerivator.deriveTokenName(placeholder);
		newToken.setName(name);
		
		String expression = tokenDerivator.deriveTokenExpression(placeholder);
		newToken.setSynthesizedRegex(expression);
		
		newToken.setPrefix(placeholder.getNormalizedPrefix());
		newToken.setSuffix(placeholder.getNormalizedSuffix());
		newToken.setEscapeCharacter(placeholder.getNormalizedEscapeCharacter());
		
		syntax.getSyntheticTokens().add(newToken);
		return newToken;
	}

	protected boolean doResolveProxiesBeforeAnalysis() {
		return false;
	}
}
