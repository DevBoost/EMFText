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
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

import junit.framework.Assert;

/**
 * A utility class that provides some methods to test the generation of
 * ANTLR grammars.
 */
public class GrammarGenerationTestUtil {

	public String getContent(InputStream grammarStream) {
		StringBuffer content = new StringBuffer();
		try {
			InputStreamReader reader = new InputStreamReader(grammarStream);
			int next = -1;
			while ((next = reader.read()) >= 0) {
				content.append((char) next);
			}
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		return content.toString();
	}

	public String getContent(File file) {
		try {
			return getContent(new FileInputStream(file));
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		return null;
	}

	public String getGrammar(URI fileURI) throws CoreException {
		ITextResource concreteSyntaxResource = (ITextResource) getConcreteSyntaxResource(fileURI);
		ConcreteSyntax concreteSyntax = getConcreteSyntax(concreteSyntaxResource);
		IGenerator antlrGen = createANTLRGenerator(concreteSyntax);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		antlrGen.generate(new PrintWriter(out));
		InputStream grammarStream = new ByteArrayInputStream(out.toByteArray());
		return getContent(grammarStream);
	}
}
