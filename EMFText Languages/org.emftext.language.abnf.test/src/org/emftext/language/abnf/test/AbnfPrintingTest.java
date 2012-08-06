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
package org.emftext.language.abnf.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.abnf.AbnfFactory;
import org.emftext.language.abnf.Concatenation;
import org.emftext.language.abnf.Repetition;
import org.emftext.language.abnf.Rule;
import org.emftext.language.abnf.RuleReference;
import org.emftext.language.abnf.resource.abnf.mopp.AbnfMetaInformation;
import org.emftext.language.abnf.resource.abnf.util.AbnfStreamUtil;
import org.junit.Ignore;
import org.junit.Test;

public class AbnfPrintingTest extends TestCase {
	
	private static final String FILE_EXTENSION = new AbnfMetaInformation().getSyntaxName();
	private static final AbnfFactory FACTORY = AbnfFactory.eINSTANCE;

	public void setUp() {
		new AbnfMetaInformation().registerResourceFactory();
	}
	
	@Ignore
	public void testPrinting2() {
		Rule rule1 = FACTORY.createRule();
		rule1.setName("rule1");
		Rule rule2 = FACTORY.createRule();
		rule2.setName("rule2");
		
		RuleReference rule1Ref = FACTORY.createRuleReference();
		rule1Ref.setRule(rule1);
		RuleReference rule2Ref = FACTORY.createRuleReference();
		rule2Ref.setRule(rule2);
		
		Repetition repetition1 = FACTORY.createRepetition();
		repetition1.setElement(rule1Ref);
		Repetition repetition2 = FACTORY.createRepetition();
		repetition2.setElement(rule2Ref);
		
		Concatenation concatenation = FACTORY.createConcatenation();
		concatenation.getRepetition().add(repetition1);
		concatenation.getRepetition().add(repetition2);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			new AbnfMetaInformation().createPrinter(outputStream, null).print(concatenation);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		String printResult = outputStream.toString();
		assertEquals("rule1 rule2", printResult);
	}

	@Ignore
	public void testPrinting3() {
		testPrinting("rule1=rule1 rule1\n");
	}

	@Test
	public void testWhitespacePrinting1() {
		testPrinting("rule1    =    rule1 rule1\n");
	}

	@Test
	public void testWhitespacePrinting2() {
		testPrinting("rule1    =    1* rule1 rule1\n");
	}

	@Test
	public void testWhitespacePrinting3() {
		testPrinting("rule1 = rule1 / rule1    / rule1\n");
	}

	@Test
	public void testHexPrinting1() {
		testPrinting("rule1 = %x14\n");
	}

	@Test
	public void testHexPrinting2() {
		testPrinting("rule1 = %x14-20\n");
	}

	@Ignore
	public void testPrinting1() {
		testPrinting(new File("." + File.separator + "input" + File.separator + "abnf.abnf"));
	}

	private void testPrinting(File inputFile) {
		String input = null;
		try {
			input = AbnfStreamUtil.getContent(new FileInputStream(inputFile));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		testPrinting(input);
	}

	private void testPrinting(String input) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("bug1408." + FILE_EXTENSION));
		try {
			resource.load(new ByteArrayInputStream(input.getBytes()), Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EList<EObject> contents = resource.getContents();
		assertNotNull(contents);
		assertEquals(1, contents.size());
		
		// print document
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		String printResult = outputStream.toString();
		// Attention: We need to ignore whitespace after '%x', because
		// there is an explicit choice in the syntax which cannot be 
		// recovered by the printer
		printResult = printResult.replace("%x ", "%x");
		printResult = printResult.replace("- ", "-");
		System.out.println("RESULT OF PRINTING ==>" + printResult + "<==");
		assertEquals(input, printResult);
	}
}
