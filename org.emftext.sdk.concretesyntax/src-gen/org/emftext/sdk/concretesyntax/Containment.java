/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Containment#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getContainment()
 * @model
 * @generated
 */
public interface Containment extends Terminal {

	/**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(GenClass)
   * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getContainment_Type()
   * @model
   * @generated
   */
	GenClass getType();

	/**
   * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Containment#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
	void setType(GenClass value);
} // Containment
