/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.reuseware.emftextedit.concretesyntax;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.reuseware.emftextedit.concretesyntax.Choice#getOptions <em>Options</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends EObject {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link org.reuseware.emftextedit.concretesyntax.Sequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getChoice_Options()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Sequence> getOptions();

} // Choice
