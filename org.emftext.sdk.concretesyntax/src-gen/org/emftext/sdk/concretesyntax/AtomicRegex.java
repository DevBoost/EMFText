/**
 * Copyright (c) 2006-2011 
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Regex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.AtomicRegex#getAtomicExpression <em>Atomic Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getAtomicRegex()
 * @model
 * @generated
 */
public interface AtomicRegex extends RegexPart {
	/**
	 * Returns the value of the '<em><b>Atomic Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atomic Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atomic Expression</em>' attribute.
	 * @see #setAtomicExpression(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getAtomicRegex_AtomicExpression()
	 * @model required="true"
	 * @generated
	 */
	String getAtomicExpression();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.AtomicRegex#getAtomicExpression <em>Atomic Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atomic Expression</em>' attribute.
	 * @see #getAtomicExpression()
	 * @generated
	 */
	void setAtomicExpression(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\treturn getAtomicExpression();\r\n'"
	 * @generated
	 */
	String getRegex();

} // AtomicRegex
