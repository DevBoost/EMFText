package org.emftext.sdk.codegen.newproject;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;


public class NewProjectArtifacts {
	
	public final static ArtifactDescriptor<NewProjectGenerationContext, ClassPathParameters> DOT_CLASSPATH = new ArtifactDescriptor<NewProjectGenerationContext, ClassPathParameters>(null, "", "", null, null);
	public final static ArtifactDescriptor<NewProjectGenerationContext, IPluginDescriptor> DOT_PROJECT = new ArtifactDescriptor<NewProjectGenerationContext, IPluginDescriptor>(null, "", "", null, null);

}
