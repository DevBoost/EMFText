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
package org.emftext.language.csv.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.csv.CSVDocument;
import org.emftext.language.csv.CsvFactory;
import org.emftext.language.csv.Row;
import org.emftext.language.csv.Value;
import org.emftext.language.csv.resource.csv.mopp.CsvMetaInformation;

public class CSVTest extends TestCase {

	private static final String FILE_EXTENSION = new CsvMetaInformation().getSyntaxName();
	private static final String NEW_LINE = System.getProperty("line.separator");
	private static final CsvFactory FACTORY = CsvFactory.eINSTANCE;

	public void setUp() {
		new CsvMetaInformation().registerResourceFactory();
	}
	
	public void testBug1408() {
		testPrinting(
				"a,b,c" + NEW_LINE + "d,e,f" + NEW_LINE, 
				"a;b;c;new" + NEW_LINE + "d;e;f" + NEW_LINE,
				"new"
		);
		testPrinting(
				"a,b,c" + NEW_LINE + "d,e,f" + NEW_LINE, 
				"a;b;c;\"ne,w\"" + NEW_LINE + "d;e;f" + NEW_LINE,
				"ne,w"
		);
		testPrinting(
				"a,b,c" + NEW_LINE + "d,e,f" + NEW_LINE, 
				"a;b;c;\"ne;w\"" + NEW_LINE + "d;e;f" + NEW_LINE,
				"ne;w"
		);
	}

	private void testPrinting(String input, String expectedResult, String newValueText) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("bug1408." + FILE_EXTENSION));
		try {
			resource.load(new ByteArrayInputStream(input.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("CSVTest.testPrinting() Error in resource: " + error);
		}
		assertTrue("The resource must not contain errors.", errors.isEmpty());
		EList<EObject> contents = resource.getContents();
		assertNotNull(contents);
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		
		// check document content
		assertTrue(root instanceof CSVDocument);
		CSVDocument document = (CSVDocument) root;
		EList<Row> rows = document.getRows();
		assertEquals(2, rows.size());
		
		// modify document
		Row firstRow = rows.get(0);
		Value newValue = FACTORY.createValue();
		newValue.setText(newValueText);
		firstRow.getValues().add(newValue);
		
		// print document
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		String printResult = outputStream.toString();
		assertEquals(expectedResult, printResult);
	}
}
