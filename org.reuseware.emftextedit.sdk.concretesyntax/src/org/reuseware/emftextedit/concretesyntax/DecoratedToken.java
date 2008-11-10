/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.reuseware.emftextedit.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decorated Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.reuseware.emftextedit.concretesyntax.DecoratedToken#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.reuseware.emftextedit.concretesyntax.DecoratedToken#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getDecoratedToken()
 * @model
 * @generated
 */
public interface DecoratedToken extends NewDefinedToken {
	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getDecoratedToken_Prefix()
	 * @model required="true"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.reuseware.emftextedit.concretesyntax.DecoratedToken#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffix</em>' attribute.
	 * @see #setSuffix(String)
	 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getDecoratedToken_Suffix()
	 * @model required="true"
	 * @generated
	 */
	String getSuffix();

	/**
	 * Sets the value of the '{@link org.reuseware.emftextedit.concretesyntax.DecoratedToken#getSuffix <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' attribute.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix(String value);

} // DecoratedToken
