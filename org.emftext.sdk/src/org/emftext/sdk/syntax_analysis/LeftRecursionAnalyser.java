/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_analysis;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * An analyser that checks whether the syntax contains left-recursive rules.
 */
public class LeftRecursionAnalyser extends AbstractPostProcessor {
	
	private static final String RULE_IS_LEFT_RECURSIVE_IN_RELATION_TO = "The rule is left recursive in relation to rule: ";

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		// stop if errors have been detected by previous analysis 
		if (!resource.getErrors().isEmpty()) {
			return;
		}
		
		GenClassFinder genClassFinder = new GenClassFinder();
		Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(syntax, true, true);
		Map<String, Collection<String>> genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);
		LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, syntax);
		
		EList<Rule> allRules = syntax.getAllRules();
		
		for (Rule rule : allRules) {
			Rule recursionRule = lrd.findLeftRecursion(rule);
			if (recursionRule != null) {
				addProblem(resource, ECsProblemType.LEFT_RECURSIVE_RULE, RULE_IS_LEFT_RECURSIVE_IN_RELATION_TO + recursionRule.getMetaclass().getName(), rule);
			}
		}
	}
}
