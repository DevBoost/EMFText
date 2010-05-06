package org.emftext.sdk.codegen;

import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ArtifactDescriptor<ContextType> {

	private IPluginDescriptor plugin;
	private String packageName;
	private String classNamePrefix;
	private String classNameSuffix;
	private IGenerator<ContextType> generator;
	private OptionTypes overrideOption;

	public ArtifactDescriptor(IPluginDescriptor plugin, String packageName, String classNamePrefix, String classNameSuffix, IGenerator<ContextType> generator, OptionTypes overrideOption) {
		this.plugin = plugin;
		this.packageName = packageName;
		this.classNamePrefix = classNamePrefix;
		this.classNameSuffix = classNameSuffix;
		this.generator = generator;
		this.overrideOption = overrideOption;
	}

	public IPluginDescriptor getPlugin() {
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

	public IGenerator<ContextType> createGenerator(ContextType context) {
		return generator.newInstance(context);
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
