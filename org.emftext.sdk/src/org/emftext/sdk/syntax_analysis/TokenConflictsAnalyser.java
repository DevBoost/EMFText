package org.emftext.sdk.syntax_analysis;

import java.util.Collections;
import java.util.List;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.regex.SorterException;
import org.emftext.sdk.codegen.regex.TokenSorter;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.concretesyntax.TokenPriorityDirective;

public class TokenConflictsAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		TokenSorter ts = new TokenSorter();
		// List<TokenDirective> conflicting = Collections.EMPTY_LIST;
		List<TokenDirective> unreachable = Collections.emptyList();
		try {
			// conflicting = ts.getConflicting(syntax.getAllTokenDirectives());
			unreachable = ts.getNonReachables(syntax.getAllTokenDirectives());
		} catch (SorterException e) {
			addProblem(resource, ECsProblemType.TOKEN_CONFLICT,
					"Error during token conflict analysis. " + e.getMessage(),
					syntax);
		}
		for (TokenDirective tokenDirective : unreachable) {
			// conflicting.remove(tokenDirective);
			if (tokenDirective instanceof TokenDefinition) {
				addProblem(resource, ECsProblemType.TOKEN_CONFLICT,
						"The token definition '"
								+ ((TokenDefinition) tokenDirective).getRegex()
								+ "' is not reachable", tokenDirective);
			} else if (tokenDirective instanceof TokenPriorityDirective) {
				addProblem(resource, ECsProblemType.TOKEN_CONFLICT,
						"The token definition '"
								+ ((TokenPriorityDirective) tokenDirective)
										.getToken().getRegex()
								+ "' is not reachable", tokenDirective);
			} else {
				addProblem(resource, ECsProblemType.TOKEN_CONFLICT,
						"The token definition '" + tokenDirective
								+ "' is not reachable", tokenDirective);
			}

		}
		// for (TokenDirective d : conflicting) {
		// addProblem(resource, ECsProblemType.TOKEN_CONFLICT,
		// "This token conflicts with a previous token definition.", d);
		// }

	}

}
