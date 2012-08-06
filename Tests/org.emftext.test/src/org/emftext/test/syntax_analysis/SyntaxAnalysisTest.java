/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.test.syntax_analysis;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;
import org.emftext.test.PluginTestHelper;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for the syntax analysis steps.
 */
public class SyntaxAnalysisTest extends TestCase {

	private static final String OPERATORS_WITH_SAME_WEIGHT_MUST_HAVE_THE_SAME_OPERATOR_TYPE = "Operators with same weight must have the same operator type.";
	private static final String[] NONE = new String[0];
	private static final String OCCURENCES_DO_NOT_MATCH = " occurences (.*) of feature .* do not match (.*).";
	private static final String WRONG_CONTAINMENT_TYPE = "Feature.*has wrong containment type.*";
	private static final String NO_SUB_CLASSES_FOUND_FOR_C_REFERENCE = "The type.*of containment reference.*is abstract and has no concrete sub classes with defined syntax.";
	private static final String FEATURE_HAS_NO_SYNTAX = "Feature.*has no syntax.";
	private static final String FEATURE_HAS_NC_OPPOSITE = "Feature.*has a non-containment opposite feature. The opposite is only established after reference resolving.*";
	private static final String DUPLICATE_FEATURE = "The feature is used multiple times. Reprinting may fail for feature.*";
	private static final String MAX_OCCURENCES_DO_NOT_MATCH = "Maximum" + OCCURENCES_DO_NOT_MATCH;
	private static final String MIN_OCCURENCES_DO_NOT_MATCH = "Minimum" + OCCURENCES_DO_NOT_MATCH;
	private static final String EXPLICIT_SYNTAX_CHOICE = "Explicit syntax choices are not reflected in model instances and may thus cause problems when printing models.";
	private static final String START_SYMBOL_WITHOUT_SYNTAX_FOUND = "Meta class.*has no syntax and can therefore not be used as start element.";
	private static final String NO_RULE_FOR_META_CLASS = "There is no rule for concrete meta class.*";
	private static final String DUPLICATE_TOKENSTYLE_FOUND = "Style for .* is already defined.*.";
	private static final String REFERENCE_TO_TYPE_WITHOUT_SYNTAX = "There is no syntax for the type (.*) of reference.*.";
	private static final String GEN_CLASS_NOT_DECLARED = "GenClass .* not declared";
	private static final String UNCHANGEABLE_REFERENCE = "Reference .* is not changeable.";
	private static final String OPTIONAL_KEYWORD = "The keyword might be used stand alone .*";
	private static final String INVALID_WARNING_TYPE = "Invalid warning type found: .*";
	private static final String INVALID_TOKEN = "Invalid regular expression.*";
	private static final String END_OF_REGEX_EXPECTED = "Invalid regular expression:.*expecting END";
	private static final String START_SYMBOL_IN_ABSTRACT_SYNTAX_FOUND = "Syntax has start symbols (.*), but is declared abstract. Note that these start symbols are thrown away during import.";
	private static final String COLLECTIN_TOKEN_USED_IN_RULE = "Token.*will never be matched here, since it is a collect-in token.";
	private static final String CYCLIC_IMPORT = "The syntax with name.*is imported cyclic or the name is used multiple times.";
	private static final String EMPTY_CS_STRING_FOUND = "Empty strings are not allowed.";
	private static final String CYCLIC_TOKEN_DEFINITION = "The regular expression for.*is cyclic.";
	private static final String EMPTY_SUFFIX = "The suffix for the placeholder in quotes must not be empty.";
	private static final String EMPTY_PREFIX = "The prefix for the placeholder in quotes must not be empty.";
	private static final String SUBCLASS_RESTRICTIONS_IN_OPERATOR_RULES_NOT_ALLOWED = "Subclass restrictions are not allowed in operator rules.";
	private static final String CANNOT_USE_OPERATOR_CLASS_DIRECTLY = "Non-primitive operator classes cannot be used directly. Use the abstract expression superclass instead.";
	private static final String LEFT_RECURSIVE_RULE = "The rule is left recursive in relation to rule.*";
	private static final String SYNTAX_NAME_MAY_CONTAIN_ONE_DOT_MAX = "The syntax name must not contain more than one dot.";
	private static final String BASE_RESOURCE_PLUGIN_OPTION_MISSING = "If the syntax name contains one dot, the option 'baseResourcePlugin' needs to be specified.";
	private static final String EMPTY_COMPOUND = "Compounds with .* must not allow empty syntax.*";
	private static final String OPTION_SET_TWICE = "Found duplicate option.*with.*value.";
	private static final String OVERLAPPING_TOKEN = "The token definition .* overlaps with previous token definition.*";
	private static final String WRONG_ATTRIBUTE_TYPE = "Only boolean attributes can be used with boolean terminals.";
	private static final String WRONG_CARDINALITY = "Attributes must have upper bound of 1 to be used with a boolean terminal.";
	private static final String EQUAL_LITERALS = "Literals of boolean terminals must be different.";
	private static final String BOTH_LITERALS_ARE_EMPTY = "At most one literal can be empty.";
	private static final String FEATURE_DOES_NOT_EXIST = "Feature \"\" does not exist.";
	private static final String SUBCLASS_RESTRICTION_YIELDS_EMPTY_SET = "There is no syntax defined for the type of the containment reference or any of the allowed subclasses.";
	private static final String PACKAGE_NOT_FOUND = ".*The GenModel at the given URI .* does not contain a matching GenPackage.";
	private static final String COLLECTIN_TOKENS_ARE_DEPRECATED = "Collect-in tokens are deprecated as of version 1.4.1 of EMFText. Use the commons.layout plug-in to capture layout in model instances instead.";

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testBug1716() throws FileNotFoundException, IOException {
		// this is a test for bug 1716: warnings that are suppressed in imported syntaxes must
		// not be shown at the import element
		assertProblems("bug1716importing.cs", NONE, NONE);
		
		// warnings that are not suppressed must be attached to the respective import, we need
		// to check the position of the warning to make sure it is attached to the import and not
		// to the root element of the syntax
		ICsTextResource resource = assertProblems("bug1716importing2.cs", new String[] {OVERLAPPING_TOKEN}, NONE);
		Diagnostic warning = resource.getWarnings().get(0);
		assertEquals(6, warning.getLine());
		assertEquals(1, warning.getColumn());

		// we must not get a warning if the import is annotated with a
		// @SuppressWarnings tag
		assertProblems("bug1716importing3.cs", NONE, NONE);
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
	public void testTokenImport() throws FileNotFoundException, IOException {
		// this is a test for bug 795: Unused token analyser does not handle imported syntax correctly
		assertProblems("token_import1.cs", NONE, NONE);
	}

	@Test
	public void testDuplicateTokenStyleDetection() throws FileNotFoundException, IOException {
		// this is a test for bug 740
		assertProblems("duplicate_tokenstyle.cs", new String[] {DUPLICATE_TOKENSTYLE_FOUND}, NONE);
	}

	@Test
	public void testEmptyCsString() throws FileNotFoundException, IOException {
		// this is a test for bug 882
		assertProblems("empty_cs_string.cs", NONE, new String[] {EMPTY_CS_STRING_FOUND});
	}

	@Test
	public void testBooleanTerminalAnalysis() throws FileNotFoundException, IOException {
		// these are tests for the BooleanTerminal feature
		assertProblems("booleanterminal1.cs", NONE, new String[] {WRONG_ATTRIBUTE_TYPE});
		assertProblems("booleanterminal2.cs", NONE, new String[] {WRONG_CARDINALITY});
		assertProblems("booleanterminal3a.cs", NONE, new String[] {EQUAL_LITERALS});
		assertProblems("booleanterminal3b.cs", NONE, new String[] {BOTH_LITERALS_ARE_EMPTY});
		assertProblems("booleanterminal3c.cs", NONE, new String[] {FEATURE_DOES_NOT_EXIST});
	}

	@Test
	public void testSuppressWarnings() throws FileNotFoundException, IOException {
		assertProblems("suppress_warnings1a.cs", NONE, NONE);
		assertProblems("suppress_warnings1b.cs", new String[] {OPTIONAL_KEYWORD}, NONE);
		assertProblems("suppress_warnings1c.cs", NONE, new String[] {INVALID_WARNING_TYPE});
	}

	@Test
	public void testBug790() throws FileNotFoundException, IOException {
		// this is a test for bug 790
		assertProblems("bug790.cs", NONE, new String[] {GEN_CLASS_NOT_DECLARED});
	}

	@Test
	public void testBug1193() throws FileNotFoundException, IOException {
		// this is a test for bug 1193
		assertProblems("bug1193.cs", new String[] {LEFT_RECURSIVE_RULE}, NONE);
	}

	@Test
	public void testDuplicateFeatures() throws FileNotFoundException, IOException {
		// this is a test for bug 1405
		assertProblems("bug1405.cs", new String[] {DUPLICATE_FEATURE, DUPLICATE_FEATURE}, NONE);
		assertProblems("duplicate_feature1.cs", NONE, NONE);
		assertProblems("duplicate_feature2.cs", new String[] {DUPLICATE_FEATURE, DUPLICATE_FEATURE}, NONE);
		assertProblems("duplicate_feature3.cs", new String[] {DUPLICATE_FEATURE, DUPLICATE_FEATURE, DUPLICATE_FEATURE}, NONE);
		assertProblems("duplicate_feature4.cs", NONE, NONE);
	}

	@Test
	public void testBug1183() throws FileNotFoundException, IOException {
		// this is a test for bug 1183
		assertProblems("empty_star_compound.cs", new String[] {OPTIONAL_KEYWORD, OPTIONAL_KEYWORD}, new String[] {EMPTY_COMPOUND});
		assertProblems("empty_plus_compound.cs", new String[] {OPTIONAL_KEYWORD, OPTIONAL_KEYWORD}, new String[] {EMPTY_COMPOUND});
	}

	@Test
	public void testDuplicateToken() throws FileNotFoundException, IOException {
		// this is a test for bug 794: Duplicate token name analyser does not handle PREDEFINED tokens correctly
		assertProblems("duplicate_token1.cs", NONE, NONE);
	}

	@Test
	public void testBug1300() throws FileNotFoundException, IOException {
		// this is a test for bug 1300: Inline quoted token definition causes error without hint
		ICsTextResource resource = assertProblems("bug1300.cs", new String[] {OVERLAPPING_TOKEN}, NONE);
		EList<Diagnostic> warnings = resource.getWarnings();
		Diagnostic warning = warnings.get(0);
		assertTrue(warning instanceof CsResource.ElementBasedTextDiagnostic);
		CsResource.ElementBasedTextDiagnostic elementDiagnostic = (CsResource.ElementBasedTextDiagnostic) warning;
		// we check the line of the warning, because before the bug fix, the warning was attached to
		// the synthesized token definition, which did not exist in the syntax physically. thus, the
		// line was zero, because fixing the bug
		assertEquals(6, elementDiagnostic.getLine());
	}

	@Test
	public void testBug1312() throws FileNotFoundException, IOException {
		// this is a test for bug 1312: Wrong warning for choice attributes
		assertProblems("bug1312.cs", new String[] {EXPLICIT_SYNTAX_CHOICE}, NONE);
	}

	@Test
	public void testBug1537() throws FileNotFoundException, IOException {
		// this is a test for bug 1537: SuppressWarnings annotation does not remove warnings
		assertProblems("bug1537.cs", NONE, NONE);
	}

	@Test
	public void testBug1640() throws FileNotFoundException, IOException {
		// this is a test for bug 1640: Add more specific error message if path to generator
		// model is correct, but the model does not contain the referenced GenPackage
		assertProblems("bug1640.cs", NONE, new String[] {PACKAGE_NOT_FOUND, GEN_CLASS_NOT_DECLARED, GEN_CLASS_NOT_DECLARED});
	}

	@Test
	public void testBug1844() throws FileNotFoundException, IOException {
		// this is a test for bug 1844: Invalid operator rules cause ANTLR code 
		// generation to fail
		assertProblems("bug1844.cs", NONE, new String[] {OPERATORS_WITH_SAME_WEIGHT_MUST_HAVE_THE_SAME_OPERATOR_TYPE, OPERATORS_WITH_SAME_WEIGHT_MUST_HAVE_THE_SAME_OPERATOR_TYPE});
	}

	@Test
	public void testBug1404() throws FileNotFoundException, IOException {
		// these are tests for bug 1404: Add syntax analyser that emits warning if subclass restrictions yields empty set of classes with syntax
		assertProblems("bug1404a.cs", new String[] {NO_RULE_FOR_META_CLASS, NO_RULE_FOR_META_CLASS}, new String[] {SUBCLASS_RESTRICTION_YIELDS_EMPTY_SET});
		assertProblems("bug1404b.cs", new String[] {NO_RULE_FOR_META_CLASS}, NONE);
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
		assertProblems("unchangeable_reference.cs", NONE, new String[] {UNCHANGEABLE_REFERENCE});
	}

	@Test
	public void testNCReferencesWithAbstractType() throws FileNotFoundException, IOException {
		// these are tests for bug 736 and 1233
		// we do not expect warnings or errors here, because NC-references
		// without subclasses can be handled after fixing bug 1233
		assertProblems("abstractNCReferenceWithoutSubclass1.cs", NONE, NONE);
		assertProblems("abstractNCReferenceWithoutSubclass2.cs", NONE, NONE);
		assertProblems("abstractNCReferenceWithoutSubclass3.cs", NONE, NONE);
	}

	@Test
	public void testCyclicTokenDefinitionDetection() throws FileNotFoundException, IOException {
		// these are tests for the cyclic token detection
		assertProblems("cyclic_token_definition1.cs", NONE, new String[] {CYCLIC_TOKEN_DEFINITION});
		assertProblems("cyclic_token_definition2.cs", NONE, new String[] {CYCLIC_TOKEN_DEFINITION, CYCLIC_TOKEN_DEFINITION});
	}

	@Test
	public void testDuplicateOptionSetting() throws FileNotFoundException, IOException {
		assertProblems("optionSetTwice1.cs", new String[] {OPTION_SET_TWICE}, NONE);
		assertProblems("optionSetTwice2.cs", NONE, new String[] {OPTION_SET_TWICE});
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

		assertProblems("cardinality6.cs", new String[] {EXPLICIT_SYNTAX_CHOICE}, NONE);
	}

	@Test
	public void testCollectinTokenAnalysis() throws FileNotFoundException, IOException {
		// this is a test for bug 829: Collect-In tokens should raise a warning if used in CS rules
		// it is also a test for bug 1418: Tag collect-in tokens as deprecated
		assertProblems("collectin_token1.cs", new String[] {COLLECTIN_TOKENS_ARE_DEPRECATED, COLLECTIN_TOKEN_USED_IN_RULE}, NONE);
	}

	@Test
	public void testStartSymbolWithoutSyntax() throws FileNotFoundException, IOException {
		assertProblems("startWithoutSyntax.cs", new String[] {NO_RULE_FOR_META_CLASS}, new String[] {START_SYMBOL_WITHOUT_SYNTAX_FOUND});
	}

	@Test
	public void testCyclicImport() throws FileNotFoundException, IOException {
		assertProblems("cyclic_import1.cs", NONE, new String[] {CYCLIC_IMPORT});
	}

	@Test
	public void testIgnorePredefinedDirective() throws FileNotFoundException, IOException {
		assertProblems("ignore_predefined_token_directive.cs", NONE, NONE);
	}

	@Test
	public void testStartSymbolsInAbstractCSs() throws FileNotFoundException, IOException {
		assertProblems("abstractSyntaxWithStartsymbol.cs", new String[] {START_SYMBOL_IN_ABSTRACT_SYNTAX_FOUND}, NONE);
	}

	@Test
	public void testInvalidRegularExpressions() throws FileNotFoundException, IOException {
		assertProblems("invalid_regex1.cs", NONE, new String[] {INVALID_TOKEN});
		assertProblems("invalid_regex2.cs", NONE, new String[] {END_OF_REGEX_EXPECTED});
	}

	@Test
	public void testSyntaxNameWithDotAnalyser() throws FileNotFoundException, IOException {
		assertProblems("nameWith.Two.Dots.cs", NONE, new String[] {SYNTAX_NAME_MAY_CONTAIN_ONE_DOT_MAX});
		assertProblems("nameWith.OneDot.cs", NONE, new String[] {BASE_RESOURCE_PLUGIN_OPTION_MISSING});
		assertProblems("nameWith.OneDotAndOption.cs", NONE, NONE);
	}

	@Test
	public void testBug1051() throws FileNotFoundException, IOException {
		assertProblems("empty_suffix_quoted_token.cs", NONE, new String[] {EMPTY_SUFFIX});
		assertProblems("empty_prefix_quoted_token.cs", NONE, new String[] {EMPTY_PREFIX});
	}

	@Test
	public void testOperatorRuleAnalysis() throws FileNotFoundException, IOException {
		assertProblems("subclass_restriction_in_operator_rule.cs", new String[] {}, new String[] {SUBCLASS_RESTRICTIONS_IN_OPERATOR_RULES_NOT_ALLOWED});
		// non-primitive operator classes cannot be used in subclass restrictions
		assertProblems("subclass_restriction_using_nonprimitive_operator_class.cs", new String[] {}, new String[] {CANNOT_USE_OPERATOR_CLASS_DIRECTLY});
		// primitive operator classes can be used in subclass restrictions
		assertProblems("subclass_restriction_using_primitive_operator_class.cs", new String[] {}, new String[] {});
	}

	private ICsTextResource assertProblems(String filename, String[] expectedWarnings, String[] expectedErrors) {
		System.out.println("\n-----> " + filename);
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		final String path = pluginRootPath + File.separator + "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "syntax_analysis" + File.separator;
		File file = new File(path + filename);

		ICsTextResource resource = CsResourceUtil.getResource(file);
		assertNotNull(resource);

		List<Diagnostic> warnings = resource.getWarnings();
		List<Diagnostic> errors = resource.getErrors();
		printDiagnostics(warnings, filename, "warning(s)");
		printDiagnostics(errors, filename, "error(s)");
		assertDiagnostics(filename, expectedWarnings, warnings, "warning(s)");
		assertDiagnostics(filename, expectedErrors, errors, "error(s)");
		return resource;
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
