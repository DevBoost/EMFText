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
package org.emftext.language.xml.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.antlr.runtime3_4_0.Token;
import org.emftext.language.xml.resource.xml.IXmlTextToken;
import org.emftext.language.xml.resource.xml.mopp.XmlAntlrScanner;
import org.emftext.language.xml.resource.xml.mopp.XmlLexer;

/**
 * This is a test for bug 854 (EMFText Editor freezes for invalid xml files).
 */
public class FreezeTest extends TestCase {

	private String example = "<collection>description\n\n    <description>\n     Some recipes used for the XML tutorial.\n  </description>\n  <recipe>\n    <title>Beef Parmesan with Garlic Angel Hair Pasta</title>\n    <ingredient name=\"beef cube steak\" amount=\"1.5\" unit=\"pound\"/>\n    ...\n    <preparation>\n      <step\n        Preheat oven to 350 degrees F (175 degrees C).\n      </step>\n      ...\n    </preparation>\n    <comment>\n      Make the meat ahead of time, and refrigerate over night, the acid in the\n      tomato sauce will tenderize the meat even more. If you do this, save the\n      mozzarella till the last minute.\n    </comment>\n    <nutrition calories=\"1167\" fat=\"23\" carbohydrates=\"45\" protein=\"32\"/>\n  </recipe>\n</collection>";

	public void testLexerFreezing() {
		try {
			InputStream actualInputStream = new ByteArrayInputStream(example.getBytes());
			XmlLexer lexer = new XmlLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream));
			Token nextToken = lexer.nextToken();
			while (nextToken != null && nextToken.getTokenIndex() >= 0) {
				nextToken = lexer.nextToken();
				System.out.println("FreezeTest.testLexerFreezing() " + nextToken.getTokenIndex());
			}
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	public void testAntlrScannerFreezing() {
		try {
			InputStream actualInputStream = new ByteArrayInputStream(example.getBytes());
			XmlLexer lexer = new XmlLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream));
			XmlAntlrScanner antlrScanner = new XmlAntlrScanner(lexer);
			int counter = 0;
			IXmlTextToken nextToken = antlrScanner.getNextToken();
			while (nextToken != null) {
				System.out.println("FreezeTest.testAntlrScannerFreezing() \"" + nextToken.getText() + "\"");
				if (counter > 10000) {
					fail("ANTLR Scanner does not terminate.");
				}
				counter++;
				nextToken = antlrScanner.getNextToken();
			}
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
