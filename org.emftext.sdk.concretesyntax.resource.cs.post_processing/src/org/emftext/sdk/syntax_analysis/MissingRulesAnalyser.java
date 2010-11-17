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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEClassUtil;
import org.emftext.sdk.finders.GenClassFinder;
import org.emftext.sdk.quickfixes.AddSuppressWarningsAnnotationQuickFix;

/**
 * An analyser that checks whether there is a syntax rule for
 * each concrete meta class.
 */
public class MissingRulesAnalyser extends AbstractPostProcessor {

	private static final String NO_RULE_FOR_META_CLASS = "There is no rule for concrete meta class: ";
	private static final CsEClassUtil eClassUtil = new CsEClassUtil();

	@Override
	public void analyse(ConcreteSyntax syntax) {
		GenClassCache genClassCache = syntax.getGenClassCache();
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
			String qualifiedName = genClassCache.getQualifiedInterfaceName(genClass);
			if (namesOfCompletedGenClasses.contains(qualifiedName)) {
				continue;
			}
			namesOfCompletedGenClasses.add(qualifiedName);
			boolean foundRuleForClass = false;
			for (Rule rule : allRules) {
				GenClass ruleClass = rule.getMetaclass();
				if (ruleClass != null && !ruleClass.eIsProxy() && genClassCache.getQualifiedInterfaceName(ruleClass).equals(qualifiedName)) {
					foundRuleForClass = true;
					break;
				}
			}
			if (!foundRuleForClass) {
				CsAnalysisProblemType problemType = CsAnalysisProblemType.NO_RULE_FOR_META_CLASS;
				addProblem(problemType, NO_RULE_FOR_META_CLASS + genClass.getName(), 0, 0, 0, 1, new AddSuppressWarningsAnnotationQuickFix(syntax, problemType));
			}
		}
	}
}
