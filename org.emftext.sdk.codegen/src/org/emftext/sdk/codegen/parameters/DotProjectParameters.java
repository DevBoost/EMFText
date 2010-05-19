package org.emftext.sdk.codegen.parameters;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;

public class DotProjectParameters<ContextType extends IContext> extends AbstractArtifactParameter<ContextType, DotProjectParameters<ContextType>> {

	private final IPluginDescriptor plugin;

	public DotProjectParameters(ArtifactDescriptor<ContextType, DotProjectParameters<ContextType>> artifact, IPluginDescriptor plugin) {
		super(artifact);
		this.plugin = plugin;
	}

	public IPluginDescriptor getPlugin() {
		return plugin;
	}
}
