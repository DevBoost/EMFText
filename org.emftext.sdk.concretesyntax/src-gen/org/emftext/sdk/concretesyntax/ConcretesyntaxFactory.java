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
	 * Returns a new object of class '<em>PLUS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PLUS</em>'.
	 * @generated
	 */
	PLUS createPLUS();

	/**
	 * Returns a new object of class '<em>STAR</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STAR</em>'.
	 * @generated
	 */
	STAR createSTAR();

	/**
	 * Returns a new object of class '<em>QUESTIONMARK</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QUESTIONMARK</em>'.
	 * @generated
	 */
	QUESTIONMARK createQUESTIONMARK();

	/**
	 * Returns a new object of class '<em>Compound Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound Definition</em>'.
	 * @generated
	 */
	CompoundDefinition createCompoundDefinition();

	/**
	 * Returns a new object of class '<em>Normal Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Normal Token</em>'.
	 * @generated
	 */
	NormalToken createNormalToken();

	/**
	 * Returns a new object of class '<em>Quoted Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quoted Token</em>'.
	 * @generated
	 */
	QuotedToken createQuotedToken();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConcretesyntaxPackage getConcretesyntaxPackage();

} //ConcretesyntaxFactory
