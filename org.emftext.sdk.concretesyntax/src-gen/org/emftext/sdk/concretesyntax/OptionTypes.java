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
/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *  *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 *  
 * 
 */
package org.emftext.sdk.concretesyntax;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Option Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOptionTypes()
 * @model
 * @generated
 */
public enum OptionTypes implements Enumerator {
	/**
	 * The '<em><b>GENERATE TEST ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERATE_TEST_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	GENERATE_TEST_ACTION(0, "GENERATE_TEST_ACTION", "generateTestAction"),

	/**
	 * The '<em><b>GENERATE CODE FROM GENERATOR MODEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERATE_CODE_FROM_GENERATOR_MODEL_VALUE
	 * @generated
	 * @ordered
	 */
	GENERATE_CODE_FROM_GENERATOR_MODEL(1, "GENERATE_CODE_FROM_GENERATOR_MODEL", "generateCodeFromGeneratorModel"),

	/**
	 * The '<em><b>OVERRIDE PLUGIN XML</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLUGIN_XML_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PLUGIN_XML(3, "OVERRIDE_PLUGIN_XML", "overridePluginXML"),

	/**
	 * The '<em><b>OVERRIDE MANIFEST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MANIFEST_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_MANIFEST(4, "OVERRIDE_MANIFEST", "overrideManifest"),

	/**
	 * The '<em><b>OVERRIDE PARSER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PARSER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PARSER(5, "OVERRIDE_PARSER", "overrideParser"),

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVERS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_RESOLVERS(6, "OVERRIDE_TOKEN_RESOLVERS", "overrideTokenResolvers"),

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVERS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_REFERENCE_RESOLVERS(7, "OVERRIDE_REFERENCE_RESOLVERS", "overrideReferenceResolvers"),

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVER SWITCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVER_SWITCH_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_REFERENCE_RESOLVER_SWITCH(8, "OVERRIDE_REFERENCE_RESOLVER_SWITCH", "overrideReferenceResolverSwitch"),

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVER FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVER_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_RESOLVER_FACTORY(9, "OVERRIDE_TOKEN_RESOLVER_FACTORY", "overrideTokenResolverFactory"),

	/**
	 * The '<em><b>OVERRIDE PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PRINTER(10, "OVERRIDE_PRINTER", "overridePrinter"),

	/**
	 * The '<em><b>ANTLR BACKTRACKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTLR_BACKTRACKING_VALUE
	 * @generated
	 * @ordered
	 */
	ANTLR_BACKTRACKING(12, "ANTLR_BACKTRACKING", "backtracking"),

	/**
	 * The '<em><b>ANTLR MEMOIZE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTLR_MEMOIZE_VALUE
	 * @generated
	 * @ordered
	 */
	ANTLR_MEMOIZE(13, "ANTLR_MEMOIZE", "memoize"),

	/**
	 * The '<em><b>AUTOFIX SIMPLE LEFTRECURSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUTOFIX_SIMPLE_LEFTRECURSION_VALUE
	 * @generated
	 * @ordered
	 */
	AUTOFIX_SIMPLE_LEFTRECURSION(14, "AUTOFIX_SIMPLE_LEFTRECURSION", "autofixSimpleLeftrecursion"),

	/**
	 * The '<em><b>FORCE EOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORCE_EOF_VALUE
	 * @generated
	 * @ordered
	 */
	FORCE_EOF(15, "FORCE_EOF", "forceEOF"),

	/**
	 * The '<em><b>DEFAULT TOKEN NAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_TOKEN_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	DEFAULT_TOKEN_NAME(16, "DEFAULT_TOKEN_NAME", "defaultTokenName"),

	/**
	 * The '<em><b>USE PREDEFINED TOKENS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USE_PREDEFINED_TOKENS_VALUE
	 * @generated
	 * @ordered
	 */
	USE_PREDEFINED_TOKENS(17, "USE_PREDEFINED_TOKENS", "usePredefinedTokens"),

	/**
	 * The '<em><b>TOKENSPACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOKENSPACE_VALUE
	 * @generated
	 * @ordered
	 */
	TOKENSPACE(18, "TOKENSPACE", "tokenspace"),

	/**
	 * The '<em><b>RELOAD GENERATOR MODEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELOAD_GENERATOR_MODEL_VALUE
	 * @generated
	 * @ordered
	 */
	RELOAD_GENERATOR_MODEL(19, "RELOAD_GENERATOR_MODEL", "reloadGeneratorModel"),

	/**
	 * The '<em><b>OVERRIDE DOT CLASSPATH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOT_CLASSPATH_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DOT_CLASSPATH(20, "OVERRIDE_DOT_CLASSPATH", "overrideClasspath"),

	/**
	 * The '<em><b>OVERRIDE DOT PROJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOT_PROJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DOT_PROJECT(21, "OVERRIDE_DOT_PROJECT", "overrideProjectFile"),

	/**
	 * The '<em><b>OVERRIDE TEXT RESOURCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_RESOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TEXT_RESOURCE(22, "OVERRIDE_TEXT_RESOURCE", "overrideTextResource"),

	/**
	 * The '<em><b>OVERRIDE RESOURCE FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_RESOURCE_FACTORY(23, "OVERRIDE_RESOURCE_FACTORY", "overrideResourceFactory"),

	/**
	 * The '<em><b>OVERRIDE NEW FILE WIZARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_FILE_WIZARD_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_NEW_FILE_WIZARD(24, "OVERRIDE_NEW_FILE_WIZARD", "overrideNewFileWizard"),

	/**
	 * The '<em><b>PARSER GENERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARSER_GENERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	PARSER_GENERATOR(25, "PARSER_GENERATOR", "parserGenerator"),

	/**
	 * The '<em><b>SOURCE FOLDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOURCE_FOLDER_VALUE
	 * @generated
	 * @ordered
	 */
	SOURCE_FOLDER(26, "SOURCE_FOLDER", "srcFolder"),

	/**
	 * The '<em><b>BASE PACKAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_PACKAGE_VALUE
	 * @generated
	 * @ordered
	 */
	BASE_PACKAGE(27, "BASE_PACKAGE", "basePackage"),

	/**
	 * The '<em><b>RESOURCE PLUGIN ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_PLUGIN_ID_VALUE
	 * @generated
	 * @ordered
	 */
	RESOURCE_PLUGIN_ID(28, "RESOURCE_PLUGIN_ID", "resourcePluginID"),

	/**
	 * The '<em><b>OVERRIDE BUILD PROPERTIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BUILD_PROPERTIES_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BUILD_PROPERTIES(29, "OVERRIDE_BUILD_PROPERTIES", "overrideBuildProperties"),

	/**
	 * The '<em><b>OVERRIDE META INFORMATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_META_INFORMATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_META_INFORMATION(30, "OVERRIDE_META_INFORMATION", "overrideMetaInformation"),

	/**
	 * The '<em><b>OVERRIDE DEFAULT RESOLVER DELEGATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_RESOLVER_DELEGATE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEFAULT_RESOLVER_DELEGATE(31, "OVERRIDE_DEFAULT_RESOLVER_DELEGATE", "overrideDefaultResolverDelegate"),

	/**
	 * The '<em><b>OVERRIDE PROBLEM CLASS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PROBLEM_CLASS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PROBLEM_CLASS(32, "OVERRIDE_PROBLEM_CLASS", "overrideProblemClass"),

	/**
	 * The '<em><b>OVERRIDE SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SCANNER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SCANNER(33, "OVERRIDE_SCANNER", "overrideScanner"),

	/**
	 * The '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT(34, "OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT", "overrideContextDependentURIFragment"),

	/**
	 * The '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY(35, "OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY", "overrideContextDependentURIFragmentFactory"),

	/**
	 * The '<em><b>OVERRIDE DELEGATING RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DELEGATING_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DELEGATING_RESOLVE_RESULT(36, "OVERRIDE_DELEGATING_RESOLVE_RESULT", "overrideDelegatingResolveResult"),

	/**
	 * The '<em><b>OVERRIDE DUMMY EOBJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DUMMY_EOBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DUMMY_EOBJECT(37, "OVERRIDE_DUMMY_E_OBJECT", "overrideDummyEObject"),

	/**
	 * The '<em><b>OVERRIDE ELEMENT MAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ELEMENT_MAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ELEMENT_MAPPING(38, "OVERRIDE_ELEMENT_MAPPING", "overrideElementMapping"),

	/**
	 * The '<em><b>OVERRIDE FUZZY RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FUZZY_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_FUZZY_RESOLVE_RESULT(39, "OVERRIDE_FUZZY_RESOLVE_RESULT", "overrideFuzzyResolveResult"),

	/**
	 * The '<em><b>OVERRIDE DEFAULT TOKEN RESOLVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_TOKEN_RESOLVER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEFAULT_TOKEN_RESOLVER(40, "OVERRIDE_DEFAULT_TOKEN_RESOLVER", "overrideDefaultTokenResolver"),

	/**
	 * The '<em><b>OVERRIDE LOCATION MAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LOCATION_MAP_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LOCATION_MAP(41, "OVERRIDE_LOCATION_MAP", "overrideLocationMap"),

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_REFERENCE_RESOLVE_RESULT(42, "OVERRIDE_REFERENCE_RESOLVE_RESULT", "overrideReferenceResolveResult"),

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_RESOLVE_RESULT(43, "OVERRIDE_TOKEN_RESOLVE_RESULT", "overrideTokenResolveResult"),

	/**
	 * The '<em><b>OVERRIDE URI MAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_URI_MAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_URI_MAPPING(45, "OVERRIDE_URI_MAPPING", "overrideURIMapping"),

	/**
	 * The '<em><b>OVERRIDE HOVER TEXT PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HOVER_TEXT_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HOVER_TEXT_PROVIDER(46, "OVERRIDE_HOVER_TEXT_PROVIDER", "overrideHoverTextProvider"),

	/**
	 * The '<em><b>OVERRIDE PARSE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PARSE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PARSE_RESULT(47, "OVERRIDE_PARSE_RESULT", "overrideParseResult"),

	/**
	 * The '<em><b>OVERRIDE ANTLR TOKEN HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANTLR_TOKEN_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ANTLR_TOKEN_HELPER(48, "OVERRIDE_ANTLR_TOKEN_HELPER", "overrideAntlrTokenHelper"),

	/**
	 * The '<em><b>OVERRIDE BRACKET SET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BRACKET_SET_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BRACKET_SET(49, "OVERRIDE_BRACKET_SET", "overrideBracketSet"),

	/**
	 * The '<em><b>OVERRIDE BROWSER INFORMATION CONTROL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BROWSER_INFORMATION_CONTROL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BROWSER_INFORMATION_CONTROL(50, "OVERRIDE_BROWSER_INFORMATION_CONTROL", "overrideBrowserInformationControl"),

	/**
	 * The '<em><b>OVERRIDE CODE FOLDING MANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CODE_FOLDING_MANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CODE_FOLDING_MANAGER(51, "OVERRIDE_CODE_FOLDING_MANAGER", "overrideCodeFoldingManager"),

	/**
	 * The '<em><b>OVERRIDE COLOR MANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COLOR_MANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COLOR_MANAGER(52, "OVERRIDE_COLOR_MANAGER", "overrideColorManager"),

	/**
	 * The '<em><b>OVERRIDE COMPLETION PROCESSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COMPLETION_PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COMPLETION_PROCESSOR(53, "OVERRIDE_COMPLETION_PROCESSOR", "overrideCompletionProcessor"),

	/**
	 * The '<em><b>OVERRIDE PARSING STRATEGY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PARSING_STRATEGY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PARSING_STRATEGY(54, "OVERRIDE_PARSING_STRATEGY", "overrideParsingStrategy"),

	/**
	 * The '<em><b>OVERRIDE DOC BROWSER INFORMATION CONTROL INPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT(55, "OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT", "overrideDocBrowserInformationControlInput"),

	/**
	 * The '<em><b>OVERRIDE EDITOR CONFIGURATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EDITOR_CONFIGURATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EDITOR_CONFIGURATION(55, "OVERRIDE_EDITOR_CONFIGURATION", "overrideEditorConfiguration"),

	/**
	 * The '<em><b>OVERRIDE EDITOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EDITOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EDITOR(56, "OVERRIDE_EDITOR", "overrideEditor"),

	/**
	 * The '<em><b>OVERRIDE EOBJECT SELECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EOBJECT_SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EOBJECT_SELECTION(57, "OVERRIDE_E_OBJECT_SELECTION", "overrideEObjectSelection"),

	/**
	 * The '<em><b>OVERRIDE HIGHLIGHTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HIGHLIGHTING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HIGHLIGHTING(58, "OVERRIDE_HIGHLIGHTING", "overrideHighlighting"),

	/**
	 * The '<em><b>OVERRIDE HTML PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HTML_PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HTML_PRINTER(59, "OVERRIDE_HTML_PRINTER", "overrideHTMLPrinter"),

	/**
	 * The '<em><b>OVERRIDE HYPERLINK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HYPERLINK_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HYPERLINK(60, "OVERRIDE_HYPERLINK", "overrideHyperlink"),

	/**
	 * The '<em><b>OVERRIDE HYPERLINK DETECTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HYPERLINK_DETECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HYPERLINK_DETECTOR(61, "OVERRIDE_HYPERLINK_DETECTOR", "overrideHyperlinkDetector"),

	/**
	 * The '<em><b>OVERRIDE MARKER HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MARKER_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_MARKER_HELPER(62, "OVERRIDE_MARKER_HELPER", "overrideMarkerHelper"),

	/**
	 * The '<em><b>OVERRIDE OCCURRENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OCCURRENCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OCCURRENCE(63, "OVERRIDE_OCCURRENCE", "overrideOccurrence"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE(64, "OVERRIDE_OUTLINE_PAGE", "overrideOutlinePage"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE TREE VIEWER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_TREE_VIEWER(65, "OVERRIDE_OUTLINE_PAGE_TREE_VIEWER", "overrideOutlinePageTreeViewer"),

	/**
	 * The '<em><b>OVERRIDE PLUGIN ACTIVATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLUGIN_ACTIVATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PLUGIN_ACTIVATOR(66, "OVERRIDE_PLUGIN_ACTIVATOR", "overridePluginActivator"),

	/**
	 * The '<em><b>OVERRIDE POSITION CATEGORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_POSITION_CATEGORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_POSITION_CATEGORY(67, "OVERRIDE_POSITION_CATEGORY", "overridePositionCategory"),

	/**
	 * The '<em><b>OVERRIDE POSITION HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_POSITION_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_POSITION_HELPER(68, "OVERRIDE_POSITION_HELPER", "overridePositionHelper"),

	/**
	 * The '<em><b>OVERRIDE PROPERTY SHEET PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PROPERTY_SHEET_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PROPERTY_SHEET_PAGE(69, "OVERRIDE_PROPERTY_SHEET_PAGE", "overridePropertySheetPage"),

	/**
	 * The '<em><b>OVERRIDE TEXT HOVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_HOVER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TEXT_HOVER(70, "OVERRIDE_TEXT_HOVER", "overrideTextHover"),

	/**
	 * The '<em><b>OVERRIDE TOKEN SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_SCANNER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_SCANNER(71, "OVERRIDE_TOKEN_SCANNER", "overrideTokenScanner"),

	/**
	 * The '<em><b>OVERRIDE BRACKET PREFERENCE PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BRACKET_PREFERENCE_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BRACKET_PREFERENCE_PAGE(72, "OVERRIDE_BRACKET_PREFERENCE_PAGE", "overrideBracketPreferencePage"),

	/**
	 * The '<em><b>OVERRIDE PREFERENCE CONSTANTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PREFERENCE_CONSTANTS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PREFERENCE_CONSTANTS(73, "OVERRIDE_PREFERENCE_CONSTANTS", "overridePreferenceConstants"),

	/**
	 * The '<em><b>OVERRIDE OCCURRENCE PREFERENCE PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OCCURRENCE_PREFERENCE_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OCCURRENCE_PREFERENCE_PAGE(74, "OVERRIDE_OCCURRENCE_PREFERENCE_PAGE", "overrideOccurrencePreferencePage"),

	/**
	 * The '<em><b>OVERRIDE PIXEL CONVERTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PIXEL_CONVERTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PIXEL_CONVERTER(75, "OVERRIDE_PIXEL_CONVERTER", "overridePixelConverter"),

	/**
	 * The '<em><b>OVERRIDE PREFERENCE INITIALIZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PREFERENCE_INITIALIZER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PREFERENCE_INITIALIZER(76, "OVERRIDE_PREFERENCE_INITIALIZER", "overridePreferenceInitializer"),

	/**
	 * The '<em><b>OVERRIDE SYNTAX COLORING HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_COLORING_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SYNTAX_COLORING_HELPER(77, "OVERRIDE_SYNTAX_COLORING_HELPER", "overrideSyntaxColoringHelper"),

	/**
	 * The '<em><b>OVERRIDE SYNTAX COLORING PREFERENCE PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE(78, "OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE", "overrideSyntaxColoringPreferencePage"),

	/**
	 * The '<em><b>OVERRIDE IINPUT STREAM PROCESSOR PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER(79, "OVERRIDE_I_INPUT_STREAM_PROCESSOR_PROVIDER", "overrideIInputStreamProcessorProvider"),

	/**
	 * The '<em><b>OVERRIDE INPUT STREAM PROCESSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_INPUT_STREAM_PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_INPUT_STREAM_PROCESSOR(80, "OVERRIDE_INPUT_STREAM_PROCESSOR", "overrideInputStreamProcessor"),

	/**
	 * The '<em><b>OVERRIDE IOPTION PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IOPTION_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IOPTION_PROVIDER(81, "OVERRIDE_I_OPTION_PROVIDER", "overrideIOptionProvider"),

	/**
	 * The '<em><b>OVERRIDE IOPTIONS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IOPTIONS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IOPTIONS(82, "OVERRIDE_I_OPTIONS", "overrideIOptions"),

	/**
	 * The '<em><b>OVERRIDE IRESOURCE POST PROCESSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IRESOURCE_POST_PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IRESOURCE_POST_PROCESSOR(83, "OVERRIDE_I_RESOURCE_POST_PROCESSOR", "overrideIResourcePostProcessor"),

	/**
	 * The '<em><b>OVERRIDE IRESOURCE POST PROCESSOR PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER(84, "OVERRIDE_I_RESOURCE_POST_PROCESSOR_PROVIDER", "overrideIResourcePostProcessorProvider"),

	/**
	 * The '<em><b>OVERRIDE IBRACKET PAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IBRACKET_PAIR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IBRACKET_PAIR(85, "OVERRIDE_I_BRACKET_PAIR", "overrideIBracketPair"),

	/**
	 * The '<em><b>OVERRIDE ICOMMAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ICOMMAND_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ICOMMAND(86, "OVERRIDE_I_COMMAND", "overrideICommand"),

	/**
	 * The '<em><b>OVERRIDE ICONFIGURABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ICONFIGURABLE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ICONFIGURABLE(87, "OVERRIDE_I_CONFIGURABLE", "overrideIConfigurable"),

	/**
	 * The '<em><b>OVERRIDE ICONTEXT DEPENDENT URI FRAGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT(88, "OVERRIDE_I_CONTEXT_DEPENDENT_URI_FRAGMENT", "overrideIContextDependentURIFragment"),

	/**
	 * The '<em><b>OVERRIDE ICONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY(89, "OVERRIDE_I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY", "overrideIContextDependentURIFragmentFactory"),

	/**
	 * The '<em><b>OVERRIDE IELEMENT MAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IELEMENT_MAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IELEMENT_MAPPING(90, "OVERRIDE_I_ELEMENT_MAPPING", "overrideIElementMapping"),

	/**
	 * The '<em><b>OVERRIDE IEXPECTED ELEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IEXPECTED_ELEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IEXPECTED_ELEMENT(91, "OVERRIDE_I_EXPECTED_ELEMENT", "overrideIExpectedElement"),

	/**
	 * The '<em><b>OVERRIDE IHOVER TEXT PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IHOVER_TEXT_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IHOVER_TEXT_PROVIDER(92, "OVERRIDE_I_HOVER_TEXT_PROVIDER", "overrideIHoverTextProvider"),

	/**
	 * The '<em><b>OVERRIDE ILOCATION MAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ILOCATION_MAP_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ILOCATION_MAP(93, "OVERRIDE_I_LOCATION_MAP", "overrideILocationMap"),

	/**
	 * The '<em><b>OVERRIDE IPARSE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IPARSE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IPARSE_RESULT(94, "OVERRIDE_I_PARSE_RESULT", "overrideIParseResult"),

	/**
	 * The '<em><b>OVERRIDE IPROBLEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IPROBLEM_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IPROBLEM(95, "OVERRIDE_I_PROBLEM", "overrideIProblem"),

	/**
	 * The '<em><b>OVERRIDE IREFERENCE MAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_MAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IREFERENCE_MAPPING(96, "OVERRIDE_I_REFERENCE_MAPPING", "overrideIReferenceMapping"),

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IREFERENCE_RESOLVER(97, "OVERRIDE_I_REFERENCE_RESOLVER", "overrideIReferenceResolver"),

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IREFERENCE_RESOLVE_RESULT(98, "OVERRIDE_I_REFERENCE_RESOLVE_RESULT", "overrideIReferenceResolveResult"),

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVER SWITCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVER_SWITCH_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IREFERENCE_RESOLVER_SWITCH(99, "OVERRIDE_I_REFERENCE_RESOLVER_SWITCH", "overrideIReferenceResolverSwitch"),

	/**
	 * The '<em><b>OVERRIDE ITEXT DIAGNOSTIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_DIAGNOSTIC_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITEXT_DIAGNOSTIC(100, "OVERRIDE_I_TEXT_DIAGNOSTIC", "overrideITextDiagnostic"),

	/**
	 * The '<em><b>OVERRIDE ITEXT PARSER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_PARSER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITEXT_PARSER(101, "OVERRIDE_I_TEXT_PARSER", "overrideITextParser"),

	/**
	 * The '<em><b>OVERRIDE ITEXT PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITEXT_PRINTER(102, "OVERRIDE_I_TEXT_PRINTER", "overrideITextPrinter"),

	/**
	 * The '<em><b>OVERRIDE ITEXT RESOURCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_RESOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITEXT_RESOURCE(103, "OVERRIDE_I_TEXT_RESOURCE", "overrideITextResource"),

	/**
	 * The '<em><b>OVERRIDE IMETA INFORMATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IMETA_INFORMATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IMETA_INFORMATION(104, "OVERRIDE_I_META_INFORMATION", "overrideIMetaInformation"),

	/**
	 * The '<em><b>OVERRIDE ITEXT RESOURCE PLUGIN PART</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART(105, "OVERRIDE_I_TEXT_RESOURCE_PLUGIN_PART", "overrideITextResourcePluginPart"),

	/**
	 * The '<em><b>OVERRIDE ITEXT SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_SCANNER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITEXT_SCANNER(106, "OVERRIDE_I_TEXT_SCANNER", "overrideITextScanner"),

	/**
	 * The '<em><b>OVERRIDE ITEXT TOKEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_TOKEN_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITEXT_TOKEN(107, "OVERRIDE_I_TEXT_TOKEN", "overrideITextToken"),

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITOKEN_RESOLVER(108, "OVERRIDE_I_TOKEN_RESOLVER", "overrideITokenResolver"),

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITOKEN_RESOLVE_RESULT(109, "OVERRIDE_I_TOKEN_RESOLVE_RESULT", "overrideITokenResolveResult"),

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVER FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVER_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITOKEN_RESOLVER_FACTORY(110, "OVERRIDE_I_TOKEN_RESOLVER_FACTORY", "overrideITokenResolverFactory"),

	/**
	 * The '<em><b>OVERRIDE ITOKEN STYLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITOKEN_STYLE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ITOKEN_STYLE(111, "OVERRIDE_I_TOKEN_STYLE", "overrideITokenStyle"),

	/**
	 * The '<em><b>OVERRIDE IURI MAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IURI_MAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IURI_MAPPING(112, "OVERRIDE_I_URI_MAPPING", "overrideIURIMapping"),

	/**
	 * The '<em><b>OVERRIDE EPROBLEM TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EPROBLEM_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EPROBLEM_TYPE(113, "OVERRIDE_E_PROBLEM_TYPE", "overrideEProblemType"),

	/**
	 * The '<em><b>OVERRIDE CODE COMPLETION HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CODE_COMPLETION_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CODE_COMPLETION_HELPER(114, "OVERRIDE_CODE_COMPLETION_HELPER", "overrideCodeCompletionHelper"),

	/**
	 * The '<em><b>OVERRIDE EXPECTED CS STRING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTED_CS_STRING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EXPECTED_CS_STRING(115, "OVERRIDE_EXPECTED_CS_STRING", "overrideExpectedCsString"),

	/**
	 * The '<em><b>OVERRIDE EXPECTED STRUCTURAL FEATURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTED_STRUCTURAL_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EXPECTED_STRUCTURAL_FEATURE(116, "OVERRIDE_EXPECTED_STRUCTURAL_FEATURE", "overrideExpectedStructuralFeature"),

	/**
	 * The '<em><b>OVERRIDE CAST UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CAST_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CAST_UTIL(117, "OVERRIDE_CAST_UTIL", "overrideCastUtil"),

	/**
	 * The '<em><b>OVERRIDE COPIED ELIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COPIED_ELIST_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COPIED_ELIST(118, "OVERRIDE_COPIED_E_LIST", "overrideCopiedEList"),

	/**
	 * The '<em><b>OVERRIDE COPIED EOBJECT INTERNAL ELIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST(119, "OVERRIDE_COPIED_E_OBJECT_INTERNAL_E_LIST", "overrideCopiedEObjectInternalEList"),

	/**
	 * The '<em><b>OVERRIDE ECLASS UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ECLASS_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ECLASS_UTIL(120, "OVERRIDE_E_CLASS_UTIL", "overrideEClassUtil"),

	/**
	 * The '<em><b>OVERRIDE EOBJECT UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EOBJECT_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EOBJECT_UTIL(121, "OVERRIDE_E_OBJECT_UTIL", "overrideEObjectUtil"),

	/**
	 * The '<em><b>OVERRIDE LIST UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LIST_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LIST_UTIL(122, "OVERRIDE_LIST_UTIL", "overrideListUtil"),

	/**
	 * The '<em><b>OVERRIDE MAP UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MAP_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_MAP_UTIL(123, "OVERRIDE_MAP_UTIL", "overrideMapUtil"),

	/**
	 * The '<em><b>OVERRIDE MINIMAL MODEL HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MINIMAL_MODEL_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_MINIMAL_MODEL_HELPER(124, "OVERRIDE_MINIMAL_MODEL_HELPER", "overrideMinimalModelHelper"),

	/**
	 * The '<em><b>OVERRIDE RESOURCE UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_RESOURCE_UTIL(125, "OVERRIDE_RESOURCE_UTIL", "overrideResourceUtil"),

	/**
	 * The '<em><b>OVERRIDE STREAM UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_STREAM_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_STREAM_UTIL(126, "OVERRIDE_STREAM_UTIL", "overrideStreamUtil"),

	/**
	 * The '<em><b>OVERRIDE STRING UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_STRING_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_STRING_UTIL(127, "OVERRIDE_STRING_UTIL", "overrideStringUtil"),

	/**
	 * The '<em><b>OVERRIDE TEXT RESOURCE UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_RESOURCE_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TEXT_RESOURCE_UTIL(128, "OVERRIDE_TEXT_RESOURCE_UTIL", "overrideTextResourceUtil"),

	/**
	 * The '<em><b>OVERRIDE UNICODE CONVERTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UNICODE_CONVERTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UNICODE_CONVERTER(129, "OVERRIDE_UNICODE_CONVERTER", "overrideUnicodeConverter"),

	/**
	 * The '<em><b>OVERRIDE ABSTRACT EXPECTED ELEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ABSTRACT_EXPECTED_ELEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ABSTRACT_EXPECTED_ELEMENT(130, "OVERRIDE_ABSTRACT_EXPECTED_ELEMENT", "overrideAbstractExpectedElement"),

	/**
	 * The '<em><b>OVERRIDE NEW FILE WIZARD PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_FILE_WIZARD_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_NEW_FILE_WIZARD_PAGE(131, "OVERRIDE_NEW_FILE_WIZARD_PAGE", "overrideNewFileWizardPage"),

	/**
	 * The '<em><b>OVERRIDE IBACKGROUND PARSING LISTENER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IBACKGROUND_PARSING_LISTENER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IBACKGROUND_PARSING_LISTENER(132, "OVERRIDE_I_BACKGROUND_PARSING_LISTENER", "overrideIBackgroundParsingListener"),

	/**
	 * The '<em><b>OVERRIDE TERMINATE PARSING EXCEPTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TERMINATE_PARSING_EXCEPTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TERMINATE_PARSING_EXCEPTION(133, "OVERRIDE_TERMINATE_PARSING_EXCEPTION", "overrideTerminateParsingException"),

	/**
	 * The '<em><b>OVERRIDE UNEXPECTED CONTENT TYPE EXCEPTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION(134, "OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION", "overrideUnexpectedContentTypeException"),

	/**
	 * The '<em><b>OVERRIDE TEXT TOKEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_TOKEN_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TEXT_TOKEN(135, "OVERRIDE_TEXT_TOKEN", "overrideTextToken"),

	/**
	 * The '<em><b>SOURCE GEN FOLDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOURCE_GEN_FOLDER_VALUE
	 * @generated
	 * @ordered
	 */
	SOURCE_GEN_FOLDER(136, "SOURCE_GEN_FOLDER", "srcGenFolder"),

	/**
	 * The '<em><b>OVERRIDE DEFAULT LOAD OPTIONS EXTENSION POINT SCHEMA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA(137, "OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA", "overrideDefaultLoadOptionsExtensionPointSchema"),

	/**
	 * The '<em><b>OVERRIDE ADDITIONAL EXTENSION PARSER EXTENSION POINT SCHEMA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA(138, "OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA", "overrideAdditionalExtensionParserExtensionPointSchema"),

	/**
	 * The '<em><b>OVERRIDE RESOURCE FACTORY DELEGATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_FACTORY_DELEGATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_RESOURCE_FACTORY_DELEGATOR(139, "OVERRIDE_RESOURCE_FACTORY_DELEGATOR", "overrideResourceFactoryDelegator"),

	/**
	 * The '<em><b>BASE RESOURCE PLUGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASE_RESOURCE_PLUGIN_VALUE
	 * @generated
	 * @ordered
	 */
	BASE_RESOURCE_PLUGIN(140, "BASE_RESOURCE_PLUGIN", "baseResourcePlugin"),

	/**
	 * The '<em><b>OVERRIDE PREFERENCE PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PREFERENCE_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PREFERENCE_PAGE(141, "OVERRIDE_PREFERENCE_PAGE", "overridePreferencePage"),

	/**
	 * The '<em><b>ANTLR PLUGIN ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTLR_PLUGIN_ID_VALUE
	 * @generated
	 * @ordered
	 */
	ANTLR_PLUGIN_ID(142, "ANTLR_PLUGIN_ID", "antlrPluginID"),

	/**
	 * The '<em><b>OVERRIDE ANTLR PLUGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANTLR_PLUGIN_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ANTLR_PLUGIN(143, "OVERRIDE_ANTLR_PLUGIN", "overrideAntlrPlugin"),

	/**
	 * The '<em><b>OVERRIDE TOKEN STYLE INFORMATION PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER(144, "OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER", "overrideTokenStyleInformationProvider"),

	/**
	 * The '<em><b>OVERRIDE FOLDING INFORMATION PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FOLDING_INFORMATION_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_FOLDING_INFORMATION_PROVIDER(145, "OVERRIDE_FOLDING_INFORMATION_PROVIDER", "overrideFoldingInformationProvider"),

	/**
	 * The '<em><b>OVERRIDE BRACKET INFORMATION PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BRACKET_INFORMATION_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BRACKET_INFORMATION_PROVIDER(146, "OVERRIDE_BRACKET_INFORMATION_PROVIDER", "overrideBracketInformationProvider"),

	/**
	 * The '<em><b>OVERRIDE SYNTAX COVERAGE INFORMATION PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER(147, "OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER", "overrideSyntaxCoverageInformationProvider"),

	/**
	 * The '<em><b>SAVE CHANGED RESOURCES ONLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAVE_CHANGED_RESOURCES_ONLY_VALUE
	 * @generated
	 * @ordered
	 */
	SAVE_CHANGED_RESOURCES_ONLY(148, "SAVE_CHANGED_RESOURCES_ONLY", "saveChangedResourcesOnly"),

	/**
	 * The '<em><b>OVERRIDE NEW FILE CONTENT PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_FILE_CONTENT_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_NEW_FILE_CONTENT_PROVIDER(149, "OVERRIDE_NEW_FILE_CONTENT_PROVIDER", "overrideNewFileContentProvider"),

	/**
	 * The '<em><b>LICENCE HEADER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LICENCE_HEADER_VALUE
	 * @generated
	 * @ordered
	 */
	LICENCE_HEADER(150, "LICENCE_HEADER", "licenceHeader"),

	/**
	 * The '<em><b>OVERRIDE EXPECTED TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTED_TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EXPECTED_TERMINAL(151, "OVERRIDE_EXPECTED_TERMINAL", "overrideExpectedTerminal"),

	/**
	 * The '<em><b>OVERRIDE COMPLETION PROPOSAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COMPLETION_PROPOSAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COMPLETION_PROPOSAL(152, "OVERRIDE_COMPLETION_PROPOSAL", "overrideCompletionProposal"),

	/**
	 * The '<em><b>OVERRIDE BUILDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BUILDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BUILDER(153, "OVERRIDE_BUILDER", "overrideBuilder"),

	/**
	 * The '<em><b>OVERRIDE BUILDER ADAPTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BUILDER_ADAPTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BUILDER_ADAPTER(154, "OVERRIDE_BUILDER_ADAPTER", "overrideBuilderAdapter"),

	/**
	 * The '<em><b>OVERRIDE IBUILDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IBUILDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IBUILDER(155, "OVERRIDE_I_BUILDER", "overrideIBuilder"),

	/**
	 * The '<em><b>OVERRIDE NATURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NATURE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_NATURE(156, "OVERRIDE_NATURE", "overrideNature"),

	/**
	 * The '<em><b>ADDITIONAL DEPENDENCIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_DEPENDENCIES_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_DEPENDENCIES(157, "ADDITIONAL_DEPENDENCIES", "additionalDependencies"),

	/**
	 * The '<em><b>DISABLE BUILDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_BUILDER_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_BUILDER(158, "DISABLE_BUILDER", "disableBuilder"),

	/**
	 * The '<em><b>ADDITIONAL EXPORTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_EXPORTS_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_EXPORTS(159, "ADDITIONAL_EXPORTS", "additionalExports"),

	/**
	 * The '<em><b>OVERRIDE PAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PAIR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PAIR(160, "OVERRIDE_PAIR", "overridePair"),

	/**
	 * The '<em><b>OVERRIDE ABSTRACT INTERPRETER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ABSTRACT_INTERPRETER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ABSTRACT_INTERPRETER(161, "OVERRIDE_ABSTRACT_INTERPRETER", "overrideAbstractInterpreter"),

	/**
	 * The '<em><b>OVERRIDE GRAMMAR INFORMATION PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_GRAMMAR_INFORMATION_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_GRAMMAR_INFORMATION_PROVIDER(162, "OVERRIDE_GRAMMAR_INFORMATION_PROVIDER", "overrideGrammarInformationProvider"),

	/**
	 * The '<em><b>OVERRIDE ATTRIBUTE VALUE PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ATTRIBUTE_VALUE_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ATTRIBUTE_VALUE_PROVIDER(163, "OVERRIDE_ATTRIBUTE_VALUE_PROVIDER", "overrideAttributeValueProvider"),

	/**
	 * The '<em><b>OVERRIDE FOLLOW SET PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FOLLOW_SET_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_FOLLOW_SET_PROVIDER(164, "OVERRIDE_FOLLOW_SET_PROVIDER", "overrideFollowSetProvider"),

	/**
	 * The '<em><b>OVERRIDE SYNTAX ELEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_ELEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SYNTAX_ELEMENT(165, "OVERRIDE_SYNTAX_ELEMENT", "overrideSyntaxElement"),

	/**
	 * The '<em><b>OVERRIDE KEYWORD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_KEYWORD_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_KEYWORD(166, "OVERRIDE_KEYWORD", "overrideKeyword"),

	/**
	 * The '<em><b>OVERRIDE PLACEHOLDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLACEHOLDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PLACEHOLDER(167, "OVERRIDE_PLACEHOLDER", "overridePlaceholder"),

	/**
	 * The '<em><b>OVERRIDE CARDINALITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CARDINALITY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CARDINALITY(168, "OVERRIDE_CARDINALITY", "overrideCardinality"),

	/**
	 * The '<em><b>OVERRIDE PRINTER2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PRINTER2_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PRINTER2(169, "OVERRIDE_PRINTER2", "overridePrinter2"),

	/**
	 * The '<em><b>OVERRIDE CHOICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CHOICE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CHOICE(170, "OVERRIDE_CHOICE", "overrideChoice"),

	/**
	 * The '<em><b>OVERRIDE COMPOUND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COMPOUND_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COMPOUND(171, "OVERRIDE_COMPOUND", "overrideCompound"),

	/**
	 * The '<em><b>OVERRIDE CONTAINMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTAINMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CONTAINMENT(172, "OVERRIDE_CONTAINMENT", "overrideContainment"),

	/**
	 * The '<em><b>OVERRIDE LINE BREAK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LINE_BREAK_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LINE_BREAK(173, "OVERRIDE_LINE_BREAK", "overrideLineBreak"),

	/**
	 * The '<em><b>OVERRIDE SEQUENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SEQUENCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SEQUENCE(174, "OVERRIDE_SEQUENCE", "overrideSequence"),

	/**
	 * The '<em><b>OVERRIDE WHITE SPACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_WHITE_SPACE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_WHITE_SPACE(175, "OVERRIDE_WHITE_SPACE", "overrideWhiteSpace"),

	/**
	 * The '<em><b>OVERRIDE SYNTAX ELEMENT DECORATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_ELEMENT_DECORATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SYNTAX_ELEMENT_DECORATOR(176, "OVERRIDE_SYNTAX_ELEMENT_DECORATOR", "overrideSyntaxElementDecorator"),

	/**
	 * The '<em><b>OVERRIDE IREFERENCE CACHE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_CACHE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IREFERENCE_CACHE(177, "OVERRIDE_I_REFERENCE_CACHE", "overrideIReferenceCache"),

	/**
	 * The '<em><b>OVERRIDE DEFAULT HOVER TEXT PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER(178, "OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER", "overrideDefaultHoverTextProvider"),

	/**
	 * The '<em><b>OVERRIDE FORMATTING ELEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FORMATTING_ELEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_FORMATTING_ELEMENT(179, "OVERRIDE_FORMATTING_ELEMENT", "overrideFormattingElement"),

	/**
	 * The '<em><b>OVERRIDE TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TERMINAL(180, "OVERRIDE_TERMINAL", "overrideTerminal"),

	/**
	 * The '<em><b>OVERRIDE LAYOUT INFORMATION ADAPTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAYOUT_INFORMATION_ADAPTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAYOUT_INFORMATION_ADAPTER(181, "OVERRIDE_LAYOUT_INFORMATION_ADAPTER", "overrideLayoutInformationAdapter"),

	/**
	 * The '<em><b>OVERRIDE LAYOUT INFORMATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAYOUT_INFORMATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAYOUT_INFORMATION(182, "OVERRIDE_LAYOUT_INFORMATION", "overrideLayoutInformation"),

	/**
	 * The '<em><b>USE CLASSIC PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USE_CLASSIC_PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	USE_CLASSIC_PRINTER(183, "USE_CLASSIC_PRINTER", "useClassicPrinter"),

	/**
	 * The '<em><b>DISABLE EVALIDATORS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_EVALIDATORS_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_EVALIDATORS(184, "DISABLE_E_VALIDATORS", "disableEValidators"),

	/**
	 * The '<em><b>DISABLE EMF VALIDATION CONSTRAINTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_EMF_VALIDATION_CONSTRAINTS_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_EMF_VALIDATION_CONSTRAINTS(185, "DISABLE_EMF_VALIDATION_CONSTRAINTS", "disableEMFValidationConstraints"),

	/**
	 * The '<em><b>OVERRIDE UI META INFORMATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_META_INFORMATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_META_INFORMATION(186, "OVERRIDE_UI_META_INFORMATION", "overrideUIMetaInformation"),

	/**
	 * The '<em><b>RESOURCE UI PLUGIN ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_UI_PLUGIN_ID_VALUE
	 * @generated
	 * @ordered
	 */
	RESOURCE_UI_PLUGIN_ID(187, "RESOURCE_UI_PLUGIN_ID", "resourceUIPluginID"),

	/**
	 * The '<em><b>OVERRIDE UI PLUGIN ACTIVATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_PLUGIN_ACTIVATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_PLUGIN_ACTIVATOR(188, "OVERRIDE_UI_PLUGIN_ACTIVATOR", "overrideUIPluginActivator"),

	/**
	 * The '<em><b>UI BASE PACKAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UI_BASE_PACKAGE_VALUE
	 * @generated
	 * @ordered
	 */
	UI_BASE_PACKAGE(189, "UI_BASE_PACKAGE", "uiBasePackage"),

	/**
	 * The '<em><b>ADDITIONAL UI DEPENDENCIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_UI_DEPENDENCIES_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_UI_DEPENDENCIES(190, "ADDITIONAL_UI_DEPENDENCIES", "additionalUIDependencies"),

	/**
	 * The '<em><b>ADDITIONAL UI EXPORTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_UI_EXPORTS_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_UI_EXPORTS(191, "ADDITIONAL_UI_EXPORTS", "additionalUIExports"),

	/**
	 * The '<em><b>OVERRIDE UI MANIFEST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_MANIFEST_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_MANIFEST(192, "OVERRIDE_UI_MANIFEST", "overrideUIManifest"),

	/**
	 * The '<em><b>OVERRIDE UI BUILD PROPERTIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_BUILD_PROPERTIES_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_BUILD_PROPERTIES(193, "OVERRIDE_UI_BUILD_PROPERTIES", "overrideUIBuildProperties"),

	/**
	 * The '<em><b>OVERRIDE UI DOT CLASSPATH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_DOT_CLASSPATH_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_DOT_CLASSPATH(194, "OVERRIDE_UI_DOT_CLASSPATH", "overrideUIDotClasspath"),

	/**
	 * The '<em><b>OVERRIDE UI DOT PROJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_DOT_PROJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_DOT_PROJECT(195, "OVERRIDE_UI_DOT_PROJECT", "overrideUIDotProject"),

	/**
	 * The '<em><b>UI SOURCE FOLDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UI_SOURCE_FOLDER_VALUE
	 * @generated
	 * @ordered
	 */
	UI_SOURCE_FOLDER(196, "UI_SOURCE_FOLDER", "uiSrcFolder"),

	/**
	 * The '<em><b>UI SOURCE GEN FOLDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UI_SOURCE_GEN_FOLDER_VALUE
	 * @generated
	 * @ordered
	 */
	UI_SOURCE_GEN_FOLDER(197, "UI_SOURCE_GEN_FOLDER", "uiSrcGenFolder"),

	/**
	 * The '<em><b>GENERATE UI PLUGIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERATE_UI_PLUGIN_VALUE
	 * @generated
	 * @ordered
	 */
	GENERATE_UI_PLUGIN(198, "GENERATE_UI_PLUGIN", "generateUIPlugin"),

	/**
	 * The '<em><b>OVERRIDE IBRACKET HANDLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IBRACKET_HANDLER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IBRACKET_HANDLER(199, "OVERRIDE_I_BRACKET_HANDLER", "overrideIBracketHandler"),

	/**
	 * The '<em><b>OVERRIDE UI PLUGIN XML</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_PLUGIN_XML_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_PLUGIN_XML(200, "OVERRIDE_UI_PLUGIN_XML", "overrideUIPluginXML"),

	/**
	 * The '<em><b>OVERRIDE PROPOSAL POST PROCESSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PROPOSAL_POST_PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PROPOSAL_POST_PROCESSOR(201, "OVERRIDE_PROPOSAL_POST_PROCESSOR", "overrideProposalPostProcessor"),

	/**
	 * The '<em><b>DISABLE TOKEN SORTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_TOKEN_SORTING_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_TOKEN_SORTING(202, "DISABLE_TOKEN_SORTING", "disableTokenSorting"),

	/**
	 * The '<em><b>OVERRIDE IQUICK FIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IQUICK_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IQUICK_FIX(203, "OVERRIDE_I_QUICK_FIX", "overrideIQuickFix"),

	/**
	 * The '<em><b>OVERRIDE QUICK FIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_QUICK_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_QUICK_FIX(204, "OVERRIDE_QUICK_FIX", "overrideQuickFix"),

	/**
	 * The '<em><b>OVERRIDE ANNOTATION MODEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANNOTATION_MODEL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ANNOTATION_MODEL(205, "OVERRIDE_ANNOTATION_MODEL", "overrideAnnotationModel"),

	/**
	 * The '<em><b>OVERRIDE ANNOTATION MODEL FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANNOTATION_MODEL_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ANNOTATION_MODEL_FACTORY(206, "OVERRIDE_ANNOTATION_MODEL_FACTORY", "overrideAnnotationModelFactory"),

	/**
	 * The '<em><b>OVERRIDE MARKER ANNOTATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MARKER_ANNOTATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_MARKER_ANNOTATION(208, "OVERRIDE_MARKER_ANNOTATION", "overrideMarkerAnnotation"),

	/**
	 * The '<em><b>OVERRIDE MARKER RESOLUTION GENERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MARKER_RESOLUTION_GENERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_MARKER_RESOLUTION_GENERATOR(209, "OVERRIDE_MARKER_RESOLUTION_GENERATOR", "overrideMarkerResolutionGenerator"),

	/**
	 * The '<em><b>OVERRIDE QUICK ASSIST ASSISTANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_QUICK_ASSIST_ASSISTANT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_QUICK_ASSIST_ASSISTANT(211, "OVERRIDE_QUICK_ASSIST_ASSISTANT", "overrideQuickAssistAssistant"),

	/**
	 * The '<em><b>OVERRIDE QUICK ASSIST PROCESSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_QUICK_ASSIST_PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_QUICK_ASSIST_PROCESSOR(212, "OVERRIDE_QUICK_ASSIST_PROCESSOR", "overrideQuickAssistProcessor"),

	/**
	 * The '<em><b>OVERRIDE IMAGE PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IMAGE_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IMAGE_PROVIDER(213, "OVERRIDE_IMAGE_PROVIDER", "overrideImageProvider"),

	/**
	 * The '<em><b>OVERRIDE TOKEN STYLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_STYLE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_STYLE(214, "OVERRIDE_TOKEN_STYLE", "overrideTokenStyle"),

	/**
	 * The '<em><b>OVERRIDE DYNAMIC TOKEN STYLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DYNAMIC_TOKEN_STYLER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DYNAMIC_TOKEN_STYLER(215, "OVERRIDE_DYNAMIC_TOKEN_STYLER", "overrideDynamicTokenStyler"),

	/**
	 * The '<em><b>RESOLVE PROXY ELEMENTS AFTER PARSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOLVE_PROXY_ELEMENTS_AFTER_PARSING_VALUE
	 * @generated
	 * @ordered
	 */
	RESOLVE_PROXY_ELEMENTS_AFTER_PARSING(216, "RESOLVE_PROXY_ELEMENTS_AFTER_PARSING", "resolveProxyElementsAfterParsing"),

	/**
	 * The '<em><b>OVERRIDE EXPECTED BOOLEAN TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTED_BOOLEAN_TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EXPECTED_BOOLEAN_TERMINAL(217, "OVERRIDE_EXPECTED_BOOLEAN_TERMINAL", "overrideExpectedBooleanTerminal"),

	/**
	 * The '<em><b>OVERRIDE BOOLEAN TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BOOLEAN_TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BOOLEAN_TERMINAL(218, "OVERRIDE_BOOLEAN_TERMINAL", "overrideBooleanTerminal"),

	/**
	 * The '<em><b>OVERRIDE ENUMERATION TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ENUMERATION_TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ENUMERATION_TERMINAL(219, "OVERRIDE_ENUMERATION_TERMINAL", "overrideEnumerationTerminal"),

	/**
	 * The '<em><b>OVERRIDE EXPECTED ENUMERATION TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTED_ENUMERATION_TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EXPECTED_ENUMERATION_TERMINAL(220, "OVERRIDE_EXPECTED_ENUMERATION_TERMINAL", "overrideExpectedEnumerationTerminal"),

	/**
	 * The '<em><b>OVERRIDE CHANGE REFERENCE QUICK FIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CHANGE_REFERENCE_QUICK_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CHANGE_REFERENCE_QUICK_FIX(221, "OVERRIDE_CHANGE_REFERENCE_QUICK_FIX", "overrideChangeReferenceQuickFix"),

	/**
	 * The '<em><b>OVERRIDE EPROBLEM SEVERITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EPROBLEM_SEVERITY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EPROBLEM_SEVERITY(222, "OVERRIDE_EPROBLEM_SEVERITY", "overrideEProblemSeverity"),

	/**
	 * The '<em><b>OVERRIDE RESOURCE POST PROCESSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_POST_PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_RESOURCE_POST_PROCESSOR(223, "OVERRIDE_RESOURCE_POST_PROCESSOR", "overrideResourcePostProcessor"),

	/**
	 * The '<em><b>OVERRIDE IRESOURCE PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IRESOURCE_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IRESOURCE_PROVIDER(224, "OVERRIDE_I_RESOURCE_PROVIDER", "overrideIResourceProvider"),

	/**
	 * The '<em><b>OVERRIDE IBRACKET HANDLER PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IBRACKET_HANDLER_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IBRACKET_HANDLER_PROVIDER(225, "OVERRIDE_I_BRACKET_HANDLER_PROVIDER", "overrideIBracketHandlerProvider"),

	/**
	 * The '<em><b>OVERRIDE IANNOTATION MODEL PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IANNOTATION_MODEL_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IANNOTATION_MODEL_PROVIDER(226, "OVERRIDE_I_ANNOTATION_MODEL_PROVIDER", "overrideIAnnotationModelProvider"),

	/**
	 * The '<em><b>OVERRIDE LAUNCH CONFIGURATION DELEGATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE(227, "OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE", "overrideLaunchConfigurationDelegate"),

	/**
	 * The '<em><b>OVERRIDE LAUNCH CONFIGURATION TAB GROUP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP(228, "OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP", "overrideLaunchConfigurationTabGroup"),

	/**
	 * The '<em><b>OVERRIDE LAUNCH CONFIGURATION MAIN TAB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB(229, "OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB", "overrideLaunchConfigurationMainTab"),

	/**
	 * The '<em><b>OVERRIDE LAUNCH SHORTCUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAUNCH_SHORTCUT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAUNCH_SHORTCUT(230, "OVERRIDE_LAUNCH_SHORTCUT", "overrideLaunchShortcut"),

	/**
	 * The '<em><b>OVERRIDE PROPERTY TESTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PROPERTY_TESTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PROPERTY_TESTER(231, "OVERRIDE_PROPERTY_TESTER", "overridePropertyTester"),

	/**
	 * The '<em><b>DISABLE LAUNCH SUPPORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_LAUNCH_SUPPORT_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_LAUNCH_SUPPORT(232, "DISABLE_LAUNCH_SUPPORT", "disableLaunchSupport"),

	/**
	 * The '<em><b>OVERRIDE RULE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RULE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_RULE(233, "OVERRIDE_RULE", "overrideRule"),

	/**
	 * The '<em><b>OVERRIDE ABSTRACT DEBUGGABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ABSTRACT_DEBUGGABLE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ABSTRACT_DEBUGGABLE(234, "OVERRIDE_ABSTRACT_DEBUGGABLE", "overrideAbstractDebuggable"),

	/**
	 * The '<em><b>OVERRIDE EDEBUG MESSAGE TYPES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EDEBUG_MESSAGE_TYPES_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EDEBUG_MESSAGE_TYPES(235, "OVERRIDE_E_DEBUG_MESSAGE_TYPES", "overrideEDebugMessageTypes"),

	/**
	 * The '<em><b>OVERRIDE IDEBUG EVENT LISTENER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IDEBUG_EVENT_LISTENER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IDEBUG_EVENT_LISTENER(236, "OVERRIDE_I_DEBUG_EVENT_LISTENER", "overrideIDebugEventListener"),

	/**
	 * The '<em><b>OVERRIDE IINTERPRETER LISTENER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IINTERPRETER_LISTENER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IINTERPRETER_LISTENER(237, "OVERRIDE_I_INTERPRETER_LISTENER", "overrideIInterpreterListener"),

	/**
	 * The '<em><b>OVERRIDE DEBUG COMMUNICATION HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_COMMUNICATION_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_COMMUNICATION_HELPER(238, "OVERRIDE_DEBUG_COMMUNICATION_HELPER", "overrideDebugCommunicationHelper"),

	/**
	 * The '<em><b>OVERRIDE DEBUG ELEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_ELEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_ELEMENT(239, "OVERRIDE_DEBUG_ELEMENT", "overrideDebugElement"),

	/**
	 * The '<em><b>OVERRIDE DEBUGGABLE INTERPRETER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUGGABLE_INTERPRETER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUGGABLE_INTERPRETER(240, "OVERRIDE_DEBUGGABLE_INTERPRETER", "overrideDebuggableInterpreter"),

	/**
	 * The '<em><b>OVERRIDE DEBUGGER LISTENER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUGGER_LISTENER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUGGER_LISTENER(241, "OVERRIDE_DEBUGGER_LISTENER", "overrideDebuggerListener"),

	/**
	 * The '<em><b>OVERRIDE DEBUG MESSAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_MESSAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_MESSAGE(242, "OVERRIDE_DEBUG_MESSAGE", "overrideDebugMessage"),

	/**
	 * The '<em><b>OVERRIDE DEBUG PROCESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_PROCESS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_PROCESS(243, "OVERRIDE_DEBUG_PROCESS", "overrideDebugProcess"),

	/**
	 * The '<em><b>OVERRIDE DEBUG PROXY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_PROXY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_PROXY(244, "OVERRIDE_DEBUG_PROXY", "overrideDebugProxy"),

	/**
	 * The '<em><b>OVERRIDE DEBUG TARGET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_TARGET_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_TARGET(245, "OVERRIDE_DEBUG_TARGET", "overrideDebugTarget"),

	/**
	 * The '<em><b>OVERRIDE DEBUG THREAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_THREAD_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_THREAD(246, "OVERRIDE_DEBUG_THREAD", "overrideDebugThread"),

	/**
	 * The '<em><b>OVERRIDE DEBUG VALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_VALUE(247, "OVERRIDE_DEBUG_VALUE", "overrideDebugValue"),

	/**
	 * The '<em><b>OVERRIDE DEBUG VARIABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_VARIABLE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_VARIABLE(248, "OVERRIDE_DEBUG_VARIABLE", "overrideDebugVariable"),

	/**
	 * The '<em><b>OVERRIDE LINEBREAK POINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LINEBREAK_POINT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LINEBREAK_POINT(249, "OVERRIDE_LINEBREAK_POINT", "overrideLineBreakpoint"),

	/**
	 * The '<em><b>OVERRIDE SOURCE LOCATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SOURCE_LOCATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SOURCE_LOCATOR(250, "OVERRIDE_SOURCE_LOCATOR", "overrideSourceLocator"),

	/**
	 * The '<em><b>OVERRIDE SOURCE LOOKUP PARTICIPANT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SOURCE_LOOKUP_PARTICIPANT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SOURCE_LOOKUP_PARTICIPANT(251, "OVERRIDE_SOURCE_LOOKUP_PARTICIPANT", "overrideSourceLookupParticipant"),

	/**
	 * The '<em><b>OVERRIDE SOURCE PATH COMPUTER DELEGATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE(252, "OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE", "overrideSourcePathComputerDelegate"),

	/**
	 * The '<em><b>OVERRIDE STACK FRAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_STACK_FRAME_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_STACK_FRAME(253, "OVERRIDE_STACK_FRAME", "overrideStackFrame"),

	/**
	 * The '<em><b>DISABLE DEBUG SUPPORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_DEBUG_SUPPORT_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_DEBUG_SUPPORT(254, "DISABLE_DEBUG_SUPPORT", "disableDebugSupport"),

	/**
	 * The '<em><b>OVERRIDE DEBUG MODEL PRESENTATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEBUG_MODEL_PRESENTATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEBUG_MODEL_PRESENTATION(255, "OVERRIDE_DEBUG_MODEL_PRESENTATION", "overrideDebugModelPresentation"),

	/**
	 * The '<em><b>OVERRIDE LINE BREAKPOINT ADAPTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LINE_BREAKPOINT_ADAPTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LINE_BREAKPOINT_ADAPTER(256, "OVERRIDE_LINE_BREAKPOINT_ADAPTER", "overrideLineBreakpointAdapter"),

	/**
	 * The '<em><b>OVERRIDE ADAPTER FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ADAPTER_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ADAPTER_FACTORY(257, "OVERRIDE_ADAPTER_FACTORY", "overrideAdapterFactory"),

	/**
	 * The '<em><b>OVERRIDE LAUNCH CONFIGURATION HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAUNCH_CONFIGURATION_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAUNCH_CONFIGURATION_HELPER(258, "OVERRIDE_LAUNCH_CONFIGURATION_HELPER", "overrideLaunchConfigurationHelper"),

	/**
	 * The '<em><b>OVERRIDE NEW PROJECT WIZARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_PROJECT_WIZARD_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_NEW_PROJECT_WIZARD(259, "OVERRIDE_NEW_PROJECT_WIZARD", "overrideNewProjectWizard"),

	/**
	 * The '<em><b>DISABLE NEW PROJECT WIZARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_NEW_PROJECT_WIZARD_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_NEW_PROJECT_WIZARD(260, "DISABLE_NEW_PROJECT_WIZARD", "disableNewProjectWizard"),

	/**
	 * The '<em><b>OVERRIDE OPTION PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OPTION_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OPTION_PROVIDER(260, "OVERRIDE_OPTION_PROVIDER", "overrideOptionProvider"),

	/**
	 * The '<em><b>IGNORE TYPE RESTRICTIONS FOR PRINTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING_VALUE
	 * @generated
	 * @ordered
	 */
	IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING(261, "IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING", "ignoreTypeRestrictionsForPrinting"),

	/**
	 * The '<em><b>OVERRIDE INAME PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_INAME_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_INAME_PROVIDER(262, "OVERRIDE_I_NAME_PROVIDER", "overrideINameProvider"),

	/**
	 * The '<em><b>OVERRIDE DEFAULT NAME PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_NAME_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEFAULT_NAME_PROVIDER(263, "OVERRIDE_DEFAULT_NAME_PROVIDER", "overrideDefaultNameProvider"),

	/**
	 * The '<em><b>OVERRIDE REFERENCE CACHE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_CACHE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_REFERENCE_CACHE(264, "OVERRIDE_REFERENCE_CACHE", "overrideReferenceCache"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE LEXICAL SORTING ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_LEXICAL_SORTING_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_LEXICAL_SORTING_ACTION(265, "OVERRIDE_OUTLINE_PAGE_LEXICAL_SORTING_ACTION", "overrideOutlinePageLexicalSortingAction"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE COLLAPSE ALL ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_COLLAPSE_ALL_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_COLLAPSE_ALL_ACTION(266, "OVERRIDE_OUTLINE_PAGE_COLLAPSE_ALL_ACTION", "overrideOutlinePageCollapseAllAction"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE GROUP TYPES ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_GROUP_TYPES_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_GROUP_TYPES_ACTION(267, "OVERRIDE_OUTLINE_PAGE_GROUP_TYPES_ACTION", "overrideOutlinePageGroupTypesAction"),

	/**
	 * The '<em><b>OVERRIDE ABSTRACT OUTLINE PAGE ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ABSTRACT_OUTLINE_PAGE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ABSTRACT_OUTLINE_PAGE_ACTION(268, "OVERRIDE_ABSTRACT_OUTLINE_PAGE_ACTION", "overrideAbstractOutlinePageAction"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE TREE VIEWER COMPARATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_COMPARATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_COMPARATOR(269, "OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_COMPARATOR", "overrideOutlinePageTreeViewerComparator"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE EXPAND ALL ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_EXPAND_ALL_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_EXPAND_ALL_ACTION(270, "OVERRIDE_OUTLINE_PAGE_EXPAND_ALL_ACTION", "overrideOutlinePageExpandAllAction"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE ACTION PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER(271, "OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER", "overrideOutlinePageActionProvider"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE LINK WITH EDITOR ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION(272, "OVERRIDE_OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION", "overrideOutlinePageLinkWithEditorAction"),

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE AUTO EXPAND ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_AUTO_EXPAND_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_AUTO_EXPAND_ACTION(273, "OVERRIDE_OUTLINE_PAGE_AUTO_EXPAND_ACTION", "overrideOutlinePageAutoExpandAction"),

	/**
	 * The '<em><b>OVERRIDE CONTAINED FEATURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTAINED_FEATURE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CONTAINED_FEATURE(274, "OVERRIDE_CONTAINED_FEATURE", "overrideContainedFeature"),

	/**
	 * The '<em><b>OVERRIDE EXPECTATION CONSTANTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTATION_CONSTANTS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EXPECTATION_CONSTANTS(275, "OVERRIDE_EXPECTATION_CONSTANTS", "overrideExpectationConstants"),

	/**
	 * The '<em><b>OVERRIDE ECLIPSE PROXY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ECLIPSE_PROXY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ECLIPSE_PROXY(276, "OVERRIDE_ECLIPSE_PROXY", "overrideEclipeProxy"),

	/**
	 * The '<em><b>OVERRIDE RUNTIME UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RUNTIME_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_RUNTIME_UTIL(277, "OVERRIDE_RUNTIME_UTIL", "overrideRuntimeUtil"),

	/**
	 * The '<em><b>REMOVE ECLIPSE DEPENDENT CODE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVE_ECLIPSE_DEPENDENT_CODE_VALUE
	 * @generated
	 * @ordered
	 */
	REMOVE_ECLIPSE_DEPENDENT_CODE(278, "REMOVE_ECLIPSE_DEPENDENT_CODE", "removeEclipseDependentCode"),

	/**
	 * The '<em><b>OVERRIDE IFUNCTION1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IFUNCTION1_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IFUNCTION1(279, "OVERRIDE_I_FUNCTION1", "overrideIFunction1"),

	/**
	 * The '<em><b>OVERRIDE DEV NULL LOCATION MAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEV_NULL_LOCATION_MAP_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEV_NULL_LOCATION_MAP(280, "OVERRIDE_DEV_NULL_LOCATION_MAP", "overrideDevNullLocationMap"),

	/**
	 * The '<em><b>OVERRIDE IGNORED WORDS FILTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IGNORED_WORDS_FILTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IGNORED_WORDS_FILTER(281, "OVERRIDE_IGNORED_WORDS_FILTER", "overrideIgnoredWordsFilter"),

	/**
	 * The '<em><b>OVERRIDE TASK ITEM DETECTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TASK_ITEM_DETECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TASK_ITEM_DETECTOR(282, "OVERRIDE_TASK_ITEM_DETECTOR", "overrideTaskItemDetector"),

	/**
	 * The '<em><b>OVERRIDE TASK ITEM BUILDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TASK_ITEM_BUILDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TASK_ITEM_BUILDER(283, "OVERRIDE_TASK_ITEM_BUILDER", "overrideTaskItemBuilder"),

	/**
	 * The '<em><b>OVERRIDE SOURCE VIEWER CONFIGURATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SOURCE_VIEWER_CONFIGURATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SOURCE_VIEWER_CONFIGURATION(284, "OVERRIDE_SOURCE_VIEWER_CONFIGURATION", "overrideSourceViewerConfiguration"),

	/**
	 * The '<em><b>OVERRIDE TASK ITEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TASK_ITEM_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TASK_ITEM(285, "OVERRIDE_TASK_ITEM", "overrideTaskItem"),

	/**
	 * The '<em><b>OVERRIDE URI UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_URI_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_URI_UTIL(286, "OVERRIDE_URI_UTIL", "overrideURIUtil"),

	/**
	 * The '<em><b>OVERRIDE ANTLR TEXT TOKEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANTLR_TEXT_TOKEN_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ANTLR_TEXT_TOKEN(287, "OVERRIDE_ANTLR_TEXT_TOKEN", "overrideAntlrTextToken"),

	/**
	 * The '<em><b>OVERRIDE IDELEGATING REFERENCE RESOLVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IDELEGATING_REFERENCE_RESOLVER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IDELEGATING_REFERENCE_RESOLVER(288, "OVERRIDE_I_DELEGATING_REFERENCE_RESOLVER", "overrideIDelegatingReferenceResolver"),

	/**
	 * The '<em><b>ADDITIONAL IMPORTED PACKAGES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_IMPORTED_PACKAGES_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_IMPORTED_PACKAGES(289, "ADDITIONAL_IMPORTED_PACKAGES", "additionalImportedPackages"),

	/**
	 * The '<em><b>ADDITIONAL UI IMPORTED PACKAGES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_UI_IMPORTED_PACKAGES_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_UI_IMPORTED_PACKAGES(290, "ADDITIONAL_UI_IMPORTED_PACKAGES", "additionalUIImportedPackages"),

	/**
	 * The '<em><b>ADDITIONAL LIBRARIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_LIBRARIES_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_LIBRARIES(291, "ADDITIONAL_LIBRARIES", "additionalLibraries"),

	/**
	 * The '<em><b>OVERRIDE CONTAINMENT TRACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTAINMENT_TRACE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CONTAINMENT_TRACE(292, "OVERRIDE_CONTAINMENT_TRACE", "overrideContainmentTrace"),

	/**
	 * The '<em><b>EDITOR NAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EDITOR_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	EDITOR_NAME(293, "EDITOR_NAME", "editorName"),

	/**
	 * The '<em><b>OVERRIDE LAYOUT UTIL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAYOUT_UTIL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAYOUT_UTIL(294, "OVERRIDE_LAYOUT_UTIL", "overrideLayoutUtil"),

	/**
	 * The '<em><b>OVERRIDE UI ANTLR TOKEN HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_ANTLR_TOKEN_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_ANTLR_TOKEN_HELPER(295, "OVERRIDE_UI_ANTLR_TOKEN_HELPER", "overrideUIAntlrTokenHelper");

	/**
	 * The '<em><b>GENERATE TEST ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, EMFText generates a UI action that can be used to test parsing and printing of files containing textual syntax. The default value for this option is <code>false</code>. This is a non-standard option, which might be removed in future releases of EMFText.
	 * <!-- end-model-doc -->
	 * @see #GENERATE_TEST_ACTION
	 * @model literal="generateTestAction"
	 * @generated
	 * @ordered
	 */
	public static final int GENERATE_TEST_ACTION_VALUE = 0;

	/**
	 * The '<em><b>GENERATE CODE FROM GENERATOR MODEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, EMFText automatically generates the model code using the generator model referenced in the CS specification. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #GENERATE_CODE_FROM_GENERATOR_MODEL
	 * @model literal="generateCodeFromGeneratorModel"
	 * @generated
	 * @ordered
	 */
	public static final int GENERATE_CODE_FROM_GENERATOR_MODEL_VALUE = 1;

	/**
	 * The '<em><b>OVERRIDE PLUGIN XML</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the plugin.xml file will be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PLUGIN_XML
	 * @model literal="overridePluginXML"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PLUGIN_XML_VALUE = 3;

	/**
	 * The '<em><b>OVERRIDE MANIFEST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the manifest of the resource plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_MANIFEST
	 * @model literal="overrideManifest"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MANIFEST_VALUE = 4;

	/**
	 * The '<em><b>OVERRIDE PARSER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Parser class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PARSER
	 * @model literal="overrideParser"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PARSER_VALUE = 5;

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the token resolver classes will be overridden. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVERS
	 * @model literal="overrideTokenResolvers"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_RESOLVERS_VALUE = 6;

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the reference resolver classes will be overridden. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVERS
	 * @model literal="overrideReferenceResolvers"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_REFERENCE_RESOLVERS_VALUE = 7;

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVER SWITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the reference resolver switch will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVER_SWITCH
	 * @model literal="overrideReferenceResolverSwitch"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_REFERENCE_RESOLVER_SWITCH_VALUE = 8;

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVER FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the token resolver factory class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVER_FACTORY
	 * @model literal="overrideTokenResolverFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_RESOLVER_FACTORY_VALUE = 9;

	/**
	 * The '<em><b>OVERRIDE PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the printer will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PRINTER
	 * @model literal="overridePrinter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PRINTER_VALUE = 10;

	/**
	 * The '<em><b>ANTLR BACKTRACKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ANTLR-backtracking is deactivated for parser generation. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #ANTLR_BACKTRACKING
	 * @model literal="backtracking"
	 * @generated
	 * @ordered
	 */
	public static final int ANTLR_BACKTRACKING_VALUE = 12;

	/**
	 * The '<em><b>ANTLR MEMOIZE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ANTLR-memoize is deactivated for parser generation. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #ANTLR_MEMOIZE
	 * @model literal="memoize"
	 * @generated
	 * @ordered
	 */
	public static final int ANTLR_MEMOIZE_VALUE = 13;

	/**
	 * The '<em><b>AUTOFIX SIMPLE LEFTRECURSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, EMFText will try to fix rules that contain simple left recursion. The default value for this option is <code>false</code>. This is a non-standard option, which might be removed in future releases of EMFText.
	 * <!-- end-model-doc -->
	 * @see #AUTOFIX_SIMPLE_LEFTRECURSION
	 * @model literal="autofixSimpleLeftrecursion"
	 * @generated
	 * @ordered
	 */
	public static final int AUTOFIX_SIMPLE_LEFTRECURSION_VALUE = 14;

	/**
	 * The '<em><b>FORCE EOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, EMFText will generate a parser that does not expect an EOF signal at the end of the input stream. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #FORCE_EOF
	 * @model literal="forceEOF"
	 * @generated
	 * @ordered
	 */
	public static final int FORCE_EOF_VALUE = 15;

	/**
	 * The '<em><b>DEFAULT TOKEN NAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This option can be used to specify the name of the token that is used when no token is given for attributes or non-containment references in syntax rules. Declarations like <code>featureX[]</code> in CS rules will automatically be expanded to <code>featureX[TOKEN_Y]</code> if the value of this option is <code>TOKEN_Y</code>. The default value for this option is <code>TEXT</code>, which makes the predefined token <code>TEXT</code> the default token.
	 * <!-- end-model-doc -->
	 * @see #DEFAULT_TOKEN_NAME
	 * @model literal="defaultTokenName"
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT_TOKEN_NAME_VALUE = 16;

	/**
	 * The '<em><b>USE PREDEFINED TOKENS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, EMFText does not automatically provide predefined tokens (TEXT, WHITESPACE, LINEBREAK). The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #USE_PREDEFINED_TOKENS
	 * @model literal="usePredefinedTokens"
	 * @generated
	 * @ordered
	 */
	public static final int USE_PREDEFINED_TOKENS_VALUE = 17;

	/**
	 * The '<em><b>TOKENSPACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The (numerical) value of this option defines how many whitespace should be printed between tokens if no whitespace information is given in CS rules. This option should only be used with the classic printer. The default value of this option is <code>1</code> if the classic printer is used (see option <code>useClassicPrinter</code>) and <code>automatic</code> otherwise.
	 * <!-- end-model-doc -->
	 * @see #TOKENSPACE
	 * @model literal="tokenspace"
	 * @generated
	 * @ordered
	 */
	public static final int TOKENSPACE_VALUE = 18;

	/**
	 * The '<em><b>RELOAD GENERATOR MODEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, EMFText reloads the generator model before loading it. This is particular useful, when the meta model (i.e., the Ecore file) is changing a lot during language development. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #RELOAD_GENERATOR_MODEL
	 * @model literal="reloadGeneratorModel"
	 * @generated
	 * @ordered
	 */
	public static final int RELOAD_GENERATOR_MODEL_VALUE = 19;

	/**
	 * The '<em><b>OVERRIDE DOT CLASSPATH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the .classpath file of the resource plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DOT_CLASSPATH
	 * @model literal="overrideClasspath"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DOT_CLASSPATH_VALUE = 20;

	/**
	 * The '<em><b>OVERRIDE DOT PROJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the .project file of the resource plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DOT_PROJECT
	 * @model literal="overrideProjectFile"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DOT_PROJECT_VALUE = 21;

	/**
	 * The '<em><b>OVERRIDE TEXT RESOURCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the text resource class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TEXT_RESOURCE
	 * @model literal="overrideTextResource"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TEXT_RESOURCE_VALUE = 22;

	/**
	 * The '<em><b>OVERRIDE RESOURCE FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the resource factory class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_RESOURCE_FACTORY
	 * @model literal="overrideResourceFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RESOURCE_FACTORY_VALUE = 23;

	/**
	 * The '<em><b>OVERRIDE NEW FILE WIZARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the new file wizard class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_NEW_FILE_WIZARD
	 * @model literal="overrideNewFileWizard"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NEW_FILE_WIZARD_VALUE = 24;

	/**
	 * The '<em><b>PARSER GENERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the parser generator to use. The default value for this option is <code>antlr</code>, which is also the only valid value. This is a non-standard option, which might be removed in future releases of EMFText.
	 * <!-- end-model-doc -->
	 * @see #PARSER_GENERATOR
	 * @model literal="parserGenerator"
	 * @generated
	 * @ordered
	 */
	public static final int PARSER_GENERATOR_VALUE = 25;

	/**
	 * The '<em><b>SOURCE FOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the folder where EMFText shall store the customizable classes of the resource plug-in in. All classes for which the <code>override</code> option is set to <code>false</code> will be stored in this folder.
	 * <!-- end-model-doc -->
	 * @see #SOURCE_FOLDER
	 * @model literal="srcFolder"
	 * @generated
	 * @ordered
	 */
	public static final int SOURCE_FOLDER_VALUE = 26;

	/**
	 * The '<em><b>BASE PACKAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the base package EMFText shall store the generated classes or the resource plug-in in. If this option is not set, the default value is determined by adding the suffix <code>resource.FILE_EXTENSION</code> to the base package of the generator model.
	 * <!-- end-model-doc -->
	 * @see #BASE_PACKAGE
	 * @model literal="basePackage"
	 * @generated
	 * @ordered
	 */
	public static final int BASE_PACKAGE_VALUE = 27;

	/**
	 * The '<em><b>RESOURCE PLUGIN ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ID of the generated resource plug-in. The resource plug-in is stored in a folder that is equal to this ID.
	 * <!-- end-model-doc -->
	 * @see #RESOURCE_PLUGIN_ID
	 * @model literal="resourcePluginID"
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_PLUGIN_ID_VALUE = 28;

	/**
	 * The '<em><b>OVERRIDE BUILD PROPERTIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the build.properties file will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_BUILD_PROPERTIES
	 * @model literal="overrideBuildProperties"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BUILD_PROPERTIES_VALUE = 29;

	/**
	 * The '<em><b>OVERRIDE META INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the MetaInformation class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_META_INFORMATION
	 * @model literal="overrideMetaInformation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_META_INFORMATION_VALUE = 30;

	/**
	 * The '<em><b>OVERRIDE DEFAULT RESOLVER DELEGATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the default resolver class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEFAULT_RESOLVER_DELEGATE
	 * @model literal="overrideDefaultResolverDelegate"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_RESOLVER_DELEGATE_VALUE = 31;

	/**
	 * The '<em><b>OVERRIDE PROBLEM CLASS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the problem class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PROBLEM_CLASS
	 * @model literal="overrideProblemClass"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PROBLEM_CLASS_VALUE = 32;

	/**
	 * The '<em><b>OVERRIDE SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Scanner class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SCANNER
	 * @model literal="overrideScanner"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SCANNER_VALUE = 33;

	/**
	 * The '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ContextDependentUriFragment class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT
	 * @model literal="overrideContextDependentURIFragment"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_VALUE = 34;

	/**
	 * The '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ContextDependentUriFragmentFactory class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY
	 * @model literal="overrideContextDependentURIFragmentFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE = 35;

	/**
	 * The '<em><b>OVERRIDE DELEGATING RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DelegatingResolveResult class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DELEGATING_RESOLVE_RESULT
	 * @model literal="overrideDelegatingResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DELEGATING_RESOLVE_RESULT_VALUE = 36;

	/**
	 * The '<em><b>OVERRIDE DUMMY EOBJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DummyEObject class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DUMMY_EOBJECT
	 * @model name="OVERRIDE_DUMMY_E_OBJECT" literal="overrideDummyEObject"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DUMMY_EOBJECT_VALUE = 37;

	/**
	 * The '<em><b>OVERRIDE ELEMENT MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ElementMapping class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ELEMENT_MAPPING
	 * @model literal="overrideElementMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ELEMENT_MAPPING_VALUE = 38;

	/**
	 * The '<em><b>OVERRIDE FUZZY RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the FuzzyResolveResult class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_FUZZY_RESOLVE_RESULT
	 * @model literal="overrideFuzzyResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_FUZZY_RESOLVE_RESULT_VALUE = 39;

	/**
	 * The '<em><b>OVERRIDE DEFAULT TOKEN RESOLVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DefaultTokenResolver class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEFAULT_TOKEN_RESOLVER
	 * @model literal="overrideDefaultTokenResolver"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_TOKEN_RESOLVER_VALUE = 40;

	/**
	 * The '<em><b>OVERRIDE LOCATION MAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LocationMap class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LOCATION_MAP
	 * @model literal="overrideLocationMap"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LOCATION_MAP_VALUE = 41;

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ReferenceResolveResult class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVE_RESULT
	 * @model literal="overrideReferenceResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_REFERENCE_RESOLVE_RESULT_VALUE = 42;

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TokenResolveResult class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVE_RESULT
	 * @model literal="overrideTokenResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_RESOLVE_RESULT_VALUE = 43;

	/**
	 * The '<em><b>OVERRIDE URI MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the UriMapping class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_URI_MAPPING
	 * @model literal="overrideURIMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_URI_MAPPING_VALUE = 45;

	/**
	 * The '<em><b>OVERRIDE HOVER TEXT PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the HoverTextProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_HOVER_TEXT_PROVIDER
	 * @model literal="overrideHoverTextProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HOVER_TEXT_PROVIDER_VALUE = 46;

	/**
	 * The '<em><b>OVERRIDE PARSE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ParseResult class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PARSE_RESULT
	 * @model literal="overrideParseResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PARSE_RESULT_VALUE = 47;

	/**
	 * The '<em><b>OVERRIDE ANTLR TOKEN HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AntlrTokenHelper class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ANTLR_TOKEN_HELPER
	 * @model literal="overrideAntlrTokenHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ANTLR_TOKEN_HELPER_VALUE = 48;

	/**
	 * The '<em><b>OVERRIDE BRACKET SET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the BracketSet class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_BRACKET_SET
	 * @model literal="overrideBracketSet"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BRACKET_SET_VALUE = 49;

	/**
	 * The '<em><b>OVERRIDE BROWSER INFORMATION CONTROL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the BrowserInformationControl class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_BROWSER_INFORMATION_CONTROL
	 * @model literal="overrideBrowserInformationControl"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BROWSER_INFORMATION_CONTROL_VALUE = 50;

	/**
	 * The '<em><b>OVERRIDE CODE FOLDING MANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the CodeFoldingManager class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CODE_FOLDING_MANAGER
	 * @model literal="overrideCodeFoldingManager"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CODE_FOLDING_MANAGER_VALUE = 51;

	/**
	 * The '<em><b>OVERRIDE COLOR MANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ColorManager class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_COLOR_MANAGER
	 * @model literal="overrideColorManager"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COLOR_MANAGER_VALUE = 52;

	/**
	 * The '<em><b>OVERRIDE COMPLETION PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the CompletionProcessor class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_COMPLETION_PROCESSOR
	 * @model literal="overrideCompletionProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COMPLETION_PROCESSOR_VALUE = 53;

	/**
	 * The '<em><b>OVERRIDE PARSING STRATEGY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ParsingStrategy class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PARSING_STRATEGY
	 * @model literal="overrideParsingStrategy"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PARSING_STRATEGY_VALUE = 54;

	/**
	 * The '<em><b>OVERRIDE DOC BROWSER INFORMATION CONTROL INPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DocBrowserInformationControlInput class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT
	 * @model literal="overrideDocBrowserInformationControlInput"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT_VALUE = 55;

	/**
	 * The '<em><b>OVERRIDE EDITOR CONFIGURATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EditorConfiguration class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EDITOR_CONFIGURATION
	 * @model literal="overrideEditorConfiguration"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EDITOR_CONFIGURATION_VALUE = 55;

	/**
	 * The '<em><b>OVERRIDE EDITOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Editor class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EDITOR
	 * @model literal="overrideEditor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EDITOR_VALUE = 56;

	/**
	 * The '<em><b>OVERRIDE EOBJECT SELECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EObjectSelection class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EOBJECT_SELECTION
	 * @model name="OVERRIDE_E_OBJECT_SELECTION" literal="overrideEObjectSelection"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EOBJECT_SELECTION_VALUE = 57;

	/**
	 * The '<em><b>OVERRIDE HIGHLIGHTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Highlighting class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_HIGHLIGHTING
	 * @model literal="overrideHighlighting"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HIGHLIGHTING_VALUE = 58;

	/**
	 * The '<em><b>OVERRIDE HTML PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the HtmlPrinter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_HTML_PRINTER
	 * @model literal="overrideHTMLPrinter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HTML_PRINTER_VALUE = 59;

	/**
	 * The '<em><b>OVERRIDE HYPERLINK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Hyperlink class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_HYPERLINK
	 * @model literal="overrideHyperlink"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HYPERLINK_VALUE = 60;

	/**
	 * The '<em><b>OVERRIDE HYPERLINK DETECTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the HyperlinkDetector class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_HYPERLINK_DETECTOR
	 * @model literal="overrideHyperlinkDetector"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HYPERLINK_DETECTOR_VALUE = 61;

	/**
	 * The '<em><b>OVERRIDE MARKER HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the MarkerHelper class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_MARKER_HELPER
	 * @model literal="overrideMarkerHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MARKER_HELPER_VALUE = 62;

	/**
	 * The '<em><b>OVERRIDE OCCURRENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Occurrence class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OCCURRENCE
	 * @model literal="overrideOccurrence"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OCCURRENCE_VALUE = 63;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePage class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE
	 * @model literal="overrideOutlinePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_VALUE = 64;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE TREE VIEWER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageTreeViewer class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_TREE_VIEWER
	 * @model literal="overrideOutlinePageTreeViewer"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_VALUE = 65;

	/**
	 * The '<em><b>OVERRIDE PLUGIN ACTIVATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PluginActivator class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PLUGIN_ACTIVATOR
	 * @model literal="overridePluginActivator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PLUGIN_ACTIVATOR_VALUE = 66;

	/**
	 * The '<em><b>OVERRIDE POSITION CATEGORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PositionCategory class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_POSITION_CATEGORY
	 * @model literal="overridePositionCategory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_POSITION_CATEGORY_VALUE = 67;

	/**
	 * The '<em><b>OVERRIDE POSITION HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PositionHelper class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_POSITION_HELPER
	 * @model literal="overridePositionHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_POSITION_HELPER_VALUE = 68;

	/**
	 * The '<em><b>OVERRIDE PROPERTY SHEET PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PropertySheetPage class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PROPERTY_SHEET_PAGE
	 * @model literal="overridePropertySheetPage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PROPERTY_SHEET_PAGE_VALUE = 69;

	/**
	 * The '<em><b>OVERRIDE TEXT HOVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TextHover class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TEXT_HOVER
	 * @model literal="overrideTextHover"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TEXT_HOVER_VALUE = 70;

	/**
	 * The '<em><b>OVERRIDE TOKEN SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TokenScanner class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TOKEN_SCANNER
	 * @model literal="overrideTokenScanner"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_SCANNER_VALUE = 71;

	/**
	 * The '<em><b>OVERRIDE BRACKET PREFERENCE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the BracketPreferencePage class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_BRACKET_PREFERENCE_PAGE
	 * @model literal="overrideBracketPreferencePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BRACKET_PREFERENCE_PAGE_VALUE = 72;

	/**
	 * The '<em><b>OVERRIDE PREFERENCE CONSTANTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PreferenceConstants class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PREFERENCE_CONSTANTS
	 * @model literal="overridePreferenceConstants"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PREFERENCE_CONSTANTS_VALUE = 73;

	/**
	 * The '<em><b>OVERRIDE OCCURRENCE PREFERENCE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OccurrencePreferencePage class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OCCURRENCE_PREFERENCE_PAGE
	 * @model literal="overrideOccurrencePreferencePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OCCURRENCE_PREFERENCE_PAGE_VALUE = 74;

	/**
	 * The '<em><b>OVERRIDE PIXEL CONVERTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PixelConverter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PIXEL_CONVERTER
	 * @model literal="overridePixelConverter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PIXEL_CONVERTER_VALUE = 75;

	/**
	 * The '<em><b>OVERRIDE PREFERENCE INITIALIZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PreferenceInitializer class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PREFERENCE_INITIALIZER
	 * @model literal="overridePreferenceInitializer"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PREFERENCE_INITIALIZER_VALUE = 76;

	/**
	 * The '<em><b>OVERRIDE SYNTAX COLORING HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SyntaxColoringHelper class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SYNTAX_COLORING_HELPER
	 * @model literal="overrideSyntaxColoringHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_COLORING_HELPER_VALUE = 77;

	/**
	 * The '<em><b>OVERRIDE SYNTAX COLORING PREFERENCE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SyntaxColoringPreferencePage class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE
	 * @model literal="overrideSyntaxColoringPreferencePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE_VALUE = 78;

	/**
	 * The '<em><b>OVERRIDE IINPUT STREAM PROCESSOR PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IInputStreamProcessorProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER
	 * @model name="OVERRIDE_I_INPUT_STREAM_PROCESSOR_PROVIDER" literal="overrideIInputStreamProcessorProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER_VALUE = 79;

	/**
	 * The '<em><b>OVERRIDE INPUT STREAM PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the InputStreamProcessor class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_INPUT_STREAM_PROCESSOR
	 * @model literal="overrideInputStreamProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_INPUT_STREAM_PROCESSOR_VALUE = 80;

	/**
	 * The '<em><b>OVERRIDE IOPTION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IOptionProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IOPTION_PROVIDER
	 * @model name="OVERRIDE_I_OPTION_PROVIDER" literal="overrideIOptionProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IOPTION_PROVIDER_VALUE = 81;

	/**
	 * The '<em><b>OVERRIDE IOPTIONS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IOptions class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IOPTIONS
	 * @model name="OVERRIDE_I_OPTIONS" literal="overrideIOptions"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IOPTIONS_VALUE = 82;

	/**
	 * The '<em><b>OVERRIDE IRESOURCE POST PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IResourcePostProcessor class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IRESOURCE_POST_PROCESSOR
	 * @model name="OVERRIDE_I_RESOURCE_POST_PROCESSOR" literal="overrideIResourcePostProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IRESOURCE_POST_PROCESSOR_VALUE = 83;

	/**
	 * The '<em><b>OVERRIDE IRESOURCE POST PROCESSOR PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IResourcePostProcessorProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER
	 * @model name="OVERRIDE_I_RESOURCE_POST_PROCESSOR_PROVIDER" literal="overrideIResourcePostProcessorProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER_VALUE = 84;

	/**
	 * The '<em><b>OVERRIDE IBRACKET PAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IBracketPair class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IBRACKET_PAIR
	 * @model name="OVERRIDE_I_BRACKET_PAIR" literal="overrideIBracketPair"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IBRACKET_PAIR_VALUE = 85;

	/**
	 * The '<em><b>OVERRIDE ICOMMAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ICommand class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ICOMMAND
	 * @model name="OVERRIDE_I_COMMAND" literal="overrideICommand"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ICOMMAND_VALUE = 86;

	/**
	 * The '<em><b>OVERRIDE ICONFIGURABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IConfigurable class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ICONFIGURABLE
	 * @model name="OVERRIDE_I_CONFIGURABLE" literal="overrideIConfigurable"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ICONFIGURABLE_VALUE = 87;

	/**
	 * The '<em><b>OVERRIDE ICONTEXT DEPENDENT URI FRAGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IContextDependentUriFragment class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT
	 * @model name="OVERRIDE_I_CONTEXT_DEPENDENT_URI_FRAGMENT" literal="overrideIContextDependentURIFragment"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_VALUE = 88;

	/**
	 * The '<em><b>OVERRIDE ICONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IContextDependentUriFragmentFactory class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY
	 * @model name="OVERRIDE_I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY" literal="overrideIContextDependentURIFragmentFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE = 89;

	/**
	 * The '<em><b>OVERRIDE IELEMENT MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IElementMapping class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IELEMENT_MAPPING
	 * @model name="OVERRIDE_I_ELEMENT_MAPPING" literal="overrideIElementMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IELEMENT_MAPPING_VALUE = 90;

	/**
	 * The '<em><b>OVERRIDE IEXPECTED ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IExpectedElement class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IEXPECTED_ELEMENT
	 * @model name="OVERRIDE_I_EXPECTED_ELEMENT" literal="overrideIExpectedElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IEXPECTED_ELEMENT_VALUE = 91;

	/**
	 * The '<em><b>OVERRIDE IHOVER TEXT PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IHoverTextProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IHOVER_TEXT_PROVIDER
	 * @model name="OVERRIDE_I_HOVER_TEXT_PROVIDER" literal="overrideIHoverTextProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IHOVER_TEXT_PROVIDER_VALUE = 92;

	/**
	 * The '<em><b>OVERRIDE ILOCATION MAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ILocationMap class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ILOCATION_MAP
	 * @model name="OVERRIDE_I_LOCATION_MAP" literal="overrideILocationMap"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ILOCATION_MAP_VALUE = 93;

	/**
	 * The '<em><b>OVERRIDE IPARSE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IParseResult class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IPARSE_RESULT
	 * @model name="OVERRIDE_I_PARSE_RESULT" literal="overrideIParseResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IPARSE_RESULT_VALUE = 94;

	/**
	 * The '<em><b>OVERRIDE IPROBLEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IProblem class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IPROBLEM
	 * @model name="OVERRIDE_I_PROBLEM" literal="overrideIProblem"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IPROBLEM_VALUE = 95;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IReferenceMapping class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IREFERENCE_MAPPING
	 * @model name="OVERRIDE_I_REFERENCE_MAPPING" literal="overrideIReferenceMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_MAPPING_VALUE = 96;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IReferenceResolver class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVER
	 * @model name="OVERRIDE_I_REFERENCE_RESOLVER" literal="overrideIReferenceResolver"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_RESOLVER_VALUE = 97;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IReferenceResolveResult class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVE_RESULT
	 * @model name="OVERRIDE_I_REFERENCE_RESOLVE_RESULT" literal="overrideIReferenceResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_RESOLVE_RESULT_VALUE = 98;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVER SWITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IReferenceResolverSwitch class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVER_SWITCH
	 * @model name="OVERRIDE_I_REFERENCE_RESOLVER_SWITCH" literal="overrideIReferenceResolverSwitch"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_RESOLVER_SWITCH_VALUE = 99;

	/**
	 * The '<em><b>OVERRIDE ITEXT DIAGNOSTIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITextDiagnostic class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITEXT_DIAGNOSTIC
	 * @model name="OVERRIDE_I_TEXT_DIAGNOSTIC" literal="overrideITextDiagnostic"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_DIAGNOSTIC_VALUE = 100;

	/**
	 * The '<em><b>OVERRIDE ITEXT PARSER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITextParser class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITEXT_PARSER
	 * @model name="OVERRIDE_I_TEXT_PARSER" literal="overrideITextParser"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_PARSER_VALUE = 101;

	/**
	 * The '<em><b>OVERRIDE ITEXT PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITextPrinter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITEXT_PRINTER
	 * @model name="OVERRIDE_I_TEXT_PRINTER" literal="overrideITextPrinter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_PRINTER_VALUE = 102;

	/**
	 * The '<em><b>OVERRIDE ITEXT RESOURCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITextResource class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITEXT_RESOURCE
	 * @model name="OVERRIDE_I_TEXT_RESOURCE" literal="overrideITextResource"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_RESOURCE_VALUE = 103;

	/**
	 * The '<em><b>OVERRIDE IMETA INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IMetaInformation class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IMETA_INFORMATION
	 * @model name="OVERRIDE_I_META_INFORMATION" literal="overrideIMetaInformation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IMETA_INFORMATION_VALUE = 104;

	/**
	 * The '<em><b>OVERRIDE ITEXT RESOURCE PLUGIN PART</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITextResourcePluginPart class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART
	 * @model name="OVERRIDE_I_TEXT_RESOURCE_PLUGIN_PART" literal="overrideITextResourcePluginPart"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART_VALUE = 105;

	/**
	 * The '<em><b>OVERRIDE ITEXT SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITextScanner class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITEXT_SCANNER
	 * @model name="OVERRIDE_I_TEXT_SCANNER" literal="overrideITextScanner"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_SCANNER_VALUE = 106;

	/**
	 * The '<em><b>OVERRIDE ITEXT TOKEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITextToken class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITEXT_TOKEN
	 * @model name="OVERRIDE_I_TEXT_TOKEN" literal="overrideITextToken"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_TOKEN_VALUE = 107;

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITokenResolver class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVER
	 * @model name="OVERRIDE_I_TOKEN_RESOLVER" literal="overrideITokenResolver"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITOKEN_RESOLVER_VALUE = 108;

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITokenResolveResult class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVE_RESULT
	 * @model name="OVERRIDE_I_TOKEN_RESOLVE_RESULT" literal="overrideITokenResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITOKEN_RESOLVE_RESULT_VALUE = 109;

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVER FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITokenResolverFactory class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVER_FACTORY
	 * @model name="OVERRIDE_I_TOKEN_RESOLVER_FACTORY" literal="overrideITokenResolverFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITOKEN_RESOLVER_FACTORY_VALUE = 110;

	/**
	 * The '<em><b>OVERRIDE ITOKEN STYLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ITokenStyle class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ITOKEN_STYLE
	 * @model name="OVERRIDE_I_TOKEN_STYLE" literal="overrideITokenStyle"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITOKEN_STYLE_VALUE = 111;

	/**
	 * The '<em><b>OVERRIDE IURI MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IUriMapping class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IURI_MAPPING
	 * @model name="OVERRIDE_I_URI_MAPPING" literal="overrideIURIMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IURI_MAPPING_VALUE = 112;

	/**
	 * The '<em><b>OVERRIDE EPROBLEM TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EProblemType class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EPROBLEM_TYPE
	 * @model name="OVERRIDE_E_PROBLEM_TYPE" literal="overrideEProblemType"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EPROBLEM_TYPE_VALUE = 113;

	/**
	 * The '<em><b>OVERRIDE CODE COMPLETION HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the CodeCompletionHelper class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CODE_COMPLETION_HELPER
	 * @model literal="overrideCodeCompletionHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CODE_COMPLETION_HELPER_VALUE = 114;

	/**
	 * The '<em><b>OVERRIDE EXPECTED CS STRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ExpectedCsString class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EXPECTED_CS_STRING
	 * @model literal="overrideExpectedCsString"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTED_CS_STRING_VALUE = 115;

	/**
	 * The '<em><b>OVERRIDE EXPECTED STRUCTURAL FEATURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ExpectedStructuralFeature class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EXPECTED_STRUCTURAL_FEATURE
	 * @model literal="overrideExpectedStructuralFeature"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTED_STRUCTURAL_FEATURE_VALUE = 116;

	/**
	 * The '<em><b>OVERRIDE CAST UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the CastUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CAST_UTIL
	 * @model literal="overrideCastUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CAST_UTIL_VALUE = 117;

	/**
	 * The '<em><b>OVERRIDE COPIED ELIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the CopiedEList class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_COPIED_ELIST
	 * @model name="OVERRIDE_COPIED_E_LIST" literal="overrideCopiedEList"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COPIED_ELIST_VALUE = 118;

	/**
	 * The '<em><b>OVERRIDE COPIED EOBJECT INTERNAL ELIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the CopiedEObjectInternalEList class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST
	 * @model name="OVERRIDE_COPIED_E_OBJECT_INTERNAL_E_LIST" literal="overrideCopiedEObjectInternalEList"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST_VALUE = 119;

	/**
	 * The '<em><b>OVERRIDE ECLASS UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EClassUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ECLASS_UTIL
	 * @model name="OVERRIDE_E_CLASS_UTIL" literal="overrideEClassUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ECLASS_UTIL_VALUE = 120;

	/**
	 * The '<em><b>OVERRIDE EOBJECT UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EObjectUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EOBJECT_UTIL
	 * @model name="OVERRIDE_E_OBJECT_UTIL" literal="overrideEObjectUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EOBJECT_UTIL_VALUE = 121;

	/**
	 * The '<em><b>OVERRIDE LIST UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ListUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LIST_UTIL
	 * @model literal="overrideListUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LIST_UTIL_VALUE = 122;

	/**
	 * The '<em><b>OVERRIDE MAP UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the MapUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_MAP_UTIL
	 * @model literal="overrideMapUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MAP_UTIL_VALUE = 123;

	/**
	 * The '<em><b>OVERRIDE MINIMAL MODEL HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the MinimalModelHelper class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_MINIMAL_MODEL_HELPER
	 * @model literal="overrideMinimalModelHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MINIMAL_MODEL_HELPER_VALUE = 124;

	/**
	 * The '<em><b>OVERRIDE RESOURCE UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ResourceUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_RESOURCE_UTIL
	 * @model literal="overrideResourceUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RESOURCE_UTIL_VALUE = 125;

	/**
	 * The '<em><b>OVERRIDE STREAM UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the StreamUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_STREAM_UTIL
	 * @model literal="overrideStreamUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_STREAM_UTIL_VALUE = 126;

	/**
	 * The '<em><b>OVERRIDE STRING UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the StringUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_STRING_UTIL
	 * @model literal="overrideStringUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_STRING_UTIL_VALUE = 127;

	/**
	 * The '<em><b>OVERRIDE TEXT RESOURCE UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TextResourceUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TEXT_RESOURCE_UTIL
	 * @model literal="overrideTextResourceUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TEXT_RESOURCE_UTIL_VALUE = 128;

	/**
	 * The '<em><b>OVERRIDE UNICODE CONVERTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the UnicodeConverter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UNICODE_CONVERTER
	 * @model literal="overrideUnicodeConverter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UNICODE_CONVERTER_VALUE = 129;

	/**
	 * The '<em><b>OVERRIDE ABSTRACT EXPECTED ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AbstractExpectedElement class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ABSTRACT_EXPECTED_ELEMENT
	 * @model literal="overrideAbstractExpectedElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ABSTRACT_EXPECTED_ELEMENT_VALUE = 130;

	/**
	 * The '<em><b>OVERRIDE NEW FILE WIZARD PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the NewFileWizardPage class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_NEW_FILE_WIZARD_PAGE
	 * @model literal="overrideNewFileWizardPage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NEW_FILE_WIZARD_PAGE_VALUE = 131;

	/**
	 * The '<em><b>OVERRIDE IBACKGROUND PARSING LISTENER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IBackgroundParsingListener class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IBACKGROUND_PARSING_LISTENER
	 * @model name="OVERRIDE_I_BACKGROUND_PARSING_LISTENER" literal="overrideIBackgroundParsingListener"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IBACKGROUND_PARSING_LISTENER_VALUE = 132;

	/**
	 * The '<em><b>OVERRIDE TERMINATE PARSING EXCEPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TerminateParsingException class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TERMINATE_PARSING_EXCEPTION
	 * @model literal="overrideTerminateParsingException"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TERMINATE_PARSING_EXCEPTION_VALUE = 133;

	/**
	 * The '<em><b>OVERRIDE UNEXPECTED CONTENT TYPE EXCEPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the UnexpectedContentTypeException class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION
	 * @model literal="overrideUnexpectedContentTypeException"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION_VALUE = 134;

	/**
	 * The '<em><b>OVERRIDE TEXT TOKEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TextToken class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TEXT_TOKEN
	 * @model literal="overrideTextToken"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TEXT_TOKEN_VALUE = 135;

	/**
	 * The '<em><b>SOURCE GEN FOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the folder where EMFText shall store the generated classes of the resource plug-in in. All classes for which the <code>override</code> option is set to <code>true</code> will be stored in this folder.
	 * <!-- end-model-doc -->
	 * @see #SOURCE_GEN_FOLDER
	 * @model literal="srcGenFolder"
	 * @generated
	 * @ordered
	 */
	public static final int SOURCE_GEN_FOLDER_VALUE = 136;

	/**
	 * The '<em><b>OVERRIDE DEFAULT LOAD OPTIONS EXTENSION POINT SCHEMA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the extension point schema for default load options is not overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA
	 * @model literal="overrideDefaultLoadOptionsExtensionPointSchema"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA_VALUE = 137;

	/**
	 * The '<em><b>OVERRIDE ADDITIONAL EXTENSION PARSER EXTENSION POINT SCHEMA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the extension point schema for additional parsers is not overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA
	 * @model literal="overrideAdditionalExtensionParserExtensionPointSchema"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA_VALUE = 138;

	/**
	 * The '<em><b>OVERRIDE RESOURCE FACTORY DELEGATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ResourceFactoryDelegator class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_RESOURCE_FACTORY_DELEGATOR
	 * @model literal="overrideResourceFactoryDelegator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RESOURCE_FACTORY_DELEGATOR_VALUE = 139;

	/**
	 * The '<em><b>BASE RESOURCE PLUGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The plug-in containing the resource implementation for the DSL (if different from the generated resource plug-in). By default this option is not set, which means that the generated resource plug-in provides the resource implementation.
	 * <!-- end-model-doc -->
	 * @see #BASE_RESOURCE_PLUGIN
	 * @model literal="baseResourcePlugin"
	 * @generated
	 * @ordered
	 */
	public static final int BASE_RESOURCE_PLUGIN_VALUE = 140;

	/**
	 * The '<em><b>OVERRIDE PREFERENCE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PreferencePage class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PREFERENCE_PAGE
	 * @model literal="overridePreferencePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PREFERENCE_PAGE_VALUE = 141;

	/**
	 * The '<em><b>ANTLR PLUGIN ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the ID for the generated common ANTLR runtime plug-in. The default value for this option is <code>org.emftext.commons.antlr3_4_0</code>.
	 * <!-- end-model-doc -->
	 * @see #ANTLR_PLUGIN_ID
	 * @model literal="antlrPluginID"
	 * @generated
	 * @ordered
	 */
	public static final int ANTLR_PLUGIN_ID_VALUE = 142;

	/**
	 * The '<em><b>OVERRIDE ANTLR PLUGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, no ANTLR common runtime plug-in is generated. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ANTLR_PLUGIN
	 * @model literal="overrideAntlrPlugin"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ANTLR_PLUGIN_VALUE = 143;

	/**
	 * The '<em><b>OVERRIDE TOKEN STYLE INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TokenStyleInformationProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER
	 * @model literal="overrideTokenStyleInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER_VALUE = 144;

	/**
	 * The '<em><b>OVERRIDE FOLDING INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the FoldingInformationProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_FOLDING_INFORMATION_PROVIDER
	 * @model literal="overrideFoldingInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_FOLDING_INFORMATION_PROVIDER_VALUE = 145;

	/**
	 * The '<em><b>OVERRIDE BRACKET INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the BracketInformationProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_BRACKET_INFORMATION_PROVIDER
	 * @model literal="overrideBracketInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BRACKET_INFORMATION_PROVIDER_VALUE = 146;

	/**
	 * The '<em><b>OVERRIDE SYNTAX COVERAGE INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SyntaxCoverageInformationProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER
	 * @model literal="overrideSyntaxCoverageInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER_VALUE = 147;

	/**
	 * The '<em><b>SAVE CHANGED RESOURCES ONLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the generated EMF resource will save only resource when their content (text) has actually changed. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #SAVE_CHANGED_RESOURCES_ONLY
	 * @model literal="saveChangedResourcesOnly"
	 * @generated
	 * @ordered
	 */
	public static final int SAVE_CHANGED_RESOURCES_ONLY_VALUE = 148;

	/**
	 * The '<em><b>OVERRIDE NEW FILE CONTENT PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the NewFileContentProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_NEW_FILE_CONTENT_PROVIDER
	 * @model literal="overrideNewFileContentProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NEW_FILE_CONTENT_PROVIDER_VALUE = 149;

	/**
	 * The '<em><b>LICENCE HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A URI pointing to a text file that contains a header which shall be added to all generated Java files. This option is useful to include copyright statements in the generated classes. If this option is not set, a default (empty) header is added to all generated Java classes.
	 * <!-- end-model-doc -->
	 * @see #LICENCE_HEADER
	 * @model literal="licenceHeader"
	 * @generated
	 * @ordered
	 */
	public static final int LICENCE_HEADER_VALUE = 150;

	/**
	 * The '<em><b>OVERRIDE EXPECTED TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ExpectedTerminal class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EXPECTED_TERMINAL
	 * @model literal="overrideExpectedTerminal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTED_TERMINAL_VALUE = 151;

	/**
	 * The '<em><b>OVERRIDE COMPLETION PROPOSAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the CompletionProposal class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_COMPLETION_PROPOSAL
	 * @model literal="overrideCompletionProposal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COMPLETION_PROPOSAL_VALUE = 152;

	/**
	 * The '<em><b>OVERRIDE BUILDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Builder class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_BUILDER
	 * @model literal="overrideBuilder"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BUILDER_VALUE = 153;

	/**
	 * The '<em><b>OVERRIDE BUILDER ADAPTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the BuilderAdapter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_BUILDER_ADAPTER
	 * @model literal="overrideBuilderAdapter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BUILDER_ADAPTER_VALUE = 154;

	/**
	 * The '<em><b>OVERRIDE IBUILDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IBuilder class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IBUILDER
	 * @model name="OVERRIDE_I_BUILDER" literal="overrideIBuilder"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IBUILDER_VALUE = 155;

	/**
	 * The '<em><b>OVERRIDE NATURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Nature class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_NATURE
	 * @model literal="overrideNature"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NATURE_VALUE = 156;

	/**
	 * The '<em><b>ADDITIONAL DEPENDENCIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of comma separated plug-in IDs, which will be added to the manifest of the generated resource plug-in. The default value for this option is an empty list.
	 * <!-- end-model-doc -->
	 * @see #ADDITIONAL_DEPENDENCIES
	 * @model literal="additionalDependencies"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_DEPENDENCIES_VALUE = 157;

	/**
	 * The '<em><b>DISABLE BUILDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the builder that is generated and registered by default will not be registered anymore. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #DISABLE_BUILDER
	 * @model literal="disableBuilder"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_BUILDER_VALUE = 158;

	/**
	 * The '<em><b>ADDITIONAL EXPORTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of comma separated packages, which will be added as exports to the manifest of the generated resource plug-in. The default value for this option is an empty list.
	 * <!-- end-model-doc -->
	 * @see #ADDITIONAL_EXPORTS
	 * @model literal="additionalExports"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_EXPORTS_VALUE = 159;

	/**
	 * The '<em><b>OVERRIDE PAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Pair class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PAIR
	 * @model literal="overridePair"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PAIR_VALUE = 160;

	/**
	 * The '<em><b>OVERRIDE ABSTRACT INTERPRETER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AbstractInterpreter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ABSTRACT_INTERPRETER
	 * @model literal="overrideAbstractInterpreter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ABSTRACT_INTERPRETER_VALUE = 161;

	/**
	 * The '<em><b>OVERRIDE GRAMMAR INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the GrammarInformationProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_GRAMMAR_INFORMATION_PROVIDER
	 * @model literal="overrideGrammarInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_GRAMMAR_INFORMATION_PROVIDER_VALUE = 162;

	/**
	 * The '<em><b>OVERRIDE ATTRIBUTE VALUE PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AttributeValueProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ATTRIBUTE_VALUE_PROVIDER
	 * @model literal="overrideAttributeValueProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ATTRIBUTE_VALUE_PROVIDER_VALUE = 163;

	/**
	 * The '<em><b>OVERRIDE FOLLOW SET PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the FollowSetProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_FOLLOW_SET_PROVIDER
	 * @model literal="overrideFollowSetProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_FOLLOW_SET_PROVIDER_VALUE = 164;

	/**
	 * The '<em><b>OVERRIDE SYNTAX ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SyntaxElement class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SYNTAX_ELEMENT
	 * @model literal="overrideSyntaxElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_ELEMENT_VALUE = 165;

	/**
	 * The '<em><b>OVERRIDE KEYWORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Keyword class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_KEYWORD
	 * @model literal="overrideKeyword"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_KEYWORD_VALUE = 166;

	/**
	 * The '<em><b>OVERRIDE PLACEHOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Placeholder class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PLACEHOLDER
	 * @model literal="overridePlaceholder"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PLACEHOLDER_VALUE = 167;

	/**
	 * The '<em><b>OVERRIDE CARDINALITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Cardinality class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CARDINALITY
	 * @model literal="overrideCardinality"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CARDINALITY_VALUE = 168;

	/**
	 * The '<em><b>OVERRIDE PRINTER2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Printer2 class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PRINTER2
	 * @model literal="overridePrinter2"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PRINTER2_VALUE = 169;

	/**
	 * The '<em><b>OVERRIDE CHOICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Choice class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CHOICE
	 * @model literal="overrideChoice"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CHOICE_VALUE = 170;

	/**
	 * The '<em><b>OVERRIDE COMPOUND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Compound class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_COMPOUND
	 * @model literal="overrideCompound"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COMPOUND_VALUE = 171;

	/**
	 * The '<em><b>OVERRIDE CONTAINMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Containment class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CONTAINMENT
	 * @model literal="overrideContainment"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CONTAINMENT_VALUE = 172;

	/**
	 * The '<em><b>OVERRIDE LINE BREAK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LineBreak class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LINE_BREAK
	 * @model literal="overrideLineBreak"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LINE_BREAK_VALUE = 173;

	/**
	 * The '<em><b>OVERRIDE SEQUENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Sequence class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SEQUENCE
	 * @model literal="overrideSequence"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SEQUENCE_VALUE = 174;

	/**
	 * The '<em><b>OVERRIDE WHITE SPACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the WhiteSpace class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_WHITE_SPACE
	 * @model literal="overrideWhiteSpace"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_WHITE_SPACE_VALUE = 175;

	/**
	 * The '<em><b>OVERRIDE SYNTAX ELEMENT DECORATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SyntaxElementDecorator class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SYNTAX_ELEMENT_DECORATOR
	 * @model literal="overrideSyntaxElementDecorator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_ELEMENT_DECORATOR_VALUE = 176;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE CACHE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IReferenceCache class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IREFERENCE_CACHE
	 * @model name="OVERRIDE_I_REFERENCE_CACHE" literal="overrideIReferenceCache"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_CACHE_VALUE = 177;

	/**
	 * The '<em><b>OVERRIDE DEFAULT HOVER TEXT PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DefaultHoverTextProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER
	 * @model literal="overrideDefaultHoverTextProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER_VALUE = 178;

	/**
	 * The '<em><b>OVERRIDE FORMATTING ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the FormattingElement class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_FORMATTING_ELEMENT
	 * @model literal="overrideFormattingElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_FORMATTING_ELEMENT_VALUE = 179;

	/**
	 * The '<em><b>OVERRIDE TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Terminal class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TERMINAL
	 * @model literal="overrideTerminal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TERMINAL_VALUE = 180;

	/**
	 * The '<em><b>OVERRIDE LAYOUT INFORMATION ADAPTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LayoutInformationAdapter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LAYOUT_INFORMATION_ADAPTER
	 * @model literal="overrideLayoutInformationAdapter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAYOUT_INFORMATION_ADAPTER_VALUE = 181;

	/**
	 * The '<em><b>OVERRIDE LAYOUT INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LayoutInformation class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LAYOUT_INFORMATION
	 * @model literal="overrideLayoutInformation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAYOUT_INFORMATION_VALUE = 182;

	/**
	 * The '<em><b>USE CLASSIC PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the classic printer (i.e., the one used before EMFText 1.3.0) will be used. Otherwise the new printer implementation is used. In any case both printers are generated, but only one is used. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #USE_CLASSIC_PRINTER
	 * @model literal="useClassicPrinter"
	 * @generated
	 * @ordered
	 */
	public static final int USE_CLASSIC_PRINTER_VALUE = 183;

	/**
	 * The '<em><b>DISABLE EVALIDATORS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, constraint validation using registered EValidators will be enabled. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #DISABLE_EVALIDATORS
	 * @model name="DISABLE_E_VALIDATORS" literal="disableEValidators"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_EVALIDATORS_VALUE = 184;

	/**
	 * The '<em><b>DISABLE EMF VALIDATION CONSTRAINTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, constraint validation using the EMF Validation Framework is disabled. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #DISABLE_EMF_VALIDATION_CONSTRAINTS
	 * @model literal="disableEMFValidationConstraints"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_EMF_VALIDATION_CONSTRAINTS_VALUE = 185;

	/**
	 * The '<em><b>OVERRIDE UI META INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the MetaInformation class of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UI_META_INFORMATION
	 * @model literal="overrideUIMetaInformation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_META_INFORMATION_VALUE = 186;

	/**
	 * The '<em><b>RESOURCE UI PLUGIN ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ID of the generated resource UI plug-in. The resource UI plug-in is stored in a folder that is equal to this ID.
	 * <!-- end-model-doc -->
	 * @see #RESOURCE_UI_PLUGIN_ID
	 * @model literal="resourceUIPluginID"
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_UI_PLUGIN_ID_VALUE = 187;

	/**
	 * The '<em><b>OVERRIDE UI PLUGIN ACTIVATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the plug-in activator class of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UI_PLUGIN_ACTIVATOR
	 * @model literal="overrideUIPluginActivator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_PLUGIN_ACTIVATOR_VALUE = 188;

	/**
	 * The '<em><b>UI BASE PACKAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The package where to store all classes of the resource UI plug-in in. If this option is not set, the default value is determined by adding the suffix <code>resource.FILE_EXTENSION.ui</code> to the base package of the generator model.
	 * <!-- end-model-doc -->
	 * @see #UI_BASE_PACKAGE
	 * @model literal="uiBasePackage"
	 * @generated
	 * @ordered
	 */
	public static final int UI_BASE_PACKAGE_VALUE = 189;

	/**
	 * The '<em><b>ADDITIONAL UI DEPENDENCIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of comma separated plug-in IDs, which will be added to the manifest of the generated resource UI plug-in. The default value for this option is an empty list.
	 * <!-- end-model-doc -->
	 * @see #ADDITIONAL_UI_DEPENDENCIES
	 * @model literal="additionalUIDependencies"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_UI_DEPENDENCIES_VALUE = 190;

	/**
	 * The '<em><b>ADDITIONAL UI EXPORTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of comma separated packages, which will be added as exports to the manifest of the generated resource UI plug-in. The default value for this option is an empty list.
	 * <!-- end-model-doc -->
	 * @see #ADDITIONAL_UI_EXPORTS
	 * @model literal="additionalUIExports"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_UI_EXPORTS_VALUE = 191;

	/**
	 * The '<em><b>OVERRIDE UI MANIFEST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the manifest of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UI_MANIFEST
	 * @model literal="overrideUIManifest"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_MANIFEST_VALUE = 192;

	/**
	 * The '<em><b>OVERRIDE UI BUILD PROPERTIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the build.properties file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UI_BUILD_PROPERTIES
	 * @model literal="overrideUIBuildProperties"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_BUILD_PROPERTIES_VALUE = 193;

	/**
	 * The '<em><b>OVERRIDE UI DOT CLASSPATH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the .classpath file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UI_DOT_CLASSPATH
	 * @model literal="overrideUIDotClasspath"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_DOT_CLASSPATH_VALUE = 194;

	/**
	 * The '<em><b>OVERRIDE UI DOT PROJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the .project file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UI_DOT_PROJECT
	 * @model literal="overrideUIDotProject"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_DOT_PROJECT_VALUE = 195;

	/**
	 * The '<em><b>UI SOURCE FOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the folder where EMFText shall store the customizable classes of the resource UI plug-in in. All classes for which the <code>override</code> option is set to <code>false</code> will be stored in this folder.
	 * <!-- end-model-doc -->
	 * @see #UI_SOURCE_FOLDER
	 * @model literal="uiSrcFolder"
	 * @generated
	 * @ordered
	 */
	public static final int UI_SOURCE_FOLDER_VALUE = 196;

	/**
	 * The '<em><b>UI SOURCE GEN FOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the folder EMFText shall store the generated classes of the resource UI plug-in in. All classes for which the <code>override</code> option is set to <code>true</code> will be stored in this folder.
	 * <!-- end-model-doc -->
	 * @see #UI_SOURCE_GEN_FOLDER
	 * @model literal="uiSrcGenFolder"
	 * @generated
	 * @ordered
	 */
	public static final int UI_SOURCE_GEN_FOLDER_VALUE = 197;

	/**
	 * The '<em><b>GENERATE UI PLUGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, EMFText will not generate the resource UI plug-in. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #GENERATE_UI_PLUGIN
	 * @model literal="generateUIPlugin"
	 * @generated
	 * @ordered
	 */
	public static final int GENERATE_UI_PLUGIN_VALUE = 198;

	/**
	 * The '<em><b>OVERRIDE IBRACKET HANDLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IBracketHandler class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IBRACKET_HANDLER
	 * @model name="OVERRIDE_I_BRACKET_HANDLER" literal="overrideIBracketHandler"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IBRACKET_HANDLER_VALUE = 199;

	/**
	 * The '<em><b>OVERRIDE UI PLUGIN XML</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the plugin.xml file of the resource UI plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UI_PLUGIN_XML
	 * @model literal="overrideUIPluginXML"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_PLUGIN_XML_VALUE = 200;

	/**
	 * The '<em><b>OVERRIDE PROPOSAL POST PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ProposalPostProcessor class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PROPOSAL_POST_PROCESSOR
	 * @model literal="overrideProposalPostProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PROPOSAL_POST_PROCESSOR_VALUE = 201;

	/**
	 * The '<em><b>DISABLE TOKEN SORTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Disables the automatic sorting of tokens. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #DISABLE_TOKEN_SORTING
	 * @model literal="disableTokenSorting"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_TOKEN_SORTING_VALUE = 202;

	/**
	 * The '<em><b>OVERRIDE IQUICK FIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IQuickFix class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IQUICK_FIX
	 * @model name="OVERRIDE_I_QUICK_FIX" literal="overrideIQuickFix"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IQUICK_FIX_VALUE = 203;

	/**
	 * The '<em><b>OVERRIDE QUICK FIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the QuickFix class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_QUICK_FIX
	 * @model literal="overrideQuickFix"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_QUICK_FIX_VALUE = 204;

	/**
	 * The '<em><b>OVERRIDE ANNOTATION MODEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AnnotationModel class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ANNOTATION_MODEL
	 * @model literal="overrideAnnotationModel"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ANNOTATION_MODEL_VALUE = 205;

	/**
	 * The '<em><b>OVERRIDE ANNOTATION MODEL FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, AnnotationModelFactory class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ANNOTATION_MODEL_FACTORY
	 * @model literal="overrideAnnotationModelFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ANNOTATION_MODEL_FACTORY_VALUE = 206;

	/**
	 * The '<em><b>OVERRIDE MARKER ANNOTATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the MarkerAnnotation class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_MARKER_ANNOTATION
	 * @model literal="overrideMarkerAnnotation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MARKER_ANNOTATION_VALUE = 208;

	/**
	 * The '<em><b>OVERRIDE MARKER RESOLUTION GENERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the MarkerResolutionGenerator class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_MARKER_RESOLUTION_GENERATOR
	 * @model literal="overrideMarkerResolutionGenerator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MARKER_RESOLUTION_GENERATOR_VALUE = 209;

	/**
	 * The '<em><b>OVERRIDE QUICK ASSIST ASSISTANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the QuickAssistAssistant class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_QUICK_ASSIST_ASSISTANT
	 * @model literal="overrideQuickAssistAssistant"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_QUICK_ASSIST_ASSISTANT_VALUE = 211;

	/**
	 * The '<em><b>OVERRIDE QUICK ASSIST PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the QuickAssistProcessor class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_QUICK_ASSIST_PROCESSOR
	 * @model literal="overrideQuickAssistProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_QUICK_ASSIST_PROCESSOR_VALUE = 212;

	/**
	 * The '<em><b>OVERRIDE IMAGE PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ImageProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IMAGE_PROVIDER
	 * @model literal="overrideImageProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IMAGE_PROVIDER_VALUE = 213;

	/**
	 * The '<em><b>OVERRIDE TOKEN STYLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TokenStyle class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TOKEN_STYLE
	 * @model literal="overrideTokenStyle"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_STYLE_VALUE = 214;

	/**
	 * The '<em><b>OVERRIDE DYNAMIC TOKEN STYLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DynamicTokenStyler class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DYNAMIC_TOKEN_STYLER
	 * @model literal="overrideDynamicTokenStyler"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DYNAMIC_TOKEN_STYLER_VALUE = 215;

	/**
	 * The '<em><b>RESOLVE PROXY ELEMENTS AFTER PARSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the generated resource class will not resolve references after parsing. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #RESOLVE_PROXY_ELEMENTS_AFTER_PARSING
	 * @model literal="resolveProxyElementsAfterParsing"
	 * @generated
	 * @ordered
	 */
	public static final int RESOLVE_PROXY_ELEMENTS_AFTER_PARSING_VALUE = 216;

	/**
	 * The '<em><b>OVERRIDE EXPECTED BOOLEAN TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ExpectedBooleanTerminal class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EXPECTED_BOOLEAN_TERMINAL
	 * @model literal="overrideExpectedBooleanTerminal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTED_BOOLEAN_TERMINAL_VALUE = 217;

	/**
	 * The '<em><b>OVERRIDE BOOLEAN TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the BooleanTerminal class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_BOOLEAN_TERMINAL
	 * @model literal="overrideBooleanTerminal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BOOLEAN_TERMINAL_VALUE = 218;

	/**
	 * The '<em><b>OVERRIDE ENUMERATION TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EnumerationTerminal class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ENUMERATION_TERMINAL
	 * @model literal="overrideEnumerationTerminal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ENUMERATION_TERMINAL_VALUE = 219;

	/**
	 * The '<em><b>OVERRIDE EXPECTED ENUMERATION TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ExpectedEnumerationTerminal class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EXPECTED_ENUMERATION_TERMINAL
	 * @model literal="overrideExpectedEnumerationTerminal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTED_ENUMERATION_TERMINAL_VALUE = 220;

	/**
	 * The '<em><b>OVERRIDE CHANGE REFERENCE QUICK FIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ChangeReferenceQuickFix class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CHANGE_REFERENCE_QUICK_FIX
	 * @model literal="overrideChangeReferenceQuickFix"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CHANGE_REFERENCE_QUICK_FIX_VALUE = 221;

	/**
	 * The '<em><b>OVERRIDE EPROBLEM SEVERITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EProblemSeverity class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EPROBLEM_SEVERITY
	 * @model literal="overrideEProblemSeverity"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EPROBLEM_SEVERITY_VALUE = 222;

	/**
	 * The '<em><b>OVERRIDE RESOURCE POST PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ResourcePostProcessor class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_RESOURCE_POST_PROCESSOR
	 * @model literal="overrideResourcePostProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RESOURCE_POST_PROCESSOR_VALUE = 223;

	/**
	 * The '<em><b>OVERRIDE IRESOURCE PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IResourceProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IRESOURCE_PROVIDER
	 * @model name="OVERRIDE_I_RESOURCE_PROVIDER" literal="overrideIResourceProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IRESOURCE_PROVIDER_VALUE = 224;

	/**
	 * The '<em><b>OVERRIDE IBRACKET HANDLER PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IBracketHandlerProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IBRACKET_HANDLER_PROVIDER
	 * @model name="OVERRIDE_I_BRACKET_HANDLER_PROVIDER" literal="overrideIBracketHandlerProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IBRACKET_HANDLER_PROVIDER_VALUE = 225;

	/**
	 * The '<em><b>OVERRIDE IANNOTATION MODEL PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IAnnotationModelProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IANNOTATION_MODEL_PROVIDER
	 * @model name="OVERRIDE_I_ANNOTATION_MODEL_PROVIDER" literal="overrideIAnnotationModelProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IANNOTATION_MODEL_PROVIDER_VALUE = 226;

	/**
	 * The '<em><b>OVERRIDE LAUNCH CONFIGURATION DELEGATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LaunchConfigurationDelegate class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE
	 * @model literal="overrideLaunchConfigurationDelegate"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE_VALUE = 227;

	/**
	 * The '<em><b>OVERRIDE LAUNCH CONFIGURATION TAB GROUP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LaunchConfigurationTabGroup class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP
	 * @model literal="overrideLaunchConfigurationTabGroup"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP_VALUE = 228;

	/**
	 * The '<em><b>OVERRIDE LAUNCH CONFIGURATION MAIN TAB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LaunchConfigurationMainTab class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB
	 * @model literal="overrideLaunchConfigurationMainTab"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB_VALUE = 229;

	/**
	 * The '<em><b>OVERRIDE LAUNCH SHORTCUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LaunchShortcurt class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LAUNCH_SHORTCUT
	 * @model literal="overrideLaunchShortcut"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAUNCH_SHORTCUT_VALUE = 230;

	/**
	 * The '<em><b>OVERRIDE PROPERTY TESTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the PropertyTester class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_PROPERTY_TESTER
	 * @model literal="overridePropertyTester"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PROPERTY_TESTER_VALUE = 231;

	/**
	 * The '<em><b>DISABLE LAUNCH SUPPORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, code that is required to support launching of DSL models is not generated. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #DISABLE_LAUNCH_SUPPORT
	 * @model literal="disableLaunchSupport"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_LAUNCH_SUPPORT_VALUE = 232;

	/**
	 * The '<em><b>OVERRIDE RULE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the Rule class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_RULE
	 * @model literal="overrideRule"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RULE_VALUE = 233;

	/**
	 * The '<em><b>OVERRIDE ABSTRACT DEBUGGABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AbstractDebuggable class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ABSTRACT_DEBUGGABLE
	 * @model literal="overrideAbstractDebuggable"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ABSTRACT_DEBUGGABLE_VALUE = 234;

	/**
	 * The '<em><b>OVERRIDE EDEBUG MESSAGE TYPES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EDebugMessage enumeration will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EDEBUG_MESSAGE_TYPES
	 * @model name="OVERRIDE_E_DEBUG_MESSAGE_TYPES" literal="overrideEDebugMessageTypes"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EDEBUG_MESSAGE_TYPES_VALUE = 235;

	/**
	 * The '<em><b>OVERRIDE IDEBUG EVENT LISTENER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IDebugEventListener interface will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IDEBUG_EVENT_LISTENER
	 * @model name="OVERRIDE_I_DEBUG_EVENT_LISTENER" literal="overrideIDebugEventListener"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IDEBUG_EVENT_LISTENER_VALUE = 236;

	/**
	 * The '<em><b>OVERRIDE IINTERPRETER LISTENER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IInterpreterListener interface will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IINTERPRETER_LISTENER
	 * @model name="OVERRIDE_I_INTERPRETER_LISTENER" literal="overrideIInterpreterListener"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IINTERPRETER_LISTENER_VALUE = 237;

	/**
	 * The '<em><b>OVERRIDE DEBUG COMMUNICATION HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugCommunicationHandler class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_COMMUNICATION_HELPER
	 * @model literal="overrideDebugCommunicationHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_COMMUNICATION_HELPER_VALUE = 238;

	/**
	 * The '<em><b>OVERRIDE DEBUG ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugElement class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_ELEMENT
	 * @model literal="overrideDebugElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_ELEMENT_VALUE = 239;

	/**
	 * The '<em><b>OVERRIDE DEBUGGABLE INTERPRETER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebuggableInterpreter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUGGABLE_INTERPRETER
	 * @model literal="overrideDebuggableInterpreter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUGGABLE_INTERPRETER_VALUE = 240;

	/**
	 * The '<em><b>OVERRIDE DEBUGGER LISTENER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebuggerListener class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUGGER_LISTENER
	 * @model literal="overrideDebuggerListener"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUGGER_LISTENER_VALUE = 241;

	/**
	 * The '<em><b>OVERRIDE DEBUG MESSAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugMessage class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_MESSAGE
	 * @model literal="overrideDebugMessage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_MESSAGE_VALUE = 242;

	/**
	 * The '<em><b>OVERRIDE DEBUG PROCESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugProcess class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_PROCESS
	 * @model literal="overrideDebugProcess"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_PROCESS_VALUE = 243;

	/**
	 * The '<em><b>OVERRIDE DEBUG PROXY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugProxy class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_PROXY
	 * @model literal="overrideDebugProxy"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_PROXY_VALUE = 244;

	/**
	 * The '<em><b>OVERRIDE DEBUG TARGET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugTarget class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_TARGET
	 * @model literal="overrideDebugTarget"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_TARGET_VALUE = 245;

	/**
	 * The '<em><b>OVERRIDE DEBUG THREAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugThread class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_THREAD
	 * @model literal="overrideDebugThread"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_THREAD_VALUE = 246;

	/**
	 * The '<em><b>OVERRIDE DEBUG VALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugValue class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_VALUE
	 * @model literal="overrideDebugValue"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_VALUE_VALUE = 247;

	/**
	 * The '<em><b>OVERRIDE DEBUG VARIABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugVariable class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_VARIABLE
	 * @model literal="overrideDebugVariable"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_VARIABLE_VALUE = 248;

	/**
	 * The '<em><b>OVERRIDE LINEBREAK POINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LinebreakPoint class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LINEBREAK_POINT
	 * @model literal="overrideLineBreakpoint"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LINEBREAK_POINT_VALUE = 249;

	/**
	 * The '<em><b>OVERRIDE SOURCE LOCATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SourceLocator class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SOURCE_LOCATOR
	 * @model literal="overrideSourceLocator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SOURCE_LOCATOR_VALUE = 250;

	/**
	 * The '<em><b>OVERRIDE SOURCE LOOKUP PARTICIPANT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SourceLookupParticipant class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SOURCE_LOOKUP_PARTICIPANT
	 * @model literal="overrideSourceLookupParticipant"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SOURCE_LOOKUP_PARTICIPANT_VALUE = 251;

	/**
	 * The '<em><b>OVERRIDE SOURCE PATH COMPUTER DELEGATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SourcePathComputerDelegate class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE
	 * @model literal="overrideSourcePathComputerDelegate"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE_VALUE = 252;

	/**
	 * The '<em><b>OVERRIDE STACK FRAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the StackFrame class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_STACK_FRAME
	 * @model literal="overrideStackFrame"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_STACK_FRAME_VALUE = 253;

	/**
	 * The '<em><b>DISABLE DEBUG SUPPORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, code that is required to support debugging of DSL models is not generated. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #DISABLE_DEBUG_SUPPORT
	 * @model literal="disableDebugSupport"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_DEBUG_SUPPORT_VALUE = 254;

	/**
	 * The '<em><b>OVERRIDE DEBUG MODEL PRESENTATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DebugModelPresentation class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEBUG_MODEL_PRESENTATION
	 * @model literal="overrideDebugModelPresentation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEBUG_MODEL_PRESENTATION_VALUE = 255;

	/**
	 * The '<em><b>OVERRIDE LINE BREAKPOINT ADAPTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LineBreakpointAdapter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LINE_BREAKPOINT_ADAPTER
	 * @model literal="overrideLineBreakpointAdapter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LINE_BREAKPOINT_ADAPTER_VALUE = 256;

	/**
	 * The '<em><b>OVERRIDE ADAPTER FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AdapterFactory class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ADAPTER_FACTORY
	 * @model literal="overrideAdapterFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ADAPTER_FACTORY_VALUE = 257;

	/**
	 * The '<em><b>OVERRIDE LAUNCH CONFIGURATION HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LaunchConfigurationHelper class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LAUNCH_CONFIGURATION_HELPER
	 * @model literal="overrideLaunchConfigurationHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAUNCH_CONFIGURATION_HELPER_VALUE = 258;

	/**
	 * The '<em><b>OVERRIDE NEW PROJECT WIZARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the NewProjectWizard class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_NEW_PROJECT_WIZARD
	 * @model literal="overrideNewProjectWizard"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NEW_PROJECT_WIZARD_VALUE = 259;

	/**
	 * The '<em><b>DISABLE NEW PROJECT WIZARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the new NewProjectWizard is not registered. Use this option if there is already an existing wizard. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #DISABLE_NEW_PROJECT_WIZARD
	 * @model literal="disableNewProjectWizard"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_NEW_PROJECT_WIZARD_VALUE = 260;

	/**
	 * The '<em><b>OVERRIDE OPTION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OptionProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OPTION_PROVIDER
	 * @model literal="overrideOptionProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OPTION_PROVIDER_VALUE = 260;

	/**
	 * The '<em><b>IGNORE TYPE RESTRICTIONS FOR PRINTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the modern printer will not consider type restrictions for containment references that are defined in CS specifications. The classic printer does ignore these restrictions in any case. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING
	 * @model literal="ignoreTypeRestrictionsForPrinting"
	 * @generated
	 * @ordered
	 */
	public static final int IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING_VALUE = 261;

	/**
	 * The '<em><b>OVERRIDE INAME PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the INameProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_INAME_PROVIDER
	 * @model name="OVERRIDE_I_NAME_PROVIDER" literal="overrideINameProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_INAME_PROVIDER_VALUE = 262;

	/**
	 * The '<em><b>OVERRIDE DEFAULT NAME PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DefaultNameProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEFAULT_NAME_PROVIDER
	 * @model literal="overrideDefaultNameProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_NAME_PROVIDER_VALUE = 263;

	/**
	 * The '<em><b>OVERRIDE REFERENCE CACHE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ReferenceCache class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_REFERENCE_CACHE
	 * @model literal="overrideReferenceCache"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_REFERENCE_CACHE_VALUE = 264;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE LEXICAL SORTING ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageLexicalSortingAction class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_LEXICAL_SORTING_ACTION
	 * @model literal="overrideOutlinePageLexicalSortingAction"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_LEXICAL_SORTING_ACTION_VALUE = 265;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE COLLAPSE ALL ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageCollapseAllAction class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_COLLAPSE_ALL_ACTION
	 * @model literal="overrideOutlinePageCollapseAllAction"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_COLLAPSE_ALL_ACTION_VALUE = 266;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE GROUP TYPES ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageGroupTypesAction class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_GROUP_TYPES_ACTION
	 * @model literal="overrideOutlinePageGroupTypesAction"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_GROUP_TYPES_ACTION_VALUE = 267;

	/**
	 * The '<em><b>OVERRIDE ABSTRACT OUTLINE PAGE ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AbstractOutlinePageAction class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ABSTRACT_OUTLINE_PAGE_ACTION
	 * @model literal="overrideAbstractOutlinePageAction"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ABSTRACT_OUTLINE_PAGE_ACTION_VALUE = 268;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE TREE VIEWER COMPARATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageTreeViewerComparator class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_COMPARATOR
	 * @model literal="overrideOutlinePageTreeViewerComparator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_COMPARATOR_VALUE = 269;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE EXPAND ALL ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageExpandAllAction class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_EXPAND_ALL_ACTION
	 * @model literal="overrideOutlinePageExpandAllAction"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_EXPAND_ALL_ACTION_VALUE = 270;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE ACTION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageActionProvider class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER
	 * @model literal="overrideOutlinePageActionProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER_VALUE = 271;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE LINK WITH EDITOR ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageLinkWithEditorAction class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION
	 * @model literal="overrideOutlinePageLinkWithEditorAction"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION_VALUE = 272;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE AUTO EXPAND ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the OutlinePageAutoExpandAction class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_AUTO_EXPAND_ACTION
	 * @model literal="overrideOutlinePageAutoExpandAction"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_AUTO_EXPAND_ACTION_VALUE = 273;

	/**
	 * The '<em><b>OVERRIDE CONTAINED FEATURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ContainedFeature class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CONTAINED_FEATURE
	 * @model literal="overrideContainedFeature"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CONTAINED_FEATURE_VALUE = 274;

	/**
	 * The '<em><b>OVERRIDE EXPECTATION CONSTANTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ExpectationConstants class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_EXPECTATION_CONSTANTS
	 * @model literal="overrideExpectationConstants"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTATION_CONSTANTS_VALUE = 275;

	/**
	 * The '<em><b>OVERRIDE ECLIPSE PROXY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the EclipseProxy class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ECLIPSE_PROXY
	 * @model literal="overrideEclipeProxy"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ECLIPSE_PROXY_VALUE = 276;

	/**
	 * The '<em><b>OVERRIDE RUNTIME UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the RuntimeUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_RUNTIME_UTIL
	 * @model literal="overrideRuntimeUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RUNTIME_UTIL_VALUE = 277;

	/**
	 * The '<em><b>REMOVE ECLIPSE DEPENDENT CODE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>true</code>, the generated resource plug-in will not contain any dependencies to Eclipse. The default value for this option is <code>false</code>.
	 * <!-- end-model-doc -->
	 * @see #REMOVE_ECLIPSE_DEPENDENT_CODE
	 * @model literal="removeEclipseDependentCode"
	 * @generated
	 * @ordered
	 */
	public static final int REMOVE_ECLIPSE_DEPENDENT_CODE_VALUE = 278;

	/**
	 * The '<em><b>OVERRIDE IFUNCTION1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IFunction1 interface will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IFUNCTION1
	 * @model name="OVERRIDE_I_FUNCTION1" literal="overrideIFunction1"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IFUNCTION1_VALUE = 279;

	/**
	 * The '<em><b>OVERRIDE DEV NULL LOCATION MAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the DevNullLocationMap class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_DEV_NULL_LOCATION_MAP
	 * @model literal="overrideDevNullLocationMap"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEV_NULL_LOCATION_MAP_VALUE = 280;

	/**
	 * The '<em><b>OVERRIDE IGNORED WORDS FILTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IgnoredWordsFilter class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IGNORED_WORDS_FILTER
	 * @model literal="overrideIgnoredWordsFilter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IGNORED_WORDS_FILTER_VALUE = 281;

	/**
	 * The '<em><b>OVERRIDE TASK ITEM DETECTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TaskItemDetector class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TASK_ITEM_DETECTOR
	 * @model literal="overrideTaskItemDetector"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TASK_ITEM_DETECTOR_VALUE = 282;

	/**
	 * The '<em><b>OVERRIDE TASK ITEM BUILDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TaskItemBuilder class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TASK_ITEM_BUILDER
	 * @model literal="overrideTaskItemBuilder"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TASK_ITEM_BUILDER_VALUE = 283;

	/**
	 * The '<em><b>OVERRIDE SOURCE VIEWER CONFIGURATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the SourceViewerConfiguration class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_SOURCE_VIEWER_CONFIGURATION
	 * @model literal="overrideSourceViewerConfiguration"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SOURCE_VIEWER_CONFIGURATION_VALUE = 284;

	/**
	 * The '<em><b>OVERRIDE TASK ITEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the TaskItem class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_TASK_ITEM
	 * @model literal="overrideTaskItem"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TASK_ITEM_VALUE = 285;

	/**
	 * The '<em><b>OVERRIDE URI UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the URIUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_URI_UTIL
	 * @model literal="overrideURIUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_URI_UTIL_VALUE = 286;

	/**
	 * The '<em><b>OVERRIDE ANTLR TEXT TOKEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ANTLRTextToken class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_ANTLR_TEXT_TOKEN
	 * @model literal="overrideAntlrTextToken"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ANTLR_TEXT_TOKEN_VALUE = 287;

	/**
	 * The '<em><b>OVERRIDE IDELEGATING REFERENCE RESOLVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the IDelegatingReferenceResolver interface will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_IDELEGATING_REFERENCE_RESOLVER
	 * @model name="OVERRIDE_I_DELEGATING_REFERENCE_RESOLVER" literal="overrideIDelegatingReferenceResolver"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IDELEGATING_REFERENCE_RESOLVER_VALUE = 288;

	/**
	 * The '<em><b>ADDITIONAL IMPORTED PACKAGES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of comma separated packages, which will be added as imported packages to the manifest of the generated resource plug-in. The default value for this option is an empty list.
	 * <!-- end-model-doc -->
	 * @see #ADDITIONAL_IMPORTED_PACKAGES
	 * @model literal="additionalImportedPackages"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_IMPORTED_PACKAGES_VALUE = 289;

	/**
	 * The '<em><b>ADDITIONAL UI IMPORTED PACKAGES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of comma separated packages, which will be added as imported packages to the manifest of the generated resource UI plug-in. The default value for this option is an empty list.
	 * <!-- end-model-doc -->
	 * @see #ADDITIONAL_UI_IMPORTED_PACKAGES
	 * @model literal="additionalUIImportedPackages"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_UI_IMPORTED_PACKAGES_VALUE = 290;

	/**
	 * The '<em><b>ADDITIONAL LIBRARIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of comma separated libraries, which will be added to the manifest file, the .classpath file and the build.properties file of the generated resource plug-in. The default value for this option is an empty list.
	 * <!-- end-model-doc -->
	 * @see #ADDITIONAL_LIBRARIES
	 * @model literal="additionalLibraries"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_LIBRARIES_VALUE = 291;

	/**
	 * The '<em><b>OVERRIDE CONTAINMENT TRACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the ContainmentTrace class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_CONTAINMENT_TRACE
	 * @model literal="overrideContainmentTrace"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CONTAINMENT_TRACE_VALUE = 292;

	/**
	 * The '<em><b>EDITOR NAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The default editor name can be changed with this option. Default name is 'EMFText <yourSyntaxExtension> Editor'
	 * <!-- end-model-doc -->
	 * @see #EDITOR_NAME
	 * @model literal="editorName"
	 * @generated
	 * @ordered
	 */
	public static final int EDITOR_NAME_VALUE = 293;

	/**
	 * The '<em><b>OVERRIDE LAYOUT UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the LayoutUtil class will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_LAYOUT_UTIL
	 * @model literal="overrideLayoutUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAYOUT_UTIL_VALUE = 294;

	/**
	 * The '<em><b>OVERRIDE UI ANTLR TOKEN HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set to <code>false</code>, the AntlrTokenHelper class in the UI plug-in will not be overridden. The default value for this option is <code>true</code>.
	 * <!-- end-model-doc -->
	 * @see #OVERRIDE_UI_ANTLR_TOKEN_HELPER
	 * @model literal="overrideUIAntlrTokenHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_ANTLR_TOKEN_HELPER_VALUE = 295;

	/**
	 * An array of all the '<em><b>Option Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OptionTypes[] VALUES_ARRAY =
		new OptionTypes[] {
			GENERATE_TEST_ACTION,
			GENERATE_CODE_FROM_GENERATOR_MODEL,
			OVERRIDE_PLUGIN_XML,
			OVERRIDE_MANIFEST,
			OVERRIDE_PARSER,
			OVERRIDE_TOKEN_RESOLVERS,
			OVERRIDE_REFERENCE_RESOLVERS,
			OVERRIDE_REFERENCE_RESOLVER_SWITCH,
			OVERRIDE_TOKEN_RESOLVER_FACTORY,
			OVERRIDE_PRINTER,
			ANTLR_BACKTRACKING,
			ANTLR_MEMOIZE,
			AUTOFIX_SIMPLE_LEFTRECURSION,
			FORCE_EOF,
			DEFAULT_TOKEN_NAME,
			USE_PREDEFINED_TOKENS,
			TOKENSPACE,
			RELOAD_GENERATOR_MODEL,
			OVERRIDE_DOT_CLASSPATH,
			OVERRIDE_DOT_PROJECT,
			OVERRIDE_TEXT_RESOURCE,
			OVERRIDE_RESOURCE_FACTORY,
			OVERRIDE_NEW_FILE_WIZARD,
			PARSER_GENERATOR,
			SOURCE_FOLDER,
			BASE_PACKAGE,
			RESOURCE_PLUGIN_ID,
			OVERRIDE_BUILD_PROPERTIES,
			OVERRIDE_META_INFORMATION,
			OVERRIDE_DEFAULT_RESOLVER_DELEGATE,
			OVERRIDE_PROBLEM_CLASS,
			OVERRIDE_SCANNER,
			OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT,
			OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY,
			OVERRIDE_DELEGATING_RESOLVE_RESULT,
			OVERRIDE_DUMMY_EOBJECT,
			OVERRIDE_ELEMENT_MAPPING,
			OVERRIDE_FUZZY_RESOLVE_RESULT,
			OVERRIDE_DEFAULT_TOKEN_RESOLVER,
			OVERRIDE_LOCATION_MAP,
			OVERRIDE_REFERENCE_RESOLVE_RESULT,
			OVERRIDE_TOKEN_RESOLVE_RESULT,
			OVERRIDE_URI_MAPPING,
			OVERRIDE_HOVER_TEXT_PROVIDER,
			OVERRIDE_PARSE_RESULT,
			OVERRIDE_ANTLR_TOKEN_HELPER,
			OVERRIDE_BRACKET_SET,
			OVERRIDE_BROWSER_INFORMATION_CONTROL,
			OVERRIDE_CODE_FOLDING_MANAGER,
			OVERRIDE_COLOR_MANAGER,
			OVERRIDE_COMPLETION_PROCESSOR,
			OVERRIDE_PARSING_STRATEGY,
			OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT,
			OVERRIDE_EDITOR_CONFIGURATION,
			OVERRIDE_EDITOR,
			OVERRIDE_EOBJECT_SELECTION,
			OVERRIDE_HIGHLIGHTING,
			OVERRIDE_HTML_PRINTER,
			OVERRIDE_HYPERLINK,
			OVERRIDE_HYPERLINK_DETECTOR,
			OVERRIDE_MARKER_HELPER,
			OVERRIDE_OCCURRENCE,
			OVERRIDE_OUTLINE_PAGE,
			OVERRIDE_OUTLINE_PAGE_TREE_VIEWER,
			OVERRIDE_PLUGIN_ACTIVATOR,
			OVERRIDE_POSITION_CATEGORY,
			OVERRIDE_POSITION_HELPER,
			OVERRIDE_PROPERTY_SHEET_PAGE,
			OVERRIDE_TEXT_HOVER,
			OVERRIDE_TOKEN_SCANNER,
			OVERRIDE_BRACKET_PREFERENCE_PAGE,
			OVERRIDE_PREFERENCE_CONSTANTS,
			OVERRIDE_OCCURRENCE_PREFERENCE_PAGE,
			OVERRIDE_PIXEL_CONVERTER,
			OVERRIDE_PREFERENCE_INITIALIZER,
			OVERRIDE_SYNTAX_COLORING_HELPER,
			OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE,
			OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER,
			OVERRIDE_INPUT_STREAM_PROCESSOR,
			OVERRIDE_IOPTION_PROVIDER,
			OVERRIDE_IOPTIONS,
			OVERRIDE_IRESOURCE_POST_PROCESSOR,
			OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER,
			OVERRIDE_IBRACKET_PAIR,
			OVERRIDE_ICOMMAND,
			OVERRIDE_ICONFIGURABLE,
			OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT,
			OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY,
			OVERRIDE_IELEMENT_MAPPING,
			OVERRIDE_IEXPECTED_ELEMENT,
			OVERRIDE_IHOVER_TEXT_PROVIDER,
			OVERRIDE_ILOCATION_MAP,
			OVERRIDE_IPARSE_RESULT,
			OVERRIDE_IPROBLEM,
			OVERRIDE_IREFERENCE_MAPPING,
			OVERRIDE_IREFERENCE_RESOLVER,
			OVERRIDE_IREFERENCE_RESOLVE_RESULT,
			OVERRIDE_IREFERENCE_RESOLVER_SWITCH,
			OVERRIDE_ITEXT_DIAGNOSTIC,
			OVERRIDE_ITEXT_PARSER,
			OVERRIDE_ITEXT_PRINTER,
			OVERRIDE_ITEXT_RESOURCE,
			OVERRIDE_IMETA_INFORMATION,
			OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART,
			OVERRIDE_ITEXT_SCANNER,
			OVERRIDE_ITEXT_TOKEN,
			OVERRIDE_ITOKEN_RESOLVER,
			OVERRIDE_ITOKEN_RESOLVE_RESULT,
			OVERRIDE_ITOKEN_RESOLVER_FACTORY,
			OVERRIDE_ITOKEN_STYLE,
			OVERRIDE_IURI_MAPPING,
			OVERRIDE_EPROBLEM_TYPE,
			OVERRIDE_CODE_COMPLETION_HELPER,
			OVERRIDE_EXPECTED_CS_STRING,
			OVERRIDE_EXPECTED_STRUCTURAL_FEATURE,
			OVERRIDE_CAST_UTIL,
			OVERRIDE_COPIED_ELIST,
			OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST,
			OVERRIDE_ECLASS_UTIL,
			OVERRIDE_EOBJECT_UTIL,
			OVERRIDE_LIST_UTIL,
			OVERRIDE_MAP_UTIL,
			OVERRIDE_MINIMAL_MODEL_HELPER,
			OVERRIDE_RESOURCE_UTIL,
			OVERRIDE_STREAM_UTIL,
			OVERRIDE_STRING_UTIL,
			OVERRIDE_TEXT_RESOURCE_UTIL,
			OVERRIDE_UNICODE_CONVERTER,
			OVERRIDE_ABSTRACT_EXPECTED_ELEMENT,
			OVERRIDE_NEW_FILE_WIZARD_PAGE,
			OVERRIDE_IBACKGROUND_PARSING_LISTENER,
			OVERRIDE_TERMINATE_PARSING_EXCEPTION,
			OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION,
			OVERRIDE_TEXT_TOKEN,
			SOURCE_GEN_FOLDER,
			OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA,
			OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA,
			OVERRIDE_RESOURCE_FACTORY_DELEGATOR,
			BASE_RESOURCE_PLUGIN,
			OVERRIDE_PREFERENCE_PAGE,
			ANTLR_PLUGIN_ID,
			OVERRIDE_ANTLR_PLUGIN,
			OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER,
			OVERRIDE_FOLDING_INFORMATION_PROVIDER,
			OVERRIDE_BRACKET_INFORMATION_PROVIDER,
			OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER,
			SAVE_CHANGED_RESOURCES_ONLY,
			OVERRIDE_NEW_FILE_CONTENT_PROVIDER,
			LICENCE_HEADER,
			OVERRIDE_EXPECTED_TERMINAL,
			OVERRIDE_COMPLETION_PROPOSAL,
			OVERRIDE_BUILDER,
			OVERRIDE_BUILDER_ADAPTER,
			OVERRIDE_IBUILDER,
			OVERRIDE_NATURE,
			ADDITIONAL_DEPENDENCIES,
			DISABLE_BUILDER,
			ADDITIONAL_EXPORTS,
			OVERRIDE_PAIR,
			OVERRIDE_ABSTRACT_INTERPRETER,
			OVERRIDE_GRAMMAR_INFORMATION_PROVIDER,
			OVERRIDE_ATTRIBUTE_VALUE_PROVIDER,
			OVERRIDE_FOLLOW_SET_PROVIDER,
			OVERRIDE_SYNTAX_ELEMENT,
			OVERRIDE_KEYWORD,
			OVERRIDE_PLACEHOLDER,
			OVERRIDE_CARDINALITY,
			OVERRIDE_PRINTER2,
			OVERRIDE_CHOICE,
			OVERRIDE_COMPOUND,
			OVERRIDE_CONTAINMENT,
			OVERRIDE_LINE_BREAK,
			OVERRIDE_SEQUENCE,
			OVERRIDE_WHITE_SPACE,
			OVERRIDE_SYNTAX_ELEMENT_DECORATOR,
			OVERRIDE_IREFERENCE_CACHE,
			OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER,
			OVERRIDE_FORMATTING_ELEMENT,
			OVERRIDE_TERMINAL,
			OVERRIDE_LAYOUT_INFORMATION_ADAPTER,
			OVERRIDE_LAYOUT_INFORMATION,
			USE_CLASSIC_PRINTER,
			DISABLE_EVALIDATORS,
			DISABLE_EMF_VALIDATION_CONSTRAINTS,
			OVERRIDE_UI_META_INFORMATION,
			RESOURCE_UI_PLUGIN_ID,
			OVERRIDE_UI_PLUGIN_ACTIVATOR,
			UI_BASE_PACKAGE,
			ADDITIONAL_UI_DEPENDENCIES,
			ADDITIONAL_UI_EXPORTS,
			OVERRIDE_UI_MANIFEST,
			OVERRIDE_UI_BUILD_PROPERTIES,
			OVERRIDE_UI_DOT_CLASSPATH,
			OVERRIDE_UI_DOT_PROJECT,
			UI_SOURCE_FOLDER,
			UI_SOURCE_GEN_FOLDER,
			GENERATE_UI_PLUGIN,
			OVERRIDE_IBRACKET_HANDLER,
			OVERRIDE_UI_PLUGIN_XML,
			OVERRIDE_PROPOSAL_POST_PROCESSOR,
			DISABLE_TOKEN_SORTING,
			OVERRIDE_IQUICK_FIX,
			OVERRIDE_QUICK_FIX,
			OVERRIDE_ANNOTATION_MODEL,
			OVERRIDE_ANNOTATION_MODEL_FACTORY,
			OVERRIDE_MARKER_ANNOTATION,
			OVERRIDE_MARKER_RESOLUTION_GENERATOR,
			OVERRIDE_QUICK_ASSIST_ASSISTANT,
			OVERRIDE_QUICK_ASSIST_PROCESSOR,
			OVERRIDE_IMAGE_PROVIDER,
			OVERRIDE_TOKEN_STYLE,
			OVERRIDE_DYNAMIC_TOKEN_STYLER,
			RESOLVE_PROXY_ELEMENTS_AFTER_PARSING,
			OVERRIDE_EXPECTED_BOOLEAN_TERMINAL,
			OVERRIDE_BOOLEAN_TERMINAL,
			OVERRIDE_ENUMERATION_TERMINAL,
			OVERRIDE_EXPECTED_ENUMERATION_TERMINAL,
			OVERRIDE_CHANGE_REFERENCE_QUICK_FIX,
			OVERRIDE_EPROBLEM_SEVERITY,
			OVERRIDE_RESOURCE_POST_PROCESSOR,
			OVERRIDE_IRESOURCE_PROVIDER,
			OVERRIDE_IBRACKET_HANDLER_PROVIDER,
			OVERRIDE_IANNOTATION_MODEL_PROVIDER,
			OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE,
			OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP,
			OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB,
			OVERRIDE_LAUNCH_SHORTCUT,
			OVERRIDE_PROPERTY_TESTER,
			DISABLE_LAUNCH_SUPPORT,
			OVERRIDE_RULE,
			OVERRIDE_ABSTRACT_DEBUGGABLE,
			OVERRIDE_EDEBUG_MESSAGE_TYPES,
			OVERRIDE_IDEBUG_EVENT_LISTENER,
			OVERRIDE_IINTERPRETER_LISTENER,
			OVERRIDE_DEBUG_COMMUNICATION_HELPER,
			OVERRIDE_DEBUG_ELEMENT,
			OVERRIDE_DEBUGGABLE_INTERPRETER,
			OVERRIDE_DEBUGGER_LISTENER,
			OVERRIDE_DEBUG_MESSAGE,
			OVERRIDE_DEBUG_PROCESS,
			OVERRIDE_DEBUG_PROXY,
			OVERRIDE_DEBUG_TARGET,
			OVERRIDE_DEBUG_THREAD,
			OVERRIDE_DEBUG_VALUE,
			OVERRIDE_DEBUG_VARIABLE,
			OVERRIDE_LINEBREAK_POINT,
			OVERRIDE_SOURCE_LOCATOR,
			OVERRIDE_SOURCE_LOOKUP_PARTICIPANT,
			OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE,
			OVERRIDE_STACK_FRAME,
			DISABLE_DEBUG_SUPPORT,
			OVERRIDE_DEBUG_MODEL_PRESENTATION,
			OVERRIDE_LINE_BREAKPOINT_ADAPTER,
			OVERRIDE_ADAPTER_FACTORY,
			OVERRIDE_LAUNCH_CONFIGURATION_HELPER,
			OVERRIDE_NEW_PROJECT_WIZARD,
			DISABLE_NEW_PROJECT_WIZARD,
			OVERRIDE_OPTION_PROVIDER,
			IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING,
			OVERRIDE_INAME_PROVIDER,
			OVERRIDE_DEFAULT_NAME_PROVIDER,
			OVERRIDE_REFERENCE_CACHE,
			OVERRIDE_OUTLINE_PAGE_LEXICAL_SORTING_ACTION,
			OVERRIDE_OUTLINE_PAGE_COLLAPSE_ALL_ACTION,
			OVERRIDE_OUTLINE_PAGE_GROUP_TYPES_ACTION,
			OVERRIDE_ABSTRACT_OUTLINE_PAGE_ACTION,
			OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_COMPARATOR,
			OVERRIDE_OUTLINE_PAGE_EXPAND_ALL_ACTION,
			OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER,
			OVERRIDE_OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION,
			OVERRIDE_OUTLINE_PAGE_AUTO_EXPAND_ACTION,
			OVERRIDE_CONTAINED_FEATURE,
			OVERRIDE_EXPECTATION_CONSTANTS,
			OVERRIDE_ECLIPSE_PROXY,
			OVERRIDE_RUNTIME_UTIL,
			REMOVE_ECLIPSE_DEPENDENT_CODE,
			OVERRIDE_IFUNCTION1,
			OVERRIDE_DEV_NULL_LOCATION_MAP,
			OVERRIDE_IGNORED_WORDS_FILTER,
			OVERRIDE_TASK_ITEM_DETECTOR,
			OVERRIDE_TASK_ITEM_BUILDER,
			OVERRIDE_SOURCE_VIEWER_CONFIGURATION,
			OVERRIDE_TASK_ITEM,
			OVERRIDE_URI_UTIL,
			OVERRIDE_ANTLR_TEXT_TOKEN,
			OVERRIDE_IDELEGATING_REFERENCE_RESOLVER,
			ADDITIONAL_IMPORTED_PACKAGES,
			ADDITIONAL_UI_IMPORTED_PACKAGES,
			ADDITIONAL_LIBRARIES,
			OVERRIDE_CONTAINMENT_TRACE,
			EDITOR_NAME,
			OVERRIDE_LAYOUT_UTIL,
			OVERRIDE_UI_ANTLR_TOKEN_HELPER,
		};

	/**
	 * A public read-only list of all the '<em><b>Option Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<OptionTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Option Types</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OptionTypes get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OptionTypes result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Option Types</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OptionTypes getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OptionTypes result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Option Types</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OptionTypes get(int value) {
		switch (value) {
			case GENERATE_TEST_ACTION_VALUE: return GENERATE_TEST_ACTION;
			case GENERATE_CODE_FROM_GENERATOR_MODEL_VALUE: return GENERATE_CODE_FROM_GENERATOR_MODEL;
			case OVERRIDE_PLUGIN_XML_VALUE: return OVERRIDE_PLUGIN_XML;
			case OVERRIDE_MANIFEST_VALUE: return OVERRIDE_MANIFEST;
			case OVERRIDE_PARSER_VALUE: return OVERRIDE_PARSER;
			case OVERRIDE_TOKEN_RESOLVERS_VALUE: return OVERRIDE_TOKEN_RESOLVERS;
			case OVERRIDE_REFERENCE_RESOLVERS_VALUE: return OVERRIDE_REFERENCE_RESOLVERS;
			case OVERRIDE_REFERENCE_RESOLVER_SWITCH_VALUE: return OVERRIDE_REFERENCE_RESOLVER_SWITCH;
			case OVERRIDE_TOKEN_RESOLVER_FACTORY_VALUE: return OVERRIDE_TOKEN_RESOLVER_FACTORY;
			case OVERRIDE_PRINTER_VALUE: return OVERRIDE_PRINTER;
			case ANTLR_BACKTRACKING_VALUE: return ANTLR_BACKTRACKING;
			case ANTLR_MEMOIZE_VALUE: return ANTLR_MEMOIZE;
			case AUTOFIX_SIMPLE_LEFTRECURSION_VALUE: return AUTOFIX_SIMPLE_LEFTRECURSION;
			case FORCE_EOF_VALUE: return FORCE_EOF;
			case DEFAULT_TOKEN_NAME_VALUE: return DEFAULT_TOKEN_NAME;
			case USE_PREDEFINED_TOKENS_VALUE: return USE_PREDEFINED_TOKENS;
			case TOKENSPACE_VALUE: return TOKENSPACE;
			case RELOAD_GENERATOR_MODEL_VALUE: return RELOAD_GENERATOR_MODEL;
			case OVERRIDE_DOT_CLASSPATH_VALUE: return OVERRIDE_DOT_CLASSPATH;
			case OVERRIDE_DOT_PROJECT_VALUE: return OVERRIDE_DOT_PROJECT;
			case OVERRIDE_TEXT_RESOURCE_VALUE: return OVERRIDE_TEXT_RESOURCE;
			case OVERRIDE_RESOURCE_FACTORY_VALUE: return OVERRIDE_RESOURCE_FACTORY;
			case OVERRIDE_NEW_FILE_WIZARD_VALUE: return OVERRIDE_NEW_FILE_WIZARD;
			case PARSER_GENERATOR_VALUE: return PARSER_GENERATOR;
			case SOURCE_FOLDER_VALUE: return SOURCE_FOLDER;
			case BASE_PACKAGE_VALUE: return BASE_PACKAGE;
			case RESOURCE_PLUGIN_ID_VALUE: return RESOURCE_PLUGIN_ID;
			case OVERRIDE_BUILD_PROPERTIES_VALUE: return OVERRIDE_BUILD_PROPERTIES;
			case OVERRIDE_META_INFORMATION_VALUE: return OVERRIDE_META_INFORMATION;
			case OVERRIDE_DEFAULT_RESOLVER_DELEGATE_VALUE: return OVERRIDE_DEFAULT_RESOLVER_DELEGATE;
			case OVERRIDE_PROBLEM_CLASS_VALUE: return OVERRIDE_PROBLEM_CLASS;
			case OVERRIDE_SCANNER_VALUE: return OVERRIDE_SCANNER;
			case OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_VALUE: return OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT;
			case OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE: return OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY;
			case OVERRIDE_DELEGATING_RESOLVE_RESULT_VALUE: return OVERRIDE_DELEGATING_RESOLVE_RESULT;
			case OVERRIDE_DUMMY_EOBJECT_VALUE: return OVERRIDE_DUMMY_EOBJECT;
			case OVERRIDE_ELEMENT_MAPPING_VALUE: return OVERRIDE_ELEMENT_MAPPING;
			case OVERRIDE_FUZZY_RESOLVE_RESULT_VALUE: return OVERRIDE_FUZZY_RESOLVE_RESULT;
			case OVERRIDE_DEFAULT_TOKEN_RESOLVER_VALUE: return OVERRIDE_DEFAULT_TOKEN_RESOLVER;
			case OVERRIDE_LOCATION_MAP_VALUE: return OVERRIDE_LOCATION_MAP;
			case OVERRIDE_REFERENCE_RESOLVE_RESULT_VALUE: return OVERRIDE_REFERENCE_RESOLVE_RESULT;
			case OVERRIDE_TOKEN_RESOLVE_RESULT_VALUE: return OVERRIDE_TOKEN_RESOLVE_RESULT;
			case OVERRIDE_URI_MAPPING_VALUE: return OVERRIDE_URI_MAPPING;
			case OVERRIDE_HOVER_TEXT_PROVIDER_VALUE: return OVERRIDE_HOVER_TEXT_PROVIDER;
			case OVERRIDE_PARSE_RESULT_VALUE: return OVERRIDE_PARSE_RESULT;
			case OVERRIDE_ANTLR_TOKEN_HELPER_VALUE: return OVERRIDE_ANTLR_TOKEN_HELPER;
			case OVERRIDE_BRACKET_SET_VALUE: return OVERRIDE_BRACKET_SET;
			case OVERRIDE_BROWSER_INFORMATION_CONTROL_VALUE: return OVERRIDE_BROWSER_INFORMATION_CONTROL;
			case OVERRIDE_CODE_FOLDING_MANAGER_VALUE: return OVERRIDE_CODE_FOLDING_MANAGER;
			case OVERRIDE_COLOR_MANAGER_VALUE: return OVERRIDE_COLOR_MANAGER;
			case OVERRIDE_COMPLETION_PROCESSOR_VALUE: return OVERRIDE_COMPLETION_PROCESSOR;
			case OVERRIDE_PARSING_STRATEGY_VALUE: return OVERRIDE_PARSING_STRATEGY;
			case OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT_VALUE: return OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT;
			case OVERRIDE_EDITOR_VALUE: return OVERRIDE_EDITOR;
			case OVERRIDE_EOBJECT_SELECTION_VALUE: return OVERRIDE_EOBJECT_SELECTION;
			case OVERRIDE_HIGHLIGHTING_VALUE: return OVERRIDE_HIGHLIGHTING;
			case OVERRIDE_HTML_PRINTER_VALUE: return OVERRIDE_HTML_PRINTER;
			case OVERRIDE_HYPERLINK_VALUE: return OVERRIDE_HYPERLINK;
			case OVERRIDE_HYPERLINK_DETECTOR_VALUE: return OVERRIDE_HYPERLINK_DETECTOR;
			case OVERRIDE_MARKER_HELPER_VALUE: return OVERRIDE_MARKER_HELPER;
			case OVERRIDE_OCCURRENCE_VALUE: return OVERRIDE_OCCURRENCE;
			case OVERRIDE_OUTLINE_PAGE_VALUE: return OVERRIDE_OUTLINE_PAGE;
			case OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_VALUE: return OVERRIDE_OUTLINE_PAGE_TREE_VIEWER;
			case OVERRIDE_PLUGIN_ACTIVATOR_VALUE: return OVERRIDE_PLUGIN_ACTIVATOR;
			case OVERRIDE_POSITION_CATEGORY_VALUE: return OVERRIDE_POSITION_CATEGORY;
			case OVERRIDE_POSITION_HELPER_VALUE: return OVERRIDE_POSITION_HELPER;
			case OVERRIDE_PROPERTY_SHEET_PAGE_VALUE: return OVERRIDE_PROPERTY_SHEET_PAGE;
			case OVERRIDE_TEXT_HOVER_VALUE: return OVERRIDE_TEXT_HOVER;
			case OVERRIDE_TOKEN_SCANNER_VALUE: return OVERRIDE_TOKEN_SCANNER;
			case OVERRIDE_BRACKET_PREFERENCE_PAGE_VALUE: return OVERRIDE_BRACKET_PREFERENCE_PAGE;
			case OVERRIDE_PREFERENCE_CONSTANTS_VALUE: return OVERRIDE_PREFERENCE_CONSTANTS;
			case OVERRIDE_OCCURRENCE_PREFERENCE_PAGE_VALUE: return OVERRIDE_OCCURRENCE_PREFERENCE_PAGE;
			case OVERRIDE_PIXEL_CONVERTER_VALUE: return OVERRIDE_PIXEL_CONVERTER;
			case OVERRIDE_PREFERENCE_INITIALIZER_VALUE: return OVERRIDE_PREFERENCE_INITIALIZER;
			case OVERRIDE_SYNTAX_COLORING_HELPER_VALUE: return OVERRIDE_SYNTAX_COLORING_HELPER;
			case OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE_VALUE: return OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE;
			case OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER_VALUE: return OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER;
			case OVERRIDE_INPUT_STREAM_PROCESSOR_VALUE: return OVERRIDE_INPUT_STREAM_PROCESSOR;
			case OVERRIDE_IOPTION_PROVIDER_VALUE: return OVERRIDE_IOPTION_PROVIDER;
			case OVERRIDE_IOPTIONS_VALUE: return OVERRIDE_IOPTIONS;
			case OVERRIDE_IRESOURCE_POST_PROCESSOR_VALUE: return OVERRIDE_IRESOURCE_POST_PROCESSOR;
			case OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER_VALUE: return OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER;
			case OVERRIDE_IBRACKET_PAIR_VALUE: return OVERRIDE_IBRACKET_PAIR;
			case OVERRIDE_ICOMMAND_VALUE: return OVERRIDE_ICOMMAND;
			case OVERRIDE_ICONFIGURABLE_VALUE: return OVERRIDE_ICONFIGURABLE;
			case OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_VALUE: return OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT;
			case OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE: return OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY;
			case OVERRIDE_IELEMENT_MAPPING_VALUE: return OVERRIDE_IELEMENT_MAPPING;
			case OVERRIDE_IEXPECTED_ELEMENT_VALUE: return OVERRIDE_IEXPECTED_ELEMENT;
			case OVERRIDE_IHOVER_TEXT_PROVIDER_VALUE: return OVERRIDE_IHOVER_TEXT_PROVIDER;
			case OVERRIDE_ILOCATION_MAP_VALUE: return OVERRIDE_ILOCATION_MAP;
			case OVERRIDE_IPARSE_RESULT_VALUE: return OVERRIDE_IPARSE_RESULT;
			case OVERRIDE_IPROBLEM_VALUE: return OVERRIDE_IPROBLEM;
			case OVERRIDE_IREFERENCE_MAPPING_VALUE: return OVERRIDE_IREFERENCE_MAPPING;
			case OVERRIDE_IREFERENCE_RESOLVER_VALUE: return OVERRIDE_IREFERENCE_RESOLVER;
			case OVERRIDE_IREFERENCE_RESOLVE_RESULT_VALUE: return OVERRIDE_IREFERENCE_RESOLVE_RESULT;
			case OVERRIDE_IREFERENCE_RESOLVER_SWITCH_VALUE: return OVERRIDE_IREFERENCE_RESOLVER_SWITCH;
			case OVERRIDE_ITEXT_DIAGNOSTIC_VALUE: return OVERRIDE_ITEXT_DIAGNOSTIC;
			case OVERRIDE_ITEXT_PARSER_VALUE: return OVERRIDE_ITEXT_PARSER;
			case OVERRIDE_ITEXT_PRINTER_VALUE: return OVERRIDE_ITEXT_PRINTER;
			case OVERRIDE_ITEXT_RESOURCE_VALUE: return OVERRIDE_ITEXT_RESOURCE;
			case OVERRIDE_IMETA_INFORMATION_VALUE: return OVERRIDE_IMETA_INFORMATION;
			case OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART_VALUE: return OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART;
			case OVERRIDE_ITEXT_SCANNER_VALUE: return OVERRIDE_ITEXT_SCANNER;
			case OVERRIDE_ITEXT_TOKEN_VALUE: return OVERRIDE_ITEXT_TOKEN;
			case OVERRIDE_ITOKEN_RESOLVER_VALUE: return OVERRIDE_ITOKEN_RESOLVER;
			case OVERRIDE_ITOKEN_RESOLVE_RESULT_VALUE: return OVERRIDE_ITOKEN_RESOLVE_RESULT;
			case OVERRIDE_ITOKEN_RESOLVER_FACTORY_VALUE: return OVERRIDE_ITOKEN_RESOLVER_FACTORY;
			case OVERRIDE_ITOKEN_STYLE_VALUE: return OVERRIDE_ITOKEN_STYLE;
			case OVERRIDE_IURI_MAPPING_VALUE: return OVERRIDE_IURI_MAPPING;
			case OVERRIDE_EPROBLEM_TYPE_VALUE: return OVERRIDE_EPROBLEM_TYPE;
			case OVERRIDE_CODE_COMPLETION_HELPER_VALUE: return OVERRIDE_CODE_COMPLETION_HELPER;
			case OVERRIDE_EXPECTED_CS_STRING_VALUE: return OVERRIDE_EXPECTED_CS_STRING;
			case OVERRIDE_EXPECTED_STRUCTURAL_FEATURE_VALUE: return OVERRIDE_EXPECTED_STRUCTURAL_FEATURE;
			case OVERRIDE_CAST_UTIL_VALUE: return OVERRIDE_CAST_UTIL;
			case OVERRIDE_COPIED_ELIST_VALUE: return OVERRIDE_COPIED_ELIST;
			case OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST_VALUE: return OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST;
			case OVERRIDE_ECLASS_UTIL_VALUE: return OVERRIDE_ECLASS_UTIL;
			case OVERRIDE_EOBJECT_UTIL_VALUE: return OVERRIDE_EOBJECT_UTIL;
			case OVERRIDE_LIST_UTIL_VALUE: return OVERRIDE_LIST_UTIL;
			case OVERRIDE_MAP_UTIL_VALUE: return OVERRIDE_MAP_UTIL;
			case OVERRIDE_MINIMAL_MODEL_HELPER_VALUE: return OVERRIDE_MINIMAL_MODEL_HELPER;
			case OVERRIDE_RESOURCE_UTIL_VALUE: return OVERRIDE_RESOURCE_UTIL;
			case OVERRIDE_STREAM_UTIL_VALUE: return OVERRIDE_STREAM_UTIL;
			case OVERRIDE_STRING_UTIL_VALUE: return OVERRIDE_STRING_UTIL;
			case OVERRIDE_TEXT_RESOURCE_UTIL_VALUE: return OVERRIDE_TEXT_RESOURCE_UTIL;
			case OVERRIDE_UNICODE_CONVERTER_VALUE: return OVERRIDE_UNICODE_CONVERTER;
			case OVERRIDE_ABSTRACT_EXPECTED_ELEMENT_VALUE: return OVERRIDE_ABSTRACT_EXPECTED_ELEMENT;
			case OVERRIDE_NEW_FILE_WIZARD_PAGE_VALUE: return OVERRIDE_NEW_FILE_WIZARD_PAGE;
			case OVERRIDE_IBACKGROUND_PARSING_LISTENER_VALUE: return OVERRIDE_IBACKGROUND_PARSING_LISTENER;
			case OVERRIDE_TERMINATE_PARSING_EXCEPTION_VALUE: return OVERRIDE_TERMINATE_PARSING_EXCEPTION;
			case OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION_VALUE: return OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION;
			case OVERRIDE_TEXT_TOKEN_VALUE: return OVERRIDE_TEXT_TOKEN;
			case SOURCE_GEN_FOLDER_VALUE: return SOURCE_GEN_FOLDER;
			case OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA_VALUE: return OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA;
			case OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA_VALUE: return OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA;
			case OVERRIDE_RESOURCE_FACTORY_DELEGATOR_VALUE: return OVERRIDE_RESOURCE_FACTORY_DELEGATOR;
			case BASE_RESOURCE_PLUGIN_VALUE: return BASE_RESOURCE_PLUGIN;
			case OVERRIDE_PREFERENCE_PAGE_VALUE: return OVERRIDE_PREFERENCE_PAGE;
			case ANTLR_PLUGIN_ID_VALUE: return ANTLR_PLUGIN_ID;
			case OVERRIDE_ANTLR_PLUGIN_VALUE: return OVERRIDE_ANTLR_PLUGIN;
			case OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER_VALUE: return OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER;
			case OVERRIDE_FOLDING_INFORMATION_PROVIDER_VALUE: return OVERRIDE_FOLDING_INFORMATION_PROVIDER;
			case OVERRIDE_BRACKET_INFORMATION_PROVIDER_VALUE: return OVERRIDE_BRACKET_INFORMATION_PROVIDER;
			case OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER_VALUE: return OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER;
			case SAVE_CHANGED_RESOURCES_ONLY_VALUE: return SAVE_CHANGED_RESOURCES_ONLY;
			case OVERRIDE_NEW_FILE_CONTENT_PROVIDER_VALUE: return OVERRIDE_NEW_FILE_CONTENT_PROVIDER;
			case LICENCE_HEADER_VALUE: return LICENCE_HEADER;
			case OVERRIDE_EXPECTED_TERMINAL_VALUE: return OVERRIDE_EXPECTED_TERMINAL;
			case OVERRIDE_COMPLETION_PROPOSAL_VALUE: return OVERRIDE_COMPLETION_PROPOSAL;
			case OVERRIDE_BUILDER_VALUE: return OVERRIDE_BUILDER;
			case OVERRIDE_BUILDER_ADAPTER_VALUE: return OVERRIDE_BUILDER_ADAPTER;
			case OVERRIDE_IBUILDER_VALUE: return OVERRIDE_IBUILDER;
			case OVERRIDE_NATURE_VALUE: return OVERRIDE_NATURE;
			case ADDITIONAL_DEPENDENCIES_VALUE: return ADDITIONAL_DEPENDENCIES;
			case DISABLE_BUILDER_VALUE: return DISABLE_BUILDER;
			case ADDITIONAL_EXPORTS_VALUE: return ADDITIONAL_EXPORTS;
			case OVERRIDE_PAIR_VALUE: return OVERRIDE_PAIR;
			case OVERRIDE_ABSTRACT_INTERPRETER_VALUE: return OVERRIDE_ABSTRACT_INTERPRETER;
			case OVERRIDE_GRAMMAR_INFORMATION_PROVIDER_VALUE: return OVERRIDE_GRAMMAR_INFORMATION_PROVIDER;
			case OVERRIDE_ATTRIBUTE_VALUE_PROVIDER_VALUE: return OVERRIDE_ATTRIBUTE_VALUE_PROVIDER;
			case OVERRIDE_FOLLOW_SET_PROVIDER_VALUE: return OVERRIDE_FOLLOW_SET_PROVIDER;
			case OVERRIDE_SYNTAX_ELEMENT_VALUE: return OVERRIDE_SYNTAX_ELEMENT;
			case OVERRIDE_KEYWORD_VALUE: return OVERRIDE_KEYWORD;
			case OVERRIDE_PLACEHOLDER_VALUE: return OVERRIDE_PLACEHOLDER;
			case OVERRIDE_CARDINALITY_VALUE: return OVERRIDE_CARDINALITY;
			case OVERRIDE_PRINTER2_VALUE: return OVERRIDE_PRINTER2;
			case OVERRIDE_CHOICE_VALUE: return OVERRIDE_CHOICE;
			case OVERRIDE_COMPOUND_VALUE: return OVERRIDE_COMPOUND;
			case OVERRIDE_CONTAINMENT_VALUE: return OVERRIDE_CONTAINMENT;
			case OVERRIDE_LINE_BREAK_VALUE: return OVERRIDE_LINE_BREAK;
			case OVERRIDE_SEQUENCE_VALUE: return OVERRIDE_SEQUENCE;
			case OVERRIDE_WHITE_SPACE_VALUE: return OVERRIDE_WHITE_SPACE;
			case OVERRIDE_SYNTAX_ELEMENT_DECORATOR_VALUE: return OVERRIDE_SYNTAX_ELEMENT_DECORATOR;
			case OVERRIDE_IREFERENCE_CACHE_VALUE: return OVERRIDE_IREFERENCE_CACHE;
			case OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER_VALUE: return OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER;
			case OVERRIDE_FORMATTING_ELEMENT_VALUE: return OVERRIDE_FORMATTING_ELEMENT;
			case OVERRIDE_TERMINAL_VALUE: return OVERRIDE_TERMINAL;
			case OVERRIDE_LAYOUT_INFORMATION_ADAPTER_VALUE: return OVERRIDE_LAYOUT_INFORMATION_ADAPTER;
			case OVERRIDE_LAYOUT_INFORMATION_VALUE: return OVERRIDE_LAYOUT_INFORMATION;
			case USE_CLASSIC_PRINTER_VALUE: return USE_CLASSIC_PRINTER;
			case DISABLE_EVALIDATORS_VALUE: return DISABLE_EVALIDATORS;
			case DISABLE_EMF_VALIDATION_CONSTRAINTS_VALUE: return DISABLE_EMF_VALIDATION_CONSTRAINTS;
			case OVERRIDE_UI_META_INFORMATION_VALUE: return OVERRIDE_UI_META_INFORMATION;
			case RESOURCE_UI_PLUGIN_ID_VALUE: return RESOURCE_UI_PLUGIN_ID;
			case OVERRIDE_UI_PLUGIN_ACTIVATOR_VALUE: return OVERRIDE_UI_PLUGIN_ACTIVATOR;
			case UI_BASE_PACKAGE_VALUE: return UI_BASE_PACKAGE;
			case ADDITIONAL_UI_DEPENDENCIES_VALUE: return ADDITIONAL_UI_DEPENDENCIES;
			case ADDITIONAL_UI_EXPORTS_VALUE: return ADDITIONAL_UI_EXPORTS;
			case OVERRIDE_UI_MANIFEST_VALUE: return OVERRIDE_UI_MANIFEST;
			case OVERRIDE_UI_BUILD_PROPERTIES_VALUE: return OVERRIDE_UI_BUILD_PROPERTIES;
			case OVERRIDE_UI_DOT_CLASSPATH_VALUE: return OVERRIDE_UI_DOT_CLASSPATH;
			case OVERRIDE_UI_DOT_PROJECT_VALUE: return OVERRIDE_UI_DOT_PROJECT;
			case UI_SOURCE_FOLDER_VALUE: return UI_SOURCE_FOLDER;
			case UI_SOURCE_GEN_FOLDER_VALUE: return UI_SOURCE_GEN_FOLDER;
			case GENERATE_UI_PLUGIN_VALUE: return GENERATE_UI_PLUGIN;
			case OVERRIDE_IBRACKET_HANDLER_VALUE: return OVERRIDE_IBRACKET_HANDLER;
			case OVERRIDE_UI_PLUGIN_XML_VALUE: return OVERRIDE_UI_PLUGIN_XML;
			case OVERRIDE_PROPOSAL_POST_PROCESSOR_VALUE: return OVERRIDE_PROPOSAL_POST_PROCESSOR;
			case DISABLE_TOKEN_SORTING_VALUE: return DISABLE_TOKEN_SORTING;
			case OVERRIDE_IQUICK_FIX_VALUE: return OVERRIDE_IQUICK_FIX;
			case OVERRIDE_QUICK_FIX_VALUE: return OVERRIDE_QUICK_FIX;
			case OVERRIDE_ANNOTATION_MODEL_VALUE: return OVERRIDE_ANNOTATION_MODEL;
			case OVERRIDE_ANNOTATION_MODEL_FACTORY_VALUE: return OVERRIDE_ANNOTATION_MODEL_FACTORY;
			case OVERRIDE_MARKER_ANNOTATION_VALUE: return OVERRIDE_MARKER_ANNOTATION;
			case OVERRIDE_MARKER_RESOLUTION_GENERATOR_VALUE: return OVERRIDE_MARKER_RESOLUTION_GENERATOR;
			case OVERRIDE_QUICK_ASSIST_ASSISTANT_VALUE: return OVERRIDE_QUICK_ASSIST_ASSISTANT;
			case OVERRIDE_QUICK_ASSIST_PROCESSOR_VALUE: return OVERRIDE_QUICK_ASSIST_PROCESSOR;
			case OVERRIDE_IMAGE_PROVIDER_VALUE: return OVERRIDE_IMAGE_PROVIDER;
			case OVERRIDE_TOKEN_STYLE_VALUE: return OVERRIDE_TOKEN_STYLE;
			case OVERRIDE_DYNAMIC_TOKEN_STYLER_VALUE: return OVERRIDE_DYNAMIC_TOKEN_STYLER;
			case RESOLVE_PROXY_ELEMENTS_AFTER_PARSING_VALUE: return RESOLVE_PROXY_ELEMENTS_AFTER_PARSING;
			case OVERRIDE_EXPECTED_BOOLEAN_TERMINAL_VALUE: return OVERRIDE_EXPECTED_BOOLEAN_TERMINAL;
			case OVERRIDE_BOOLEAN_TERMINAL_VALUE: return OVERRIDE_BOOLEAN_TERMINAL;
			case OVERRIDE_ENUMERATION_TERMINAL_VALUE: return OVERRIDE_ENUMERATION_TERMINAL;
			case OVERRIDE_EXPECTED_ENUMERATION_TERMINAL_VALUE: return OVERRIDE_EXPECTED_ENUMERATION_TERMINAL;
			case OVERRIDE_CHANGE_REFERENCE_QUICK_FIX_VALUE: return OVERRIDE_CHANGE_REFERENCE_QUICK_FIX;
			case OVERRIDE_EPROBLEM_SEVERITY_VALUE: return OVERRIDE_EPROBLEM_SEVERITY;
			case OVERRIDE_RESOURCE_POST_PROCESSOR_VALUE: return OVERRIDE_RESOURCE_POST_PROCESSOR;
			case OVERRIDE_IRESOURCE_PROVIDER_VALUE: return OVERRIDE_IRESOURCE_PROVIDER;
			case OVERRIDE_IBRACKET_HANDLER_PROVIDER_VALUE: return OVERRIDE_IBRACKET_HANDLER_PROVIDER;
			case OVERRIDE_IANNOTATION_MODEL_PROVIDER_VALUE: return OVERRIDE_IANNOTATION_MODEL_PROVIDER;
			case OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE_VALUE: return OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE;
			case OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP_VALUE: return OVERRIDE_LAUNCH_CONFIGURATION_TAB_GROUP;
			case OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB_VALUE: return OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB;
			case OVERRIDE_LAUNCH_SHORTCUT_VALUE: return OVERRIDE_LAUNCH_SHORTCUT;
			case OVERRIDE_PROPERTY_TESTER_VALUE: return OVERRIDE_PROPERTY_TESTER;
			case DISABLE_LAUNCH_SUPPORT_VALUE: return DISABLE_LAUNCH_SUPPORT;
			case OVERRIDE_RULE_VALUE: return OVERRIDE_RULE;
			case OVERRIDE_ABSTRACT_DEBUGGABLE_VALUE: return OVERRIDE_ABSTRACT_DEBUGGABLE;
			case OVERRIDE_EDEBUG_MESSAGE_TYPES_VALUE: return OVERRIDE_EDEBUG_MESSAGE_TYPES;
			case OVERRIDE_IDEBUG_EVENT_LISTENER_VALUE: return OVERRIDE_IDEBUG_EVENT_LISTENER;
			case OVERRIDE_IINTERPRETER_LISTENER_VALUE: return OVERRIDE_IINTERPRETER_LISTENER;
			case OVERRIDE_DEBUG_COMMUNICATION_HELPER_VALUE: return OVERRIDE_DEBUG_COMMUNICATION_HELPER;
			case OVERRIDE_DEBUG_ELEMENT_VALUE: return OVERRIDE_DEBUG_ELEMENT;
			case OVERRIDE_DEBUGGABLE_INTERPRETER_VALUE: return OVERRIDE_DEBUGGABLE_INTERPRETER;
			case OVERRIDE_DEBUGGER_LISTENER_VALUE: return OVERRIDE_DEBUGGER_LISTENER;
			case OVERRIDE_DEBUG_MESSAGE_VALUE: return OVERRIDE_DEBUG_MESSAGE;
			case OVERRIDE_DEBUG_PROCESS_VALUE: return OVERRIDE_DEBUG_PROCESS;
			case OVERRIDE_DEBUG_PROXY_VALUE: return OVERRIDE_DEBUG_PROXY;
			case OVERRIDE_DEBUG_TARGET_VALUE: return OVERRIDE_DEBUG_TARGET;
			case OVERRIDE_DEBUG_THREAD_VALUE: return OVERRIDE_DEBUG_THREAD;
			case OVERRIDE_DEBUG_VALUE_VALUE: return OVERRIDE_DEBUG_VALUE;
			case OVERRIDE_DEBUG_VARIABLE_VALUE: return OVERRIDE_DEBUG_VARIABLE;
			case OVERRIDE_LINEBREAK_POINT_VALUE: return OVERRIDE_LINEBREAK_POINT;
			case OVERRIDE_SOURCE_LOCATOR_VALUE: return OVERRIDE_SOURCE_LOCATOR;
			case OVERRIDE_SOURCE_LOOKUP_PARTICIPANT_VALUE: return OVERRIDE_SOURCE_LOOKUP_PARTICIPANT;
			case OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE_VALUE: return OVERRIDE_SOURCE_PATH_COMPUTER_DELEGATE;
			case OVERRIDE_STACK_FRAME_VALUE: return OVERRIDE_STACK_FRAME;
			case DISABLE_DEBUG_SUPPORT_VALUE: return DISABLE_DEBUG_SUPPORT;
			case OVERRIDE_DEBUG_MODEL_PRESENTATION_VALUE: return OVERRIDE_DEBUG_MODEL_PRESENTATION;
			case OVERRIDE_LINE_BREAKPOINT_ADAPTER_VALUE: return OVERRIDE_LINE_BREAKPOINT_ADAPTER;
			case OVERRIDE_ADAPTER_FACTORY_VALUE: return OVERRIDE_ADAPTER_FACTORY;
			case OVERRIDE_LAUNCH_CONFIGURATION_HELPER_VALUE: return OVERRIDE_LAUNCH_CONFIGURATION_HELPER;
			case OVERRIDE_NEW_PROJECT_WIZARD_VALUE: return OVERRIDE_NEW_PROJECT_WIZARD;
			case DISABLE_NEW_PROJECT_WIZARD_VALUE: return DISABLE_NEW_PROJECT_WIZARD;
			case IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING_VALUE: return IGNORE_TYPE_RESTRICTIONS_FOR_PRINTING;
			case OVERRIDE_INAME_PROVIDER_VALUE: return OVERRIDE_INAME_PROVIDER;
			case OVERRIDE_DEFAULT_NAME_PROVIDER_VALUE: return OVERRIDE_DEFAULT_NAME_PROVIDER;
			case OVERRIDE_REFERENCE_CACHE_VALUE: return OVERRIDE_REFERENCE_CACHE;
			case OVERRIDE_OUTLINE_PAGE_LEXICAL_SORTING_ACTION_VALUE: return OVERRIDE_OUTLINE_PAGE_LEXICAL_SORTING_ACTION;
			case OVERRIDE_OUTLINE_PAGE_COLLAPSE_ALL_ACTION_VALUE: return OVERRIDE_OUTLINE_PAGE_COLLAPSE_ALL_ACTION;
			case OVERRIDE_OUTLINE_PAGE_GROUP_TYPES_ACTION_VALUE: return OVERRIDE_OUTLINE_PAGE_GROUP_TYPES_ACTION;
			case OVERRIDE_ABSTRACT_OUTLINE_PAGE_ACTION_VALUE: return OVERRIDE_ABSTRACT_OUTLINE_PAGE_ACTION;
			case OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_COMPARATOR_VALUE: return OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_COMPARATOR;
			case OVERRIDE_OUTLINE_PAGE_EXPAND_ALL_ACTION_VALUE: return OVERRIDE_OUTLINE_PAGE_EXPAND_ALL_ACTION;
			case OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER_VALUE: return OVERRIDE_OUTLINE_PAGE_ACTION_PROVIDER;
			case OVERRIDE_OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION_VALUE: return OVERRIDE_OUTLINE_PAGE_LINK_WITH_EDITOR_ACTION;
			case OVERRIDE_OUTLINE_PAGE_AUTO_EXPAND_ACTION_VALUE: return OVERRIDE_OUTLINE_PAGE_AUTO_EXPAND_ACTION;
			case OVERRIDE_CONTAINED_FEATURE_VALUE: return OVERRIDE_CONTAINED_FEATURE;
			case OVERRIDE_EXPECTATION_CONSTANTS_VALUE: return OVERRIDE_EXPECTATION_CONSTANTS;
			case OVERRIDE_ECLIPSE_PROXY_VALUE: return OVERRIDE_ECLIPSE_PROXY;
			case OVERRIDE_RUNTIME_UTIL_VALUE: return OVERRIDE_RUNTIME_UTIL;
			case REMOVE_ECLIPSE_DEPENDENT_CODE_VALUE: return REMOVE_ECLIPSE_DEPENDENT_CODE;
			case OVERRIDE_IFUNCTION1_VALUE: return OVERRIDE_IFUNCTION1;
			case OVERRIDE_DEV_NULL_LOCATION_MAP_VALUE: return OVERRIDE_DEV_NULL_LOCATION_MAP;
			case OVERRIDE_IGNORED_WORDS_FILTER_VALUE: return OVERRIDE_IGNORED_WORDS_FILTER;
			case OVERRIDE_TASK_ITEM_DETECTOR_VALUE: return OVERRIDE_TASK_ITEM_DETECTOR;
			case OVERRIDE_TASK_ITEM_BUILDER_VALUE: return OVERRIDE_TASK_ITEM_BUILDER;
			case OVERRIDE_SOURCE_VIEWER_CONFIGURATION_VALUE: return OVERRIDE_SOURCE_VIEWER_CONFIGURATION;
			case OVERRIDE_TASK_ITEM_VALUE: return OVERRIDE_TASK_ITEM;
			case OVERRIDE_URI_UTIL_VALUE: return OVERRIDE_URI_UTIL;
			case OVERRIDE_ANTLR_TEXT_TOKEN_VALUE: return OVERRIDE_ANTLR_TEXT_TOKEN;
			case OVERRIDE_IDELEGATING_REFERENCE_RESOLVER_VALUE: return OVERRIDE_IDELEGATING_REFERENCE_RESOLVER;
			case ADDITIONAL_IMPORTED_PACKAGES_VALUE: return ADDITIONAL_IMPORTED_PACKAGES;
			case ADDITIONAL_UI_IMPORTED_PACKAGES_VALUE: return ADDITIONAL_UI_IMPORTED_PACKAGES;
			case ADDITIONAL_LIBRARIES_VALUE: return ADDITIONAL_LIBRARIES;
			case OVERRIDE_CONTAINMENT_TRACE_VALUE: return OVERRIDE_CONTAINMENT_TRACE;
			case EDITOR_NAME_VALUE: return EDITOR_NAME;
			case OVERRIDE_LAYOUT_UTIL_VALUE: return OVERRIDE_LAYOUT_UTIL;
			case OVERRIDE_UI_ANTLR_TOKEN_HELPER_VALUE: return OVERRIDE_UI_ANTLR_TOKEN_HELPER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private OptionTypes(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //OptionTypes
