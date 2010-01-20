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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeReferences <em>Attribute References</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#isHidden <em>Hidden</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#isUsed <em>Used</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompleteTokenDefinition()
 * @model abstract="true"
 * @generated
 */
public interface CompleteTokenDefinition extends AbstractTokenDefinition, TokenDirective, RegexOwner {
	/**
	 * Returns the value of the '<em><b>Attribute References</b></em>' reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.Placeholder}.
	 * It is bidirectional and its opposite is '{@link org.emftext.sdk.concretesyntax.Placeholder#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute References</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompleteTokenDefinition_AttributeReferences()
	 * @see org.emftext.sdk.concretesyntax.Placeholder#getToken
	 * @model opposite="token"
	 * @generated
	 */
	EList<Placeholder> getAttributeReferences();

	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompleteTokenDefinition_AttributeName()
	 * @model
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

	/**
	 * Returns the value of the '<em><b>Hidden</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hidden</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hidden</em>' attribute.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompleteTokenDefinition_Hidden()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isHidden();

	/**
	 * Returns the value of the '<em><b>Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used</em>' attribute.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompleteTokenDefinition_Used()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isUsed();

} // TokenDefinition
