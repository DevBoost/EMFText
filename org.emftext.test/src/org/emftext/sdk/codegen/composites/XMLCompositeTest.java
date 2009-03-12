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

import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.composites.XMLComposite;
import org.junit.Test;

import junit.framework.TestCase;

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
