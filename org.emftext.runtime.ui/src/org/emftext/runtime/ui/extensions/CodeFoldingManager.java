package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;

//TODO mseifert: align this class with the EMFText coding style
public class CodeFoldingManager {

	protected ArrayList<Annotation> oldAnnotations = new ArrayList<Annotation>();
	protected ArrayList<Annotation> deletions = new ArrayList<Annotation>();
	protected Map<Annotation, Position> additions = new HashMap<Annotation, Position>();

	protected ProjectionAnnotationModel pam;
	protected ISourceViewer viewer;

	public CodeFoldingManager(ProjectionAnnotationModel annotationModel, ISourceViewer sourceviewer) {
		pam = annotationModel;
		viewer = sourceviewer;
	}

	public void updateCodefolding(ArrayList<Position> positions) {
		IDocument doc = viewer.getDocument();
		// Add new Position with unique line offset
		for (Position p : positions) {
			if (!isInModel(p) && !isInAdditions(p))
				addPosition(p);
		}
		// Delete old Position with line count < 2.
		for (Annotation a : oldAnnotations) {
			Position pamPos = pam.getPosition(a);
			int lines = 0;
			try {
				lines = doc.getNumberOfLines(pamPos.offset, pamPos.length);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			if (lines < 2)
				deletions.add(a);
		}
		pam.modifyAnnotations(deletions.toArray(new Annotation[0]), additions, null);

		for (Annotation a : deletions)
			oldAnnotations.remove(a);
		deletions.clear();

		for (Annotation a : additions.keySet())
			oldAnnotations.add(a);
		additions.clear();
	}

	/**
	 * Just look after the offset.
	 * 
	 * @param p
	 * @return
	 */
	private boolean isInModel(Position p) {
		for (Annotation a : oldAnnotations)
			if (pam.getPosition(a).offset == p.offset)
				return true;
		return false;
	}

	/**
	 * Just look after the offset.
	 * 
	 * @param p
	 * @return
	 */
	private boolean isInAdditions(Position p) {
		for (Annotation a : additions.keySet())
			if (additions.get(a).offset == p.offset)
				return true;
		return false;
	}

	/**
	 * Try to add this Position to the model. If a Position existed on the same
	 * line, the longer one will be chosen. The Position will be exchanged if it
	 * is in the additions, when the to be deleted Annotation existed in
	 * deletions. Else, just exchange the Position in additions, if there is a
	 * shorter one. Should be tested in JUnit.
	 * 
	 * @param p
	 */
	private void addPosition(Position p) {
		IDocument doc = viewer.getDocument();
		int lines = 0;
		try {
			lines = doc.getNumberOfLines(p.offset, p.length);
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		if (lines < 2)
			return;
		for (Annotation a : oldAnnotations) {
			Position modelPos = pam.getPosition(a);
			try {
				if (doc.getLineOfOffset(p.offset) == doc.getLineOfOffset(modelPos.offset))
					if (modelPos.length >= p.length)
						return;
					else {
						for (Annotation aDel : deletions) {
							if (aDel.equals(a))
								for (Annotation aAdd : additions.keySet().toArray(new Annotation[0])) {
									Position addPos = additions.get(aAdd);
									if (doc.getLineOfOffset(p.offset) == doc.getLineOfOffset(addPos.offset))
										if (addPos.length < p.length) {
											additions.remove(aAdd);
											additions.put(new ProjectionAnnotation(), p);
											return;
										}
								}
						}
						for (Annotation aAdd : additions.keySet().toArray(new Annotation[0])) {
							Position addPos = additions.get(aAdd);
							if (doc.getLineOfOffset(p.offset) == doc.getLineOfOffset(addPos.offset))
								if (addPos.length < p.length) {
									additions.remove(aAdd);
									additions.put(new ProjectionAnnotation(), p);
									deletions.add(a);
									return;
								}
						}
					}
			} catch (BadLocationException e) {
				e.printStackTrace();
				return;
			}
		}
		additions.put(new ProjectionAnnotation(), p);
	}
}
