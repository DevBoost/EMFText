package org.emftext.sdk.codegen.newproject;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.newproject.creators.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.generators.MetaModelGenerator;

public class NewProjectArtifacts {
	
	public static final ArtifactDescriptor<NewProjectGenerationContext> META_MODEL  = 
		new ArtifactDescriptor<NewProjectGenerationContext>(NewProjectConstants.NEW_PROJECT_PLUGIN, NewProjectConstants.META_MODEL_PACKAGE, "", "", new MetaModelGenerator(), null);

}
