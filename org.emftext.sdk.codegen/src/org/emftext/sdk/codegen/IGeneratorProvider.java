package org.emftext.sdk.codegen;

public interface IGeneratorProvider<ContextType, ParameterType> {

	public IGenerator<ContextType, ParameterType> newInstance(ICodeGenerationComponent parent, ContextType context, ParameterType parameters);
}
