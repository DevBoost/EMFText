/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.test.bug821;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

import junit.framework.TestCase;

/**
 * This is a test case for bug 821 (CS Pretty Printing does not 
 * work with imported packages). It load a .cs file containing 
 * a rule which refers to an imported meta class, prints it and
 * checks the result.
 */
public class Bug821Test extends TestCase {

	public void setUp() {
		registerResourceFactories();
	}
	
	public void testPrefixReprinting() {
		String path = "./src/org/emftext/test/bug821/main.cs";
		File file = new File(path);
		Resource resource = new ResourceSetImpl().createResource(URI.createFileURI(file.getAbsolutePath()));
		try {
			resource.load(null);
			EcoreUtil.resolveAll(resource);
			assertReprintContains(resource, "imported");
			// now change the prefix and check whether it is still printed
			// correctly
			ConcreteSyntax syntax = (ConcreteSyntax) resource.getContents().get(0);
			Import firstImport = syntax.getImports().get(0);
			final String newPrefix = "newPrefix";
			firstImport.setPrefix(newPrefix);
			assertReprintContains(resource, newPrefix);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private void assertReprintContains(Resource resource, String expectedPrefix) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		resource.save(out, null);
		String printResult = new String(out.toByteArray());
		System.out.println("Bug821Test.testPrefixReprinting()" + printResult);
		assertTrue("Prefix " + expectedPrefix + " not found.", printResult.contains(expectedPrefix + ".ClassInImportedPackage"));
	}
}
