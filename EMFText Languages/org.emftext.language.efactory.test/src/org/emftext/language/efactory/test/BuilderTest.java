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
package org.emftext.language.efactory.test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.builder.Builder;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryMetaInformation;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryResourceFactory;

/**
 * A test that check whether the EFactory build does create
 * correct models from .efactory files.
 */
public class BuilderTest extends TestCase {

	private final static String EFACTORY_FILE_EXTENSION = "." + new EfactoryMetaInformation().getSyntaxName();

	private ResourceSetImpl rs;

	public void setUp() {
		rs = new ResourceSetImpl();
		// register XMI and EFactory resource factory
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new EfactoryMetaInformation().getSyntaxName(),
				new EfactoryResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi",
				new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		
		// register test meta models
		File[] mmFiles = getFiles("." + File.separator + "metamodels", ".ecore");
		for (File mmFile : mmFiles) {
			Resource mmResource = rs.getResource(URI.createFileURI(mmFile.getAbsolutePath()), true);
			EObject mmRoot = mmResource.getContents().get(0);
			EPackage mmPackage = (EPackage) mmRoot;
			EPackage.Registry.INSTANCE.put(mmPackage.getNsURI(), mmPackage);
		}
	}
	
	public void testBuilding() {
		File[] inputFiles = getFiles("." + File.separator + "input", EFACTORY_FILE_EXTENSION);
		assertTrue(inputFiles.length >= 2);
		for (File inputFile : inputFiles) {
			testBuilding(inputFile);
		}
	}

	private File[] getFiles(String dir, final String fileExtension) {
		File inputFolder = new File(dir);
		File[] inputFiles = inputFolder.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				return name.endsWith(fileExtension);
			}
		});
		return inputFiles;
	}

	private void testBuilding(File inputFile) {
		// load .efactory file
		String absolutePath = inputFile.getAbsolutePath();
		Resource resource = rs.getResource(URI.createFileURI(absolutePath), true);
		assertNotNull(resource);
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("Error in resource: " + error);
		}
		assertTrue("Resource must not contain errors.", errors.isEmpty());
		List<EObject> contents = resource.getContents();
		assertEquals(1, contents.size());
		EObject root = contents.get(0);
		assertTrue(root instanceof Factory);
		Factory factory = (Factory) root;
		// build model
		Builder builder = new Builder();
		List<EObject> builtModel = builder.build(factory, new HashMap<EObject, String>());
		Resource tempResource = rs.createResource(URI.createURI("temp_resource_for_build_model.xmi"));
		tempResource.getContents().addAll(builtModel);
		// load expected model
		String pathToExpectedModel = absolutePath.substring(0, absolutePath.length() - EFACTORY_FILE_EXTENSION.length()) + ".xmi";
		Resource expectedResource = rs.getResource(URI.createFileURI(pathToExpectedModel), true);
		List<EObject> expectedContents = expectedResource.getContents();
		assertEquals(builtModel.size(), expectedContents.size());
		// compare built model and expected one
		try {
			compareModels(builtModel, expectedContents);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception while comparing models " + e.getMessage());
		}
	}

	private void compareModels(List<EObject> modelLeft, List<EObject> modelRight) throws Exception {
		for (int i=0; i<modelLeft.size(); i++) {
			MatchModel inputMatch = MatchService.doMatch(
					modelLeft.get(i), modelRight.get(i), null);
			DiffModel inputDiff = DiffService.doDiff(inputMatch);

			if (((DiffGroup) inputDiff.getOwnedElements().get(0)).getSubchanges() != 0) {
				fail("Diff failed");
			}	
		}
	}
}
