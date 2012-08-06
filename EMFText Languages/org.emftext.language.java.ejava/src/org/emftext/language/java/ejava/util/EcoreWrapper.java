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
package org.emftext.language.java.ejava.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.java.JavaClasspath;
import org.emftext.language.java.JavaUniquePathConstructor;
import org.emftext.language.java.classifiers.Classifier;
import org.emftext.language.java.ejava.EClassifierClassWrapper;
import org.emftext.language.java.ejava.EClassifierEnumerationWrapper;
import org.emftext.language.java.ejava.EClassifierInterfaceWrapper;
import org.emftext.language.java.ejava.EClassifierWrapper;
import org.emftext.language.java.ejava.EEnumLiteralWrapper;
import org.emftext.language.java.ejava.EOperationWrapper;
import org.emftext.language.java.ejava.EPackageWrapper;
import org.emftext.language.java.ejava.EStructuralFeatureGetWrapper;
import org.emftext.language.java.ejava.EStructuralFeatureSetWrapper;
import org.emftext.language.java.ejava.EjavaFactory;
import org.emftext.language.java.generics.GenericsFactory;
import org.emftext.language.java.generics.QualifiedTypeArgument;
import org.emftext.language.java.generics.TypeParameter;
import org.emftext.language.java.members.EnumConstant;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.parameters.ParametersFactory;
import org.emftext.language.java.types.ClassifierReference;
import org.emftext.language.java.types.PrimitiveType;
import org.emftext.language.java.types.Type;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesFactory;
import org.emftext.language.java.types.TypesPackage;
import org.emftext.language.java.types.Void;

/**
 * Wraps an Ecore model in an eJava model. This way, the Ecore types can be 
 * interpreted as Java types by JaMoPP.
 */
public class EcoreWrapper {

	public static void wrap(EPackageWrapper mainEPackageWrapper) {
		EMap<EList<String>, GenPackage> genPackagesInScope = findGenPackagesInScope(mainEPackageWrapper);

		for(final EList<String> namespaces : genPackagesInScope.keySet()) {
			GenPackage genPackage = genPackagesInScope.get(namespaces);
			if (genPackage.eIsProxy() && genPackage.getEcorePackage().eIsProxy()) {
				String message = "Can't find generator package for " + namespaces.toString();
				addError(mainEPackageWrapper.eResource(), message);
				continue;
			}
			wrapEPackage(genPackage, namespaces, mainEPackageWrapper);
		}

	}

	private static void addError(Resource resource, final String message) {
		resource.getErrors().add(new Diagnostic() {
			
			public String getMessage() {
				return message;
			}
			
			public String getLocation() {
				return null;
			}
			
			public int getLine() {
				return 0;
			}
			
			public int getColumn() {
				return 0;
			}
			
			@Override
			public String toString() {
				return message;
			}
		});
	}

	public static void wrapEPackage(GenPackage genPackage, EList<String> namespaces, EPackageWrapper mainEPackageWrapper) {
		EPackageWrapper wrapper = null;
		Resource wrapperResource = null;
		JavaClasspath cp = JavaClasspath.get(mainEPackageWrapper);
		String packageName = "";
		for(String s : namespaces) { packageName += s + "."; }

		if (mainEPackageWrapper.getNamespaces().equals(namespaces)) {
			wrapper = mainEPackageWrapper;
			wrapperResource = mainEPackageWrapper.eResource();
			wrapper.setGenPackage(genPackage);
			wrapper.setEPackage(genPackage.getEcorePackage());
		}

		for(EClassifier eClassifier : genPackage.getEcorePackage().getEClassifiers()) {
			if (wrapper == null) {
				URI uri = JavaUniquePathConstructor.getJavaFileResourceURI(packageName + eClassifier.getName());
				ResourceSet rs = mainEPackageWrapper.eResource().getResourceSet();
				wrapperResource = rs.getResource(uri, false);
				if (wrapperResource == null) {
					wrapperResource = new ResourceImpl(uri);
					rs.getResources().add(wrapperResource);
				}
				else {
					wrapperResource.getContents().clear();
				}
				wrapper = EjavaFactory.eINSTANCE.createEPackageWrapper();
				wrapperResource.getContents().add(wrapper);
				wrapper.getNamespaces().addAll(namespaces);
				wrapper.setGenPackage(genPackage);
				wrapper.setEPackage(genPackage.getEcorePackage());
			}
			wrapEClassifier(eClassifier, wrapper);
			cp.registerClassifier(packageName, eClassifier.getName(), wrapperResource.getURI());
		}
	}

	public static void wrapEClassifier(EClassifier eClassifier, EPackageWrapper ePackageWrapper)  {
		EClassifierWrapper wrapper = (EClassifierWrapper) ePackageWrapper.getContainedClassifier(eClassifier.getName());

		if (wrapper == null) {
			if (eClassifier instanceof EClass) {
				wrapper = EjavaFactory.eINSTANCE.createEClassifierInterfaceWrapper();
			}
			else if (eClassifier instanceof EEnum) {
				wrapper = EjavaFactory.eINSTANCE.createEClassifierEnumerationWrapper();
			}
			else {
				return;
			}
			wrapper.setName(eClassifier.getName());
			ePackageWrapper.getClassifiers().add(wrapper);
		}
		wrapper.setEClassifier(eClassifier);

		if (eClassifier instanceof EClass) {
			EClass eClass = (EClass)eClassifier;
			EList<TypeReference> superTypeList = null;
			if (wrapper instanceof EClassifierInterfaceWrapper) {
				superTypeList =
					((EClassifierInterfaceWrapper)wrapper).getExtends();
			}
			else /*wrapper instanceof EClassifierClassWrapper*/ {
				superTypeList =
					((EClassifierClassWrapper)wrapper).getImplements();
			}

			for(EClass extendedEClass : eClass.getESuperTypes()) {
				superTypeList.add(createTypeReferenceForEClassifier(extendedEClass, eClassifier.eResource().getResourceSet()));
			}

			JavaClasspath cp = JavaClasspath.get(eClassifier);
			ClassifierReference eObjectRef = TypesFactory.eINSTANCE.createClassifierReference();
			eObjectRef.setTarget((Classifier) cp.getClassifier("org.eclipse.emf.ecore.EObject"));
			superTypeList.add(eObjectRef);

			for(EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
				wrapEStructuralFeatureForGet(eStructuralFeature, wrapper);
				if (!eStructuralFeature.isMany() && !eStructuralFeature.isDerived()) {
					wrapEStructuralFeatureForSet(eStructuralFeature, wrapper);
				}
			}
			List<EOperation> eOperations = eClass.getEOperations();
			eOperations.addAll(getMissingOperations(eClass));
			for(EOperation eOperation : new ArrayList<EOperation>(eOperations)) {
				wrapEOperation(eOperation, wrapper);
			}
		}
		else if (eClassifier instanceof EEnum) {
			EEnum eEnmu = (EEnum) eClassifier;
			for(EEnumLiteral eEnumLiteral : eEnmu.getELiterals()) {
				wrapEEnumLiteral(eEnumLiteral, (EClassifierEnumerationWrapper) wrapper);
			}
		}
	}

	/**
	 * Returns operations that are present in the implementation of
	 * the given EClass but that are not declared in the meta model.
	 * This is needed because the classes from the EMF GenModel package
	 * do contain methods that are not declared in the meta model.
	 *
	 * @param eClass
	 * @return
	 */
	private static Collection<EOperation> getMissingOperations(EClass eClass) {
		Collection<EOperation> operations = new ArrayList<EOperation>();
		// TODO this name check is not sufficient
		if (eClass.getName().equals(GenModelPackage.eINSTANCE.getGenClass().getName())) {
			EOperation getQualifiedInterfaceNameOperation = EcoreFactory.eINSTANCE.createEOperation();
			getQualifiedInterfaceNameOperation.setName("getQualifiedInterfaceName");
			getQualifiedInterfaceNameOperation.setEType(EcorePackage.eINSTANCE.getEString());
			operations.add(getQualifiedInterfaceNameOperation);
		}
		if (eClass.getName().equals(GenModelPackage.eINSTANCE.getGenFeature().getName())) {
			EOperation getTypeGenClassOperation = EcoreFactory.eINSTANCE.createEOperation();
			getTypeGenClassOperation.setName("getTypeGenClass");
			getTypeGenClassOperation.setEType(GenModelPackage.eINSTANCE.getGenClass());
			operations.add(getTypeGenClassOperation);
		}
		return operations;
	}

	public static void wrapEStructuralFeatureForGet(
			EStructuralFeature eStructuralFeature, EClassifierWrapper eClassifierWrapper) {
		String prefix = "get";
		EClassifier type = eStructuralFeature.getEType();
		if (type != null && "EBoolean".equals(type.getName())) {
			prefix = "is";
		}
		String getterName = prefix + firstToUpperCase(eStructuralFeature.getName());
		Method method = eClassifierWrapper.getContainedMethod(getterName);
		if (method != null && !(method instanceof EStructuralFeatureGetWrapper)) {
			// can happen if a method with the same name was declared in eJava file
			return;
		}
		EStructuralFeatureGetWrapper wrapper = (EStructuralFeatureGetWrapper) method;

		if (wrapper == null) {
			wrapper = EjavaFactory.eINSTANCE.createEStructuralFeatureGetWrapper();
			eClassifierWrapper.getMembers().add(wrapper);
			wrapper.setName(getterName);
		}
		wrapper.setEStructuralFeature(eStructuralFeature);
		wrapper.setTypeReference(createTypeReferenceForETypedElement(eStructuralFeature));
	}

	public static void wrapEStructuralFeatureForSet(
			EStructuralFeature eStructuralFeature, EClassifierWrapper eClassifierWrapper) {
		String setterName = "set" + firstToUpperCase(eStructuralFeature.getName());
		Method method = eClassifierWrapper.getContainedMethod(setterName);
		if (method != null && !(method instanceof EStructuralFeatureGetWrapper)) {
			// can happen if a method with the same name was declared in eJava file
			return;
		}
		EStructuralFeatureSetWrapper wrapper = (EStructuralFeatureSetWrapper) method;

		if(wrapper == null) {
			wrapper = EjavaFactory.eINSTANCE.createEStructuralFeatureSetWrapper();
			eClassifierWrapper.getMembers().add(wrapper);
			wrapper.setName(setterName);

			Parameter parameter = ParametersFactory.eINSTANCE.createOrdinaryParameter();
			parameter.setName("value");
			parameter.setTypeReference(createTypeReferenceForETypedElement(eStructuralFeature));
			wrapper.getParameters().add(parameter);
		}

		wrapper.setEStructuralFeature(eStructuralFeature);
		wrapper.setTypeReference(TypesFactory.eINSTANCE.createVoid());
	}

	public static void wrapEOperation(
			EOperation eOperation, EClassifierWrapper eClassifierWrapper) {
		EOperationWrapper wrapper = (EOperationWrapper)
				eClassifierWrapper.getContainedMethod(eOperation.getName());

		if (wrapper == null) {
			wrapper = EjavaFactory.eINSTANCE.createEOperationWrapper();
			wrapper.setName(eOperation.getName());
			eClassifierWrapper.getMembers().add(wrapper);
		}
		wrapper.setEOperation(eOperation);
		wrapper.setTypeReference(createTypeReferenceForETypedElement(eOperation));

		// add type parameters to operation wrapper
		List<TypeParameter> typeParameters = wrapper.getTypeParameters();
		if (typeParameters.isEmpty()) {
			for (ETypeParameter eTypeParameter : eOperation.getETypeParameters()) {
				TypeParameter typeParameter = GenericsFactory.eINSTANCE.createTypeParameter();
				typeParameter.setName(eTypeParameter.getName());
				typeParameters.add(typeParameter);
			}
		}

		if (wrapper.getParameters().isEmpty()) {
			for(EParameter eParameter : eOperation.getEParameters()) {
				Parameter parameter = ParametersFactory.eINSTANCE.createOrdinaryParameter();
				parameter.setName(eParameter.getName());
				parameter.setTypeReference(createTypeReferenceForETypedElement(eParameter));
				wrapper.getParameters().add(parameter);
			}
		}
	}

	public static void wrapEEnumLiteral(
			EEnumLiteral eEnumLiteral, EClassifierEnumerationWrapper eClassifierWrapper) {
		EEnumLiteralWrapper wrapper = null;

		for(EnumConstant constant : eClassifierWrapper.getConstants()) {
			if (constant.getName().equals(eEnumLiteral.getName().toUpperCase())) {
				wrapper = (EEnumLiteralWrapper) constant;
			}
		}

		if (wrapper == null) {
			wrapper = EjavaFactory.eINSTANCE.createEEnumLiteralWrapper();
			wrapper.setName(eEnumLiteral.getName().toUpperCase());
			eClassifierWrapper.getConstants().add(wrapper);
		}
		wrapper.setEEnumLiteral(eEnumLiteral);
	}

	private static EMap<EList<String>, GenPackage> findGenPackagesInScope(EPackageWrapper context) {

		Resource eJavaResource = context.eResource();
		if (eJavaResource == null) {
			return ECollections.emptyEMap();
		}
		ResourceSet rs = eJavaResource.getResourceSet();
		if (rs == null) {
			return ECollections.emptyEMap();
		}

		EMap<EList<String>, GenPackage> result = new BasicEMap<EList<String>, GenPackage>();
		String fileName = context.getNamespaces().get(0) + ".genmodel";
		URI ecoreURI = eJavaResource.getURI().trimSegments(
				1 + context.getNamespaces().size()).appendSegment(fileName);
		try {
			Resource genModelResource = rs.getResource(ecoreURI, true);
			EcoreUtil.resolveAll(genModelResource);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}

		// we need to create a copy of the list of resource, because the resource
		// set is expanded while iterating over the resources.
		List<Resource> copy = new ArrayList<Resource>();
		copy.addAll(rs.getResources());
		for(Resource r : copy) {
			if (!r.getContents().isEmpty() && r.getContents().get(0) instanceof GenModel) {
				GenModel genModel = (GenModel)r.getContents().get(0);
				for(GenPackage genPackage : genModel.getGenPackages()) {
					collectGenPackages(genPackage, new BasicEList<String>(), result);
				}
				for(GenPackage genPackage : genModel.getUsedGenPackages()) {
					if (genPackage.eIsProxy()) {
						// TODO add error
						String message = "Can't find used generator package for " + genPackage.toString();
						addError(context.eResource(), message);
						continue;
					}
					collectGenPackages(genPackage, new BasicEList<String>(), result);
				}
			}
		}

		return result;
	}

	private static void collectGenPackages(GenPackage genPackage,
			EList<String> basePackageName, EMap<EList<String>, GenPackage> result) {
		basePackageName.add(genPackage.getPackageName());
		result.put(ECollections.unmodifiableEList(basePackageName), genPackage);
		for(GenPackage subGenPackage : genPackage.getNestedGenPackages()) {
			collectGenPackages(subGenPackage, new BasicEList<String>(basePackageName), result);
		}

	}

	private static Type getType(EClassifier eClassifier, ResourceSet resourceSet)  {
		if (eClassifier == null) {
			return TypesFactory.eINSTANCE.createVoid();
		}
		String javaTypeName = null;
		EPackage ePackage = eClassifier.getEPackage();
		if (ePackage != null) {
			if (eClassifier instanceof EDataType && !(eClassifier instanceof EEnum)) {
				javaTypeName = ((EDataType) eClassifier).getInstanceTypeName();
				if (javaTypeName != null && !javaTypeName.contains(".")) {
					//primitive type
					return (Type) TypesFactory.eINSTANCE.create(
							(EClass) TypesPackage.eINSTANCE.getEClassifier(
									firstToUpperCase(javaTypeName)));
				}
			} else if (isEClassifierFromEcorePackage(eClassifier)) {
				javaTypeName = getEcoreImplementationTypeName(eClassifier);
			}
			else if (eClassifier instanceof EClass) {
				javaTypeName = getFullPackageName(ePackage) + "." + eClassifier.getName();
			}
			else if (eClassifier instanceof EEnum) {
				javaTypeName = getFullPackageName(ePackage) + "." + eClassifier.getName();
			} else {
				throw new RuntimeException("Unknown EClassifier type: " + eClassifier.getClass());
			}
		}
		if (javaTypeName == null) {
			return null;
		}
		JavaClasspath cp = JavaClasspath.get(resourceSet);
		return (Type) cp.getClassifier(javaTypeName);
	}

	private static boolean isEClassifierFromEcorePackage(EClassifier eClassifier) {
		return EcorePackage.eINSTANCE == eClassifier.getEPackage();
	}

	private static String getEcoreImplementationTypeName(EClassifier eClassifier) {
		return eClassifier.getInstanceClassName();
	}

	private static TypeReference createTypeReferenceForEClassifier(EClassifier eClassifier, ResourceSet resourceSet) {
		Type type = getType(eClassifier, resourceSet);
		if (type instanceof TypeReference) {
			return (TypeReference) type;
		}
		ClassifierReference ref = TypesFactory.eINSTANCE.createClassifierReference();
		ref.setTarget((Classifier)type);
		return ref;
	}

	private static TypeReference createTypeReferenceForETypedElement(ETypedElement eTypedElement) {

		TypeReference baseTypeRef = createTypeReferenceForEClassifier(eTypedElement.getEType(), eTypedElement.eResource().getResourceSet());
		if (baseTypeRef instanceof Void) {
			return baseTypeRef;
		}
		if (!eTypedElement.isMany()) {
			return baseTypeRef;
		}
		else {
			ClassifierReference typeRef = TypesFactory.eINSTANCE.createClassifierReference();
			if (java.util.Map.Entry.class.getName().equals(eTypedElement.getEType().getInstanceClassName())) {
				Classifier mapType = (Classifier) JavaClasspath.get(eTypedElement).getClassifier(EMap.class.getName());
				typeRef.setTarget((Classifier) mapType);
				// TODO set type arguments for map
			} else {
				// we need to convert primitive types to their respective wrappers,
				// because lists cannot have primitive types as type argument
				PrimitiveType originalBaseTypeRef = null;
				if (baseTypeRef instanceof PrimitiveType) {
					originalBaseTypeRef = (PrimitiveType) baseTypeRef;
					baseTypeRef = TypesFactory.eINSTANCE.createClassifierReference();
					// we temporarily add 'originalBaseTypeRef' to the resource, because wrapPrimitiveType()
					// requires the resource to work correctly
					eTypedElement.eResource().getContents().add(originalBaseTypeRef);
					((ClassifierReference)baseTypeRef).setTarget(((PrimitiveType)originalBaseTypeRef).wrapPrimitiveType());
					eTypedElement.eResource().getContents().remove(originalBaseTypeRef);
				}
				Classifier listType;
				listType = (Classifier) JavaClasspath.get(eTypedElement).getClassifier(EList.class.getName());
				typeRef.setTarget((Classifier)listType);
				QualifiedTypeArgument typeArgument = GenericsFactory.eINSTANCE.createQualifiedTypeArgument();
				typeArgument.setTypeReference(baseTypeRef);
				typeRef.getTypeArguments().add(typeArgument);
			}
			return typeRef;
		}
	}

	private static String getFullPackageName(EPackage ePackage) {
		String s = ePackage.getName();
		while (ePackage.getESuperPackage() != null) {
			ePackage = ePackage.getESuperPackage();
			s = ePackage.getName() + "." + s;
		}
		return s;
	}

	private static String firstToUpperCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

}
