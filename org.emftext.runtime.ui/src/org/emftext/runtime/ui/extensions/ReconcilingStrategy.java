package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.swt.widgets.Display;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.editor.EMFTextEditor;

//TODO hoang-kim add documentation
public class ReconcilingStrategy implements IReconcilingStrategy,
		IReconcilingStrategyExtension {

	private IDocument document;
	private EMFTextEditor editor;

	private ITextResource textResource;

	/** holds the calculated positions */
	protected final List<Position> positions = new ArrayList<Position>();

	public void reconcile(IRegion partition) {
		initialReconcile();
	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		initialReconcile();
	}

	public void setDocument(IDocument document) {
		this.document = document;
	}

	public EMFTextEditor getEditor() {
		return editor;
	}

	public void setEditor(EMFTextEditor editor) {
		this.editor = editor;
	}

	public void initialReconcile() {
		// TODO Because of the inconsistency between ITextResource and dirty
		// editor, this Strategy can't work.
		// We need an ITextResource with ILocationMap of this "dirty"
		// ITextResource.
		// TODO remove this once the background parsing is activated
		if (editor.isDirty()) {
			return;
		}
		positions.clear();
		if (textResource == null) {
			textResource = (ITextResource) editor.getResource();
		}
		calculatePositions();

	}

	public void setProgressMonitor(IProgressMonitor monitor) {
	}

	protected void calculatePositions() {
		ILocationMap locationMap = textResource.getLocationMap();
		for (TreeIterator<EObject> contentIterator = textResource
				.getAllContents(); contentIterator.hasNext();) {
			EObject nextObject = contentIterator.next();
			int offset = locationMap.getCharStart(nextObject);
			int length = locationMap.getCharEnd(nextObject) + 1 - offset;
			try {
				int lines = document.getNumberOfLines(offset, length);
				if (lines<2)
					continue;
			} catch (BadLocationException e) {
				continue;
			}
			length = getOffsetOfNextLine(length + offset) - offset;
			if (offset >= 0 && length > 0) {
				positions.add(new Position(offset, length));
			}
		}
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				editor.updateFoldingStructure(positions);
			}
		});
	}

	private int getOffsetOfNextLine(int offset) {
		int end = document.getLength();
		int nextLineOffset = offset;
		if (offset < 0 || offset > end) 
			return -1;
		while (nextLineOffset < end) {
			String charAtOffset = "";
			try {
				charAtOffset += document.getChar(nextLineOffset);
			} catch (BadLocationException e) {
				return -1;
			}
			if (charAtOffset.equals("\n"))
				return nextLineOffset + 1;
			nextLineOffset++;
		}
		return offset;
	}
}
