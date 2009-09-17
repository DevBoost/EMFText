package org.emftext.sdk.codegen;

import org.emftext.runtime.resource.IHoverTextProvider;
import org.emftext.runtime.resource.IParseResult;
import org.emftext.runtime.resource.ITextResourcePluginMetaInformation;
import org.emftext.runtime.resource.ITokenResolverFactory;
import org.emftext.sdk.codegen.generators.ANTLRGrammarGenerator;
import org.emftext.sdk.codegen.generators.ANTLRScannerGenerator;
import org.emftext.sdk.codegen.generators.BabylonSpecificationGenerator;
import org.emftext.sdk.codegen.generators.ContextDependentURIFragmentFactoryGenerator;
import org.emftext.sdk.codegen.generators.ContextDependentURIFragmentGenerator;
import org.emftext.sdk.codegen.generators.DefaultResolverDelegateGenerator;
import org.emftext.sdk.codegen.generators.DefaultTokenResolverGenerator;
import org.emftext.sdk.codegen.generators.DelegatingResolveResultGenerator;
import org.emftext.sdk.codegen.generators.DummyEObjectGenerator;
import org.emftext.sdk.codegen.generators.ElementMappingGenerator;
import org.emftext.sdk.codegen.generators.FuzzyResolveResultGenerator;
import org.emftext.sdk.codegen.generators.HoverTextProviderGenerator;
import org.emftext.sdk.codegen.generators.LocationMapGenerator;
import org.emftext.sdk.codegen.generators.NewFileWizardGenerator;
import org.emftext.sdk.codegen.generators.ParseResultGenerator;
import org.emftext.sdk.codegen.generators.PluginActivatorGenerator;
import org.emftext.sdk.codegen.generators.PluginMetaInformationGenerator;
import org.emftext.sdk.codegen.generators.ProblemClassGenerator;
import org.emftext.sdk.codegen.generators.ReferenceResolveResultGenerator;
import org.emftext.sdk.codegen.generators.ReferenceResolverSwitchGenerator;
import org.emftext.sdk.codegen.generators.ResourceFactoryGenerator;
import org.emftext.sdk.codegen.generators.ScannerlessParserGenerator;
import org.emftext.sdk.codegen.generators.ScannerlessScannerGenerator;
import org.emftext.sdk.codegen.generators.TextResourceGenerator;
import org.emftext.sdk.codegen.generators.TokenResolveResultGenerator;
import org.emftext.sdk.codegen.generators.TokenResolverFactoryGenerator;
import org.emftext.sdk.codegen.generators.URIMappingGenerator;
import org.emftext.sdk.codegen.generators.ui.AntlrTokenHelperGenerator;
import org.emftext.sdk.codegen.generators.ui.BackgroundParsingStrategyGenerator;
import org.emftext.sdk.codegen.generators.ui.BracketPreferencePageGenerator;
import org.emftext.sdk.codegen.generators.ui.BracketSetGenerator;
import org.emftext.sdk.codegen.generators.ui.BrowserInformationControlGenerator;
import org.emftext.sdk.codegen.generators.ui.CodeFoldingManagerGenerator;
import org.emftext.sdk.codegen.generators.ui.ColorManagerGenerator;
import org.emftext.sdk.codegen.generators.ui.CompletionProcessorGenerator;
import org.emftext.sdk.codegen.generators.ui.DocBrowserInformationControlInputGenerator;
import org.emftext.sdk.codegen.generators.ui.EObjectSelectionGenerator;
import org.emftext.sdk.codegen.generators.ui.EditorConfigurationGenerator;
import org.emftext.sdk.codegen.generators.ui.EditorGenerator;
import org.emftext.sdk.codegen.generators.ui.HTMLPrinterGenerator;
import org.emftext.sdk.codegen.generators.ui.HighlightingGenerator;
import org.emftext.sdk.codegen.generators.ui.HyperlinkDetectorGenerator;
import org.emftext.sdk.codegen.generators.ui.HyperlinkGenerator;
import org.emftext.sdk.codegen.generators.ui.MarkerHelperGenerator;
import org.emftext.sdk.codegen.generators.ui.OccurrenceGenerator;
import org.emftext.sdk.codegen.generators.ui.OutlinePageGenerator;
import org.emftext.sdk.codegen.generators.ui.OutlinePageTreeViewerGenerator;
import org.emftext.sdk.codegen.generators.ui.PositionCategoryGenerator;
import org.emftext.sdk.codegen.generators.ui.PositionHelperGenerator;
import org.emftext.sdk.codegen.generators.ui.PreferenceConstantsGenerator;
import org.emftext.sdk.codegen.generators.ui.PropertySheetPageGenerator;
import org.emftext.sdk.codegen.generators.ui.TextHoverGenerator;
import org.emftext.sdk.codegen.generators.ui.TokenScannerGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public enum EArtifact {

	ANTLR_LEXER("Lexer", null, OptionTypes.OVERRIDE_PARSER),
	ANTLR_SCANNER("AntlrScanner", new ANTLRScannerGenerator(), OptionTypes.OVERRIDE_SCANNER),
	ANTLR_PARSER("Parser", null, OptionTypes.OVERRIDE_PARSER),
	CONTEXT_DEPENDENT_URI_FRAGMENT("ContextDependentURIFragment", new ContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT),
	CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY("ContextDependentURIFragmentFactory", new ContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY),
	DELEGATING_RESOLVE_RESULT("DelegatingResolveResult", new DelegatingResolveResultGenerator(), OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT),
	DUMMY_E_OBJECT("DummyEObject", new DummyEObjectGenerator(), OptionTypes.OVERRIDE_DUMMY_EOBJECT),
	ELEMENT_MAPPING("ElementMapping", new ElementMappingGenerator(), OptionTypes.OVERRIDE_ELEMENT_MAPPING),
	FUZZY_RESOLVE_RESULT("FuzzyResolveResult", new FuzzyResolveResultGenerator(), OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT),
	DEFAULT_TOKEN_RESOLVER("DefaultTokenResolver", new DefaultTokenResolverGenerator(), OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER),
	LOCATION_MAP("LocationMap", new LocationMapGenerator(), OptionTypes.OVERRIDE_LOCATION_MAP),
	REFERENCE_RESOLVE_RESULT("ReferenceResolveResult", new ReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT),
	TOKEN_RESOLVE_RESULT("TokenResolveResult", new TokenResolveResultGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVE_RESULT),
	URI_MAPPING("URIMapping", new URIMappingGenerator(), OptionTypes.OVERRIDE_URI_MAPPING),
	SCANNERLESS_SCANNER("ScannerlessScanner", new ScannerlessScannerGenerator(), OptionTypes.OVERRIDE_PARSER),
	SCANNERLESS_PARSER("ScannerlessParser", new ScannerlessParserGenerator(), OptionTypes.OVERRIDE_PARSER),
	PROBLEM("Problem", new ProblemClassGenerator(), OptionTypes.OVERRIDE_PROBLEM_CLASS),
	PRINTER("Printer", null, OptionTypes.OVERRIDE_PRINTER),
	PRINTER_BASE("PrinterBase", null, OptionTypes.OVERRIDE_PRINTER_BASE),
	RESOURCE("Resource", new TextResourceGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE),
	RESOURCE_FACTORY("ResourceFactory", new ResourceFactoryGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY),
	NEW_FILE_WIZARD("NewFileWizard", new NewFileWizardGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD),
	TOKEN_RESOLVER_FACTORY(ITokenResolverFactory.class.getSimpleName().substring(1), new TokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY),
	REFERENCE_RESOLVER_SWITCH("ReferenceResolverSwitch", new ReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH),
	META_INFORMATION(ITextResourcePluginMetaInformation.class.getSimpleName().substring("ITextResourcePlugin".length()), new PluginMetaInformationGenerator(), OptionTypes.OVERRIDE_PLUGIN_META_INFORMATION_CLASS), 
	HOVER_TEXT_PROVIDER(IHoverTextProvider.class.getSimpleName().substring(1), new HoverTextProviderGenerator(), OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER),
	PARSE_RESULT(IParseResult.class.getSimpleName().substring(1), new ParseResultGenerator(), OptionTypes.OVERRIDE_PARSE_RESULT),
	PLUGIN_ACTIVATOR("Plugin", new PluginActivatorGenerator(), OptionTypes.OVERRIDE_PLUGIN_ACTIVATOR), 

	DEFAULT_RESOLVER_DELEGATE("analysis", "DefaultResolverDelegate", new DefaultResolverDelegateGenerator(), OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE), 

	ANTLR_TOKEN_HELPER("ui", "AntlrTokenHelper", new AntlrTokenHelperGenerator(), OptionTypes.OVERRIDE_ANTLR_TOKEN_HELPER), 
	BRACKET_SET("ui", "BracketSet", new BracketSetGenerator(), OptionTypes.OVERRIDE_BRACKET_SET),
	POSITION_HELPER("ui", "PositionHelper", new PositionHelperGenerator(), OptionTypes.OVERRIDE_POSITION_HELPER),
	CODE_FOLDING_MANAGER("ui", "CodeFoldingManager", new CodeFoldingManagerGenerator(), OptionTypes.OVERRIDE_CODE_FOLDING_MANAGER),
	EDITOR("ui", "Editor", new EditorGenerator(), OptionTypes.OVERRIDE_EDITOR),
	COLOR_MANAGER("ui", "ColorManager", new ColorManagerGenerator(), OptionTypes.OVERRIDE_COLOR_MANAGER),
	BACKGROUND_PARSING_STRATEGY("ui", "BackgroundParsingStrategy", new BackgroundParsingStrategyGenerator(), OptionTypes.OVERRIDE_PARSING_STRATEGY),
	TEXT_HOVER("ui", "TextHover", new TextHoverGenerator(), OptionTypes.OVERRIDE_TEXT_HOVER),
	HTML_PRINTER("ui", "HTMLPrinter", new HTMLPrinterGenerator(), OptionTypes.OVERRIDE_HTML_PRINTER),
	POSITION_CATEGORY("ui", "PositionCategory", new PositionCategoryGenerator(), OptionTypes.OVERRIDE_POSITION_CATEGORY),
	OCCURENCE("ui", "Occurrence", new OccurrenceGenerator(), OptionTypes.OVERRIDE_OCCURENCE),
	TOKEN_SCANNER("ui", "TokenScanner", new TokenScannerGenerator(), OptionTypes.OVERRIDE_TOKEN_SCANNER),
	MARKER_HELPER("ui", "MarkerHelper", new MarkerHelperGenerator(), OptionTypes.OVERRIDE_MARKER_HELPER),
	HYPERLINK("ui", "Hyperlink", new HyperlinkGenerator(), OptionTypes.OVERRIDE_HYPERLINK),
	HYPERLINK_DETECTOR("ui", "HyperlinkDetector", new HyperlinkDetectorGenerator(), OptionTypes.OVERRIDE_HYPERLINK_DETECTOR), 
	E_OBJECT_SELECTION("ui", "EObjectSelection", new EObjectSelectionGenerator(), OptionTypes.OVERRIDE_EOBJECT_SELECTION),
	HIGHLIGHTING("ui", "Highlighting", new HighlightingGenerator(), OptionTypes.OVERRIDE_HIGHLIGHTING),
	PROPERTY_SHEET_PAGE("ui", "PropertySheetPage", new PropertySheetPageGenerator(), OptionTypes.OVERRIDE_PROPERTY_SHEET_PAGE),
	OUTLINE_PAGE_TREE_VIEWER("ui", "OutlinePageTreeViewer", new OutlinePageTreeViewerGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE_TREE_VIEWER), 
	OUTLINE_PAGE("ui", "OutlinePage", new OutlinePageGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE),
	EDITOR_CONFIGURATION("ui", "EditorConfiguration", new EditorConfigurationGenerator(), OptionTypes.OVERRIDE_EDITOR_CONFIGURATION),
	DOC_BROWSER_INFORMATION_CONTROL_INPUT("ui", "DocBrowserInformationControlInput", new DocBrowserInformationControlInputGenerator(), OptionTypes.OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT),
	COMPLETION_PROCESSOR("ui", "CompletionProcessor", new CompletionProcessorGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROCESSOR),
	BROWER_INFORMATION_CONTROL("ui", "BrowserInformationControl", new BrowserInformationControlGenerator(), OptionTypes.OVERRIDE_BROWSER_INFORMATION_CONTROL),
	
	BRACKET_PREFERENCE_PAGE("ui", "BracketPreferencePage", new BracketPreferencePageGenerator(), OptionTypes.OVERRIDE_BRACKET_PREFERENCE_PAGE),
	PREFERENCE_CONSTANTS("ui", "PreferenceConstants", new PreferenceConstantsGenerator(), OptionTypes.OVERRIDE_PREFERENCE_CONSTANTS),
	
	ANTLR_GRAMMAR("", "", new ANTLRGrammarGenerator(), OptionTypes.OVERRIDE_PARSER), 
	BABYLON_SPECIFICATION("", "Babylon", new BabylonSpecificationGenerator(), OptionTypes.OVERRIDE_PARSER),
	
	MAIN_PACKAGE("", "", null, null),
	ANALYSIS_PACKAGE("analysis", "analysis", null, null),   
	;
	
	private String classNameSuffix;
	private String packageName;
	private IGenerator generator;
	private OptionTypes overrideOption;

	private EArtifact(String classNameSuffix, IGenerator generator, OptionTypes overrideOption) {
		this("", classNameSuffix, generator, overrideOption);
	}

	private EArtifact(String packageName, String classNameSuffix, IGenerator generator, OptionTypes overrideOption) {
		this.packageName = packageName;
		this.classNameSuffix = classNameSuffix;
		this.generator = generator;
		this.overrideOption = overrideOption;
	}

	public String getClassNameSuffix() {
		return classNameSuffix;
	}

	public String getPackage() {
		return packageName;
	}

	public IGenerator createGenerator(GenerationContext context) {
		return generator.newInstance(context);
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
