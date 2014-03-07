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

import static de.devboost.codecomposers.java.ClassNameConstants.ITERATOR;
import static de.devboost.codecomposers.java.ClassNameConstants.LINKED_HASH_MAP;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BUFFERED_READER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BUNDLE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.FILE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.FILE_INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.FILE_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.INPUT_STREAM_READER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.MESSAGE_DIGEST;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.NO_SUCH_ALGORITHM_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.OUTPUT_STREAM_WRITER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.PLATFORM;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.SAFE_RUNNER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.URI;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_MEMENTO;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PART_LISTENER2;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PART;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PART_REFERENCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MESSAGE_DIALOG;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.POSITION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROJECTION_ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROJECTION_ANNOTATION_MODEL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SAFE_RUNNABLE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SHELL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.XML_MEMENTO;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class CodeFoldingManagerGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"This manager adds new projection annotations for the code folding and deletes " +
			"old projection annotations with lines < 3. It is needed to hold the toggle " +
			"states. It provides the ability to restore the toggle states between Eclipse " +
			"sessions and after closing, opening as well."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addFoldingUpdateListenerClass(sc);
		addEditorOnCloseListenerClass(sc);
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addAddCloseListenerMethod(sc);
		addUpdateCodefoldingMethod(sc);
		addIsInAdditionsMethod(sc);
		addAddPositionMethod(sc);
		addSaveCodeFoldingMethod(sc);
		addRestoreCodeFoldingMethod(sc);
		addRestoreCodeFoldingStateFromFileMethod(sc);
		addSaveCodeFoldingStateFileMethod(sc);
		addGetCodeFoldingStateFileMethod(sc);
		addMakeMD5Method(sc);
		addCalculatePositionsMethod(sc);
		addGetAllContentsMethod(sc);
		addGetOffsetOfNextLineMethod(sc);
	}

	private void addGetOffsetOfNextLineMethod(JavaComposite sc) {
		sc.add("private int getOffsetOfNextLine(" + I_DOCUMENT(sc) + " document, int offset) {");
		sc.add("int end = document.getLength();");
		sc.add("int nextLineOffset = offset;");
		sc.add("if (offset < 0 || offset > end) {");
		sc.add("return -1;");
		sc.add("}");
		sc.add("while (nextLineOffset < end) {");
		sc.add("String charAtOffset = \"\";");
		sc.add("try {");
		sc.add("charAtOffset += document.getChar(nextLineOffset);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.add("return -1;");
		sc.add("}");
		sc.add("if (charAtOffset.matches(\"\\\\S\")) {");
		sc.add("return nextLineOffset;");
		sc.add("}");
		sc.add("if (charAtOffset.equals(\"\\n\")) {");
		sc.add("return nextLineOffset + 1;");
		sc.add("}");
		sc.add("nextLineOffset++;");
		sc.add("}");
		sc.add("return offset;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAllContentsMethod(JavaComposite sc) {
		sc.add("private " + LIST(sc) + "<" + E_OBJECT(sc) + "> getAllContents(" + E_OBJECT(sc) + "[] contentArray) {");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> result = new " + ARRAY_LIST(sc) + "<" + E_OBJECT(sc) + ">();");
		sc.add("for (" + E_OBJECT(sc) + " eObject : contentArray) {");
		sc.add("if (eObject == null) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("result.add(eObject);");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> contents = eObject.eContents();");
		sc.add("if (contents == null) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("result.addAll(getAllContents(contents.toArray(new " + E_OBJECT(sc) + "[0])));");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCalculatePositionsMethod(JavaComposite sc) {
		sc.add("protected void calculatePositions() {");
		sc.add(textResourceClassName + " textResource = (" + textResourceClassName + ") editor.getResource();");
		sc.add(I_DOCUMENT(sc) + " document = sourceViewer.getDocument();");
		sc.add("if (textResource == null || document == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (textResource.hasErrors()) {");
		sc.add("return;");
		sc.add("}");
		sc.add("final " + LIST(sc) + "<" + POSITION(sc) + "> positions = new " + ARRAY_LIST(sc) + "<" + POSITION(sc) + ">();");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add(E_CLASS(sc) + "[] foldableClasses = textResource.getMetaInformation().getFoldableClasses();");
		sc.add("if (foldableClasses == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (foldableClasses.length < 1) {");
		sc.add("return;");
		sc.add("}");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> contents = textResource.getContents();");
		sc.add(E_OBJECT(sc) + "[] contentArray = contents.toArray(new " + E_OBJECT(sc) + "[0]);");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> allContents = getAllContents(contentArray);");
		sc.add("for (" + E_OBJECT(sc) + " nextObject : allContents) {");
		sc.add("boolean isFoldable = false;");
		sc.add("for (" + E_CLASS(sc) + " eClass : foldableClasses) {");
		sc.add("if (nextObject.eClass().equals(eClass)) {");
		sc.add("isFoldable = true;");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("if (!isFoldable) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("int offset = locationMap.getCharStart(nextObject);");
		sc.add("int length = locationMap.getCharEnd(nextObject) + 1 - offset;");
		sc.add("try {");
		sc.add("int lines = document.getNumberOfLines(offset, length);");
		sc.add("if (lines < 2) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("length = getOffsetOfNextLine(document, length + offset) - offset;");
		sc.add("if (offset >= 0 && length > 0) {");
		sc.add("positions.add(new " + POSITION(sc) + "(offset, length));");
		sc.add("}");
		sc.add("}");
		sc.add(DISPLAY(sc) + ".getDefault().asyncExec(new Runnable() {");
		sc.add("public void run() {");
		sc.add("updateCodefolding(positions);");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMakeMD5Method(JavaComposite sc) {
		sc.add("private String makeMD5(String text) {");
		sc.add(MESSAGE_DIGEST(sc) + " md = null;");
		sc.add("byte[] encryptMsg = null;");
		sc.add("try {");
		sc.add("md = " + MESSAGE_DIGEST(sc) + ".getInstance(\"MD5\");");
		sc.add("encryptMsg = md.digest(text.getBytes());");
		sc.add("} catch (" + NO_SUCH_ALGORITHM_EXCEPTION(sc) + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"NoSuchAlgorithmException while creating MD5 checksum.\", e);");
		sc.add("return \"\";");
		sc.add("}");
		sc.add("String swap = \"\";");
		sc.add("String byteStr = \"\";");
		sc.add("StringBuffer strBuf = new StringBuffer();");
		sc.add("for (int i = 0; i <= encryptMsg.length - 1; i++) {");
		sc.add("byteStr = Integer.toHexString(encryptMsg[i]);");
		sc.add("switch (byteStr.length()) {");
		sc.add("case 1:");
		sc.addComment("if hex-number length is 1, add a '0' before");
		sc.add("swap = \"0\" + Integer.toHexString(encryptMsg[i]);");
		sc.add("break;");
		sc.add("case 2:");
		sc.addComment("correct hex-letter");
		sc.add("swap = Integer.toHexString(encryptMsg[i]);");
		sc.add("break;");
		sc.add("case 8:");
		sc.addComment("get the correct substring");
		sc.add("swap = (Integer.toHexString(encryptMsg[i])).substring(6, 8);");
		sc.add("break;");
		sc.add("}");
		sc.add("strBuf.append(swap);");
		sc.addComment("appending swap to get complete hash-key");
		sc.add("}");
		sc.add("return strBuf.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCodeFoldingStateFileMethod(JavaComposite sc) {
		sc.add("private " + FILE(sc) + " getCodeFoldingStateFile(String uriString) {");
		sc.add(BUNDLE(sc) + " bundle = " + PLATFORM(sc) + ".getBundle(" + uiPluginActivatorClassName + ".PLUGIN_ID);");
		sc.add(I_PATH(sc) + " path = " + PLATFORM(sc) + ".getStateLocation(bundle);");
		sc.add("if (path == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("path = path.append(makeMD5(uriString) + \".xml\");");
		sc.add("return path.toFile();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSaveCodeFoldingStateFileMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Saves the code folding state to a XML file in the state location.",
			"@param uriString the key to determine the file to save to"
		);
		sc.add("public void saveCodeFoldingStateFile(String uriString) {");
		sc.add(I_DOCUMENT(sc) + " document = sourceViewer.getDocument();");
		sc.add("if (document == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(XML_MEMENTO(sc) + " codeFoldingMemento = " + XML_MEMENTO(sc) + ".createWriteRoot(MODEL);");
		sc.add("codeFoldingMemento.putString(VERIFY_KEY, makeMD5(document.get()));");
		sc.add("saveCodeFolding(codeFoldingMemento);");
		sc.add(FILE(sc) + " stateFile = getCodeFoldingStateFile(uriString);");
		sc.add("if (stateFile == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("try {");
		sc.add(FILE_OUTPUT_STREAM(sc) + " stream = new " + FILE_OUTPUT_STREAM(sc) + "(stateFile);");
		sc.add(OUTPUT_STREAM_WRITER(sc) + " writer = new " + OUTPUT_STREAM_WRITER(sc) + "(stream, \"utf-8\");");
		sc.add("codeFoldingMemento.save(writer);");
		sc.add("writer.close();");
		sc.add("} catch (" + IO_EXCEPTION(sc) + " e) {");
		sc.add("stateFile.delete();");
		sc.add(MESSAGE_DIALOG(sc) + ".openError((" + SHELL(sc) + ") null, \"Saving Problems\", \"Unable to save code folding state.\");");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRestoreCodeFoldingStateFromFileMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Restores the code folding state from a XML file in the state location.",
			"@param uriString the key to determine the file to load the state from"
		);
		sc.add("public void restoreCodeFoldingStateFromFile(String uriString) {");
		sc.add("final " + FILE(sc) + " stateFile = getCodeFoldingStateFile(uriString);");
		sc.add("if (stateFile == null || !stateFile.exists()) {");
		sc.add("calculatePositions();");
		sc.add("return;");
		sc.add("}");
		sc.add(SAFE_RUNNER(sc) + ".run(new " + SAFE_RUNNABLE(sc) + "(\"Unable to read code folding state. The state will be reset.\") {");
		sc.add("public void run() throws Exception {");
		sc.add(FILE_INPUT_STREAM(sc) + " input = new " + FILE_INPUT_STREAM(sc) + "(stateFile);");
		sc.add(BUFFERED_READER(sc) + " reader = new " + BUFFERED_READER(sc) + "(new " + INPUT_STREAM_READER(sc) + "(input, \"utf-8\"));");
		sc.add(I_MEMENTO(sc) + " memento = " + XML_MEMENTO(sc) + ".createReadRoot(reader);");
		sc.add("reader.close();");
		sc.add("String sourceText = sourceViewer.getDocument().get();");
		sc.add("if (memento.getString(VERIFY_KEY).equals(makeMD5(sourceText))) {");
		sc.add("restoreCodeFolding(memento);");
		sc.add("} else {");
		sc.add("calculatePositions();");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRestoreCodeFoldingMethod(JavaComposite sc) {
		sc.addJavadoc("Restores the code folding state information from the given memento.");
		sc.add("public void restoreCodeFolding(" + I_MEMENTO(sc) + " memento) {");
		sc.add("if (memento == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(I_MEMENTO(sc) + "[] annotationMementos = memento.getChildren(ANNOTATION);");
		sc.add("if (annotationMementos == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(MAP(sc) + "<" + PROJECTION_ANNOTATION(sc) + ", Boolean> collapsedStates = new " + LINKED_HASH_MAP(sc) + "<" + PROJECTION_ANNOTATION(sc) + ", Boolean>();");
		sc.add("for (" + I_MEMENTO(sc) + " annotationMemento : annotationMementos) {");
		sc.add(PROJECTION_ANNOTATION(sc) + " annotation = new " + PROJECTION_ANNOTATION(sc) + "();");
		sc.add("collapsedStates.put(annotation, annotationMemento.getBoolean(IS_COLLAPSED));");
		sc.add("int offset = annotationMemento.getInteger(OFFSET);");
		sc.add("int length = annotationMemento.getInteger(LENGTH);");
		sc.add(POSITION(sc) + " position = new " + POSITION(sc) + "(offset, length);");
		sc.add("projectionAnnotationModel.addAnnotation(annotation, position);");
		sc.add("}");
		sc.addComment("postset collapse state to prevent wrong displaying folding code.");
		sc.add("for (" + PROJECTION_ANNOTATION(sc) + " annotation : collapsedStates.keySet()) {");
		sc.add("Boolean isCollapsed = collapsedStates.get(annotation);");
		sc.add("if (isCollapsed != null && isCollapsed.booleanValue()) {");
		sc.add("projectionAnnotationModel.collapse(annotation);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSaveCodeFoldingMethod(JavaComposite sc) {
		sc.addJavadoc("Saves the code folding state into the given memento.");
		sc.add("public void saveCodeFolding(" + I_MEMENTO(sc) + " memento) {");
		sc.addComment("The annotation model might be null if the editor opened an storage input instead of a file input.");
		sc.add("if (projectionAnnotationModel == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add(ITERATOR(sc) + "<?> annotationIt = projectionAnnotationModel.getAnnotationIterator();");
		sc.add("while (annotationIt.hasNext()) {");
		sc.add(PROJECTION_ANNOTATION(sc) + " annotation = (" + PROJECTION_ANNOTATION(sc) + ") annotationIt.next();");
		sc.add(I_MEMENTO(sc) + " annotationMemento = memento.createChild(ANNOTATION);");
		sc.add(POSITION(sc) + " position = projectionAnnotationModel.getPosition(annotation);");
		sc.add("annotationMemento.putBoolean(IS_COLLAPSED, annotation.isCollapsed());");
		sc.add("annotationMemento.putInteger(OFFSET, position.offset);");
		sc.add("annotationMemento.putInteger(LENGTH, position.length);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddPositionMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Tries to add this position into the model. Only positions with more than " +
			"3 lines can be taken in. If multiple positions exist on the same line, the " +
			"longest will be chosen. The shorter ones will be deleted.",
			"@param position the position to be added."
		);
		sc.add("private void addPosition(" + POSITION(sc) + " position) {");
		sc.add(I_DOCUMENT(sc) + " document = sourceViewer.getDocument();");
		sc.add("int lines = 0;");
		sc.add("try {");
		sc.add("lines = document.getNumberOfLines(position.offset, position.length);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("return;");
		sc.add("}");
		sc.add("if (lines < 3) {");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("if a position to add existed on the same line, the longest one will be chosen");
		sc.add("try {");
		sc.add("for (" + PROJECTION_ANNOTATION(sc) + " annotationToAdd : additions.keySet()) {");
		sc.add(POSITION(sc) + " positionToAdd = additions.get(annotationToAdd);");
		sc.add("if (document.getLineOfOffset(position.offset) == document.getLineOfOffset(positionToAdd.offset)) {");
		sc.add("if (positionToAdd.length < position.length) {");
		sc.add("additions.remove(annotationToAdd);");
		sc.add("} else {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.add("return;");
		sc.add("}");
		sc.add("for (" + PROJECTION_ANNOTATION(sc) + " annotationInModel : oldAnnotations) {");
		sc.add(POSITION(sc) + " positionInModel = projectionAnnotationModel.getPosition(annotationInModel);");
		sc.add("if (position.offset == positionInModel.offset && position.length == positionInModel.length) {");
		sc.add("oldAnnotations.remove(annotationInModel);");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("additions.put(new " + PROJECTION_ANNOTATION(sc) + "(), position);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsInAdditionsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Checks the offset of the given <code>" + POSITION(sc) + "</code> against the " +
			"<code>" + POSITION(sc) + "</code>s in <code>additions</code> to determine the " +
			"existence whether the given position is contained in the additions set.",
			"@param position the position to check",
			"@return <code>true</code> if it is in the <code>additions</code>"
		);
		sc.add("private boolean isInAdditions(" + POSITION(sc) + " position) {");
		sc.add("for (" + ANNOTATION(sc) + " addition : additions.keySet()) {");
		sc.add(POSITION(sc) + " additionPosition = additions.get(addition);");
		sc.add("if (position.offset == additionPosition.offset && position.length == additionPosition.length) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addUpdateCodefoldingMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Checks whether the given positions are in the <code>" + PROJECTION_ANNOTATION_MODEL(sc) + "</code> or in " +
			"the addition set. If not it tries to add into <code>additions</code>. " +
			"Deletes old " + PROJECTION_ANNOTATION(sc) + " with line count less than 2.",
			"@param positions a list of available foldable positions"
		);
		sc.add("public void updateCodefolding(" + LIST(sc) + "<" + POSITION(sc) + "> positions) {");
		sc.add(I_DOCUMENT(sc) + " document = sourceViewer.getDocument();");
		sc.add("if (document == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("oldAnnotations.clear();");
		sc.add(ITERATOR(sc) + "<?> annotationIterator = projectionAnnotationModel.getAnnotationIterator();");
		sc.add("while (annotationIterator.hasNext()) {");
		sc.add("oldAnnotations.add((" + PROJECTION_ANNOTATION(sc) + ") annotationIterator.next());");
		sc.add("}");
		sc.addComment("Add new Position with a unique line offset");
		sc.add("for (" + POSITION(sc) + " position : positions) {");
		sc.add("if (!isInAdditions(position)) {");
		sc.add("addPosition(position);");
		sc.add("}");
		sc.add("}");
		sc.add("projectionAnnotationModel.modifyAnnotations(oldAnnotations.toArray(new " + ANNOTATION(sc) + "[0]), additions, null);");
		sc.add("additions.clear();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddCloseListenerMethod(StringComposite sc) {
		sc.add("private void addCloseListener(final " + editorClassName + " editor) {");
		sc.add("editor.getSite().getPage().addPartListener(new EditorOnCloseListener(editor));");
		sc.add("editor.addBackgroundParsingListener(new FoldingUpdateListener());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEditorOnCloseListenerClass(JavaComposite sc) {
		sc.add("private class EditorOnCloseListener implements " + I_PART_LISTENER2(sc) + " {");
		sc.addLineBreak();
		sc.add("private " + editorClassName + " editor;");
		sc.addLineBreak();
		sc.add("public EditorOnCloseListener(" + editorClassName + " editor) {");
		sc.add("this.editor = editor;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void partActivated(" + I_WORKBENCH_PART_REFERENCE(sc) + " partRef) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void partBroughtToTop(" + I_WORKBENCH_PART_REFERENCE(sc) + " partRef) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void partClosed(" + I_WORKBENCH_PART_REFERENCE(sc) + " partRef) {");
		sc.add("if (partRef.isDirty()) {");
		sc.add("return;");
		sc.add("}");
		sc.add(I_WORKBENCH_PART(sc) + " workbenchPart = partRef.getPart(false);");
		sc.add("if (workbenchPart instanceof " + editorClassName + ") {");
		sc.add(editorClassName + " editor = (" + editorClassName + ") workbenchPart;");
		sc.add(RESOURCE(sc) + " editorResource = editor.getResource();");
		sc.add("if (editorResource == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("String uri = editorResource.getURI().toString();");
		sc.add(RESOURCE(sc) + " thisEditorResource = this.editor.getResource();");
		sc.add(URI(sc) + " thisEditorResourceURI = thisEditorResource.getURI();");
		sc.add("if (uri.equals(thisEditorResourceURI.toString())) {");
		sc.add("saveCodeFoldingStateFile(uri);");
		sc.add("editor.getSite().getPage().removePartListener(this);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void partDeactivated(" + I_WORKBENCH_PART_REFERENCE(sc) + " partRef) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void partHidden(" + I_WORKBENCH_PART_REFERENCE(sc) + " partRef) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void partInputChanged(" + I_WORKBENCH_PART_REFERENCE(sc) + " partRef) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void partOpened(" + I_WORKBENCH_PART_REFERENCE(sc) + " partRef) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void partVisible(" + I_WORKBENCH_PART_REFERENCE(sc) + " partRef) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFoldingUpdateListenerClass(JavaComposite sc) {
		sc.add("private class FoldingUpdateListener implements " + iBackgroundParsingListenerClassName + " {");
		sc.add("public void parsingCompleted(" + RESOURCE(sc) + " resource) {");
		sc.add("calculatePositions();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private static final String VERIFY_KEY = \"verify_key\";");
		sc.add("private static final String ANNOTATION = \"ANNOTATION\";");
		sc.add("private static final String IS_COLLAPSED = \"IS_COLLAPSED\";");
		sc.add("private static final String OFFSET = \"OFFSET\";");
		sc.add("private static final String LENGTH = \"LENGTH\";");
		sc.add("private static final String MODEL = \"MODEL\";");
		sc.add("protected " + LIST(sc) + "<" + PROJECTION_ANNOTATION(sc) + "> oldAnnotations = new " + ARRAY_LIST(sc) + "<" + PROJECTION_ANNOTATION(sc) + ">();");
		sc.add("protected " + MAP(sc) + "<" + PROJECTION_ANNOTATION(sc) + ", " + POSITION(sc) + "> additions = new " + LINKED_HASH_MAP(sc) + "<" + PROJECTION_ANNOTATION(sc) + ", " + POSITION(sc) + ">();");
		sc.add("protected " + PROJECTION_ANNOTATION_MODEL(sc) + " projectionAnnotationModel;");
		sc.add("protected " + PROJECTION_VIEWER(sc) + " sourceViewer;");
		sc.add("protected " + editorClassName + " editor;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a code folding manager to handle the " +
			"<code>" + PROJECTION_ANNOTATION(sc) + "</code>.",
			"@param sourceViewer the source viewer to calculate the element lines"
		);
		sc.add("public " + getResourceClassName() + "(" + PROJECTION_VIEWER(sc) + " sourceViewer," + editorClassName + " textEditor) {");
		sc.add("this.projectionAnnotationModel = sourceViewer.getProjectionAnnotationModel();");
		sc.add("this.sourceViewer = sourceViewer;");
		sc.add("this.editor = textEditor;");
		sc.add("addCloseListener(textEditor);");
		sc.add("try {");
		sc.add("restoreCodeFoldingStateFromFile(editor.getResource().getURI().toString());");
		sc.add("} catch (Exception e) {");
		sc.add("calculatePositions();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
