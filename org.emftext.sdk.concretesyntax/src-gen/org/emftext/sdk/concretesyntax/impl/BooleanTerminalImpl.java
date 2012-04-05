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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Terminal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.BooleanTerminalImpl#getTrueLiteral <em>True Literal</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.impl.BooleanTerminalImpl#getFalseLiteral <em>False Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanTerminalImpl extends TerminalImpl implements BooleanTerminal {
	/**
	 * The default value of the '{@link #getTrueLiteral() <em>True Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String TRUE_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrueLiteral() <em>True Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrueLiteral()
	 * @generated
	 * @ordered
	 */
	protected String trueLiteral = TRUE_LITERAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getFalseLiteral() <em>False Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String FALSE_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFalseLiteral() <em>False Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFalseLiteral()
	 * @generated
	 * @ordered
	 */
	protected String falseLiteral = FALSE_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanTerminalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.BOOLEAN_TERMINAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTrueLiteral() {
		return trueLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueLiteral(String newTrueLiteral) {
		String oldTrueLiteral = trueLiteral;
		trueLiteral = newTrueLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL, oldTrueLiteral, trueLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFalseLiteral() {
		return falseLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFalseLiteral(String newFalseLiteral) {
		String oldFalseLiteral = falseLiteral;
		falseLiteral = newFalseLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL, oldFalseLiteral, falseLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean containsEmptyLiteral() {
		
				return "".equals(getTrueLiteral()) || "".equals(getFalseLiteral());
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL:
				return getTrueLiteral();
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL:
				return getFalseLiteral();
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
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL:
				setTrueLiteral((String)newValue);
				return;
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL:
				setFalseLiteral((String)newValue);
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
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL:
				setTrueLiteral(TRUE_LITERAL_EDEFAULT);
				return;
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL:
				setFalseLiteral(FALSE_LITERAL_EDEFAULT);
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
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL__TRUE_LITERAL:
				return TRUE_LITERAL_EDEFAULT == null ? trueLiteral != null : !TRUE_LITERAL_EDEFAULT.equals(trueLiteral);
			case ConcretesyntaxPackage.BOOLEAN_TERMINAL__FALSE_LITERAL:
				return FALSE_LITERAL_EDEFAULT == null ? falseLiteral != null : !FALSE_LITERAL_EDEFAULT.equals(falseLiteral);
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
		result.append(" (trueLiteral: ");
		result.append(trueLiteral);
		result.append(", falseLiteral: ");
		result.append(falseLiteral);
		result.append(')');
		return result.toString();
	}

} //BooleanTerminalImpl
