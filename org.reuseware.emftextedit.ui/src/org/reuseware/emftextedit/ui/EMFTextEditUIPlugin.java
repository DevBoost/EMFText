package org.reuseware.emftextedit.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import  org.reuseware.emftextedit.codegen.ResourcePackageGenerator;
import org.reuseware.emftextedit.concretesyntax.resource.cs.analysis.MetamodelManager;
import org.reuseware.emftextedit.ui.actions.GenPackageInRegistryFinder;
import org.reuseware.emftextedit.ui.actions.GenPackageInWorkspaceFinder;

/**
 * The activator class controls the plug-in life cycle
 */
public class EMFTextEditUIPlugin extends AbstractUIPlugin {
	
	public static String GENERATE_TEST_ACTION_NAME = "genTestAction";
	public static String OVERRIDE_PLUGIN_CONFIG_NAME = "ovrPluginConfig";
	public static final String PLUGIN_ID = "org.reuseware.emftextedit.ui";
	private static EMFTextEditUIPlugin plugin;
	
	public EMFTextEditUIPlugin() {
		MetamodelManager.INSTANCE.addGenPackageFinder(new GenPackageInWorkspaceFinder());
		MetamodelManager.INSTANCE.addGenPackageFinder(new GenPackageInRegistryFinder());
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
	public static EMFTextEditUIPlugin getDefault() {
		return plugin;
	}
	
	private void initPreferences(){		
		getPreferenceStore().setDefault(GENERATE_TEST_ACTION_NAME,true);
		getPreferenceStore().setDefault(OVERRIDE_PLUGIN_CONFIG_NAME,true);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_ANTLR_SPEC_NAME,true);
		getPreferenceStore().setDefault(ResourcePackageGenerator.GENERATE_PRINTER_STUB_ONLY_NAME,false);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_PROXY_RESOLVERS_NAME,false);		
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_TREE_ANALYSER_NAME,true);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVERS_NAME,false);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME,true);
		getPreferenceStore().setDefault(ResourcePackageGenerator.OVERRIDE_PRINTER_NAME,true);
	}



}
