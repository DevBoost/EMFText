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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Rule#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Rule#getMetaclass <em>Metaclass</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Rule#getSyntax <em>Syntax</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends Annotable {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(Choice)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRule_Definition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Choice getDefinition();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Rule#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Choice value);

	/**
	 * Returns the value of the '<em><b>Metaclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metaclass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metaclass</em>' reference.
	 * @see #setMetaclass(GenClass)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRule_Metaclass()
	 * @model required="true"
	 * @generated
	 */
	GenClass getMetaclass();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Rule#getMetaclass <em>Metaclass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metaclass</em>' reference.
	 * @see #getMetaclass()
	 * @generated
	 */
	void setMetaclass(GenClass value);

	/**
	 * Returns the value of the '<em><b>Syntax</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syntax</em>' container reference.
	 * @see #setSyntax(ConcreteSyntax)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRule_Syntax()
	 * @see org.emftext.sdk.concretesyntax.ConcreteSyntax#getRules
	 * @model opposite="rules" required="true" transient="false"
	 * @generated
	 */
	ConcreteSyntax getSyntax();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Rule#getSyntax <em>Syntax</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syntax</em>' container reference.
	 * @see #getSyntax()
	 * @generated
	 */
	void setSyntax(ConcreteSyntax value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Annotation getOperatorAnnotation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	int getOperatorWeight();

} // Rule
