package org.emftext.runtime.resource.impl;

import static org.junit.Assert.assertEquals;

import org.emftext.runtime.resource.impl.EMFTextParserImpl;
import org.junit.Test;

public class EMFTextParserImplTest {

	@Test
	public void formatTokenName() {
		assertEquals("a", EMFTextParserImpl.formatTokenName("'a'"));
		assertEquals("NUMBER", EMFTextParserImpl.formatTokenName("NUMBER"));
	}
}
