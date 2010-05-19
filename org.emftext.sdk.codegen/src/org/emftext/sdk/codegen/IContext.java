package org.emftext.sdk.codegen;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;

/**
 * An interface that defines methods which must be implemented by all
 * code generation contexts.
 */
public interface IContext {

	public IFileSystemConnector getFileSystemConnector();
	
	public IProblemCollector getProblemCollector();

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<?, ?> artifact);
}
