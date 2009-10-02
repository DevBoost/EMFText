package org.emftext.sdk.antlr;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class EMFTextSDKAntlrPlugin extends Plugin {

	public static final String PLUGIN_ID = "org.emftext.sdk.antlr";
	
	private static EMFTextSDKAntlrPlugin plugin;
	
	/**
	 * The constructor
	 */
	public EMFTextSDKAntlrPlugin() {
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
	public static EMFTextSDKAntlrPlugin getDefault() {
		return plugin;
	}
}
