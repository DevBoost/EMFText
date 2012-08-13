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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean isReferenced = !getAttributeReferences().isEmpty();\nboolean isCollectInToken = getAttributeName() != null;\nreturn !isReferenced || isCollectInToken;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean isReferenced = !getAttributeReferences().isEmpty();\nboolean isCollectInToken = getAttributeName() != null;\nreturn isReferenced || isCollectInToken;'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return !syntax.equals(getContainingSyntax(syntax));'"
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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.ecore.EObject container = this.eContainer();\nif (container instanceof org.emftext.sdk.concretesyntax.ConcreteSyntax) {\n\treturn ( org.emftext.sdk.concretesyntax.ConcreteSyntax) container;\n}\nreturn syntax;'"
	 * @generated
	 */
	ConcreteSyntax getContainingSyntax(ConcreteSyntax syntax);

} // CompleteTokenDefinition
