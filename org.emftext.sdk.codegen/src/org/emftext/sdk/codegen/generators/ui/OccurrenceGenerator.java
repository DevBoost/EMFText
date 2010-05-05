/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.REGION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STYLED_TEXT;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class OccurrenceGenerator extends JavaBaseGenerator {

	public OccurrenceGenerator() {
		super();
	}

	private OccurrenceGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.OCCURENCE);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("This class finds the positions to highlight and adds them to the document.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
		return true;
	}

	private void addMethods(JavaComposite sc) {
		addGetResolvedEObjectMethod(sc);
		addTryToResolveMethod(sc);
		addGetEObjectAtCurrentPositionMethod(sc);
		addGetTokenTextMethod(sc);
		addGetLengthMethod(sc);
		addHandleOccurrenceHighlightingMethod(sc);
		addSetHighlightingPositionsMethod(sc);
		addAddPositionsMethod(sc);
		addIsToRemoveHighlightingMethod(sc);
		addIsPositionsChangedMethod(sc);
		addResetTokenRegionMethod(sc);
	}

	private void addResetTokenRegionMethod(JavaComposite sc) {
		sc.addJavadoc("Resets the token region to enable remove highlighting if the text is changing.");
		sc.add("public void resetTokenRegion(){");
		sc.add("tokenRegion = new " + REGION + "(-1, 0);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsPositionsChangedMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Check whether the token region changed to decide to highlight or not.",
			"@return <code>true</code> if the occurrences should be highlighted"
		);
		sc.add("public boolean isPositionsChanged() {");
		sc.add("return isPositionsChanged;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsToRemoveHighlightingMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Check whether it is time to remove the occurrence highlighting.",
			"@return <code>true</code> if the caret changed the token."
		);
		sc.add("public boolean isToRemoveHighlighting() {");
		sc.add(STYLED_TEXT + " textWidget = projectionViewer.getTextWidget();");
		sc.add("int caretOffset = textWidget.getCaretOffset();");
		sc.add("caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);");
		sc.add("if (caretOffset >= tokenRegion.getOffset() && caretOffset <= tokenRegion.getOffset() + tokenRegion.getLength()) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddPositionsMethod(StringComposite sc) {
		sc.add("private void addPosition(" + I_DOCUMENT + " document, String positionCategory) {");
		sc.add("int tokenOffset = tokenScanner.getTokenOffset();");
		sc.add("int tokenLength = tokenScanner.getTokenLength();");
		sc.add("positionHelper.addPosition(document, positionCategory, tokenOffset, tokenLength);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetHighlightingPositionsMethod(StringComposite sc) {
		sc.add("private void setHighlightingPositions(" + E_OBJECT + " definitionElement, " + LIST + "<" + E_OBJECT + "> elementsAtDefinition) {");
		sc.add(I_DOCUMENT + " document = projectionViewer.getDocument();");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add(I_TOKEN + " token;");
		sc.add("int defPosition = -1;");
		sc.add("boolean isNull = definitionElement == null;");
		sc.add("if (isNull) {");
		sc.add("definitionElement = elementsAtDefinition.get(0);");
		sc.add("}");
		sc.add(RESOURCE + " resource = definitionElement.eResource();");
		sc.add("if (resource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (resource.equals(textResource)) {");
		sc.add("tokenScanner.setRange(projectionViewer.getDocument(), locationMap.getCharStart(definitionElement), getLength(definitionElement));");
		sc.add("token = tokenScanner.nextToken();");
		sc.add("while (!token.isEOF()) {");
		sc.add("String text = tokenScanner.getTokenText();");
		sc.add("if (text.equals(tokenText)) {");
		sc.add("defPosition = tokenScanner.getTokenOffset();");
		sc.add("addPosition(document, " + positionCategoryClassName + ".DEFINTION.toString());");
		sc.add("break;");
		sc.add("}");
		sc.add("token = tokenScanner.nextToken();");
		sc.add("}");
		sc.add("}");
		sc.add("tokenScanner.setRange(projectionViewer.getDocument(), 0, projectionViewer.getDocument().getLength());");
		sc.add(E_OBJECT + " occEO;");
		sc.add("token = tokenScanner.nextToken();");
		sc.add("while (!token.isEOF()) {");
		sc.add("String text = tokenScanner.getTokenText();");
		sc.add("if (text != null && text.equals(tokenText) && tokenScanner.getTokenOffset() != defPosition) {");
		sc.add("occEO = tryToResolve(locationMap.getElementsAt(tokenScanner.getTokenOffset()));");
		sc.add("if (occEO != null) {");
		sc.add("if ((isNull && elementsAtDefinition.contains(occEO)) || !isNull && definitionElement.equals(occEO)) {");
		sc.add("addPosition(document, " + positionCategoryClassName + ".PROXY.toString());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("token = tokenScanner.nextToken();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleOccurrenceHighlightingMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Finds the positions of the occurrences which will be highlighted. The " +
			"brackets and the key words should not be highlighted.",
			"@param bracketSet the set of brackets which have to be ignored."
		);
		sc.add("public void handleOccurrenceHighlighting(" + bracketSetClassName + " bracketSet) {");
		sc.add("if (textResource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(STYLED_TEXT + " textWidget = projectionViewer.getTextWidget();");
		sc.add("int caretOffset = textWidget.getCaretOffset();");
		sc.add("caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);");
		sc.add(I_DOCUMENT + " document = projectionViewer.getDocument();");
		sc.add("if (caretOffset < 0 || caretOffset >= document.getLength()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int tokenRegionOffset = tokenRegion.getOffset();");
		sc.add("if (caretOffset >= tokenRegionOffset && caretOffset <= tokenRegionOffset + tokenRegion.getLength()) {");
		sc.add("isPositionsChanged = false;");
		sc.add("return;");
		sc.add("}");
		sc.add("tokenRegion = new " + REGION + "(-1,0);");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add(LIST + "<" + E_OBJECT + "> elementsAtOffset = locationMap.getElementsAt(caretOffset);");
		sc.addLineBreak();
		sc.add("if (elementsAtOffset == null || elementsAtOffset.size() < 1) {");
		sc.add("return;");
		sc.add("}");
		sc.add(E_OBJECT + " firstElementAtOffset = elementsAtOffset.get(0);");
		sc.add(E_OBJECT + " resolvedEO = tryToResolve(elementsAtOffset);");
		sc.add("if (resolvedEO != null) {");
		sc.add("elementsAtOffset = locationMap.getElementsAt(locationMap.getCharStart(resolvedEO));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("tokenScanner.setRange(document, locationMap.getCharStart(firstElementAtOffset), getLength(firstElementAtOffset));");
		sc.add(I_TOKEN + " token = tokenScanner.nextToken();");
		sc.add("while (!token.isEOF()) {");
		sc.add("int tokenOffset = tokenScanner.getTokenOffset();");
		sc.add("int tokenLength = tokenScanner.getTokenLength();");
		sc.add("String text = tokenScanner.getTokenText();");
		sc.add("if (tokenOffset <= caretOffset && tokenLength + tokenOffset > caretOffset) {");
		sc.add("if (text.trim().equals(\"\")) {");
		sc.addComment("the rejected elements");
		sc.add("return;");
		sc.add("}");
		sc.add("tokenText = text;");
		sc.add("tokenRegion = new " + REGION + "(tokenOffset, tokenLength);");
		sc.add("isPositionsChanged = true;");
		sc.add("break;");
		sc.add("}");
		sc.add("token = tokenScanner.nextToken();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (tokenText == null || tokenText.equals(\"\")) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if ((resolvedEO == null && quotedTokenArray.contains(tokenText))");
		sc.add("|| (resolvedEO == null && elementsAtOffset.get(0).eResource() == null)");
		sc.add("|| bracketSet.isBracket(tokenText)) {");
		sc.add("tokenText = \"\";");
		sc.add("return;");
		sc.add("}");
		sc.add("try {");
		sc.add("setHighlightingPositions(resolvedEO, elementsAtOffset);");
		sc.add("} catch (Exception e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLengthMethod(StringComposite sc) {
		sc.add("private int getLength(" + E_OBJECT + " eObject) {");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add("return locationMap.getCharEnd(eObject) - locationMap.getCharStart(eObject) + 1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenTextMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the token text at the caret.",
			"@return the token text"
		);
		sc.add("public String getTokenText() {");
		sc.add("return tokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEObjectAtCurrentPositionMethod(JavaComposite sc) {
		sc.addJavadoc("@return the eObject at the current cursor position.");
		sc.add("public " + E_OBJECT + " getEObjectAtCurrentPosition() {");
		sc.add(STYLED_TEXT + " textWidget = projectionViewer.getTextWidget();");
		sc.add("if (textWidget == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("int caretOffset = textWidget.getCaretOffset();");
		sc.add("caretOffset = projectionViewer.widgetOffset2ModelOffset(caretOffset);");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add(LIST + "<" + E_OBJECT + "> elementsAtOffset = locationMap.getElementsAt(caretOffset);");
		sc.addLineBreak();
		sc.add("if (elementsAtOffset == null || elementsAtOffset.isEmpty()) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("for (" + E_OBJECT + " candidate : elementsAtOffset) {");
		sc.add("if (candidate.eIsProxy()) {");
		sc.add("candidate = getResolvedEObject(candidate);");
		sc.add("}");
		sc.addComment(
			"take an element that is actually contained in a resource. " +
			"the location map might reference elements that were removed by a post processor"
		);
		sc.add("if (candidate.eResource() != null) {");
		sc.add("return candidate;");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTryToResolveMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Tries to resolve the first proxy object in a list.",
			"@param objects the <code>EObject</code>s at the text caret",
			"@return the resolved <code>EObject</code> of the first proxy <code>EObject</code> in a list. If there are none returns <code>null</code>"
		);
		sc.add("public " + E_OBJECT + " tryToResolve(" + LIST + "<" + E_OBJECT + "> objects) {");
		sc.add("for (" + E_OBJECT + " object : objects) {");
		sc.add("if (object.eIsProxy()) {");
		sc.add("return getResolvedEObject(object);");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResolvedEObjectMethod(StringComposite sc) {
		sc.add("private " + E_OBJECT + " getResolvedEObject(" + E_OBJECT + " eObject) {");
		sc.add("return eObject.eIsProxy() ? " + ECORE_UTIL + ".resolve(eObject, textResource) : eObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates the Occurrence class to find position to highlight.",
			"@param textResource the text resource for location",
			"@param sourceViewer the source viewer for the text",
			"@param tokenScanner the token scanner helps to find the searched tokens"
		);
		sc.add("public " + getResourceClassName() + "(" + iTextResourceClassName + " textResource, " + PROJECTION_VIEWER + " sourceViewer, " + tokenScannerClassName + " tokenScanner) {");
		sc.add("this.textResource = textResource;");
		sc.add("this.projectionViewer = sourceViewer;");
		sc.addLineBreak();
		sc.add("quotedTokenArray = new " + ARRAY_LIST + "<String>();");
		sc.add("String[] tokenNames = new " + metaInformationClassName + "().getTokenNames();");
		sc.add("for (String tokenName : tokenNames) {");
		// TODO this is ANTLR specific maybe use ANTLRTokenHelper here
		sc.add("if (tokenName.startsWith(\"'\") && tokenName.endsWith(\"'\")) {");
		sc.add("quotedTokenArray.add(tokenName.substring(1, tokenName.length() - 1).trim());");
		sc.add("}");
		sc.add("}");
		sc.add("this.tokenScanner = tokenScanner;");
		sc.add("tokenRegion = new " + REGION + "(-1, 0);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private final static " + positionHelperClassName + " positionHelper = new " + positionHelperClassName + "();");
		sc.add("private " + tokenScannerClassName + " tokenScanner;");
		sc.add("private " + LIST + "<String> quotedTokenArray;");
		sc.add("private " + PROJECTION_VIEWER + " projectionViewer;");
		sc.add("private " + iTextResourceClassName + " textResource;");
		sc.add("private String tokenText = \"\";");
		sc.add("private " + REGION + " tokenRegion;");
		sc.add("private boolean isPositionsChanged = true;");
		sc.addLineBreak();
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new OccurrenceGenerator(context);
	}
}
