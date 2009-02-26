package org.emftext.test.opposite_references;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
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
		assertProblems("src\\org\\emftext\\test\\opposite_references\\opposite1.cs", 1, 0);
		assertProblems("src\\org\\emftext\\test\\opposite_references\\opposite2.cs", 0, 0);
		assertProblems("src\\org\\emftext\\test\\opposite_references\\opposite3.cs", 0, 0);
		assertProblems("src\\org\\emftext\\test\\opposite_references\\opposite4.cs", 0, 0);
	}

	private void assertProblems(String path, int expectedWarnings, int expectedErrors) {
		File file = new File(path);
		
		ITextResource resource = new TextResourceHelper().getResource(file);
		assertNotNull(resource);
		
		EList<Diagnostic> warnings = resource.getWarnings();
		printDiagnostics(warnings);
		assertEquals(path + " should contain " + expectedWarnings + " warnings.", expectedWarnings, warnings.size());
		EList<Diagnostic> errors = resource.getErrors();
		printDiagnostics(errors);
		assertEquals(path + " should contain " + expectedWarnings + " errors.", expectedErrors, errors.size());
	}

	private void printDiagnostics(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnotic : diagnostics) {
			System.out.println("assertProblems() " + diagnotic.getMessage());
		}
	}
}
