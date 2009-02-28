package org.emftext.sdk.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class DuplicateTokenNameAnalyser extends AbstractAnalyser {

	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<TokenDefinition> duplicateDefinitions = getDuplicateTokenDefinitions(syntax);
		for (TokenDefinition duplicate : duplicateDefinitions) {
			resource.addError("Duplicate token name (names are not case sensitive).", duplicate);
		}
	}

	public List<TokenDefinition> getDuplicateTokenDefinitions(ConcreteSyntax syntax) {
		List<TokenDefinition> duplicateTokens = new ArrayList<TokenDefinition>();
		
		List<String> foundTokenNames = new ArrayList<String>();
		EList<TokenDefinition> tokens = syntax.getTokens();
		for (int i = 0; i < tokens.size(); i++) {
			TokenDefinition token_i = tokens.get(i);
			String token_i_name = token_i.getName();
			if (foundTokenNames.contains(token_i_name.toLowerCase())) {
				continue;
			}
			
			foundTokenNames.add(token_i_name.toLowerCase());
			
			boolean foundDuplicate = false;
			// name was not found before
			for (int j = i + 1; j < tokens.size(); j++) {
				TokenDefinition token_j = tokens.get(j);
				if (token_j.getName().equalsIgnoreCase(token_i_name)) {
					duplicateTokens.add(token_j);
					foundDuplicate = true;
				}
			}
			if (foundDuplicate) {
				duplicateTokens.add(token_i);
			}
		}
		return duplicateTokens;
	}
}
