package org.emftext.sdk.codegen;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGenerator<ContextType, ParameterType> implements IGenerator<ContextType, ParameterType>, IProblemCollector {

	protected ContextType context;
	protected ParameterType parameters;
	
	private List<GenerationProblem> errors;
	private List<GenerationProblem> warnings;

	public AbstractGenerator() {
		this(null, null);
	}

	public AbstractGenerator(ContextType context, ParameterType parameters) {
		super();
		this.context = context;
		this.parameters = parameters;
		errors = new LinkedList<GenerationProblem>();
		warnings = new LinkedList<GenerationProblem>();
	}
	
	public boolean generate(OutputStream stream) {
		PrintWriter out = new PrintWriter(new BufferedOutputStream(stream));
		boolean result = generate(out);
		out.flush();
		out.close();
		return result;
	}

	public boolean generate(PrintWriter out) {
		return false;
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
