package org.emftext.sdk.codegen.newproject;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;

/**
 * This class contains constants for all artifacts that are created while
 * generating a new EMFText project.
 */
public class NewProjectArtifacts {
	
	public final static ArtifactDescriptor<NewProjectGenerationContext, ClassPathParameters<NewProjectGenerationContext>> DOT_CLASSPATH = new ArtifactDescriptor<NewProjectGenerationContext, ClassPathParameters<NewProjectGenerationContext>>(null, "", "", null, null);
	public final static ArtifactDescriptor<NewProjectGenerationContext, DotProjectParameters<NewProjectGenerationContext>> DOT_PROJECT = new ArtifactDescriptor<NewProjectGenerationContext, DotProjectParameters<NewProjectGenerationContext>>(null, "", "", null, null);
	
	public final static ArtifactDescriptor<NewProjectGenerationContext, ArtifactParameter<NewProjectGenerationContext>> META_MODEL = null;
	public final static ArtifactDescriptor<NewProjectGenerationContext, ArtifactParameter<NewProjectGenerationContext>> GEN_MODEL = null;
	public final static ArtifactDescriptor<NewProjectGenerationContext, ArtifactParameter<NewProjectGenerationContext>> SYNTAX = null;
}
