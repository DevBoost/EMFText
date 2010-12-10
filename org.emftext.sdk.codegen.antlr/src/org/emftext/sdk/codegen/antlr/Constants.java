package org.emftext.sdk.codegen.antlr;

import org.emftext.sdk.codegen.BasicPackage;
import org.emftext.sdk.codegen.IPackage;
import org.emftext.sdk.codegen.ISyntaxContext;

public interface Constants {

	public String ANTLR_VERSION = "3_3_0";
	public String DEFAULT_ANTLR_PLUGIN_NAME = "org.emftext.commons.antlr" + ANTLR_VERSION;
	
	public IPackage<ISyntaxContext> ANTLR_RUNTIME_PACKAGE = new BasicPackage<ISyntaxContext>("org.antlr.runtime" + ANTLR_VERSION);
	
	public IPackage<ISyntaxContext> ANTLR_RUNTIME_DEBUG_PACKAGE = new BasicPackage<ISyntaxContext>(ANTLR_RUNTIME_PACKAGE.getName(null) + ".debug");
	public IPackage<ISyntaxContext> ANTLR_RUNTIME_MISC_PACKAGE = new BasicPackage<ISyntaxContext>(ANTLR_RUNTIME_PACKAGE.getName(null) + ".misc");
	public IPackage<ISyntaxContext> ANTLR_RUNTIME_TREE_PACKAGE = new BasicPackage<ISyntaxContext>(ANTLR_RUNTIME_PACKAGE.getName(null) + ".tree");
}
