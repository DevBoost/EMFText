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

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;

import org.emftext.sdk.generatorconfig.ClassContext;
import org.emftext.sdk.generatorconfig.ClassContextDefinition;
import org.emftext.sdk.generatorconfig.ClassName;
import org.emftext.sdk.generatorconfig.ClassRule;
import org.emftext.sdk.generatorconfig.ClassRuleReference;
import org.emftext.sdk.generatorconfig.Feature;
import org.emftext.sdk.generatorconfig.FeatureContext;
import org.emftext.sdk.generatorconfig.FeatureContextDefinition;
import org.emftext.sdk.generatorconfig.FeatureName;
import org.emftext.sdk.generatorconfig.FeatureReference;
import org.emftext.sdk.generatorconfig.FeatureRule;
import org.emftext.sdk.generatorconfig.FeatureRuleReference;
import org.emftext.sdk.generatorconfig.Features;
import org.emftext.sdk.generatorconfig.GeneratorConfig;
import org.emftext.sdk.generatorconfig.GeneratorRule;
import org.emftext.sdk.generatorconfig.GeneratorconfigFactory;
import org.emftext.sdk.generatorconfig.GeneratorconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratorconfigPackageImpl extends EPackageImpl implements GeneratorconfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatorConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatorRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classRuleReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featuresEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classContextDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureRuleReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureContextDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GeneratorconfigPackageImpl() {
		super(eNS_URI, GeneratorconfigFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GeneratorconfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GeneratorconfigPackage init() {
		if (isInited) return (GeneratorconfigPackage)EPackage.Registry.INSTANCE.getEPackage(GeneratorconfigPackage.eNS_URI);

		// Obtain or create and register package
		GeneratorconfigPackageImpl theGeneratorconfigPackage = (GeneratorconfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GeneratorconfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GeneratorconfigPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConcretesyntaxPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGeneratorconfigPackage.createPackageContents();

		// Initialize created meta-data
		theGeneratorconfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGeneratorconfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GeneratorconfigPackage.eNS_URI, theGeneratorconfigPackage);
		return theGeneratorconfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratorConfig() {
		return generatorConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorConfig_ClassRules() {
		return (EReference)generatorConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorConfig_FeatureRules() {
		return (EReference)generatorConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratorRule() {
		return generatorRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratorRule_Name() {
		return (EAttribute)generatorRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorRule_Definition() {
		return (EReference)generatorRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassRule() {
		return classRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureRule() {
		return featureRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassContext() {
		return classContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureContext() {
		return featureContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassRuleReference() {
		return classRuleReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassRuleReference_Rule() {
		return (EReference)classRuleReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureReference() {
		return featureReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureReference_FeatureName() {
		return (EAttribute)featureReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatures() {
		return featuresEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassContextDefinition() {
		return classContextDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassName() {
		return classNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureRuleReference() {
		return featureRuleReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureRuleReference_Rule() {
		return (EReference)featureRuleReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureContextDefinition() {
		return featureContextDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureName() {
		return featureNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorconfigFactory getGeneratorconfigFactory() {
		return (GeneratorconfigFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		generatorConfigEClass = createEClass(GENERATOR_CONFIG);
		createEReference(generatorConfigEClass, GENERATOR_CONFIG__CLASS_RULES);
		createEReference(generatorConfigEClass, GENERATOR_CONFIG__FEATURE_RULES);

		generatorRuleEClass = createEClass(GENERATOR_RULE);
		createEAttribute(generatorRuleEClass, GENERATOR_RULE__NAME);
		createEReference(generatorRuleEClass, GENERATOR_RULE__DEFINITION);

		classRuleEClass = createEClass(CLASS_RULE);

		featureRuleEClass = createEClass(FEATURE_RULE);

		classContextEClass = createEClass(CLASS_CONTEXT);

		featureContextEClass = createEClass(FEATURE_CONTEXT);

		classRuleReferenceEClass = createEClass(CLASS_RULE_REFERENCE);
		createEReference(classRuleReferenceEClass, CLASS_RULE_REFERENCE__RULE);

		featureReferenceEClass = createEClass(FEATURE_REFERENCE);
		createEAttribute(featureReferenceEClass, FEATURE_REFERENCE__FEATURE_NAME);

		featuresEClass = createEClass(FEATURES);

		classContextDefinitionEClass = createEClass(CLASS_CONTEXT_DEFINITION);

		classNameEClass = createEClass(CLASS_NAME);

		featureRuleReferenceEClass = createEClass(FEATURE_RULE_REFERENCE);
		createEReference(featureRuleReferenceEClass, FEATURE_RULE_REFERENCE__RULE);

		featureContextDefinitionEClass = createEClass(FEATURE_CONTEXT_DEFINITION);

		featureNameEClass = createEClass(FEATURE_NAME);

		featureEClass = createEClass(FEATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ConcretesyntaxPackage theConcretesyntaxPackage = (ConcretesyntaxPackage)EPackage.Registry.INSTANCE.getEPackage(ConcretesyntaxPackage.eNS_URI);
		GenModelPackage theGenModelPackage = (GenModelPackage)EPackage.Registry.INSTANCE.getEPackage(GenModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		classRuleEClass.getESuperTypes().add(this.getGeneratorRule());
		featureRuleEClass.getESuperTypes().add(this.getGeneratorRule());
		classContextEClass.getESuperTypes().add(theConcretesyntaxPackage.getDefinition());
		featureContextEClass.getESuperTypes().add(theConcretesyntaxPackage.getDefinition());
		classRuleReferenceEClass.getESuperTypes().add(this.getClassContext());
		featureReferenceEClass.getESuperTypes().add(this.getClassContext());
		featuresEClass.getESuperTypes().add(this.getClassContext());
		classContextDefinitionEClass.getESuperTypes().add(this.getClassContext());
		classNameEClass.getESuperTypes().add(this.getClassContextDefinition());
		featureRuleReferenceEClass.getESuperTypes().add(this.getFeatureContext());
		featureContextDefinitionEClass.getESuperTypes().add(this.getFeatureContext());
		featureNameEClass.getESuperTypes().add(this.getFeatureContextDefinition());
		featureEClass.getESuperTypes().add(this.getFeatureContextDefinition());

		// Initialize classes and features; add operations and parameters
		initEClass(generatorConfigEClass, GeneratorConfig.class, "GeneratorConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneratorConfig_ClassRules(), this.getClassRule(), null, "classRules", null, 0, -1, GeneratorConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGeneratorConfig_FeatureRules(), this.getFeatureRule(), null, "featureRules", null, 0, -1, GeneratorConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(generatorRuleEClass, GeneratorRule.class, "GeneratorRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneratorRule_Name(), ecorePackage.getEString(), "name", null, 1, 1, GeneratorRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneratorRule_Definition(), theConcretesyntaxPackage.getSequence(), null, "definition", null, 1, 1, GeneratorRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classRuleEClass, ClassRule.class, "ClassRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureRuleEClass, FeatureRule.class, "FeatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classContextEClass, ClassContext.class, "ClassContext", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureContextEClass, FeatureContext.class, "FeatureContext", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classRuleReferenceEClass, ClassRuleReference.class, "ClassRuleReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassRuleReference_Rule(), this.getGeneratorRule(), null, "rule", null, 1, 1, ClassRuleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureReferenceEClass, FeatureReference.class, "FeatureReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureReference_FeatureName(), ecorePackage.getEString(), "featureName", null, 1, 1, FeatureReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featuresEClass, Features.class, "Features", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classContextDefinitionEClass, ClassContextDefinition.class, "ClassContextDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(classContextDefinitionEClass, theConcretesyntaxPackage.getDefinition(), "getDefinition", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenClass(), "genClass", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(classNameEClass, ClassName.class, "ClassName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureRuleReferenceEClass, FeatureRuleReference.class, "FeatureRuleReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureRuleReference_Rule(), this.getGeneratorRule(), null, "rule", null, 1, 1, FeatureRuleReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureContextDefinitionEClass, FeatureContextDefinition.class, "FeatureContextDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(featureContextDefinitionEClass, theConcretesyntaxPackage.getDefinition(), "getDefinition", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theGenModelPackage.getGenFeature(), "genFeature", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureNameEClass, FeatureName.class, "FeatureName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //GeneratorconfigPackageImpl
