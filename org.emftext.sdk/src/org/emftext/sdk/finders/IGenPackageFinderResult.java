/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.finders;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * Implementations of this interface are instantiated by implementations of
 * {@link IGenPackageFinder}. The main purpose of this interface is to
 * encapsulate a {@link GenPackage}.
 */
public interface IGenPackageFinderResult {

	/**
	 * @return The encapsulated {@link GenPackage}.
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
