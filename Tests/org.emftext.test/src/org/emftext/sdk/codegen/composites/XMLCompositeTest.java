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

import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * A test for the XMLComposite class.
 */
public class XMLCompositeTest extends TestCase {

	@Test
	public void testXMLComposite1() {
		StringComposite sc = new XMLComposite();
		sc.add("<a>");
		sc.add("<b/>");
		sc.add("</a>");

		String result = sc.toString();
		System.out.println("testXMLComposite() => \"" + result + "\"");
		assertEquals("<a>\n\t<b/>\n</a>\n", result);
	}

	@Test
	public void testXMLComposite2() {
		StringComposite sc = new XMLComposite();
		sc.add("<a>");
		sc.add("<b>");
		sc.add("</b>");
		sc.add("</a>");

		String result = sc.toString();
		System.out.println("testXMLComposite() => \"" + result + "\"");
		assertEquals("<a>\n\t<b>\n\t</b>\n</a>\n", result);
	}


	@Test
	public void testXMLComposite3() {
		StringComposite sc = new XMLComposite();
		sc.add("<a>");
		sc.add("<b>text</b>");
		sc.add("</a>");

		String result = sc.toString();
		System.out.println("testXMLComposite() => \"" + result + "\"");
		assertEquals("<a>\n\t<b>text</b>\n</a>\n", result);
	}
}
