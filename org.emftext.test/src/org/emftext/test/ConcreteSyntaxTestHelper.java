package org.emftext.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.generators.TextParserGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.CsResource;

/**
 * A helper class for all EMFText tests.
 */
public class ConcreteSyntaxTestHelper {

	public static void registerResourceFactories() {
		org.emftext.sdk.concretesyntax.resource.cs.CsResourceFactory csResourceFactoryImpl = new org.emftext.sdk.concretesyntax.resource.cs.CsResourceFactory();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cs",
				csResourceFactoryImpl);
	}

	public static ConcreteSyntax getConcreteSyntax(Resource csResource) {
		ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource
				.getContents().get(0);
		return concreteSyntax;
	}

	public static Resource getConcreteSyntaxResource(URI fileURI, Map<?, ?> options) {
		ITextResource resource = new CsResource(fileURI);
		try {
			resource.load(options);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		final EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("getConcreteSyntaxResource() error : " + error.getMessage());
		}
		assertTrue("The CS file should not contain errors.", errors.isEmpty());
		return resource;
	}

	public static TextParserGenerator createANTLRGenerator(ConcreteSyntax concreteSyntax) {
		IProblemCollector collector = new IProblemCollector() {
			public void addProblem(GenerationProblem problem) {
				fail();
			}
		};
		GenerationContext context = new GenerationContext(concreteSyntax, collector);
		TextParserGenerator antlrGenerator = new TextParserGenerator(context);
		return antlrGenerator;
	}

	public static File generateANTLRGrammarToTempFile(URI fileURI, Map<?,?> options) throws IOException,
			FileNotFoundException {
		ConcreteSyntax concreteSyntax = getConcreteSyntax(getConcreteSyntaxResource(fileURI, options));
		assertNotNull("The concrete syntax should be successfully loaded.",
				concreteSyntax);
		
		TextParserGenerator antlrGenerator = createANTLRGenerator(concreteSyntax);

		File tempGrammarFile = File.createTempFile(
				ConcreteSyntaxTestHelper.class.getSimpleName(), ".g");
		tempGrammarFile.deleteOnExit();
		boolean success = antlrGenerator.generate(new PrintWriter(
				new FileOutputStream(tempGrammarFile)));
		Collection<GenerationProblem> problems = antlrGenerator.getCollectedProblems();
		for (GenerationProblem problem : problems) {
			System.out.println("generateANTLRGrammarToTempFile() " + problem.getMessage());
		}
		assertTrue(success);
		return tempGrammarFile;
	}
}
