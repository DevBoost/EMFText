package org.emftext.sdk.syntax_analysis;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * The HiddenTokenAnalyser searches for unused token definitions
 * in a syntax and adds a warning for each unused definition.
 */
public class UnusedTokenAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		for (TokenDefinition definition : syntax.getAllTokens()) {
			if (!definition.isUsed()) {
				resource.addWarning("Token " + definition.getName() + " is not used and will be discarded during parsing.", definition);
			}
		}
	}
}
