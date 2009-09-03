package org.emftext.runtime.util;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {
	
	public void testIsUnicodeSequence() {
		assertEquals(true, "0".matches(StringUtil.HEX_DIGIT_REGEXP));
		// check that Unicode sequences are not escaped
		assertEquals(true, StringUtil.isUnicodeSequence("\\u001a"));
		assertEquals(false, StringUtil.isUnicodeSequence("\\unknown"));
		assertEquals(false, StringUtil.isUnicodeSequence("\\u"));
		assertEquals(false, StringUtil.isUnicodeSequence("prefix\\u001a"));
	}
	
	public void testEscapeToANTLRKeyword() {
		// check that normal string are not escaped
		assertEquals("abc", StringUtil.escapeToANTLRKeyword("abc"));
		// check that Unicode sequences are not escaped
		assertEquals("\\u001a", StringUtil.escapeToANTLRKeyword("\\u001a"));
		// check that normal backslashes are escaped
		assertEquals("\\\\abc", StringUtil.escapeToANTLRKeyword("\\abc"));
		// check that normal backslashes are escaped
		assertEquals("\\\\unknown", StringUtil.escapeToANTLRKeyword("\\unknown"));
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
