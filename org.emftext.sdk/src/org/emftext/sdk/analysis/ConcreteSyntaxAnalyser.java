package org.emftext.sdk.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * An analyzer that checks syntaxes for some properties required
 * by the code generation of post-processors.
 */
public class ConcreteSyntaxAnalyser {
	
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

	/**
	 * Checks whether the given feature is defined as a collect-in
	 * feature. Note that the feature may also be defined as collect-in
	 * token in imported syntaxes. 
	 * 
	 * @see DefinedPlaceholderTokenReferenceResolver
	 * 
	 * @param rule
	 * @param syntax
	 * @return
	 */
	public boolean isCollectInFeature(ConcreteSyntax syntax, EStructuralFeature feature) {
		for (Import importElement : syntax.getImports()) {
			ConcreteSyntax importedSyntax = importElement.getConcreteSyntax();
			if (importedSyntax == null) {
				continue;
			}
			boolean isCollectInInImport = isCollectInFeatureWithoutImports(importedSyntax, feature);
			if (isCollectInInImport) {
				return true;
			}
		}
		return isCollectInFeatureWithoutImports(syntax, feature);
	}

	private boolean isCollectInFeatureWithoutImports(ConcreteSyntax syntax, EStructuralFeature feature) {
		for (TokenDefinition tokenDefinition : syntax.getTokens()) {
			final String attributeName = tokenDefinition.getAttributeName();
			final boolean isCollectToken = attributeName != null;
			if (!isCollectToken) {
				continue;
			}
			final boolean namesMatch = attributeName.equals(feature.getName());
			if (namesMatch) {
				return true;
			}
		}
		return false;
	}
}
