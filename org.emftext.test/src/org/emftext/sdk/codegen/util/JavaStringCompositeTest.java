package org.emftext.sdk.codegen.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JavaStringCompositeTest {

	@Test
	public void testSimple() {
		JavaStringComposite sc = new JavaStringComposite();
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
		JavaStringComposite sc = new JavaStringComposite();
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
		JavaStringComposite sc = new JavaStringComposite();
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
		JavaStringComposite sc = new JavaStringComposite();
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
		JavaStringComposite sc = new JavaStringComposite();
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
		JavaStringComposite sc = new JavaStringComposite();
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
		JavaStringComposite sc = new JavaStringComposite();
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
}
