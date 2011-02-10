/**
 * Copyright (c) 2006-2011 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany 
 *       - initial API and implementation
 * 
 *
 * $Id$
 */
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Import statements allow to reuse existing metamodels and syntax definitions.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Import#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Import#getConcreteSyntax <em>Concrete Syntax</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.Import#getCsLocationHint <em>Cs Location Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends GenPackageDependentElement {
	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A short prefix that is used to reference the imported elements.
	 * <!-- end-model-doc -->
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
	 * Returns the value of the '<em><b>Cs Location Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cs Location Hint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A URI where the concrete syntax definition to import is located.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cs Location Hint</em>' attribute.
	 * @see #setCsLocationHint(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getImport_CsLocationHint()
	 * @model
	 * @generated
	 */
	String getCsLocationHint();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.Import#getCsLocationHint <em>Cs Location Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cs Location Hint</em>' attribute.
	 * @see #getCsLocationHint()
	 * @generated
	 */
	void setCsLocationHint(String value);

} // Import
