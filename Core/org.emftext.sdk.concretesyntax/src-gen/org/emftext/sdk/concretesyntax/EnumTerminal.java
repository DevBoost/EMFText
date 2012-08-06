/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return !getEmptyLiterals().isEmpty();'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal> nonEmptyLiterals = new org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal>();\nfor ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal : getLiterals()) {\n\tjava.lang.String text = literal.getText();\n\tif (text != null && !\"\".equals(text)) {\n\t\tnonEmptyLiterals.add(literal);\n\t}\n}\nreturn nonEmptyLiterals;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal> emptyLiterals = new org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.EnumLiteralTerminal>();\nfor ( org.emftext.sdk.concretesyntax.EnumLiteralTerminal literal : getLiterals()) {\n\tjava.lang.String text = literal.getText();\n\tif (\"\".equals(text)) {\n\t\temptyLiterals.add(literal);\n\t}\n}\nreturn emptyLiterals;'"
	 * @generated
	 */
	EList<EnumLiteralTerminal> getEmptyLiterals();

} // EnumTerminal
