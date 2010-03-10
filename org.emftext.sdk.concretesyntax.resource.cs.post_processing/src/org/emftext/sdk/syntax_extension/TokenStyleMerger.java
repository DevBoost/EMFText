/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_extension;

import java.util.Collection;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

/**
 * The TokenStyleMerger reads all token styles from imported syntaxes and
 * merges them with the styles defined in the current syntax. If a token
 * styles exists both in an imported and in the current syntax the one from
 * the current syntax overrides the imported one.
 * 
 * In addition the TokenStyleMerger adds default styles from comments, keywords
 * and quoted tokens. Comments are recognized heuristically by their regular
 * expression and keywords are by their value.
 * 
 * TODO split this class into TokenStyleMerger and DefaultTokenStyleAdder
 */
public class TokenStyleMerger extends AbstractPostProcessor {

	/**
	 * All CsStrings that match this regular expression will be recognized
	 * as keywords and a default token style (purple and bold face font) 
	 * will be assigned.
	 */
	public static final String KEYWORD_REGEX = "([a-z]|[A-Z])|(([a-z]|[A-Z]|[_])([a-z]|[A-Z]|[:]|[-]|[_])+)";
	public static final Pattern KEYWORD_PATTERN = Pattern.compile(KEYWORD_REGEX);
	// TODO maybe this can be formulated in a more generic way?
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
				CompleteTokenDefinition token = placeholder.getToken();
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
