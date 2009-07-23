package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
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

//TODO mseifert: align this class with the EMFText coding style
public class EMFTextReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

	private EMFTextEditor editor;

	@SuppressWarnings("unused")
	private IDocument fDocument;

	private ITextResource tr;

	/** holds the calculated positions */
	protected final ArrayList<Position> fPositions = new ArrayList<Position>();

	public void reconcile(IRegion partition) {
		initialReconcile();

	}

	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		initialReconcile();

	}

	public void setDocument(IDocument document) {
		fDocument = document;

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
		if (editor.isDirty())
			return;
		fPositions.clear();
		if (tr == null)
			tr = (ITextResource) editor.getResource();
		calculatePositions();

	}

	public void setProgressMonitor(IProgressMonitor monitor) {
	}

	protected void calculatePositions() {
		ILocationMap lm = tr.getLocationMap();
		for (TreeIterator<EObject> ti = tr.getAllContents(); ti.hasNext();) {
			EObject eo = ti.next();
			int offset = lm.getCharStart(eo);
			int length = lm.getCharEnd(eo) - lm.getCharStart(eo) + 1;
			if (offset >= 0 && length > 0)
				fPositions.add(new Position(offset, length));
		}
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				editor.updateFoldingStructure(fPositions);
			}

		});
	}
}
