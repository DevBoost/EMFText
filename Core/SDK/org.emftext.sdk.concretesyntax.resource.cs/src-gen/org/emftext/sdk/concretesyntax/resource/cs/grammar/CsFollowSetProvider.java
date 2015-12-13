/*******************************************************************************
 * Copyright (c) 2006-2015
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Dresden, Amtsgericht Dresden, HRB 34001
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.grammar;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class CsFollowSetProvider {
	
	public static int terminalsIndex;
	public final static org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement TERMINALS[] = new org.emftext.sdk.concretesyntax.resource.cs.ICsExpectedElement[122];
	
	public static int featureIndex;
	public final static EStructuralFeature[] FEATURES = new EStructuralFeature[10];
	
	public static int linkIndex;
	public final static org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] LINKS = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[25];
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] EMPTY_LINK_ARRAY = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedBooleanTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_6);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_8);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_9_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_18);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_2_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_11_0_0_3_0_0_1_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_12_0_0_7);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_7);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_13_0_0_5_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_7);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_14_0_0_5_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_15_0_0_7);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_20);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_0_0_0_23);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_4_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_5);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_1_0_0_5_0_0_6_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_2_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_6_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_15_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_16_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_3_0_0_6);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_5_0_0_1_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedEnumerationTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_7_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedEnumerationTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_8_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_6);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_5_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedEnumerationTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_9_0_0_7);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_6);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_7);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedEnumerationTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_10_0_0_8);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_3_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedEnumerationTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_11_0_0_5);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_12_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedEnumerationTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_2_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_13_0_0_1_0_0_2_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedEnumerationTerminal(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_14_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_5);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_21_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_22_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_17_0_0_8_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_6_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_18_0_0_7_0_0_5);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_4);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_19_0_0_7_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_20_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_1_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_1_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_5);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_7);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_23_0_0_6_0_0_2);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_1);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_2_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_24_0_0_2_0_0_3);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedCsString(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_0);
		TERMINALS[terminalsIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedStructuralFeature(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.CS_25_0_0_1_0_0_1);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		featureIndex = 0;
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotable().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTABLE__ANNOTATIONS);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSyntaxElement().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SYNTAX_ELEMENT__CHILDREN);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexComposite().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_COMPOSITE__REGEX_PARTS);
		FEATURES[featureIndex++] = org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		linkIndex = 0;
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), FEATURES[2]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), FEATURES[3]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), FEATURES[3]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), FEATURES[3]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(), FEATURES[3]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), FEATURES[4]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), FEATURES[5]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal(), FEATURES[7]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex(), FEATURES[8]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference(), FEATURES[8]);
		LINKS[linkIndex++] = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), FEATURES[9]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[13], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[13].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[14].addFollower(TERMINALS[15], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[14], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[15].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[16], EMPTY_LINK_ARRAY);
		TERMINALS[16].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[16].addFollower(TERMINALS[17], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[16].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[9], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[18].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[9].addFollower(TERMINALS[19], EMPTY_LINK_ARRAY);
		TERMINALS[19].addFollower(TERMINALS[20], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), FEATURES[2]), });
		TERMINALS[19].addFollower(TERMINALS[21], EMPTY_LINK_ARRAY);
		TERMINALS[22].addFollower(TERMINALS[20], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), FEATURES[2]), });
		TERMINALS[22].addFollower(TERMINALS[21], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[10], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[21].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[10].addFollower(TERMINALS[23], EMPTY_LINK_ARRAY);
		TERMINALS[23].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), FEATURES[3]), });
		TERMINALS[23].addFollower(TERMINALS[24], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), FEATURES[3]), });
		TERMINALS[23].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), FEATURES[3]), });
		TERMINALS[23].addFollower(TERMINALS[25], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), FEATURES[3]), });
		TERMINALS[23].addFollower(TERMINALS[26], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), FEATURES[3]), });
		TERMINALS[23].addFollower(TERMINALS[27], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(), FEATURES[3]), });
		TERMINALS[23].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[29].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), FEATURES[3]), });
		TERMINALS[29].addFollower(TERMINALS[24], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), FEATURES[3]), });
		TERMINALS[29].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), FEATURES[3]), });
		TERMINALS[29].addFollower(TERMINALS[25], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), FEATURES[3]), });
		TERMINALS[29].addFollower(TERMINALS[26], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), FEATURES[3]), });
		TERMINALS[29].addFollower(TERMINALS[27], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(), FEATURES[3]), });
		TERMINALS[29].addFollower(TERMINALS[28], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[11], EMPTY_LINK_ARRAY);
		TERMINALS[28].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[11].addFollower(TERMINALS[30], EMPTY_LINK_ARRAY);
		TERMINALS[30].addFollower(TERMINALS[31], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), FEATURES[4]), });
		TERMINALS[30].addFollower(TERMINALS[32], EMPTY_LINK_ARRAY);
		TERMINALS[32].addFollower(TERMINALS[12], EMPTY_LINK_ARRAY);
		TERMINALS[12].addFollower(TERMINALS[33], EMPTY_LINK_ARRAY);
		TERMINALS[33].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), FEATURES[5]), });
		TERMINALS[33].addFollower(TERMINALS[34], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), FEATURES[5]), });
		TERMINALS[33].addFollower(TERMINALS[35], EMPTY_LINK_ARRAY);
		TERMINALS[17].addFollower(TERMINALS[36], EMPTY_LINK_ARRAY);
		TERMINALS[36].addFollower(TERMINALS[37], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[38], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[39], EMPTY_LINK_ARRAY);
		TERMINALS[37].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[37].addFollower(TERMINALS[17], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[37].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[38].addFollower(TERMINALS[39], EMPTY_LINK_ARRAY);
		TERMINALS[38].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[38].addFollower(TERMINALS[17], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[38].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[39].addFollower(TERMINALS[40], EMPTY_LINK_ARRAY);
		TERMINALS[40].addFollower(TERMINALS[41], EMPTY_LINK_ARRAY);
		TERMINALS[41].addFollower(TERMINALS[42], EMPTY_LINK_ARRAY);
		TERMINALS[41].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[41].addFollower(TERMINALS[17], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[41].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[42].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[42].addFollower(TERMINALS[17], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), FEATURES[1]), });
		TERMINALS[42].addFollower(TERMINALS[18], EMPTY_LINK_ARRAY);
		TERMINALS[20].addFollower(TERMINALS[43], EMPTY_LINK_ARRAY);
		TERMINALS[43].addFollower(TERMINALS[44], EMPTY_LINK_ARRAY);
		TERMINALS[44].addFollower(TERMINALS[22], EMPTY_LINK_ARRAY);
		TERMINALS[34].addFollower(TERMINALS[45], EMPTY_LINK_ARRAY);
		TERMINALS[45].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[45].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[56].addFollower(TERMINALS[0], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), FEATURES[0]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), FEATURES[5]), });
		TERMINALS[56].addFollower(TERMINALS[34], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), FEATURES[5]), });
		TERMINALS[56].addFollower(TERMINALS[35], EMPTY_LINK_ARRAY);
		TERMINALS[57].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[57].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[46].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[46].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[46].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[47].addFollower(TERMINALS[59], EMPTY_LINK_ARRAY);
		TERMINALS[59].addFollower(TERMINALS[60], EMPTY_LINK_ARRAY);
		TERMINALS[60].addFollower(TERMINALS[61], EMPTY_LINK_ARRAY);
		TERMINALS[61].addFollower(TERMINALS[62], EMPTY_LINK_ARRAY);
		TERMINALS[61].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[61].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[61].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[61].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[48].addFollower(TERMINALS[63], EMPTY_LINK_ARRAY);
		TERMINALS[63].addFollower(TERMINALS[64], EMPTY_LINK_ARRAY);
		TERMINALS[64].addFollower(TERMINALS[65], EMPTY_LINK_ARRAY);
		TERMINALS[64].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[64].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[64].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[64].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[49].addFollower(TERMINALS[66], EMPTY_LINK_ARRAY);
		TERMINALS[66].addFollower(TERMINALS[67], EMPTY_LINK_ARRAY);
		TERMINALS[67].addFollower(TERMINALS[68], EMPTY_LINK_ARRAY);
		TERMINALS[68].addFollower(TERMINALS[69], EMPTY_LINK_ARRAY);
		TERMINALS[69].addFollower(TERMINALS[70], EMPTY_LINK_ARRAY);
		TERMINALS[69].addFollower(TERMINALS[71], EMPTY_LINK_ARRAY);
		TERMINALS[70].addFollower(TERMINALS[72], EMPTY_LINK_ARRAY);
		TERMINALS[72].addFollower(TERMINALS[71], EMPTY_LINK_ARRAY);
		TERMINALS[71].addFollower(TERMINALS[73], EMPTY_LINK_ARRAY);
		TERMINALS[71].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[71].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[71].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[71].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[50].addFollower(TERMINALS[74], EMPTY_LINK_ARRAY);
		TERMINALS[74].addFollower(TERMINALS[75], EMPTY_LINK_ARRAY);
		TERMINALS[75].addFollower(TERMINALS[76], EMPTY_LINK_ARRAY);
		TERMINALS[76].addFollower(TERMINALS[77], EMPTY_LINK_ARRAY);
		TERMINALS[77].addFollower(TERMINALS[78], EMPTY_LINK_ARRAY);
		TERMINALS[78].addFollower(TERMINALS[79], EMPTY_LINK_ARRAY);
		TERMINALS[78].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[78].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[78].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[78].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[51].addFollower(TERMINALS[80], EMPTY_LINK_ARRAY);
		TERMINALS[80].addFollower(TERMINALS[81], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal(), FEATURES[7]), });
		TERMINALS[82].addFollower(TERMINALS[81], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal(), FEATURES[7]), });
		TERMINALS[83].addFollower(TERMINALS[84], EMPTY_LINK_ARRAY);
		TERMINALS[83].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[83].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[83].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[83].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[81].addFollower(TERMINALS[85], EMPTY_LINK_ARRAY);
		TERMINALS[85].addFollower(TERMINALS[86], EMPTY_LINK_ARRAY);
		TERMINALS[86].addFollower(TERMINALS[82], EMPTY_LINK_ARRAY);
		TERMINALS[86].addFollower(TERMINALS[83], EMPTY_LINK_ARRAY);
		TERMINALS[52].addFollower(TERMINALS[87], EMPTY_LINK_ARRAY);
		TERMINALS[52].addFollower(TERMINALS[88], EMPTY_LINK_ARRAY);
		TERMINALS[52].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[52].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[52].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[52].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[87].addFollower(TERMINALS[89], EMPTY_LINK_ARRAY);
		TERMINALS[89].addFollower(TERMINALS[90], EMPTY_LINK_ARRAY);
		TERMINALS[89].addFollower(TERMINALS[88], EMPTY_LINK_ARRAY);
		TERMINALS[89].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[89].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[89].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[89].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[90].addFollower(TERMINALS[91], EMPTY_LINK_ARRAY);
		TERMINALS[91].addFollower(TERMINALS[90], EMPTY_LINK_ARRAY);
		TERMINALS[91].addFollower(TERMINALS[88], EMPTY_LINK_ARRAY);
		TERMINALS[91].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), });
		TERMINALS[91].addFollower(TERMINALS[57], EMPTY_LINK_ARRAY);
		TERMINALS[91].addFollower(TERMINALS[56], EMPTY_LINK_ARRAY);
		TERMINALS[91].addFollower(TERMINALS[58], EMPTY_LINK_ARRAY);
		TERMINALS[53].addFollower(TERMINALS[46], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[47], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[48], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[49], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[50], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[51], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[52], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[53], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[54], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
		TERMINALS[53].addFollower(TERMINALS[55], new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature[] {new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), FEATURES[6]), new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsContainedFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), FEATURES[6]), });
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
