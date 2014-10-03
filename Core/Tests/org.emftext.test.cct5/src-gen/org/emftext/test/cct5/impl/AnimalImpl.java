/**
 */
package org.emftext.test.cct5.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.test.cct5.Animal;
import org.emftext.test.cct5.Cct5Package;
import org.emftext.test.cct5.Diet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.test.cct5.impl.AnimalImpl#getFeedingInstruction <em>Feeding Instruction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnimalImpl extends NamedElementImpl implements Animal {
	/**
	 * The cached value of the '{@link #getFeedingInstruction() <em>Feeding Instruction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedingInstruction()
	 * @generated
	 * @ordered
	 */
	protected Diet feedingInstruction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnimalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cct5Package.Literals.ANIMAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diet getFeedingInstruction() {
		return feedingInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeedingInstruction(Diet newFeedingInstruction, NotificationChain msgs) {
		Diet oldFeedingInstruction = feedingInstruction;
		feedingInstruction = newFeedingInstruction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Cct5Package.ANIMAL__FEEDING_INSTRUCTION, oldFeedingInstruction, newFeedingInstruction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeedingInstruction(Diet newFeedingInstruction) {
		if (newFeedingInstruction != feedingInstruction) {
			NotificationChain msgs = null;
			if (feedingInstruction != null)
				msgs = ((InternalEObject)feedingInstruction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Cct5Package.ANIMAL__FEEDING_INSTRUCTION, null, msgs);
			if (newFeedingInstruction != null)
				msgs = ((InternalEObject)newFeedingInstruction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Cct5Package.ANIMAL__FEEDING_INSTRUCTION, null, msgs);
			msgs = basicSetFeedingInstruction(newFeedingInstruction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cct5Package.ANIMAL__FEEDING_INSTRUCTION, newFeedingInstruction, newFeedingInstruction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cct5Package.ANIMAL__FEEDING_INSTRUCTION:
				return basicSetFeedingInstruction(null, msgs);
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
			case Cct5Package.ANIMAL__FEEDING_INSTRUCTION:
				return getFeedingInstruction();
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
			case Cct5Package.ANIMAL__FEEDING_INSTRUCTION:
				setFeedingInstruction((Diet)newValue);
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
			case Cct5Package.ANIMAL__FEEDING_INSTRUCTION:
				setFeedingInstruction((Diet)null);
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
			case Cct5Package.ANIMAL__FEEDING_INSTRUCTION:
				return feedingInstruction != null;
		}
		return super.eIsSet(featureID);
	}

} //AnimalImpl
