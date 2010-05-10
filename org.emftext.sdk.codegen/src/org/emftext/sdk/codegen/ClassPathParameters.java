package org.emftext.sdk.codegen;

import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.sdk.IPluginDescriptor;

public class ClassPathParameters<ContextType> {

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
