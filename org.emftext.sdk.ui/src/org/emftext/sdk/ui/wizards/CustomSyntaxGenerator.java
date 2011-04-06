/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.ui.wizards;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.EPredefinedTokens;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.TokenDirective;
import org.emftext.sdk.ui.AbstractSyntaxGenerator;
import org.emftext.sdk.ui.wizards.CustomSyntaxConfiguration.KeywordStyle;
import org.emftext.sdk.util.StringUtil;

public class CustomSyntaxGenerator extends AbstractSyntaxGenerator {

	private CustomSyntaxConfiguration configuration;

	public CustomSyntaxGenerator(CustomSyntaxConfiguration configuration) {
		super();
		this.configuration = configuration;
	}

	@Override
	public void fillSyntax(ConcreteSyntax syntax, GenModel genModel) {
		super.fillSyntax(syntax, genModel);
		addTokens(syntax);
	}

	private void addTokens(ConcreteSyntax syntax) {
		// TODO escape prefixes and suffixes
		if (configuration.isUseSingleLineComments()) {
			TokenDirective singleLineCommentToken = createToken("SL_COMMENT", "'" + configuration.getSingleLineCommentPrefix() + "'(~('\\n'|'\\r'|'\\uffff'))*");
			syntax.getTokens().add(singleLineCommentToken);
		}
		if (configuration.isUseMultiLineComments()) {
			TokenDirective multiLineCommentToken = createToken("ML_COMMENT", "'" + configuration.getMultiLineCommentPrefix() + "'(.*)'" + configuration.getMultiLineCommentSuffix() + "'");
			syntax.getTokens().add(multiLineCommentToken);
		}
	}

	@Override
	protected void addKeyword(GenClass genClass, Sequence ruleSequence) {
		String name = genClass.getName();
		if (configuration.getKeywordStyle() == KeywordStyle.NO_KEYWORDS) {
			return;
		}
		if (configuration.getKeywordStyle() == KeywordStyle.LOWER) {
			addKeyword(ruleSequence, StringUtil.firstToLower(name));
		}
		if (configuration.getKeywordStyle() == KeywordStyle.UPPER) {
			addKeyword(ruleSequence, name.toUpperCase());
		}
		if (configuration.getKeywordStyle() == KeywordStyle.CAPITALIZED) {
			addKeyword(ruleSequence, StringUtil.capitalize(name));
		}
	}

	@Override
	protected void addStandardTokens(ConcreteSyntax syntax, boolean addCommentToken) {
		// add IDENTIFIER token if required
		if (!configuration.isIdentifiersWithDash() ||
				!configuration.isIdentifiersWithUnderscore() ||
				!configuration.isIdentifiersWithDigitsFirst()) {

			String alternatives = "";
			if (configuration.isIdentifiersWithDash()) {
				alternatives += "| '-'";
			}
			if (configuration.isIdentifiersWithUnderscore()) {
				alternatives += "| '_'";
			}
			String regex = "('A'..'Z' | 'a'..'z' | '0'..'9' " + alternatives + ")";
			if (configuration.isIdentifiersWithDigitsFirst()) {
				regex = regex + "+";
			} else {
				regex = "('A'..'Z' | 'a'..'z' " + alternatives + ")" + regex + "*";
			}

			// disable predefined tokens
			Option option = CS_FACTORY.createOption();
			option.setType(OptionTypes.USE_PREDEFINED_TOKENS);
			option.setValue("false");
			syntax.getOptions().add(option);

			// add custom identifier token
			String tokenName = "IDENTIFIER";
			NormalTokenDefinition identifierToken = createToken(tokenName, regex);
			syntax.getTokens().add(identifierToken);

			// add whitespace and line break tokens
			syntax.getTokens().add(createToken(EPredefinedTokens.WHITESPACE.getTokenName(), EPredefinedTokens.WHITESPACE.getExpression()));
			syntax.getTokens().add(createToken(EPredefinedTokens.LINEBREAK.getTokenName(), EPredefinedTokens.LINEBREAK.getExpression()));

			// set IDENTIFIER as default token
			Option option2 = CS_FACTORY.createOption();
			option2.setType(OptionTypes.DEFAULT_TOKEN_NAME);
			option2.setValue(tokenName);
			syntax.getOptions().add(option2);
		}

		super.addStandardTokens(syntax, false);
	}

	@Override
	protected void generateTokenStyles(ConcreteSyntax syntax) {
		// do nothing
	}

	@Override
	protected void generateFeatureSyntax(ConcreteSyntax syntax,
			Choice featureSyntaxChoice, GenFeature genFeature) {
		if (isBooleanModifierFeature(genFeature) && configuration.isModifierStyleForBooleanAttributes()) {
			return;
		}
		if (isEnumModifierFeature(genFeature) && configuration.isModifierStyleForEnumAttributes()) {
			return;
		}
		super.generateFeatureSyntax(syntax, featureSyntaxChoice, genFeature);
	}

	@Override
	public void addBooleanModifiers(Sequence sequence, List<GenFeature> allGenFeatures) {
		if (configuration.isModifierStyleForBooleanAttributes()) {
			super.addBooleanModifiers(sequence, allGenFeatures);
		}
	}

	@Override
	protected void addEnumModifiers(Sequence sequence,
			List<GenFeature> allGenFeatures) {
		if (configuration.isModifierStyleForEnumAttributes()) {
			super.addEnumModifiers(sequence, allGenFeatures);
		}
	}

	@Override
	protected Terminal createStringAttributeSyntax() {
		boolean doQuote = configuration.isQuoteStringAttributes();
		String quoteString = configuration.getStringAttributeQuote();
		return createPlaceholder(doQuote, quoteString);
	}

	@Override
	protected Terminal createIdentifierAttributeSyntax() {
		boolean doQuote = configuration.isQuoteIdentifierAttributes();
		String quoteString = configuration.getIdentifierAttributeQuote();
		return createPlaceholder(doQuote, quoteString);
	}

	private Terminal createPlaceholder(boolean doQuote, String quoteString) {
		if (doQuote) {
			PlaceholderInQuotes placeholder = CS_FACTORY.createPlaceholderInQuotes();
			placeholder.setPrefix(quoteString);
			placeholder.setSuffix(quoteString);
			return placeholder;
		} else {
			Terminal placeholder = CS_FACTORY.createPlaceholderUsingDefaultToken();
			return placeholder;
		}
	}

	@Override
	public void addOpening(GenClass genClass, Sequence sequence) {
		String opener = configuration.getContainmentOpener();
		if (configuration.isEncloseContainments() && opener != null) {
			addKeyword(sequence, opener);
		}
	}

	@Override
	public void addClosing(GenClass genClass, Sequence sequence) {
		String closer = configuration.getContainmentCloser();
		if (configuration.isEncloseContainments() && closer != null) {
			addKeyword(sequence, closer);
		}

		String terminatingKeyword = configuration.getTerminatingKeyword();
		if (!hasContainmentFeatures(genClass) && 
				configuration.isTerminateTerminalElements() &&
				terminatingKeyword != null && 
				terminatingKeyword.length() > 0) {
			addKeyword(sequence, terminatingKeyword);
		}
	}

	@Override
	public void createFeaturePrefix(GenFeature genFeature, Sequence sequence) {
		boolean addPrefix = false;
		EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
		if (configuration.isQualifyAttributes() && ecoreFeature instanceof EAttribute) {
			addPrefix = true;
		}
		if (ecoreFeature instanceof EReference) {
			EReference eReference = (EReference) ecoreFeature;
			if (eReference.isContainment() && configuration.isQualifyContainments()) {
				addPrefix = true;
			}
			if (!eReference.isContainment() && configuration.isQualifyCrossReferences()) {
				addPrefix = true;
			}
		}
		if (addPrefix) {
			addKeyword(sequence, ecoreFeature.getName());
			String delimiter = configuration.getQualificationDelimiter();
			if (delimiter != null && delimiter.length() > 0) {
				addKeyword(sequence, delimiter);
			}
		}
	}

	@Override
	protected void generateRulesForImports(ConcreteSyntax syntax,
			GenClassCache genClassCache, Map<String, Rule> genClass2RuleCache,
			List<GenPackage> allGenPackagesWithClassifiers) {
		if(configuration.isGenerateRulesForImportedModels()){
			for (int i = 1; i < allGenPackagesWithClassifiers.size(); i++) {
				GenPackage currentPkg = allGenPackagesWithClassifiers.get(i);

				Import imp = CS_FACTORY.createImport();
				syntax.getImports().add(imp);
				imp.setPackage(currentPkg);
				String prefix = currentPkg.getQualifiedPackageName();
				imp.setPrefix(prefix);

				generateRules(syntax, genClass2RuleCache, currentPkg, prefix, genClassCache);
			}
		}
	}
}
