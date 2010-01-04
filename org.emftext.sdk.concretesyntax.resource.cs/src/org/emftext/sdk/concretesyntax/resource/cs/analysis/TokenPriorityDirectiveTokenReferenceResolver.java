/*******************************************************************************
 * Copyright (c) 2006-2010 
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
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;

public class TokenPriorityDirectiveTokenReferenceResolver implements ICsReferenceResolver<TokenPriorityDirective, TokenDefinition> {
	
	public String deResolve(TokenDefinition element, TokenPriorityDirective container, EReference reference) {
		return element.getName();
	}
	
	public void resolve(String identifier, TokenPriorityDirective container, EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<TokenDefinition> result) {
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
