/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.emftext.access.resource.IMetaInformation;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the EMFText access plug-in life cycle
 */
public class EMFTextAccessPlugin extends Plugin {
	
	public static final String PLUGIN_ID = "org.emftext.access";
	public static final String EP_SYNTAX_ID = PLUGIN_ID + ".syntax";
	public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + ".default_load_options";
	
	private static EMFTextAccessPlugin plugin;
	
	/**
	 * The constructor
	 */
	public EMFTextAccessPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EMFTextAccessPlugin getDefault() {
		return plugin;
	}
	
	private static Map<String, URI> URIToConcreteSyntaxLocationMap = null;
	private static List<String>     concreteSyntaxNamesList = null;
	private static boolean concreteSyntaxRegistryIsInitialized = false;
	private static List<IMetaInformation> concreteSyntaxRegistry;
	
	/**
	 * Returns the concrete syntax models that are registered through generated plugins. 
	 * The returned maps contains keys that have the format: 
	 * 
	 * <ul>
	 *   <li> <i>MetmaodelURI</i>%%<i>ConcreteSyntaxName</i>
	 * </ul>
	 * 
	 * @return The map. 
	 */
	public static Map<String, URI> getURIToConcreteSyntaxLocationMap() {
		if (URIToConcreteSyntaxLocationMap == null) {
			URIToConcreteSyntaxLocationMap = new HashMap<String, URI>();

	        List<IMetaInformation> syntaxPlugins = getConcreteSyntaxRegistry();
	        for (IMetaInformation syntaxPlugin : syntaxPlugins) {
	        	String uri       = syntaxPlugin.getURI();
	            String csName    = syntaxPlugin.getSyntaxName();
	            String file      = syntaxPlugin.getPathToCSDefinition();
	            URI fileURI = URI.createPlatformPluginURI("/" + file, true);	            
	            URIToConcreteSyntaxLocationMap.put(uri + "%%" + csName, fileURI);
	        }
		}
		return URIToConcreteSyntaxLocationMap;
	}
	
	public static List<String> getConcreteSyntaxNamesList() {
		if (concreteSyntaxNamesList == null) {
			concreteSyntaxNamesList = new ArrayList<String>();

	        List<IMetaInformation> syntaxPlugins = getConcreteSyntaxRegistry();
	        for (IMetaInformation syntaxPlugin : syntaxPlugins) {
	            String csName = syntaxPlugin.getSyntaxName();
	            concreteSyntaxNamesList.add(csName);
			}
		}
		return concreteSyntaxNamesList;
	}
	
	public static List<IMetaInformation> getConcreteSyntaxRegistry() {
		if (!concreteSyntaxRegistryIsInitialized) {
			concreteSyntaxRegistry = new ArrayList<IMetaInformation>();
			concreteSyntaxRegistryIsInitialized = true;
			// check for syntax extensions
			if (Platform.isRunning()) {
				org.eclipse.core.runtime.IExtensionRegistry extensionRegistry = org.eclipse.core.runtime.Platform.getExtensionRegistry();
				org.eclipse.core.runtime.IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(org.emftext.access.EMFTextAccessPlugin.EP_SYNTAX_ID);
				for (org.eclipse.core.runtime.IConfigurationElement element : configurationElements) {
					try {
						Object metaInformation = element.createExecutableExtension("class");
						registerConcreteSyntax(metaInformation);
					} catch (CoreException ce) {
						org.emftext.access.EMFTextAccessPlugin.logError("Exception while registering syntax extension.", ce);
					}
				}
			}
		}
		return concreteSyntaxRegistry;
	}

	public static void registerConcreteSyntax(
			Object metaInformation) {
		IMetaInformation accessProxy = 
			(IMetaInformation) EMFTextAccessProxy.get(metaInformation, IMetaInformation.class);
		 getConcreteSyntaxRegistry().add(accessProxy);
	}

	/**
	 * Helper method for error logging.
	 * 
	 * @param message
	 *            the error message
	 * @param exception
	 *            the exception that describes the error in detail
	 * @return the status object describing the error
	 */
	public static IStatus logError(String message, Throwable exception) {
		IStatus status;
		if (exception != null) {
			status = new Status(IStatus.ERROR, EMFTextAccessPlugin.PLUGIN_ID,
					0, message, exception);
		}
		else {
			status = new Status(IStatus.ERROR, EMFTextAccessPlugin.PLUGIN_ID,message);
		}
		
		final EMFTextAccessPlugin pluginInstance = EMFTextAccessPlugin.getDefault();
		if (pluginInstance == null) {
			System.err.println(message);
			if (exception != null) {
				exception.printStackTrace();
			}
		} else {
			pluginInstance.getLog().log(status);
		}
		return status;
	}
}
