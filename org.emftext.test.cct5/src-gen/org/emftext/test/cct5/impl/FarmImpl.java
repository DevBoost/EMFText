/**
 */
package org.emftext.test.cct5.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.test.cct5.Animal;
import org.emftext.test.cct5.Cct5Package;
import org.emftext.test.cct5.Farm;
import org.emftext.test.cct5.Farmer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Farm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.test.cct5.impl.FarmImpl#getAnimal <em>Animal</em>}</li>
 *   <li>{@link org.emftext.test.cct5.impl.FarmImpl#getFarmer <em>Farmer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FarmImpl extends EObjectImpl implements Farm {
	/**
	 * The cached value of the '{@link #getAnimal() <em>Animal</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnimal()
	 * @generated
	 * @ordered
	 */
	protected EList<Animal> animal;

	/**
	 * The cached value of the '{@link #getFarmer() <em>Farmer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFarmer()
	 * @generated
	 * @ordered
	 */
	protected EList<Farmer> farmer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FarmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cct5Package.Literals.FARM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Animal> getAnimal() {
		if (animal == null) {
			animal = new EObjectContainmentEList<Animal>(Animal.class, this, Cct5Package.FARM__ANIMAL);
		}
		return animal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Farmer> getFarmer() {
		if (farmer == null) {
			farmer = new EObjectContainmentEList<Farmer>(Farmer.class, this, Cct5Package.FARM__FARMER);
		}
		return farmer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Cct5Package.FARM__ANIMAL:
				return ((InternalEList<?>)getAnimal()).basicRemove(otherEnd, msgs);
			case Cct5Package.FARM__FARMER:
				return ((InternalEList<?>)getFarmer()).basicRemove(otherEnd, msgs);
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
			case Cct5Package.FARM__ANIMAL:
				return getAnimal();
			case Cct5Package.FARM__FARMER:
				return getFarmer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Cct5Package.FARM__ANIMAL:
				getAnimal().clear();
				getAnimal().addAll((Collection<? extends Animal>)newValue);
				return;
			case Cct5Package.FARM__FARMER:
				getFarmer().clear();
				getFarmer().addAll((Collection<? extends Farmer>)newValue);
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
			case Cct5Package.FARM__ANIMAL:
				getAnimal().clear();
				return;
			case Cct5Package.FARM__FARMER:
				getFarmer().clear();
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
			case Cct5Package.FARM__ANIMAL:
				return animal != null && !animal.isEmpty();
			case Cct5Package.FARM__FARMER:
				return farmer != null && !farmer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FarmImpl
