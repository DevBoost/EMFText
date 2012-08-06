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
package org.emftext.language.c_sharp.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.emftext.language.c_sharp.resource.csharp.mopp.CsharpResource;

public class ForceEOFTest extends AbstractCSharpTestCase {

	private static final String TEST_INPUT_FROM_MEMORY = "int x;;";

	public void testForceEOF() {
		try {
			CsharpResource resource = load(new ByteArrayInputStream(TEST_INPUT_FROM_MEMORY.getBytes()));
			assertTrue("Additional semicolon at the end should prevent successful parsing", resource.getErrors().size() > 0);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Override
	public String getTestInputFolder() {
		return null;
	}
}
