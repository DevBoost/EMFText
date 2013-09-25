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
package org.emftext.sdk.util;

import junit.framework.TestCase;
import de.devboost.codecomposers.util.StringUtil;

public class StringUtilTest extends TestCase {

	public void testIsUnicodeSequence() {
		assertEquals(true, "0".matches(StringUtil.HEX_DIGIT_REGEXP));
		// check that Unicode sequences are not escaped
		assertEquals(true, StringUtil.isUnicodeSequence("\\u001a"));
		assertEquals(false, StringUtil.isUnicodeSequence("\\unknown"));
		assertEquals(false, StringUtil.isUnicodeSequence("\\u"));
		assertEquals(false, StringUtil.isUnicodeSequence("prefix\\u001a"));
	}

	public void testEscapeToJavaString() {
		assertEquals("line1\\nline2", StringUtil.escapeToJavaString("line1\nline2"));
		assertEquals("\\n", StringUtil.escapeToJavaString("\n"));
		assertEquals("\\uffff", StringUtil.escapeToJavaString("\uFFFF"));
	}

	public void testUnescapeJavaString() {
		assertEquals("line1\nline2", StringUtil.unescapeJavaString("line1\\nline2"));
		assertEquals("\n", StringUtil.unescapeJavaString("\\n"));
		assertEquals("\n\n", StringUtil.unescapeJavaString("\\n\\n"));
		assertEquals("\r", StringUtil.unescapeJavaString("\\r"));
		assertEquals("\t", StringUtil.unescapeJavaString("\\t"));
		assertEquals("\b", StringUtil.unescapeJavaString("\\b"));
		assertEquals("\f", StringUtil.unescapeJavaString("\\f"));
		assertEquals("\"", StringUtil.unescapeJavaString("\\\""));
		assertEquals("\begin", StringUtil.unescapeJavaString("\\begin"));
		assertEquals("\\begin", StringUtil.unescapeJavaString("\\\\begin"));
		assertEquals(" ", StringUtil.unescapeJavaString("\\u0020"));
		assertEquals("  ", StringUtil.unescapeJavaString("\\u0020\\u0020"));
		assertEquals("\u00ff", StringUtil.unescapeJavaString("\\u00FF"));
		assertEquals("\uffff", StringUtil.unescapeJavaString("\\uFFFF"));
	}

	public void testEscapeToANTLRKeyword() {
		assertTrue("\\u00ff".matches(StringUtil.ESC_REGEXP));
		assertTrue("\\r".matches(StringUtil.ESC_REGEXP));
		assertTrue("\\n".matches(StringUtil.ESC_REGEXP));
		assertTrue("\\b".matches(StringUtil.ESC_REGEXP));
		assertTrue("\\r\\n".matches(StringUtil.ESC_REGEXP));

		// check that normal strings are not escaped
		assertANTLREscape("abc", "abc");
		// check that Unicode sequences are escaped
		assertANTLREscape("\\u001a", "\u001a");
		// check that normal backslashes are escaped
		assertANTLREscape("\\\\abc", "\\abc");

		assertANTLREscape("\\r", "\r");
		assertANTLREscape("\\n", "\n");
		assertANTLREscape("\\b", "\b");
		assertANTLREscape("\\\\\\\\begin", "\\\\begin");
		assertANTLREscape("\\r\\n", "\r\n");
		assertANTLREscape("\\\\unknown", "\\unknown");
		// check that single quotes are escaped
		assertANTLREscape("\\'", "'");
		assertANTLREscape("\\'\\'", "''");
		// check that backslashes are escaped
		assertANTLREscape("\\\\", "\\");

		assertANTLREscape("\\\\e", "\\e");
	}

	private void assertANTLREscape(String expectedString, String keyword) {
		String result = StringUtil.escapeToANTLRKeyword(keyword);
		assertEquals(expectedString, result);
	}

	public void testQuoteReplacement() {
		assertEquals("\\\"", StringUtil.escapeQuotes("\""));
		assertEquals("\\\"\\\"", StringUtil.escapeQuotes("\"\""));
		assertEquals("\\\\", StringUtil.escapeQuotes("\\"));
		assertEquals("\\\\ \\\\", StringUtil.escapeQuotes("\\ \\"));
	}

	public void testGetMissingTail() {
		assertEquals("d", StringUtil.getMissingTail("abc", "cd"));
		assertEquals("cd", StringUtil.getMissingTail("a", "cd"));
		assertEquals("cdef", StringUtil.getMissingTail("a", "cdef"));
	}

	public void testCamelCaseToAllCaps() {
		assertEquals("", StringUtil.convertCamelCaseToAllCaps(""));
		assertEquals("CLASS", StringUtil.convertCamelCaseToAllCaps("Class"));
		assertEquals("I_SOME_INTERFACE", StringUtil.convertCamelCaseToAllCaps("ISomeInterface"));
		assertEquals("SOME_CAPS_IN_THE_MIDDLE", StringUtil.convertCamelCaseToAllCaps("SomeCAPSInTheMiddle"));
	}

	public void testAllCapsToLowerCamelCase() {
		assertEquals("", StringUtil.convertAllCapsToLowerCamelCase(""));
		assertEquals("a", StringUtil.convertAllCapsToLowerCamelCase("A"));
		assertEquals("a", StringUtil.convertAllCapsToLowerCamelCase("a"));
		assertEquals("a", StringUtil.convertAllCapsToLowerCamelCase("a_"));
		assertEquals("aB", StringUtil.convertAllCapsToLowerCamelCase("A_B"));
		assertEquals("aBcd", StringUtil.convertAllCapsToLowerCamelCase("A_BCD"));
	}

	public void formatTokenName() {
		assertEquals("a", StringUtil.formatTokenName("'a'"));
		assertEquals("NUMBER", StringUtil.formatTokenName("NUMBER"));
	}

	public void testGetLine() {
		assertEquals(1, StringUtil.getLine("abc", 0));
		assertEquals(1, StringUtil.getLine("abc\ndef", 3));
		assertEquals(2, StringUtil.getLine("abc\ndef", 4));
		assertEquals(1, StringUtil.getLine("abc\rdef", 3));
		assertEquals(2, StringUtil.getLine("abc\rdef", 4));
		assertEquals(1, StringUtil.getLine("abc\r\ndef", 3));
		assertEquals(1, StringUtil.getLine("abc\r\ndef", 4));
		assertEquals(1, StringUtil.getLine("abc\n\rdef", 3));
		assertEquals(1, StringUtil.getLine("abc\n\rdef", 4));
		assertEquals(2, StringUtil.getLine("abc\r\ndef", 5));
		assertEquals(2, StringUtil.getLine("abc\r\ndef", 5));
		assertEquals(3, StringUtil.getLine("a\rb\rc", 4));
	}

	public void testCharPositionInLine() {
		assertEquals(1, StringUtil.getCharPositionInLine("abc", 0));
		assertEquals(4, StringUtil.getCharPositionInLine("abc\ndef", 3));
		assertEquals(1, StringUtil.getCharPositionInLine("abc\ndef", 4));
		assertEquals(3, StringUtil.getCharPositionInLine("abc\ndef", 6));
		assertEquals(4, StringUtil.getCharPositionInLine("abc\rdef", 3));
		assertEquals(1, StringUtil.getCharPositionInLine("abc\rdef", 4));
		assertEquals(4, StringUtil.getCharPositionInLine("abc\r\ndef", 3));
		assertEquals(5, StringUtil.getCharPositionInLine("abc\r\ndef", 4));
		assertEquals(4, StringUtil.getCharPositionInLine("abc\n\rdef", 3));
		assertEquals(5, StringUtil.getCharPositionInLine("abc\n\rdef", 4));
		assertEquals(1, StringUtil.getCharPositionInLine("abc\r\ndef", 5));
		assertEquals(1, StringUtil.getCharPositionInLine("abc\r\ndef", 5));
		assertEquals(1, StringUtil.getCharPositionInLine("a\rb\rc", 4));
	}
}
