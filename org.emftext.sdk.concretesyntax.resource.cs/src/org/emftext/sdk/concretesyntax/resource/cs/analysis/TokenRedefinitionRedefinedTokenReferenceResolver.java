/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenRedefinition;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.TokenReferenceResolver;

public class TokenRedefinitionRedefinedTokenReferenceResolver implements ICsReferenceResolver<TokenRedefinition, CompleteTokenDefinition> {
	
	public void resolve(String identifier, TokenRedefinition container, EReference reference, int position, boolean resolveFuzzy, final ICsReferenceResolveResult<CompleteTokenDefinition> result) {
		String tokenFormatHint = "Use syntaxName.TOKEN_NAME to refer to imported tokens.";

		String syntaxName = null;
		String tokenName = null;
		if (!resolveFuzzy) {
			if (!identifier.contains(".")) {
				result.setErrorMessage("Only tokens from imported syntax files can be redefined. " + tokenFormatHint);
				return;
			}
			String[] parts = identifier.split("\\.");
			if (parts.length != 2) {
				result.setErrorMessage(tokenFormatHint);
				return;
			}
			syntaxName = parts[0];
			tokenName = parts[1];
		}
		// find syntax
		EObject redefinitionContainer = container.eContainer();
		if (!(redefinitionContainer instanceof ConcreteSyntax)) {
			return;
		}
		ConcreteSyntax syntax = (ConcreteSyntax) redefinitionContainer;
		new TokenReferenceResolver().resolveImportedToken(syntax, syntaxName, tokenName, result,
				resolveFuzzy);
	}

	public String deResolve(CompleteTokenDefinition element, TokenRedefinition container, EReference reference) {
		ConcreteSyntax importingSyntax = (ConcreteSyntax) container.eContainer();
		ConcreteSyntax importedSyntax = (ConcreteSyntax) element.eContainer();
		EList<Import> imports = importingSyntax.getImports();
		for (Import nextImport : imports) {
			ConcreteSyntax nextImportedSyntax = nextImport.getConcreteSyntax();
			if (nextImportedSyntax == importedSyntax) {
				return nextImport.getPrefix() + "." + element.getName();
			}
		}
		return null;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// do nothing
	}
}
