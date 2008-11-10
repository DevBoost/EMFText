/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.reuseware.emftextedit.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Defined Placeholder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder#getToken <em>Token</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getDefinedPlaceholder()
 * @model
 * @generated
 */
public interface DefinedPlaceholder extends Placeholder {
	/**
	 * Returns the value of the '<em><b>Token</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.reuseware.emftextedit.concretesyntax.TokenDefinition#getAttributeReferences <em>Attribute References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token</em>' reference.
	 * @see #setToken(TokenDefinition)
	 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getDefinedPlaceholder_Token()
	 * @see org.reuseware.emftextedit.concretesyntax.TokenDefinition#getAttributeReferences
	 * @model opposite="attributeReferences" required="true"
	 * @generated
	 */
	TokenDefinition getToken();

	/**
	 * Sets the value of the '{@link org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder#getToken <em>Token</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token</em>' reference.
	 * @see #getToken()
	 * @generated
	 */
	void setToken(TokenDefinition value);

} // DefinedPlaceholder
