package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.ColorManager;
import org.emftext.runtime.ui.EMFTextRuntimeUIPlugin;
import org.emftext.runtime.ui.EMFTextTokenScanner;

//TODO mseifert: align this class with the EMFText coding style
public class Occurrence {

	private EMFTextTokenScanner scanner;
	private ArrayList<String> quotedTokenArray;
	private ISourceViewer viewer;
	private ITextResource tr;
	private String tText = "";
	private StyledText text;

	public String getTokenText() {
		return tText;
	}

	public Occurrence(ITextResource textresource, ISourceViewer sourceviewer, ColorManager colorManager,
			EMFTextTokenScanner aTScanner) {
		EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
		tr = textresource;
		viewer = sourceviewer;
		text = sourceviewer.getTextWidget();

		quotedTokenArray = new ArrayList<String>();
		String[] tokenNames = tr.getMetaInformation().getTokenNames();
		for (String tokenName : tokenNames) {
			if (tokenName.startsWith("'") && tokenName.endsWith("'")) {
				quotedTokenArray.add(tokenName.substring(1, tokenName.length() - 1).trim());
			}
		}

		scanner = aTScanner;
	}

	private EObject getResolvedEObject(EObject eobject) {
		return eobject.eIsProxy() ? EcoreUtil.resolve(eobject, tr) : eobject;
	}

	public EObject tryToResolve(List<EObject> eoList) {
		for (EObject e : eoList) {
			if (e.eIsProxy())
				return getResolvedEObject(e);
		}
		return null;
	}

	private int getEOLength(EObject eobject) {
		ILocationMap lm = tr.getLocationMap();
		return lm.getCharEnd(eobject) - lm.getCharStart(eobject) + 1;
	}

	public void handleOccurrenceHighlighting(BracketSet brackets) {
		// TODO because of the TextResource bug, only available if the editor is
		// not dirty.
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().isDirty())
			return;
		ProjectionViewer pviewer = null;
		if (viewer instanceof ProjectionViewer) {
			pviewer = (ProjectionViewer) viewer;
		}
		int caret = text.getCaretOffset();
		if (pviewer != null) {
			caret = pviewer.widgetOffset2ModelOffset(caret);
			if (caret == -1)
				return;
		}
		if (caret < 0 || caret >= viewer.getDocument().getLength())
			return;
		ILocationMap lm = tr.getLocationMap();
		List<EObject> eList = lm.getElementsAt(caret);

		EObject firstEO = eList.get(0);
		EObject resolvedEO = tryToResolve(eList);
		if (resolvedEO != null)
			eList = lm.getElementsAt(lm.getCharStart(resolvedEO));

		scanner.setRange(viewer.getDocument(), lm.getCharStart(firstEO), getEOLength(firstEO));
		IToken t = scanner.nextToken();
		while (!t.isEOF()) {
			if (scanner.getTokenOffset() <= caret && scanner.getTokenLength() + scanner.getTokenOffset() > caret) {
				if (scanner.getTokenText().trim().equals(""))// the rejected
																// elements
					return;
				tText = scanner.getTokenText();
				break;
			}
			t = scanner.nextToken();
		}

		if (tText == null || tText.equals(""))
			return;
		if ((resolvedEO == null && quotedTokenArray.contains(tText))
				|| (resolvedEO == null && eList.get(0).eResource() == null) || brackets.isBracket(tText)) {
			tText = "";
			return;
		}
		try {
			setHighlightingPositions(resolvedEO, eList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setHighlightingPositions(EObject eo, List<EObject> eList) {
		IDocument doc = viewer.getDocument();
		ILocationMap lm = tr.getLocationMap();
		IToken t;
		int defPosition = -1;
		boolean isNull = eo == null;
		if (isNull)
			eo = eList.get(0);
		if (eo.eResource().equals(tr)) {
			scanner.setRange(viewer.getDocument(), lm.getCharStart(eo), getEOLength(eo));
			t = scanner.nextToken();
			while (!t.isEOF()) {
				String tokenText = scanner.getTokenText();
				if (tokenText.equals(tText)) {
					doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_DEF);
					try {
						defPosition = scanner.getTokenOffset();
						doc.addPosition(ExtensionConstants.POSITION_CATEGORY_DEF, new Position(
								scanner.getTokenOffset(), scanner.getTokenLength()));
					} catch (BadLocationException e) {
						e.printStackTrace();
					} catch (BadPositionCategoryException e) {
						e.printStackTrace();
					}
					break;
				}
				t = scanner.nextToken();
			}
		}
		scanner.setRange(viewer.getDocument(), 0, viewer.getDocument().getLength());
		EObject occEO;
		t = scanner.nextToken();
		doc.addPositionCategory(ExtensionConstants.POSITION_CATEGORY_USE);
		while (!t.isEOF()) {
			String tokenText = scanner.getTokenText();
			if (tokenText != null && tokenText.equals(tText) && scanner.getTokenOffset() != defPosition) {
				occEO = tryToResolve(lm.getElementsAt(scanner.getTokenOffset()));
				if (occEO != null)
					if ((isNull && eList.contains(occEO)) || !isNull && eo.equals(occEO)) {
						try {
							doc.addPosition(ExtensionConstants.POSITION_CATEGORY_USE, new Position(scanner
									.getTokenOffset(), scanner.getTokenLength()));
						} catch (BadLocationException e) {
							e.printStackTrace();
						} catch (BadPositionCategoryException e) {
							e.printStackTrace();
						}
					}
			}
			t = scanner.nextToken();
		}
	}

	public boolean isQuotedToken(String tokenText) {
		return quotedTokenArray.contains(tokenText);
	}
}
