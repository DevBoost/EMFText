package org.emftext.sdk.codegen;

import org.emftext.sdk.concretesyntax.OptionTypes;

public class ArtifactDescriptor<ContextType, ParameterType> {

	private String packageName;
	private String classNamePrefix;
	private String classNameSuffix;
	private IGenerator<ContextType, ParameterType> generator;
	private OptionTypes overrideOption;

	public ArtifactDescriptor(String packageName, String classNamePrefix, String classNameSuffix, IGenerator<ContextType, ParameterType> generator, OptionTypes overrideOption) {
		this.packageName = packageName;
		this.classNamePrefix = classNamePrefix;
		this.classNameSuffix = classNameSuffix;
		this.generator = generator;
		this.overrideOption = overrideOption;
	}

	public String getPackage() {
		return packageName;
	}

	public String getClassNamePrefix() {
		return classNamePrefix;
	}

	public String getClassNameSuffix() {
		return classNameSuffix;
	}

	public IGenerator<ContextType, ParameterType> createGenerator(ContextType context, ParameterType parameter) {
		return generator.newInstance(context, parameter);
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
