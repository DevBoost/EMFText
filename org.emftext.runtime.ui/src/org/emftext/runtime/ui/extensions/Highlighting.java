package org.emftext.runtime.ui.extensions;

import java.util.HashMap;
import java.util.List;

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

//TODO mseifert: align this class with the EMFText coding style
public class Highlighting {

	private EMFTextTokenScanner scanner;
	private Color defColor;
	private Color proxyColor;
	private Color bracketColor;
	private Color hyperlinkColor;
	private Color black;
	private HashMap<String, StyleRange> srBuffer = new HashMap<String, StyleRange>();
	private final String BRACKET_HIGHLIGHT = "bh_";
	private final String DEFINITION_HIGHLIGHT = "def_";
	private final String PROXY_HIGHLIGHT = "proxy_";
	private StyleRange lastSR;
	private StyledText text;
	private IPreferenceStore store;
	private ProjectionViewer pviewer;
	private ITextResource tr;
	
	private Occurrence occurrence;
	private Brackets brackets;
	private Hyperlink hLink;
	
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

	public Highlighting(ITextResource textresource, ProjectionViewer sourceviewer, ColorManager colorManager) {
		store = EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
		tr = textresource;
		text = sourceviewer.getTextWidget();
		pviewer = sourceviewer;
		scanner = new EMFTextTokenScanner(textresource, colorManager);
		occurrence = new Occurrence(tr, sourceviewer, colorManager, scanner);
		brackets = new Brackets(sourceviewer, tr.getURI().fileExtension());

		defColor = colorManager.getColor(PreferenceConverter.getColor(store,
				PreferenceConstants.EDITOR_DEFINITION_COLOR));
		proxyColor = colorManager.getColor(PreferenceConverter.getColor(store,
				PreferenceConstants.EDITOR_PROXY_COLOR));
		bracketColor = colorManager.getColor(PreferenceConverter.getColor(
				store, PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR));
		black = colorManager.getColor(new RGB(0, 0, 0));
		hyperlinkColor = colorManager.getColor(PreferenceConverter.getColor(
				store, PreferenceConstants.EDITOR_HYPERLINK_COLOR));

		hLink = new Hyperlink();

		addListeners();
		
	}

	private void addListeners() {
		text.addMouseMoveListener(new MouseMoveListener() {

			public void mouseMove(MouseEvent e) {

				if (e.stateMask == SWT.CTRL) {
					//TODO because of the TextResource bug, only available if the editor is not dirty.
					if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().isDirty())
						return;
					int offset;
					try {
						offset = text.getOffsetAtLocation(new Point(e.x, e.y));
					} catch (Exception e1) {
						resetHyperlinkHighlighting();
						return;
					}
					ILocationMap lm = tr.getLocationMap();
					offset = pviewer.widgetOffset2ModelOffset(offset);
					List<EObject> eList = lm.getElementsAt(offset);
					if (eList == null) {
						resetHyperlinkHighlighting();
						return;
					}
					EObject firstEO = eList.get(0);
					EObject eo = occurrence.tryToResolve(eList);

					if (eo != null) {// is proxy
						if (!setHyperlinkHighlightPosition(offset, firstEO))
							return;
						setHyperlinkHighlighting();
						if (!tr.equals(eo.eResource()))
							hLink.setEObject(eo);
						setHyperLinkJumpPosition(eo);
					} else {
						resetHyperlinkHighlighting();
					}
				} else {
					resetHyperlinkHighlighting();
				}
			}
		});
		text.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {// jump to declaration
				IDocument doc = pviewer.getDocument();
				Position[] hPos = null;
				try {
					hPos = doc
							.getPositions(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
				} catch (BadPositionCategoryException e1) {
					e1.printStackTrace();
				}
				Position jumpPos = null;
				if (hPos != null && hPos.length > 0)
					jumpPos = convertToWidgedPosition(hPos[0]);
				if (e.stateMask == SWT.CTRL && jumpPos != null) {
					text.setSelection(jumpPos.offset);
					resetHyperlinkHighlighting();
					return;
				}
				if (e.stateMask == SWT.CTRL && hLink.containsEObject()) {
					hLink.open();
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
		text.addKeyListener(hl);
		text.addVerifyListener(hl);
	}

	private void setHighlighting() {
		IDocument doc = pviewer.getDocument();
		boolean isHighlightBrackets = store
				.getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		boolean isHighlightOccurrence = true;
		if (text.getCaretOffset() >= text.getCharCount())
			isHighlightOccurrence = false;
		if (isHighlightBrackets)
			brackets.matchingBrackets();

		if (isHighlightOccurrence)
			occurrence.handleOccurrenceHighlighting(brackets);
		StyleRange sr = null;

		try {
			Position[] pos = doc
					.getPositions(ExtensionConstants.POSITION_CATEGORY_BRACKET);
			for (Position p : pos) {
				Position tmpPostion = convertToWidgedPosition(p);
				if (tmpPostion != null) {
					sr = getStyleRangeAtPosition(tmpPostion);
					sr.borderStyle = SWT.BORDER_SOLID;
					sr.borderColor = bracketColor;
					if (sr.foreground == null)
						sr.foreground = black;
					text.setStyleRange(sr);
				}
			}
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
			try {
				Position[] pos = doc
						.getPositions(ExtensionConstants.POSITION_CATEGORY_DEF);
				for (Position p : pos) {
					Position tmpPostion = convertToWidgedPosition(p);
					if (tmpPostion != null) {
						sr = getStyleRangeAtPosition(tmpPostion);
						if (sr.foreground == null)
							sr.foreground = black;
						lastSR = (StyleRange) sr.clone();
						sr.background = defColor;
						text.setStyleRange(sr);
					}
				}
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}

			try {
				Position[] pos = doc
						.getPositions(ExtensionConstants.POSITION_CATEGORY_USE);
				if (lastSR == null && pos.length > 0) {
					sr = getStyleRangeAtPosition(pos[0]);
					if (sr.foreground == null)
						sr.foreground = black;
					lastSR = (StyleRange) sr.clone();
				}
				if (sr == null) {
					sr = (StyleRange) lastSR.clone();
				}
				sr.background = proxyColor;
				for (Position p : pos) {
					Position tmpPostion = convertToWidgedPosition(p);
					if (tmpPostion != null) {
						sr.start = tmpPostion.offset;
						text.setStyleRange(sr);
					}
				}
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}
		
	}

	private void removeHighlighting() {
		IDocument doc = pviewer.getDocument();
		boolean isHighlightBrackets = store
				.getBoolean(PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX);
		
		StyleRange sr;

		if (isHighlightBrackets) {
			try {
				Position[] pos = doc
						.getPositions(ExtensionConstants.POSITION_CATEGORY_BRACKET);
				for (Position p : pos) {
					Position tmpPostion = convertToWidgedPosition(p);
					if (tmpPostion != null) {
						sr = getStyleRangeAtPosition(tmpPostion);
						sr.borderStyle = SWT.NONE;
						sr.borderColor = null;
						sr.background=null;
						text.setStyleRange(sr);
					}
				}
				doc
						.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_BRACKET);
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}
			doc
					.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_BRACKET);
		}
			try {
				Position[] pos = doc
						.getPositions(ExtensionConstants.POSITION_CATEGORY_DEF);
				for (Position p : pos) {
					Position tmpPostion = convertToWidgedPosition(p);
					if (tmpPostion != null) {
						lastSR.start = tmpPostion.offset;
						text.setStyleRange(lastSR);
					}
				}
				doc
						.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_DEF);
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}
			doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DEF);
			try {
				Position[] pos = doc
						.getPositions(ExtensionConstants.POSITION_CATEGORY_USE);
				for (Position p : pos) {
					Position tmpPostion = convertToWidgedPosition(p);
					if (tmpPostion != null) {
						lastSR.start = tmpPostion.offset;
						text.setStyleRange(lastSR);
					}
				}
				doc
						.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_USE);
			} catch (BadPositionCategoryException e) {
				e.printStackTrace();
			}
			doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_USE);
			lastSR=null;
	}

	public void resetBrackets() {
		brackets.resetBrackets();
	}

	private StyleRange getTokenStyle(IToken t, int length, String tokenName,
			String tokenStyle) {
		// TODO
		int tokenType = 0;
		StyleRange sr = srBuffer.get(tokenStyle + tokenType);
		if (sr != null) {
			if (!occurrence.isQuotedToken(tokenName))
				sr.length = length;
			return sr;
		}
		TextAttribute ta = null;
		if (t.getData() instanceof TextAttribute)
			ta = (TextAttribute) t.getData();
		if (ta == null) {
			sr = new StyleRange(0, length, null, null);
			setHighlightStyle(sr, tokenStyle);
			if (!occurrence.isQuotedToken(tokenName))
				sr.length = length;
			srBuffer.put(tokenStyle + tokenType, sr);
			return sr;
		}

		int style = ta.getStyle();
		int fontStyle = style & (SWT.ITALIC | SWT.BOLD | SWT.NORMAL);
		sr = new StyleRange(-1, length, ta.getForeground(), ta.getBackground(),
				fontStyle);
		sr.strikeout = (style & TextAttribute.STRIKETHROUGH) != 0;
		sr.underline = (style & TextAttribute.UNDERLINE) != 0;
		setHighlightStyle(sr, tokenStyle);
		if (!occurrence.isQuotedToken(tokenName))
			sr.length = length;
		srBuffer.put(tokenStyle + tokenType, sr);
		return sr;
	}

	private void setHighlightStyle(StyleRange sr, String tokenStyle) {
		if (tokenStyle.equals(BRACKET_HIGHLIGHT)) {
			sr.borderStyle = SWT.BORDER_SOLID;
			sr.borderColor = bracketColor;
			return;
		}
		if (tokenStyle.equals(DEFINITION_HIGHLIGHT)) {
			sr.background = defColor;
			return;
		}
		if (tokenStyle.equals(PROXY_HIGHLIGHT))
			sr.background = proxyColor;
	}

	public void clearSRBuffer() {
		srBuffer.clear();
	}

	private void setHyperlinkHighlighting() {
		IDocument doc = pviewer.getDocument();
		Position[] tmpPos;
		tmpPos = getPositions(doc);
		if (tmpPos.length < 1)
			return;
		Position hPos = convertToWidgedPosition(tmpPos[0]);
		if (hPos == null)
			return;
		StyleRange sr = getStyleRangeAtPosition(hPos);
		sr.underline = true;
		sr.underlineColor = hyperlinkColor;
		sr.foreground = hyperlinkColor;
		text.setStyleRange(sr);
	}

	private void resetHyperlinkHighlighting() {
		IDocument doc = pviewer.getDocument();
		Position[] hPos = null;
		hPos = getPositions(doc);
		if (hPos == null) {
			return;
		}
		Position[] defPos = null;
		try {
			defPos = doc.getPositions(ExtensionConstants.POSITION_CATEGORY_DEF);
		} catch (BadPositionCategoryException e1) {
			e1.printStackTrace();
		}
		Position[] usePos = null;
		try {
			usePos = doc.getPositions(ExtensionConstants.POSITION_CATEGORY_USE);
		} catch (BadPositionCategoryException e1) {
			e1.printStackTrace();
		}
		if (hPos.length < 1)
			return;
		Position highlightPosition = convertToWidgedPosition(hPos[0]);
		if (highlightPosition == null) {
			hLink.resetValues();
			return;
		}
		scanner.setRange(pviewer.getDocument(), hPos[0].offset, hPos[0].length);
		IToken t = scanner.nextToken();
		while (!t.isEOF()) {
			if (scanner.getTokenText().equals(hLink.getHyperlinkText())) {
				StyleRange sr = getTokenStyle(t, scanner.getTokenLength(),
						hLink.getHyperlinkText(), "");
				sr = (StyleRange) sr.clone();
				sr.start = highlightPosition.offset;
				if (defPos != null && defPos.length > 0) {
					for (Position p : defPos) {
						if (p.offset == hPos[0].offset) {
							sr.background = defColor;
							break;
						}
					}
				}
				if (usePos != null && usePos.length > 0) {
					for (Position p : usePos) {
						if (p.offset == hPos[0].offset) {
							sr.background = proxyColor;
							break;
						}
					}
				}
				text.setStyleRange(sr);
			}
			t = scanner.nextToken();
		}
		hLink.resetValues();
		try {
			doc
					.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
		doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
		try {
			doc
					.removePositionCategory(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
		} catch (BadPositionCategoryException e) {
			e.printStackTrace();
		}
		doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
	}

	private Position[] getPositions(IDocument doc) {
		try {
			Position[] hPos = doc
					.getPositions(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
			return hPos;
		} catch (BadPositionCategoryException e1) {
			//e1.printStackTrace();
			return null;
		}
	}

	/**
	 * Set the hyperlinkText and hyperlinkPos.
	 * 
	 * @param offset
	 * @param eo
	 */
	private boolean setHyperlinkHighlightPosition(int offset, EObject eo) {
		IDocument doc = pviewer.getDocument();
		Position oldPos = null;
		try {
			Position[] tmp = doc
					.getPositions(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
			if (tmp.length > 0)
				oldPos = tmp[0];
		} catch (BadPositionCategoryException e1) {
			e1.printStackTrace();
		}
		ILocationMap lm = tr.getLocationMap();
		scanner.setRange(pviewer.getDocument(), lm.getCharStart(eo), lm
				.getCharEnd(eo)
				- lm.getCharStart(eo) + 1);
		IToken t = scanner.nextToken();
		while (!t.isEOF()) {
			if (scanner.getTokenOffset() <= offset
					&& scanner.getTokenLength() + scanner.getTokenOffset() > offset) {
				if (oldPos != null)
					if (oldPos.offset == scanner.getTokenOffset())
						return false;
					else
						resetHyperlinkHighlighting();
				hLink.setHyperlinkText(scanner.getTokenText().trim());
				try {
					doc
							.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_HYPERLINK);
					doc.addPosition(
							ExtensionConstants.POSITION_CATEGORY_HYPERLINK,
							new Position(scanner.getTokenOffset(), scanner
									.getTokenLength()));
				} catch (BadLocationException e) {
					e.printStackTrace();
				} catch (BadPositionCategoryException e) {
					e.printStackTrace();
				}
				return true;
			}
			t = scanner.nextToken();
		}
		hLink.resetValues();
		return false;
	}

	/**
	 * Set the hyperlinkJumpPos
	 * 
	 * @param eo
	 */
	private void setHyperLinkJumpPosition(EObject eo) {
		IDocument doc = pviewer.getDocument();
		if (hLink.getHyperlinkText().equals(""))
			return;
		ILocationMap lm = tr.getLocationMap();
		int start = lm.getCharStart(eo);
		int length = lm.getCharEnd(eo) - lm.getCharStart(eo) + 1;
		scanner.setRange(pviewer.getDocument(), start, length);
		IToken t = scanner.nextToken();
		doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DESTINATION);
		while (!t.isEOF()) {
			if (hLink.getHyperlinkText().equals(scanner.getTokenText())) {
				try {
					doc.addPosition(
							ExtensionConstants.POSITION_CATEGORY_DESTINATION,
							new Position(scanner.getTokenOffset(), scanner
									.getTokenLength()));
				} catch (BadLocationException e) {
					e.printStackTrace();
				} catch (BadPositionCategoryException e) {
					e.printStackTrace();
				}
				return;
			}
			t = scanner.nextToken();
		}
		try {
			doc.addPosition(ExtensionConstants.POSITION_CATEGORY_DESTINATION,
					new Position(start, length));
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
	 * @param eo
	 * @param text
	 * @return
	 */
	public int getTokenPosition(EObject eo, String text) {
		if (eo == null || text == null || text.equals(""))
			return -1;
		ITextResource rs = (ITextResource) eo.eResource();
		ILocationMap lm = rs.getLocationMap();
		scanner.setRange(pviewer.getDocument(), lm.getCharStart(eo), lm
				.getCharEnd(eo)
				- lm.getCharStart(eo) + 1);
		IToken t = scanner.nextToken();
		while (!t.isEOF()) {
			if (text.equals(scanner.getTokenText())) {
				return scanner.getTokenOffset();
			}
			t = scanner.nextToken();
		}
		return -1;
	}

	private Position convertToWidgedPosition(Position p) {
		if (p == null)
			return null;
		int startoffset = pviewer.modelOffset2WidgetOffset(p.offset);
		int endoffset = pviewer.modelOffset2WidgetOffset(p.offset + p.length);
		if (endoffset - startoffset != p.length || startoffset == -1)
			return null;
		return new Position(startoffset, endoffset - startoffset);
	}

	private StyleRange getStyleRangeAtPosition(Position p) {
		StyleRange sr = text.getStyleRangeAtOffset(p.offset);
		if (sr == null) {
			sr = new StyleRange(p.offset, p.length, black, null);
		} else {
			sr.length = p.length;
		}
		return sr;
	}
}
