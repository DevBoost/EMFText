package org.emftext.sdk.codegen.creators;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.OptionTypes;

public abstract class TextResourceArtifactCreator<ParameterType> extends GenericArtifactCreator<GenerationContext, ParameterType> {

	public TextResourceArtifactCreator(String artifactName, ParameterType parameters) {
		super(artifactName, parameters);
	}

	protected boolean doOverride(GenerationContext context) {
		OptionTypes overrideOption = getOverrideOption();
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), overrideOption);
		return doOverride;
	}
}
