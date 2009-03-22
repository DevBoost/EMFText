/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.TokenStyle#getTokenName <em>Token Name</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.TokenStyle#getRgb <em>Rgb</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.TokenStyle#getFontStyles <em>Font Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getTokenStyle()
 * @model
 * @generated
 */
public interface TokenStyle extends EObject {
	/**
	 * Returns the value of the '<em><b>Token Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Token Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Name</em>' attribute.
	 * @see #setTokenName(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getTokenStyle_TokenName()
	 * @model
	 * @generated
	 */
	String getTokenName();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.TokenStyle#getTokenName <em>Token Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Name</em>' attribute.
	 * @see #getTokenName()
	 * @generated
	 */
	void setTokenName(String value);

	/**
	 * Returns the value of the '<em><b>Rgb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rgb</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rgb</em>' attribute.
	 * @see #setRgb(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getTokenStyle_Rgb()
	 * @model
	 * @generated
	 */
	String getRgb();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.TokenStyle#getRgb <em>Rgb</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rgb</em>' attribute.
	 * @see #getRgb()
	 * @generated
	 */
	void setRgb(String value);

	/**
	 * Returns the value of the '<em><b>Font Styles</b></em>' attribute list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.FontStyle}.
	 * The literals are from the enumeration {@link org.emftext.sdk.concretesyntax.FontStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Font Styles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Font Styles</em>' attribute list.
	 * @see org.emftext.sdk.concretesyntax.FontStyle
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getTokenStyle_FontStyles()
	 * @model
	 * @generated
	 */
	EList<FontStyle> getFontStyles();

} // TokenStyle
