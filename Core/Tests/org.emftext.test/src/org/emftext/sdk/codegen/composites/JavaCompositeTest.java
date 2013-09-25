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
package org.emftext.sdk.codegen.composites;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import de.devboost.codecomposers.StringComponent;
import de.devboost.codecomposers.java.JavaComposite;

/**
 * A test for the JavaStringComposite class.
 */
public class JavaCompositeTest {

	private static final String LINE_BREAK = JavaComposite.LINE_BREAK;

	@Test
	public void testSplitMethod() {
		JavaComposite sc = new JavaComposite();
		assertEquals(Arrays.asList(new String[] {"123" , "123"}), sc.split("123 123", 3));
		assertEquals(Arrays.asList(new String[] {"12" , "12"}), sc.split("12 12", 3));
		assertEquals(Arrays.asList(new String[] {"123" , "456"}), sc.split("123456", 3));
	}

	@Test
	public void testSimple() {
		JavaComposite sc = new JavaComposite();
		sc.add("{");
		sc.add(new StringComponent("var1", "var1"));
		sc.add("}");
		sc.add("{");
		sc.add(new StringComponent("var2", "var2"));
		sc.add("}");

		final String string = sc.toString(Integer.MIN_VALUE, false);
		System.out.println("JavaStringCompositeTest.testSimple() -->" + string + "<--");
		assertEquals("{}{}", string);
	}

	@Test
	public void testScoping1() {
		JavaComposite sc = new JavaComposite();
		sc.add("{");
		sc.add(new StringComponent("var1", "var1"));
		sc.add("}");
		sc.add("{");
		sc.add("var1"); // using var1, but out of scope
		sc.add(new StringComponent("var2", "var2"));
		sc.add("}");

		final String string = sc.toString(Integer.MIN_VALUE, false);
		System.out.println("JavaStringCompositeTest.testScoping1() -->" + string + "<--");
		assertEquals("{}{var1}", string);
	}

	@Test
	public void testScoping2() {
		JavaComposite sc = new JavaComposite();
		sc.add("{");
		sc.add(new StringComponent("var1", "var1"));
		sc.add("{");
		sc.add("var1 = 1"); // using var1, in sub scope
		sc.add("}");
		sc.add("}");
		sc.add("{");
		sc.add(new StringComponent("var2", "var2"));
		sc.add("}");

		final String string = sc.toString(Integer.MIN_VALUE, false);
		System.out.println("JavaStringCompositeTest.testScoping2() -->" + string + "<--");
		assertEquals("{var1{var1 = 1}}{}", string);
	}

	@Test
	public void testScoping3() {
		JavaComposite sc = new JavaComposite();
		sc.add("{");
		sc.add(new StringComponent("var1", "var1"));
		sc.add("var1"); // using var1 in same scope after declaration
		sc.add("}");
		sc.add("{");
		sc.add(new StringComponent("var2", "var2"));
		sc.add("}");

		final String string = sc.toString(Integer.MIN_VALUE, false);
		System.out.println("JavaStringCompositeTest.testScoping3() -->" + string + "<--");
		assertEquals("{var1var1}{}", string);
	}


	@Test
	public void testScoping4() {
		JavaComposite sc = new JavaComposite();
		sc.add("{");
		sc.add("var1"); // using var1 in same scope, but before
		sc.add(new StringComponent("var1", "var1"));
		sc.add("}");
		sc.add("{");
		sc.add(new StringComponent("var2", "var2"));
		sc.add("}");

		final String string = sc.toString(Integer.MIN_VALUE, false);
		System.out.println("JavaStringCompositeTest.testScoping4() -->" + string + "<--");
		assertEquals("{var1}{}", string);
	}

	@Test
	public void testScoping5() {
		JavaComposite sc = new JavaComposite();
		sc.add("{");
		sc.add("{");
		sc.add("var1"); // using var1, in sub scope before
		sc.add("}");
		sc.add(new StringComponent("var1", "var1"));
		sc.add("}");
		sc.add("{");
		sc.add(new StringComponent("var2", "var2"));
		sc.add("}");

		final String string = sc.toString(Integer.MIN_VALUE, false);
		System.out.println("JavaStringCompositeTest.testScoping5() -->" + string + "<--");
		assertEquals("{{var1}}{}", string);
	}

	@Test
	public void testScoping6() {
		JavaComposite sc = new JavaComposite();
		sc.add("{");
		sc.add(new StringComponent("var1", "var1"));
		sc.add("}");
		sc.add("{");
		sc.add("{");
		sc.add("var1"); // using var1, in sub scope of another (wrong) scope
		sc.add("}");
		sc.add("}");

		final String string = sc.toString(Integer.MIN_VALUE, false);
		System.out.println("JavaStringCompositeTest.testScoping6() -->" + string + "<--");
		assertEquals("{}{{var1}}", string);
	}

	@Test
	public void testMultiLineComments() {

		// test normal multi-line comments
		assertComposition(
				"/*" + LINE_BREAK + " * some comment" + LINE_BREAK + " */" + LINE_BREAK,
				new String[] {"/*", " * some comment", " */"}
		);
		// test Javadoc comments
		assertComposition(
				"/**" + LINE_BREAK + " * some comment" + LINE_BREAK + " */" + LINE_BREAK,
				new String[] {"/**", " * some comment", " */"}
		);
	}

	private void assertComposition(String expectedResult, String... components) {
		JavaComposite sc = new JavaComposite();
		for (String component : components) {
			sc.add(component);
		}

		String actualResult = sc.toString(Integer.MIN_VALUE, true);
		System.out.println("assertComposition() -->" + actualResult + "<--");
		assertEquals(expectedResult, actualResult);
	}
}
