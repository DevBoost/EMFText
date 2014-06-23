/*******************************************************************************
 * Copyright (c) 2006-2014
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

package org.emftext.sdk.concretesyntax.resource.cs.grammar;

import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

public class CsGrammarInformationProvider {
	
	public final static EStructuralFeature ANONYMOUS_FEATURE = EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static CsGrammarInformationProvider INSTANCE = new CsGrammarInformationProvider();
	
	private Set<String> keywords;
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_0_0_0_0_0_0_0 = INSTANCE.getCS_0_0_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_0_0_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ANNOTATIONS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_0_0_0_1 = INSTANCE.getCS_0_0_0_0_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_0_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_0_0_0 = INSTANCE.getCS_0_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_0_0_0_0, CS_0_0_0_0_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_0_0 = INSTANCE.getCS_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_0 = INSTANCE.getCS_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_0_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsBooleanTerminal CS_0_0_0_1 = INSTANCE.getCS_0_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsBooleanTerminal getCS_0_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsBooleanTerminal(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__ABSTRACT), "ABSTRACT", "", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_2 = INSTANCE.getCS_0_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("SYNTAXDEF", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_3 = INSTANCE.getCS_0_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_0_0_0_4 = INSTANCE.getCS_0_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_0_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__NAME), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_5 = INSTANCE.getCS_0_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_6 = INSTANCE.getCS_0_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("FOR", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_7 = INSTANCE.getCS_0_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_0_0_0_8 = INSTANCE.getCS_0_0_0_8();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_0_0_0_8() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE), "QUOTED_60_62", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_9_0_0_0 = INSTANCE.getCS_0_0_0_9_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_9_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_0_0_0_9_0_0_1 = INSTANCE.getCS_0_0_0_9_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_0_0_0_9_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT), "QUOTED_60_62", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_9_0_0 = INSTANCE.getCS_0_0_0_9_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_9_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_9_0_0_0, CS_0_0_0_9_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_9_0 = INSTANCE.getCS_0_0_0_9_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_9_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_9_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_9 = INSTANCE.getCS_0_0_0_9();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_9() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_9_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_10 = INSTANCE.getCS_0_0_0_10();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_10() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_11_0_0_0 = INSTANCE.getCS_0_0_0_11_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_11_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("START", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_11_0_0_1 = INSTANCE.getCS_0_0_0_11_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_11_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_0_0_0_11_0_0_2_0_0_0 = INSTANCE.getCS_0_0_0_11_0_0_2_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_0_0_0_11_0_0_2_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_11_0_0_2_0_0 = INSTANCE.getCS_0_0_0_11_0_0_2_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_11_0_0_2_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_11_0_0_2_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_11_0_0_2_0 = INSTANCE.getCS_0_0_0_11_0_0_2_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_11_0_0_2_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_11_0_0_2_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_11_0_0_2 = INSTANCE.getCS_0_0_0_11_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_11_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_11_0_0_2_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_11_0_0_3_0_0_0 = INSTANCE.getCS_0_0_0_11_0_0_3_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_11_0_0_3_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(",", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_0_0_0_11_0_0_3_0_0_1_0_0_0 = INSTANCE.getCS_0_0_0_11_0_0_3_0_0_1_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_0_0_0_11_0_0_3_0_0_1_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__START_SYMBOLS), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_11_0_0_3_0_0_1_0_0 = INSTANCE.getCS_0_0_0_11_0_0_3_0_0_1_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_11_0_0_3_0_0_1_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_11_0_0_3_0_0_1_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_11_0_0_3_0_0_1_0 = INSTANCE.getCS_0_0_0_11_0_0_3_0_0_1_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_11_0_0_3_0_0_1_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_11_0_0_3_0_0_1_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_11_0_0_3_0_0_1 = INSTANCE.getCS_0_0_0_11_0_0_3_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_11_0_0_3_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_11_0_0_3_0_0_1_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_11_0_0_3_0_0 = INSTANCE.getCS_0_0_0_11_0_0_3_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_11_0_0_3_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_11_0_0_3_0_0_0, CS_0_0_0_11_0_0_3_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_11_0_0_3_0 = INSTANCE.getCS_0_0_0_11_0_0_3_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_11_0_0_3_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_11_0_0_3_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_11_0_0_3 = INSTANCE.getCS_0_0_0_11_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_11_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_11_0_0_3_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_11_0_0 = INSTANCE.getCS_0_0_0_11_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_11_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_11_0_0_0, CS_0_0_0_11_0_0_1, CS_0_0_0_11_0_0_2, CS_0_0_0_11_0_0_3);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_11_0 = INSTANCE.getCS_0_0_0_11_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_11_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_11_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_11 = INSTANCE.getCS_0_0_0_11();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_11() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_11_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_12_0_0_0 = INSTANCE.getCS_0_0_0_12_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_12_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_12_0_0_1 = INSTANCE.getCS_0_0_0_12_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_12_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_12_0_0_2 = INSTANCE.getCS_0_0_0_12_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_12_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("IMPORTS", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_12_0_0_3 = INSTANCE.getCS_0_0_0_12_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_12_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_12_0_0_4 = INSTANCE.getCS_0_0_0_12_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_12_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("{", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_12_0_0_5_0_0_0 = INSTANCE.getCS_0_0_0_12_0_0_5_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_12_0_0_5_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_0_0_0_12_0_0_5_0_0_1 = INSTANCE.getCS_0_0_0_12_0_0_5_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_0_0_0_12_0_0_5_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__IMPORTS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_12_0_0_5_0_0 = INSTANCE.getCS_0_0_0_12_0_0_5_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_12_0_0_5_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_12_0_0_5_0_0_0, CS_0_0_0_12_0_0_5_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_12_0_0_5_0 = INSTANCE.getCS_0_0_0_12_0_0_5_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_12_0_0_5_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_12_0_0_5_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_12_0_0_5 = INSTANCE.getCS_0_0_0_12_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_12_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_12_0_0_5_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_12_0_0_6 = INSTANCE.getCS_0_0_0_12_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_12_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_12_0_0_7 = INSTANCE.getCS_0_0_0_12_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_12_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("}", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_12_0_0 = INSTANCE.getCS_0_0_0_12_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_12_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_12_0_0_0, CS_0_0_0_12_0_0_1, CS_0_0_0_12_0_0_2, CS_0_0_0_12_0_0_3, CS_0_0_0_12_0_0_4, CS_0_0_0_12_0_0_5, CS_0_0_0_12_0_0_6, CS_0_0_0_12_0_0_7);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_12_0 = INSTANCE.getCS_0_0_0_12_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_12_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_12_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_12 = INSTANCE.getCS_0_0_0_12();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_12() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_12_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_13_0_0_0 = INSTANCE.getCS_0_0_0_13_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_13_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_13_0_0_1 = INSTANCE.getCS_0_0_0_13_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_13_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_13_0_0_2 = INSTANCE.getCS_0_0_0_13_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_13_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("OPTIONS", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_13_0_0_3 = INSTANCE.getCS_0_0_0_13_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_13_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_13_0_0_4 = INSTANCE.getCS_0_0_0_13_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_13_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("{", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_13_0_0_5_0_0_0 = INSTANCE.getCS_0_0_0_13_0_0_5_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_13_0_0_5_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_0_0_0_13_0_0_5_0_0_1 = INSTANCE.getCS_0_0_0_13_0_0_5_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_0_0_0_13_0_0_5_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__OPTIONS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_13_0_0_5_0_0_2 = INSTANCE.getCS_0_0_0_13_0_0_5_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_13_0_0_5_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(";", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_13_0_0_5_0_0 = INSTANCE.getCS_0_0_0_13_0_0_5_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_13_0_0_5_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_13_0_0_5_0_0_0, CS_0_0_0_13_0_0_5_0_0_1, CS_0_0_0_13_0_0_5_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_13_0_0_5_0 = INSTANCE.getCS_0_0_0_13_0_0_5_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_13_0_0_5_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_13_0_0_5_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_13_0_0_5 = INSTANCE.getCS_0_0_0_13_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_13_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_13_0_0_5_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_13_0_0_6 = INSTANCE.getCS_0_0_0_13_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_13_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_13_0_0_7 = INSTANCE.getCS_0_0_0_13_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_13_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("}", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_13_0_0 = INSTANCE.getCS_0_0_0_13_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_13_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_13_0_0_0, CS_0_0_0_13_0_0_1, CS_0_0_0_13_0_0_2, CS_0_0_0_13_0_0_3, CS_0_0_0_13_0_0_4, CS_0_0_0_13_0_0_5, CS_0_0_0_13_0_0_6, CS_0_0_0_13_0_0_7);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_13_0 = INSTANCE.getCS_0_0_0_13_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_13_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_13_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_13 = INSTANCE.getCS_0_0_0_13();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_13() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_13_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_14_0_0_0 = INSTANCE.getCS_0_0_0_14_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_14_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_14_0_0_1 = INSTANCE.getCS_0_0_0_14_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_14_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_14_0_0_2 = INSTANCE.getCS_0_0_0_14_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_14_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("TOKENS", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_14_0_0_3 = INSTANCE.getCS_0_0_0_14_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_14_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_14_0_0_4 = INSTANCE.getCS_0_0_0_14_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_14_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("{", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_14_0_0_5_0_0_0 = INSTANCE.getCS_0_0_0_14_0_0_5_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_14_0_0_5_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_0_0_0_14_0_0_5_0_0_1 = INSTANCE.getCS_0_0_0_14_0_0_5_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_0_0_0_14_0_0_5_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKENS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenDirective(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_14_0_0_5_0_0_2 = INSTANCE.getCS_0_0_0_14_0_0_5_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_14_0_0_5_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(";", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_14_0_0_5_0_0 = INSTANCE.getCS_0_0_0_14_0_0_5_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_14_0_0_5_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_14_0_0_5_0_0_0, CS_0_0_0_14_0_0_5_0_0_1, CS_0_0_0_14_0_0_5_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_14_0_0_5_0 = INSTANCE.getCS_0_0_0_14_0_0_5_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_14_0_0_5_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_14_0_0_5_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_14_0_0_5 = INSTANCE.getCS_0_0_0_14_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_14_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_14_0_0_5_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_14_0_0_6 = INSTANCE.getCS_0_0_0_14_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_14_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_14_0_0_7 = INSTANCE.getCS_0_0_0_14_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_14_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("}", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_14_0_0 = INSTANCE.getCS_0_0_0_14_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_14_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_14_0_0_0, CS_0_0_0_14_0_0_1, CS_0_0_0_14_0_0_2, CS_0_0_0_14_0_0_3, CS_0_0_0_14_0_0_4, CS_0_0_0_14_0_0_5, CS_0_0_0_14_0_0_6, CS_0_0_0_14_0_0_7);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_14_0 = INSTANCE.getCS_0_0_0_14_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_14_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_14_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_14 = INSTANCE.getCS_0_0_0_14();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_14() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_14_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_15_0_0_0 = INSTANCE.getCS_0_0_0_15_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_15_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_15_0_0_1 = INSTANCE.getCS_0_0_0_15_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_15_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_15_0_0_2 = INSTANCE.getCS_0_0_0_15_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_15_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("TOKENSTYLES", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_15_0_0_3 = INSTANCE.getCS_0_0_0_15_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_15_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_15_0_0_4 = INSTANCE.getCS_0_0_0_15_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_15_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("{", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_15_0_0_5_0_0_0 = INSTANCE.getCS_0_0_0_15_0_0_5_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_15_0_0_5_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_0_0_0_15_0_0_5_0_0_1 = INSTANCE.getCS_0_0_0_15_0_0_5_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_0_0_0_15_0_0_5_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__TOKEN_STYLES), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_15_0_0_5_0_0 = INSTANCE.getCS_0_0_0_15_0_0_5_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_15_0_0_5_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_15_0_0_5_0_0_0, CS_0_0_0_15_0_0_5_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_15_0_0_5_0 = INSTANCE.getCS_0_0_0_15_0_0_5_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_15_0_0_5_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_15_0_0_5_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_15_0_0_5 = INSTANCE.getCS_0_0_0_15_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_15_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_15_0_0_5_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_15_0_0_6 = INSTANCE.getCS_0_0_0_15_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_15_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_15_0_0_7 = INSTANCE.getCS_0_0_0_15_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_15_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("}", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_15_0_0 = INSTANCE.getCS_0_0_0_15_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_15_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_15_0_0_0, CS_0_0_0_15_0_0_1, CS_0_0_0_15_0_0_2, CS_0_0_0_15_0_0_3, CS_0_0_0_15_0_0_4, CS_0_0_0_15_0_0_5, CS_0_0_0_15_0_0_6, CS_0_0_0_15_0_0_7);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_15_0 = INSTANCE.getCS_0_0_0_15_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_15_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_15_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_15 = INSTANCE.getCS_0_0_0_15();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_15() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_15_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_16 = INSTANCE.getCS_0_0_0_16();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_16() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_17 = INSTANCE.getCS_0_0_0_17();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_17() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_18 = INSTANCE.getCS_0_0_0_18();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_18() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("RULES", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_0_0_0_19 = INSTANCE.getCS_0_0_0_19();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_0_0_0_19() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_20 = INSTANCE.getCS_0_0_0_20();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_20() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("{", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_21_0_0_0 = INSTANCE.getCS_0_0_0_21_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_21_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_0_0_0_21_0_0_1 = INSTANCE.getCS_0_0_0_21_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_0_0_0_21_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONCRETE_SYNTAX__RULES), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0_21_0_0 = INSTANCE.getCS_0_0_0_21_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0_21_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_21_0_0_0, CS_0_0_0_21_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0_0_21_0 = INSTANCE.getCS_0_0_0_21_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0_0_21_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_21_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_0_0_0_21 = INSTANCE.getCS_0_0_0_21();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_0_0_0_21() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_0_0_0_21_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_0_0_0_22 = INSTANCE.getCS_0_0_0_22();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_0_0_0_22() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_0_0_0_23 = INSTANCE.getCS_0_0_0_23();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_0_0_0_23() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("}", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_0_0_0 = INSTANCE.getCS_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0_0, CS_0_0_0_1, CS_0_0_0_2, CS_0_0_0_3, CS_0_0_0_4, CS_0_0_0_5, CS_0_0_0_6, CS_0_0_0_7, CS_0_0_0_8, CS_0_0_0_9, CS_0_0_0_10, CS_0_0_0_11, CS_0_0_0_12, CS_0_0_0_13, CS_0_0_0_14, CS_0_0_0_15, CS_0_0_0_16, CS_0_0_0_17, CS_0_0_0_18, CS_0_0_0_19, CS_0_0_0_20, CS_0_0_0_21, CS_0_0_0_22, CS_0_0_0_23);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_0_0 = INSTANCE.getCS_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_0 = INSTANCE.getCS_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getConcreteSyntax(), CS_0_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_1_0_0_0_0_0_0 = INSTANCE.getCS_1_0_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_1_0_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__ANNOTATIONS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_1_0_0_0_0_0_1 = INSTANCE.getCS_1_0_0_0_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_1_0_0_0_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_1_0_0_0_0_0 = INSTANCE.getCS_1_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_1_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_0_0_0_0, CS_1_0_0_0_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_1_0_0_0_0 = INSTANCE.getCS_1_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_1_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_1_0_0_0 = INSTANCE.getCS_1_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_1_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_1_0_0_0_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_1_0_0_1 = INSTANCE.getCS_1_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_1_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PREFIX), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_1_0_0_2 = INSTANCE.getCS_1_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_1_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(":", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_1_0_0_3 = INSTANCE.getCS_1_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_1_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE), "QUOTED_60_62", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_1_0_0_4_0_0_0 = INSTANCE.getCS_1_0_0_4_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_1_0_0_4_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_1_0_0_4_0_0_1 = INSTANCE.getCS_1_0_0_4_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_1_0_0_4_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__PACKAGE_LOCATION_HINT), "QUOTED_60_62", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_1_0_0_4_0_0 = INSTANCE.getCS_1_0_0_4_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_1_0_0_4_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_4_0_0_0, CS_1_0_0_4_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_1_0_0_4_0 = INSTANCE.getCS_1_0_0_4_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_1_0_0_4_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_4_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_1_0_0_4 = INSTANCE.getCS_1_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_1_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_1_0_0_4_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_1_0_0_5_0_0_0 = INSTANCE.getCS_1_0_0_5_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_1_0_0_5_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_1_0_0_5_0_0_1 = INSTANCE.getCS_1_0_0_5_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_1_0_0_5_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("WITH", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_1_0_0_5_0_0_2 = INSTANCE.getCS_1_0_0_5_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_1_0_0_5_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_1_0_0_5_0_0_3 = INSTANCE.getCS_1_0_0_5_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_1_0_0_5_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("SYNTAX", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_1_0_0_5_0_0_4 = INSTANCE.getCS_1_0_0_5_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_1_0_0_5_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_1_0_0_5_0_0_5 = INSTANCE.getCS_1_0_0_5_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_1_0_0_5_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CONCRETE_SYNTAX), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_1_0_0_5_0_0_6_0_0_0 = INSTANCE.getCS_1_0_0_5_0_0_6_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_1_0_0_5_0_0_6_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_1_0_0_5_0_0_6_0_0_1 = INSTANCE.getCS_1_0_0_5_0_0_6_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_1_0_0_5_0_0_6_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.IMPORT__CS_LOCATION_HINT), "QUOTED_60_62", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_1_0_0_5_0_0_6_0_0 = INSTANCE.getCS_1_0_0_5_0_0_6_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_1_0_0_5_0_0_6_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_5_0_0_6_0_0_0, CS_1_0_0_5_0_0_6_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_1_0_0_5_0_0_6_0 = INSTANCE.getCS_1_0_0_5_0_0_6_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_1_0_0_5_0_0_6_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_5_0_0_6_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_1_0_0_5_0_0_6 = INSTANCE.getCS_1_0_0_5_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_1_0_0_5_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_1_0_0_5_0_0_6_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_1_0_0_5_0_0 = INSTANCE.getCS_1_0_0_5_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_1_0_0_5_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_5_0_0_0, CS_1_0_0_5_0_0_1, CS_1_0_0_5_0_0_2, CS_1_0_0_5_0_0_3, CS_1_0_0_5_0_0_4, CS_1_0_0_5_0_0_5, CS_1_0_0_5_0_0_6);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_1_0_0_5_0 = INSTANCE.getCS_1_0_0_5_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_1_0_0_5_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_5_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_1_0_0_5 = INSTANCE.getCS_1_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_1_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_1_0_0_5_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_1_0_0 = INSTANCE.getCS_1_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_1_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0_0, CS_1_0_0_1, CS_1_0_0_2, CS_1_0_0_3, CS_1_0_0_4, CS_1_0_0_5);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_1_0 = INSTANCE.getCS_1_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_1_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_1_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_1 = INSTANCE.getCS_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getImport(), CS_1_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_2_0_0_0 = INSTANCE.getCS_2_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_2_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__TYPE), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_2_0_0_1 = INSTANCE.getCS_2_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_2_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_2_0_0_2 = INSTANCE.getCS_2_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_2_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("=", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_2_0_0_3 = INSTANCE.getCS_2_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_2_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_2_0_0_4 = INSTANCE.getCS_2_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_2_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.OPTION__VALUE), "STRING", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_2_0_0 = INSTANCE.getCS_2_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_2_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_2_0_0_0, CS_2_0_0_1, CS_2_0_0_2, CS_2_0_0_3, CS_2_0_0_4);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_2_0 = INSTANCE.getCS_2_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_2_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_2_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_2 = INSTANCE.getCS_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getOption(), CS_2_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_3_0_0_0_0_0_0 = INSTANCE.getCS_3_0_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_3_0_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__ANNOTATIONS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_3_0_0_0_0_0_1 = INSTANCE.getCS_3_0_0_0_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_3_0_0_0_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_3_0_0_0_0_0 = INSTANCE.getCS_3_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_3_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_3_0_0_0_0_0_0, CS_3_0_0_0_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_3_0_0_0_0 = INSTANCE.getCS_3_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_3_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_3_0_0_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_3_0_0_0 = INSTANCE.getCS_3_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_3_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_3_0_0_0_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_3_0_0_1 = INSTANCE.getCS_3_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_3_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__METACLASS), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_3_0_0_2 = INSTANCE.getCS_3_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_3_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_3_0_0_3 = INSTANCE.getCS_3_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_3_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("::=", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_3_0_0_4 = INSTANCE.getCS_3_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_3_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_3_0_0_5 = INSTANCE.getCS_3_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_3_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.RULE__CHILDREN), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_3_0_0_6 = INSTANCE.getCS_3_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_3_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(";", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_3_0_0 = INSTANCE.getCS_3_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_3_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_3_0_0_0, CS_3_0_0_1, CS_3_0_0_2, CS_3_0_0_3, CS_3_0_0_4, CS_3_0_0_5, CS_3_0_0_6);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_3_0 = INSTANCE.getCS_3_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_3_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_3_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_3 = INSTANCE.getCS_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRule(), CS_3_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_4_0_0_0 = INSTANCE.getCS_4_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_4_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__CHILDREN), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getDefinition(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_4_0_0_1_0_0_0 = INSTANCE.getCS_4_0_0_1_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_4_0_0_1_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_4_0_0_1_0_0_1 = INSTANCE.getCS_4_0_0_1_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_4_0_0_1_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.SEQUENCE__CHILDREN), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getDefinition(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_4_0_0_1_0_0 = INSTANCE.getCS_4_0_0_1_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_4_0_0_1_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_4_0_0_1_0_0_0, CS_4_0_0_1_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_4_0_0_1_0 = INSTANCE.getCS_4_0_0_1_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_4_0_0_1_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_4_0_0_1_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_4_0_0_1 = INSTANCE.getCS_4_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_4_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_4_0_0_1_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_4_0_0 = INSTANCE.getCS_4_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_4_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_4_0_0_0, CS_4_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_4_0 = INSTANCE.getCS_4_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_4_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_4_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_4 = INSTANCE.getCS_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), CS_4_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_5_0_0_0 = INSTANCE.getCS_5_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_5_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__CHILDREN), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_5_0_0_1_0_0_0 = INSTANCE.getCS_5_0_0_1_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_5_0_0_1_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_5_0_0_1_0_0_1 = INSTANCE.getCS_5_0_0_1_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_5_0_0_1_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("|", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_5_0_0_1_0_0_2 = INSTANCE.getCS_5_0_0_1_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_5_0_0_1_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_5_0_0_1_0_0_3 = INSTANCE.getCS_5_0_0_1_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_5_0_0_1_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CHOICE__CHILDREN), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getSequence(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_5_0_0_1_0_0 = INSTANCE.getCS_5_0_0_1_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_5_0_0_1_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_5_0_0_1_0_0_0, CS_5_0_0_1_0_0_1, CS_5_0_0_1_0_0_2, CS_5_0_0_1_0_0_3);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_5_0_0_1_0 = INSTANCE.getCS_5_0_0_1_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_5_0_0_1_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_5_0_0_1_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_5_0_0_1 = INSTANCE.getCS_5_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_5_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_5_0_0_1_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_5_0_0 = INSTANCE.getCS_5_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_5_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_5_0_0_0, CS_5_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_5_0 = INSTANCE.getCS_5_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_5_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_5_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_5 = INSTANCE.getCS_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), CS_5_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_6_0_0_0 = INSTANCE.getCS_6_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_6_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CS_STRING__VALUE), "STRING", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_6_0_0 = INSTANCE.getCS_6_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_6_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_6_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_6_0 = INSTANCE.getCS_6_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_6_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_6_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_6 = INSTANCE.getCS_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCsString(), CS_6_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_7_0_0_0 = INSTANCE.getCS_7_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_7_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_7_0_0_1 = INSTANCE.getCS_7_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_7_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("[", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_7_0_0_2 = INSTANCE.getCS_7_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_7_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_7_0_0_3 = INSTANCE.getCS_7_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_7_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("]", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal CS_7_0_0_4 = INSTANCE.getCS_7_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal getCS_7_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY), new String[] {"none", "", "plus", "+", "star", "*", "questionmark", "?", }, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_7_0_0 = INSTANCE.getCS_7_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_7_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_7_0_0_0, CS_7_0_0_1, CS_7_0_0_2, CS_7_0_0_3, CS_7_0_0_4);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_7_0 = INSTANCE.getCS_7_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_7_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_7_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_7 = INSTANCE.getCS_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingSpecifiedToken(), CS_7_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_8_0_0_0 = INSTANCE.getCS_8_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_8_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_8_0_0_1 = INSTANCE.getCS_8_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_8_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("[", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_8_0_0_2 = INSTANCE.getCS_8_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_8_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("]", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal CS_8_0_0_3 = INSTANCE.getCS_8_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal getCS_8_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY), new String[] {"none", "", "plus", "+", "star", "*", "questionmark", "?", }, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_8_0_0 = INSTANCE.getCS_8_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_8_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_8_0_0_0, CS_8_0_0_1, CS_8_0_0_2, CS_8_0_0_3);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_8_0 = INSTANCE.getCS_8_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_8_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_8_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_8 = INSTANCE.getCS_8();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_8() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderUsingDefaultToken(), CS_8_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_9_0_0_0 = INSTANCE.getCS_9_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_9_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__FEATURE), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_9_0_0_1 = INSTANCE.getCS_9_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_9_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("[", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_9_0_0_2 = INSTANCE.getCS_9_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_9_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__PREFIX), "QUOTED_39_39_92", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_9_0_0_3 = INSTANCE.getCS_9_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_9_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(",", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_9_0_0_4 = INSTANCE.getCS_9_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_9_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__SUFFIX), "QUOTED_39_39_92", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_9_0_0_5_0_0_0 = INSTANCE.getCS_9_0_0_5_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_9_0_0_5_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(",", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_9_0_0_5_0_0_1 = INSTANCE.getCS_9_0_0_5_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_9_0_0_5_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER), "QUOTED_39_39_92", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_9_0_0_5_0_0 = INSTANCE.getCS_9_0_0_5_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_9_0_0_5_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_9_0_0_5_0_0_0, CS_9_0_0_5_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_9_0_0_5_0 = INSTANCE.getCS_9_0_0_5_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_9_0_0_5_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_9_0_0_5_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_9_0_0_5 = INSTANCE.getCS_9_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_9_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_9_0_0_5_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_9_0_0_6 = INSTANCE.getCS_9_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_9_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("]", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal CS_9_0_0_7 = INSTANCE.getCS_9_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal getCS_9_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PLACEHOLDER_IN_QUOTES__CARDINALITY), new String[] {"none", "", "plus", "+", "star", "*", "questionmark", "?", }, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_9_0_0 = INSTANCE.getCS_9_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_9_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_9_0_0_0, CS_9_0_0_1, CS_9_0_0_2, CS_9_0_0_3, CS_9_0_0_4, CS_9_0_0_5, CS_9_0_0_6, CS_9_0_0_7);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_9_0 = INSTANCE.getCS_9_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_9_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_9_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_9 = INSTANCE.getCS_9();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_9() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPlaceholderInQuotes(), CS_9_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_10_0_0_0 = INSTANCE.getCS_10_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_10_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FEATURE), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_10_0_0_1 = INSTANCE.getCS_10_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_10_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("[", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_10_0_0_2 = INSTANCE.getCS_10_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_10_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL), "STRING", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_10_0_0_3 = INSTANCE.getCS_10_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_10_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_10_0_0_4 = INSTANCE.getCS_10_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_10_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(":", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_10_0_0_5 = INSTANCE.getCS_10_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_10_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_10_0_0_6 = INSTANCE.getCS_10_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_10_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL), "STRING", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_10_0_0_7 = INSTANCE.getCS_10_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_10_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("]", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal CS_10_0_0_8 = INSTANCE.getCS_10_0_0_8();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal getCS_10_0_0_8() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.BOOLEAN_TERMINAL__CARDINALITY), new String[] {"none", "", "plus", "+", "star", "*", "questionmark", "?", }, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_10_0_0 = INSTANCE.getCS_10_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_10_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_10_0_0_0, CS_10_0_0_1, CS_10_0_0_2, CS_10_0_0_3, CS_10_0_0_4, CS_10_0_0_5, CS_10_0_0_6, CS_10_0_0_7, CS_10_0_0_8);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_10_0 = INSTANCE.getCS_10_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_10_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_10_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_10 = INSTANCE.getCS_10();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_10() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal(), CS_10_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_11_0_0_0 = INSTANCE.getCS_11_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_11_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__FEATURE), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_11_0_0_1 = INSTANCE.getCS_11_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_11_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("[", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_11_0_0_2 = INSTANCE.getCS_11_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_11_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_11_0_0_3_0_0_0 = INSTANCE.getCS_11_0_0_3_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_11_0_0_3_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(",", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_11_0_0_3_0_0_1 = INSTANCE.getCS_11_0_0_3_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_11_0_0_3_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_11_0_0_3_0_0_2 = INSTANCE.getCS_11_0_0_3_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_11_0_0_3_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__LITERALS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_11_0_0_3_0_0 = INSTANCE.getCS_11_0_0_3_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_11_0_0_3_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_11_0_0_3_0_0_0, CS_11_0_0_3_0_0_1, CS_11_0_0_3_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_11_0_0_3_0 = INSTANCE.getCS_11_0_0_3_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_11_0_0_3_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_11_0_0_3_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_11_0_0_3 = INSTANCE.getCS_11_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_11_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_11_0_0_3_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_11_0_0_4 = INSTANCE.getCS_11_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_11_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("]", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal CS_11_0_0_5 = INSTANCE.getCS_11_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal getCS_11_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_TERMINAL__CARDINALITY), new String[] {"none", "", "plus", "+", "star", "*", "questionmark", "?", }, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_11_0_0 = INSTANCE.getCS_11_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_11_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_11_0_0_0, CS_11_0_0_1, CS_11_0_0_2, CS_11_0_0_3, CS_11_0_0_4, CS_11_0_0_5);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_11_0 = INSTANCE.getCS_11_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_11_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_11_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_11 = INSTANCE.getCS_11();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_11() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumTerminal(), CS_11_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_12_0_0_0 = INSTANCE.getCS_12_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_12_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__LITERAL), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_12_0_0_1 = INSTANCE.getCS_12_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_12_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(":", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_12_0_0_2 = INSTANCE.getCS_12_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_12_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ENUM_LITERAL_TERMINAL__TEXT), "STRING", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_12_0_0 = INSTANCE.getCS_12_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_12_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_12_0_0_0, CS_12_0_0_1, CS_12_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_12_0 = INSTANCE.getCS_12_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_12_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_12_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_12 = INSTANCE.getCS_12();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_12() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getEnumLiteralTerminal(), CS_12_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_13_0_0_0 = INSTANCE.getCS_13_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_13_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__FEATURE), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_13_0_0_1_0_0_0 = INSTANCE.getCS_13_0_0_1_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_13_0_0_1_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(":", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_13_0_0_1_0_0_1 = INSTANCE.getCS_13_0_0_1_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_13_0_0_1_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_13_0_0_1_0_0_2_0_0_0 = INSTANCE.getCS_13_0_0_1_0_0_2_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_13_0_0_1_0_0_2_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(",", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_13_0_0_1_0_0_2_0_0_1 = INSTANCE.getCS_13_0_0_1_0_0_2_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_13_0_0_1_0_0_2_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__TYPES), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_13_0_0_1_0_0_2_0_0 = INSTANCE.getCS_13_0_0_1_0_0_2_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_13_0_0_1_0_0_2_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_13_0_0_1_0_0_2_0_0_0, CS_13_0_0_1_0_0_2_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_13_0_0_1_0_0_2_0 = INSTANCE.getCS_13_0_0_1_0_0_2_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_13_0_0_1_0_0_2_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_13_0_0_1_0_0_2_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_13_0_0_1_0_0_2 = INSTANCE.getCS_13_0_0_1_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_13_0_0_1_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_13_0_0_1_0_0_2_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_13_0_0_1_0_0 = INSTANCE.getCS_13_0_0_1_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_13_0_0_1_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_13_0_0_1_0_0_0, CS_13_0_0_1_0_0_1, CS_13_0_0_1_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_13_0_0_1_0 = INSTANCE.getCS_13_0_0_1_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_13_0_0_1_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_13_0_0_1_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_13_0_0_1 = INSTANCE.getCS_13_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_13_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_13_0_0_1_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal CS_13_0_0_2 = INSTANCE.getCS_13_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal getCS_13_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.CONTAINMENT__CARDINALITY), new String[] {"none", "", "plus", "+", "star", "*", "questionmark", "?", }, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_13_0_0 = INSTANCE.getCS_13_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_13_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_13_0_0_0, CS_13_0_0_1, CS_13_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_13_0 = INSTANCE.getCS_13_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_13_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_13_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_13 = INSTANCE.getCS_13();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_13() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getContainment(), CS_13_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_14_0_0_0 = INSTANCE.getCS_14_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_14_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("(", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_14_0_0_1 = INSTANCE.getCS_14_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_14_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CHILDREN), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getChoice(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_14_0_0_2 = INSTANCE.getCS_14_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_14_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(")", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal CS_14_0_0_3 = INSTANCE.getCS_14_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal getCS_14_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.COMPOUND_DEFINITION__CARDINALITY), new String[] {"none", "", "plus", "+", "star", "*", "questionmark", "?", }, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_14_0_0 = INSTANCE.getCS_14_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_14_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_14_0_0_0, CS_14_0_0_1, CS_14_0_0_2, CS_14_0_0_3);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_14_0 = INSTANCE.getCS_14_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_14_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_14_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_14 = INSTANCE.getCS_14();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_14() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getCompoundDefinition(), CS_14_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_15_0_0_0 = INSTANCE.getCS_15_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_15_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.WHITE_SPACES__AMOUNT), "HEXNUMBER", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_15_0_0 = INSTANCE.getCS_15_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_15_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_15_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_15_0 = INSTANCE.getCS_15_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_15_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_15_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_15 = INSTANCE.getCS_15();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_15() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getWhiteSpaces(), CS_15_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_16_0_0_0 = INSTANCE.getCS_16_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_16_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.LINE_BREAK__TAB), "TABNUMBER", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_16_0_0 = INSTANCE.getCS_16_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_16_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_16_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_16_0 = INSTANCE.getCS_16_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_16_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_16_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_16 = INSTANCE.getCS_16();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_16() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getLineBreak(), CS_16_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_17_0_0_0_0_0_0 = INSTANCE.getCS_17_0_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_17_0_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__ANNOTATIONS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_17_0_0_0_0_0_1 = INSTANCE.getCS_17_0_0_0_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_17_0_0_0_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_17_0_0_0_0_0 = INSTANCE.getCS_17_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_17_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_17_0_0_0_0_0_0, CS_17_0_0_0_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_17_0_0_0_0 = INSTANCE.getCS_17_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_17_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_17_0_0_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_17_0_0_0 = INSTANCE.getCS_17_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_17_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_17_0_0_0_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_17_0_0_1 = INSTANCE.getCS_17_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_17_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("REDEFINE", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_17_0_0_2 = INSTANCE.getCS_17_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_17_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_17_0_0_3 = INSTANCE.getCS_17_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_17_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REDEFINED_TOKEN), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_17_0_0_4 = INSTANCE.getCS_17_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_17_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("AS", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_17_0_0_5 = INSTANCE.getCS_17_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_17_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__NAME), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_17_0_0_6 = INSTANCE.getCS_17_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_17_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_17_0_0_7 = INSTANCE.getCS_17_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_17_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexPart(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_17_0_0_8_0_0_0 = INSTANCE.getCS_17_0_0_8_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_17_0_0_8_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_17_0_0_8_0_0_1 = INSTANCE.getCS_17_0_0_8_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_17_0_0_8_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("+", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_17_0_0_8_0_0_2 = INSTANCE.getCS_17_0_0_8_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_17_0_0_8_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_17_0_0_8_0_0_3 = INSTANCE.getCS_17_0_0_8_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_17_0_0_8_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_REDEFINITION__REGEX_PARTS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexPart(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_17_0_0_8_0_0 = INSTANCE.getCS_17_0_0_8_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_17_0_0_8_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_17_0_0_8_0_0_0, CS_17_0_0_8_0_0_1, CS_17_0_0_8_0_0_2, CS_17_0_0_8_0_0_3);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_17_0_0_8_0 = INSTANCE.getCS_17_0_0_8_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_17_0_0_8_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_17_0_0_8_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_17_0_0_8 = INSTANCE.getCS_17_0_0_8();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_17_0_0_8() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_17_0_0_8_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_17_0_0 = INSTANCE.getCS_17_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_17_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_17_0_0_0, CS_17_0_0_1, CS_17_0_0_2, CS_17_0_0_3, CS_17_0_0_4, CS_17_0_0_5, CS_17_0_0_6, CS_17_0_0_7, CS_17_0_0_8);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_17_0 = INSTANCE.getCS_17_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_17_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_17_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_17 = INSTANCE.getCS_17();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_17() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenRedefinition(), CS_17_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_18_0_0_0_0_0_0 = INSTANCE.getCS_18_0_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_18_0_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ANNOTATIONS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak CS_18_0_0_0_0_0_1 = INSTANCE.getCS_18_0_0_0_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak getCS_18_0_0_0_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsLineBreak(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_18_0_0_0_0_0 = INSTANCE.getCS_18_0_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_18_0_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_18_0_0_0_0_0_0, CS_18_0_0_0_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_18_0_0_0_0 = INSTANCE.getCS_18_0_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_18_0_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_18_0_0_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_18_0_0_0 = INSTANCE.getCS_18_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_18_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_18_0_0_0_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_18_0_0_1 = INSTANCE.getCS_18_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_18_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("DEFINE", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_18_0_0_2 = INSTANCE.getCS_18_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_18_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_18_0_0_3 = INSTANCE.getCS_18_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_18_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__NAME), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_18_0_0_4 = INSTANCE.getCS_18_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_18_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_18_0_0_5 = INSTANCE.getCS_18_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_18_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexPart(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_18_0_0_6_0_0_0 = INSTANCE.getCS_18_0_0_6_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_18_0_0_6_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_18_0_0_6_0_0_1 = INSTANCE.getCS_18_0_0_6_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_18_0_0_6_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("+", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_18_0_0_6_0_0_2 = INSTANCE.getCS_18_0_0_6_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_18_0_0_6_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_18_0_0_6_0_0_3 = INSTANCE.getCS_18_0_0_6_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_18_0_0_6_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__REGEX_PARTS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexPart(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_18_0_0_6_0_0 = INSTANCE.getCS_18_0_0_6_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_18_0_0_6_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_18_0_0_6_0_0_0, CS_18_0_0_6_0_0_1, CS_18_0_0_6_0_0_2, CS_18_0_0_6_0_0_3);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_18_0_0_6_0 = INSTANCE.getCS_18_0_0_6_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_18_0_0_6_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_18_0_0_6_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_18_0_0_6 = INSTANCE.getCS_18_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_18_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_18_0_0_6_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_18_0_0_7_0_0_0 = INSTANCE.getCS_18_0_0_7_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_18_0_0_7_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_18_0_0_7_0_0_1 = INSTANCE.getCS_18_0_0_7_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_18_0_0_7_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("COLLECT", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_18_0_0_7_0_0_2 = INSTANCE.getCS_18_0_0_7_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_18_0_0_7_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_18_0_0_7_0_0_3 = INSTANCE.getCS_18_0_0_7_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_18_0_0_7_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("IN", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_18_0_0_7_0_0_4 = INSTANCE.getCS_18_0_0_7_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_18_0_0_7_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_18_0_0_7_0_0_5 = INSTANCE.getCS_18_0_0_7_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_18_0_0_7_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_18_0_0_7_0_0 = INSTANCE.getCS_18_0_0_7_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_18_0_0_7_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_18_0_0_7_0_0_0, CS_18_0_0_7_0_0_1, CS_18_0_0_7_0_0_2, CS_18_0_0_7_0_0_3, CS_18_0_0_7_0_0_4, CS_18_0_0_7_0_0_5);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_18_0_0_7_0 = INSTANCE.getCS_18_0_0_7_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_18_0_0_7_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_18_0_0_7_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_18_0_0_7 = INSTANCE.getCS_18_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_18_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_18_0_0_7_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_18_0_0 = INSTANCE.getCS_18_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_18_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_18_0_0_0, CS_18_0_0_1, CS_18_0_0_2, CS_18_0_0_3, CS_18_0_0_4, CS_18_0_0_5, CS_18_0_0_6, CS_18_0_0_7);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_18_0 = INSTANCE.getCS_18_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_18_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_18_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_18 = INSTANCE.getCS_18();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_18() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getNormalTokenDefinition(), CS_18_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_19_0_0_0 = INSTANCE.getCS_19_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_19_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("DEFINE", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_19_0_0_1 = INSTANCE.getCS_19_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_19_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_19_0_0_2 = INSTANCE.getCS_19_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_19_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("FRAGMENT", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_19_0_0_3 = INSTANCE.getCS_19_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_19_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_19_0_0_4 = INSTANCE.getCS_19_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_19_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__NAME), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_19_0_0_5 = INSTANCE.getCS_19_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_19_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_19_0_0_6 = INSTANCE.getCS_19_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_19_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__REGEX_PARTS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexPart(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_19_0_0_7_0_0_0 = INSTANCE.getCS_19_0_0_7_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_19_0_0_7_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_19_0_0_7_0_0_1 = INSTANCE.getCS_19_0_0_7_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_19_0_0_7_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("+", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_19_0_0_7_0_0_2 = INSTANCE.getCS_19_0_0_7_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_19_0_0_7_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_19_0_0_7_0_0_3 = INSTANCE.getCS_19_0_0_7_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_19_0_0_7_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.PARTIAL_TOKEN_DEFINITION__REGEX_PARTS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexPart(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_19_0_0_7_0_0 = INSTANCE.getCS_19_0_0_7_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_19_0_0_7_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_19_0_0_7_0_0_0, CS_19_0_0_7_0_0_1, CS_19_0_0_7_0_0_2, CS_19_0_0_7_0_0_3);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_19_0_0_7_0 = INSTANCE.getCS_19_0_0_7_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_19_0_0_7_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_19_0_0_7_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_19_0_0_7 = INSTANCE.getCS_19_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_19_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_19_0_0_7_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_19_0_0 = INSTANCE.getCS_19_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_19_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_19_0_0_0, CS_19_0_0_1, CS_19_0_0_2, CS_19_0_0_3, CS_19_0_0_4, CS_19_0_0_5, CS_19_0_0_6, CS_19_0_0_7);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_19_0 = INSTANCE.getCS_19_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_19_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_19_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_19 = INSTANCE.getCS_19();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_19() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getPartialTokenDefinition(), CS_19_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_20_0_0_0 = INSTANCE.getCS_20_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_20_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("PRIORITIZE", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_20_0_0_1 = INSTANCE.getCS_20_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_20_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_20_0_0_2 = INSTANCE.getCS_20_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_20_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_PRIORITY_DIRECTIVE__TOKEN), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_20_0_0 = INSTANCE.getCS_20_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_20_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_20_0_0_0, CS_20_0_0_1, CS_20_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_20_0 = INSTANCE.getCS_20_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_20_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_20_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_20 = INSTANCE.getCS_20();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_20() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenPriorityDirective(), CS_20_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_21_0_0_0 = INSTANCE.getCS_21_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_21_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ATOMIC_REGEX__ATOMIC_EXPRESSION), "QUOTED_36_36", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_21_0_0 = INSTANCE.getCS_21_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_21_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_21_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_21_0 = INSTANCE.getCS_21_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_21_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_21_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_21 = INSTANCE.getCS_21();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_21() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAtomicRegex(), CS_21_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_22_0_0_0 = INSTANCE.getCS_22_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_22_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.REGEX_REFERENCE__TARGET), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_22_0_0 = INSTANCE.getCS_22_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_22_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_22_0_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_22_0 = INSTANCE.getCS_22_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_22_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_22_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_22 = INSTANCE.getCS_22();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_22() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getRegexReference(), CS_22_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_23_0_0_0 = INSTANCE.getCS_23_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_23_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES), "STRING", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_23_0_0_1_0_0_0 = INSTANCE.getCS_23_0_0_1_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_23_0_0_1_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(",", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_23_0_0_1_0_0_1 = INSTANCE.getCS_23_0_0_1_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_23_0_0_1_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_23_0_0_1_0_0_2 = INSTANCE.getCS_23_0_0_1_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_23_0_0_1_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__TOKEN_NAMES), "STRING", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_23_0_0_1_0_0 = INSTANCE.getCS_23_0_0_1_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_23_0_0_1_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_23_0_0_1_0_0_0, CS_23_0_0_1_0_0_1, CS_23_0_0_1_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_23_0_0_1_0 = INSTANCE.getCS_23_0_0_1_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_23_0_0_1_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_23_0_0_1_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_23_0_0_1 = INSTANCE.getCS_23_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_23_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_23_0_0_1_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_23_0_0_2 = INSTANCE.getCS_23_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_23_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_23_0_0_3 = INSTANCE.getCS_23_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_23_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("COLOR", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_23_0_0_4 = INSTANCE.getCS_23_0_0_4();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_23_0_0_4() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_23_0_0_5 = INSTANCE.getCS_23_0_0_5();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_23_0_0_5() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__RGB), "HEXNUMBER", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_23_0_0_6_0_0_0 = INSTANCE.getCS_23_0_0_6_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_23_0_0_6_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(",", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace CS_23_0_0_6_0_0_1 = INSTANCE.getCS_23_0_0_6_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace getCS_23_0_0_6_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsWhiteSpace(1, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_23_0_0_6_0_0_2 = INSTANCE.getCS_23_0_0_6_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_23_0_0_6_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.TOKEN_STYLE__FONT_STYLES), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_23_0_0_6_0_0 = INSTANCE.getCS_23_0_0_6_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_23_0_0_6_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_23_0_0_6_0_0_0, CS_23_0_0_6_0_0_1, CS_23_0_0_6_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_23_0_0_6_0 = INSTANCE.getCS_23_0_0_6_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_23_0_0_6_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_23_0_0_6_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_23_0_0_6 = INSTANCE.getCS_23_0_0_6();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_23_0_0_6() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_23_0_0_6_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_23_0_0_7 = INSTANCE.getCS_23_0_0_7();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_23_0_0_7() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(";", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_23_0_0 = INSTANCE.getCS_23_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_23_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_23_0_0_0, CS_23_0_0_1, CS_23_0_0_2, CS_23_0_0_3, CS_23_0_0_4, CS_23_0_0_5, CS_23_0_0_6, CS_23_0_0_7);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_23_0 = INSTANCE.getCS_23_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_23_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_23_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_23 = INSTANCE.getCS_23();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_23() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getTokenStyle(), CS_23_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_24_0_0_0 = INSTANCE.getCS_24_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_24_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("@", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_24_0_0_1 = INSTANCE.getCS_24_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_24_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__TYPE), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_24_0_0_2_0_0_0 = INSTANCE.getCS_24_0_0_2_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_24_0_0_2_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("(", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_24_0_0_2_0_0_1 = INSTANCE.getCS_24_0_0_2_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_24_0_0_2_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_24_0_0_2_0_0_2_0_0_0 = INSTANCE.getCS_24_0_0_2_0_0_2_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_24_0_0_2_0_0_2_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(",", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment CS_24_0_0_2_0_0_2_0_0_1 = INSTANCE.getCS_24_0_0_2_0_0_2_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment getCS_24_0_0_2_0_0_2_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsContainment(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.ANNOTATION__PARAMETERS), org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, new EClass[] {org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), }, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_24_0_0_2_0_0_2_0_0 = INSTANCE.getCS_24_0_0_2_0_0_2_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_24_0_0_2_0_0_2_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_24_0_0_2_0_0_2_0_0_0, CS_24_0_0_2_0_0_2_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_24_0_0_2_0_0_2_0 = INSTANCE.getCS_24_0_0_2_0_0_2_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_24_0_0_2_0_0_2_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_24_0_0_2_0_0_2_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_24_0_0_2_0_0_2 = INSTANCE.getCS_24_0_0_2_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_24_0_0_2_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_24_0_0_2_0_0_2_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.STAR);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_24_0_0_2_0_0_3 = INSTANCE.getCS_24_0_0_2_0_0_3();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_24_0_0_2_0_0_3() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword(")", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_24_0_0_2_0_0 = INSTANCE.getCS_24_0_0_2_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_24_0_0_2_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_24_0_0_2_0_0_0, CS_24_0_0_2_0_0_1, CS_24_0_0_2_0_0_2, CS_24_0_0_2_0_0_3);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_24_0_0_2_0 = INSTANCE.getCS_24_0_0_2_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_24_0_0_2_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_24_0_0_2_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_24_0_0_2 = INSTANCE.getCS_24_0_0_2();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_24_0_0_2() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_24_0_0_2_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_24_0_0 = INSTANCE.getCS_24_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_24_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_24_0_0_0, CS_24_0_0_1, CS_24_0_0_2);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_24_0 = INSTANCE.getCS_24_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_24_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_24_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_24 = INSTANCE.getCS_24();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_24() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getAnnotation(), CS_24_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_25_0_0_0 = INSTANCE.getCS_25_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_25_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__KEY), "QUALIFIED_NAME", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword CS_25_0_0_1_0_0_0 = INSTANCE.getCS_25_0_0_1_0_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword getCS_25_0_0_1_0_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword("=", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder CS_25_0_0_1_0_0_1 = INSTANCE.getCS_25_0_0_1_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder getCS_25_0_0_1_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsPlaceholder(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair().getEStructuralFeature(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.KEY_VALUE_PAIR__VALUE), "STRING", org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, 0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_25_0_0_1_0_0 = INSTANCE.getCS_25_0_0_1_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_25_0_0_1_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_25_0_0_1_0_0_0, CS_25_0_0_1_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_25_0_0_1_0 = INSTANCE.getCS_25_0_0_1_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_25_0_0_1_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_25_0_0_1_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound CS_25_0_0_1 = INSTANCE.getCS_25_0_0_1();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound getCS_25_0_0_1() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCompound(CS_25_0_0_1_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.QUESTIONMARK);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence CS_25_0_0 = INSTANCE.getCS_25_0_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence getCS_25_0_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSequence(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_25_0_0_0, CS_25_0_0_1);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice CS_25_0 = INSTANCE.getCS_25_0();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getCS_25_0() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE, CS_25_0_0);
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule CS_25 = INSTANCE.getCS_25();
	private org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule getCS_25() {
		return new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule(org.emftext.sdk.concretesyntax.ConcretesyntaxPackage.eINSTANCE.getKeyValuePair(), CS_25_0, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality.ONE);
	}
	
	
	public static String getSyntaxElementID(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (Field field : org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement) org.emftext.sdk.concretesyntax.resource.cs.grammar.CsGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule[] RULES = new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule[] {
		CS_0,
		CS_1,
		CS_2,
		CS_3,
		CS_4,
		CS_5,
		CS_6,
		CS_7,
		CS_8,
		CS_9,
		CS_10,
		CS_11,
		CS_12,
		CS_13,
		CS_14,
		CS_15,
		CS_16,
		CS_17,
		CS_18,
		CS_19,
		CS_20,
		CS_21,
		CS_22,
		CS_23,
		CS_24,
		CS_25,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new LinkedHashSet<String>();
			for (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement element, Set<String> keywords) {
		if (element instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword) {
			keywords.add(((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsKeyword) element).getValue());
		} else if (element instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsBooleanTerminal) {
			keywords.add(((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.sdk.concretesyntax.resource.cs.grammar.CsBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal) {
			org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal terminal = (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
