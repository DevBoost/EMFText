package org.emftext.sdk.codegen.creators;

import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * An experimental (not yet implemented) creator for the SGLR compiler
 * framework.
 */
//TODO sheyden: implement this creator
public class SGLRGrammarCreator extends AbstractArtifactCreator {

	public SGLRGrammarCreator() {
		super("SGLR grammer");
	}

	@Override
	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		return null;
	}

	@Override
	public OptionTypes getOverrideOption() {
		return null;
	}
}
