/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Import#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Import#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Import#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends EObject {
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
   * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getImport_Prefix()
   * @model required="true"
   * @generated
   */
	String getPrefix();

	/**
   * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Import#getPrefix <em>Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix</em>' attribute.
   * @see #getPrefix()
   * @generated
   */
	void setPrefix(String value);

	/**
   * Returns the value of the '<em><b>Concrete Syntax</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Syntax</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Concrete Syntax</em>' reference.
   * @see #setConcreteSyntax(ConcreteSyntax)
   * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getImport_ConcreteSyntax()
   * @model
   * @generated
   */
	ConcreteSyntax getConcreteSyntax();

	/**
   * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Import#getConcreteSyntax <em>Concrete Syntax</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Concrete Syntax</em>' reference.
   * @see #getConcreteSyntax()
   * @generated
   */
	void setConcreteSyntax(ConcreteSyntax value);

	/**
   * Returns the value of the '<em><b>Package</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Package</em>' reference.
   * @see #setPackage(GenPackage)
   * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getImport_Package()
   * @model required="true"
   * @generated
   */
	GenPackage getPackage();

	/**
   * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Import#getPackage <em>Package</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Package</em>' reference.
   * @see #getPackage()
   * @generated
   */
	void setPackage(GenPackage value);

} // Import
