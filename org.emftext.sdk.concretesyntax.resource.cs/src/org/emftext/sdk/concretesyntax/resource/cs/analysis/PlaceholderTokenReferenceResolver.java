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
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class PlaceholderTokenReferenceResolver extends AbstractReferenceResolver<Placeholder, TokenDefinition> {

	public void resolve(String identifier, Placeholder container,
			EReference reference, int position, boolean resolveFuzzy,
			IReferenceResolveResult<TokenDefinition> result) {
		// first look in imported syntaxes for the token
		boolean continueSearch = searchForTokenInImportedSyntaxes(identifier, container, resolveFuzzy,
				result);
		if (!continueSearch) {
			return;
		}
		// then look in the resource itself
		EObject root = EObjectUtil.findRootContainer(container);
		if (!(root instanceof ConcreteSyntax)) {
			return;
		}
		ConcreteSyntax syntax = (ConcreteSyntax) root;
		searchForToken(identifier, resolveFuzzy, result, syntax);
	}

	public String deResolve(TokenDefinition element, Placeholder container,
			EReference reference) {
		// TODO jjohannes: implement this method
		return null;
	}

	private boolean searchForTokenInImportedSyntaxes(String identifier,
			Placeholder container, boolean resolveFuzzy, IReferenceResolveResult<TokenDefinition> result) {
		EObject root = EObjectUtil.findRootContainer(container);
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
			IReferenceResolveResult<TokenDefinition> result,
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
