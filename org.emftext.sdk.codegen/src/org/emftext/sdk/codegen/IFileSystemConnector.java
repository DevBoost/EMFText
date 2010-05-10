package org.emftext.sdk.codegen;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;

public interface IFileSystemConnector {

	//public File getFile(ArtifactDescriptor<?, ?> artifact);
	public File getProjectFolder(IPluginDescriptor plugin);
}
