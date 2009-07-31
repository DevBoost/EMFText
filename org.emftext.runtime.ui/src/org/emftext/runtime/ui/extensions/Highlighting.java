package org.emftext.runtime.ui.extensions;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.ColorManager;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.EMFTextTokenScanner;
import org.emftext.runtime.ui.preferences.PreferenceConstants;

//TODO hoang-kim add documentation
public class Highlighting {

	private final static String BRACKET_HIGHLIGHT = "bh_";
	private final static String DEFINITION_HIGHLIGHT = "def_";
	private final static String PROXY_HIGHLIGHT = "proxy_";

	private final static PositionHelper positionHelper = new PositionHelper();

	private EMFTextTokenScanner scanner;
	private Color definitionColor;
	private Color proxyColor;
	private Color bracketColor;
	private Color hyperlinkColor;
	private Color black;
	private StyleRange lastStyleRange;
	private StyledText textWidget;
	private IPreferenceStore preferenceStore;
	private ProjectionViewer projectionViewer;
	private ITextResource textResource;

	private Occurrence occurrence;
	private BracketSet bracketSet;
	private Hyperlink hyperLink;

	private final class HighlightingListener implements KeyListener,
			VerifyListener {

		private boolean changed = false;

		public void keyPressed(KeyEvent e) {
		}

		public void keyReleased(KeyEvent e) {
			if (e.stateMask == SWT.CTRL) {
				resetHyperlinkHighlighting();
			}
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
		bracketSet = new BracketSet(sourceviewer, textResource
				.getMetaInformation().getBracketPairs(), textResource.getURI()
				.fileExtension());

		definitionColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_DEFINITION_COLOR));
		proxyColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_PROXY_COLOR));
		bracketColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore,
				PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		black = colorManager.getColor(new RGB(0, 0, 0));
		hyperlinkColor = colorManager.getColor(PreferenceConverter.getColor(
				preferenceStore, PreferenceConstants.EDITOR_HYPERLINK_COLOR));

		hyperLink = new Hyperlink(textResource.getURI().fileExtension(), null);

		addListeners();
	}

	private void addListeners() {
		textWidget.addMouseMoveListener(new MouseMoveListener() {

			public void mouseMove(MouseEvent e) {

				if (e.stateMask == SWT.ALT) {

					// TODO because of the TextResource bug, only available if
					// the editor is not dirty.
					// TODO remove this once the background parsing is active
					if (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().getActiveEditor().isDirty()) {
						return;
					}
					int offset = -1;
					try {
						offset = textWidget.getOffsetAtLocation(new Point(e.x,
								e.y));
					} catch (Exception e1) {
						resetHyperlinkHighlighting();
						return;
					}
					ILocationMap locationMap = textResource.getLocationMap();
					offset = projectionViewer.widgetOffset2ModelOffset(offset);
					List<EObject> elementsAtOffset = locationMap
							.getElementsAt(offset);
					if (elementsAtOffset == null
							|| elementsAtOffset.size() == 0) {
						resetHyperlinkHighlighting();
						return;
					}
					EObject firstElementAtOffset = elementsAtOffset.get(0);
					EObject resolvedEObject = occurrence
							.tryToResolve(elementsAtOffset);

					if (resolvedEObject != null) {// is proxy
						if (!setHyperlinkHighlightPosition(offset,
								firstElementAtOffset)) {
							return;
						}
						setHyperlinkHighlighting();
						if (resolvedEObject.eResource() != null
								&& !textResource.equals(resolvedEObject
										.eResource())) {
							hyperLink.setEObject(resolvedEObject);
						}
						setHyperLinkJumpPosition(resolvedEObject);
					} else {
						resetHyperlinkHighlighting();
					}
				} else {
					resetHyperlinkHighlighting();
				}
			}
		});
		textWidget.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {// jump to declaration
				IDocument document = projectionViewer.getDocument();
				Position hPos = positionHelper.getFirstPosition(document,
						ExtensionConstants.POSITION_CATEGORY_DESTINATION);
				Position jumpPos = null;
				if (hPos != null) {
					jumpPos = convertToWidgedPosition(hPos);
				}
				if (e.stateMask == SWT.CTRL && jumpPos != null) {
					textWidget.setSelection(jumpPos.offset);
					resetHyperlinkHighlighting();
					return;
				}
				if (e.stateMask == SWT.CTRL && hyperLink.containsEObject()) {
					hyperLink.open();
					resetHyperlinkHighlighting();
					removeHighlighting();
				}
			}

			public void mouseUp(MouseEvent e) {
				removeHighlighting();
				setHighlighting();
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
			document
					.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_BRACKET);
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

		document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DEF);
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
		document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_USE);
		lastStyleRange = null;
	}

	public void resetBrackets() {
		bracketSet.resetBrackets();
	}

	/**
	 * Take a token style out of a styleRangeBuffer. If it isn't exist, create
	 * one, put it in the buffer and return it.
	 * 
	 * @param token
	 * @param length
	 *            the length of the token text
	 * @param tokenName
	 * @param tokenStyle
	 * @return
	 */
	private StyleRange getTokenStyle(IToken token, int length, String tokenStyle) {

		StyleRange styleRange = null;
		TextAttribute tokenAttribute = null;
		if (token.getData() instanceof TextAttribute) {
			tokenAttribute = (TextAttribute) token.getData();
		}
		if (tokenAttribute == null) {
			styleRange = new StyleRange(-1, length, black, null);
			setHighlightStyle(styleRange, tokenStyle);
			return styleRange;
		}

		int style = tokenAttribute.getStyle();
		int fontStyle = style & (SWT.ITALIC | SWT.BOLD | SWT.NORMAL);
		styleRange = new StyleRange(-1, length, tokenAttribute.getForeground(),
				tokenAttribute.getBackground(), fontStyle);
		styleRange.strikeout = (style & TextAttribute.STRIKETHROUGH) != 0;
		styleRange.underline = (style & TextAttribute.UNDERLINE) != 0;
		setHighlightStyle(styleRange, tokenStyle);
		return styleRange;
	}

	private void setHighlightStyle(StyleRange styleRange, String tokenStyle) {
		if (styleRange == null)
			return;
		if (tokenStyle.equals(BRACKET_HIGHLIGHT)) {
			styleRange.borderStyle = SWT.BORDER_SOLID;
			styleRange.borderColor = bracketColor;
			return;
		}
		if (tokenStyle.equals(DEFINITION_HIGHLIGHT)) {
			styleRange.background = definitionColor;
			return;
		}
		if (tokenStyle.equals(PROXY_HIGHLIGHT)) {
			styleRange.background = proxyColor;
		}
	}

	private void setHyperlinkHighlighting() {
		IDocument document = projectionViewer.getDocument();
		Position[] tmpPositions = positionHelper.getPositions(document,
				ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		if (tmpPositions.length < 1) {
			return;
		}
		Position hPos = convertToWidgedPosition(tmpPositions[0]);
		if (hPos == null) {
			return;
		}
		StyleRange styleRange = getStyleRangeAtPosition(hPos);
		styleRange.underline = true;
		styleRange.underlineColor = hyperlinkColor;
		styleRange.foreground = hyperlinkColor;
		textWidget.setStyleRange(styleRange);
	}

	private void resetHyperlinkHighlighting() {
		IDocument document = projectionViewer.getDocument();
		Position[] hPos = positionHelper.getPositions(document,
				ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		Position[] defPos = positionHelper.getPositions(document,
				ExtensionConstants.POSITION_CATEGORY_DEF);
		Position[] usePos = positionHelper.getPositions(document,
				ExtensionConstants.POSITION_CATEGORY_USE);
		if (hPos.length < 1) {
			return;
		}
		Position highlightPosition = convertToWidgedPosition(hPos[0]);
		if (highlightPosition == null) {
			hyperLink.resetValues();
			return;
		}
		scanner.setRange(projectionViewer.getDocument(), hPos[0].offset,
				hPos[0].length);
		IToken token = scanner.nextToken();
		while (!token.isEOF()) {
			if (scanner.getTokenText().equals(hyperLink.getHyperlinkText())) {
				StyleRange styleRange = getTokenStyle(token, scanner
						.getTokenLength(), "");
				styleRange = (StyleRange) styleRange.clone();
				styleRange.start = highlightPosition.offset;
				setHyperlinkBackgroundColor(hPos[0], defPos, styleRange, definitionColor);
				setHyperlinkBackgroundColor(hPos[0], usePos, styleRange, proxyColor);
				textWidget.setStyleRange(styleRange);
			}
			token = scanner.nextToken();
		}
		hyperLink.resetValues();
		positionHelper.removePositions(document,
				ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		document
				.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		positionHelper.removePositions(document,
				ExtensionConstants.POSITION_CATEGORY_DESTINATION);
		document
				.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
	}

	private void setHyperlinkBackgroundColor(Position hyperlinkPosition,
			Position[] positions, StyleRange styleRange, Color color) {
		if (positions != null && positions.length > 0) {
			for (Position p : positions) {
				if (p.offset == hyperlinkPosition.offset) {
					styleRange.background = color;
					return;
				}
			}
		}
	}

	/**
	 * Set the hyperlinkText and hyperlinkPosition.
	 * 
	 * @param offset
	 * @param offsetElement
	 */
	private boolean setHyperlinkHighlightPosition(int offset, EObject offsetElement) {
		IDocument document = projectionViewer.getDocument();
		Position oldPos = null;
		Position[] tmp = positionHelper.getPositions(document,
				ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		if (tmp.length > 0) {
			oldPos = tmp[0];
		}
		ILocationMap locationMap = textResource.getLocationMap();
		scanner.setRange(projectionViewer.getDocument(), locationMap
				.getCharStart(offsetElement), locationMap.getCharEnd(offsetElement)
				- locationMap.getCharStart(offsetElement) + 1);
		IToken token = scanner.nextToken();
		while (!token.isEOF()) {
			int tokenOffset = scanner.getTokenOffset();
			int tokenLength = scanner.getTokenLength();
			if (tokenOffset <= offset && tokenLength + tokenOffset > offset) {
				if (oldPos != null) {
					if (oldPos.offset == tokenOffset) {
						return false;
					} else {
						resetHyperlinkHighlighting();
					}
				}
				String tokenText = scanner.getTokenText();
				if (tokenText != null)
					hyperLink.setHyperlinkText(tokenText.trim());
				positionHelper.addPosition(document,
						ExtensionConstants.POSITION_CATEGORY_HYPERLINK,
						tokenOffset, tokenLength);
				return true;
			}
			token = scanner.nextToken();
		}
		hyperLink.resetValues();
		return false;
	}

	/**
	 * Set the hyperlinkJumpPos
	 * 
	 * @param jumpElement
	 */
	private void setHyperLinkJumpPosition(EObject jumpElement) {
		IDocument document = projectionViewer.getDocument();
		if (hyperLink.getHyperlinkText().equals("")) {
			return;
		}
		ILocationMap locationMap = textResource.getLocationMap();
		int start = locationMap.getCharStart(jumpElement);
		int length = locationMap.getCharEnd(jumpElement)
				- locationMap.getCharStart(jumpElement) + 1;
		scanner.setRange(projectionViewer.getDocument(), start, length);
		IToken token = scanner.nextToken();
		while (!token.isEOF()) {
			String tokenText = scanner.getTokenText();
			if (hyperLink.getHyperlinkText().equals(tokenText)) {
				int tokenLength = scanner.getTokenLength();
				int tokenOffset = scanner.getTokenOffset();
				positionHelper.addPosition(document,
						ExtensionConstants.POSITION_CATEGORY_DESTINATION,
						tokenOffset, tokenLength);
				return;
			}
			token = scanner.nextToken();
		}
		positionHelper
				.addPosition(document,
						ExtensionConstants.POSITION_CATEGORY_DESTINATION,
						start, length);
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
