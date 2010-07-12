package org.emftext.sdk.codegen;

import org.emftext.sdk.concretesyntax.OptionTypes;

public interface Constants {

	public IPackage<ISyntaxContext> ROOT_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "");
	public IPackage<ISyntaxContext> CC_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "mopp");
	public IPackage<ISyntaxContext> GRAMMAR_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "grammar");
	public IPackage<ISyntaxContext> UTIL_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "util");
	public IPackage<ISyntaxContext> MOPP_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "mopp");
	public IPackage<ISyntaxContext> ANALYSIS_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "analysis");

	public String UI_SUFFIX = "ui";
	public String RESOURCE_UI_PLUGIN_SUFFIX = "." + UI_SUFFIX;
	public IPackage<ISyntaxContext> UI_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.UI_BASE_PACKAGE, RESOURCE_UI_PLUGIN_SUFFIX, "");
}
