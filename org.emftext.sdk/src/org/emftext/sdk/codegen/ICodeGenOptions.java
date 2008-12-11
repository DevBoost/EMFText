package org.emftext.sdk.codegen;

public interface ICodeGenOptions {
	
	public String GENERATE_TEST_ACTION_NAME = "generateTestAction";
	public String GENERATE_GEN_MODEL = "generateGenModel";
	public String GENERATE_PRINTER_STUB_ONLY_NAME = "generatePrinterStubOnly";

	public String OVERRIDE_PLUGIN_XML_NAME = "overridePluginXML";
	public String OVERRIDE_MANIFEST_NAME = "overrideManifest";
	public String OVERRIDE_ANTLR_SPEC_NAME = "overrideAntlrSpecification";
	public String OVERRIDE_TOKEN_RESOLVERS_NAME = "overrideTokenResolvers";
	public String OVERRIDE_PROXY_RESOLVERS_NAME = "overrideReferenceResolvers";
	public String OVERRIDE_TREE_ANALYSER_NAME = "overrideTreeAnalyser";
	public String OVERRIDE_TOKEN_RESOLVER_FACTORY_NAME = "overrideTokenResolverFactory";
	public String OVERRIDE_PRINTER_NAME = "overridePrinter";
}
