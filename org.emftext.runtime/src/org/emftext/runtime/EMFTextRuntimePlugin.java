/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime;

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
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the EMFText runtime plug-in life cycle
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 */
public class EMFTextRuntimePlugin extends Plugin {
	
	public static final String PLUGIN_ID = "org.emftext.runtime";
	public static final String EP_SYNTAX_ID = PLUGIN_ID + ".syntax";
	public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + ".default_load_options";
	
	private static EMFTextRuntimePlugin plugin;
	
	/**
	 * The constructor
	 */
	public EMFTextRuntimePlugin() {
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
	public static EMFTextRuntimePlugin getDefault() {
		return plugin;
	}
	
	private static Map<String, URI> URIToConcreteSyntaxLocationMap = null;
	private static List<String>     concreteSyntaxNamesList = null;
	private static boolean concreteSyntaxRegistryIsInitialized = false;
	private static List<ITextResourcePluginMetaInformation> concreteSyntaxRegistry;
	
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

	        List<ITextResourcePluginMetaInformation> syntaxPlugins = getConcreteSyntaxRegistry();
	        for (ITextResourcePluginMetaInformation syntaxPlugin : syntaxPlugins) {
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

	        List<ITextResourcePluginMetaInformation> syntaxPlugins = getConcreteSyntaxRegistry();
	        for (ITextResourcePluginMetaInformation syntaxPlugin : syntaxPlugins) {
	            String csName = syntaxPlugin.getSyntaxName();
	            concreteSyntaxNamesList.add(csName);
			}
		}
		return concreteSyntaxNamesList;
	}
	
	public static List<ITextResourcePluginMetaInformation> getConcreteSyntaxRegistry() {
		if (!concreteSyntaxRegistryIsInitialized) {
			concreteSyntaxRegistry = new ArrayList<ITextResourcePluginMetaInformation>();
			// check for syntax extensions
			if (Platform.isRunning()) {
				org.eclipse.core.runtime.IExtensionRegistry extensionRegistry = org.eclipse.core.runtime.Platform.getExtensionRegistry();
				org.eclipse.core.runtime.IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(org.emftext.runtime.EMFTextRuntimePlugin.EP_SYNTAX_ID);
				for (org.eclipse.core.runtime.IConfigurationElement element : configurationElements) {
					try {
						ITextResourcePluginMetaInformation metaInformation = (ITextResourcePluginMetaInformation) element.createExecutableExtension("class");
						concreteSyntaxRegistry.add(metaInformation);
					} catch (CoreException ce) {
						org.emftext.runtime.EMFTextRuntimePlugin.logError("Exception while registering syntax extension.", ce);
					}
				}
			}
			concreteSyntaxRegistryIsInitialized = true;
		}
		return concreteSyntaxRegistry;
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
			status = new Status(IStatus.ERROR, EMFTextRuntimePlugin.PLUGIN_ID,
					0, message, exception);
		}
		else {
			status = new Status(IStatus.ERROR, EMFTextRuntimePlugin.PLUGIN_ID,
					message);
		}
		
		final EMFTextRuntimePlugin pluginInstance = EMFTextRuntimePlugin.getDefault();
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
