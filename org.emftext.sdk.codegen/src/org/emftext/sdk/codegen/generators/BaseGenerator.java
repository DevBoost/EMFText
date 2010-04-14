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

import org.emftext.sdk.codegen.EArtifact;
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
	public BaseGenerator(GenerationContext context, EArtifact artifact) {
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
		abstractExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.ABSTRACT_EXPECTED_ELEMENT);
		abstractInterpreterClassName = getContext().getQualifiedClassName(EArtifact.ABSTRACT_INTERPRETER);
		antlrGrammarClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_GRAMMAR);
		antlrLexerClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_LEXER);
		antlrParserBaseClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_PARSER_BASE);
		antlrParserClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_PARSER);
		antlrScannerClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_SCANNER);
		antlrTokenHelperClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_TOKEN_HELPER);
		attributeValueProviderClassName = getContext().getQualifiedClassName(EArtifact.ATTRIBUTE_VALUE_PROVIDER);
		babylonSpecificationClassName = getContext().getQualifiedClassName(EArtifact.BABYLON_SPECIFICATION);
		backgroundParsingStrategyClassName = getContext().getQualifiedClassName(EArtifact.BACKGROUND_PARSING_STRATEGY);
		bracketInformationProviderClassName = getContext().getQualifiedClassName(EArtifact.BRACKET_INFORMATION_PROVIDER);
		bracketPreferencePageClassName = getContext().getQualifiedClassName(EArtifact.BRACKET_PREFERENCE_PAGE);
		bracketSetClassName = getContext().getQualifiedClassName(EArtifact.BRACKET_SET);
		browserInformationControlClassName = getContext().getQualifiedClassName(EArtifact.BROWSER_INFORMATION_CONTROL);
		buildPropertiesClassName = getContext().getQualifiedClassName(EArtifact.BUILD_PROPERTIES);
		builderAdapterClassName = getContext().getQualifiedClassName(EArtifact.BUILDER_ADAPTER);
		builderClassName = getContext().getQualifiedClassName(EArtifact.BUILDER);
		cardinalityClassName = getContext().getQualifiedClassName(EArtifact.CARDINALITY);
		castUtilClassName = getContext().getQualifiedClassName(EArtifact.CAST_UTIL);
		choiceClassName = getContext().getQualifiedClassName(EArtifact.CHOICE);
		codeCompletionHelperClassName = getContext().getQualifiedClassName(EArtifact.CODE_COMPLETION_HELPER);
		codeFoldingManagerClassName = getContext().getQualifiedClassName(EArtifact.CODE_FOLDING_MANAGER);
		colorManagerClassName = getContext().getQualifiedClassName(EArtifact.COLOR_MANAGER);
		completionProcessorClassName = getContext().getQualifiedClassName(EArtifact.COMPLETION_PROCESSOR);
		completionProposalClassName = getContext().getQualifiedClassName(EArtifact.COMPLETION_PROPOSAL);
		compoundClassName = getContext().getQualifiedClassName(EArtifact.COMPOUND);
		containmentClassName = getContext().getQualifiedClassName(EArtifact.CONTAINMENT);
		contextDependentUriFragmentClassName = getContext().getQualifiedClassName(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT);
		contextDependentUriFragmentFactoryClassName = getContext().getQualifiedClassName(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		copiedEListClassName = getContext().getQualifiedClassName(EArtifact.COPIED_E_LIST);
		copiedEObjectInternalEListClassName = getContext().getQualifiedClassName(EArtifact.COPIED_E_OBJECT_INTERNAL_E_LIST);
		defaultHoverTextProviderClassName = getContext().getQualifiedClassName(EArtifact.DEFAULT_HOVER_TEXT_PROVIDER);
		defaultResolverDelegateClassName = getContext().getQualifiedClassName(EArtifact.DEFAULT_RESOLVER_DELEGATE);
		defaultTokenResolverClassName = getContext().getQualifiedClassName(EArtifact.DEFAULT_TOKEN_RESOLVER);
		delegatingResolveResultClassName = getContext().getQualifiedClassName(EArtifact.DELEGATING_RESOLVE_RESULT);
		docBrowserInformationControlInputClassName = getContext().getQualifiedClassName(EArtifact.DOC_BROWSER_INFORMATION_CONTROL_INPUT);
		dotClasspathClassName = getContext().getQualifiedClassName(EArtifact.DOT_CLASSPATH);
		dotProjectClassName = getContext().getQualifiedClassName(EArtifact.DOT_PROJECT);
		dummyEObjectClassName = getContext().getQualifiedClassName(EArtifact.DUMMY_E_OBJECT);
		eClassUtilClassName = getContext().getQualifiedClassName(EArtifact.E_CLASS_UTIL);
		eObjectSelectionClassName = getContext().getQualifiedClassName(EArtifact.E_OBJECT_SELECTION);
		eObjectUtilClassName = getContext().getQualifiedClassName(EArtifact.E_OBJECT_UTIL);
		eProblemTypeClassName = getContext().getQualifiedClassName(EArtifact.E_PROBLEM_TYPE);
		editorClassName = getContext().getQualifiedClassName(EArtifact.EDITOR);
		editorConfigurationClassName = getContext().getQualifiedClassName(EArtifact.EDITOR_CONFIGURATION);
		elementMappingClassName = getContext().getQualifiedClassName(EArtifact.ELEMENT_MAPPING);
		expectedCsStringClassName = getContext().getQualifiedClassName(EArtifact.EXPECTED_CS_STRING);
		expectedStructuralFeatureClassName = getContext().getQualifiedClassName(EArtifact.EXPECTED_STRUCTURAL_FEATURE);
		expectedTerminalClassName = getContext().getQualifiedClassName(EArtifact.EXPECTED_TERMINAL);
		foldingInformationProviderClassName = getContext().getQualifiedClassName(EArtifact.FOLDING_INFORMATION_PROVIDER);
		followSetProviderClassName = getContext().getQualifiedClassName(EArtifact.FOLLOW_SET_PROVIDER);
		formattingElementClassName = getContext().getQualifiedClassName(EArtifact.FORMATTING_ELEMENT);
		fuzzyResolveResultClassName = getContext().getQualifiedClassName(EArtifact.FUZZY_RESOLVE_RESULT);
		grammarInformationProviderClassName = getContext().getQualifiedClassName(EArtifact.GRAMMAR_INFORMATION_PROVIDER);
		highlightingClassName = getContext().getQualifiedClassName(EArtifact.HIGHLIGHTING);
		hoverTextProviderClassName = getContext().getQualifiedClassName(EArtifact.HOVER_TEXT_PROVIDER);
		htmlPrinterClassName = getContext().getQualifiedClassName(EArtifact.HTML_PRINTER);
		hyperlinkClassName = getContext().getQualifiedClassName(EArtifact.HYPERLINK);
		hyperlinkDetectorClassName = getContext().getQualifiedClassName(EArtifact.HYPERLINK_DETECTOR);
		iBackgroundParsingListenerClassName = getContext().getQualifiedClassName(EArtifact.I_BACKGROUND_PARSING_LISTENER);
		iBracketPairClassName = getContext().getQualifiedClassName(EArtifact.I_BRACKET_PAIR);
		iBuilderClassName = getContext().getQualifiedClassName(EArtifact.I_BUILDER);
		iCommandClassName = getContext().getQualifiedClassName(EArtifact.I_COMMAND);
		iConfigurableClassName = getContext().getQualifiedClassName(EArtifact.I_CONFIGURABLE);
		iContextDependentUriFragmentClassName = getContext().getQualifiedClassName(EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT);
		iContextDependentUriFragmentFactoryClassName = getContext().getQualifiedClassName(EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		iElementMappingClassName = getContext().getQualifiedClassName(EArtifact.I_ELEMENT_MAPPING);
		iExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.I_EXPECTED_ELEMENT);
		iHoverTextProviderClassName = getContext().getQualifiedClassName(EArtifact.I_HOVER_TEXT_PROVIDER);
		iInputStreamProcessorProviderClassName = getContext().getQualifiedClassName(EArtifact.I_INPUT_STREAM_PROCESSOR_PROVIDER);
		iLocationMapClassName = getContext().getQualifiedClassName(EArtifact.I_LOCATION_MAP);
		iMetaInformationClassName = getContext().getQualifiedClassName(EArtifact.I_META_INFORMATION);
		iOptionProviderClassName = getContext().getQualifiedClassName(EArtifact.I_OPTION_PROVIDER);
		iOptionsClassName = getContext().getQualifiedClassName(EArtifact.I_OPTIONS);
		iParseResultClassName = getContext().getQualifiedClassName(EArtifact.I_PARSE_RESULT);
		iProblemClassName = getContext().getQualifiedClassName(EArtifact.I_PROBLEM);
		iReferenceCacheClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_CACHE);
		iReferenceMappingClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_MAPPING);
		iReferenceResolveResultClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVE_RESULT);
		iReferenceResolverClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVER);
		iReferenceResolverSwitchClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVER_SWITCH);
		iResourcePostProcessorClassName = getContext().getQualifiedClassName(EArtifact.I_RESOURCE_POST_PROCESSOR);
		iResourcePostProcessorProviderClassName = getContext().getQualifiedClassName(EArtifact.I_RESOURCE_POST_PROCESSOR_PROVIDER);
		iTextDiagnosticClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_DIAGNOSTIC);
		iTextParserClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_PARSER);
		iTextPrinterClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_PRINTER);
		iTextResourceClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_RESOURCE);
		iTextResourcePluginPartClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_RESOURCE_PLUGIN_PART);
		iTextScannerClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_SCANNER);
		iTextTokenClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_TOKEN);
		iTokenResolveResultClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_RESOLVE_RESULT);
		iTokenResolverClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_RESOLVER);
		iTokenResolverFactoryClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_RESOLVER_FACTORY);
		iTokenStyleClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_STYLE);
		iUriMappingClassName = getContext().getQualifiedClassName(EArtifact.I_URI_MAPPING);
		inputStreamProcessorClassName = getContext().getQualifiedClassName(EArtifact.INPUT_STREAM_PROCESSOR);
		keywordClassName = getContext().getQualifiedClassName(EArtifact.KEYWORD);
		layoutInformationAdapterClassName = getContext().getQualifiedClassName(EArtifact.LAYOUT_INFORMATION_ADAPTER);
		layoutInformationClassName = getContext().getQualifiedClassName(EArtifact.LAYOUT_INFORMATION);
		lineBreakClassName = getContext().getQualifiedClassName(EArtifact.LINE_BREAK);
		listUtilClassName = getContext().getQualifiedClassName(EArtifact.LIST_UTIL);
		locationMapClassName = getContext().getQualifiedClassName(EArtifact.LOCATION_MAP);
		mapUtilClassName = getContext().getQualifiedClassName(EArtifact.MAP_UTIL);
		markerHelperClassName = getContext().getQualifiedClassName(EArtifact.MARKER_HELPER);
		metaInformationClassName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);
		minimalModelHelperClassName = getContext().getQualifiedClassName(EArtifact.MINIMAL_MODEL_HELPER);
		natureClassName = getContext().getQualifiedClassName(EArtifact.NATURE);
		newFileContentProviderClassName = getContext().getQualifiedClassName(EArtifact.NEW_FILE_CONTENT_PROVIDER);
		newFileWizardClassName = getContext().getQualifiedClassName(EArtifact.NEW_FILE_WIZARD);
		newFileWizardPageClassName = getContext().getQualifiedClassName(EArtifact.NEW_FILE_WIZARD_PAGE);
		occurenceClassName = getContext().getQualifiedClassName(EArtifact.OCCURENCE);
		occurrencePreferencePageClassName = getContext().getQualifiedClassName(EArtifact.OCCURRENCE_PREFERENCE_PAGE);
		outlinePageClassName = getContext().getQualifiedClassName(EArtifact.OUTLINE_PAGE);
		outlinePageTreeViewerClassName = getContext().getQualifiedClassName(EArtifact.OUTLINE_PAGE_TREE_VIEWER);
		pairClassName = getContext().getQualifiedClassName(EArtifact.PAIR);
		parseResultClassName = getContext().getQualifiedClassName(EArtifact.PARSE_RESULT);
		pixelConverterClassName = getContext().getQualifiedClassName(EArtifact.PIXEL_CONVERTER);
		placeholderClassName = getContext().getQualifiedClassName(EArtifact.PLACEHOLDER);
		pluginActivatorClassName = getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR);
		positionCategoryClassName = getContext().getQualifiedClassName(EArtifact.POSITION_CATEGORY);
		positionHelperClassName = getContext().getQualifiedClassName(EArtifact.POSITION_HELPER);
		preferenceConstantsClassName = getContext().getQualifiedClassName(EArtifact.PREFERENCE_CONSTANTS);
		preferenceInitializerClassName = getContext().getQualifiedClassName(EArtifact.PREFERENCE_INITIALIZER);
		preferencePageClassName = getContext().getQualifiedClassName(EArtifact.PREFERENCE_PAGE);
		printer2ClassName = getContext().getQualifiedClassName(EArtifact.PRINTER2);
		printerClassName = getContext().getQualifiedClassName(EArtifact.PRINTER);
		problemClassName = getContext().getQualifiedClassName(EArtifact.PROBLEM);
		propertySheetPageClassName = getContext().getQualifiedClassName(EArtifact.PROPERTY_SHEET_PAGE);
		referenceResolveResultClassName = getContext().getQualifiedClassName(EArtifact.REFERENCE_RESOLVE_RESULT);
		referenceResolverSwitchClassName = getContext().getQualifiedClassName(EArtifact.REFERENCE_RESOLVER_SWITCH);
		resourceFactoryClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE_FACTORY);
		resourceFactoryDelegatorClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE_FACTORY_DELEGATOR);
		resourceUtilClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE_UTIL);
		scannerlessParserClassName = getContext().getQualifiedClassName(EArtifact.SCANNERLESS_PARSER);
		scannerlessScannerClassName = getContext().getQualifiedClassName(EArtifact.SCANNERLESS_SCANNER);
		sequenceClassName = getContext().getQualifiedClassName(EArtifact.SEQUENCE);
		streamUtilClassName = getContext().getQualifiedClassName(EArtifact.STREAM_UTIL);
		stringUtilClassName = getContext().getQualifiedClassName(EArtifact.STRING_UTIL);
		syntaxColoringHelperClassName = getContext().getQualifiedClassName(EArtifact.SYNTAX_COLORING_HELPER);
		syntaxColoringPreferencePageClassName = getContext().getQualifiedClassName(EArtifact.SYNTAX_COLORING_PREFERENCE_PAGE);
		syntaxCoverageInformationProviderClassName = getContext().getQualifiedClassName(EArtifact.SYNTAX_COVERAGE_INFORMATION_PROVIDER);
		syntaxElementClassName = getContext().getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		syntaxElementDecoratorClassName = getContext().getQualifiedClassName(EArtifact.SYNTAX_ELEMENT_DECORATOR);
		terminalClassName = getContext().getQualifiedClassName(EArtifact.TERMINAL);
		terminateParsingExceptionClassName = getContext().getQualifiedClassName(EArtifact.TERMINATE_PARSING_EXCEPTION);
		textHoverClassName = getContext().getQualifiedClassName(EArtifact.TEXT_HOVER);
		textResourceClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE);
		textResourceUtilClassName = getContext().getQualifiedClassName(EArtifact.TEXT_RESOURCE_UTIL);
		textTokenClassName = getContext().getQualifiedClassName(EArtifact.TEXT_TOKEN);
		tokenResolveResultClassName = getContext().getQualifiedClassName(EArtifact.TOKEN_RESOLVE_RESULT);
		tokenResolverClassName = getContext().getQualifiedClassName(EArtifact.TOKEN_RESOLVER);
		tokenResolverFactoryClassName = getContext().getQualifiedClassName(EArtifact.TOKEN_RESOLVER_FACTORY);
		tokenScannerClassName = getContext().getQualifiedClassName(EArtifact.TOKEN_SCANNER);
		tokenStyleInformationProviderClassName = getContext().getQualifiedClassName(EArtifact.TOKEN_STYLE_INFORMATION_PROVIDER);
		unexpectedContentTypeExceptionClassName = getContext().getQualifiedClassName(EArtifact.UNEXPECTED_CONTENT_TYPE_EXCEPTION);
		unicodeConverterClassName = getContext().getQualifiedClassName(EArtifact.UNICODE_CONVERTER);
		uriMappingClassName = getContext().getQualifiedClassName(EArtifact.URI_MAPPING);
		whiteSpaceClassName = getContext().getQualifiedClassName(EArtifact.WHITE_SPACE);
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
