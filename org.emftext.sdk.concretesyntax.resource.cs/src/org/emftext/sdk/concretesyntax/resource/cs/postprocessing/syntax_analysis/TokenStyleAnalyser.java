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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.EnumLiteralTerminal;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenStyle;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

/**
 * A analyser that checks that all token styles refer either to
 * a token definition, a CsString, a BooleanTerminal or a 
 * EnumLiteralTerminal.
 */
public class TokenStyleAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		// first we collect all CsStrings, BooleanTerminals and EnumLiteralTerminals from all rules
		Collection<CsString> csStrings = new ArrayList<CsString>();
		Collection<BooleanTerminal> booleanTerminals = new ArrayList<BooleanTerminal>();
		Collection<EnumLiteralTerminal> enumLiteralTerminals = new ArrayList<EnumLiteralTerminal>();
		
		// to do so, we must iterate over the rules. Calling eAllContents()
		// on the syntax is not sufficient, because imported rules are not
		// contained in eAllContents().
		for (Rule rule : syntax.getAllRules()) {
			Collection<CsString> csStringsInRule = CsEObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
			csStrings.addAll(csStringsInRule);
			Collection<BooleanTerminal> booleanTerminalsInRule = CsEObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal());
			booleanTerminals.addAll(booleanTerminalsInRule);
			Collection<EnumLiteralTerminal> enumLiteralTerminalsInRule = CsEObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal());
			enumLiteralTerminals.addAll(enumLiteralTerminalsInRule);
		}

		// for each token style we search for a matching token
		// definition, CsString, BooleanTerminal or EnumLiteralTerminal
		Collection<TokenStyle> styles = syntax.getAllTokenStyles();
		for (TokenStyle tokenStyle : styles) {
			for (String tokenName : tokenStyle.getTokenNames()) {
				if (!refersToExistingToken(syntax, csStrings, booleanTerminals, enumLiteralTerminals, tokenName)) {
					addProblem(CsAnalysisProblemType.STYLE_REFERENCE_TO_NON_EXISTING_TOKEN, "Token style refers to non-existing token " + tokenName + ".", tokenStyle);
				}
			}
		}
	}

	private boolean refersToExistingToken(ConcreteSyntax syntax, Collection<CsString> csStrings, Collection<BooleanTerminal> booleanTerminals, Collection<EnumLiteralTerminal> enumLiteralTerminals, String tokenName) {
		for (CompleteTokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			if (tokenName.equals(tokenDefinition.getName())) {
				return true;
			}
		}
		for (CsString csString : csStrings) {
			if (tokenName.equals(csString.getValue())) {
				return true;
			}
		}
		for (BooleanTerminal booleanTerminal : booleanTerminals) {
			if (tokenName.equals(booleanTerminal.getTrueLiteral())) {
				return true;
			}
			if (tokenName.equals(booleanTerminal.getFalseLiteral())) {
				return true;
			}
		}
		for (EnumLiteralTerminal enumLiteralTerminal : enumLiteralTerminals) {
			if (tokenName.equals(enumLiteralTerminal.getText())) {
				return true;
			}
		}
		return false;
	}
}
