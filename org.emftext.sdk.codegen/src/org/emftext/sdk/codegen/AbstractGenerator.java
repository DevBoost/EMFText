package org.emftext.sdk.codegen;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGenerator<ContextType> implements IGenerator<ContextType>, IProblemCollector {

	private List<GenerationProblem> errors;
	private List<GenerationProblem> warnings;

	public AbstractGenerator() {
		super();
		errors = new LinkedList<GenerationProblem>();
		warnings = new LinkedList<GenerationProblem>();
	}
	
	/**
	 * Can be used by base classes to collect problems.
	 * 
	 * @param problem
	 */
	public void addProblem(GenerationProblem problem){
		if (problem.getSeverity().equals(GenerationProblem.Severity.ERROR)) {
			errors.add(problem);
		} else {
			warnings.add(problem);
		}
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return errors;
	}
	
	public Collection<GenerationProblem> getCollectedProblems() {
		List<GenerationProblem> allProblems = new LinkedList<GenerationProblem>(errors);
		allProblems.addAll(warnings);
		return allProblems;
	}
}
