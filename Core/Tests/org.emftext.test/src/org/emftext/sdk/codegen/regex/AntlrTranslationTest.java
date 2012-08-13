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
import static org.emftext.test.ConcreteSyntaxTestHelper.loadCsResource;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.antlr.runtime3_4_0.RecognitionException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.regex.RegexpTranslationHelper;
import org.junit.Before;
import org.junit.Test;

public class AntlrTranslationTest extends TestCase {

	private static final String[] EXCLUDES = new String[] {
		".*/invalid_regex1.cs"};

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testLineTerminatorTranslation() throws IOException, RecognitionException {
		String regex = "'$'(~('$'))*'$'";
		regex = RegexpTranslationHelper.translateANTLRToJavaStyle(regex);
		assertTrue("Should match example string.","$ test $".matches(regex));

		assertFalse("Should not match empty string.","".matches(regex));
	}

	@Test
	public void testBug1493() throws IOException, RecognitionException {
		// this code does reproduce bug 1493, which was caused by the
		// ANTLR-to-Java translation of regular expressions, which is
		// not correct. Instead of fixing the translator, which is not
		// used by other parts of EMFText, we decided to use the automaton
		// framework to check whether regular expression match the empty
		// string. Therefore, the subsequent method calls are not active.
		// If we ever decide to fix the ANTLR-to-Java translation, we can
		// activate them.

		/*
		assertNotMatchesEmptyString("'|'");
		assertNotMatchesEmptyString("'|''~'");
		assertNotMatchesEmptyString("'|''~''|'");
		*/
	}

	/*
	private void assertNotMatchesEmptyString(String regex) throws IOException,
			RecognitionException {
		regex = RegexpTranslationHelper.translateANTLRToJavaStyle(regex);
		System.out.println("testBug1493() Java regex: " + regex);
		assertFalse("Must not match empty string.", "".matches(regex));
	}
	*/



	@Test
	public void testWhitespaceTranslation() {
		 Pattern pattern = java.util.regex.Pattern.compile("\\A( |\\t|\"\\f\")");
		 Matcher matcher = pattern.matcher(" ");
		 assertTrue(matcher.matches());
		 matcher = pattern.matcher("\t");
		 assertTrue(matcher.matches());

		 pattern = Pattern.compile("unsettable");
		 matcher = pattern.matcher("unsettable");
		 assertTrue(matcher.matches());

		 pattern = Pattern.compile("((<)([^(>)]|(\\\\>))*(>))|(([A-Z]|:|[a-z]|[0-9]|_|\\-)+)");
		 matcher = pattern.matcher("<http://www.test.de>");
		 assertTrue(matcher.matches());
	}

	@Test
	public void testExpsFromGrammars() throws IOException, RecognitionException {

		Collection<String> grammars = findAllGrammars(EXCLUDES);
		System.out.println(AntlrTranslationTest.class.getSimpleName() + ".testExpsFromGrammars() found " + grammars.size() + " grammar files.");
		// make sure all grammars are found
		int minGrammarCount = 168;
		assertTrue("Expected more than " + minGrammarCount + " grammars, but found " + grammars.size(), grammars.size() > minGrammarCount);

		for (String grammar : grammars) {
			System.out.println(AntlrTranslationTest.class.getSimpleName() + ".testExpsFromGrammars() testing " + grammar);
			Resource resource = loadCsResource(grammar);

			TreeIterator<EObject> contents = resource.getAllContents();
			while (contents.hasNext()) {
				EObject object = (EObject) contents.next();
				if (object instanceof CompleteTokenDefinition) {
					CompleteTokenDefinition td = (CompleteTokenDefinition) object;
					testExp(td.getRegex());
				}
			}
		}
	}

	private void testExp(String exp) throws IOException, RecognitionException {
		String javaStyle = RegexpTranslationHelper.translateANTLRToJavaStyle(exp);
		System.out.println("\tLoaded: " + exp);
		System.out.println("\tTranslated: " + javaStyle);
		Pattern p = Pattern.compile(javaStyle);
		System.out.println("\tCompiled: " + p);
		Matcher matcher = p.matcher("bla");
		System.out.println("\t\tMatches 'matcherWorks' " + matcher.matches());
	}
}
