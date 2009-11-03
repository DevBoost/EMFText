/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class PlaceholderTokenReferenceResolver implements ICsReferenceResolver<Placeholder, TokenDefinition> {

	public void resolve(String identifier, Placeholder container,
			EReference reference, int position, boolean resolveFuzzy,
			ICsReferenceResolveResult<TokenDefinition> result) {
		// first look in imported syntaxes for the token
		boolean continueSearch = searchForTokenInImportedSyntaxes(identifier, container, resolveFuzzy,
				result);
		if (!continueSearch) {
			return;
		}
		// then look in the resource itself
		EObject root = CsEObjectUtil.findRootContainer(container);
		if (!(root instanceof ConcreteSyntax)) {
			return;
		}
		ConcreteSyntax syntax = (ConcreteSyntax) root;
		searchForToken(identifier, resolveFuzzy, result, syntax);
	}

	public String deResolve(TokenDefinition element, Placeholder container,
			EReference reference) {
		return element.getName();
	}

	private boolean searchForTokenInImportedSyntaxes(String identifier,
			Placeholder container, boolean resolveFuzzy, ICsReferenceResolveResult<TokenDefinition> result) {
		EObject root = CsEObjectUtil.findRootContainer(container);
		if (!(root instanceof ConcreteSyntax)) {
			return false;
		}
		ConcreteSyntax syntax = (ConcreteSyntax) root;
		for (Import nextImport : syntax.getImports()) {
			ConcreteSyntax nextImportedSyntax = nextImport.getConcreteSyntax();
			if (nextImportedSyntax == null) {
				continue;
			}
			boolean continueSearch = searchForToken(identifier, resolveFuzzy, result, nextImportedSyntax);
			if (!continueSearch) {
				return false;
			}
		}
		return true;
	}

	private boolean searchForToken(String identifier, boolean resolveFuzzy,
			ICsReferenceResolveResult<TokenDefinition> result,
			ConcreteSyntax nextImportedSyntax) {
		for (TokenDefinition tokenDefinition : nextImportedSyntax.getActiveTokens()) {
			final String tokenName = tokenDefinition.getName();
			if (tokenName.equals(identifier) && !resolveFuzzy) {
				result.addMapping(identifier, tokenDefinition);
				return false;
			}
			if (tokenName.startsWith(identifier) && resolveFuzzy) {
				result.addMapping(tokenName, tokenDefinition);
			}
		}
		return true;
	}

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}
