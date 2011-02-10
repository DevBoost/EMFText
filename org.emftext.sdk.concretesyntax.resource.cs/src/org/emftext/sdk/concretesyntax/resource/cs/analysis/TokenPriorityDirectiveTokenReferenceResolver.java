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
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.TokenReferenceResolver;

public class TokenPriorityDirectiveTokenReferenceResolver implements ICsReferenceResolver<TokenPriorityDirective, CompleteTokenDefinition> {
	
	public String deResolve(CompleteTokenDefinition element, TokenPriorityDirective container, EReference reference) {
		return element.getName();
	}
	
	public void resolve(String identifier, TokenPriorityDirective container, EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<CompleteTokenDefinition> result) {
		ConcreteSyntax syntax = (ConcreteSyntax) container.eContainer();
		List<TokenDirective> tokens = syntax.getAllTokenDirectives();
		for (TokenDirective tokenDirective : tokens) {
			if (tokenDirective instanceof CompleteTokenDefinition) {
				CompleteTokenDefinition token = (CompleteTokenDefinition) tokenDirective;
				String tokenName = token.getName();
				if (resolveFuzzy || tokenName.equals(identifier)) {
					result.addMapping(tokenName, token);
					if (!resolveFuzzy) {
						return;
					}
				}
			}
		}
		if (identifier.contains(".")) {
			String[] parts = identifier.split("\\.");
			if (parts.length != 2) {
				return;
			}
			String syntaxName = parts[0];
			String tokenName = parts[1];
			new TokenReferenceResolver().resolveImportedToken(syntax, syntaxName, tokenName, result,
					resolveFuzzy);
		}
	}

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}
