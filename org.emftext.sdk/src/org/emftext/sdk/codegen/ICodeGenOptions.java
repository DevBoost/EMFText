package org.emftext.sdk.codegen;

public interface ICodeGenOptions {
	
	public static final String GENERATE_TEST_ACTION = "generateTestAction";
	public static final String GENERATE_CODE_FROM_GENERATOR_MODEL = "generateCodeFromGeneratorModel";
	
	/**
	 * If this option is set to true, an empty printer class is generated. This class can be
	 * subject to manual implementation. Otherwise, which is the default case, a printer and
	 * a base class containing a default printer implementation are generated.
	 */
	public static final String  GENERATE_PRINTER_STUB_ONLY = "generatePrinterStubOnly";

	/**
	 * If this options is set to true, the plugin.xml file will be overridden during code
	 * generation. The default value for this option is true.
	 */
	public static final String  OVERRIDE_PLUGIN_XML = "overridePluginXML";

	/**
	 * If this options is set to true, the manifest of the generated plug-in will be overridden during code
	 * generation. The default value for this option is true.
	 */
	public static final String  OVERRIDE_MANIFEST = "overrideManifest";

	/**
	 * If this options is set to true, the ANTLR grammar will be overridden during code
	 * generation. The default value for this option is true.
	 */
	public static final String  OVERRIDE_ANTLR_SPEC = "overrideAntlrSpecification";

	/**
	 * If this options is set to true, the token resolver classes will be overridden during code
	 * generation. The default value for this option is false.
	 */
	public static final String  OVERRIDE_TOKEN_RESOLVERS = "overrideTokenResolvers";

	/**
	 * If this options is set to true, the reference resolver classes will be overridden during code
	 * generation. The default value for this option is false.
	 */
	public static final String  OVERRIDE_REFERENCE_RESOLVERS = "overrideReferenceResolvers";

	/**
	 * If this options is set to true, the composite reference resolver will be overridden during code
	 * generation. The default value for this option is true.
	 */
	public static final String  OVERRIDE_TREE_ANALYSER = "overrideTreeAnalyser";

	/**
	 * If this options is set to true, the token resolver factory class will be overridden during code
	 * generation. The default value for this option is true.
	 */
	public static final String  OVERRIDE_TOKEN_RESOLVER_FACTORY = "overrideTokenResolverFactory";

	/**
	 * If this options is set to true, the printer will be overridden during code
	 * generation. The default value for this option is true.
	 */
	public static final String  OVERRIDE_PRINTER = "overridePrinter";

	/**
	 * If this options is set to true, the Antlr-backtracking is activated for
	 * parser generation. The default value for this option is true.
	 */
	public static final String ANTLR_BACKTRACKING ="backtracking";
	
	public static final String CS_OPTION_AUTOFIX_SIMPLE_LEFTRECURSION = "autofixSimpleLeftrecursion";
	public static final String CS_OPTION_FORCE_EOF = "forceEOF";
	public static final String CS_OPTION_STD_TOKEN_NAME = "standardTextTokenName";
	public static final String CS_OPTION_USE_DEFAULT_TOKENS = "useDefaultTokens";
	
	public static final String CS_OPTION_TOKENSPACE = "tokenspace";
	
}
