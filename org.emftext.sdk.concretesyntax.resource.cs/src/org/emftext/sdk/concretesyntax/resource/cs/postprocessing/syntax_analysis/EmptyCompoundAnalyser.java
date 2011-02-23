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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.quickfixes.RemoveElementQuickFix;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * The EmptyCompoundAnalyser searches for compounds with an unlimited
 * upper bound (tagged with STAR or PLUS), which can potentially be
 * empty. A compound can be empty if it does not contain at least one
 * mandatory syntax element. Such (potentially empty) compounds cause 
 * ANTLR to parse forever, which is why the EmptyCompoundAnalyser emits 
 * an error if such a compound is found.
 * 
 * This analyzer was created as a response to bug 1183.
 */
public class EmptyCompoundAnalyser extends AbstractPostProcessor {

	private static final String EMPTY_COMPOUND_MESSAGE = "Compounds with * or + must not allow empty syntax.";
	
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();

	@Override
	public void analyse(ConcreteSyntax syntax) {
		EList<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			EList<SyntaxElement> children = rule.getChildren();
			checkCompounds(children);
		}
	}

	private void checkCompounds(EList<SyntaxElement> children) {
		for (SyntaxElement syntaxElement : children) {
			if (syntaxElement instanceof CompoundDefinition) {
				CompoundDefinition compound = (CompoundDefinition) syntaxElement;
				if (compound.getCardinality() == Cardinality.PLUS ||
					compound.getCardinality() == Cardinality.STAR) {
					// check whether the compound allows the empty sentence
					if (csUtil.canBeEmpty(compound.getDefinition(), true)) {
						addProblem(CsAnalysisProblemType.EMPTY_COMPOUND, EMPTY_COMPOUND_MESSAGE, compound, new RemoveElementQuickFix("Remove compound", compound));
					}
				}
			}
			checkCompounds(syntaxElement.getChildren());
		}
	}
}
