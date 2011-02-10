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

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class PlaceholderTokenReferenceResolver implements ICsReferenceResolver<Placeholder, ReferencableTokenDefinition> {

	public void resolve(String identifier, Placeholder container,
			EReference reference, int position, boolean resolveFuzzy,
			ICsReferenceResolveResult<ReferencableTokenDefinition> result) {
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

	public String deResolve(ReferencableTokenDefinition element, Placeholder container,
			EReference reference) {
		return element.getName();
	}

	private boolean searchForTokenInImportedSyntaxes(String identifier,
			Placeholder container, boolean resolveFuzzy, ICsReferenceResolveResult<ReferencableTokenDefinition> result) {
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
			ICsReferenceResolveResult<ReferencableTokenDefinition> result,
			ConcreteSyntax syntax) {
		EList<? extends TokenDirective> tokens = syntax.getActiveTokens();
		// for fuzzy resolution we must use getTokens(), because getActiveTokens()
		// is initialized in a post processor, which does not run in fuzzy resolving
		// mode. As a result the predefined tokens are not available during code
		// completion. Probably it would be better to implement getActiveTokens()
		// in eJava rather than using a post processor.
		if (resolveFuzzy) {
			tokens = syntax.getTokens();
		} else {
			tokens = syntax.getActiveTokens();
		}
		for (TokenDirective token : tokens) {
			if (token instanceof CompleteTokenDefinition) {
				CompleteTokenDefinition tokenDefinition = (CompleteTokenDefinition) token;
				final String tokenName = tokenDefinition.getName();
				if (tokenName.equals(identifier) && !resolveFuzzy) {
					result.addMapping(identifier, tokenDefinition);
					return false;
				}
				if (resolveFuzzy) {
					result.addMapping(tokenName, tokenDefinition);
				}
			}
		}
		return true;
	}

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}
