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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.emftext.runtime.util.EClassUtil;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.ECsProblemType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.CsResource;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * An analyser that checks whether there is a syntax rule for
 * each meta class.
 */
public class MissingRulesAnalyser extends AbstractPostProcessor {

	private static final String NO_RULE_FOR_META_CLASS = "There is no rule for concrete meta class: ";
	private static final EClassUtil eClassUtil = new EClassUtil();

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		GenClassFinder genClassFinder = new GenClassFinder();
		Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(syntax, false, false);
		EList<Rule> allRules = syntax.getAllRules();
		// this set ensures that we do not add warnings for a missing rule twice
		Set<String> namesOfCompletedGenClasses = new LinkedHashSet<String>();
		
		for (GenClass genClass : allGenClasses) {
			EClass ecoreClass = genClass.getEcoreClass();
			if (ecoreClass == null) {
				continue;
			}
			if (eClassUtil.isNotConcrete(ecoreClass)) {
				continue;
			}
			String qualifiedName = genClassFinder.getQualifiedInterfaceName(genClass);
			if (namesOfCompletedGenClasses.contains(qualifiedName)) {
				continue;
			}
			namesOfCompletedGenClasses.add(qualifiedName);
			boolean foundRuleForClass = false;
			for (Rule rule : allRules) {
				GenClass ruleClass = rule.getMetaclass();
				if (ruleClass != null && !ruleClass.eIsProxy() && genClassFinder.getQualifiedInterfaceName(ruleClass).equals(qualifiedName)) {
					foundRuleForClass = true;
					break;
				}
			}
			if (!foundRuleForClass) {
				addProblem(resource, ECsProblemType.NO_RULE_FOR_META_CLASS, NO_RULE_FOR_META_CLASS + genClass.getName(), 0, 0, 0, 1);
			}
		}
	}
}
