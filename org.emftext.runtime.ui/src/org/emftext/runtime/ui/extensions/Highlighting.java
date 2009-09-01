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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.ColorManager;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.EMFTextTokenScanner;
import org.emftext.runtime.ui.preferences.PreferenceConstants;

/**
 * A manager class for the highlighting of occurrences and brackets.
 * 
 * @author Tan-Ky Hoang-Kim
 * 
 */
public class Highlighting implements ISelectionProvider, ISelectionChangedListener {

	private final static PositionHelper positionHelper = new PositionHelper();

	private boolean isHighlightBrackets = true;
	private boolean isHighlightOccurrences = true;
	private EMFTextTokenScanner scanner;
	private ColorManager colorManager;
	private Color definitionColor;
	private Color proxyColor;
	private Color bracketColor;
	private Color black;
	private StyleRange lastStyleRange;
	private StyledText textWidget;
	private IPreferenceStore preferenceStore;
	private ProjectionViewer projectionViewer;

	private Occurrence occurrence;
	private BracketSet bracketSet;

	/**
	 * A key and mouse <code>Listener</code> for the highlighting. Removes the
	 * highlighting before document change. No highlighting is set after
	 * document change to increase the performance. No finding new occurrences
	 * if the caret is still in the same token to increase the performance.
	 * 
	 * @author Tan-Ky Hoang-Kim
	 * 
	 */
	private final class HighlightingListener implements KeyListener,
			VerifyListener, MouseListener {

		private boolean changed = false;
		private int caret = -1;

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			if (changed) {
				changed = false;
				return;
			}
			int textCaret = textWidget.getCaretOffset();
			if (textCaret < 0 || textCaret > textWidget.getCharCount())
				return;
			if (textCaret != caret) {
				caret = textCaret;
				removeHighlighting();
				setHighlighting();
				setEObjectSelection();
			}
		}

		public void verifyText(VerifyEvent e) {
			occurrence.resetTokenRegion();
			removeHighlighting();
			changed = true;
		}

		public void mouseDoubleClick(MouseEvent e) {
		}

		public void mouseDown(MouseEvent e) {
		}

		public void mouseUp(MouseEvent e) {// 1-left click, 2-middle click,
			// 3-right click
			if (e.button != 1)
				return;
			int textCaret = textWidget.getCaretOffset();
			if (textCaret < 0 || textCaret > textWidget.getCharCount())
				return;
			if (textCaret != caret) {
				caret = textCaret;
				removeHighlighting();
				setHighlighting();
				setEObjectSelection();
			}
		}

	}

	/**
	 * Creates the highlighting manager class.
	 * 
	 * @param textResource
	 *            the text resource to be provided to other classes
	 * @param sourceviewer
	 *            the source viewer converts offset between master and slave
	 *            documents
	 * @param colorManager
	 *            the color manager provides highlighting colors
	 * @param iPropertySheetPage 
	 */
	public Highlighting(ITextResource textResource,
			ProjectionViewer sourceviewer, ColorManager colorManager) {
		sourceviewer.getSelectionProvider();
		preferenceStore = EMFTextRuntimeUIPlugin.getDefault()
				.getPreferenceStore();
		textWidget = sourceviewer.getTextWidget();
		projectionViewer = sourceviewer;
		scanner = new EMFTextTokenScanner(textResource, colorManager);
		occurrence = new Occurrence(textResource, sourceviewer, scanner);
		bracketSet = new BracketSet(sourceviewer, textResource.getURI()
				.fileExtension());
		this.colorManager = colorManager;

		isHighlightBrackets = preferenceStore
				.getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		isHighlightOccurrences = preferenceStore
				.getBoolean(PreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX);
		definitionColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_DEFINITION_COLOR));
		proxyColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_PROXY_COLOR));
		bracketColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore,
				PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		black = colorManager.getColor(new RGB(0, 0, 0));

		addListeners();
	}

	private void addListeners() {
		HighlightingListener hl = new HighlightingListener();
		textWidget.addKeyListener(hl);
		textWidget.addVerifyListener(hl);
		textWidget.addMouseListener(hl);
	}

	private void setHighlighting() {
		IDocument document = projectionViewer.getDocument();

		if (isHighlightBrackets) {
			bracketSet.matchingBrackets();
		}
		if (isHighlightOccurrences) {
			occurrence.handleOccurrenceHighlighting(bracketSet);
		}
		if (occurrence.isPositionsChanged()) {
			setCategoryHighlighting(document,
					ExtensionConstants.PositionCategory.DEFINTION.toString());
			setCategoryHighlighting(document,
					ExtensionConstants.PositionCategory.PROXY.toString());
		}
		setCategoryHighlighting(document,
				ExtensionConstants.PositionCategory.BRACKET.toString());

	}

	private void setCategoryHighlighting(IDocument document, String category) {
		StyleRange styleRange = null;
		Position[] positions = positionHelper.getPositions(document, category);

		if (category.equals(ExtensionConstants.PositionCategory.PROXY
				.toString())) {
			if (lastStyleRange == null && positions.length > 0) {
				styleRange = getStyleRangeAtPosition(positions[0]);
				if (styleRange.foreground == null) {
					styleRange.foreground = black;
				}
				lastStyleRange = (StyleRange) styleRange.clone();
			}

			if (lastStyleRange != null) {
				if (styleRange == null) {
					styleRange = (StyleRange) lastStyleRange.clone();
				}
				styleRange.background = proxyColor;
			}
		}

		for (Position position : positions) {
			Position tmpPosition = convertToWidgedPosition(position);
			if (tmpPosition != null) {
				if (category
						.equals(ExtensionConstants.PositionCategory.DEFINTION
								.toString())) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					if (styleRange.foreground == null) {
						styleRange.foreground = black;
					}
					lastStyleRange = (StyleRange) styleRange.clone();
					styleRange.background = definitionColor;
					textWidget.setStyleRange(styleRange);
				}
				if (category.equals(ExtensionConstants.PositionCategory.PROXY
						.toString())) {
					if (styleRange == null)
						return;
					styleRange.start = tmpPosition.offset;
					textWidget.setStyleRange(styleRange);
				}
				if (category.equals(ExtensionConstants.PositionCategory.BRACKET
						.toString())) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					styleRange.borderStyle = SWT.BORDER_SOLID;
					styleRange.borderColor = bracketColor;
					if (styleRange.foreground == null)
						styleRange.foreground = black;
					textWidget.setStyleRange(styleRange);
				}
			}
		}
	}

	private void removeHighlighting() {
		IDocument document = projectionViewer.getDocument();
		removeHighlightingCategory(document,
				ExtensionConstants.PositionCategory.BRACKET.toString());
		if (occurrence.isToRemoveHighlighting()) {
			removeHighlightingCategory(document,
					ExtensionConstants.PositionCategory.DEFINTION.toString());
			removeHighlightingCategory(document,
					ExtensionConstants.PositionCategory.PROXY.toString());
			lastStyleRange = null;
		}
	}

	private void removeHighlightingCategory(IDocument document, String category) {
		Position[] positions = positionHelper.getPositions(document, category);
		boolean isOccurrence = (category
				.equals(ExtensionConstants.PositionCategory.DEFINTION
						.toString()) || category
				.equals(ExtensionConstants.PositionCategory.PROXY.toString()))
				&& lastStyleRange != null;

		if (category.equals(ExtensionConstants.PositionCategory.BRACKET
				.toString())) {
			StyleRange styleRange;
			for (Position position : positions) {
				Position tmpPosition = convertToWidgedPosition(position);
				if (tmpPosition != null) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					styleRange.borderStyle = SWT.NONE;
					styleRange.borderColor = null;
					styleRange.background = null;
					textWidget.setStyleRange(styleRange);
				}
			}
		}

		if (isOccurrence)
			for (Position position : positions) {
				Position tmpPosition = convertToWidgedPosition(position);
				if (tmpPosition != null) {
					lastStyleRange.start = tmpPosition.offset;
					textWidget.setStyleRange(lastStyleRange);
				}
			}

		positionHelper.removePositions(document, category);
	}
	
	public void setEObjectSelection() {
		EObject selectedEObject = occurrence.getEObjectAtCurrentPosition();

		if (selectedEObject != null) {
			setSelection(new StructuredSelection(selectedEObject));
		}
		
	}

	/**
	 * Resets the changed values after setting the preference pages.
	 */
	public void resetValues() {
		isHighlightBrackets = preferenceStore
				.getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		isHighlightOccurrences = preferenceStore
				.getBoolean(PreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX);
		bracketColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore,
				PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		definitionColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_DEFINITION_COLOR));
		proxyColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_PROXY_COLOR));
		bracketSet.resetBrackets();
	}

	private Position convertToWidgedPosition(Position position) {
		if (position == null) {
			return null;
		}
		int startOffset = projectionViewer
				.modelOffset2WidgetOffset(position.offset);
		int endOffset = projectionViewer
				.modelOffset2WidgetOffset(position.offset + position.length);
		if (endOffset - startOffset != position.length || startOffset == -1) {
			return null;
		}
		return new Position(startOffset, endOffset - startOffset);
	}

	private StyleRange getStyleRangeAtPosition(Position position) {
		StyleRange styleRange = null;
		try {
			styleRange = textWidget
			.getStyleRangeAtOffset(position.offset);
		} catch (IllegalArgumentException iae) {
			// TODO: handle exception
		}
		if (styleRange == null) {
			styleRange = new StyleRange(position.offset, position.length,
					black, null);
		} else {
			styleRange.length = position.length;
		}
		return styleRange;
	}
	
	private List<ISelectionChangedListener> selectionChangedListeners = 
		new ArrayList<ISelectionChangedListener>();
	
	private ISelection selection = null;

	public void addSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	public void setSelection(ISelection selection) {
		this.selection = selection;
		for(ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, selection));
		}
	}

	public ISelection getSelection() {
		return selection;
	}
	
	public void selectionChanged(
			SelectionChangedEvent event) {
		
		Object oldSelection = null;
		Object newSelection = null;
		if (getSelection() instanceof IStructuredSelection) {
			oldSelection = ((IStructuredSelection)getSelection()).getFirstElement();
		}
		if (event.getSelection() instanceof IStructuredSelection) {
			newSelection = ((IStructuredSelection)event.getSelection()).getFirstElement();
		}	
		if(newSelection != null && !newSelection.equals(oldSelection)) {
			selection = event.getSelection();
			handleContentOutlineSelection(event
					.getSelection());
		}
	}	

	private void handleContentOutlineSelection(ISelection selection) {
		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection)
					.getFirstElement();
			if (selectedElement instanceof EObject) {
				EObject selectedEObject = (EObject) selectedElement;
				Resource resource = selectedEObject.eResource();
				if (resource instanceof ITextResource) {
					ITextResource textResource = (ITextResource) resource;
					ILocationMap locationMap = textResource.getLocationMap();
					int elementCharStart = locationMap
							.getCharStart(selectedEObject);
					int elementCharEnd = locationMap
							.getCharEnd(selectedEObject);
					// selectAndReveal(elementCharStart, elementCharEnd -
					// elementCharStart + 1);
					// this.getSelectionProvider().setSelection(selection);
					TextSelection textEditorSelection = new TextSelection(
							elementCharStart, elementCharEnd - elementCharStart
									+ 1);
					projectionViewer.getSelectionProvider().setSelection(
							textEditorSelection);
				}
			}
		}
	}

}
