/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.concretesyntax.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Package Dependent Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.GenPackageDependentElementImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.GenPackageDependentElementImpl#getPackageLocationHint <em>Package Location Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GenPackageDependentElementImpl extends EObjectImpl implements GenPackageDependentElement {
	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected GenPackage package_;

	/**
	 * The default value of the '{@link #getPackageLocationHint() <em>Package Location Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageLocationHint()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_LOCATION_HINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageLocationHint() <em>Package Location Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageLocationHint()
	 * @generated
	 * @ordered
	 */
	protected String packageLocationHint = PACKAGE_LOCATION_HINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenPackageDependentElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.GEN_PACKAGE_DEPENDENT_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPackage getPackage() {
		if (package_ != null && package_.eIsProxy()) {
			InternalEObject oldPackage = (InternalEObject)package_;
			package_ = (GenPackage)eResolveProxy(oldPackage);
			if (package_ != oldPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE, oldPackage, package_));
			}
		}
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPackage basicGetPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(GenPackage newPackage) {
		GenPackage oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageLocationHint() {
		return packageLocationHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageLocationHint(String newPackageLocationHint) {
		String oldPackageLocationHint = packageLocationHint;
		packageLocationHint = newPackageLocationHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT, oldPackageLocationHint, packageLocationHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE:
				if (resolve) return getPackage();
				return basicGetPackage();
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT:
				return getPackageLocationHint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE:
				setPackage((GenPackage)newValue);
				return;
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT:
				setPackageLocationHint((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE:
				setPackage((GenPackage)null);
				return;
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT:
				setPackageLocationHint(PACKAGE_LOCATION_HINT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE:
				return package_ != null;
			case ConcretesyntaxPackage.GEN_PACKAGE_DEPENDENT_ELEMENT__PACKAGE_LOCATION_HINT:
				return PACKAGE_LOCATION_HINT_EDEFAULT == null ? packageLocationHint != null : !PACKAGE_LOCATION_HINT_EDEFAULT.equals(packageLocationHint);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (packageLocationHint: ");
		result.append(packageLocationHint);
		result.append(')');
		return result.toString();
	}

} //GenPackageDependentElementImpl
