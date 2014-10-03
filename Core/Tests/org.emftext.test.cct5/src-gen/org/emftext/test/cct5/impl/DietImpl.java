/**
 */
package org.emftext.test.cct5.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.test.cct5.Cct5Package;
import org.emftext.test.cct5.Diet;
import org.emftext.test.cct5.DietType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.test.cct5.impl.DietImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.emftext.test.cct5.impl.DietImpl#getFavoriteDish <em>Favorite Dish</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DietImpl extends EObjectImpl implements Diet {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final DietType TYPE_EDEFAULT = DietType.ALL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DietType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFavoriteDish() <em>Favorite Dish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFavoriteDish()
	 * @generated
	 * @ordered
	 */
	protected static final String FAVORITE_DISH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFavoriteDish() <em>Favorite Dish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFavoriteDish()
	 * @generated
	 * @ordered
	 */
	protected String favoriteDish = FAVORITE_DISH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DietImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Cct5Package.Literals.DIET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DietType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DietType newType) {
		DietType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cct5Package.DIET__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFavoriteDish() {
		return favoriteDish;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFavoriteDish(String newFavoriteDish) {
		String oldFavoriteDish = favoriteDish;
		favoriteDish = newFavoriteDish;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Cct5Package.DIET__FAVORITE_DISH, oldFavoriteDish, favoriteDish));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Cct5Package.DIET__TYPE:
				return getType();
			case Cct5Package.DIET__FAVORITE_DISH:
				return getFavoriteDish();
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
			case Cct5Package.DIET__TYPE:
				setType((DietType)newValue);
				return;
			case Cct5Package.DIET__FAVORITE_DISH:
				setFavoriteDish((String)newValue);
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
			case Cct5Package.DIET__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case Cct5Package.DIET__FAVORITE_DISH:
				setFavoriteDish(FAVORITE_DISH_EDEFAULT);
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
			case Cct5Package.DIET__TYPE:
				return type != TYPE_EDEFAULT;
			case Cct5Package.DIET__FAVORITE_DISH:
				return FAVORITE_DISH_EDEFAULT == null ? favoriteDish != null : !FAVORITE_DISH_EDEFAULT.equals(favoriteDish);
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
		result.append(" (Type: ");
		result.append(type);
		result.append(", FavoriteDish: ");
		result.append(favoriteDish);
		result.append(')');
		return result.toString();
	}

} //DietImpl
