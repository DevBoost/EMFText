package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;

/**
 * An experimental (not yet implemented) generator for the SGLR compiler
 * framework.
 */
// TODO sheyden: implement this generator
public class SGLRGrammarGenerator implements IGenerator {

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
