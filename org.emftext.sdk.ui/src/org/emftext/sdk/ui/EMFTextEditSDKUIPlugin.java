package org.emftext.sdk.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.emftext.sdk.codegen.ResourcePackageGenerator;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class EMFTextEditSDKUIPlugin extends AbstractUIPlugin {
	
	//public final static String PLUGIN_ID = "org.reuseware.emftextedit.sdk.ui";
	
	public final static String GENERATE_TEST_ACTION_NAME = "genTestAction";
	public final static String GENERATE_GEN_MODEL = "genGenModel";
	public final static String OVERRIDE_PLUGIN_CONFIG_NAME = "ovrPluginConfig";
	
	private static EMFTextEditSDKUIPlugin plugin;
	
	public EMFTextEditSDKUIPlugin() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		initPreferences();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	public static EMFTextEditSDKUIPlugin getDefault() {
		return plugin;
	}

	private void initPreferences(){
		getPreferenceStore().setDefault(GENERATE_TEST_ACTION_NAME,false);
		getPreferenceStore().setDefault(OVERRIDE_PLUGIN_CONFIG_NAME,true);
		getPreferenceStore().setDefault(GENERATE_GEN_MODEL,true);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_ANTLR_SPEC_NAME,true);
		getPreferenceStore().setDefault(ResourcePackageGenerator.GENERATE_PRINTER_STUB_ONLY_NAME,false);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_PROXY_RESOLVERS_NAME,false);		
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_TREE_ANALYSER_NAME,true);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVERS_NAME,false);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME,true);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_PRINTER_NAME,true);
	}
}
