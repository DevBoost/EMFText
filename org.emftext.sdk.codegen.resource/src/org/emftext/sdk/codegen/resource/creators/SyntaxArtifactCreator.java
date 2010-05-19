package org.emftext.sdk.codegen.resource.creators;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class SyntaxArtifactCreator<ParameterType extends IArtifactParameter<GenerationContext, ParameterType>> 
	extends GenericArtifactCreator<GenerationContext, ParameterType> {

	/*
	public SyntaxArtifactCreator(ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext, Object>> artifact) {
		super(artifact, new ArtifactParameter<GenerationContext, Object>());
	}
	*/

	public SyntaxArtifactCreator(ParameterType parameters) {
		super(parameters);
	}

	@Override
	public boolean doOverride(GenerationContext context) {
		OptionTypes overrideOption = getParameters().getArtifact().getOverrideOption();
		if (overrideOption == null) {
			return true;
		}
		
		ConcreteSyntax syntax = context.getConcreteSyntax();
		boolean override = OptionManager.INSTANCE.getBooleanOptionValue(syntax, overrideOption);
		return override;
	}
}
