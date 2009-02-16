package org.emftext.sdk.codegen;

/**
 * An interface that is used to decouple problem handling 
 * from the generators that actually produce the problems.
 */
public interface IProblemCollector {
	public void addProblem(GenerationProblem problem);
}
