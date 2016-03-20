/*******************************************************************************
 * Copyright (c) 2006-2015
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
package org.emftext.test;

import static org.junit.Assert.assertEquals;

import org.emftext.sdk.codegen.resource.generators.util.BinaryIntegerSplitter;
import org.junit.Test;

public class BinaryIntegerSplitterTest {

	@Test
	public void testSplitting() {
		assertCode(0, "");
		assertCode(1, "1");
		assertCode(2, "0,1");
		assertCode(3, "1,1");
		assertCode(4, "0,0,1");
		assertCode(7, "1,1,1");
	}

	private void assertCode(int value, String expectedCode) {
		BinaryIntegerSplitter splitter = new BinaryIntegerSplitter(value);
		String actualCode = splitter.getComputationCode();
		assertEquals(expectedCode, actualCode);
	}
}
