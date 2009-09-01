package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.regex.SorterException;
import org.emftext.sdk.codegen.regex.TokenSorter;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.NewDefinedToken;
import org.emftext.sdk.concretesyntax.NormalToken;
import org.emftext.sdk.concretesyntax.QuotedToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;

public class TokenConflictsAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		TokenSorter ts = new TokenSorter();
		// List<TokenDirective> conflicting = Collections.EMPTY_LIST;
		EList<TokenDefinition> allTokenDirectives = syntax.getActiveTokens();

		List<TokenDefinition> unreachable = Collections.emptyList();
		try {
			// conflicting = ts.getConflicting(syntax.getAllTokenDirectives());
			List<TokenDefinition> directivesMatchingEmptyString = getDirectivesMatchingEmptyString(allTokenDirectives);
			for (TokenDefinition tokenDirective : directivesMatchingEmptyString) {
				addProblem(resource, ECsProblemType.TOKEN_MATCHES_EMPTY_STRING,
						"The token definition'"
								+ tokenDirective.getRegex()
								+ "' matches the empty string.", tokenDirective);
			}
			unreachable = ts.getNonReachables(allTokenDirectives);
		} catch (SorterException e) {
			addProblem(resource, ECsProblemType.TOKEN_CONFLICT,
					"Error during token conflict analysis. " + e.getMessage(),
					syntax);
		}
		for (TokenDefinition tokenDirective : unreachable) {
			// conflicting.remove(tokenDirective);

			addProblem(resource, ECsProblemType.TOKEN_CONFLICT,
					"The token definition '" + tokenDirective.getRegex()
							+ "' is not reachable", tokenDirective);

		}
		// for (TokenDirective d : conflicting) {
		// addProblem(resource, ECsProblemType.TOKEN_CONFLICT,
		// "This token conflicts with a previous token definition.", d);
		// }

	}

	private List<TokenDefinition> getDirectivesMatchingEmptyString(
			EList<TokenDefinition> allTokenDirectives) throws SorterException {
		List<TokenDefinition> emptyMatchers = new ArrayList<TokenDefinition>();
		for (TokenDefinition def : allTokenDirectives) {
			String regex = null;
			if (def instanceof NewDefinedToken) {
				NewDefinedToken newToken = (NewDefinedToken) def;
				regex = newToken.getRegex();

			} else if (def instanceof NormalToken) {
				NormalToken newToken = (NormalToken) def;
				regex = newToken.getRegex();

			} else if (def instanceof QuotedToken) {
				QuotedToken newToken = (QuotedToken) def;
				regex = newToken.getRegex();

			} else if (def instanceof TokenPriorityDirective) {
				// ignore priority directives
				continue;
			} else {
				throw new SorterException(
						"An undefined token class was found. The unkown type was: "
								+ def.getClass().getName());
			}
			if ("".matches(regex)) {
				emptyMatchers.add(def);
			}
		}
		return emptyMatchers;
	}

}
