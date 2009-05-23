package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.List;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenStyle;

public class DuplicateTokenStyleAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<String> tokenNames = new ArrayList<String>();
		List<TokenStyle> duplicates = new ArrayList<TokenStyle>();
		
		// search for duplicate
		List<TokenStyle> allTokenStyles = syntax.getAllTokenStyles();
		for (TokenStyle nextStyle : allTokenStyles) {
			String nextName = nextStyle.getTokenName();
			if (tokenNames.contains(nextName)) {
				// found duplicate
				duplicates.add(nextStyle);
			} else {
				tokenNames.add(nextName);
			}
		}
		
		// add warnings
		for (TokenStyle nextDuplicate : duplicates) {
			resource.addWarning("Style for \"" + nextDuplicate.getTokenName() + "\" is already defined (potentially in imported syntax).", nextDuplicate);
		}
	}
}
