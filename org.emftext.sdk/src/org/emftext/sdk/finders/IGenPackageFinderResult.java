/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.finders;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * Implementations of this interface are instantiated by implementations of
 * {@link IGenPackageFinder}. The main purpose of this interface is to
 * encapsulate a set of {@link GenPackage}s.
 */
public interface IGenPackageFinderResult {

	/**
	 * @return The encapsulated {@link GenPackage}s.
	 */
	public GenPackage getResult();

	/**
	 * This method is used by the meta model cache to determine
	 * whether the content a generator package has changed since
	 * the last time is was loaded. If this method returns true,
	 * the result is thrown away and the model is loaded again.
	 * 
	 * @return
	 */
	public boolean hasChanged();
}
