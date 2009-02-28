package org.emftext.sdk.analysis;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.finders.GenClassFinder;

public class MissingRulesAnalyser extends AbstractAnalyser {

	private static final String NO_RULE_FOR_META_CLASS = "There is no rule for concrete meta class: ";

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
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
			if (ecoreClass.isAbstract()) {
				continue;
			}
			String qualifiedName = genClass.getQualifiedInterfaceName();
			if (namesOfCompletedGenClasses.contains(qualifiedName)) {
				continue;
			}
			namesOfCompletedGenClasses.add(qualifiedName);
			boolean foundRuleForClass = false;
			for (Rule rule : allRules) {
				GenClass ruleClass = rule.getMetaclass();
				if (ruleClass != null && !ruleClass.eIsProxy() && ruleClass.getQualifiedInterfaceName().equals(qualifiedName)) {
					foundRuleForClass = true;
					break;
				}
			}
			if (!foundRuleForClass) {
				resource.addWarning(NO_RULE_FOR_META_CLASS + genClass.getName(), 0, 0, 0, 1);
			}
		}
	}
}
