/**
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany 
 *       - initial API and implementation
 * 
 *
 * $Id$
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
	 * The '<em><b>OVERRIDE OCCURENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OCCURENCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OCCURENCE(63, "OVERRIDE_OCCURENCE", "overrideOccurrence"),

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
	 * The '<em><b>OVERRIDE OCCURENCE PREFERENCE PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OCCURENCE_PREFERENCE_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OCCURENCE_PREFERENCE_PAGE(74, "OVERRIDE_OCCURENCE_PREFERENCE_PAGE", "overrideOccurencePreferencePage"),

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
	OVERRIDE_IURI_MAPPING(112, "OVERRIDE_IURI_MAPPING", "overrideIURIMapping"),

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
	OVERRIDE_CARDINALITY(168, "OVERRIDE_CARDINALITY", "overrideCardinality"), /**
	 * The '<em><b>OVERRIDE PRINTER2</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PRINTER2_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PRINTER2(169, "OVERRIDE_PRINTER2", "overridePrinter2"), /**
	 * The '<em><b>OVERRIDE CHOICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CHOICE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CHOICE(170, "OVERRIDE_CHOICE", "overrideChoice"), /**
	 * The '<em><b>OVERRIDE COMPOUND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COMPOUND_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COMPOUND(171, "OVERRIDE_COMPOUND", "overrideCompound"), /**
	 * The '<em><b>OVERRIDE CONTAINMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTAINMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CONTAINMENT(172, "OVERRIDE_CONTAINMENT", "overrideContainment"), /**
	 * The '<em><b>OVERRIDE LINE BREAK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LINE_BREAK_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LINE_BREAK(173, "OVERRIDE_LINE_BREAK", "overrideLineBreak"), /**
	 * The '<em><b>OVERRIDE SEQUENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SEQUENCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SEQUENCE(174, "OVERRIDE_SEQUENCE", "overrideSequence"), /**
	 * The '<em><b>OVERRIDE WHITE SPACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_WHITE_SPACE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_WHITE_SPACE(175, "OVERRIDE_WHITE_SPACE", "overrideWhiteSpace"), /**
	 * The '<em><b>OVERRIDE SYNTAX ELEMENT DECORATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_ELEMENT_DECORATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SYNTAX_ELEMENT_DECORATOR(176, "OVERRIDE_SYNTAX_ELEMENT_DECORATOR", "overrideSyntaxElementDecorator"), /**
	 * The '<em><b>OVERRIDE IREFERENCE CACHE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_CACHE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_IREFERENCE_CACHE(177, "OVERRIDE_IREFERENCE_CACHE", "overrideIReferenceCache"), /**
	 * The '<em><b>OVERRIDE DEFAULT HOVER TEXT PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER(178, "OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER", "overrideDefaultHoverTextProvider"), /**
	 * The '<em><b>OVERRIDE FORMATTING ELEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FORMATTING_ELEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_FORMATTING_ELEMENT(179, "OVERRIDE_FORMATTING_ELEMENT", "overrideFormattingElement"), /**
	 * The '<em><b>OVERRIDE TERMINAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TERMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TERMINAL(180, "OVERRIDE_TERMINAL", "overrideTerminal"), /**
	 * The '<em><b>OVERRIDE LAYOUT INFORMATION ADAPTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAYOUT_INFORMATION_ADAPTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAYOUT_INFORMATION_ADAPTER(181, "OVERRIDE_LAYOUT_INFORMATION_ADAPTER", "overrideLayoutInformationAdapter"), /**
	 * The '<em><b>OVERRIDE LAYOUT INFORMATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAYOUT_INFORMATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LAYOUT_INFORMATION(182, "OVERRIDE_LAYOUT_INFORMATION", "overrideLayoutInformation"), /**
	 * The '<em><b>USE CLASSIC PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USE_CLASSIC_PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	USE_CLASSIC_PRINTER(183, "USE_CLASSIC_PRINTER", "useClassicPrinter"), /**
	 * The '<em><b>DISABLE EVALIDATORS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_EVALIDATORS_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_EVALIDATORS(184, "DISABLE_E_VALIDATORS", "disableEValidators"), /**
	 * The '<em><b>DISABLE EMF VALIDATION CONSTRAINTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISABLE_EMF_VALIDATION_CONSTRAINTS_VALUE
	 * @generated
	 * @ordered
	 */
	DISABLE_EMF_VALIDATION_CONSTRAINTS(185, "DISABLE_EMF_VALIDATION_CONSTRAINTS", "disableEMFValidationConstraints"), /**
	 * The '<em><b>OVERRIDE UI META INFORMATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_META_INFORMATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_META_INFORMATION(186, "OVERRIDE_UI_META_INFORMATION", "overrideUIMetaInformation"), /**
	 * The '<em><b>RESOURCE UI PLUGIN ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_UI_PLUGIN_ID_VALUE
	 * @generated
	 * @ordered
	 */
	RESOURCE_UI_PLUGIN_ID(187, "RESOURCE_UI_PLUGIN_ID", "resourceUIPluginID"), /**
	 * The '<em><b>OVERRIDE UI PLUGIN ACTIVATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_PLUGIN_ACTIVATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_PLUGIN_ACTIVATOR(188, "OVERRIDE_UI_PLUGIN_ACTIVATOR", "overrideUIPluginActivator"), /**
	 * The '<em><b>UI BASE PACKAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UI_BASE_PACKAGE_VALUE
	 * @generated
	 * @ordered
	 */
	UI_BASE_PACKAGE(189, "UI_BASE_PACKAGE", "uiBasePackage"), /**
	 * The '<em><b>ADDITIONAL UI DEPENDENCIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_UI_DEPENDENCIES_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_UI_DEPENDENCIES(190, "ADDITIONAL_UI_DEPENDENCIES", "additionalUIDependencies"), /**
	 * The '<em><b>ADDITIONAL UI EXPORTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_UI_EXPORTS_VALUE
	 * @generated
	 * @ordered
	 */
	ADDITIONAL_UI_EXPORTS(191, "ADDITIONAL_UI_EXPORTS", "additionalUIExports"), /**
	 * The '<em><b>OVERRIDE UI MANIFEST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_MANIFEST_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_UI_MANIFEST(192, "OVERRIDE_UI_MANIFEST", "overrideUIManifest");

	/**
	 * The '<em><b>GENERATE TEST ACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERATE TEST ACTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERATE_TEST_ACTION
	 * @model literal="generateTestAction"
	 * @generated
	 * @ordered
	 */
	public static final int GENERATE_TEST_ACTION_VALUE = 0;

	/**
	 * The '<em><b>GENERATE CODE FROM GENERATOR MODEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERATE CODE FROM GENERATOR MODEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERATE_CODE_FROM_GENERATOR_MODEL
	 * @model literal="generateCodeFromGeneratorModel"
	 * @generated
	 * @ordered
	 */
	public static final int GENERATE_CODE_FROM_GENERATOR_MODEL_VALUE = 1;

	/**
	 * The '<em><b>OVERRIDE PLUGIN XML</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PLUGIN XML</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLUGIN_XML
	 * @model literal="overridePluginXML"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PLUGIN_XML_VALUE = 3;

	/**
	 * The '<em><b>OVERRIDE MANIFEST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE MANIFEST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MANIFEST
	 * @model literal="overrideManifest"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MANIFEST_VALUE = 4;

	/**
	 * The '<em><b>OVERRIDE PARSER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PARSER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PARSER
	 * @model literal="overrideParser"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PARSER_VALUE = 5;

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TOKEN RESOLVERS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVERS
	 * @model literal="overrideTokenResolvers"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_RESOLVERS_VALUE = 6;

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVERS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE REFERENCE RESOLVERS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVERS
	 * @model literal="overrideReferenceResolvers"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_REFERENCE_RESOLVERS_VALUE = 7;

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVER SWITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE REFERENCE RESOLVER SWITCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVER_SWITCH
	 * @model literal="overrideReferenceResolverSwitch"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_REFERENCE_RESOLVER_SWITCH_VALUE = 8;

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVER FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TOKEN RESOLVER FACTORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVER_FACTORY
	 * @model literal="overrideTokenResolverFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_RESOLVER_FACTORY_VALUE = 9;

	/**
	 * The '<em><b>OVERRIDE PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PRINTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PRINTER
	 * @model literal="overridePrinter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PRINTER_VALUE = 10;

	/**
	 * The '<em><b>ANTLR BACKTRACKING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANTLR BACKTRACKING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANTLR_BACKTRACKING
	 * @model literal="backtracking"
	 * @generated
	 * @ordered
	 */
	public static final int ANTLR_BACKTRACKING_VALUE = 12;

	/**
	 * The '<em><b>ANTLR MEMOIZE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANTLR MEMOIZE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANTLR_MEMOIZE
	 * @model literal="memoize"
	 * @generated
	 * @ordered
	 */
	public static final int ANTLR_MEMOIZE_VALUE = 13;

	/**
	 * The '<em><b>AUTOFIX SIMPLE LEFTRECURSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AUTOFIX SIMPLE LEFTRECURSION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUTOFIX_SIMPLE_LEFTRECURSION
	 * @model literal="autofixSimpleLeftrecursion"
	 * @generated
	 * @ordered
	 */
	public static final int AUTOFIX_SIMPLE_LEFTRECURSION_VALUE = 14;

	/**
	 * The '<em><b>FORCE EOF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FORCE EOF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORCE_EOF
	 * @model literal="forceEOF"
	 * @generated
	 * @ordered
	 */
	public static final int FORCE_EOF_VALUE = 15;

	/**
	 * The '<em><b>DEFAULT TOKEN NAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEFAULT TOKEN NAME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_TOKEN_NAME
	 * @model literal="defaultTokenName"
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT_TOKEN_NAME_VALUE = 16;

	/**
	 * The '<em><b>USE PREDEFINED TOKENS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USE PREDEFINED TOKENS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USE_PREDEFINED_TOKENS
	 * @model literal="usePredefinedTokens"
	 * @generated
	 * @ordered
	 */
	public static final int USE_PREDEFINED_TOKENS_VALUE = 17;

	/**
	 * The '<em><b>TOKENSPACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOKENSPACE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOKENSPACE
	 * @model literal="tokenspace"
	 * @generated
	 * @ordered
	 */
	public static final int TOKENSPACE_VALUE = 18;

	/**
	 * The '<em><b>RELOAD GENERATOR MODEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RELOAD GENERATOR MODEL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELOAD_GENERATOR_MODEL
	 * @model literal="reloadGeneratorModel"
	 * @generated
	 * @ordered
	 */
	public static final int RELOAD_GENERATOR_MODEL_VALUE = 19;

	/**
	 * The '<em><b>OVERRIDE DOT CLASSPATH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DOT CLASSPATH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOT_CLASSPATH
	 * @model literal="overrideClasspath"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DOT_CLASSPATH_VALUE = 20;

	/**
	 * The '<em><b>OVERRIDE DOT PROJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DOT PROJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOT_PROJECT
	 * @model literal="overrideProjectFile"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DOT_PROJECT_VALUE = 21;

	/**
	 * The '<em><b>OVERRIDE TEXT RESOURCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TEXT RESOURCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_RESOURCE
	 * @model literal="overrideTextResource"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TEXT_RESOURCE_VALUE = 22;

	/**
	 * The '<em><b>OVERRIDE RESOURCE FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE RESOURCE FACTORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_FACTORY
	 * @model literal="overrideResourceFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RESOURCE_FACTORY_VALUE = 23;

	/**
	 * The '<em><b>OVERRIDE NEW FILE WIZARD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE NEW FILE WIZARD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_FILE_WIZARD
	 * @model literal="overrideNewFileWizard"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NEW_FILE_WIZARD_VALUE = 24;

	/**
	 * The '<em><b>PARSER GENERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARSER GENERATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARSER_GENERATOR
	 * @model literal="parserGenerator"
	 * @generated
	 * @ordered
	 */
	public static final int PARSER_GENERATOR_VALUE = 25;

	/**
	 * The '<em><b>SOURCE FOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOURCE FOLDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOURCE_FOLDER
	 * @model literal="srcFolder"
	 * @generated
	 * @ordered
	 */
	public static final int SOURCE_FOLDER_VALUE = 26;

	/**
	 * The '<em><b>BASE PACKAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BASE PACKAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BASE_PACKAGE
	 * @model literal="basePackage"
	 * @generated
	 * @ordered
	 */
	public static final int BASE_PACKAGE_VALUE = 27;

	/**
	 * The '<em><b>RESOURCE PLUGIN ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESOURCE PLUGIN ID</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_PLUGIN_ID
	 * @model literal="resourcePluginID"
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_PLUGIN_ID_VALUE = 28;

	/**
	 * The '<em><b>OVERRIDE BUILD PROPERTIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE BUILD PROPERTIES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BUILD_PROPERTIES
	 * @model literal="overrideBuildProperties"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BUILD_PROPERTIES_VALUE = 29;

	/**
	 * The '<em><b>OVERRIDE META INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE META INFORMATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_META_INFORMATION
	 * @model literal="overrideMetaInformation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_META_INFORMATION_VALUE = 30;

	/**
	 * The '<em><b>OVERRIDE DEFAULT RESOLVER DELEGATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DEFAULT RESOLVER DELEGATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_RESOLVER_DELEGATE
	 * @model literal="overrideDefaultResolverDelegate"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_RESOLVER_DELEGATE_VALUE = 31;

	/**
	 * The '<em><b>OVERRIDE PROBLEM CLASS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PROBLEM CLASS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PROBLEM_CLASS
	 * @model literal="overrideProblemClass"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PROBLEM_CLASS_VALUE = 32;

	/**
	 * The '<em><b>OVERRIDE SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE SCANNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SCANNER
	 * @model literal="overrideScanner"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SCANNER_VALUE = 33;

	/**
	 * The '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT
	 * @model literal="overrideContextDependentURIFragment"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_VALUE = 34;

	/**
	 * The '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY
	 * @model literal="overrideContextDependentURIFragmentFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE = 35;

	/**
	 * The '<em><b>OVERRIDE DELEGATING RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DELEGATING RESOLVE RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DELEGATING_RESOLVE_RESULT
	 * @model literal="overrideDelegatingResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DELEGATING_RESOLVE_RESULT_VALUE = 36;

	/**
	 * The '<em><b>OVERRIDE DUMMY EOBJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DUMMY EOBJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DUMMY_EOBJECT
	 * @model name="OVERRIDE_DUMMY_E_OBJECT" literal="overrideDummyEObject"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DUMMY_EOBJECT_VALUE = 37;

	/**
	 * The '<em><b>OVERRIDE ELEMENT MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ELEMENT MAPPING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ELEMENT_MAPPING
	 * @model literal="overrideElementMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ELEMENT_MAPPING_VALUE = 38;

	/**
	 * The '<em><b>OVERRIDE FUZZY RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE FUZZY RESOLVE RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FUZZY_RESOLVE_RESULT
	 * @model literal="overrideFuzzyResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_FUZZY_RESOLVE_RESULT_VALUE = 39;

	/**
	 * The '<em><b>OVERRIDE DEFAULT TOKEN RESOLVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DEFAULT TOKEN RESOLVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_TOKEN_RESOLVER
	 * @model literal="overrideDefaultTokenResolver"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_TOKEN_RESOLVER_VALUE = 40;

	/**
	 * The '<em><b>OVERRIDE LOCATION MAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE LOCATION MAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LOCATION_MAP
	 * @model literal="overrideLocationMap"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LOCATION_MAP_VALUE = 41;

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE REFERENCE RESOLVE RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVE_RESULT
	 * @model literal="overrideReferenceResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_REFERENCE_RESOLVE_RESULT_VALUE = 42;

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TOKEN RESOLVE RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVE_RESULT
	 * @model literal="overrideTokenResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_RESOLVE_RESULT_VALUE = 43;

	/**
	 * The '<em><b>OVERRIDE URI MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE URI MAPPING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_URI_MAPPING
	 * @model literal="overrideURIMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_URI_MAPPING_VALUE = 45;

	/**
	 * The '<em><b>OVERRIDE HOVER TEXT PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE HOVER TEXT PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HOVER_TEXT_PROVIDER
	 * @model literal="overrideHoverTextProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HOVER_TEXT_PROVIDER_VALUE = 46;

	/**
	 * The '<em><b>OVERRIDE PARSE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PARSE RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PARSE_RESULT
	 * @model literal="overrideParseResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PARSE_RESULT_VALUE = 47;

	/**
	 * The '<em><b>OVERRIDE ANTLR TOKEN HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ANTLR TOKEN HELPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANTLR_TOKEN_HELPER
	 * @model literal="overrideAntlrTokenHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ANTLR_TOKEN_HELPER_VALUE = 48;

	/**
	 * The '<em><b>OVERRIDE BRACKET SET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE BRACKET SET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BRACKET_SET
	 * @model literal="overrideBracketSet"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BRACKET_SET_VALUE = 49;

	/**
	 * The '<em><b>OVERRIDE BROWSER INFORMATION CONTROL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE BROWSER INFORMATION CONTROL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BROWSER_INFORMATION_CONTROL
	 * @model literal="overrideBrowserInformationControl"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BROWSER_INFORMATION_CONTROL_VALUE = 50;

	/**
	 * The '<em><b>OVERRIDE CODE FOLDING MANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE CODE FOLDING MANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CODE_FOLDING_MANAGER
	 * @model literal="overrideCodeFoldingManager"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CODE_FOLDING_MANAGER_VALUE = 51;

	/**
	 * The '<em><b>OVERRIDE COLOR MANAGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE COLOR MANAGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COLOR_MANAGER
	 * @model literal="overrideColorManager"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COLOR_MANAGER_VALUE = 52;

	/**
	 * The '<em><b>OVERRIDE COMPLETION PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE COMPLETION PROCESSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COMPLETION_PROCESSOR
	 * @model literal="overrideCompletionProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COMPLETION_PROCESSOR_VALUE = 53;

	/**
	 * The '<em><b>OVERRIDE PARSING STRATEGY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PARSING STRATEGY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PARSING_STRATEGY
	 * @model literal="overrideParsingStrategy"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PARSING_STRATEGY_VALUE = 54;

	/**
	 * The '<em><b>OVERRIDE DOC BROWSER INFORMATION CONTROL INPUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DOC BROWSER INFORMATION CONTROL INPUT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT
	 * @model literal="overrideDocBrowserInformationControlInput"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT_VALUE = 55;

	/**
	 * The '<em><b>OVERRIDE EDITOR CONFIGURATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE EDITOR CONFIGURATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EDITOR_CONFIGURATION
	 * @model literal="overrideEditorConfiguration"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EDITOR_CONFIGURATION_VALUE = 55;

	/**
	 * The '<em><b>OVERRIDE EDITOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE EDITOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EDITOR
	 * @model literal="overrideEditor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EDITOR_VALUE = 56;

	/**
	 * The '<em><b>OVERRIDE EOBJECT SELECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE EOBJECT SELECTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EOBJECT_SELECTION
	 * @model name="OVERRIDE_E_OBJECT_SELECTION" literal="overrideEObjectSelection"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EOBJECT_SELECTION_VALUE = 57;

	/**
	 * The '<em><b>OVERRIDE HIGHLIGHTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE HIGHLIGHTING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HIGHLIGHTING
	 * @model literal="overrideHighlighting"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HIGHLIGHTING_VALUE = 58;

	/**
	 * The '<em><b>OVERRIDE HTML PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE HTML PRINTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HTML_PRINTER
	 * @model literal="overrideHTMLPrinter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HTML_PRINTER_VALUE = 59;

	/**
	 * The '<em><b>OVERRIDE HYPERLINK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE HYPERLINK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HYPERLINK
	 * @model literal="overrideHyperlink"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HYPERLINK_VALUE = 60;

	/**
	 * The '<em><b>OVERRIDE HYPERLINK DETECTOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE HYPERLINK DETECTOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HYPERLINK_DETECTOR
	 * @model literal="overrideHyperlinkDetector"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_HYPERLINK_DETECTOR_VALUE = 61;

	/**
	 * The '<em><b>OVERRIDE MARKER HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE MARKER HELPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MARKER_HELPER
	 * @model literal="overrideMarkerHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MARKER_HELPER_VALUE = 62;

	/**
	 * The '<em><b>OVERRIDE OCCURENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE OCCURENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OCCURENCE
	 * @model literal="overrideOccurrence"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OCCURENCE_VALUE = 63;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE OUTLINE PAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE
	 * @model literal="overrideOutlinePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_VALUE = 64;

	/**
	 * The '<em><b>OVERRIDE OUTLINE PAGE TREE VIEWER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE OUTLINE PAGE TREE VIEWER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_TREE_VIEWER
	 * @model literal="overrideOutlinePageTreeViewer"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_VALUE = 65;

	/**
	 * The '<em><b>OVERRIDE PLUGIN ACTIVATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PLUGIN ACTIVATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLUGIN_ACTIVATOR
	 * @model literal="overridePluginActivator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PLUGIN_ACTIVATOR_VALUE = 66;

	/**
	 * The '<em><b>OVERRIDE POSITION CATEGORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE POSITION CATEGORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_POSITION_CATEGORY
	 * @model literal="overridePositionCategory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_POSITION_CATEGORY_VALUE = 67;

	/**
	 * The '<em><b>OVERRIDE POSITION HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE POSITION HELPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_POSITION_HELPER
	 * @model literal="overridePositionHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_POSITION_HELPER_VALUE = 68;

	/**
	 * The '<em><b>OVERRIDE PROPERTY SHEET PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PROPERTY SHEET PAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PROPERTY_SHEET_PAGE
	 * @model literal="overridePropertySheetPage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PROPERTY_SHEET_PAGE_VALUE = 69;

	/**
	 * The '<em><b>OVERRIDE TEXT HOVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TEXT HOVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_HOVER
	 * @model literal="overrideTextHover"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TEXT_HOVER_VALUE = 70;

	/**
	 * The '<em><b>OVERRIDE TOKEN SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TOKEN SCANNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_SCANNER
	 * @model literal="overrideTokenScanner"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_SCANNER_VALUE = 71;

	/**
	 * The '<em><b>OVERRIDE BRACKET PREFERENCE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE BRACKET PREFERENCE PAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BRACKET_PREFERENCE_PAGE
	 * @model literal="overrideBracketPreferencePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BRACKET_PREFERENCE_PAGE_VALUE = 72;

	/**
	 * The '<em><b>OVERRIDE PREFERENCE CONSTANTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PREFERENCE CONSTANTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PREFERENCE_CONSTANTS
	 * @model literal="overridePreferenceConstants"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PREFERENCE_CONSTANTS_VALUE = 73;

	/**
	 * The '<em><b>OVERRIDE OCCURENCE PREFERENCE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE OCCURENCE PREFERENCE PAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OCCURENCE_PREFERENCE_PAGE
	 * @model literal="overrideOccurencePreferencePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_OCCURENCE_PREFERENCE_PAGE_VALUE = 74;

	/**
	 * The '<em><b>OVERRIDE PIXEL CONVERTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PIXEL CONVERTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PIXEL_CONVERTER
	 * @model literal="overridePixelConverter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PIXEL_CONVERTER_VALUE = 75;

	/**
	 * The '<em><b>OVERRIDE PREFERENCE INITIALIZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PREFERENCE INITIALIZER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PREFERENCE_INITIALIZER
	 * @model literal="overridePreferenceInitializer"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PREFERENCE_INITIALIZER_VALUE = 76;

	/**
	 * The '<em><b>OVERRIDE SYNTAX COLORING HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE SYNTAX COLORING HELPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_COLORING_HELPER
	 * @model literal="overrideSyntaxColoringHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_COLORING_HELPER_VALUE = 77;

	/**
	 * The '<em><b>OVERRIDE SYNTAX COLORING PREFERENCE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE SYNTAX COLORING PREFERENCE PAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE
	 * @model literal="overrideSyntaxColoringPreferencePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_COLORING_PREFERENCE_PAGE_VALUE = 78;

	/**
	 * The '<em><b>OVERRIDE IINPUT STREAM PROCESSOR PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IINPUT STREAM PROCESSOR PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER
	 * @model name="OVERRIDE_I_INPUT_STREAM_PROCESSOR_PROVIDER" literal="overrideIInputStreamProcessorProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IINPUT_STREAM_PROCESSOR_PROVIDER_VALUE = 79;

	/**
	 * The '<em><b>OVERRIDE INPUT STREAM PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE INPUT STREAM PROCESSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_INPUT_STREAM_PROCESSOR
	 * @model literal="overrideInputStreamProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_INPUT_STREAM_PROCESSOR_VALUE = 80;

	/**
	 * The '<em><b>OVERRIDE IOPTION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IOPTION PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IOPTION_PROVIDER
	 * @model name="OVERRIDE_I_OPTION_PROVIDER" literal="overrideIOptionProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IOPTION_PROVIDER_VALUE = 81;

	/**
	 * The '<em><b>OVERRIDE IOPTIONS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IOPTIONS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IOPTIONS
	 * @model name="OVERRIDE_I_OPTIONS" literal="overrideIOptions"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IOPTIONS_VALUE = 82;

	/**
	 * The '<em><b>OVERRIDE IRESOURCE POST PROCESSOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IRESOURCE POST PROCESSOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IRESOURCE_POST_PROCESSOR
	 * @model name="OVERRIDE_I_RESOURCE_POST_PROCESSOR" literal="overrideIResourcePostProcessor"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IRESOURCE_POST_PROCESSOR_VALUE = 83;

	/**
	 * The '<em><b>OVERRIDE IRESOURCE POST PROCESSOR PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IRESOURCE POST PROCESSOR PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER
	 * @model name="OVERRIDE_I_RESOURCE_POST_PROCESSOR_PROVIDER" literal="overrideIResourcePostProcessorProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IRESOURCE_POST_PROCESSOR_PROVIDER_VALUE = 84;

	/**
	 * The '<em><b>OVERRIDE IBRACKET PAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IBRACKET PAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IBRACKET_PAIR
	 * @model name="OVERRIDE_I_BRACKET_PAIR" literal="overrideIBracketPair"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IBRACKET_PAIR_VALUE = 85;

	/**
	 * The '<em><b>OVERRIDE ICOMMAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ICOMMAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ICOMMAND
	 * @model name="OVERRIDE_I_COMMAND" literal="overrideICommand"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ICOMMAND_VALUE = 86;

	/**
	 * The '<em><b>OVERRIDE ICONFIGURABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ICONFIGURABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ICONFIGURABLE
	 * @model name="OVERRIDE_I_CONFIGURABLE" literal="overrideIConfigurable"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ICONFIGURABLE_VALUE = 87;

	/**
	 * The '<em><b>OVERRIDE ICONTEXT DEPENDENT URI FRAGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ICONTEXT DEPENDENT URI FRAGMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT
	 * @model name="OVERRIDE_I_CONTEXT_DEPENDENT_URI_FRAGMENT" literal="overrideIContextDependentURIFragment"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_VALUE = 88;

	/**
	 * The '<em><b>OVERRIDE ICONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ICONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY
	 * @model name="OVERRIDE_I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY" literal="overrideIContextDependentURIFragmentFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ICONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE = 89;

	/**
	 * The '<em><b>OVERRIDE IELEMENT MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IELEMENT MAPPING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IELEMENT_MAPPING
	 * @model name="OVERRIDE_I_ELEMENT_MAPPING" literal="overrideIElementMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IELEMENT_MAPPING_VALUE = 90;

	/**
	 * The '<em><b>OVERRIDE IEXPECTED ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IEXPECTED ELEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IEXPECTED_ELEMENT
	 * @model name="OVERRIDE_I_EXPECTED_ELEMENT" literal="overrideIExpectedElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IEXPECTED_ELEMENT_VALUE = 91;

	/**
	 * The '<em><b>OVERRIDE IHOVER TEXT PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IHOVER TEXT PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IHOVER_TEXT_PROVIDER
	 * @model name="OVERRIDE_I_HOVER_TEXT_PROVIDER" literal="overrideIHoverTextProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IHOVER_TEXT_PROVIDER_VALUE = 92;

	/**
	 * The '<em><b>OVERRIDE ILOCATION MAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ILOCATION MAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ILOCATION_MAP
	 * @model name="OVERRIDE_I_LOCATION_MAP" literal="overrideILocationMap"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ILOCATION_MAP_VALUE = 93;

	/**
	 * The '<em><b>OVERRIDE IPARSE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IPARSE RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IPARSE_RESULT
	 * @model name="OVERRIDE_I_PARSE_RESULT" literal="overrideIParseResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IPARSE_RESULT_VALUE = 94;

	/**
	 * The '<em><b>OVERRIDE IPROBLEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IPROBLEM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IPROBLEM
	 * @model name="OVERRIDE_I_PROBLEM" literal="overrideIProblem"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IPROBLEM_VALUE = 95;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IREFERENCE MAPPING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_MAPPING
	 * @model name="OVERRIDE_I_REFERENCE_MAPPING" literal="overrideIReferenceMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_MAPPING_VALUE = 96;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IREFERENCE RESOLVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVER
	 * @model name="OVERRIDE_I_REFERENCE_RESOLVER" literal="overrideIReferenceResolver"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_RESOLVER_VALUE = 97;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IREFERENCE RESOLVE RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVE_RESULT
	 * @model name="OVERRIDE_I_REFERENCE_RESOLVE_RESULT" literal="overrideIReferenceResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_RESOLVE_RESULT_VALUE = 98;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE RESOLVER SWITCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IREFERENCE RESOLVER SWITCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_RESOLVER_SWITCH
	 * @model name="OVERRIDE_I_REFERENCE_RESOLVER_SWITCH" literal="overrideIReferenceResolverSwitch"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_RESOLVER_SWITCH_VALUE = 99;

	/**
	 * The '<em><b>OVERRIDE ITEXT DIAGNOSTIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITEXT DIAGNOSTIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_DIAGNOSTIC
	 * @model name="OVERRIDE_I_TEXT_DIAGNOSTIC" literal="overrideITextDiagnostic"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_DIAGNOSTIC_VALUE = 100;

	/**
	 * The '<em><b>OVERRIDE ITEXT PARSER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITEXT PARSER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_PARSER
	 * @model name="OVERRIDE_I_TEXT_PARSER" literal="overrideITextParser"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_PARSER_VALUE = 101;

	/**
	 * The '<em><b>OVERRIDE ITEXT PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITEXT PRINTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_PRINTER
	 * @model name="OVERRIDE_I_TEXT_PRINTER" literal="overrideITextPrinter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_PRINTER_VALUE = 102;

	/**
	 * The '<em><b>OVERRIDE ITEXT RESOURCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITEXT RESOURCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_RESOURCE
	 * @model name="OVERRIDE_I_TEXT_RESOURCE" literal="overrideITextResource"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_RESOURCE_VALUE = 103;

	/**
	 * The '<em><b>OVERRIDE IMETA INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IMETA INFORMATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IMETA_INFORMATION
	 * @model name="OVERRIDE_I_META_INFORMATION" literal="overrideIMetaInformation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IMETA_INFORMATION_VALUE = 104;

	/**
	 * The '<em><b>OVERRIDE ITEXT RESOURCE PLUGIN PART</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITEXT RESOURCE PLUGIN PART</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART
	 * @model name="OVERRIDE_I_TEXT_RESOURCE_PLUGIN_PART" literal="overrideITextResourcePluginPart"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_RESOURCE_PLUGIN_PART_VALUE = 105;

	/**
	 * The '<em><b>OVERRIDE ITEXT SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITEXT SCANNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_SCANNER
	 * @model name="OVERRIDE_I_TEXT_SCANNER" literal="overrideITextScanner"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_SCANNER_VALUE = 106;

	/**
	 * The '<em><b>OVERRIDE ITEXT TOKEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITEXT TOKEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITEXT_TOKEN
	 * @model name="OVERRIDE_I_TEXT_TOKEN" literal="overrideITextToken"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITEXT_TOKEN_VALUE = 107;

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITOKEN RESOLVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVER
	 * @model name="OVERRIDE_I_TOKEN_RESOLVER" literal="overrideITokenResolver"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITOKEN_RESOLVER_VALUE = 108;

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVE RESULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITOKEN RESOLVE RESULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVE_RESULT
	 * @model name="OVERRIDE_I_TOKEN_RESOLVE_RESULT" literal="overrideITokenResolveResult"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITOKEN_RESOLVE_RESULT_VALUE = 109;

	/**
	 * The '<em><b>OVERRIDE ITOKEN RESOLVER FACTORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITOKEN RESOLVER FACTORY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITOKEN_RESOLVER_FACTORY
	 * @model name="OVERRIDE_I_TOKEN_RESOLVER_FACTORY" literal="overrideITokenResolverFactory"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITOKEN_RESOLVER_FACTORY_VALUE = 110;

	/**
	 * The '<em><b>OVERRIDE ITOKEN STYLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ITOKEN STYLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ITOKEN_STYLE
	 * @model name="OVERRIDE_I_TOKEN_STYLE" literal="overrideITokenStyle"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ITOKEN_STYLE_VALUE = 111;

	/**
	 * The '<em><b>OVERRIDE IURI MAPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IURI MAPPING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IURI_MAPPING
	 * @model literal="overrideIURIMapping"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IURI_MAPPING_VALUE = 112;

	/**
	 * The '<em><b>OVERRIDE EPROBLEM TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE EPROBLEM TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EPROBLEM_TYPE
	 * @model name="OVERRIDE_E_PROBLEM_TYPE" literal="overrideEProblemType"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EPROBLEM_TYPE_VALUE = 113;

	/**
	 * The '<em><b>OVERRIDE CODE COMPLETION HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE CODE COMPLETION HELPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CODE_COMPLETION_HELPER
	 * @model literal="overrideCodeCompletionHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CODE_COMPLETION_HELPER_VALUE = 114;

	/**
	 * The '<em><b>OVERRIDE EXPECTED CS STRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE EXPECTED CS STRING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTED_CS_STRING
	 * @model literal="overrideExpectedCsString"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTED_CS_STRING_VALUE = 115;

	/**
	 * The '<em><b>OVERRIDE EXPECTED STRUCTURAL FEATURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE EXPECTED STRUCTURAL FEATURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTED_STRUCTURAL_FEATURE
	 * @model literal="overrideExpectedStructuralFeature"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTED_STRUCTURAL_FEATURE_VALUE = 116;

	/**
	 * The '<em><b>OVERRIDE CAST UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE CAST UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CAST_UTIL
	 * @model literal="overrideCastUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CAST_UTIL_VALUE = 117;

	/**
	 * The '<em><b>OVERRIDE COPIED ELIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE COPIED ELIST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COPIED_ELIST
	 * @model name="OVERRIDE_COPIED_E_LIST" literal="overrideCopiedEList"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COPIED_ELIST_VALUE = 118;

	/**
	 * The '<em><b>OVERRIDE COPIED EOBJECT INTERNAL ELIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE COPIED EOBJECT INTERNAL ELIST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST
	 * @model name="OVERRIDE_COPIED_E_OBJECT_INTERNAL_E_LIST" literal="overrideCopiedEObjectInternalEList"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COPIED_EOBJECT_INTERNAL_ELIST_VALUE = 119;

	/**
	 * The '<em><b>OVERRIDE ECLASS UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ECLASS UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ECLASS_UTIL
	 * @model name="OVERRIDE_E_CLASS_UTIL" literal="overrideEClassUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ECLASS_UTIL_VALUE = 120;

	/**
	 * The '<em><b>OVERRIDE EOBJECT UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE EOBJECT UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EOBJECT_UTIL
	 * @model name="OVERRIDE_E_OBJECT_UTIL" literal="overrideEObjectUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EOBJECT_UTIL_VALUE = 121;

	/**
	 * The '<em><b>OVERRIDE LIST UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE LIST UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LIST_UTIL
	 * @model literal="overrideListUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LIST_UTIL_VALUE = 122;

	/**
	 * The '<em><b>OVERRIDE MAP UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE MAP UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MAP_UTIL
	 * @model literal="overrideMapUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MAP_UTIL_VALUE = 123;

	/**
	 * The '<em><b>OVERRIDE MINIMAL MODEL HELPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE MINIMAL MODEL HELPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MINIMAL_MODEL_HELPER
	 * @model literal="overrideMinimalModelHelper"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_MINIMAL_MODEL_HELPER_VALUE = 124;

	/**
	 * The '<em><b>OVERRIDE RESOURCE UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE RESOURCE UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_UTIL
	 * @model literal="overrideResourceUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RESOURCE_UTIL_VALUE = 125;

	/**
	 * The '<em><b>OVERRIDE STREAM UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE STREAM UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_STREAM_UTIL
	 * @model literal="overrideStreamUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_STREAM_UTIL_VALUE = 126;

	/**
	 * The '<em><b>OVERRIDE STRING UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE STRING UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_STRING_UTIL
	 * @model literal="overrideStringUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_STRING_UTIL_VALUE = 127;

	/**
	 * The '<em><b>OVERRIDE TEXT RESOURCE UTIL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TEXT RESOURCE UTIL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_RESOURCE_UTIL
	 * @model literal="overrideTextResourceUtil"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TEXT_RESOURCE_UTIL_VALUE = 128;

	/**
	 * The '<em><b>OVERRIDE UNICODE CONVERTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE UNICODE CONVERTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UNICODE_CONVERTER
	 * @model literal="overrideUnicodeConverter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UNICODE_CONVERTER_VALUE = 129;

	/**
	 * The '<em><b>OVERRIDE ABSTRACT EXPECTED ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ABSTRACT EXPECTED ELEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ABSTRACT_EXPECTED_ELEMENT
	 * @model literal="overrideAbstractExpectedElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ABSTRACT_EXPECTED_ELEMENT_VALUE = 130;

	/**
	 * The '<em><b>OVERRIDE NEW FILE WIZARD PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE NEW FILE WIZARD PAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_FILE_WIZARD_PAGE
	 * @model literal="overrideNewFileWizardPage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NEW_FILE_WIZARD_PAGE_VALUE = 131;

	/**
	 * The '<em><b>OVERRIDE IBACKGROUND PARSING LISTENER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IBACKGROUND PARSING LISTENER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IBACKGROUND_PARSING_LISTENER
	 * @model name="OVERRIDE_I_BACKGROUND_PARSING_LISTENER" literal="overrideIBackgroundParsingListener"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IBACKGROUND_PARSING_LISTENER_VALUE = 132;

	/**
	 * The '<em><b>OVERRIDE TERMINATE PARSING EXCEPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TERMINATE PARSING EXCEPTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TERMINATE_PARSING_EXCEPTION
	 * @model literal="overrideTerminateParsingException"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TERMINATE_PARSING_EXCEPTION_VALUE = 133;

	/**
	 * The '<em><b>OVERRIDE UNEXPECTED CONTENT TYPE EXCEPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE UNEXPECTED CONTENT TYPE EXCEPTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION
	 * @model literal="overrideUnexpectedContentTypeException"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UNEXPECTED_CONTENT_TYPE_EXCEPTION_VALUE = 134;

	/**
	 * The '<em><b>OVERRIDE TEXT TOKEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TEXT TOKEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_TOKEN
	 * @model literal="overrideTextToken"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TEXT_TOKEN_VALUE = 135;

	/**
	 * The '<em><b>SOURCE GEN FOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOURCE GEN FOLDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOURCE_GEN_FOLDER
	 * @model literal="srcGenFolder"
	 * @generated
	 * @ordered
	 */
	public static final int SOURCE_GEN_FOLDER_VALUE = 136;

	/**
	 * The '<em><b>OVERRIDE DEFAULT LOAD OPTIONS EXTENSION POINT SCHEMA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DEFAULT LOAD OPTIONS EXTENSION POINT SCHEMA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA
	 * @model literal="overrideDefaultLoadOptionsExtensionPointSchema"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_LOAD_OPTIONS_EXTENSION_POINT_SCHEMA_VALUE = 137;

	/**
	 * The '<em><b>OVERRIDE ADDITIONAL EXTENSION PARSER EXTENSION POINT SCHEMA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ADDITIONAL EXTENSION PARSER EXTENSION POINT SCHEMA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA
	 * @model literal="overrideAdditionalExtensionParserExtensionPointSchema"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ADDITIONAL_EXTENSION_PARSER_EXTENSION_POINT_SCHEMA_VALUE = 138;

	/**
	 * The '<em><b>OVERRIDE RESOURCE FACTORY DELEGATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE RESOURCE FACTORY DELEGATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_FACTORY_DELEGATOR
	 * @model literal="overrideResourceFactoryDelegator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_RESOURCE_FACTORY_DELEGATOR_VALUE = 139;

	/**
	 * The '<em><b>BASE RESOURCE PLUGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BASE RESOURCE PLUGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BASE_RESOURCE_PLUGIN
	 * @model literal="baseResourcePlugin"
	 * @generated
	 * @ordered
	 */
	public static final int BASE_RESOURCE_PLUGIN_VALUE = 140;

	/**
	 * The '<em><b>OVERRIDE PREFERENCE PAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PREFERENCE PAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PREFERENCE_PAGE
	 * @model literal="overridePreferencePage"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PREFERENCE_PAGE_VALUE = 141;

	/**
	 * The '<em><b>ANTLR PLUGIN ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANTLR PLUGIN ID</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANTLR_PLUGIN_ID
	 * @model literal="antlrPluginID"
	 * @generated
	 * @ordered
	 */
	public static final int ANTLR_PLUGIN_ID_VALUE = 142;

	/**
	 * The '<em><b>OVERRIDE ANTLR PLUGIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ANTLR PLUGIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANTLR_PLUGIN
	 * @model literal="overrideAntlrPlugin"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ANTLR_PLUGIN_VALUE = 143;

	/**
	 * The '<em><b>OVERRIDE TOKEN STYLE INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TOKEN STYLE INFORMATION PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER
	 * @model literal="overrideTokenStyleInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TOKEN_STYLE_INFORMATION_PROVIDER_VALUE = 144;

	/**
	 * The '<em><b>OVERRIDE FOLDING INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE FOLDING INFORMATION PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FOLDING_INFORMATION_PROVIDER
	 * @model literal="overrideFoldingInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_FOLDING_INFORMATION_PROVIDER_VALUE = 145;

	/**
	 * The '<em><b>OVERRIDE BRACKET INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE BRACKET INFORMATION PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BRACKET_INFORMATION_PROVIDER
	 * @model literal="overrideBracketInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BRACKET_INFORMATION_PROVIDER_VALUE = 146;

	/**
	 * The '<em><b>OVERRIDE SYNTAX COVERAGE INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE SYNTAX COVERAGE INFORMATION PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER
	 * @model literal="overrideSyntaxCoverageInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_COVERAGE_INFORMATION_PROVIDER_VALUE = 147;

	/**
	 * The '<em><b>SAVE CHANGED RESOURCES ONLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAVE CHANGED RESOURCES ONLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAVE_CHANGED_RESOURCES_ONLY
	 * @model literal="saveChangedResourcesOnly"
	 * @generated
	 * @ordered
	 */
	public static final int SAVE_CHANGED_RESOURCES_ONLY_VALUE = 148;

	/**
	 * The '<em><b>OVERRIDE NEW FILE CONTENT PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE NEW FILE CONTENT PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_FILE_CONTENT_PROVIDER
	 * @model literal="overrideNewFileContentProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NEW_FILE_CONTENT_PROVIDER_VALUE = 149;

	/**
	 * The '<em><b>LICENCE HEADER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LICENCE HEADER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LICENCE_HEADER
	 * @model literal="licenceHeader"
	 * @generated
	 * @ordered
	 */
	public static final int LICENCE_HEADER_VALUE = 150;

	/**
	 * The '<em><b>OVERRIDE EXPECTED TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE EXPECTED TERMINAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EXPECTED_TERMINAL
	 * @model literal="overrideExpectedTerminal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_EXPECTED_TERMINAL_VALUE = 151;

	/**
	 * The '<em><b>OVERRIDE COMPLETION PROPOSAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE COMPLETION PROPOSAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COMPLETION_PROPOSAL
	 * @model literal="overrideCompletionProposal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COMPLETION_PROPOSAL_VALUE = 152;

	/**
	 * The '<em><b>OVERRIDE BUILDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE BUILDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BUILDER
	 * @model literal="overrideBuilder"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BUILDER_VALUE = 153;

	/**
	 * The '<em><b>OVERRIDE BUILDER ADAPTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE BUILDER ADAPTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BUILDER_ADAPTER
	 * @model literal="overrideBuilderAdapter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_BUILDER_ADAPTER_VALUE = 154;

	/**
	 * The '<em><b>OVERRIDE IBUILDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IBUILDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IBUILDER
	 * @model name="OVERRIDE_I_BUILDER" literal="overrideIBuilder"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IBUILDER_VALUE = 155;

	/**
	 * The '<em><b>OVERRIDE NATURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE NATURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NATURE
	 * @model literal="overrideNature"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_NATURE_VALUE = 156;

	/**
	 * The '<em><b>ADDITIONAL DEPENDENCIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADDITIONAL DEPENDENCIES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_DEPENDENCIES
	 * @model literal="additionalDependencies"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_DEPENDENCIES_VALUE = 157;

	/**
	 * The '<em><b>DISABLE BUILDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISABLE BUILDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISABLE_BUILDER
	 * @model literal="disableBuilder"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_BUILDER_VALUE = 158;

	/**
	 * The '<em><b>ADDITIONAL EXPORTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADDITIONAL EXPORTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_EXPORTS
	 * @model literal="additionalExports"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_EXPORTS_VALUE = 159;

	/**
	 * The '<em><b>OVERRIDE PAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PAIR
	 * @model literal="overridePair"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PAIR_VALUE = 160;

	/**
	 * The '<em><b>OVERRIDE ABSTRACT INTERPRETER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ABSTRACT INTERPRETER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ABSTRACT_INTERPRETER
	 * @model literal="overrideAbstractInterpreter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ABSTRACT_INTERPRETER_VALUE = 161;

	/**
	 * The '<em><b>OVERRIDE GRAMMAR INFORMATION PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE GRAMMAR INFORMATION PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_GRAMMAR_INFORMATION_PROVIDER
	 * @model literal="overrideGrammarInformationProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_GRAMMAR_INFORMATION_PROVIDER_VALUE = 162;

	/**
	 * The '<em><b>OVERRIDE ATTRIBUTE VALUE PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ATTRIBUTE VALUE PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ATTRIBUTE_VALUE_PROVIDER
	 * @model literal="overrideAttributeValueProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ATTRIBUTE_VALUE_PROVIDER_VALUE = 163;

	/**
	 * The '<em><b>OVERRIDE FOLLOW SET PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE FOLLOW SET PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FOLLOW_SET_PROVIDER
	 * @model literal="overrideFollowSetProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_FOLLOW_SET_PROVIDER_VALUE = 164;

	/**
	 * The '<em><b>OVERRIDE SYNTAX ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE SYNTAX ELEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_ELEMENT
	 * @model literal="overrideSyntaxElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_ELEMENT_VALUE = 165;

	/**
	 * The '<em><b>OVERRIDE KEYWORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE KEYWORD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_KEYWORD
	 * @model literal="overrideKeyword"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_KEYWORD_VALUE = 166;

	/**
	 * The '<em><b>OVERRIDE PLACEHOLDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PLACEHOLDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLACEHOLDER
	 * @model literal="overridePlaceholder"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PLACEHOLDER_VALUE = 167;

	/**
	 * The '<em><b>OVERRIDE CARDINALITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE CARDINALITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CARDINALITY
	 * @model literal="overrideCardinality"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CARDINALITY_VALUE = 168;

	/**
	 * The '<em><b>OVERRIDE PRINTER2</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PRINTER2</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PRINTER2
	 * @model literal="overridePrinter2"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PRINTER2_VALUE = 169;

	/**
	 * The '<em><b>OVERRIDE CHOICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE CHOICE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CHOICE
	 * @model literal="overrideChoice"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CHOICE_VALUE = 170;

	/**
	 * The '<em><b>OVERRIDE COMPOUND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE COMPOUND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COMPOUND
	 * @model literal="overrideCompound"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_COMPOUND_VALUE = 171;

	/**
	 * The '<em><b>OVERRIDE CONTAINMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE CONTAINMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTAINMENT
	 * @model literal="overrideContainment"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_CONTAINMENT_VALUE = 172;

	/**
	 * The '<em><b>OVERRIDE LINE BREAK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE LINE BREAK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LINE_BREAK
	 * @model literal="overrideLineBreak"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LINE_BREAK_VALUE = 173;

	/**
	 * The '<em><b>OVERRIDE SEQUENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE SEQUENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SEQUENCE
	 * @model literal="overrideSequence"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SEQUENCE_VALUE = 174;

	/**
	 * The '<em><b>OVERRIDE WHITE SPACE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE WHITE SPACE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_WHITE_SPACE
	 * @model literal="overrideWhiteSpace"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_WHITE_SPACE_VALUE = 175;

	/**
	 * The '<em><b>OVERRIDE SYNTAX ELEMENT DECORATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE SYNTAX ELEMENT DECORATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SYNTAX_ELEMENT_DECORATOR
	 * @model literal="overrideSyntaxElementDecorator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_SYNTAX_ELEMENT_DECORATOR_VALUE = 176;

	/**
	 * The '<em><b>OVERRIDE IREFERENCE CACHE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE IREFERENCE CACHE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_IREFERENCE_CACHE
	 * @model literal="overrideIReferenceCache"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_IREFERENCE_CACHE_VALUE = 177;

	/**
	 * The '<em><b>OVERRIDE DEFAULT HOVER TEXT PROVIDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE DEFAULT HOVER TEXT PROVIDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER
	 * @model literal="overrideDefaultHoverTextProvider"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_DEFAULT_HOVER_TEXT_PROVIDER_VALUE = 178;

	/**
	 * The '<em><b>OVERRIDE FORMATTING ELEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE FORMATTING ELEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FORMATTING_ELEMENT
	 * @model literal="overrideFormattingElement"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_FORMATTING_ELEMENT_VALUE = 179;

	/**
	 * The '<em><b>OVERRIDE TERMINAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE TERMINAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TERMINAL
	 * @model literal="overrideTerminal"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_TERMINAL_VALUE = 180;

	/**
	 * The '<em><b>OVERRIDE LAYOUT INFORMATION ADAPTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE LAYOUT INFORMATION ADAPTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAYOUT_INFORMATION_ADAPTER
	 * @model literal="overrideLayoutInformationAdapter"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAYOUT_INFORMATION_ADAPTER_VALUE = 181;

	/**
	 * The '<em><b>OVERRIDE LAYOUT INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE LAYOUT INFORMATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LAYOUT_INFORMATION
	 * @model literal="overrideLayoutInformation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_LAYOUT_INFORMATION_VALUE = 182;

	/**
	 * The '<em><b>USE CLASSIC PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USE CLASSIC PRINTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USE_CLASSIC_PRINTER
	 * @model literal="useClassicPrinter"
	 * @generated
	 * @ordered
	 */
	public static final int USE_CLASSIC_PRINTER_VALUE = 183;

	/**
	 * The '<em><b>DISABLE EVALIDATORS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISABLE EVALIDATORS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISABLE_EVALIDATORS
	 * @model name="DISABLE_E_VALIDATORS" literal="disableEValidators"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_EVALIDATORS_VALUE = 184;

	/**
	 * The '<em><b>DISABLE EMF VALIDATION CONSTRAINTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISABLE EMF VALIDATION CONSTRAINTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISABLE_EMF_VALIDATION_CONSTRAINTS
	 * @model literal="disableEMFValidationConstraints"
	 * @generated
	 * @ordered
	 */
	public static final int DISABLE_EMF_VALIDATION_CONSTRAINTS_VALUE = 185;

	/**
	 * The '<em><b>OVERRIDE UI META INFORMATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE UI META INFORMATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_META_INFORMATION
	 * @model literal="overrideUIMetaInformation"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_META_INFORMATION_VALUE = 186;

	/**
	 * The '<em><b>RESOURCE UI PLUGIN ID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESOURCE UI PLUGIN ID</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_UI_PLUGIN_ID
	 * @model literal="resourceUIPluginID"
	 * @generated
	 * @ordered
	 */
	public static final int RESOURCE_UI_PLUGIN_ID_VALUE = 187;

	/**
	 * The '<em><b>OVERRIDE UI PLUGIN ACTIVATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE UI PLUGIN ACTIVATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_PLUGIN_ACTIVATOR
	 * @model literal="overrideUIPluginActivator"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_PLUGIN_ACTIVATOR_VALUE = 188;

	/**
	 * The '<em><b>UI BASE PACKAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UI BASE PACKAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UI_BASE_PACKAGE
	 * @model literal="uiBasePackage"
	 * @generated
	 * @ordered
	 */
	public static final int UI_BASE_PACKAGE_VALUE = 189;

	/**
	 * The '<em><b>ADDITIONAL UI DEPENDENCIES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADDITIONAL UI DEPENDENCIES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_UI_DEPENDENCIES
	 * @model literal="additionalUIDependencies"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_UI_DEPENDENCIES_VALUE = 190;

	/**
	 * The '<em><b>ADDITIONAL UI EXPORTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADDITIONAL UI EXPORTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADDITIONAL_UI_EXPORTS
	 * @model literal="additionalUIExports"
	 * @generated
	 * @ordered
	 */
	public static final int ADDITIONAL_UI_EXPORTS_VALUE = 191;

	/**
	 * The '<em><b>OVERRIDE UI MANIFEST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE UI MANIFEST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_UI_MANIFEST
	 * @model literal="overrideUIManifest"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_UI_MANIFEST_VALUE = 192;

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
			OVERRIDE_OCCURENCE,
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
			OVERRIDE_OCCURENCE_PREFERENCE_PAGE,
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
			case OVERRIDE_OCCURENCE_VALUE: return OVERRIDE_OCCURENCE;
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
			case OVERRIDE_OCCURENCE_PREFERENCE_PAGE_VALUE: return OVERRIDE_OCCURENCE_PREFERENCE_PAGE;
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
