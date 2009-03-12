/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.composites;

import static org.junit.Assert.assertEquals;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComponent;
import org.junit.Test;

/**
 * A test for the JavaStringComposite class.
 */
public class JavaCompositeTest {

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
}
