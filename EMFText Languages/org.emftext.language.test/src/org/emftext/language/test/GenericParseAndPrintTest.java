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
package org.emftext.language.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IMetaInformation;

/**
 * This generic test checks whether there is a test plug-in for each
 * language deployed on the EMFText update site. Each file found in 
 * the folder 'input' contained in the test plug-in is parsed, printed 
 * and parsed again. Afterwards the resulting EObject tree are compared.
 */
public class GenericParseAndPrintTest extends TestCase {

	public void setUp() {
		
	}
	
	public void testParsingAndPrinting() {
		TestLanguageRegistry registry = new TestLanguageRegistry();
		Set<Object> metaInformations = registry.getMetaInformationsForLanguageOnUpdateSite();
		for (Object metaInformation : metaInformations) {
			IMetaInformation castedInfo = (IMetaInformation) EMFTextAccessProxy.get(metaInformation, IMetaInformation.class);
	        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
        		castedInfo.getSyntaxName(),
        		castedInfo.createResourceFactory()
    		); 
			final String syntaxName = castedInfo.getSyntaxName();
			System.out.println("-------- Testing " + syntaxName);
			String pathToCS = castedInfo.getPathToCSDefinition();
			String pluginName = pathToCS.substring(0, pathToCS.indexOf('/'));
			System.out.println("Plugin with CS definition: " + pluginName);
			String testPluginName = pluginName + ".test";
			System.out.println("Expected test plugin: " + testPluginName);
			File testPluginFolder = new File(".." + File.separator + testPluginName);
			assertTrue("No test plugin found.", testPluginFolder.exists());
			assertTrue("Test plugin folder is not a directory.", testPluginFolder.isDirectory());

			String testInputFolderPath = testPluginFolder.getAbsolutePath() + File.separator + "input";
			System.out.println("Expected test input folder: " + testInputFolderPath);
			File testInputFolder = new File(testInputFolderPath);
			assertTrue("No test input folder found.", testInputFolder.exists());
			assertTrue("Test input folder is not a directory.", testInputFolder.isDirectory());
			
			File[] inputFiles = testInputFolder.listFiles(new FilenameFilter() {
				
				public boolean accept(File dir, String name) {
					return name.endsWith("." + syntaxName);
				}
			});
			
			for (File inputFile : inputFiles) {
				testInputFile(syntaxName, inputFile);
			}
		}
	}

	private void testInputFile(final String syntaxName, File inputFile) {
		System.out.println("----- Loading input file " + inputFile.getAbsolutePath());
		// load input file
		ResourceSetImpl rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createFileURI(inputFile.getAbsolutePath()), true);
		assertEmptyList("error", resource.getErrors());
		EList<EObject> contents = resource.getContents();
		assertTrue("Resource must contain one element", contents.size() == 1);
		EObject root = contents.get(0);
		System.out.println("----- Printing content of input file");
		// print content of input files to buffer in memory
		Resource printResultResource = rs.createResource(URI.createURI("printResult." + syntaxName));
		printResultResource.getContents().addAll(contents);
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			printResultResource.save(buffer, null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		String printResult = buffer.toString();
		System.out.println("Print result: \"" + printResult + "\"");
		System.out.println("----- Parsing printed content");
		// parse print result
		Resource parsedFromPrintResource = rs.createResource(URI.createURI("parsedFromPrintResult." + syntaxName));
		try {
			parsedFromPrintResource.load(new ByteArrayInputStream(printResult.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertEmptyList("error", parsedFromPrintResource.getErrors());
		EList<EObject> newContents = parsedFromPrintResource.getContents();
		assertTrue("Resource must contain one element", newContents.size() == 1);
		EObject newRoot = newContents.get(0);
		// compare object trees created by first and second parse run
		try {
			compareModels(root, newRoot);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	private void assertEmptyList(String string, EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(string + " found: " + diagnostic.getMessage() + " at " + diagnostic.getLocation() + " (" + + diagnostic.getLine() + "," + diagnostic.getColumn() + ")");
		}
		assertTrue("Resource should not contain " + string + "(s).", diagnostics.size() == 0);
	}

	private void compareModels(EObject modelLeft, EObject modelRight) throws Exception {
		MatchModel inputMatch = MatchService.doMatch(modelLeft, modelRight, null);
		DiffModel inputDiff = DiffService.doDiff(inputMatch);

		if (((DiffGroup) inputDiff.getOwnedElements().get(0)).getSubchanges() != 0) {
			fail("Diff failed");
		}
	}
}
