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
package org.emftext.test.syntax_extension;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.DefaultTokenStyleAdder;

public class DefaultTokenStyleAdderTest extends TestCase {

	public void testRegex() {
		String ffff = "\uFFFF";
		System.out.println((int) ffff.charAt(0));
		assertEquals("" + ((char) 0xffff), ffff);
	}
	
	public void testKeywordMatching() {
		assertMatches("public");
		assertMatches("_something");
		assertMatches("a:keyword");
		assertMatches("a-keyword");
		assertMatches("a keyword");
		assertMatches("a keyword with 123");
		assertNotMatches("-");
		assertNotMatches("_");
		assertNotMatches(":");
	}

	private void assertMatches(String input) {
		assertMatches(input, true);
	}

	private void assertNotMatches(String input) {
		assertMatches(input, false);
	}

	private void assertMatches(String input, boolean expectedResult) {
		DefaultTokenStyleAdder adder = ConcretesyntaxFactory.eINSTANCE.createDefaultTokenStyleAdder();
		String regex = adder.getKeywordRegex();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		assertEquals(expectedResult, matcher.matches());
	}
}
