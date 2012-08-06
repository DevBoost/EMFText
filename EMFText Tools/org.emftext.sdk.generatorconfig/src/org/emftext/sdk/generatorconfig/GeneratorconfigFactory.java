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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage
 * @generated
 */
public interface GeneratorconfigFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorconfigFactory eINSTANCE = org.emftext.sdk.generatorconfig.impl.GeneratorconfigFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Generator Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generator Config</em>'.
	 * @generated
	 */
	GeneratorConfig createGeneratorConfig();

	/**
	 * Returns a new object of class '<em>Generator Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generator Rule</em>'.
	 * @generated
	 */
	GeneratorRule createGeneratorRule();

	/**
	 * Returns a new object of class '<em>Class Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Rule</em>'.
	 * @generated
	 */
	ClassRule createClassRule();

	/**
	 * Returns a new object of class '<em>Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Rule</em>'.
	 * @generated
	 */
	FeatureRule createFeatureRule();

	/**
	 * Returns a new object of class '<em>Class Rule Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Rule Reference</em>'.
	 * @generated
	 */
	ClassRuleReference createClassRuleReference();

	/**
	 * Returns a new object of class '<em>Feature Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Reference</em>'.
	 * @generated
	 */
	FeatureReference createFeatureReference();

	/**
	 * Returns a new object of class '<em>Features</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Features</em>'.
	 * @generated
	 */
	Features createFeatures();

	/**
	 * Returns a new object of class '<em>Class Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Name</em>'.
	 * @generated
	 */
	ClassName createClassName();

	/**
	 * Returns a new object of class '<em>Feature Rule Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Rule Reference</em>'.
	 * @generated
	 */
	FeatureRuleReference createFeatureRuleReference();

	/**
	 * Returns a new object of class '<em>Feature Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Name</em>'.
	 * @generated
	 */
	FeatureName createFeatureName();

	/**
	 * Returns a new object of class '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature</em>'.
	 * @generated
	 */
	Feature createFeature();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GeneratorconfigPackage getGeneratorconfigPackage();

} //GeneratorconfigFactory
