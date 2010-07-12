package org.emftext.sdk.codegen.parameters;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.IContext;

public abstract class AbstractArtifactParameter<ContextType extends IContext<ContextType>, ParameterType> implements IArtifactParameter<ContextType, ParameterType> {

	private ArtifactDescriptor<ContextType, ParameterType> artifact;

	public AbstractArtifactParameter(ArtifactDescriptor<ContextType, ParameterType> artifact) {
		super();
		this.artifact = artifact;
	}

	public ArtifactDescriptor<ContextType, ParameterType> getArtifact() {
		return artifact;
	}
}
