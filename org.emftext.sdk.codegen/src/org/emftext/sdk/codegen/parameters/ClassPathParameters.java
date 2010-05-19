package org.emftext.sdk.codegen.parameters;

import java.util.LinkedHashSet;
import java.util.Set;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;

/**
 * A parameter class that can be used to specify the content of .classpath
 * files.
 */
public class ClassPathParameters<ContextType extends IContext> 
	extends AbstractArtifactParameter<ContextType, ClassPathParameters<ContextType>> {

	private Set<String> sourceFolders = new LinkedHashSet<String>();
	private IPluginDescriptor plugin;
	
	public ClassPathParameters(ArtifactDescriptor<ContextType, ClassPathParameters<ContextType>> artifact, IPluginDescriptor plugin) {
		super(artifact);
		this.plugin = plugin;
	}

	public Set<String> getSourceFolders() {
		return sourceFolders;
	}

	public IPluginDescriptor getPlugin() {
		return plugin;
	}
}
