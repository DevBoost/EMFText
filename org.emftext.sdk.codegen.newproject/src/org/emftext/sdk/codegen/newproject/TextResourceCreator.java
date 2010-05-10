package org.emftext.sdk.codegen.newproject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.JavaCore;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.creators.AbstractGenerationComponent;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.CreateTextResourcePluginsJob;
import org.emftext.sdk.codegen.resource.ui.CreateTextResourcePluginsJob.Result;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class TextResourceCreator extends AbstractGenerationComponent implements
		IArtifactCreator<NewProjectGenerationContext> {

	public void createArtifacts(IPluginDescriptor plugin, final NewProjectGenerationContext context) {
		ResourceSet rs = new ResourceSetImpl();
		NewProjectParameters parameters = context.getParameters();
		String syntaxFile = parameters.getSyntaxFile();
		String syntaxFilePath = parameters.getProjectName() + "/" + parameters.getMetamodelFolder() + "/" + syntaxFile;
		Resource csResource = rs.getResource(URI.createPlatformResourceURI(syntaxFilePath, true), true);
		IProblemCollector collector = new IProblemCollector() {
			public void addProblem(GenerationProblem problem) {
				// TODO something about this
			}
		};
		
		ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
		context.setConcreteSyntax(concreteSyntax);
		GenerationContext genContext = new GenerationContext(concreteSyntax) {

			@Override
			public boolean getGenerateANTLRPlugin() {
				return true;
			}

			@Override
			public String getProjectRelativePathToSyntaxFile() {
				NewProjectParameters parameters = context.getParameters();
				return parameters.getMetamodelFolder() + "/" + parameters.getSyntaxFile();
			}

			@Override
			public String getSyntaxProjectName() {
				return context.getParameters().getProjectName();
			}
		};
		genContext.setFileSystemConnector(context.getFileSystemConnector());
		genContext.setProblemCollector(context.getProblemCollector());
		context.setGenerationContext(genContext);
		
		try {
			Result result = new CreateTextResourcePluginsJob() {

				@Override
				public void createProject(
						IPluginDescriptor plugin, GenerationContext context, SubMonitor progress)
						throws Exception {
					String projectName = plugin.getName();
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
					if (!project.exists()) {
						project.create(new NullProgressMonitor());
					}
					project.open(new NullProgressMonitor());
					JavaCore.create(project);
				}
			}.run(genContext, context.getResourceMarker(), context.getMonitor());
		} catch (Exception e) {
			// TODO do something about this
			e.printStackTrace();
		}
	}

	public String getArtifactDescription() {
		return "text resource plug-in";
	}
}
