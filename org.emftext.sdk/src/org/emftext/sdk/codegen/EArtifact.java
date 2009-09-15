package org.emftext.sdk.codegen;

import org.emftext.runtime.resource.IHoverTextProvider;
import org.emftext.runtime.resource.IParseResult;
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
	HOVER_TEXT_PROVIDER(IHoverTextProvider.class.getSimpleName().substring(1)), 
	PARSE_RESULT(IParseResult.class.getSimpleName().substring(1)),
	PLUGIN_ACTIVATOR("Plugin"), 

	ANTLR_TOKEN_HELPER("ui", "AntlrTokenHelper"), 
	BRACKET_SET("ui", "BracketSet"), 
	POSITION_HELPER("ui", "PositionHelper"), 
	CODE_FOLDING_MANAGER("ui", "CodeFoldingManager"), 
	EDITOR("ui", "Editor"), 
	COLOR_MANAGER("ui", "ColorManager"), 
	BACKGROUND_PARSING_STRATEGY("ui", "BackgroundParsingStrategy"), 
	TEXT_HOVER("ui", "TextHover"), 
	HTML_PRINTER("ui", "HTMLPrinter"), 
	POSITION_CATEGORY("ui", "PositionCategory"), 
	OCCURENCE("ui", "Occurrence"), 
	TEXT_TOKEN_SCANNER("ui", "TextTokenScanner"), 
	MARKER_HELPER("ui", "MarkerHelper"),
	HYPERLINK("ui", "Hyperlink"), 
	HYPERLINK_DETECTOR("ui", "HyperlinkDetector"), 
	E_OBJECT_SELECTION("ui", "EObjectSelection"), 
	HIGHLIGHTING("ui", "Highlighting"), 
	PROPERTY_SHEET_PAGE("ui", "PropertySheetPage"), 
	OUTLINE_PAGE_TREE_VIEWER("ui", "OutlinePageTreeViewer"), 
	OUTLINE_PAGE("ui", "OutlinePage"), 
	EDITOR_CONFIGURATION("ui", "EditorConfiguration"), 
	DOC_BROWSER_INFORMATION_CONTROL_INPUT("ui", "DocBrowserInformationControlInput"), 
	COMPLETION_PROCESSOR("ui", "CompletionProcessor"), 
	BROWER_INFORMATION_CONTROL("ui", "BrowserInformationControl"),
	
	ANTLR_GRAMMAR(""), 
	BABYLON_SPECIFICATION("Babylon"), 
	
	MAIN_PACKAGE("", ""),
	ANALYSIS_PACKAGE("analysis", "analysis"), 
	DEFAULT_RESOLVER_DELEGATE("analysis", "DefaultResolverDelegate"), 
	;
	
	private String classNameSuffix;
	private String packageName;

	private EArtifact(String classNameSuffix) {
		this("", classNameSuffix);
	}

	private EArtifact(String packageName, String classNameSuffix) {
		this.packageName = packageName;
		this.classNameSuffix = classNameSuffix;
	}

	public String getClassNameSuffix() {
		return classNameSuffix;
	}

	public String getPackage() {
		return packageName;
	}
}
