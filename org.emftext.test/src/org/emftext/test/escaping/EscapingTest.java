package org.emftext.test.escaping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.test.escaping.resource.escaping.EscapingResource;

import junit.framework.TestCase;

public class EscapingTest extends TestCase {

	public void testParsingEscapeLanguageExamples() {
		EscapingResource resource = new EscapingResource();
		try {
			resource.load(new ByteArrayInputStream("Root \"".getBytes()), null);
			List<EObject> contents = resource.getContents();
			assertEquals(1, contents.size());
			EObject root = contents.get(0);
			assertTrue(root instanceof Root);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
