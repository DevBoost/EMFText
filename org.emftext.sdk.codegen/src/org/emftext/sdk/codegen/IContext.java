package org.emftext.sdk.codegen;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;

public interface IContext {

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<?, ?> artifact);
	public IFileSystemConnector getFileSystemConnector();
}
