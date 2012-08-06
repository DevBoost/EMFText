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
package org.emftext.test.bug1233.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.test.bug1233.AbstractType;
import org.emftext.test.bug1233.Root;
import org.emftext.test.bug1233.resource.bug1233.analysis.RootReferenceReferenceResolver;
import org.emftext.test.bug1233.resource.bug1233.mopp.Bug1233MetaInformation;

/**
 * This test performs proxy resolving for references that do have an abstract
 * type where no concrete subclasses are known. This is a tricky case, because
 * proxy objects need to be instances of concrete types. Thus, EMFText normally
 * picks a random concrete sub type to create a proxy object. If no concrete sub
 * type is known at grammar development time a more complex construct is needed.
 * This special treatment (i.e., creation of a dynamic Java proxy) is tested with
 * this class.
 */
public class ProxyResolvingTest extends TestCase {

	private static final String BUG1233_EXTENSION = new Bug1233MetaInformation().getSyntaxName();

	public void setUp() {
		new Bug1233MetaInformation().registerResourceFactory();
	}
	
	public void testDynamicProxy() {
		testResolving(true);
		testResolving(false);
	}

	private void testResolving(boolean doResolveProxies) {
		RootReferenceReferenceResolver.doResolve = doResolveProxies;
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + BUG1233_EXTENSION));
		assertNotNull(resource);
		String input = "Root a";
		try {
			resource.load(new ByteArrayInputStream(input.getBytes()), null);
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		EList<EObject> contents = resource.getContents();
		assertEquals(1, contents.size());
		EObject rootObject = contents.get(0);
		assertTrue(rootObject instanceof Root);
		Root root = (Root) rootObject;
		AbstractType reference = root.getReference();
		assertNotNull(reference);
		// now request a property of 'reference'
		String property = reference.getProperty();
		assertNull(property);
	}
}
