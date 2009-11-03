/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.test.scannerless_parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

public class RegexpTest extends TestCase {

	public void testExpressions() {
		assertTrue(find("abc de", "\\A[a-z]+"));
		assertTrue(find(" abc", "\\A[ ]"));
		assertTrue(find(" class A {}", "\\A[ ]"));
	}
	
	private boolean find(String text, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		return matcher.find();
	}
}
