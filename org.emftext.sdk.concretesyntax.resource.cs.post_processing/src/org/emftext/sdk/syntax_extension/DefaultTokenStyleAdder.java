package org.emftext.sdk.syntax_extension;

import java.util.Collection;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

/**
 * The DefaultTokenStyleAdder adds default styles from comments, keywords
 * and quoted tokens. Comments are recognized heuristically by their regular
 * expression and keywords are by their value.
 */
public class DefaultTokenStyleAdder extends TokenStylePostProcessor {

	/**
	 * All CsStrings that match this regular expression will be recognized
	 * as keywords and a default token style (purple and bold face font) 
	 * will be assigned.
	 */
	public static final String KEYWORD_REGEX = "([a-z]|[A-Z])|(([a-z]|[A-Z]|[_])([a-z]|[A-Z]|[:]|[-]|[_])+)";
	public static final Pattern KEYWORD_PATTERN = Pattern.compile(KEYWORD_REGEX);
	private static final String SL_COMMENT = "'//'(~('\n'|'\r'|'\uffff'))*";
	private static final String ML_COMMENT = "'/*'.*'*/'";
	
	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		EList<TokenStyle> allStyles = syntax.getAllTokenStyles();
		// add default styles
		addTokenStylesForKeywords(syntax, allStyles);
		addTokenStylesForQuotedTokens(syntax, allStyles);
		addTokenStylesForComments(syntax, allStyles);
	}

	private void addTokenStylesForComments(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		Collection<CompleteTokenDefinition> tokens = syntax.getActiveTokens();
		for (CompleteTokenDefinition tokenDefinition : tokens) {
			String regex = tokenDefinition.getRegex();
			if (isCommentPattern(regex)) {
				TokenStyle newStyle = ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				newStyle.setRgb("3F805D");
				newStyle.setTokenName(tokenDefinition.getName());
				addStyle(allStyles, newStyle);
			}
		}
	}

	private boolean isCommentPattern(String regex) {
		return SL_COMMENT.equals(regex) || ML_COMMENT.equals(regex);
	}

	private void addTokenStylesForQuotedTokens(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		for (Rule rule : syntax.getAllRules()) {
			Collection<PlaceholderInQuotes> placeholders = CsEObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes());
			for (PlaceholderInQuotes placeholder : placeholders) {
				ReferencableTokenDefinition token = placeholder.getToken();
				if (token == null) {
					continue;
				}
				String tokenName = token.getName();

				TokenStyle newStyle = ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				newStyle.setRgb("2A00FF");
				newStyle.setTokenName(tokenName);
				addStyle(allStyles, newStyle);
			}
		}
	}

	private void addTokenStylesForKeywords(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		for (Rule rule : syntax.getAllRules()) {
			Collection<CsString> csStrings = CsEObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
			for (CsString csString : csStrings) {
				if (KEYWORD_PATTERN.matcher(csString.getValue()).matches()) {
					TokenStyle newStyle = ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					newStyle.setRgb("800055");
					newStyle.setTokenName(csString.getValue());
					newStyle.getFontStyles().add(FontStyle.BOLD);
					addStyle(allStyles, newStyle);
				}
			}
		}
	}
}
