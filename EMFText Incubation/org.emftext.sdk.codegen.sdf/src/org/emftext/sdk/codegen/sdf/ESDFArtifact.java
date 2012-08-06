package org.emftext.sdk.codegen.sdf;

import static org.emftext.sdk.Constants.MOPP_PACKAGE;
import static org.emftext.sdk.EPlugins.RESOURCE_PLUGIN;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

// TODO this should extend EArtifact instead of copying
// all members and the constructor here
public enum ESDFArtifact {

	SGLR_PARSER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "SGLRParser", null, OptionTypes.OVERRIDE_PARSER),
	SGLR_GRAMMAR(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", null, OptionTypes.OVERRIDE_PARSER);

	private EPlugins plugin;
	private String packageName;
	private String classNamePrefix;
	private String classNameSuffix;
	private IGenerator generator;
	private OptionTypes overrideOption;

	private ESDFArtifact(EPlugins plugin, String packageName, String classNamePrefix, String classNameSuffix, IGenerator generator, OptionTypes overrideOption) {
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
