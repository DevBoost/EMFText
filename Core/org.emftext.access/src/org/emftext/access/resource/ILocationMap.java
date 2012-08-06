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
package org.emftext.access.resource;

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
