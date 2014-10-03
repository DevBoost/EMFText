/**
 */
package org.emftext.test.cct5;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Farm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.test.cct5.Farm#getAnimal <em>Animal</em>}</li>
 *   <li>{@link org.emftext.test.cct5.Farm#getFarmer <em>Farmer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.test.cct5.Cct5Package#getFarm()
 * @model
 * @generated
 */
public interface Farm extends EObject {
	/**
	 * Returns the value of the '<em><b>Animal</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.test.cct5.Animal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Animal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Animal</em>' containment reference list.
	 * @see org.emftext.test.cct5.Cct5Package#getFarm_Animal()
	 * @model containment="true"
	 * @generated
	 */
	EList<Animal> getAnimal();

	/**
	 * Returns the value of the '<em><b>Farmer</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.test.cct5.Farmer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Farmer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Farmer</em>' containment reference list.
	 * @see org.emftext.test.cct5.Cct5Package#getFarm_Farmer()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Farmer> getFarmer();

} // Farm
