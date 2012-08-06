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
package org.emftext.language.pl0extended.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.pl0.PL0Package;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0MetaInformation;
import org.emftext.language.pl0.resource.pl0.mopp.Pl0ResourceFactory;
import org.emftext.language.pl0extended.resource.pl0extended.IPl0extendedOptions;
import org.emftext.language.pl0extended.resource.pl0extended.mopp.Pl0extendedMetaInformation;
import org.emftext.language.pl0extended.resource.pl0extended.mopp.Pl0extendedResourceFactory;

public class Pl0ExtendedTest extends TestCase {

	private static final String PL0_FILE_EXTENSION = new Pl0MetaInformation().getSyntaxName();
	private static final String PL0_EXTENDED_FILE_EXTENSION = new Pl0extendedMetaInformation().getSyntaxName();

	public void setUp() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				PL0_FILE_EXTENSION,
				new Pl0ResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				PL0_EXTENDED_FILE_EXTENSION,
				new Pl0extendedResourceFactory());
	}
	
	public void testParsing() {
		// first parse with Pl0 parser
		testParsing("1 < 2", PL0_FILE_EXTENSION);
		// then parse with Pl0extended parser
		testParsing("1 < 2", PL0_EXTENDED_FILE_EXTENSION);
	}

	private void testParsing(String input, String extension) {
		System.out.println("testParsing(" + input + ", " + extension + ")");
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + extension));
		
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		Map<String, Object> options = new LinkedHashMap<String, Object>();
		options.put(IPl0extendedOptions.RESOURCE_CONTENT_TYPE, PL0Package.eINSTANCE.getRelationalCondition());
		try {
			resource.load(inputStream, options);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("Error " + error.getMessage() + " at " + error.getLine() + ":" + error.getColumn());
		}
		EList<EObject> contents = resource.getContents();
		assertTrue(contents.size() > 0);
	}
}
