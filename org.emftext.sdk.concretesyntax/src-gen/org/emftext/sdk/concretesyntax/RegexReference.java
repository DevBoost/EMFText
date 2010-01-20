/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regex Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.RegexReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexReference()
 * @model
 * @generated
 */
public interface RegexReference extends RegexPart {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(NormalToken)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexReference_Target()
	 * @model required="true"
	 * @generated
	 */
	NormalToken getTarget();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.RegexReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(NormalToken value);

} // RegexReference
