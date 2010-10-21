/**
 * Copyright (c) 2006-2010 
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
 * A representation of the model object '<em><b>Placeholder In Quotes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getSuffix <em>Suffix</em>}</li>
 *   <li>{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getEscapeCharacter <em>Escape Character</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholderInQuotes()
 * @model
 * @generated
 */
public interface PlaceholderInQuotes extends Placeholder {
	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholderInQuotes_Prefix()
	 * @model default="" required="true"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Suffix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suffix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suffix</em>' attribute.
	 * @see #setSuffix(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholderInQuotes_Suffix()
	 * @model default="" required="true"
	 * @generated
	 */
	String getSuffix();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getSuffix <em>Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suffix</em>' attribute.
	 * @see #getSuffix()
	 * @generated
	 */
	void setSuffix(String value);

	/**
	 * Returns the value of the '<em><b>Escape Character</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Escape Character</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Escape Character</em>' attribute.
	 * @see #setEscapeCharacter(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getPlaceholderInQuotes_EscapeCharacter()
	 * @model
	 * @generated
	 */
	String getEscapeCharacter();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.PlaceholderInQuotes#getEscapeCharacter <em>Escape Character</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escape Character</em>' attribute.
	 * @see #getEscapeCharacter()
	 * @generated
	 */
	void setEscapeCharacter(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t java.lang.String prefix = getPrefix();\r\n\r\n\t\tif (prefix == null) return prefix;\r\n\r\n\t\tif (prefix.length() == 0) return null;\r\n\r\n\t\treturn prefix;\r\n'"
	 * @generated
	 */
	String getNormalizedPrefix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t java.lang.String suffix = getSuffix();\r\n\r\n\t\tif (suffix == null) return suffix;\r\n\r\n\t\tif (suffix.length() == 0) return null;\r\n\r\n\t\treturn suffix;\r\n'"
	 * @generated
	 */
	String getNormalizedSuffix();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t java.lang.String escapeCharacter = getEscapeCharacter();\r\n\r\n\t\tif (escapeCharacter == null) return escapeCharacter;\r\n\r\n\t\tif (escapeCharacter.length() == 0) return null;\r\n\r\n\t\treturn escapeCharacter;\r\n'"
	 * @generated
	 */
	String getNormalizedEscapeCharacter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tif (eIsProxy()) return super.toString();\r\n\r\n\r\n\t\t java.lang.StringBuffer result = new  java.lang.StringBuffer();\r\n\r\n\t\t org.eclipse.emf.codegen.ecore.genmodel.GenFeature feature = getFeature();\r\n\r\n\t\tif (feature != null && feature.getEcoreFeature() != null) {\r\n\t\t\tresult.append(feature.getName());\r\n\t\t}\r\n\r\n\t\tresult.append(\"[\'\");\r\n\r\n\t\tresult.append(getPrefix());\r\n\r\n\t\tresult.append(\"\', \'\");\r\n\r\n\t\tresult.append(getSuffix());\r\n\r\n\t\tresult.append(\"\']\");\r\n\r\n\t\treturn result.toString();\r\n'"
	 * @generated
	 */
	String toString();

} // PlaceholderInQuotes
