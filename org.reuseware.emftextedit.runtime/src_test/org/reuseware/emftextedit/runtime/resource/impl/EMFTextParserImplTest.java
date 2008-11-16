package org.reuseware.emftextedit.runtime.resource.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EMFTextParserImplTest {

	@Test
	public void formatTokenName() {
		assertEquals("a", EMFTextParserImpl.formatTokenName("'a'"));
		assertEquals("NUMBER", EMFTextParserImpl.formatTokenName("NUMBER"));
	}
}
