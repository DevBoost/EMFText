package org.emftext.sdk.codegen;

import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * An ArtifactDescriptor bundles information about an artifact that
 * is created during code generation. This includes data about the
 * name of the artifact (classNamePrefix and classNameSuffix), the
 * target package of the artifact (packageName) and the generator
 * that can be used to produce the artifact.
 *
 * @param <ContextType> the type of the context class that is required
 *                      by the code generator for this artifact
 * @param <ParameterType> the type of the parameter class that can be
 *                        used to configure the code generator
 */
public class ArtifactDescriptor<ContextType, ParameterType> {

	private String packageName;
	private String classNamePrefix;
	private String classNameSuffix;
	private IGeneratorProvider<ContextType, ParameterType> provider;
	private OptionTypes overrideOption;

	public ArtifactDescriptor(String packageName, String classNamePrefix, String classNameSuffix, IGeneratorProvider<ContextType, ParameterType> provider, OptionTypes overrideOption) {
		this.packageName = packageName;
		this.classNamePrefix = classNamePrefix;
		this.classNameSuffix = classNameSuffix;
		this.provider = provider;
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

	public IGenerator<ContextType, ParameterType> createGenerator(ICodeGenerationComponent parent, ContextType context, ParameterType parameter) {
		return provider.newInstance(parent, context, parameter);
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
