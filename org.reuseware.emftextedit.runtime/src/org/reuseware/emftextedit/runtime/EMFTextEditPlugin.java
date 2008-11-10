package org.reuseware.emftextedit.runtime;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Jendrik Johannes (jj2)
 */
public class EMFTextEditPlugin extends Plugin {
	
	public static final String PLUGIN_ID = "org.reuseware.ecoretextedit.runtime";
	public static final String EP_CONCRETESYNTAX_ID = "org.reuseware.emftextedit.runtime.concretesyntax";
	
	private static EMFTextEditPlugin plugin;
	
	/**
	 * The constructor
	 */
	public EMFTextEditPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static EMFTextEditPlugin getDefault() {
		return plugin;
	}
	
	private static Map<String, URI> URIToConcreteSyntaxLocationMap = null;
	
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
			
	        IExtensionPoint csExtensionPoint = Platform.getExtensionRegistry().getExtensionPoint(EP_CONCRETESYNTAX_ID);
	        IConfigurationElement[] parserPoints = csExtensionPoint.getConfigurationElements();
	        for(int i = 0;i < parserPoints.length;i++) {
	        	String uri       = parserPoints[i].getAttribute("uri");
	            String csName    = parserPoints[i].getAttribute("csName");
	            String file      = parserPoints[i].getAttribute("csDefinition");
	            URI fileURI = URI.createPlatformPluginURI("/" + file, true);
	            
	            URIToConcreteSyntaxLocationMap.put(uri + "%%" + csName, fileURI);
	        }
			
		}
		return URIToConcreteSyntaxLocationMap;
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
		IStatus status = new Status(IStatus.ERROR, EMFTextEditPlugin.PLUGIN_ID,
				0, message, exception);
		EMFTextEditPlugin.getDefault().getLog().log(status);
		return status;
	}

}
