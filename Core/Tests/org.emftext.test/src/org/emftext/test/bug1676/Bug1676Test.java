/*******************************************************************************
 * Copyright (c) 2006-2015
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
package org.emftext.test.bug1676;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.PluginTestHelper;
import org.junit.Ignore;
import org.junit.Test;

public class Bug1676Test {

	private final String packageDirectory = File.separator + "src" + File.separator + Bug1676Test.class.getPackage().getName().replace(".", File.separator) + File.separator;

	public void setUp() {
		new CsMetaInformation().registerResourceFactory();
		ConcreteSyntaxTestHelper.registerResourceFactories();
		ConcreteSyntaxTestHelper.registerEcoreGenModel();
	}

	@Test
	@Ignore("Temporarily ignored")
	public void testBug1676() {
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		String path = pluginRootPath + packageDirectory + "EcoreImporting.cs";
		CsResource resource = CsResourceUtil.getResource(new File(path).getAbsoluteFile());
		assertNotNull(resource);
		CsResourceUtil.resolveAll(resource);
		List<Diagnostic> errors = resource.getErrors();
		for (Diagnostic error : errors) {
			System.out.println("Error: " + error);
		}
		
		assertFalse("Resource must not contain errors.", CsResourceUtil.containsErrors(resource));
	}
}
