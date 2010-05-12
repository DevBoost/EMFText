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
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "AntlrScanner", new ANTLRScannerGenerator(), OptionTypes.OVERRIDE_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_PARSER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Parser", null, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_PARSER_BASE = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ANTLRParserBase", new ANTLRParserBaseGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTEXT_DEPENDENT_URI_FRAGMENT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ContextDependentURIFragment", new ContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ContextDependentURIFragmentFactory", new ContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> DELEGATING_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "DelegatingResolveResult", new DelegatingResolveResultGenerator(), OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> DUMMY_E_OBJECT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "DummyEObject", new DummyEObjectGenerator(), OptionTypes.OVERRIDE_DUMMY_EOBJECT);
	public final static ArtifactDescriptor<GenerationContext, Object> ELEMENT_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ElementMapping", new ElementMappingGenerator(), OptionTypes.OVERRIDE_ELEMENT_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> FUZZY_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "FuzzyResolveResult", new FuzzyResolveResultGenerator(), OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> LOCATION_MAP = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "LocationMap", new LocationMapGenerator(), OptionTypes.OVERRIDE_LOCATION_MAP);
	public final static ArtifactDescriptor<GenerationContext, Object> REFERENCE_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ReferenceResolveResult", new ReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TokenResolveResult", new TokenResolveResultGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> URI_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "URIMapping", new URIMappingGenerator(), OptionTypes.OVERRIDE_URI_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> SCANNERLESS_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ScannerlessScanner", new ScannerlessScannerGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> SCANNERLESS_PARSER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ScannerlessParser", new ScannerlessParserGenerator(), OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> PROBLEM = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Problem", new ProblemClassGenerator(), OptionTypes.OVERRIDE_PROBLEM_CLASS);
	public final static ArtifactDescriptor<GenerationContext, Object> PRINTER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Printer", new PrinterGenerator(), OptionTypes.OVERRIDE_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, Object> PRINTER2 = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Printer2", new Printer2Generator(), OptionTypes.OVERRIDE_PRINTER2);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_ELEMENT_DECORATOR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "SyntaxElementDecorator", new SyntaxElementDecoratorGenerator(), OptionTypes.OVERRIDE_SYNTAX_ELEMENT_DECORATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Resource", new TextResourceGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ResourceFactory", new ResourceFactoryGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_FACTORY_DELEGATOR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ResourceFactoryDelegator", new ResourceFactoryDelegatorGenerator(), OptionTypes.OVERRIDE_RESOURCE_FACTORY_DELEGATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_RESOLVER_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TokenResolverFactory", new TokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> REFERENCE_RESOLVER_SWITCH = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ReferenceResolverSwitch", new ReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH);
	public final static ArtifactDescriptor<GenerationContext, Object> META_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "MetaInformation", new MetaInformationGenerator(), OptionTypes.OVERRIDE_META_INFORMATION);
	
	public final static ArtifactDescriptor<GenerationContext, Object> NEW_FILE_CONTENT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "NewFileContentProvider", new NewFileContentProviderGenerator(), OptionTypes.OVERRIDE_NEW_FILE_CONTENT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> PARSE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "ParseResult", new ParseResultGenerator(), OptionTypes.OVERRIDE_PARSE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> PLUGIN_ACTIVATOR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Plugin", new PluginActivatorGenerator(), OptionTypes.OVERRIDE_PLUGIN_ACTIVATOR);
	public final static ArtifactDescriptor<GenerationContext, Object> TEXT_TOKEN = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TextToken", new TextTokenGenerator(), OptionTypes.OVERRIDE_TEXT_TOKEN);
	public final static ArtifactDescriptor<GenerationContext, Object> TERMINATE_PARSING_EXCEPTION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TerminateParsingException", new TerminateParsingExceptionGenerator(), OptionTypes.OVERRIDE_TERMINATE_PARSING_EXCEPTION);
	public final static ArtifactDescriptor<GenerationContext, Object> UNEXPECTED_CONTENT_TYPE_EXCEPTION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "UnexpectedContentTypeException", new UnexpectedContentTypeExceptionGenerator(), OptionTypes.OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	public final static ArtifactDescriptor<GenerationContext, Object> TOKEN_STYLE_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "TokenStyleInformationProvider", new TokenStyleInformationProviderGenerator(), OptionTypes.OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> FOLDING_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "FoldingInformationProvider", new FoldingInformationProviderGenerator(), OptionTypes.OVERRIDE_FOLDING_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> BRACKET_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "BracketInformationProvider", new BracketInformationProviderGenerator(), OptionTypes.OVERRIDE_BRACKET_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_COVERAGE_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "SyntaxCoverageInformationProvider", new SyntaxCoverageInformationProviderGenerator(), OptionTypes.OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> LAYOUT_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "LayoutInformation", new LayoutInformationGenerator(), OptionTypes.OVERRIDE_LAYOUT_INFORMATION); 
	public final static ArtifactDescriptor<GenerationContext, Object> LAYOUT_INFORMATION_ADAPTER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "LayoutInformationAdapter", new LayoutInformationAdapterGenerator(), OptionTypes.OVERRIDE_LAYOUT_INFORMATION_ADAPTER);

	public final static ArtifactDescriptor<GenerationContext, Object> NATURE = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Nature", new NatureGenerator(), OptionTypes.OVERRIDE_NATURE);
	public final static ArtifactDescriptor<GenerationContext, Object> BUILDER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Builder", new BuilderGenerator(), OptionTypes.OVERRIDE_BUILDER);
	public final static ArtifactDescriptor<GenerationContext, Object> BUILDER_ADAPTER = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "BuilderAdapter", new BuilderAdapterGenerator(), OptionTypes.OVERRIDE_BUILDER_ADAPTER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BUILDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Builder", new IBuilderGenerator(), OptionTypes.OVERRIDE_IBUILDER);
	
	public final static ArtifactDescriptor<GenerationContext, Object> DEFAULT_TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(Constants.ANALYSIS_PACKAGE, "", "DefaultTokenResolver", new DefaultTokenResolverGenerator(), OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> DEFAULT_RESOLVER_DELEGATE = new ArtifactDescriptor<GenerationContext, Object>(Constants.ANALYSIS_PACKAGE, "", "DefaultResolverDelegate", new DefaultResolverDelegateGenerator(), OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE); 
	public final static ArtifactDescriptor<GenerationContext, CompleteTokenDefinition> TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, CompleteTokenDefinition>(Constants.ANALYSIS_PACKAGE, "", "", null, OptionTypes.OVERRIDE_TOKEN_RESOLVERS);

	public final static ArtifactDescriptor<GenerationContext, Object> I_INPUT_STREAM_PROCESSOR_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "InputStreamProcessorProvider", new IInputStreamProcessorProviderGenerator(), OptionTypes.OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> INPUT_STREAM_PROCESSOR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "InputStreamProcessor", new InputStreamProcessorGenerator(), OptionTypes.OVERRIDE_INPUT_STREAM_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_OPTION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "OptionProvider", new IOptionProviderGenerator(), OptionTypes.OVERRIDE_IOPTION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_OPTIONS = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Options", new IOptionsGenerator(), OptionTypes.OVERRIDE_IOPTIONS);
	public final static ArtifactDescriptor<GenerationContext, Object> I_RESOURCE_POST_PROCESSOR = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ResourcePostProcessor", new IResourcePostProcessorGenerator(), OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_RESOURCE_POST_PROCESSOR_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ResourcePostProcessorProvider", new IResourcePostProcessorProviderGenerator(), OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BACKGROUND_PARSING_LISTENER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "BackgroundParsingListener", new IBackgroundParsingListenerGenerator(), OptionTypes.OVERRIDE_IBACKGROUND_PARSING_LISTENER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_BRACKET_PAIR = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "BracketPair", new IBracketPairGenerator(), OptionTypes.OVERRIDE_IBRACKET_PAIR);
	public final static ArtifactDescriptor<GenerationContext, Object> I_COMMAND = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Command", new ICommandGenerator(), OptionTypes.OVERRIDE_ICOMMAND);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONFIGURABLE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Configurable", new IConfigurableGenerator(), OptionTypes.OVERRIDE_ICONFIGURABLE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONTEXT_DEPENDENT_URI_FRAGMENT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ContextDependentURIFragment", new IContextDependentURIFragmentGenerator(), OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ContextDependentURIFragmentFactory", new IContextDependentURIFragmentFactoryGenerator(), OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> I_ELEMENT_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ElementMapping", new IElementMappingGenerator(), OptionTypes.OVERRIDE_IELEMENT_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> I_EXPECTED_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ExpectedElement", new IExpectedElementGenerator(), OptionTypes.OVERRIDE_IEXPECTED_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "HoverTextProvider", new IHoverTextProviderGenerator(), OptionTypes.OVERRIDE_IHOVER_TEXT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_LOCATION_MAP = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "LocationMap", new ILocationMapGenerator(), OptionTypes.OVERRIDE_ILOCATION_MAP);
	public final static ArtifactDescriptor<GenerationContext, Object> I_PARSE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ParseResult", new IParseResultGenerator(), OptionTypes.OVERRIDE_IPARSE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_PROBLEM = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "Problem", new IProblemGenerator(), OptionTypes.OVERRIDE_IPROBLEM);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_CACHE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceCache", new IReferenceCacheGenerator(), OptionTypes.OVERRIDE_IREFERENCE_CACHE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceMapping", new IReferenceMappingGenerator(), OptionTypes.OVERRIDE_IREFERENCE_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceResolver", new IReferenceResolverGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceResolveResult", new IReferenceResolveResultGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_REFERENCE_RESOLVER_SWITCH = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "ReferenceResolverSwitch", new IReferenceResolverSwitchGenerator(), OptionTypes.OVERRIDE_IREFERENCE_RESOLVER_SWITCH);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_DIAGNOSTIC = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextDiagnostic", new ITextDiagnosticGenerator(), OptionTypes.OVERRIDE_ITEXT_DIAGNOSTIC);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_PARSER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextParser", new ITextParserGenerator(), OptionTypes.OVERRIDE_ITEXT_PARSER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_PRINTER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextPrinter", new ITextPrinterGenerator(), OptionTypes.OVERRIDE_ITEXT_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_RESOURCE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextResource", new ITextResourceGenerator(), OptionTypes.OVERRIDE_ITEXT_RESOURCE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_META_INFORMATION = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "MetaInformation", new IMetaInformationGenerator(), OptionTypes.OVERRIDE_IMETA_INFORMATION);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_RESOURCE_PLUGIN_PART = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextResourcePluginPart", new ITextResourcePluginPartGenerator(), OptionTypes.OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_SCANNER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextScanner", new ITextScannerGenerator(), OptionTypes.OVERRIDE_ITEXT_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TEXT_TOKEN = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TextToken", new ITextTokenGenerator(), OptionTypes.OVERRIDE_ITEXT_TOKEN);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TokenResolver", new ITokenResolverGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TokenResolveResult", new ITokenResolveResultGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_RESOLVER_FACTORY = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TokenResolverFactory", new ITokenResolverFactoryGenerator(), OptionTypes.OVERRIDE_ITOKEN_RESOLVER_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, Object> I_TOKEN_STYLE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "TokenStyle", new ITokenStyleGenerator(), OptionTypes.OVERRIDE_ITOKEN_STYLE);
	public final static ArtifactDescriptor<GenerationContext, Object> I_URI_MAPPING = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "I", "URIMapping", new IURIMappingGenerator(), OptionTypes.OVERRIDE_IURI_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, Object> E_PROBLEM_TYPE = new ArtifactDescriptor<GenerationContext, Object>(ROOT_PACKAGE, "", "EProblemType", new EProblemTypeGenerator(), OptionTypes.OVERRIDE_EPROBLEM_TYPE);
	
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_CS_STRING = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "ExpectedCsString", new ExpectedCsStringGenerator(), OptionTypes.OVERRIDE_EXPECTED_CS_STRING);
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_STRUCTURAL_FEATURE = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "ExpectedStructuralFeature", new ExpectedStructuralFeatureGenerator(), OptionTypes.OVERRIDE_EXPECTED_STRUCTURAL_FEATURE);
	public final static ArtifactDescriptor<GenerationContext, Object> ABSTRACT_EXPECTED_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "AbstractExpectedElement", new AbstractExpectedElementGenerator(), OptionTypes.OVERRIDE_ABSTRACT_EXPECTED_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> EXPECTED_TERMINAL = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "ExpectedTerminal", new ExpectedTerminalGenerator(), OptionTypes.OVERRIDE_EXPECTED_TERMINAL);
	public final static ArtifactDescriptor<GenerationContext, Object> ATTRIBUTE_VALUE_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(CC_PACKAGE, "", "AttributeValueProvider", new AttributeValueProviderGenerator(), OptionTypes.OVERRIDE_ATTRIBUTE_VALUE_PROVIDER);

	// the grammar package
	public final static ArtifactDescriptor<GenerationContext, Object> CARDINALITY = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Cardinality", new CardinalityGenerator(), OptionTypes.OVERRIDE_CARDINALITY);
	public final static ArtifactDescriptor<GenerationContext, Object> SYNTAX_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "SyntaxElement", new SyntaxElementGenerator(), OptionTypes.OVERRIDE_SYNTAX_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> KEYWORD = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Keyword", new KeywordGenerator(), OptionTypes.OVERRIDE_KEYWORD);
	public final static ArtifactDescriptor<GenerationContext, Object> TERMINAL = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Terminal", new TerminalGenerator(), OptionTypes.OVERRIDE_TERMINAL);
	public final static ArtifactDescriptor<GenerationContext, Object> PLACEHOLDER = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Placeholder", new PlaceholderGenerator(), OptionTypes.OVERRIDE_PLACEHOLDER);
	public final static ArtifactDescriptor<GenerationContext, Object> CHOICE = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Choice", new ChoiceGenerator(), OptionTypes.OVERRIDE_CHOICE);
	public final static ArtifactDescriptor<GenerationContext, Object> COMPOUND = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Compound", new CompoundGenerator(), OptionTypes.OVERRIDE_COMPOUND);
	public final static ArtifactDescriptor<GenerationContext, Object> CONTAINMENT = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Containment", new ContainmentGenerator(), OptionTypes.OVERRIDE_CONTAINMENT);
	public final static ArtifactDescriptor<GenerationContext, Object> LINE_BREAK = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "LineBreak", new LineBreakGenerator(), OptionTypes.OVERRIDE_LINE_BREAK);
	public final static ArtifactDescriptor<GenerationContext, Object> SEQUENCE = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "Sequence", new SequenceGenerator(), OptionTypes.OVERRIDE_SEQUENCE);
	public final static ArtifactDescriptor<GenerationContext, Object> WHITE_SPACE = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "WhiteSpace", new WhiteSpaceGenerator(), OptionTypes.OVERRIDE_WHITE_SPACE);
	public final static ArtifactDescriptor<GenerationContext, Object> FORMATTING_ELEMENT = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "FormattingElement", new FormattingElementGenerator(), OptionTypes.OVERRIDE_FORMATTING_ELEMENT);

	public final static ArtifactDescriptor<GenerationContext, Object> GRAMMAR_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "GrammarInformationProvider", new GrammarInformationProviderGenerator(), OptionTypes.OVERRIDE_GRAMMAR_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, Object> FOLLOW_SET_PROVIDER = new ArtifactDescriptor<GenerationContext, Object>(GRAMMAR_PACKAGE, "", "FollowSetProvider", new FollowSetProviderGenerator(), OptionTypes.OVERRIDE_FOLLOW_SET_PROVIDER);
	
	public final static ArtifactDescriptor<GenerationContext, Object> CAST_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "CastUtil", new CastUtilGenerator(), OptionTypes.OVERRIDE_CAST_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> COPIED_E_LIST = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "CopiedEList", new CopiedEListGenerator(), OptionTypes.OVERRIDE_COPIED_ELIST);
	public final static ArtifactDescriptor<GenerationContext, Object> COPIED_E_OBJECT_INTERNAL_E_LIST = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "CopiedEObjectInternalEList", new CopiedEObjectInternalEListGenerator(), OptionTypes.OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST);
	public final static ArtifactDescriptor<GenerationContext, Object> E_CLASS_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "EClassUtil", new EClassUtilGenerator(), OptionTypes.OVERRIDE_ECLASS_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> E_OBJECT_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "EObjectUtil", new EObjectUtilGenerator(), OptionTypes.OVERRIDE_EOBJECT_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> LIST_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "ListUtil", new ListUtilGenerator(), OptionTypes.OVERRIDE_LIST_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> MAP_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "MapUtil", new MapUtilGenerator(), OptionTypes.OVERRIDE_MAP_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> PAIR = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "Pair", new PairGenerator(), OptionTypes.OVERRIDE_PAIR);
	public final static ArtifactDescriptor<GenerationContext, Object> MINIMAL_MODEL_HELPER = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "MinimalModelHelper", new MinimalModelHelperGenerator(), OptionTypes.OVERRIDE_MINIMAL_MODEL_HELPER);
	public final static ArtifactDescriptor<GenerationContext, Object> RESOURCE_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "ResourceUtil", new ResourceUtilGenerator(), OptionTypes.OVERRIDE_RESOURCE_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> STREAM_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "StreamUtil", new StreamUtilGenerator(), OptionTypes.OVERRIDE_STREAM_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> STRING_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "StringUtil", new StringUtilGenerator(), OptionTypes.OVERRIDE_STRING_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> TEXT_RESOURCE_UTIL = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "TextResourceUtil", new TextResourceUtilGenerator(), OptionTypes.OVERRIDE_TEXT_RESOURCE_UTIL);
	public final static ArtifactDescriptor<GenerationContext, Object> UNICODE_CONVERTER = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "", "UnicodeConverter", new UnicodeConverterGenerator(), OptionTypes.OVERRIDE_UNICODE_CONVERTER);
	public final static ArtifactDescriptor<GenerationContext, Object> ABSTRACT_INTERPRETER = new ArtifactDescriptor<GenerationContext, Object>(UTIL_PACKAGE, "Abstract", "Interpreter", new AbstractInterpreterGenerator(), OptionTypes.OVERRIDE_ABSTRACT_INTERPRETER);

	public final static ArtifactDescriptor<GenerationContext, Object> ANTLR_GRAMMAR = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "ANTLR grammar", "", new ANTLRGrammarGenerator(), OptionTypes.OVERRIDE_PARSER); 
	public final static ArtifactDescriptor<GenerationContext, Object> BABYLON_SPECIFICATION = new ArtifactDescriptor<GenerationContext, Object>(MOPP_PACKAGE, "", "Babylon", new BabylonSpecificationGenerator(), OptionTypes.OVERRIDE_PARSER);
	
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
