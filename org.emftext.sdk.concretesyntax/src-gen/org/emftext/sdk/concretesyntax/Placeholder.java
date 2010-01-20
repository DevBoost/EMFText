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
 * A representation of the model object '<em><b>Placeholder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Placeholder#getToken <em>Token</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholder()
 * @model abstract="true"
 * @generated
 */
public interface Placeholder extends Terminal {

	/**
	 * Returns the value of the '<em><b>Token</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeReferences <em>Attribute References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token</em>' reference.
	 * @see #setToken(CompleteTokenDefinition)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholder_Token()
	 * @see org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeReferences
	 * @model opposite="attributeReferences" required="true"
	 * @generated
	 */
	CompleteTokenDefinition getToken();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Placeholder#getToken <em>Token</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token</em>' reference.
	 * @see #getToken()
	 * @generated
	 */
	void setToken(CompleteTokenDefinition value);
} // Placeholder
