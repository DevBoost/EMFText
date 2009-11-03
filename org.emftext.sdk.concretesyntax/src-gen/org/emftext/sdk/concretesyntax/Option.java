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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Option#getType <em>Type</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Option#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOption()
 * @model
 * @generated
 */
public interface Option extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emftext.sdk.concretesyntax.OptionTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.emftext.sdk.concretesyntax.OptionTypes
	 * @see #setType(OptionTypes)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOption_Type()
	 * @model required="true"
	 * @generated
	 */
	OptionTypes getType();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Option#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.emftext.sdk.concretesyntax.OptionTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(OptionTypes value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getOption_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Option#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Option
