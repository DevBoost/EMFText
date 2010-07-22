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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		Map<String, Set<TokenStyle>> duplicates = new LinkedHashMap<String, Set<TokenStyle>>();
		
		// search for duplicate
		List<TokenStyle> allTokenStyles = syntax.getAllTokenStyles();
		for (TokenStyle nextStyle : allTokenStyles) {
			for (String nextName : nextStyle.getTokenNames()) {
				if (tokenNames.contains(nextName)) {
					// found duplicate
					if (!duplicates.containsKey(nextName)) {
						duplicates.put(nextName, new LinkedHashSet<TokenStyle>());
					}
					duplicates.get(nextName).add(nextStyle);
				} else {
					tokenNames.add(nextName);
				}
			}
		}
		
		// add warnings
		for (String duplicateName : duplicates.keySet()) {
			for (TokenStyle tokenStyle : duplicates.get(duplicateName)) {
				addProblem(resource, ECsProblemType.DUPLICATE_TOKEN_STYLE, "Style for \"" + duplicateName + "\" is already defined (potentially in imported syntax).", tokenStyle);
			}
		}
	}
}
