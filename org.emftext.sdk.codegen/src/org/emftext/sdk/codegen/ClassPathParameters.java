package org.emftext.sdk.codegen;

import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.sdk.IPluginDescriptor;

public class ClassPathParameters<ContextType> {

	private Set<String> sourceFolders = new LinkedHashSet<String>();
	private IPluginDescriptor<ContextType> plugin;
	
	public ClassPathParameters(IPluginDescriptor<ContextType> plugin) {
		super();
		this.plugin = plugin;
	}

	public Set<String> getSourceFolders() {
		return sourceFolders;
	}

	public IPluginDescriptor<ContextType> getPlugin() {
		return plugin;
	}
}
