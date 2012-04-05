/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *  *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 *  
 * 
 */
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
public interface CardinalityDefinition extends Definition {
	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emftext.sdk.concretesyntax.Cardinality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' attribute.
	 * @see org.emftext.sdk.concretesyntax.Cardinality
	 * @see #setCardinality(Cardinality)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCardinalityDefinition_Cardinality()
	 * @model
	 * @generated
	 */
	Cardinality getCardinality();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.CardinalityDefinition#getCardinality <em>Cardinality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' attribute.
	 * @see org.emftext.sdk.concretesyntax.Cardinality
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(Cardinality value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\treturn getCardinality() ==  org.emftext.sdk.concretesyntax.Cardinality.NONE || getCardinality() ==  org.emftext.sdk.concretesyntax.Cardinality.PLUS;\r\n'"
	 * @generated
	 */
	boolean hasMinimalCardinalityOneOrHigher();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\treturn !\r\n\t\t\t(getCardinality() ==  org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK ||\r\n\t\t\t getCardinality() ==  org.emftext.sdk.concretesyntax.Cardinality.STAR);\r\n'"
	 * @generated
	 */
	boolean hasNoOptionalPart();

} // CardinalityDefinition
