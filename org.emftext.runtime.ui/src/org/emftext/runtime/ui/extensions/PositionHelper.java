package org.emftext.runtime.ui.extensions;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;

public class PositionHelper {

	public void addPosition(IDocument document, String category, int offset, int length) {
		try {
			Position position = new Position(offset, length);
			document.addPosition(category, position);
		} catch (BadLocationException e) {
			//e.printStackTrace();
		} catch (BadPositionCategoryException e) {
			//e.printStackTrace();
		}
	}

	public Position[] getPositions(IDocument document, String category) {
		try {
			return document.getPositions(category);
		} catch (BadPositionCategoryException e) {
			//e.printStackTrace();
		}
		return new Position[0];
	}

	public void removePositions(IDocument document, String category) {
		try {
			document.removePositionCategory(category);
		} catch (BadPositionCategoryException e) {
			//e.printStackTrace();
		}
	}
}
