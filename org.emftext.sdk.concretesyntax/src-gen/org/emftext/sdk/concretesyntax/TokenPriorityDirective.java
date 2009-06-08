/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token Priority Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.TokenPriorityDirective#getToken <em>Token</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getTokenPriorityDirective()
 * @model
 * @generated
 */
public interface TokenPriorityDirective extends TokenDirective {
	/**
	 * Returns the value of the '<em><b>Token</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token</em>' reference.
	 * @see #setToken(TokenDefinition)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getTokenPriorityDirective_Token()
	 * @model required="true"
	 * @generated
	 */
	TokenDefinition getToken();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.TokenPriorityDirective#getToken <em>Token</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token</em>' reference.
	 * @see #getToken()
	 * @generated
	 */
	void setToken(TokenDefinition value);

} // TokenPriorityDirective
