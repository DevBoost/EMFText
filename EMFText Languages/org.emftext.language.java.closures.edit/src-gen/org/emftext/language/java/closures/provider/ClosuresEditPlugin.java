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
package org.emftext.language.java.closures.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.emftext.language.java.annotations.provider.JavaEditPlugin;

/**
 * This is the central singleton for the Closures edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class ClosuresEditPlugin extends EMFPlugin {
	/**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static final ClosuresEditPlugin INSTANCE = new ClosuresEditPlugin();

	/**
   * Keep track of the singleton.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static Implementation plugin;

	/**
   * Create the instance.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ClosuresEditPlugin() {
    super
      (new ResourceLocator [] 
       {
         JavaEditPlugin.INSTANCE,
       });
  }

	/**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
	@Override
	public ResourceLocator getPluginResourceLocator() {
    return plugin;
  }

	/**
   * Returns the singleton instance of the Eclipse plugin.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the singleton instance.
   * @generated
   */
	public static Implementation getPlugin() {
    return plugin;
  }

	/**
   * The actual implementation of the Eclipse <b>Plugin</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static class Implementation extends EclipsePlugin {
		/**
     * Creates an instance.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		public Implementation() {
      super();

      // Remember the static instance.
      //
      plugin = this;
    }
	}

}
