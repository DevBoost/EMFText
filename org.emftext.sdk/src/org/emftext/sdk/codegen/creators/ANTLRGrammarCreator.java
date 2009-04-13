package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.generators.ANTLRGrammarGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ANTLRGrammarCreator extends AbstractArtifactCreator {

	public ANTLRGrammarCreator() {
		super("ANTLR grammar");
	}

	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
	    File antlrFile = context.getANTLRGrammarFile();
		
	    InputStream grammarStream = invokeGeneration(new ANTLRGrammarGenerator(context), context.getProblemCollector());
	    if (grammarStream == null) {
			context.getProblemCollector().addProblem(new GenerationProblem("Exception while generating ANTLR grammar.", null, GenerationProblem.Severity.ERROR, null));
	    	return new ArrayList<IArtifact>();
	    }
	    Artifact artifact = new Artifact(antlrFile, grammarStream);
	    return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PARSER_SPEC;
	}
}
