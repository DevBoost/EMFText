/**
 * <copyright>
 * </copyright>
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
 * An enumeration of all options that are available to parameterize
 * the code generation process.
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOptionTypes()
 * @model
 * @generated
 */
public enum OptionTypes implements Enumerator {
	/**
	 * The '<em><b>GENERATE TEST ACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, EMFText generate a UI action that 
	 * can be used to test parsing and printing of files containing 
	 * textual syntax. The default value of this option is <code>false</code>.
	 * <!-- end-user-doc -->
	 * @see #GENERATE_TEST_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	GENERATE_TEST_ACTION(0, "GENERATE_TEST_ACTION", "generateTestAction"),

	/**
	 * The '<em><b>GENERATE CODE FROM GENERATOR MODEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, EMFText automatically generates the
	 * model code using the generator model referenced in the CS specification.
	 * The default value of this option is <code>false</code>. 
	 * <!-- end-user-doc -->
	 * @see #GENERATE_CODE_FROM_GENERATOR_MODEL_VALUE
	 * @generated
	 * @ordered
	 */
	GENERATE_CODE_FROM_GENERATOR_MODEL(1, "GENERATE_CODE_FROM_GENERATOR_MODEL", "generateCodeFromGeneratorModel"),

	/**
	 * The '<em><b>GENERATE PRINTER STUB ONLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, an empty printer class is generated. This class can be
	 * subject to manual implementation. Otherwise, a printer and
	 * a base class containing a default printer implementation are generated.
	 * The default value for this option is <code>false</code>. 
	 * <!-- end-user-doc -->
	 * @see #GENERATE_PRINTER_STUB_ONLY_VALUE
	 * @generated
	 * @ordered
	 */
	GENERATE_PRINTER_STUB_ONLY(2, "GENERATE_PRINTER_STUB_ONLY", "generatePrinterStubOnly"),

	/**
	 * The '<em><b>OVERRIDE PLUGIN XML</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the plugin.xml file will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLUGIN_XML_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PLUGIN_XML(3, "OVERRIDE_PLUGIN_XML", "overridePluginXML"),

	/**
	 * The '<em><b>OVERRIDE MANIFEST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the manifest of the generated plug-in will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
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
	OVERRIDE_PARSER(5, "OVERRIDE_PARSER", "overrideParser"), /**
	 * The '<em><b>OVERRIDE TOKEN RESOLVERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the token resolver classes will be overridden during code
	 * generation. The default value for this option is <code>false</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVERS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_RESOLVERS(6, "OVERRIDE_TOKEN_RESOLVERS", "overrideTokenResolvers"),

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVERS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the reference resolver classes will be overridden during code
	 * generation. The default value for this option is <code>false</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVERS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_REFERENCE_RESOLVERS(7, "OVERRIDE_REFERENCE_RESOLVERS", "overrideReferenceResolvers"),

	/**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVER SWITCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the reference resolver switch will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVER_SWITCH_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_REFERENCE_RESOLVER_SWITCH(8, "OVERRIDE_REFERENCE_RESOLVER_SWITCH", "overrideReferenceResolverSwitch"),

	/**
	 * The '<em><b>OVERRIDE TOKEN RESOLVER FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the token resolver factory class will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVER_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_RESOLVER_FACTORY(9, "OVERRIDE_TOKEN_RESOLVER_FACTORY", "overrideTokenResolverFactory"),

	/**
	 * The '<em><b>OVERRIDE PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the printer will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PRINTER(10, "OVERRIDE_PRINTER", "overridePrinter"),

	/**
	 * The '<em><b>OVERRIDE PRINTER BASE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the printer base class will be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PRINTER_BASE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PRINTER_BASE(11, "OVERRIDE_PRINTER_BASE", "overridePrinterBase"),

	/**
	 * The '<em><b>ANTLR BACKTRACKING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the Antlr-backtracking is activated for
	 * parser generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #ANTLR_BACKTRACKING_VALUE
	 * @generated
	 * @ordered
	 */
	ANTLR_BACKTRACKING(12, "ANTLR_BACKTRACKING", "backtracking"),

	/**
	 * The '<em><b>ANTLR MEMOIZE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the Antlr-memoize is activated for
	 * parser generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #ANTLR_MEMOIZE_VALUE
	 * @generated
	 * @ordered
	 */
	ANTLR_MEMOIZE(13, "ANTLR_MEMOIZE", "memoize"),

	/**
	 * The '<em><b>AUTOFIX SIMPLE LEFTRECURSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, EMFText will try to resolve rules that
	 * contain simple left recursion. The default value for this option
	 * is <code>false</code>. 
	 * <!-- end-user-doc -->
	 * @see #AUTOFIX_SIMPLE_LEFTRECURSION_VALUE
	 * @generated
	 * @ordered
	 */
	AUTOFIX_SIMPLE_LEFTRECURSION(14, "AUTOFIX_SIMPLE_LEFTRECURSION", "autofixSimpleLeftrecursion"),

	/**
	 * The '<em><b>FORCE EOF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, EMFText will generate a parser that expects
	 * an EOF signal at the end of the input stream. The default value for this option
	 * is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #FORCE_EOF_VALUE
	 * @generated
	 * @ordered
	 */
	FORCE_EOF(15, "FORCE_EOF", "forceEOF"),

	/**
	 * The '<em><b>DEFAULT TOKEN NAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * This option can be used to specify the name of the token that is used for
	 * non-containment references. A declaration like <code>featureX[]</code> in
	 * a CS rule with be replaced by <code>featureX[TOKEN_Y]</code> if the
	 * value of this option is <code>TOKEN_Y</code>.
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_TOKEN_NAME_VALUE
	 * @generated
	 * @ordered
	 */
	DEFAULT_TOKEN_NAME(16, "DEFAULT_TOKEN_NAME", "defaultTokenName"),

	/**
	 * The '<em><b>USE PREDEFINED TOKENS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to false, EMFText does not automatically provide 
	 * predefined tokens (TEXT, WS, ...). The default value of this option is
	 * <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #USE_PREDEFINED_TOKENS_VALUE
	 * @generated
	 * @ordered
	 */
	USE_PREDEFINED_TOKENS(17, "USE_PREDEFINED_TOKENS", "usePredefinedTokens"),

	/**
	 * The '<em><b>TOKENSPACE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * The (numerical) value of this option defined how many whitespace should 
	 * be printed between tokens if no whitespace information is given in CS
	 * rules. The default value for this option is 0.
	 * <!-- end-user-doc -->
	 * @see #TOKENSPACE_VALUE
	 * @generated
	 * @ordered
	 */
	TOKENSPACE(18, "TOKENSPACE", "tokenspace"),

	/**
	 * The '<em><b>RELOAD GENERATOR MODEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, EMFText reloads the generator model
	 * before loading it. This is particular useful, when the meta model
	 * (i.e., the Ecore file) is changing a lot during language development.
	 * The default value of this option is <code>false</code>. 
	 * <!-- end-user-doc -->
	 * @see #RELOAD_GENERATOR_MODEL_VALUE
	 * @generated
	 * @ordered
	 */
	RELOAD_GENERATOR_MODEL(19, "RELOAD_GENERATOR_MODEL", "reloadGeneratorModel"), 
	
	/**
	 * The '<em><b>OVERRIDE DOT CLASSPATH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to false, the .classpath file will not be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOT_CLASSPATH_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DOT_CLASSPATH(20, "OVERRIDE_DOT_CLASSPATH", "overrideClasspath"), 
	
	/**
	 * The '<em><b>OVERRIDE DOT PROJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to false, the .project file will not be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOT_PROJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DOT_PROJECT(21, "OVERRIDE_DOT_PROJECT", "overrideProjectFile"), 
	
	/**
	 * The '<em><b>OVERRIDE TEXT RESOURCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to false, the text resource class will not be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_RESOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TEXT_RESOURCE(22, "OVERRIDE_TEXT_RESOURCE", "overrideTextResource"), 
	
	/**
	 * The '<em><b>OVERRIDE RESOURCE FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to false, the resource factory class will not be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_RESOURCE_FACTORY(23, "OVERRIDE_RESOURCE_FACTORY", "overrideResourceFactory"), 
	
	/**
	 * The '<em><b>OVERRIDE NEW FILE WIZARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to false, the new file wizard class will not be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_FILE_WIZARD_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_NEW_FILE_WIZARD(24, "OVERRIDE_NEW_FILE_WIZARD", "overrideNewFileWizard"), /**
	 * The '<em><b>PARSER GENERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * The name of the parser generator to use. The default value for this
	 * option is ANTLR.
	 * <!-- end-user-doc -->
	 * @see #PARSER_GENERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	PARSER_GENERATOR(25, "PARSER_GENERATOR", "parserGenerator"), /**
	 * The '<em><b>SOURCE FOLDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * The name of the folder EMFText shall store the generated classes in.
	 * The default value for this option is 'src'.
	 * <!-- end-user-doc -->
	 * @see #SOURCE_FOLDER_VALUE
	 * @generated
	 * @ordered
	 */
	SOURCE_FOLDER(26, "SOURCE_FOLDER", "srcFolder"), /**
	 * The '<em><b>BASE PACKAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * The name of the base package EMFText shall store the generated 
	 * classes in.
	 * <!-- end-user-doc -->
	 * @see #BASE_PACKAGE_VALUE
	 * @generated
	 * @ordered
	 */
	BASE_PACKAGE(27, "BASE_PACKAGE", "basePackage"), /**
	 * The '<em><b>RESOURCE PLUGIN ID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * The ID of the generated resource plug-in. The resource 
	 * plug-in is stored in a folder that is equal to this ID.
	 * <!-- end-user-doc -->
	 * @see #RESOURCE_PLUGIN_ID_VALUE
	 * @generated
	 * @ordered
	 */
	RESOURCE_PLUGIN_ID(28, "RESOURCE_PLUGIN_ID", "resourcePluginID"), /**
	 * The '<em><b>OVERRIDE BUILD PROPERTIES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to false, the build.properties file will not be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BUILD_PROPERTIES_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BUILD_PROPERTIES(29, "OVERRIDE_BUILD_PROPERTIES", "overrideBuildProperties"), /**
	 * The '<em><b>OVERRIDE PLUGIN META INFORMATION CLASS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to false, the meta information class will not be overridden 
	 * during code generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLUGIN_META_INFORMATION_CLASS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PLUGIN_META_INFORMATION_CLASS(30, "OVERRIDE_PLUGIN_META_INFORMATION_CLASS", "overridePluginMetaInformationClass"), /**
	 * The '<em><b>OVERRIDE DEFAULT RESOLVER DELEGATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the default resolver class will be overridden 
	 * during code generation. The default value for this option is <code>false</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_RESOLVER_DELEGATE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEFAULT_RESOLVER_DELEGATE(31, "OVERRIDE_DEFAULT_RESOLVER_DELEGATE", "overrideDefaultResolverDelegate"), /**
	 * The '<em><b>OVERRIDE PROBLEM CLASS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PROBLEM_CLASS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PROBLEM_CLASS(32, "OVERRIDE_PROBLEM_CLASS", "overrideProblemClass"), /**
	 * The '<em><b>OVERRIDE SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_SCANNER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_SCANNER(33, "OVERRIDE_SCANNER", "overrideScanner"), /**
	 * The '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT(34, "OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT", "overrideContextDependentURIFragment"), /**
	 * The '<em><b>OVERRIDE CONTEXT DEPENDENT URI FRAGMENT FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY(35, "OVERRIDE_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY", "overrideContextDependentURIFragmentFactory"), /**
	 * The '<em><b>OVERRIDE DELEGATING RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DELEGATING_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DELEGATING_RESOLVE_RESULT(36, "OVERRIDE_DELEGATING_RESOLVE_RESULT", "overrideDelegatingResolveResult"), /**
	 * The '<em><b>OVERRIDE DUMMY EOBJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DUMMY_EOBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DUMMY_EOBJECT(37, "OVERRIDE_DUMMY_E_OBJECT", "overrideDummyEObject"), /**
	 * The '<em><b>OVERRIDE ELEMENT MAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ELEMENT_MAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ELEMENT_MAPPING(38, "OVERRIDE_ELEMENT_MAPPING", "overrideElementMapping"), /**
	 * The '<em><b>OVERRIDE FUZZY RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_FUZZY_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_FUZZY_RESOLVE_RESULT(39, "OVERRIDE_FUZZY_RESOLVE_RESULT", "overrideFuzzyResolveResult"), /**
	 * The '<em><b>OVERRIDE DEFAULT TOKEN RESOLVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DEFAULT_TOKEN_RESOLVER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DEFAULT_TOKEN_RESOLVER(40, "OVERRIDE_DEFAULT_TOKEN_RESOLVER", "overrideDefaultTokenResolver"), /**
	 * The '<em><b>OVERRIDE LOCATION MAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_LOCATION_MAP_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_LOCATION_MAP(41, "OVERRIDE_LOCATION_MAP", "overrideLocationMap"), /**
	 * The '<em><b>OVERRIDE REFERENCE RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_REFERENCE_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_REFERENCE_RESOLVE_RESULT(42, "OVERRIDE_REFERENCE_RESOLVE_RESULT", "overrideReferenceResolveResult"), /**
	 * The '<em><b>OVERRIDE TOKEN RESOLVE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_RESOLVE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_RESOLVE_RESULT(43, "OVERRIDE_TOKEN_RESOLVE_RESULT", "overrideTokenResolveResult"), /**
	 * The '<em><b>OVERRIDE URI MAPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_URI_MAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_URI_MAPPING(45, "OVERRIDE_URI_MAPPING", "overrideURIMapping"), /**
	 * The '<em><b>OVERRIDE HOVER TEXT PROVIDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HOVER_TEXT_PROVIDER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HOVER_TEXT_PROVIDER(46, "OVERRIDE_HOVER_TEXT_PROVIDER", "overrideHoverTextProvider"), /**
	 * The '<em><b>OVERRIDE PARSE RESULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PARSE_RESULT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PARSE_RESULT(47, "OVERRIDE_PARSE_RESULT", "overrideParseResult"), /**
	 * The '<em><b>OVERRIDE ANTLR TOKEN HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANTLR_TOKEN_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ANTLR_TOKEN_HELPER(48, "OVERRIDE_ANTLR_TOKEN_HELPER", "overrideAntlrTokenHelper"), /**
	 * The '<em><b>OVERRIDE BRACKET SET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BRACKET_SET_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BRACKET_SET(49, "OVERRIDE_BRACKET_SET", "overrideBracketSet"), /**
	 * The '<em><b>OVERRIDE BROWSER INFORMATION CONTROL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BROWSER_INFORMATION_CONTROL_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BROWSER_INFORMATION_CONTROL(50, "OVERRIDE_BROWSER_INFORMATION_CONTROL", "overrideBrowserInformationControl"), /**
	 * The '<em><b>OVERRIDE CODE FOLDING MANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_CODE_FOLDING_MANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_CODE_FOLDING_MANAGER(51, "OVERRIDE_CODE_FOLDING_MANAGER", "overrideCodeFoldingManager"), /**
	 * The '<em><b>OVERRIDE COLOR MANAGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COLOR_MANAGER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COLOR_MANAGER(52, "OVERRIDE_COLOR_MANAGER", "overrideColorManager"), /**
	 * The '<em><b>OVERRIDE COMPLETION PROCESSOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_COMPLETION_PROCESSOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_COMPLETION_PROCESSOR(53, "OVERRIDE_COMPLETION_PROCESSOR", "overrideCompletionProcessor"), /**
	 * The '<em><b>OVERRIDE PARSING STRATEGY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PARSING_STRATEGY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PARSING_STRATEGY(54, "OVERRIDE_PARSING_STRATEGY", "overrideParsingStrategy"), /**
	 * The '<em><b>OVERRIDE DOC BROWSER INFORMATION CONTROL INPUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT(55, "OVERRIDE_DOC_BROWSER_INFORMATION_CONTROL_INPUT", "overrideDocBrowserInformationControlInput"), /**
	 * The '<em><b>OVERRIDE EDITOR CONFIGURATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EDITOR_CONFIGURATION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EDITOR_CONFIGURATION(55, "OVERRIDE_EDITOR_CONFIGURATION", "overrideEditorConfiguration"), /**
	 * The '<em><b>OVERRIDE EDITOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EDITOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EDITOR(56, "OVERRIDE_EDITOR", "overrideEditor"), /**
	 * The '<em><b>OVERRIDE EOBJECT SELECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_EOBJECT_SELECTION_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_EOBJECT_SELECTION(57, "OVERRIDE_E_OBJECT_SELECTION", "overrideEObjectSelection"), /**
	 * The '<em><b>OVERRIDE HIGHLIGHTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HIGHLIGHTING_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HIGHLIGHTING(58, "OVERRIDE_HIGHLIGHTING", "overrideHighlighting"), /**
	 * The '<em><b>OVERRIDE HTML PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HTML_PRINTER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HTML_PRINTER(59, "OVERRIDE_HTML_PRINTER", "overrideHTMLPrinter"), /**
	 * The '<em><b>OVERRIDE HYPERLINK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HYPERLINK_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HYPERLINK(60, "OVERRIDE_HYPERLINK", "overrideHyperlink"), /**
	 * The '<em><b>OVERRIDE HYPERLINK DETECTOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_HYPERLINK_DETECTOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_HYPERLINK_DETECTOR(61, "OVERRIDE_HYPERLINK_DETECTOR", "overrideHyperlinkDetector"), /**
	 * The '<em><b>OVERRIDE MARKER HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_MARKER_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_MARKER_HELPER(62, "OVERRIDE_MARKER_HELPER", "overrideMarkerHelper"), /**
	 * The '<em><b>OVERRIDE OCCURENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OCCURENCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OCCURENCE(63, "OVERRIDE_OCCURENCE", "overrideOccurrence"), /**
	 * The '<em><b>OVERRIDE OUTLINE PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE(64, "OVERRIDE_OUTLINE_PAGE", "overrideOutlinePage"), /**
	 * The '<em><b>OVERRIDE OUTLINE PAGE TREE VIEWER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_OUTLINE_PAGE_TREE_VIEWER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_OUTLINE_PAGE_TREE_VIEWER(65, "OVERRIDE_OUTLINE_PAGE_TREE_VIEWER", "overrideOutlinePageTreeViewer"), /**
	 * The '<em><b>OVERRIDE PLUGIN ACTIVATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLUGIN_ACTIVATOR_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PLUGIN_ACTIVATOR(66, "OVERRIDE_PLUGIN_ACTIVATOR", "overridePluginActivator"), /**
	 * The '<em><b>OVERRIDE POSITION CATEGORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_POSITION_CATEGORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_POSITION_CATEGORY(67, "OVERRIDE_POSITION_CATEGORY", "overridePositionCategory"), /**
	 * The '<em><b>OVERRIDE POSITION HELPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_POSITION_HELPER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_POSITION_HELPER(68, "OVERRIDE_POSITION_HELPER", "overridePositionHelper"), /**
	 * The '<em><b>OVERRIDE PROPERTY SHEET PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PROPERTY_SHEET_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PROPERTY_SHEET_PAGE(69, "OVERRIDE_PROPERTY_SHEET_PAGE", "overridePropertySheetPage"), /**
	 * The '<em><b>OVERRIDE TEXT HOVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_HOVER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TEXT_HOVER(70, "OVERRIDE_TEXT_HOVER", "overrideTextHover"), /**
	 * The '<em><b>OVERRIDE TOKEN SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TOKEN_SCANNER_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TOKEN_SCANNER(71, "OVERRIDE_TOKEN_SCANNER", "overrideTokenScanner"), /**
	 * The '<em><b>OVERRIDE BRACKET PREFERENCE PAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_BRACKET_PREFERENCE_PAGE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_BRACKET_PREFERENCE_PAGE(72, "OVERRIDE_BRACKET_PREFERENCE_PAGE", "overrideBracketPreferencePage"), /**
	 * The '<em><b>OVERRIDE PREFERENCE CONSTANTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PREFERENCE_CONSTANTS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_PREFERENCE_CONSTANTS(73, "OVERRIDE_PREFERENCE_CONSTANTS", "overridePreferenceConstants");

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
	 * The '<em><b>GENERATE PRINTER STUB ONLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERATE PRINTER STUB ONLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERATE_PRINTER_STUB_ONLY
	 * @model literal="generatePrinterStubOnly"
	 * @generated
	 * @ordered
	 */
	public static final int GENERATE_PRINTER_STUB_ONLY_VALUE = 2;

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
	 * The '<em><b>OVERRIDE PRINTER BASE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PRINTER BASE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PRINTER_BASE
	 * @model literal="overridePrinterBase"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PRINTER_BASE_VALUE = 11;

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
	 * The '<em><b>OVERRIDE PLUGIN META INFORMATION CLASS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE PLUGIN META INFORMATION CLASS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_PLUGIN_META_INFORMATION_CLASS
	 * @model literal="overridePluginMetaInformationClass"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_PLUGIN_META_INFORMATION_CLASS_VALUE = 30;

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
	 * An array of all the '<em><b>Option Types</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final OptionTypes[] VALUES_ARRAY =
		new OptionTypes[] {
			GENERATE_TEST_ACTION,
			GENERATE_CODE_FROM_GENERATOR_MODEL,
			GENERATE_PRINTER_STUB_ONLY,
			OVERRIDE_PLUGIN_XML,
			OVERRIDE_MANIFEST,
			OVERRIDE_PARSER,
			OVERRIDE_TOKEN_RESOLVERS,
			OVERRIDE_REFERENCE_RESOLVERS,
			OVERRIDE_REFERENCE_RESOLVER_SWITCH,
			OVERRIDE_TOKEN_RESOLVER_FACTORY,
			OVERRIDE_PRINTER,
			OVERRIDE_PRINTER_BASE,
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
			OVERRIDE_PLUGIN_META_INFORMATION_CLASS,
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
			case GENERATE_PRINTER_STUB_ONLY_VALUE: return GENERATE_PRINTER_STUB_ONLY;
			case OVERRIDE_PLUGIN_XML_VALUE: return OVERRIDE_PLUGIN_XML;
			case OVERRIDE_MANIFEST_VALUE: return OVERRIDE_MANIFEST;
			case OVERRIDE_PARSER_VALUE: return OVERRIDE_PARSER;
			case OVERRIDE_TOKEN_RESOLVERS_VALUE: return OVERRIDE_TOKEN_RESOLVERS;
			case OVERRIDE_REFERENCE_RESOLVERS_VALUE: return OVERRIDE_REFERENCE_RESOLVERS;
			case OVERRIDE_REFERENCE_RESOLVER_SWITCH_VALUE: return OVERRIDE_REFERENCE_RESOLVER_SWITCH;
			case OVERRIDE_TOKEN_RESOLVER_FACTORY_VALUE: return OVERRIDE_TOKEN_RESOLVER_FACTORY;
			case OVERRIDE_PRINTER_VALUE: return OVERRIDE_PRINTER;
			case OVERRIDE_PRINTER_BASE_VALUE: return OVERRIDE_PRINTER_BASE;
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
			case OVERRIDE_PLUGIN_META_INFORMATION_CLASS_VALUE: return OVERRIDE_PLUGIN_META_INFORMATION_CLASS;
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
