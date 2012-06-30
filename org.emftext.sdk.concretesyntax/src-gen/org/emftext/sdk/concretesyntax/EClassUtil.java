/**
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
 *  
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EClass Util</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getEClassUtil()
 * @model
 * @generated
 */
public interface EClassUtil extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (subClassCandidate == null) {\n\treturn false;\n}\nfor ( org.eclipse.emf.ecore.EClass superClassCandidate : subClassCandidate.getEAllSuperTypes()) {\n\t// There seem to be multiple instances of meta classes when accessed\n\t// through the generator model. Therefore, we compare by name.\n\tif (namesAndPackageURIsAreEqual(superClassCandidate, superClass)) {\n\t\treturn true;\n\t}\n}\nreturn false;'"
	 * @generated
	 */
	boolean isSubClass(EClass subClassCandidate, EClass superClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Returns all subclasses of 'superClass' that are contained
	 *  in 'availableClasses'.
	 *  
	 *  @param superClass the superclass
	 *  @param availableClasses the set of classes to search in
	 *  @return a list of all subclasses of 'superClass'
	 * 
	 * <!-- end-model-doc -->
	 * @model availableClassesMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList< org.eclipse.emf.ecore.EClass> result = new org.eclipse.emf.common.util.BasicEList< org.eclipse.emf.ecore.EClass>();\nfor ( org.eclipse.emf.ecore.EClass next : availableClasses) {\n\tif (isSubClass(next, superClass) &&\n\t\tisConcrete(next)) {\n\t\tresult.add(next);\n\t}\n}\nreturn result;'"
	 * @generated
	 */
	EList<EClass> getSubClasses(EClass superClass, EList<EClass> availableClasses);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return namesAreEqual(classA, classB) && \n\tpackageURIsAreEqual(classA, classB);'"
	 * @generated
	 */
	boolean namesAndPackageURIsAreEqual(EClass classA, EClass classB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='java.lang.String nsURI_A = classA.getEPackage().getNsURI();\njava.lang.String nsURI_B = classB.getEPackage().getNsURI();\nif (nsURI_A == null && nsURI_B == null) {\n\treturn true;\n}\nif (nsURI_A != null) {\n\treturn nsURI_A.equals(nsURI_B);\n} else {\n\t// nsURI_A is null, but nsURI_B is not\n\treturn false;\n}'"
	 * @generated
	 */
	boolean packageURIsAreEqual(EClass classA, EClass classB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (classA == null || classB == null) {\n\treturn false;\n}\njava.lang.String nameA = classA.getName();\njava.lang.String nameB = classB.getName();\nif (nameA == null) {\n\treturn nameB == null;\n}\nreturn nameA.equals(nameB);'"
	 * @generated
	 */
	boolean namesAreEqual(EClass classA, EClass classB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return !eClass.isAbstract() && !eClass.isInterface();'"
	 * @generated
	 */
	boolean isConcrete(EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return !isConcrete(eClass);'"
	 * @generated
	 */
	boolean isNotConcrete(EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" subclassCandidateRequired="true" superTypeRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean isEqual = namesAndPackageURIsAreEqual(subclassCandidate, superType);\nboolean isSubclass = isSubClass(subclassCandidate, superType);\nreturn isEqual || isSubclass;'"
	 * @generated
	 */
	boolean isSubClassOrEqual(EClass subclassCandidate, EClass superType);

} // EClassUtil
