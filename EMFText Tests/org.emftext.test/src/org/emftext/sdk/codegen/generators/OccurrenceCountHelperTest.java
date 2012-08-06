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
package org.emftext.sdk.codegen.generators;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.emftext.sdk.codegen.resource.generators.helpers.OccurrenceCountHelper;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;

public class OccurrenceCountHelperTest extends TestCase {

	private static final ConcretesyntaxFactory FACTORY = ConcretesyntaxFactory.eINSTANCE;

	public void testCounting1() {

		GenFeature feature = GenModelFactory.eINSTANCE.createGenFeature();
		Containment containment1 = createContainment(feature);
		Containment containment2 = createContainment(feature);
		
		CsString decision = createCsString("DECISION");
		CsString comma = createCsString(",");
		CsString open = createCsString("(");
		CsString close = createCsString(")");

		Sequence sequence = createRuleBody();

		sequence.getChildren().add(decision);
		sequence.getChildren().add(open);
		sequence.getChildren().add(containment1);
		sequence.getChildren().add(comma);
		sequence.getChildren().add(containment2);
		sequence.getChildren().add(close);
		
		OccurrenceCountHelper helper = new OccurrenceCountHelper();
		
		assertEquals(1, helper.getMandatoryOccurencesAfter(containment1, feature));
		assertEquals(0, helper.getMandatoryOccurencesAfter(containment2, feature));
	}

	public void testCounting2() {

		GenFeature feature = GenModelFactory.eINSTANCE.createGenFeature();
		Containment containment1 = createContainment(feature);
		Containment containment2 = createContainment(feature);
		Containment containment3 = createContainment(feature);
		Containment containment4 = createContainment(feature);
		Containment containment5 = createContainment(feature);
		Containment containment6 = createContainment(feature);
		Containment containment7 = createContainment(feature);
		Containment containment8 = createContainment(feature);
		
		Sequence sequence = createRuleBody();

		sequence.getChildren().add(containment1);
		sequence.getChildren().add(containment2);
		sequence.getChildren().add(containment3);
		sequence.getChildren().add(containment4);
		sequence.getChildren().add(containment5);
		sequence.getChildren().add(containment6);
		sequence.getChildren().add(containment7);
		sequence.getChildren().add(containment8);
		
		OccurrenceCountHelper helper = new OccurrenceCountHelper();
		
		assertEquals(7, helper.getMandatoryOccurencesAfter(containment1, feature));
		assertEquals(6, helper.getMandatoryOccurencesAfter(containment2, feature));
		assertEquals(5, helper.getMandatoryOccurencesAfter(containment3, feature));
		assertEquals(4, helper.getMandatoryOccurencesAfter(containment4, feature));
		assertEquals(3, helper.getMandatoryOccurencesAfter(containment5, feature));
		assertEquals(2, helper.getMandatoryOccurencesAfter(containment6, feature));
		assertEquals(1, helper.getMandatoryOccurencesAfter(containment7, feature));
		assertEquals(0, helper.getMandatoryOccurencesAfter(containment8, feature));
	}

	private Containment createContainment(GenFeature feature) {
		Containment containment = FACTORY.createContainment();
		containment.setFeature(feature);
		return containment;
	}

	private CsString createCsString(String value) {
		CsString csString = FACTORY.createCsString();
		csString.setValue(value);
		return csString;
	}

	private Sequence createRuleBody() {
		Rule rule = FACTORY.createRule();
		
		Sequence sequence = FACTORY.createSequence();

		Choice choice = FACTORY.createChoice();

		choice.getChildren().add(sequence);
		
		rule.getChildren().add(choice);
		return sequence;
	}
}
