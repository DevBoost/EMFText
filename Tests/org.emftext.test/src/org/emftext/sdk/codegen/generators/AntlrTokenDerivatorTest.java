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
package org.emftext.sdk.codegen.generators;

import junit.framework.TestCase;

import org.emftext.sdk.AntlrTokenDerivator;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.PlaceholderInQuotes;
import org.junit.Test;

public class AntlrTokenDerivatorTest extends TestCase {

	@Test
	public void testTokenDerivation() {
		String prefix = "\"";
		String suffix = "\"";
		//String expected = "('\"')(~('\"'|'\\\\')|('\\\\''\"')|('\\\\''\\\\'))*('\"')";
		String expected = "('\"')(~('\"'))*('\"')";
		String actual = getRegex(prefix, suffix);
		System.out.println("AntlrTokenDerivatorTest.testTokenDerivation() EXP " + expected);
		System.out.println("AntlrTokenDerivatorTest.testTokenDerivation() ACT " + actual);
		assertEquals(expected, actual);
	}

	@Test
	public void testNegation() {
		assertEquals("~('a')", new AntlrTokenDerivator().getOrNegation("a", ""));
		assertEquals("~('a'|'b')", new AntlrTokenDerivator().getOrNegation("a", "b"));
		assertEquals("~('a'|'c')|'a'~('b')", new AntlrTokenDerivator().getOrNegation("ab", "c"));
		assertEquals("~('a'|'b')|'b'~('c')", new AntlrTokenDerivator().getOrNegation("a", "bc"));
	}
	
	private String getRegex(String prefix, String suffix) {
		AntlrTokenDerivator derivator = new AntlrTokenDerivator();
		PlaceholderInQuotes placeholder = ConcretesyntaxFactory.eINSTANCE.createPlaceholderInQuotes();
		placeholder.setPrefix(prefix);
		placeholder.setSuffix(suffix);
		return derivator.deriveTokenExpression(placeholder);
	}
}
