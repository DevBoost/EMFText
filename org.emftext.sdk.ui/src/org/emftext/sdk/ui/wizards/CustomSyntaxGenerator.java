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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
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
			TokenDirective singleLineCommentToken = createToken("SL_COMMENT", "'" + configuration.getSingleLineCommentPrefix() + "'(.*)(\\n|\\r|\\n\\r)");
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
			addKeyword(ruleSequence, StringUtil.capitalize(name));
		}
		if (configuration.getKeywordStyle() == KeywordStyle.CAPITALIZED) {
			addKeyword(ruleSequence, name.toUpperCase());
		}
	}
	
	protected void generateTokenStyles(ConcreteSyntax syntax) {
		// do nothing
	}
	
	@Override
	protected void generateFeatureSyntax(ConcreteSyntax syntax,
			Choice featureSyntaxChoice, GenFeature genFeature) {
		if (isModifierFeature(genFeature) && configuration.isSeparateBooleanAttributes()) {
			return;
		}
		super.generateFeatureSyntax(syntax, featureSyntaxChoice, genFeature);
	}

	@Override
	public void addBooleanModifiers(Sequence sequence, List<GenFeature> allGenFeatures) {
		if (configuration.isSeparateBooleanAttributes()) {
			super.addBooleanModifiers(sequence, allGenFeatures);
		}
	}

	@Override
	public Terminal createStringAttributeSyntax() {
		if (configuration.isQuoteStringAttributes()) {
			String quoteString = configuration.getStringAttributeQuote();
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
}
