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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage
 * @generated
 */
public interface ConcretesyntaxFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ConcretesyntaxFactory eINSTANCE = org.emftext.sdk.concretesyntax.impl.ConcretesyntaxFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Concrete Syntax</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Syntax</em>'.
	 * @generated
	 */
	ConcreteSyntax createConcreteSyntax();

	/**
	 * Returns a new object of class '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import</em>'.
	 * @generated
	 */
	Import createImport();

	/**
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule</em>'.
	 * @generated
	 */
	Rule createRule();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>Cs String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cs String</em>'.
	 * @generated
	 */
	CsString createCsString();

	/**
	 * Returns a new object of class '<em>White Spaces</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>White Spaces</em>'.
	 * @generated
	 */
	WhiteSpaces createWhiteSpaces();

	/**
	 * Returns a new object of class '<em>Line Break</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Break</em>'.
	 * @generated
	 */
	LineBreak createLineBreak();

	/**
	 * Returns a new object of class '<em>Compound Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound Definition</em>'.
	 * @generated
	 */
	CompoundDefinition createCompoundDefinition();

	/**
	 * Returns a new object of class '<em>Regex Composer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Regex Composer</em>'.
	 * @generated
	 */
	RegexComposer createRegexComposer();

	/**
	 * Returns a new object of class '<em>Atomic Regex</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Atomic Regex</em>'.
	 * @generated
	 */
	AtomicRegex createAtomicRegex();

	/**
	 * Returns a new object of class '<em>Regex Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Regex Reference</em>'.
	 * @generated
	 */
	RegexReference createRegexReference();

	/**
	 * Returns a new object of class '<em>Partial Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partial Token Definition</em>'.
	 * @generated
	 */
	PartialTokenDefinition createPartialTokenDefinition();

	/**
	 * Returns a new object of class '<em>Normal Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Token Definition</em>'.
	 * @generated
	 */
	NormalTokenDefinition createNormalTokenDefinition();

	/**
	 * Returns a new object of class '<em>Token Redefinition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Token Redefinition</em>'.
	 * @generated
	 */
	TokenRedefinition createTokenRedefinition();

	/**
	 * Returns a new object of class '<em>Quoted Token Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quoted Token Definition</em>'.
	 * @generated
	 */
	QuotedTokenDefinition createQuotedTokenDefinition();

	/**
	 * Returns a new object of class '<em>Token Priority Directive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Token Priority Directive</em>'.
	 * @generated
	 */
	TokenPriorityDirective createTokenPriorityDirective();

	/**
	 * Returns a new object of class '<em>Containment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Containment</em>'.
	 * @generated
	 */
	Containment createContainment();

	/**
	 * Returns a new object of class '<em>Placeholder Using Specified Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placeholder Using Specified Token</em>'.
	 * @generated
	 */
	PlaceholderUsingSpecifiedToken createPlaceholderUsingSpecifiedToken();

	/**
	 * Returns a new object of class '<em>Placeholder Using Default Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placeholder Using Default Token</em>'.
	 * @generated
	 */
	PlaceholderUsingDefaultToken createPlaceholderUsingDefaultToken();

	/**
	 * Returns a new object of class '<em>Placeholder In Quotes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Placeholder In Quotes</em>'.
	 * @generated
	 */
	PlaceholderInQuotes createPlaceholderInQuotes();

	/**
	 * Returns a new object of class '<em>Boolean Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Terminal</em>'.
	 * @generated
	 */
	BooleanTerminal createBooleanTerminal();

	/**
	 * Returns a new object of class '<em>Enum Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Terminal</em>'.
	 * @generated
	 */
	EnumTerminal createEnumTerminal();

	/**
	 * Returns a new object of class '<em>Enum Literal Terminal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Terminal</em>'.
	 * @generated
	 */
	EnumLiteralTerminal createEnumLiteralTerminal();

	/**
	 * Returns a new object of class '<em>Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Option</em>'.
	 * @generated
	 */
	Option createOption();

	/**
	 * Returns a new object of class '<em>Abstract</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract</em>'.
	 * @generated
	 */
	Abstract createAbstract();

	/**
	 * Returns a new object of class '<em>Token Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Token Style</em>'.
	 * @generated
	 */
	TokenStyle createTokenStyle();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns a new object of class '<em>Key Value Pair</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Value Pair</em>'.
	 * @generated
	 */
	KeyValuePair createKeyValuePair();

	/**
	 * Returns a new object of class '<em>Gen Class Cache</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Class Cache</em>'.
	 * @generated
	 */
	GenClassCache createGenClassCache();

	/**
	 * Returns a new object of class '<em>EClass Util</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClass Util</em>'.
	 * @generated
	 */
	EClassUtil createEClassUtil();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConcretesyntaxPackage getConcretesyntaxPackage();

} //ConcretesyntaxFactory
