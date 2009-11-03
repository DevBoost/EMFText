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
package org.emftext.test.bug856;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.SDKOptionProvider;

/**
 * This is a test case for bug 856 (Syntaxes that import theirself cause a
 * StackOverflowError when opened in the editor). It loads a .cs file containing
 * a self import and checks the result.
 */
public class Bug856Test extends TestCase {

	public void setUp() {
		registerResourceFactories();
	}

	public void testPrefixReprinting() {
		String path = "./src/org/emftext/test/bug856/main.cs";
		File file = new File(path);
		Resource resource = new ResourceSetImpl().createResource(URI
				.createFileURI(file.getAbsolutePath()));
		try {
			resource.load(new SDKOptionProvider().getOptions());
			EcoreUtil.resolveAll(resource);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
