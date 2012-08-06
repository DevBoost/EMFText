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
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

import org.emftext.sdk.concretesyntax.resource.cs.ICsTokenResolver;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTokenResolveResult;
import org.emftext.sdk.util.Pair;
import org.junit.Test;

public class StringResolverTest extends TestCase {

	private Collection<Pair<String, String>> testData;

	public void setUp() {
		testData = new ArrayList<Pair<String,String>>();

		// test "" -> empty string
		testData.add(new Pair<String, String>("\"\"", ""));
		// test "\"" -> "
		testData.add(new Pair<String, String>("\"\\\"\"", "\""));
		// test "\\" -> \
		testData.add(new Pair<String, String>("\"\\\\\"", "\\"));
		// test "\\\\" -> \\
		testData.add(new Pair<String, String>("\"\\\\\\\\\"", "\\\\"));
		// test "\\\"" -> \"
		testData.add(new Pair<String, String>("\"\\\\\\\"\"", "\\\""));
		// test "\n" -> line break
		testData.add(new Pair<String, String>("\"\\n\"", "\n"));
		// test "\r" -> return
		testData.add(new Pair<String, String>("\"\\r\"", "\r"));
		// test "\t" -> tab
		testData.add(new Pair<String, String>("\"\\t\"", "\t"));
		// test "\b" -> bell
		testData.add(new Pair<String, String>("\"\\b\"", "\b"));
		// test "\f" -> \f
		testData.add(new Pair<String, String>("\"\\f\"", "\f"));
		// test "\\begin" -> \begin
		testData.add(new Pair<String, String>("\"\\\\begin\"", "\\begin"));
	}

	@Test
	public void testResolvers() {
		ICsTokenResolver doubleQuoteResolver = new CsSTRINGTokenResolver();

		for (Pair<String,String> pair : testData) {
			assertResolveTo(doubleQuoteResolver, pair.getLeft(), pair.getRight());
			assertDeResolveTo(doubleQuoteResolver, pair.getRight(), pair.getLeft());
		}
	}

	public void assertResolveTo(ICsTokenResolver resolver, String lexem, String expectedResult) {
		CsTokenResolveResult result = new CsTokenResolveResult();
		resolver.resolve(lexem, null, result);
		Object actualResult = result.getResolvedToken();
		System.out.println("RESOLVE(" + lexem + ") EXP: [" + expectedResult + "]");
		System.out.println("RESOLVE(" + lexem + ") ACT: [" + actualResult + "]");
		assertEquals(expectedResult, actualResult);
	}

	public void assertDeResolveTo(ICsTokenResolver resolver, String value, String expectedResult) {
		String actualResult = resolver.deResolve(value, null, null);
		System.out.println("DE-RESOLVE(" + value + ") EXP: [" + expectedResult + "]");
		System.out.println("DE-RESOLVE(" + value + ") ACT: [" + actualResult + "]");
		assertEquals(expectedResult, actualResult);
	}
}
