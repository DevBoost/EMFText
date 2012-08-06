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
package org.emftext.test.noeclipse.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.test.noeclipse.NoeclipseFactory;
import org.emftext.test.noeclipse.Root;
import org.emftext.test.noeclipse.resource.noeclipse.INoeclipseTextPrinter;
import org.emftext.test.noeclipse.resource.noeclipse.INoeclipseTextResource;
import org.emftext.test.noeclipse.resource.noeclipse.mopp.NoeclipseMetaInformation;
import org.emftext.test.noeclipse.resource.noeclipse.util.NoeclipseResourceUtil;

/**
 * Checks whether the generated plug-in for the NoEclipse DSL does not 
 * contain Eclipse dependencies.
 */
public class EclipseDependencyTest extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new NoeclipseMetaInformation().registerResourceFactory();
	}
	
	public void testParsing() {
		Root root = NoeclipseResourceUtil.getResourceContent("root");
		assertNotNull("Parsing must be successfull.", root);
	}
	
	public void testPrinting() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		URI uri = URI.createURI("temp." + new NoeclipseMetaInformation().getSyntaxName());
		INoeclipseTextResource resource = (INoeclipseTextResource) new ResourceSetImpl().createResource(uri);
		INoeclipseTextPrinter printer = new NoeclipseMetaInformation().createPrinter(outputStream , resource);
		try {
			printer.print(NoeclipseFactory.eINSTANCE.createRoot());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertEquals("Printing must be successfull.", "root", outputStream.toString());
	}
}
