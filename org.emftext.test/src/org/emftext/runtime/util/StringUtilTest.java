package org.emftext.runtime.util;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {

	public void testGetMissingTail() {
		assertEquals("d", StringUtil.getMissingTail("abc", "cd"));
		assertEquals("cd", StringUtil.getMissingTail("a", "cd"));
		assertEquals("cdef", StringUtil.getMissingTail("a", "cdef"));
	}
	
	public void testAllCapsToLowerCamelCase() {
		assertEquals("", StringUtil.convertAllCapsToLowerCamelCase(""));
		assertEquals("a", StringUtil.convertAllCapsToLowerCamelCase("A"));
		assertEquals("a", StringUtil.convertAllCapsToLowerCamelCase("a"));
		assertEquals("a", StringUtil.convertAllCapsToLowerCamelCase("a_"));
		assertEquals("aB", StringUtil.convertAllCapsToLowerCamelCase("A_B"));
		assertEquals("aBcd", StringUtil.convertAllCapsToLowerCamelCase("A_BCD"));
	}
}
