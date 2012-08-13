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
package org.emftext.test.bug674;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;
import org.emftext.test.PluginTestHelper;
import org.junit.Before;
import org.junit.Test;

/**
 * A test case for bug 674.
 */
public class Bug674Test extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testBug674() {
		final String filename = "YggdrasilComponents.cs";
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		final String path = pluginRootPath + File.separator + "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "bug674" + File.separator;
		File file = new File(path + filename);

		ICsTextResource resource = CsResourceUtil.getResource(file);
		assertNotNull(resource);
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("Found error in syntax " + error.getMessage() + " at " + error.getLine() + ":" + error.getColumn());
		}
		assertEquals(3, errors.size());
		String errorMessage = errors.get(0).getMessage();
		assertTrue(errorMessage.matches("The genmodel .* is invalid. Please reconcile it.*"));
	}
}
