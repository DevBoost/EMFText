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

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that looks for explicit choices in the syntax
 * definition. Such choices are not reflected in the models
 * after parsing and can thus cause a result different from
 * the original text after printing.
 */
public class ChoiceAnalyser extends AbstractPostProcessor {

	private static final String EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS = 
		"Explicit syntax choices are not reflected in model instances and may thus cause problem when printing models.";

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		Iterator<EObject> iterator = syntax.eAllContents();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Choice) {
				Choice choice = (Choice) next;
				if (choice.getChildren().size() > 1) {
					addProblem(
							resource,
							ECsProblemType.EXPLICIT_SYNTAX_CHOICE,
							EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS,
							choice);
				}
			}
		}
	}

}
