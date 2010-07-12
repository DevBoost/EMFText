package org.emftext.sdk.codegen.creators;

import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.IContext;

public class OverridingArtifactCreator<ContextType extends IContext<ContextType>, ParameterType extends IArtifactParameter<ContextType, ParameterType>> 
	extends GenericArtifactCreator<ContextType, ParameterType> {

	public OverridingArtifactCreator(ParameterType parameters) {
		super(parameters);
	}

	@Override
	public boolean doOverride(ContextType context) {
		return true;
	}
}
