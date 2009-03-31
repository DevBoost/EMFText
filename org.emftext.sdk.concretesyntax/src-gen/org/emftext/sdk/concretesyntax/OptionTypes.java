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
	 * The '<em><b>OVERRIDE ANTLR SPEC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * If this option is set to true, the ANTLR grammar will be overridden during code
	 * generation. The default value for this option is <code>true</code>. 
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANTLR_SPEC_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_ANTLR_SPEC(5, "OVERRIDE_ANTLR_SPEC", "overrideAntlrSpecification"),

	/**
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
	RELOAD_GENERATOR_MODEL(19, "RELOAD_GENERATOR_MODEL", "reloadGeneratorModel"), /**
	 * The '<em><b>OVERRIDE DOT CLASSPATH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOT_CLASSPATH_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DOT_CLASSPATH(20, "OVERRIDE_DOT_CLASSPATH", "overrideClasspath"), /**
	 * The '<em><b>OVERRIDE DOT PROJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_DOT_PROJECT_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_DOT_PROJECT(21, "OVERRIDE_DOT_PROJECT", "overrideProjectFile"), /**
	 * The '<em><b>OVERRIDE TEXT RESOURCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_TEXT_RESOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_TEXT_RESOURCE(22, "OVERRIDE_TEXT_RESOURCE", "overrideTextResource"), /**
	 * The '<em><b>OVERRIDE RESOURCE FACTORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_RESOURCE_FACTORY_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_RESOURCE_FACTORY(23, "OVERRIDE_RESOURCE_FACTORY", "overrideResourceFactory"), /**
	 * The '<em><b>OVERRIDE NEW FILE WIZARD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_NEW_FILE_WIZARD_VALUE
	 * @generated
	 * @ordered
	 */
	OVERRIDE_NEW_FILE_WIZARD(23, "OVERRIDE_NEW_FILE_WIZARD", "overrideNewFileWizard");

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
	 * The '<em><b>OVERRIDE ANTLR SPEC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OVERRIDE ANTLR SPEC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERRIDE_ANTLR_SPEC
	 * @model literal="overrideAntlrSpecification"
	 * @generated
	 * @ordered
	 */
	public static final int OVERRIDE_ANTLR_SPEC_VALUE = 5;

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
	public static final int OVERRIDE_NEW_FILE_WIZARD_VALUE = 23;

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
			OVERRIDE_ANTLR_SPEC,
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
			case OVERRIDE_ANTLR_SPEC_VALUE: return OVERRIDE_ANTLR_SPEC;
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
