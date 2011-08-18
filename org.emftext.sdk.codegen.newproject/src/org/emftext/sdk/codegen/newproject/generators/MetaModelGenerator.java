/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.codegen.newproject.generators;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.sdk.codegen.newproject.NewProjectParameters;

/**
 * Generates a simple Ecore model with some example meta classes.
 */
public class MetaModelGenerator extends ModelGenerator {

	public static final String FEATURE_KIND_ATT = "kind";
	public static final String FEATURE_KIND = "FeatureKind";
	public static final String FEATURE_KIND_ATTRIBUTE = "attribute";
	public static final String FEATURE_KIND_REFERENCE = "reference";
	public static final String FEATURE_KIND_CONTAINMENT = "containment";
	public static final String FEATURE = "Feature";
	public static final String FEATURE_TYPE_REF = "type";
	public static final String ENTITY_MODEL = "EntityModel";
	public static final String ENTITY_MODEL_TYPES_REF = "types";
	public static final String ENTITY = "Entity";
	public static final String ENTITY_FEATURES_REF = "features";
	public static final String DATA_TYPE = "DataType";
	public static final String TYPE = "Type";

	private static final EcoreFactory ECORE_FACTORY = EcoreFactory.eINSTANCE;
	
	public static final String TYPE_NAME_ATT = "name";
	public static final String ENTITY_ABSTRACT_ATT = "abstract";
	private static final String NAMED_ELEMENT = "NamedElement";
	
	public MetaModelGenerator() {
		super();
	}

	public EObject generateModel(NewProjectParameters parameters) {
		EPackage ePackage = generateEPackage(parameters);
		getContext().setEPackage(ePackage);
		return ePackage;
	}

	public EPackage generateEPackage(NewProjectParameters parameters) {
		EClass namedElementClass = ECORE_FACTORY.createEClass();
		namedElementClass.setName(NAMED_ELEMENT);
		namedElementClass.setAbstract(true);
		
		createAttribute(namedElementClass, TYPE_NAME_ATT, EcorePackage.eINSTANCE.getEString());

		EClass typeClass = ECORE_FACTORY.createEClass();
		typeClass.setName(TYPE);
		typeClass.setAbstract(true);
		typeClass.getESuperTypes().add(namedElementClass);
		
		EClass dataTypeClass = ECORE_FACTORY.createEClass();
		dataTypeClass.setName(DATA_TYPE);
		dataTypeClass.getESuperTypes().add(typeClass);
		
		EClass entityClass = ECORE_FACTORY.createEClass();
		entityClass.setName(ENTITY);
		entityClass.getESuperTypes().add(typeClass);

		createAttribute(entityClass, ENTITY_ABSTRACT_ATT, EcorePackage.eINSTANCE.getEBoolean());

		EClass entityModelClass = ECORE_FACTORY.createEClass();
		entityModelClass.setName(ENTITY_MODEL);

		EEnum featureKindEnum = ECORE_FACTORY.createEEnum();
		featureKindEnum.setName(FEATURE_KIND);
		
		createEnumLiteral(featureKindEnum, FEATURE_KIND_ATTRIBUTE, 0);
		createEnumLiteral(featureKindEnum, FEATURE_KIND_REFERENCE, 1);
		createEnumLiteral(featureKindEnum, FEATURE_KIND_CONTAINMENT, 2);

		EClass featureClass = ECORE_FACTORY.createEClass();
		featureClass.setName(FEATURE);
		featureClass.getESuperTypes().add(namedElementClass);

		createAttribute(featureClass, FEATURE_KIND_ATT, featureKindEnum);
		
		createContainment(entityModelClass, ENTITY_MODEL_TYPES_REF, typeClass);
		createContainment(entityClass, ENTITY_FEATURES_REF, featureClass);
		createNonContainment(featureClass, FEATURE_TYPE_REF, typeClass);

		EPackage ePackage = ECORE_FACTORY.createEPackage();
		ePackage.getEClassifiers().add(namedElementClass);
		ePackage.getEClassifiers().add(typeClass);
		ePackage.getEClassifiers().add(dataTypeClass);
		ePackage.getEClassifiers().add(entityClass);
		ePackage.getEClassifiers().add(entityModelClass);
		ePackage.getEClassifiers().add(featureClass);
		ePackage.getEClassifiers().add(featureKindEnum);
		
		ePackage.setName(parameters.getName());
		ePackage.setNsPrefix(parameters.getNamespacePrefix());
		ePackage.setNsURI(parameters.getNamespaceUri());
		return ePackage;
	}

	private void createContainment(EClass eClass, String name, EClass type) {
		EReference eReference = ECORE_FACTORY.createEReference();
		eReference.setName(name);
		eReference.setEType(type);
		eReference.setLowerBound(0);
		eReference.setUpperBound(-1);
		eReference.setContainment(true);
		eClass.getEStructuralFeatures().add(eReference);
	}

	private void createNonContainment(EClass eClass, String name, EClass type) {
		EReference eReference = ECORE_FACTORY.createEReference();
		eReference.setName(name);
		eReference.setEType(type);
		eReference.setLowerBound(1);
		eReference.setUpperBound(1);
		eReference.setContainment(false);
		eClass.getEStructuralFeatures().add(eReference);
	}

	private void createAttribute(EClass eClass, String name, EClassifier type) {
		EAttribute eAttribute = ECORE_FACTORY.createEAttribute();
		eAttribute.setName(name);
		eAttribute.setLowerBound(1);
		eAttribute.setUpperBound(1);
		eAttribute.setEType(type);
		eClass.getEStructuralFeatures().add(eAttribute);
	}

	private void createEnumLiteral(EEnum enumeration, String name, int value) {
		EEnumLiteral enumLiteral = ECORE_FACTORY.createEEnumLiteral();
		enumLiteral.setName(name);
		enumLiteral.setLiteral(name);
		enumLiteral.setValue(value);
		enumeration.getELiterals().add(enumLiteral);
	}

	public String getModelPath() {
		NewProjectParameters parameters = getContext().getParameters();
		String metaModelFileName = parameters.getEcoreFile();
		String pathToMetaModel = getFileInMetaModelFolder(metaModelFileName);
		return pathToMetaModel;
	}
}
