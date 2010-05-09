package org.emftext.sdk.codegen;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;

public interface IGenerationContext<ContextType> {

	public IProblemCollector getProblemCollector();
	public File getFile(ArtifactDescriptor<ContextType, ?> artifact);
	public File getProjectFolder(IPluginDescriptor<ContextType> plugin);
}
