package org.emftext.sdk.codegen;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ArtifactDescriptor {

	private EPlugins plugin;
	private String packageName;
	private String classNamePrefix;
	private String classNameSuffix;
	private IGenerator generator;
	private OptionTypes overrideOption;

	public ArtifactDescriptor(EPlugins plugin, String packageName, String classNamePrefix, String classNameSuffix, IGenerator generator, OptionTypes overrideOption) {
		this.plugin = plugin;
		this.packageName = packageName;
		this.classNamePrefix = classNamePrefix;
		this.classNameSuffix = classNameSuffix;
		this.generator = generator;
		this.overrideOption = overrideOption;
	}

	public EPlugins getPlugin() {
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

	public IGenerator createGenerator(GenerationContext context) {
		return generator.newInstance(context);
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
