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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return true;'"
	 * @generated
	 */
	boolean hasMinimalCardinalityOneOrHigher();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return false;'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='org.emftext.sdk.concretesyntax.Cardinality cardinality = org.emftext.sdk.concretesyntax.Cardinality.NONE;\nif (this instanceof org.emftext.sdk.concretesyntax.CardinalityDefinition) {\n\tcardinality = (( org.emftext.sdk.concretesyntax.CardinalityDefinition) this).getCardinality();\n}\nif (cardinality == org.emftext.sdk.concretesyntax.Cardinality.NONE) {\n\treturn \"\";\n} else if (cardinality == org.emftext.sdk.concretesyntax.Cardinality.PLUS) {\n\treturn \"+\";\n} else if (cardinality == org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK) {\n\treturn \"?\";\n} else {\n\treturn \"*\";\n}'"
	 * @generated
	 */
	String computeCardinalityString();

} // Definition
