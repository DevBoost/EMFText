/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.reuseware.emftextedit.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.reuseware.emftextedit.concretesyntax.CompoundDefinition#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getCompoundDefinition()
 * @model
 * @generated
 */
public interface CompoundDefinition extends Definition {
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
	 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getCompoundDefinition_Definitions()
	 * @model containment="true"
	 * @generated
	 */
	Choice getDefinitions();

	/**
	 * Sets the value of the '{@link org.reuseware.emftextedit.concretesyntax.CompoundDefinition#getDefinitions <em>Definitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definitions</em>' containment reference.
	 * @see #getDefinitions()
	 * @generated
	 */
	void setDefinitions(Choice value);

} // CompoundDefinition
