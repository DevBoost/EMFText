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
package org.emftext.language.simplemath.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.simplemath.Expression;
import org.emftext.language.simplemath.resource.sm.mopp.SmMetaInformation;
import org.emftext.language.simplemath.resource.sm.mopp.SmResourceFactory;

public abstract class AbstractSimpleMathTestCase extends TestCase {
	
	public void setUp() throws Exception {
		super.setUp();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new SmMetaInformation().getSyntaxName(),
				new SmResourceFactory());
	}

	public Expression loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {

		Resource resource = load(inputStream, fileIdentifier);
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic diagnostic : errors) {
			System.out.println("loadResource() ERROR: " + diagnostic.getMessage());
		}
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier + "' was parsed to type Expression.",
				content instanceof Expression);
		assertEquals(0, errors.size());
		assertEquals(0, resource.getWarnings().size());
		Expression root = (Expression) content;
		return root;
	}

	public Resource load(File file) throws IOException {
		InputStream inputStream = new FileInputStream(file);
		return load(inputStream, file.getAbsolutePath());
	}

	private Resource load(InputStream inputStream, String uri)
			throws IOException {
		Map<?, ?> options = getLoadOptions();
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + new SmMetaInformation().getSyntaxName()));
		resource.load(inputStream, options);
		inputStream.close();
		return resource;
	}

	public abstract Map<?, ?> getLoadOptions();
}
