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
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenRedefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;

/**
 * A analyser that checks that all token names start with a capital letter
 * and that they do not contain dashes. This is required by ANTLR.
 */
public class TokenNameAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		List<CompleteTokenDefinition> wrongDefinitions = getTokenDefinitionsWithInvalidCapitalization(syntax);
		for (CompleteTokenDefinition next : wrongDefinitions) {
			addProblem(CsAnalysisProblemType.INVALID_TOKEN_NAME, "Token names must start with a capital letter.", next);
		}

		wrongDefinitions = getTokenDefinitionsWithDashes(syntax);
		for (CompleteTokenDefinition next : wrongDefinitions) {
			addProblem(CsAnalysisProblemType.INVALID_TOKEN_NAME, "Token names must not contain dashes.", next);
		}
	}

	private List<CompleteTokenDefinition> getTokenDefinitionsWithInvalidCapitalization(ConcreteSyntax syntax) {
		List<CompleteTokenDefinition> result = new ArrayList<CompleteTokenDefinition>();
		for (CompleteTokenDefinition definition : syntax.getActiveTokens()) {
			if (definition instanceof TokenRedefinition) {
				continue;
			}
			char firstLetter = definition.getName().charAt(0);
			if (!(firstLetter >= 'A' && firstLetter <= 'Z')) {
				result.add(definition);
			}
		}
		return result;
	}

	private List<CompleteTokenDefinition> getTokenDefinitionsWithDashes(ConcreteSyntax syntax) {
		List<CompleteTokenDefinition> result = new ArrayList<CompleteTokenDefinition>();
		for (CompleteTokenDefinition definition : syntax.getActiveTokens()) {
			String name = definition.getName();
			if (name != null && name.contains("-")) {
				result.add(definition);
			}
		}
		return result;
	}
}
