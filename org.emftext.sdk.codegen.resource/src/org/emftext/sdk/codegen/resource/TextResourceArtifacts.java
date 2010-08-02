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

import static org.emftext.sdk.codegen.Constants.ANALYSIS_PACKAGE;
import static org.emftext.sdk.codegen.Constants.CC_PACKAGE;
import static org.emftext.sdk.codegen.Constants.GRAMMAR_PACKAGE;
import static org.emftext.sdk.codegen.Constants.MOPP_PACKAGE;
import static org.emftext.sdk.codegen.Constants.ROOT_PACKAGE;
import static org.emftext.sdk.codegen.Constants.UTIL_PACKAGE;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.creators.BuildPropertiesCreator;
import org.emftext.sdk.codegen.creators.DotClasspathCreator;
import org.emftext.sdk.codegen.creators.DotProjectCreator;
import org.emftext.sdk.codegen.creators.ManifestCreator;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.codegen.parameters.ClassPathParameters;
import org.emftext.sdk.codegen.parameters.DotProjectParameters;
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
import org.emftext.sdk.codegen.resource.generators.interfaces.IQuickFixGenerator;
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
import org.emftext.sdk.codegen.resource.generators.mopp.MarkerHelperGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.Printer2Generator;
import org.emftext.sdk.codegen.resource.generators.mopp.PrinterGenerator;
import org.emftext.sdk.codegen.resource.generators.mopp.QuickFixGenerator;
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
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A collection of all artifacts that are created for the text resource plug-in
 * (excluding the UI resource artifacts).
 */
public class TextResourceArtifacts {
	
	public final static ArtifactDescriptor<GenerationContext, BuildPropertiesParameters<GenerationContext>> BUILD_PROPERTIES = new ArtifactDescriptor<GenerationContext, BuildPropertiesParameters<GenerationContext>>(null, BuildPropertiesCreator.FILENAME, "", null, OptionTypes.OVERRIDE_BUILD_PROPERTIES); 
	public final static ArtifactDescriptor<GenerationContext, ClassPathParameters<GenerationContext>> DOT_CLASSPATH = new ArtifactDescriptor<GenerationContext, ClassPathParameters<GenerationContext>>(null, DotClasspathCreator.FILENAME, "", null, OptionTypes.OVERRIDE_DOT_CLASSPATH);
	public final static ArtifactDescriptor<GenerationContext, DotProjectParameters<GenerationContext>> DOT_PROJECT = new ArtifactDescriptor<GenerationContext, DotProjectParameters<GenerationContext>>(null, DotProjectCreator.FILENAME, "", null, OptionTypes.OVERRIDE_DOT_PROJECT);

	public static final ArtifactDescriptor<GenerationContext, ManifestParameters<GenerationContext>> MANIFEST = new ArtifactDescriptor<GenerationContext, ManifestParameters<GenerationContext>>(null, ManifestCreator.FILENAME, "", null, null);
	public static final ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PLUGIN_XML = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(null, PluginXMLCreator.FILENAME, "", null, null);

	// the classes
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ANTLR_LEXER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Lexer", null, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ANTLR_SCANNER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "AntlrScanner", ANTLRScannerGenerator.class, OptionTypes.OVERRIDE_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ANTLR_PARSER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Parser", null, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ANTLR_PARSER_BASE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ANTLRParserBase", ANTLRParserBaseGenerator.class, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> CONTEXT_DEPENDENT_URI_FRAGMENT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ContextDependentURIFragment", ContextDependentURIFragmentGenerator.class, OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ContextDependentURIFragmentFactory", ContextDependentURIFragmentFactoryGenerator.class, OptionTypes.OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> DELEGATING_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "DelegatingResolveResult", DelegatingResolveResultGenerator.class, OptionTypes.OVERRIDE_DELEGATING_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> DUMMY_E_OBJECT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "DummyEObject", DummyEObjectGenerator.class, OptionTypes.OVERRIDE_DUMMY_EOBJECT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ELEMENT_MAPPING = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ElementMapping", ElementMappingGenerator.class, OptionTypes.OVERRIDE_ELEMENT_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> FUZZY_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "FuzzyResolveResult", FuzzyResolveResultGenerator.class, OptionTypes.OVERRIDE_FUZZY_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LOCATION_MAP = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "LocationMap", LocationMapGenerator.class, OptionTypes.OVERRIDE_LOCATION_MAP);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> REFERENCE_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ReferenceResolveResult", ReferenceResolveResultGenerator.class, OptionTypes.OVERRIDE_REFERENCE_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TOKEN_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "TokenResolveResult", TokenResolveResultGenerator.class, OptionTypes.OVERRIDE_TOKEN_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> URI_MAPPING = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "URIMapping", URIMappingGenerator.class, OptionTypes.OVERRIDE_URI_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> SCANNERLESS_SCANNER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ScannerlessScanner", ScannerlessScannerGenerator.class, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> SCANNERLESS_PARSER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ScannerlessParser", ScannerlessParserGenerator.class, OptionTypes.OVERRIDE_PARSER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PROBLEM = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Problem", ProblemClassGenerator.class, OptionTypes.OVERRIDE_PROBLEM_CLASS);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> MARKER_HELPER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "MarkerHelper", MarkerHelperGenerator.class, OptionTypes.OVERRIDE_MARKER_HELPER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PRINTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Printer", PrinterGenerator.class, OptionTypes.OVERRIDE_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PRINTER2 = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Printer2", Printer2Generator.class, OptionTypes.OVERRIDE_PRINTER2);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> SYNTAX_ELEMENT_DECORATOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "SyntaxElementDecorator", SyntaxElementDecoratorGenerator.class, OptionTypes.OVERRIDE_SYNTAX_ELEMENT_DECORATOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> RESOURCE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Resource", TextResourceGenerator.class, OptionTypes.OVERRIDE_TEXT_RESOURCE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> RESOURCE_FACTORY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ResourceFactory", ResourceFactoryGenerator.class, OptionTypes.OVERRIDE_RESOURCE_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> RESOURCE_FACTORY_DELEGATOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ResourceFactoryDelegator", ResourceFactoryDelegatorGenerator.class, OptionTypes.OVERRIDE_RESOURCE_FACTORY_DELEGATOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TOKEN_RESOLVER_FACTORY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "TokenResolverFactory", TokenResolverFactoryGenerator.class, OptionTypes.OVERRIDE_TOKEN_RESOLVER_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> REFERENCE_RESOLVER_SWITCH = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ReferenceResolverSwitch", ReferenceResolverSwitchGenerator.class, OptionTypes.OVERRIDE_REFERENCE_RESOLVER_SWITCH);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> META_INFORMATION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "MetaInformation", MetaInformationGenerator.class, OptionTypes.OVERRIDE_META_INFORMATION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> QUICK_FIX = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "QuickFix", QuickFixGenerator.class, OptionTypes.OVERRIDE_QUICK_FIX);
	
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> NEW_FILE_CONTENT_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "NewFileContentProvider", NewFileContentProviderGenerator.class, OptionTypes.OVERRIDE_NEW_FILE_CONTENT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PARSE_RESULT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "ParseResult", ParseResultGenerator.class, OptionTypes.OVERRIDE_PARSE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PLUGIN_ACTIVATOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Plugin", PluginActivatorGenerator.class, OptionTypes.OVERRIDE_PLUGIN_ACTIVATOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TEXT_TOKEN = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "TextToken", TextTokenGenerator.class, OptionTypes.OVERRIDE_TEXT_TOKEN);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TERMINATE_PARSING_EXCEPTION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "TerminateParsingException", TerminateParsingExceptionGenerator.class, OptionTypes.OVERRIDE_TERMINATE_PARSING_EXCEPTION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> UNEXPECTED_CONTENT_TYPE_EXCEPTION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "UnexpectedContentTypeException", UnexpectedContentTypeExceptionGenerator.class, OptionTypes.OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TOKEN_STYLE_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "TokenStyleInformationProvider", TokenStyleInformationProviderGenerator.class, OptionTypes.OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> FOLDING_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "FoldingInformationProvider", FoldingInformationProviderGenerator.class, OptionTypes.OVERRIDE_FOLDING_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> BRACKET_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "BracketInformationProvider", BracketInformationProviderGenerator.class, OptionTypes.OVERRIDE_BRACKET_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> SYNTAX_COVERAGE_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "SyntaxCoverageInformationProvider", SyntaxCoverageInformationProviderGenerator.class, OptionTypes.OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LAYOUT_INFORMATION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "LayoutInformation", LayoutInformationGenerator.class, OptionTypes.OVERRIDE_LAYOUT_INFORMATION); 
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LAYOUT_INFORMATION_ADAPTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "LayoutInformationAdapter", LayoutInformationAdapterGenerator.class, OptionTypes.OVERRIDE_LAYOUT_INFORMATION_ADAPTER);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> NATURE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Nature", NatureGenerator.class, OptionTypes.OVERRIDE_NATURE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> BUILDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Builder", BuilderGenerator.class, OptionTypes.OVERRIDE_BUILDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> BUILDER_ADAPTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "BuilderAdapter", BuilderAdapterGenerator.class, OptionTypes.OVERRIDE_BUILDER_ADAPTER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_BUILDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "Builder", IBuilderGenerator.class, OptionTypes.OVERRIDE_IBUILDER);
	
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> DEFAULT_TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ANALYSIS_PACKAGE, "", "DefaultTokenResolver", DefaultTokenResolverGenerator.class, OptionTypes.OVERRIDE_DEFAULT_TOKEN_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> DEFAULT_RESOLVER_DELEGATE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ANALYSIS_PACKAGE, "", "DefaultResolverDelegate", DefaultResolverDelegateGenerator.class, OptionTypes.OVERRIDE_DEFAULT_RESOLVER_DELEGATE); 
	public final static ArtifactDescriptor<GenerationContext, TokenResolverParameters> TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, TokenResolverParameters>(ANALYSIS_PACKAGE, "", "", null, OptionTypes.OVERRIDE_TOKEN_RESOLVERS);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_INPUT_STREAM_PROCESSOR_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "InputStreamProcessorProvider", IInputStreamProcessorProviderGenerator.class, OptionTypes.OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> INPUT_STREAM_PROCESSOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "InputStreamProcessor", InputStreamProcessorGenerator.class, OptionTypes.OVERRIDE_INPUT_STREAM_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_OPTION_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "OptionProvider", IOptionProviderGenerator.class, OptionTypes.OVERRIDE_IOPTION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_OPTIONS = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "Options", IOptionsGenerator.class, OptionTypes.OVERRIDE_IOPTIONS);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_RESOURCE_POST_PROCESSOR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ResourcePostProcessor", IResourcePostProcessorGenerator.class, OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_RESOURCE_POST_PROCESSOR_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ResourcePostProcessorProvider", IResourcePostProcessorProviderGenerator.class, OptionTypes.OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_BACKGROUND_PARSING_LISTENER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "BackgroundParsingListener", IBackgroundParsingListenerGenerator.class, OptionTypes.OVERRIDE_IBACKGROUND_PARSING_LISTENER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_BRACKET_PAIR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "BracketPair", IBracketPairGenerator.class, OptionTypes.OVERRIDE_IBRACKET_PAIR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_COMMAND = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "Command", ICommandGenerator.class, OptionTypes.OVERRIDE_ICOMMAND);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_CONFIGURABLE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "Configurable", IConfigurableGenerator.class, OptionTypes.OVERRIDE_ICONFIGURABLE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_CONTEXT_DEPENDENT_URI_FRAGMENT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ContextDependentURIFragment", IContextDependentURIFragmentGenerator.class, OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ContextDependentURIFragmentFactory", IContextDependentURIFragmentFactoryGenerator.class, OptionTypes.OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_ELEMENT_MAPPING = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ElementMapping", IElementMappingGenerator.class, OptionTypes.OVERRIDE_IELEMENT_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_EXPECTED_ELEMENT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ExpectedElement", IExpectedElementGenerator.class, OptionTypes.OVERRIDE_IEXPECTED_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_HOVER_TEXT_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "HoverTextProvider", IHoverTextProviderGenerator.class, OptionTypes.OVERRIDE_IHOVER_TEXT_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_LOCATION_MAP = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "LocationMap", ILocationMapGenerator.class, OptionTypes.OVERRIDE_ILOCATION_MAP);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_PARSE_RESULT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ParseResult", IParseResultGenerator.class, OptionTypes.OVERRIDE_IPARSE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_PROBLEM = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "Problem", IProblemGenerator.class, OptionTypes.OVERRIDE_IPROBLEM);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_REFERENCE_CACHE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ReferenceCache", IReferenceCacheGenerator.class, OptionTypes.OVERRIDE_IREFERENCE_CACHE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_REFERENCE_MAPPING = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ReferenceMapping", IReferenceMappingGenerator.class, OptionTypes.OVERRIDE_IREFERENCE_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_REFERENCE_RESOLVER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ReferenceResolver", IReferenceResolverGenerator.class, OptionTypes.OVERRIDE_IREFERENCE_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_REFERENCE_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ReferenceResolveResult", IReferenceResolveResultGenerator.class, OptionTypes.OVERRIDE_IREFERENCE_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_REFERENCE_RESOLVER_SWITCH = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "ReferenceResolverSwitch", IReferenceResolverSwitchGenerator.class, OptionTypes.OVERRIDE_IREFERENCE_RESOLVER_SWITCH);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TEXT_DIAGNOSTIC = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TextDiagnostic", ITextDiagnosticGenerator.class, OptionTypes.OVERRIDE_ITEXT_DIAGNOSTIC);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TEXT_PARSER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TextParser", ITextParserGenerator.class, OptionTypes.OVERRIDE_ITEXT_PARSER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TEXT_PRINTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TextPrinter", ITextPrinterGenerator.class, OptionTypes.OVERRIDE_ITEXT_PRINTER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TEXT_RESOURCE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TextResource", ITextResourceGenerator.class, OptionTypes.OVERRIDE_ITEXT_RESOURCE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_META_INFORMATION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "MetaInformation", IMetaInformationGenerator.class, OptionTypes.OVERRIDE_IMETA_INFORMATION);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TEXT_RESOURCE_PLUGIN_PART = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TextResourcePluginPart", ITextResourcePluginPartGenerator.class, OptionTypes.OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TEXT_SCANNER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TextScanner", ITextScannerGenerator.class, OptionTypes.OVERRIDE_ITEXT_SCANNER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TEXT_TOKEN = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TextToken", ITextTokenGenerator.class, OptionTypes.OVERRIDE_ITEXT_TOKEN);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TOKEN_RESOLVER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TokenResolver", ITokenResolverGenerator.class, OptionTypes.OVERRIDE_ITOKEN_RESOLVER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TOKEN_RESOLVE_RESULT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TokenResolveResult", ITokenResolveResultGenerator.class, OptionTypes.OVERRIDE_ITOKEN_RESOLVE_RESULT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TOKEN_RESOLVER_FACTORY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TokenResolverFactory", ITokenResolverFactoryGenerator.class, OptionTypes.OVERRIDE_ITOKEN_RESOLVER_FACTORY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_TOKEN_STYLE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "TokenStyle", ITokenStyleGenerator.class, OptionTypes.OVERRIDE_ITOKEN_STYLE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_URI_MAPPING = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "URIMapping", IURIMappingGenerator.class, OptionTypes.OVERRIDE_IURI_MAPPING);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> I_QUICK_FIX = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "I", "QuickFix", IQuickFixGenerator.class, OptionTypes.OVERRIDE_IQUICK_FIX);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> E_PROBLEM_TYPE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "", "EProblemType", EProblemTypeGenerator.class, OptionTypes.OVERRIDE_EPROBLEM_TYPE);
	
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> EXPECTED_CS_STRING = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(CC_PACKAGE, "", "ExpectedCsString", ExpectedCsStringGenerator.class, OptionTypes.OVERRIDE_EXPECTED_CS_STRING);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> EXPECTED_STRUCTURAL_FEATURE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(CC_PACKAGE, "", "ExpectedStructuralFeature", ExpectedStructuralFeatureGenerator.class, OptionTypes.OVERRIDE_EXPECTED_STRUCTURAL_FEATURE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ABSTRACT_EXPECTED_ELEMENT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(CC_PACKAGE, "", "AbstractExpectedElement", AbstractExpectedElementGenerator.class, OptionTypes.OVERRIDE_ABSTRACT_EXPECTED_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> EXPECTED_TERMINAL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(CC_PACKAGE, "", "ExpectedTerminal", ExpectedTerminalGenerator.class, OptionTypes.OVERRIDE_EXPECTED_TERMINAL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ATTRIBUTE_VALUE_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(CC_PACKAGE, "", "AttributeValueProvider", AttributeValueProviderGenerator.class, OptionTypes.OVERRIDE_ATTRIBUTE_VALUE_PROVIDER);

	// the grammar package
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> CARDINALITY = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "Cardinality", CardinalityGenerator.class, OptionTypes.OVERRIDE_CARDINALITY);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> SYNTAX_ELEMENT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "SyntaxElement", SyntaxElementGenerator.class, OptionTypes.OVERRIDE_SYNTAX_ELEMENT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> KEYWORD = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "Keyword", KeywordGenerator.class, OptionTypes.OVERRIDE_KEYWORD);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TERMINAL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "Terminal", TerminalGenerator.class, OptionTypes.OVERRIDE_TERMINAL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PLACEHOLDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "Placeholder", PlaceholderGenerator.class, OptionTypes.OVERRIDE_PLACEHOLDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> CHOICE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "Choice", ChoiceGenerator.class, OptionTypes.OVERRIDE_CHOICE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> COMPOUND = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "Compound", CompoundGenerator.class, OptionTypes.OVERRIDE_COMPOUND);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> CONTAINMENT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "Containment", ContainmentGenerator.class, OptionTypes.OVERRIDE_CONTAINMENT);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LINE_BREAK = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "LineBreak", LineBreakGenerator.class, OptionTypes.OVERRIDE_LINE_BREAK);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> SEQUENCE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "Sequence", SequenceGenerator.class, OptionTypes.OVERRIDE_SEQUENCE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> WHITE_SPACE = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "WhiteSpace", WhiteSpaceGenerator.class, OptionTypes.OVERRIDE_WHITE_SPACE);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> FORMATTING_ELEMENT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "FormattingElement", FormattingElementGenerator.class, OptionTypes.OVERRIDE_FORMATTING_ELEMENT);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> GRAMMAR_INFORMATION_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "GrammarInformationProvider", GrammarInformationProviderGenerator.class, OptionTypes.OVERRIDE_GRAMMAR_INFORMATION_PROVIDER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> FOLLOW_SET_PROVIDER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "FollowSetProvider", FollowSetProviderGenerator.class, OptionTypes.OVERRIDE_FOLLOW_SET_PROVIDER);
	
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> CAST_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "CastUtil", CastUtilGenerator.class, OptionTypes.OVERRIDE_CAST_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> COPIED_E_LIST = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "CopiedEList", CopiedEListGenerator.class, OptionTypes.OVERRIDE_COPIED_ELIST);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> COPIED_E_OBJECT_INTERNAL_E_LIST = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "CopiedEObjectInternalEList", CopiedEObjectInternalEListGenerator.class, OptionTypes.OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> E_CLASS_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "EClassUtil", EClassUtilGenerator.class, OptionTypes.OVERRIDE_ECLASS_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> E_OBJECT_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "EObjectUtil", EObjectUtilGenerator.class, OptionTypes.OVERRIDE_EOBJECT_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> LIST_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "ListUtil", ListUtilGenerator.class, OptionTypes.OVERRIDE_LIST_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> MAP_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "MapUtil", MapUtilGenerator.class, OptionTypes.OVERRIDE_MAP_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PAIR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "Pair", PairGenerator.class, OptionTypes.OVERRIDE_PAIR);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> MINIMAL_MODEL_HELPER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "MinimalModelHelper", MinimalModelHelperGenerator.class, OptionTypes.OVERRIDE_MINIMAL_MODEL_HELPER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> RESOURCE_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "ResourceUtil", ResourceUtilGenerator.class, OptionTypes.OVERRIDE_RESOURCE_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> STREAM_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "StreamUtil", StreamUtilGenerator.class, OptionTypes.OVERRIDE_STREAM_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> STRING_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "StringUtil", StringUtilGenerator.class, OptionTypes.OVERRIDE_STRING_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> TEXT_RESOURCE_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "TextResourceUtil", TextResourceUtilGenerator.class, OptionTypes.OVERRIDE_TEXT_RESOURCE_UTIL);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> UNICODE_CONVERTER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "UnicodeConverter", UnicodeConverterGenerator.class, OptionTypes.OVERRIDE_UNICODE_CONVERTER);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ABSTRACT_INTERPRETER = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "Abstract", "Interpreter", AbstractInterpreterGenerator.class, OptionTypes.OVERRIDE_ABSTRACT_INTERPRETER);

	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ANTLR_GRAMMAR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "ANTLR grammar", "", ANTLRGrammarGenerator.class, OptionTypes.OVERRIDE_PARSER); 
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> BABYLON_SPECIFICATION = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "Babylon", BabylonSpecificationGenerator.class, OptionTypes.OVERRIDE_PARSER);
	
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PACKAGE_ROOT = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ROOT_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PACKAGE_MOPP = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PACKAGE_GRAMMAR = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(GRAMMAR_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PACKAGE_ANALYSIS = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(ANALYSIS_PACKAGE, "analysis", "analysis", null, null);      
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PACKAGE_CC = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(MOPP_PACKAGE, "", "", null, null);
	public final static ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> PACKAGE_UTIL = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(UTIL_PACKAGE, "", "", null, null);
	
	public static final ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> ADDITIONAL_EXTENSION_PARSER_EXSD = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(null, AdditionalExtensionParserExtensionPointSchemaCreator.FILENAME, "", null, null);
	public static final ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> DEFAULT_LOAD_OPTIONS_EXSD = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(null, DefaultLoadOptionsExtensionPointSchemaCreator.FILENAME, "", null, null);
	public static final ArtifactDescriptor<GenerationContext, ReferenceResolverParameters> REFERENCE_RESOLVER = new ArtifactDescriptor<GenerationContext, ReferenceResolverParameters>(null, "reference resolvers", "", null, null);
	public static final ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>> REFERENCE_RESOLVERS = new ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext>>(null, "reference resolvers", "", null, null);
	public static final ArtifactDescriptor<GenerationContext, TokenResolverParameters> TOKEN_RESOLVERS = new ArtifactDescriptor<GenerationContext, TokenResolverParameters>(null, "token resolvers", "", null, null);
	
	public static final ArtifactDescriptor<GenerationContext, ClassParameters> EMPTY_CLASS = new ArtifactDescriptor<GenerationContext, ClassParameters>(null, "empty ", "", null, null);
}
