package org.emftext.sdk.codegen;

/**
 * A collection of all options that are available to parameterize
 * the code generation process.
 */
public interface ICodeGenOptions {
	
	/**
	 * If this option is set to true, EMFText generate a UI action that 
	 * can be used to test parsing and printing of files containing 
	 * textual syntax. The default value of this option is <code>false</code>.
	 */
	public static final String GENERATE_TEST_ACTION = "generateTestAction";
	
	/**
	 * If this option is set to true, EMFText automatically generates the
	 * model code using the generator model referenced in the CS specification.
	 * The default value of this option is <code>false</code>. 
	 */
	public static final String GENERATE_CODE_FROM_GENERATOR_MODEL = "generateCodeFromGeneratorModel";
	
	/**
	 * If this option is set to true, an empty printer class is generated. This class can be
	 * subject to manual implementation. Otherwise, a printer and
	 * a base class containing a default printer implementation are generated.
	 * The default value for this option is <code>false</code>. 
	 */
	public static final String  GENERATE_PRINTER_STUB_ONLY = "generatePrinterStubOnly";

	/**
	 * If this option is set to true, the plugin.xml file will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 */
	public static final String  OVERRIDE_PLUGIN_XML = "overridePluginXML";

	/**
	 * If this option is set to true, the manifest of the generated plug-in will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 */
	public static final String  OVERRIDE_MANIFEST = "overrideManifest";

	/**
	 * If this option is set to true, the ANTLR grammar will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 */
	public static final String  OVERRIDE_ANTLR_SPEC = "overrideAntlrSpecification";

	/**
	 * If this option is set to true, the token resolver classes will be overridden during code
	 * generation. The default value for this option is <code>false</code>. 
	 */
	public static final String  OVERRIDE_TOKEN_RESOLVERS = "overrideTokenResolvers";

	/**
	 * If this option is set to true, the reference resolver classes will be overridden during code
	 * generation. The default value for this option is <code>false</code>. 
	 */
	public static final String  OVERRIDE_REFERENCE_RESOLVERS = "overrideReferenceResolvers";

	/**
	 * If this option is set to true, the composite reference resolver will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 */
	public static final String  OVERRIDE_REFERENCE_RESOLVER_SWITCH = "overrideReferenceResolverSwitch";

	/**
	 * If this option is set to true, the token resolver factory class will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 */
	public static final String  OVERRIDE_TOKEN_RESOLVER_FACTORY = "overrideTokenResolverFactory";

	/**
	 * If this option is set to true, the printer will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 */
	public static final String  OVERRIDE_PRINTER = "overridePrinter";
	
	/**
	 * If this option is set to true, the printer base class will be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 */
	public static final String  OVERRIDE_PRINTER_BASE = "overridePrinterBase";

	/**
	 * If this option is set to true, the Antlr-backtracking is activated for
	 * parser generation. The default value for this option is <code>true</code>. 
	 */
	public static final String ANTLR_BACKTRACKING ="backtracking";

	/**
	 * If this option is set to true, the Antlr-memoize is activated for
	 * parser generation. The default value for this option is <code>true</code>. 
	 */
	public static final String ANTLR_MEMOIZE = "memoize";
	
	/**
	 * If this option is set to true, EMFText will try to resolve rules that
	 * contain simple left recursion. The default value for this option
	 * is <code>false</code>. 
	 */
	public static final String CS_OPTION_AUTOFIX_SIMPLE_LEFTRECURSION = "autofixSimpleLeftrecursion";
	
	/**
	 * If this option is set to true, EMFText will generate a parser that expects
	 * an EOF signal at the end of the input stream. The default value for this option
	 * is <code>true</code>. 
	 */
	public static final String CS_OPTION_FORCE_EOF = "forceEOF";
	
	/**
	 * This option can be used to specify the name of the token that is used for
	 * non-containment references. A declaration like <code>featureX[]</code> in
	 * a CS rule with be replaced by <code>featureX[TOKEN_Y]</code> if the
	 * value of this option is <code>TOKEN_Y</code>.
	 */
	public static final String CS_OPTION_STD_TOKEN_NAME = "defaultTokenName";
	
	/**
	 * If this option is set to false, EMFText does not automatically provide 
	 * predefined tokens (TEXT, WS, ...). The default value of this option is
	 * <code>true</code>. 
	 */
	public static final String CS_OPTION_USE_PREDEFINED_TOKENS = "usePredefinedTokens";
	
	/**
	 * The (numerical) value of this option defined how many whitespace should 
	 * be printed between tokens if no whitespace information is given in CS
	 * rules. The default value for this option is 0.
	 */
	public static final String CS_OPTION_TOKENSPACE = "tokenspace";
}
