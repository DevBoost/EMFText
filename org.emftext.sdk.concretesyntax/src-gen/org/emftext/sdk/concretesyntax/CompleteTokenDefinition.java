/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 *  
 */
package org.emftext.sdk.concretesyntax;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complete Token Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeName <em>Attribute Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompleteTokenDefinition()
 * @model abstract="true"
 * @generated
 */
public interface CompleteTokenDefinition extends TokenDirective, RegexOwner, ReferencableTokenDefinition {
	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getCompleteTokenDefinition_AttributeName()
	 * @model
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link org.emftext.sdk.concretesyntax.CompleteTokenDefinition#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tboolean isReferenced = !getAttributeReferences().isEmpty();\r\n\r\n\t\tboolean isCollectInToken = getAttributeName() != null;\r\n\r\n\t\treturn !isReferenced || isCollectInToken;\r\n'"
	 * @generated
	 */
	boolean isHidden();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\tboolean isReferenced = !getAttributeReferences().isEmpty();\r\n\r\n\t\tboolean isCollectInToken = getAttributeName() != null;\r\n\r\n\t\treturn isReferenced || isCollectInToken;\r\n'"
	 * @generated
	 */
	boolean isUsed();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model syntaxRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\treturn !syntax.equals(getContainingSyntax(syntax));\r\n'"
	 * @generated
	 */
	boolean isImported(ConcreteSyntax syntax);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model syntaxRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.ecore.EObject container = this.eContainer();\r\n\r\n\t\tif (container instanceof  org.emftext.sdk.concretesyntax.ConcreteSyntax) {\r\n\t\t\treturn ( org.emftext.sdk.concretesyntax.ConcreteSyntax) container;\r\n\t\t}\r\n\r\n\t\treturn syntax;\r\n'"
	 * @generated
	 */
	ConcreteSyntax getContainingSyntax(ConcreteSyntax syntax);

} // CompleteTokenDefinition
