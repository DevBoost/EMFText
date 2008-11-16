package org.reuseware.emftextedit.test;

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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.sdk.codegen.BaseGenerator;
import org.reuseware.emftextedit.sdk.codegen.GenerationProblem;
import org.reuseware.emftextedit.sdk.codegen.IGenerator;
import org.reuseware.emftextedit.sdk.codegen.PutEverywhereSyntaxExtender;
import org.reuseware.emftextedit.sdk.codegen.ResourcePackageGenerator;
import org.reuseware.emftextedit.sdk.codegen.TextParserGenerator;
import org.reuseware.emftextedit.sdk.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.CsResourceImpl;

public class ConcreteSyntaxTestHelper {

	public static void registerResourceFactories() {
		org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.CsResourceFactoryImpl csResourceFactoryImpl = new org.reuseware.emftextedit.sdk.concretesyntax.resource.cs.CsResourceFactoryImpl();
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
		TextResource resource = new CsResourceImpl(fileURI);
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

	public static IGenerator createANTLRGenerator(ConcreteSyntax concreteSyntax) {
		String antlrName = BaseGenerator.cap(concreteSyntax.getName());
		GenPackage csPackage = concreteSyntax.getPackage();
		String csBasePackage = csPackage.getBasePackage();
		EPackage ecorePackage = csPackage.getEcorePackage();
		String csPackageName = (csBasePackage == null ? "" : csBasePackage
				+ ".")
				+ ecorePackage.getName()
				+ ".resource."
				+ concreteSyntax.getName();
		String tokenResolverFactoryName = antlrName
				+ ResourcePackageGenerator.CLASS_TOKEN_RESOLVER_FACTORY;

		IGenerator antlrGenerator = new TextParserGenerator(concreteSyntax,
				antlrName, csPackageName, tokenResolverFactoryName);
		return antlrGenerator;
	}

	public static File generateANTLRGrammarToTempFile(URI fileURI, Map<?,?> options) throws IOException,
			FileNotFoundException {
		ConcreteSyntax concreteSyntax = getConcreteSyntax(getConcreteSyntaxResource(fileURI, options));
		assertNotNull("The concrete syntax should be successfully loaded.",
				concreteSyntax);
		new PutEverywhereSyntaxExtender().generatePutEverywhereExtensions(concreteSyntax);

		IGenerator antlrGenerator = createANTLRGenerator(concreteSyntax);

		File tempGrammarFile = File.createTempFile(
				ConcreteSyntaxTestHelper.class.getSimpleName(), ".g");
		tempGrammarFile.deleteOnExit();
		boolean success = antlrGenerator.generate(new PrintWriter(
				new FileOutputStream(tempGrammarFile)));
		Collection<GenerationProblem> problems = antlrGenerator.getOccuredWarningsAndErrors();
		for (GenerationProblem problem : problems) {
			System.out.println("generateANTLRGrammarToTempFile() " + problem.getMessage());
		}
		assertTrue(success);
		return tempGrammarFile;
	}
}
