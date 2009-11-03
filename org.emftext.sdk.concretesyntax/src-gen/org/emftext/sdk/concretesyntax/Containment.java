/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.Containment#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getContainment()
 * @model
 * @generated
 */
public interface Containment extends Terminal {

	/**
	 * Returns the value of the '<em><b>Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenClass}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' reference list.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getContainment_Types()
	 * @model
	 * @generated
	 */
  EList<GenClass> getTypes();
} // Containment
