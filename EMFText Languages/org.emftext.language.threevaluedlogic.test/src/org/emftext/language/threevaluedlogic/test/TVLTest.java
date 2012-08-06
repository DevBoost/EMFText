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
package org.emftext.language.threevaluedlogic.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.threevaluedlogic.Constants;
import org.emftext.language.threevaluedlogic.Formula;
import org.emftext.language.threevaluedlogic.InterpreterProvider;
import org.emftext.language.threevaluedlogic.resource.tvl.ITvlOptions;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlMetaInformation;
import org.emftext.language.threevaluedlogic.resource.tvl.mopp.TvlResourceFactory;

public class TVLTest extends TestCase {

	public void setUp() throws Exception {
		super.setUp();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				new TvlMetaInformation().getSyntaxName(),
				new TvlResourceFactory());
	}
	
	public void testInterpreter() {
		// check basic truth table (for or)
		assertComputedValue(Constants.TRUE, "true OR true");
		assertComputedValue(Constants.TRUE, "true OR unknown");
		assertComputedValue(Constants.TRUE, "true OR false");
		assertComputedValue(Constants.TRUE, "unknown OR true");
		assertComputedValue(Constants.UNKNOWN, "unknown OR unknown");
		assertComputedValue(Constants.UNKNOWN, "unknown OR false");
		assertComputedValue(Constants.TRUE, "false OR true");
		assertComputedValue(Constants.UNKNOWN, "false OR unknown");
		assertComputedValue(Constants.FALSE, "false OR false");

		// check basic truth table (for and)
		assertComputedValue(Constants.TRUE, "true AND true");
		assertComputedValue(Constants.UNKNOWN, "true AND unknown");
		assertComputedValue(Constants.FALSE, "true AND false");
		assertComputedValue(Constants.UNKNOWN, "unknown AND true");
		assertComputedValue(Constants.UNKNOWN, "unknown AND unknown");
		assertComputedValue(Constants.FALSE, "unknown AND false");
		assertComputedValue(Constants.FALSE, "false AND true");
		assertComputedValue(Constants.FALSE, "false AND unknown");
		assertComputedValue(Constants.FALSE, "false AND false");

		// check basic truth table (for not)
		assertComputedValue(Constants.FALSE, "NOT true");
		assertComputedValue(Constants.UNKNOWN, "NOT unknown");
		assertComputedValue(Constants.TRUE, "NOT false");
	}

	private void assertComputedValue(Constants result, String formula) {
		try {
			Formula root = loadResource(formula, "from memory");
			assertEquals(result, root.getComputedValue());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private Formula loadResource(String text, String fileIdentifier) throws IOException {
		return loadResource(new ByteArrayInputStream(text.getBytes()), fileIdentifier);
	}

	private Formula loadResource(InputStream inputStream,
			String fileIdentifier) throws IOException {

		Resource resource = load(inputStream, fileIdentifier);
		assertEquals("The resource should have one content element.", 1,
				resource.getContents().size());
		EObject content = resource.getContents().get(0);
		assertTrue("File '" + fileIdentifier + "' was parsed to type Formula.",
				content instanceof Formula);
		EList<Diagnostic> errors = resource.getErrors();
		for (Diagnostic diagnostic : errors) {
			System.out.println("loadResource() ERROR: " + diagnostic.getMessage());
		}
		assertEquals(0, errors.size());
		assertEquals(0, resource.getWarnings().size());
		Formula root = (Formula) content;
		return root;
	}

	private Resource load(InputStream inputStream, String uri)
			throws IOException {
		Map<?, ?> options = getLoadOptions();
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("temp." + new TvlMetaInformation().getSyntaxName()));
		resource.load(inputStream, options);
		inputStream.close();
		return resource;
	}

	private Map<?, ?> getLoadOptions() {
		Map<Object, Object> options = new LinkedHashMap<Object, Object>();
		options.put(ITvlOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new InterpreterProvider());
		return options;
	}
}
