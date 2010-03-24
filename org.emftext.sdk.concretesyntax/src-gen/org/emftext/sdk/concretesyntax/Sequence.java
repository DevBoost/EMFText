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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='org.eclipse.emf.common.util.EList < org.emftext.sdk.concretesyntax.Definition > parts = new org.eclipse.emf.common.util.BasicEList < org.emftext.sdk.concretesyntax.Definition > ( ) ; \r\nfor ( org.emftext.sdk.concretesyntax.SyntaxElement child : getChildren ( ) ) { \r\n\tif ( child instanceof org.emftext.sdk.concretesyntax.Definition ) { \r\n\t\tparts .add ( ( org.emftext.sdk.concretesyntax.Definition ) child ) ; \r\n\t} else { \r\n\t\t// there should be no elements other than Definition elements in the\n// list of children\nassert false ; \r\n\t} \r\n} \r\nreturn parts ; \r\n'"
	 * @generated
	 */
	EList<Definition> getParts();

} // Sequence
