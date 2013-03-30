/*******************************************************************************
 * Copyright (c) 2006-2013
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.ICsOptions;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.test.PluginTestHelper;
import org.junit.Before;
import org.junit.Test;

/**
 * The {@link LocationMapOptionsTest} checks whether options to disabled layout
 * information recording and the location map do work as expected.
 */
public class LocationMapOptionsTest {

	@Before
	public void setUp() {
		registerResourceFactories();
	}

	@Test
	public void testDisableLocationMapOption() {
		Map<String, Boolean> options = Collections.singletonMap(
				ICsOptions.DISABLE_LOCATION_MAP, true);

		File file = getInputFile();
		CsResource resource = createResource(file);
		try {
			resource.load(null);
			ConcreteSyntax cs = getConcreteSyntax(resource);
			int l = resource.getLocationMap().getLine(cs.getRules().get(0));
			//location map enabled -> location information available
			assertEquals("Location information expected.", 10, l);

			resource.unload();
			resource.load(options);
			cs = getConcreteSyntax(resource);
			l = resource.getLocationMap().getLine(cs.getRules().get(0));
			//location map disabled -> no location information available
			assertEquals("Location information not expected.", -1, l);
			
			resource.unload();
			resource.load(null);
			resource.load(options); //no effect since already loaded
			cs = getConcreteSyntax(resource);
			l = resource.getLocationMap().getLine(cs.getRules().get(0));
			//location map enabled -> location information available
			assertEquals("Location information expected.", 10, l);
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testDisableLayoutInformationRecording() {
		Map<String, Boolean> options = Collections.singletonMap(
				ICsOptions.DISABLE_LAYOUT_INFORMATION_RECORDING, true);

		File file = getInputFile();
		CsResource resource = createResource(file);
		try {
			resource.load(null);
			ConcreteSyntax cs = getConcreteSyntax(resource);
			Rule r = cs.getRules().get(0);
			// layout information adapter available
			assertEquals("Layout adapter expected.", 1, r.eAdapters().size());

			resource.unload();
			resource.load(options);
			cs = getConcreteSyntax(resource);
			r = cs.getRules().get(0);
			// no layout information adapter available
			assertEquals("There must be no layout information adapters.", 0, r.eAdapters().size());
			
			resource.unload();
			resource.load(null);
			resource.load(options); //no effect since already loaded
			cs = getConcreteSyntax(resource);
			r = cs.getRules().get(0);
			// layout information adapter available
			assertEquals("Layout adapter expected.", 1, r.eAdapters().size());
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private CsResource createResource(File file) {
		ResourceSetImpl rs = new ResourceSetImpl();
		String absolutePath = file.getAbsolutePath();
		URI uri = URI.createFileURI(absolutePath);
		CsResource resource = (CsResource) rs.createResource(uri);
		return resource;
	}

	private File getInputFile() {
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(getClass());
		String path = pluginRootPath + "/src/org/emftext/test/locationmap/main.cs";
		File file = new File(path);
		return file;
	}
}
