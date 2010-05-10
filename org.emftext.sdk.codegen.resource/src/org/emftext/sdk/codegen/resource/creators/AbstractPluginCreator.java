package org.emftext.sdk.codegen.resource.creators;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.IPluginCreator;
import org.emftext.sdk.codegen.creators.AbstractGenerationComponent;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public abstract class AbstractPluginCreator<ParameterType> extends AbstractGenerationComponent implements IPluginCreator<GenerationContext, ParameterType> {

	public void create(IPluginDescriptor plugin, GenerationContext context, ParameterType parameters, IProgressMonitor monitor) throws IOException {
		setFileSystemConnector(context.getFileSystemConnector());
		SubMonitor progress = SubMonitor.convert(monitor, "generating " + getPluginName() + " plug-in...", 100);
	    
		ConcreteSyntax syntax = context.getConcreteSyntax();
		Resource csResource = syntax.eResource();
		EcoreUtil.resolveAll(csResource);
	    
	    List<IArtifactCreator<GenerationContext>> creators = getCreators(context);
	    // TODO implement extension mechanism to allow code generator plug-ins
	    // to add more creators
	
	    for (IArtifactCreator<GenerationContext> creator : creators) {
			progress.setTaskName("creating " + creator.getArtifactDescription() + "...");
			creator.createArtifacts(plugin, context);
		    progress.worked(100 / creators.size());
	    }
	}

	public abstract String getPluginName();

	public abstract List<IArtifactCreator<GenerationContext>> getCreators(GenerationContext context);

}
