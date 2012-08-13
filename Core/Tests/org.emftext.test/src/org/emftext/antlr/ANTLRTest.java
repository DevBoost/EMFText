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
package org.emftext.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.List;

import junit.framework.TestCase;

import org.antlr.runtime3_4_0.ANTLRInputStream;
import org.antlr.runtime3_4_0.CharStream;
import org.antlr.runtime3_4_0.CommonTokenStream;
import org.antlr.runtime3_4_0.RecognitionException;
import org.antlr.runtime3_4_0.TokenSource;
import org.antlr.runtime3_4_0.TokenStream;

/**
 * This is a test for bug 1226. Actually this test confirms
 * that bug 1226 is not a bug. ANTLR does correctly handle 
 * in-line tokens no matter whether they are alpha-numerical
 * or not.
 */
public class ANTLRTest extends TestCase {

	/**
	 * Runs ANTLR to generate a lexer and parser for the
	 * test grammar.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		runANTLR("Keywords.g");
		runANTLR("Bug1492a.g");
		runANTLR("Bug1492b.g");
		runANTLR("Bug1499.g");
	}

	private static void runANTLR(String grammarName) {
		String path = "./src/org/emftext/antlr";
		org.antlr.Tool antlrTool = new org.antlr.Tool(new String[] { "-o",
				new java.io.File(path).getAbsolutePath(),
				path + "/" + grammarName });
		antlrTool.process();
	}

	public void testKeywordTreatment() {
		assertParsing(KeywordsParser.class, KeywordsLexer.class, "keyword", "r2");
		assertParsing(KeywordsParser.class, KeywordsLexer.class, "[", "r1");
	}

	public void testBug1492a() {
		assertParsing(Bug1492aParser.class, Bug1492aLexer.class, "ident1 ident2", "ok");
	}

	public void testBug1492b() {
		assertParsing(Bug1492bParser.class, Bug1492bLexer.class, "ident1 = ident2", "ok");
		assertParsing(Bug1492bParser.class, Bug1492bLexer.class, "ident1 += ident2", "ok");
	}

	public void testBug1499() {
		assertParsing(Bug1499Parser.class, Bug1499Lexer.class, "[]", "ok");
		assertParsing(Bug1499Parser.class, Bug1499Lexer.class, "|~|", "ok");
		assertParsing(Bug1499Parser.class, Bug1499Lexer.class, "\r[]", "ok");
		assertParsing(Bug1499Parser.class, Bug1499Lexer.class, "\r|~|", "ok");
		assertParsing(Bug1499Parser.class, Bug1499Lexer.class, "  []", "ok");
		assertParsing(Bug1499Parser.class, Bug1499Lexer.class, "  |~|", "ok");
	}

	private void assertParsing(Class<?> parserClass, Class<?> lexerClass, String text, String expectedResult) {
		InputStream inputStream = new ByteArrayInputStream(text.getBytes());
		try {
			TokenSource lexer = createLexer(lexerClass, inputStream);
			AbstractParser parser = createParser(parserClass, lexer);
			String actualResult = parser.root();
			List<RecognitionException> errors = parser.getErrors();
			for (RecognitionException recognitionException : errors) {
				System.out.println("ERROR " + recognitionException.getClass() + ": " + recognitionException.toString());
			}
			assertTrue("Parsing must not yield errors.", errors.isEmpty());
			assertEquals(expectedResult, actualResult);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private AbstractParser createParser(Class<?> parserClass, TokenSource lexer) {
		try {
			Constructor<?> constructor = parserClass.getConstructor(TokenStream.class);
			Object instance = constructor.newInstance(new CommonTokenStream(lexer));
			return (AbstractParser) instance;
		} catch (Exception e) {
			e.printStackTrace();
			fail("Can't create parser.");
			return null;
		}
	}

	private TokenSource createLexer(Class<?> lexerClass, InputStream inputStream) throws IOException {
		try {
			Constructor<?> constructor = lexerClass.getConstructor(CharStream.class);
			Object instance = constructor.newInstance(new ANTLRInputStream(inputStream));
			return (TokenSource) instance;
		} catch (Exception e) {
			e.printStackTrace();
			fail("Can't create lexer.");
			return null;
		}
	}
}
