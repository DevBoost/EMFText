/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Placeholder In Quotes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getEscapeCharacter <em>Escape Character</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholderInQuotes()
 * @model
 * @generated
 */
public interface PlaceholderInQuotes extends Placeholder {
	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholderInQuotes_Prefix()
	 * @model default="" required="true"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffix</em>' attribute.
	 * @see #setSuffix(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholderInQuotes_Suffix()
	 * @model default="" required="true"
	 * @generated
	 */
	String getSuffix();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getSuffix <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' attribute.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Escape Character</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Escape Character</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Escape Character</em>' attribute.
	 * @see #setEscapeCharacter(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholderInQuotes_EscapeCharacter()
	 * @model
	 * @generated
	 */
	String getEscapeCharacter();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getEscapeCharacter <em>Escape Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escape Character</em>' attribute.
	 * @see #getEscapeCharacter()
	 * @generated
	 */
	void setEscapeCharacter(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getNormalizedPrefix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getNormalizedSuffix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getNormalizedEscapeCharacter();

} // PlaceholderInQuotes
