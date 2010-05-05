/*******************************************************************************
 * Copyright (c) 2006-2010 
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
import static org.emftext.sdk.Constants.GRAMMAR_PACKAGE;
import static org.emftext.sdk.Constants.MOPP_PACKAGE;
import static org.emftext.sdk.Constants.ROOT_PACKAGE;
import static org.emftext.sdk.Constants.UI_PACKAGE;
import static org.emftext.sdk.Constants.UTIL_PACKAGE;
import static org.emftext.sdk.EPlugins.ANTLR_PLUGIN;
import static org.emftext.sdk.EPlugins.RESOURCE_PLUGIN;

import org.emftext.sdk.Constants;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.generators.AbstractInterpreterGenerator;
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
import org.emftext.sdk.codegen.generators.SyntaxCoverageInformationProviderGenerator;
import org.emftext.sdk.codegen.generators.TerminateParsingExceptionGenerator;
import org.emftext.sdk.codegen.generators.TextResourceGenerator;
import org.emftext.sdk.codegen.generators.TextTokenGenerator;
import org.emftext.sdk.codegen.generators.TokenResolveResultGenerator;
import org.emftext.sdk.codegen.generators.TokenResolverFactoryGenerator;
import org.emftext.sdk.codegen.generators.TokenStyleInformationProviderGenerator;
import org.emftext.sdk.codegen.generators.URIMappingGenerator;
import org.emftext.sdk.codegen.generators.UnexpectedContentTypeExceptionGenerator;
import org.emftext.sdk.codegen.generators.code_completion.AbstractExpectedElementGenerator;
import org.emftext.sdk.codegen.generators.code_completion.AttributeValueProviderGenerator;
import org.emftext.sdk.codegen.generators.code_completion.CodeCompletionHelperGenerator;
import org.emftext.sdk.codegen.generators.code_completion.CompletionProposalGenerator;
import org.emftext.sdk.codegen.generators.code_completion.ExpectedCsStringGenerator;
import org.emftext.sdk.codegen.generators.code_completion.ExpectedStructuralFeatureGenerator;
import org.emftext.sdk.codegen.generators.code_completion.ExpectedTerminalGenerator;
import org.emftext.sdk.codegen.generators.grammar.CardinalityGenerator;
import org.emftext.sdk.codegen.generators.grammar.ChoiceGenerator;
import org.emftext.sdk.codegen.generators.grammar.CompoundGenerator;
import org.emftext.sdk.codegen.generators.grammar.ContainmentGenerator;
import org.emftext.sdk.codegen.generators.grammar.FollowSetProviderGenerator;
import org.emftext.sdk.codegen.generators.grammar.FormattingElementGenerator;
import org.emftext.sdk.codegen.generators.grammar.GrammarInformationProviderGenerator;
import org.emftext.sdk.codegen.generators.grammar.KeywordGenerator;
import org.emftext.sdk.codegen.generators.grammar.LineBreakGenerator;
import org.emftext.sdk.codegen.generators.grammar.PlaceholderGenerator;
import org.emftext.sdk.codegen.generators.grammar.SequenceGenerator;
import org.emftext.sdk.codegen.generators.grammar.SyntaxElementGenerator;
import org.emftext.sdk.codegen.generators.grammar.TerminalGenerator;
import org.emftext.sdk.codegen.generators.grammar.WhiteSpaceGenerator;
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
import org.emftext.sdk.codegen.generators.interfaces.IReferenceCacheGenerator;
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
import org.emftext.sdk.codegen.generators.mopp.ANTLRGrammarGenerator;
import org.emftext.sdk.codegen.generators.mopp.ANTLRParserBaseGenerator;
import org.emftext.sdk.codegen.generators.mopp.ANTLRScannerGenerator;
import org.emftext.sdk.codegen.generators.mopp.BabylonSpecificationGenerator;
import org.emftext.sdk.codegen.generators.mopp.LayoutInformationAdapterGenerator;
import org.emftext.sdk.codegen.generators.mopp.LayoutInformationGenerator;
import org.emftext.sdk.codegen.generators.mopp.Printer2Generator;
import org.emftext.sdk.codegen.generators.mopp.PrinterGenerator;
import org.emftext.sdk.codegen.generators.mopp.ScannerlessParserGenerator;
import org.emftext.sdk.codegen.generators.mopp.ScannerlessScannerGenerator;
import org.emftext.sdk.codegen.generators.mopp.SyntaxElementDecoratorGenerator;
import org.emftext.sdk.codegen.generators.ui.AntlrTokenHelperGenerator;
import org.emftext.sdk.codegen.generators.ui.BackgroundParsingStrategyGenerator;
import org.emftext.sdk.codegen.generators.ui.BracketPreferencePageGenerator;
import org.emftext.sdk.codegen.generators.ui.BracketSetGenerator;
import org.emftext.sdk.codegen.generators.ui.BrowserInformationControlGenerator;
import org.emftext.sdk.codegen.generators.ui.CodeFoldingManagerGenerator;
import org.emftext.sdk.codegen.generators.ui.ColorManagerGenerator;
import org.emftext.sdk.codegen.generators.ui.CompletionProcessorGenerator;
import org.emftext.sdk.codegen.generators.ui.DefaultHoverTextProviderGenerator;
import org.emftext.sdk.codegen.generators.ui.DocBrowserInformationControlInputGenerator;
import org.emftext.sdk.codegen.generators.ui.EObjectSelectionGenerator;
import org.emftext.sdk.codegen.generators.ui.EditorConfigurationGenerator;
import org.emftext.sdk.codegen.generators.ui.EditorGenerator;
import org.emftext.sdk.codegen.generators.ui.HTMLPrinterGenerator;
import org.emftext.sdk.codegen.generators.ui.HighlightingGenerator;
import org.emftext.sdk.codegen.generators.ui.HoverTextProviderGenerator;
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
import org.emftext.sdk.codegen.generators.util.PairGenerator;
import org.emftext.sdk.codegen.generators.util.ResourceUtilGenerator;
import org.emftext.sdk.codegen.generators.util.StreamUtilGenerator;
import org.emftext.sdk.codegen.generators.util.StringUtilGenerator;
import org.emftext.sdk.codegen.generators.util.TextResourceUtilGenerator;
import org.emftext.sdk.codegen.generators.util.UnicodeConverterGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class EArtifact {
	
	public final static EArtifact BUILD_PROPERTIES = new EArtifact(null, null, "", "", null, OptionTypes.OVERRIDE_BUILD_PROPERTIES); 
	public final static EArtifact DOT_CLASSPATH = new EArtifact(null, null, "", "", null, OptionTypes.OVERRIDE_DOT_CLASSPATH);
	public final static EArtifact DOT_PROJECT = new EArtifact(null, null, "", "", null, OptionTypes.OVERRIDE_DOT_PROJECT);

	// the classes
	public final static EArtifact ANTLR_LEXER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Lexer", null, OptionTypes.OVERRIDE_PARSER);
	public final static EArtifact ANTLR_SCANNER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "AntlrScanner", new ANTLRScannerGenerator(), OptionTypes.OVERRIDE_SCANNER);
	public final static EArtifact ANTLR_PARSER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Parser", null, OptionTypes.OVERRIDE_PARSER);
	public final static EArtifact ANTLR_PARSER_BASE = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ANTLRParserBase", new ANTLRParserBaseGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static EArtifact CONTEXT_DEPENDENT_URI_FRAGMENT = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ContextDependentURIFragment", new ContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static EArtifact CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ContextDependentURIFragmentFactory", new ContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static EArtifact DELEGATING_RESOLVE_RESULT = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "DelegatingResolveResult", new DelegatingResolveResultGenerator(), OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT);
	public final static EArtifact DUMMY_E_OBJECT = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "DummyEObject", new DummyEObjectGenerator(), OptionTypes.OVERRIDE_DUMMY_EOBJECT);
	public final static EArtifact ELEMENT_MAPPING = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ElementMapping", new ElementMappingGenerator(), OptionTypes.OVERRIDE_ELEMENT_MAPPING);
	public final static EArtifact FUZZY_RESOLVE_RESULT = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "FuzzyResolveResult", new FuzzyResolveResultGenerator(), OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT);
	public final static EArtifact LOCATION_MAP = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "LocationMap", new LocationMapGenerator(), OptionTypes.OVERRIDE_LOCATION_MAP);
	public final static EArtifact REFERENCE_RESOLVE_RESULT = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ReferenceResolveResult", new ReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT);
	public final static EArtifact TOKEN_RESOLVE_RESULT = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenResolveResult", new TokenResolveResultGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVE_RESULT);
	public final static EArtifact URI_MAPPING = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "URIMapping", new URIMappingGenerator(), OptionTypes.OVERRIDE_URI_MAPPING);
	public final static EArtifact SCANNERLESS_SCANNER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ScannerlessScanner", new ScannerlessScannerGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static EArtifact SCANNERLESS_PARSER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ScannerlessParser", new ScannerlessParserGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static EArtifact PROBLEM = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Problem", new ProblemClassGenerator(), OptionTypes.OVERRIDE_PROBLEM_CLASS);
	public final static EArtifact PRINTER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Printer", new PrinterGenerator(), OptionTypes.OVERRIDE_PRINTER);
	public final static EArtifact PRINTER2 = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Printer2", new Printer2Generator(), OptionTypes.OVERRIDE_PRINTER2);
	public final static EArtifact SYNTAX_ELEMENT_DECORATOR = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "SyntaxElementDecorator", new SyntaxElementDecoratorGenerator(), OptionTypes.OVERRIDE_SYNTAX_ELEMENT_DECORATOR);
	public final static EArtifact RESOURCE = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Resource", new TextResourceGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE);
	public final static EArtifact RESOURCE_FACTORY = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ResourceFactory", new ResourceFactoryGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY);
	public final static EArtifact RESOURCE_FACTORY_DELEGATOR = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ResourceFactoryDelegator", new ResourceFactoryDelegatorGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY_DELEGATOR);
	public final static EArtifact TOKEN_RESOLVER_FACTORY = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenResolverFactory", new TokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY);
	public final static EArtifact REFERENCE_RESOLVER_SWITCH = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ReferenceResolverSwitch", new ReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH);
	public final static EArtifact META_INFORMATION = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "MetaInformation", new MetaInformationGenerator(), OptionTypes.OVERRIDE_META_INFORMATION);
	
	// TODO the hover text provider should actually go to the UI package, but moving it requires
	// to remove the old generated class from existing DSL plug-ins. If bug #1296 is resolved 
	// this task is probably obsolete
	public final static EArtifact HOVER_TEXT_PROVIDER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "HoverTextProvider", new HoverTextProviderGenerator(), OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER);
	public final static EArtifact DEFAULT_HOVER_TEXT_PROVIDER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "DefaultHoverTextProvider", new DefaultHoverTextProviderGenerator(), OptionTypes.OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER);
	public final static EArtifact NEW_FILE_CONTENT_PROVIDER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "NewFileContentProvider", new NewFileContentProviderGenerator(), OptionTypes.OVERRIDE_NEW_FILE_CONTENT_PROVIDER);
	public final static EArtifact PARSE_RESULT = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ParseResult", new ParseResultGenerator(), OptionTypes.OVERRIDE_PARSE_RESULT);
	public final static EArtifact PLUGIN_ACTIVATOR = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Plugin", new PluginActivatorGenerator(), OptionTypes.OVERRIDE_PLUGIN_ACTIVATOR);
	public final static EArtifact TEXT_TOKEN = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TextToken", new TextTokenGenerator(), OptionTypes.OVERRIDE_TEXT_TOKEN);
	public final static EArtifact TERMINATE_PARSING_EXCEPTION = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TerminateParsingException", new TerminateParsingExceptionGenerator(), OptionTypes.OVERRIDE_TERMINATE_PARSING_EXCEPTION);
	public final static EArtifact UNEXPECTED_CONTENT_TYPE_EXCEPTION = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "UnexpectedContentTypeException", new UnexpectedContentTypeExceptionGenerator(), OptionTypes.OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	public final static EArtifact TOKEN_STYLE_INFORMATION_PROVIDER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenStyleInformationProvider", new TokenStyleInformationProviderGenerator(), OptionTypes.OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER);
	public final static EArtifact FOLDING_INFORMATION_PROVIDER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "FoldingInformationProvider", new FoldingInformationProviderGenerator(), OptionTypes.OVERRIDE_FOLDING_INFORMATION_PROVIDER);
	public final static EArtifact BRACKET_INFORMATION_PROVIDER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "BracketInformationProvider", new BracketInformationProviderGenerator(), OptionTypes.OVERRIDE_BRACKET_INFORMATION_PROVIDER);
	public final static EArtifact SYNTAX_COVERAGE_INFORMATION_PROVIDER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "SyntaxCoverageInformationProvider", new SyntaxCoverageInformationProviderGenerator(), OptionTypes.OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	public final static EArtifact LAYOUT_INFORMATION = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "LayoutInformation", new LayoutInformationGenerator(), OptionTypes.OVERRIDE_LAYOUT_INFORMATION); 
	public final static EArtifact LAYOUT_INFORMATION_ADAPTER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "LayoutInformationAdapter", new LayoutInformationAdapterGenerator(), OptionTypes.OVERRIDE_LAYOUT_INFORMATION_ADAPTER);

	public final static EArtifact NATURE = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Nature", new NatureGenerator(), OptionTypes.OVERRIDE_NATURE);
	public final static EArtifact BUILDER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Builder", new BuilderGenerator(), OptionTypes.OVERRIDE_BUILDER);
	public final static EArtifact BUILDER_ADAPTER = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "BuilderAdapter", new BuilderAdapterGenerator(), OptionTypes.OVERRIDE_BUILDER_ADAPTER);
	public final static EArtifact I_BUILDER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Builder", new IBuilderGenerator(), OptionTypes.OVERRIDE_IBUILDER);
	
	public final static EArtifact DEFAULT_TOKEN_RESOLVER = new EArtifact(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "DefaultTokenResolver", new DefaultTokenResolverGenerator(), OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER);
	public final static EArtifact DEFAULT_RESOLVER_DELEGATE = new EArtifact(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "DefaultResolverDelegate", new DefaultResolverDelegateGenerator(), OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE); 
	public final static EArtifact TOKEN_RESOLVER = new EArtifact(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "", null, OptionTypes.OVERRIDE_TOKEN_RESOLVERS);

	public final static EArtifact ANTLR_TOKEN_HELPER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "AntlrTokenHelper", new AntlrTokenHelperGenerator(), OptionTypes.OVERRIDE_ANTLR_TOKEN_HELPER); 
	public final static EArtifact BRACKET_SET = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "BracketSet", new BracketSetGenerator(), OptionTypes.OVERRIDE_BRACKET_SET);
	public final static EArtifact POSITION_HELPER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "PositionHelper", new PositionHelperGenerator(), OptionTypes.OVERRIDE_POSITION_HELPER);
	public final static EArtifact CODE_FOLDING_MANAGER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "CodeFoldingManager", new CodeFoldingManagerGenerator(), OptionTypes.OVERRIDE_CODE_FOLDING_MANAGER);
	public final static EArtifact EDITOR = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "Editor", new EditorGenerator(), OptionTypes.OVERRIDE_EDITOR);
	public final static EArtifact COLOR_MANAGER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "ColorManager", new ColorManagerGenerator(), OptionTypes.OVERRIDE_COLOR_MANAGER);
	public final static EArtifact BACKGROUND_PARSING_STRATEGY = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "BackgroundParsingStrategy", new BackgroundParsingStrategyGenerator(), OptionTypes.OVERRIDE_PARSING_STRATEGY);
	public final static EArtifact TEXT_HOVER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "TextHover", new TextHoverGenerator(), OptionTypes.OVERRIDE_TEXT_HOVER);
	public final static EArtifact HTML_PRINTER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "HTMLPrinter", new HTMLPrinterGenerator(), OptionTypes.OVERRIDE_HTML_PRINTER);
	public final static EArtifact POSITION_CATEGORY = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "PositionCategory", new PositionCategoryGenerator(), OptionTypes.OVERRIDE_POSITION_CATEGORY);
	public final static EArtifact OCCURENCE = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "Occurrence", new OccurrenceGenerator(), OptionTypes.OVERRIDE_OCCURENCE);
	public final static EArtifact TOKEN_SCANNER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "TokenScanner", new TokenScannerGenerator(), OptionTypes.OVERRIDE_TOKEN_SCANNER);
	public final static EArtifact MARKER_HELPER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "MarkerHelper", new MarkerHelperGenerator(), OptionTypes.OVERRIDE_MARKER_HELPER);
	public final static EArtifact HYPERLINK = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "Hyperlink", new HyperlinkGenerator(), OptionTypes.OVERRIDE_HYPERLINK);
	public final static EArtifact HYPERLINK_DETECTOR = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "HyperlinkDetector", new HyperlinkDetectorGenerator(), OptionTypes.OVERRIDE_HYPERLINK_DETECTOR); 
	public final static EArtifact E_OBJECT_SELECTION = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "EObjectSelection", new EObjectSelectionGenerator(), OptionTypes.OVERRIDE_EOBJECT_SELECTION);
	public final static EArtifact HIGHLIGHTING = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "Highlighting", new HighlightingGenerator(), OptionTypes.OVERRIDE_HIGHLIGHTING);
	public final static EArtifact PROPERTY_SHEET_PAGE = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "PropertySheetPage", new PropertySheetPageGenerator(), OptionTypes.OVERRIDE_PROPERTY_SHEET_PAGE);
	public final static EArtifact OUTLINE_PAGE_TREE_VIEWER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "OutlinePageTreeViewer", new OutlinePageTreeViewerGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE_TREE_VIEWER); 
	public final static EArtifact OUTLINE_PAGE = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "OutlinePage", new OutlinePageGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE);
	public final static EArtifact EDITOR_CONFIGURATION = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "EditorConfiguration", new EditorConfigurationGenerator(), OptionTypes.OVERRIDE_EDITOR_CONFIGURATION);
	public final static EArtifact DOC_BROWSER_INFORMATION_CONTROL_INPUT = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "DocBrowserInformationControlInput", new DocBrowserInformationControlInputGenerator(), OptionTypes.OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT);
	public final static EArtifact COMPLETION_PROCESSOR = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "CompletionProcessor", new CompletionProcessorGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROCESSOR);
	public final static EArtifact BROWSER_INFORMATION_CONTROL = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "BrowserInformationControl", new BrowserInformationControlGenerator(), OptionTypes.OVERRIDE_BROWSER_INFORMATION_CONTROL);
	// preference pages
	public final static EArtifact PREFERENCE_PAGE = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferencePage", new PreferencePageGenerator(), OptionTypes.OVERRIDE_PREFERENCE_PAGE);
	public final static EArtifact BRACKET_PREFERENCE_PAGE = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "BracketPreferencePage", new BracketPreferencePageGenerator(), OptionTypes.OVERRIDE_BRACKET_PREFERENCE_PAGE);
	public final static EArtifact PREFERENCE_CONSTANTS = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferenceConstants", new PreferenceConstantsGenerator(), OptionTypes.OVERRIDE_PREFERENCE_CONSTANTS);
	public final static EArtifact OCCURRENCE_PREFERENCE_PAGE = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "OccurrencePreferencePage", new OccurrencePreferencePageGenerator(), OptionTypes.OVERRIDE_OCCURENCE_PREFERENCE_PAGE);
	public final static EArtifact PIXEL_CONVERTER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "PixelConverter", new PixelConverterGenerator(), OptionTypes.OVERRIDE_PIXEL_CONVERTER);
	public final static EArtifact PREFERENCE_INITIALIZER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferenceInitializer", new PreferenceInitializerGenerator(), OptionTypes.OVERRIDE_PREFERENCE_INITIALIZER);
	public final static EArtifact SYNTAX_COLORING_HELPER = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "SyntaxColoringHelper", new SyntaxColoringHelperGenerator(), OptionTypes.OVERRIDE_SYNTAX_COLORING_HELPER);
	public final static EArtifact SYNTAX_COLORING_PREFERENCE_PAGE = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "SyntaxColoringPreferencePage", new SyntaxColoringPreferencePageGenerator(), OptionTypes.OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE);
	public final static EArtifact NEW_FILE_WIZARD = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "NewFileWizard", new NewFileWizardGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD);
	public final static EArtifact NEW_FILE_WIZARD_PAGE = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "NewFileWizardPage", new NewFileWizardPageGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD_PAGE);
	
	public final static EArtifact I_INPUT_STREAM_PROCESSOR_PROVIDER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "InputStreamProcessorProvider", new IInputStreamProcessorProviderGenerator(), OptionTypes.OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER);
	public final static EArtifact INPUT_STREAM_PROCESSOR = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "InputStreamProcessor", new InputStreamProcessorGenerator(), OptionTypes.OVERRIDE_INPUT_STREAM_PROCESSOR);
	public final static EArtifact I_OPTION_PROVIDER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "OptionProvider", new IOptionProviderGenerator(), OptionTypes.OVERRIDE_IOPTION_PROVIDER);
	public final static EArtifact I_OPTIONS = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Options", new IOptionsGenerator(), OptionTypes.OVERRIDE_IOPTIONS);
	public final static EArtifact I_RESOURCE_POST_PROCESSOR = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ResourcePostProcessor", new IResourcePostProcessorGenerator(), OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR);
	public final static EArtifact I_RESOURCE_POST_PROCESSOR_PROVIDER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ResourcePostProcessorProvider", new IResourcePostProcessorProviderGenerator(), OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER);
	public final static EArtifact I_BACKGROUND_PARSING_LISTENER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "BackgroundParsingListener", new IBackgroundParsingListenerGenerator(), OptionTypes.OVERRIDE_IBACKGROUND_PARSING_LISTENER);
	public final static EArtifact I_BRACKET_PAIR = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "BracketPair", new IBracketPairGenerator(), OptionTypes.OVERRIDE_IBRACKET_PAIR);
	public final static EArtifact I_COMMAND = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Command", new ICommandGenerator(), OptionTypes.OVERRIDE_ICOMMAND);
	public final static EArtifact I_CONFIGURABLE = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Configurable", new IConfigurableGenerator(), OptionTypes.OVERRIDE_ICONFIGURABLE);
	public final static EArtifact I_CONTEXT_DEPENDENT_URI_FRAGMENT = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ContextDependentURIFragment", new IContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static EArtifact I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ContextDependentURIFragmentFactory", new IContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static EArtifact I_ELEMENT_MAPPING = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ElementMapping", new IElementMappingGenerator(), OptionTypes.OVERRIDE_IELEMENT_MAPPING);
	public final static EArtifact I_EXPECTED_ELEMENT = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ExpectedElement", new IExpectedElementGenerator(), OptionTypes.OVERRIDE_IEXPECTED_ELEMENT);
	public final static EArtifact I_HOVER_TEXT_PROVIDER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "HoverTextProvider", new IHoverTextProviderGenerator(), OptionTypes.OVERRIDE_IHOVER_TEXT_PROVIDER);
	public final static EArtifact I_LOCATION_MAP = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "LocationMap", new ILocationMapGenerator(), OptionTypes.OVERRIDE_ILOCATION_MAP);
	public final static EArtifact I_PARSE_RESULT = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ParseResult", new IParseResultGenerator(), OptionTypes.OVERRIDE_IPARSE_RESULT);
	public final static EArtifact I_PROBLEM = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Problem", new IProblemGenerator(), OptionTypes.OVERRIDE_IPROBLEM);
	public final static EArtifact I_REFERENCE_CACHE = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceCache", new IReferenceCacheGenerator(), OptionTypes.OVERRIDE_IREFERENCE_CACHE);
	public final static EArtifact I_REFERENCE_MAPPING = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceMapping", new IReferenceMappingGenerator(), OptionTypes.OVERRIDE_IREFERENCE_MAPPING);
	public final static EArtifact I_REFERENCE_RESOLVER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolver", new IReferenceResolverGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVER);
	public final static EArtifact I_REFERENCE_RESOLVE_RESULT = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolveResult", new IReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVE_RESULT);
	public final static EArtifact I_REFERENCE_RESOLVER_SWITCH = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolverSwitch", new IReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVER_SWITCH);
	public final static EArtifact I_TEXT_DIAGNOSTIC = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextDiagnostic", new ITextDiagnosticGenerator(), OptionTypes.OVERRIDE_ITEXT_DIAGNOSTIC);
	public final static EArtifact I_TEXT_PARSER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextParser", new ITextParserGenerator(), OptionTypes.OVERRIDE_ITEXT_PARSER);
	public final static EArtifact I_TEXT_PRINTER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextPrinter", new ITextPrinterGenerator(), OptionTypes.OVERRIDE_ITEXT_PRINTER);
	public final static EArtifact I_TEXT_RESOURCE = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextResource", new ITextResourceGenerator(), OptionTypes.OVERRIDE_ITEXT_RESOURCE);
	public final static EArtifact I_META_INFORMATION = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "MetaInformation", new IMetaInformationGenerator(), OptionTypes.OVERRIDE_IMETA_INFORMATION);
	public final static EArtifact I_TEXT_RESOURCE_PLUGIN_PART = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextResourcePluginPart", new ITextResourcePluginPartGenerator(), OptionTypes.OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART);
	public final static EArtifact I_TEXT_SCANNER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextScanner", new ITextScannerGenerator(), OptionTypes.OVERRIDE_ITEXT_SCANNER);
	public final static EArtifact I_TEXT_TOKEN = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextToken", new ITextTokenGenerator(), OptionTypes.OVERRIDE_ITEXT_TOKEN);
	public final static EArtifact I_TOKEN_RESOLVER = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolver", new ITokenResolverGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVER);
	public final static EArtifact I_TOKEN_RESOLVE_RESULT = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolveResult", new ITokenResolveResultGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVE_RESULT);
	public final static EArtifact I_TOKEN_RESOLVER_FACTORY = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolverFactory", new ITokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVER_FACTORY);
	public final static EArtifact I_TOKEN_STYLE = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenStyle", new ITokenStyleGenerator(), OptionTypes.OVERRIDE_ITOKEN_STYLE);
	public final static EArtifact I_URI_MAPPING = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "URIMapping", new IURIMappingGenerator(), OptionTypes.OVERRIDE_IURI_MAPPING);
	public final static EArtifact E_PROBLEM_TYPE = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "", "EProblemType", new EProblemTypeGenerator(), OptionTypes.OVERRIDE_EPROBLEM_TYPE);
	
	public final static EArtifact CODE_COMPLETION_HELPER = new EArtifact(RESOURCE_PLUGIN, CC_PACKAGE, "", "CodeCompletionHelper", new CodeCompletionHelperGenerator(), OptionTypes.OVERRIDE_CODE_COMPLETION_HELPER);
	public final static EArtifact EXPECTED_CS_STRING = new EArtifact(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedCsString", new ExpectedCsStringGenerator(), OptionTypes.OVERRIDE_EXPECTED_CS_STRING);
	public final static EArtifact EXPECTED_STRUCTURAL_FEATURE = new EArtifact(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedStructuralFeature", new ExpectedStructuralFeatureGenerator(), OptionTypes.OVERRIDE_EXPECTED_STRUCTURAL_FEATURE);
	public final static EArtifact ABSTRACT_EXPECTED_ELEMENT = new EArtifact(RESOURCE_PLUGIN, CC_PACKAGE, "", "AbstractExpectedElement", new AbstractExpectedElementGenerator(), OptionTypes.OVERRIDE_ABSTRACT_EXPECTED_ELEMENT);
	public final static EArtifact EXPECTED_TERMINAL = new EArtifact(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedTerminal", new ExpectedTerminalGenerator(), OptionTypes.OVERRIDE_EXPECTED_TERMINAL);
	public final static EArtifact COMPLETION_PROPOSAL = new EArtifact(RESOURCE_PLUGIN, CC_PACKAGE, "", "CompletionProposal", new CompletionProposalGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROPOSAL); 
	public final static EArtifact ATTRIBUTE_VALUE_PROVIDER = new EArtifact(RESOURCE_PLUGIN, CC_PACKAGE, "", "AttributeValueProvider", new AttributeValueProviderGenerator(), OptionTypes.OVERRIDE_ATTRIBUTE_VALUE_PROVIDER);

	// the grammar package
	public final static EArtifact CARDINALITY = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Cardinality", new CardinalityGenerator(), OptionTypes.OVERRIDE_CARDINALITY);
	public final static EArtifact SYNTAX_ELEMENT = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "SyntaxElement", new SyntaxElementGenerator(), OptionTypes.OVERRIDE_SYNTAX_ELEMENT);
	public final static EArtifact KEYWORD = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Keyword", new KeywordGenerator(), OptionTypes.OVERRIDE_KEYWORD);
	public final static EArtifact TERMINAL = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Terminal", new TerminalGenerator(), OptionTypes.OVERRIDE_TERMINAL);
	public final static EArtifact PLACEHOLDER = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Placeholder", new PlaceholderGenerator(), OptionTypes.OVERRIDE_PLACEHOLDER);
	public final static EArtifact CHOICE = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Choice", new ChoiceGenerator(), OptionTypes.OVERRIDE_CHOICE);
	public final static EArtifact COMPOUND = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Compound", new CompoundGenerator(), OptionTypes.OVERRIDE_COMPOUND);
	public final static EArtifact CONTAINMENT = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Containment", new ContainmentGenerator(), OptionTypes.OVERRIDE_CONTAINMENT);
	public final static EArtifact LINE_BREAK = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "LineBreak", new LineBreakGenerator(), OptionTypes.OVERRIDE_LINE_BREAK);
	public final static EArtifact SEQUENCE = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Sequence", new SequenceGenerator(), OptionTypes.OVERRIDE_SEQUENCE);
	public final static EArtifact WHITE_SPACE = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "WhiteSpace", new WhiteSpaceGenerator(), OptionTypes.OVERRIDE_WHITE_SPACE);
	public final static EArtifact FORMATTING_ELEMENT = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "FormattingElement", new FormattingElementGenerator(), OptionTypes.OVERRIDE_FORMATTING_ELEMENT);

	public final static EArtifact GRAMMAR_INFORMATION_PROVIDER = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "GrammarInformationProvider", new GrammarInformationProviderGenerator(), OptionTypes.OVERRIDE_GRAMMAR_INFORMATION_PROVIDER);
	public final static EArtifact FOLLOW_SET_PROVIDER = new EArtifact(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "FollowSetProvider", new FollowSetProviderGenerator(), OptionTypes.OVERRIDE_FOLLOW_SET_PROVIDER);
	
	public final static EArtifact CAST_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CastUtil", new CastUtilGenerator(), OptionTypes.OVERRIDE_CAST_UTIL);
	public final static EArtifact COPIED_E_LIST = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CopiedEList", new CopiedEListGenerator(), OptionTypes.OVERRIDE_COPIED_ELIST);
	public final static EArtifact COPIED_E_OBJECT_INTERNAL_E_LIST = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CopiedEObjectInternalEList", new CopiedEObjectInternalEListGenerator(), OptionTypes.OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST);
	public final static EArtifact E_CLASS_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "EClassUtil", new EClassUtilGenerator(), OptionTypes.OVERRIDE_ECLASS_UTIL);
	public final static EArtifact E_OBJECT_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "EObjectUtil", new EObjectUtilGenerator(), OptionTypes.OVERRIDE_EOBJECT_UTIL);
	public final static EArtifact LIST_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "ListUtil", new ListUtilGenerator(), OptionTypes.OVERRIDE_LIST_UTIL);
	public final static EArtifact MAP_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "MapUtil", new MapUtilGenerator(), OptionTypes.OVERRIDE_MAP_UTIL);
	public final static EArtifact PAIR = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "Pair", new PairGenerator(), OptionTypes.OVERRIDE_PAIR);
	public final static EArtifact MINIMAL_MODEL_HELPER = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "MinimalModelHelper", new MinimalModelHelperGenerator(), OptionTypes.OVERRIDE_MINIMAL_MODEL_HELPER);
	public final static EArtifact RESOURCE_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "ResourceUtil", new ResourceUtilGenerator(), OptionTypes.OVERRIDE_RESOURCE_UTIL);
	public final static EArtifact STREAM_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "StreamUtil", new StreamUtilGenerator(), OptionTypes.OVERRIDE_STREAM_UTIL);
	public final static EArtifact STRING_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "StringUtil", new StringUtilGenerator(), OptionTypes.OVERRIDE_STRING_UTIL);
	public final static EArtifact TEXT_RESOURCE_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "TextResourceUtil", new TextResourceUtilGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE_UTIL);
	public final static EArtifact UNICODE_CONVERTER = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "UnicodeConverter", new UnicodeConverterGenerator(), OptionTypes.OVERRIDE_UNICODE_CONVERTER);
	public final static EArtifact ABSTRACT_INTERPRETER = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "Abstract", "Interpreter", new AbstractInterpreterGenerator(), OptionTypes.OVERRIDE_ABSTRACT_INTERPRETER);

	public final static EArtifact ANTLR_GRAMMAR = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", new ANTLRGrammarGenerator(), OptionTypes.OVERRIDE_PARSER); 
	public final static EArtifact BABYLON_SPECIFICATION = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Babylon", new BabylonSpecificationGenerator(), OptionTypes.OVERRIDE_PARSER);
	
	public final static EArtifact PACKAGE_ROOT = new EArtifact(RESOURCE_PLUGIN, ROOT_PACKAGE, "", "", null, null);
	public final static EArtifact PACKAGE_MOPP = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", null, null);
	public final static EArtifact PACKAGE_ANALYSIS = new EArtifact(RESOURCE_PLUGIN, ANALYSIS_PACKAGE, "analysis", "analysis", null, null);      
	public final static EArtifact PACKAGE_CC = new EArtifact(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", null, null);
	public final static EArtifact PACKAGE_UI = new EArtifact(RESOURCE_PLUGIN, UI_PACKAGE, "", "", null, null);
	public final static EArtifact PACKAGE_UTIL = new EArtifact(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "", null, null);
	
	public final static EArtifact PACKAGE_ANTLR_RUNTIME = new EArtifact(ANTLR_PLUGIN, ANTLR_RUNTIME_PACKAGE, "", "", null, null);
	public final static EArtifact PACKAGE_ANTLR_RUNTIME_DEBUG = new EArtifact(ANTLR_PLUGIN, ANTLR_RUNTIME_DEBUG_PACKAGE, "", "", null, null);
	public final static EArtifact PACKAGE_ANTLR_RUNTIME_MISC = new EArtifact(ANTLR_PLUGIN, ANTLR_RUNTIME_MISC_PACKAGE, "", "", null, null);
	public final static EArtifact PACKAGE_ANTLR_RUNTIME_TREE = new EArtifact(ANTLR_PLUGIN, ANTLR_RUNTIME_TREE_PACKAGE, "", "", null, null); 
	
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
