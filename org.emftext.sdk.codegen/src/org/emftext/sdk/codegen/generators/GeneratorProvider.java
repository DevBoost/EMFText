package org.emftext.sdk.codegen.generators;

import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IGeneratorProvider;

public class GeneratorProvider<ContextType, ParameterType> implements IGeneratorProvider<ContextType, ParameterType> {

	private AbstractGenerator<ContextType, ParameterType> generator;

	public GeneratorProvider(AbstractGenerator<ContextType, ParameterType> generator) {
		this.generator = generator;
	}

	public IGenerator<ContextType, ParameterType> newInstance(
			ICodeGenerationComponent parent, ContextType context,
			ParameterType parameters) {
		return generator.newInstance(parent, context, parameters);
	}
}
