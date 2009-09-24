/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_extension;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.AntlrTokenDerivator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.QuotedToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
/**
 * The DerivedTokenCreator searches for DerivedPlaceholders in the
 * syntax definition. For each placeholder that has a prefix and a
 * suffix, a new TokenDefinition is created and added to the syntax.
 */
public class DerivedTokenCreator extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
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
		
		for (TokenDirective next : syntax.getSyntheticTokens()) {
			String expression = tokenDerivator.deriveTokenExpression(placeholder);
			if (next instanceof TokenDefinition) {
				TokenDefinition token = (TokenDefinition) next;
				if (expression.equals(token.getRegex())) {
					return token;
				}
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
