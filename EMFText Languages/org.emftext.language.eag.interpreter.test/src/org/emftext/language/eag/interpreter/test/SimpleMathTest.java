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
package org.emftext.language.eag.interpreter.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.simplemath.SimplemathPackage;
import org.emftext.language.simplemath.resource.sm.mopp.SmMetaInformation;
import org.emftext.language.simplemath.resource.sm.mopp.SmResourceFactory;
import org.junit.Before;

public class SimpleMathTest extends AbstractInterpreterTest {

	private static final String SM_FILE_EXTENSION = new SmMetaInformation().getSyntaxName();

	private AttributeGrammar grammar;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		// register resource factories
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				SM_FILE_EXTENSION,
				new SmResourceFactory());
		SimplemathPackage.eINSTANCE.getAdditive();
		grammar = loadGrammar("input" + File.separator + "simplemath.eag");
	}

	/*
	public void testSimpleMathAG100() {
		for (int i = 0; i < 10000; i++) {
			if (i % 50 == 0) {
				System.out.println("SimpleMathTest.testSimpleMathAG100() " + i);
			}
			testSimpleMathAG();
		}
	}
	*/
	
	public void testSimpleMathAG() {
		testInterpretation("1+1", 2);
		testInterpretation("2*3", 6);
		testInterpretation("6/2", 3);
		testInterpretation("6-2", 4);
		testInterpretation("1+2*5", 11);
		testInterpretation("1+2*5.0", 11.0f);
		testInterpretation("11.1", 11.1f);
	}

	private void testInterpretation(String text, Object expected) {
		EObject root = loadModel(text);
		//EObject root = loadModel("1*5");
		String attribute = "Value";
		assertInterpretation(expected, root, grammar, attribute);
	}

	private EObject loadModel(String text) {
		Resource resource = rs.createResource(URI.createURI("test." + SM_FILE_EXTENSION));
		try {
			resource.load(new ByteArrayInputStream(text.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		return getRootObject(resource);
	}
}
