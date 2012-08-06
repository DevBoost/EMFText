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
import org.emftext.test.ConcreteSyntaxTestHelper;

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
		ConcreteSyntaxTestHelper.registerResourceFactories();

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

	public void process(ConcreteSyntax syntax) {
		Option parserGeneratorOption = ConcretesyntaxFactory.eINSTANCE.createOption();
		parserGeneratorOption.setType(OptionTypes.PARSER_GENERATOR);
		parserGeneratorOption.setValue("scales");
		syntax.getOptions().add(parserGeneratorOption);
	}
}
