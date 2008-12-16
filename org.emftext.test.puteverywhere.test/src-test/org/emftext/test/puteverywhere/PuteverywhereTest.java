package org.emftext.test.puteverywhere;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.emftext.test.puteverywhere.Root;
import org.junit.Test;

public class PuteverywhereTest extends AbstractPuteverywhereTest {

	@Test
	public void testParsing() {
		try {
			tryToParse("left right");
			tryToParse("one two three");
			tryToParse("one NL two three");
			tryToParse("one COMMENT two three");
			tryToParse("COMMENT one COMMENT two three");
			tryToParse("COMMENT one COMMENT two three NL");
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private void tryToParse(String text) throws IOException {
		Root root = loadResource(new ByteArrayInputStream(text.getBytes()), "Memory");
		assertNotNull(root);
	}
}
