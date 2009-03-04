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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * A LocationMap map EObjects to the position of their textual
 * representations. For each EObject the map can contain information
 * about the line, the column, the character position where the
 * object begins and the character position where the object ends.
 */
public interface ILocationMap {

	/**
	 * Used by parsers to set location information.
	 */
	public void setLine(EObject element, int line);

	/**
	 * Used by parsers to set location information.
	 */
	public int getLine(EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setColumn(EObject element, int column);
	
	/**
	 * Used by parsers to set location information.
	 */
	public int getColumn(EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setCharStart(EObject element, int charStart);
	
	/**
	 * Used by parsers to set location information.
	 */
	public int getCharStart(EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setCharEnd(EObject element, int charEnd);
	
	/**
	 * Used by parsers to set location information.
	 */
	public int getCharEnd(EObject element);

	/**
	 * Returns all EObjects that are located at the given 
	 * offset in the text document. The method can return
	 * multiple elements, because containers include their
	 * children in the textual representation.
	 * 
	 * @param documentOffset
	 * @return
	 */
	public List<EObject> getElementsAt(int documentOffset);
	
	/**
	 * Returns all EObjects that are located between the given 
	 * offsets in the text document. The method can return
	 * multiple elements.
	 * 
	 * @param startOffset
	 * @param endOffset
	 * @return
	 */
	public List<EObject> getElementsBetween(int startOffset, int endOffset);
}
