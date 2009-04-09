package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.generators.BabylonSpecificationGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BabylonSpecificationCreator extends AbstractArtifactCreator {

	public Collection<IArtifact> getArtifactsToCreate(GenerationContext context) {
		
		String specificationName = context.getCapitalizedConcreteSyntaxName();
		String packagePath = context.getPackagePath();
  		File specificationFile = new File(packagePath + specificationName + ".babylon");
		
	    InputStream grammarStream = invokeGeneration(new BabylonSpecificationGenerator(context), context.getProblemCollector());
	    if (grammarStream == null) {
			context.getProblemCollector().addProblem(new GenerationProblem("Exception while generating ANTLR grammar.", null, GenerationProblem.Severity.ERROR, null));
	    	return new ArrayList<IArtifact>();
	    }
	    Artifact artifact = new Artifact(specificationFile, grammarStream);
	    return toList(artifact);
	}

	public OptionTypes getOverrideOption() {
		return OptionTypes.OVERRIDE_PARSER_SPEC;
	}
}
