package org.emftext.runtime.ui.extensions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
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

	private EMFTextTokenScanner scanner;
	private Color definitionColor;
	private Color proxyColor;
	private Color bracketColor;
	private Color hyperlinkColor;
	private Color black;
	private Map<String, StyleRange> styleRangeBuffer = new HashMap<String, StyleRange>();
	private StyleRange lastStyleRange;
	private StyledText textWidget;
	private IPreferenceStore preferenceStore;
	private ProjectionViewer projectionViewer;
	private ITextResource textResource;

	private Occurrence occurrence;
	private BracketSet bracketSet;
	private Hyperlink hyperLink;

	private final class HighlightingListener implements KeyListener, VerifyListener {

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

	public Highlighting(ITextResource textresource, ProjectionViewer sourceviewer, ColorManager colorManager) {
		preferenceStore = EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
		textResource = textresource;
		textWidget = sourceviewer.getTextWidget();
		projectionViewer = sourceviewer;
		scanner = new EMFTextTokenScanner(textresource, colorManager);
		occurrence = new Occurrence(textResource, sourceviewer, colorManager, scanner);
		bracketSet = new BracketSet(sourceviewer, textResource.getURI().fileExtension());

		definitionColor = colorManager.getColor(PreferenceConverter.getColor(preferenceStore,
				PreferenceConstants.EDITOR_DEFINITION_COLOR));
		proxyColor = colorManager.getColor(PreferenceConverter.getColor(preferenceStore, PreferenceConstants.EDITOR_PROXY_COLOR));
		bracketColor = colorManager.getColor(PreferenceConverter.getColor(preferenceStore,
				PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		black = colorManager.getColor(new RGB(0, 0, 0));
		hyperlinkColor = colorManager.getColor(PreferenceConverter.getColor(preferenceStore,
				PreferenceConstants.EDITOR_HYPERLINK_COLOR));

		hyperLink = new Hyperlink();

		addListeners();
	}

	private void addListeners() {
		textWidget.addMouseMoveListener(new MouseMoveListener() {

			public void mouseMove(MouseEvent e) {

				if (e.stateMask == SWT.CTRL) {
					// TODO because of the TextResource bug, only available if
					// the editor is not dirty.
					// TODO remove this once the background parsing is active
					if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
							.isDirty()) {
						return;
					}
					int offset;
					try {
						offset = textWidget.getOffsetAtLocation(new Point(e.x, e.y));
					} catch (Exception e1) {
						resetHyperlinkHighlighting();
						return;
					}
					ILocationMap locationMap = textResource.getLocationMap();
					offset = projectionViewer.widgetOffset2ModelOffset(offset);
					List<EObject> elementsAtOffset = locationMap.getElementsAt(offset);
					if (elementsAtOffset == null) {
						resetHyperlinkHighlighting();
						return;
					}
					EObject firstElementAtOffset = elementsAtOffset.get(0);
					// TODO hoang-kim rename 'eo' to something meaningful
					EObject eo = occurrence.tryToResolve(elementsAtOffset);

					if (eo != null) {// is proxy
						if (!setHyperlinkHighlightPosition(offset, firstElementAtOffset)) {
							return;
						}
						setHyperlinkHighlighting();
						if (!textResource.equals(eo.eResource())) {
							hyperLink.setEObject(eo);
						}
						setHyperLinkJumpPosition(eo);
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
				IDocument doc = projectionViewer.getDocument();
				Position[] hPos = null;
				try {
					hPos = doc.getPositions(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
				} catch (BadPositionCategoryException e1) {
					e1.printStackTrace();
				}
				Position jumpPos = null;
				if (hPos != null && hPos.length > 0) {
					jumpPos = convertToWidgedPosition(hPos[0]);
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
		boolean isHighlightBrackets = preferenceStore.getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
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
		StyleRange styleRange = null;

		// TODO hoang-kim the code below seems quite similar. can we move it to a method
		// and call it multiple times instead of duplicating the code here?
		try {
			Position[] positions = document.getPositions(ExtensionConstants.POSITION_CATEGORY_BRACKET);
			for (Position position : positions) {
				Position tmpPosition = convertToWidgedPosition(position);
				if (tmpPosition != null) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					styleRange.borderStyle = SWT.BORDER_SOLID;
					styleRange.borderColor = bracketColor;
					if (styleRange.foreground == null)
						styleRange.foreground = black;
					textWidget.setStyleRange(styleRange);
				}
			}
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
		try {
			Position[] positions = document.getPositions(ExtensionConstants.POSITION_CATEGORY_DEF);
			for (Position position : positions) {
				Position tmpPosition = convertToWidgedPosition(position);
				if (tmpPosition != null) {
					styleRange = getStyleRangeAtPosition(tmpPosition);
					if (styleRange.foreground == null) {
						styleRange.foreground = black;
					}
					lastStyleRange = (StyleRange) styleRange.clone();
					styleRange.background = definitionColor;
					textWidget.setStyleRange(styleRange);
				}
			}
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}

		try {
			Position[] positions = document.getPositions(ExtensionConstants.POSITION_CATEGORY_USE);
			if (lastStyleRange == null && positions.length > 0) {
				styleRange = getStyleRangeAtPosition(positions[0]);
				if (styleRange.foreground == null) {
					styleRange.foreground = black;
				}
				lastStyleRange = (StyleRange) styleRange.clone();
			}
			// TODO hoang-kim is this correct?
			if (lastStyleRange == null) {
				return;
			}
			if (styleRange == null) {
				styleRange = (StyleRange) lastStyleRange.clone();
			}
			styleRange.background = proxyColor;
			for (Position position : positions) {
				Position tmpPostion = convertToWidgedPosition(position);
				if (tmpPostion != null) {
					styleRange.start = tmpPostion.offset;
					textWidget.setStyleRange(styleRange);
				}
			}
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}

	}

	private void removeHighlighting() {
		IDocument document = projectionViewer.getDocument();
		boolean isHighlightBrackets = preferenceStore.getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);

		StyleRange styleRange;

		if (isHighlightBrackets) {
			try {
				Position[] positions = document.getPositions(ExtensionConstants.POSITION_CATEGORY_BRACKET);
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
				document.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_BRACKET);
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}
			document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_BRACKET);
		}
		try {
			Position[] positions = document.getPositions(ExtensionConstants.POSITION_CATEGORY_DEF);
			for (Position position : positions) {
				Position tmpPosition = convertToWidgedPosition(position);
				if (tmpPosition != null) {
					lastStyleRange.start = tmpPosition.offset;
					textWidget.setStyleRange(lastStyleRange);
				}
			}
			document.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_DEF);
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
		document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DEF);
		try {
			Position[] positions = document.getPositions(ExtensionConstants.POSITION_CATEGORY_USE);
			for (Position position : positions) {
				Position tmpPosition = convertToWidgedPosition(position);
				if (tmpPosition != null) {
					lastStyleRange.start = tmpPosition.offset;
					textWidget.setStyleRange(lastStyleRange);
				}
			}
			document.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_USE);
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
		document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_USE);
		lastStyleRange = null;
	}

	public void resetBrackets() {
		bracketSet.resetBrackets();
	}

	private StyleRange getTokenStyle(IToken token, int length, String tokenName, String tokenStyle) {
		// TODO hoang-kim specify what is to do here (there was an empty TODO here before)
		int tokenType = 0;
		StyleRange styleRange = styleRangeBuffer.get(tokenStyle + tokenType);
		if (styleRange != null) {
			if (!occurrence.isQuotedToken(tokenName)) {
				styleRange.length = length;
			}
			return styleRange;
		}
		TextAttribute tokenAttribute = null;
		if (token.getData() instanceof TextAttribute) {
			tokenAttribute = (TextAttribute) token.getData();
		}
		if (tokenAttribute == null) {
			styleRange = new StyleRange(0, length, null, null);
			setHighlightStyle(styleRange, tokenStyle);
			if (!occurrence.isQuotedToken(tokenName)) {
				styleRange.length = length;
			}
			styleRangeBuffer.put(tokenStyle + tokenType, styleRange);
			return styleRange;
		}

		int style = tokenAttribute.getStyle();
		int fontStyle = style & (SWT.ITALIC | SWT.BOLD | SWT.NORMAL);
		styleRange = new StyleRange(-1, length, tokenAttribute.getForeground(), tokenAttribute.getBackground(), fontStyle);
		styleRange.strikeout = (style & TextAttribute.STRIKETHROUGH) != 0;
		styleRange.underline = (style & TextAttribute.UNDERLINE) != 0;
		setHighlightStyle(styleRange, tokenStyle);
		if (!occurrence.isQuotedToken(tokenName)) {
			styleRange.length = length;
		}
		styleRangeBuffer.put(tokenStyle + tokenType, styleRange);
		return styleRange;
	}

	private void setHighlightStyle(StyleRange styleRange, String tokenStyle) {
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

	public void clearStyleRangeBuffer() {
		styleRangeBuffer.clear();
	}

	private void setHyperlinkHighlighting() {
		IDocument document = projectionViewer.getDocument();
		Position[] tmpPositions = getPositions(document);
		if (tmpPositions == null) {
			return;
		}
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
		Position[] hPos = getPositions(document);
		if (hPos == null) {
			return;
		}
		Position[] defPos = null;
		try {
			defPos = document.getPositions(ExtensionConstants.POSITION_CATEGORY_DEF);
		} catch (BadPositionCategoryException e1) {
			e1.printStackTrace();
		}
		Position[] usePos = null;
		try {
			usePos = document.getPositions(ExtensionConstants.POSITION_CATEGORY_USE);
		} catch (BadPositionCategoryException e1) {
			e1.printStackTrace();
		}
		if (hPos.length < 1) {
			return;
		}
		Position highlightPosition = convertToWidgedPosition(hPos[0]);
		if (highlightPosition == null) {
			hyperLink.resetValues();
			return;
		}
		scanner.setRange(projectionViewer.getDocument(), hPos[0].offset, hPos[0].length);
		IToken token = scanner.nextToken();
		while (!token.isEOF()) {
			if (scanner.getTokenText().equals(hyperLink.getHyperlinkText())) {
				StyleRange styleRange = getTokenStyle(token, scanner.getTokenLength(), hyperLink.getHyperlinkText(), "");
				styleRange = (StyleRange) styleRange.clone();
				styleRange.start = highlightPosition.offset;
				// TODO hoang-kim duplicate code, please refactor to method
				if (defPos != null && defPos.length > 0) {
					for (Position p : defPos) {
						if (p.offset == hPos[0].offset) {
							styleRange.background = definitionColor;
							break;
						}
					}
				}
				if (usePos != null && usePos.length > 0) {
					for (Position p : usePos) {
						if (p.offset == hPos[0].offset) {
							styleRange.background = proxyColor;
							break;
						}
					}
				}
				textWidget.setStyleRange(styleRange);
			}
			token = scanner.nextToken();
		}
		hyperLink.resetValues();
		try {
			document.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
		document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		try {
			document.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
		document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
	}

	private Position[] getPositions(IDocument document) {
		try {
			Position[] hPos = document.getPositions(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
			return hPos;
		} catch (BadPositionCategoryException e1) {
			// e1.printStackTrace();
			return null;
		}
	}

	/**
	 * Set the hyperlinkText and hyperlinkPos.
	 * 
	 * @param offset
	 * @param eo TODO hoang-kim choose meaningful name
	 */
	private boolean setHyperlinkHighlightPosition(int offset, EObject eo) {
		IDocument document = projectionViewer.getDocument();
		Position oldPos = null;
		try {
			Position[] tmp = document.getPositions(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
			if (tmp.length > 0) {
				oldPos = tmp[0];
			}
		} catch (BadPositionCategoryException e1) {
			e1.printStackTrace();
		}
		ILocationMap locationMap = textResource.getLocationMap();
		scanner.setRange(projectionViewer.getDocument(), locationMap.getCharStart(eo), locationMap.getCharEnd(eo) - locationMap.getCharStart(eo) + 1);
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
				hyperLink.setHyperlinkText(tokenText.trim());
				try {
					document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
					document.addPosition(ExtensionConstants.POSITION_CATEGORY_HYPERLINK, new Position(tokenOffset, tokenLength));
				} catch (BadLocationException e) {
					e.printStackTrace();
				} catch (BadPositionCategoryException e) {
					e.printStackTrace();
				}
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
	 * @param eo TODO hoang-kim choose meaningful name
	 */
	private void setHyperLinkJumpPosition(EObject eo) {
		IDocument document = projectionViewer.getDocument();
		if (hyperLink.getHyperlinkText().equals("")) {
			return;
		}
		ILocationMap locationMap = textResource.getLocationMap();
		int start = locationMap.getCharStart(eo);
		int length = locationMap.getCharEnd(eo) - locationMap.getCharStart(eo) + 1;
		scanner.setRange(projectionViewer.getDocument(), start, length);
		IToken token = scanner.nextToken();
		document.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
		while (!token.isEOF()) {
			String tokenText = scanner.getTokenText();
			if (hyperLink.getHyperlinkText().equals(tokenText)) {
				try {
					int tokenLength = scanner.getTokenLength();
					document.addPosition(ExtensionConstants.POSITION_CATEGORY_DESTINATION, new Position(scanner
							.getTokenOffset(), tokenLength));
				} catch (BadLocationException e) {
					e.printStackTrace();
				} catch (BadPositionCategoryException e) {
					e.printStackTrace();
				}
				return;
			}
			token = scanner.nextToken();
		}
		try {
			document.addPosition(ExtensionConstants.POSITION_CATEGORY_DESTINATION, new Position(start, length));
		} catch (BadLocationException e) {
			e.printStackTrace();
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the token position of the given text in the range of the given
	 * EObject.
	 * 
	 * @param eo TODO hoang-kim choose meaningful name
	 * @param text
	 * @return
	 */
	public int getTokenPosition(EObject eo, String text) {
		if (eo == null || text == null || text.equals("")) {
			return -1;
		}
		ITextResource textResource = (ITextResource) eo.eResource();
		ILocationMap locationMap = textResource.getLocationMap();
		scanner.setRange(projectionViewer.getDocument(), locationMap.getCharStart(eo), locationMap.getCharEnd(eo) - locationMap.getCharStart(eo) + 1);
		IToken token = scanner.nextToken();
		while (!token.isEOF()) {
			if (text.equals(scanner.getTokenText())) {
				return scanner.getTokenOffset();
			}
			token = scanner.nextToken();
		}
		return -1;
	}

	private Position convertToWidgedPosition(Position position) {
		if (position == null) {
			return null;
		}
		int startOffset = projectionViewer.modelOffset2WidgetOffset(position.offset);
		int endOffset = projectionViewer.modelOffset2WidgetOffset(position.offset + position.length);
		if (endOffset - startOffset != position.length || startOffset == -1) {
			return null;
		}
		return new Position(startOffset, endOffset - startOffset);
	}

	private StyleRange getStyleRangeAtPosition(Position position) {
		StyleRange styleRange = textWidget.getStyleRangeAtOffset(position.offset);
		if (styleRange == null) {
			styleRange = new StyleRange(position.offset, position.length, black, null);
		} else {
			styleRange.length = position.length;
		}
		return styleRange;
	}
}
