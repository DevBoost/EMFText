package org.emftext.runtime.ui.extensions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IDocument;
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

//TODO hoang-kim add documentation
public class Occurrence {
	
	private final static PositionHelper positionHelper = new PositionHelper();

	private EMFTextTokenScanner tokenScanner;
	private List<String> quotedTokenArray;
	private ISourceViewer sourceViewer;
	private ITextResource textResource;
	private String tokenText = "";
	private StyledText textWidget;

	public String getTokenText() {
		return tokenText;
	}

	public Occurrence(ITextResource textResource, ISourceViewer sourceViewer, ColorManager colorManager,
			EMFTextTokenScanner tokenScanner) {
		// TODO hoang-kim is this call needed?
		EMFTextRuntimeUIPlugin.getDefault().getPreferenceStore();
		this.textResource = textResource;
		this.sourceViewer = sourceViewer;
		this.textWidget = sourceViewer.getTextWidget();

		quotedTokenArray = new ArrayList<String>();
		String[] tokenNames = textResource.getMetaInformation().getTokenNames();
		for (String tokenName : tokenNames) {
			// TODO this is ANTLR specific
			if (tokenName.startsWith("'") && tokenName.endsWith("'")) {
				quotedTokenArray.add(tokenName.substring(1, tokenName.length() - 1).trim());
			}
		}

		this.tokenScanner = tokenScanner;
	}

	private EObject getResolvedEObject(EObject eObject) {
		return eObject.eIsProxy() ? EcoreUtil.resolve(eObject, textResource) : eObject;
	}

	public EObject tryToResolve(List<EObject> objects) {
		for (EObject object : objects) {
			if (object.eIsProxy()) {
				return getResolvedEObject(object);
			}
		}
		return null;
	}

	private int getLength(EObject eObject) {
		ILocationMap locationMap = textResource.getLocationMap();
		return locationMap.getCharEnd(eObject) - locationMap.getCharStart(eObject) + 1;
	}

	public void handleOccurrenceHighlighting(BracketSet bracketSet) {
		// TODO because of the TextResource bug, only available if the editor is
		// not dirty.
		// TODO remove this once the background parsing is active
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().isDirty()) {
			return;
		}
		ProjectionViewer projectionViewer = null;
		if (sourceViewer instanceof ProjectionViewer) {
			projectionViewer = (ProjectionViewer) sourceViewer;
		}
		int caretOffset = textWidget.getCaretOffset();
		if (projectionViewer != null) {
			caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
			if (caretOffset == -1) {
				return;
			}
		}
		if (caretOffset < 0 || caretOffset >= sourceViewer.getDocument().getLength()) {
			return;
		}
		ILocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(caretOffset);

		EObject firstElementAtOffset = elementsAtOffset.get(0);
		EObject resolvedEO = tryToResolve(elementsAtOffset);
		if (resolvedEO != null) {
			elementsAtOffset = locationMap.getElementsAt(locationMap.getCharStart(resolvedEO));
		}

		tokenScanner.setRange(sourceViewer.getDocument(), locationMap.getCharStart(firstElementAtOffset), getLength(firstElementAtOffset));
		IToken token = tokenScanner.nextToken();
		while (!token.isEOF()) {
			int tokenOffset = tokenScanner.getTokenOffset();
			int tokenLength = tokenScanner.getTokenLength();
			String text = tokenScanner.getTokenText();
			if (tokenOffset <= caretOffset && tokenLength + tokenOffset > caretOffset) {
				if (text.trim().equals("")) {
					// the rejected elements
					return;
				}
				tokenText = text;
				break;
			}
			token = tokenScanner.nextToken();
		}

		if (tokenText == null || tokenText.equals("")) {
			return;
		}
		if ((resolvedEO == null && quotedTokenArray.contains(tokenText))
				|| (resolvedEO == null && elementsAtOffset.get(0).eResource() == null) || bracketSet.isBracket(tokenText)) {
			tokenText = "";
			return;
		}
		try {
			setHighlightingPositions(resolvedEO, elementsAtOffset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO hoang-kim given meaningful names to the parameters
	private void setHighlightingPositions(EObject eo, List<EObject> eList) {
		IDocument document = sourceViewer.getDocument();
		ILocationMap locationMap = textResource.getLocationMap();
		IToken token;
		int defPosition = -1;
		boolean isNull = eo == null;
		if (isNull) {
			eo = eList.get(0);
		}
		Resource resource = eo.eResource();
		// TODO hoang-kim is this correct?
		if (resource == null) {
			return;
		}
		if (resource.equals(textResource)) {
			tokenScanner.setRange(sourceViewer.getDocument(), locationMap.getCharStart(eo), getLength(eo));
			token = tokenScanner.nextToken();
			while (!token.isEOF()) {
				String text = tokenScanner.getTokenText();
				if (text.equals(tokenText)) {
					defPosition = tokenScanner.getTokenOffset();
					addPosition(document, ExtensionConstants.POSITION_CATEGORY_DEF);
					break;
				}
				token = tokenScanner.nextToken();
			}
		}
		tokenScanner.setRange(sourceViewer.getDocument(), 0, sourceViewer.getDocument().getLength());
		EObject occEO;
		token = tokenScanner.nextToken();
		while (!token.isEOF()) {
			String text = tokenScanner.getTokenText();
			if (text != null && text.equals(tokenText) && tokenScanner.getTokenOffset() != defPosition) {
				occEO = tryToResolve(locationMap.getElementsAt(tokenScanner.getTokenOffset()));
				if (occEO != null) {
					if ((isNull && eList.contains(occEO)) || !isNull && eo.equals(occEO)) {
						addPosition(document, ExtensionConstants.POSITION_CATEGORY_USE);
					}
				}
			}
			token = tokenScanner.nextToken();
		}
	}

	private void addPosition(IDocument document, String positionCategory) {
		int tokenOffset = tokenScanner.getTokenOffset();
		int tokenLength = tokenScanner.getTokenLength();
		positionHelper.addPosition(document, positionCategory, tokenOffset, tokenLength);
	}

	public boolean isQuotedToken(String tokenText) {
		return quotedTokenArray.contains(tokenText);
	}
}
