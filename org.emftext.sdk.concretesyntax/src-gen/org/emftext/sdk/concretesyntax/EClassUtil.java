/**
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany 
 *       - initial API and implementation
 * 
 *
 * $Id$
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( org.eclipse.emf.ecore.EClass superClassCandidate : subClassCandidate .getEAllSuperTypes ( ) ) { \r\n\t// There seem to be multiple instances of meta classes when accessed\n// through the generator model. Therefore, we compare by name.\nif ( namesAndPackageURIsAreEqual ( superClassCandidate , superClass ) ) { \r\n\t\treturn true ; \r\n\t} \r\n} \r\nreturn false ; \r\n'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.eclipse.emf.ecore.EClass > result = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.ecore.EClass > ( ) ; \r\nfor ( org.eclipse.emf.ecore.EClass next : availableClasses ) { \r\n\tif ( isSubClass ( next , superClass ) && isConcrete ( next ) ) { \r\n\t\tresult .add ( next ) ; \r\n\t} \r\n} \r\nreturn result ; \r\n'"
	 * @generated
	 */
	EList<EClass> getSubClasses(EClass superClass, EList<EClass> availableClasses);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return namesAreEqual ( classA , classB ) && packageURIsAreEqual ( classA , classB ) ; \r\n'"
	 * @generated
	 */
	boolean namesAndPackageURIsAreEqual(EClass classA, EClass classB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='java.lang.String nsURI_A = classA .getEPackage ( ) .getNsURI ( ) ; \r\njava.lang.String nsURI_B = classB .getEPackage ( ) .getNsURI ( ) ; \r\nreturn ( nsURI_A == null && nsURI_B == null ) || nsURI_A .equals ( nsURI_B ) ; \r\n'"
	 * @generated
	 */
	boolean packageURIsAreEqual(EClass classA, EClass classB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return classA .getName ( ) .equals ( classB .getName ( ) ) ; \r\n'"
	 * @generated
	 */
	boolean namesAreEqual(EClass classA, EClass classB);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ! eClass .isAbstract ( ) && ! eClass .isInterface ( ) ; \r\n'"
	 * @generated
	 */
	boolean isConcrete(EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ! isConcrete ( eClass ) ; \r\n'"
	 * @generated
	 */
	boolean isNotConcrete(EClass eClass);

} // EClassUtil
