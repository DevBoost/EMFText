/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *  *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 *  
 * 
 */
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.EClassUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EClass Util</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EClassUtilImpl extends EObjectImpl implements EClassUtil {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClassUtilImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.ECLASS_UTIL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubClass(EClass subClassCandidate, EClass superClass) {
		for ( org.eclipse.emf.ecore.EClass superClassCandidate:subClassCandidate.getEAllSuperTypes()) {
			if (namesAndPackageURIsAreEqual(superClassCandidate,superClass)) {
				return true;
			}
		}
		return false;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getSubClasses(EClass superClass, EList<EClass> availableClasses) {
		org.eclipse.emf.common.util.EList < org.eclipse.emf.ecore.EClass >result = new org.eclipse.emf.common.util.BasicEList < org.eclipse.emf.ecore.EClass >();
		for ( org.eclipse.emf.ecore.EClass next:availableClasses) {
			if (isSubClass(next,superClass)&&isConcrete(next)) {
				result.add(next);
			}
		}
		return result;
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean namesAndPackageURIsAreEqual(EClass classA, EClass classB) {
		return namesAreEqual(classA,classB)&&packageURIsAreEqual(classA,classB);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean packageURIsAreEqual(EClass classA, EClass classB) {
		java.lang.String nsURI_A = classA.getEPackage().getNsURI();
		java.lang.String nsURI_B = classB.getEPackage().getNsURI();
		if (nsURI_A == null&&nsURI_B == null) {
			return true;
		}
		if (nsURI_A != null) {
			return nsURI_A.equals(nsURI_B);
		}else {
			return false;
		}
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean namesAreEqual(EClass classA, EClass classB) {
		return classA.getName().equals(classB.getName());
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConcrete(EClass eClass) {
		return!eClass.isAbstract()&&!eClass.isInterface();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNotConcrete(EClass eClass) {
		return!isConcrete(eClass);
		
	}

} //EClassUtilImpl
