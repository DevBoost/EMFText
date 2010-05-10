package org.emftext.sdk.codegen.parameters;

import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.sdk.IPluginDescriptor;

/**
 * A parameter class that can be used to specify the content of .classpath
 * files.
 */
public class ClassPathParameters {

	private Set<String> sourceFolders = new LinkedHashSet<String>();
	private IPluginDescriptor plugin;
	
	public ClassPathParameters(IPluginDescriptor plugin) {
		super();
		this.plugin = plugin;
	}

	public Set<String> getSourceFolders() {
		return sourceFolders;
	}

	public IPluginDescriptor getPlugin() {
		return plugin;
	}
}
