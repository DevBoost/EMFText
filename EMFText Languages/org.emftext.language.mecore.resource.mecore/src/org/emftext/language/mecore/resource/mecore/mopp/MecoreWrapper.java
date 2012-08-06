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
package org.emftext.language.mecore.resource.mecore.mopp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.mecore.MClass;
import org.emftext.language.mecore.MClassifier;
import org.emftext.language.mecore.MComplexMultiplicity;
import org.emftext.language.mecore.MDataType;
import org.emftext.language.mecore.MEcoreType;
import org.emftext.language.mecore.MEnum;
import org.emftext.language.mecore.MEnumLiteral;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.MModelElement;
import org.emftext.language.mecore.MMultiplicity;
import org.emftext.language.mecore.MOperation;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.MParameter;
import org.emftext.language.mecore.MSimpleMultiplicity;
import org.emftext.language.mecore.MSimpleMultiplicityValue;
import org.emftext.language.mecore.MSuperTypeReference;
import org.emftext.language.mecore.MType;
import org.emftext.language.mecore.MTypeParameter;
import org.emftext.language.mecore.MTypedElement;
import org.emftext.language.mecore.resource.mecore.IMecoreCommand;

/**
 * Converts Mecore models to Ecore models. The wrapper tries to keep the
 * contents of the previous Ecore model to the extent possible.
 */
public class MecoreWrapper {

	private static final String ANNOTATION_SOURCE = MecoreWrapper.class
			.getName();
	private static final String COMMENT_KEY = "WARNING";
	private static final String COMMENT_VALUE = "This element was generated from an .mecore file. Removing this annotation will signal the MinimalEcore builder to keep this element.";

	private Map<MModelElement, EObject> primaryMapping = new LinkedHashMap<MModelElement, EObject>();
	// this mappings to used to trace validation errors that are detected in the
	// Ecore model back to
	// the Mecore model
	private Map<EObject, MModelElement> reverseMapping = new LinkedHashMap<EObject, MModelElement>();

	/**
	 * Some steps in the creation of the Ecore model need to be postponed (e.g.,
	 * the creation of super type references). We collect these steps in this
	 * list of commands and execute them after the structure of the Ecore model
	 * was created completely.
	 */
	private List<IMecoreCommand<Object>> commands = new ArrayList<IMecoreCommand<Object>>();

	public EPackage wrapMPackage(MPackage mPackage, EPackage existingEPackage) {
		if (existingEPackage != null) {
			primaryMapping.put(mPackage, existingEPackage);
		}
		EPackage superPackage = null;
		if (existingEPackage != null) {
			existingEPackage.getESuperPackage();
		}
		EPackage ePackage = findOrCreateEPackage(mPackage, superPackage);

		// set package properties
		String packageName = mPackage.getName();
		if (packageName == null) {
			ePackage.setName(mPackage.eResource().getURI().fragment());
		} else {
			ePackage.setName(packageName);
		}
		ePackage.setNsURI(mPackage.getNamespace());
		ePackage.setNsPrefix(mPackage.getName());

		// process package contents
		for (MClassifier mClassifier : mPackage.getContents()) {
			wrapMClassifier(mClassifier, ePackage);
		}

		// execute deferred commands
		for (IMecoreCommand<Object> command : commands) {
			command.execute(null);
		}

		removeObsoleteElements(ePackage);
		return ePackage;
	}

	private void removeObsoleteElements(EPackage ePackage) {
		List<EObject> obsoleteElements = new ArrayList<EObject>();
		removeObsoleteElements(ePackage, obsoleteElements);
		for (EObject eObject : obsoleteElements) {
			EcoreUtil.remove(eObject);
		}
	}

	private void removeObsoleteElements(EObject eObject,
			List<EObject> obsoleteElements) {
		// remove elements that have an MEcore annotation, but that are not
		// present
		// in the .mecore file anymore
		for (EObject child : eObject.eContents()) {
			boolean wasMapped = primaryMapping.values().contains(child);
			boolean isAnnotation = child instanceof EAnnotation;
			if (hasAnnotation(child) && !wasMapped && !isAnnotation) {
				obsoleteElements.add(child);
			} else {
				// call method recursively on children
				removeObsoleteElements(child, obsoleteElements);
			}
		}
	}

	private void addAnnotation(EModelElement element, String comment) {
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		// TODO add reverse mapping
		eAnnotation.setSource(ANNOTATION_SOURCE);
		eAnnotation.getDetails().put(COMMENT_KEY, comment);
		element.getEAnnotations().add(eAnnotation);
	}

	private boolean hasAnnotation(EObject eObject) {
		if (eObject instanceof EModelElement) {
			EModelElement element = (EModelElement) eObject;
			EAnnotation annotation = element.getEAnnotation(ANNOTATION_SOURCE);
			return annotation != null;
		} else {
			return false;
		}
	}

	private void wrapMClassifier(MClassifier mClassifier, EPackage ePackage) {
		if (mClassifier instanceof MClass) {
			wrapMClass((MClass) mClassifier, ePackage);
		} else if (mClassifier instanceof MEnum) {
			wrapMEnum((MEnum) mClassifier, ePackage);
		}
	}

	private void wrapMEnum(MEnum mEnum, EPackage ePackage) {
		EEnum eEnum = findOrCreateEEnum(mEnum, ePackage);
		eEnum.setName(mEnum.getName());
		int count = 0;
		for (MEnumLiteral literal : mEnum.getLiterals()) {
			wrapMEnumLiteral(literal, eEnum, count++);
		}
		primaryMapping.put(mEnum, eEnum);
	}

	private void wrapMEnumLiteral(MEnumLiteral literal, EEnum existingEEnum,
			int count) {
		EEnumLiteral eEnumLiteral = findOrCreateEEnumLiteral(literal,
				existingEEnum);
		eEnumLiteral.setName(literal.getName());
		eEnumLiteral.setLiteral(literal.getLiteral());
		eEnumLiteral.setValue(count);
		primaryMapping.put(literal, eEnumLiteral);
	}

	private void wrapMClass(final MClass mClass, EPackage ePackage) {
		final EClass eClass = findOrCreateEClass(mClass, ePackage);
		primaryMapping.put(mClass, eClass);
		eClass.getESuperTypes().clear();
		eClass.setName(mClass.getName());

		boolean isInterface = mClass.isInterface();
		// interfaces must be abstract
		eClass.setAbstract(isInterface || mClass.isAbstract());
		eClass.setInterface(isInterface);

		// handle features
		for (MFeature mFeature : mClass.getFeatures()) {
			wrapMFeature(mFeature, eClass);
		}

		// handle operations
		for (MOperation mOperation : mClass.getOperations()) {
			wrapMOperation(mOperation, eClass);
		}

		// handle type parameters
		addTypeParameters(mClass, eClass);

		// handle super types
		wrapMSuperTypeReferences(mClass, eClass);
	}

	private void wrapMSuperTypeReferences(final MClass mClass,
			final EClass eClass) {
		commands.add(new IMecoreCommand<Object>() {

			public boolean execute(Object context) {
				// add local super types
				for (MSuperTypeReference supertypeRef : mClass
						.getSuperTypeReferences()) {
					wrapMSuperTypeReference(eClass, supertypeRef);
				}

				return true;
			}
		});
	}

	private EClass getSuperType(MSuperTypeReference supertypeRef) {
		MClass mSupertype = supertypeRef.getSupertype();
		if (mSupertype != null) {
			return (EClass) primaryMapping.get(mSupertype);
		}
		EClass eSuperType = supertypeRef.getESupertype();
		if (eSuperType != null) {
			return eSuperType;
		}
		return null;
	}

	private void wrapMFeature(MFeature mFeature, EClass existingEClass) {
		EStructuralFeature eFeature;
		final MType mType = mFeature.getType();
		if (mType == null) {
			return;
		}
		if (mType instanceof MClass) {
			eFeature = createReference(mFeature, mType, existingEClass);
		} else if (mType instanceof MDataType) {
			eFeature = createAttribute(mFeature, existingEClass, mType);
		} else if (mType instanceof MEnum) {
			final EAttribute eAttribute = findOrCreateEAttribute(mFeature,
					existingEClass);
			commands.add(new IMecoreCommand<Object>() {

				public boolean execute(Object context) {
					eAttribute.setEType((EEnum) primaryMapping.get(mType));
					return true;
				}
			});
			eFeature = eAttribute;
		} else if (mType instanceof MEcoreType) {
			eFeature = createReference(mFeature, mType, existingEClass);
		} else if (mType instanceof MTypeParameter) {
			eFeature = createReference(mFeature, mType, existingEClass);
		} else {
			throw new RuntimeException("Found unknown subtype of MType: "
					+ mType.eClass().getName());
		}
		setMulitplicity(mFeature, eFeature);
		primaryMapping.put(mFeature, eFeature);
		eFeature.setName(mFeature.getName());
	}

	private EStructuralFeature createAttribute(MFeature mFeature,
			EClass existingEClass, final MType mType) {
		// primitive type, create attribute
		EAttribute eAttribute = findOrCreateEAttribute(mFeature, existingEClass);
		setType(eAttribute, mType, Collections.<MType> emptyList());
		return eAttribute;
	}

	private void wrapMOperation(MOperation mOperation, EClass existingEClass) {
		final MType mType = mOperation.getType();
		if (mType == null) {
			return;
		}
		final EOperation eOperation = findOrCreateEOperation(mOperation,
				existingEClass);
		addTypeParameters(mOperation, eOperation);
		// handle parameters
		for (MParameter mParameter : mOperation.getParameters()) {
			wrapMParameter(mParameter, eOperation);
		}

		commands.add(new IMecoreCommand<Object>() {

			public boolean execute(Object context) {
				setType(eOperation, mType, Collections.<MType> emptyList());
				return true;
			}
		});

		setMulitplicity(mOperation, eOperation);
		primaryMapping.put(mOperation, eOperation);
		eOperation.setName(mOperation.getName());
	}

	private void addTypeParameters(MOperation mOperation, EOperation eOperation) {
		List<MTypeParameter> typeParameters = mOperation.getTypeParameters();
		for (MTypeParameter typeParameter : typeParameters) {
			findOrCreateETypeParameter(eOperation, typeParameter);
		}
	}

	private void addTypeParameters(MClass mClass, EClass eClass) {
		List<MTypeParameter> typeParameters = mClass.getTypeParameters();
		for (MTypeParameter typeParameter : typeParameters) {
			findOrCreateETypeParameter(eClass, typeParameter);
		}
	}

	private ETypeParameter findOrCreateETypeParameter(EOperation eOperation,
			MTypeParameter typeParameter) {

		List<ETypeParameter> eTypeParameters = eOperation.getETypeParameters();
		return findOrCreateTypeParameter(typeParameter, eTypeParameters);
	}

	private ETypeParameter findOrCreateETypeParameter(EClass eClass,
			MTypeParameter typeParameter) {

		List<ETypeParameter> eTypeParameters = eClass.getETypeParameters();
		return findOrCreateTypeParameter(typeParameter, eTypeParameters);
	}

	private ETypeParameter findOrCreateTypeParameter(
			final MTypeParameter typeParameter,
			List<ETypeParameter> eTypeParameters) {
		String mName = typeParameter.getName();

		for (ETypeParameter eTypeParameter : eTypeParameters) {
			String eName = eTypeParameter.getName();
			if (eName != null && eName.equals(mName)) {
				primaryMapping.put(typeParameter, eTypeParameter);
				return eTypeParameter;
			}
		}
		final ETypeParameter newETypeParameter = EcoreFactory.eINSTANCE
				.createETypeParameter();
		reverseMapping.put(newETypeParameter, typeParameter);
		newETypeParameter.setName(mName);

		// set type bounds
		commands.add(new IMecoreCommand<Object>() {

			@Override
			public boolean execute(Object context) {
				setTypeBound(typeParameter, newETypeParameter);
				return true;
			}
		});

		eTypeParameters.add(newETypeParameter);
		// TODO this mapping must consider scoping of type parameters
		primaryMapping.put(typeParameter, newETypeParameter);
		return newETypeParameter;
	}

	private void setTypeBound(MTypeParameter mTypeParameter,
			ETypeParameter eTypeParameter) {
		MType lowerBound = mTypeParameter.getLowerBound();
		if (lowerBound != null) {
			EGenericType eLowerBound = EcoreFactory.eINSTANCE
					.createEGenericType();
			reverseMapping.put(eLowerBound, mTypeParameter);
			eLowerBound.setEClassifier(getEType(lowerBound));
			eTypeParameter.getEBounds().add(eLowerBound);
		}
	}

	private void wrapMParameter(MParameter mParameter,
			EOperation existingOperation) {
		final MType mType = mParameter.getType();
		if (mType == null) {
			return;
		}
		final List<MType> typeArguments = mParameter.getTypeArguments();
		final EParameter eParameter = findOrCreateEParameter(mParameter,
				existingOperation);

		commands.add(new IMecoreCommand<Object>() {

			public boolean execute(Object context) {
				setType(eParameter, mType, typeArguments);
				return true;
			}
		});

		setMulitplicity(mParameter, eParameter);
		primaryMapping.put(mParameter, eParameter);
		eParameter.setName(mParameter.getName());
	}

	private EStructuralFeature createReference(final MFeature mFeature,
			final MType mType, EClass eClass) {
		// complex type, create reference
		final EReference eReference = findOrCreateEReference(mFeature, eClass);
		commands.add(new IMecoreCommand<Object>() {

			public boolean execute(Object context) {
				setType(eReference, mType, Collections.<MType> emptyList());
				MFeature opposite = mFeature.getOpposite();
				if (opposite != null) {
					eReference.setEOpposite((EReference) primaryMapping
							.get(opposite));
				} else {
					eReference.setEOpposite(null);
				}
				return true;
			}
		});
		eReference.setContainment(!mFeature.isNcReference());
		return eReference;
	}

	private void setMulitplicity(MTypedElement mElement, ETypedElement eElement) {
		MMultiplicity multiplicity = mElement.getMultiplicity();
		if (multiplicity instanceof MSimpleMultiplicity) {
			MSimpleMultiplicity simpleMultiplicity = (MSimpleMultiplicity) multiplicity;
			MSimpleMultiplicityValue value = simpleMultiplicity.getValue();
			if (value == MSimpleMultiplicityValue.STAR) {
				setBounds(eElement, 0, -1);
			} else if (value == MSimpleMultiplicityValue.PLUS) {
				setBounds(eElement, 1, -1);
			} else if (value == MSimpleMultiplicityValue.OPTIONAL) {
				setBounds(eElement, 0, 1);
			} else {
				setBounds(eElement, 1, 1);
			}
		} else if (multiplicity instanceof MComplexMultiplicity) {
			MComplexMultiplicity complexMultiplicity = (MComplexMultiplicity) multiplicity;
			eElement.setLowerBound(complexMultiplicity.getLowerBound());
			eElement.setUpperBound(complexMultiplicity.getUpperBound());
		} else if (multiplicity == null) {
			setBounds(eElement, 1, 1);
		}
	}

	private void setBounds(ETypedElement element, int lower, int upper) {
		element.setLowerBound(lower);
		element.setUpperBound(upper);
	}

	private EPackage findOrCreateEPackage(MPackage mPackage,
			EPackage existingSuperPackage) {
		if (primaryMapping.containsKey(mPackage)) {
			return (EPackage) primaryMapping.get(mPackage);
		}

		if (existingSuperPackage != null) {
			List<EPackage> existingSubPackages = existingSuperPackage
					.getESubpackages();
			for (EPackage existingSubPackage : existingSubPackages) {
				if (mPackage.getName().equals(existingSubPackage.getName())) {
					primaryMapping.put(mPackage, existingSubPackage);
					return (EPackage) existingSubPackage;
				}
			}
		}

		// if we can't find an existing EPackage, we need to create a fresh one
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		reverseMapping.put(ePackage, mPackage);
		
		addAnnotation(ePackage, COMMENT_VALUE);
		if (existingSuperPackage != null) {
			existingSuperPackage.getESubpackages().add(ePackage);
		}
		primaryMapping.put(mPackage, ePackage);
		return ePackage;
	}

	private EClass findOrCreateEClass(MClass mClass, EPackage ePackage) {
		if (primaryMapping.containsKey(mClass)) {
			return (EClass) primaryMapping.get(mClass);
		}

		EClassifier existingEClassifier = ePackage.getEClassifier(mClass
				.getName());
		if (existingEClassifier != null
				&& existingEClassifier instanceof EClass) {
			primaryMapping.put(mClass, existingEClassifier);
			return (EClass) existingEClassifier;
		}

		// if we can't find an existing EClass, we need to create a fresh one
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		reverseMapping.put(eClass, mClass);
		addAnnotation(eClass, COMMENT_VALUE);
		ePackage.getEClassifiers().add(eClass);
		primaryMapping.put(mClass, eClass);
		return eClass;
	}

	private EEnum findOrCreateEEnum(MEnum mEnum, EPackage ePackage) {
		if (primaryMapping.containsKey(mEnum)) {
			return (EEnum) primaryMapping.get(mEnum);
		}

		EClassifier existingEClassifier = ePackage.getEClassifier(mEnum
				.getName());
		if (existingEClassifier != null && existingEClassifier instanceof EEnum) {
			primaryMapping.put(mEnum, existingEClassifier);
			return (EEnum) existingEClassifier;
		}

		// if we can't find an existing EEnum, we need to create a fresh one
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		reverseMapping.put(eEnum, mEnum);
		addAnnotation(eEnum, COMMENT_VALUE);
		ePackage.getEClassifiers().add(eEnum);
		primaryMapping.put(mEnum, eEnum);
		return eEnum;
	}

	private EEnumLiteral findOrCreateEEnumLiteral(MEnumLiteral mEnumLiteral,
			EEnum existingEnum) {
		if (primaryMapping.containsKey(mEnumLiteral)) {
			return (EEnumLiteral) primaryMapping.get(mEnumLiteral);
		}

		EEnumLiteral existingEEnumLiteral = existingEnum
				.getEEnumLiteral(mEnumLiteral.getName());
		if (existingEEnumLiteral != null) {
			primaryMapping.put(mEnumLiteral, existingEEnumLiteral);
			return existingEEnumLiteral;
		}

		// if we can't find an existing EEnumLiteral, we need to create a fresh
		// one
		EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		reverseMapping.put(eEnumLiteral, mEnumLiteral);
		addAnnotation(eEnumLiteral, COMMENT_VALUE);
		existingEnum.getELiterals().add(eEnumLiteral);
		primaryMapping.put(mEnumLiteral, eEnumLiteral);
		return eEnumLiteral;
	}

	private EAttribute findOrCreateEAttribute(MFeature mFeature,
			EClass existingEClass) {
		if (primaryMapping.containsKey(mFeature)) {
			return (EAttribute) primaryMapping.get(mFeature);
		}

		EStructuralFeature existingFeature = existingEClass
				.getEStructuralFeature(mFeature.getName());
		if (existingFeature != null && existingFeature instanceof EAttribute) {
			primaryMapping.put(mFeature, existingFeature);
			return (EAttribute) existingFeature;
		}

		// if we can't find an existing EAttribute, we need to create a fresh
		// one
		EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		reverseMapping.put(eAttribute, mFeature);
		addAnnotation(eAttribute, COMMENT_VALUE);
		existingEClass.getEStructuralFeatures().add(eAttribute);
		primaryMapping.put(mFeature, eAttribute);
		return eAttribute;
	}

	private EReference findOrCreateEReference(MFeature mFeature,
			EClass existingEClass) {
		if (primaryMapping.containsKey(mFeature)) {
			return (EReference) primaryMapping.get(mFeature);
		}

		EStructuralFeature existingFeature = existingEClass
				.getEStructuralFeature(mFeature.getName());
		if (existingFeature != null && existingFeature instanceof EReference) {
			primaryMapping.put(mFeature, existingFeature);
			return (EReference) existingFeature;
		}

		// if we can't find an existing EReference, we need to create a fresh
		// one
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		reverseMapping.put(eReference, mFeature);
		
		addAnnotation(eReference, COMMENT_VALUE);
		existingEClass.getEStructuralFeatures().add(eReference);
		primaryMapping.put(mFeature, eReference);
		return eReference;
	}

	private EOperation findOrCreateEOperation(MOperation mOperation,
			EClass existingEClass) {
		if (primaryMapping.containsKey(mOperation)) {
			return (EOperation) primaryMapping.get(mOperation);
		}

		EOperation existingOperation = null;
		for (EOperation operation : existingEClass.getEOperations()) {
			String name = operation.getName();
			if (name != null && name.equals(mOperation.getName())) {
				// TODO check parameter types and return type
				existingOperation = operation;
				break;
			}
		}

		if (existingOperation != null
				&& existingOperation instanceof EOperation) {
			primaryMapping.put(mOperation, existingOperation);
			return (EOperation) existingOperation;
		}

		// if we can't find an existing EOperation, we need to create a fresh
		// one
		EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		reverseMapping.put(eOperation, mOperation);
		
		addAnnotation(eOperation, COMMENT_VALUE);
		existingEClass.getEOperations().add(eOperation);
		primaryMapping.put(mOperation, eOperation);
		return eOperation;
	}

	private EParameter findOrCreateEParameter(MParameter mParameter,
			EOperation existingEOperation) {
		if (primaryMapping.containsKey(mParameter)) {
			return (EParameter) primaryMapping.get(mParameter);
		}

		EParameter existingParameter = null;
		for (EParameter parameter : existingEOperation.getEParameters()) {
			String name = parameter.getName();
			if (name != null && name.equals(mParameter.getName())) {
				// TODO check parameter types and return type
				existingParameter = parameter;
				break;
			}
		}

		if (existingParameter != null
				&& existingParameter instanceof EParameter) {
			primaryMapping.put(mParameter, existingParameter);
			return (EParameter) existingParameter;
		}

		// if we can't find an existing EParameter, we need to create a fresh
		// one
		EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		reverseMapping.put(eParameter, mParameter);
		
		addAnnotation(eParameter, COMMENT_VALUE);
		existingEOperation.getEParameters().add(eParameter);
		primaryMapping.put(mParameter, eParameter);
		return eParameter;
	}

	public Map<EObject, MModelElement> getReverseMapping() {
		return reverseMapping;
	}

	private EClassifier getEType(MType mType) {
		EClassifier eType = null;
		if (mType instanceof MEcoreType) {
			MEcoreType mEcoreType = (MEcoreType) mType;
			eType = mEcoreType.getEcoreType();
		} else if (mType instanceof MDataType) {
			MDataType mDataType = (MDataType) mType;
			eType = mDataType.getEDataType();
		} else if (mType instanceof MTypeParameter) {
			// requires a generic type
		} else {
			EClass eClass = (EClass) primaryMapping.get(mType);
			eType = eClass;
		}
		return eType;
	}

	private EGenericType getGenericEType(MType mType) {
		if (mType instanceof MTypeParameter) {
			MTypeParameter mTypeParameter = (MTypeParameter) mType;
			EGenericType eGenericType = createEGenericTypeParameter(mTypeParameter);
			return eGenericType;
		} else {
			// requires a normal type
			return null;
		}
	}

	private void setType(ETypedElement eTypedElement, MType mType,
			List<MType> mTypeArguments) {
		EClassifier eType = getEType(mType);
		EGenericType eGenericType = getGenericEType(mType);

		if (mTypeArguments.isEmpty()) {
			if (eType != null) {
				eTypedElement.setEType(eType);
			}
			if (eGenericType != null) {
				eTypedElement.setEGenericType(eGenericType);
			}
		} else {
			if (eGenericType == null) {
				eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
				reverseMapping.put(eGenericType, mType);
			}
			if (eType != null) {
				eGenericType.setEClassifier(eType);
			}
			List<EGenericType> eTypeArguments = eGenericType
					.getETypeArguments();
			for (MType mTypeArgument : mTypeArguments) {
				eTypeArguments.add(createEGenericTypeParameter(mTypeArgument));
			}
			eTypedElement.setEGenericType(eGenericType);
		}
	}

	private EGenericType createEGenericTypeParameter(MType mType) {
		EGenericType genericType = EcoreFactory.eINSTANCE.createEGenericType();
		reverseMapping.put(genericType, mType);
		ETypeParameter eTypeParameter = (ETypeParameter) primaryMapping
				.get(mType);
		genericType.setETypeParameter(eTypeParameter);
		return genericType;
	}

	private void wrapMSuperTypeReference(final EClass eClass,
			MSuperTypeReference supertypeRef) {
		List<EClass> eSuperTypes = eClass.getESuperTypes();
		List<EGenericType> eGenericSuperTypes = eClass.getEGenericSuperTypes();

		EClass eSuperType = getSuperType(supertypeRef);
		if (eSuperType == null) {
			return;
		}
		List<MType> mTypeArguments = supertypeRef.getTypeArguments();
		if (mTypeArguments.isEmpty()) {
			// this is a non-generic super type
			if (!eSuperTypes.contains(eSuperType)) {
				eSuperTypes.add(eSuperType);
			}
		} else {
			EGenericType eGenericSuperType = EcoreFactory.eINSTANCE
					.createEGenericType();
			reverseMapping.put(eGenericSuperType, supertypeRef);

			eGenericSuperType.setEClassifier(eSuperType);
			eGenericSuperTypes.add(eGenericSuperType);

			for (MType mTypeArgument : mTypeArguments) {
				EGenericType eTypeArgument = EcoreFactory.eINSTANCE
						.createEGenericType();
				reverseMapping.put(eTypeArgument, supertypeRef);

				EClassifier eType = getEType(mTypeArgument);
				eTypeArgument.setEClassifier(eType);
				eGenericSuperType.getETypeArguments().add(eTypeArgument);
			}
		}
	}
}
