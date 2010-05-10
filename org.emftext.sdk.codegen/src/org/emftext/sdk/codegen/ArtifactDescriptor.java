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
