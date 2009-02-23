/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.CompoundDefinition#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompoundDefinition()
 * @model
 * @generated
 */
public interface CompoundDefinition extends CardinalityDefinition {
	/**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference.
   * @see #setDefinitions(Choice)
   * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompoundDefinition_Definitions()
   * @model containment="true"
   * @generated
   */
	Choice getDefinitions();

	/**
   * Sets the value of the '{@link org.emftext.sdk.concretesyntax.CompoundDefinition#getDefinitions <em>Definitions</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definitions</em>' containment reference.
   * @see #getDefinitions()
   * @generated
   */
	void setDefinitions(Choice value);

} // CompoundDefinition
