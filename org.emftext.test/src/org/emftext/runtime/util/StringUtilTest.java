package org.emftext.runtime.util;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {

	public void testGetMissingTail() {
		assertEquals("d", StringUtil.getMissingTail("abc", "cd"));
		assertEquals("cd", StringUtil.getMissingTail("a", "cd"));
		assertEquals("cdef", StringUtil.getMissingTail("a", "cdef"));
	}
}
