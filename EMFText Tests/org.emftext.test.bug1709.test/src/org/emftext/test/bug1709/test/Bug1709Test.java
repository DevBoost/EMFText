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
package org.emftext.test.bug1709.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.test.bug1709.Bug1709Factory;
import org.emftext.test.bug1709.Bug1709Package;
import org.emftext.test.bug1709.NamedElement;
import org.emftext.test.bug1709.Root;
import org.emftext.test.bug1709.resource.bug1709.mopp.Bug1709MetaInformation;
import org.junit.BeforeClass;
import org.junit.Test;

public class Bug1709Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		new Bug1709MetaInformation().registerResourceFactory();
	}

	@Test
	public void testParsing() {
		testParsing("root typeA validName", "validName");
		// the underscore must be removed by the token resolver
		testParsing("root typeA _typeA", "typeA");
		// two underscores must be replaced by a single one by the token resolver
		testParsing("root typeA __typeA", "_typeA");
		testParsing("root typeA ___typeA", "__typeA");
		
		testParsing("root typeB \"validName\"", "validName");
		// the underscore must NOT be removed by the token resolver
		testParsing("root typeB \"_typeB\"", "_typeB");
	}

	@Test
	public void testPrinting() {
		EClass typeA = Bug1709Package.eINSTANCE.getTypeA();
		EClass typeB = Bug1709Package.eINSTANCE.getTypeB();
		
		testPrinting("validName", "root typeA validName", typeA);
		testPrinting("typeA", "root typeA _typeA", typeA);
		testPrinting("_typeA", "root typeA __typeA", typeA);
		testPrinting("__typeA", "root typeA ___typeA", typeA);

		testPrinting("validName", "root typeB\"validName\"", typeB);
		testPrinting("typeB", "root typeB\"typeB\"", typeB);
		testPrinting("_typeB", "root typeB\"_typeB\"", typeB);
		testPrinting("__typeB", "root typeB\"__typeB\"", typeB);
	}

	private void testPrinting(String name, String expectedOutput, EClass type) {
		Root root = Bug1709Factory.eINSTANCE.createRoot();
		NamedElement element = (NamedElement) Bug1709Factory.eINSTANCE.create(type);
		element.setName(name);
		root.getElements().add(element);
		
		Resource resource = createTempResource();
		resource.getContents().add(root);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		String output = outputStream.toString();
		assertEquals(expectedOutput, output);
	}

	private void testParsing(String text, String expectedName) {
		Resource resource = createTempResource();
		InputStream inputStream = new ByteArrayInputStream(text.getBytes());
		try {
			resource.load(inputStream, null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.err.println("Error while parsing test input: " + error);
		}
		assertTrue(errors.isEmpty());
		
		List<EObject> contents = resource.getContents();
		assertFalse(contents.isEmpty());
		
		EObject first = contents.get(0);
		assertTrue(first instanceof Root);
		Root root = (Root) first;
		List<NamedElement> elements = root.getElements();
		assertEquals(1, elements.size());
		NamedElement element = elements.get(0);
		assertEquals(expectedName, element.getName());
	}

	private Resource createTempResource() {
		URI uri = URI.createURI("temp." + new Bug1709MetaInformation().getSyntaxName());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(uri);
		return resource;
	}
}
