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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regex Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.RegexComposite#getRegexParts <em>Regex Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexComposite()
 * @model abstract="true"
 * @generated
 */
public interface RegexComposite extends RegexOwner {
	/**
	 * Returns the value of the '<em><b>Regex Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.RegexPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regex Parts</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexComposite_RegexParts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<RegexPart> getRegexParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t java.lang.StringBuilder result = new  java.lang.StringBuilder();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.RegexPart part : getRegexParts()) {\r\n\t\t\tresult.append(part.getRegex());\r\n\t\t}\r\n\r\n\t\treturn result.toString();\r\n'"
	 * @generated
	 */
	String getRegex();

} // RegexComposite
