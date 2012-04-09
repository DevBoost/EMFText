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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime3_4_0.RecognitionException;
import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.regex.SorterException;
import org.emftext.sdk.util.StringUtil;
import org.emftext.sdk.util.ToStringConverter;

import dk.brics.automaton.Automaton;

public class TokenConflictsAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Map<CompleteTokenDefinition, Set<CompleteTokenDefinition>> conflicting = Collections.emptyMap();
		EList<CompleteTokenDefinition> allTokenDefinitions = syntax.getActiveTokens();
		
		Map<CompleteTokenDefinition, Collection<CompleteTokenDefinition>> unreachable = Collections.emptyMap();
		try {
			conflicting = tokenSorter.getConflicting(allTokenDefinitions);
			List<CompleteTokenDefinition> directivesMatchingEmptyString = getDirectivesMatchingEmptyString(allTokenDefinitions);
			for (CompleteTokenDefinition tokenDirective : directivesMatchingEmptyString) {
				addTokenProblem(CsAnalysisProblemType.TOKEN_MATCHES_EMPTY_STRING,
						"The token definition '" + tokenDirective.getRegex()
								+ "' matches the empty string.", syntax, tokenDirective);
			}
			unreachable = tokenSorter.getNonReachables(allTokenDefinitions);
		} catch (Exception e) {
			addProblem(CsAnalysisProblemType.TOKEN_UNREACHABLE,
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
			addTokenProblem(CsAnalysisProblemType.TOKEN_UNREACHABLE,
					"The token definition '" + tokenDirective.getRegex()
							+ "' is not reachable because of previous tokens " + conflictingTokens, syntax, tokenDirective);

		}
		for (CompleteTokenDefinition tokenDirective : conflicting.keySet()) {
			Set<CompleteTokenDefinition> previousDefinitions = conflicting.get(tokenDirective);
			Set<String> nameSet = new HashSet<String>();
			for (CompleteTokenDefinition nextDefinition : previousDefinitions) {
				nameSet.add(nextDefinition.getName());
			}
			String names = StringUtil.explode(nameSet, ", ");
			addTokenProblem(CsAnalysisProblemType.TOKEN_OVERLAPPING,
					"The token definition " + tokenDirective.getName()
							+ " overlaps with previous token definition(s) (" + names + ").",
					syntax,
					tokenDirective);
		}
	}

	private List<CompleteTokenDefinition> getDirectivesMatchingEmptyString(
			List<CompleteTokenDefinition> definitions) throws SorterException,
			IOException, RecognitionException {
		List<CompleteTokenDefinition> emptyMatchers = new ArrayList<CompleteTokenDefinition>();
		for (CompleteTokenDefinition definition : definitions) {
			Automaton automaton = tokenSorter.getAutomaton(definition.getRegex());
			boolean matchesEmptyString = automaton.run("");
			if (matchesEmptyString) {
				emptyMatchers.add(definition);
			}
		}
		return emptyMatchers;
	}

}
