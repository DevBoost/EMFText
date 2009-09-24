package org.emftext.sdk.syntax_extension;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.util.EObjectUtil;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;

public class TokenStyleMerger extends AbstractPostProcessor {

	// TODO maybe this can be formulated in a more generic way
	private static final String SL_COMMENT = "'//'(~('\n'|'\r'|'\uffff'))*";
	private static final String ML_COMMENT = "'/*'.*'*/'";
	
	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		EList<TokenStyle> allStyles = syntax.getAllTokenStyles();
		allStyles.addAll(syntax.getTokenStyles());
		
		// first add the imported token styles
		EList<Import> imports = syntax.getImports();
		for (Import importedElement : imports) {
			ConcreteSyntax importedSyntax = importedElement.getConcreteSyntax();
			if (importedSyntax != null) {
				EList<TokenStyle> importedStyles = importedSyntax.getAllTokenStyles();
				for (TokenStyle importedStyle : importedStyles) {
					addStyle(allStyles, importedStyle);
				}
			}
		}
		
		// second add default styles
		addTokenStylesForKeywords(syntax, allStyles);
		addTokenStylesForQuotedTokens(syntax, allStyles);
		addTokenStylesForComments(syntax, allStyles);
	}

	private void addTokenStylesForComments(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		Collection<TokenDefinition> tokens = syntax.getActiveTokens();
		for (TokenDefinition tokenDefinition : tokens) {
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
			Collection<PlaceholderInQuotes> placeholders = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes());
			for (PlaceholderInQuotes placeholder : placeholders) {
				String tokenName = placeholder.getToken().getName();

				TokenStyle newStyle = ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
				newStyle.setRgb("2A00FF");
				newStyle.setTokenName(tokenName);
				addStyle(allStyles, newStyle);
			}
		}
	}

	private void addTokenStylesForKeywords(ConcreteSyntax syntax, EList<TokenStyle> allStyles) {
		for (Rule rule : syntax.getAllRules()) {
			Collection<CsString> csStrings = EObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
			for (CsString csString : csStrings) {
				if (csString.getValue().matches("([a-z]|[A-Z]|[:]|[-])+")) {
					TokenStyle newStyle = ConcretesyntaxFactory.eINSTANCE.createTokenStyle();
					newStyle.setRgb("800055");
					newStyle.setTokenName(csString.getValue());
					newStyle.getFontStyles().add(FontStyle.BOLD);
					addStyle(allStyles, newStyle);
				}
			}
		}
	}

	private void addStyle(EList<TokenStyle> allStyles, TokenStyle style) {
		boolean exists = containsStyle(allStyles, style);
		if (!exists){
			allStyles.add(style);
		}
	}

	private boolean containsStyle(Collection<TokenStyle> styles, TokenStyle style) {
		for (TokenStyle existingStyle : styles) {
			if (existingStyle.getTokenName().equals(style.getTokenName())) {
				return true;
			}
		}
		return false;
	}

}
