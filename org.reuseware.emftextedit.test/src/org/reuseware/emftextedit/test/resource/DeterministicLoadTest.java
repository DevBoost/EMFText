package org.reuseware.emftextedit.test.resource;

import static org.junit.Assert.fail;

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
import org.junit.Test;
import org.reuseware.emftextedit.concretesyntax.resource.cs.CsResourceFactoryImpl;
import org.reuseware.emftextedit.resource.impl.TextResourceImpl;

public class DeterministicLoadTest {

	private static final URI csInputUri = URI.createFileURI("input/java.cs");
	private static final String CS_FILE_EXTENSION = "cs";

	@Test
	public void testDeterministicLoad() throws Exception {
		final EObject modelObject1 = loadModel(csInputUri);
		final EObject modelObject2 = loadModel(csInputUri);
		
		compareModels(modelObject1, modelObject2);
	}
	
	@Test
	public void testDeterministicLoadSave() throws Exception {
		fail("Not yet implemented");
	}

	private void compareModels(final EObject modelLeft, final EObject modelRight)
			throws Exception {
		final MatchModel inputMatch = MatchService.doMatch(modelLeft,
				modelRight, null);
		final DiffModel inputDiff = DiffService.doDiff(inputMatch);

		if (((DiffGroup) inputDiff.getOwnedElements().get(0)).getSubchanges() != 0) {
			fail("Diff failed");
		}
	}
	
	private EObject loadModel(final URI modelFilUri) {
		return loadModelResource(modelFilUri).getContents().get(0);
	}

	private Resource loadModelResource(final URI modelFileUri) {
		// every resource is loaded in its own ResourceSet to prevent caching effects
		ResourceSet resourceSet = new ResourceSetImpl();

		final Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		final Object resourceFactory = reg.getExtensionToFactoryMap().get(
				CS_FILE_EXTENSION);
		if (resourceFactory != null) {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(CS_FILE_EXTENSION, resourceFactory);
		} else {
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(CS_FILE_EXTENSION, new CsResourceFactoryImpl());
		}

		resourceSet.getLoadOptions().put(TextResourceImpl.OPTION_NO_VALIDATE, true);

		return resourceSet.getResource(modelFileUri, true);
	}
}
