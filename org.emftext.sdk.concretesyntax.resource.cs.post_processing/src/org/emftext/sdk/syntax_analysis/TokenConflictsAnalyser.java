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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime3_2_0.RecognitionException;
import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.regex.RegexpTranslationHelper;
import org.emftext.sdk.regex.SorterException;
import org.emftext.sdk.regex.TokenSorter;
import org.emftext.sdk.util.StringUtil;

public class TokenConflictsAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		TokenSorter ts = new TokenSorter();
		Map<TokenDefinition, Set<TokenDefinition>> conflicting = Collections.emptyMap();
		EList<TokenDefinition> allTokenDefinitions = syntax.getActiveTokens();

		List<TokenDefinition> unreachable = Collections.emptyList();
		try {
			conflicting = ts.getConflicting(allTokenDefinitions);
			List<TokenDefinition> directivesMatchingEmptyString = getDirectivesMatchingEmptyString(allTokenDefinitions);
			for (TokenDefinition tokenDirective : directivesMatchingEmptyString) {
				addProblem(resource, ECsProblemType.TOKEN_MATCHES_EMPTY_STRING,
						"The token definition '" + tokenDirective.getRegex()
								+ "' matches the empty string.", tokenDirective);
			}
			unreachable = ts.getNonReachables(allTokenDefinitions);
		} catch (Exception e) {
			addProblem(resource, ECsProblemType.TOKEN_UNREACHABLE,
					"Error during token conflict analysis. " + e.getMessage(),
					syntax);
		}
		for (TokenDefinition tokenDirective : unreachable) {
			conflicting.remove(tokenDirective);

			addProblem(resource, ECsProblemType.TOKEN_UNREACHABLE,
					"The token definition '" + tokenDirective.getRegex()
							+ "' is not reachable", tokenDirective);

		}
		for (TokenDefinition tokenDirective : conflicting.keySet()) {
			Set<TokenDefinition> previousDefinitions = conflicting.get(tokenDirective);
			Set<String> nameSet = new HashSet<String>();
			for (TokenDefinition nextDefinition : previousDefinitions) {
				nameSet.add(nextDefinition.getName());
			}
			String names = StringUtil.explode(nameSet, ", ");
			addProblem(resource, ECsProblemType.TOKEN_OVERLAPPING,
					"The token definition " + tokenDirective.getName()
							+ " overlaps with previous token definition(s) (" + names + ").",
					tokenDirective);
		}
	}

	private List<TokenDefinition> getDirectivesMatchingEmptyString(
			EList<TokenDefinition> allTokenDirectives) throws SorterException,
			IOException, RecognitionException {
		List<TokenDefinition> emptyMatchers = new ArrayList<TokenDefinition>();
		for (TokenDefinition def : allTokenDirectives) {

			String regex = RegexpTranslationHelper
					.translateAntLRToJavaStyle(def.getRegex());
			if ("".matches(regex)) {
				emptyMatchers.add(def);
			}
		}
		return emptyMatchers;
	}

}
