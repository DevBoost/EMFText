/**
 */
package org.emftext.test.cct5.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.test.cct5.Cct5Package;
import org.emftext.test.cct5.Diet;
import org.emftext.test.cct5.Farmer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Farmer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.test.cct5.impl.FarmerImpl#getDiet <em>Diet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FarmerImpl extends NamedElementImpl implements Farmer {
	/**
	 * The cached value of the '{@link #getDiet() <em>Diet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiet()
	 * @generated
	 * @ordered
	 */
	protected Diet diet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FarmerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cct5Package.Literals.FARMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diet getDiet() {
		return diet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiet(Diet newDiet, NotificationChain msgs) {
		Diet oldDiet = diet;
		diet = newDiet;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cct5Package.FARMER__DIET, oldDiet, newDiet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiet(Diet newDiet) {
		if (newDiet != diet) {
			NotificationChain msgs = null;
			if (diet != null)
				msgs = ((InternalEObject)diet).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cct5Package.FARMER__DIET, null, msgs);
			if (newDiet != null)
				msgs = ((InternalEObject)newDiet).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cct5Package.FARMER__DIET, null, msgs);
			msgs = basicSetDiet(newDiet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cct5Package.FARMER__DIET, newDiet, newDiet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cct5Package.FARMER__DIET:
				return basicSetDiet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Cct5Package.FARMER__DIET:
				return getDiet();
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
			case Cct5Package.FARMER__DIET:
				setDiet((Diet)newValue);
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
			case Cct5Package.FARMER__DIET:
				setDiet((Diet)null);
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
			case Cct5Package.FARMER__DIET:
				return diet != null;
		}
		return super.eIsSet(featureID);
	}

} //FarmerImpl
