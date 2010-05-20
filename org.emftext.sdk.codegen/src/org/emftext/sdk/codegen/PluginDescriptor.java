package org.emftext.sdk.codegen;

import org.emftext.sdk.IPluginDescriptor;

public class PluginDescriptor implements IPluginDescriptor {

	private String name;
	
	public PluginDescriptor(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
