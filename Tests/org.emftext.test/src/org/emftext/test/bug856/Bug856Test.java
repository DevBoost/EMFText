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
package org.emftext.test.bug856;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.test.PluginTestHelper;

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
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		String path = pluginRootPath + "/src/org/emftext/test/bug856/main.cs";
		File file = new File(path);
		Resource resource = new ResourceSetImpl().createResource(URI
				.createFileURI(file.getAbsolutePath()));
		try {
			resource.load(null);
			EcoreUtil.resolveAll(resource);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
