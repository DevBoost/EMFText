package org.emftext.sdk.analysis;

import java.util.ArrayList;
import java.util.List;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * A analyser that checks that all token names start with a capital letter.
 */
public class TokenNameAnalyser extends AbstractAnalyser {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<TokenDefinition> wrongDefinitions = getTokenDefinitionsWithInvalidNames(syntax);
		for (TokenDefinition next : wrongDefinitions) {
			resource.addError("Token names must start with a capital letter.", next);
		}
	}

	public List<TokenDefinition> getTokenDefinitionsWithInvalidNames(ConcreteSyntax syntax) {
		List<TokenDefinition> result = new ArrayList<TokenDefinition>();
		for (TokenDefinition definition : syntax.getTokens()) {
			char firstLetter = definition.getName().charAt(0);
			if (!(firstLetter >= 'A' && firstLetter <= 'Z')) {
				result.add(definition);
			}
		}
		return result;
	}
}
