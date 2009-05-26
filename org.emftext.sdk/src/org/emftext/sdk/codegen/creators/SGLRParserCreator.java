package org.emftext.sdk.codegen.creators;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IArtifactCreator;

/**
 * An experimental (not yet implemented) generator that must call the 
 * SGLR compiler framework to create a parser from an SDF grammar.
 */
//TODO sheyden: implement this creator
public class SGLRParserCreator implements IArtifactCreator {

	public void createArtifacts(GenerationContext context) {
	}

	public String getArtifactDescription() {
		return null;
	}
}
