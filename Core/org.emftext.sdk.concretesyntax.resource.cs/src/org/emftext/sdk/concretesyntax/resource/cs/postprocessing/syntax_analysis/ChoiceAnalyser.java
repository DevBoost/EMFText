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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * An analyser that looks for explicit choices in the syntax
 * definition. Such choices are not reflected in the models
 * after parsing and can thus cause a result different from
 * the original text after printing.
 */
public class ChoiceAnalyser extends AbstractPostProcessor {

	private static final String EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS = 
		"Explicit syntax choices are not reflected in model instances and may thus cause problems when printing models.";

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Iterator<EObject> iterator = syntax.eAllContents();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Choice) {
				Choice choice = (Choice) next;
				if (getChildCount(choice) > 1) {
					addProblem(
							CsAnalysisProblemType.EXPLICIT_SYNTAX_CHOICE,
							EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS,
							choice);
				}
			}
		}
	}

	private int getChildCount(Choice choice) {
		int childrenWithTerminals = 0;
		List<SyntaxElement> children = choice.getChildren();
		for (SyntaxElement child : children) {
			TreeIterator<EObject> eAllContents = child.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = (EObject) eAllContents.next();
				if (next instanceof CsString) {
					childrenWithTerminals++;
					break;
				} else if (next instanceof Terminal) {
					Terminal terminal = (Terminal) next;
					if (terminal.getFeature() == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
						continue;
					}
					childrenWithTerminals++;
					break;
				} else if (next instanceof Containment) {
					childrenWithTerminals++;
					break;
				}
			}
		}
		return childrenWithTerminals;
	}

}
