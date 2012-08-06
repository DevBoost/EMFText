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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Rule Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.generatorconfig.ClassRuleReference#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getClassRuleReference()
 * @model
 * @generated
 */
public interface ClassRuleReference extends ClassContext {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' reference.
	 * @see #setRule(GeneratorRule)
	 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getClassRuleReference_Rule()
	 * @model required="true"
	 * @generated
	 */
	GeneratorRule getRule();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.generatorconfig.ClassRuleReference#getRule <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(GeneratorRule value);

} // ClassRuleReference
