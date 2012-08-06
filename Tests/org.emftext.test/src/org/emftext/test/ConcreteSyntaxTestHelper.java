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
package org.emftext.test;

import static org.emftext.sdk.codegen.Constants.MOPP_PACKAGE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.mopp.ANTLRGrammarGenerator;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;
import org.junit.Assert;

/**
 * A helper class for all EMFText tests.
 */
public class ConcreteSyntaxTestHelper {

	private static final String[] EXCLUDED_FILES = new String[] {
		".*/CheckCSSyntax.cs",
		".*/ecore.cs",
		".*/standardSyntax/forms.cs",
		".*/rev6618/java_templates.cs",
		".*/org.emftext.test.ant/metamodel/simple.cs",
		".*/org.emftext.test.atl/model/example.cs",
		".*/org.emftext.test.code_completion.test/input/cs/.*",
		".*/concretesyntax.newfile.cs"
	};

	public static void registerEcoreGenModel() {
		String genModelPath = "/model/Ecore.genmodel";
		String nsURI = "http://www.eclipse.org/emf/2002/Ecore";
		Class<EClass> clazz = EClass.class;

		registerGenModel(genModelPath, nsURI, clazz);
	}

	public static void registerGenModelGenModel() {
		String genModelPath = "/model/GenModel.genmodel";
		String nsURI = "http://www.eclipse.org/emf/2002/GenModel";
		Class<GenClass> clazz = GenClass.class;

		registerGenModel(genModelPath, nsURI, clazz);
	}

	private static void registerGenModel(String genModelPath, String nsURI, Class<?> clazz) {
		final Map<String, URI> packageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		String path = clazz.getResource(genModelPath).getFile();
		path = path.replace("file:/", "archive:file:/");
		URI uri = URI.createURI(path);
		packageNsURIToGenModelLocationMap.put(nsURI, uri);
	}

	public static void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi",
				new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());

		new CsMetaInformation().registerResourceFactory();
	}

	public static ConcreteSyntax getConcreteSyntax(Resource csResource) {
		ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource
				.getContents().get(0);
		return concreteSyntax;
	}

	public static ConcreteSyntax getConcreteSyntax(String path) {
		try {
			return getConcreteSyntax(loadCsResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		return null;
	}

	public static Resource getConcreteSyntaxResource(URI fileURI) {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(fileURI, true);
		final Set<EObject> proxies = CsResourceUtil.findUnresolvedProxies(resource);
		for (EObject proxy : proxies) {
			System.out.println("getConcreteSyntaxResource() unresolved proxy : " + proxy);
		}
		final List<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("getConcreteSyntaxResource() error : " + error.getMessage());
		}
		assertTrue("The CS file must not contain errors.", errors.isEmpty());
		return resource;
	}

	public static ANTLRGrammarGenerator createANTLRGenerator(ConcreteSyntax concreteSyntax) {
		ANTLRGrammarGenerator antlrGenerator = new ANTLRGrammarGenerator();
		return antlrGenerator;
	}

	public static File generateANTLRGrammarToTempFile(URI fileURI, IProblemCollector problemCollector) throws IOException,
			FileNotFoundException {
		ConcreteSyntax concreteSyntax = getConcreteSyntax(getConcreteSyntaxResource(fileURI));
		assertNotNull("The concrete syntax should be successfully loaded.",
				concreteSyntax);

		ANTLRGrammarGenerator antlrGenerator = createANTLRGenerator(concreteSyntax);

		File tempGrammarFile = File.createTempFile(
				ConcreteSyntaxTestHelper.class.getSimpleName(), ".g");
		tempGrammarFile.deleteOnExit();
		GenerationContext context = new TestGenerationContext(concreteSyntax, problemCollector);
		ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> antlrGrammar = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "ANTLR grammar", "", ANTLRGrammarGenerator.class, OptionTypes.OVERRIDE_PARSER);
		antlrGenerator.generate(context, new ArtifactParameter<GenerationContext>(antlrGrammar), new FileOutputStream(tempGrammarFile));
		return tempGrammarFile;
	}


	public static Resource loadCsResource(String grammar) throws IOException {
		File file = new File(grammar);

		ICsTextResource resource = CsResourceUtil.getResource(file.getAbsoluteFile());
		assertNotNull(resource);

		return resource;
	}

	public static Collection<String> findAllGrammars(final String... additionalExcludes) {
		Collection<String> grammarPaths = new LinkedHashSet<String>();

		// use WorkspaceIndexer to find grammar files quickly
		Collection<File> allGrammarFiles = new WorkspaceIndexer().getFilesFromIndex(".cs");
		for (File file : allGrammarFiles) {
			String path = file.getAbsolutePath();
			String normlizedPath = path.replace(File.separator, "/");
			boolean isExcluded = false;
			for (String excludedFile : EXCLUDED_FILES) {
				if (normlizedPath.matches(excludedFile)) {
					isExcluded = true;
					break;
				}
			}
			if (additionalExcludes != null) {
				for (String excludedFile : additionalExcludes) {
					if (normlizedPath.matches(excludedFile)) {
						isExcluded = true;
						break;
					}
				}
			}
			if (isExcluded) {
				continue;
			}
			grammarPaths.add(file.getAbsolutePath());
		}
		return grammarPaths;
	}
}
