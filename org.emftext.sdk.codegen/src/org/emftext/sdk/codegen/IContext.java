package org.emftext.sdk.codegen;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;

/**
 * An interface that defined method which must be implemented by all
 * code generation contexts.
 */
public interface IContext {

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<?, ?> artifact);
	public IFileSystemConnector getFileSystemConnector();
}
