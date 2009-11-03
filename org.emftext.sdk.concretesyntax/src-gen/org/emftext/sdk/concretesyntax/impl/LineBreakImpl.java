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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.LineBreak;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Line Break</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.LineBreakImpl#getTab <em>Tab</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LineBreakImpl extends DefinitionImpl implements LineBreak {
	/**
	 * The default value of the '{@link #getTab() <em>Tab</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTab()
	 * @generated
	 * @ordered
	 */
	protected static final int TAB_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTab() <em>Tab</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTab()
	 * @generated
	 * @ordered
	 */
	protected int tab = TAB_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LineBreakImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.LINE_BREAK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTab() {
		return tab;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTab(int newTab) {
		int oldTab = tab;
		tab = newTab;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.LINE_BREAK__TAB, oldTab, tab));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.LINE_BREAK__TAB:
				return getTab();
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
			case ConcretesyntaxPackage.LINE_BREAK__TAB:
				setTab((Integer)newValue);
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
			case ConcretesyntaxPackage.LINE_BREAK__TAB:
				setTab(TAB_EDEFAULT);
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
			case ConcretesyntaxPackage.LINE_BREAK__TAB:
				return tab != TAB_EDEFAULT;
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
		result.append(" (tab: ");
		result.append(tab);
		result.append(')');
		return result.toString();
	}

} //LineBreakImpl
