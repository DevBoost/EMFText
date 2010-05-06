package org.emftext.sdk.codegen.creators;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.OptionTypes;

public abstract class TextResourceArtifactCreator extends GenericArtifactCreator<GenerationContext> {

	public TextResourceArtifactCreator(String artifactName) {
		super(artifactName);
	}

	protected boolean doOverride(GenerationContext context) {
		OptionTypes overrideOption = getOverrideOption();
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), overrideOption);
		return doOverride;
	}
}
