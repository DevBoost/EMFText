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
package org.emftext.test.bug674;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;

import junit.framework.TestCase;

import org.emftext.sdk.SDKOptionProvider;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsTextResourceUtil;
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
		final String path = "src" + File.separator + "org" + File.separator + "emftext" + File.separator + "test" + File.separator + "bug674" + File.separator;
		File file = new File(path + filename);
		
		ICsTextResource resource = CsTextResourceUtil.getResource(file, new SDKOptionProvider().getOptions());
		assertNotNull(resource);
		assertEquals(1, resource.getErrors().size());
		String errorMessage = resource.getErrors().get(0).getMessage();
		assertTrue(errorMessage.matches("The genmodel .* is invalid. Please reconcile it."));
	}
}
