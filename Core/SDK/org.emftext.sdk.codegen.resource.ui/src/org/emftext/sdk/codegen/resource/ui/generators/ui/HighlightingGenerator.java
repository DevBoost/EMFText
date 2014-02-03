/*******************************************************************************
 * Copyright (c) 2006-2014
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

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COLOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.KEY_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.KEY_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MOUSE_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MOUSE_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.POSITION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PREFERENCE_CONVERTER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RGB;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.STYLED_TEXT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.STYLE_RANGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.TREE_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.VERIFY_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.VERIFY_LISTENER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class HighlightingGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc("A manager class for the highlighting of occurrences and brackets.");
		sc.add("public class " + getResourceClassName() + " implements " + I_SELECTION_PROVIDER(sc) + ", " + I_SELECTION_CHANGED_LISTENER(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addPositionHelperClass(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite jc) {
		jc.add("private final static " + positionHelperClassName + " positionHelper = new " + positionHelperClassName + "();");
		jc.addLineBreak();
		jc.add("private " + LIST(jc) + "<" + I_SELECTION_CHANGED_LISTENER(jc) + "> selectionChangedListeners = new " + ARRAY_LIST(jc) + "<" + I_SELECTION_CHANGED_LISTENER(jc) + ">();");
		jc.add("private " + I_SELECTION(jc) + " selection = null;");
		jc.add("private boolean isHighlightBrackets = true;");
		jc.add("private " + colorManagerClassName + " colorManager;");
		jc.add("private " + COLOR(jc) + " bracketColor;");
		jc.add("private " + COLOR(jc) + " black;");
		jc.add("private " + STYLED_TEXT(jc) + " textWidget;");
		jc.add("private " + I_PREFERENCE_STORE(jc) + " preferenceStore;");
		jc.add("private " + editorClassName + " editor;");
		jc.add("private " + PROJECTION_VIEWER(jc) + " projectionViewer;");
		jc.add("private " + occurrenceClassName + " occurrence;");
		jc.add("private " + bracketSetClassName + " bracketSet;");
		jc.add("private " + DISPLAY(jc) + " display;");
		jc.addLineBreak();
	}

	private void addMethods(JavaComposite jc) {
		addListenersMethod(jc);
		addSetHighlightingMethod(jc);
		addSetBracketHighlightingMethod(jc);
		addRemoveHighlightingMethod(jc);
		addRemoveHighlightingCategoryMethod(jc);
		addUpdateEObjectSelectionMethod(jc);
		addResetValuesMethod(jc);
		addConvertToWidgetPositionMethod(jc);
		addGetStyleRangeAtPositionMethod(jc);
		addAddSelectionChangedListenerMethod(jc);
		addRemoveSelectionChangedListenerMethod(jc);
		addSetSelectionMethod(jc);
		addGetSelectionMethod(jc);
		addSelectionChangedMethod(jc);
		addHandleContentOutlineSelectionMethod(jc);
	}

	private void addHandleContentOutlineSelectionMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Notifies the editor that the selection in the outline page has " +
			"changed. This method assumes that the origin of the selection " +
			"is the outline page or its tree viewer."
		);
		sc.add("private void handleContentOutlineSelection(" + I_SELECTION(sc) + " selection) {");
		sc.add("if (selection.isEmpty()) {");
		sc.addComment("Ignore empty selections");
		sc.add("return;");
		sc.add("}");
		sc.add("editor.setSelection(selection);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSelectionChangedMethod(JavaComposite sc) {
		sc.addJavadoc(
			"This method is called by the outline page if its selection was " +
			"changed. This is accomplished by adding this class as selection " +
			"change listener to the outline page, which is performed by the " +
			"editor."
		);
		sc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT(sc) + " event) {");
		sc.add("if (event.getSelection() instanceof " + TREE_SELECTION(sc) + ") {");
		sc.add("handleContentOutlineSelection(event.getSelection());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSelectionMethod(JavaComposite sc) {
		sc.add("public " + I_SELECTION(sc) + " getSelection() {");
		sc.add("return selection;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetSelectionMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Updates the current selection and notifies registered selection " +
			"listeners (e.g., the outline page) about this."
		);
		sc.add("public void setSelection(" + I_SELECTION(sc) + " selection) {");
		sc.add("this.selection = selection;");
		sc.add(SELECTION_CHANGED_EVENT(sc) + " event = new " + SELECTION_CHANGED_EVENT(sc) + "(this, selection);");
		sc.add("for (" + I_SELECTION_CHANGED_LISTENER(sc) + " listener : selectionChangedListeners) {");
		sc.add("listener.selectionChanged(event);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveSelectionChangedListenerMethod(JavaComposite sc) {
		sc.add("public void removeSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER(sc) + " listener) {");
		sc.add("selectionChangedListeners.remove(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddSelectionChangedListenerMethod(JavaComposite sc) {
		sc.add("public void addSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER(sc) + " listener) {");
		sc.add("selectionChangedListeners.add(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStyleRangeAtPositionMethod(JavaComposite sc) {
		sc.add("private " + STYLE_RANGE(sc) + " getStyleRangeAtPosition(" + POSITION(sc) + " position) {");
		sc.add(STYLE_RANGE(sc) + " styleRange = null;");
		sc.add("try {");
		sc.add("styleRange = textWidget.getStyleRangeAtOffset(position.offset);");
		sc.add("} catch (IllegalArgumentException iae) {");
		// TODO handle exception?
		sc.add("}");
		sc.add("if (styleRange == null) {");
		sc.add("styleRange = new " + STYLE_RANGE(sc) + "(position.offset, position.length, black, null);");
		sc.add("} else {");
		sc.add("styleRange.length = position.length;");
		sc.add("}");
		sc.add("return styleRange;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConvertToWidgetPositionMethod(JavaComposite sc) {
		sc.add("private " + POSITION(sc) + " convertToWidgetPosition(" + POSITION(sc) + " position) {");
		sc.add("if (position == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("int startOffset = projectionViewer.modelOffset2WidgetOffset(position.offset);");
		sc.add("int endOffset = projectionViewer.modelOffset2WidgetOffset(position.offset + position.length);");
		sc.add("if (endOffset - startOffset != position.length || startOffset == -1 || textWidget.getCharCount() < endOffset) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return new " + POSITION(sc) + "(startOffset, endOffset - startOffset);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResetValuesMethod(JavaComposite sc) {
		sc.addJavadoc("Resets the changed values after setting the preference pages.");
		sc.add("public void resetValues() {");
		sc.add("isHighlightBrackets = preferenceStore.getBoolean(" + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_CHECKBOX);");
		sc.add("bracketColor = colorManager.getColor(" + PREFERENCE_CONVERTER(sc) + ".getColor(preferenceStore, " + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_COLOR));");
		sc.add("bracketSet.resetBrackets(preferenceStore);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addUpdateEObjectSelectionMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Updates the currently selected EObject and notifies registered " +
			"selection listeners (e.g., the outline page) about this " +
			"asynchronously."
		);
		sc.add("public void updateEObjectSelection() {");
		sc.add("display.asyncExec(new Runnable() {");
		sc.add("public void run() {");
		sc.add(E_OBJECT(sc) + " selectedEObject = occurrence.getEObjectAtCurrentPosition();");
		sc.add("if (selectedEObject != null) {");
		sc.add("setSelection(new " + eObjectSelectionClassName + "(selectedEObject));");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveHighlightingCategoryMethod(JavaComposite sc) {
		// TODO maybe rename method to removeBracketHighlighting and move call to removeAnnotations() to another method?
		sc.add("private void removeHighlightingCategory(" + I_DOCUMENT(sc) + " document, String category) {");
		sc.add(POSITION(sc) + "[] positions = positionHelper.getPositions(document, category);");
		sc.add("if (category.equals(" + positionCategoryClassName + ".BRACKET.toString())) {");
		sc.add(STYLE_RANGE(sc) + " styleRange;");
		sc.add("for (" + POSITION(sc) + " position : positions) {");
		sc.add(POSITION(sc) + " tmpPosition = convertToWidgetPosition(position);");
		sc.add("if (tmpPosition != null) {");
		sc.add("styleRange = getStyleRangeAtPosition(tmpPosition);");
		sc.add("styleRange.borderStyle = " + SWT(sc) + ".NONE;");
		sc.add("styleRange.borderColor = null;");
		sc.add("styleRange.background = null;");
		sc.add("textWidget.setStyleRange(styleRange);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("positionHelper.removePositions(document, category);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveHighlightingMethod(JavaComposite sc) {
		sc.add("private void removeHighlighting() {");
		sc.add(I_DOCUMENT(sc) + " document = projectionViewer.getDocument();");
		sc.addComment("remove highlighted matching brackets");
		sc.add("removeHighlightingCategory(document, " + positionCategoryClassName + ".BRACKET.toString());");
		//sc.addComment("remove annotations for occurrences and declarations");
		//sc.add("removeOccurrenceAndDeclarationAnnotations();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetBracketHighlightingMethod(JavaComposite sc) {
		sc.add("private void setBracketHighlighting(" + I_DOCUMENT(sc) + " document) {");
		sc.add(STYLE_RANGE(sc) + " styleRange = null;");
		sc.add(POSITION(sc) + "[] positions = positionHelper.getPositions(document, " + positionCategoryClassName + ".BRACKET.toString());");
		sc.addLineBreak();
		sc.add("for (" + POSITION(sc) + " position : positions) {");
		sc.add(POSITION(sc) + " tmpPosition = convertToWidgetPosition(position);");
		sc.add("if (tmpPosition != null) {");
		sc.add("styleRange = getStyleRangeAtPosition(tmpPosition);");
		sc.add("styleRange.borderStyle = " + SWT(sc) + ".BORDER_SOLID;");
		sc.add("styleRange.borderColor = bracketColor;");
		sc.add("if (styleRange.foreground == null) {");
		sc.add("styleRange.foreground = black;");
		sc.add("}");
		sc.add("textWidget.setStyleRange(styleRange);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetHighlightingMethod(JavaComposite sc) {
		sc.add("private void setHighlighting() {");
		sc.add(I_DOCUMENT(sc) + " document = projectionViewer.getDocument();");
		sc.add("if (isHighlightBrackets) {");
		sc.add("int offset = bracketSet.getCaretOffset((" + I_SOURCE_VIEWER(sc) + ") editor.getViewer(), textWidget);");
		sc.add("bracketSet.findAndHighlightMatchingBrackets(document, offset);");
		sc.add("}");
		sc.add("occurrence.updateOccurrenceAnnotations();");
		sc.add("setBracketHighlighting(document);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addListenersMethod(StringComposite sc) {
		sc.add("private void addListeners(" + editorClassName + " editor) {");
		sc.add("UpdateHighlightingListener hl = new UpdateHighlightingListener();");
		sc.add("textWidget.addKeyListener(hl);");
		sc.add("textWidget.addVerifyListener(hl);");
		sc.add("textWidget.addMouseListener(hl);");
		sc.add("editor.addBackgroundParsingListener(hl);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates the highlighting manager class.",
			"@param textResource the text resource to be provided to other classes",
			"@param sourceviewer the source viewer converts offset between master and slave documents",
			"@param colorManager the color manager provides highlighting colors",
			"@param editor the editor that uses this highlighting object"
		);
		sc.add("public " + getResourceClassName() + "(" + iTextResourceClassName + " textResource, " + PROJECTION_VIEWER(sc) + " projectionViewer, " + colorManagerClassName + " colorManager, " + editorClassName + " editor) {");
		sc.add("this.display = " + DISPLAY(sc) + ".getCurrent();");
		sc.add("projectionViewer.getSelectionProvider();");
		sc.add("this.preferenceStore = " + uiPluginActivatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("this.editor = editor;");
		sc.add("this.textWidget = projectionViewer.getTextWidget();");
		sc.add("this.projectionViewer = projectionViewer;");
		sc.add("this.occurrence = new " + occurrenceClassName + "(textResource, projectionViewer);");
		sc.add("this.bracketSet = new " + bracketSetClassName + "();");
		sc.add("this.colorManager = colorManager;");
		sc.add("this.isHighlightBrackets = preferenceStore.getBoolean(" + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_CHECKBOX);");
		sc.add("this.bracketColor = colorManager.getColor(" + PREFERENCE_CONVERTER(sc) + ".getColor(preferenceStore, " + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_COLOR));");
		sc.add("this.black = colorManager.getColor(new " + RGB(sc) + "(0, 0, 0));");
		sc.addLineBreak();
		sc.add("addListeners(editor);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPositionHelperClass(JavaComposite sc) {
		sc.addJavadoc(
			"A key and mouse listener for the highlighting. It removes the " +
			"highlighting before documents change. No highlighting is set after " +
			"document changes to increase the performance. Occurrences are not searched " +
			"if the caret is still in the same token to increase the performance."
		);
		sc.add("private final class UpdateHighlightingListener implements " + KEY_LISTENER(sc) + ", " + VERIFY_LISTENER(sc) + ", " + MOUSE_LISTENER(sc) + ", " + iBackgroundParsingListenerClassName + " {");
		sc.addLineBreak();
		sc.add("private boolean changed = false;");
		sc.add("private int caret = -1;");
		sc.addLineBreak();
		sc.add("public void keyPressed(" + KEY_EVENT(sc) + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void keyReleased(" + KEY_EVENT(sc) + " e) {");
		sc.add("if (changed) {");
		sc.add("changed = false;");
		sc.add("return;");
		sc.add("}");
		sc.add("refreshHighlighting();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private void refreshHighlighting() {");
		sc.add("if (textWidget.isDisposed()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("int textCaret = textWidget.getCaretOffset();");
		sc.add("if (textCaret < 0 || textCaret > textWidget.getCharCount()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (textCaret != caret) {");
		sc.add("caret = textCaret;");
		sc.add("removeHighlighting();");
		sc.add("setHighlighting();");
		sc.add("updateEObjectSelection();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void verifyText(" + VERIFY_EVENT(sc) + " e) {");
		sc.add("occurrence.resetTokenRegion();");
		sc.add("removeHighlighting();");
		sc.add("changed = true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void mouseDoubleClick(" + MOUSE_EVENT(sc) + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void mouseDown(" + MOUSE_EVENT(sc) + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("1-left click, 2-middle click,");
		sc.add("public void mouseUp(" + MOUSE_EVENT(sc) + " e) {");
		sc.addComment("3-right click");
		sc.add("if (e.button != 1) {");
		sc.add("return;");
		sc.add("}");
		sc.add("refreshHighlighting();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void parsingCompleted(" + RESOURCE(sc) + " resource) {");
		sc.add("display.asyncExec(new Runnable() {");
		sc.addLineBreak();
		sc.add("public void run() {");
		sc.add("refreshHighlighting();");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
