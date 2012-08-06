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
package org.emftext.sdk.generatorconfig.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.emftext.sdk.concretesyntax.Definition;

import org.emftext.sdk.generatorconfig.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage
 * @generated
 */
public class GeneratorconfigSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeneratorconfigPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorconfigSwitch() {
		if (modelPackage == null) {
			modelPackage = GeneratorconfigPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GeneratorconfigPackage.GENERATOR_CONFIG: {
				GeneratorConfig generatorConfig = (GeneratorConfig)theEObject;
				T result = caseGeneratorConfig(generatorConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.GENERATOR_RULE: {
				GeneratorRule generatorRule = (GeneratorRule)theEObject;
				T result = caseGeneratorRule(generatorRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.CLASS_RULE: {
				ClassRule classRule = (ClassRule)theEObject;
				T result = caseClassRule(classRule);
				if (result == null) result = caseGeneratorRule(classRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.FEATURE_RULE: {
				FeatureRule featureRule = (FeatureRule)theEObject;
				T result = caseFeatureRule(featureRule);
				if (result == null) result = caseGeneratorRule(featureRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.CLASS_CONTEXT: {
				ClassContext classContext = (ClassContext)theEObject;
				T result = caseClassContext(classContext);
				if (result == null) result = caseDefinition(classContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.FEATURE_CONTEXT: {
				FeatureContext featureContext = (FeatureContext)theEObject;
				T result = caseFeatureContext(featureContext);
				if (result == null) result = caseDefinition(featureContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.CLASS_RULE_REFERENCE: {
				ClassRuleReference classRuleReference = (ClassRuleReference)theEObject;
				T result = caseClassRuleReference(classRuleReference);
				if (result == null) result = caseClassContext(classRuleReference);
				if (result == null) result = caseDefinition(classRuleReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.FEATURE_REFERENCE: {
				FeatureReference featureReference = (FeatureReference)theEObject;
				T result = caseFeatureReference(featureReference);
				if (result == null) result = caseClassContext(featureReference);
				if (result == null) result = caseDefinition(featureReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.FEATURES: {
				Features features = (Features)theEObject;
				T result = caseFeatures(features);
				if (result == null) result = caseClassContext(features);
				if (result == null) result = caseDefinition(features);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.CLASS_CONTEXT_DEFINITION: {
				ClassContextDefinition classContextDefinition = (ClassContextDefinition)theEObject;
				T result = caseClassContextDefinition(classContextDefinition);
				if (result == null) result = caseClassContext(classContextDefinition);
				if (result == null) result = caseDefinition(classContextDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.CLASS_NAME: {
				ClassName className = (ClassName)theEObject;
				T result = caseClassName(className);
				if (result == null) result = caseClassContextDefinition(className);
				if (result == null) result = caseClassContext(className);
				if (result == null) result = caseDefinition(className);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.FEATURE_RULE_REFERENCE: {
				FeatureRuleReference featureRuleReference = (FeatureRuleReference)theEObject;
				T result = caseFeatureRuleReference(featureRuleReference);
				if (result == null) result = caseFeatureContext(featureRuleReference);
				if (result == null) result = caseDefinition(featureRuleReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.FEATURE_CONTEXT_DEFINITION: {
				FeatureContextDefinition featureContextDefinition = (FeatureContextDefinition)theEObject;
				T result = caseFeatureContextDefinition(featureContextDefinition);
				if (result == null) result = caseFeatureContext(featureContextDefinition);
				if (result == null) result = caseDefinition(featureContextDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.FEATURE_NAME: {
				FeatureName featureName = (FeatureName)theEObject;
				T result = caseFeatureName(featureName);
				if (result == null) result = caseFeatureContextDefinition(featureName);
				if (result == null) result = caseFeatureContext(featureName);
				if (result == null) result = caseDefinition(featureName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorconfigPackage.FEATURE: {
				Feature feature = (Feature)theEObject;
				T result = caseFeature(feature);
				if (result == null) result = caseFeatureContextDefinition(feature);
				if (result == null) result = caseFeatureContext(feature);
				if (result == null) result = caseDefinition(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generator Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generator Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneratorConfig(GeneratorConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generator Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generator Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneratorRule(GeneratorRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassRule(ClassRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureRule(FeatureRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassContext(ClassContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureContext(FeatureContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Rule Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Rule Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassRuleReference(ClassRuleReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureReference(FeatureReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Features</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Features</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatures(Features object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Context Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Context Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassContextDefinition(ClassContextDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassName(ClassName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Rule Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Rule Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureRuleReference(FeatureRuleReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Context Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Context Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureContextDefinition(FeatureContextDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureName(FeatureName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinition(Definition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //GeneratorconfigSwitch
