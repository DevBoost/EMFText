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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxFactory
 * @model kind="package"
 * @generated
 */
public interface ConcretesyntaxPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "concretesyntax";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/sdk/concretesyntax";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.emftext.sdk.concretesyntax";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConcretesyntaxPackage eINSTANCE = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.GenPackageDependentElementImpl <em>Gen Package Dependent Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.GenPackageDependentElementImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getGenPackageDependentElement()
	 * @generated
	 */
	int GEN_PACKAGE_DEPENDENT_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Package Location Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT = 1;

	/**
	 * The number of structural features of the '<em>Gen Package Dependent Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl <em>Concrete Syntax</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getConcreteSyntax()
	 * @generated
	 */
	int CONCRETE_SYNTAX = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__PACKAGE = GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Package Location Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__PACKAGE_LOCATION_HINT = GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ANNOTATIONS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__MODIFIER = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__NAME = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Start Symbols</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__START_SYMBOLS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Active Tokens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ACTIVE_TOKENS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__IMPORTS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__OPTIONS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__TOKENS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Synthetic Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__SYNTHETIC_TOKENS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Token Styles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__TOKEN_STYLES = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>All Token Styles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ALL_TOKEN_STYLES = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>All Token Directives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__RULES = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>operator Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__OPERATOR_RULES = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>operator Rule Subsets</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>operator Rules Initialized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>gen Class Cache</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__GEN_CLASS_CACHE = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>eClass Util</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ECLASS_UTIL = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 17;

	/**
	 * The number of structural features of the '<em>Concrete Syntax</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_FEATURE_COUNT = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 18;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ImportImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 2;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__PACKAGE = GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE;

	/**
	 * The feature id for the '<em><b>Package Location Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__PACKAGE_LOCATION_HINT = GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__PREFIX = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__CONCRETE_SYNTAX = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cs Location Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__CS_LOCATION_HINT = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.AnnotableImpl <em>Annotable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.AnnotableImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAnnotable()
	 * @generated
	 */
	int ANNOTABLE = 46;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.RuleImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 4;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.SyntaxElementImpl <em>Syntax Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.SyntaxElementImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getSyntaxElement()
	 * @generated
	 */
	int SYNTAX_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_ELEMENT__CHILDREN = 0;

	/**
	 * The number of structural features of the '<em>Syntax Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTAX_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTABLE__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Annotable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTABLE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ANNOTATIONS = ANNOTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__CHILDREN = ANNOTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__METACLASS = ANNOTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Syntax</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__SYNTAX = ANNOTABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = ANNOTABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ChoiceImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 5;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__CHILDREN = SYNTAX_ELEMENT__CHILDREN;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = SYNTAX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.SequenceImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 6;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__CHILDREN = SYNTAX_ELEMENT__CHILDREN;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = SYNTAX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.DefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.DefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDefinition()
	 * @generated
	 */
	int DEFINITION = 7;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__CHILDREN = SYNTAX_ELEMENT__CHILDREN;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_FEATURE_COUNT = SYNTAX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.CardinalityDefinitionImpl <em>Cardinality Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.CardinalityDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCardinalityDefinition()
	 * @generated
	 */
	int CARDINALITY_DEFINITION = 8;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_DEFINITION__CHILDREN = DEFINITION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_DEFINITION__CARDINALITY = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cardinality Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.TerminalImpl <em>Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.TerminalImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 9;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__CHILDREN = CARDINALITY_DEFINITION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__CARDINALITY = CARDINALITY_DEFINITION__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__FEATURE = CARDINALITY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = CARDINALITY_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.CsStringImpl <em>Cs String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.CsStringImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCsString()
	 * @generated
	 */
	int CS_STRING = 10;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_STRING__CHILDREN = DEFINITION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_STRING__VALUE = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cs String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_STRING_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.WhiteSpacesImpl <em>White Spaces</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.WhiteSpacesImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getWhiteSpaces()
	 * @generated
	 */
	int WHITE_SPACES = 11;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHITE_SPACES__CHILDREN = DEFINITION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHITE_SPACES__AMOUNT = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>White Spaces</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHITE_SPACES_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.LineBreakImpl <em>Line Break</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.LineBreakImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getLineBreak()
	 * @generated
	 */
	int LINE_BREAK = 12;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK__CHILDREN = DEFINITION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Tab</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK__TAB = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Line Break</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.CardinalityImpl <em>Cardinality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.CardinalityImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCardinality()
	 * @generated
	 */
	int CARDINALITY = 13;

	/**
	 * The number of structural features of the '<em>Cardinality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CARDINALITY_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.PLUSImpl <em>PLUS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.PLUSImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPLUS()
	 * @generated
	 */
	int PLUS = 14;

	/**
	 * The number of structural features of the '<em>PLUS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUS_FEATURE_COUNT = CARDINALITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.STARImpl <em>STAR</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.STARImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getSTAR()
	 * @generated
	 */
	int STAR = 15;

	/**
	 * The number of structural features of the '<em>STAR</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAR_FEATURE_COUNT = CARDINALITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.QUESTIONMARKImpl <em>QUESTIONMARK</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.QUESTIONMARKImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getQUESTIONMARK()
	 * @generated
	 */
	int QUESTIONMARK = 16;

	/**
	 * The number of structural features of the '<em>QUESTIONMARK</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTIONMARK_FEATURE_COUNT = CARDINALITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.CompoundDefinitionImpl <em>Compound Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.CompoundDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCompoundDefinition()
	 * @generated
	 */
	int COMPOUND_DEFINITION = 17;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION__CHILDREN = CARDINALITY_DEFINITION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION__CARDINALITY = CARDINALITY_DEFINITION__CARDINALITY;

	/**
	 * The number of structural features of the '<em>Compound Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION_FEATURE_COUNT = CARDINALITY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.TokenDirectiveImpl <em>Token Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.TokenDirectiveImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenDirective()
	 * @generated
	 */
	int TOKEN_DIRECTIVE = 24;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.RegexComposerImpl <em>Regex Composer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.RegexComposerImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexComposer()
	 * @generated
	 */
	int REGEX_COMPOSER = 18;

	/**
	 * The number of structural features of the '<em>Regex Composer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_COMPOSER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.RegexOwner <em>Regex Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.RegexOwner
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexOwner()
	 * @generated
	 */
	int REGEX_OWNER = 19;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_OWNER__REGEX = 0;

	/**
	 * The number of structural features of the '<em>Regex Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_OWNER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.RegexPartImpl <em>Regex Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.RegexPartImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexPart()
	 * @generated
	 */
	int REGEX_PART = 20;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_PART__REGEX = REGEX_OWNER__REGEX;

	/**
	 * The number of structural features of the '<em>Regex Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_PART_FEATURE_COUNT = REGEX_OWNER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.RegexCompositeImpl <em>Regex Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.RegexCompositeImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexComposite()
	 * @generated
	 */
	int REGEX_COMPOSITE = 21;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_COMPOSITE__REGEX = REGEX_OWNER__REGEX;

	/**
	 * The feature id for the '<em><b>Regex Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_COMPOSITE__REGEX_PARTS = REGEX_OWNER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regex Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_COMPOSITE_FEATURE_COUNT = REGEX_OWNER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.AtomicRegexImpl <em>Atomic Regex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.AtomicRegexImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAtomicRegex()
	 * @generated
	 */
	int ATOMIC_REGEX = 22;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_REGEX__REGEX = REGEX_PART__REGEX;

	/**
	 * The feature id for the '<em><b>Atomic Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_REGEX__ATOMIC_EXPRESSION = REGEX_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Atomic Regex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_REGEX_FEATURE_COUNT = REGEX_PART_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.RegexReferenceImpl <em>Regex Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.RegexReferenceImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexReference()
	 * @generated
	 */
	int REGEX_REFERENCE = 23;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_REFERENCE__REGEX = REGEX_PART__REGEX;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_REFERENCE__TARGET = REGEX_PART_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Regex Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGEX_REFERENCE_FEATURE_COUNT = REGEX_PART_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Token Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DIRECTIVE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.AbstractTokenDefinitionImpl <em>Abstract Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.AbstractTokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAbstractTokenDefinition()
	 * @generated
	 */
	int ABSTRACT_TOKEN_DEFINITION = 25;

	/**
	 * The number of structural features of the '<em>Abstract Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_TOKEN_DEFINITION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.NamedTokenDefinitionImpl <em>Named Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.NamedTokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNamedTokenDefinition()
	 * @generated
	 */
	int NAMED_TOKEN_DEFINITION = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_TOKEN_DEFINITION__NAME = ABSTRACT_TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_TOKEN_DEFINITION_FEATURE_COUNT = ABSTRACT_TOKEN_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ReferencableTokenDefinitionImpl <em>Referencable Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ReferencableTokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getReferencableTokenDefinition()
	 * @generated
	 */
	int REFERENCABLE_TOKEN_DEFINITION = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCABLE_TOKEN_DEFINITION__NAME = NAMED_TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCABLE_TOKEN_DEFINITION__REGEX = NAMED_TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCABLE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES = NAMED_TOKEN_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Referencable Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCABLE_TOKEN_DEFINITION_FEATURE_COUNT = NAMED_TOKEN_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.PartialTokenDefinitionImpl <em>Partial Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.PartialTokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPartialTokenDefinition()
	 * @generated
	 */
	int PARTIAL_TOKEN_DEFINITION = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TOKEN_DEFINITION__NAME = NAMED_TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TOKEN_DEFINITION__REGEX = NAMED_TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Regex Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TOKEN_DEFINITION__REGEX_PARTS = NAMED_TOKEN_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Partial Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_TOKEN_DEFINITION_FEATURE_COUNT = NAMED_TOKEN_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl <em>Complete Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCompleteTokenDefinition()
	 * @generated
	 */
	int COMPLETE_TOKEN_DEFINITION = 29;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TOKEN_DEFINITION__REGEX = TOKEN_DIRECTIVE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TOKEN_DEFINITION__NAME = TOKEN_DIRECTIVE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES = TOKEN_DIRECTIVE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME = TOKEN_DIRECTIVE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Complete Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT = TOKEN_DIRECTIVE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.NormalTokenDefinitionImpl <em>Normal Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.NormalTokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNormalTokenDefinition()
	 * @generated
	 */
	int NORMAL_TOKEN_DEFINITION = 30;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_DEFINITION__REGEX = COMPLETE_TOKEN_DEFINITION__REGEX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_DEFINITION__NAME = COMPLETE_TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES = COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_DEFINITION__ATTRIBUTE_NAME = COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_DEFINITION__ANNOTATIONS = COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Regex Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_DEFINITION__REGEX_PARTS = COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Normal Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_DEFINITION_FEATURE_COUNT = COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.TokenRedefinitionImpl <em>Token Redefinition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.TokenRedefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenRedefinition()
	 * @generated
	 */
	int TOKEN_REDEFINITION = 31;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_REDEFINITION__ANNOTATIONS = ANNOTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_REDEFINITION__REGEX = ANNOTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Regex Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_REDEFINITION__REGEX_PARTS = ANNOTABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_REDEFINITION__NAME = ANNOTABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_REDEFINITION__ATTRIBUTE_REFERENCES = ANNOTABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_REDEFINITION__ATTRIBUTE_NAME = ANNOTABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Redefined Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_REDEFINITION__REDEFINED_TOKEN = ANNOTABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Token Redefinition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_REDEFINITION_FEATURE_COUNT = ANNOTABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.QuotedTokenDefinitionImpl <em>Quoted Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.QuotedTokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getQuotedTokenDefinition()
	 * @generated
	 */
	int QUOTED_TOKEN_DEFINITION = 32;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION__REGEX = COMPLETE_TOKEN_DEFINITION__REGEX;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION__NAME = COMPLETE_TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES = COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION__ATTRIBUTE_NAME = COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION__PREFIX = COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION__SUFFIX = COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Escape Character</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION__ESCAPE_CHARACTER = COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Synthesized Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION__SYNTHESIZED_REGEX = COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Quoted Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_DEFINITION_FEATURE_COUNT = COMPLETE_TOKEN_DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.TokenPriorityDirectiveImpl <em>Token Priority Directive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.TokenPriorityDirectiveImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenPriorityDirective()
	 * @generated
	 */
	int TOKEN_PRIORITY_DIRECTIVE = 33;

	/**
	 * The feature id for the '<em><b>Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_PRIORITY_DIRECTIVE__TOKEN = TOKEN_DIRECTIVE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Token Priority Directive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_PRIORITY_DIRECTIVE_FEATURE_COUNT = TOKEN_DIRECTIVE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ContainmentImpl <em>Containment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ContainmentImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getContainment()
	 * @generated
	 */
	int CONTAINMENT = 34;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT__CHILDREN = TERMINAL__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT__CARDINALITY = TERMINAL__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT__FEATURE = TERMINAL__FEATURE;

	/**
	 * The feature id for the '<em><b>Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT__TYPES = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Containment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.PlaceholderImpl <em>Placeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.PlaceholderImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPlaceholder()
	 * @generated
	 */
	int PLACEHOLDER = 35;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__CHILDREN = TERMINAL__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__CARDINALITY = TERMINAL__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__FEATURE = TERMINAL__FEATURE;

	/**
	 * The feature id for the '<em><b>Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER__TOKEN = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Placeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.PlaceholderUsingSpecifiedTokenImpl <em>Placeholder Using Specified Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.PlaceholderUsingSpecifiedTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPlaceholderUsingSpecifiedToken()
	 * @generated
	 */
	int PLACEHOLDER_USING_SPECIFIED_TOKEN = 36;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_SPECIFIED_TOKEN__CHILDREN = PLACEHOLDER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_SPECIFIED_TOKEN__CARDINALITY = PLACEHOLDER__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_SPECIFIED_TOKEN__FEATURE = PLACEHOLDER__FEATURE;

	/**
	 * The feature id for the '<em><b>Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_SPECIFIED_TOKEN__TOKEN = PLACEHOLDER__TOKEN;

	/**
	 * The number of structural features of the '<em>Placeholder Using Specified Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_SPECIFIED_TOKEN_FEATURE_COUNT = PLACEHOLDER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.PlaceholderUsingDefaultTokenImpl <em>Placeholder Using Default Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.PlaceholderUsingDefaultTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPlaceholderUsingDefaultToken()
	 * @generated
	 */
	int PLACEHOLDER_USING_DEFAULT_TOKEN = 37;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_DEFAULT_TOKEN__CHILDREN = PLACEHOLDER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_DEFAULT_TOKEN__CARDINALITY = PLACEHOLDER__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_DEFAULT_TOKEN__FEATURE = PLACEHOLDER__FEATURE;

	/**
	 * The feature id for the '<em><b>Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_DEFAULT_TOKEN__TOKEN = PLACEHOLDER__TOKEN;

	/**
	 * The number of structural features of the '<em>Placeholder Using Default Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_USING_DEFAULT_TOKEN_FEATURE_COUNT = PLACEHOLDER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.PlaceholderInQuotesImpl <em>Placeholder In Quotes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.PlaceholderInQuotesImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPlaceholderInQuotes()
	 * @generated
	 */
	int PLACEHOLDER_IN_QUOTES = 38;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES__CHILDREN = PLACEHOLDER__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES__CARDINALITY = PLACEHOLDER__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES__FEATURE = PLACEHOLDER__FEATURE;

	/**
	 * The feature id for the '<em><b>Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES__TOKEN = PLACEHOLDER__TOKEN;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES__PREFIX = PLACEHOLDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES__SUFFIX = PLACEHOLDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Escape Character</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER = PLACEHOLDER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Placeholder In Quotes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES_FEATURE_COUNT = PLACEHOLDER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.BooleanTerminalImpl <em>Boolean Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.BooleanTerminalImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getBooleanTerminal()
	 * @generated
	 */
	int BOOLEAN_TERMINAL = 39;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERMINAL__CHILDREN = TERMINAL__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERMINAL__CARDINALITY = TERMINAL__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERMINAL__FEATURE = TERMINAL__FEATURE;

	/**
	 * The feature id for the '<em><b>True Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERMINAL__TRUE_LITERAL = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>False Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERMINAL__FALSE_LITERAL = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TERMINAL_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.EnumTerminalImpl <em>Enum Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.EnumTerminalImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getEnumTerminal()
	 * @generated
	 */
	int ENUM_TERMINAL = 40;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERMINAL__CHILDREN = TERMINAL__CHILDREN;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERMINAL__CARDINALITY = TERMINAL__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERMINAL__FEATURE = TERMINAL__FEATURE;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERMINAL__LITERALS = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TERMINAL_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.EnumLiteralTerminalImpl <em>Enum Literal Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.EnumLiteralTerminalImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getEnumLiteralTerminal()
	 * @generated
	 */
	int ENUM_LITERAL_TERMINAL = 41;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TERMINAL__CHILDREN = SYNTAX_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TERMINAL__LITERAL = SYNTAX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TERMINAL__TEXT = SYNTAX_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enum Literal Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_TERMINAL_FEATURE_COUNT = SYNTAX_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.OptionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 42;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.AbstractImpl <em>Abstract</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.AbstractImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAbstract()
	 * @generated
	 */
	int ABSTRACT = 43;

	/**
	 * The number of structural features of the '<em>Abstract</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.TokenStyleImpl <em>Token Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.TokenStyleImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenStyle()
	 * @generated
	 */
	int TOKEN_STYLE = 44;

	/**
	 * The feature id for the '<em><b>Token Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_STYLE__TOKEN_NAMES = 0;

	/**
	 * The feature id for the '<em><b>Rgb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_STYLE__RGB = 1;

	/**
	 * The feature id for the '<em><b>Font Styles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_STYLE__FONT_STYLES = 2;

	/**
	 * The number of structural features of the '<em>Token Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_STYLE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.AnnotationImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 45;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__PARAMETERS = 1;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.KeyValuePairImpl <em>Key Value Pair</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.KeyValuePairImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getKeyValuePair()
	 * @generated
	 */
	int KEY_VALUE_PAIR = 47;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_PAIR__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_PAIR__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Key Value Pair</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_VALUE_PAIR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.GenClassCacheImpl <em>Gen Class Cache</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.GenClassCacheImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getGenClassCache()
	 * @generated
	 */
	int GEN_CLASS_CACHE = 48;

	/**
	 * The feature id for the '<em><b>qualified Interface Name Cache</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_CLASS_CACHE__QUALIFIED_INTERFACE_NAME_CACHE = 0;

	/**
	 * The number of structural features of the '<em>Gen Class Cache</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_CLASS_CACHE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.GenClassCacheEntryImpl <em>Gen Class Cache Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.GenClassCacheEntryImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getGenClassCacheEntry()
	 * @generated
	 */
	int GEN_CLASS_CACHE_ENTRY = 49;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_CLASS_CACHE_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_CLASS_CACHE_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Gen Class Cache Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_CLASS_CACHE_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.EClassUtilImpl <em>EClass Util</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.EClassUtilImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getEClassUtil()
	 * @generated
	 */
	int ECLASS_UTIL = 50;

	/**
	 * The number of structural features of the '<em>EClass Util</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECLASS_UTIL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.OptionTypes <em>Option Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.OptionTypes
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOptionTypes()
	 * @generated
	 */
	int OPTION_TYPES = 51;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.FontStyle <em>Font Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.FontStyle
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getFontStyle()
	 * @generated
	 */
	int FONT_STYLE = 52;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.AnnotationType <em>Annotation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.AnnotationType
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAnnotationType()
	 * @generated
	 */
	int ANNOTATION_TYPE = 53;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.OperatorAnnotationType <em>Operator Annotation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.OperatorAnnotationType
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOperatorAnnotationType()
	 * @generated
	 */
	int OPERATOR_ANNOTATION_TYPE = 54;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.OperatorAnnotationProperty <em>Operator Annotation Property</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.OperatorAnnotationProperty
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOperatorAnnotationProperty()
	 * @generated
	 */
	int OPERATOR_ANNOTATION_PROPERTY = 55;


	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.GenPackageDependentElement <em>Gen Package Dependent Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Package Dependent Element</em>'.
	 * @see org.emftext.sdk.concretesyntax.GenPackageDependentElement
	 * @generated
	 */
	EClass getGenPackageDependentElement();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.GenPackageDependentElement#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.emftext.sdk.concretesyntax.GenPackageDependentElement#getPackage()
	 * @see #getGenPackageDependentElement()
	 * @generated
	 */
	EReference getGenPackageDependentElement_Package();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.GenPackageDependentElement#getPackageLocationHint <em>Package Location Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Location Hint</em>'.
	 * @see org.emftext.sdk.concretesyntax.GenPackageDependentElement#getPackageLocationHint()
	 * @see #getGenPackageDependentElement()
	 * @generated
	 */
	EAttribute getGenPackageDependentElement_PackageLocationHint();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax <em>Concrete Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concrete Syntax</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax
	 * @generated
	 */
	EClass getConcreteSyntax();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Modifier</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getModifier()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Modifier();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getName()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EAttribute getConcreteSyntax_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getStartSymbols <em>Start Symbols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Start Symbols</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getStartSymbols()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_StartSymbols();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getActiveTokens <em>Active Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active Tokens</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getActiveTokens()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_ActiveTokens();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getImports()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getOptions()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Options();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tokens</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokens()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Tokens();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getSyntheticTokens <em>Synthetic Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Synthetic Tokens</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getSyntheticTokens()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_SyntheticTokens();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokenStyles <em>Token Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Token Styles</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getTokenStyles()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_TokenStyles();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenStyles <em>All Token Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Token Styles</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenStyles()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_AllTokenStyles();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenDirectives <em>All Token Directives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Token Directives</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokenDirectives()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_AllTokenDirectives();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Rules();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_operatorRules <em>operator Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>operator Rules</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#get_operatorRules()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax__operatorRules();

	/**
	 * Returns the meta object for the attribute list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_operatorRuleSubsets <em>operator Rule Subsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>operator Rule Subsets</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#get_operatorRuleSubsets()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EAttribute getConcreteSyntax__operatorRuleSubsets();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#is_operatorRulesInitialized <em>operator Rules Initialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>operator Rules Initialized</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#is_operatorRulesInitialized()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EAttribute getConcreteSyntax__operatorRulesInitialized();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_genClassCache <em>gen Class Cache</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>gen Class Cache</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#get_genClassCache()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax__genClassCache();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#get_eClassUtil <em>eClass Util</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>eClass Util</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#get_eClassUtil()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax__eClassUtil();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see org.emftext.sdk.concretesyntax.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.Import#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.emftext.sdk.concretesyntax.Import#getPrefix()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Prefix();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.Import#getConcreteSyntax <em>Concrete Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Concrete Syntax</em>'.
	 * @see org.emftext.sdk.concretesyntax.Import#getConcreteSyntax()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_ConcreteSyntax();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.Import#getCsLocationHint <em>Cs Location Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cs Location Hint</em>'.
	 * @see org.emftext.sdk.concretesyntax.Import#getCsLocationHint()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_CsLocationHint();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.emftext.sdk.concretesyntax.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.Rule#getMetaclass <em>Metaclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metaclass</em>'.
	 * @see org.emftext.sdk.concretesyntax.Rule#getMetaclass()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Metaclass();

	/**
	 * Returns the meta object for the container reference '{@link org.emftext.sdk.concretesyntax.Rule#getSyntax <em>Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Syntax</em>'.
	 * @see org.emftext.sdk.concretesyntax.Rule#getSyntax()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Syntax();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.SyntaxElement <em>Syntax Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Syntax Element</em>'.
	 * @see org.emftext.sdk.concretesyntax.SyntaxElement
	 * @generated
	 */
	EClass getSyntaxElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.SyntaxElement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.emftext.sdk.concretesyntax.SyntaxElement#getChildren()
	 * @see #getSyntaxElement()
	 * @generated
	 */
	EReference getSyntaxElement_Children();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see org.emftext.sdk.concretesyntax.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see org.emftext.sdk.concretesyntax.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Definition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.Definition
	 * @generated
	 */
	EClass getDefinition();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.CardinalityDefinition <em>Cardinality Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.CardinalityDefinition
	 * @generated
	 */
	EClass getCardinalityDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.sdk.concretesyntax.CardinalityDefinition#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cardinality</em>'.
	 * @see org.emftext.sdk.concretesyntax.CardinalityDefinition#getCardinality()
	 * @see #getCardinalityDefinition()
	 * @generated
	 */
	EReference getCardinalityDefinition_Cardinality();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal</em>'.
	 * @see org.emftext.sdk.concretesyntax.Terminal
	 * @generated
	 */
	EClass getTerminal();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.Terminal#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.emftext.sdk.concretesyntax.Terminal#getFeature()
	 * @see #getTerminal()
	 * @generated
	 */
	EReference getTerminal_Feature();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.CsString <em>Cs String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cs String</em>'.
	 * @see org.emftext.sdk.concretesyntax.CsString
	 * @generated
	 */
	EClass getCsString();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.CsString#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.emftext.sdk.concretesyntax.CsString#getValue()
	 * @see #getCsString()
	 * @generated
	 */
	EAttribute getCsString_Value();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.WhiteSpaces <em>White Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>White Spaces</em>'.
	 * @see org.emftext.sdk.concretesyntax.WhiteSpaces
	 * @generated
	 */
	EClass getWhiteSpaces();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.WhiteSpaces#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see org.emftext.sdk.concretesyntax.WhiteSpaces#getAmount()
	 * @see #getWhiteSpaces()
	 * @generated
	 */
	EAttribute getWhiteSpaces_Amount();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.LineBreak <em>Line Break</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Break</em>'.
	 * @see org.emftext.sdk.concretesyntax.LineBreak
	 * @generated
	 */
	EClass getLineBreak();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.LineBreak#getTab <em>Tab</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tab</em>'.
	 * @see org.emftext.sdk.concretesyntax.LineBreak#getTab()
	 * @see #getLineBreak()
	 * @generated
	 */
	EAttribute getLineBreak_Tab();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Cardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cardinality</em>'.
	 * @see org.emftext.sdk.concretesyntax.Cardinality
	 * @generated
	 */
	EClass getCardinality();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.PLUS <em>PLUS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PLUS</em>'.
	 * @see org.emftext.sdk.concretesyntax.PLUS
	 * @generated
	 */
	EClass getPLUS();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.STAR <em>STAR</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STAR</em>'.
	 * @see org.emftext.sdk.concretesyntax.STAR
	 * @generated
	 */
	EClass getSTAR();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.QUESTIONMARK <em>QUESTIONMARK</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QUESTIONMARK</em>'.
	 * @see org.emftext.sdk.concretesyntax.QUESTIONMARK
	 * @generated
	 */
	EClass getQUESTIONMARK();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.CompoundDefinition <em>Compound Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.CompoundDefinition
	 * @generated
	 */
	EClass getCompoundDefinition();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.TokenDirective <em>Token Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token Directive</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenDirective
	 * @generated
	 */
	EClass getTokenDirective();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.RegexComposer <em>Regex Composer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regex Composer</em>'.
	 * @see org.emftext.sdk.concretesyntax.RegexComposer
	 * @generated
	 */
	EClass getRegexComposer();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.RegexOwner <em>Regex Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regex Owner</em>'.
	 * @see org.emftext.sdk.concretesyntax.RegexOwner
	 * @generated
	 */
	EClass getRegexOwner();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.RegexOwner#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see org.emftext.sdk.concretesyntax.RegexOwner#getRegex()
	 * @see #getRegexOwner()
	 * @generated
	 */
	EAttribute getRegexOwner_Regex();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.RegexPart <em>Regex Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regex Part</em>'.
	 * @see org.emftext.sdk.concretesyntax.RegexPart
	 * @generated
	 */
	EClass getRegexPart();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.RegexComposite <em>Regex Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regex Composite</em>'.
	 * @see org.emftext.sdk.concretesyntax.RegexComposite
	 * @generated
	 */
	EClass getRegexComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.RegexComposite#getRegexParts <em>Regex Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Regex Parts</em>'.
	 * @see org.emftext.sdk.concretesyntax.RegexComposite#getRegexParts()
	 * @see #getRegexComposite()
	 * @generated
	 */
	EReference getRegexComposite_RegexParts();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.AtomicRegex <em>Atomic Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Regex</em>'.
	 * @see org.emftext.sdk.concretesyntax.AtomicRegex
	 * @generated
	 */
	EClass getAtomicRegex();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.AtomicRegex#getAtomicExpression <em>Atomic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Atomic Expression</em>'.
	 * @see org.emftext.sdk.concretesyntax.AtomicRegex#getAtomicExpression()
	 * @see #getAtomicRegex()
	 * @generated
	 */
	EAttribute getAtomicRegex_AtomicExpression();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.RegexReference <em>Regex Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regex Reference</em>'.
	 * @see org.emftext.sdk.concretesyntax.RegexReference
	 * @generated
	 */
	EClass getRegexReference();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.RegexReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.emftext.sdk.concretesyntax.RegexReference#getTarget()
	 * @see #getRegexReference()
	 * @generated
	 */
	EReference getRegexReference_Target();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.AbstractTokenDefinition <em>Abstract Token Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Token Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.AbstractTokenDefinition
	 * @generated
	 */
	EClass getAbstractTokenDefinition();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.NamedTokenDefinition <em>Named Token Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Token Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.NamedTokenDefinition
	 * @generated
	 */
	EClass getNamedTokenDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.NamedTokenDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.sdk.concretesyntax.NamedTokenDefinition#getName()
	 * @see #getNamedTokenDefinition()
	 * @generated
	 */
	EAttribute getNamedTokenDefinition_Name();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.ReferencableTokenDefinition <em>Referencable Token Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referencable Token Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.ReferencableTokenDefinition
	 * @generated
	 */
	EClass getReferencableTokenDefinition();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ReferencableTokenDefinition#getAttributeReferences <em>Attribute References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute References</em>'.
	 * @see org.emftext.sdk.concretesyntax.ReferencableTokenDefinition#getAttributeReferences()
	 * @see #getReferencableTokenDefinition()
	 * @generated
	 */
	EReference getReferencableTokenDefinition_AttributeReferences();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.PartialTokenDefinition <em>Partial Token Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partial Token Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.PartialTokenDefinition
	 * @generated
	 */
	EClass getPartialTokenDefinition();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition <em>Complete Token Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Token Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.CompleteTokenDefinition
	 * @generated
	 */
	EClass getCompleteTokenDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeName()
	 * @see #getCompleteTokenDefinition()
	 * @generated
	 */
	EAttribute getCompleteTokenDefinition_AttributeName();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.NormalTokenDefinition <em>Normal Token Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Token Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.NormalTokenDefinition
	 * @generated
	 */
	EClass getNormalTokenDefinition();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.TokenRedefinition <em>Token Redefinition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token Redefinition</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenRedefinition
	 * @generated
	 */
	EClass getTokenRedefinition();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.TokenRedefinition#getRedefinedToken <em>Redefined Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Redefined Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenRedefinition#getRedefinedToken()
	 * @see #getTokenRedefinition()
	 * @generated
	 */
	EReference getTokenRedefinition_RedefinedToken();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.QuotedTokenDefinition <em>Quoted Token Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quoted Token Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.QuotedTokenDefinition
	 * @generated
	 */
	EClass getQuotedTokenDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.QuotedTokenDefinition#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.emftext.sdk.concretesyntax.QuotedTokenDefinition#getPrefix()
	 * @see #getQuotedTokenDefinition()
	 * @generated
	 */
	EAttribute getQuotedTokenDefinition_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.QuotedTokenDefinition#getSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix</em>'.
	 * @see org.emftext.sdk.concretesyntax.QuotedTokenDefinition#getSuffix()
	 * @see #getQuotedTokenDefinition()
	 * @generated
	 */
	EAttribute getQuotedTokenDefinition_Suffix();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.QuotedTokenDefinition#getEscapeCharacter <em>Escape Character</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Character</em>'.
	 * @see org.emftext.sdk.concretesyntax.QuotedTokenDefinition#getEscapeCharacter()
	 * @see #getQuotedTokenDefinition()
	 * @generated
	 */
	EAttribute getQuotedTokenDefinition_EscapeCharacter();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.QuotedTokenDefinition#getSynthesizedRegex <em>Synthesized Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Synthesized Regex</em>'.
	 * @see org.emftext.sdk.concretesyntax.QuotedTokenDefinition#getSynthesizedRegex()
	 * @see #getQuotedTokenDefinition()
	 * @generated
	 */
	EAttribute getQuotedTokenDefinition_SynthesizedRegex();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.TokenPriorityDirective <em>Token Priority Directive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token Priority Directive</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenPriorityDirective
	 * @generated
	 */
	EClass getTokenPriorityDirective();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.TokenPriorityDirective#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenPriorityDirective#getToken()
	 * @see #getTokenPriorityDirective()
	 * @generated
	 */
	EReference getTokenPriorityDirective_Token();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Containment <em>Containment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Containment</em>'.
	 * @see org.emftext.sdk.concretesyntax.Containment
	 * @generated
	 */
	EClass getContainment();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.Containment#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Types</em>'.
	 * @see org.emftext.sdk.concretesyntax.Containment#getTypes()
	 * @see #getContainment()
	 * @generated
	 */
	EReference getContainment_Types();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Placeholder <em>Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placeholder</em>'.
	 * @see org.emftext.sdk.concretesyntax.Placeholder
	 * @generated
	 */
	EClass getPlaceholder();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.Placeholder#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.Placeholder#getToken()
	 * @see #getPlaceholder()
	 * @generated
	 */
	EReference getPlaceholder_Token();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken <em>Placeholder Using Specified Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placeholder Using Specified Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.PlaceholderUsingSpecifiedToken
	 * @generated
	 */
	EClass getPlaceholderUsingSpecifiedToken();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken <em>Placeholder Using Default Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placeholder Using Default Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken
	 * @generated
	 */
	EClass getPlaceholderUsingDefaultToken();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes <em>Placeholder In Quotes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Placeholder In Quotes</em>'.
	 * @see org.emftext.sdk.concretesyntax.PlaceholderInQuotes
	 * @generated
	 */
	EClass getPlaceholderInQuotes();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getPrefix()
	 * @see #getPlaceholderInQuotes()
	 * @generated
	 */
	EAttribute getPlaceholderInQuotes_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix</em>'.
	 * @see org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getSuffix()
	 * @see #getPlaceholderInQuotes()
	 * @generated
	 */
	EAttribute getPlaceholderInQuotes_Suffix();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getEscapeCharacter <em>Escape Character</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escape Character</em>'.
	 * @see org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getEscapeCharacter()
	 * @see #getPlaceholderInQuotes()
	 * @generated
	 */
	EAttribute getPlaceholderInQuotes_EscapeCharacter();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.BooleanTerminal <em>Boolean Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Terminal</em>'.
	 * @see org.emftext.sdk.concretesyntax.BooleanTerminal
	 * @generated
	 */
	EClass getBooleanTerminal();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.BooleanTerminal#getTrueLiteral <em>True Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>True Literal</em>'.
	 * @see org.emftext.sdk.concretesyntax.BooleanTerminal#getTrueLiteral()
	 * @see #getBooleanTerminal()
	 * @generated
	 */
	EAttribute getBooleanTerminal_TrueLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.BooleanTerminal#getFalseLiteral <em>False Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>False Literal</em>'.
	 * @see org.emftext.sdk.concretesyntax.BooleanTerminal#getFalseLiteral()
	 * @see #getBooleanTerminal()
	 * @generated
	 */
	EAttribute getBooleanTerminal_FalseLiteral();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.EnumTerminal <em>Enum Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Terminal</em>'.
	 * @see org.emftext.sdk.concretesyntax.EnumTerminal
	 * @generated
	 */
	EClass getEnumTerminal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.EnumTerminal#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.emftext.sdk.concretesyntax.EnumTerminal#getLiterals()
	 * @see #getEnumTerminal()
	 * @generated
	 */
	EReference getEnumTerminal_Literals();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.EnumLiteralTerminal <em>Enum Literal Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Terminal</em>'.
	 * @see org.emftext.sdk.concretesyntax.EnumLiteralTerminal
	 * @generated
	 */
	EClass getEnumLiteralTerminal();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.EnumLiteralTerminal#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see org.emftext.sdk.concretesyntax.EnumLiteralTerminal#getLiteral()
	 * @see #getEnumLiteralTerminal()
	 * @generated
	 */
	EReference getEnumLiteralTerminal_Literal();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.EnumLiteralTerminal#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.emftext.sdk.concretesyntax.EnumLiteralTerminal#getText()
	 * @see #getEnumLiteralTerminal()
	 * @generated
	 */
	EAttribute getEnumLiteralTerminal_Text();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see org.emftext.sdk.concretesyntax.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.Option#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.emftext.sdk.concretesyntax.Option#getType()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.Option#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.emftext.sdk.concretesyntax.Option#getValue()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Value();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Abstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract</em>'.
	 * @see org.emftext.sdk.concretesyntax.Abstract
	 * @generated
	 */
	EClass getAbstract();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.TokenStyle <em>Token Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token Style</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenStyle
	 * @generated
	 */
	EClass getTokenStyle();

	/**
	 * Returns the meta object for the attribute list '{@link org.emftext.sdk.concretesyntax.TokenStyle#getTokenNames <em>Token Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Token Names</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenStyle#getTokenNames()
	 * @see #getTokenStyle()
	 * @generated
	 */
	EAttribute getTokenStyle_TokenNames();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.TokenStyle#getRgb <em>Rgb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rgb</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenStyle#getRgb()
	 * @see #getTokenStyle()
	 * @generated
	 */
	EAttribute getTokenStyle_Rgb();

	/**
	 * Returns the meta object for the attribute list '{@link org.emftext.sdk.concretesyntax.TokenStyle#getFontStyles <em>Font Styles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Font Styles</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenStyle#getFontStyles()
	 * @see #getTokenStyle()
	 * @generated
	 */
	EAttribute getTokenStyle_FontStyles();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see org.emftext.sdk.concretesyntax.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.Annotation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.emftext.sdk.concretesyntax.Annotation#getType()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.Annotation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.emftext.sdk.concretesyntax.Annotation#getParameters()
	 * @see #getAnnotation()
	 * @generated
	 */
	EReference getAnnotation_Parameters();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Annotable <em>Annotable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotable</em>'.
	 * @see org.emftext.sdk.concretesyntax.Annotable
	 * @generated
	 */
	EClass getAnnotable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.Annotable#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see org.emftext.sdk.concretesyntax.Annotable#getAnnotations()
	 * @see #getAnnotable()
	 * @generated
	 */
	EReference getAnnotable_Annotations();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.KeyValuePair <em>Key Value Pair</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Value Pair</em>'.
	 * @see org.emftext.sdk.concretesyntax.KeyValuePair
	 * @generated
	 */
	EClass getKeyValuePair();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.KeyValuePair#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.emftext.sdk.concretesyntax.KeyValuePair#getKey()
	 * @see #getKeyValuePair()
	 * @generated
	 */
	EAttribute getKeyValuePair_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.KeyValuePair#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.emftext.sdk.concretesyntax.KeyValuePair#getValue()
	 * @see #getKeyValuePair()
	 * @generated
	 */
	EAttribute getKeyValuePair_Value();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.GenClassCache <em>Gen Class Cache</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Class Cache</em>'.
	 * @see org.emftext.sdk.concretesyntax.GenClassCache
	 * @generated
	 */
	EClass getGenClassCache();

	/**
	 * Returns the meta object for the map '{@link org.emftext.sdk.concretesyntax.GenClassCache#get_qualifiedInterfaceNameCache <em>qualified Interface Name Cache</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>qualified Interface Name Cache</em>'.
	 * @see org.emftext.sdk.concretesyntax.GenClassCache#get_qualifiedInterfaceNameCache()
	 * @see #getGenClassCache()
	 * @generated
	 */
	EReference getGenClassCache__qualifiedInterfaceNameCache();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Gen Class Cache Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Class Cache Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="org.eclipse.emf.codegen.ecore.genmodel.GenClass"
	 *        valueDataType="org.eclipse.emf.ecore.EString"
	 * @generated
	 */
	EClass getGenClassCacheEntry();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getGenClassCacheEntry()
	 * @generated
	 */
	EReference getGenClassCacheEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getGenClassCacheEntry()
	 * @generated
	 */
	EAttribute getGenClassCacheEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.EClassUtil <em>EClass Util</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EClass Util</em>'.
	 * @see org.emftext.sdk.concretesyntax.EClassUtil
	 * @generated
	 */
	EClass getEClassUtil();

	/**
	 * Returns the meta object for enum '{@link org.emftext.sdk.concretesyntax.OptionTypes <em>Option Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Option Types</em>'.
	 * @see org.emftext.sdk.concretesyntax.OptionTypes
	 * @generated
	 */
	EEnum getOptionTypes();

	/**
	 * Returns the meta object for enum '{@link org.emftext.sdk.concretesyntax.FontStyle <em>Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Font Style</em>'.
	 * @see org.emftext.sdk.concretesyntax.FontStyle
	 * @generated
	 */
	EEnum getFontStyle();

	/**
	 * Returns the meta object for enum '{@link org.emftext.sdk.concretesyntax.AnnotationType <em>Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Annotation Type</em>'.
	 * @see org.emftext.sdk.concretesyntax.AnnotationType
	 * @generated
	 */
	EEnum getAnnotationType();

	/**
	 * Returns the meta object for enum '{@link org.emftext.sdk.concretesyntax.OperatorAnnotationType <em>Operator Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator Annotation Type</em>'.
	 * @see org.emftext.sdk.concretesyntax.OperatorAnnotationType
	 * @generated
	 */
	EEnum getOperatorAnnotationType();

	/**
	 * Returns the meta object for enum '{@link org.emftext.sdk.concretesyntax.OperatorAnnotationProperty <em>Operator Annotation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator Annotation Property</em>'.
	 * @see org.emftext.sdk.concretesyntax.OperatorAnnotationProperty
	 * @generated
	 */
	EEnum getOperatorAnnotationProperty();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConcretesyntaxFactory getConcretesyntaxFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.GenPackageDependentElementImpl <em>Gen Package Dependent Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.GenPackageDependentElementImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getGenPackageDependentElement()
		 * @generated
		 */
		EClass GEN_PACKAGE_DEPENDENT_ELEMENT = eINSTANCE.getGenPackageDependentElement();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE = eINSTANCE.getGenPackageDependentElement_Package();

		/**
		 * The meta object literal for the '<em><b>Package Location Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT = eINSTANCE.getGenPackageDependentElement_PackageLocationHint();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl <em>Concrete Syntax</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getConcreteSyntax()
		 * @generated
		 */
		EClass CONCRETE_SYNTAX = eINSTANCE.getConcreteSyntax();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__MODIFIER = eINSTANCE.getConcreteSyntax_Modifier();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_SYNTAX__NAME = eINSTANCE.getConcreteSyntax_Name();

		/**
		 * The meta object literal for the '<em><b>Start Symbols</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__START_SYMBOLS = eINSTANCE.getConcreteSyntax_StartSymbols();

		/**
		 * The meta object literal for the '<em><b>Active Tokens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__ACTIVE_TOKENS = eINSTANCE.getConcreteSyntax_ActiveTokens();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__IMPORTS = eINSTANCE.getConcreteSyntax_Imports();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__OPTIONS = eINSTANCE.getConcreteSyntax_Options();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__TOKENS = eINSTANCE.getConcreteSyntax_Tokens();

		/**
		 * The meta object literal for the '<em><b>Synthetic Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__SYNTHETIC_TOKENS = eINSTANCE.getConcreteSyntax_SyntheticTokens();

		/**
		 * The meta object literal for the '<em><b>Token Styles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__TOKEN_STYLES = eINSTANCE.getConcreteSyntax_TokenStyles();

		/**
		 * The meta object literal for the '<em><b>All Token Styles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__ALL_TOKEN_STYLES = eINSTANCE.getConcreteSyntax_AllTokenStyles();

		/**
		 * The meta object literal for the '<em><b>All Token Directives</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__ALL_TOKEN_DIRECTIVES = eINSTANCE.getConcreteSyntax_AllTokenDirectives();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__RULES = eINSTANCE.getConcreteSyntax_Rules();

		/**
		 * The meta object literal for the '<em><b>operator Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__OPERATOR_RULES = eINSTANCE.getConcreteSyntax__operatorRules();

		/**
		 * The meta object literal for the '<em><b>operator Rule Subsets</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_SYNTAX__OPERATOR_RULE_SUBSETS = eINSTANCE.getConcreteSyntax__operatorRuleSubsets();

		/**
		 * The meta object literal for the '<em><b>operator Rules Initialized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_SYNTAX__OPERATOR_RULES_INITIALIZED = eINSTANCE.getConcreteSyntax__operatorRulesInitialized();

		/**
		 * The meta object literal for the '<em><b>gen Class Cache</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__GEN_CLASS_CACHE = eINSTANCE.getConcreteSyntax__genClassCache();

		/**
		 * The meta object literal for the '<em><b>eClass Util</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__ECLASS_UTIL = eINSTANCE.getConcreteSyntax__eClassUtil();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.ImportImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__PREFIX = eINSTANCE.getImport_Prefix();

		/**
		 * The meta object literal for the '<em><b>Concrete Syntax</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__CONCRETE_SYNTAX = eINSTANCE.getImport_ConcreteSyntax();

		/**
		 * The meta object literal for the '<em><b>Cs Location Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__CS_LOCATION_HINT = eINSTANCE.getImport_CsLocationHint();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.RuleImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Metaclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__METACLASS = eINSTANCE.getRule_Metaclass();

		/**
		 * The meta object literal for the '<em><b>Syntax</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__SYNTAX = eINSTANCE.getRule_Syntax();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.SyntaxElementImpl <em>Syntax Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.SyntaxElementImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getSyntaxElement()
		 * @generated
		 */
		EClass SYNTAX_ELEMENT = eINSTANCE.getSyntaxElement();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYNTAX_ELEMENT__CHILDREN = eINSTANCE.getSyntaxElement_Children();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.ChoiceImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.SequenceImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.DefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.DefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDefinition()
		 * @generated
		 */
		EClass DEFINITION = eINSTANCE.getDefinition();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.CardinalityDefinitionImpl <em>Cardinality Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.CardinalityDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCardinalityDefinition()
		 * @generated
		 */
		EClass CARDINALITY_DEFINITION = eINSTANCE.getCardinalityDefinition();

		/**
		 * The meta object literal for the '<em><b>Cardinality</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CARDINALITY_DEFINITION__CARDINALITY = eINSTANCE.getCardinalityDefinition_Cardinality();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.TerminalImpl <em>Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.TerminalImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTerminal()
		 * @generated
		 */
		EClass TERMINAL = eINSTANCE.getTerminal();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TERMINAL__FEATURE = eINSTANCE.getTerminal_Feature();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.CsStringImpl <em>Cs String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.CsStringImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCsString()
		 * @generated
		 */
		EClass CS_STRING = eINSTANCE.getCsString();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CS_STRING__VALUE = eINSTANCE.getCsString_Value();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.WhiteSpacesImpl <em>White Spaces</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.WhiteSpacesImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getWhiteSpaces()
		 * @generated
		 */
		EClass WHITE_SPACES = eINSTANCE.getWhiteSpaces();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHITE_SPACES__AMOUNT = eINSTANCE.getWhiteSpaces_Amount();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.LineBreakImpl <em>Line Break</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.LineBreakImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getLineBreak()
		 * @generated
		 */
		EClass LINE_BREAK = eINSTANCE.getLineBreak();

		/**
		 * The meta object literal for the '<em><b>Tab</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE_BREAK__TAB = eINSTANCE.getLineBreak_Tab();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.CardinalityImpl <em>Cardinality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.CardinalityImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCardinality()
		 * @generated
		 */
		EClass CARDINALITY = eINSTANCE.getCardinality();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.PLUSImpl <em>PLUS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.PLUSImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPLUS()
		 * @generated
		 */
		EClass PLUS = eINSTANCE.getPLUS();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.STARImpl <em>STAR</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.STARImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getSTAR()
		 * @generated
		 */
		EClass STAR = eINSTANCE.getSTAR();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.QUESTIONMARKImpl <em>QUESTIONMARK</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.QUESTIONMARKImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getQUESTIONMARK()
		 * @generated
		 */
		EClass QUESTIONMARK = eINSTANCE.getQUESTIONMARK();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.CompoundDefinitionImpl <em>Compound Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.CompoundDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCompoundDefinition()
		 * @generated
		 */
		EClass COMPOUND_DEFINITION = eINSTANCE.getCompoundDefinition();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.TokenDirectiveImpl <em>Token Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.TokenDirectiveImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenDirective()
		 * @generated
		 */
		EClass TOKEN_DIRECTIVE = eINSTANCE.getTokenDirective();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.RegexComposerImpl <em>Regex Composer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.RegexComposerImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexComposer()
		 * @generated
		 */
		EClass REGEX_COMPOSER = eINSTANCE.getRegexComposer();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.RegexOwner <em>Regex Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.RegexOwner
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexOwner()
		 * @generated
		 */
		EClass REGEX_OWNER = eINSTANCE.getRegexOwner();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGEX_OWNER__REGEX = eINSTANCE.getRegexOwner_Regex();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.RegexPartImpl <em>Regex Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.RegexPartImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexPart()
		 * @generated
		 */
		EClass REGEX_PART = eINSTANCE.getRegexPart();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.RegexCompositeImpl <em>Regex Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.RegexCompositeImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexComposite()
		 * @generated
		 */
		EClass REGEX_COMPOSITE = eINSTANCE.getRegexComposite();

		/**
		 * The meta object literal for the '<em><b>Regex Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGEX_COMPOSITE__REGEX_PARTS = eINSTANCE.getRegexComposite_RegexParts();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.AtomicRegexImpl <em>Atomic Regex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.AtomicRegexImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAtomicRegex()
		 * @generated
		 */
		EClass ATOMIC_REGEX = eINSTANCE.getAtomicRegex();

		/**
		 * The meta object literal for the '<em><b>Atomic Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATOMIC_REGEX__ATOMIC_EXPRESSION = eINSTANCE.getAtomicRegex_AtomicExpression();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.RegexReferenceImpl <em>Regex Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.RegexReferenceImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRegexReference()
		 * @generated
		 */
		EClass REGEX_REFERENCE = eINSTANCE.getRegexReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGEX_REFERENCE__TARGET = eINSTANCE.getRegexReference_Target();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.AbstractTokenDefinitionImpl <em>Abstract Token Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.AbstractTokenDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAbstractTokenDefinition()
		 * @generated
		 */
		EClass ABSTRACT_TOKEN_DEFINITION = eINSTANCE.getAbstractTokenDefinition();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.NamedTokenDefinitionImpl <em>Named Token Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.NamedTokenDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNamedTokenDefinition()
		 * @generated
		 */
		EClass NAMED_TOKEN_DEFINITION = eINSTANCE.getNamedTokenDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_TOKEN_DEFINITION__NAME = eINSTANCE.getNamedTokenDefinition_Name();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.ReferencableTokenDefinitionImpl <em>Referencable Token Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.ReferencableTokenDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getReferencableTokenDefinition()
		 * @generated
		 */
		EClass REFERENCABLE_TOKEN_DEFINITION = eINSTANCE.getReferencableTokenDefinition();

		/**
		 * The meta object literal for the '<em><b>Attribute References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCABLE_TOKEN_DEFINITION__ATTRIBUTE_REFERENCES = eINSTANCE.getReferencableTokenDefinition_AttributeReferences();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.PartialTokenDefinitionImpl <em>Partial Token Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.PartialTokenDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPartialTokenDefinition()
		 * @generated
		 */
		EClass PARTIAL_TOKEN_DEFINITION = eINSTANCE.getPartialTokenDefinition();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl <em>Complete Token Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.CompleteTokenDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCompleteTokenDefinition()
		 * @generated
		 */
		EClass COMPLETE_TOKEN_DEFINITION = eINSTANCE.getCompleteTokenDefinition();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETE_TOKEN_DEFINITION__ATTRIBUTE_NAME = eINSTANCE.getCompleteTokenDefinition_AttributeName();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.NormalTokenDefinitionImpl <em>Normal Token Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.NormalTokenDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNormalTokenDefinition()
		 * @generated
		 */
		EClass NORMAL_TOKEN_DEFINITION = eINSTANCE.getNormalTokenDefinition();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.TokenRedefinitionImpl <em>Token Redefinition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.TokenRedefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenRedefinition()
		 * @generated
		 */
		EClass TOKEN_REDEFINITION = eINSTANCE.getTokenRedefinition();

		/**
		 * The meta object literal for the '<em><b>Redefined Token</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN_REDEFINITION__REDEFINED_TOKEN = eINSTANCE.getTokenRedefinition_RedefinedToken();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.QuotedTokenDefinitionImpl <em>Quoted Token Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.QuotedTokenDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getQuotedTokenDefinition()
		 * @generated
		 */
		EClass QUOTED_TOKEN_DEFINITION = eINSTANCE.getQuotedTokenDefinition();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUOTED_TOKEN_DEFINITION__PREFIX = eINSTANCE.getQuotedTokenDefinition_Prefix();

		/**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUOTED_TOKEN_DEFINITION__SUFFIX = eINSTANCE.getQuotedTokenDefinition_Suffix();

		/**
		 * The meta object literal for the '<em><b>Escape Character</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUOTED_TOKEN_DEFINITION__ESCAPE_CHARACTER = eINSTANCE.getQuotedTokenDefinition_EscapeCharacter();

		/**
		 * The meta object literal for the '<em><b>Synthesized Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUOTED_TOKEN_DEFINITION__SYNTHESIZED_REGEX = eINSTANCE.getQuotedTokenDefinition_SynthesizedRegex();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.TokenPriorityDirectiveImpl <em>Token Priority Directive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.TokenPriorityDirectiveImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenPriorityDirective()
		 * @generated
		 */
		EClass TOKEN_PRIORITY_DIRECTIVE = eINSTANCE.getTokenPriorityDirective();

		/**
		 * The meta object literal for the '<em><b>Token</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN_PRIORITY_DIRECTIVE__TOKEN = eINSTANCE.getTokenPriorityDirective_Token();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.ContainmentImpl <em>Containment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.ContainmentImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getContainment()
		 * @generated
		 */
		EClass CONTAINMENT = eINSTANCE.getContainment();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINMENT__TYPES = eINSTANCE.getContainment_Types();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.PlaceholderImpl <em>Placeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.PlaceholderImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPlaceholder()
		 * @generated
		 */
		EClass PLACEHOLDER = eINSTANCE.getPlaceholder();

		/**
		 * The meta object literal for the '<em><b>Token</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACEHOLDER__TOKEN = eINSTANCE.getPlaceholder_Token();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.PlaceholderUsingSpecifiedTokenImpl <em>Placeholder Using Specified Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.PlaceholderUsingSpecifiedTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPlaceholderUsingSpecifiedToken()
		 * @generated
		 */
		EClass PLACEHOLDER_USING_SPECIFIED_TOKEN = eINSTANCE.getPlaceholderUsingSpecifiedToken();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.PlaceholderUsingDefaultTokenImpl <em>Placeholder Using Default Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.PlaceholderUsingDefaultTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPlaceholderUsingDefaultToken()
		 * @generated
		 */
		EClass PLACEHOLDER_USING_DEFAULT_TOKEN = eINSTANCE.getPlaceholderUsingDefaultToken();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.PlaceholderInQuotesImpl <em>Placeholder In Quotes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.PlaceholderInQuotesImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPlaceholderInQuotes()
		 * @generated
		 */
		EClass PLACEHOLDER_IN_QUOTES = eINSTANCE.getPlaceholderInQuotes();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEHOLDER_IN_QUOTES__PREFIX = eINSTANCE.getPlaceholderInQuotes_Prefix();

		/**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEHOLDER_IN_QUOTES__SUFFIX = eINSTANCE.getPlaceholderInQuotes_Suffix();

		/**
		 * The meta object literal for the '<em><b>Escape Character</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLACEHOLDER_IN_QUOTES__ESCAPE_CHARACTER = eINSTANCE.getPlaceholderInQuotes_EscapeCharacter();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.BooleanTerminalImpl <em>Boolean Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.BooleanTerminalImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getBooleanTerminal()
		 * @generated
		 */
		EClass BOOLEAN_TERMINAL = eINSTANCE.getBooleanTerminal();

		/**
		 * The meta object literal for the '<em><b>True Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_TERMINAL__TRUE_LITERAL = eINSTANCE.getBooleanTerminal_TrueLiteral();

		/**
		 * The meta object literal for the '<em><b>False Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_TERMINAL__FALSE_LITERAL = eINSTANCE.getBooleanTerminal_FalseLiteral();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.EnumTerminalImpl <em>Enum Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.EnumTerminalImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getEnumTerminal()
		 * @generated
		 */
		EClass ENUM_TERMINAL = eINSTANCE.getEnumTerminal();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_TERMINAL__LITERALS = eINSTANCE.getEnumTerminal_Literals();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.EnumLiteralTerminalImpl <em>Enum Literal Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.EnumLiteralTerminalImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getEnumLiteralTerminal()
		 * @generated
		 */
		EClass ENUM_LITERAL_TERMINAL = eINSTANCE.getEnumLiteralTerminal();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_TERMINAL__LITERAL = eINSTANCE.getEnumLiteralTerminal_Literal();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL_TERMINAL__TEXT = eINSTANCE.getEnumLiteralTerminal_Text();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.OptionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__TYPE = eINSTANCE.getOption_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__VALUE = eINSTANCE.getOption_Value();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.AbstractImpl <em>Abstract</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.AbstractImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAbstract()
		 * @generated
		 */
		EClass ABSTRACT = eINSTANCE.getAbstract();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.TokenStyleImpl <em>Token Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.TokenStyleImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenStyle()
		 * @generated
		 */
		EClass TOKEN_STYLE = eINSTANCE.getTokenStyle();

		/**
		 * The meta object literal for the '<em><b>Token Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_STYLE__TOKEN_NAMES = eINSTANCE.getTokenStyle_TokenNames();

		/**
		 * The meta object literal for the '<em><b>Rgb</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_STYLE__RGB = eINSTANCE.getTokenStyle_Rgb();

		/**
		 * The meta object literal for the '<em><b>Font Styles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_STYLE__FONT_STYLES = eINSTANCE.getTokenStyle_FontStyles();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.AnnotationImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__TYPE = eINSTANCE.getAnnotation_Type();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION__PARAMETERS = eINSTANCE.getAnnotation_Parameters();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.AnnotableImpl <em>Annotable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.AnnotableImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAnnotable()
		 * @generated
		 */
		EClass ANNOTABLE = eINSTANCE.getAnnotable();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTABLE__ANNOTATIONS = eINSTANCE.getAnnotable_Annotations();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.KeyValuePairImpl <em>Key Value Pair</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.KeyValuePairImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getKeyValuePair()
		 * @generated
		 */
		EClass KEY_VALUE_PAIR = eINSTANCE.getKeyValuePair();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_VALUE_PAIR__KEY = eINSTANCE.getKeyValuePair_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_VALUE_PAIR__VALUE = eINSTANCE.getKeyValuePair_Value();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.GenClassCacheImpl <em>Gen Class Cache</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.GenClassCacheImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getGenClassCache()
		 * @generated
		 */
		EClass GEN_CLASS_CACHE = eINSTANCE.getGenClassCache();

		/**
		 * The meta object literal for the '<em><b>qualified Interface Name Cache</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_CLASS_CACHE__QUALIFIED_INTERFACE_NAME_CACHE = eINSTANCE.getGenClassCache__qualifiedInterfaceNameCache();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.GenClassCacheEntryImpl <em>Gen Class Cache Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.GenClassCacheEntryImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getGenClassCacheEntry()
		 * @generated
		 */
		EClass GEN_CLASS_CACHE_ENTRY = eINSTANCE.getGenClassCacheEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_CLASS_CACHE_ENTRY__KEY = eINSTANCE.getGenClassCacheEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_CLASS_CACHE_ENTRY__VALUE = eINSTANCE.getGenClassCacheEntry_Value();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.EClassUtilImpl <em>EClass Util</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.EClassUtilImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getEClassUtil()
		 * @generated
		 */
		EClass ECLASS_UTIL = eINSTANCE.getEClassUtil();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.OptionTypes <em>Option Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.OptionTypes
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOptionTypes()
		 * @generated
		 */
		EEnum OPTION_TYPES = eINSTANCE.getOptionTypes();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.FontStyle <em>Font Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.FontStyle
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getFontStyle()
		 * @generated
		 */
		EEnum FONT_STYLE = eINSTANCE.getFontStyle();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.AnnotationType <em>Annotation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.AnnotationType
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getAnnotationType()
		 * @generated
		 */
		EEnum ANNOTATION_TYPE = eINSTANCE.getAnnotationType();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.OperatorAnnotationType <em>Operator Annotation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.OperatorAnnotationType
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOperatorAnnotationType()
		 * @generated
		 */
		EEnum OPERATOR_ANNOTATION_TYPE = eINSTANCE.getOperatorAnnotationType();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.OperatorAnnotationProperty <em>Operator Annotation Property</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.OperatorAnnotationProperty
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOperatorAnnotationProperty()
		 * @generated
		 */
		EEnum OPERATOR_ANNOTATION_PROPERTY = eINSTANCE.getOperatorAnnotationProperty();

	}

} //ConcretesyntaxPackage
