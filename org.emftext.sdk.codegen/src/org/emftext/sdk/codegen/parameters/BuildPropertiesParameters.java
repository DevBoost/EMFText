package org.emftext.sdk.codegen.parameters;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.emftext.sdk.IPluginDescriptor;

/**
 * A parameter class that can be used to specify the content of build.properties
 * files.
 */
public class BuildPropertiesParameters {
	
	private Collection<String> sourceFolders = new LinkedHashSet<String>();
	private Collection<String> binIncludes = new LinkedHashSet<String>();
	private IPluginDescriptor plugin;

	public BuildPropertiesParameters(IPluginDescriptor plugin) {
		super();
		this.plugin = plugin;
	}

	public Collection<String> getSourceFolders() {
		return sourceFolders;
	}

	public Collection<String> getBinIncludes() {
		return binIncludes;
	}

	public IPluginDescriptor getProject() {
		return plugin;
	}
}
