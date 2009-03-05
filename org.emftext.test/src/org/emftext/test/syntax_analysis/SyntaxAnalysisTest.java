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

	private static final String[] NONE = new String[0];
	private static final String WRONG_CONTAINMENT_TYPE = "Feature.*has wrong containment type.*";
	private static final String NO_SUB_CLASSES_FOUND = "The type of non-containment reference.*is abstract and has no concrete sub classes with defined syntax.";
	private static final String FEATURE_HAS_NO_SYNTAX = "Feature.*has no syntax.";
	private static final String MULTIPLICITY_DOES_NOT_MATCH = "Multiplicity of feature.*does not match cardinality.";

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
		assertProblems("opposite1.cs", new String[] {FEATURE_HAS_NO_SYNTAX, FEATURE_HAS_NO_SYNTAX}, NONE);
		assertProblems("opposite2.cs", NONE, NONE);
		assertProblems("opposite3.cs", NONE, NONE);
		assertProblems("opposite4.cs", NONE, NONE);
	}

	@Test
	public void testReferences() throws FileNotFoundException, IOException {
		assertProblems("reference1.cs", new String[] {NO_SUB_CLASSES_FOUND}, NONE);
		assertProblems("reference2.cs", new String[] {FEATURE_HAS_NO_SYNTAX}, NONE);
		assertProblems("reference3.cs", NONE, new String[] {WRONG_CONTAINMENT_TYPE});

		assertProblems("cardinality.cs", NONE, new String[] {MULTIPLICITY_DOES_NOT_MATCH});
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
