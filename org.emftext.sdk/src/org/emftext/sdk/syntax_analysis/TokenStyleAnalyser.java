package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.Collection;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenStyle;

/**
 * A analyser that checks that all token styles refer either to
 * a token definition or a CsString.
 */
public class TokenStyleAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		// first we collect all CsStrings from all rules
		Collection<CsString> csStrings = new ArrayList<CsString>();
		// to do so, we must iterate over the rules. Calling eAllContents()
		// on the syntax is not sufficient, because imported rules are not
		// contained in eAllContents().
		for (Rule rule : syntax.getAllRules()) {
			Collection<CsString> csStringsInRule = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
			csStrings.addAll(csStringsInRule);
		}

		// for each token style we search for a matching token
		// definition or CsString
		Collection<TokenStyle> styles = syntax.getAllTokenStyles();
		for (TokenStyle tokenStyle : styles) {
			if (!refersToExistingToken(syntax, csStrings, tokenStyle)) {
				resource.addWarning("Token style refers to non-existing token.", tokenStyle);
			}
		}
	}

	private boolean refersToExistingToken(ConcreteSyntax syntax, Collection<CsString> csStrings, TokenStyle tokenStyle) {
		String name = tokenStyle.getTokenName();
		for (TokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (name.equals(tokenDefinition.getName())) {
				return true;
			}
		}
		for (CsString csString : csStrings) {
			if (name.equals(csString.getValue())) {
				return true;
			}
		}
		return false;
	}
}
