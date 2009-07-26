package org.emftext.sdk.codegen;

import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.ITokenResolverFactory;

public enum EArtifact {

	ANTLR_LEXER("Lexer"),
	ANTLR_SCANNER("AntlrScanner"),
	ANTLR_PARSER("Parser"),
	CONTEXT_DEPENDENT_URI_FRAGMENT("ContextDependentURIFragment"),
	CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY("ContextDependentURIFragmentFactory"),
	DELEGATING_RESOLVE_RESULT("DelegatingResolveResult"),
	DUMMY_E_OBJECT("DummyEObject"),
	ELEMENT_MAPPING("ElementMapping"),
	FUZZY_RESOLVE_RESULT("FuzzyResolveResult"),
	DEFAULT_TOKEN_RESOLVER("DefaultTokenResolver"),
	LOCATION_MAP("LocationMap"),
	REFERENCE_RESOLVE_RESULT("ReferenceResolveResult"),
	TOKEN_RESOLVE_RESULT("TokenResolveResult"),
	URI_MAPPING("URIMapping"),
	SCANNERLESS_SCANNER("ScannerlessScanner"),
	SCANNERLESS_PARSER("ScannerlessParser"),
	PROBLEM("Problem"),
	PRINTER("Printer"),
	PRINTER_BASE("PrinterBase"),
	RESOURCE("Resource"),
	RESOURCE_FACTORY("ResourceFactory"),
	NEW_FILE_WIZARD("NewFileWizard"),
	TOKEN_RESOLVER_FACTORY(ITokenResolverFactory.class.getSimpleName().substring(1)),
	REFERENCE_RESOLVER_SWITCH("ReferenceResolverSwitch"),
	META_INFORMATION(ITextResourcePluginMetaInformation.class.getSimpleName().substring("ITextResourcePlugin".length())),
	;
	
	private String classNameSuffix;

	private EArtifact(String classNameSuffix) {
		this.classNameSuffix = classNameSuffix;
	}

	public String getClassNameSuffix() {
		return classNameSuffix;
	}
}
