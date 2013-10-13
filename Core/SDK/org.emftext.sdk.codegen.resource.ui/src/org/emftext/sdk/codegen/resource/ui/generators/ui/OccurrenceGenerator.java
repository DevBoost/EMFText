/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SETTING;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ANNOTATION_MODEL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_VIEWER_EXTENSION5;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TOKEN;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.POSITION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.REGION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.STYLED_TEXT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class OccurrenceGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc("This class finds text positions to highlight and adds them to the document.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addInnerClassITokenScannerConstraint(sc);
		addFields(sc);
		addConstructor1(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("public final static String OCCURRENCE_ANNOTATION_ID = \"" + getContext().getOccurrenceAnnotationTypeID() + "\";");
		sc.add("public final static String DECLARATION_ANNOTATION_ID = \"" + getContext().getDeclarationAnnotationTypeID() + "\";");
		sc.addLineBreak();
		sc.add("private final static " + positionHelperClassName + " positionHelper = new " + positionHelperClassName + "();");
		sc.addLineBreak();
		sc.addJavadoc("The viewer showing the document the we search occurrences for");
		sc.add("private " + PROJECTION_VIEWER(sc) + " projectionViewer;");
		sc.addLineBreak();
		sc.addJavadoc("The resource we operate on");
		sc.add("private " + iTextResourceClassName + " textResource;");
		sc.addLineBreak();
		sc.addJavadoc("The text of the token that was located at the caret position at the time occurrence were computed last");
		sc.add("private String tokenText = \"\";");
		sc.addLineBreak();
		sc.addJavadoc("The region of the token that was located at the caret position at the time occurrence were computed last");
		sc.add("private " + REGION(sc) + " tokenRegion;");
		sc.addLineBreak();
	}

	private void addInnerClassITokenScannerConstraint(JavaComposite sc) {
		sc.add("private static interface ITokenScannerConstraint {");
		sc.add("public boolean mustStop(" + iTokenScannerClassName + " tokenScanner);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor1(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a " + getResourceClassName() + " object to find positions to highlight.",
			"@param textResource the text resource for location",
			"@param projectionViewer the viewer for the text"
		);
		sc.add("public " + getResourceClassName() + "(" + iTextResourceClassName + " textResource, " + PROJECTION_VIEWER(sc) + " projectionViewer) {");
		sc.add("super();");
		sc.add("this.textResource = textResource;");
		sc.add("this.projectionViewer = projectionViewer;");
		sc.addLineBreak();
		sc.add("resetTokenRegion();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetResolvedEObjectMethod(sc);
		addTryToResolveMethod(sc);
		addGetEObjectAtCurrentPositionMethod(sc);
		addGetTokenTextMethod(sc);
		addGetLengthMethod(sc);
		addUpdateOccurrenceAnnotationsMethod(sc);
		addIsContainedInMethod1(sc);
		addIsContainedInMethod2(sc);
		addAddAnnotationsMethod(sc);
		addAddAnnotationsForReferencesMethod(sc);
		addAddAnnotationsForDefinitionMethod(sc);
		addGetIndexOfMethod(sc);
		addScanMethod(sc);
		addCreateTokenScannerMethod(sc);
		addAddAnnotationMethod(sc);
		addRemoveAnnotationsMethod1(sc);
		addRemoveAnnotationsMethod2(sc);
		addResetTokenRegionMethod(sc);
		addGetCaretOffsetMethod(sc);
		addGetSourceViewerMethod(sc);
		addGetTextViewerExtension5Method(sc);
	}

	private void addGetTextViewerExtension5Method(JavaComposite sc) {
		sc.addJavadoc(
			"Accessor method for the field <code>projectionViewer</code>. " + 
			"The accessor is also used for unit testing to inject a custom text viewer extension by overriding this method."
		);
		sc.add("protected " + I_TEXT_VIEWER_EXTENSION5(sc) + " getTextViewerExtension5() {");
		sc.add("return projectionViewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSourceViewerMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Accessor method for the field <code>projectionViewer</code>. " + 
			"The accessor is also used for unit testing to inject a custom source viewer by overriding this method."
		);
		sc.add("protected " + I_SOURCE_VIEWER(sc) + " getSourceViewer() {");
		sc.add("return projectionViewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateTokenScannerMethod(JavaComposite sc) {
		sc.add("protected " + iTokenScannerClassName + " createTokenScanner() {");
		sc.add("return new " + uiMetaInformationClassName + "().createTokenScanner(null, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addScanMethod(JavaComposite sc) {
		sc.add("protected " + iTokenScannerClassName + " scan(" + E_OBJECT(sc) + " object, ITokenScannerConstraint constraint) {");
		sc.add(I_DOCUMENT(sc) + " document = getSourceViewer().getDocument();");
		sc.addLineBreak();
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.addLineBreak();
		sc.add(iTokenScannerClassName + " tokenScanner = createTokenScanner();");
		sc.add("int offset = locationMap.getCharStart(object);");
		sc.add("int length = getLength(locationMap, object);");
		sc.addLineBreak();
		sc.add("tokenScanner.setRange(document, offset, length);");
		sc.add(I_TOKEN(sc) + " token = tokenScanner.nextToken();");
		sc.add("while (!token.isEOF()) {");
		sc.add("if (constraint.mustStop(tokenScanner)) {");
		sc.add("return tokenScanner;");
		sc.add("}");
		sc.add("token = tokenScanner.nextToken();");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetIndexOfMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the index of the given text within the text that corresponds to " +
				" the EObject.");
		sc.add("protected int getIndexOf(" + E_OBJECT(sc) + " eObject, final String text) {");
		sc.add(iTokenScannerClassName + " tokenScanner = scan(eObject, new ITokenScannerConstraint() {");
		sc.addLineBreak();
		sc.add("public boolean mustStop(" + iTokenScannerClassName + " tokenScanner) {");
		sc.add("String tokenText = tokenScanner.getTokenText();");
		sc.add("return tokenText.equals(text);");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add("if (tokenScanner == null) {");
		sc.add("return -1;");
		sc.add("} else {");
		sc.add("return tokenScanner.getTokenOffset();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddAnnotationsForDefinitionMethod(JavaComposite sc) {
		sc.add("protected " + LIST(sc) + "<String> addAnnotationsForDefinition(" + E_OBJECT(sc) + " referencedElement, String definitionText, int definitionOffset, final int caretOffset) {");
		sc.addLineBreak();
		sc.add("final " + I_DOCUMENT(sc) + " document = getSourceViewer().getDocument();");
		sc.add("final " + LIST(sc) + "<String> matchingNames = new " + ARRAY_LIST(sc) + "<String>();");
		sc.add("if (definitionText == null) {");
		sc.addComment("The object at the caret position is not referenced from within " +
				"the resource. Thus, we cannot highlight occurrences or " +
				"declarations.");
		sc.add("final " + LIST(sc) + "<String> names = new " + defaultNameProviderClassName + "().getNames(referencedElement);");
		sc.add("scan(referencedElement, new ITokenScannerConstraint() {");
		sc.addLineBreak();
		sc.add("public boolean mustStop(" + iTokenScannerClassName + " tokenScanner) {");
		sc.add("int offset = tokenScanner.getTokenOffset();");
		sc.add("int length = tokenScanner.getTokenLength();");
		sc.add("String text = tokenScanner.getTokenText();");
		sc.add("if (names.contains(text) && isContainedIn(offset, length, caretOffset)) {");
		sc.add("matchingNames.add(text);");
		sc.add("addAnnotation(document, " + positionCategoryClassName + ".DEFINITION, text, offset, text.length());");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.add("});");
		sc.add("} else {");
		sc.addComment("Highlight the token in the text for the referenced object");
		sc.add("addAnnotation(document, " + positionCategoryClassName + ".DEFINITION, definitionText, definitionOffset, definitionText.length());");
		sc.add("matchingNames.add(definitionText);");
		sc.add("}");
		sc.add("return matchingNames;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddAnnotationsForReferencesMethod(JavaComposite sc) {
		sc.add("protected void addAnnotationsForReferences(" + E_OBJECT(sc) + " referencedElement, " + LIST(sc) + "<String> matchingNames) {");
		sc.addLineBreak();
		sc.add(I_DOCUMENT(sc) + " document = getSourceViewer().getDocument();");
		sc.addLineBreak();
		sc.addComment("Determine all references to the EObject");
		sc.add(MAP(sc) + "<" + E_OBJECT(sc) + ", " + COLLECTION(sc) + "<" + SETTING + ">> map = " + ECORE_UTIL(sc) + ".UsageCrossReferencer.find(" + COLLECTIONS(sc) + ".singleton(textResource));");
		sc.add(COLLECTION(sc) + "<" + SETTING + "> referencingObjects = map.get(referencedElement);");
		sc.add("if (referencingObjects == null) {");
		sc.addComment("No references found");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("Highlight the token in the text for the referencing objects");
		sc.add("for (" + SETTING + " setting : referencingObjects) {");
		sc.add(E_OBJECT(sc) + " referencingElement = setting.getEObject();");
		sc.addComment("Search through all tokens in the elements that reference the " +
				"element at the caret position");
		sc.add("for (String name : matchingNames) {");
		sc.add("int index = getIndexOf(referencingElement, name);");
		sc.add("if (index > 0) {");
		sc.add("addAnnotation(document, " + positionCategoryClassName + ".PROXY, name, index, name.length());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddAnnotationsMethod(JavaComposite sc) {
		sc.add("protected void addAnnotations(" + E_OBJECT(sc) + " referencedElement, String definitionText, int definitionOffset, int caretOffset) {");
		sc.add(LIST(sc) + "<String> matchingNames = addAnnotationsForDefinition(referencedElement, definitionText, definitionOffset, caretOffset);");
		sc.add("addAnnotationsForReferences(referencedElement, matchingNames);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCaretOffsetMethod(JavaComposite sc) {
		sc.add("protected int getCaretOffset() {");
		sc.add(STYLED_TEXT(sc) + " textWidget = getSourceViewer().getTextWidget();");
		sc.add("int widgetOffset = textWidget.getCaretOffset();");
		sc.add("return getTextViewerExtension5().widgetOffset2ModelOffset(widgetOffset);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResetTokenRegionMethod(JavaComposite sc) {
		sc.addJavadoc("Resets the token region to enable remove highlighting if the text is changing.");
		sc.add("public void resetTokenRegion() {");
		sc.add("tokenRegion = new " + REGION(sc) + "(-1, 0);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddAnnotationMethod(JavaComposite sc) {
		sc.add("protected void addAnnotation(" + I_DOCUMENT(sc) + " document, " + positionCategoryClassName + " type, String text, int offset, int length) {");
		sc.addComment("for declarations and occurrences we do not need to add the position to the document ");
		sc.add(POSITION(sc) + " position = positionHelper.createPosition(offset, length);");
		sc.addComment("instead, an annotation is created");
		sc.add(ANNOTATION(sc) + " annotation = new " + ANNOTATION(sc) + "(false);");
		sc.add("if (type == " + positionCategoryClassName + ".DEFINITION) {");
		sc.add("annotation.setText(\"Declaration of \" + text);");
		sc.add("annotation.setType(DECLARATION_ANNOTATION_ID);");
		sc.add("} else {");
		sc.add("annotation.setText(\"Occurrence of \" + text);");
		sc.add("annotation.setType(OCCURRENCE_ANNOTATION_ID);");
		sc.add("}");
		sc.add("getSourceViewer().getAnnotationModel().addAnnotation(annotation, position);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addUpdateOccurrenceAnnotationsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Finds the positions of the occurrences and declarations which will be highlighted."
		);
		sc.add("public void updateOccurrenceAnnotations() {");
		sc.add("if (textResource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("final int caretOffset = getCaretOffset();");
		sc.add(I_DOCUMENT(sc) + " document = getSourceViewer().getDocument();");
		sc.add("if (caretOffset < 0 || caretOffset >= document.getLength()) {");
		sc.addComment("The caret is outside of the document.");
		sc.add("removeAnnotations();");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (isContainedIn(tokenRegion, caretOffset)) {");
		sc.addComment(
			"The caret is still contained in the same token region. " +
			"No need to update occurrence annotations."
		);
		//sc.add("isPositionsChanged = false;");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("resetTokenRegion();");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> elementsAtOffset = locationMap.getElementsAt(caretOffset);");
		sc.addLineBreak();
		sc.add("if (elementsAtOffset == null || elementsAtOffset.size() < 1) {");
		sc.addComment("The document does not contain EObjects. Probably there is a syntax error.");
		sc.add("removeAnnotations();");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("removeAnnotations();");
		sc.add(E_OBJECT(sc) + " resolvedEObject = tryToResolve(elementsAtOffset);");
		sc.add(E_OBJECT(sc) + " referencedElement;");
		sc.add(E_OBJECT(sc) + " firstElementAtOffset = elementsAtOffset.get(0);");
		sc.add("if (resolvedEObject != null) {");
		sc.add("referencedElement = resolvedEObject;");
		sc.add("} else {");
		sc.add("referencedElement = firstElementAtOffset;");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("Scan the region in which the referenced object is located.");
		sc.add(iTokenScannerClassName + " tokenScanner = scan(referencedElement, new ITokenScannerConstraint() {");
		sc.addLineBreak();
		sc.add("public boolean mustStop(" + iTokenScannerClassName + " tokenScanner) {");
		sc.add("int tokenOffset = tokenScanner.getTokenOffset();");
		sc.add("int tokenLength = tokenScanner.getTokenLength();");
		sc.addComment("check whether the caret in this token");
		sc.add("return isContainedIn(tokenOffset, tokenLength, caretOffset);");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add("if (tokenScanner != null) {");
		sc.addComment("caret is located in referenced element");
		sc.add("removeAnnotations();");
		sc.addLineBreak();
		sc.add("int tokenOffset = tokenScanner.getTokenOffset();");
		sc.add("int tokenLength = tokenScanner.getTokenLength();");
		sc.add("tokenText = tokenScanner.getTokenText();");
		sc.add("tokenRegion = new " + REGION(sc) + "(tokenOffset, tokenLength);");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment(
			"The tokenScanner must always be not null if there was no proxy at " +
			"the caret position, but to prevent JDT from complaining about a " +
			"potential null pointer access, we check both conditions here."
		);
		sc.add("if (resolvedEObject == null && tokenScanner != null) {");
		sc.addComment("caret is within definition");
		sc.add("int tokenOffset = tokenScanner.getTokenOffset();");
		sc.addComment("we pass null as 'definitionText' because we do not know whether "+
			"the token at the caret is actually the defining name");
		sc.add("addAnnotations(referencedElement, null, tokenOffset, caretOffset);");
		sc.add("} else {");
		sc.addComment("caret is within reference");
		sc.add("int proxyOffset = locationMap.getCharStart(firstElementAtOffset);");
		sc.add("int proxyLength = getLength(locationMap, firstElementAtOffset);");
		sc.add("try {");
		sc.add("String proxyText = document.get(proxyOffset, proxyLength);");
		sc.add("int index = getIndexOf(referencedElement, proxyText);");
		sc.add("if (index >= 0) {");
		sc.add("addAnnotations(referencedElement, proxyText, index, caretOffset);");
		sc.add("}");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.addComment("ignore");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsContainedInMethod2(JavaComposite sc) {
		sc.add("protected boolean isContainedIn(int regionOffset, int regionLength, int offset) {");
		sc.add("int regionEnd = regionOffset + regionLength;");
		sc.add("return regionOffset <= offset && offset < regionEnd;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsContainedInMethod1(JavaComposite sc) {
		sc.add("protected boolean isContainedIn(" + REGION(sc) + " region, int offset) {");
		sc.add("int regionOffset = region.getOffset();");
		sc.add("int regionEnd = regionOffset + region.getLength();");
		sc.add("return offset >= regionOffset && offset <= regionEnd;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLengthMethod(JavaComposite sc) {
		sc.add("protected int getLength(" + iLocationMapClassName + " locationMap, " + E_OBJECT(sc) + " eObject) {");
		sc.add("return locationMap.getCharEnd(eObject) - locationMap.getCharStart(eObject) + 1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenTextMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the text of the token that was found at the caret position at the time occurrence we computed last.",
			"@return the token text"
		);
		sc.add("protected String getTokenText() {");
		sc.add("return tokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEObjectAtCurrentPositionMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the EObject at the current caret position.");
		sc.add("public " + E_OBJECT(sc) + " getEObjectAtCurrentPosition() {");
		sc.add("if (textResource == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("int caretOffset = getCaretOffset();");
		sc.addLineBreak();
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> elementsAtOffset = locationMap.getElementsAt(caretOffset);");
		sc.addLineBreak();
		sc.add("if (elementsAtOffset == null || elementsAtOffset.isEmpty()) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("for (" + E_OBJECT(sc) + " candidate : elementsAtOffset) {");
		sc.add("if (candidate.eIsProxy()) {");
		sc.add("candidate = getResolvedEObject(candidate);");
		sc.add("}");
		sc.addComment(
			"Only accept elements that are actually contained in a resource. " +
			"The location map might reference elements that were removed by a post processor and " +
			"which are therefore not part of the resource anymore."
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
			"Tries to resolve the first proxy object in the given list.",
			"@param objects the <code>EObject</code>s located at the caret position",
			"@return the resolved <code>EObject</code> of the first proxy <code>EObject</code> in a list. If resolving fails, <code>null</code> is returned."
		);
		sc.add("public " + E_OBJECT(sc) + " tryToResolve(" + LIST(sc) + "<" + E_OBJECT(sc) + "> objects) {");
		sc.add("for (" + E_OBJECT(sc) + " object : objects) {");
		sc.add("if (object.eIsProxy()) {");
		sc.add("return getResolvedEObject(object);");
		sc.add("}");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResolvedEObjectMethod(JavaComposite sc) {
		sc.add("protected " + E_OBJECT(sc) + " getResolvedEObject(" + E_OBJECT(sc) + " eObject) {");
		sc.add("return eObject.eIsProxy() ? " + ECORE_UTIL(sc) + ".resolve(eObject, textResource) : eObject;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveAnnotationsMethod1(StringComposite sc) {
		sc.add("protected void removeAnnotations() {");
		sc.add("removeAnnotations(" + occurrenceClassName + ".OCCURRENCE_ANNOTATION_ID);");
		sc.add("removeAnnotations(" + occurrenceClassName + ".DECLARATION_ANNOTATION_ID);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveAnnotationsMethod2(JavaComposite sc) {
		sc.add("protected void removeAnnotations(String annotationTypeID) {");
		sc.add(LIST(sc) + "<" + ANNOTATION(sc) + "> annotationsToRemove = new " + ARRAY_LIST(sc) + "<" + ANNOTATION(sc) + ">();");
		sc.add(I_ANNOTATION_MODEL(sc) + " annotationModel = getSourceViewer().getAnnotationModel();");
		sc.add(ITERATOR(sc) + "<?> annotationIterator = annotationModel.getAnnotationIterator();");
		sc.add("while (annotationIterator.hasNext()) {");
		sc.add("Object object = (Object) annotationIterator.next();");
		sc.add("if (object instanceof " + ANNOTATION(sc) + ") {");
		sc.add(ANNOTATION(sc) + " annotation = (" + ANNOTATION(sc) + ") object;");
		sc.add("if (annotationTypeID.equals(annotation.getType())) {");
		sc.add("annotationsToRemove.add(annotation);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + ANNOTATION(sc) + " annotation : annotationsToRemove) {");
		sc.add("annotationModel.removeAnnotation(annotation);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
