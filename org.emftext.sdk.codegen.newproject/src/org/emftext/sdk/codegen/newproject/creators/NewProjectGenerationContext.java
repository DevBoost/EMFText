package org.emftext.sdk.codegen.newproject.creators;

import java.io.File;

import org.emftext.sdk.codegen.AbstractGenerationContext;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IProblemCollector;

public class NewProjectGenerationContext extends AbstractGenerationContext<NewProjectGenerationContext> {

	private NewProjectParameters parameters;

	public NewProjectGenerationContext(NewProjectParameters parameters, IProblemCollector problemCollector) {
		super(problemCollector);
		this.parameters = parameters;
	}

	public File getFile(ArtifactDescriptor<NewProjectGenerationContext> artifact) {
		// TODO Auto-generated method stub
		return null;
	}

	public NewProjectParameters getParameters() {
		return parameters;
	}
}
