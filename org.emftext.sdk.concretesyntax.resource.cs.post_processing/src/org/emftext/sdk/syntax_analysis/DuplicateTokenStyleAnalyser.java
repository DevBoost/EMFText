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
package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.List;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that checks whether multiple token styles refer to the
 * same token. If duplicate definitions are found a warning is added to
 * the CS resource.
 */
public class DuplicateTokenStyleAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		List<String> tokenNames = new ArrayList<String>();
		List<TokenStyle> duplicates = new ArrayList<TokenStyle>();
		
		// search for duplicate
		List<TokenStyle> allTokenStyles = syntax.getAllTokenStyles();
		for (TokenStyle nextStyle : allTokenStyles) {
			String nextName = nextStyle.getTokenName();
			if (tokenNames.contains(nextName)) {
				// found duplicate
				duplicates.add(nextStyle);
			} else {
				tokenNames.add(nextName);
			}
		}
		
		// add warnings
		for (TokenStyle nextDuplicate : duplicates) {
			addProblem(resource, ECsProblemType.DUPLICATE_TOKEN_STYLE, "Style for \"" + nextDuplicate.getTokenName() + "\" is already defined (potentially in imported syntax).", nextDuplicate);
		}
	}
}
