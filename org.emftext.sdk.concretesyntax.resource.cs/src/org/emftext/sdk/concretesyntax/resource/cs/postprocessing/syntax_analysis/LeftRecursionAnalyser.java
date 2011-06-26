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

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.LeftRecursionDetector;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * An analyser that checks whether the syntax contains left-recursive rules.
 */
public class LeftRecursionAnalyser extends AbstractPostProcessor {
	
	private static final String RULE_IS_LEFT_RECURSIVE_IN_RELATION_TO = "The rule is left recursive in relation to rule: ";

	@Override
	public void analyse(ConcreteSyntax syntax) {
		GenClassFinder genClassFinder = new GenClassFinder();
		Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(syntax, true, true);
		Map<String, Collection<String>> genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses, syntax.getGenClassCache());
		LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, syntax);
		
		for (Rule rule : syntax.getAllRules()) {
			Rule recursionRule = lrd.findLeftRecursion(rule);
			if (recursionRule != null) {
				// TODO this is not correct. there are still cases where left recursion can be
				// caused by operator rules, but the analysis that is required to detect these
				// is complex. since we exclude all warnings here, we may end up with too few
				// warnings, while we get too many if do not exclude them. the only way to
				// solve this is to implement the aforementioned analysis.
				if (recursionRule.getOperatorAnnotation() != null) {
					continue;
				}
				String message = RULE_IS_LEFT_RECURSIVE_IN_RELATION_TO + recursionRule.getMetaclass().getName();
				addProblem(
					CsAnalysisProblemType.LEFT_RECURSIVE_RULE, 
					message,
					rule
				);
			}
		}
	}
}
