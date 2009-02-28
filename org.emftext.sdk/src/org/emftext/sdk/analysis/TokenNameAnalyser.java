package org.emftext.sdk.analysis;

import java.util.List;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class TokenNameAnalyser extends AbstractAnalyser {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		ConcreteSyntaxAnalyser analyser = new ConcreteSyntaxAnalyser();
		List<TokenDefinition> wrongDefinitions = analyser.getTokenDefinitionsWithInvalidNames(syntax);
		for (TokenDefinition next : wrongDefinitions) {
			resource.addError("Token names must start with a capital letter.", next);
		}
	}
}
