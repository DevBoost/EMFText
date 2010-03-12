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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Class Cache</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.sdk.concretesyntax.GenClassCache#get_qualifiedInterfaceNameCache <em>qualified Interface Name Cache</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getGenClassCache()
 * @model
 * @generated
 */
public interface GenClassCache extends EObject {
	/**
	 * Returns the value of the '<em><b>qualified Interface Name Cache</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.codegen.ecore.genmodel.GenClass},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>qualified Interface Name Cache</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>qualified Interface Name Cache</em>' map.
	 * @see org.emftext.sdk.concretesyntax.ConcretesyntaxPackage#getGenClassCache__qualifiedInterfaceNameCache()
	 * @model mapType="org.emftext.sdk.concretesyntax.GenClassCacheEntry<org.eclipse.emf.codegen.ecore.genmodel.GenClass, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<GenClass, String> get_qualifiedInterfaceNameCache();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if ( ! get_qualifiedInterfaceNameCache ( ) .containsKey ( genClass ) ) { \r\n\tjava.lang.String qualifiedInterfaceName = genClass .getQualifiedInterfaceName ( ) ; \r\n\tget_qualifiedInterfaceNameCache ( ) .put ( genClass , qualifiedInterfaceName ) ; \r\n} \r\nreturn get_qualifiedInterfaceNameCache ( ) .get ( genClass ) ; \r\n'"
	 * @generated
	 */
	String getQualifiedInterfaceName(GenClass genClass);

} // GenClassCache
