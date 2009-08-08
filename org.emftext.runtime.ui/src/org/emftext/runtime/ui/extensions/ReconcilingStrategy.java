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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
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

/**
 * This ReconcilingStrategy finds all foldable elements and sends their positions to the editor for further handling. 
 * It should start every time after changing the text document. Right now, it starts at the starting sequence and after every saving action.
 * @author Tan-Ky Hoang-Kim
 *
 */
public class ReconcilingStrategy implements IReconcilingStrategy,
		IReconcilingStrategyExtension {

	private IDocument document;
	private EMFTextEditor editor;

	private ITextResource textResource;

	/**
	 * Creates a <code>ReconcilingStrategy</code> to find foldable elements.
	 * @param editor the <code>EMFTextEditor</code> to handle the calculated positions
	 */
	public ReconcilingStrategy(EMFTextEditor editor) {
		super();
		this.editor = editor;
	}

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
		EClass[] eClasses = textResource.getMetaInformation().getFoldableClasses();
		if (eClasses.length<1)
			return;
		for (TreeIterator<EObject> contentIterator = textResource
				.getAllContents(); contentIterator.hasNext();) {
			boolean isFoldable =false;
			EObject nextObject = contentIterator.next();
			for (EClass eClass : eClasses) {
				if (nextObject.eClass().equals(eClass)){
					isFoldable = true;
					break;
				}
			}
			if (!isFoldable)
				continue;
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
			if (charAtOffset.matches("\\S"))
				return nextLineOffset;
			if (charAtOffset.equals("\n"))
				return nextLineOffset + 1;
			nextLineOffset++;
		}
		return offset;
	}
}
