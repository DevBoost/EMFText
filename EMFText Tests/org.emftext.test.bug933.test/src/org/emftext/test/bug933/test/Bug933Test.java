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
package org.emftext.test.bug933.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.test.bug933.BACKSLASH;
import org.emftext.test.bug933.Child;
import org.emftext.test.bug933.DQUOTE;
import org.emftext.test.bug933.N;
import org.emftext.test.bug933.R;
import org.emftext.test.bug933.RN;
import org.emftext.test.bug933.Root;
import org.emftext.test.bug933.SQUOTE;
import org.emftext.test.bug933.resource.bug933.mopp.Bug933MetaInformation;

public class Bug933Test extends TestCase {

	public void setUp() {
		new Bug933MetaInformation().registerResourceFactory();
	}
	
	public void testBug933() {
		testParsing("R\r", R.class);
		testParsing("N\n", N.class);
		testParsing("RN\r\n", RN.class);
		testParsing("SQ'", SQUOTE.class);
		testParsing("DQ\"", DQUOTE.class);
		testParsing("BS\\", BACKSLASH.class);
	}

	private void testParsing(String input, Class<?> expectedClass) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("temp." + new Bug933MetaInformation().getSyntaxName()));
		try {
			r.load(new ByteArrayInputStream(input.getBytes()), null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		List<Diagnostic> errors = r.getErrors();
		for (Diagnostic diagnostic : errors) {
			System.out.println("Bug933Test.testParsing() ERROR: " + diagnostic.getMessage());
		}
		assertTrue(errors.size() == 0);
		List<EObject> contents = r.getContents();
		assertTrue(contents.size() == 1);
		EObject rootObject = contents.get(0);
		assertTrue(rootObject instanceof Root);
		Root root = (Root) rootObject;
		Child child = root.getChild();
		assertTrue(expectedClass.isInstance(child));
	}
}
