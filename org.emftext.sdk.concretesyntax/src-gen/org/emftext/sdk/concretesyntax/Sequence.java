/**
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *  *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 *  
 * 
 */
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getSequence()
 * @model
 * @generated
 */
public interface Sequence extends SyntaxElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.eclipse.emf.common.util.EList< org.emftext.sdk.concretesyntax.Definition> parts = new  org.eclipse.emf.common.util.BasicEList< org.emftext.sdk.concretesyntax.Definition>();\r\n\r\n\t\tfor ( org.emftext.sdk.concretesyntax.SyntaxElement child : getChildren()) {\r\n\t\t\tif (child instanceof  org.emftext.sdk.concretesyntax.Definition) {\r\n\t\t\t\tparts.add(( org.emftext.sdk.concretesyntax.Definition) child);\r\n\t\t\t} else {\r\n\t\t\t\t// there should be no elements other than Definition elements in the\r\n\t\t\t\t// list of children\r\n\t\t\t\tassert false;\r\n\t\t\t}\r\n\t\t}\r\n\r\n\t\treturn parts;\r\n'"
	 * @generated
	 */
	EList<Definition> getParts();

} // Sequence
