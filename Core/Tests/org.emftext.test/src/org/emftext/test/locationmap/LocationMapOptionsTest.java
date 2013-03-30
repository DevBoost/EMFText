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
package org.emftext.test.locationmap;

import static org.emftext.test.ConcreteSyntaxTestHelper.getConcreteSyntax;
import static org.emftext.test.ConcreteSyntaxTestHelper.registerResourceFactories;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.ICsOptions;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.test.PluginTestHelper;

/**
 * This is a test case for bug 856 (Syntaxes that import theirself cause a
 * StackOverflowError when opened in the editor). It loads a .cs file containing
 * a self import and checks the result.
 */
public class LocationMapOptionsTest extends TestCase {

	public void setUp() {
		registerResourceFactories();
	}

	public void testDisableLocationMapOption() {
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		String path = pluginRootPath + "/src/org/emftext/test/locationmap/main.cs";
		File file = new File(path);
		CsResource resource = (CsResource) new ResourceSetImpl().createResource(URI
				.createFileURI(file.getAbsolutePath()));
		try {
			resource.load(null);
			ConcreteSyntax cs = getConcreteSyntax(resource);
			int l = resource.getLocationMap().getLine(cs.getRules().get(0));
			//location map enabled -> location information available
			assertEquals(10, l);

			resource.unload();
			resource.load(Collections.singletonMap(
					ICsOptions.DISABLE_LOCATION_MAP, true));
			cs = getConcreteSyntax(resource);
			l = resource.getLocationMap().getLine(cs.getRules().get(0));
			//location map disabled -> no location information available
			assertEquals(-1, l);
			
			resource.unload();
			resource.load(null);
			resource.load(Collections.singletonMap(
					ICsOptions.DISABLE_LOCATION_MAP, true)); //no effect since already loaded
			cs = getConcreteSyntax(resource);
			l = resource.getLocationMap().getLine(cs.getRules().get(0));
			//location map enabled -> location information available
			assertEquals(10, l);
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	public void testDisableLayoutInformationRecording() {
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		String path = pluginRootPath + "/src/org/emftext/test/locationmap/main.cs";
		File file = new File(path);
		CsResource resource = (CsResource) new ResourceSetImpl().createResource(URI
				.createFileURI(file.getAbsolutePath()));
		try {
			resource.load(null);
			ConcreteSyntax cs = getConcreteSyntax(resource);
			Rule r = cs.getRules().get(0);
			// layout information adapter available
			assertEquals(1, r.eAdapters().size());

			resource.unload();
			resource.load(Collections.singletonMap(
					ICsOptions.DISABLE_LAYOUT_INFORMATION_RECORDING, true));
			cs = getConcreteSyntax(resource);
			r = cs.getRules().get(0);
			// no layout information adapter available
			assertEquals("There must be no layout information adapters.", 0, r.eAdapters().size());
			
			resource.unload();
			resource.load(null);
			resource.load(Collections.singletonMap(
					ICsOptions.DISABLE_LAYOUT_INFORMATION_RECORDING, true)); //no effect since already loaded
			cs = getConcreteSyntax(resource);
			r = cs.getRules().get(0);
			// layout information adapter available
			assertEquals(1, r.eAdapters().size());
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
}
