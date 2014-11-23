package org.emftext.test;

import static org.junit.Assert.assertEquals;

import org.emftext.sdk.codegen.resource.generators.util.BinaryIntegerSplitter;
import org.junit.Test;

public class BinaryIntegerSplitterTest {

	@Test
	public void testSplitting() {
		assertCode(0, "");
		assertCode(1, "1");
		assertCode(2, "0,1");
		assertCode(3, "1,1");
		assertCode(4, "0,0,1");
		assertCode(7, "1,1,1");
	}

	private void assertCode(int value, String expectedCode) {
		BinaryIntegerSplitter splitter = new BinaryIntegerSplitter(value);
		String actualCode = splitter.getComputationCode();
		assertEquals(expectedCode, actualCode);
	}
}
