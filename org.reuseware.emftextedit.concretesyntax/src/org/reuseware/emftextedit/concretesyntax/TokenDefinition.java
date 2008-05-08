/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.reuseware.emftextedit.concretesyntax;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.reuseware.emftextedit.concretesyntax.TokenDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.reuseware.emftextedit.concretesyntax.TokenDefinition#getAttributeReferences <em>Attribute References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getTokenDefinition()
 * @model abstract="true"
 * @generated
 */
public interface TokenDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getTokenDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.reuseware.emftextedit.concretesyntax.TokenDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Attribute References</b></em>' reference list.
	 * The list contents are of type {@link org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder}.
	 * It is bidirectional and its opposite is '{@link org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder#getToken <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute References</em>' reference list.
	 * @see org.reuseware.emftextedit.concretesyntax.ConcretesyntaxPackage#getTokenDefinition_AttributeReferences()
	 * @see org.reuseware.emftextedit.concretesyntax.DefinedPlaceholder#getToken
	 * @model opposite="token"
	 * @generated
	 */
	EList<DefinedPlaceholder> getAttributeReferences();

} // TokenDefinition
