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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Sequence;
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
		if (configuration.isUseSingleLineComments()) {
			TokenDirective singleLineCommentToken = createToken("SL_COMMENT", configuration.getSingleLineCommentPrefix() + "(.*)(\\n|\\r|\\n\\r)");
			syntax.getTokens().add(singleLineCommentToken);
		}
		if (configuration.isUseMultiLineComments()) {
			TokenDirective multiLineCommentToken = createToken("ML_COMMENT", configuration.getMultiLineCommentPrefix() + "(.*)" + configuration.getMultiLineCommentSuffix());
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
