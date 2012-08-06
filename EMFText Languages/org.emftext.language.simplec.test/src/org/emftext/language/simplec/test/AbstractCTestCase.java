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
package org.emftext.language.simplec.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.emftext.language.simplec.CPackage;
import org.emftext.language.simplec.resource.c.ICOptions;

public class AbstractCTestCase extends TestCase {

	protected EObject loadResource(InputStream inputStream,
			String fileIdentifier, EClass type) throws IOException {

		EObject fragment = tryToLoadResource(inputStream, fileIdentifier, type);
		assertNotNull(fragment);
		assertSuccessfulParsing(fragment.eResource());
		return fragment;
	}

	protected EObject tryToLoadResource(InputStream inputStream,
			String fileIdentifier, EClass type) throws IOException {
		CResourceImplTestWrapper resource = new CResourceImplTestWrapper();
		Map<String,EClass> options = new HashMap<String,EClass>();
		if (type != null) {
			options.put(ICOptions.RESOURCE_CONTENT_TYPE, type);
		}
		resource.load(inputStream,options);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		//if null, type should be selected appropriately in parser
		if (type == null) {
			type = CPackage.eINSTANCE.getCompilationUnit();
		}
		assertTrue("File '" + fileIdentifier
				+ "' was parsed to " + type.getName() + ".",
				content.eClass() == type);
		return content;
	}

	private void assertSuccessfulParsing(Resource resource) {
		print(resource.getErrors());
		print(resource.getWarnings());
		assertEquals(0, resource.getErrors().size());
		assertEquals(0, resource.getWarnings().size());
	}

	private void print(EList<Diagnostic> diagnostics) {
		for (Diagnostic diagnostic : diagnostics) {
			System.out.println(diagnostic.getMessage());
		}
	}
}
