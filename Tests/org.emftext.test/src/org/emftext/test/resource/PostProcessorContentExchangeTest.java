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
package org.emftext.test.resource;

import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntax;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.resource.cs.ICsOptions;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;

public class PostProcessorContentExchangeTest extends TestCase {
	
	public void setUp() {
		registerResourceFactories();
	}
	
	private ConcreteSyntax replacementRoot = 
			ConcretesyntaxFactory.eINSTANCE.createConcreteSyntax();
	private boolean executedPostProcessor = false;

	public void testDisableLocationMapOption() {
		String path = "./src/org/emftext/test/locationmap/main.cs";
		File file = new File(path);
		CsResource resource = (CsResource) new ResourceSetImpl().createResource(URI
				.createFileURI(file.getAbsolutePath()));
		try {
			resource.load(Collections.singletonMap(
					ICsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new ExchangePostProcessor()));
			ConcreteSyntax cs = getConcreteSyntax(resource);
		
			assertTrue("Post processor was not executed.", executedPostProcessor);
			assertEquals(replacementRoot, cs);
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	public class ExchangePostProcessor implements ICsResourcePostProcessorProvider, ICsResourcePostProcessor {

		@Override
		public void process(CsResource resource) {
			resource.getContents().clear();
			resource.getContents().add(replacementRoot);
			executedPostProcessor = true;
		}

		@Override
		public void terminate() { }

		@Override
		public ICsResourcePostProcessor getResourcePostProcessor() {
			return new ExchangePostProcessor();
		}
		
	}

}
