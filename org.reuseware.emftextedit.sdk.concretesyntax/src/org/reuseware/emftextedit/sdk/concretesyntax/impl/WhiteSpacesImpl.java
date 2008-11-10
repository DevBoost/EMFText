/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.reuseware.emftextedit.sdk.concretesyntax.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.reuseware.emftextedit.sdk.concretesyntax.ConcretesyntaxPackage;
import org.reuseware.emftextedit.sdk.concretesyntax.WhiteSpaces;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>White Spaces</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.reuseware.emftextedit.sdk.concretesyntax.impl.WhiteSpacesImpl#getAmmount <em>Ammount</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WhiteSpacesImpl extends DefinitionImpl implements WhiteSpaces {
	/**
	 * The default value of the '{@link #getAmmount() <em>Ammount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmmount()
	 * @generated
	 * @ordered
	 */
	protected static final int AMMOUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAmmount() <em>Ammount</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAmmount()
	 * @generated
	 * @ordered
	 */
	protected int ammount = AMMOUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhiteSpacesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConcretesyntaxPackage.Literals.WHITE_SPACES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAmmount() {
		return ammount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmmount(int newAmmount) {
		int oldAmmount = ammount;
		ammount = newAmmount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConcretesyntaxPackage.WHITE_SPACES__AMMOUNT, oldAmmount, ammount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConcretesyntaxPackage.WHITE_SPACES__AMMOUNT:
				return new Integer(getAmmount());
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
			case ConcretesyntaxPackage.WHITE_SPACES__AMMOUNT:
				setAmmount(((Integer)newValue).intValue());
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
			case ConcretesyntaxPackage.WHITE_SPACES__AMMOUNT:
				setAmmount(AMMOUNT_EDEFAULT);
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
			case ConcretesyntaxPackage.WHITE_SPACES__AMMOUNT:
				return ammount != AMMOUNT_EDEFAULT;
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
		result.append(" (ammount: ");
		result.append(ammount);
		result.append(')');
		return result.toString();
	}

} //WhiteSpacesImpl
