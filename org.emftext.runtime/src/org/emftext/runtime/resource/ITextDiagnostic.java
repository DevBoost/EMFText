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
package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended diagnostic that gives access to the exact position of the problem
 * in a character stream.
 */
public interface ITextDiagnostic extends Resource.Diagnostic {
	
	/**
	 * @return Position of the first character of the problem area.
	 */
	public int getCharStart();
	
	/**
	 * @return Position of the last character of the problem area.
	 */
	public int getCharEnd();

	/**
	 * @return The column of the problem area.
	 */
	public int getColumn();

	/**
	 * @return The line that contains the problem area.
	 */
	public int getLine();
	
	/**
	 * Checks whether the problem was caused by the given element.
	 */
	public boolean wasCausedBy(EObject element);
}
