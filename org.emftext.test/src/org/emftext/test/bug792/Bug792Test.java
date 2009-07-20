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
package org.emftext.test.bug792;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.generators.ANTLRGrammarGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.junit.Before;
import org.junit.Test;

/**
 * A test case for bug 792.
 */
public class Bug792Test extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testBug792() throws Exception {
		final String filename = "Start.cs";
		final String path = "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "bug792" + File.separator;
		String absolutePath = new File(path + filename).getAbsolutePath();
		URI fileURI = URI.createFileURI(absolutePath);
		
		ConcreteSyntax concreteSyntax = ConcreteSyntaxTestHelper.getConcreteSyntax(
				ConcreteSyntaxTestHelper.getConcreteSyntaxResource(fileURI));
		assertNotNull("The concrete syntax should be successfully loaded.",
				concreteSyntax);
		
		ANTLRGrammarGenerator antlrGenerator = ConcreteSyntaxTestHelper.createANTLRGenerator(concreteSyntax);

		File tempGrammarFile = File.createTempFile(
				ConcreteSyntaxTestHelper.class.getSimpleName(), ".g");
		tempGrammarFile.deleteOnExit();
		StringWriter writer = new StringWriter();
		
		boolean success = antlrGenerator.generate(new PrintWriter(writer));
		Collection<GenerationProblem> problems = antlrGenerator.getCollectedProblems();
		for (GenerationProblem problem : problems) {
			System.out.println("Problem when generating ANTLR grammar: " + problem.getMessage());
		}
		
		assertTrue(success);
		
		String grammar = writer.toString();
		String whitespaces = "[ \\t]+";
		String[] parts = "a b".split(whitespaces);
		assertEquals(2, parts.length);
		parts = "ab cd".split("b" + whitespaces + "c");
		assertEquals(2, parts.length);
		parts = "ab \t\t cd".split("b" + whitespaces + "c");
		assertEquals(2, parts.length);
		
		String startRulePattern = "start" + whitespaces + "returns";
		parts = grammar.split(startRulePattern);
		
		// there should be exactly one "start" rule
		assertTrue("There should be exactly one start rule.", parts.length == 2);
	}
}
