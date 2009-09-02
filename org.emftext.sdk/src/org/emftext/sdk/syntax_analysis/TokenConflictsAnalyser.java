package org.emftext.sdk.syntax_analysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.regex.RegexpTranslationHelper;
import org.emftext.sdk.codegen.regex.SorterException;
import org.emftext.sdk.codegen.regex.TokenSorter;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class TokenConflictsAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		TokenSorter ts = new TokenSorter();
		List<TokenDefinition> conflicting = Collections.emptyList();
		EList<TokenDefinition> allTokenDefinitions = syntax.getActiveTokens();

		List<TokenDefinition> unreachable = Collections.emptyList();
		try {
			conflicting = ts.getConflicting(allTokenDefinitions);
			List<TokenDefinition> directivesMatchingEmptyString = getDirectivesMatchingEmptyString(allTokenDefinitions);
			for (TokenDefinition tokenDirective : directivesMatchingEmptyString) {
				addProblem(resource, ECsProblemType.TOKEN_MATCHES_EMPTY_STRING,
						"The token definition '" + tokenDirective.getRegex()
								+ "' matches the empty string.", tokenDirective);
			}
			unreachable = ts.getNonReachables(allTokenDefinitions);
		} catch (Exception e) {
			addProblem(resource, ECsProblemType.TOKEN_UNREACHABLE,
					"Error during token conflict analysis. " + e.getMessage(),
					syntax);
		}
		for (TokenDefinition tokenDirective : unreachable) {
			conflicting.remove(tokenDirective);

			addProblem(resource, ECsProblemType.TOKEN_UNREACHABLE,
					"The token definition '" + tokenDirective.getRegex()
							+ "' is not reachable", tokenDirective);

		}
		for (TokenDefinition tokenDirective : conflicting) {
			addProblem(resource, ECsProblemType.TOKEN_OVERLAPPING,
					"The token definition '" + tokenDirective.getRegex()
							+ "' overlaps with a previous token definition.",
					tokenDirective);
		}

	}

	private List<TokenDefinition> getDirectivesMatchingEmptyString(
			EList<TokenDefinition> allTokenDirectives) throws SorterException,
			IOException, RecognitionException {
		List<TokenDefinition> emptyMatchers = new ArrayList<TokenDefinition>();
		for (TokenDefinition def : allTokenDirectives) {

			String regex = RegexpTranslationHelper
					.translateAntLRToJavaStyle(def.getRegex());
			if ("".matches(regex)) {
				emptyMatchers.add(def);
			}
		}
		return emptyMatchers;
	}

}
