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
package org.emftext.language.regexp.test;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrMetaInformation;
import org.emftext.language.regexp.resource.regexp_antlr.mopp.Regexp_antlrResourceFactory;
import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfMetaInformation;
import org.emftext.language.regexp.resource.regexp_sdf.mopp.Regexp_sdfResourceFactory;
import org.junit.Before;

import junit.framework.TestCase;

public abstract class AbstractTestCase extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new Regexp_sdfMetaInformation().getSyntaxName(),
				new Regexp_sdfResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new Regexp_antlrMetaInformation().getSyntaxName(),
				new Regexp_antlrResourceFactory());
	}
	

	public EObject parse(String nextRegexp, String syntaxType) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("temp." + syntaxType));
		try {
			System.out.println("parse(): " + nextRegexp);
			r.load(new ByteArrayInputStream(nextRegexp.getBytes()), null);
			EList<Diagnostic> errors = r.getErrors();
			for (Diagnostic error : errors) {
				System.out.println("Error: " + error.getMessage() + "(" + error.getColumn() + ")");
			}
			assertTrue("Errors are found.", errors.size() == 0);
			EList<EObject> contents = r.getContents();
			assertTrue("There should be a root element", contents.size() > 0);
			return contents.get(0);
		} catch (IOException e) {
			fail(e.getMessage());
		}
		return null;
	}
}
