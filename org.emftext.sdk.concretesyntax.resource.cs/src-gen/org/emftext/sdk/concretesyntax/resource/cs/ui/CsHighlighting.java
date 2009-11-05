/*******************************************************************************
 * Copyright (c) 2006-2009
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.ui;

// A manager class for the highlighting of occurrences and brackets.
public class CsHighlighting implements org.eclipse.jface.viewers.ISelectionProvider, org.eclipse.jface.viewers.ISelectionChangedListener {
	
	private java.util.List<org.eclipse.jface.viewers.ISelectionChangedListener> selectionChangedListeners = new java.util.ArrayList<org.eclipse.jface.viewers.ISelectionChangedListener>();
	private org.eclipse.jface.viewers.ISelection selection = null;
	private final static org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionHelper positionHelper = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionHelper();
	private boolean isHighlightBrackets = true;
	private boolean isHighlightOccurrences = true;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsTokenScanner scanner;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager colorManager;
	private org.eclipse.swt.graphics.Color definitionColor;
	private org.eclipse.swt.graphics.Color proxyColor;
	private org.eclipse.swt.graphics.Color bracketColor;
	private org.eclipse.swt.graphics.Color black;
	private org.eclipse.swt.custom.StyleRange lastStyleRange;
	private org.eclipse.swt.custom.StyledText textWidget;
	private org.eclipse.jface.preference.IPreferenceStore preferenceStore;
	private org.eclipse.jface.text.source.projection.ProjectionViewer projectionViewer;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsOccurrence occurrence;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet bracketSet;
	private org.eclipse.swt.widgets.Display display;
	
	// A key and mouse <code>org.eclipse.swt.widgets.Listener</code> for the highlighting. Removes the
	// highlighting before document change. No highlighting is set after
	// document change to increase the performance. No finding new occurrences
	// if the caret is still in the same token to increase the performance.
	private final class UpdateHighlightingListener implements org.eclipse.swt.events.KeyListener, org.eclipse.swt.events.VerifyListener, org.eclipse.swt.events.MouseListener, org.emftext.sdk.concretesyntax.resource.cs.ICsBackgroundParsingListener {
		
		private boolean changed = false;
		private int caret = -1;
		
		public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
		}
		
		public void keyReleased(org.eclipse.swt.events.KeyEvent e) {
			if (changed) {
				changed = false;
				return;
			}
			refreshHighlighting();
		}
		
		private void refreshHighlighting() {
			int textCaret = textWidget.getCaretOffset();
			if (textCaret < 0 || textCaret > textWidget.getCharCount()) {
				return;
			}
			if (textCaret != caret) {
				caret = textCaret;
				removeHighlighting();
				setHighlighting();
				setEObjectSelection();
			}
		}
		
		public void verifyText(org.eclipse.swt.events.VerifyEvent e) {
			occurrence.resetTokenRegion();
			removeHighlighting();
			changed = true;
		}
		
		public void mouseDoubleClick(org.eclipse.swt.events.MouseEvent e) {
		}
		
		public void mouseDown(org.eclipse.swt.events.MouseEvent e) {
		}
		
		// 1-left click, 2-middle click,
		public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
			// 3-right click
			if (e.button != 1) {
				return;
			}
			refreshHighlighting();
		}
		
		public void parsingCompleted(org.eclipse.emf.ecore.resource.Resource resource) {
			display.syncExec(new Runnable() {
				
				public void run() {
					refreshHighlighting();
				}
			});
		}
	}
	
	// Creates the highlighting manager class.
	//
	// @param textResource
	//            the text resource to be provided to other classes
	// @param sourceviewer
	//            the source viewer converts offset between master and slave
	//            documents
	// @param colorManager
	//            the color manager provides highlighting colors
	// @param emfTextEditor
	// @param iPropertySheetPage
	public CsHighlighting(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource textResource, org.eclipse.jface.text.source.projection.ProjectionViewer sourceviewer, org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager colorManager, org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor editor) {
		this.display = org.eclipse.swt.widgets.Display.getCurrent();
		sourceviewer.getSelectionProvider();
		preferenceStore = org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.getDefault().getPreferenceStore();
		textWidget = sourceviewer.getTextWidget();
		projectionViewer = sourceviewer;
		scanner = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsTokenScanner(colorManager);
		occurrence = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsOccurrence(textResource, sourceviewer, scanner);
		bracketSet = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet(sourceviewer, "cs");
		this.colorManager = colorManager;
		isHighlightBrackets = preferenceStore.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		isHighlightOccurrences = preferenceStore.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX);
		definitionColor = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(preferenceStore, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_DEFINITION_COLOR));
		proxyColor = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(preferenceStore, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_PROXY_COLOR));
		bracketColor = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(preferenceStore, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		black = colorManager.getColor(new org.eclipse.swt.graphics.RGB(0, 0, 0));
		
		addListeners(editor);
	}
	
	private void addListeners(org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor editor) {
		UpdateHighlightingListener hl = new UpdateHighlightingListener();
		textWidget.addKeyListener(hl);
		textWidget.addVerifyListener(hl);
		textWidget.addMouseListener(hl);
		editor.addBackgroundParsingListener(hl);
	}
	
	private void setHighlighting() {
		org.eclipse.jface.text.IDocument document = projectionViewer.getDocument();
		if (isHighlightBrackets) {
			bracketSet.matchingBrackets();
		}
		if (isHighlightOccurrences) {
			occurrence.handleOccurrenceHighlighting(bracketSet);
		}
		if (occurrence.isPositionsChanged()) {
			setCategoryHighlighting(document,
			org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.DEFINTION.toString());
			setCategoryHighlighting(document,
			org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.PROXY.toString());
		}
		setCategoryHighlighting(document, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.BRACKET.toString());
	}
	
	private void setCategoryHighlighting(org.eclipse.jface.text.IDocument document, String category) {
		org.eclipse.swt.custom.StyleRange styleRange = null;
		org.eclipse.jface.text.Position[] positions = positionHelper.getPositions(document, category);
		
		if (category.equals(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.PROXY.toString())) {
			if (lastStyleRange == null && positions.length > 0) {
				styleRange = getStyleRangeAtPosition(positions[0]);
				if (styleRange.foreground == null) {
					styleRange.foreground = black;
				}
				lastStyleRange = (org.eclipse.swt.custom.StyleRange) styleRange.clone();
			}
			if (lastStyleRange != null) {
				if (styleRange == null) {
					styleRange = (org.eclipse.swt.custom.StyleRange) lastStyleRange.clone();
				}
				styleRange.background = proxyColor;
			}
		}
		for (org.eclipse.jface.text.Position position : positions) {
			org.eclipse.jface.text.Position tmpPosition = convertToWidgetPosition(position);
			if (tmpPosition != null) {
				if (category.equals(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.DEFINTION.toString())) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					if (styleRange.foreground == null) {
						styleRange.foreground = black;
					}
					lastStyleRange = (org.eclipse.swt.custom.StyleRange) styleRange.clone();
					styleRange.background = definitionColor;
					textWidget.setStyleRange(styleRange);
				}
				if (category.equals(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.PROXY.toString())) {
					if (styleRange == null)					return;
					styleRange.start = tmpPosition.offset;
					textWidget.setStyleRange(styleRange);
				}
				if (category.equals(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.BRACKET.toString())) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					styleRange.borderStyle = org.eclipse.swt.SWT.BORDER_SOLID;
					styleRange.borderColor = bracketColor;
					if (styleRange.foreground == null)					styleRange.foreground = black;
					textWidget.setStyleRange(styleRange);
				}
			}
		}
	}
	
	private void removeHighlighting() {
		org.eclipse.jface.text.IDocument document = projectionViewer.getDocument();
		removeHighlightingCategory(document, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.BRACKET.toString());
		if (occurrence.isToRemoveHighlighting()) {
			removeHighlightingCategory(document, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.DEFINTION.toString());
			removeHighlightingCategory(document, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.PROXY.toString());
			lastStyleRange = null;
		}
	}
	
	private void removeHighlightingCategory(org.eclipse.jface.text.IDocument document, String category) {
		org.eclipse.jface.text.Position[] positions = positionHelper.getPositions(document, category);
		boolean isOccurrence = (category.equals(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.DEFINTION.toString()) || category.equals(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.PROXY.toString())) && lastStyleRange != null;
		if (category.equals(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.BRACKET.toString())) {
			org.eclipse.swt.custom.StyleRange styleRange;
			for (org.eclipse.jface.text.Position position : positions) {
				org.eclipse.jface.text.Position tmpPosition = convertToWidgetPosition(position);
				if (tmpPosition != null) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					styleRange.borderStyle = org.eclipse.swt.SWT.NONE;
					styleRange.borderColor = null;
					styleRange.background = null;
					textWidget.setStyleRange(styleRange);
				}
			}
		}
		
		if (isOccurrence) {
			for (org.eclipse.jface.text.Position position : positions) {
				org.eclipse.jface.text.Position tmpPosition = convertToWidgetPosition(position);
				if (tmpPosition != null) {
					lastStyleRange.start = tmpPosition.offset;
					textWidget.setStyleRange(lastStyleRange);
				}
			}
		}
		
		positionHelper.removePositions(document, category);
	}
	
	public void setEObjectSelection() {
		display.syncExec(new Runnable() {
			public void run() {
				org.eclipse.emf.ecore.EObject selectedEObject = occurrence.getEObjectAtCurrentPosition();
				if (selectedEObject != null) {
					setSelection(new org.emftext.sdk.concretesyntax.resource.cs.ui.CsEObjectSelection(selectedEObject, false));
				}
			}
		});
	}
	
	// Resets the changed values after setting the preference pages.
	public void resetValues() {
		isHighlightBrackets = preferenceStore.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		isHighlightOccurrences = preferenceStore.getBoolean(org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_OCCURRENCE_CHECKBOX);
		bracketColor = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(preferenceStore, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		definitionColor = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(preferenceStore, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_DEFINITION_COLOR));
		proxyColor = colorManager.getColor(org.eclipse.jface.preference.PreferenceConverter.getColor(preferenceStore, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPreferenceConstants.EDITOR_PROXY_COLOR));
		bracketSet.resetBrackets();
	}
	
	private org.eclipse.jface.text.Position convertToWidgetPosition(org.eclipse.jface.text.Position position) {
		if (position == null) {
			return null;
		}
		int startOffset = projectionViewer.modelOffset2WidgetOffset(position.offset);
		int endOffset = projectionViewer.modelOffset2WidgetOffset(position.offset + position.length);
		if (endOffset - startOffset != position.length || startOffset == -1 || textWidget.getCharCount() < endOffset) {
			return null;
		}
		return new org.eclipse.jface.text.Position(startOffset, endOffset - startOffset);
	}
	
	private org.eclipse.swt.custom.StyleRange getStyleRangeAtPosition(org.eclipse.jface.text.Position position) {
		org.eclipse.swt.custom.StyleRange styleRange = null;
		try {
			styleRange = textWidget.getStyleRangeAtOffset(position.offset);
		} catch (IllegalArgumentException iae) {
		}
		if (styleRange == null) {
			styleRange = new org.eclipse.swt.custom.StyleRange(position.offset, position.length, black, null);
		} else {
			styleRange.length = position.length;
		}
		return styleRange;
	}
	
	public void addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}
	
	public void removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}
	
	public void setSelection(org.eclipse.jface.viewers.ISelection selection) {
		this.selection = selection;
		for (org.eclipse.jface.viewers.ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new org.eclipse.jface.viewers.SelectionChangedEvent(this, selection));
		}
	}
	
	public org.eclipse.jface.viewers.ISelection getSelection() {
		return selection;
	}
	
	public void selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent event) {
		if (event.getSelection() instanceof org.eclipse.jface.viewers.TreeSelection) {
			handleContentOutlineSelection(event.getSelection());
		}
	}
	
	private void handleContentOutlineSelection(org.eclipse.jface.viewers.ISelection selection) {
		if (!selection.isEmpty()) {
			java.lang.Object selectedElement = ((org.eclipse.jface.viewers.IStructuredSelection) selection).getFirstElement();
			if (selectedElement instanceof org.eclipse.emf.ecore.EObject) {
				org.eclipse.emf.ecore.EObject selectedEObject = (org.eclipse.emf.ecore.EObject) selectedElement;
				org.eclipse.emf.ecore.resource.Resource resource = selectedEObject.eResource();
				if (resource instanceof org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource) {
					org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource textResource = (org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource) resource;
					org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = textResource.getLocationMap();
					int elementCharStart = locationMap.getCharStart(selectedEObject);
					int elementCharEnd = locationMap.getCharEnd(selectedEObject);
					org.eclipse.jface.text.TextSelection textEditorSelection = new org.eclipse.jface.text.TextSelection(elementCharStart, elementCharEnd - elementCharStart + 1);
					projectionViewer.getSelectionProvider().setSelection(textEditorSelection);
				}
			}
		}
	}
	
}
