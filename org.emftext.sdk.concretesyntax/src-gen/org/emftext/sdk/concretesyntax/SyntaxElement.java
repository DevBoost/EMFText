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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Syntax Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.SyntaxElement#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getSyntaxElement()
 * @model abstract="true"
 * @generated
 */
public interface SyntaxElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.emftext.sdk.concretesyntax.SyntaxElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getSyntaxElement_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<SyntaxElement> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.emftext.sdk.concretesyntax.Rule rule = null;\r\n\r\n\t\t org.eclipse.emf.ecore.EObject o = this;\r\n\r\n\t\tdo {\r\n\t\t\tif (o instanceof  org.emftext.sdk.concretesyntax.Rule) {\r\n\t\t\t\trule = ( org.emftext.sdk.concretesyntax.Rule) o;\r\n\t\t\t}\r\n\t\t\telse {\r\n\t\t\t\to = o.eContainer();\r\n\t\t\t}\r\n\t\t} while (rule == null && o != null);\r\n\r\n\t\treturn rule;\r\n'"
	 * @generated
	 */
	Rule getContainingRule();

} // SyntaxElement
