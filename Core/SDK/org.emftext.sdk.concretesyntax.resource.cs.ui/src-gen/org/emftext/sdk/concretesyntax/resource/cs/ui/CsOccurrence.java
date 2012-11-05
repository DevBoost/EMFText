/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * This class finds the positions to highlight and adds them to the document.
 */
public class CsOccurrence {
	
	public final static String OCCURRENCE_ANNOTATION_ID = "org.emftext.sdk.concretesyntax.resource.cs.ui.occurences";
	public final static String DECLARATION_ANNOTATION_ID = "org.emftext.sdk.concretesyntax.resource.cs.ui.occurences.declaration";
	
	private final static org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionHelper positionHelper = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionHelper();
	
	private org.emftext.sdk.concretesyntax.resource.cs.ui.ICsTokenScanner tokenScanner;
	private java.util.List<String> quotedTokenArray;
	private org.eclipse.jface.text.source.projection.ProjectionViewer projectionViewer;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource textResource;
	private String tokenText = "";
	private org.eclipse.jface.text.Region tokenRegion;
	
	/**
	 * Creates the Occurrence class to find position to highlight.
	 * 
	 * @param textResource the text resource for location
	 * @param sourceViewer the source viewer for the text
	 * @param tokenScanner the token scanner helps to find the searched tokens
	 */
	public CsOccurrence(org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource textResource, org.eclipse.jface.text.source.projection.ProjectionViewer sourceViewer, org.emftext.sdk.concretesyntax.resource.cs.ui.ICsTokenScanner tokenScanner) {
		this.textResource = textResource;
		this.projectionViewer = sourceViewer;
		
		quotedTokenArray = new java.util.ArrayList<String>();
		String[] tokenNames = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().getTokenNames();
		for (String tokenName : tokenNames) {
			if (tokenName.startsWith("'") && tokenName.endsWith("'")) {
				quotedTokenArray.add(tokenName.substring(1, tokenName.length() - 1).trim());
			}
		}
		this.tokenScanner = tokenScanner;
		tokenRegion = new org.eclipse.jface.text.Region(-1, 0);
	}
	
	private org.eclipse.emf.ecore.EObject getResolvedEObject(org.eclipse.emf.ecore.EObject eObject) {
		return eObject.eIsProxy() ? org.eclipse.emf.ecore.util.EcoreUtil.resolve(eObject, textResource) : eObject;
	}
	
	/**
	 * Tries to resolve the first proxy object in a list.
	 * 
	 * @param objects the <code>EObject</code>s at the text caret
	 * 
	 * @return the resolved <code>EObject</code> of the first proxy
	 * <code>EObject</code> in a list. If there are none returns <code>null</code>
	 */
	public org.eclipse.emf.ecore.EObject tryToResolve(java.util.List<org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			if (object.eIsProxy()) {
				return getResolvedEObject(object);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @return the eObject at the current cursor position.
	 */
	public org.eclipse.emf.ecore.EObject getEObjectAtCurrentPosition() {
		org.eclipse.swt.custom.StyledText textWidget = projectionViewer.getTextWidget();
		if (textWidget == null) {
			return null;
		}
		int caretOffset = textWidget.getCaretOffset();
		caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
		if (textResource == null) {
			return null;
		}
		org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = textResource.getLocationMap();
		java.util.List<org.eclipse.emf.ecore.EObject> elementsAtOffset = locationMap.getElementsAt(caretOffset);
		
		if (elementsAtOffset == null || elementsAtOffset.isEmpty()) {
			return null;
		}
		for (org.eclipse.emf.ecore.EObject candidate : elementsAtOffset) {
			if (candidate.eIsProxy()) {
				candidate = getResolvedEObject(candidate);
			}
			// Only accept elements that are actually contained in a resource. The location
			// map might reference elements that were removed by a post processor and which
			// are therefore not part of the resource anymore.
			if (candidate.eResource() != null) {
				return candidate;
			}
		}
		return null;
	}
	
	/**
	 * Returns the token text at the caret.
	 * 
	 * @return the token text
	 */
	public String getTokenText() {
		return tokenText;
	}
	
	private int getLength(org.eclipse.emf.ecore.EObject eObject) {
		org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = textResource.getLocationMap();
		return locationMap.getCharEnd(eObject) - locationMap.getCharStart(eObject) + 1;
	}
	
	/**
	 * Finds the positions of the occurrences which will be highlighted. The brackets
	 * and the key words should not be highlighted.
	 * 
	 * @param bracketSet the set of brackets which have to be ignored.
	 */
	public void handleOccurrenceHighlighting(org.emftext.sdk.concretesyntax.resource.cs.ui.CsBracketSet bracketSet) {
		if (textResource == null) {
			return;
		}
		org.eclipse.swt.custom.StyledText textWidget = projectionViewer.getTextWidget();
		int caretOffset = textWidget.getCaretOffset();
		caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
		org.eclipse.jface.text.IDocument document = projectionViewer.getDocument();
		if (caretOffset < 0 || caretOffset >= document.getLength()) {
			return;
		}
		int tokenRegionOffset = tokenRegion.getOffset();
		if (caretOffset >= tokenRegionOffset && caretOffset <= tokenRegionOffset + tokenRegion.getLength()) {
			return;
		}
		tokenRegion = new org.eclipse.jface.text.Region(-1,0);
		org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = textResource.getLocationMap();
		java.util.List<org.eclipse.emf.ecore.EObject> elementsAtOffset = locationMap.getElementsAt(caretOffset);
		
		if (elementsAtOffset == null || elementsAtOffset.size() < 1) {
			return;
		}
		org.eclipse.emf.ecore.EObject firstElementAtOffset = elementsAtOffset.get(0);
		org.eclipse.emf.ecore.EObject resolvedEO = tryToResolve(elementsAtOffset);
		if (resolvedEO != null) {
			elementsAtOffset = locationMap.getElementsAt(locationMap.getCharStart(resolvedEO));
		}
		
		tokenScanner.setRange(document, locationMap.getCharStart(firstElementAtOffset), getLength(firstElementAtOffset));
		org.eclipse.jface.text.rules.IToken token = tokenScanner.nextToken();
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
				tokenRegion = new org.eclipse.jface.text.Region(tokenOffset, tokenLength);
				removeAnnotations();
				break;
			}
			token = tokenScanner.nextToken();
		}
		
		if (tokenText == null || tokenText.equals("")) {
			return;
		}
		if ((resolvedEO == null && quotedTokenArray.contains(tokenText)) || (resolvedEO == null && elementsAtOffset.get(0).eResource() == null) || bracketSet.isBracket(tokenText)) {
			tokenText = "";
			return;
		}
		try {
			setHighlightingPositions(resolvedEO, elementsAtOffset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setHighlightingPositions(org.eclipse.emf.ecore.EObject definitionElement, java.util.List<org.eclipse.emf.ecore.EObject> elementsAtDefinition) {
		org.eclipse.jface.text.IDocument document = projectionViewer.getDocument();
		org.emftext.sdk.concretesyntax.resource.cs.ICsLocationMap locationMap = textResource.getLocationMap();
		org.eclipse.jface.text.rules.IToken token;
		int defPosition = -1;
		if (definitionElement == null) {
			definitionElement = elementsAtDefinition.get(0);
		}
		org.eclipse.emf.ecore.resource.Resource resource = definitionElement.eResource();
		if (resource == null) {
			return;
		}
		if (resource.equals(textResource)) {
			tokenScanner.setRange(projectionViewer.getDocument(), locationMap.getCharStart(definitionElement), getLength(definitionElement));
			token = tokenScanner.nextToken();
			while (!token.isEOF()) {
				String text = tokenScanner.getTokenText();
				if (text.equals(tokenText)) {
					defPosition = tokenScanner.getTokenOffset();
					addAnnotation(document, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.DEFINTION, text);
					break;
				}
				token = tokenScanner.nextToken();
			}
		}
		tokenScanner.setRange(projectionViewer.getDocument(), 0, projectionViewer.getDocument().getLength());
		org.eclipse.emf.ecore.EObject occEO;
		token = tokenScanner.nextToken();
		while (!token.isEOF()) {
			String text = tokenScanner.getTokenText();
			if (text != null && text.equals(tokenText) && tokenScanner.getTokenOffset() != defPosition) {
				occEO = tryToResolve(locationMap.getElementsAt(tokenScanner.getTokenOffset()));
				if (occEO != null) {
					if (elementsAtDefinition.contains(occEO) || definitionElement.equals(occEO)) {
						addAnnotation(document, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.PROXY, text);
					}
				}
			}
			token = tokenScanner.nextToken();
		}
	}
	
	private void addAnnotation(org.eclipse.jface.text.IDocument document, org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory type, String text) {
		int tokenOffset = tokenScanner.getTokenOffset();
		int tokenLength = tokenScanner.getTokenLength();
		// for declarations and occurrences we do not need to add the position to the
		// document
		org.eclipse.jface.text.Position position = positionHelper.createPosition(tokenOffset, tokenLength);
		// instead, an annotation is created
		org.eclipse.jface.text.source.Annotation annotation = new org.eclipse.jface.text.source.Annotation(false);
		if (type == org.emftext.sdk.concretesyntax.resource.cs.ui.CsPositionCategory.DEFINTION) {
			annotation.setText("Declaration of " + text);
			annotation.setType(DECLARATION_ANNOTATION_ID);
		} else {
			annotation.setText("Occurrence of " + text);
			annotation.setType(OCCURRENCE_ANNOTATION_ID);
		}
		projectionViewer.getAnnotationModel().addAnnotation(annotation, position);
	}
	
	private void removeAnnotations() {
		removeAnnotations(org.emftext.sdk.concretesyntax.resource.cs.ui.CsOccurrence.OCCURRENCE_ANNOTATION_ID);
		removeAnnotations(org.emftext.sdk.concretesyntax.resource.cs.ui.CsOccurrence.DECLARATION_ANNOTATION_ID);
	}
	
	private void removeAnnotations(String annotationTypeID) {
		java.util.List<org.eclipse.jface.text.source.Annotation> annotationsToRemove = new java.util.ArrayList<org.eclipse.jface.text.source.Annotation>();
		org.eclipse.jface.text.source.IAnnotationModel annotationModel = projectionViewer.getAnnotationModel();
		java.util.Iterator<?> annotationIterator = annotationModel.getAnnotationIterator();
		while (annotationIterator.hasNext()) {
			Object object = (Object) annotationIterator.next();
			if (object instanceof org.eclipse.jface.text.source.Annotation) {
				org.eclipse.jface.text.source.Annotation annotation = (org.eclipse.jface.text.source.Annotation) object;
				if (annotationTypeID.equals(annotation.getType())) {
					annotationsToRemove.add(annotation);
				}
			}
		}
		for (org.eclipse.jface.text.source.Annotation annotation : annotationsToRemove) {
			annotationModel.removeAnnotation(annotation);
		}
	}
	
	/**
	 * Check whether it is time to remove the occurrence highlighting.
	 * 
	 * @return <code>true</code> if the caret changed the token.
	 */
	public boolean isToRemoveHighlighting() {
		org.eclipse.swt.custom.StyledText textWidget = projectionViewer.getTextWidget();
		int caretOffset = textWidget.getCaretOffset();
		caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);
		if (caretOffset >= tokenRegion.getOffset() && caretOffset <= tokenRegion.getOffset() + tokenRegion.getLength()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Resets the token region to enable remove highlighting if the text is changing.
	 */
	public void resetTokenRegion(){
		tokenRegion = new org.eclipse.jface.text.Region(-1, 0);
	}
	
}
