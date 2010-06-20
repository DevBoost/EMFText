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
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime3_2_0.RecognitionException;
import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.regex.RegexpTranslationHelper;
import org.emftext.sdk.regex.SorterException;
import org.emftext.sdk.regex.TokenSorter;
import org.emftext.sdk.util.StringUtil;
import org.emftext.sdk.util.ToStringConverter;

public class TokenConflictsAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		TokenSorter ts = new TokenSorter();
		Map<CompleteTokenDefinition, Set<CompleteTokenDefinition>> conflicting = Collections.emptyMap();
		EList<CompleteTokenDefinition> allTokenDefinitions = syntax.getActiveTokens();

		Map<CompleteTokenDefinition, Collection<CompleteTokenDefinition>> unreachable = Collections.emptyMap();
		try {
			conflicting = ts.getConflicting(allTokenDefinitions);
			List<CompleteTokenDefinition> directivesMatchingEmptyString = getDirectivesMatchingEmptyString(allTokenDefinitions);
			for (CompleteTokenDefinition tokenDirective : directivesMatchingEmptyString) {
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
		for (CompleteTokenDefinition tokenDirective : unreachable.keySet()) {
			conflicting.remove(tokenDirective);

			String conflictingTokens = StringUtil.explode(unreachable.get(tokenDirective), ", ", new ToStringConverter<CompleteTokenDefinition>() {

				public String toString(CompleteTokenDefinition definition) {
					return definition.getName();
				}
				
			});
			addProblem(resource, ECsProblemType.TOKEN_UNREACHABLE,
					"The token definition '" + tokenDirective.getRegex()
							+ "' is not reachable because of previous tokens " + conflictingTokens, tokenDirective);

		}
		for (CompleteTokenDefinition tokenDirective : conflicting.keySet()) {
			Set<CompleteTokenDefinition> previousDefinitions = conflicting.get(tokenDirective);
			Set<String> nameSet = new HashSet<String>();
			for (CompleteTokenDefinition nextDefinition : previousDefinitions) {
				nameSet.add(nextDefinition.getName());
			}
			String names = StringUtil.explode(nameSet, ", ");
			addProblem(resource, ECsProblemType.TOKEN_OVERLAPPING,
					"The token definition " + tokenDirective.getName()
							+ " overlaps with previous token definition(s) (" + names + ").",
					tokenDirective);
		}
	}

	private List<CompleteTokenDefinition> getDirectivesMatchingEmptyString(
			EList<CompleteTokenDefinition> allTokenDirectives) throws SorterException,
			IOException, RecognitionException {
		List<CompleteTokenDefinition> emptyMatchers = new ArrayList<CompleteTokenDefinition>();
		for (CompleteTokenDefinition def : allTokenDirectives) {

			String regex = RegexpTranslationHelper
					.translateAntLRToJavaStyle(def.getRegex());
			if ("".matches(regex)) {
				emptyMatchers.add(def);
			}
		}
		return emptyMatchers;
	}

}
