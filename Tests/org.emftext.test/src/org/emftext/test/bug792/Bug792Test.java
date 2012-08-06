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
package org.emftext.test.bug792;

import static org.emftext.sdk.codegen.Constants.MOPP_PACKAGE;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.ByteArrayOutputStream;
import java.io.File;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.mopp.ANTLRGrammarGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.PluginTestHelper;
import org.emftext.test.TestGenerationContext;
import org.emftext.test.TestProblemCollector;
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
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		final String path = pluginRootPath + File.separator + "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "bug792" + File.separator;
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
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		GenerationContext context = new TestGenerationContext(concreteSyntax, new TestProblemCollector());

		ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> antlrGrammar = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "ANTLR grammar", "", ANTLRGrammarGenerator.class, OptionTypes.OVERRIDE_PARSER);
		antlrGenerator.generate(context, new ArtifactParameter<GenerationContext>(antlrGrammar), baos);

		String grammar = new String(baos.toByteArray());
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
