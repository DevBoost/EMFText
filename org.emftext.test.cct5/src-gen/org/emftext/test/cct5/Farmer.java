/**
 */
package org.emftext.test.cct5;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Farmer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.test.cct5.Farmer#getDiet <em>Diet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.test.cct5.Cct5Package#getFarmer()
 * @model
 * @generated
 */
public interface Farmer extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Diet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diet</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diet</em>' containment reference.
	 * @see #setDiet(Diet)
	 * @see org.emftext.test.cct5.Cct5Package#getFarmer_Diet()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Diet getDiet();

	/**
	 * Sets the value of the '{@link org.emftext.test.cct5.Farmer#getDiet <em>Diet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diet</em>' containment reference.
	 * @see #getDiet()
	 * @generated
	 */
	void setDiet(Diet value);

} // Farmer
