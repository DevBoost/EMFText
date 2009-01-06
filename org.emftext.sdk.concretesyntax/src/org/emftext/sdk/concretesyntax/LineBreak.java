/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Line Break</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.LineBreak#getTab <em>Tab</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getLineBreak()
 * @model
 * @generated
 */
public interface LineBreak extends Definition {
	/**
   * Returns the value of the '<em><b>Tab</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tab</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Tab</em>' attribute.
   * @see #setTab(int)
   * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getLineBreak_Tab()
   * @model
   * @generated
   */
	int getTab();

	/**
   * Sets the value of the '{@link org.emftext.sdk.concretesyntax.LineBreak#getTab <em>Tab</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tab</em>' attribute.
   * @see #getTab()
   * @generated
   */
	void setTab(int value);

} // LineBreak
