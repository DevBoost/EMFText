/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Terminal#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getTerminal()
 * @model abstract="true"
 * @generated
 */
public interface Terminal extends CardinalityDefinition {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(GenFeature)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getTerminal_Feature()
	 * @model required="true"
	 * @generated
	 */
	GenFeature getFeature();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Terminal#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(GenFeature value);

} // Terminal
