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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.generatorconfig.GeneratorConfig#getClassRules <em>Class Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.generatorconfig.GeneratorConfig#getFeatureRules <em>Feature Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getGeneratorConfig()
 * @model
 * @generated
 */
public interface GeneratorConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Class Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.generatorconfig.ClassRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Rules</em>' containment reference list.
	 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getGeneratorConfig_ClassRules()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ClassRule> getClassRules();

	/**
	 * Returns the value of the '<em><b>Feature Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.generatorconfig.FeatureRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Rules</em>' containment reference list.
	 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getGeneratorConfig_FeatureRules()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FeatureRule> getFeatureRules();

} // GeneratorConfig
