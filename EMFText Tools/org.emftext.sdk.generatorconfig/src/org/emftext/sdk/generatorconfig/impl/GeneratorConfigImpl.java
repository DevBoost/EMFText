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
package org.emftext.sdk.generatorconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.sdk.generatorconfig.ClassRule;
import org.emftext.sdk.generatorconfig.FeatureRule;
import org.emftext.sdk.generatorconfig.GeneratorConfig;
import org.emftext.sdk.generatorconfig.GeneratorconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.generatorconfig.impl.GeneratorConfigImpl#getClassRules <em>Class Rules</em>}</li>
 *   <li>{@link org.emftext.sdk.generatorconfig.impl.GeneratorConfigImpl#getFeatureRules <em>Feature Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneratorConfigImpl extends EObjectImpl implements GeneratorConfig {
	/**
	 * The cached value of the '{@link #getClassRules() <em>Class Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassRules()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassRule> classRules;

	/**
	 * The cached value of the '{@link #getFeatureRules() <em>Feature Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureRules()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureRule> featureRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratorConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorconfigPackage.Literals.GENERATOR_CONFIG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassRule> getClassRules() {
		if (classRules == null) {
			classRules = new EObjectContainmentEList<ClassRule>(ClassRule.class, this, GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES);
		}
		return classRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureRule> getFeatureRules() {
		if (featureRules == null) {
			featureRules = new EObjectContainmentEList<FeatureRule>(FeatureRule.class, this, GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES);
		}
		return featureRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES:
				return ((InternalEList<?>)getClassRules()).basicRemove(otherEnd, msgs);
			case GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES:
				return ((InternalEList<?>)getFeatureRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES:
				return getClassRules();
			case GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES:
				return getFeatureRules();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES:
				getClassRules().clear();
				getClassRules().addAll((Collection<? extends ClassRule>)newValue);
				return;
			case GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES:
				getFeatureRules().clear();
				getFeatureRules().addAll((Collection<? extends FeatureRule>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES:
				getClassRules().clear();
				return;
			case GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES:
				getFeatureRules().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneratorconfigPackage.GENERATOR_CONFIG__CLASS_RULES:
				return classRules != null && !classRules.isEmpty();
			case GeneratorconfigPackage.GENERATOR_CONFIG__FEATURE_RULES:
				return featureRules != null && !featureRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GeneratorConfigImpl
