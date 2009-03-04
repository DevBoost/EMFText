/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
