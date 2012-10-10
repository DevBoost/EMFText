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
package org.emftext.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.provider.ConcreteSyntaxItemProvider;
import org.emftext.sdk.concretesyntax.provider.ConcretesyntaxItemProviderAdapterFactory;
import org.emftext.sdk.concretesyntax.resource.cs.ICsOptions;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;

/**
 * This is a test for EMFText GitHub issue #12. 
 */
public class ItemProviderMemoryLeakTest extends TestCase {

	private final class InspectableConcreteSyntaxItemProvider extends
			ConcreteSyntaxItemProvider {
		
		private InspectableConcreteSyntaxItemProvider(AdapterFactory adapterFactory) {
			super(adapterFactory);
		}

		public List<Notifier> getTargets() {
			return targets;
		}
	}

	private final class InspectableAdapterFactory extends
			ConcretesyntaxItemProviderAdapterFactory {

		private InspectableConcreteSyntaxItemProvider inspectableProvider;
		
		public InspectableAdapterFactory() {
			super();
			this.inspectableProvider = new InspectableConcreteSyntaxItemProvider(this);
		}
		
		public InspectableConcreteSyntaxItemProvider getInspectableProvider() {
			return inspectableProvider;
		}

		@Override
		public Adapter createConcreteSyntaxAdapter() {
			return inspectableProvider;
		}
	}

	public void testResourceReloading() {
		String pluginRootPath = new PluginTestHelper().getPluginRootPath(ConcreteSyntax.class);
		String path = pluginRootPath + "/../metamodel/concretesyntax.cs";
		try {
			Map<Object, Object> options = new LinkedHashMap<Object, Object>();
			options.put(ICsOptions.DISABLE_LAYOUT_INFORMATION_RECORDING, true);
			options.put(ICsOptions.DISABLE_LOCATION_MAP, true);
			
			// load resource (initially)
			Resource resource = ConcreteSyntaxTestHelper.loadCsResource(path, options);
			assertTrue(resource instanceof CsResource);
			CsResource csResource = (CsResource) resource;
			
			InspectableAdapterFactory inspectableAdapter = new InspectableAdapterFactory();
			InspectableConcreteSyntaxItemProvider inspectableProvider = inspectableAdapter.getInspectableProvider();
			AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(inspectableAdapter);

			// reload twice
			reload(path, options, csResource, inspectableProvider, labelProvider);
			reload(path, options, csResource, inspectableProvider, labelProvider);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}

	private void reload(String path, Map<Object, Object> options,
			CsResource csResource,
			InspectableConcreteSyntaxItemProvider inspectableProvider,
			AdapterFactoryLabelProvider labelProvider)
			throws IOException {
		
		// reload resource (this is what happens while typing in the editor)
		InputStream inputStream = new FileInputStream(new File(path).getAbsoluteFile());
		csResource.reload(inputStream, options);
		
		// check contents of resource
		List<EObject> contents = csResource.getContents();
		assertFalse(contents.isEmpty());
		EObject root = contents.get(0);

		// check adapters (before getting the text)
		List<Adapter> eAdapters = root.eAdapters();
		assertTrue("There must not be adapters after loading the resource", eAdapters.isEmpty());
		
		// get text using the label provider
		labelProvider.getText(root);
		
		// check adapters (after getting the text)
		assertFalse("There must be an adapter (ItemProviderAdapter) attached after calling getText()", eAdapters.isEmpty());
		List<Notifier> targets = inspectableProvider.getTargets();
		assertTrue("The targets list must remain empty or have a size of 1", targets == null || targets.size() <= 1);
	}
}
