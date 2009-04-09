package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;

// TODO cbuerger
public class BabylonSpecificationGenerator implements IGenerator {

	public BabylonSpecificationGenerator(GenerationContext context) {
	}

	public boolean generate(PrintWriter out) {
		return false;
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return null;
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return null;
	}
}
