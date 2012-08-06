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
package org.emftext.language.ecore.resource;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class EcoreResourceFactoryDelegator implements Resource.Factory {
	
	protected Map<String, Resource.Factory> factories = null;
	
	public Map<String, Resource.Factory> getResourceFactoriesMap() {
		return factories;
	}
	
	public EcoreResourceFactoryDelegator() {
		init();
	}
	
	public Resource.Factory getFactoryForURI(URI uri) {
		URI trimmedURI = uri.trimFileExtension();
		String secondaryFileExtension = trimmedURI.fileExtension();
		Resource.Factory factory = factories.get(secondaryFileExtension);
		if (factory == null) {
			factory = factories.get("");
		}
		return factory;
	}
	
	public Resource createResource(URI uri) {
		return getFactoryForURI(uri).createResource(uri);
	}
	
	protected void init() {
		if (factories == null) {
			factories = new LinkedHashMap<String, Resource.Factory>();
		}
		if (Platform.isRunning()) {
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(EcoreResourcePlugin.EP_ADDITIONAL_EXTENSION_PARSER_ID);
			for (IConfigurationElement element : configurationElements) {
				try {
					String type = element.getAttribute("type");
					Resource.Factory factory = (Resource.Factory) element.createExecutableExtension("class");
					if (type == null) {
						type = "";
					}
					Resource.Factory otherFactory = factories.get(type);
					if (otherFactory != null) {
						Class<?> superClass = factory.getClass().getSuperclass();
						while(superClass != Object.class) {
							if (superClass.equals(otherFactory.getClass())) {
								factories.put(type, factory);
								break;
							}
							superClass = superClass.getClass();
						}
					}
					else {
						factories.put(type, factory);
					}
				} catch (CoreException ce) {
					EcoreResourcePlugin.logError("Exception while getting default options.", ce);
				}
			}
		}
		if (factories.get("") == null) {
			factories.put("", new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
		}
	}
	
}
