package org.emftext.sdk.codegen.newproject.creators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.ICreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.FoldersCreator;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.newproject.NewProjectConstants;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.generators.GenModelGenerator;
import org.emftext.sdk.codegen.newproject.generators.MetaModelGenerator;
import org.emftext.sdk.codegen.newproject.generators.SyntaxGenerator;

public class NewProjectContentsCreator implements ICreator<NewProjectGenerationContext> {

	public void generate(NewProjectGenerationContext context,
			IProgressMonitor monitor) throws IOException {
		for (IArtifactCreator<NewProjectGenerationContext> creator : getCreators(context)) {
			creator.createArtifacts(context);
		}
	}
	
	public List<IArtifactCreator<NewProjectGenerationContext>> getCreators(NewProjectGenerationContext context) {
		ArtifactDescriptor<NewProjectGenerationContext> metamodel  = 
			new ArtifactDescriptor<NewProjectGenerationContext>(
					context.getPluginDescriptor(), 
					NewProjectConstants.META_MODEL_PACKAGE, 
					"", 
					context.getParameters().
					getEcoreFile(), 
					new MetaModelGenerator(), 
					null);

		ArtifactDescriptor<NewProjectGenerationContext> genModel  = 
			new ArtifactDescriptor<NewProjectGenerationContext>(
					context.getPluginDescriptor(), 
					NewProjectConstants.META_MODEL_PACKAGE, 
					"", 
					context.getParameters().
					getGenmodelFile(), 
					new GenModelGenerator(), 
					null);

		ArtifactDescriptor<NewProjectGenerationContext> syntax  = 
			new ArtifactDescriptor<NewProjectGenerationContext>(
					context.getPluginDescriptor(), 
					NewProjectConstants.META_MODEL_PACKAGE, 
					"", 
					context.getParameters().
					getSyntaxFile(), 
					new SyntaxGenerator(), 
					null);

		List<IArtifactCreator<NewProjectGenerationContext>> creators = new ArrayList<IArtifactCreator<NewProjectGenerationContext>>();
		
		creators.add(new FoldersCreator<NewProjectGenerationContext>(new File(context.getProjectFolder() + File.separator + NewProjectConstants.META_MODEL_PACKAGE)));
    	creators.add(new GenericArtifactCreator<NewProjectGenerationContext>(metamodel));
    	creators.add(new GenericArtifactCreator<NewProjectGenerationContext>(genModel));
    	creators.add(new GenericArtifactCreator<NewProjectGenerationContext>(syntax));
    	creators.add(new GenerateCodeCreator());
    	creators.add(new TextResourcePluginCreator());
    	//creators.add(new DotClasspathCreator(plugin));
		return creators; 
	}
}
