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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.emftext.sdk.codegen.ArtifactDescriptor;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.IProblemCollector;

/**
 * A basic implementation for generators which generate Java or ANTLR code. 
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public abstract class BaseGenerator implements IGenerator, IProblemCollector {
	
	protected static final Map<String, String> javaNativeTypeMapping;
	static {
		javaNativeTypeMapping = new HashMap<String, String>();
		
		javaNativeTypeMapping.put("int", "java.lang.Integer");
		javaNativeTypeMapping.put("short", "java.lang.Short");
		javaNativeTypeMapping.put("long", "java.lang.Long");
		javaNativeTypeMapping.put("double", "java.lang.Double");
		javaNativeTypeMapping.put("byte", "java.lang.Byte");
		javaNativeTypeMapping.put("boolean", "java.lang.Boolean");
		javaNativeTypeMapping.put("float", "java.lang.Float");
		javaNativeTypeMapping.put("char", "java.lang.Character");
	}

	
	private List<GenerationProblem> errors;
	private List<GenerationProblem> warnings;
	protected GenerationContext context;
	private String resourceClassName;
	private String resourcePackageName;

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
	protected String backgroundParsingStrategyClassName;
	protected String bracketInformationProviderClassName;
	protected String bracketPreferencePageClassName;
	protected String bracketSetClassName;
	protected String browserInformationControlClassName;
	protected String buildPropertiesClassName;
	protected String builderAdapterClassName;
	protected String builderClassName;
	protected String cardinalityClassName;
	protected String castUtilClassName;
	protected String choiceClassName;
	protected String codeCompletionHelperClassName;
	protected String codeFoldingManagerClassName;
	protected String colorManagerClassName;
	protected String completionProcessorClassName;
	protected String completionProposalClassName;
	protected String compoundClassName;
	protected String containmentClassName;
	protected String contextDependentUriFragmentClassName;
	protected String contextDependentUriFragmentFactoryClassName;
	protected String copiedEListClassName;
	protected String copiedEObjectInternalEListClassName;
	protected String defaultHoverTextProviderClassName;
	protected String defaultResolverDelegateClassName;
	protected String defaultTokenResolverClassName;
	protected String delegatingResolveResultClassName;
	protected String docBrowserInformationControlInputClassName;
	protected String dotClasspathClassName;
	protected String dotProjectClassName;
	protected String dummyEObjectClassName;
	protected String eClassUtilClassName;
	protected String eObjectSelectionClassName;
	protected String eObjectUtilClassName;
	protected String eProblemTypeClassName;
	protected String editorClassName;
	protected String editorConfigurationClassName;
	protected String elementMappingClassName;
	protected String expectedCsStringClassName;
	protected String expectedStructuralFeatureClassName;
	protected String expectedTerminalClassName;
	protected String foldingInformationProviderClassName;
	protected String followSetProviderClassName;
	protected String formattingElementClassName;
	protected String fuzzyResolveResultClassName;
	protected String grammarInformationProviderClassName;
	protected String highlightingClassName;
	protected String hoverTextProviderClassName;
	protected String htmlPrinterClassName;
	protected String hyperlinkClassName;
	protected String hyperlinkDetectorClassName;
	protected String iBackgroundParsingListenerClassName;
	protected String iBracketPairClassName;
	protected String iBuilderClassName;
	protected String iCommandClassName;
	protected String iConfigurableClassName;
	protected String iContextDependentUriFragmentClassName;
	protected String iContextDependentUriFragmentFactoryClassName;
	protected String iElementMappingClassName;
	protected String iExpectedElementClassName;
	protected String iHoverTextProviderClassName;
	protected String iInputStreamProcessorProviderClassName;
	protected String iLocationMapClassName;
	protected String iMetaInformationClassName;
	protected String iOptionProviderClassName;
	protected String iOptionsClassName;
	protected String iParseResultClassName;
	protected String iProblemClassName;
	protected String iReferenceCacheClassName;
	protected String iReferenceMappingClassName;
	protected String iReferenceResolveResultClassName;
	protected String iReferenceResolverClassName;
	protected String iReferenceResolverSwitchClassName;
	protected String iResourcePostProcessorClassName;
	protected String iResourcePostProcessorProviderClassName;
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
	protected String layoutInformationAdapterClassName;
	protected String layoutInformationClassName;
	protected String lineBreakClassName;
	protected String listUtilClassName;
	protected String locationMapClassName;
	protected String mapUtilClassName;
	protected String markerHelperClassName;
	protected String metaInformationClassName;
	protected String minimalModelHelperClassName;
	protected String natureClassName;
	protected String newFileContentProviderClassName;
	protected String newFileWizardClassName;
	protected String newFileWizardPageClassName;
	protected String occurenceClassName;
	protected String occurrencePreferencePageClassName;
	protected String outlinePageClassName;
	protected String outlinePageTreeViewerClassName;
	protected String pairClassName;
	protected String parseResultClassName;
	protected String pixelConverterClassName;
	protected String placeholderClassName;
	protected String pluginActivatorClassName;
	protected String positionCategoryClassName;
	protected String positionHelperClassName;
	protected String preferenceConstantsClassName;
	protected String preferenceInitializerClassName;
	protected String preferencePageClassName;
	protected String printer2ClassName;
	protected String printerClassName;
	protected String problemClassName;
	protected String propertySheetPageClassName;
	protected String referenceResolveResultClassName;
	protected String referenceResolverSwitchClassName;
	protected String resourceFactoryClassName;
	protected String resourceFactoryDelegatorClassName;
	protected String resourceUtilClassName;
	protected String scannerlessParserClassName;
	protected String scannerlessScannerClassName;
	protected String sequenceClassName;
	protected String streamUtilClassName;
	protected String stringUtilClassName;
	protected String syntaxColoringHelperClassName;
	protected String syntaxColoringPreferencePageClassName;
	protected String syntaxCoverageInformationProviderClassName;
	protected String syntaxElementClassName;
	protected String syntaxElementDecoratorClassName;
	protected String terminalClassName;
	protected String terminateParsingExceptionClassName;
	protected String textHoverClassName;
	protected String textResourceClassName;
	protected String textResourceUtilClassName;
	protected String textTokenClassName;
	protected String tokenResolveResultClassName;
	protected String tokenResolverClassName;
	protected String tokenResolverFactoryClassName;
	protected String tokenScannerClassName;
	protected String tokenStyleInformationProviderClassName;
	protected String unexpectedContentTypeExceptionClassName;
	protected String unicodeConverterClassName;
	protected String uriMappingClassName;
	protected String whiteSpaceClassName;

	public BaseGenerator() {
		super();
	}
	
	/**
	 * Creates a new BaseGenerator that can be used to generate an 
	 * artifact of the given type.
	 * 
	 * @param artifact the type of artifact to be generated
	 */
	public BaseGenerator(GenerationContext context, ArtifactDescriptor artifact) {
		errors = new LinkedList<GenerationProblem>();
		warnings = new LinkedList<GenerationProblem>();

		this.context = context;
		if (artifact != null) {
			this.resourcePackageName = context.getPackageName(artifact);
			this.resourceClassName = context.getClassName(artifact);
		}
		
		initilizeClassNames();
	}

	private void initilizeClassNames() {
		abstractExpectedElementClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ABSTRACT_EXPECTED_ELEMENT);
		abstractInterpreterClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ABSTRACT_INTERPRETER);
		antlrGrammarClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ANTLR_GRAMMAR);
		antlrLexerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ANTLR_LEXER);
		antlrParserBaseClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ANTLR_PARSER_BASE);
		antlrParserClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ANTLR_PARSER);
		antlrScannerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ANTLR_SCANNER);
		antlrTokenHelperClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ANTLR_TOKEN_HELPER);
		attributeValueProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ATTRIBUTE_VALUE_PROVIDER);
		babylonSpecificationClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BABYLON_SPECIFICATION);
		backgroundParsingStrategyClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BACKGROUND_PARSING_STRATEGY);
		bracketInformationProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BRACKET_INFORMATION_PROVIDER);
		bracketPreferencePageClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BRACKET_PREFERENCE_PAGE);
		bracketSetClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BRACKET_SET);
		browserInformationControlClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BROWSER_INFORMATION_CONTROL);
		buildPropertiesClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BUILD_PROPERTIES);
		builderAdapterClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BUILDER_ADAPTER);
		builderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.BUILDER);
		cardinalityClassName = getContext().getQualifiedClassName(TextResourceArtifacts.CARDINALITY);
		castUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.CAST_UTIL);
		choiceClassName = getContext().getQualifiedClassName(TextResourceArtifacts.CHOICE);
		codeCompletionHelperClassName = getContext().getQualifiedClassName(TextResourceArtifacts.CODE_COMPLETION_HELPER);
		codeFoldingManagerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.CODE_FOLDING_MANAGER);
		colorManagerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.COLOR_MANAGER);
		completionProcessorClassName = getContext().getQualifiedClassName(TextResourceArtifacts.COMPLETION_PROCESSOR);
		completionProposalClassName = getContext().getQualifiedClassName(TextResourceArtifacts.COMPLETION_PROPOSAL);
		compoundClassName = getContext().getQualifiedClassName(TextResourceArtifacts.COMPOUND);
		containmentClassName = getContext().getQualifiedClassName(TextResourceArtifacts.CONTAINMENT);
		contextDependentUriFragmentClassName = getContext().getQualifiedClassName(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT);
		contextDependentUriFragmentFactoryClassName = getContext().getQualifiedClassName(TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		copiedEListClassName = getContext().getQualifiedClassName(TextResourceArtifacts.COPIED_E_LIST);
		copiedEObjectInternalEListClassName = getContext().getQualifiedClassName(TextResourceArtifacts.COPIED_E_OBJECT_INTERNAL_E_LIST);
		defaultHoverTextProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.DEFAULT_HOVER_TEXT_PROVIDER);
		defaultResolverDelegateClassName = getContext().getQualifiedClassName(TextResourceArtifacts.DEFAULT_RESOLVER_DELEGATE);
		defaultTokenResolverClassName = getContext().getQualifiedClassName(TextResourceArtifacts.DEFAULT_TOKEN_RESOLVER);
		delegatingResolveResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.DELEGATING_RESOLVE_RESULT);
		docBrowserInformationControlInputClassName = getContext().getQualifiedClassName(TextResourceArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT);
		dotClasspathClassName = getContext().getQualifiedClassName(TextResourceArtifacts.DOT_CLASSPATH);
		dotProjectClassName = getContext().getQualifiedClassName(TextResourceArtifacts.DOT_PROJECT);
		dummyEObjectClassName = getContext().getQualifiedClassName(TextResourceArtifacts.DUMMY_E_OBJECT);
		eClassUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.E_CLASS_UTIL);
		eObjectSelectionClassName = getContext().getQualifiedClassName(TextResourceArtifacts.E_OBJECT_SELECTION);
		eObjectUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.E_OBJECT_UTIL);
		eProblemTypeClassName = getContext().getQualifiedClassName(TextResourceArtifacts.E_PROBLEM_TYPE);
		editorClassName = getContext().getQualifiedClassName(TextResourceArtifacts.EDITOR);
		editorConfigurationClassName = getContext().getQualifiedClassName(TextResourceArtifacts.EDITOR_CONFIGURATION);
		elementMappingClassName = getContext().getQualifiedClassName(TextResourceArtifacts.ELEMENT_MAPPING);
		expectedCsStringClassName = getContext().getQualifiedClassName(TextResourceArtifacts.EXPECTED_CS_STRING);
		expectedStructuralFeatureClassName = getContext().getQualifiedClassName(TextResourceArtifacts.EXPECTED_STRUCTURAL_FEATURE);
		expectedTerminalClassName = getContext().getQualifiedClassName(TextResourceArtifacts.EXPECTED_TERMINAL);
		foldingInformationProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.FOLDING_INFORMATION_PROVIDER);
		followSetProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.FOLLOW_SET_PROVIDER);
		formattingElementClassName = getContext().getQualifiedClassName(TextResourceArtifacts.FORMATTING_ELEMENT);
		fuzzyResolveResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.FUZZY_RESOLVE_RESULT);
		grammarInformationProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.GRAMMAR_INFORMATION_PROVIDER);
		highlightingClassName = getContext().getQualifiedClassName(TextResourceArtifacts.HIGHLIGHTING);
		hoverTextProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.HOVER_TEXT_PROVIDER);
		htmlPrinterClassName = getContext().getQualifiedClassName(TextResourceArtifacts.HTML_PRINTER);
		hyperlinkClassName = getContext().getQualifiedClassName(TextResourceArtifacts.HYPERLINK);
		hyperlinkDetectorClassName = getContext().getQualifiedClassName(TextResourceArtifacts.HYPERLINK_DETECTOR);
		iBackgroundParsingListenerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_BACKGROUND_PARSING_LISTENER);
		iBracketPairClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_BRACKET_PAIR);
		iBuilderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_BUILDER);
		iCommandClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_COMMAND);
		iConfigurableClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_CONFIGURABLE);
		iContextDependentUriFragmentClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT);
		iContextDependentUriFragmentFactoryClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		iElementMappingClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_ELEMENT_MAPPING);
		iExpectedElementClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_EXPECTED_ELEMENT);
		iHoverTextProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_HOVER_TEXT_PROVIDER);
		iInputStreamProcessorProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_INPUT_STREAM_PROCESSOR_PROVIDER);
		iLocationMapClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_LOCATION_MAP);
		iMetaInformationClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_META_INFORMATION);
		iOptionProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_OPTION_PROVIDER);
		iOptionsClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_OPTIONS);
		iParseResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_PARSE_RESULT);
		iProblemClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_PROBLEM);
		iReferenceCacheClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_CACHE);
		iReferenceMappingClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_MAPPING);
		iReferenceResolveResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_RESOLVE_RESULT);
		iReferenceResolverClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_RESOLVER);
		iReferenceResolverSwitchClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_REFERENCE_RESOLVER_SWITCH);
		iResourcePostProcessorClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR);
		iResourcePostProcessorProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_RESOURCE_POST_PROCESSOR_PROVIDER);
		iTextDiagnosticClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TEXT_DIAGNOSTIC);
		iTextParserClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TEXT_PARSER);
		iTextPrinterClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TEXT_PRINTER);
		iTextResourceClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TEXT_RESOURCE);
		iTextResourcePluginPartClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TEXT_RESOURCE_PLUGIN_PART);
		iTextScannerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TEXT_SCANNER);
		iTextTokenClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TEXT_TOKEN);
		iTokenResolveResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TOKEN_RESOLVE_RESULT);
		iTokenResolverClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TOKEN_RESOLVER);
		iTokenResolverFactoryClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TOKEN_RESOLVER_FACTORY);
		iTokenStyleClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_TOKEN_STYLE);
		iUriMappingClassName = getContext().getQualifiedClassName(TextResourceArtifacts.I_URI_MAPPING);
		inputStreamProcessorClassName = getContext().getQualifiedClassName(TextResourceArtifacts.INPUT_STREAM_PROCESSOR);
		keywordClassName = getContext().getQualifiedClassName(TextResourceArtifacts.KEYWORD);
		layoutInformationAdapterClassName = getContext().getQualifiedClassName(TextResourceArtifacts.LAYOUT_INFORMATION_ADAPTER);
		layoutInformationClassName = getContext().getQualifiedClassName(TextResourceArtifacts.LAYOUT_INFORMATION);
		lineBreakClassName = getContext().getQualifiedClassName(TextResourceArtifacts.LINE_BREAK);
		listUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.LIST_UTIL);
		locationMapClassName = getContext().getQualifiedClassName(TextResourceArtifacts.LOCATION_MAP);
		mapUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.MAP_UTIL);
		markerHelperClassName = getContext().getQualifiedClassName(TextResourceArtifacts.MARKER_HELPER);
		metaInformationClassName = getContext().getQualifiedClassName(TextResourceArtifacts.META_INFORMATION);
		minimalModelHelperClassName = getContext().getQualifiedClassName(TextResourceArtifacts.MINIMAL_MODEL_HELPER);
		natureClassName = getContext().getQualifiedClassName(TextResourceArtifacts.NATURE);
		newFileContentProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.NEW_FILE_CONTENT_PROVIDER);
		newFileWizardClassName = getContext().getQualifiedClassName(TextResourceArtifacts.NEW_FILE_WIZARD);
		newFileWizardPageClassName = getContext().getQualifiedClassName(TextResourceArtifacts.NEW_FILE_WIZARD_PAGE);
		occurenceClassName = getContext().getQualifiedClassName(TextResourceArtifacts.OCCURENCE);
		occurrencePreferencePageClassName = getContext().getQualifiedClassName(TextResourceArtifacts.OCCURRENCE_PREFERENCE_PAGE);
		outlinePageClassName = getContext().getQualifiedClassName(TextResourceArtifacts.OUTLINE_PAGE);
		outlinePageTreeViewerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.OUTLINE_PAGE_TREE_VIEWER);
		pairClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PAIR);
		parseResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PARSE_RESULT);
		pixelConverterClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PIXEL_CONVERTER);
		placeholderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PLACEHOLDER);
		pluginActivatorClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PLUGIN_ACTIVATOR);
		positionCategoryClassName = getContext().getQualifiedClassName(TextResourceArtifacts.POSITION_CATEGORY);
		positionHelperClassName = getContext().getQualifiedClassName(TextResourceArtifacts.POSITION_HELPER);
		preferenceConstantsClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PREFERENCE_CONSTANTS);
		preferenceInitializerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PREFERENCE_INITIALIZER);
		preferencePageClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PREFERENCE_PAGE);
		printer2ClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PRINTER2);
		printerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PRINTER);
		problemClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PROBLEM);
		propertySheetPageClassName = getContext().getQualifiedClassName(TextResourceArtifacts.PROPERTY_SHEET_PAGE);
		referenceResolveResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.REFERENCE_RESOLVE_RESULT);
		referenceResolverSwitchClassName = getContext().getQualifiedClassName(TextResourceArtifacts.REFERENCE_RESOLVER_SWITCH);
		resourceFactoryClassName = getContext().getQualifiedClassName(TextResourceArtifacts.RESOURCE_FACTORY);
		resourceFactoryDelegatorClassName = getContext().getQualifiedClassName(TextResourceArtifacts.RESOURCE_FACTORY_DELEGATOR);
		resourceUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.RESOURCE_UTIL);
		scannerlessParserClassName = getContext().getQualifiedClassName(TextResourceArtifacts.SCANNERLESS_PARSER);
		scannerlessScannerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.SCANNERLESS_SCANNER);
		sequenceClassName = getContext().getQualifiedClassName(TextResourceArtifacts.SEQUENCE);
		streamUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.STREAM_UTIL);
		stringUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.STRING_UTIL);
		syntaxColoringHelperClassName = getContext().getQualifiedClassName(TextResourceArtifacts.SYNTAX_COLORING_HELPER);
		syntaxColoringPreferencePageClassName = getContext().getQualifiedClassName(TextResourceArtifacts.SYNTAX_COLORING_PREFERENCE_PAGE);
		syntaxCoverageInformationProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.SYNTAX_COVERAGE_INFORMATION_PROVIDER);
		syntaxElementClassName = getContext().getQualifiedClassName(TextResourceArtifacts.SYNTAX_ELEMENT);
		syntaxElementDecoratorClassName = getContext().getQualifiedClassName(TextResourceArtifacts.SYNTAX_ELEMENT_DECORATOR);
		terminalClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TERMINAL);
		terminateParsingExceptionClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TERMINATE_PARSING_EXCEPTION);
		textHoverClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TEXT_HOVER);
		textResourceClassName = getContext().getQualifiedClassName(TextResourceArtifacts.RESOURCE);
		textResourceUtilClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TEXT_RESOURCE_UTIL);
		textTokenClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TEXT_TOKEN);
		tokenResolveResultClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TOKEN_RESOLVE_RESULT);
		tokenResolverClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TOKEN_RESOLVER);
		tokenResolverFactoryClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TOKEN_RESOLVER_FACTORY);
		tokenScannerClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TOKEN_SCANNER);
		tokenStyleInformationProviderClassName = getContext().getQualifiedClassName(TextResourceArtifacts.TOKEN_STYLE_INFORMATION_PROVIDER);
		unexpectedContentTypeExceptionClassName = getContext().getQualifiedClassName(TextResourceArtifacts.UNEXPECTED_CONTENT_TYPE_EXCEPTION);
		unicodeConverterClassName = getContext().getQualifiedClassName(TextResourceArtifacts.UNICODE_CONVERTER);
		uriMappingClassName = getContext().getQualifiedClassName(TextResourceArtifacts.URI_MAPPING);
		whiteSpaceClassName = getContext().getQualifiedClassName(TextResourceArtifacts.WHITE_SPACE);
	}

	/**
	 * A ResourceGenerator generates its output on a PrintWriter. All its GenerationProblems should be reported
	 * via addProblem(GenerationProblem).<br/> 
	 * Important:  Even with valid output there might be problems.
	 * 
	 * @param out - the target stream to write on
	 * @return true, iff the result is valid
	 */
	public abstract boolean generate(PrintWriter out);
	
	public GenerationContext getContext() {
		return context;
	}

	/**
	 * Can be used by base classes to collect problems.
	 * 
	 * @param problem
	 */
	public void addProblem(GenerationProblem problem){
		if (problem.getSeverity().equals(GenerationProblem.Severity.ERROR)) {
			errors.add(problem);
		} else {
			warnings.add(problem);
		}
	}
	
	
	public Collection<GenerationProblem> getCollectedErrors(){
		return errors;
	}
	
	public Collection<GenerationProblem> getCollectedProblems(){
		List<GenerationProblem> allProblems = new LinkedList<GenerationProblem>(errors);
		allProblems.addAll(warnings);
		return allProblems;
	}
	
	protected String getResourceClassName() {
    	return resourceClassName;
    }
    
    protected String getResourcePackageName() {
    	return resourcePackageName;
    }
    
    protected String getObjectTypeName(String typeName){
    	if (BaseGenerator.javaNativeTypeMapping.containsKey(typeName)) {
    		return BaseGenerator.javaNativeTypeMapping.get(typeName);
    	}
    	return typeName;
    }
}
