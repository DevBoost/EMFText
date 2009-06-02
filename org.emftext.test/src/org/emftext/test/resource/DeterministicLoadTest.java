/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.test.resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.resource.cs.CsResourceFactory;
import org.emftext.sdk.finders.GenPackageInRegistryFinder;
import org.junit.Before;
import org.junit.Test;

/**
 * A test that checks whether the EMFText code generation works
 * deterministically.
 */
public class DeterministicLoadTest {

	private static final String CS_FILE_EXTENSION = "cs";
	private static final URI csUri = EMFTextRuntimePlugin
			.getURIToConcreteSyntaxLocationMap().get(
					"http://www.emftext.org/sdk/concretesyntax%%cs");

	private static final String OUTPUT_FOLDER = "snapshots";
	private static final String OUTPUT_PROJECT = "DeterministicLoadTest";

	@Before
	public void setUp() throws Exception {
		assertNotNull("Concrete syntax URI not found", csUri);
		
		createOutputProject(OUTPUT_PROJECT, OUTPUT_FOLDER);

	}

	@Test
	public void testDeterministicLoad() throws Exception {
		final EObject modelObject1 = loadModel(csUri);
		final EObject modelObject2 = loadModel(csUri);

		compareModels(modelObject1, modelObject2, "testDeterministicLoad");
	}

	private void compareModels(final EObject modelLeft,
			final EObject modelRight, String testName) throws Exception {
		final MatchModel inputMatch = MatchService.doMatch(modelLeft,
				modelRight, null);
		final DiffModel inputDiff = DiffService.doDiff(inputMatch);

		if (((DiffGroup) inputDiff.getOwnedElements().get(0)).getSubchanges() != 0) {
			// TODO make this code run against Eclipse Galileo
			/*
			final ModelInputSnapshot snapshot = DiffFactory.eINSTANCE
					.createModelInputSnapshot();
			snapshot.setDiff(inputDiff);
			snapshot.setMatch(inputMatch);
			saveModel(snapshot, testName);
			*/
			fail("Diff failed");
		}
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
