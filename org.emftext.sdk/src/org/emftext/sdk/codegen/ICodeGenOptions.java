package org.emftext.sdk.codegen;

public interface ICodeGenOptions {
	
	public String GENERATE_TEST_ACTION = "generateTestAction";
	public String GENERATE_CODE_FROM_GENERATOR_MODEL = "generateCodeFromGeneratorModel";
	public String GENERATE_PRINTER_STUB_ONLY = "generatePrinterStubOnly";

	public String OVERRIDE_PLUGIN_XML = "overridePluginXML";
	public String OVERRIDE_MANIFEST = "overrideManifest";
	public String OVERRIDE_ANTLR_SPEC = "overrideAntlrSpecification";
	public String OVERRIDE_TOKEN_RESOLVERS = "overrideTokenResolvers";
	public String OVERRIDE_REFERENCE_RESOLVERS = "overrideReferenceResolvers";
	public String OVERRIDE_TREE_ANALYSER = "overrideTreeAnalyser";
	public String OVERRIDE_TOKEN_RESOLVER_FACTORY = "overrideTokenResolverFactory";
	public String OVERRIDE_PRINTER = "overridePrinter";
}
