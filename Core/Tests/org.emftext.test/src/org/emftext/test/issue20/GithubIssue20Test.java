package org.emftext.test.issue20;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory;
import org.junit.Test;

public class GithubIssue20Test {

	private static final EcoreFactory ECORE_FACTORY = EcoreFactory.eINSTANCE;

	@Test
	public void testStackOverflow() {
		
		CsResource resource = createTempResource();
		
		EPackage ePackage = createMinimalModel();
		
		EList<EObject> contents = resource.getContents();
		contents.add(ePackage);
		
		assertNoStackOverflow(resource);
	}

	private CsResource createTempResource() {
		ResourceSet rs = createResourceSet();
		URI uri = URI.createFileURI("temp.cs");
		CsResource resource = (CsResource) rs.createResource(uri);
		return resource;
	}

	private EPackage createMinimalModel() {
		EPackage ePackage = ECORE_FACTORY.createEPackage();
		ePackage.setName("P");

		EClass eClass = ECORE_FACTORY.createEClass();
		eClass.setName("C");
		ePackage.getEClassifiers().add(eClass);
		
		EOperation eOperation = ECORE_FACTORY.createEOperation();
		eClass.getEOperations().add(eOperation);
		return ePackage;
	}

	private void assertNoStackOverflow(CsResource resource) {
		assertFalse(resource.getContents().isEmpty());
		byte[] input = "some input".getBytes();
		try {
			resource.reload(new ByteArrayInputStream(input), null);
		} catch (IOException e) {
			fail("Reloading resource failed: " + e.getMessage());
		}
	}

	private ResourceSet createResourceSet() {
		ResourceSet rs = new ResourceSetImpl();
		
		Registry resourceFactoryRegistry = rs.getResourceFactoryRegistry();
		Map<String, Object> extensionToFactoryMap = resourceFactoryRegistry.getExtensionToFactoryMap();
		extensionToFactoryMap.put("cs", new CsResourceFactory());
		return rs;
	}
}
