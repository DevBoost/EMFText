/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.concretesyntax.OptionTypes;

public abstract class ResourceBaseGenerator<ParameterType extends IArtifactParameter<GenerationContext, ParameterType>> extends BaseGenerator<GenerationContext, ParameterType> {

	private String resourceClassName;
	private String resourcePackageName;
	
	protected String abstractDebuggableClassName;
	protected String abstractExpectedElementClassName;
	protected String abstractInterpreterClassName;
	protected String antlrGrammarClassName;
	protected String antlrLexerClassName;
	protected String antlrParserBaseClassName;
	protected String antlrParserClassName;
	protected String antlrScannerClassName;
	protected String antlrTokenHelperClassName;
	protected String attributeValueProviderClassName;
	protected String babylonSpecificationClassName;
	protected String booleanTerminalClassName;
	protected String bracketInformationProviderClassName;
	protected String buildPropertiesClassName;
	protected String builderAdapterClassName;
	protected String builderClassName;
	protected String cardinalityClassName;
	protected String castUtilClassName;
	protected String changeReferenceQuickFixClassName;
	protected String choiceClassName;
	protected String compoundClassName;
	protected String containedFeatureClassName;
	protected String containmentClassName;
	protected String containmentTraceClassName;
	protected String contextDependentUriFragmentClassName;
	protected String contextDependentUriFragmentFactoryClassName;
	protected String copiedEListClassName;
	protected String copiedEObjectInternalEListClassName;
	protected String debugCommunicationHelperClassName;
	protected String debugElementClassName;
	protected String debugMessageClassName;
	protected String debugProcessClassName;
	protected String debugProxyClassName;
	protected String debugTargetClassName;
	protected String debugThreadClassName;
	protected String debugValueClassName;
	protected String debugVariableClassName;
	protected String debuggableInterpreterClassName;
	protected String debuggerListenerClassName;
	protected String defaultNameProviderClassName;
	protected String defaultResolverDelegateClassName;
	protected String defaultTokenResolverClassName;
	protected String delegatingResolveResultClassName;
	protected String dotClasspathClassName;
	protected String dotProjectClassName;
	protected String dummyEObjectClassName;
	protected String dynamicTokenStyleClassName;
	protected String eclipseProxyClassName;
	protected String eClassUtilClassName;
	protected String eDebugMessageTypesClassName;
	protected String eObjectUtilClassName;
	protected String eProblemSeverityClassName;
	protected String eProblemTypeClassName;
	protected String elementMappingClassName;
	protected String enumerationTerminalClassName;
	protected String expectationConstantsClassName;
	protected String expectedBooleanTerminalClassName;
	protected String expectedCsStringClassName;
	protected String expectedEnumerationTerminalClassName;
	protected String expectedStructuralFeatureClassName;
	protected String expectedTerminalClassName;
	protected String foldingInformationProviderClassName;
	protected String followSetProviderClassName;
	protected String formattingElementClassName;
	protected String fuzzyResolveResultClassName;
	protected String grammarInformationProviderClassName;
	protected String iBackgroundParsingListenerClassName;
	protected String iBracketPairClassName;
	protected String iBuilderClassName;
	protected String iCommandClassName;
	protected String iConfigurableClassName;
	protected String iContextDependentUriFragmentClassName;
	protected String iContextDependentUriFragmentFactoryClassName;
	protected String iDebugEventListenerClassName;
	protected String iElementMappingClassName;
	protected String iExpectedElementClassName;
	protected String iHoverTextProviderClassName;
	protected String iInputStreamProcessorProviderClassName;
	protected String iInterpreterListenerClassName;
	protected String iLocationMapClassName;
	protected String iMetaInformationClassName;
	protected String iNameProviderClassName;
	protected String iOptionProviderClassName;
	protected String iOptionsClassName;
	protected String iParseResultClassName;
	protected String iProblemClassName;
	protected String iQuickFixClassName;
	protected String iReferenceCacheClassName;
	protected String iReferenceMappingClassName;
	protected String iReferenceResolveResultClassName;
	protected String iReferenceResolverClassName;
	protected String iDelegatingReferenceResolverClassName;
	protected String iReferenceResolverSwitchClassName;
	protected String iResourcePostProcessorClassName;
	protected String iResourcePostProcessorProviderClassName;
	protected String iResourceProviderClassName;
	protected String iTextDiagnosticClassName;
	protected String iTextParserClassName;
	protected String iTextPrinterClassName;
	protected String iTextResourceClassName;
	protected String iTextResourcePluginPartClassName;
	protected String iTextScannerClassName;
	protected String iTextTokenClassName;
	protected String iTokenResolveResultClassName;
	protected String iTokenResolverClassName;
	protected String iTokenResolverFactoryClassName;
	protected String iTokenStyleClassName;
	protected String iUriMappingClassName;
	protected String inputStreamProcessorClassName;
	protected String keywordClassName;
	protected String launchConfigurationDelegateClassName;
	protected String launchConfigurationHelperClassName;
	protected String layoutInformationAdapterClassName;
	protected String layoutInformationClassName;
	protected String lineBreakClassName;
	protected String lineBreakpointClassName;
	protected String layoutUtilClassName;
	protected String listUtilClassName;
	protected String locationMapClassName;
	protected String devNullLocationMapClassName;
	protected String mapUtilClassName;
	protected String markerHelperClassName;
	protected String metaInformationClassName;
	protected String minimalModelHelperClassName;
	protected String natureClassName;
	protected String newFileContentProviderClassName;
	protected String optionProviderClassName;
	protected String pairClassName;
	protected String parseResultClassName;
	protected String placeholderClassName;
	protected String pluginActivatorClassName;
	protected String printer2ClassName;
	protected String printerClassName;
	protected String problemClassName;
	protected String quickFixClassName;
	protected String referenceCacheClassName;
	protected String referenceResolveResultClassName;
	protected String referenceResolverSwitchClassName;
	protected String resourceFactoryClassName;
	protected String resourceFactoryDelegatorClassName;
	protected String resourcePostProcessorClassName;
	protected String resourceUtilClassName;
	protected String ruleClassName;
	protected String runtimeUtilClassName;
	protected String scannerlessParserClassName;
	protected String scannerlessScannerClassName;
	protected String sequenceClassName;
	protected String sourceLocatorClassName;
	protected String sourceLookupParticipantClassName;
	protected String sourcePathComputerDelegateClassName;
	protected String stackFrameClassName;
	protected String streamUtilClassName;
	protected String stringUtilClassName;
	protected String syntaxCoverageInformationProviderClassName;
	protected String syntaxElementClassName;
	protected String syntaxElementDecoratorClassName;
	protected String terminalClassName;
	protected String terminateParsingExceptionClassName;
	protected String textResourceClassName;
	protected String textResourceUtilClassName;
	protected String textTokenClassName;
	protected String tokenResolveResultClassName;
	protected String tokenResolverClassName;
	protected String tokenResolverFactoryClassName;
	protected String tokenStyleClassName;
	protected String tokenStyleInformationProviderClassName;
	protected String unexpectedContentTypeExceptionClassName;
	protected String unicodeConverterClassName;
	protected String uriMappingClassName;
	protected String whiteSpaceClassName;
	
	protected String iFunction1ClassName;
	protected String taskItemClassName;
	protected String taskItemDetectorClassName;
	protected String taskItemBuilderClassName;
	protected String uriUtilClassName;
	protected String antlrTextTokenClassName;
	
	protected void initilizeClassNames() {
		GenerationContext context = getContext();
		abstractDebuggableClassName = context.getQualifiedClassName(TextResourceArtifacts.ABSTRACT_DEBUGGABLE);
		abstractExpectedElementClassName = context.getQualifiedClassName(TextResourceArtifacts.ABSTRACT_EXPECTED_ELEMENT);
		abstractInterpreterClassName = context.getQualifiedClassName(TextResourceArtifacts.ABSTRACT_INTERPRETER);
		antlrGrammarClassName = context.getQualifiedClassName(TextResourceArtifacts.ANTLR_GRAMMAR);
		antlrLexerClassName = context.getQualifiedClassName(TextResourceArtifacts.ANTLR_LEXER);
		antlrParserBaseClassName = context.getQualifiedClassName(TextResourceArtifacts.ANTLR_PARSER_BASE);
		antlrParserClassName = context.getQualifiedClassName(TextResourceArtifacts.ANTLR_PARSER);
		antlrScannerClassName = context.getQualifiedClassName(TextResourceArtifacts.ANTLR_SCANNER);
		antlrTokenHelperClassName = context.getQualifiedClassName(TextResourceArtifacts.ANTLR_TOKEN_HELPER);
		attributeValueProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.ATTRIBUTE_VALUE_PROVIDER);
		booleanTerminalClassName = context.getQualifiedClassName(TextResourceArtifacts.BOOLEAN_TERMINAL);
		bracketInformationProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.BRACKET_INFORMATION_PROVIDER);
		buildPropertiesClassName = context.getQualifiedClassName(TextResourceArtifacts.BUILD_PROPERTIES);
		builderAdapterClassName = context.getQualifiedClassName(TextResourceArtifacts.BUILDER_ADAPTER);
		builderClassName = context.getQualifiedClassName(TextResourceArtifacts.BUILDER);
		cardinalityClassName = context.getQualifiedClassName(TextResourceArtifacts.CARDINALITY);
		castUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.CAST_UTIL);
		changeReferenceQuickFixClassName = context.getQualifiedClassName(TextResourceArtifacts.CHANGE_REFERENCE_QUICK_FIX);
		choiceClassName = context.getQualifiedClassName(TextResourceArtifacts.CHOICE);
		compoundClassName = context.getQualifiedClassName(TextResourceArtifacts.COMPOUND);
		containedFeatureClassName = context.getQualifiedClassName(TextResourceArtifacts.CONTAINED_FEATURE);
		containmentClassName = context.getQualifiedClassName(TextResourceArtifacts.CONTAINMENT);
		containmentTraceClassName = context.getQualifiedClassName(TextResourceArtifacts.CONTAINMENT_TRACE);
		contextDependentUriFragmentClassName = context.getQualifiedClassName(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT);
		contextDependentUriFragmentFactoryClassName = context.getQualifiedClassName(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		copiedEListClassName = context.getQualifiedClassName(TextResourceArtifacts.COPIED_E_LIST);
		copiedEObjectInternalEListClassName = context.getQualifiedClassName(TextResourceArtifacts.COPIED_E_OBJECT_INTERNAL_E_LIST);
		debugCommunicationHelperClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_COMMUNICATION_HELPER);
		debugElementClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_ELEMENT);
		debugMessageClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_MESSAGE);
		debugProcessClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_PROCESS);
		debugProxyClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_PROXY);
		debugTargetClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_TARGET);
		debugThreadClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_THREAD);
		debugValueClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_VALUE);
		debugVariableClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUG_VARIABLE);
		debuggableInterpreterClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUGGABLE_INTERPRETER);
		debuggerListenerClassName = context.getQualifiedClassName(TextResourceArtifacts.DEBUGGER_LISTENER);
		defaultNameProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.DEFAULT_NAME_PROVIDER);
		defaultResolverDelegateClassName = context.getQualifiedClassName(TextResourceArtifacts.DEFAULT_RESOLVER_DELEGATE);
		defaultTokenResolverClassName = context.getQualifiedClassName(TextResourceArtifacts.DEFAULT_TOKEN_RESOLVER);
		delegatingResolveResultClassName = context.getQualifiedClassName(TextResourceArtifacts.DELEGATING_RESOLVE_RESULT);
		dotClasspathClassName = context.getQualifiedClassName(TextResourceArtifacts.DOT_CLASSPATH);
		dotProjectClassName = context.getQualifiedClassName(TextResourceArtifacts.DOT_PROJECT);
		dummyEObjectClassName = context.getQualifiedClassName(TextResourceArtifacts.DUMMY_E_OBJECT);
		dynamicTokenStyleClassName = context.getQualifiedClassName(TextResourceArtifacts.DYNAMIC_TOKEN_STYLER);
		eclipseProxyClassName = context.getQualifiedClassName(TextResourceArtifacts.ECLIPSE_PROXY);
		eClassUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.E_CLASS_UTIL);
		eDebugMessageTypesClassName = context.getQualifiedClassName(TextResourceArtifacts.E_DEBUG_MESSAGE_TYPES);
		eObjectUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.E_OBJECT_UTIL);
		eProblemSeverityClassName = context.getQualifiedClassName(TextResourceArtifacts.E_PROBLEM_SEVERITY);
		eProblemTypeClassName = context.getQualifiedClassName(TextResourceArtifacts.E_PROBLEM_TYPE);
		elementMappingClassName = context.getQualifiedClassName(TextResourceArtifacts.ELEMENT_MAPPING);
		enumerationTerminalClassName = context.getQualifiedClassName(TextResourceArtifacts.ENUMERATION_TERMINAL);
		expectationConstantsClassName = context.getQualifiedClassName(TextResourceArtifacts.EXPECTATION_CONSTANTS);
		expectedBooleanTerminalClassName = context.getQualifiedClassName(TextResourceArtifacts.EXPECTED_BOOLEAN_TERMINAL);
		expectedCsStringClassName = context.getQualifiedClassName(TextResourceArtifacts.EXPECTED_CS_STRING);
		expectedEnumerationTerminalClassName = context.getQualifiedClassName(TextResourceArtifacts.EXPECTED_ENUMERATION_TERMINAL);
		expectedStructuralFeatureClassName = context.getQualifiedClassName(TextResourceArtifacts.EXPECTED_STRUCTURAL_FEATURE);
		expectedTerminalClassName = context.getQualifiedClassName(TextResourceArtifacts.EXPECTED_TERMINAL);
		foldingInformationProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.FOLDING_INFORMATION_PROVIDER);
		followSetProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.FOLLOW_SET_PROVIDER);
		formattingElementClassName = context.getQualifiedClassName(TextResourceArtifacts.FORMATTING_ELEMENT);
		fuzzyResolveResultClassName = context.getQualifiedClassName(TextResourceArtifacts.FUZZY_RESOLVE_RESULT);
		grammarInformationProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.GRAMMAR_INFORMATION_PROVIDER);
		iBackgroundParsingListenerClassName = context.getQualifiedClassName(TextResourceArtifacts.I_BACKGROUND_PARSING_LISTENER);
		iBracketPairClassName = context.getQualifiedClassName(TextResourceArtifacts.I_BRACKET_PAIR);
		iBuilderClassName = context.getQualifiedClassName(TextResourceArtifacts.I_BUILDER);
		iCommandClassName = context.getQualifiedClassName(TextResourceArtifacts.I_COMMAND);
		iFunction1ClassName = context.getQualifiedClassName(TextResourceArtifacts.I_FUNCTION1);
		iConfigurableClassName = context.getQualifiedClassName(TextResourceArtifacts.I_CONFIGURABLE);
		iContextDependentUriFragmentClassName = context.getQualifiedClassName(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT);
		iContextDependentUriFragmentFactoryClassName = context.getQualifiedClassName(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		iDebugEventListenerClassName = context.getQualifiedClassName(TextResourceArtifacts.I_DEBUG_EVENT_LISTENER);
		iElementMappingClassName = context.getQualifiedClassName(TextResourceArtifacts.I_ELEMENT_MAPPING);
		iExpectedElementClassName = context.getQualifiedClassName(TextResourceArtifacts.I_EXPECTED_ELEMENT);
		iHoverTextProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.I_HOVER_TEXT_PROVIDER);
		iInputStreamProcessorProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.I_INPUT_STREAM_PROCESSOR_PROVIDER);
		iInterpreterListenerClassName = context.getQualifiedClassName(TextResourceArtifacts.I_INTERPRETER_LISTENER);
		iLocationMapClassName = context.getQualifiedClassName(TextResourceArtifacts.I_LOCATION_MAP);
		iMetaInformationClassName = context.getQualifiedClassName(TextResourceArtifacts.I_META_INFORMATION);
		iNameProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.I_NAME_PROVIDER);
		iOptionProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.I_OPTION_PROVIDER);
		iOptionsClassName = context.getQualifiedClassName(TextResourceArtifacts.I_OPTIONS);
		iParseResultClassName = context.getQualifiedClassName(TextResourceArtifacts.I_PARSE_RESULT);
		iProblemClassName = context.getQualifiedClassName(TextResourceArtifacts.I_PROBLEM);
		iQuickFixClassName = context.getQualifiedClassName(TextResourceArtifacts.I_QUICK_FIX);
		iReferenceCacheClassName = context.getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_CACHE);
		iReferenceMappingClassName = context.getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_MAPPING);
		iReferenceResolveResultClassName = context.getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT);
		iReferenceResolverClassName = context.getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_RESOLVER);
		iDelegatingReferenceResolverClassName = context.getQualifiedClassName(TextResourceArtifacts.I_DELEGATING_REFERENCE_RESOLVER);
		iReferenceResolverSwitchClassName = context.getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_RESOLVER_SWITCH);
		iResourcePostProcessorClassName = context.getQualifiedClassName(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR);
		iResourcePostProcessorProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR_PROVIDER);
		iResourceProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.I_RESOURCE_PROVIDER);
		iTextDiagnosticClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_DIAGNOSTIC);
		iTextParserClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_PARSER);
		iTextPrinterClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_PRINTER);
		iTextResourceClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_RESOURCE);
		iTextResourcePluginPartClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_RESOURCE_PLUGIN_PART);
		iTextScannerClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_SCANNER);
		iTextTokenClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TEXT_TOKEN);
		iTokenResolveResultClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TOKEN_RESOLVE_RESULT);
		iTokenResolverClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TOKEN_RESOLVER);
		iTokenResolverFactoryClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TOKEN_RESOLVER_FACTORY);
		iTokenStyleClassName = context.getQualifiedClassName(TextResourceArtifacts.I_TOKEN_STYLE);
		iUriMappingClassName = context.getQualifiedClassName(TextResourceArtifacts.I_URI_MAPPING);
		inputStreamProcessorClassName = context.getQualifiedClassName(TextResourceArtifacts.INPUT_STREAM_PROCESSOR);
		keywordClassName = context.getQualifiedClassName(TextResourceArtifacts.KEYWORD);
		launchConfigurationDelegateClassName = context.getQualifiedClassName(TextResourceArtifacts.LAUNCH_CONFIGURATION_DELEGATE);
		launchConfigurationHelperClassName = context.getQualifiedClassName(TextResourceArtifacts.LAUNCH_CONFIGURATION_HELPER);
		layoutInformationAdapterClassName = context.getQualifiedClassName(TextResourceArtifacts.LAYOUT_INFORMATION_ADAPTER);
		layoutInformationClassName = context.getQualifiedClassName(TextResourceArtifacts.LAYOUT_INFORMATION);
		lineBreakClassName = context.getQualifiedClassName(TextResourceArtifacts.LINE_BREAK);
		lineBreakpointClassName = context.getQualifiedClassName(TextResourceArtifacts.LINEBREAK_POINT);
		layoutUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.LAYOUT_UTIL);
		listUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.LIST_UTIL);
		locationMapClassName = context.getQualifiedClassName(TextResourceArtifacts.LOCATION_MAP);
		devNullLocationMapClassName = context.getQualifiedClassName(TextResourceArtifacts.DEV_NULL_LOCATION_MAP);		
		mapUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.MAP_UTIL);
		markerHelperClassName = context.getQualifiedClassName(TextResourceArtifacts.MARKER_HELPER);
		metaInformationClassName = context.getQualifiedClassName(TextResourceArtifacts.META_INFORMATION);
		minimalModelHelperClassName = context.getQualifiedClassName(TextResourceArtifacts.MINIMAL_MODEL_HELPER);
		natureClassName = context.getQualifiedClassName(TextResourceArtifacts.NATURE);
		newFileContentProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.NEW_FILE_CONTENT_PROVIDER);
		optionProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.OPTION_PROVIDER);
		pairClassName = context.getQualifiedClassName(TextResourceArtifacts.PAIR);
		parseResultClassName = context.getQualifiedClassName(TextResourceArtifacts.PARSE_RESULT);
		placeholderClassName = context.getQualifiedClassName(TextResourceArtifacts.PLACEHOLDER);
		pluginActivatorClassName = context.getQualifiedClassName(TextResourceArtifacts.PLUGIN_ACTIVATOR);
		printer2ClassName = context.getQualifiedClassName(TextResourceArtifacts.PRINTER2);
		printerClassName = context.getQualifiedClassName(TextResourceArtifacts.PRINTER);
		problemClassName = context.getQualifiedClassName(TextResourceArtifacts.PROBLEM);
		quickFixClassName = context.getQualifiedClassName(TextResourceArtifacts.QUICK_FIX);
		referenceCacheClassName = context.getQualifiedClassName(TextResourceArtifacts.REFERENCE_CACHE);
		referenceResolveResultClassName = context.getQualifiedClassName(TextResourceArtifacts.REFERENCE_RESOLVE_RESULT);
		referenceResolverSwitchClassName = context.getQualifiedClassName(TextResourceArtifacts.REFERENCE_RESOLVER_SWITCH);
		resourceFactoryClassName = context.getQualifiedClassName(TextResourceArtifacts.RESOURCE_FACTORY);
		resourceFactoryDelegatorClassName = context.getQualifiedClassName(TextResourceArtifacts.RESOURCE_FACTORY_DELEGATOR);
		resourcePostProcessorClassName = context.getQualifiedClassName(TextResourceArtifacts.RESOURCE_POST_PROCESSOR);
		resourceUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.RESOURCE_UTIL);
		ruleClassName = context.getQualifiedClassName(TextResourceArtifacts.RULE);
		runtimeUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.RUNTIME_UTIL);
		scannerlessParserClassName = context.getQualifiedClassName(TextResourceArtifacts.SCANNERLESS_PARSER);
		scannerlessScannerClassName = context.getQualifiedClassName(TextResourceArtifacts.SCANNERLESS_SCANNER);
		sequenceClassName = context.getQualifiedClassName(TextResourceArtifacts.SEQUENCE);
		sourceLocatorClassName = context.getQualifiedClassName(TextResourceArtifacts.SOURCE_LOCATOR);
		sourceLookupParticipantClassName = context.getQualifiedClassName(TextResourceArtifacts.SOURCE_LOOKUP_PARTICIPANT);
		sourcePathComputerDelegateClassName = context.getQualifiedClassName(TextResourceArtifacts.SOURCE_PATH_COMPUTER_DELEGATE);
		stackFrameClassName = context.getQualifiedClassName(TextResourceArtifacts.STACK_FRAME);
		streamUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.STREAM_UTIL);
		stringUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.STRING_UTIL);
		syntaxCoverageInformationProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.SYNTAX_COVERAGE_INFORMATION_PROVIDER);
		syntaxElementClassName = context.getQualifiedClassName(TextResourceArtifacts.SYNTAX_ELEMENT);
		syntaxElementDecoratorClassName = context.getQualifiedClassName(TextResourceArtifacts.SYNTAX_ELEMENT_DECORATOR);
		terminalClassName = context.getQualifiedClassName(TextResourceArtifacts.TERMINAL);
		terminateParsingExceptionClassName = context.getQualifiedClassName(TextResourceArtifacts.TERMINATE_PARSING_EXCEPTION);
		textResourceClassName = context.getQualifiedClassName(TextResourceArtifacts.RESOURCE);
		textResourceUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.TEXT_RESOURCE_UTIL);
		textTokenClassName = context.getQualifiedClassName(TextResourceArtifacts.TEXT_TOKEN);
		tokenResolveResultClassName = context.getQualifiedClassName(TextResourceArtifacts.TOKEN_RESOLVE_RESULT);
		tokenResolverClassName = context.getQualifiedClassName(TextResourceArtifacts.TOKEN_RESOLVER);
		tokenResolverFactoryClassName = context.getQualifiedClassName(TextResourceArtifacts.TOKEN_RESOLVER_FACTORY);
		tokenStyleClassName = context.getQualifiedClassName(TextResourceArtifacts.TOKEN_STYLE);
		tokenStyleInformationProviderClassName = context.getQualifiedClassName(TextResourceArtifacts.TOKEN_STYLE_INFORMATION_PROVIDER);
		unexpectedContentTypeExceptionClassName = context.getQualifiedClassName(TextResourceArtifacts.UNEXPECTED_CONTENT_TYPE_EXCEPTION);
		unicodeConverterClassName = context.getQualifiedClassName(TextResourceArtifacts.UNICODE_CONVERTER);
		uriMappingClassName = context.getQualifiedClassName(TextResourceArtifacts.URI_MAPPING);
		whiteSpaceClassName = context.getQualifiedClassName(TextResourceArtifacts.WHITE_SPACE);

		taskItemClassName = context.getQualifiedClassName(TextResourceArtifacts.TASK_ITEM);
		taskItemDetectorClassName = context.getQualifiedClassName(TextResourceArtifacts.TASK_ITEM_DETECTOR);
		taskItemBuilderClassName = context.getQualifiedClassName(TextResourceArtifacts.TASK_ITEM_BUILDER);
		uriUtilClassName = context.getQualifiedClassName(TextResourceArtifacts.URI_UTIL);
		antlrTextTokenClassName = context.getQualifiedClassName(TextResourceArtifacts.ANTLR_TEXT_TOKEN);
	}

	protected String getResourceClassName() {
    	return resourceClassName;
    }
    
    protected String getResourcePackageName() {
    	return resourcePackageName;
    }
    
    @Override
    public void doGenerate(PrintWriter out) {
		initilizeClassNames();
		ArtifactDescriptor<GenerationContext, ?> artifact = getParameters().getArtifact();
		if (artifact != null) {
			this.resourcePackageName = getContext().getPackageName(artifact);
			this.resourceClassName = getContext().getClassName(artifact);
		}
    }

	protected void generateEmptyClass(JavaComposite sc, String classComment, OptionTypes disablingOption) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		if (classComment != null) {
			sc.addJavadoc(classComment);
		}
		sc.add("public class " + getResourceClassName() + " {");
		sc.addComment("The generator for this class is currently disabled by option '" + disablingOption.getLiteral() + "' in the .cs file.");
		sc.add("}");
	}
}
