/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl <em>Concrete Syntax</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ConcreteSyntaxImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getConcreteSyntax()
	 * @generated
	 */
	int CONCRETE_SYNTAX = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__NAME = 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__IMPORTS = 2;

	/**
	 * The feature id for the '<em><b>Start Symbols</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__START_SYMBOLS = 3;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__RULES = 4;

	/**
	 * The feature id for the '<em><b>All Rules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__ALL_RULES = 5;

	/**
	 * The feature id for the '<em><b>Tokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__TOKENS = 6;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX__OPTIONS = 7;

	/**
	 * The number of structural features of the '<em>Concrete Syntax</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCRETE_SYNTAX_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ImportImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__PREFIX = 0;

	/**
	 * The feature id for the '<em><b>Concrete Syntax</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__CONCRETE_SYNTAX = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.RuleImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getRule()
	 * @generated
	 */
	int RULE = 2;

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
	int CHOICE = 3;

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
	int SEQUENCE = 4;

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
	int DEFINITION = 5;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__CARDINALITY = 0;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.TerminalImpl <em>Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.TerminalImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 6;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__CARDINALITY = DEFINITION__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL__FEATURE = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.CsStringImpl <em>Cs String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.CsStringImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getCsString()
	 * @generated
	 */
	int CS_STRING = 7;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CS_STRING__CARDINALITY = DEFINITION__CARDINALITY;

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
	int WHITE_SPACES = 8;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHITE_SPACES__CARDINALITY = DEFINITION__CARDINALITY;

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
	int LINE_BREAK = 9;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BREAK__CARDINALITY = DEFINITION__CARDINALITY;

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
	int CARDINALITY = 10;

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
	int PLUS = 11;

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
	int STAR = 12;

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
	int QUESTIONMARK = 13;

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
	int COMPOUND_DEFINITION = 14;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION__CARDINALITY = DEFINITION__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION__DEFINITIONS = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl <em>Token Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.TokenDefinitionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getTokenDefinition()
	 * @generated
	 */
	int TOKEN_DEFINITION = 15;

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
	 * The number of structural features of the '<em>Token Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOKEN_DEFINITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.NewDefinedTokenImpl <em>New Defined Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.NewDefinedTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNewDefinedToken()
	 * @generated
	 */
	int NEW_DEFINED_TOKEN = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_DEFINED_TOKEN__NAME = TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_DEFINED_TOKEN__ATTRIBUTE_REFERENCES = TOKEN_DEFINITION__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_DEFINED_TOKEN__ATTRIBUTE_NAME = TOKEN_DEFINITION__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_DEFINED_TOKEN__REGEX = TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Defined Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_DEFINED_TOKEN_FEATURE_COUNT = TOKEN_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.NormalTokenImpl <em>Normal Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.NormalTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNormalToken()
	 * @generated
	 */
	int NORMAL_TOKEN = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__NAME = NEW_DEFINED_TOKEN__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__ATTRIBUTE_REFERENCES = NEW_DEFINED_TOKEN__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__ATTRIBUTE_NAME = NEW_DEFINED_TOKEN__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN__REGEX = NEW_DEFINED_TOKEN__REGEX;

	/**
	 * The number of structural features of the '<em>Normal Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NORMAL_TOKEN_FEATURE_COUNT = NEW_DEFINED_TOKEN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.DecoratedTokenImpl <em>Decorated Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.DecoratedTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDecoratedToken()
	 * @generated
	 */
	int DECORATED_TOKEN = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_TOKEN__NAME = NEW_DEFINED_TOKEN__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_TOKEN__ATTRIBUTE_REFERENCES = NEW_DEFINED_TOKEN__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_TOKEN__ATTRIBUTE_NAME = NEW_DEFINED_TOKEN__ATTRIBUTE_NAME;

	/**
	 * The feature id for the '<em><b>Regex</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_TOKEN__REGEX = NEW_DEFINED_TOKEN__REGEX;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_TOKEN__PREFIX = NEW_DEFINED_TOKEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_TOKEN__SUFFIX = NEW_DEFINED_TOKEN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Decorated Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECORATED_TOKEN_FEATURE_COUNT = NEW_DEFINED_TOKEN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.PreDefinedTokenImpl <em>Pre Defined Token</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.PreDefinedTokenImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPreDefinedToken()
	 * @generated
	 */
	int PRE_DEFINED_TOKEN = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_DEFINED_TOKEN__NAME = TOKEN_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Attribute References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_DEFINED_TOKEN__ATTRIBUTE_REFERENCES = TOKEN_DEFINITION__ATTRIBUTE_REFERENCES;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_DEFINED_TOKEN__ATTRIBUTE_NAME = TOKEN_DEFINITION__ATTRIBUTE_NAME;

	/**
	 * The number of structural features of the '<em>Pre Defined Token</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRE_DEFINED_TOKEN_FEATURE_COUNT = TOKEN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.ContainmentImpl <em>Containment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.ContainmentImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getContainment()
	 * @generated
	 */
	int CONTAINMENT = 20;

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
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT__TYPE = TERMINAL_FEATURE_COUNT + 0;

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
	int PLACEHOLDER = 23;

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
	 * The number of structural features of the '<em>Placeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACEHOLDER_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.DefinedPlaceholderImpl <em>Defined Placeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.DefinedPlaceholderImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDefinedPlaceholder()
	 * @generated
	 */
	int DEFINED_PLACEHOLDER = 21;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_PLACEHOLDER__CARDINALITY = PLACEHOLDER__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_PLACEHOLDER__FEATURE = PLACEHOLDER__FEATURE;

	/**
	 * The feature id for the '<em><b>Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_PLACEHOLDER__TOKEN = PLACEHOLDER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Defined Placeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_PLACEHOLDER_FEATURE_COUNT = PLACEHOLDER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.DerivedPlaceholderImpl <em>Derived Placeholder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.DerivedPlaceholderImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDerivedPlaceholder()
	 * @generated
	 */
	int DERIVED_PLACEHOLDER = 22;

	/**
	 * The feature id for the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PLACEHOLDER__CARDINALITY = PLACEHOLDER__CARDINALITY;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PLACEHOLDER__FEATURE = PLACEHOLDER__FEATURE;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PLACEHOLDER__PREFIX = PLACEHOLDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PLACEHOLDER__SUFFIX = PLACEHOLDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Derived Placeholder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_PLACEHOLDER_FEATURE_COUNT = PLACEHOLDER_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.emftext.sdk.concretesyntax.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.concretesyntax.impl.OptionImpl
	 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__NAME = 0;

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
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getPackage()
	 * @see #getConcreteSyntax()
	 * @generated
	 */
	EReference getConcreteSyntax_Package();

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
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.Import#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see org.emftext.sdk.concretesyntax.Import#getPackage()
	 * @see #getImport()
	 * @generated
	 */
	EReference getImport_Package();

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
	 * Returns the meta object for the containment reference '{@link org.emftext.sdk.concretesyntax.Definition#getCardinality <em>Cardinality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cardinality</em>'.
	 * @see org.emftext.sdk.concretesyntax.Definition#getCardinality()
	 * @see #getDefinition()
	 * @generated
	 */
	EReference getDefinition_Cardinality();

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
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.NormalToken <em>Normal Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Normal Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.NormalToken
	 * @generated
	 */
	EClass getNormalToken();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.DecoratedToken <em>Decorated Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decorated Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.DecoratedToken
	 * @generated
	 */
	EClass getDecoratedToken();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.DecoratedToken#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.emftext.sdk.concretesyntax.DecoratedToken#getPrefix()
	 * @see #getDecoratedToken()
	 * @generated
	 */
	EAttribute getDecoratedToken_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.DecoratedToken#getSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix</em>'.
	 * @see org.emftext.sdk.concretesyntax.DecoratedToken#getSuffix()
	 * @see #getDecoratedToken()
	 * @generated
	 */
	EAttribute getDecoratedToken_Suffix();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.NewDefinedToken <em>New Defined Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Defined Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.NewDefinedToken
	 * @generated
	 */
	EClass getNewDefinedToken();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.NewDefinedToken#getRegex <em>Regex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Regex</em>'.
	 * @see org.emftext.sdk.concretesyntax.NewDefinedToken#getRegex()
	 * @see #getNewDefinedToken()
	 * @generated
	 */
	EAttribute getNewDefinedToken_Regex();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.PreDefinedToken <em>Pre Defined Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pre Defined Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.PreDefinedToken
	 * @generated
	 */
	EClass getPreDefinedToken();

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
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.Containment#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.emftext.sdk.concretesyntax.Containment#getType()
	 * @see #getContainment()
	 * @generated
	 */
	EReference getContainment_Type();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.DefinedPlaceholder <em>Defined Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defined Placeholder</em>'.
	 * @see org.emftext.sdk.concretesyntax.DefinedPlaceholder
	 * @generated
	 */
	EClass getDefinedPlaceholder();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.concretesyntax.DefinedPlaceholder#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Token</em>'.
	 * @see org.emftext.sdk.concretesyntax.DefinedPlaceholder#getToken()
	 * @see #getDefinedPlaceholder()
	 * @generated
	 */
	EReference getDefinedPlaceholder_Token();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.DerivedPlaceholder <em>Derived Placeholder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Placeholder</em>'.
	 * @see org.emftext.sdk.concretesyntax.DerivedPlaceholder
	 * @generated
	 */
	EClass getDerivedPlaceholder();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.DerivedPlaceholder#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.emftext.sdk.concretesyntax.DerivedPlaceholder#getPrefix()
	 * @see #getDerivedPlaceholder()
	 * @generated
	 */
	EAttribute getDerivedPlaceholder_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.DerivedPlaceholder#getSuffix <em>Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix</em>'.
	 * @see org.emftext.sdk.concretesyntax.DerivedPlaceholder#getSuffix()
	 * @see #getDerivedPlaceholder()
	 * @generated
	 */
	EAttribute getDerivedPlaceholder_Suffix();

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
	 * Returns the meta object for class '{@link org.emftext.sdk.concretesyntax.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see org.emftext.sdk.concretesyntax.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.concretesyntax.Option#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.sdk.concretesyntax.Option#getName()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Name();

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
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__PACKAGE = eINSTANCE.getConcreteSyntax_Package();

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
		 * The meta object literal for the '<em><b>Tokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCRETE_SYNTAX__TOKENS = eINSTANCE.getConcreteSyntax_Tokens();

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
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT__PACKAGE = eINSTANCE.getImport_Package();

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
		 * The meta object literal for the '<em><b>Cardinality</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINITION__CARDINALITY = eINSTANCE.getDefinition_Cardinality();

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
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.NormalTokenImpl <em>Normal Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.NormalTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNormalToken()
		 * @generated
		 */
		EClass NORMAL_TOKEN = eINSTANCE.getNormalToken();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.DecoratedTokenImpl <em>Decorated Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.DecoratedTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDecoratedToken()
		 * @generated
		 */
		EClass DECORATED_TOKEN = eINSTANCE.getDecoratedToken();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECORATED_TOKEN__PREFIX = eINSTANCE.getDecoratedToken_Prefix();

		/**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECORATED_TOKEN__SUFFIX = eINSTANCE.getDecoratedToken_Suffix();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.NewDefinedTokenImpl <em>New Defined Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.NewDefinedTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getNewDefinedToken()
		 * @generated
		 */
		EClass NEW_DEFINED_TOKEN = eINSTANCE.getNewDefinedToken();

		/**
		 * The meta object literal for the '<em><b>Regex</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_DEFINED_TOKEN__REGEX = eINSTANCE.getNewDefinedToken_Regex();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.PreDefinedTokenImpl <em>Pre Defined Token</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.PreDefinedTokenImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getPreDefinedToken()
		 * @generated
		 */
		EClass PRE_DEFINED_TOKEN = eINSTANCE.getPreDefinedToken();

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
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINMENT__TYPE = eINSTANCE.getContainment_Type();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.DefinedPlaceholderImpl <em>Defined Placeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.DefinedPlaceholderImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDefinedPlaceholder()
		 * @generated
		 */
		EClass DEFINED_PLACEHOLDER = eINSTANCE.getDefinedPlaceholder();

		/**
		 * The meta object literal for the '<em><b>Token</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINED_PLACEHOLDER__TOKEN = eINSTANCE.getDefinedPlaceholder_Token();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.DerivedPlaceholderImpl <em>Derived Placeholder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.DerivedPlaceholderImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getDerivedPlaceholder()
		 * @generated
		 */
		EClass DERIVED_PLACEHOLDER = eINSTANCE.getDerivedPlaceholder();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DERIVED_PLACEHOLDER__PREFIX = eINSTANCE.getDerivedPlaceholder_Prefix();

		/**
		 * The meta object literal for the '<em><b>Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DERIVED_PLACEHOLDER__SUFFIX = eINSTANCE.getDerivedPlaceholder_Suffix();

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
		 * The meta object literal for the '{@link org.emftext.sdk.concretesyntax.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.concretesyntax.impl.OptionImpl
		 * @see org.emftext.sdk.concretesyntax.impl.ConcretesyntaxPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__NAME = eINSTANCE.getOption_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__VALUE = eINSTANCE.getOption_Value();

	}

} //ConcretesyntaxPackage
