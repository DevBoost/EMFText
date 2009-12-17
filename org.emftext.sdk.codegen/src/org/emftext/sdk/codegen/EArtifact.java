/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen;

import static org.emftext.sdk.Constants.ANALYSIS_PACKAGE;
import static org.emftext.sdk.Constants.ANTLR_RUNTIME_DEBUG_PACKAGE;
import static org.emftext.sdk.Constants.ANTLR_RUNTIME_MISC_PACKAGE;
import static org.emftext.sdk.Constants.ANTLR_RUNTIME_PACKAGE;
import static org.emftext.sdk.Constants.ANTLR_RUNTIME_TREE_PACKAGE;
import static org.emftext.sdk.Constants.CC_PACKAGE;
import static org.emftext.sdk.Constants.MOPP_PACKAGE;
import static org.emftext.sdk.Constants.ROOT_PACKAGE;
import static org.emftext.sdk.Constants.UI_PACKAGE;
import static org.emftext.sdk.Constants.UTIL_PACKAGE;
import static org.emftext.sdk.EPlugins.ANTLR_PLUGIN;
import static org.emftext.sdk.EPlugins.RESOURCE_PLUGIN;

import org.emftext.sdk.Constants;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.generators.ANTLRGrammarGenerator;
import org.emftext.sdk.codegen.generators.ANTLRParserBaseGenerator;
import org.emftext.sdk.codegen.generators.ANTLRScannerGenerator;
import org.emftext.sdk.codegen.generators.BabylonSpecificationGenerator;
import org.emftext.sdk.codegen.generators.BracketInformationProviderGenerator;
import org.emftext.sdk.codegen.generators.BuilderAdapterGenerator;
import org.emftext.sdk.codegen.generators.BuilderGenerator;
import org.emftext.sdk.codegen.generators.ContextDependentURIFragmentFactoryGenerator;
import org.emftext.sdk.codegen.generators.ContextDependentURIFragmentGenerator;
import org.emftext.sdk.codegen.generators.DefaultResolverDelegateGenerator;
import org.emftext.sdk.codegen.generators.DefaultTokenResolverGenerator;
import org.emftext.sdk.codegen.generators.DelegatingResolveResultGenerator;
import org.emftext.sdk.codegen.generators.DummyEObjectGenerator;
import org.emftext.sdk.codegen.generators.EProblemTypeGenerator;
import org.emftext.sdk.codegen.generators.ElementMappingGenerator;
import org.emftext.sdk.codegen.generators.FoldingInformationProviderGenerator;
import org.emftext.sdk.codegen.generators.FuzzyResolveResultGenerator;
import org.emftext.sdk.codegen.generators.HoverTextProviderGenerator;
import org.emftext.sdk.codegen.generators.LocationMapGenerator;
import org.emftext.sdk.codegen.generators.MetaInformationGenerator;
import org.emftext.sdk.codegen.generators.NatureGenerator;
import org.emftext.sdk.codegen.generators.NewFileContentProviderGenerator;
import org.emftext.sdk.codegen.generators.NewFileWizardGenerator;
import org.emftext.sdk.codegen.generators.ParseResultGenerator;
import org.emftext.sdk.codegen.generators.PluginActivatorGenerator;
import org.emftext.sdk.codegen.generators.ProblemClassGenerator;
import org.emftext.sdk.codegen.generators.ReferenceResolveResultGenerator;
import org.emftext.sdk.codegen.generators.ReferenceResolverSwitchGenerator;
import org.emftext.sdk.codegen.generators.ResourceFactoryDelegatorGenerator;
import org.emftext.sdk.codegen.generators.ResourceFactoryGenerator;
import org.emftext.sdk.codegen.generators.ScannerlessParserGenerator;
import org.emftext.sdk.codegen.generators.ScannerlessScannerGenerator;
import org.emftext.sdk.codegen.generators.SyntaxCoverageInformationProviderGenerator;
import org.emftext.sdk.codegen.generators.TerminateParsingExceptionGenerator;
import org.emftext.sdk.codegen.generators.TextPrinterGenerator;
import org.emftext.sdk.codegen.generators.TextResourceGenerator;
import org.emftext.sdk.codegen.generators.TextTokenGenerator;
import org.emftext.sdk.codegen.generators.TokenResolveResultGenerator;
import org.emftext.sdk.codegen.generators.TokenResolverFactoryGenerator;
import org.emftext.sdk.codegen.generators.TokenStyleInformationProviderGenerator;
import org.emftext.sdk.codegen.generators.URIMappingGenerator;
import org.emftext.sdk.codegen.generators.UnexpectedContentTypeExceptionGenerator;
import org.emftext.sdk.codegen.generators.code_completion.AbstractExpectedElementGenerator;
import org.emftext.sdk.codegen.generators.code_completion.CodeCompletionHelperGenerator;
import org.emftext.sdk.codegen.generators.code_completion.CompletionProposalGenerator;
import org.emftext.sdk.codegen.generators.code_completion.ExpectedCsStringGenerator;
import org.emftext.sdk.codegen.generators.code_completion.ExpectedStructuralFeatureGenerator;
import org.emftext.sdk.codegen.generators.code_completion.ExpectedTerminalGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IBackgroundParsingListenerGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IBracketPairGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IBuilderGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ICommandGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IConfigurableGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IContextDependentURIFragmentFactoryGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IContextDependentURIFragmentGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IElementMappingGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IExpectedElementGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IHoverTextProviderGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IInputStreamProcessorProviderGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ILocationMapGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IMetaInformationGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IOptionProviderGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IOptionsGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IParseResultGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IProblemGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IReferenceMappingGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IReferenceResolveResultGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IReferenceResolverGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IReferenceResolverSwitchGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IResourcePostProcessorGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IResourcePostProcessorProviderGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITextDiagnosticGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITextParserGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITextPrinterGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITextResourceGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITextResourcePluginPartGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITextScannerGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITextTokenGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITokenResolveResultGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITokenResolverFactoryGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITokenResolverGenerator;
import org.emftext.sdk.codegen.generators.interfaces.ITokenStyleGenerator;
import org.emftext.sdk.codegen.generators.interfaces.IURIMappingGenerator;
import org.emftext.sdk.codegen.generators.interfaces.InputStreamProcessorGenerator;
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
import org.emftext.sdk.codegen.generators.ui.NewFileWizardPageGenerator;
import org.emftext.sdk.codegen.generators.ui.OccurrenceGenerator;
import org.emftext.sdk.codegen.generators.ui.OccurrencePreferencePageGenerator;
import org.emftext.sdk.codegen.generators.ui.OutlinePageGenerator;
import org.emftext.sdk.codegen.generators.ui.OutlinePageTreeViewerGenerator;
import org.emftext.sdk.codegen.generators.ui.PixelConverterGenerator;
import org.emftext.sdk.codegen.generators.ui.PositionCategoryGenerator;
import org.emftext.sdk.codegen.generators.ui.PositionHelperGenerator;
import org.emftext.sdk.codegen.generators.ui.PreferenceConstantsGenerator;
import org.emftext.sdk.codegen.generators.ui.PreferenceInitializerGenerator;
import org.emftext.sdk.codegen.generators.ui.PreferencePageGenerator;
import org.emftext.sdk.codegen.generators.ui.PropertySheetPageGenerator;
import org.emftext.sdk.codegen.generators.ui.SyntaxColoringHelperGenerator;
import org.emftext.sdk.codegen.generators.ui.SyntaxColoringPreferencePageGenerator;
import org.emftext.sdk.codegen.generators.ui.TextHoverGenerator;
import org.emftext.sdk.codegen.generators.ui.TokenScannerGenerator;
import org.emftext.sdk.codegen.generators.util.CastUtilGenerator;
import org.emftext.sdk.codegen.generators.util.CopiedEListGenerator;
import org.emftext.sdk.codegen.generators.util.CopiedEObjectInternalEListGenerator;
import org.emftext.sdk.codegen.generators.util.EClassUtilGenerator;
import org.emftext.sdk.codegen.generators.util.EObjectUtilGenerator;
import org.emftext.sdk.codegen.generators.util.ListUtilGenerator;
import org.emftext.sdk.codegen.generators.util.MapUtilGenerator;
import org.emftext.sdk.codegen.generators.util.MinimalModelHelperGenerator;
import org.emftext.sdk.codegen.generators.util.ResourceUtilGenerator;
import org.emftext.sdk.codegen.generators.util.StreamUtilGenerator;
import org.emftext.sdk.codegen.generators.util.StringUtilGenerator;
import org.emftext.sdk.codegen.generators.util.TextResourceUtilGenerator;
import org.emftext.sdk.codegen.generators.util.UnicodeConverterGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public enum EArtifact {
	
	BUILD_PROPERTIES(null, null, "", "", null, OptionTypes.OVERRIDE_BUILD_PROPERTIES), 
	DOT_CLASSPATH(null, null, "", "", null, OptionTypes.OVERRIDE_DOT_CLASSPATH), 
	DOT_PROJECT(null, null, "", "", null, OptionTypes.OVERRIDE_DOT_PROJECT), 

	// the classes
	ANTLR_LEXER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Lexer", null, OptionTypes.OVERRIDE_PARSER),
	ANTLR_SCANNER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "AntlrScanner", new ANTLRScannerGenerator(), OptionTypes.OVERRIDE_SCANNER),
	ANTLR_PARSER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Parser", null, OptionTypes.OVERRIDE_PARSER),
	ANTLR_PARSER_BASE(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ANTLRParserBase", new ANTLRParserBaseGenerator(), OptionTypes.OVERRIDE_PARSER),
	CONTEXT_DEPENDENT_URI_FRAGMENT(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ContextDependentURIFragment", new ContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT),
	CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ContextDependentURIFragmentFactory", new ContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY),
	DELEGATING_RESOLVE_RESULT(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "DelegatingResolveResult", new DelegatingResolveResultGenerator(), OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT),
	DUMMY_E_OBJECT(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "DummyEObject", new DummyEObjectGenerator(), OptionTypes.OVERRIDE_DUMMY_EOBJECT),
	ELEMENT_MAPPING(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ElementMapping", new ElementMappingGenerator(), OptionTypes.OVERRIDE_ELEMENT_MAPPING),
	FUZZY_RESOLVE_RESULT(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "FuzzyResolveResult", new FuzzyResolveResultGenerator(), OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT),
	LOCATION_MAP(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "LocationMap", new LocationMapGenerator(), OptionTypes.OVERRIDE_LOCATION_MAP),
	REFERENCE_RESOLVE_RESULT(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ReferenceResolveResult", new ReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT),
	TOKEN_RESOLVE_RESULT(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenResolveResult", new TokenResolveResultGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVE_RESULT),
	URI_MAPPING(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "URIMapping", new URIMappingGenerator(), OptionTypes.OVERRIDE_URI_MAPPING),
	SCANNERLESS_SCANNER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ScannerlessScanner", new ScannerlessScannerGenerator(), OptionTypes.OVERRIDE_PARSER),
	SCANNERLESS_PARSER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ScannerlessParser", new ScannerlessParserGenerator(), OptionTypes.OVERRIDE_PARSER),
	PROBLEM(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Problem", new ProblemClassGenerator(), OptionTypes.OVERRIDE_PROBLEM_CLASS),
	PRINTER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Printer", new TextPrinterGenerator(), OptionTypes.OVERRIDE_PRINTER),
	RESOURCE(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Resource", new TextResourceGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE),
	RESOURCE_FACTORY(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ResourceFactory", new ResourceFactoryGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY),
	RESOURCE_FACTORY_DELEGATOR(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ResourceFactoryDelegator", new ResourceFactoryDelegatorGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY_DELEGATOR),
	TOKEN_RESOLVER_FACTORY(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenResolverFactory", new TokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY),
	REFERENCE_RESOLVER_SWITCH(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ReferenceResolverSwitch", new ReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH),
	META_INFORMATION(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "MetaInformation", new MetaInformationGenerator(), OptionTypes.OVERRIDE_META_INFORMATION), 
	HOVER_TEXT_PROVIDER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "HoverTextProvider", new HoverTextProviderGenerator(), OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER),
	NEW_FILE_CONTENT_PROVIDER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "NewFileContentProvider", new NewFileContentProviderGenerator(), OptionTypes.OVERRIDE_NEW_FILE_CONTENT_PROVIDER),
	PARSE_RESULT(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ParseResult", new ParseResultGenerator(), OptionTypes.OVERRIDE_PARSE_RESULT),
	PLUGIN_ACTIVATOR(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Plugin", new PluginActivatorGenerator(), OptionTypes.OVERRIDE_PLUGIN_ACTIVATOR),
	TEXT_TOKEN(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TextToken", new TextTokenGenerator(), OptionTypes.OVERRIDE_TEXT_TOKEN),
	TERMINATE_PARSING_EXCEPTION(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TerminateParsingException", new TerminateParsingExceptionGenerator(), OptionTypes.OVERRIDE_TERMINATE_PARSING_EXCEPTION),
	UNEXPECTED_CONTENT_TYPE_EXCEPTION(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "UnexpectedContentTypeException", new UnexpectedContentTypeExceptionGenerator(), OptionTypes.OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION),

	TOKEN_STYLE_INFORMATION_PROVIDER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenStyleInformationProvider", new TokenStyleInformationProviderGenerator(), OptionTypes.OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER),
	FOLDING_INFORMATION_PROVIDER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "FoldingInformationProvider", new FoldingInformationProviderGenerator(), OptionTypes.OVERRIDE_FOLDING_INFORMATION_PROVIDER),
	BRACKET_INFORMATION_PROVIDER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "BracketInformationProvider", new BracketInformationProviderGenerator(), OptionTypes.OVERRIDE_BRACKET_INFORMATION_PROVIDER),
	SYNTAX_COVERAGE_INFORMATION_PROVIDER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "SyntaxCoverageInformationProvider", new SyntaxCoverageInformationProviderGenerator(), OptionTypes.OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER),

	NATURE(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Nature", new NatureGenerator(), OptionTypes.OVERRIDE_NATURE),
	BUILDER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Builder", new BuilderGenerator(), OptionTypes.OVERRIDE_BUILDER),
	BUILDER_ADAPTER(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "BuilderAdapter", new BuilderAdapterGenerator(), OptionTypes.OVERRIDE_BUILDER_ADAPTER),
	I_BUILDER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Builder", new IBuilderGenerator(), OptionTypes.OVERRIDE_IBUILDER),
	
	DEFAULT_TOKEN_RESOLVER(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "DefaultTokenResolver", new DefaultTokenResolverGenerator(), OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER),
	DEFAULT_RESOLVER_DELEGATE(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "DefaultResolverDelegate", new DefaultResolverDelegateGenerator(), OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE), 
	TOKEN_RESOLVER(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "", null, OptionTypes.OVERRIDE_TOKEN_RESOLVERS), 

	ANTLR_TOKEN_HELPER(RESOURCE_PLUGIN, UI_PACKAGE, "", "AntlrTokenHelper", new AntlrTokenHelperGenerator(), OptionTypes.OVERRIDE_ANTLR_TOKEN_HELPER), 
	BRACKET_SET(RESOURCE_PLUGIN, UI_PACKAGE, "", "BracketSet", new BracketSetGenerator(), OptionTypes.OVERRIDE_BRACKET_SET),
	POSITION_HELPER(RESOURCE_PLUGIN, UI_PACKAGE, "", "PositionHelper", new PositionHelperGenerator(), OptionTypes.OVERRIDE_POSITION_HELPER),
	CODE_FOLDING_MANAGER(RESOURCE_PLUGIN, UI_PACKAGE, "", "CodeFoldingManager", new CodeFoldingManagerGenerator(), OptionTypes.OVERRIDE_CODE_FOLDING_MANAGER),
	EDITOR(RESOURCE_PLUGIN, UI_PACKAGE, "", "Editor", new EditorGenerator(), OptionTypes.OVERRIDE_EDITOR),
	COLOR_MANAGER(RESOURCE_PLUGIN, UI_PACKAGE, "", "ColorManager", new ColorManagerGenerator(), OptionTypes.OVERRIDE_COLOR_MANAGER),
	BACKGROUND_PARSING_STRATEGY(RESOURCE_PLUGIN, UI_PACKAGE, "", "BackgroundParsingStrategy", new BackgroundParsingStrategyGenerator(), OptionTypes.OVERRIDE_PARSING_STRATEGY),
	TEXT_HOVER(RESOURCE_PLUGIN, UI_PACKAGE, "", "TextHover", new TextHoverGenerator(), OptionTypes.OVERRIDE_TEXT_HOVER),
	HTML_PRINTER(RESOURCE_PLUGIN, UI_PACKAGE, "", "HTMLPrinter", new HTMLPrinterGenerator(), OptionTypes.OVERRIDE_HTML_PRINTER),
	POSITION_CATEGORY(RESOURCE_PLUGIN, UI_PACKAGE, "", "PositionCategory", new PositionCategoryGenerator(), OptionTypes.OVERRIDE_POSITION_CATEGORY),
	OCCURENCE(RESOURCE_PLUGIN, UI_PACKAGE, "", "Occurrence", new OccurrenceGenerator(), OptionTypes.OVERRIDE_OCCURENCE),
	TOKEN_SCANNER(RESOURCE_PLUGIN, UI_PACKAGE, "", "TokenScanner", new TokenScannerGenerator(), OptionTypes.OVERRIDE_TOKEN_SCANNER),
	MARKER_HELPER(RESOURCE_PLUGIN, UI_PACKAGE, "", "MarkerHelper", new MarkerHelperGenerator(), OptionTypes.OVERRIDE_MARKER_HELPER),
	HYPERLINK(RESOURCE_PLUGIN, UI_PACKAGE, "", "Hyperlink", new HyperlinkGenerator(), OptionTypes.OVERRIDE_HYPERLINK),
	HYPERLINK_DETECTOR(RESOURCE_PLUGIN, UI_PACKAGE, "", "HyperlinkDetector", new HyperlinkDetectorGenerator(), OptionTypes.OVERRIDE_HYPERLINK_DETECTOR), 
	E_OBJECT_SELECTION(RESOURCE_PLUGIN, UI_PACKAGE, "", "EObjectSelection", new EObjectSelectionGenerator(), OptionTypes.OVERRIDE_EOBJECT_SELECTION),
	HIGHLIGHTING(RESOURCE_PLUGIN, UI_PACKAGE, "", "Highlighting", new HighlightingGenerator(), OptionTypes.OVERRIDE_HIGHLIGHTING),
	PROPERTY_SHEET_PAGE(RESOURCE_PLUGIN, UI_PACKAGE, "", "PropertySheetPage", new PropertySheetPageGenerator(), OptionTypes.OVERRIDE_PROPERTY_SHEET_PAGE),
	OUTLINE_PAGE_TREE_VIEWER(RESOURCE_PLUGIN, UI_PACKAGE, "", "OutlinePageTreeViewer", new OutlinePageTreeViewerGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE_TREE_VIEWER), 
	OUTLINE_PAGE(RESOURCE_PLUGIN, UI_PACKAGE, "", "OutlinePage", new OutlinePageGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE),
	EDITOR_CONFIGURATION(RESOURCE_PLUGIN, UI_PACKAGE, "", "EditorConfiguration", new EditorConfigurationGenerator(), OptionTypes.OVERRIDE_EDITOR_CONFIGURATION),
	DOC_BROWSER_INFORMATION_CONTROL_INPUT(RESOURCE_PLUGIN, UI_PACKAGE, "", "DocBrowserInformationControlInput", new DocBrowserInformationControlInputGenerator(), OptionTypes.OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT),
	COMPLETION_PROCESSOR(RESOURCE_PLUGIN, UI_PACKAGE, "", "CompletionProcessor", new CompletionProcessorGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROCESSOR),
	BROWER_INFORMATION_CONTROL(RESOURCE_PLUGIN, UI_PACKAGE, "", "BrowserInformationControl", new BrowserInformationControlGenerator(), OptionTypes.OVERRIDE_BROWSER_INFORMATION_CONTROL),
	// preference pages
	PREFERENCE_PAGE(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferencePage", new PreferencePageGenerator(), OptionTypes.OVERRIDE_PREFERENCE_PAGE),
	BRACKET_PREFERENCE_PAGE(RESOURCE_PLUGIN, UI_PACKAGE, "", "BracketPreferencePage", new BracketPreferencePageGenerator(), OptionTypes.OVERRIDE_BRACKET_PREFERENCE_PAGE),
	PREFERENCE_CONSTANTS(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferenceConstants", new PreferenceConstantsGenerator(), OptionTypes.OVERRIDE_PREFERENCE_CONSTANTS),
	OCCURRENCE_PREFERENCE_PAGE(RESOURCE_PLUGIN, UI_PACKAGE, "", "OccurrencePreferencePage", new OccurrencePreferencePageGenerator(), OptionTypes.OVERRIDE_OCCURENCE_PREFERENCE_PAGE),
	PIXEL_CONVERTER(RESOURCE_PLUGIN, UI_PACKAGE, "", "PixelConverter", new PixelConverterGenerator(), OptionTypes.OVERRIDE_PIXEL_CONVERTER),
	PREFERENCE_INITIALIZER(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferenceInitializer", new PreferenceInitializerGenerator(), OptionTypes.OVERRIDE_PREFERENCE_INITIALIZER),
	SYNTAX_COLORING_HELPER(RESOURCE_PLUGIN, UI_PACKAGE, "", "SyntaxColoringHelper", new SyntaxColoringHelperGenerator(), OptionTypes.OVERRIDE_SYNTAX_COLORING_HELPER),
	SYNTAX_COLORING_PREFERENCE_PAGE(RESOURCE_PLUGIN, UI_PACKAGE, "", "SyntaxColoringPreferencePage", new SyntaxColoringPreferencePageGenerator(), OptionTypes.OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE),
	NEW_FILE_WIZARD(RESOURCE_PLUGIN, UI_PACKAGE, "", "NewFileWizard", new NewFileWizardGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD),
	NEW_FILE_WIZARD_PAGE(RESOURCE_PLUGIN, UI_PACKAGE, "", "NewFileWizardPage", new NewFileWizardPageGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD_PAGE),
	
	I_INPUT_STREAM_PROCESSOR_PROVIDER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "InputStreamProcessorProvider", new IInputStreamProcessorProviderGenerator(), OptionTypes.OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER),
	INPUT_STREAM_PROCESSOR(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "InputStreamProcessor", new InputStreamProcessorGenerator(), OptionTypes.OVERRIDE_INPUT_STREAM_PROCESSOR),
	I_OPTION_PROVIDER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "OptionProvider", new IOptionProviderGenerator(), OptionTypes.OVERRIDE_IOPTION_PROVIDER),
	I_OPTIONS(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Options", new IOptionsGenerator(), OptionTypes.OVERRIDE_IOPTIONS),
	I_RESOURCE_POST_PROCESSOR(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ResourcePostProcessor", new IResourcePostProcessorGenerator(), OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR),
	I_RESOURCE_POST_PROCESSOR_PROVIDER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ResourcePostProcessorProvider", new IResourcePostProcessorProviderGenerator(), OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER),
	I_BACKGROUND_PARSING_LISTENER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "BackgroundParsingListener", new IBackgroundParsingListenerGenerator(), OptionTypes.OVERRIDE_IBACKGROUND_PARSING_LISTENER),
	I_BRACKET_PAIR(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "BracketPair", new IBracketPairGenerator(), OptionTypes.OVERRIDE_IBRACKET_PAIR),
	I_COMMAND(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Command", new ICommandGenerator(), OptionTypes.OVERRIDE_ICOMMAND),
	I_CONFIGURABLE(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Configurable", new IConfigurableGenerator(), OptionTypes.OVERRIDE_ICONFIGURABLE),
	I_CONTEXT_DEPENDENT_URI_FRAGMENT(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ContextDependentURIFragment", new IContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT),
	I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ContextDependentURIFragmentFactory", new IContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY),
	I_ELEMENT_MAPPING(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ElementMapping", new IElementMappingGenerator(), OptionTypes.OVERRIDE_IELEMENT_MAPPING),
	I_EXPECTED_ELEMENT(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ExpectedElement", new IExpectedElementGenerator(), OptionTypes.OVERRIDE_IEXPECTED_ELEMENT),
	I_HOVER_TEXT_PROVIDER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "HoverTextProvider", new IHoverTextProviderGenerator(), OptionTypes.OVERRIDE_IHOVER_TEXT_PROVIDER),
	I_LOCATION_MAP(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "LocationMap", new ILocationMapGenerator(), OptionTypes.OVERRIDE_ILOCATION_MAP),
	I_PARSE_RESULT(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ParseResult", new IParseResultGenerator(), OptionTypes.OVERRIDE_IPARSE_RESULT),
	I_PROBLEM(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Problem", new IProblemGenerator(), OptionTypes.OVERRIDE_IPROBLEM),
	I_REFERENCE_MAPPING(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceMapping", new IReferenceMappingGenerator(), OptionTypes.OVERRIDE_IREFERENCE_MAPPING),
	I_REFERENCE_RESOLVER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolver", new IReferenceResolverGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVER),
	I_REFERENCE_RESOLVE_RESULT(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolveResult", new IReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVE_RESULT),
	I_REFERENCE_RESOLVER_SWITCH(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolverSwitch", new IReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVER_SWITCH),
	I_TEXT_DIAGNOSTIC(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextDiagnostic", new ITextDiagnosticGenerator(), OptionTypes.OVERRIDE_ITEXT_DIAGNOSTIC),
	I_TEXT_PARSER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextParser", new ITextParserGenerator(), OptionTypes.OVERRIDE_ITEXT_PARSER),
	I_TEXT_PRINTER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextPrinter", new ITextPrinterGenerator(), OptionTypes.OVERRIDE_ITEXT_PRINTER),
	I_TEXT_RESOURCE(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextResource", new ITextResourceGenerator(), OptionTypes.OVERRIDE_ITEXT_RESOURCE),
	I_META_INFORMATION(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "MetaInformation", new IMetaInformationGenerator(), OptionTypes.OVERRIDE_IMETA_INFORMATION),
	I_TEXT_RESOURCE_PLUGIN_PART(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextResourcePluginPart", new ITextResourcePluginPartGenerator(), OptionTypes.OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART),
	I_TEXT_SCANNER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextScanner", new ITextScannerGenerator(), OptionTypes.OVERRIDE_ITEXT_SCANNER),
	I_TEXT_TOKEN(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextToken", new ITextTokenGenerator(), OptionTypes.OVERRIDE_ITEXT_TOKEN),
	I_TOKEN_RESOLVER(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolver", new ITokenResolverGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVER),
	I_TOKEN_RESOLVE_RESULT(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolveResult", new ITokenResolveResultGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVE_RESULT),
	I_TOKEN_RESOLVER_FACTORY(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolverFactory", new ITokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVER_FACTORY),
	I_TOKEN_STYLE(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenStyle", new ITokenStyleGenerator(), OptionTypes.OVERRIDE_ITOKEN_STYLE),
	IURI_MAPPING(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "URIMapping", new IURIMappingGenerator(), OptionTypes.OVERRIDE_IURI_MAPPING),
	E_PROBLEM_TYPE(RESOURCE_PLUGIN, ROOT_PACKAGE, "", "EProblemType", new EProblemTypeGenerator(), OptionTypes.OVERRIDE_EPROBLEM_TYPE),
	
	CODE_COMPLETION_HELPER(RESOURCE_PLUGIN, CC_PACKAGE, "", "CodeCompletionHelper", new CodeCompletionHelperGenerator(), OptionTypes.OVERRIDE_CODE_COMPLETION_HELPER),
	EXPECTED_CS_STRING(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedCsString", new ExpectedCsStringGenerator(), OptionTypes.OVERRIDE_EXPECTED_CS_STRING),
	EXPECTED_STRUCTURAL_FEATURE(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedStructuralFeature", new ExpectedStructuralFeatureGenerator(), OptionTypes.OVERRIDE_EXPECTED_STRUCTURAL_FEATURE),
	ABSTRACT_EXPECTED_ELEMENT(RESOURCE_PLUGIN, CC_PACKAGE, "", "AbstractExpectedElement", new AbstractExpectedElementGenerator(), OptionTypes.OVERRIDE_ABSTRACT_EXPECTED_ELEMENT),
	EXPECTED_TERMINAL(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedTerminal", new ExpectedTerminalGenerator(), OptionTypes.OVERRIDE_EXPECTED_TERMINAL),
	COMPLETION_PROPOSAL(RESOURCE_PLUGIN, CC_PACKAGE, "", "CompletionProposal", new CompletionProposalGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROPOSAL), 
	
	CAST_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CastUtil", new CastUtilGenerator(), OptionTypes.OVERRIDE_CAST_UTIL),
	COPIED_E_LIST(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CopiedEList", new CopiedEListGenerator(), OptionTypes.OVERRIDE_COPIED_ELIST),
	COPIED_E_OBJECT_INTERNAL_E_LIST(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CopiedEObjectInternalEList", new CopiedEObjectInternalEListGenerator(), OptionTypes.OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST),
	E_CLASS_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "EClassUtil", new EClassUtilGenerator(), OptionTypes.OVERRIDE_ECLASS_UTIL),
	E_OBJECT_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "EObjectUtil", new EObjectUtilGenerator(), OptionTypes.OVERRIDE_EOBJECT_UTIL),
	LIST_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "ListUtil", new ListUtilGenerator(), OptionTypes.OVERRIDE_LIST_UTIL),
	MAP_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "MapUtil", new MapUtilGenerator(), OptionTypes.OVERRIDE_MAP_UTIL),
	MINIMAL_MODEL_HELPER(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "MinimalModelHelper", new MinimalModelHelperGenerator(), OptionTypes.OVERRIDE_MINIMAL_MODEL_HELPER),
	RESOURCE_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "ResourceUtil", new ResourceUtilGenerator(), OptionTypes.OVERRIDE_RESOURCE_UTIL),
	STREAM_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "StreamUtil", new StreamUtilGenerator(), OptionTypes.OVERRIDE_STREAM_UTIL),
	STRING_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "StringUtil", new StringUtilGenerator(), OptionTypes.OVERRIDE_STRING_UTIL),
	TEXT_RESOURCE_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "TextResourceUtil", new TextResourceUtilGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE_UTIL),
	UNICODE_CONVERTER(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "UnicodeConverter", new UnicodeConverterGenerator(), OptionTypes.OVERRIDE_UNICODE_CONVERTER),

	ANTLR_GRAMMAR(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", new ANTLRGrammarGenerator(), OptionTypes.OVERRIDE_PARSER), 
	BABYLON_SPECIFICATION(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Babylon", new BabylonSpecificationGenerator(), OptionTypes.OVERRIDE_PARSER),
	
	PACKAGE_ROOT(RESOURCE_PLUGIN, ROOT_PACKAGE, "", "", null, null),
	PACKAGE_MOPP(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", null, null),
	PACKAGE_ANALYSIS(RESOURCE_PLUGIN, ANALYSIS_PACKAGE, "analysis", "analysis", null, null),      
	PACKAGE_CC(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", null, null),
	PACKAGE_UI(RESOURCE_PLUGIN, UI_PACKAGE, "", "", null, null),
	PACKAGE_UTIL(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "", null, null),
	
	PACKAGE_ANTLR_RUNTIME(ANTLR_PLUGIN, ANTLR_RUNTIME_PACKAGE, "", "", null, null),
	PACKAGE_ANTLR_RUNTIME_DEBUG(ANTLR_PLUGIN, ANTLR_RUNTIME_DEBUG_PACKAGE, "", "", null, null),
	PACKAGE_ANTLR_RUNTIME_MISC(ANTLR_PLUGIN, ANTLR_RUNTIME_MISC_PACKAGE, "", "", null, null),
	PACKAGE_ANTLR_RUNTIME_TREE(ANTLR_PLUGIN, ANTLR_RUNTIME_TREE_PACKAGE, "", "", null, null), 
	;
	
	private EPlugins plugin;
	private String packageName;
	private String classNamePrefix;
	private String classNameSuffix;
	private IGenerator generator;
	private OptionTypes overrideOption;

	private EArtifact(EPlugins plugin, String packageName, String classNamePrefix, String classNameSuffix, IGenerator generator, OptionTypes overrideOption) {
		this.plugin = plugin;
		this.packageName = packageName;
		this.classNamePrefix = classNamePrefix;
		this.classNameSuffix = classNameSuffix;
		this.generator = generator;
		this.overrideOption = overrideOption;
	}

	public EPlugins getPlugin() {
		return plugin;
	}

	public String getPackage() {
		return packageName;
	}

	public String getClassNamePrefix() {
		return classNamePrefix;
	}

	public String getClassNameSuffix() {
		return classNameSuffix;
	}

	public IGenerator createGenerator(GenerationContext context) {
		return generator.newInstance(context);
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
