package org.emftext.sdk.codegen.parameters;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;

/**
 * A parameter class that can be used to specify the content of build.properties
 * files.
 */
public class BuildPropertiesParameters<ContextType extends IContext<ContextType>> extends AbstractArtifactParameter<ContextType, BuildPropertiesParameters<ContextType>> {
	
	private Collection<String> sourceFolders = new LinkedHashSet<String>();
	private Collection<String> binIncludes = new LinkedHashSet<String>();
	private IPluginDescriptor plugin;

	public BuildPropertiesParameters(ArtifactDescriptor<ContextType, BuildPropertiesParameters<ContextType>> artifact, IPluginDescriptor plugin) {
		super(artifact);
		this.plugin = plugin;
	}

	public Collection<String> getSourceFolders() {
		return sourceFolders;
	}

	public Collection<String> getBinIncludes() {
		return binIncludes;
	}

	public IPluginDescriptor getProject() {
		return plugin;
	}
}
