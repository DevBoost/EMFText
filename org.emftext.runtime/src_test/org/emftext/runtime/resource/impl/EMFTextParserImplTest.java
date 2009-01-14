package org.emftext.runtime.resource.impl;

import static org.junit.Assert.assertEquals;

import org.emftext.runtime.resource.impl.AbstractEMFTextParser;
import org.junit.Test;

public class EMFTextParserImplTest {

	@Test
	public void formatTokenName() {
		assertEquals("a", AbstractEMFTextParser.formatTokenName("'a'"));
		assertEquals("NUMBER", AbstractEMFTextParser.formatTokenName("NUMBER"));
	}
}
