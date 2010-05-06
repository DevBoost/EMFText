package org.emftext.sdk.codegen;

// TODO move this class to codegen/common
public abstract class AbstractGenerationContext<ContextType> implements IGenerationContext<ContextType> {

	private final IProblemCollector problemCollector;

	public AbstractGenerationContext(IProblemCollector problemCollector) {
		super();
		this.problemCollector = problemCollector;
	}

	public IProblemCollector getProblemCollector() {
		return problemCollector;
	}
}
