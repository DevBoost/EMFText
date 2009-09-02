package org.emftext.test.profiling;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.ant.GenerateTextResourceTask;
import org.emftext.sdk.ant.SyntaxProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A simple profiler for the generation of the scales parser for
 * Java. This class was developed to improve the performance of the
 * code generation.
 */
public class ScannerlessJavaParserGeneratorProfiler implements SyntaxProcessor {

	public static void main(String[] args) {
		new ScannerlessJavaParserGeneratorProfiler().run();
	}
	
	public void run() {
		registerFactories();

		String syntaxProjectName = "org.emftext.language.java";

		File genmodelFile = new File(".." + File.separator + syntaxProjectName + File.separator + "metamodel" + File.separator + "java.genmodel");
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createFileURI(genmodelFile.getAbsolutePath()));
		System.out.println("GenerateScannerlessJavaParser.main() " + resource);
		
		long start = System.currentTimeMillis();
		GenerateTextResourceTask task = new GenerateTextResourceTask();
		task.registerResourceFactories();
		task.setPreprocessor(this);
		task.setRootFolder(new File(".." + File.separator).getAbsoluteFile());
		task.setSyntax(new File(".." + File.separator + syntaxProjectName + File.separator + "metamodel" + File.separator + "java.cs"));
		task.setSyntaxProjectName(syntaxProjectName);
		task.execute();
		long end = System.currentTimeMillis();
		System.out.println("GenerateScannerlessJavaParser.main() TOTAL " + (end-start) / 1000 + " seconds.");
	}

	private static void registerFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi",
				new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel",
				new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
	}

	public void process(ConcreteSyntax syntax) {
		Option parserGeneratorOption = ConcretesyntaxFactory.eINSTANCE.createOption();
		parserGeneratorOption.setType(OptionTypes.PARSER_GENERATOR);
		parserGeneratorOption.setValue("scales");
		syntax.getOptions().add(parserGeneratorOption);
	}
}
