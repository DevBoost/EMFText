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
package org.emftext.sdk.syntax_analysis;

import java.util.Collection;
import java.util.List;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class PlaceholderInQuotesAnalyser extends AbstractPostProcessor {

	public final static String MESSAGE_1 = "The suffix for the placeholder in quotes must not be empty.";
	public final static String MESSAGE_2 = "The prefix for the placeholder in quotes must not be empty.";

	@Override
	public void analyse(ConcreteSyntax syntax) {
		// we do not analyse all rule because imported ones can not be correctly
		// handled when this analyser is called
		List<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			Collection<PlaceholderInQuotes> placeholdersInQuotes = CsEObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes());
			for (PlaceholderInQuotes placeholder : placeholdersInQuotes) {
				checkEmpty(placeholder, placeholder.getSuffix(), CsAnalysisProblemType.PLACEHOLDER_IN_QUOTES_WITH_EMPTY_SUFFIX, MESSAGE_1);
				checkEmpty(placeholder, placeholder.getPrefix(), CsAnalysisProblemType.PLACEHOLDER_IN_QUOTES_WITH_EMPTY_PREFIX, MESSAGE_2);
			}
		}
	}

	private void checkEmpty(PlaceholderInQuotes placeholder, String value, CsAnalysisProblemType problemType, String message) {
		if (value != null && "".equals(value)) {
			addProblem(problemType, message, placeholder);
		}
	}
}
