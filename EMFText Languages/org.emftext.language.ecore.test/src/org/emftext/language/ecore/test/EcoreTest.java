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
package org.emftext.language.ecore.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.emftext.language.ecore.resource.EcoreResourceFactoryDelegator;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.emftext.language.ecore.resource.text.util.TextEcoreStreamUtil;
import org.junit.Before;
import org.junit.Test;

public class EcoreTest extends AbstractEcoreTestCase {

	@Before
	public void setUp() {
		EcoreResourceFactoryDelegator factoryDelegator = new EcoreResourceFactoryDelegator();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", factoryDelegator);
		factoryDelegator.getResourceFactoriesMap().put(
				"text", new TextEcoreResourceFactory());
		factoryDelegator.getResourceFactoriesMap().put(
				"", new EcoreResourceFactoryImpl());
	}

	@Test
	public void testGenerics() {
		assertParse("TypeArguments.text.ecore");
		assertParse("TypeParameters.text.ecore");
		assertParse("SomeXMI.ecore");
	}

	@Test
	public void testOwl() {
		assertParse("owl.text.ecore");
	}

	@Test
	public void testPrint() {
		// this is a test for bug 1708
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		ePackage.setNsPrefix("test");
		ePackage.setNsURI("http://test");

		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("A");
		ePackage.getEClassifiers().add(eClass);

		EAttribute eAtt = EcoreFactory.eINSTANCE.createEAttribute();
		eAtt.setName("abstract");
		eClass.getEStructuralFeatures().add(eAtt);

		String printResult = print(ePackage).
			replace(System.getProperty("line.separator"), "").
			replace("\t", "").
			replace("  ", " ");
		System.out.println("assertPrint() result is ==>" + printResult + "<==");
		assertEquals("package test test \"http://test\" {class A {attribute _abstract (0..1);}}", printResult);
	}

	@Test
	public void testRePrint() {
		// this is a test for bug 1602
		assertRePrint("reprint.text.ecore");
	}

	@Test
	public void testRePrint2() {
		// these are tests for bug 1617
		assertRePrint("reprint2.text.ecore");
		assertRePrint("reprint3.text.ecore");
	}

	@Test
	public void testRePrint4() {
		// these are tests for bug 1708
		assertRePrint("reprint4.text.ecore");
	}

	@Test
	public void testImport() {
		assertParse("import.text.ecore");
	}

	private void assertRePrint(String fileName) {
		String content = null;
		try {
			content = TextEcoreStreamUtil.getContent(new FileInputStream(getPath(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EPackage ePackage = assertParse(fileName);
		String printResult = print(ePackage);
		System.out.println("EcoreTest.assertRePrint() result is ==>" + printResult + "<==");
		assertEquals(content, printResult);
	}

	private EPackage assertParse(String fileName) {
		try {
			EPackage ePackage = loadResource(getPath(fileName), fileName);
			assertNotNull(ePackage);
			return ePackage;
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return null;
	}

	private String getPath(String fileName) {
		return "input" + File.separator + fileName;
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
		Resource resource = rs.createResource(URI.createURI("temp.text.ecore"));
		return resource;
	}
}
