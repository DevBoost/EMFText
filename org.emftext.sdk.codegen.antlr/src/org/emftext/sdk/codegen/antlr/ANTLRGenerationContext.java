package org.emftext.sdk.codegen.antlr;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.AbstractGenerationContext;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;

public class ANTLRGenerationContext extends AbstractGenerationContext implements IContext {

	public ANTLRGenerationContext() {
		super();
	}

	public File getFile(IPluginDescriptor plugin, ArtifactDescriptor<?, ?> artifact) {
		throw new UnsupportedOperationException();
	}

	public File getProjectFolder(IPluginDescriptor plugin) {
		return getFileSystemConnector().getProjectFolder(plugin);
	}
}
