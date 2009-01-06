/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>White Spaces</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.WhiteSpaces#getAmount <em>Amount</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getWhiteSpaces()
 * @model
 * @generated
 */
public interface WhiteSpaces extends Definition {
	/**
   * Returns the value of the '<em><b>Amount</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Amount</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Amount</em>' attribute.
   * @see #setAmount(int)
   * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getWhiteSpaces_Amount()
   * @model
   * @generated
   */
	int getAmount();

	/**
   * Sets the value of the '{@link org.emftext.sdk.concretesyntax.WhiteSpaces#getAmount <em>Amount</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Amount</em>' attribute.
   * @see #getAmount()
   * @generated
   */
	void setAmount(int value);

} // WhiteSpaces
