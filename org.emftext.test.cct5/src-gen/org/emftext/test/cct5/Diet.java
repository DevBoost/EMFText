/**
 */
package org.emftext.test.cct5;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.test.cct5.Diet#getType <em>Type</em>}</li>
 *   <li>{@link org.emftext.test.cct5.Diet#getFavoriteDish <em>Favorite Dish</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.test.cct5.Cct5Package#getDiet()
 * @model
 * @generated
 */
public interface Diet extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.emftext.test.cct5.DietType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.emftext.test.cct5.DietType
	 * @see #setType(DietType)
	 * @see org.emftext.test.cct5.Cct5Package#getDiet_Type()
	 * @model required="true"
	 * @generated
	 */
	DietType getType();

	/**
	 * Sets the value of the '{@link org.emftext.test.cct5.Diet#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.emftext.test.cct5.DietType
	 * @see #getType()
	 * @generated
	 */
	void setType(DietType value);

	/**
	 * Returns the value of the '<em><b>Favorite Dish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Favorite Dish</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Favorite Dish</em>' attribute.
	 * @see #setFavoriteDish(String)
	 * @see org.emftext.test.cct5.Cct5Package#getDiet_FavoriteDish()
	 * @model
	 * @generated
	 */
	String getFavoriteDish();

	/**
	 * Sets the value of the '{@link org.emftext.test.cct5.Diet#getFavoriteDish <em>Favorite Dish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Favorite Dish</em>' attribute.
	 * @see #getFavoriteDish()
	 * @generated
	 */
	void setFavoriteDish(String value);

} // Diet
