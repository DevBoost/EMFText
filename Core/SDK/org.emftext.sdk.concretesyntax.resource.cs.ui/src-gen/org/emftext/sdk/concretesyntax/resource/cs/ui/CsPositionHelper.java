/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;

/**
 * A helper class to add, get or remove positions with a specific category in a
 * document.
 */
public class CsPositionHelper {
	
	/**
	 * Adds a position with the given offset and length into a document.
	 * 
	 * @param document the document to add a position into
	 * @param category the category of this position
	 * @param offset the offset of the position
	 * @param length the length of the position
	 */
	public void addPosition(IDocument document, String category, int offset, int length) {
		try {
			document.addPositionCategory(category);
			Position position = new Position(offset, length);
			document.addPosition(category, position);
		} catch (BadLocationException e) {
		} catch (BadPositionCategoryException e) {
		}
	}
	
	public Position createPosition(int offset, int length) {
		return new Position(offset, length);
	}
	
	/**
	 * Returns the positions of a specific category of the given document.
	 * 
	 * @param document the document to get the positions from
	 * @param category the position's category
	 * 
	 * @return an array of positions. If there is none return an array with the length
	 * = 0
	 */
	public Position[] getPositions(IDocument document, String category) {
		try {
			return document.getPositions(category);
		} catch (BadPositionCategoryException e) {
		}
		return new Position[0];
	}
	
	/**
	 * Returns the first position of a specific category of the given document.
	 * 
	 * @param document the document to get the positions from
	 * @param category the category of the position
	 * 
	 * @return a position. If there is none return <code>null</code>.
	 */
	public Position getFirstPosition(IDocument document, String category) {
		try {
			Position[] positions = document.getPositions(category);
			if (positions.length > 0) {
				return positions[0];
			}
		} catch (BadPositionCategoryException e) {
		}
		return null;
	}
	
	/**
	 * Deletes the position category from the document. All positions in this category
	 * are thus deleted as well.
	 * 
	 * @param document the document contains the category
	 * @param category the category to be removed
	 */
	public void removePositions(IDocument document, String category) {
		try {
			document.removePositionCategory(category);
		} catch (BadPositionCategoryException e) {
		}
	}
}
