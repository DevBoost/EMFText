package org.emftext.sdk.codegen;

import org.emftext.sdk.PluginDescriptor;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ArtifactDescriptor {

	private PluginDescriptor plugin;
	private String packageName;
	private String classNamePrefix;
	private String classNameSuffix;
	private IGenerator<GenerationContext> generator;
	private OptionTypes overrideOption;

	public ArtifactDescriptor(PluginDescriptor plugin, String packageName, String classNamePrefix, String classNameSuffix, IGenerator<GenerationContext> generator, OptionTypes overrideOption) {
		this.plugin = plugin;
		this.packageName = packageName;
		this.classNamePrefix = classNamePrefix;
		this.classNameSuffix = classNameSuffix;
		this.generator = generator;
		this.overrideOption = overrideOption;
	}

	public PluginDescriptor getPlugin() {
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

	public IGenerator<GenerationContext> createGenerator(GenerationContext context) {
		return generator.newInstance(context);
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
