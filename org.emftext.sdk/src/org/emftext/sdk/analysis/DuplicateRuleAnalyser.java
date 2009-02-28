package org.emftext.sdk.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;

public class DuplicateRuleAnalyser extends AbstractAnalyser {

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
