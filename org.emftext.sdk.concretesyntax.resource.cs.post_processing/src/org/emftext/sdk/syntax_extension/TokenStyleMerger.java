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
package org.emftext.sdk.syntax_extension;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;

/**
 * The TokenStyleMerger reads all token styles from imported syntaxes and
 * merges them with the styles defined in the current syntax. If a token
 * styles exists both in an imported and in the current syntax the one from
 * the current syntax overrides the imported one.
 */
public class TokenStyleMerger extends AbstractTokenStylePostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		EList<TokenStyle> allStyles = syntax.getAllTokenStyles();
		allStyles.addAll(syntax.getTokenStyles());
		
		// add the imported token styles
		EList<Import> imports = syntax.getImports();
		for (Import importedElement : imports) {
			ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();
			if (importedSyntax != null) {
				EList<TokenStyle> importedStyles = importedSyntax.getAllTokenStyles();
				for (TokenStyle importedStyle : importedStyles) {
					addStyle(allStyles, importedStyle);
				}
			}
		}
	}
}
