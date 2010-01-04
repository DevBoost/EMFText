/*******************************************************************************
 * Copyright (c) 2006-2010 
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
 * A representation of the model object '<em><b>Cardinality Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.CardinalityDefinition#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCardinalityDefinition()
 * @model abstract="true"
 * @generated
 */
public interface CardinalityDefinition extends Definition
{
  /**
	 * Returns the value of the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cardinality</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' containment reference.
	 * @see #setCardinality(Cardinality)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCardinalityDefinition_Cardinality()
	 * @model containment="true"
	 * @generated
	 */
  Cardinality getCardinality();

  /**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.CardinalityDefinition#getCardinality <em>Cardinality</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' containment reference.
	 * @see #getCardinality()
	 * @generated
	 */
  void setCardinality(Cardinality value);

} // CardinalityDefinition
