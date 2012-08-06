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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.generatorconfig.GeneratorconfigFactory
 * @model kind="package"
 * @generated
 */
public interface GeneratorconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generatorconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.emftext.org/sdk/generatorconfig";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.emftext.sdk.generatorconfig";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorconfigPackage eINSTANCE = org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.GeneratorConfigImpl <em>Generator Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorConfigImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getGeneratorConfig()
	 * @generated
	 */
	int GENERATOR_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Class Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_CONFIG__CLASS_RULES = 0;

	/**
	 * The feature id for the '<em><b>Feature Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_CONFIG__FEATURE_RULES = 1;

	/**
	 * The number of structural features of the '<em>Generator Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_CONFIG_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.GeneratorRuleImpl <em>Generator Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorRuleImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getGeneratorRule()
	 * @generated
	 */
	int GENERATOR_RULE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_RULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_RULE__DEFINITION = 1;

	/**
	 * The number of structural features of the '<em>Generator Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_RULE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.ClassRuleImpl <em>Class Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.ClassRuleImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassRule()
	 * @generated
	 */
	int CLASS_RULE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_RULE__NAME = GENERATOR_RULE__NAME;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_RULE__DEFINITION = GENERATOR_RULE__DEFINITION;

	/**
	 * The number of structural features of the '<em>Class Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_RULE_FEATURE_COUNT = GENERATOR_RULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureRuleImpl <em>Feature Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.FeatureRuleImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureRule()
	 * @generated
	 */
	int FEATURE_RULE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_RULE__NAME = GENERATOR_RULE__NAME;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_RULE__DEFINITION = GENERATOR_RULE__DEFINITION;

	/**
	 * The number of structural features of the '<em>Feature Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_RULE_FEATURE_COUNT = GENERATOR_RULE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.ClassContext <em>Class Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.ClassContext
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassContext()
	 * @generated
	 */
	int CLASS_CONTEXT = 4;

	/**
	 * The number of structural features of the '<em>Class Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTEXT_FEATURE_COUNT = ConcretesyntaxPackage.DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.FeatureContext <em>Feature Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.FeatureContext
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureContext()
	 * @generated
	 */
	int FEATURE_CONTEXT = 5;

	/**
	 * The number of structural features of the '<em>Feature Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_FEATURE_COUNT = ConcretesyntaxPackage.DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.ClassRuleReferenceImpl <em>Class Rule Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.ClassRuleReferenceImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassRuleReference()
	 * @generated
	 */
	int CLASS_RULE_REFERENCE = 6;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_RULE_REFERENCE__RULE = CLASS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Rule Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_RULE_REFERENCE_FEATURE_COUNT = CLASS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureReferenceImpl <em>Feature Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.FeatureReferenceImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureReference()
	 * @generated
	 */
	int FEATURE_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_REFERENCE__FEATURE_NAME = CLASS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_REFERENCE_FEATURE_COUNT = CLASS_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.FeaturesImpl <em>Features</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.FeaturesImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatures()
	 * @generated
	 */
	int FEATURES = 8;

	/**
	 * The number of structural features of the '<em>Features</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURES_FEATURE_COUNT = CLASS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.ClassContextDefinition <em>Class Context Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.ClassContextDefinition
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassContextDefinition()
	 * @generated
	 */
	int CLASS_CONTEXT_DEFINITION = 9;

	/**
	 * The number of structural features of the '<em>Class Context Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CONTEXT_DEFINITION_FEATURE_COUNT = CLASS_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.ClassNameImpl <em>Class Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.ClassNameImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassName()
	 * @generated
	 */
	int CLASS_NAME = 10;

	/**
	 * The number of structural features of the '<em>Class Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_NAME_FEATURE_COUNT = CLASS_CONTEXT_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureRuleReferenceImpl <em>Feature Rule Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.FeatureRuleReferenceImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureRuleReference()
	 * @generated
	 */
	int FEATURE_RULE_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_RULE_REFERENCE__RULE = FEATURE_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Rule Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_RULE_REFERENCE_FEATURE_COUNT = FEATURE_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.FeatureContextDefinition <em>Feature Context Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.FeatureContextDefinition
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureContextDefinition()
	 * @generated
	 */
	int FEATURE_CONTEXT_DEFINITION = 12;

	/**
	 * The number of structural features of the '<em>Feature Context Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONTEXT_DEFINITION_FEATURE_COUNT = FEATURE_CONTEXT_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureNameImpl <em>Feature Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.FeatureNameImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureName()
	 * @generated
	 */
	int FEATURE_NAME = 13;

	/**
	 * The number of structural features of the '<em>Feature Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_NAME_FEATURE_COUNT = FEATURE_CONTEXT_DEFINITION_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.emftext.sdk.generatorconfig.impl.FeatureImpl
	 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 14;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = FEATURE_CONTEXT_DEFINITION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.GeneratorConfig <em>Generator Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Config</em>'.
	 * @see org.emftext.sdk.generatorconfig.GeneratorConfig
	 * @generated
	 */
	EClass getGeneratorConfig();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.generatorconfig.GeneratorConfig#getClassRules <em>Class Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Rules</em>'.
	 * @see org.emftext.sdk.generatorconfig.GeneratorConfig#getClassRules()
	 * @see #getGeneratorConfig()
	 * @generated
	 */
	EReference getGeneratorConfig_ClassRules();

	/**
	 * Returns the meta object for the containment reference list '{@link org.emftext.sdk.generatorconfig.GeneratorConfig#getFeatureRules <em>Feature Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Rules</em>'.
	 * @see org.emftext.sdk.generatorconfig.GeneratorConfig#getFeatureRules()
	 * @see #getGeneratorConfig()
	 * @generated
	 */
	EReference getGeneratorConfig_FeatureRules();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.GeneratorRule <em>Generator Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Rule</em>'.
	 * @see org.emftext.sdk.generatorconfig.GeneratorRule
	 * @generated
	 */
	EClass getGeneratorRule();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.generatorconfig.GeneratorRule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.emftext.sdk.generatorconfig.GeneratorRule#getName()
	 * @see #getGeneratorRule()
	 * @generated
	 */
	EAttribute getGeneratorRule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.emftext.sdk.generatorconfig.GeneratorRule#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definition</em>'.
	 * @see org.emftext.sdk.generatorconfig.GeneratorRule#getDefinition()
	 * @see #getGeneratorRule()
	 * @generated
	 */
	EReference getGeneratorRule_Definition();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.ClassRule <em>Class Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Rule</em>'.
	 * @see org.emftext.sdk.generatorconfig.ClassRule
	 * @generated
	 */
	EClass getClassRule();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.FeatureRule <em>Feature Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Rule</em>'.
	 * @see org.emftext.sdk.generatorconfig.FeatureRule
	 * @generated
	 */
	EClass getFeatureRule();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.ClassContext <em>Class Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Context</em>'.
	 * @see org.emftext.sdk.generatorconfig.ClassContext
	 * @generated
	 */
	EClass getClassContext();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.FeatureContext <em>Feature Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Context</em>'.
	 * @see org.emftext.sdk.generatorconfig.FeatureContext
	 * @generated
	 */
	EClass getFeatureContext();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.ClassRuleReference <em>Class Rule Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Rule Reference</em>'.
	 * @see org.emftext.sdk.generatorconfig.ClassRuleReference
	 * @generated
	 */
	EClass getClassRuleReference();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.generatorconfig.ClassRuleReference#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see org.emftext.sdk.generatorconfig.ClassRuleReference#getRule()
	 * @see #getClassRuleReference()
	 * @generated
	 */
	EReference getClassRuleReference_Rule();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.FeatureReference <em>Feature Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Reference</em>'.
	 * @see org.emftext.sdk.generatorconfig.FeatureReference
	 * @generated
	 */
	EClass getFeatureReference();

	/**
	 * Returns the meta object for the attribute '{@link org.emftext.sdk.generatorconfig.FeatureReference#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.emftext.sdk.generatorconfig.FeatureReference#getFeatureName()
	 * @see #getFeatureReference()
	 * @generated
	 */
	EAttribute getFeatureReference_FeatureName();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.Features <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Features</em>'.
	 * @see org.emftext.sdk.generatorconfig.Features
	 * @generated
	 */
	EClass getFeatures();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.ClassContextDefinition <em>Class Context Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Context Definition</em>'.
	 * @see org.emftext.sdk.generatorconfig.ClassContextDefinition
	 * @generated
	 */
	EClass getClassContextDefinition();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.ClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Name</em>'.
	 * @see org.emftext.sdk.generatorconfig.ClassName
	 * @generated
	 */
	EClass getClassName();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.FeatureRuleReference <em>Feature Rule Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Rule Reference</em>'.
	 * @see org.emftext.sdk.generatorconfig.FeatureRuleReference
	 * @generated
	 */
	EClass getFeatureRuleReference();

	/**
	 * Returns the meta object for the reference '{@link org.emftext.sdk.generatorconfig.FeatureRuleReference#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see org.emftext.sdk.generatorconfig.FeatureRuleReference#getRule()
	 * @see #getFeatureRuleReference()
	 * @generated
	 */
	EReference getFeatureRuleReference_Rule();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.FeatureContextDefinition <em>Feature Context Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Context Definition</em>'.
	 * @see org.emftext.sdk.generatorconfig.FeatureContextDefinition
	 * @generated
	 */
	EClass getFeatureContextDefinition();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.FeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Name</em>'.
	 * @see org.emftext.sdk.generatorconfig.FeatureName
	 * @generated
	 */
	EClass getFeatureName();

	/**
	 * Returns the meta object for class '{@link org.emftext.sdk.generatorconfig.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.emftext.sdk.generatorconfig.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneratorconfigFactory getGeneratorconfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.GeneratorConfigImpl <em>Generator Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorConfigImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getGeneratorConfig()
		 * @generated
		 */
		EClass GENERATOR_CONFIG = eINSTANCE.getGeneratorConfig();

		/**
		 * The meta object literal for the '<em><b>Class Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_CONFIG__CLASS_RULES = eINSTANCE.getGeneratorConfig_ClassRules();

		/**
		 * The meta object literal for the '<em><b>Feature Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_CONFIG__FEATURE_RULES = eINSTANCE.getGeneratorConfig_FeatureRules();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.GeneratorRuleImpl <em>Generator Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorRuleImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getGeneratorRule()
		 * @generated
		 */
		EClass GENERATOR_RULE = eINSTANCE.getGeneratorRule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR_RULE__NAME = eINSTANCE.getGeneratorRule_Name();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_RULE__DEFINITION = eINSTANCE.getGeneratorRule_Definition();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.ClassRuleImpl <em>Class Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.ClassRuleImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassRule()
		 * @generated
		 */
		EClass CLASS_RULE = eINSTANCE.getClassRule();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureRuleImpl <em>Feature Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.FeatureRuleImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureRule()
		 * @generated
		 */
		EClass FEATURE_RULE = eINSTANCE.getFeatureRule();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.ClassContext <em>Class Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.ClassContext
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassContext()
		 * @generated
		 */
		EClass CLASS_CONTEXT = eINSTANCE.getClassContext();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.FeatureContext <em>Feature Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.FeatureContext
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureContext()
		 * @generated
		 */
		EClass FEATURE_CONTEXT = eINSTANCE.getFeatureContext();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.ClassRuleReferenceImpl <em>Class Rule Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.ClassRuleReferenceImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassRuleReference()
		 * @generated
		 */
		EClass CLASS_RULE_REFERENCE = eINSTANCE.getClassRuleReference();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_RULE_REFERENCE__RULE = eINSTANCE.getClassRuleReference_Rule();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureReferenceImpl <em>Feature Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.FeatureReferenceImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureReference()
		 * @generated
		 */
		EClass FEATURE_REFERENCE = eINSTANCE.getFeatureReference();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_REFERENCE__FEATURE_NAME = eINSTANCE.getFeatureReference_FeatureName();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.FeaturesImpl <em>Features</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.FeaturesImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatures()
		 * @generated
		 */
		EClass FEATURES = eINSTANCE.getFeatures();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.ClassContextDefinition <em>Class Context Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.ClassContextDefinition
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassContextDefinition()
		 * @generated
		 */
		EClass CLASS_CONTEXT_DEFINITION = eINSTANCE.getClassContextDefinition();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.ClassNameImpl <em>Class Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.ClassNameImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getClassName()
		 * @generated
		 */
		EClass CLASS_NAME = eINSTANCE.getClassName();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureRuleReferenceImpl <em>Feature Rule Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.FeatureRuleReferenceImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureRuleReference()
		 * @generated
		 */
		EClass FEATURE_RULE_REFERENCE = eINSTANCE.getFeatureRuleReference();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_RULE_REFERENCE__RULE = eINSTANCE.getFeatureRuleReference_Rule();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.FeatureContextDefinition <em>Feature Context Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.FeatureContextDefinition
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureContextDefinition()
		 * @generated
		 */
		EClass FEATURE_CONTEXT_DEFINITION = eINSTANCE.getFeatureContextDefinition();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureNameImpl <em>Feature Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.FeatureNameImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeatureName()
		 * @generated
		 */
		EClass FEATURE_NAME = eINSTANCE.getFeatureName();

		/**
		 * The meta object literal for the '{@link org.emftext.sdk.generatorconfig.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.emftext.sdk.generatorconfig.impl.FeatureImpl
		 * @see org.emftext.sdk.generatorconfig.impl.GeneratorconfigPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

	}

} //GeneratorconfigPackage
