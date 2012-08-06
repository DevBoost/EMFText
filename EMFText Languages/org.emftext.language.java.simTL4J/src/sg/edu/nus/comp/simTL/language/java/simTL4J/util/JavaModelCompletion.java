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
package sg.edu.nus.comp.simTL.language.java.simTL4J.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import sg.edu.nus.comp.simTL.language.java.simTL4J.annotations.AnnotationAttributeSetting;
import sg.edu.nus.comp.simTL.language.java.simTL4J.annotations.AnnotationInstance;
import sg.edu.nus.comp.simTL.language.java.simTL4J.annotations.AnnotationsFactory;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Annotation;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Class;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Enumeration;
import sg.edu.nus.comp.simTL.language.java.simTL4J.classifiers.Interface;
import sg.edu.nus.comp.simTL.language.java.simTL4J.expressions.Expression;
import sg.edu.nus.comp.simTL.language.java.simTL4J.expressions.PrimaryExpression;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.MembersFactory;
import sg.edu.nus.comp.simTL.language.java.simTL4J.members.Method;
import sg.edu.nus.comp.simTL.language.java.simTL4J.parameters.Parameter;
import sg.edu.nus.comp.simTL.language.java.simTL4J.parameters.ParametersFactory;
import sg.edu.nus.comp.simTL.language.java.simTL4J.types.ClassifierReference;
import sg.edu.nus.comp.simTL.language.java.simTL4J.types.TypesFactory;

/**
 * Utility class that enhances and simplifies a Java model based on
 * Java language specifics.
 */
public class JavaModelCompletion {

	/**
	 * Main method to perform the completion for the given resource.
	 *
	 * @param resource
	 */
	public static void complete(Resource resource) {
		for(Iterator<EObject> contentIterator = resource.getAllContents(); contentIterator.hasNext(); ) {
			EObject element = contentIterator.next();
			if (element instanceof Class) {
				addDefaultSuperClass((Class) element);
			}
			if (element instanceof Interface) {
				addDefaultSuperInterface((Interface) element);
			}
			if (element instanceof Enumeration) {
				addMissingEnumerationMembers((Enumeration) element);
			}
			if (element instanceof Annotation) {
				addMissingAnnotationMembers((Annotation) element);
			}
		}
		simplifyExpressions(resource);
	}

	/**
	 * Adds <code>java.lang.Object</code> as default super class if non is specified.
	 *
	 * @param javaClass
	 */
	public static void addDefaultSuperClass(Class javaClass) {
		if (javaClass.getExtends() == null && javaClass.getDefaultExtends() == null) {
			Class objectClass = javaClass.getObjectClass();
			ClassifierReference classifierReference = TypesFactory.eINSTANCE.createClassifierReference();
			classifierReference.setTarget(objectClass);
			javaClass.setDefaultExtends(classifierReference);
		}
	}

	/**
	 * Adds <code>java.lang.Object</code> as a default super interface to an interface
	 * that implements no other interface.
	 *
	 * @param javaClass
	 */
	public static void addDefaultSuperInterface(Interface javaInterface) {
		if (javaInterface.getExtends().isEmpty() && javaInterface.getDefaultExtends().isEmpty()) {
			Class objectClass = javaInterface.getObjectClass();
			ClassifierReference classifierReference = TypesFactory.eINSTANCE.createClassifierReference();
			classifierReference.setTarget(objectClass);
			javaInterface.getDefaultExtends().add(classifierReference);
		}
	}

	public static void addMissingAnnotationMembers(Annotation annotation) {
		String valueMethodName = "value";
		Method valueMethod = annotation.getContainedMethod(valueMethodName);
		if (valueMethod == null) {
			valueMethod = AnnotationsFactory.eINSTANCE.createAnnotationAttribute();
			valueMethod.setName(valueMethodName);
			ClassifierReference type = TypesFactory.eINSTANCE.createClassifierReference();
			type.setTarget(annotation.getConcreteClassifier("java.lang.String"));
			valueMethod.setTypeReference(type);
			annotation.getDefaultMembers().add(valueMethod);
		}
	}

	/**
	 * Adds the additional methods <code>value()</code> and <code>calueOf()</code>
	 * to the given enumeration.
	 *
	 * @param enumeration the enumeration to complete
	 */
	public static void addMissingEnumerationMembers(Enumeration enumeration) {

		//add the values
		String valuesMethodName = "values";
		Method valuesMethod = enumeration.getContainedMethod(valuesMethodName);

		if (valuesMethod == null) {
			valuesMethod = MembersFactory.eINSTANCE.createInterfaceMethod();
			valuesMethod.setName(valuesMethodName);

			ClassifierReference type = TypesFactory.eINSTANCE.createClassifierReference();
			type.setTarget(enumeration);
			valuesMethod.setTypeReference(type);
			enumeration.getDefaultMembers().add(valuesMethod);
		}

		//add the value of method
		String valueOfMethodName = "valueOf";
		Method valueOfMethod = enumeration.getContainedMethod(valueOfMethodName);

		if (valueOfMethod == null) {
			valueOfMethod = MembersFactory.eINSTANCE.createInterfaceMethod();
			valueOfMethod.setName(valueOfMethodName);

			ClassifierReference type = TypesFactory.eINSTANCE.createClassifierReference();
			type.setTarget(enumeration);
			valueOfMethod.setTypeReference(type);

			Parameter strParameter = ParametersFactory.eINSTANCE.createOrdinaryParameter();
			strParameter.setName("str");
			type = TypesFactory.eINSTANCE.createClassifierReference();
			type.setTarget(enumeration.getConcreteClassifier("java.lang.String"));
			strParameter.setTypeReference(type);

			valueOfMethod.getParameters().add(strParameter);
			enumeration.getDefaultMembers().add(valueOfMethod);
		}
	}

	/**
	 * Simplifies all expression in the given resource by removing empty containers
	 * in all expression trees.
	 *
	 * @param resource
	 */
	public static void simplifyExpressions(Resource resource) {
		simplifyDown(resource.getContents());
	}

	private static void simplifyDown(EList<EObject> parentList) {
		for(EObject child : new BasicEList<EObject>(parentList)) {
			EObject singleContained = getSingleContained(child);
			EObject next = singleContained;
			while (next != null) {
				next = getSingleContained(singleContained);
				if (next != null) {
					singleContained = next;
				}
			}
			if (singleContained != null) {
				EcoreUtil.replace(child, singleContained);
				child = singleContained;
			}
			simplifyDown(child.eContents());
		}
	}

	private static EObject getSingleContained(EObject parent) {
		if (parent.eContainer() instanceof AnnotationInstance ||
				parent.eContainer() instanceof AnnotationAttributeSetting) {
			//special case. Might be changed in the future.
			return null;
		}
		if (!(parent instanceof Expression)) {
			return null;
		}
		//never kill a primary
		if (parent instanceof PrimaryExpression) {
			return null;
		}

		EObject singleContained = null;
		for(EObject contained : parent.eContents()) {
			if (singleContained != null) {
				return null;
			}
			singleContained = contained;
		}
		if (!(singleContained instanceof Expression)) {
			return null;
		}

		return singleContained;
	}

}
