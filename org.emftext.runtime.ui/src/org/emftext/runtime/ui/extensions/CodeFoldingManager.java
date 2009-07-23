package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;

//TODO hoang-kim add documentation
public class CodeFoldingManager {

	protected List<Annotation> oldAnnotations = new ArrayList<Annotation>();
	protected List<Annotation> deletions = new ArrayList<Annotation>();
	protected Map<Annotation, Position> additions = new HashMap<Annotation, Position>();

	protected ProjectionAnnotationModel projectionAnnotationModel;
	protected ISourceViewer sourceViewer;

	public CodeFoldingManager(ProjectionAnnotationModel projectionAnnotationModel, ISourceViewer sourceViewer) {
		this.projectionAnnotationModel = projectionAnnotationModel;
		this.sourceViewer = sourceViewer;
	}

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
			Position modelPosition = projectionAnnotationModel.getPosition(oldAnnotation);
			int lines = 0;
			try {
				lines = document.getNumberOfLines(modelPosition.offset, modelPosition.length);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			if (lines < 2) {
				deletions.add(oldAnnotation);
			}
		}
		projectionAnnotationModel.modifyAnnotations(deletions.toArray(new Annotation[0]), additions, null);

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
	 * Just look after the offset.
	 * 
	 * @param position
	 * @return
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
	 * Just look after the offset.
	 * 
	 * @param position
	 * @return
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
	 * Try to add this Position to the model. If a Position exists on the same
	 * line, the longer one will be chosen. The Position will be exchanged if it
	 * is in the additions, when the to be deleted Annotation existed in
	 * deletions. Else, just exchange the Position in additions, if there is a
	 * shorter one. 
	 * 
	 * TODO hoang-kim test with JUnit
	 * 
	 * @param position
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
			Position modelPosition = projectionAnnotationModel.getPosition(oldAnnotation);
			try {
				if (document.getLineOfOffset(position.offset) == document.getLineOfOffset(modelPosition.offset)) {
					if (modelPosition.length >= position.length) {
						return;
					} else {
						for (Annotation annotationToDelete : deletions) {
							if (annotationToDelete.equals(oldAnnotation)) {
								for (Annotation annotationToAdd : additions.keySet().toArray(new Annotation[0])) {
									Position addPosition = additions.get(annotationToAdd);
									if (document.getLineOfOffset(position.offset) == document.getLineOfOffset(addPosition.offset)) {
										if (addPosition.length < position.length) {
											additions.remove(annotationToAdd);
											additions.put(new ProjectionAnnotation(), position);
											return;
										}
									}
								}
							}
						}
						for (Annotation annotationToAdd : additions.keySet().toArray(new Annotation[0])) {
							Position addPosition = additions.get(annotationToAdd);
							if (document.getLineOfOffset(position.offset) == document.getLineOfOffset(addPosition.offset)) {
								if (addPosition.length < position.length) {
									additions.remove(annotationToAdd);
									additions.put(new ProjectionAnnotation(), position);
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
