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
package org.emftext.language.customsandwich.resource.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.customsandwich.resource.customsandwich.CustomsandwichEProblemSeverity;
import org.emftext.language.customsandwich.resource.customsandwich.CustomsandwichEProblemType;
import org.emftext.language.customsandwich.resource.customsandwich.ICustomsandwichOptionProvider;
import org.emftext.language.customsandwich.resource.customsandwich.ICustomsandwichOptions;
import org.emftext.language.customsandwich.resource.customsandwich.ICustomsandwichResourcePostProcessor;
import org.emftext.language.customsandwich.resource.customsandwich.ICustomsandwichResourcePostProcessorProvider;
import org.emftext.language.customsandwich.resource.customsandwich.mopp.CustomsandwichProblem;
import org.emftext.language.customsandwich.resource.customsandwich.mopp.CustomsandwichResource;
import org.emftext.language.templateconcepts.ExpressionChecker;

/**
 * Post processor that performs
 * <i>cast repair</i>,
 * <i>expression simplification</i> and
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class CustomsandwichPostProcessor implements ICustomsandwichOptionProvider, ICustomsandwichResourcePostProcessor, ICustomsandwichResourcePostProcessorProvider {

	private ExpressionChecker expressionChecker = new ExpressionChecker();

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ICustomsandwichOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(final CustomsandwichResource resource) {
		expressionChecker.process(resource, new ExpressionChecker.ErrorReporter() {

			public void report(EObject element, String message) {
				resource.addProblem(new CustomsandwichProblem(message, CustomsandwichEProblemType.ANALYSIS_PROBLEM, CustomsandwichEProblemSeverity.ERROR), element);
			}
		});
	}

	public ICustomsandwichResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void terminate() {
		// do nothing
	}
}
