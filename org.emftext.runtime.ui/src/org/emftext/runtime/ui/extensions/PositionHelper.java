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
package org.emftext.runtime.ui.extensions;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;

/**
 * A helper class to add, get or remove positions with a specific category in a document.
 * 
 * @see Position
 * @see IDocument
 * 
 * @author Tan-Ky Hoang-Kim
 */
@Deprecated
public class PositionHelper {

	/**
	 * Adds a position with the given offset and length into a document.
	 * 
	 * @param document the document to add a position into
	 * @param category the category of this position
	 * @param offset the offset of the position
	 * @param length the length of the position
	 * 
	 * @see Position
	 */
	public void addPosition(IDocument document, String category, int offset, int length) {
		try {
			document.addPositionCategory(category);
			Position position = new Position(offset, length);
			document.addPosition(category, position);
		} catch (BadLocationException e) {
			//e.printStackTrace();
		} catch (BadPositionCategoryException e) {
			//e.printStackTrace();
		}
	}

	/**
	 * Gets the positions of a specific category of the given document.
	 * @param document the document to get the positions from
	 * @param category the position's category
	 * @return an array of positions. If there is none return an array with the length = 0
	 */
	public Position[] getPositions(IDocument document, String category) {
		try {
			return document.getPositions(category);
		} catch (BadPositionCategoryException e) {
			//e.printStackTrace();
		}
		return new Position[0];
	}
	
	/**
	 * Gets the first position of a specific category of the given document.
	 * @param document the document to get the positions from
	 * @param category the category of the position
	 * @return a position. If there is none return <code>null</code>.
	 */
	public Position getFirstPosition(IDocument document, String category) {
		try {
			Position[] positions = document.getPositions(category);
			if (positions.length > 0) {
				return positions[0];
			}
		} catch (BadPositionCategoryException e) {
			//e.printStackTrace();
		}
		return null;
	}

	/**
	 * Deletes the position category from the document. 
	 * All positions in this category are thus deleted as well.
	 * 
	 * @param document the document contains the category 
	 * @param category the category to be removed
	 */
	public void removePositions(IDocument document, String category) {
		try {
			document.removePositionCategory(category);
		} catch (BadPositionCategoryException e) {
			//e.printStackTrace();
		}
	}
}
