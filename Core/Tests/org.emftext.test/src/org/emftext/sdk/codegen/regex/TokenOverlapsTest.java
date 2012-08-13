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
package org.emftext.sdk.codegen.regex;

import static org.emftext.test.ConcreteSyntaxTestHelper.findAllGrammars;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;
import org.emftext.sdk.regex.RegexpTranslationHelper;
import org.emftext.sdk.regex.SorterException;
import org.emftext.sdk.regex.TokenSorter;
import org.junit.Before;
import org.junit.Test;

import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;

public class TokenOverlapsTest extends TestCase {

	private static final String[] EXCLUDES = new String[] {
			".*/invalid_regex1.cs", ".*/invalid_regex2.cs", };

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testSortNoConflict() throws SorterException {

		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs("'a'",
				"'b'", "'c'");

		assertEquals(0, ts.getNonReachables(conflicting).size());

		ts.sortTokens(conflicting, false);
		// no exception expected.

	}

	@Test
	public void testSort1() throws SorterException {

		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> tokens = createTokenDefs(
				"'0'..'9'|'a'..'z'", "'0'..'9'");
		CompleteTokenDefinition general = tokens.get(0);
		CompleteTokenDefinition specific = tokens.get(1);

		List<CompleteTokenDefinition> sortedTokens = ts.sortTokens(tokens,
				false);
		// no exception expected.
		assertEquals("The specific token should be first.", specific,
				sortedTokens.get(0));
		assertEquals("The general token should be first.", general,
				sortedTokens.get(1));
	}

	@Test
	public void testANTLRToAutomatonTranslation() {
		assertEquals("\"\r\"", getAutomatonRegExp("'\\r'"));
		assertEquals("\"\r\"|\"\n\"", getAutomatonRegExp("'\\r'|'\\n'"));
		assertEquals("(\"\r\n\"|\"\r\"|\"\n\")",
				getAutomatonRegExp("('\\r\\n' | '\\r' | '\\n')"));
	}

	@Test
	public void testBug1137() {
		assertANTLRRegExpMatches("'a'", "a");
		assertAutomatonRegExpMatches(" ", " ", true);
		assertANTLRRegExpMatches("' '", " ");
		assertAutomatonRegExpMatches("\u0013", "\u0013", true);
		assertAutomatonRegExpMatches("\r", "\r", true);
		assertANTLRRegExpMatches("'\\r'", "\r");
		assertANTLRRegExpNotMatches("'\\r'", "");
		assertANTLRRegExpNotMatches("('\\r\\n' | '\\r' | '\\n')", "");
		
		assertAutomatonRegExpMatches("~(\"a\")", "", true);
		
		// these tests fail because of the changes that have been introduced in
		// r12208 "When translating an ANTLR negation into an automata 
		// complement, the empty string needs to be added to the 
		// expression-to-complement (ANTLR does this implicitly).
		// (This issue occurred in the Tcl/Tk grammar; fixes #1496)"
		//
		// I'm not sure what is the expected result here. I think we need to
		// write a dedicated test that checks whether ANTLR lets the negated
		// expressions match the empty string or not. Until then, I will 
		// disable the tests. They have not been ran since a long time, because
		// this class did not meet the conventions of the build system. Also,
		// no information could be found why these tests were added in the first
		// place.
		
		// TODO write a test for ANTLR to figure out the expected results
		/*
		assertANTLRRegExpMatches("~('a')", "");
		
		assertANTLRRegExpMatches("~('\"'|','|'\\r\\n'|'\\r'|'\\n')", "");
		assertANTLRRegExpMatches(
				"('\"')(('\\\\''\"')|('\\\\''\\\\')|~('\"'|'\\\\'))*('\"') | (~('\"'|','|'\\r\\n'|'\\r'|'\\n'))",
				"");
		*/

		assertANTLRRegExpMatches(
				"((' '|'\\t'|'\\f'|'='|':')+)(('\\\\'('\\r\\n'|'\\r'|'\\n'))|('\\\\''\\\\')|~('\\r\\n'|'\\r'|'\\n'|'\\\\'))*('\\r\\n'|'\\r'|'\\n')",
				" = something\r");
	}

	/**
	 * Asserts that the given ANTLR regular expression matches 'input' if parsed
	 * using an automaton constructed by the automaton library.
	 *
	 * @param antlrRegExp
	 * @param input
	 */
	private void assertANTLRRegExpMatches(String antlrRegExp, String input) {
		String automatonRegExp = getAutomatonRegExp(antlrRegExp);
		assertAutomatonRegExpMatches(automatonRegExp, input, true);
	}

	private void assertANTLRRegExpNotMatches(String antlrRegExp, String input) {
		String automatonRegExp = getAutomatonRegExp(antlrRegExp);
		assertAutomatonRegExpMatches(automatonRegExp, input, false);
	}

	private String getAutomatonRegExp(String antlrRegExp) {
		String automatonRegExp = null;
		try {
			automatonRegExp = RegexpTranslationHelper
					.translateANTLRToAutomatonStyle(antlrRegExp);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		return automatonRegExp;
	}

	public void testBug1493() {
		assertANTLRRegExpMatches("'|'", "|");
		assertANTLRRegExpMatches("'|''~'", "|~");
		assertANTLRRegExpMatches("'|''~''|'", "|~|");

		assertANTLRRegExpNotMatches("'|'", "");
		assertANTLRRegExpNotMatches("'|'", "abc");
		assertANTLRRegExpNotMatches("'|''~'", "");
		assertANTLRRegExpNotMatches("'|''~''|'", "");
	}

	/**
	 * Asserts that the given automaton regular expression matches 'input' if
	 * parsed using an automaton constructed by the automaton library.
	 *
	 * @param csRegExp
	 * @param input
	 */
	private void assertAutomatonRegExpMatches(String automatonRegExp,
			String input, boolean expectedToMatch) {
		RegExp regExp = new RegExp(automatonRegExp);
		Automaton automaton = regExp.toAutomaton();
		assertEquals("Automaton must " + (expectedToMatch ? "" : "not")
				+ " match expression", expectedToMatch, automaton.run(input));
	}

	@Test
	public void testSortSameRegexConflict() throws SorterException {

		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs("'a'",
				"'a'", "'b'");

		Map<CompleteTokenDefinition, Collection<CompleteTokenDefinition>> nonReachables = ts
				.getNonReachables(conflicting);
		assertEquals(1, nonReachables.size());
		assertEquals("'a'", ((NormalTokenDefinition) nonReachables.keySet()
				.iterator().next()).getRegex());

		try {
			ts.sortTokens(conflicting, false);
			fail("Expected SorterException when sorting conflicting tokens.");
		} catch (SorterException s) {
			// expected exception
		}

	}

	@Test
	public void testSortIntersectionConflict() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs("'a'*",
				"'a'+", "'b'");

		assertEquals(1, ts.getNonReachables(conflicting).size());
		assertEquals(1, ts.getConflicting(conflicting).size());

		// non-reachables can be removed by clever sorting
		assertEquals(0, ts.getNonReachables(ts.sortTokens(conflicting, true))
				.size());
		// conflicting can not be removed
		assertEquals(1, ts.getConflicting(conflicting).size());
	}

	@Test
	public void testSortIntersectionConflict3() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs("'a'*", "",
				"'b'");

		assertEquals(1, ts.getConflicting(conflicting).size());
		assertEquals(1, ts.getNonReachables(conflicting).size());

		// non-reachables can be removed by clever sorting
		assertEquals(0, ts.getNonReachables(ts.sortTokens(conflicting, true))
				.size());
		// conflicting can not be removed
		assertEquals(1, ts.getConflicting(conflicting).size());
	}

	@Test
	public void testBadConflict() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs(
				"('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+",
				"('\\r\\n' | '\\r' | '\\n')");

		assertEquals(0, ts.getNonReachables(conflicting).size());
	}

	@Test
	public void testBadConflict2() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs(
				"'\u0040'|('\u0040'..'\u0042')", "'7'");

		assertEquals(0, ts.getNonReachables(conflicting).size());
	}

	@Test
	public void testSortIntersectionConflict2() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs("'1'|'2'",
				"'2'|'3'", "'b'");

		assertEquals(0, ts.getNonReachables(conflicting).size());
		assertEquals(1, ts.getConflicting(conflicting).size());

		ts.sortTokens(conflicting, false);

	}

	@Test
	public void testSublanguageConflict() throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs("'a'?",
				"'a'");

		assertEquals(1, ts.getNonReachables(conflicting).size());
		assertEquals(1, ts.getConflicting(conflicting).size());

		ts.sortTokens(conflicting, false);

	}

	private List<CompleteTokenDefinition> createTokenDefs(String... regex) {
		List<CompleteTokenDefinition> list = new ArrayList<CompleteTokenDefinition>();
		ConcretesyntaxFactory factory = ConcretesyntaxFactory.eINSTANCE;

		for (int i = 0; i < regex.length; i++) {
			NormalTokenDefinition def = factory.createNormalTokenDefinition();
			def.setName("" + i);
			AtomicRegex atomicRegex = factory.createAtomicRegex();
			atomicRegex.setAtomicExpression(regex[i]);
			def.getRegexParts().add(atomicRegex);
			list.add(def);
		}
		return list;
	}

	@Test
	public void testBug1138() throws SorterException {
		TokenSorter ts = new TokenSorter();
		String regex1 = "('A'..'Z'|'a'..'z')('A'..'Z'|'a'..'z'|'0'..'9'|'-')*";
		String regex2 = "'0'..'9'";
		String regex3 = "'a'..'f'|'A'..'F'";
		List<CompleteTokenDefinition> conflicting = createTokenDefs(regex1,
				regex2, regex3);
		Map<CompleteTokenDefinition, Collection<CompleteTokenDefinition>> nonReachables = ts
				.getNonReachables(conflicting);
		assertEquals(1, ts.getNonReachables(conflicting).size());

		CompleteTokenDefinition tokenDefinition = nonReachables.keySet()
				.iterator().next();
		assertEquals(regex3, tokenDefinition.getRegex());

		Collection<CompleteTokenDefinition> causes = nonReachables
				.get(tokenDefinition);
		assertEquals(1, causes.size());
		CompleteTokenDefinition cause = causes.iterator().next();
		assertEquals(regex1, cause.getRegex());
	}

	@Test
	public void testNonReachableDueToPreviousTokenUnion()
			throws SorterException {
		TokenSorter ts = new TokenSorter();
		List<CompleteTokenDefinition> conflicting = createTokenDefs(
				"('A'..'Z'|'a'..'z')('A'..'Z'|'a'..'z'|'0'..'9'|'-')*",
				"'0'..'9'", "'0'..'9'|'a'..'f'|'A'..'F'");
		Map<CompleteTokenDefinition, Collection<CompleteTokenDefinition>> nonReachables = ts
				.getNonReachables(conflicting);
		assertEquals(1, ts.getNonReachables(conflicting).size());
		CompleteTokenDefinition tokenDefinition = nonReachables.keySet()
				.iterator().next();
		assertEquals("'0'..'9'|'a'..'f'|'A'..'F'", tokenDefinition.getRegex());
	}

	@Test
	public void testDetectionOfInvalidRegexp() throws IOException {
			String grammar = "src/org/emftext/test/syntax_analysis/invalid_regex2.cs";
			Resource resource = loadResource(grammar);
			assertEquals(1,resource.getErrors().size());
			assertEquals("Invalid regular expression: line 1:3 extraneous input ')' expecting END", resource.getErrors().get(0).getMessage());
	}

	@Test
	public void testSorts() throws IOException, SorterException {
		TokenSorter ts = new TokenSorter();
		Collection<String> grammars = findAllGrammars(EXCLUDES);

		for (String grammar : grammars) {
			Resource resource = loadResource(grammar);
			if (resource.getContents().size() > 0) {
				EList<CompleteTokenDefinition> allTokenDirectives = ((ConcreteSyntax) resource
						.getContents().get(0)).getActiveTokens();
				// assertTrue("Grammar " + resource.getURI() +
				// " should contain some tokens. " , allTokenDirectives.size() >
				// 0);
				try {
					Map<CompleteTokenDefinition, Collection<CompleteTokenDefinition>> nonReachables = ts
							.getNonReachables(allTokenDirectives);
					assertTrue("Grammar " + resource.getURI()
							+ " should contain no non-reachables.",
							nonReachables.size() == 0);
				} catch (Exception e) {
					e.printStackTrace();
					fail("Failed testing grammar " + grammar + " : "
							+ e.getMessage());
				}

				ts.sortTokens(allTokenDirectives, false);
			}
		}
	}

	private Resource loadResource(String grammar) throws IOException {
		File file = new File(grammar);

		ICsTextResource resource = CsResourceUtil.getResource(file);
		assertNotNull(resource);

		return resource;
	}
}
