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
package org.emftext.language.ecore.test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.ecore.resource.text.util.TextEcoreResourceUtil;

public class AbstractEcoreTestCase extends TestCase {

	protected EPackage loadResource(String path,
			String fileIdentifier) throws IOException {

		Resource resource = tryToLoadResource(path, fileIdentifier);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to EPackage.",
				content instanceof EPackage);
		EPackage ePackage = (EPackage) content;
		assertNotNull(ePackage);
		EcoreUtil.resolveAll(resource);
		assertSuccessfulParsing(ePackage.eResource());
		return ePackage;
	}

	protected Resource tryToLoadResource(String path,
			String fileIdentifier) throws IOException {

		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.getResource(URI.createFileURI(new File(path).getAbsolutePath()), true);
		return resource;
	}

	private void assertSuccessfulParsing(Resource resource) {
		print(resource.getErrors());
		print(resource.getWarnings());
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());

		Set<EObject> unresolvedProxies = TextEcoreResourceUtil.findUnresolvedProxies(resource);
		for (EObject proxy : unresolvedProxies) {
			//assertTrue(proxy.eIsProxy());
			InternalEObject internalProxy = (InternalEObject) proxy;
			System.out.println("Unresolved proxy " + internalProxy.eProxyURI() + " in " + resource.getURI());
		}
		assertEquals("There must be no unresolve proxy objects.", 0, unresolvedProxies.size());
	}

	private void print(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(diagnostic.getMessage() + " at " + diagnostic.getLine() + ":" + diagnostic.getColumn());
		}
	}
}
