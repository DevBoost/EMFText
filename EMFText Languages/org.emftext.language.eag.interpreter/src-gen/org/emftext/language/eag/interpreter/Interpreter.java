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
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.language.eag.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.eag.Attribute;
import org.emftext.language.eag.AttributeGrammar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interpreter</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.emftext.language.eag.interpreter.InterpreterPackage#getInterpreter()
 * @model
 * @generated
 */
public interface Interpreter extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model objectRequired="true" grammarRequired="true" attributeRequired="true"
	 * @generated
	 */
	Object interpret(EObject object, AttributeGrammar grammar, Attribute attribute);

} // Interpreter
