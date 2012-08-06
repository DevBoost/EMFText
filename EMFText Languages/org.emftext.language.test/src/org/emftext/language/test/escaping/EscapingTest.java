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
package org.emftext.language.test.escaping;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EObject;
import org.emftext.test.escaping.DoubleQuote;
import org.emftext.test.escaping.EscapingFactory;
import org.emftext.test.escaping.resource.escaping.mopp.EscapingResource;

public class EscapingTest extends TestCase {

	public void testParsingEscapeLanguageExamples() {
		String input = "DoubleQuote \"";
		EscapingResource resource = new EscapingResource();
		try {
			resource.load(new ByteArrayInputStream(input.getBytes()), null);
			List<EObject> contents = resource.getContents();
			assertEquals(1, contents.size());
			EObject root = contents.get(0);
			assertTrue(root instanceof DoubleQuote);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	public void testPrintingEscapeLanguageExamples() {
		EscapingResource resource = new EscapingResource();
		List<EObject> contents = resource.getContents();
		contents.add(EscapingFactory.eINSTANCE.createDoubleQuote());
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			resource.save(baos, null);
			String result = baos.toString();
			assertEquals("DoubleQuote\"", result);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
