/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
	 * The feature id for the '<em><b>Modifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__MODIFIER = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__NAME = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Symbols</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__START_SYMBOLS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Active Start Symbols</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ACTIVE_START_SYMBOLS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>All Start Symbols</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ALL_START_SYMBOLS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>All Tokens</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ALL_TOKENS = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__RULES = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>All Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ALL_RULES = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Concrete Syntax</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_FEATURE_COUNT = GEN_PACKAGE_DEPENDENT_ELEMENT_FEATURE_COUNT + 14;

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
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.RuleImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 3;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__METACLASS = 1;

	/**
	 * The feature id for the '<em><b>Syntax</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__SYNTAX = 2;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ChoiceImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 4;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__OPTIONS = 0;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.SequenceImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 5;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__PARTS = 0;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.DefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.DefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDefinition()
	 * @generated
	 */
	int DEFINITION = 6;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.CardinalityDefinitionImpl <em>Cardinality Definition</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.CardinalityDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCardinalityDefinition()
	 * @generated
	 */
  int CARDINALITY_DEFINITION = 7;

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
	int TERMINAL = 8;

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
	int CS_STRING = 9;

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
	int WHITE_SPACES = 10;

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
	int LINE_BREAK = 11;

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
	int CARDINALITY = 12;

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
	int PLUS = 13;

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
	int STAR = 14;

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
	int QUESTIONMARK = 15;

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
	int COMPOUND_DEFINITION = 16;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION__CARDINALITY = CARDINALITY_DEFINITION__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION__DEFINITIONS = CARDINALITY_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION_FEATURE_COUNT = CARDINALITY_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl <em>Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenDefinition()
	 * @generated
	 */
	int TOKEN_DEFINITION = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DEFINITION__ATTRIBUTE_REFERENCES = 1;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DEFINITION__ATTRIBUTE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DEFINITION__REGEX = 3;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DEFINITION__HIDDEN = 4;

	/**
	 * The feature id for the '<em><b>Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DEFINITION__USED = 5;

	/**
	 * The number of structural features of the '<em>Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DEFINITION_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.NormalTokenImpl <em>Normal Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.NormalTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNormalToken()
	 * @generated
	 */
	int NORMAL_TOKEN = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__NAME = TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__ATTRIBUTE_REFERENCES = TOKEN_DEFINITION__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__ATTRIBUTE_NAME = TOKEN_DEFINITION__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__REGEX = TOKEN_DEFINITION__REGEX;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__HIDDEN = TOKEN_DEFINITION__HIDDEN;

	/**
	 * The feature id for the '<em><b>Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__USED = TOKEN_DEFINITION__USED;

	/**
	 * The number of structural features of the '<em>Normal Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_FEATURE_COUNT = TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.QuotedTokenImpl <em>Quoted Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.QuotedTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getQuotedToken()
	 * @generated
	 */
	int QUOTED_TOKEN = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN__NAME = TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN__ATTRIBUTE_REFERENCES = TOKEN_DEFINITION__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN__ATTRIBUTE_NAME = TOKEN_DEFINITION__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN__REGEX = TOKEN_DEFINITION__REGEX;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN__HIDDEN = TOKEN_DEFINITION__HIDDEN;

	/**
	 * The feature id for the '<em><b>Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN__USED = TOKEN_DEFINITION__USED;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN__PREFIX = TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN__SUFFIX = TOKEN_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Quoted Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUOTED_TOKEN_FEATURE_COUNT = TOKEN_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.PredefinedTokenImpl <em>Predefined Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.PredefinedTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPredefinedToken()
	 * @generated
	 */
	int PREDEFINED_TOKEN = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_TOKEN__NAME = TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_TOKEN__ATTRIBUTE_REFERENCES = TOKEN_DEFINITION__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_TOKEN__ATTRIBUTE_NAME = TOKEN_DEFINITION__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_TOKEN__REGEX = TOKEN_DEFINITION__REGEX;

	/**
	 * The feature id for the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_TOKEN__HIDDEN = TOKEN_DEFINITION__HIDDEN;

	/**
	 * The feature id for the '<em><b>Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_TOKEN__USED = TOKEN_DEFINITION__USED;

	/**
	 * The number of structural features of the '<em>Predefined Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDEFINED_TOKEN_FEATURE_COUNT = TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ContainmentImpl <em>Containment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ContainmentImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getContainment()
	 * @generated
	 */
	int CONTAINMENT = 21;

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
	int PLACEHOLDER = 22;

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
	int PLACEHOLDER_USING_SPECIFIED_TOKEN = 23;

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
	int PLACEHOLDER_USING_DEFAULT_TOKEN = 24;

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
	int PLACEHOLDER_IN_QUOTES = 25;

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
	 * The number of structural features of the '<em>Placeholder In Quotes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_IN_QUOTES_FEATURE_COUNT = PLACEHOLDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.OptionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 26;

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
	int ABSTRACT = 27;

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
	int TOKEN_STYLE = 28;

	/**
	 * The feature id for the '<em><b>Token Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_STYLE__TOKEN_NAME = 0;

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
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.OptionTypes <em>Option Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.OptionTypes
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOptionTypes()
	 * @generated
	 */
	int OPTION_TYPES = 29;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.FontStyle <em>Font Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.FontStyle
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getFontStyle()
	 * @generated
	 */
	int FONT_STYLE = 30;


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
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getActiveStartSymbols <em>Active Start Symbols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Active Start Symbols</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getActiveStartSymbols()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_ActiveStartSymbols();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllStartSymbols <em>All Start Symbols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Start Symbols</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllStartSymbols()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_AllStartSymbols();

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
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllRules <em>All Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Rules</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllRules()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_AllRules();

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
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokens <em>All Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>All Tokens</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getAllTokens()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_AllTokens();

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
	 * Returns the meta object for the containment reference '{@link org.emftext.sdk.concretesyntax.Rule#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.Rule#getDefinition()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Definition();

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
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see org.emftext.sdk.concretesyntax.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.Choice#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see org.emftext.sdk.concretesyntax.Choice#getOptions()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_Options();

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
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.concretesyntax.Sequence#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.emftext.sdk.concretesyntax.Sequence#getParts()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Parts();

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
	 * Returns the meta object for the containment reference '{@link org.emftext.sdk.concretesyntax.CompoundDefinition#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definitions</em>'.
	 * @see org.emftext.sdk.concretesyntax.CompoundDefinition#getDefinitions()
	 * @see #getCompoundDefinition()
	 * @generated
	 */
	EReference getCompoundDefinition_Definitions();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.TokenDefinition <em>Token Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Token Definition</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenDefinition
	 * @generated
	 */
	EClass getTokenDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.TokenDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenDefinition#getName()
	 * @see #getTokenDefinition()
	 * @generated
	 */
	EAttribute getTokenDefinition_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.emftext.sdk.concretesyntax.TokenDefinition#getAttributeReferences <em>Attribute References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attribute References</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenDefinition#getAttributeReferences()
	 * @see #getTokenDefinition()
	 * @generated
	 */
	EReference getTokenDefinition_AttributeReferences();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.TokenDefinition#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenDefinition#getAttributeName()
	 * @see #getTokenDefinition()
	 * @generated
	 */
	EAttribute getTokenDefinition_AttributeName();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.TokenDefinition#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenDefinition#getRegex()
	 * @see #getTokenDefinition()
	 * @generated
	 */
	EAttribute getTokenDefinition_Regex();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.TokenDefinition#isHidden <em>Hidden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hidden</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenDefinition#isHidden()
	 * @see #getTokenDefinition()
	 * @generated
	 */
	EAttribute getTokenDefinition_Hidden();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.TokenDefinition#isUsed <em>Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Used</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenDefinition#isUsed()
	 * @see #getTokenDefinition()
	 * @generated
	 */
	EAttribute getTokenDefinition_Used();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.NormalToken <em>Normal Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.NormalToken
	 * @generated
	 */
	EClass getNormalToken();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.QuotedToken <em>Quoted Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quoted Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.QuotedToken
	 * @generated
	 */
	EClass getQuotedToken();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.QuotedToken#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.emftext.sdk.concretesyntax.QuotedToken#getPrefix()
	 * @see #getQuotedToken()
	 * @generated
	 */
	EAttribute getQuotedToken_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.QuotedToken#getSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix</em>'.
	 * @see org.emftext.sdk.concretesyntax.QuotedToken#getSuffix()
	 * @see #getQuotedToken()
	 * @generated
	 */
	EAttribute getQuotedToken_Suffix();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.PredefinedToken <em>Predefined Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predefined Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.PredefinedToken
	 * @generated
	 */
	EClass getPredefinedToken();

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
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.TokenStyle#getTokenName <em>Token Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Token Name</em>'.
	 * @see org.emftext.sdk.concretesyntax.TokenStyle#getTokenName()
	 * @see #getTokenStyle()
	 * @generated
	 */
	EAttribute getTokenStyle_TokenName();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCRETE_SYNTAX__NAME = eINSTANCE.getConcreteSyntax_Name();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__IMPORTS = eINSTANCE.getConcreteSyntax_Imports();

		/**
		 * The meta object literal for the '<em><b>Start Symbols</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__START_SYMBOLS = eINSTANCE.getConcreteSyntax_StartSymbols();

		/**
		 * The meta object literal for the '<em><b>Active Start Symbols</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__ACTIVE_START_SYMBOLS = eINSTANCE.getConcreteSyntax_ActiveStartSymbols();

		/**
		 * The meta object literal for the '<em><b>All Start Symbols</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__ALL_START_SYMBOLS = eINSTANCE.getConcreteSyntax_AllStartSymbols();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__RULES = eINSTANCE.getConcreteSyntax_Rules();

		/**
		 * The meta object literal for the '<em><b>All Rules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__ALL_RULES = eINSTANCE.getConcreteSyntax_AllRules();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__MODIFIER = eINSTANCE.getConcreteSyntax_Modifier();

		/**
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__TOKENS = eINSTANCE.getConcreteSyntax_Tokens();

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
		 * The meta object literal for the '<em><b>Synthetic Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__SYNTHETIC_TOKENS = eINSTANCE.getConcreteSyntax_SyntheticTokens();

		/**
		 * The meta object literal for the '<em><b>All Tokens</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__ALL_TOKENS = eINSTANCE.getConcreteSyntax_AllTokens();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__OPTIONS = eINSTANCE.getConcreteSyntax_Options();

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
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__DEFINITION = eINSTANCE.getRule_Definition();

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
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.ChoiceImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__OPTIONS = eINSTANCE.getChoice_Options();

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
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__PARTS = eINSTANCE.getSequence_Parts();

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
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_DEFINITION__DEFINITIONS = eINSTANCE.getCompoundDefinition_Definitions();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl <em>Token Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenDefinition()
		 * @generated
		 */
		EClass TOKEN_DEFINITION = eINSTANCE.getTokenDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_DEFINITION__NAME = eINSTANCE.getTokenDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Attribute References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOKEN_DEFINITION__ATTRIBUTE_REFERENCES = eINSTANCE.getTokenDefinition_AttributeReferences();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_DEFINITION__ATTRIBUTE_NAME = eINSTANCE.getTokenDefinition_AttributeName();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_DEFINITION__REGEX = eINSTANCE.getTokenDefinition_Regex();

		/**
		 * The meta object literal for the '<em><b>Hidden</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_DEFINITION__HIDDEN = eINSTANCE.getTokenDefinition_Hidden();

		/**
		 * The meta object literal for the '<em><b>Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_DEFINITION__USED = eINSTANCE.getTokenDefinition_Used();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.NormalTokenImpl <em>Normal Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.NormalTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNormalToken()
		 * @generated
		 */
		EClass NORMAL_TOKEN = eINSTANCE.getNormalToken();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.QuotedTokenImpl <em>Quoted Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.QuotedTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getQuotedToken()
		 * @generated
		 */
		EClass QUOTED_TOKEN = eINSTANCE.getQuotedToken();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUOTED_TOKEN__PREFIX = eINSTANCE.getQuotedToken_Prefix();

		/**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUOTED_TOKEN__SUFFIX = eINSTANCE.getQuotedToken_Suffix();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.PredefinedTokenImpl <em>Predefined Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.PredefinedTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPredefinedToken()
		 * @generated
		 */
		EClass PREDEFINED_TOKEN = eINSTANCE.getPredefinedToken();

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
		 * The meta object literal for the '<em><b>Token Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOKEN_STYLE__TOKEN_NAME = eINSTANCE.getTokenStyle_TokenName();

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

	}

} //ConcretesyntaxPackage
