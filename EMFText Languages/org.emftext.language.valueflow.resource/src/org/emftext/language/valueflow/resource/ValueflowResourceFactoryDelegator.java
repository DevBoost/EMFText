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
package org.emftext.language.valueflow.resource;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * This resource factory delegates to different resource factories
 * that can handle Valueflow models of different syntax registered by the
 * <code>org.emftext.language.ecore.resource.additional_valueflow_extension_parser</code>
 * extension point.
 * If no parser is registered for a given URI, it delegates to the default
 * <code>org.emftext.language.ecore.resource.EcoreResourceFactoryImpl</code>.
 *
 */
public class ValueflowResourceFactoryDelegator implements Resource.Factory {

	public static final String EP_PARSER = "org.emftext.language.valueflow.resource.additional_extension_parser";

	private final static Map<String, Resource.Factory> valueflowFactories =
		new HashMap<String, Resource.Factory>();

	private final static Resource.Factory defaultXMIFactory =
		new XMIResourceFactoryImpl();

	protected void init() {
		if (valueflowFactories.isEmpty() && Platform.isRunning()) {
	        IExtensionPoint csExtensionPoint = Platform.getExtensionRegistry().getExtensionPoint(EP_PARSER);
	        if (csExtensionPoint != null) {
		        IConfigurationElement[] parserPoints = csExtensionPoint.getConfigurationElements();
		        for(int i = 0;i < parserPoints.length;i++) {
					try {
			        	String           type    = parserPoints[i].getAttribute("type");
			            Resource.Factory factory =
			            	(Resource.Factory) parserPoints[i].createExecutableExtension("class");

			            valueflowFactories.put(type, factory);
					} catch (CoreException e) {
						e.printStackTrace();
						//EMFTextRuntimePlugin.logError(
						//		"Error while instatiating: " + parserPoints[i].getAttribute("class"), e);
					}
		        }
	        }
		}
	}

	public Map<String, Resource.Factory> getEcoreResourceFactoriesMap() {
		return valueflowFactories;
	}

	public Resource.Factory getFactoryForURI(URI uri) {
		URI trimmedURI = uri.trimFileExtension();
		String secondaryFileExtension = trimmedURI.fileExtension();

		Resource.Factory factory = valueflowFactories.get(secondaryFileExtension);

		if (factory == null) {
			factory = defaultXMIFactory;
		}
		return factory;
	}

	public ValueflowResourceFactoryDelegator() {
		init();
	}

	public Resource createResource(URI uri) {
		return getFactoryForURI(uri).createResource(uri);
	}
}
