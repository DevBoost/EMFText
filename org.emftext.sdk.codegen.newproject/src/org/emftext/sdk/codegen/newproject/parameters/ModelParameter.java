package org.emftext.sdk.codegen.newproject.parameters;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.newproject.NewProjectGenerationContext;
import org.emftext.sdk.codegen.parameters.AbstractArtifactParameter;

public class ModelParameter<ModelType> extends AbstractArtifactParameter<NewProjectGenerationContext, ModelParameter<ModelType>> {

	private ModelType model;

	public ModelParameter(ArtifactDescriptor<NewProjectGenerationContext, ModelParameter<ModelType>> artifact, ModelType model) {
		super(artifact);
		this.model = model;
	}

	public ModelType getModel() {
		return model;
	}
}
