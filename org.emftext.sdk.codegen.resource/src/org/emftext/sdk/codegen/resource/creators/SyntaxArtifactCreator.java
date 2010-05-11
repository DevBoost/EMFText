package org.emftext.sdk.codegen.resource.creators;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class SyntaxArtifactCreator<ParameterType> extends GenericArtifactCreator<GenerationContext, ParameterType> {

	public SyntaxArtifactCreator(ArtifactDescriptor<GenerationContext, ParameterType> artifact) {
		super(artifact);
	}

	@Override
	public boolean doOverride(GenerationContext context) {
		OptionTypes overrideOption = getArtifact().getOverrideOption();
		if (overrideOption == null) {
			return true;
		}
		
		ConcreteSyntax syntax = context.getConcreteSyntax();
		boolean override = OptionManager.INSTANCE.getBooleanOptionValue(syntax, overrideOption);
		return override;
	}
}
