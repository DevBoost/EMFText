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
 * A representation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getDefinition()
 * @model abstract="true"
 * @generated
 */
public interface Definition extends SyntaxElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return true ; \r\n'"
	 * @generated
	 */
	boolean hasMinimalCardinalityOneOrHigher();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return false ; \r\n'"
	 * @generated
	 */
	boolean hasNoOptionalPart();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *  Returns a string representation of the cardinality of the
	 * ' or the
	 *  empty string.
	 *  
	 *  @param definition
	 *  @return
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.emftext.sdk.concretesyntax.Cardinality cardinality = null ; \r\nif ( this instanceof org.emftext.sdk.concretesyntax.CardinalityDefinition ) { \r\n\tcardinality = ( ( org.emftext.sdk.concretesyntax.CardinalityDefinition ) this ) .getCardinality ( ) ; \r\n} \r\nif ( cardinality == null ) { \r\n\treturn \"\" ; \r\n} else if ( cardinality instanceof org.emftext.sdk.concretesyntax.PLUS ) { \r\n\treturn \"+\" ; \r\n} else if ( cardinality instanceof org.emftext.sdk.concretesyntax.QUESTIONMARK ) { \r\n\treturn \"?\" ; \r\n} else { \r\n\treturn \"*\" ; \r\n} \r\n'"
	 * @generated
	 */
	String computeCardinalityString();
} // Definition
