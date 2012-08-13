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
package org.emftext.test.printing.test;


public class Bug1602BooleanPrintingTest {

	//TODO #1879: Turn this into an Ecore TEXT language test
	
	/* 
	@Before
	public void setUp() {
		ConcreteSyntaxTestHelper.registerResourceFactories();
		EcoreResourceFactoryDelegator delegator = new EcoreResourceFactoryDelegator();
		delegator.getResourceFactoriesMap().put("text", new TextEcoreResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				delegator);
	}


	@Test
	public void testOntologyImportsDeresolve() {
		ResourceSet rs = new ResourceSetImpl();
		URI inuri = URI.createURI("./testInput/testfile.text.ecore");
		Resource inresource = rs.getResource(inuri, true);
		assertNotNull("Input resource could not be created", inresource);
		assertFalse("Input resource was empty", inresource.getContents().isEmpty());
		EObject root = inresource.getContents().get(0);
		assertNotNull("Root package of input resource could not be received", root);
		
		URI outuri = URI.createURI("./testInput/outfile.text.ecore");
		Resource outresource = rs.createResource(outuri);
		assertNotNull("Output resource could not be created", inresource);
		outresource.getContents().add(root);
		try {
			outresource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
		outresource.unload();
		
		try {
			outresource.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
		assertFalse("Printed resource was empty", outresource.getContents().isEmpty());
		EPackage outroot = (EPackage) outresource.getContents().get(0);
		assertNotNull("Root package of printed resource could not be received", outroot);
		EClassifier firstClassifier = outroot.getEClassifiers().get(0);
		assertEquals("Printed classifer has wrong name, due to printing bug","Shape",firstClassifier.getName());	
	}
	*/
}
