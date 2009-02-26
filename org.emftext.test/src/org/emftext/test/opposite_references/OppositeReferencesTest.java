package org.emftext.test.opposite_references;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for one of the syntax analysis steps.
 * It check whether opposite references are correctly 
 * tagged as unused, if they are not defined at all in 
 * the concrete syntax. 
 */
public class OppositeReferencesTest extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testOptions() throws FileNotFoundException, IOException {
		String path = "src\\org\\emftext\\test\\opposite_references\\opposite_references.cs";
		File file = new File(path);
		
		ITextResource resource = new TextResourceHelper().getResource(file);
		assertNotNull(resource);
		assertProblems(resource, 1, 0);
	}

	private void assertProblems(ITextResource resource, int expectedWarnings, int expectedErrors) {
		assertEquals(expectedWarnings, resource.getWarnings().size());
		assertEquals(expectedErrors, resource.getErrors().size());
	}
}
