/*******************************************************************************
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
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.generatorconfig;

import org.eclipse.emf.ecore.EObject;

import org.emftext.sdk.concretesyntax.Sequence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.generatorconfig.GeneratorRule#getName <em>Name</em>}</li>
 *   <li>{@link org.emftext.sdk.generatorconfig.GeneratorRule#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getGeneratorRule()
 * @model
 * @generated
 */
public interface GeneratorRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getGeneratorRule_Name()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.generatorconfig.GeneratorRule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' containment reference.
	 * @see #setDefinition(Sequence)
	 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getGeneratorRule_Definition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Sequence getDefinition();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.generatorconfig.GeneratorRule#getDefinition <em>Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' containment reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Sequence value);

} // GeneratorRule
