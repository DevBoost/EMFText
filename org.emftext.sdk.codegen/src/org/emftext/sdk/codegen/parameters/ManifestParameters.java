package org.emftext.sdk.codegen.parameters;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.emftext.sdk.IPluginDescriptor;

/**
 * A parameter class that can be used to specify the content of manifest
 * files.
 */
public class ManifestParameters {

	private String bundleName;
	private String activatorClass;
	private IPluginDescriptor plugin;
	private Collection<String> requiredBundles = new LinkedHashSet<String>();
	private Collection<String> exportedPackages = new LinkedHashSet<String>();

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	public void setActivatorClass(String activatorClass) {
		this.activatorClass = activatorClass;
	}

	public void setPlugin(IPluginDescriptor plugin) {
		this.plugin = plugin;
	}

	public String getBundleName() {
		return bundleName;
	}

	public String getActivatorClass() {
		return activatorClass;
	}

	public IPluginDescriptor getPlugin() {
		return plugin;
	}

	public Collection<String> getRequiredBundles() {
		return requiredBundles;
	}

	public Collection<String> getExportedPackages() {
		return exportedPackages;
	}
}
