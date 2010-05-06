package org.emftext.sdk;

public interface IPluginDescriptor<ContextType> {

	//public String getBasePackage(ContextType context);
	public String getName(ContextType context);
}