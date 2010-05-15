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
package org.emftext.sdk.codegen.resource;

import static org.emftext.sdk.Constants.ANALYSIS_PACKAGE;
import static org.emftext.sdk.Constants.CC_PACKAGE;
import static org.emftext.sdk.Constants.GRAMMAR_PACKAGE;
import static org.emftext.sdk.Constants.MOPP_PACKAGE;
import static org.emftext.sdk.Constants.ROOT_PACKAGE;
import static org.emftext.sdk.Constants.UTIL_PACKAGE;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.Constants;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.ManifestCreator;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.ManifestParameters;
import org.emftext.sdk.codegen.resource.creators.AdditionalExtensionParserExtensionPointSchemaCreator;
import org.emftext.sdk.codegen.resource.creators.DefaultLoadOptionsExtensionPointSchemaCreator;
import org.emftext.sdk.codegen.resource.creators.PluginXMLCreator;
import org.emftext.sdk.codegen.resource.generators.AbstractInterpreterGenerator;
import org.emftext.sdk.codegen.resource.generators.BracketInformationProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.BuilderAdapterGenerator;
import org.emftext.sdk.codegen.resource.generators.BuilderGenerator;
import org.emftext.sdk.codegen.resource.generators.ContextDependentURIFragmentFactoryGenerator;
import org.emftext.sdk.codegen.resource.generators.ContextDependentURIFragmentGenerator;
import org.emftext.sdk.codegen.resource.generators.DefaultResolverDelegateGenerator;
import org.emftext.sdk.codegen.resource.generators.DefaultTokenResolverGenerator;
import org.emftext.sdk.codegen.resource.generators.DelegatingResolveResultGenerator;
import org.emftext.sdk.codegen.resource.generators.DummyEObjectGenerator;
import org.emftext.sdk.codegen.resource.generators.EProblemTypeGenerator;
import org.emftext.sdk.codegen.resource.generators.ElementMappingGenerator;
import org.emftext.sdk.codegen.resource.generators.FoldingInformationProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.FuzzyResolveResultGenerator;
import org.emftext.sdk.codegen.resource.generators.LocationMapGenerator;
import org.emftext.sdk.codegen.resource.generators.MetaInformationGenerator;
import org.emftext.sdk.codegen.resource.generators.NatureGenerator;
import org.emftext.sdk.codegen.resource.generators.NewFileContentProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.ParseResultGenerator;
import org.emftext.sdk.codegen.resource.generators.PluginActivatorGenerator;
import org.emftext.sdk.codegen.resource.generators.ProblemClassGenerator;
import org.emftext.sdk.codegen.resource.generators.ReferenceResolveResultGenerator;
import org.emftext.sdk.codegen.resource.generators.ReferenceResolverSwitchGenerator;
import org.emftext.sdk.codegen.resource.generators.ResourceFactoryDelegatorGenerator;
import org.emftext.sdk.codegen.resource.generators.ResourceFactoryGenerator;
import org.emftext.sdk.codegen.resource.generators.SyntaxCoverageInformationProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.TerminateParsingExceptionGenerator;
import org.emftext.sdk.codegen.resource.generators.TextResourceGenerator;
import org.emftext.sdk.codegen.resource.generators.TextTokenGenerator;
import org.emftext.sdk.codegen.resource.generators.TokenResolveResultGenerator;
import org.emftext.sdk.codegen.resource.generators.TokenResolverFactoryGenerator;
import org.emftext.sdk.codegen.resource.generators.TokenStyleInformationProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.URIMappingGenerator;
import org.emftext.sdk.codegen.resource.generators.UnexpectedContentTypeExceptionGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.AbstractExpectedElementGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.AttributeValueProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.ExpectedCsStringGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.ExpectedStructuralFeatureGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.ExpectedTerminalGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.CardinalityGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.ChoiceGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.CompoundGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.ContainmentGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.FollowSetProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.FormattingElementGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.GrammarInformationProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.KeywordGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.LineBreakGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.PlaceholderGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.SequenceGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.SyntaxElementGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.TerminalGenerator;
import org.emftext.sdk.codegen.resource.generators.grammar.WhiteSpaceGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IBackgroundParsingListenerGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IBracketPairGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IBuilderGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ICommandGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IConfigurableGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IContextDependentURIFragmentFactoryGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IContextDependentURIFragmentGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IElementMappingGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IExpectedElementGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IHoverTextProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IInputStreamProcessorProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ILocationMapGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IMetaInformationGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IOptionProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IOptionsGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IParseResultGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IProblemGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IReferenceCacheGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IReferenceMappingGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IReferenceResolveResultGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IReferenceResolverGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IReferenceResolverSwitchGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IResourcePostProcessorGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IResourcePostProcessorProviderGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITextDiagnosticGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITextParserGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITextPrinterGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITextResourceGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITextResourcePluginPartGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITextScannerGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITextTokenGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITokenResolveResultGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITokenResolverFactoryGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITokenResolverGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.ITokenStyleGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.IURIMappingGenerator;
import org.emftext.sdk.codegen.resource.generators.interfaces.InputStreamProcessorGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.ANTLRGrammarGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.ANTLRParserBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.ANTLRScannerGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.BabylonSpecificationGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.LayoutInformationAdapterGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.LayoutInformationGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.Printer2Generator;
import org.emftext.sdk.codegen.resource.generators.mopp.PrinterGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.ScannerlessParserGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.ScannerlessScannerGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.SyntaxElementDecoratorGenerator;
import org.emftext.sdk.codegen.resource.generators.util.CastUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.CopiedEListGenerator;
import org.emftext.sdk.codegen.resource.generators.util.CopiedEObjectInternalEListGenerator;
import org.emftext.sdk.codegen.resource.generators.util.EClassUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.EObjectUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.ListUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.MapUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.MinimalModelHelperGenerator;
import org.emftext.sdk.codegen.resource.generators.util.PairGenerator;
import org.emftext.sdk.codegen.resource.generators.util.ResourceUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.StreamUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.StringUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.TextResourceUtilGenerator;
import org.emftext.sdk.codegen.resource.generators.util.UnicodeConverterGenerator;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A collection of all artifacts that are created for the text resource plug-in
 * (excluding the UI resource artifacts).
 */
public class TextResourceArtifacts {
	
	public final static ArtifactDescriptor<GenerationContext, BuildPropertiesParameters> BUILD_PROPERTIES = new ArtifactDescriptor<GenerationContext, BuildPropertiesParameters>(null, BuildPropertiesCreator.FILENAME, "", null, OptionTypes.OVERRIDE_BUILD_PROPERTIES); 
	public final static ArtifactDescriptor<GenerationContext, ClassPathParameters> DOT_CLASSPATH = new ArtifactDescriptor<GenerationContext, ClassPathParameters>(null, DotClasspathCreator.FILENAME, "", null, OptionTypes.OVERRIDE_DOT_CLASSPATH);
	public final static ArtifactDescriptor<GenerationContext, IPluginDescriptor> DOT_PROJECT = new ArtifactDescriptor<GenerationContext, IPluginDescriptor>(null, DotProjectCreator.FILENAME, "", null, OptionTypes.OVERRIDE_DOT_PROJECT);

	public static final ArtifactDescriptor<GenerationContext, ManifestParameters> MANIFEST = new ArtifactDescriptor<GenerationContext, ManifestParameters>(null, ManifestCreator.FILENAME, "", null, null);
	public static final ArtifactDescriptor<GenerationContext, Object> PLUGIN_XML = new ArtifactDescriptor<GenerationContext, Object>(null, PluginXMLCreator.FILENAME, "", null, null);

	// the classes
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_LEXER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Lexer", null, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "AntlrScanner", ANTLRScannerGenerator.PROVIDER, OptionTypes.OVERRIDE_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_PARSER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Parser", null, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_PARSER_BASE = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ANTLRParserBase", ANTLRParserBaseGenerator.PROVIDER, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTEXT_DEPENDENT_URI_FRAGMENT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ContextDependentURIFragment", ContextDependentURIFragmentGenerator.PROVIDER, OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ContextDependentURIFragmentFactory", ContextDependentURIFragmentFactoryGenerator.PROVIDER, OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> DELEGATING_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "DelegatingResolveResult", DelegatingResolveResultGenerator.PROVIDER, OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> DUMMY_E_OBJECT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "DummyEObject", DummyEObjectGenerator.PROVIDER, OptionTypes.OVERRIDE_DUMMY_EOBJECT);
	public final static ArtifactDescriptor<GenerationContext, Object> ELEMENT_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ElementMapping", ElementMappingGenerator.PROVIDER, OptionTypes.OVERRIDE_ELEMENT_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> FUZZY_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "FuzzyResolveResult", FuzzyResolveResultGenerator.PROVIDER, OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> LOCATION_MAP = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "LocationMap", LocationMapGenerator.PROVIDER, OptionTypes.OVERRIDE_LOCATION_MAP);
	public final static ArtifactDescriptor<GenerationContext, Object> REFERENCE_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ReferenceResolveResult", ReferenceResolveResultGenerator.PROVIDER, OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TokenResolveResult", TokenResolveResultGenerator.PROVIDER, OptionTypes.OVERRIDE_TOKEN_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> URI_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "URIMapping", URIMappingGenerator.PROVIDER, OptionTypes.OVERRIDE_URI_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> SCANNERLESS_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ScannerlessScanner", ScannerlessScannerGenerator.PROVIDER, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> SCANNERLESS_PARSER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ScannerlessParser", ScannerlessParserGenerator.PROVIDER, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> PROBLEM = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Problem", ProblemClassGenerator.PROVIDER, OptionTypes.OVERRIDE_PROBLEM_CLASS);
	public final static ArtifactDescriptor<GenerationContext, Object> PRINTER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Printer", PrinterGenerator.PROVIDER, OptionTypes.OVERRIDE_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, Object> PRINTER2 = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Printer2", Printer2Generator.PROVIDER, OptionTypes.OVERRIDE_PRINTER2);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_ELEMENT_DECORATOR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "SyntaxElementDecorator", SyntaxElementDecoratorGenerator.PROVIDER, OptionTypes.OVERRIDE_SYNTAX_ELEMENT_DECORATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Resource", TextResourceGenerator.PROVIDER, OptionTypes.OVERRIDE_TEXT_RESOURCE);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ResourceFactory", ResourceFactoryGenerator.PROVIDER, OptionTypes.OVERRIDE_RESOURCE_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_FACTORY_DELEGATOR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ResourceFactoryDelegator", ResourceFactoryDelegatorGenerator.PROVIDER, OptionTypes.OVERRIDE_RESOURCE_FACTORY_DELEGATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_RESOLVER_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TokenResolverFactory", TokenResolverFactoryGenerator.PROVIDER, OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> REFERENCE_RESOLVER_SWITCH = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ReferenceResolverSwitch", ReferenceResolverSwitchGenerator.PROVIDER, OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH);
	public final static ArtifactDescriptor<GenerationContext, Object> META_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "MetaInformation", MetaInformationGenerator.PROVIDER, OptionTypes.OVERRIDE_META_INFORMATION);
	
	public final static ArtifactDescriptor<GenerationContext, Object> NEW_FILE_CONTENT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "NewFileContentProvider", NewFileContentProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_NEW_FILE_CONTENT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> PARSE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ParseResult", ParseResultGenerator.PROVIDER, OptionTypes.OVERRIDE_PARSE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> PLUGIN_ACTIVATOR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Plugin", PluginActivatorGenerator.PROVIDER, OptionTypes.OVERRIDE_PLUGIN_ACTIVATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> TEXT_TOKEN = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TextToken", TextTokenGenerator.PROVIDER, OptionTypes.OVERRIDE_TEXT_TOKEN);
	public final static ArtifactDescriptor<GenerationContext, Object> TERMINATE_PARSING_EXCEPTION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TerminateParsingException", TerminateParsingExceptionGenerator.PROVIDER, OptionTypes.OVERRIDE_TERMINATE_PARSING_EXCEPTION);
	public final static ArtifactDescriptor<GenerationContext, Object> UNEXPECTED_CONTENT_TYPE_EXCEPTION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "UnexpectedContentTypeException", UnexpectedContentTypeExceptionGenerator.PROVIDER, OptionTypes.OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_STYLE_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TokenStyleInformationProvider", TokenStyleInformationProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> FOLDING_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "FoldingInformationProvider", FoldingInformationProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_FOLDING_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> BRACKET_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "BracketInformationProvider", BracketInformationProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_BRACKET_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_COVERAGE_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "SyntaxCoverageInformationProvider", SyntaxCoverageInformationProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> LAYOUT_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "LayoutInformation", LayoutInformationGenerator.PROVIDER, OptionTypes.OVERRIDE_LAYOUT_INFORMATION); 
	public final static ArtifactDescriptor<GenerationContext, Object> LAYOUT_INFORMATION_ADAPTER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "LayoutInformationAdapter", LayoutInformationAdapterGenerator.PROVIDER, OptionTypes.OVERRIDE_LAYOUT_INFORMATION_ADAPTER);

	public final static ArtifactDescriptor<GenerationContext, Object> NATURE = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Nature", NatureGenerator.PROVIDER, OptionTypes.OVERRIDE_NATURE);
	public final static ArtifactDescriptor<GenerationContext, Object> BUILDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Builder", BuilderGenerator.PROVIDER, OptionTypes.OVERRIDE_BUILDER);
	public final static ArtifactDescriptor<GenerationContext, Object> BUILDER_ADAPTER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "BuilderAdapter", BuilderAdapterGenerator.PROVIDER, OptionTypes.OVERRIDE_BUILDER_ADAPTER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BUILDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Builder", IBuilderGenerator.PROVIDER, OptionTypes.OVERRIDE_IBUILDER);
	
	public final static ArtifactDescriptor<GenerationContext, Object> DEFAULT_TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(Constants.ANALYSIS_PACKAGE, "", "DefaultTokenResolver", DefaultTokenResolverGenerator.PROVIDER, OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> DEFAULT_RESOLVER_DELEGATE = new ArtifactDescriptor<GenerationContext, Object>(Constants.ANALYSIS_PACKAGE, "", "DefaultResolverDelegate", DefaultResolverDelegateGenerator.PROVIDER, OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE); 
	public final static ArtifactDescriptor<GenerationContext, CompleteTokenDefinition> TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, CompleteTokenDefinition>(Constants.ANALYSIS_PACKAGE, "", "", null, OptionTypes.OVERRIDE_TOKEN_RESOLVERS);

	public final static ArtifactDescriptor<GenerationContext, Object> I_INPUT_STREAM_PROCESSOR_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "InputStreamProcessorProvider", IInputStreamProcessorProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> INPUT_STREAM_PROCESSOR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "InputStreamProcessor", InputStreamProcessorGenerator.PROVIDER, OptionTypes.OVERRIDE_INPUT_STREAM_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_OPTION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "OptionProvider", IOptionProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_IOPTION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_OPTIONS = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Options", IOptionsGenerator.PROVIDER, OptionTypes.OVERRIDE_IOPTIONS);
	public final static ArtifactDescriptor<GenerationContext, Object> I_RESOURCE_POST_PROCESSOR = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ResourcePostProcessor", IResourcePostProcessorGenerator.PROVIDER, OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_RESOURCE_POST_PROCESSOR_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ResourcePostProcessorProvider", IResourcePostProcessorProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BACKGROUND_PARSING_LISTENER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "BackgroundParsingListener", IBackgroundParsingListenerGenerator.PROVIDER, OptionTypes.OVERRIDE_IBACKGROUND_PARSING_LISTENER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BRACKET_PAIR = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "BracketPair", IBracketPairGenerator.PROVIDER, OptionTypes.OVERRIDE_IBRACKET_PAIR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_COMMAND = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Command", ICommandGenerator.PROVIDER, OptionTypes.OVERRIDE_ICOMMAND);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONFIGURABLE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Configurable", IConfigurableGenerator.PROVIDER, OptionTypes.OVERRIDE_ICONFIGURABLE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONTEXT_DEPENDENT_URI_FRAGMENT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ContextDependentURIFragment", IContextDependentURIFragmentGenerator.PROVIDER, OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ContextDependentURIFragmentFactory", IContextDependentURIFragmentFactoryGenerator.PROVIDER, OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> I_ELEMENT_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ElementMapping", IElementMappingGenerator.PROVIDER, OptionTypes.OVERRIDE_IELEMENT_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> I_EXPECTED_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ExpectedElement", IExpectedElementGenerator.PROVIDER, OptionTypes.OVERRIDE_IEXPECTED_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "HoverTextProvider", IHoverTextProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_IHOVER_TEXT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_LOCATION_MAP = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "LocationMap", ILocationMapGenerator.PROVIDER, OptionTypes.OVERRIDE_ILOCATION_MAP);
	public final static ArtifactDescriptor<GenerationContext, Object> I_PARSE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ParseResult", IParseResultGenerator.PROVIDER, OptionTypes.OVERRIDE_IPARSE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_PROBLEM = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Problem", IProblemGenerator.PROVIDER, OptionTypes.OVERRIDE_IPROBLEM);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_CACHE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceCache", IReferenceCacheGenerator.PROVIDER, OptionTypes.OVERRIDE_IREFERENCE_CACHE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceMapping", IReferenceMappingGenerator.PROVIDER, OptionTypes.OVERRIDE_IREFERENCE_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceResolver", IReferenceResolverGenerator.PROVIDER, OptionTypes.OVERRIDE_IREFERENCE_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceResolveResult", IReferenceResolveResultGenerator.PROVIDER, OptionTypes.OVERRIDE_IREFERENCE_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVER_SWITCH = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceResolverSwitch", IReferenceResolverSwitchGenerator.PROVIDER, OptionTypes.OVERRIDE_IREFERENCE_RESOLVER_SWITCH);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_DIAGNOSTIC = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextDiagnostic", ITextDiagnosticGenerator.PROVIDER, OptionTypes.OVERRIDE_ITEXT_DIAGNOSTIC);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_PARSER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextParser", ITextParserGenerator.PROVIDER, OptionTypes.OVERRIDE_ITEXT_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_PRINTER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextPrinter", ITextPrinterGenerator.PROVIDER, OptionTypes.OVERRIDE_ITEXT_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_RESOURCE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextResource", ITextResourceGenerator.PROVIDER, OptionTypes.OVERRIDE_ITEXT_RESOURCE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_META_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "MetaInformation", IMetaInformationGenerator.PROVIDER, OptionTypes.OVERRIDE_IMETA_INFORMATION);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_RESOURCE_PLUGIN_PART = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextResourcePluginPart", ITextResourcePluginPartGenerator.PROVIDER, OptionTypes.OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextScanner", ITextScannerGenerator.PROVIDER, OptionTypes.OVERRIDE_ITEXT_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_TOKEN = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextToken", ITextTokenGenerator.PROVIDER, OptionTypes.OVERRIDE_ITEXT_TOKEN);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TokenResolver", ITokenResolverGenerator.PROVIDER, OptionTypes.OVERRIDE_ITOKEN_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TokenResolveResult", ITokenResolveResultGenerator.PROVIDER, OptionTypes.OVERRIDE_ITOKEN_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVER_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TokenResolverFactory", ITokenResolverFactoryGenerator.PROVIDER, OptionTypes.OVERRIDE_ITOKEN_RESOLVER_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_STYLE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TokenStyle", ITokenStyleGenerator.PROVIDER, OptionTypes.OVERRIDE_ITOKEN_STYLE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_URI_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "URIMapping", IURIMappingGenerator.PROVIDER, OptionTypes.OVERRIDE_IURI_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> E_PROBLEM_TYPE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "", "EProblemType", EProblemTypeGenerator.PROVIDER, OptionTypes.OVERRIDE_EPROBLEM_TYPE);
	
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_CS_STRING = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "ExpectedCsString", ExpectedCsStringGenerator.PROVIDER, OptionTypes.OVERRIDE_EXPECTED_CS_STRING);
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_STRUCTURAL_FEATURE = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "ExpectedStructuralFeature", ExpectedStructuralFeatureGenerator.PROVIDER, OptionTypes.OVERRIDE_EXPECTED_STRUCTURAL_FEATURE);
	public final static ArtifactDescriptor<GenerationContext, Object> ABSTRACT_EXPECTED_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "AbstractExpectedElement", AbstractExpectedElementGenerator.PROVIDER, OptionTypes.OVERRIDE_ABSTRACT_EXPECTED_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_TERMINAL = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "ExpectedTerminal", ExpectedTerminalGenerator.PROVIDER, OptionTypes.OVERRIDE_EXPECTED_TERMINAL);
	public final static ArtifactDescriptor<GenerationContext, Object> ATTRIBUTE_VALUE_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "AttributeValueProvider", AttributeValueProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_ATTRIBUTE_VALUE_PROVIDER);

	// the grammar package
	public final static ArtifactDescriptor<GenerationContext, Object> CARDINALITY = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Cardinality", CardinalityGenerator.PROVIDER, OptionTypes.OVERRIDE_CARDINALITY);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "SyntaxElement", SyntaxElementGenerator.PROVIDER, OptionTypes.OVERRIDE_SYNTAX_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> KEYWORD = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Keyword", KeywordGenerator.PROVIDER, OptionTypes.OVERRIDE_KEYWORD);
	public final static ArtifactDescriptor<GenerationContext, Object> TERMINAL = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Terminal", TerminalGenerator.PROVIDER, OptionTypes.OVERRIDE_TERMINAL);
	public final static ArtifactDescriptor<GenerationContext, Object> PLACEHOLDER = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Placeholder", PlaceholderGenerator.PROVIDER, OptionTypes.OVERRIDE_PLACEHOLDER);
	public final static ArtifactDescriptor<GenerationContext, Object> CHOICE = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Choice", ChoiceGenerator.PROVIDER, OptionTypes.OVERRIDE_CHOICE);
	public final static ArtifactDescriptor<GenerationContext, Object> COMPOUND = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Compound", CompoundGenerator.PROVIDER, OptionTypes.OVERRIDE_COMPOUND);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTAINMENT = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Containment", ContainmentGenerator.PROVIDER, OptionTypes.OVERRIDE_CONTAINMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> LINE_BREAK = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "LineBreak", LineBreakGenerator.PROVIDER, OptionTypes.OVERRIDE_LINE_BREAK);
	public final static ArtifactDescriptor<GenerationContext, Object> SEQUENCE = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Sequence", SequenceGenerator.PROVIDER, OptionTypes.OVERRIDE_SEQUENCE);
	public final static ArtifactDescriptor<GenerationContext, Object> WHITE_SPACE = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "WhiteSpace", WhiteSpaceGenerator.PROVIDER, OptionTypes.OVERRIDE_WHITE_SPACE);
	public final static ArtifactDescriptor<GenerationContext, Object> FORMATTING_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "FormattingElement", FormattingElementGenerator.PROVIDER, OptionTypes.OVERRIDE_FORMATTING_ELEMENT);

	public final static ArtifactDescriptor<GenerationContext, Object> GRAMMAR_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "GrammarInformationProvider", GrammarInformationProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_GRAMMAR_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> FOLLOW_SET_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "FollowSetProvider", FollowSetProviderGenerator.PROVIDER, OptionTypes.OVERRIDE_FOLLOW_SET_PROVIDER);
	
	public final static ArtifactDescriptor<GenerationContext, Object> CAST_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "CastUtil", CastUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_CAST_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> COPIED_E_LIST = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "CopiedEList", CopiedEListGenerator.PROVIDER, OptionTypes.OVERRIDE_COPIED_ELIST);
	public final static ArtifactDescriptor<GenerationContext, Object> COPIED_E_OBJECT_INTERNAL_E_LIST = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "CopiedEObjectInternalEList", CopiedEObjectInternalEListGenerator.PROVIDER, OptionTypes.OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST);
	public final static ArtifactDescriptor<GenerationContext, Object> E_CLASS_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "EClassUtil", EClassUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_ECLASS_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> E_OBJECT_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "EObjectUtil", EObjectUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_EOBJECT_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> LIST_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "ListUtil", ListUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_LIST_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> MAP_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "MapUtil", MapUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_MAP_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> PAIR = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "Pair", PairGenerator.PROVIDER, OptionTypes.OVERRIDE_PAIR);
	public final static ArtifactDescriptor<GenerationContext, Object> MINIMAL_MODEL_HELPER = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "MinimalModelHelper", MinimalModelHelperGenerator.PROVIDER, OptionTypes.OVERRIDE_MINIMAL_MODEL_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "ResourceUtil", ResourceUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_RESOURCE_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> STREAM_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "StreamUtil", StreamUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_STREAM_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> STRING_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "StringUtil", StringUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_STRING_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> TEXT_RESOURCE_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "TextResourceUtil", TextResourceUtilGenerator.PROVIDER, OptionTypes.OVERRIDE_TEXT_RESOURCE_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> UNICODE_CONVERTER = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "UnicodeConverter", UnicodeConverterGenerator.PROVIDER, OptionTypes.OVERRIDE_UNICODE_CONVERTER);
	public final static ArtifactDescriptor<GenerationContext, Object> ABSTRACT_INTERPRETER = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "Abstract", "Interpreter", AbstractInterpreterGenerator.PROVIDER, OptionTypes.OVERRIDE_ABSTRACT_INTERPRETER);

	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_GRAMMAR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "ANTLR grammar", "", ANTLRGrammarGenerator.PROVIDER, OptionTypes.OVERRIDE_PARSER); 
	public final static ArtifactDescriptor<GenerationContext, Object> BABYLON_SPECIFICATION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Babylon", BabylonSpecificationGenerator.PROVIDER, OptionTypes.OVERRIDE_PARSER);
	
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_ROOT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_MOPP = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_GRAMMAR = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_ANALYSIS = new ArtifactDescriptor<GenerationContext, Object>(ANALYSIS_PACKAGE, "analysis", "analysis", null, null);      
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_CC = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, Object> PACKAGE_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "", null, null);
	
	public static final ArtifactDescriptor<GenerationContext, Object> ADDITIONAL_EXTENSION_PARSER_EXSD = new ArtifactDescriptor<GenerationContext, Object>(null, AdditionalExtensionParserExtensionPointSchemaCreator.FILENAME, "", null, null);
	public static final ArtifactDescriptor<GenerationContext, Object> DEFAULT_LOAD_OPTIONS_EXSD = new ArtifactDescriptor<GenerationContext, Object>(null, DefaultLoadOptionsExtensionPointSchemaCreator.FILENAME, "", null, null);
	public static final ArtifactDescriptor<GenerationContext, GenFeature> REFERENCE_RESOLVERS = new ArtifactDescriptor<GenerationContext, GenFeature>(null, "reference resolvers", "", null, null);
	public static final ArtifactDescriptor<GenerationContext, CompleteTokenDefinition> TOKEN_RESOLVERS = new ArtifactDescriptor<GenerationContext, CompleteTokenDefinition>(null, "token resolvers", "", null, null);
}
