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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.sdk.generatorconfig.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratorconfigFactoryImpl extends EFactoryImpl implements GeneratorconfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorconfigFactory init() {
		try {
			GeneratorconfigFactory theGeneratorconfigFactory = (GeneratorconfigFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.emftext.org/sdk/generatorconfig"); 
			if (theGeneratorconfigFactory != null) {
				return theGeneratorconfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GeneratorconfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorconfigFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GeneratorconfigPackage.GENERATOR_CONFIG: return createGeneratorConfig();
			case GeneratorconfigPackage.GENERATOR_RULE: return createGeneratorRule();
			case GeneratorconfigPackage.CLASS_RULE: return createClassRule();
			case GeneratorconfigPackage.FEATURE_RULE: return createFeatureRule();
			case GeneratorconfigPackage.CLASS_RULE_REFERENCE: return createClassRuleReference();
			case GeneratorconfigPackage.FEATURE_REFERENCE: return createFeatureReference();
			case GeneratorconfigPackage.FEATURES: return createFeatures();
			case GeneratorconfigPackage.CLASS_NAME: return createClassName();
			case GeneratorconfigPackage.FEATURE_RULE_REFERENCE: return createFeatureRuleReference();
			case GeneratorconfigPackage.FEATURE_NAME: return createFeatureName();
			case GeneratorconfigPackage.FEATURE: return createFeature();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorConfig createGeneratorConfig() {
		GeneratorConfigImpl generatorConfig = new GeneratorConfigImpl();
		return generatorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorRule createGeneratorRule() {
		GeneratorRuleImpl generatorRule = new GeneratorRuleImpl();
		return generatorRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassRule createClassRule() {
		ClassRuleImpl classRule = new ClassRuleImpl();
		return classRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureRule createFeatureRule() {
		FeatureRuleImpl featureRule = new FeatureRuleImpl();
		return featureRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassRuleReference createClassRuleReference() {
		ClassRuleReferenceImpl classRuleReference = new ClassRuleReferenceImpl();
		return classRuleReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReference createFeatureReference() {
		FeatureReferenceImpl featureReference = new FeatureReferenceImpl();
		return featureReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Features createFeatures() {
		FeaturesImpl features = new FeaturesImpl();
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassName createClassName() {
		ClassNameImpl className = new ClassNameImpl();
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureRuleReference createFeatureRuleReference() {
		FeatureRuleReferenceImpl featureRuleReference = new FeatureRuleReferenceImpl();
		return featureRuleReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureName createFeatureName() {
		FeatureNameImpl featureName = new FeatureNameImpl();
		return featureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorconfigPackage getGeneratorconfigPackage() {
		return (GeneratorconfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GeneratorconfigPackage getPackage() {
		return GeneratorconfigPackage.eINSTANCE;
	}

} //GeneratorconfigFactoryImpl
