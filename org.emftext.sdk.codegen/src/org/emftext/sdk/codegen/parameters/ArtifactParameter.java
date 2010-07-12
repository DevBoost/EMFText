package org.emftext.sdk.codegen.parameters;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;

public class ArtifactParameter<ContextType extends IContext<ContextType>> extends
		AbstractArtifactParameter<ContextType, ArtifactParameter<ContextType>> {

	public ArtifactParameter(ArtifactDescriptor<ContextType, ArtifactParameter<ContextType>> artifact) {
		super(artifact);
	}
}
