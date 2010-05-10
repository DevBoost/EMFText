package org.emftext.sdk.codegen.resource.creators;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.OptionTypes;

public abstract class TextResourceArtifactCreator<ParameterType> extends GenericArtifactCreator<GenerationContext, ParameterType> {

	public TextResourceArtifactCreator(ArtifactDescriptor<GenerationContext, ParameterType> artifact, ParameterType parameters) {
		super(artifact, parameters);
	}

	public boolean doOverride(GenerationContext context) {
		OptionTypes overrideOption = getOverrideOption();
		boolean doOverride = overrideOption == null || OptionManager.INSTANCE.getBooleanOptionValue(context.getConcreteSyntax(), overrideOption);
		return doOverride;
	}

	/**
	 * Returns the option that enables/disables this
	 * creator. If the option is set to true the creator
	 * should create or override the artifact. Otherwise
	 * the artifact should be created only in case it does
	 * not exist yet.
	 * 
	 * @return the option to enabled this creator
	 */
	public OptionTypes getOverrideOption() {
		return getArtifact().getOverrideOption();
	}
}
