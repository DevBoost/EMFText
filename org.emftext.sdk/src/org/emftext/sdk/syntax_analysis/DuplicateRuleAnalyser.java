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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;

/**
 * An analyser that checks that there is not more than one rule
 * per meta class.
 */
public class DuplicateRuleAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {

		final EList<Rule> allRules = syntax.getAllRules();
		for (int i = 0; i < allRules.size(); i++) {
			Rule rule_i = allRules.get(i);
			GenClass genClass_i = rule_i.getMetaclass();
			if (genClass_i == null || genClass_i.eIsProxy()) {
				continue;
			}
			final String name_i = genClass_i.getQualifiedInterfaceName();
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
				final String name_j = genClass_j.getQualifiedInterfaceName();
				if (name_i.equals(name_j)) {
					duplicates.add(rule_j);
				}
			}
			if (duplicates.size() > 0) {
				final String message = "Found duplicate rule for meta class \"" + genClass_i.getName() + "\" (may be imported).";
				resource.addError(message, rule_i);
				for (Rule duplicate : duplicates) {
					resource.addError(message, duplicate);
				}
			}
		}
	}
}
