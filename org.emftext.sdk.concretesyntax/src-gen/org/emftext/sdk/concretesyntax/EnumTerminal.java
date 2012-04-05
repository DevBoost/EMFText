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
 * A representation of the model object '<em><b>Enum Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.EnumTerminal#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getEnumTerminal()
 * @model
 * @generated
 */
public interface EnumTerminal extends Terminal {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.EnumLiteralTerminal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getEnumTerminal_Literals()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EnumLiteralTerminal> getLiterals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\treturn !getEmptyLiterals().isEmpty();\r\n'"
	 * @generated
	 */
	boolean containsEmptyLiteral();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal> nonEmptyLiterals = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal>();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal : getLiterals()) {\r\n\t\t\t java.lang.String text = literal.getText();\r\n\t\t\tif (text != null && !\"\".equals(text)) {\r\n\t\t\t\tnonEmptyLiterals.add(literal);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn nonEmptyLiterals;\r\n'"
	 * @generated
	 */
	EList<EnumLiteralTerminal> getNonEmptyLiterals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal> emptyLiterals = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal>();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal : getLiterals()) {\r\n\t\t\t java.lang.String text = literal.getText();\r\n\t\t\tif (\"\".equals(text)) {\r\n\t\t\t\temptyLiterals.add(literal);\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn emptyLiterals;\r\n'"
	 * @generated
	 */
	EList<EnumLiteralTerminal> getEmptyLiterals();

} // EnumTerminal
