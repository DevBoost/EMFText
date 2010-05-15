package org.emftext.sdk.codegen.newproject.creators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IPluginCreator;
import org.emftext.sdk.codegen.creators.AbstractGenerationComponent;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.FoldersCreator;
import org.emftext.sdk.codegen.creators.OverridingArtifactCreator;
import org.emftext.sdk.codegen.newproject.NewProjectArtifacts;
import org.emftext.sdk.codegen.newproject.NewProjectConstants;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.newproject.TextResourceCreator;
import org.emftext.sdk.codegen.newproject.generators.GenModelGenerator;
import org.emftext.sdk.codegen.newproject.generators.MetaModelGenerator;
import org.emftext.sdk.codegen.newproject.generators.SyntaxGenerator;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;

/**
 * This class creates the content of new EMFText project. First it uses special
 * generators to create a meta model, a concrete syntax and a generator model. 
 * Afterwards the EMF code generation and the EMFText code generation is called
 * to obtain runnable DSL plug-ins. 
 */
public class NewProjectContentsCreator extends AbstractGenerationComponent implements IPluginCreator<NewProjectGenerationContext, Object> {

	public NewProjectContentsCreator(ICodeGenerationComponent parent) {
		super(parent);
	}

	public void create(IPluginDescriptor plugin, NewProjectGenerationContext context, Object parameters,
			IProgressMonitor unusedMonitor) throws IOException {

		IProgressMonitor monitor = context.getMonitor();
		List<IArtifactCreator<NewProjectGenerationContext>> creators = getCreators(context);
		monitor.beginTask("Creating new project", creators.size());
		for (IArtifactCreator<NewProjectGenerationContext> creator : creators) {
			creator.createArtifacts(context.getPluginDescriptor(), context);
			monitor.worked(1);
		}
	}
	
	public List<IArtifactCreator<NewProjectGenerationContext>> getCreators(NewProjectGenerationContext context) {
		ArtifactDescriptor<NewProjectGenerationContext, Object> metamodel  = 
			new ArtifactDescriptor<NewProjectGenerationContext, Object>(
					NewProjectConstants.META_MODEL_PACKAGE, 
					"", 
					context.getParameters().getEcoreFile(), 
					MetaModelGenerator.PROVIDER, 
					null);

		ArtifactDescriptor<NewProjectGenerationContext, Object> genModel  = 
			new ArtifactDescriptor<NewProjectGenerationContext, Object>(
					NewProjectConstants.META_MODEL_PACKAGE, 
					"", 
					context.getParameters().getGenmodelFile(), 
					GenModelGenerator.PROVIDER, 
					null);

		ArtifactDescriptor<NewProjectGenerationContext, Object> syntax  = 
			new ArtifactDescriptor<NewProjectGenerationContext, Object>(
					NewProjectConstants.META_MODEL_PACKAGE, 
					"", 
					context.getParameters().getSyntaxFile(), 
					SyntaxGenerator.PROVIDER, 
					null);

		List<IArtifactCreator<NewProjectGenerationContext>> creators = new ArrayList<IArtifactCreator<NewProjectGenerationContext>>();
		
		creators.add(new FoldersCreator<NewProjectGenerationContext>(this, new File(context.getProjectFolder(context.getPluginDescriptor()) + File.separator + NewProjectConstants.META_MODEL_PACKAGE)));
    	creators.add(new OverridingArtifactCreator<NewProjectGenerationContext, Object>(this, metamodel));
    	creators.add(new OverridingArtifactCreator<NewProjectGenerationContext, Object>(this, genModel));
    	creators.add(new OverridingArtifactCreator<NewProjectGenerationContext, Object>(this, syntax));
    	creators.add(new GenerateCodeCreator(this));
    	creators.add(new TextResourceCreator(this));
    	
    	ClassPathParameters cpp = new ClassPathParameters(context.getPluginDescriptor());
    	cpp.getSourceFolders().add(context.getParameters().getSrcFolder());
		creators.add(new DotClasspathCreator<NewProjectGenerationContext>(this, NewProjectArtifacts.DOT_CLASSPATH, cpp, true));
		creators.add(new DotProjectCreator<NewProjectGenerationContext>(this, NewProjectArtifacts.DOT_PROJECT, context.getPluginDescriptor(), true));
		
		return creators;
	}
}
