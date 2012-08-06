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
package org.emftext.language.featherweightjava.test;

import java.io.File;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.featherweightjava.resource.fj.mopp.FjResourceFactory;

public class FJTest extends TestCase {

	public static class ParseTest extends TestCase {

		private File inputFile;

		public ParseTest(File inputFile) {
			super("Parse " + inputFile.getName());
			this.inputFile = inputFile;
		}

		public void runTest() {
			try {
				URI uri = URI.createFileURI(inputFile.getAbsolutePath());
				ResourceSet rs = new ResourceSetImpl();
				Resource r = rs.createResource(uri);
				r.load(null);
				assertNotNull("Parsing should be successful.", r.getContents());
				EList<Diagnostic> errors = r.getErrors();
				for (Diagnostic diagnostic : errors) {
					System.out.println("ERROR: " + diagnostic.getMessage() + " at " + diagnostic.getLine() + ":" + diagnostic.getColumn());
				}
				assertTrue("There should be no errors", errors.size() == 0);
			} catch (IOException e) {
				fail(e.getMessage());
			}
		}
	}

	public static Test suite() {
		registerResourceFactories();
		TestSuite suite = new TestSuite("Parse all files from the input folder");
		File inputFolder = new File("input");
		File[] inputFiles = inputFolder.listFiles();
		for (File inputFile : inputFiles) {
			if (inputFile.getName().endsWith(".fj")) {
				suite.addTest(new ParseTest(inputFile));
			}
		}
		return suite;
	}

	private static void registerResourceFactories() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"fj", new FjResourceFactory());
	}
}
