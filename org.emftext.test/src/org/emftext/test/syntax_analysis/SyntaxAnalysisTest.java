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
	public void testUnusedOppositeReferences() throws FileNotFoundException, IOException {
		final String featureHasNoSyntax = "Feature.*has no syntax.";
		assertProblems("opposite1.cs", new String[] {featureHasNoSyntax, featureHasNoSyntax}, new String[0]);
		assertProblems("opposite2.cs", new String[0], new String[0]);
		assertProblems("opposite3.cs", new String[0], new String[0]);
		assertProblems("opposite4.cs", new String[0], new String[0]);
	}

	@Test
	public void testReferences() throws FileNotFoundException, IOException {
		assertProblems("reference1.cs", new String[0], new String[] {"The type of non-containment reference.*is abstract and has no concrete sub classes."});
		assertProblems("reference2.cs", new String[] {"Feature.*has no syntax."}, new String[0]);
		assertProblems("reference3.cs", new String[0], new String[] {"Feature.*has wrong containment type.*"});
	}

	private void assertProblems(String filename, String[] expectedWarnings, String[] expectedErrors) {
		final String path = "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "syntax_analysis" + File.separator;
		File file = new File(path + filename);
		
		ITextResource resource = new TextResourceHelper().getResource(file, new SDKOptionProvider().getOptions());
		assertNotNull(resource);
		
		assertDiagnostics(filename, expectedWarnings, resource.getWarnings(), "warnings");
		assertDiagnostics(filename, expectedErrors, resource.getErrors(), "errors");
	}

	private void assertDiagnostics(String filename, String[] expectedDiagnostics,
			EList<Diagnostic> diagnostics, String type) {
		printDiagnostics(diagnostics);
		assertEquals(filename + " should contain " + expectedDiagnostics.length + " " + type + ".", expectedDiagnostics.length, diagnostics.size());
		for (int i = 0; i < expectedDiagnostics.length; i++) {
			String actualDiagnostic = diagnostics.get(i).getMessage();
			assertNotNull(actualDiagnostic);
			String expectedDiagnostic = expectedDiagnostics[i];
			assertTrue("Diagnostic ("+actualDiagnostic+") should match \""+expectedDiagnostic+"\".", actualDiagnostic.matches(expectedDiagnostic));
		}
	}

	private void printDiagnostics(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnotic : diagnostics) {
			System.out.println("assertProblems() " + diagnotic.getMessage());
		}
	}
}
