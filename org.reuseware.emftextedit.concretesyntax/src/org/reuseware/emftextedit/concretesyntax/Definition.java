/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.reuseware.emftextedit.concretesyntax;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.reuseware.emftextedit.concretesyntax.Definition#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getDefinition()
 * @model abstract="true"
 * @generated
 */
public interface Definition extends EObject {
	/**
	 * Returns the value of the '<em><b>Cardinality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cardinality</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cardinality</em>' containment reference.
	 * @see #setCardinality(Cardinality)
	 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getDefinition_Cardinality()
	 * @model containment="true"
	 * @generated
	 */
	Cardinality getCardinality();

	/**
	 * Sets the value of the '{@link org.reuseware.emftextedit.concretesyntax.Definition#getCardinality <em>Cardinality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cardinality</em>' containment reference.
	 * @see #getCardinality()
	 * @generated
	 */
	void setCardinality(Cardinality value);

} // Definition
