package org.emftext.test;

import static org.emftext.test.ConcreteSyntaxTestHelper.createANTLRGenerator;
import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntax;
import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntaxResource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import junit.framework.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.util.StreamUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A utility class that provides some methods to test the generation of
 * ANTLR grammars.
 */
public class GrammarGenerationTestUtil {

	public String getContent(File file) {
		try {
			return StreamUtil.getContent(new FileInputStream(file));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		return null;
	}

	public String getGrammar(URI fileURI) throws CoreException, IOException {
		ITextResource concreteSyntaxResource = (ITextResource) getConcreteSyntaxResource(fileURI);
		ConcreteSyntax concreteSyntax = getConcreteSyntax(concreteSyntaxResource);
		IGenerator antlrGen = createANTLRGenerator(concreteSyntax);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		antlrGen.generate(new PrintWriter(out));
		InputStream grammarStream = new ByteArrayInputStream(out.toByteArray());
		return StreamUtil.getContent(grammarStream);
	}
}
