package org.emftext.sdk.codegen.newproject.creators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.emftext.sdk.codegen.IArtifactCreator;
import org.emftext.sdk.codegen.ICreator;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.newproject.NewProjectArtifacts;

public class NewProjectContentsCreator implements ICreator<NewProjectGenerationContext> {

	public void generate(NewProjectGenerationContext context,
			IProgressMonitor monitor) throws IOException {
		for (IArtifactCreator<NewProjectGenerationContext> creator : getCreators(context)) {
			creator.createArtifacts(context);
		}
	}
	
	public List<IArtifactCreator<NewProjectGenerationContext>> getCreators(NewProjectGenerationContext context) {
		List<IArtifactCreator<NewProjectGenerationContext>> creators = new ArrayList<IArtifactCreator<NewProjectGenerationContext>>();
		
    	creators.add(new GenericArtifactCreator<NewProjectGenerationContext>(NewProjectArtifacts.META_MODEL));
		return creators;
	}
}
