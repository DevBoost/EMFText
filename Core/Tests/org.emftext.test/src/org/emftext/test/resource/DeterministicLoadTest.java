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
package org.emftext.test.resource;

import static org.junit.Assert.fail;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.access.EMFTextAccessPlugin;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory;
import org.emftext.sdk.finders.GenPackageInRegistryFinder;
import org.junit.Test;

/**
 * A test that checks whether the EMFText code generation works
 * deterministically.
 */
public class DeterministicLoadTest {

	private static final String CS_FILE_EXTENSION = "cs";
	private static final URI csUri = EMFTextAccessPlugin
			.getURIToConcreteSyntaxLocationMap().get(
					"http://www.emftext.org/sdk/concretesyntax%%cs");

	private static final String OUTPUT_FOLDER = "snapshots";
	private static final String OUTPUT_PROJECT = "DeterministicLoadTest";

	@Test
	public void testDeterministicLoad() throws Exception {
		//TODO change this test to work independent of Eclipse
		if (csUri == null) {
			// This test only runs inside Eclipse as Plug-in test.
			// The missing CS registrations indicates that Eclipse is not running.
			return;
		}

		createOutputProject(OUTPUT_PROJECT, OUTPUT_FOLDER);
		
		final EObject modelObject1 = loadModel(csUri);
		final EObject modelObject2 = loadModel(csUri);

		compareModels(modelObject1, modelObject2);
	}

	private void compareModels(EObject modelLeft, EObject modelRight) throws Exception {
		
		Comparison comparison = compare(modelLeft, modelRight);
		
		if (!comparison.getDifferences().isEmpty()) {
			fail("Diff failed");
		}
	}

	public Comparison compare(EObject modelLeft, EObject modelRight) {

		// Configure EMF Compare
		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(matcher, comparisonFactory);
        matchEngineFactory.setRanking(20);
        IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
        matchEngineRegistry.add(matchEngineFactory);
		EMFCompare comparator = EMFCompare.builder().setMatchEngineFactoryRegistry(matchEngineRegistry).build();
	 
		// Compare the two models
		IComparisonScope scope = EMFCompare.createDefaultScope(modelLeft, modelRight);
		return comparator.compare(scope);
	}
	
	private void createOutputProject(String projectName, String folderName)
			throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project = root.getProject(projectName);
		if (!project.exists()) {
			project.create(null);
		}

		if (!project.isOpen()) {
			project.open(null);
		}

		IFolder inputFolder = project.getFolder(folderName);
		if (!inputFolder.exists()) {
			inputFolder.create(IResource.NONE, true, null);
		}

	}

	private EObject loadModel(final URI modelFilUri) {
		return loadModelResource(modelFilUri).getContents().get(0);
	}

	private Resource loadModelResource(final URI modelFileUri) {
		// every resource is loaded in its own ResourceSet to prevent caching effects
		ResourceSet resourceSet = new ResourceSetImpl();
		registerFactory(resourceSet);

		resourceSet.getLoadOptions().put(MetamodelHelper.GEN_PACKAGE_FINDER_KEY, new GenPackageInRegistryFinder());

		return resourceSet.getResource(modelFileUri, true);
	}

	private void registerFactory(final ResourceSet resourceSet) {
		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Object resourceFactory = reg.getExtensionToFactoryMap().get(
				CS_FILE_EXTENSION);
		if (resourceFactory != null) {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(CS_FILE_EXTENSION, resourceFactory);
		} else {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(CS_FILE_EXTENSION, new CsResourceFactory());
		}
	}

	/*
	private void saveModel(EObject root, String snapshotName) throws Exception {
		final URI modelURI = URI.createPlatformResourceURI(OUTPUT_PROJECT + "/"
				+ OUTPUT_FOLDER + "/" + snapshotName, true);
		final ResourceSet resourceSet = new ResourceSetImpl();

		registerFactory(resourceSet);

		final Resource newModelResource = resourceSet.createResource(modelURI);
		newModelResource.getContents().add(root);
		newModelResource.save(Collections.EMPTY_MAP);
	}
	*/
}
