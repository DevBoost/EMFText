/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.NamedTokenDefinition;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;

/**
 * A class that customizes code completion proposals to the CS language.
 */
public class CsProposalPostProcessor {
	
	public List<CsCompletionProposal> process(List<CsCompletionProposal> proposals) {
		List<CsCompletionProposal> newProposals = new ArrayList<CsCompletionProposal>();
		for (int i = 0; i < proposals.size(); i++) {
			CsCompletionProposal proposal = proposals.get(i);
			newProposals.add(proposal);
			EStructuralFeature feature = proposal.getStructuralFeature();
			EObject container = proposal.getContainer();
			// change proposal for boolean options from "someValue" to "true", "false"
			if (ConcretesyntaxPackage.eINSTANCE.getOption_Value() == feature) {
				if (container instanceof Option) {
					Option option = (Option) container;
					OptionTypes type = option.getType();
					if (OptionManager.INSTANCE.getBooleanOptions().contains(type)) {
						newProposals.remove(newProposals.size() - 1);
						newProposals.add(new CsCompletionProposal(
								null,
								"\"true\"",
								proposal.getPrefix(), 
								proposal.isMatchesPrefix(), 
								feature, 
								container 
						));
						newProposals.add(new CsCompletionProposal(
								null,
								"\"false\"",
								proposal.getPrefix(), 
								proposal.isMatchesPrefix(), 
								feature, 
								container 
						));
					}
				}
			// change proposal for keywords from "someValue" to "keyword"
			} else if (ConcretesyntaxPackage.eINSTANCE.getCsString_Value() == feature) {
				newProposals.remove(newProposals.size() - 1);
				newProposals.add(new CsCompletionProposal(
						null,
						"\"keyword\"",
						proposal.getPrefix(), 
						proposal.isMatchesPrefix(), 
						feature, 
						container 
				));
			} else if (ConcretesyntaxPackage.eINSTANCE.getNamedTokenDefinition_Name() == feature) {
				newProposals.remove(newProposals.size() - 1);
				newProposals.add(new CsCompletionProposal(
						null,
						"TOKEN_NAME",
						proposal.getPrefix(), 
						proposal.isMatchesPrefix(), 
						feature, 
						container 
				));
			} else if (ConcretesyntaxPackage.eINSTANCE.getTokenStyle_Rgb() == feature) {
				newProposals.remove(newProposals.size() - 1);
				addColorProposals(
						newProposals, 
						proposal.getPrefix(), 
						proposal.isMatchesPrefix(), 
						feature, 
						container
				);
			} else if (ConcretesyntaxPackage.eINSTANCE.getKeyValuePair_Key() == feature) {
				if (container instanceof KeyValuePair) {
					EObject parent = container.eContainer();
					if (parent instanceof Annotation) {
						Annotation annotation = (Annotation) parent;
						AnnotationType type = annotation.getType();
						if (type == AnnotationType.SUPPRESS_WARNINGS) {
							newProposals.remove(newProposals.size() - 1);
							CsAnalysisProblemType[] problemTypes = CsAnalysisProblemType.values();
							for (CsAnalysisProblemType problemType : problemTypes) {
								if (problemType.getProblemSeverity() == CsEProblemSeverity.WARNING) {
									newProposals.add(new CsCompletionProposal(
											null,
											problemType.getName(),
											proposal.getPrefix(), 
											proposal.isMatchesPrefix(), 
											feature, 
											container 
									));
								}
							}
						}
					}
				}
			} else if (ConcretesyntaxPackage.eINSTANCE.getAtomicRegex_AtomicExpression() == feature) {
				newProposals.remove(newProposals.size() - 1);
				
				String insertString = "$'a'..'z'|'0'..'9'$";
				if (container instanceof NamedTokenDefinition) {
					NamedTokenDefinition namedToken = (NamedTokenDefinition) container;
					String tokenName = namedToken.getName();
					if (tokenName != null && tokenName.contains("COMMENT")) {
						insertString = "$'//'(~('\\n'|'\\r'))*$";
					}
					if (tokenName != null && tokenName.contains("NUMBER")) {
						insertString = "$('0'..'9')+$";
					}
					if (tokenName != null && tokenName.contains("WHITE") && tokenName.contains("SPACE")) {
						insertString = "$' '|'\\t'|'\\f'$";
					}
					if (tokenName != null && tokenName.contains("LINE") && tokenName.contains("BREAK")) {
						insertString = "$'\\r\\n'|'\\r'|'\\n'$";
					}
				}
				newProposals.add(new CsCompletionProposal(
						null,
						insertString,
						proposal.getPrefix(), 
						proposal.isMatchesPrefix(), 
						feature, 
						container 
				));
			}
		}
		return newProposals;
	}

	private void addColorProposals(List<CsCompletionProposal> newProposals,
			String prefix, boolean startsWithPrefix,
			EStructuralFeature feature, EObject container) {
		Map<String, Color> allColors = new LinkedHashMap<String, Color>();
		allColors.put("Black", Color.BLACK);
		allColors.put("Blue", Color.BLUE);
		allColors.put("Cyan", Color.CYAN);
		allColors.put("Dark Gray", Color.DARK_GRAY);
		allColors.put("Gray", Color.GRAY);
		allColors.put("Green", Color.GREEN);
		allColors.put("Light Gray", Color.LIGHT_GRAY);
		allColors.put("Magenta", Color.MAGENTA);
		allColors.put("Orange", Color.ORANGE);
		allColors.put("Pink", Color.PINK);
		allColors.put("Red", Color.RED);
		allColors.put("Yellow", Color.YELLOW);
		List<String> colorNames = new ArrayList<String>();
		colorNames.addAll(allColors.keySet());
		Collections.sort(colorNames);
		for (String colorName : colorNames) {
			Color color = allColors.get(colorName);
			String rgb = "#" +
				getHex(color.getRed()) +
				getHex(color.getGreen()) +
				getHex(color.getBlue());
			rgb = rgb.toUpperCase();
			newProposals.add(new CsCompletionProposal(
					null,
					rgb,
					prefix, 
					startsWithPrefix, 
					feature, 
					container,
					null,
					colorName
			));
		}
	}

	private String getHex(int color) {
		String hexString = Integer.toHexString(color);
		if (hexString.length() == 1) {
			hexString = "0" + hexString;
		}
		return hexString;
	}
}
