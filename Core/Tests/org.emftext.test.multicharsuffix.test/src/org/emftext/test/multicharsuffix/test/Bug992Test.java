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
package org.emftext.test.multicharsuffix.test;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.test.multicharsuffix.resource.multicharsuffix.util.MulticharsuffixResourceUtil;

import junit.framework.TestCase;

public class Bug992Test extends TestCase {

	public void testParsing() {
		assertParsing("variant1{{ some text in here }};");

		assertParsing("variant2< some text in here >;");
		assertParsing("variant2< some -> text in here >;");

		assertParsing("variant3( some text in here );");
		assertParsing("variant3( some ##) text in here );");

		assertParsing("variant4abc some text in here def;");
		assertParsing("variant4abc some ***def text in here def;");
	}

	private void assertParsing(String input) {
		Resource resource = MulticharsuffixResourceUtil.getResource(input);
		assertNotNull(resource);
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic diagnostic : errors) {
			System.out.println("Error: " + diagnostic);
		}
		assertTrue("Resource must not have errors.", errors.isEmpty());
	}
}
