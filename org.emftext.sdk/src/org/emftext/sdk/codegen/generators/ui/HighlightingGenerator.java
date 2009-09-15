package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.GenerationContext;
import java.io.PrintWriter;
import org.emftext.sdk.codegen.EArtifact;

public class HighlightingGenerator extends BaseGenerator {

	private String textTokenScannerClassName;
	private String colorManagerClassName;
	private String editorClassName;
	private String activatorClassName;
	
	private String positionHelperClassName;
	private String occurenceClassName;
	private String bracketSetClassName;
	private String positionCategoryClassName;
	private String eObjectSelectClassName;

	public HighlightingGenerator(GenerationContext context) {
		super(context, EArtifact.HIGHLIGHTING);
		textTokenScannerClassName = getContext().getQualifiedClassName(EArtifact.TEXT_TOKEN_SCANNER);
		colorManagerClassName = getContext().getQualifiedClassName(EArtifact.COLOR_MANAGER);
		editorClassName = getContext().getQualifiedClassName(EArtifact.EDITOR);
		activatorClassName = getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR);
		positionHelperClassName = getContext().getQualifiedClassName(EArtifact.POSITION_HELPER);
		occurenceClassName = getContext().getQualifiedClassName(EArtifact.OCCURENCE);
		bracketSetClassName = getContext().getQualifiedClassName(EArtifact.BRACKET_SET);
		positionCategoryClassName = getContext().getQualifiedClassName(EArtifact.POSITION_CATEGORY);
		eObjectSelectClassName = getContext().getQualifiedClassName(EArtifact.E_OBJECT_SELECTION);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A manager class for the highlighting of occurrences and brackets.");
		sc.add("public class " + getResourceClassName() + " implements " + I_SELECTION_PROVIDER + ", " + I_SELECTION_CHANGED_LISTENER + " {");
		sc.addLineBreak();
		addFields(sc);
		addPositionHelperClass(sc);
		addConstructor(sc);
		addListenersMethod(sc);
		addSetHighlightingMethod(sc);
		addSetCategoryHighlightingMethod(sc);
		addRemoveHighlightingMethod(sc);
		addRemoveHighlightingCategoryMethod(sc);
		addSetEObjectSelectionMethod(sc);
		addResetValuesMethod(sc);
		addConvertToWidgedPositionMethod(sc);
		addGetStyleRangeAtPositionMethod(sc);

		addAddSelectionChangedListenerMethod(sc);
		addremoveSelectionChangedListenerMethod(sc);
		addsetSelectionMethod(sc);
		addgetSelectionMethod(sc);
		addselectionChangedMethod(sc);
		addHandleContentOutlineSelectionMethod(sc);
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addHandleContentOutlineSelectionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private void handleContentOutlineSelection(" + I_SELECTION + " selection) {");
		sc.add("if (!selection.isEmpty() && selection instanceof " + I_STRUCTURED_SELECTION + ") {");
		sc.add(OBJECT + " selectedElement = ((" + I_STRUCTURED_SELECTION + ") selection).getFirstElement();");
		sc.add("if (selectedElement instanceof " + E_OBJECT + ") {");
		sc.add(E_OBJECT + " selectedEObject = (" + E_OBJECT + ") selectedElement;");
		sc.add(RESOURCE + " resource = selectedEObject.eResource();");
		sc.add("if (resource instanceof " + I_TEXT_RESOURCE + ") {");
		sc.add(I_TEXT_RESOURCE + " textResource = (" + I_TEXT_RESOURCE + ") resource;");
		sc.add(I_LOCATION_MAP + " locationMap = textResource.getLocationMap();");
		sc.add("int elementCharStart = locationMap.getCharStart(selectedEObject);");
		sc.add("int elementCharEnd = locationMap.getCharEnd(selectedEObject);");
		sc.add("// selectAndReveal(elementCharStart, elementCharEnd -");
		sc.add("// elementCharStart + 1);");
		sc.add("// this.getSelectionProvider().setSelection(selection);");
		sc.add(TEXT_SELECTION + " textEditorSelection = new " + TEXT_SELECTION + "(elementCharStart, elementCharEnd - elementCharStart + 1);");
		sc.add("projectionViewer.getSelectionProvider().setSelection(");
		sc.add("textEditorSelection);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addselectionChangedMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void selectionChanged(");
		sc.add(SELECTION_CHANGED_EVENT + " event) {");
		sc.addLineBreak();
		sc.add(OBJECT + " oldSelection = null;");
		sc.add(OBJECT + " newSelection = null;");
		sc.add("if (getSelection() instanceof " + I_STRUCTURED_SELECTION + ") {");
		sc.add("oldSelection = ((" + I_STRUCTURED_SELECTION + ")getSelection()).getFirstElement();");
		sc.add("}");
		sc.add("if (event.getSelection() instanceof " + I_STRUCTURED_SELECTION + ") {");
		sc.add("newSelection = ((" + I_STRUCTURED_SELECTION + ")event.getSelection()).getFirstElement();");
		sc.add("}");
		sc.add("if (newSelection != null && !newSelection.equals(oldSelection)) {");
		sc.add("selection = event.getSelection();");
		sc.add("handleContentOutlineSelection(event.getSelection());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addgetSelectionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + I_SELECTION + " getSelection() {");
		sc.add("return selection;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addsetSelectionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void setSelection(" + I_SELECTION + " selection) {");
		sc.add("this.selection = selection;");
		sc.add("for (" + I_SELECTION_CHANGED_LISTENER + " listener : selectionChangedListeners) {");
		sc.add("listener.selectionChanged(new " + SELECTION_CHANGED_EVENT + "(this, selection));");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addremoveSelectionChangedListenerMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void removeSelectionChangedListener(");
		sc.add(I_SELECTION_CHANGED_LISTENER + " listener) {");
		sc.add("selectionChangedListeners.remove(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddSelectionChangedListenerMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void addSelectionChangedListener(");
		sc.add(I_SELECTION_CHANGED_LISTENER + " listener) {");
		sc.add("selectionChangedListeners.add(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private " + LIST + "<" + I_SELECTION_CHANGED_LISTENER + "> selectionChangedListeners = new " + ARRAY_LIST + "<" + I_SELECTION_CHANGED_LISTENER + ">();");
		sc.add("private " + I_SELECTION + " selection = null;");
		sc.add("private final static " + positionHelperClassName + " positionHelper = new " + positionHelperClassName + "();");
		sc.add("private boolean isHighlightBrackets = true;");
		sc.add("private boolean isHighlightOccurrences = true;");
		sc.add("private " + textTokenScannerClassName + " scanner;");
		sc.add("private " + colorManagerClassName + " colorManager;");
		sc.add("private " + COLOR + " definitionColor;");
		sc.add("private " + COLOR + " proxyColor;");
		sc.add("private " + COLOR + " bracketColor;");
		sc.add("private " + COLOR + " black;");
		sc.add("private " + STYLE_RANGE + " lastStyleRange;");
		sc.add("private " + STYLED_TEXT + " textWidget;");
		sc.add("private " + I_PREFERENCE_STORE + " preferenceStore;");
		sc.add("private " + PROJECTION_VIEWER + " projectionViewer;");
		sc.add("private " + occurenceClassName + " occurrence;");
		sc.add("private " + bracketSetClassName + " bracketSet;");
		sc.add("private " + DISPLAY + " display;");
		sc.addLineBreak();
		sc.addLineBreak();
	}

	private void addGetStyleRangeAtPositionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private " + STYLE_RANGE + " getStyleRangeAtPosition(" + POSITION + " position) {");
		sc.add(STYLE_RANGE + " styleRange = null;");
		sc.add("try {");
		sc.add("styleRange = textWidget.getStyleRangeAtOffset(position.offset);");
		sc.add("} catch (IllegalArgumentException iae) {");
		sc.add("// TODO: handle exception");
		sc.add("}");
		sc.add("if (styleRange == null) {");
		sc.add("styleRange = new " + STYLE_RANGE + "(position.offset, position.length, black, null);");
		sc.add("} else {");
		sc.add("styleRange.length = position.length;");
		sc.add("}");
		sc.add("return styleRange;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConvertToWidgedPositionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private " + POSITION + " convertToWidgedPosition(" + POSITION + " position) {");
		sc.add("if (position == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("int startOffset = projectionViewer.modelOffset2WidgetOffset(position.offset);");
		sc.add("int endOffset = projectionViewer.modelOffset2WidgetOffset(position.offset + position.length);");
		sc.add("if (endOffset - startOffset != position.length || startOffset == -1) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return new " + POSITION + "(startOffset, endOffset - startOffset);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResetValuesMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Resets the changed values after setting the preference pages.");
		sc.add("public void resetValues() {");
		sc.add("isHighlightBrackets = preferenceStore.getBoolean(" + PREFERENCE_CONSTANTS + ".EDITOR_MATCHING_BRACKETS_CHECKBOX);");
		sc.add("isHighlightOccurrences = preferenceStore.getBoolean(" + PREFERENCE_CONSTANTS + ".EDITOR_OCCURRENCE_CHECKBOX);");
		sc.add("bracketColor = colorManager.getColor(" + PREFERENCE_CONVERTER + ".getColor(preferenceStore, " + PREFERENCE_CONSTANTS + ".EDITOR_MATCHING_BRACKETS_COLOR));");
		sc.add("definitionColor = colorManager.getColor(" + PREFERENCE_CONVERTER + ".getColor(preferenceStore, " + PREFERENCE_CONSTANTS + ".EDITOR_DEFINITION_COLOR));");
		sc.add("proxyColor = colorManager.getColor(" + PREFERENCE_CONVERTER + ".getColor(preferenceStore, " + PREFERENCE_CONSTANTS + ".EDITOR_PROXY_COLOR));");
		sc.add("bracketSet.resetBrackets();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetEObjectSelectionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void setEObjectSelection() {");
		sc.add("display.syncExec(new Runnable() {");
		sc.add("public void run() {");
		sc.add(E_OBJECT + " selectedEObject = occurrence.getEObjectAtCurrentPosition();");
		sc.add("if (selectedEObject != null) {");
		sc.add("setSelection(new " + eObjectSelectClassName + "(selectedEObject, false));");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveHighlightingCategoryMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private void removeHighlightingCategory(" + I_DOCUMENT + " document, String category) {");
		sc.add(POSITION + "[] positions = positionHelper.getPositions(document, category);");
		sc.add("boolean isOccurrence = (category.equals(" + positionCategoryClassName + ".DEFINTION.toString()) || category.equals(" + positionCategoryClassName + ".PROXY.toString())) && lastStyleRange != null;");
		sc.add("if (category.equals(" + positionCategoryClassName + ".BRACKET.toString())) {");
		sc.add(STYLE_RANGE + " styleRange;");
		sc.add("for (" + POSITION + " position : positions) {");
		sc.add(POSITION + " tmpPosition = convertToWidgedPosition(position);");
		sc.add("if (tmpPosition != null) {");
		sc.add("styleRange = getStyleRangeAtPosition(tmpPosition);");
		sc.add("styleRange.borderStyle = " + SWT + ".NONE;");
		sc.add("styleRange.borderColor = null;");
		sc.add("styleRange.background = null;");
		sc.add("textWidget.setStyleRange(styleRange);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (isOccurrence) {");
		sc.add("for (" + POSITION + " position : positions) {");
		sc.add(POSITION + " tmpPosition = convertToWidgedPosition(position);");
		sc.add("if (tmpPosition != null) {");
		sc.add("lastStyleRange.start = tmpPosition.offset;");
		sc.add("textWidget.setStyleRange(lastStyleRange);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("positionHelper.removePositions(document, category);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveHighlightingMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private void removeHighlighting() {");
		sc.add(I_DOCUMENT + " document = projectionViewer.getDocument();");
		sc.add("removeHighlightingCategory(document, " + positionCategoryClassName + ".BRACKET.toString());");
		sc.add("if (occurrence.isToRemoveHighlighting()) {");
		sc.add("removeHighlightingCategory(document, " + positionCategoryClassName + ".DEFINTION.toString());");
		sc.add("removeHighlightingCategory(document, " + positionCategoryClassName + ".PROXY.toString());");
		sc.add("lastStyleRange = null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetCategoryHighlightingMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private void setCategoryHighlighting(" + I_DOCUMENT + " document, String category) {");
		sc.add(STYLE_RANGE + " styleRange = null;");
		sc.add(POSITION + "[] positions = positionHelper.getPositions(document, category);");
		sc.addLineBreak();
		sc.add("if (category.equals(" + positionCategoryClassName + ".PROXY.toString())) {");
		sc.add("if (lastStyleRange == null && positions.length > 0) {");
		sc.add("styleRange = getStyleRangeAtPosition(positions[0]);");
		sc.add("if (styleRange.foreground == null) {");
		sc.add("styleRange.foreground = black;");
		sc.add("}");
		sc.add("lastStyleRange = (" + STYLE_RANGE + ") styleRange.clone();");
		sc.add("}");
		sc.add("if (lastStyleRange != null) {");
		sc.add("if (styleRange == null) {");
		sc.add("styleRange = (" + STYLE_RANGE + ") lastStyleRange.clone();");
		sc.add("}");
		sc.add("styleRange.background = proxyColor;");
		sc.add("}");
		sc.add("}");
		sc.add("for (" + POSITION + " position : positions) {");
		sc.add(POSITION + " tmpPosition = convertToWidgedPosition(position);");
		sc.add("if (tmpPosition != null) {");
		sc.add("if (category.equals(" + positionCategoryClassName + ".DEFINTION.toString())) {");
		sc.add("styleRange = getStyleRangeAtPosition(tmpPosition);");
		sc.add("if (styleRange.foreground == null) {");
		sc.add("styleRange.foreground = black;");
		sc.add("}");
		sc.add("lastStyleRange = (" + STYLE_RANGE + ") styleRange.clone();");
		sc.add("styleRange.background = definitionColor;");
		sc.add("textWidget.setStyleRange(styleRange);");
		sc.add("}");
		sc.add("if (category.equals(" + positionCategoryClassName + ".PROXY.toString())) {");
		sc.add("if (styleRange == null)");
		sc.add("return;");
		sc.add("styleRange.start = tmpPosition.offset;");
		sc.add("textWidget.setStyleRange(styleRange);");
		sc.add("}");
		sc.add("if (category.equals(" + positionCategoryClassName + ".BRACKET.toString())) {");
		sc.add("styleRange = getStyleRangeAtPosition(tmpPosition);");
		sc.add("styleRange.borderStyle = " + SWT + ".BORDER_SOLID;");
		sc.add("styleRange.borderColor = bracketColor;");
		sc.add("if (styleRange.foreground == null)");
		sc.add("styleRange.foreground = black;");
		sc.add("textWidget.setStyleRange(styleRange);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetHighlightingMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private void setHighlighting() {");
		sc.add(I_DOCUMENT + " document = projectionViewer.getDocument();");
		sc.add("if (isHighlightBrackets) {");
		sc.add("bracketSet.matchingBrackets();");
		sc.add("}");
		sc.add("if (isHighlightOccurrences) {");
		sc.add("occurrence.handleOccurrenceHighlighting(bracketSet);");
		sc.add("}");
		sc.add("if (occurrence.isPositionsChanged()) {");
		sc.add("setCategoryHighlighting(document,");
		sc.add(positionCategoryClassName + ".DEFINTION.toString());");
		sc.add("setCategoryHighlighting(document,");
		sc.add(positionCategoryClassName + ".PROXY.toString());");
		sc.add("}");
		sc.add("setCategoryHighlighting(document, " + positionCategoryClassName + ".BRACKET.toString());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addListenersMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private void addListeners(" + editorClassName + " editor) {");
		sc.add("UpdateHighlightingListener hl = new UpdateHighlightingListener();");
		sc.add("textWidget.addKeyListener(hl);");
		sc.add("textWidget.addVerifyListener(hl);");
		sc.add("textWidget.addMouseListener(hl);");
		sc.add("editor.addBackgroundParsingListener(hl);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Creates the highlighting manager class.");
		sc.add("//");
		sc.add("// @param textResource");
		sc.add("//            the text resource to be provided to other classes");
		sc.add("// @param sourceviewer");
		sc.add("//            the source viewer converts offset between master and slave");
		sc.add("//            documents");
		sc.add("// @param colorManager");
		sc.add("//            the color manager provides highlighting colors");
		sc.add("// @param emfTextEditor");
		sc.add("// @param iPropertySheetPage");
		sc.add("public " + getResourceClassName() + "(" + I_TEXT_RESOURCE + " textResource, " + PROJECTION_VIEWER + " sourceviewer, " + colorManagerClassName + " colorManager, " + editorClassName + " editor) {");
		sc.add("this.display = " + DISPLAY + ".getCurrent();");
		sc.add("sourceviewer.getSelectionProvider();");
		sc.add("preferenceStore = " + activatorClassName + ".getDefault()");
		sc.add(".getPreferenceStore();");
		sc.add("textWidget = sourceviewer.getTextWidget();");
		sc.add("projectionViewer = sourceviewer;");
		sc.add("scanner = new " + textTokenScannerClassName + "(textResource, colorManager);");
		sc.add("occurrence = new " + occurenceClassName + "(textResource, sourceviewer, scanner);");
		sc.add("bracketSet = new " + bracketSetClassName + "(sourceviewer, textResource.getURI().fileExtension());");
		sc.add("this.colorManager = colorManager;");
		sc.add("isHighlightBrackets = preferenceStore.getBoolean(" + PREFERENCE_CONSTANTS + ".EDITOR_MATCHING_BRACKETS_CHECKBOX);");
		sc.add("isHighlightOccurrences = preferenceStore.getBoolean(" + PREFERENCE_CONSTANTS + ".EDITOR_OCCURRENCE_CHECKBOX);");
		sc.add("definitionColor = colorManager.getColor(" + PREFERENCE_CONVERTER + ".getColor(preferenceStore, " + PREFERENCE_CONSTANTS + ".EDITOR_DEFINITION_COLOR));");
		sc.add("proxyColor = colorManager.getColor(" + PREFERENCE_CONVERTER + ".getColor(preferenceStore, " + PREFERENCE_CONSTANTS + ".EDITOR_PROXY_COLOR));");
		sc.add("bracketColor = colorManager.getColor(" + PREFERENCE_CONVERTER + ".getColor(preferenceStore, " + PREFERENCE_CONSTANTS + ".EDITOR_MATCHING_BRACKETS_COLOR));");
		sc.add("black = colorManager.getColor(new " + RGB + "(0, 0, 0));");
		sc.addLineBreak();
		sc.add("addListeners(editor);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPositionHelperClass(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// A key and mouse <code>" + LISTENER + "</code> for the highlighting. Removes the");
		sc.add("// highlighting before document change. No highlighting is set after");
		sc.add("// document change to increase the performance. No finding new occurrences");
		sc.add("// if the caret is still in the same token to increase the performance.");
		sc.add("private final class UpdateHighlightingListener implements " + KEY_LISTENER + ", " + VERIFY_LISTENER + ", " + MOUSE_LISTENER + ", " + I_BACKGROUND_PARSING_LISTENER + " {");
		sc.addLineBreak();
		sc.add("private boolean changed = false;");
		sc.add("private int caret = -1;");
		sc.addLineBreak();
		sc.add("public void keyPressed(" + KEY_EVENT + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void keyReleased(" + KEY_EVENT + " e) {");
		sc.add("if (changed) {");
		sc.add("changed = false;");
		sc.add("return;");
		sc.add("}");
		sc.add("refreshHighlighting();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private void refreshHighlighting() {");
		sc.add("int textCaret = textWidget.getCaretOffset();");
		sc.add("if (textCaret < 0 || textCaret > textWidget.getCharCount()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (textCaret != caret) {");
		sc.add("caret = textCaret;");
		sc.add("removeHighlighting();");
		sc.add("setHighlighting();");
		sc.add("setEObjectSelection();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void verifyText(" + VERIFY_EVENT + " e) {");
		sc.add("occurrence.resetTokenRegion();");
		sc.add("removeHighlighting();");
		sc.add("changed = true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void mouseDoubleClick(" + MOUSE_EVENT + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void mouseDown(" + MOUSE_EVENT + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("// 1-left click, 2-middle click,");
		sc.add("public void mouseUp(" + MOUSE_EVENT + " e) {");
		sc.add("// 3-right click");
		sc.add("if (e.button != 1) {");
		sc.add("return;");
		sc.add("}");
		sc.add("refreshHighlighting();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void parsingCompleted(" + RESOURCE + " resource) {");
		sc.add("display.syncExec(new Runnable() {");
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
