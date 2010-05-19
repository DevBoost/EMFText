package org.emftext.sdk.codegen;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.emftext.sdk.EMFTextSDKPlugin;

public abstract class AbstractGenerator<ContextType extends IContext, ParameterType> implements IGenerator<ContextType, ParameterType>, IProblemCollector {

	private ContextType context;
	private ParameterType parameters;
	
	public AbstractGenerator() {
		super();
	}

	private void init(ContextType context, ParameterType parameters) {
		this.context = context;
		this.parameters = parameters;
	}
	
	public final void generate(ContextType context, ParameterType parameters, OutputStream stream) {
		init(context, parameters);
		
		PrintWriter out = new PrintWriter(new BufferedOutputStream(stream));
		doGenerate(out);
		out.flush();
		out.close();
	}

	public void doGenerate(OutputStream stream) {
		// can be overridden by subclasses
	}

	public void doGenerate(PrintWriter out) {
		// can be overridden by subclasses
	}

	/**
	 * Can be used by base classes to collect problems.
	 * 
	 * @param problem
	 */
	public void addProblem(GenerationProblem problem) {
		getContext().getProblemCollector().addProblem(problem);
	}

	public ContextType getContext() {
		return context;
	}
	
	public ParameterType getParameters() {
		return parameters;
	}

	@SuppressWarnings("unchecked")
	public final IGenerator<ContextType, ParameterType> newInstance(ContextType context, ParameterType parameters) {
		Constructor<?>[] constructors = this.getClass().getConstructors();
		if (constructors.length != 1) {
			throw new RuntimeException("Found generator class with more than one constructor.");
		}
		Object newInstance = null;
		try {
			newInstance = constructors[0].newInstance(context, parameters);
		} catch (IllegalArgumentException e) {
			EMFTextSDKPlugin.logError("Exception while creating generator.", e);
		} catch (InstantiationException e) {
			EMFTextSDKPlugin.logError("Exception while creating generator.", e);
		} catch (IllegalAccessException e) {
			EMFTextSDKPlugin.logError("Exception while creating generator.", e);
		} catch (InvocationTargetException e) {
			EMFTextSDKPlugin.logError("Exception while creating generator.", e);
		}
		return (IGenerator<ContextType, ParameterType>) newInstance;
	}
}
