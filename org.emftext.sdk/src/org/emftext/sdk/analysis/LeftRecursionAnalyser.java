package org.emftext.sdk.analysis;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.finders.GenClassFinder;

/**
 * An analyser that checks whether the syntax contains left-recursive rules.
 */
public class LeftRecursionAnalyser extends AbstractAnalyser {
	
	private static final String RULE_IS_LEFT_RECURSIVE_IN_RELATION_TO = "The rule is left recursive in relation to rule: ";

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		GenClassFinder genClassFinder = new GenClassFinder();
		Set<GenClass> allGenClasses = genClassFinder.findAllGenClasses(syntax, true, true);
		Map<String, Collection<String>> genClassNames2superClassNames = genClassFinder.findAllSuperclasses(allGenClasses);
		LeftRecursionDetector lrd = new LeftRecursionDetector(genClassNames2superClassNames, syntax);
		
		EList<Rule> allRules = syntax.getAllRules();
		
		for (Rule rule : allRules) {
			Rule recursionRule = lrd.findLeftRecursion(rule);
			if (recursionRule != null) {
				resource.addWarning(RULE_IS_LEFT_RECURSIVE_IN_RELATION_TO + recursionRule.getMetaclass().getName(), rule);
			}
		}
	}
}
