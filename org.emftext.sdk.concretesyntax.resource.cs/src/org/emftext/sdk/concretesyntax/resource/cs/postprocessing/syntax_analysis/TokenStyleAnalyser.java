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
import java.util.LinkedHashSet;
import java.util.Set;

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
 * The TokenStyleAnalyser checks that all token styles refer either to a token 
 * definition, a CsString, a BooleanTerminal, an EnumLiteralTerminal or to the 
 * virtual token TASK_ITEM.
 */
public class TokenStyleAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Set<String> validTokenNames = getValidTokenNames(syntax);
		
		// for each token style we search for a matching token
		// definition, CsString, BooleanTerminal or EnumLiteralTerminal
		Collection<TokenStyle> styles = syntax.getAllTokenStyles();
		for (TokenStyle tokenStyle : styles) {
			for (String tokenName : tokenStyle.getTokenNames()) {
				if (!validTokenNames.contains(tokenName)) {
					addProblem(CsAnalysisProblemType.STYLE_REFERENCE_TO_NON_EXISTING_TOKEN, "Token style refers to non-existing token " + tokenName + ".", tokenStyle);
				}
			}
		}
	}

	private Set<String> getValidTokenNames(ConcreteSyntax syntax) {
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

		Set<String> validTokenNames = new LinkedHashSet<String>(); 
		for (CompleteTokenDefinition tokenDefinition : syntax.getActiveTokens()) {
			validTokenNames.add(tokenDefinition.getName());
		}
		for (CsString csString : csStrings) {
			validTokenNames.add(csString.getValue());
		}
		for (BooleanTerminal booleanTerminal : booleanTerminals) {
			validTokenNames.add(booleanTerminal.getTrueLiteral());
			validTokenNames.add(booleanTerminal.getFalseLiteral());
		}
		for (EnumLiteralTerminal enumLiteralTerminal : enumLiteralTerminals) {
			validTokenNames.add(enumLiteralTerminal.getText());
		}
		// TODO replace this with a constant
		validTokenNames.add("TASK_ITEM");
		return validTokenNames;
	}
}
