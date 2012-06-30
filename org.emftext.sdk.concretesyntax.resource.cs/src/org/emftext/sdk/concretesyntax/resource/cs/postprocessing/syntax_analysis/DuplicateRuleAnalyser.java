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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;

/**
 * An analyser that checks that there is not more than one rule per meta class.
 */
public class DuplicateRuleAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		GenClassCache genClassCache = syntax.getGenClassCache();

		final EList<Rule> allRules = syntax.getAllRules();
		for (int i = 0; i < allRules.size(); i++) {
			Rule rule_i = allRules.get(i);
			GenClass genClass_i = rule_i.getMetaclass();
			if (genClass_i == null || genClass_i.eIsProxy()) {
				continue;
			}
			final String name_i = genClassCache.getQualifiedInterfaceName(genClass_i);
			if (name_i == null) {
				continue;
			}
			
			List<Rule> duplicates = new ArrayList<Rule>();
			for (int j = i + 1; j < allRules.size(); j++) {
				Rule rule_j = allRules.get(j);
				GenClass genClass_j = rule_j.getMetaclass();
				if (genClass_j == null) {
					continue;
				}
				final String name_j = genClassCache.getQualifiedInterfaceName(genClass_j);
				if (name_i.equals(name_j)) {
					duplicates.add(rule_j);
				}
			}
			if (duplicates.size() > 0) {
				final String message = "Found duplicate rule for meta class \"" + genClass_i.getName() + "\" (may be imported).";
				addProblem(CsAnalysisProblemType.DUPLICATE_RULE, message, rule_i);
				for (Rule duplicate : duplicates) {
					addProblem(CsAnalysisProblemType.DUPLICATE_RULE, message, duplicate);
				}
			}
		}
	}
}
