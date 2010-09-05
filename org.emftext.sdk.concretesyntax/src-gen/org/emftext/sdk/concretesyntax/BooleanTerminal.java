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
 */
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.BooleanTerminal#getTrueLiteral <em>True Literal</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.BooleanTerminal#getFalseLiteral <em>False Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getBooleanTerminal()
 * @model
 * @generated
 */
public interface BooleanTerminal extends Terminal {
	/**
	 * Returns the value of the '<em><b>True Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True Literal</em>' attribute.
	 * @see #setTrueLiteral(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getBooleanTerminal_TrueLiteral()
	 * @model required="true"
	 * @generated
	 */
	String getTrueLiteral();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.BooleanTerminal#getTrueLiteral <em>True Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True Literal</em>' attribute.
	 * @see #getTrueLiteral()
	 * @generated
	 */
	void setTrueLiteral(String value);

	/**
	 * Returns the value of the '<em><b>False Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>False Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>False Literal</em>' attribute.
	 * @see #setFalseLiteral(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getBooleanTerminal_FalseLiteral()
	 * @model required="true"
	 * @generated
	 */
	String getFalseLiteral();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.BooleanTerminal#getFalseLiteral <em>False Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>False Literal</em>' attribute.
	 * @see #getFalseLiteral()
	 * @generated
	 */
	void setFalseLiteral(String value);

} // BooleanTerminal
