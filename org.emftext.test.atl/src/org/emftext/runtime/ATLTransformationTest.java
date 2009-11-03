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
package org.emftext.runtime;

import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.ecore.resource.text.mopp.TextEcoreResourceFactory;
import org.emftext.runtime.atl.ATLTransformationPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResourceFactory;
import org.junit.Before;

public class ATLTransformationTest extends TestCase {

	@Before
	public void setUp() {
		registerResourceFactories();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new TextEcoreResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("cs",
				new CsResourceFactory());

	}

	public void testTransformationResult() throws Exception {

		String testfile = "platform:/resource/org.emftext.test.atl/model/example.cs";
		loadResourceWithProcessor(testfile);
		
		String outfile = "platform:/resource/org.emftext.test.atl/model/example.out.cs";
		Resource outResource = loadResource(outfile);
		assertEquals(1, outResource.getContents().size());
		assertEquals("wasHere", ((ConcreteSyntax) outResource.getContents().get(0) ).getName());
		
	}
	
	private Resource loadResource(String grammar) throws IOException {
		URI fileUri = URI.createURI(grammar);

		ResourceSet rs = new ResourceSetImpl();
		Resource csResource = rs.getResource(fileUri, true);
		return csResource;
	}

	private Resource loadResourceWithProcessor(String grammar) throws IOException {
		URI fileUri = URI.createURI(grammar);

		ResourceSet rs = new ResourceSetImpl();

		ATLTransformationPostProcessor transformationPostProcessor = new TestTransformationPostProcessor();
		rs.getLoadOptions().putAll(transformationPostProcessor.getOptions());
		Resource csResource = rs.getResource(fileUri, true);
		return csResource;
	}
}
