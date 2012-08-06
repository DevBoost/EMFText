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
package org.emftext.language.calc.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.calc.Calculation;
import org.emftext.language.calc.resource.calc.mopp.CalcMetaInformation;
import org.emftext.language.calc.resource.calc.util.CalcResourceUtil;

public abstract class AbstractCalcTestCase extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new CalcMetaInformation().registerResourceFactory();
	}

	protected Calculation assertParseable(String text) {
		URI uri = URI.createURI("temp." + new CalcMetaInformation().getSyntaxName());
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(uri);
		assertNotNull(resource);
		InputStream bais = new ByteArrayInputStream(text.getBytes());
		try {
			resource.load(bais, null);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic diagnostic : errors) {
			System.out.println("ParserTest.testParsing() ERROR " + diagnostic);
		}
		assertEquals("Resource contains error(s).", 0, errors.size());
		Set<EObject> unresolvedProxies = CalcResourceUtil.findUnresolvedProxies(resource);
		for (EObject unresolvedProxy : unresolvedProxies) {
			System.out.println("ParserTest.testParsing() UNRESOLVED PROXY " + unresolvedProxy);
		}
		assertTrue("Found unresolved references", unresolvedProxies.isEmpty());
		List<EObject> contents = resource.getContents();
		assertFalse(contents.isEmpty());
		EObject root = contents.get(0);
		assertTrue(root instanceof Calculation);
		Calculation calc = (Calculation) root;
		assertNotNull(calc);
		return calc;
	}
}
