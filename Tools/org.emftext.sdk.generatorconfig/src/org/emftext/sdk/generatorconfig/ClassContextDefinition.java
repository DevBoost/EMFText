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
package org.emftext.sdk.generatorconfig;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

import org.eclipse.emf.common.util.EList;

import org.emftext.sdk.concretesyntax.Definition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Context Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.emftext.sdk.generatorconfig.GeneratorconfigPackage#getClassContextDefinition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ClassContextDefinition extends ClassContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Definition> getDefinition(GenClass genClass);

} // ClassContextDefinition
