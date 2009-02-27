package org.emftext.test.syntax_analysis;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.emftext.sdk.SDKOptionProvider;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for the syntax analysis steps.
 */
public class SyntaxAnalysisTest extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	/**
	 * This test checks whether opposite references are correctly 
	 * tagged as unused, if they are not defined at all in 
	 * the concrete syntax.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testOptions() throws FileNotFoundException, IOException {
		assertProblems("opposite1.cs", 2, 0);
		assertProblems("opposite2.cs", 0, 0);
		assertProblems("opposite3.cs", 0, 0);
		assertProblems("opposite4.cs", 0, 0);
	}

	private void assertProblems(String filename, int expectedWarnings, int expectedErrors) {
		final String path = "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "opposite_references" + File.separator;
		File file = new File(path + filename);
		
		ITextResource resource = new TextResourceHelper().getResource(file, new SDKOptionProvider().getOptions());
		assertNotNull(resource);
		
		EList<Diagnostic> warnings = resource.getWarnings();
		printDiagnostics(warnings);
		assertEquals(filename + " should contain " + expectedWarnings + " warnings.", expectedWarnings, warnings.size());
		EList<Diagnostic> errors = resource.getErrors();
		printDiagnostics(errors);
		assertEquals(filename + " should contain " + expectedWarnings + " errors.", expectedErrors, errors.size());
	}

	private void printDiagnostics(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnotic : diagnostics) {
			System.out.println("assertProblems() " + diagnotic.getMessage());
		}
	}
}
