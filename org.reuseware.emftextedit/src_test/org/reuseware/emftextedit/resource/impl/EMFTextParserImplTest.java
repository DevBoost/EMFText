package org.reuseware.emftextedit.resource.impl;

import junit.framework.TestCase;

public class EMFTextParserImplTest extends TestCase {

	public void testFormatTokenName() {
		assertEquals("a", EMFTextParserImpl.formatTokenName("'a'"));
		assertEquals("NUMBER", EMFTextParserImpl.formatTokenName("NUMBER"));
	}
}
