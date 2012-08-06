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
package org.emftext.language.efactory.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.emftext.language.efactory.Factory;
import org.emftext.language.efactory.builder.Builder;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryMetaInformation;
import org.emftext.language.efactory.resource.efactory.mopp.EfactoryResourceFactory;

public class LoadTest extends TestCase {

	private final static String EFACTORY_EXTENSION = new EfactoryMetaInformation().getSyntaxName();
	
	private final static ResourceSet rs = new ResourceSetImpl();

	static {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore",
				new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				EFACTORY_EXTENSION,
				new EfactoryResourceFactory());
	}

	public void testEnumModel() throws IOException {
		testLoadModel("enumtest.efactory");
		testLoadModel("enumtest2.efactory");
	}
	
	public void testLoadSmallModel() throws IOException {
		testLoadModel("small.efactory");
	}
	
	public void testLoadLargeModel() throws IOException {
		testLoadModel("large.efactory");
	}

	private void testLoadModel(String filename) throws IOException {
		System.out.println("loading " + filename + "...");
		Resource resource = rs.getResource(URI.createFileURI(new File("." + File.separator + "input_load" + File.separator + filename).getCanonicalPath()), true);
		EList<Diagnostic> errors = resource.getErrors();
		EList<Diagnostic> warnings = resource.getWarnings();
		print(errors, "Error: ");
		print(warnings, "Warning: ");
		assertEquals(0, errors.size());
		assertEquals(0, warnings.size());
		System.out.println("resolving " + filename + "...");
		EcoreUtil.resolveAll(resource);

		Builder builder = new Builder();

		System.out.println("building " + filename + "...");
		EList<EObject> contents = resource.getContents();
		for (EObject eObject : contents) {
			if (eObject instanceof Factory) {
				Factory eFactory = (Factory) eObject;
				List<EObject> roots = builder.build(eFactory, new HashMap<EObject, String>());
				assertFalse(roots.isEmpty());
			}
		}
	}

	private void print(EList<Diagnostic> diagnostics, String string) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(string + diagnostic.getMessage());
		}
	}
}
