/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.test;

import static org.emftext.sdk.codegen.Constants.MOPP_PACKAGE;
import static org.emftext.test.ConcreteSyntaxTestHelper.createANTLRGenerator;
import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntax;
import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntaxResource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.mopp.ANTLRGrammarGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsStreamUtil;

/**
 * A utility class that provides some methods to test the generation of
 * ANTLR grammars.
 */
public class GrammarGenerationTestUtil {

	public String getContent(File file) {
		try {
			return CsStreamUtil.getContent(new FileInputStream(file));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		return null;
	}

	public String getGrammar(URI fileURI) throws CoreException, IOException {
		ICsTextResource concreteSyntaxResource = (ICsTextResource) getConcreteSyntaxResource(fileURI);
		ConcreteSyntax concreteSyntax = getConcreteSyntax(concreteSyntaxResource);
		IGenerator<GenerationContext, ArtifactParameter<GenerationContext>> antlrGen = createANTLRGenerator(concreteSyntax);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> antlrGrammar = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "ANTLR grammar", "", ANTLRGrammarGenerator.class, OptionTypes.OVERRIDE_PARSER);
		antlrGen.generate(new TestGenerationContext(concreteSyntax, new TestProblemCollector()), new ArtifactParameter<GenerationContext>(antlrGrammar), out);
		InputStream grammarStream = new ByteArrayInputStream(out.toByteArray());
		return CsStreamUtil.getContent(grammarStream);
	}
}
