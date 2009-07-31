package org.emftext.runtime.ui.extensions;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.ColorManager;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.EMFTextTokenScanner;
import org.emftext.runtime.ui.preferences.PreferenceConstants;

//TODO hoang-kim add documentation
public class Highlighting {

	private final static PositionHelper positionHelper = new PositionHelper();

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
	private ITextResource textResource;

	private Occurrence occurrence;
	private BracketSet bracketSet;
	
	private final class HighlightingListener implements KeyListener,
			VerifyListener {

		private boolean changed = false;

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			if (changed) {
				changed = false;
				return;
			}
			removeHighlighting();
			setHighlighting();
		}

		public void verifyText(VerifyEvent e) {
			removeHighlighting();
			changed = true;
		}
	}

	public Highlighting(ITextResource textresource,
			ProjectionViewer sourceviewer, ColorManager colorManager) {
		preferenceStore = EMFTextRuntimeUIPlugin.getDefault()
				.getPreferenceStore();
		textResource = textresource;
		textWidget = sourceviewer.getTextWidget();
		projectionViewer = sourceviewer;
		scanner = new EMFTextTokenScanner(textresource, colorManager);
		occurrence = new Occurrence(textResource, sourceviewer, colorManager,
				scanner);
		bracketSet = new BracketSet(sourceviewer, textResource.getURI()
				.fileExtension());
		this.colorManager = colorManager;
		definitionColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_DEFINITION_COLOR));
		proxyColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_PROXY_COLOR));
		bracketColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore,
				PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		black = colorManager.getColor(new RGB(0, 0, 0));
		colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_HYPERLINK_COLOR));

		addListeners();
	}

	private void addListeners() {
		textWidget.addCaretListener(new CaretListener() {
			
			public void caretMoved(CaretEvent event) {
				//TODO Maybe this line can be removed after activating backgroundparsing
				if (!PlatformUI.getWorkbench().isStarting()) {
				int offset = event.caretOffset;
				if (offset >=0&&offset<=textWidget.getCharCount()) {
					removeHighlighting();
					setHighlighting();
				}
				}
			}
		});

		HighlightingListener hl = new HighlightingListener();
		textWidget.addKeyListener(hl);
		textWidget.addVerifyListener(hl);
	}

	private void setHighlighting() {
		IDocument document = projectionViewer.getDocument();
		boolean isHighlightBrackets = preferenceStore
				.getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		boolean isHighlightOccurrence = true;
		if (textWidget.getCaretOffset() >= textWidget.getCharCount()) {
			isHighlightOccurrence = false;
		}
		if (isHighlightBrackets) {
			bracketSet.matchingBrackets();
		}
		if (isHighlightOccurrence) {
			occurrence.handleOccurrenceHighlighting(bracketSet);
		}

		setCategoryHighlighting(document,
				ExtensionConstants.POSITION_CATEGORY_DEF);
		setCategoryHighlighting(document,
				ExtensionConstants.POSITION_CATEGORY_USE);
		setCategoryHighlighting(document,
				ExtensionConstants.POSITION_CATEGORY_BRACKET);

	}

	private void setCategoryHighlighting(IDocument document, String category) {
		StyleRange styleRange = null;
		Position[] positions = positionHelper.getPositions(document, category);

		if (category.equals(ExtensionConstants.POSITION_CATEGORY_USE)) {

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
				if (category.equals(ExtensionConstants.POSITION_CATEGORY_DEF)) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					if (styleRange.foreground == null) {
						styleRange.foreground = black;
					}
					lastStyleRange = (StyleRange) styleRange.clone();
					styleRange.background = definitionColor;
					textWidget.setStyleRange(styleRange);
				}
				if (category.equals(ExtensionConstants.POSITION_CATEGORY_USE)) {
					if (styleRange == null)
						return;
					styleRange.start = tmpPosition.offset;
					textWidget.setStyleRange(styleRange);
				}
				if (category
						.equals(ExtensionConstants.POSITION_CATEGORY_BRACKET)) {
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
		boolean isHighlightBrackets = preferenceStore
				.getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);

		StyleRange styleRange;

		if (isHighlightBrackets) {
			Position[] positions = positionHelper.getPositions(document,
					ExtensionConstants.POSITION_CATEGORY_BRACKET);
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
			positionHelper.removePositions(document,
					ExtensionConstants.POSITION_CATEGORY_BRACKET);
		}

		Position[] positions = positionHelper.getPositions(document,
				ExtensionConstants.POSITION_CATEGORY_DEF);
		for (Position position : positions) {
			Position tmpPosition = convertToWidgedPosition(position);
			if (tmpPosition != null) {
				lastStyleRange.start = tmpPosition.offset;
				textWidget.setStyleRange(lastStyleRange);
			}
		}
		positionHelper.removePositions(document,
				ExtensionConstants.POSITION_CATEGORY_DEF);

		positions = positionHelper.getPositions(document,
				ExtensionConstants.POSITION_CATEGORY_USE);
		for (Position position : positions) {
			Position tmpPosition = convertToWidgedPosition(position);
			if (tmpPosition != null) {
				lastStyleRange.start = tmpPosition.offset;
				textWidget.setStyleRange(lastStyleRange);
			}
		}
		positionHelper.removePositions(document,
				ExtensionConstants.POSITION_CATEGORY_USE);
		lastStyleRange = null;
	}

	public void resetBrackets() {
		bracketColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore,
				PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
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
		StyleRange styleRange = textWidget
				.getStyleRangeAtOffset(position.offset);
		if (styleRange == null) {
			styleRange = new StyleRange(position.offset, position.length,
					black, null);
		} else {
			styleRange.length = position.length;
		}
		return styleRange;
	}
}
