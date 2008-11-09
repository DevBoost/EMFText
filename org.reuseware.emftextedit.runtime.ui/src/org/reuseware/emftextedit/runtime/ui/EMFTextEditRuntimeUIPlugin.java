package org.reuseware.emftextedit.runtime.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.reuseware.emftextedit.runtime.GenPackageInRegistryFinder;
import org.reuseware.emftextedit.runtime.GenPackageInWorkspaceFinder;
import org.reuseware.emftextedit.runtime.MetamodelManager;

public class EMFTextEditRuntimeUIPlugin extends AbstractUIPlugin {
	
	private static EMFTextEditRuntimeUIPlugin plugin;
	
	public EMFTextEditRuntimeUIPlugin() {
		// TODO mseifert: this should be done in the SDK UI plug-in, but
		// the activator there is started too late
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
	public static EMFTextEditRuntimeUIPlugin getDefault() {
		return plugin;
	}
}
