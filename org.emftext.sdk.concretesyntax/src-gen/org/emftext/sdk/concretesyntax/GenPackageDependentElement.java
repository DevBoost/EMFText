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

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Package Dependent Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.GenPackageDependentElement#getPackage <em>Package</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.GenPackageDependentElement#getPackageLocationHint <em>Package Location Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getGenPackageDependentElement()
 * @model abstract="true"
 * @generated
 */
public interface GenPackageDependentElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see #setPackage(GenPackage)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getGenPackageDependentElement_Package()
	 * @model required="true"
	 * @generated
	 */
	GenPackage getPackage();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.GenPackageDependentElement#getPackage <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(GenPackage value);

	/**
	 * Returns the value of the '<em><b>Package Location Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Location Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Location Hint</em>' attribute.
	 * @see #setPackageLocationHint(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getGenPackageDependentElement_PackageLocationHint()
	 * @model
	 * @generated
	 */
	String getPackageLocationHint();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.GenPackageDependentElement#getPackageLocationHint <em>Package Location Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Location Hint</em>' attribute.
	 * @see #getPackageLocationHint()
	 * @generated
	 */
	void setPackageLocationHint(String value);

} // GenPackageDependentElement
