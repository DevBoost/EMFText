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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regex Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.RegexReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexReference()
 * @model
 * @generated
 */
public interface RegexReference extends RegexPart {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(AbstractTokenDefinition)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexReference_Target()
	 * @model required="true"
	 * @generated
	 */
	AbstractTokenDefinition getTarget();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.RegexReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(AbstractTokenDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.emftext.sdk.concretesyntax.AbstractTokenDefinition target = getTarget ( ) ; \r\nif ( target == null || target .eIsProxy ( ) ) { \r\n\treturn \"\" ; \r\n} else { \r\n\tassert target instanceof org.emftext.sdk.concretesyntax.RegexOwner ; \r\n\treturn ( ( org.emftext.sdk.concretesyntax.RegexOwner ) target ) .getRegex ( ) ; \r\n} \r\n'"
	 * @generated
	 */
	String getRegex();

} // RegexReference
