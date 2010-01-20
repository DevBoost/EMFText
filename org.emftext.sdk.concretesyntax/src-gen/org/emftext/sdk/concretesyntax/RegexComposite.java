/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regex Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.RegexComposite#getRegexParts <em>Regex Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexComposite()
 * @model abstract="true"
 * @generated
 */
public interface RegexComposite extends RegexOwner {
	/**
	 * Returns the value of the '<em><b>Regex Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.RegexPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regex Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regex Parts</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getRegexComposite_RegexParts()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<RegexPart> getRegexParts();

} // RegexComposite
