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
package org.emftext.test.resolving.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.test.resolving.EcoreImport;
import org.emftext.test.resolving.GenModelImport;
import org.emftext.test.resolving.Object;
import org.emftext.test.resolving.resource.resolving.IResolvingTextPrinter;
import org.emftext.test.resolving.resource.resolving.IResolvingTextResource;
import org.emftext.test.resolving.resource.resolving.mopp.ResolvingMetaInformation;

public class DefaultResolvingTest extends TestCase {

	private static final String FILE_EXTENSION = new ResolvingMetaInformation().getSyntaxName();

	public void setUp() {
		new ResolvingMetaInformation().registerResourceFactory();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"genmodel",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
	}

	/**
	 * A test for bug 1746 (Default deresolver for elements that were imported by uri should also print uri)
	 */
	public void testPrintingExternalReferences() {
		Resource resource = loadMainResource();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			resource.save(outputStream, null);
			String printResult = outputStream.toString();
			System.out.println("DefaultResolvingTest.testPrintingExternalReferences() printResult ==>" + printResult + "<==");
			assertTrue(printResult.matches("(?s)import <.*ImportedModel.resolving>.*"));
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	public void testResolving() {
		String input =
			"object a 1 {" +
				"object b 2 -> a {" +
				"}" +
			"}";
		assertReferenceTarget(input, 2, 1);

		input =
			"object a 1 {" +
				"object b 2 {" +
				"}" +
				"object b 3 {" +
				"}" +
				"object c 4 -> b {" +
				"}" +
			"}";
		assertReferenceTarget(input, 4, 2);
	}

	public void testScoping() {
		String input =
			"object b 1 {" +
				"object b 2 {" +
				"}" +
				"object c 3 -> b {" +
				"}" +
			"}";
		assertReferenceTarget(input, 3, 2);
	}

	public void testPrintingProxies() {
		// this is a test for bug 1544: Extend new printer to support printing of proxy objects
		String input =
			"object a 1 {" +
				// the reference to 'b' cannot be resolved, but should be printed correctly
				"object c 2 => b {" + 
				"}" +
			"}";
		IResolvingTextResource resource = (IResolvingTextResource) loadResourceFromMemory(input);
		EcoreUtil.resolveAll(resource);
		assertEquals("Expecting one error, because a reference is dangling.", 1, resource.getErrors().size());
		
		EList<EObject> contents = resource.getContents();
		assertEquals("Resource must have one root element.", 1, contents.size());
		
		EObject root = contents.get(0);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		IResolvingTextPrinter printer = new ResolvingMetaInformation().createPrinter(outputStream, resource);
		try {
			printer.print(root);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		String output = outputStream.toString();
		System.out.println("testPrintingProxies() output is ==>" + output + "<==");
		assertEquals(input, output);
	}

	public void testResolvingPerformance1() {
		int objects = 100000;

		StringBuilder input = new StringBuilder("object a 1 {");
		input.append("object c 2 -> d {}");
		for (int i = 3; i < objects; i++) {
			input.append("object b ");
			input.append(i);
			input.append(" {}");
		}
		input.append("object d " + objects + " {}");
		input.append("}");
		System.out.println("DefaultResolvingTest.testResolvingPerformance() " + input.toString().length());
		assertReferenceTarget(input.toString(), 2, objects);
	}

	/**
	 * Checks whether the default resolving algorithm can handle deeply nested
	 * models. Since the default support for scoping depends on the depth of
	 * the container of the reference to be resolved, is was assumed that 
	 * resolving would take forever, but this works fine.
	 */
	public void testResolvingPerformance2() {
		int objects = 1000;

		// create a deeply nested model
		StringBuilder input = new StringBuilder("object a 1 {");
		input.append("object c 2 {}");

		StringBuilder child = new StringBuilder();
		// this is the most inner object
		child.append("object d " + objects + " -> c {}");
		for (int i = 3; i < objects; i++) {
			StringBuilder tree = new StringBuilder();
			tree.append("object b ");
			tree.append(i);
			tree.append(" {");
			tree.append(child);
			tree.append("}");
			child = tree;
		}
		input.append(child);
		input.append("}");
		System.out.println("testResolvingPerformance() " + input.toString().length());
		// try to resolve the reference from the most inner object
		// to one that is almost at the root of the tree
		assertReferenceTarget(input.toString(), objects, 2);
	}

	public void testImport() {
		Resource resource = loadMainResource();
		assertReferenceTarget(resource, 1, 3);
	}

	private Resource loadMainResource() {
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createFileURI(new File("." + File.separator + "input" + File.separator + "Main.resolving").getAbsolutePath());
		Resource resource = rs.getResource(uri, true);
		return resource;
	}
	
	/**
	 * Tests whether references to Ecore models that use the namespace URI 
	 * can be resolved by the default reference resolving mechanisms. 
	 */
	public void testImportFromEcoreRegistry() {
		Resource resource = loadResourceFromMemory("ecoreimport <http://www.eclipse.org/emf/2002/Ecore>");
		printErrors(resource);
		assertTrue("Resource must not contain errors.", resource.getErrors().isEmpty());
		EList<EObject> contents = resource.getContents();
		assertFalse("Resource must contain elements.", contents.isEmpty());
		EObject root = contents.get(0);
		assertTrue("Root element must be EcoreImport", root instanceof EcoreImport);
		EcoreImport eImport = (EcoreImport) root;
		EPackage importedEPackage = eImport.getEPackage();
		assertEquals("Imported EPackage must be Ecore package", "ecore", importedEPackage.getName());
	}

	/**
	 * Tests whether references to generator models that use the namespace URI 
	 * of the respective Ecore model can be resolved by the default reference 
	 * resolving mechanisms. 
	 */
	public void testImportFromGenModelRegistry() {
		final String namespace = "http://www.emftext.org/test/resolving";
		// first register a generator model in the registry. otherwise the test won't find
		// one, because the generator model registry is only initialized if the platform 
		// is running
		final Map<String, URI> packageNsURIToGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
		packageNsURIToGenModelLocationMap.put(namespace, URI.createFileURI("../org.emftext.test.resolving/metamodel/resolving.genmodel"));
		
		Resource resource = loadResourceFromMemory("genmodelimport <" + namespace + ">");
		printErrors(resource);
		assertTrue("Resource must not contain errors.", resource.getErrors().isEmpty());
		EList<EObject> contents = resource.getContents();
		assertFalse("Resource must contain elements.", contents.isEmpty());
		EObject root = contents.get(0);
		assertTrue("Root element must be EcoreImport", root instanceof GenModelImport);
		GenModelImport genmodelImport = (GenModelImport) root;
		GenModel importedGenModel = genmodelImport.getGenModel();
		assertFalse("Imported element must not be a proxy", importedGenModel.eIsProxy());
		assertEquals("Imported GenPackage must be resolving GenPackage", "org.emftext.test.resolving", importedGenModel.getModelPluginID());
	}
	
	private void printErrors(Resource resource) {
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("Error in resource: " + error);
		}
	}

	private void assertReferenceTarget(String input, int i, int j) {
		Resource resource = loadResourceFromMemory(input);
		assertReferenceTarget(resource, i, j);
	}

	private Resource loadResourceFromMemory(String input) {
		ResourceSet rs = new ResourceSetImpl();
		URI uri = URI.createURI("temp." + FILE_EXTENSION);
		Resource resource = rs.createResource(uri);
		try {
			resource.load(new ByteArrayInputStream(input.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		return resource;
	}

	private void assertReferenceTarget(Resource resource, int i, int j) {
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("Found error in resource: "+ error);
		}
		assertEquals("Resource must not have errors.", 0, errors.size());
		
		org.emftext.test.resolving.Object objectI = getObject(resource.getResourceSet(), i);
		assertNotNull("Can't find object " + i, objectI);
		org.emftext.test.resolving.Object objectJ = getObject(resource.getResourceSet(), j);
		assertNotNull("Can't find object " + j, objectJ);
		
		// check reference
		Object target = objectI.getRef();
		assertNotNull("Reference of object I (" + objectI + ") must not be null.", target);
		assertSame(objectJ, target);
	}

	private org.emftext.test.resolving.Object getObject(ResourceSet resourceSet, int number) {
		for (Resource resource : resourceSet.getResources()) {
			EList<EObject> contents = resource.getContents();
			for (EObject contentObject : contents) {
				if (contentObject instanceof org.emftext.test.resolving.Object) {
					org.emftext.test.resolving.Object object = (org.emftext.test.resolving.Object) contentObject;
					if (object.getNumber() == number) {
						return object;
					}
				}
				TreeIterator<EObject> iterator = contentObject.eAllContents();
				while (iterator.hasNext()) {
					EObject next = (EObject) iterator.next();
					if (next instanceof org.emftext.test.resolving.Object) {
						org.emftext.test.resolving.Object object = (org.emftext.test.resolving.Object) next;
						if (object.getNumber() == number) {
							return object;
						}
					}
				}
			}
		}
		return null;
	}
}
