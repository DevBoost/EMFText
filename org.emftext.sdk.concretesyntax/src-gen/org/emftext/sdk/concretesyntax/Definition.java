/*******************************************************************************
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
 ******************************************************************************/
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\treturn true;\r\n'"
	 * @generated
	 */
	boolean hasMinimalCardinalityOneOrHigher();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\treturn false;\r\n'"
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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='\r\n\t\t org.emftext.sdk.concretesyntax.Cardinality cardinality =  org.emftext.sdk.concretesyntax.Cardinality.NONE;\r\n\r\n\t\tif (this instanceof  org.emftext.sdk.concretesyntax.CardinalityDefinition) {\r\n\t\t\tcardinality = (( org.emftext.sdk.concretesyntax.CardinalityDefinition) this).getCardinality();\r\n\t\t}\r\n\r\n\t\tif (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.NONE) {\r\n\t\t\treturn \"\";\r\n\t\t} else if (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.PLUS) {\r\n\t\t\treturn \"+\";\r\n\t\t} else if (cardinality ==  org.emftext.sdk.concretesyntax.Cardinality.QUESTIONMARK) {\r\n\t\t\treturn \"?\";\r\n\t\t} else {\r\n\t\t\treturn \"*\";\r\n\t\t}\r\n'"
	 * @generated
	 */
	String computeCardinalityString();

} // Definition
