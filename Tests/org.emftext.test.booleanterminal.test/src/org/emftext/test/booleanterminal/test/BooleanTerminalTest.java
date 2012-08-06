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
package org.emftext.test.booleanterminal.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.test.booleanterminal.BooleanterminalPackage;
import org.emftext.test.booleanterminal.resource.booleanterminal.IBooleanterminalTextResource;
import org.emftext.test.booleanterminal.resource.booleanterminal.mopp.BooleanterminalMetaInformation;
import org.emftext.test.booleanterminal.resource.booleanterminal.mopp.BooleanterminalResourceFactory;
import org.emftext.test.booleanterminal.resource.booleanterminal.ui.BooleanterminalCodeCompletionHelper;
import org.emftext.test.booleanterminal.resource.booleanterminal.ui.BooleanterminalCompletionProposal;

public class BooleanTerminalTest extends TestCase {

	private static final Boolean FALSE = Boolean.FALSE;
	private static final Boolean TRUE = Boolean.TRUE;
	private static final BooleanterminalPackage BT_PACKAGE = BooleanterminalPackage.eINSTANCE;
	private static final Enumerator BLUE = BT_PACKAGE.getEnum1().getEEnumLiteral("blue").getInstance();
	private static final Enumerator GREEN = BT_PACKAGE.getEnum1().getEEnumLiteral("green").getInstance();
	private static final Enumerator RED = BT_PACKAGE.getEnum1().getEEnumLiteral("red").getInstance();
	private static final String SYNTAX_NAME = new BooleanterminalMetaInformation().getSyntaxName();

	public void setUp() {
		new BooleanterminalMetaInformation().registerResourceFactory();
	}
	
	public void testParsing() {
		// test boolean literals
		assertParsing("a yes;", BT_PACKAGE.getClassA(), TRUE);
		assertParsing("a no;", BT_PACKAGE.getClassA(), FALSE);
		assertParsing("b;", BT_PACKAGE.getClassB(), TRUE);
		assertParsing("b no;", BT_PACKAGE.getClassB(), FALSE);
		assertParsing("c yes;", BT_PACKAGE.getClassC(), TRUE);
		assertParsing("c;", BT_PACKAGE.getClassC(), FALSE);
		
		// test enumeration literals
		assertParsing("d r", BT_PACKAGE.getClassD(), RED);
		assertParsing("d g", BT_PACKAGE.getClassD(), GREEN);
		assertParsing("d b", BT_PACKAGE.getClassD(), BLUE);

		assertParsing("e r", BT_PACKAGE.getClassE(), RED);
		assertParsing("e g", BT_PACKAGE.getClassE(), GREEN);
		assertParsing("e", BT_PACKAGE.getClassE(), BLUE);
	}
	
	public void testCodeCompletion() {
		BooleanterminalCodeCompletionHelper helper = new BooleanterminalCodeCompletionHelper();
		URI uri = URI.createURI("temp." + SYNTAX_NAME);
		IBooleanterminalTextResource resource = (IBooleanterminalTextResource) new BooleanterminalResourceFactory().createResource(uri);
		BooleanterminalCompletionProposal[] proposals = helper.computeCompletionProposals(resource, "d ", 2);
		assertEquals(3, proposals.length);
		assertEquals("b", proposals[0].getInsertString());
		assertEquals("g", proposals[1].getInsertString());
		assertEquals("r", proposals[2].getInsertString());
	}

	public void testPrinting() {
		// test boolean literals
		assertPrinting("ayes;", BT_PACKAGE.getClassA(), TRUE);
		assertPrinting("ano;", BT_PACKAGE.getClassA(), FALSE);
		assertPrinting("b;", BT_PACKAGE.getClassB(), TRUE);
		assertPrinting("bno;", BT_PACKAGE.getClassB(), FALSE);
		assertPrinting("cyes;", BT_PACKAGE.getClassC(), TRUE);
		assertPrinting("c;", BT_PACKAGE.getClassC(), FALSE);

		// test enumeration literals
		assertPrinting("dr", BT_PACKAGE.getClassD(), RED);
		assertPrinting("dg", BT_PACKAGE.getClassD(), GREEN);
		assertPrinting("db", BT_PACKAGE.getClassD(), BLUE);
		assertPrinting("er", BT_PACKAGE.getClassE(), RED);
		assertPrinting("eg", BT_PACKAGE.getClassE(), GREEN);
		assertPrinting("e", BT_PACKAGE.getClassE(), BLUE);
	}

	public void testRePrinting() {
		assertRePrinting("ayes;");
		assertRePrinting("ano;");
		assertRePrinting("b;");
		assertRePrinting("bno;");
		assertRePrinting("cyes;");
		assertRePrinting("c;");

		// test enumeration literals
		assertRePrinting("dr");
		assertRePrinting("dg");
		assertRePrinting("db");
		assertRePrinting("er");
		assertRePrinting("eg");
		assertRePrinting("e");
	}
	
	private void assertRePrinting(String text) {
		EObject root = parse(text);
		String printResult = print(root);
		assertEquals(printResult, text);
	}

	private void assertParsing(String text, EClass expectedClass, Object expectedValue) {
		EObject root = parse(text);
		assertTrue("Root object must be instance of " + expectedClass.getName() + ", but is " + root.eClass().getName(), expectedClass.isInstance(root));
		Object attributeValue = root.eGet(expectedClass.getEStructuralFeature("attribute"));
		assertEquals("Expected different attribute value", expectedValue, attributeValue);
	}

	private EObject parse(String text) {
		Resource resource = createTempResource();
		try {
			resource.load(new ByteArrayInputStream(text.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("parse() ERROR: " + error);
		}
		assertTrue("Resource should not have errors", errors.isEmpty());
		EList<EObject> contents = resource.getContents();
		assertNotNull(contents);
		EObject root = contents.get(0);
		return root;
	}

	private void assertPrinting(String expectedPrintResult, EClass eClass, Object attributeValue) {
		EObject object = eClass.getEPackage().getEFactoryInstance().create(eClass);
		object.eSet(eClass.getEStructuralFeature("attribute"), attributeValue);
		String printResult = print(object);
		assertEquals("Wrong print result", expectedPrintResult, printResult);
	}

	private String print(EObject object) {
		Resource resource = createTempResource();
		resource.getContents().add(object);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		String printResult = outputStream.toString();
		return printResult;
	}

	private Resource createTempResource() {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + SYNTAX_NAME));
		return resource;
	}
}
