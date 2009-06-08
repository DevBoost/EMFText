/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.test.syntax_analysis;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

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

	private static final String[] NONE = new String[0];
	private static final String OCCURENCES_DO_NOT_MATCH = " occurences (.*) of feature .* do not match (.*).";
	private static final String WRONG_CONTAINMENT_TYPE = "Feature.*has wrong containment type.*";
	private static final String NO_SUB_CLASSES_FOUND_FOR_C_REFERENCE = "The type.*of containment reference.*is abstract and has no concrete sub classes with defined syntax.";
	private static final String NO_SUB_CLASSES_FOUND_FOR_NC_REFERENCE = "The type.*of non-containment reference.*is abstract and has no concrete sub classes.";
	private static final String FEATURE_HAS_NO_SYNTAX = "Feature.*has no syntax.";
	private static final String FEATURE_HAS_NC_OPPOSITE = "Feature has a non-containment opposite feature. The opposite is only established after reference resolving.*";
	private static final String MAX_OCCURENCES_DO_NOT_MATCH = "Maximum" + OCCURENCES_DO_NOT_MATCH;
	private static final String MIN_OCCURENCES_DO_NOT_MATCH = "Minimum" + OCCURENCES_DO_NOT_MATCH;
	private static final String EXPLICIT_SYNTAX_CHOICE = "Explicit syntax choices are not reflected in model instances and may thus cause problem when printing models.";
	private static final String START_SYMBOL_WITHOUT_SYNTAX_FOUND = "Meta class.*has no syntax and can therefore not be used as start element.";
	private static final String NO_RULE_FOR_META_CLASS = "There is no rule for concrete meta class.*";
	private static final String DUPLICATE_TOKENSTYLE_FOUND = "Style for .* is already defined.*.";
	private static final String REFERENCE_TO_TYPE_WITHOUT_SYNTAX = "There is no syntax for the type (.*) of reference.*.";

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
		assertProblems("opposite1a.cs", new String[] {FEATURE_HAS_NO_SYNTAX, FEATURE_HAS_NO_SYNTAX}, NONE);
		assertProblems("opposite1b.cs", new String[] {FEATURE_HAS_NC_OPPOSITE}, NONE);
		assertProblems("opposite1c.cs", new String[] {FEATURE_HAS_NC_OPPOSITE}, NONE);
		assertProblems("opposite1d.cs", NONE, NONE);

		assertProblems("opposite2a.cs", new String[] {FEATURE_HAS_NC_OPPOSITE, FEATURE_HAS_NC_OPPOSITE}, NONE);
		assertProblems("opposite2b.cs", new String[] {FEATURE_HAS_NO_SYNTAX, FEATURE_HAS_NO_SYNTAX, FEATURE_HAS_NC_OPPOSITE}, NONE);
	}

	@Test
	public void testDuplicateTokenStyleDetection() throws FileNotFoundException, IOException {
		// this is a test for bug 740
		assertProblems("duplicate_tokenstyle.cs", new String[] {DUPLICATE_TOKENSTYLE_FOUND}, NONE);
	}
	
	@Test
	public void testDuplicateToken() throws FileNotFoundException, IOException {
		// this is a test for bug 794: Duplicate token name analyser does not handle PREDEFINED tokens correctly 
		assertProblems("duplicate_token1.cs", NONE, NONE);
	}
	
	@Test
	public void testDuplicateAnalysisForQuotedTokens() throws FileNotFoundException, IOException {
		assertProblems("duplicate_quoted_token.cs", NONE, NONE);
	}
	
	@Test
	public void testCardinalityWarningsInImportedSyntaxes() throws FileNotFoundException, IOException {
		// this is a test for bug 760
		assertProblems("wrongCardinalityInImportedSyntax_import.cs", new String[] {MIN_OCCURENCES_DO_NOT_MATCH}, NONE);
		assertProblems("wrongCardinalityInImportedSyntax.cs", NONE, NONE);
	}
	
	@Test
	public void testReferences() throws FileNotFoundException, IOException {
		assertProblems("reference1.cs", NONE, new String[] {NO_SUB_CLASSES_FOUND_FOR_C_REFERENCE});
		assertProblems("reference2.cs", new String[] {FEATURE_HAS_NO_SYNTAX}, NONE);
		assertProblems("reference3.cs", NONE, new String[] {WRONG_CONTAINMENT_TYPE});
		// this is a test for bug 729 (Add syntax analyser that checks that every reference used in the CS has a type with syntax)
		assertProblems("referenceWithoutSyntax.cs", new String[] {NO_RULE_FOR_META_CLASS}, new String[] {REFERENCE_TO_TYPE_WITHOUT_SYNTAX});
	}

	@Test
	public void testNCReferencesWithAbstractType() throws FileNotFoundException, IOException {
		// these are tests for bug 736
		assertProblems("abstractNCReferenceWithoutSubclass1.cs", NONE, new String[] {NO_SUB_CLASSES_FOUND_FOR_NC_REFERENCE});
		assertProblems("abstractNCReferenceWithoutSubclass2.cs", new String[] {NO_SUB_CLASSES_FOUND_FOR_NC_REFERENCE}, NONE);
		assertProblems("abstractNCReferenceWithoutSubclass3.cs", NONE, new String[] {NO_SUB_CLASSES_FOUND_FOR_NC_REFERENCE});
	}

	@Test
	public void testCardinalityChecks() throws FileNotFoundException, IOException {
		assertProblems("cardinality.cs", new String[] {MAX_OCCURENCES_DO_NOT_MATCH}, NONE);
		
		// these are tests for bug 730 (Add syntax analyser that checks that meta model cardinalities match the defined syntax) 
		assertProblems("cardinality2.cs", new String[] {MIN_OCCURENCES_DO_NOT_MATCH}, NONE);
		assertProblems("cardinality3.cs", new String[] {MAX_OCCURENCES_DO_NOT_MATCH, MIN_OCCURENCES_DO_NOT_MATCH}, NONE);
		assertProblems("cardinality4a.cs", new String[] {EXPLICIT_SYNTAX_CHOICE}, NONE);
		assertProblems("cardinality4b.cs", new String[] {EXPLICIT_SYNTAX_CHOICE, EXPLICIT_SYNTAX_CHOICE}, NONE);

		assertProblems("cardinality5a.cs", new String[] {EXPLICIT_SYNTAX_CHOICE}, NONE);
		assertProblems("cardinality5b.cs", new String[] {MIN_OCCURENCES_DO_NOT_MATCH, EXPLICIT_SYNTAX_CHOICE, EXPLICIT_SYNTAX_CHOICE}, NONE);
	}

	@Test
	public void testStartSymbolWithoutSyntax() throws FileNotFoundException, IOException {
		assertProblems("startWithoutSyntax.cs", new String[] {NO_RULE_FOR_META_CLASS}, new String[] {START_SYMBOL_WITHOUT_SYNTAX_FOUND});
	}
	
	@Test
	public void testIgnorePredefinedDirective() throws FileNotFoundException, IOException {
		assertProblems("ignore_predefined_token_directive.cs", NONE, NONE);
	}

	private void assertProblems(String filename, String[] expectedWarnings, String[] expectedErrors) {
		System.out.println("\n-----> " + filename);
		final String path = "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "syntax_analysis" + File.separator;
		File file = new File(path + filename);
		
		ITextResource resource = new TextResourceHelper().getResource(file, new SDKOptionProvider().getOptions());
		assertNotNull(resource);
		
		List<Diagnostic> warnings = resource.getWarnings();
		List<Diagnostic> errors = resource.getErrors();
		printDiagnostics(warnings, filename, "warning(s)");
		printDiagnostics(errors, filename, "error(s)");
		assertDiagnostics(filename, expectedWarnings, warnings, "warning(s)");
		assertDiagnostics(filename, expectedErrors, errors, "error(s)");
	}

	private void assertDiagnostics(String filename, String[] expectedDiagnostics,
			List<Diagnostic> diagnostics, String type) {
		assertEquals(filename + " should contain " + expectedDiagnostics.length + " " + type + ".", expectedDiagnostics.length, diagnostics.size());
		for (int i = 0; i < expectedDiagnostics.length; i++) {
			String actualDiagnostic = diagnostics.get(i).getMessage();
			assertNotNull(actualDiagnostic);
			String expectedDiagnostic = expectedDiagnostics[i];
			assertTrue("Diagnostic \"" + actualDiagnostic + "\" should match \"" + expectedDiagnostic + "\".", actualDiagnostic.matches(expectedDiagnostic));
		}
	}

	private void printDiagnostics(List<Diagnostic> diagnostics, String file, String type) {
		for (Diagnostic diagnotic : diagnostics) {
			System.out.println(type + ": " + diagnotic.getMessage() + " at " + diagnotic.getLine() + "," + diagnotic.getColumn());
		}
	}
}
