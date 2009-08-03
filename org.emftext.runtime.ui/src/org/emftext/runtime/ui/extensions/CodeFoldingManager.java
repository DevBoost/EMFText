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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;

/**
 * 
 * This manager adds new ProjectionAnnotation for the code folding and deletes
 * old ProjectionAnnotation with lines < 2. It is needed to hold the toggle
 * states.
 * 
 * @author Hoang-Kim, Tan-Ky
 */
public class CodeFoldingManager {

	protected List<Annotation> oldAnnotations = new ArrayList<Annotation>();
	protected List<Annotation> deletions = new ArrayList<Annotation>();
	protected Map<Annotation, Position> additions = new HashMap<Annotation, Position>();

	protected ProjectionAnnotationModel projectionAnnotationModel;
	protected ProjectionViewer sourceViewer;

	/**
	 * Creates a code folding manager to handle the
	 * <code>ProjectionAnnotation</code>.
	 * 
	 * @param sourceViewer
	 *            the source viewer to calculate the element lines
	 */
	public CodeFoldingManager(ProjectionViewer sourceViewer) {
		this.projectionAnnotationModel = sourceViewer
				.getProjectionAnnotationModel();
		this.sourceViewer = sourceViewer;
	}

	/**
	 * Checks whether it is in the <code>ProjectionAnnotationModel</code> or in
	 * the addition set. If not it tries to add into <code>additions</code>.
	 * Deletes old ProjectionAnnotation with line count < 2.
	 * 
	 * @param positions
	 *            a list of available foldable positions
	 */
	public void updateCodefolding(List<Position> positions) {
		IDocument document = sourceViewer.getDocument();
		// Add new Position with a unique line offset
		for (Position position : positions) {
			if (!isInModel(position) && !isInAdditions(position)) {
				addPosition(position);
			}
		}
		// Delete old Position with line count < 2.
		for (Annotation oldAnnotation : oldAnnotations) {
			Position modelPosition = projectionAnnotationModel
					.getPosition(oldAnnotation);
			int lines = 0;
			try {
				lines = document.getNumberOfLines(modelPosition.offset,
						modelPosition.length);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			if (lines < 2) {
				deletions.add(oldAnnotation);
			}
		}
		projectionAnnotationModel.modifyAnnotations(deletions
				.toArray(new Annotation[0]), additions, null);

		for (Annotation annotationToDelete : deletions) {
			oldAnnotations.remove(annotationToDelete);
		}
		deletions.clear();

		for (Annotation newAnnotation : additions.keySet()) {
			oldAnnotations.add(newAnnotation);
		}
		additions.clear();
	}

	/**
	 * Checks the offset of this <code>Position</code> with the
	 * <code>Position</code>s in the <code>ProjectionAnnotationModel</code> to
	 * determine the existence.
	 * 
	 * @param position
	 *            the position to check
	 * @return <code>true</code> if it is in the
	 *         <code>ProjectionAnnotationModel</code>
	 */
	private boolean isInModel(Position position) {
		for (Annotation oldAnnotation : oldAnnotations) {
			if (projectionAnnotationModel.getPosition(oldAnnotation).offset == position.offset) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks the offset of this <code>Position</code> with the
	 * <code>Position</code>s in <code>additions</code> to determine the
	 * existence.
	 * 
	 * @param position
	 *            the position to check
	 * @return <code>true</code> if it is in the <code>additions</code>
	 */
	private boolean isInAdditions(Position position) {
		for (Annotation addition : additions.keySet()) {
			if (additions.get(addition).offset == position.offset) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Tries to add this position into the model. If more positions exist on the
	 * same line, the longer one will be chosen. The position will be exchanged
	 * if it is in the additions, when the to be deleted <code>Annotation</code>
	 * existed in deletions. Else, just exchange the Position in additions, if
	 * there is a shorter one.
	 * 
	 * TODO hoang-kim test with JUnit
	 * 
	 * @param position
	 *            the position to be added.
	 */
	private void addPosition(Position position) {
		IDocument document = sourceViewer.getDocument();
		int lines = 0;
		try {
			lines = document.getNumberOfLines(position.offset, position.length);
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		if (lines < 2) {
			return;
		}

		for (Annotation oldAnnotation : oldAnnotations) {
			Position modelPosition = projectionAnnotationModel
					.getPosition(oldAnnotation);
			try {
				if (document.getLineOfOffset(position.offset) == document
						.getLineOfOffset(modelPosition.offset)) {
					if (modelPosition.length >= position.length) {
						return;
					} else {
						for (Annotation annotationToDelete : deletions) {
							if (annotationToDelete.equals(oldAnnotation)) {
								for (Annotation annotationToAdd : additions
										.keySet().toArray(new Annotation[0])) {
									Position addPosition = additions
											.get(annotationToAdd);
									if (document
											.getLineOfOffset(position.offset) == document
											.getLineOfOffset(addPosition.offset)) {
										if (addPosition.length < position.length) {
											additions.remove(annotationToAdd);
											additions.put(
													new ProjectionAnnotation(),
													position);
											return;
										}
									}
								}
							}
						}
						for (Annotation annotationToAdd : additions.keySet()
								.toArray(new Annotation[0])) {
							Position addPosition = additions
									.get(annotationToAdd);
							if (document.getLineOfOffset(position.offset) == document
									.getLineOfOffset(addPosition.offset)) {
								if (addPosition.length < position.length) {
									additions.remove(annotationToAdd);
									additions.put(new ProjectionAnnotation(),
											position);
									deletions.add(oldAnnotation);
									return;
								}
							}
						}
					}
				}
			} catch (BadLocationException e) {
				e.printStackTrace();
				return;
			}
		}
		additions.put(new ProjectionAnnotation(), position);
	}
}
