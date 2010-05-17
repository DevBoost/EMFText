package org.emftext.sdk.codegen;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.emftext.sdk.codegen.creators.AbstractGenerationComponent;

public abstract class AbstractGenerator<ContextType, ParameterType> extends AbstractGenerationComponent implements IGenerator<ContextType, ParameterType>, IProblemCollector {

	protected ContextType context;
	protected ParameterType parameters;
	
	public AbstractGenerator() {
		super();
		init(context, parameters);
	}

	public AbstractGenerator(ICodeGenerationComponent parent, ContextType context, ParameterType parameters) {
		super(parent);
		init(context, parameters);
	}

	private void init(ContextType context, ParameterType parameters) {
		this.context = context;
		this.parameters = parameters;
	}
	
	public void generate(OutputStream stream) {
		PrintWriter out = new PrintWriter(new BufferedOutputStream(stream));
		generate(out);
		out.flush();
		out.close();
	}

	public void generate(PrintWriter out) {
		// default implementation does nothing
	}

	/**
	 * Can be used by base classes to collect problems.
	 * 
	 * @param problem
	 */
	public void addProblem(GenerationProblem problem) {
		getProblemCollector().addProblem(problem);
	}

	public abstract IGenerator<ContextType, ParameterType> newInstance(ICodeGenerationComponent parent, ContextType context, ParameterType parameters);
}
