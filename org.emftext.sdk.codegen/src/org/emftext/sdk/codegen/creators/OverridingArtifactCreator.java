package org.emftext.sdk.codegen.creators;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IContext;

public class OverridingArtifactCreator<ContextType extends IContext, ParameterType> extends GenericArtifactCreator<ContextType, ParameterType> {

	public OverridingArtifactCreator(ArtifactDescriptor<ContextType, ParameterType> artifact) {
		super(artifact);
	}

	@Override
	public boolean doOverride(ContextType context) {
		return true;
	}
}
