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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.ui.PlatformUI;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.EMFTextTokenScanner;

/**
 * This class finds the positions to highlight and adds them to the document.
 * 
 * @see Position
 * @see IDocument
 * @author Tan-Ky Hoang-Kim
 * 
 */
public class Occurrence {

	private final static PositionHelper positionHelper = new PositionHelper();

	private EMFTextTokenScanner tokenScanner;
	private List<String> quotedTokenArray;
	private ProjectionViewer projectionViewer;
	private ITextResource textResource;
	private String tokenText = "";

	private Region tokenRegion;

	private boolean isPositionsChanged = true;

	/**
	 * Creates the Occurrence class to find position to highlight.
	 * 
	 * @param textResource
	 *            the text resource for location.
	 * @param sourceViewer
	 *            the source viewer for the text
	 * @param tokenScanner
	 *            the token scanner helps to find the searched tokens
	 */
	public Occurrence(ITextResource textResource,
			ProjectionViewer sourceViewer, EMFTextTokenScanner tokenScanner) {
		this.textResource = textResource;
		this.projectionViewer = sourceViewer;

		quotedTokenArray = new ArrayList<String>();
		String[] tokenNames = textResource.getMetaInformation().getTokenNames();
		for (String tokenName : tokenNames) {
			// TODO this is ANTLR specific
			if (tokenName.startsWith("'") && tokenName.endsWith("'")) {
				quotedTokenArray.add(tokenName.substring(1,
						tokenName.length() - 1).trim());
			}
		}
		this.tokenScanner = tokenScanner;
		tokenRegion = new Region(-1, 0);
	}

	private EObject getResolvedEObject(EObject eObject) {
		return eObject.eIsProxy() ? EcoreUtil.resolve(eObject, textResource)
				: eObject;
	}

	/**
	 * Tries to resolve the first proxy object in a list.
	 * 
	 * @param objects
	 *            the <code>EObject</code>s at the text caret
	 * @return the resolved <code>EObject</code> of the first proxy
	 *         <code>EObject</code> in a list. If there are none returns
	 *         <code>null</code>
	 */
	public EObject tryToResolve(List<EObject> objects) {
		for (EObject object : objects) {
			if (object.eIsProxy()) {
				return getResolvedEObject(object);
			}
		}
		return null;
	}
	
	/**
	 * @return the eObject at the current cursor position.
	 */
	public EObject getEObjectAtCurrentPosition() {
		StyledText textWidget = projectionViewer.getTextWidget();
		int caretOffset = textWidget.getCaretOffset();
		caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
		ILocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(caretOffset);

		if (elementsAtOffset == null || elementsAtOffset.isEmpty()) {
			return null;
		}
		for(EObject cand : elementsAtOffset) {
			if(cand.eIsProxy()) {
				cand = getResolvedEObject(cand);
			}
			//take an element that is actually contained in a resource
			//the location map might reference elements that were removed by a post processor
			if (cand.eResource() != null) {
				return cand;
			}
		}
		return null;
	}

	/**
	 * Gets the token text at the caret.
	 * 
	 * @return the token text
	 */
	public String getTokenText() {
		return tokenText;
	}

	private int getLength(EObject eObject) {
		ILocationMap locationMap = textResource.getLocationMap();
		return locationMap.getCharEnd(eObject)
				- locationMap.getCharStart(eObject) + 1;
	}

	/**
	 * Finds the positions of the occurrences which will be highlighted. The
	 * brackets and the key words should not be highlighted.
	 * 
	 * @param bracketSet
	 *            the set of brackets which have to be ignored.
	 */
	public void handleOccurrenceHighlighting(BracketSet bracketSet) {
		// TODO remove this once the background parsing is active
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().getActiveEditor().isDirty()) {
			return;
		}

		StyledText textWidget = projectionViewer.getTextWidget();
		int caretOffset = textWidget.getCaretOffset();
		caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
		if (caretOffset < 0
				|| caretOffset >= projectionViewer.getDocument().getLength()) {
			return;
		}
		if (caretOffset >= tokenRegion.getOffset()
				&& caretOffset <= tokenRegion.getOffset()
						+ tokenRegion.getLength()) {
			isPositionsChanged = false;
			return;
		}
		tokenRegion = new Region(-1,0);
		ILocationMap locationMap = textResource.getLocationMap();
		List<EObject> elementsAtOffset = locationMap.getElementsAt(caretOffset);

		if (elementsAtOffset == null || elementsAtOffset.size() < 1) {
			return;
		}
		EObject firstElementAtOffset = elementsAtOffset.get(0);
		EObject resolvedEO = tryToResolve(elementsAtOffset);
		if (resolvedEO != null) {
			elementsAtOffset = locationMap.getElementsAt(locationMap
					.getCharStart(resolvedEO));
		}

		tokenScanner.setRange(projectionViewer.getDocument(), locationMap
				.getCharStart(firstElementAtOffset),
				getLength(firstElementAtOffset));
		IToken token = tokenScanner.nextToken();
		while (!token.isEOF()) {
			int tokenOffset = tokenScanner.getTokenOffset();
			int tokenLength = tokenScanner.getTokenLength();
			String text = tokenScanner.getTokenText();
			if (tokenOffset <= caretOffset
					&& tokenLength + tokenOffset > caretOffset) {
				if (text.trim().equals("")) {
					// the rejected elements
					return;
				}
				tokenText = text;
				tokenRegion = new Region(tokenOffset, tokenLength);
				isPositionsChanged = true;
				break;
			}
			token = tokenScanner.nextToken();
		}

		if (tokenText == null || tokenText.equals("")) {
			return;
		}
		if ((resolvedEO == null && quotedTokenArray.contains(tokenText))
				|| (resolvedEO == null && elementsAtOffset.get(0).eResource() == null)
				|| bracketSet.isBracket(tokenText)) {
			tokenText = "";
			return;
		}
		try {
			setHighlightingPositions(resolvedEO, elementsAtOffset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setHighlightingPositions(EObject definitionElement,
			List<EObject> elementsAtDefinition) {
		IDocument document = projectionViewer.getDocument();
		ILocationMap locationMap = textResource.getLocationMap();
		IToken token;
		int defPosition = -1;
		boolean isNull = definitionElement == null;
		if (isNull) {
			definitionElement = elementsAtDefinition.get(0);
		}
		Resource resource = definitionElement.eResource();
		if (resource == null) {
			return;
		}
		if (resource.equals(textResource)) {
			tokenScanner.setRange(projectionViewer.getDocument(), locationMap
					.getCharStart(definitionElement),
					getLength(definitionElement));
			token = tokenScanner.nextToken();
			while (!token.isEOF()) {
				String text = tokenScanner.getTokenText();
				if (text.equals(tokenText)) {
					defPosition = tokenScanner.getTokenOffset();
					addPosition(document,
							ExtensionConstants.PositionCategory.DEFINTION
									.toString());
					break;
				}
				token = tokenScanner.nextToken();
			}
		}
		tokenScanner.setRange(projectionViewer.getDocument(), 0,
				projectionViewer.getDocument().getLength());
		EObject occEO;
		token = tokenScanner.nextToken();
		while (!token.isEOF()) {
			String text = tokenScanner.getTokenText();
			if (text != null && text.equals(tokenText)
					&& tokenScanner.getTokenOffset() != defPosition) {
				occEO = tryToResolve(locationMap.getElementsAt(tokenScanner
						.getTokenOffset()));
				if (occEO != null) {
					if ((isNull && elementsAtDefinition.contains(occEO))
							|| !isNull && definitionElement.equals(occEO)) {
						addPosition(document,
								ExtensionConstants.PositionCategory.PROXY
										.toString());
					}
				}
			}
			token = tokenScanner.nextToken();
		}
	}

	private void addPosition(IDocument document, String positionCategory) {
		int tokenOffset = tokenScanner.getTokenOffset();
		int tokenLength = tokenScanner.getTokenLength();
		positionHelper.addPosition(document, positionCategory, tokenOffset,
				tokenLength);
	}

	
	/**
	 * Check whether it is time to remove the occurrence highlighting.
	 * 
	 * @return <code>true</code> if the caret changed the token.
	 */
	public boolean isToRemoveHighlighting() {
		StyledText textWidget = projectionViewer.getTextWidget();
		int caretOffset = textWidget.getCaretOffset();
		caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
		if (caretOffset >= tokenRegion.getOffset()
				&& caretOffset <= tokenRegion.getOffset()
						+ tokenRegion.getLength()) {
			return false;
		}
		return true;
	}

	/**
	 * Check whether the token region changed to decide to highlight or not.
	 * @return <code>true</code> if the occurrences should be highlighted
	 */
	public boolean isPositionsChanged() {
		return isPositionsChanged ;
	}
	
	/**
	 * Resets the token region to enable remove highlighting if the text is changing.
	 */
	public void resetTokenRegion(){
		tokenRegion = new Region(-1,0);
	}

}
