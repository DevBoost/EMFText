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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * The StartSymbolAnalyser checks that all start symbols have syntax.
 * A start symbol (i.e., a meta class) is also considered to have
 * syntax if at least one of its subclasses has syntax.
 */
public class StartSymbolAnalyser extends AbstractPostProcessor {
	
	private final ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	@Override
	public void analyse(ConcreteSyntax syntax) {
		List<GenClass> startSymbols = syntax.getActiveStartSymbols();
		for (GenClass nextStartSymbol : startSymbols) {
			Collection<Rule> rules = csUtil.getRules(syntax, nextStartSymbol);
			if (rules.isEmpty()) {
				addProblem(CsAnalysisProblemType.START_SYMBOL_WITHOUT_SYNTAX, "Meta class " + nextStartSymbol.getName() + " has no syntax and can therefore not be used as start element.", syntax);
			}
		}
	}
}
