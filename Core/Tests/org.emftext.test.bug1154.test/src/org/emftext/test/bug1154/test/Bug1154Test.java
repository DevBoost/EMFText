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
package org.emftext.test.bug1154.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.ModelComparator;
import org.emftext.test.bug1154.Bug1154Factory;
import org.emftext.test.bug1154.Root;
import org.emftext.test.bug1154.resource.bug1154.IBug1154TextResource;
import org.emftext.test.bug1154.resource.bug1154.mopp.Bug1154MetaInformation;
import org.emftext.test.bug1154.resource.bug1154.mopp.Bug1154Printer;
import org.emftext.test.bug1154.resource.bug1154.mopp.Bug1154Printer2;

public class Bug1154Test extends TestCase {

	private final static String FILE_EXTENSION = "." + new Bug1154MetaInformation().getSyntaxName();

	private ResourceSetImpl rs;

	private int parseInputs;

	public void setUp() {
		rs = new ResourceSetImpl();
		// register XMI, Ecore and Bug1154 resource factory
		ConcreteSyntaxTestHelper.registerResourceFactories();
		new Bug1154MetaInformation().registerResourceFactory();
	}
	
	public void testPrinting() {
		Bug1154Factory factory = Bug1154Factory.eINSTANCE;
		
		testPrinting(factory.createSingleQuote(), "'");
		testPrinting(factory.createSingleBackslash(), "\\");

		testPrinting(factory.createBackslashN(), "\n");
		testPrinting(factory.createBackslashR(), "\r");
		testPrinting(factory.createBackslashT(), "\t");
		testPrinting(factory.createBackslashB(), "\b");
		testPrinting(factory.createBackslashF(), "\f");
		testPrinting(factory.createPercent(), "%");

		testPrinting(factory.createDoubleQuote(), "\"");
		testPrinting(factory.createBackslashInWord(), "\\begin");
		
		testPrinting(factory.createUnicodeFFFF(), "\uffff");
	}

	private void testPrinting(EObject elementToPrint, String expectedFromNewPrinter) {
		// the old printer adds an additional space at the end of the document
		String expectedFromOldPrinter = expectedFromNewPrinter + " ";
		// test old printer
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		IBug1154TextResource resource = null;
		Bug1154Printer oldPrinter = new Bug1154Printer(outputStream, resource);
		try {
			oldPrinter.print(elementToPrint);
			byte[] bytes = outputStream.toByteArray();
			byte[] exptectedBytes = expectedFromOldPrinter.getBytes();
			assertEqualsArrays("Wrong result from old printer", exptectedBytes, bytes);
		} catch (Exception e1) {
			e1.printStackTrace();
			fail(e1.getMessage());
		}

		// test new printer
		outputStream = new ByteArrayOutputStream();
		Bug1154Printer2 newPrinter = new Bug1154Printer2(outputStream, resource);
		try {
			newPrinter.print(elementToPrint);
			byte[] bytes = outputStream.toByteArray();
			byte[] exptectedBytes = expectedFromNewPrinter.getBytes();
			assertEqualsArrays("Wrong result from new printer", exptectedBytes, bytes);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	private void assertEqualsArrays(String message, byte[] expectedArray, byte[] actualArray) {
		if (expectedArray == null && actualArray == null) {
			return;
		}
		if (expectedArray == null) {
			fail(message + ": expected array is null, but actual one is not.");
		}
		if (actualArray == null) {
			fail(message + ": actual array is null, but expected one is not.");
		}
		if (actualArray.length != expectedArray.length) {
			fail(message + ": array sizes do not match (expected " + expectedArray.length + ", actual " + actualArray.length + ").");
		}
		for (int i = 0; i < actualArray.length; i++) {
			byte expected = expectedArray[i];
			byte actual = actualArray[i];
			if (actual != expected) {
				fail(message + ": array element " + i + " do not match (expected " + expected + ", actual " + actual + ").");
			}
		}
	}

	public void testParsing() {
		parseInputs = 0;
		// test files
		String inputDirPath = "." + File.separator + "input";
		File[] inputFiles = getFiles(inputDirPath, FILE_EXTENSION);
		for (File inputFile : inputFiles) {
			testParsing(inputFile);
		}
		// test input from memory
		testParsing("\n", inputDirPath + File.separator + "backslash_n.xmi");
		testParsing("\r", inputDirPath + File.separator + "backslash_r.xmi");
		testParsing("\t", inputDirPath + File.separator + "backslash_t.xmi");
		testParsing("\b", inputDirPath + File.separator + "backslash_b.xmi");
		testParsing("\f", inputDirPath + File.separator + "backslash_f.xmi");
		testParsing("\"", inputDirPath + File.separator + "doublequote.xmi");
		testParsing("'", inputDirPath + File.separator + "singlequote.xmi");
		testParsing("%", inputDirPath + File.separator + "percent.xmi");

		assertTrue(parseInputs >= 2);
	}

	private File[] getFiles(String dir, final String fileExtension) {
		File inputFolder = new File(dir);
		File[] inputFiles = inputFolder.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				return name.endsWith(fileExtension);
			}
		});
		return inputFiles;
	}

	private void testParsing(File inputFile) {
		// load .bug1154 file
		String absolutePath = inputFile.getAbsolutePath();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(inputFile);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			fail(fnfe.getMessage());
		}

		String pathToExpectedModel = absolutePath.substring(0, absolutePath.length() - FILE_EXTENSION.length()) + ".xmi";
		testParsing(pathToExpectedModel, inputStream);
	}

	private void testParsing(String input, String pathToExpectedModel) {
		testParsing(pathToExpectedModel, new ByteArrayInputStream(input.getBytes()));
	}

	private void testParsing(String pathToExpectedModel, InputStream inputStream) {
		Resource resource = rs.createResource(URI.createFileURI("temp." + FILE_EXTENSION));
		try {
			resource.load(inputStream, null);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail(ioe.getMessage());
		}
		assertNotNull(resource);
		List<EObject> contents = resource.getContents();
		assertEquals("Resource is empty (probably because it could not be parsed).", 1, contents.size());
		EObject rootObject = contents.get(0);
		assertTrue(rootObject instanceof Root);

		// load expected model
		Resource expectedResource = rs.getResource(URI.createFileURI(pathToExpectedModel), true);
		List<EObject> expectedContents = expectedResource.getContents();
		assertEquals(1, expectedContents.size());
		EObject expectedRoot = expectedContents.get(0);
		// compare loaded model and expected one
		try {
			compareModels(rootObject, expectedRoot);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while comparing models " + e.getMessage());
		}
		parseInputs++;
	}

	private void compareModels(EObject modelLeft, EObject modelRight) throws Exception {
		Comparison result = new ModelComparator().compare(modelLeft, modelRight);
		if (!result.getDifferences().isEmpty()) {
			fail("Diff failed");
		}
	}
}
