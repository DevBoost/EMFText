/**
 */
package org.emftext.test.cct5;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Animal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.test.cct5.Animal#getFeedingInstruction <em>Feeding Instruction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.test.cct5.Cct5Package#getAnimal()
 * @model
 * @generated
 */
public interface Animal extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Feeding Instruction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feeding Instruction</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feeding Instruction</em>' containment reference.
	 * @see #setFeedingInstruction(Diet)
	 * @see org.emftext.test.cct5.Cct5Package#getAnimal_FeedingInstruction()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Diet getFeedingInstruction();

	/**
	 * Sets the value of the '{@link org.emftext.test.cct5.Animal#getFeedingInstruction <em>Feeding Instruction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feeding Instruction</em>' containment reference.
	 * @see #getFeedingInstruction()
	 * @generated
	 */
	void setFeedingInstruction(Diet value);

} // Animal
