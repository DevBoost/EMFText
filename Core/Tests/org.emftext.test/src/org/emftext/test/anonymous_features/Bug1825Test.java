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
package org.emftext.test.anonymous_features;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;
import org.emftext.test.ConcreteSyntaxTestHelper;
import org.emftext.test.PluginTestHelper;

import junit.framework.TestCase;

public class Bug1825Test extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ConcreteSyntaxTestHelper.registerResourceFactories();
	}
	
	public void testReprintWarnings() {
		assertNoProblems("anonymous_feature2.cs");
		assertNoProblems("anonymous_feature3.cs");
	}

	private void assertNoProblems(String fileName) {
		String path = new PluginTestHelper().getSourcePackagePath(getClass());
		File input = new File(path + File.separator + fileName).getAbsoluteFile();
		URI uri = URI.createFileURI(input.getPath());
		ConcreteSyntax syntax = CsResourceUtil.getResourceContent(uri);
		assertNotNull(syntax);
		
		Resource eResource = syntax.eResource();
		assertNotNull(eResource);
		
		assertTrue("Resource must not contain errors.", eResource.getErrors().isEmpty());
		assertTrue("Resource must not contain warnings.", eResource.getWarnings().isEmpty());
	}
}
