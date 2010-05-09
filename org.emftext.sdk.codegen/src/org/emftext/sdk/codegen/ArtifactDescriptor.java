package org.emftext.sdk.codegen;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ArtifactDescriptor<ContextType, ParameterType> {

	private IPluginDescriptor<ContextType> plugin;
	private String packageName;
	private String classNamePrefix;
	private String classNameSuffix;
	private IGenerator<ContextType, ParameterType> generator;
	private OptionTypes overrideOption;

	public ArtifactDescriptor(IPluginDescriptor<ContextType> plugin, String packageName, String classNamePrefix, String classNameSuffix, IGenerator<ContextType, ParameterType> generator, OptionTypes overrideOption) {
		this.plugin = plugin;
		this.packageName = packageName;
		this.classNamePrefix = classNamePrefix;
		this.classNameSuffix = classNameSuffix;
		this.generator = generator;
		this.overrideOption = overrideOption;
	}

	public IPluginDescriptor<ContextType> getPlugin() {
		return plugin;
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
