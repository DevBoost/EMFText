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
import static org.emftext.sdk.codegen.TextResourcePlugins.ANTLR_PLUGIN;
import static org.emftext.sdk.codegen.TextResourcePlugins.RESOURCE_PLUGIN;

import org.emftext.sdk.Constants;
import org.emftext.sdk.IPluginDescriptor;
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
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class TextResourceArtifacts {
	
	public final static ArtifactDescriptor<GenerationContext, IPluginDescriptor<GenerationContext>> BUILD_PROPERTIES = new ArtifactDescriptor<GenerationContext, IPluginDescriptor<GenerationContext>>(null, null, "", "", null, OptionTypes.OVERRIDE_BUILD_PROPERTIES); 
	public final static ArtifactDescriptor<GenerationContext, Object> DOT_CLASSPATH = new ArtifactDescriptor<GenerationContext, Object>(null, null, "", "", null, OptionTypes.OVERRIDE_DOT_CLASSPATH);
	public final static ArtifactDescriptor<GenerationContext, Object> DOT_PROJECT = new ArtifactDescriptor<GenerationContext, Object>(null, null, "", "", null, OptionTypes.OVERRIDE_DOT_PROJECT);

	// the classes
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_LEXER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Lexer", null, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "AntlrScanner", new ANTLRScannerGenerator(), OptionTypes.OVERRIDE_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_PARSER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Parser", null, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_PARSER_BASE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ANTLRParserBase", new ANTLRParserBaseGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTEXT_DEPENDENT_URI_FRAGMENT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ContextDependentURIFragment", new ContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ContextDependentURIFragmentFactory", new ContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> DELEGATING_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "DelegatingResolveResult", new DelegatingResolveResultGenerator(), OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> DUMMY_E_OBJECT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "DummyEObject", new DummyEObjectGenerator(), OptionTypes.OVERRIDE_DUMMY_EOBJECT);
	public final static ArtifactDescriptor<GenerationContext, Object> ELEMENT_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ElementMapping", new ElementMappingGenerator(), OptionTypes.OVERRIDE_ELEMENT_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> FUZZY_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "FuzzyResolveResult", new FuzzyResolveResultGenerator(), OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> LOCATION_MAP = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "LocationMap", new LocationMapGenerator(), OptionTypes.OVERRIDE_LOCATION_MAP);
	public final static ArtifactDescriptor<GenerationContext, Object> REFERENCE_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ReferenceResolveResult", new ReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenResolveResult", new TokenResolveResultGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> URI_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "URIMapping", new URIMappingGenerator(), OptionTypes.OVERRIDE_URI_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> SCANNERLESS_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ScannerlessScanner", new ScannerlessScannerGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> SCANNERLESS_PARSER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ScannerlessParser", new ScannerlessParserGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> PROBLEM = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Problem", new ProblemClassGenerator(), OptionTypes.OVERRIDE_PROBLEM_CLASS);
	public final static ArtifactDescriptor<GenerationContext, Object> PRINTER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Printer", new PrinterGenerator(), OptionTypes.OVERRIDE_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, Object> PRINTER2 = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Printer2", new Printer2Generator(), OptionTypes.OVERRIDE_PRINTER2);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_ELEMENT_DECORATOR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "SyntaxElementDecorator", new SyntaxElementDecoratorGenerator(), OptionTypes.OVERRIDE_SYNTAX_ELEMENT_DECORATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Resource", new TextResourceGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ResourceFactory", new ResourceFactoryGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_FACTORY_DELEGATOR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ResourceFactoryDelegator", new ResourceFactoryDelegatorGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY_DELEGATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_RESOLVER_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenResolverFactory", new TokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> REFERENCE_RESOLVER_SWITCH = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ReferenceResolverSwitch", new ReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH);
	public final static ArtifactDescriptor<GenerationContext, Object> META_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "MetaInformation", new MetaInformationGenerator(), OptionTypes.OVERRIDE_META_INFORMATION);
	
	// TODO the hover text provider should actually go to the UI package, but moving it requires
	// to remove the old generated class from existing DSL plug-ins. If bug #1296 is resolved 
	// this task is probably obsolete
	public final static ArtifactDescriptor<GenerationContext, Object> HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "HoverTextProvider", new HoverTextProviderGenerator(), OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> DEFAULT_HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "DefaultHoverTextProvider", new DefaultHoverTextProviderGenerator(), OptionTypes.OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> NEW_FILE_CONTENT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "NewFileContentProvider", new NewFileContentProviderGenerator(), OptionTypes.OVERRIDE_NEW_FILE_CONTENT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> PARSE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "ParseResult", new ParseResultGenerator(), OptionTypes.OVERRIDE_PARSE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> PLUGIN_ACTIVATOR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Plugin", new PluginActivatorGenerator(), OptionTypes.OVERRIDE_PLUGIN_ACTIVATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> TEXT_TOKEN = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TextToken", new TextTokenGenerator(), OptionTypes.OVERRIDE_TEXT_TOKEN);
	public final static ArtifactDescriptor<GenerationContext, Object> TERMINATE_PARSING_EXCEPTION = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TerminateParsingException", new TerminateParsingExceptionGenerator(), OptionTypes.OVERRIDE_TERMINATE_PARSING_EXCEPTION);
	public final static ArtifactDescriptor<GenerationContext, Object> UNEXPECTED_CONTENT_TYPE_EXCEPTION = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "UnexpectedContentTypeException", new UnexpectedContentTypeExceptionGenerator(), OptionTypes.OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_STYLE_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "TokenStyleInformationProvider", new TokenStyleInformationProviderGenerator(), OptionTypes.OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> FOLDING_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "FoldingInformationProvider", new FoldingInformationProviderGenerator(), OptionTypes.OVERRIDE_FOLDING_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> BRACKET_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "BracketInformationProvider", new BracketInformationProviderGenerator(), OptionTypes.OVERRIDE_BRACKET_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_COVERAGE_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "SyntaxCoverageInformationProvider", new SyntaxCoverageInformationProviderGenerator(), OptionTypes.OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> LAYOUT_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "LayoutInformation", new LayoutInformationGenerator(), OptionTypes.OVERRIDE_LAYOUT_INFORMATION); 
	public final static ArtifactDescriptor<GenerationContext, Object> LAYOUT_INFORMATION_ADAPTER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "LayoutInformationAdapter", new LayoutInformationAdapterGenerator(), OptionTypes.OVERRIDE_LAYOUT_INFORMATION_ADAPTER);

	public final static ArtifactDescriptor<GenerationContext, Object> NATURE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Nature", new NatureGenerator(), OptionTypes.OVERRIDE_NATURE);
	public final static ArtifactDescriptor<GenerationContext, Object> BUILDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Builder", new BuilderGenerator(), OptionTypes.OVERRIDE_BUILDER);
	public final static ArtifactDescriptor<GenerationContext, Object> BUILDER_ADAPTER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "BuilderAdapter", new BuilderAdapterGenerator(), OptionTypes.OVERRIDE_BUILDER_ADAPTER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BUILDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Builder", new IBuilderGenerator(), OptionTypes.OVERRIDE_IBUILDER);
	
	public final static ArtifactDescriptor<GenerationContext, Object> DEFAULT_TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "DefaultTokenResolver", new DefaultTokenResolverGenerator(), OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> DEFAULT_RESOLVER_DELEGATE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "DefaultResolverDelegate", new DefaultResolverDelegateGenerator(), OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE); 
	public final static ArtifactDescriptor<GenerationContext, CompleteTokenDefinition> TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, CompleteTokenDefinition>(RESOURCE_PLUGIN, Constants.ANALYSIS_PACKAGE, "", "", null, OptionTypes.OVERRIDE_TOKEN_RESOLVERS);

	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_TOKEN_HELPER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "AntlrTokenHelper", new AntlrTokenHelperGenerator(), OptionTypes.OVERRIDE_ANTLR_TOKEN_HELPER); 
	public final static ArtifactDescriptor<GenerationContext, Object> BRACKET_SET = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "BracketSet", new BracketSetGenerator(), OptionTypes.OVERRIDE_BRACKET_SET);
	public final static ArtifactDescriptor<GenerationContext, Object> POSITION_HELPER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "PositionHelper", new PositionHelperGenerator(), OptionTypes.OVERRIDE_POSITION_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> CODE_FOLDING_MANAGER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "CodeFoldingManager", new CodeFoldingManagerGenerator(), OptionTypes.OVERRIDE_CODE_FOLDING_MANAGER);
	public final static ArtifactDescriptor<GenerationContext, Object> EDITOR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "Editor", new EditorGenerator(), OptionTypes.OVERRIDE_EDITOR);
	public final static ArtifactDescriptor<GenerationContext, Object> COLOR_MANAGER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "ColorManager", new ColorManagerGenerator(), OptionTypes.OVERRIDE_COLOR_MANAGER);
	public final static ArtifactDescriptor<GenerationContext, Object> BACKGROUND_PARSING_STRATEGY = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "BackgroundParsingStrategy", new BackgroundParsingStrategyGenerator(), OptionTypes.OVERRIDE_PARSING_STRATEGY);
	public final static ArtifactDescriptor<GenerationContext, Object> TEXT_HOVER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "TextHover", new TextHoverGenerator(), OptionTypes.OVERRIDE_TEXT_HOVER);
	public final static ArtifactDescriptor<GenerationContext, Object> HTML_PRINTER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "HTMLPrinter", new HTMLPrinterGenerator(), OptionTypes.OVERRIDE_HTML_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, Object> POSITION_CATEGORY = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "PositionCategory", new PositionCategoryGenerator(), OptionTypes.OVERRIDE_POSITION_CATEGORY);
	public final static ArtifactDescriptor<GenerationContext, Object> OCCURENCE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "Occurrence", new OccurrenceGenerator(), OptionTypes.OVERRIDE_OCCURENCE);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "TokenScanner", new TokenScannerGenerator(), OptionTypes.OVERRIDE_TOKEN_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, Object> MARKER_HELPER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "MarkerHelper", new MarkerHelperGenerator(), OptionTypes.OVERRIDE_MARKER_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> HYPERLINK = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "Hyperlink", new HyperlinkGenerator(), OptionTypes.OVERRIDE_HYPERLINK);
	public final static ArtifactDescriptor<GenerationContext, Object> HYPERLINK_DETECTOR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "HyperlinkDetector", new HyperlinkDetectorGenerator(), OptionTypes.OVERRIDE_HYPERLINK_DETECTOR); 
	public final static ArtifactDescriptor<GenerationContext, Object> E_OBJECT_SELECTION = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "EObjectSelection", new EObjectSelectionGenerator(), OptionTypes.OVERRIDE_EOBJECT_SELECTION);
	public final static ArtifactDescriptor<GenerationContext, Object> HIGHLIGHTING = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "Highlighting", new HighlightingGenerator(), OptionTypes.OVERRIDE_HIGHLIGHTING);
	public final static ArtifactDescriptor<GenerationContext, Object> PROPERTY_SHEET_PAGE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "PropertySheetPage", new PropertySheetPageGenerator(), OptionTypes.OVERRIDE_PROPERTY_SHEET_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> OUTLINE_PAGE_TREE_VIEWER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "OutlinePageTreeViewer", new OutlinePageTreeViewerGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE_TREE_VIEWER); 
	public final static ArtifactDescriptor<GenerationContext, Object> OUTLINE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "OutlinePage", new OutlinePageGenerator(), OptionTypes.OVERRIDE_OUTLINE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> EDITOR_CONFIGURATION = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "EditorConfiguration", new EditorConfigurationGenerator(), OptionTypes.OVERRIDE_EDITOR_CONFIGURATION);
	public final static ArtifactDescriptor<GenerationContext, Object> DOC_BROWSER_INFORMATION_CONTROL_INPUT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "DocBrowserInformationControlInput", new DocBrowserInformationControlInputGenerator(), OptionTypes.OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT);
	public final static ArtifactDescriptor<GenerationContext, Object> COMPLETION_PROCESSOR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "CompletionProcessor", new CompletionProcessorGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, Object> BROWSER_INFORMATION_CONTROL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "BrowserInformationControl", new BrowserInformationControlGenerator(), OptionTypes.OVERRIDE_BROWSER_INFORMATION_CONTROL);
	// preference pages
	public final static ArtifactDescriptor<GenerationContext, Object> PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferencePage", new PreferencePageGenerator(), OptionTypes.OVERRIDE_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> BRACKET_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "BracketPreferencePage", new BracketPreferencePageGenerator(), OptionTypes.OVERRIDE_BRACKET_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> PREFERENCE_CONSTANTS = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferenceConstants", new PreferenceConstantsGenerator(), OptionTypes.OVERRIDE_PREFERENCE_CONSTANTS);
	public final static ArtifactDescriptor<GenerationContext, Object> OCCURRENCE_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "OccurrencePreferencePage", new OccurrencePreferencePageGenerator(), OptionTypes.OVERRIDE_OCCURENCE_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> PIXEL_CONVERTER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "PixelConverter", new PixelConverterGenerator(), OptionTypes.OVERRIDE_PIXEL_CONVERTER);
	public final static ArtifactDescriptor<GenerationContext, Object> PREFERENCE_INITIALIZER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "PreferenceInitializer", new PreferenceInitializerGenerator(), OptionTypes.OVERRIDE_PREFERENCE_INITIALIZER);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_COLORING_HELPER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "SyntaxColoringHelper", new SyntaxColoringHelperGenerator(), OptionTypes.OVERRIDE_SYNTAX_COLORING_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_COLORING_PREFERENCE_PAGE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "SyntaxColoringPreferencePage", new SyntaxColoringPreferencePageGenerator(), OptionTypes.OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE);
	public final static ArtifactDescriptor<GenerationContext, Object> NEW_FILE_WIZARD = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "NewFileWizard", new NewFileWizardGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD);
	public final static ArtifactDescriptor<GenerationContext, Object> NEW_FILE_WIZARD_PAGE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "NewFileWizardPage", new NewFileWizardPageGenerator(), OptionTypes.OVERRIDE_NEW_FILE_WIZARD_PAGE);
	
	public final static ArtifactDescriptor<GenerationContext, Object> I_INPUT_STREAM_PROCESSOR_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "InputStreamProcessorProvider", new IInputStreamProcessorProviderGenerator(), OptionTypes.OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> INPUT_STREAM_PROCESSOR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "InputStreamProcessor", new InputStreamProcessorGenerator(), OptionTypes.OVERRIDE_INPUT_STREAM_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_OPTION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "OptionProvider", new IOptionProviderGenerator(), OptionTypes.OVERRIDE_IOPTION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_OPTIONS = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Options", new IOptionsGenerator(), OptionTypes.OVERRIDE_IOPTIONS);
	public final static ArtifactDescriptor<GenerationContext, Object> I_RESOURCE_POST_PROCESSOR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ResourcePostProcessor", new IResourcePostProcessorGenerator(), OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_RESOURCE_POST_PROCESSOR_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ResourcePostProcessorProvider", new IResourcePostProcessorProviderGenerator(), OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BACKGROUND_PARSING_LISTENER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "BackgroundParsingListener", new IBackgroundParsingListenerGenerator(), OptionTypes.OVERRIDE_IBACKGROUND_PARSING_LISTENER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BRACKET_PAIR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "BracketPair", new IBracketPairGenerator(), OptionTypes.OVERRIDE_IBRACKET_PAIR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_COMMAND = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Command", new ICommandGenerator(), OptionTypes.OVERRIDE_ICOMMAND);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONFIGURABLE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Configurable", new IConfigurableGenerator(), OptionTypes.OVERRIDE_ICONFIGURABLE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONTEXT_DEPENDENT_URI_FRAGMENT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ContextDependentURIFragment", new IContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ContextDependentURIFragmentFactory", new IContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> I_ELEMENT_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ElementMapping", new IElementMappingGenerator(), OptionTypes.OVERRIDE_IELEMENT_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> I_EXPECTED_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ExpectedElement", new IExpectedElementGenerator(), OptionTypes.OVERRIDE_IEXPECTED_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "HoverTextProvider", new IHoverTextProviderGenerator(), OptionTypes.OVERRIDE_IHOVER_TEXT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_LOCATION_MAP = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "LocationMap", new ILocationMapGenerator(), OptionTypes.OVERRIDE_ILOCATION_MAP);
	public final static ArtifactDescriptor<GenerationContext, Object> I_PARSE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ParseResult", new IParseResultGenerator(), OptionTypes.OVERRIDE_IPARSE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_PROBLEM = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "Problem", new IProblemGenerator(), OptionTypes.OVERRIDE_IPROBLEM);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_CACHE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceCache", new IReferenceCacheGenerator(), OptionTypes.OVERRIDE_IREFERENCE_CACHE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceMapping", new IReferenceMappingGenerator(), OptionTypes.OVERRIDE_IREFERENCE_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolver", new IReferenceResolverGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolveResult", new IReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVER_SWITCH = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "ReferenceResolverSwitch", new IReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVER_SWITCH);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_DIAGNOSTIC = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextDiagnostic", new ITextDiagnosticGenerator(), OptionTypes.OVERRIDE_ITEXT_DIAGNOSTIC);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_PARSER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextParser", new ITextParserGenerator(), OptionTypes.OVERRIDE_ITEXT_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_PRINTER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextPrinter", new ITextPrinterGenerator(), OptionTypes.OVERRIDE_ITEXT_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_RESOURCE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextResource", new ITextResourceGenerator(), OptionTypes.OVERRIDE_ITEXT_RESOURCE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_META_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "MetaInformation", new IMetaInformationGenerator(), OptionTypes.OVERRIDE_IMETA_INFORMATION);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_RESOURCE_PLUGIN_PART = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextResourcePluginPart", new ITextResourcePluginPartGenerator(), OptionTypes.OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextScanner", new ITextScannerGenerator(), OptionTypes.OVERRIDE_ITEXT_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_TOKEN = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TextToken", new ITextTokenGenerator(), OptionTypes.OVERRIDE_ITEXT_TOKEN);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolver", new ITokenResolverGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolveResult", new ITokenResolveResultGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVER_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenResolverFactory", new ITokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVER_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_STYLE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "TokenStyle", new ITokenStyleGenerator(), OptionTypes.OVERRIDE_ITOKEN_STYLE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_URI_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "I", "URIMapping", new IURIMappingGenerator(), OptionTypes.OVERRIDE_IURI_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> E_PROBLEM_TYPE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "", "EProblemType", new EProblemTypeGenerator(), OptionTypes.OVERRIDE_EPROBLEM_TYPE);
	
	public final static ArtifactDescriptor<GenerationContext, Object> CODE_COMPLETION_HELPER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, CC_PACKAGE, "", "CodeCompletionHelper", new CodeCompletionHelperGenerator(), OptionTypes.OVERRIDE_CODE_COMPLETION_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_CS_STRING = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedCsString", new ExpectedCsStringGenerator(), OptionTypes.OVERRIDE_EXPECTED_CS_STRING);
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_STRUCTURAL_FEATURE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedStructuralFeature", new ExpectedStructuralFeatureGenerator(), OptionTypes.OVERRIDE_EXPECTED_STRUCTURAL_FEATURE);
	public final static ArtifactDescriptor<GenerationContext, Object> ABSTRACT_EXPECTED_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, CC_PACKAGE, "", "AbstractExpectedElement", new AbstractExpectedElementGenerator(), OptionTypes.OVERRIDE_ABSTRACT_EXPECTED_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_TERMINAL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, CC_PACKAGE, "", "ExpectedTerminal", new ExpectedTerminalGenerator(), OptionTypes.OVERRIDE_EXPECTED_TERMINAL);
	public final static ArtifactDescriptor<GenerationContext, Object> COMPLETION_PROPOSAL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, CC_PACKAGE, "", "CompletionProposal", new CompletionProposalGenerator(), OptionTypes.OVERRIDE_COMPLETION_PROPOSAL); 
	public final static ArtifactDescriptor<GenerationContext, Object> ATTRIBUTE_VALUE_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, CC_PACKAGE, "", "AttributeValueProvider", new AttributeValueProviderGenerator(), OptionTypes.OVERRIDE_ATTRIBUTE_VALUE_PROVIDER);

	// the grammar package
	public final static ArtifactDescriptor<GenerationContext, Object> CARDINALITY = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Cardinality", new CardinalityGenerator(), OptionTypes.OVERRIDE_CARDINALITY);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "SyntaxElement", new SyntaxElementGenerator(), OptionTypes.OVERRIDE_SYNTAX_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> KEYWORD = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Keyword", new KeywordGenerator(), OptionTypes.OVERRIDE_KEYWORD);
	public final static ArtifactDescriptor<GenerationContext, Object> TERMINAL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Terminal", new TerminalGenerator(), OptionTypes.OVERRIDE_TERMINAL);
	public final static ArtifactDescriptor<GenerationContext, Object> PLACEHOLDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Placeholder", new PlaceholderGenerator(), OptionTypes.OVERRIDE_PLACEHOLDER);
	public final static ArtifactDescriptor<GenerationContext, Object> CHOICE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Choice", new ChoiceGenerator(), OptionTypes.OVERRIDE_CHOICE);
	public final static ArtifactDescriptor<GenerationContext, Object> COMPOUND = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Compound", new CompoundGenerator(), OptionTypes.OVERRIDE_COMPOUND);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTAINMENT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Containment", new ContainmentGenerator(), OptionTypes.OVERRIDE_CONTAINMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> LINE_BREAK = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "LineBreak", new LineBreakGenerator(), OptionTypes.OVERRIDE_LINE_BREAK);
	public final static ArtifactDescriptor<GenerationContext, Object> SEQUENCE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "Sequence", new SequenceGenerator(), OptionTypes.OVERRIDE_SEQUENCE);
	public final static ArtifactDescriptor<GenerationContext, Object> WHITE_SPACE = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "WhiteSpace", new WhiteSpaceGenerator(), OptionTypes.OVERRIDE_WHITE_SPACE);
	public final static ArtifactDescriptor<GenerationContext, Object> FORMATTING_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "FormattingElement", new FormattingElementGenerator(), OptionTypes.OVERRIDE_FORMATTING_ELEMENT);

	public final static ArtifactDescriptor<GenerationContext, Object> GRAMMAR_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "GrammarInformationProvider", new GrammarInformationProviderGenerator(), OptionTypes.OVERRIDE_GRAMMAR_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> FOLLOW_SET_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, GRAMMAR_PACKAGE, "", "FollowSetProvider", new FollowSetProviderGenerator(), OptionTypes.OVERRIDE_FOLLOW_SET_PROVIDER);
	
	public final static ArtifactDescriptor<GenerationContext, Object> CAST_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CastUtil", new CastUtilGenerator(), OptionTypes.OVERRIDE_CAST_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> COPIED_E_LIST = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CopiedEList", new CopiedEListGenerator(), OptionTypes.OVERRIDE_COPIED_ELIST);
	public final static ArtifactDescriptor<GenerationContext, Object> COPIED_E_OBJECT_INTERNAL_E_LIST = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "CopiedEObjectInternalEList", new CopiedEObjectInternalEListGenerator(), OptionTypes.OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST);
	public final static ArtifactDescriptor<GenerationContext, Object> E_CLASS_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "EClassUtil", new EClassUtilGenerator(), OptionTypes.OVERRIDE_ECLASS_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> E_OBJECT_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "EObjectUtil", new EObjectUtilGenerator(), OptionTypes.OVERRIDE_EOBJECT_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> LIST_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "ListUtil", new ListUtilGenerator(), OptionTypes.OVERRIDE_LIST_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> MAP_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "MapUtil", new MapUtilGenerator(), OptionTypes.OVERRIDE_MAP_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> PAIR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "Pair", new PairGenerator(), OptionTypes.OVERRIDE_PAIR);
	public final static ArtifactDescriptor<GenerationContext, Object> MINIMAL_MODEL_HELPER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "MinimalModelHelper", new MinimalModelHelperGenerator(), OptionTypes.OVERRIDE_MINIMAL_MODEL_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "ResourceUtil", new ResourceUtilGenerator(), OptionTypes.OVERRIDE_RESOURCE_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> STREAM_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "StreamUtil", new StreamUtilGenerator(), OptionTypes.OVERRIDE_STREAM_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> STRING_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "StringUtil", new StringUtilGenerator(), OptionTypes.OVERRIDE_STRING_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> TEXT_RESOURCE_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "TextResourceUtil", new TextResourceUtilGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> UNICODE_CONVERTER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "UnicodeConverter", new UnicodeConverterGenerator(), OptionTypes.OVERRIDE_UNICODE_CONVERTER);
	public final static ArtifactDescriptor<GenerationContext, Object> ABSTRACT_INTERPRETER = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "Abstract", "Interpreter", new AbstractInterpreterGenerator(), OptionTypes.OVERRIDE_ABSTRACT_INTERPRETER);

	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_GRAMMAR = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", new ANTLRGrammarGenerator(), OptionTypes.OVERRIDE_PARSER); 
	public final static ArtifactDescriptor<GenerationContext, Object> BABYLON_SPECIFICATION = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "Babylon", new BabylonSpecificationGenerator(), OptionTypes.OVERRIDE_PARSER);
	
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_ROOT = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ROOT_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_MOPP = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_ANALYSIS = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, ANALYSIS_PACKAGE, "analysis", "analysis", null, null);      
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_CC = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, MOPP_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_UI = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UI_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_UTIL = new ArtifactDescriptor<GenerationContext, Object>(RESOURCE_PLUGIN, UTIL_PACKAGE, "", "", null, null);
	
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_ANTLR_RUNTIME = new ArtifactDescriptor<GenerationContext, Object>(ANTLR_PLUGIN, ANTLR_RUNTIME_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_ANTLR_RUNTIME_DEBUG = new ArtifactDescriptor<GenerationContext, Object>(ANTLR_PLUGIN, ANTLR_RUNTIME_DEBUG_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_ANTLR_RUNTIME_MISC = new ArtifactDescriptor<GenerationContext, Object>(ANTLR_PLUGIN, ANTLR_RUNTIME_MISC_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_ANTLR_RUNTIME_TREE = new ArtifactDescriptor<GenerationContext, Object>(ANTLR_PLUGIN, ANTLR_RUNTIME_TREE_PACKAGE, "", "", null, null); 
}
