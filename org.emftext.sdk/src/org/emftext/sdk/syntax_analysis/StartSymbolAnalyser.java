package org.emftext.sdk.syntax_analysis;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;

/**
 * The StartSymbolAnalyser checks that all start symbols have syntax.
 */
public class StartSymbolAnalyser extends AbstractPostProcessor {
	
	private final static GeneratorUtil generatorUtil = new GeneratorUtil();

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<GenClass> startSymbols = syntax.getActiveStartSymbols();
		for (GenClass nextStartSymbol : startSymbols) {
			Rule rule = generatorUtil.getRule(syntax, nextStartSymbol);
			if (rule == null) {
				resource.addError("Meta class " + nextStartSymbol.getName() + " has no syntax and can therefore not be used as start element.", syntax);
			}
		}
	}
}
