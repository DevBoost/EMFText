package org.emftext.sdk.codegen;

public interface ICodeGenOptions {
	
	public static final String GENERATE_TEST_ACTION = "generateTestAction";
	public static final String  GENERATE_CODE_FROM_GENERATOR_MODEL = "generateCodeFromGeneratorModel";
	public static final String  GENERATE_PRINTER_STUB_ONLY = "generatePrinterStubOnly";

	public static final String  OVERRIDE_PLUGIN_XML = "overridePluginXML";
	public static final String  OVERRIDE_MANIFEST = "overrideManifest";
	public static final String  OVERRIDE_ANTLR_SPEC = "overrideAntlrSpecification";
	public static final String  OVERRIDE_TOKEN_RESOLVERS = "overrideTokenResolvers";
	public static final String  OVERRIDE_REFERENCE_RESOLVERS = "overrideReferenceResolvers";
	public static final String  OVERRIDE_TREE_ANALYSER = "overrideTreeAnalyser";
	public static final String  OVERRIDE_TOKEN_RESOLVER_FACTORY = "overrideTokenResolverFactory";
	public static final String  OVERRIDE_PRINTER = "overridePrinter";

	public static final String CS_OPTION_AUTOFIX_SIMPLE_LEFTRECURSION = "autofixSimpleLeftrecursion";
	public static final String CS_OPTION_FORCE_EOF = "forceEOF";
	public static final String CS_OPTION_STD_TOKEN_NAME = "standardTextTokenName";
	public static final String CS_OPTION_USE_DEFAULT_TOKENS = "useDefaultTokens";
	
	public static String CS_OPTION_TOKENSPACE = "tokenspace";
	
}
