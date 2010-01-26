package org.emftext.sdk.syntax_analysis;

import java.util.Collection;
import java.util.List;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class PlaceholderInQuotesSuffixAnalyser extends AbstractPostProcessor {

	public final static String MESSAGE = "The suffix for the placeholder in quotes must not be empty.";

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		// we do not analyse all rule because imported ones can not be correctly
		// handled when this analyser is called
		List<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			Collection<PlaceholderInQuotes> placeholdersInQuotes = CsEObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes());
			for (PlaceholderInQuotes placeholderInQuotes : placeholdersInQuotes) {
				checkEmptySuffix(resource, placeholderInQuotes);
			}
		}
	}

	private void checkEmptySuffix(CsResource resource, PlaceholderInQuotes placeholder) {
		String suffix = placeholder.getSuffix();
		if (suffix != null && "".equals(suffix)) {
			addProblem(resource, ECsProblemType.PLACEHOLDER_IN_QUOTES_WITH_EMPTY_SUFFIX, MESSAGE, placeholder);
		}
	}
}
