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
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_RESOURCE_CHANGE_EVENT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_RESOURCE_CHANGE_LISTENER;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_RESOURCE_DELTA;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_RESOURCE_DELTA_VISITOR;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.LINKED_LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE_BUNDLE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.URI;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ABSTRACT_MARKER_ANNOTATION_MODEL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ADAPTER_FACTORY_CONTENT_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CELL_EDITOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DOCUMENT_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.EDITING_DOMAIN;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ENUMERATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.FILE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ANNOTATION_ACCESS_EXTENSION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ANNOTATION_MODEL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTENT_OUTLINE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTEXT_SERVICE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DOCUMENT_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_EDITING_DOMAIN_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ITEM_PROPERTY_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ITEM_PROPERTY_SOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PROPERTY_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PROPERTY_SHEET_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PROPERTY_SOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STORAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STORAGE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_EDITOR_ACTION_CONSTANTS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_OPERATION_TARGET;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_PRESENTATION_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_VERTICAL_RULER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_VIEWER_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.POSITION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROJECTION_SUPPORT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROPERTY_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROPERTY_SOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECT_MARKER_RULES_ACTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.TEXT_EDITOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.TEXT_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.VIEWER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class EditorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		GenerationContext context = getContext();

		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc("A text editor for '" + context.getConcreteSyntax().getName() + "' models."
				, "<p>"
				, "This editor has id <code>" + context.getQualifiedClassName(TextResourceUIArtifacts.EDITOR) + "</code>"
				, "The editor's context menu has id <code>" + context.getEditorContextID() + "</code>. "
				, "The editor's ruler context menu has id <code>" + context.getEditorRulerID() + "</code>."
				, "The editor's editing context has id <code>" + context.getEditorScopeID() + "</code>."
				, "</p>");
		sc.add("public class " + getResourceClassName() + " extends " + TEXT_EDITOR(sc) + " implements " + I_EDITING_DOMAIN_PROVIDER(sc) + ", " + I_SELECTION_PROVIDER(sc) + ", " + I_SELECTION_CHANGED_LISTENER(sc) + ", " + I_VIEWER_PROVIDER(sc) + ", " + iResourceProviderClassName + ", " + iBracketHandlerProviderClassName + ", " + iAnnotationModelProviderClassName + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
	}
	
	private void addFields(JavaComposite sc) {
		sc.add("private " + highlightingClassName + " highlighting;");
		sc.add("private " + PROJECTION_SUPPORT(sc) + " projectionSupport;");
		sc.add("private " + codeFoldingManagerClassName + " codeFoldingManager;");
		sc.add("private " + backgroundParsingStrategyClassName + " bgParsingStrategy = new " + backgroundParsingStrategyClassName + "();");
		sc.add("private " + COLLECTION(sc) + "<" + iBackgroundParsingListenerClassName + "> bgParsingListeners = new " + ARRAY_LIST(sc) + "<" + iBackgroundParsingListenerClassName + ">();");
		sc.add("private " + colorManagerClassName + " colorManager = new " + colorManagerClassName + "();");
		sc.add("private " + outlinePageClassName + " outlinePage;");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.add("private " + I_RESOURCE_CHANGE_LISTENER(sc) + " resourceChangeListener = new ModelResourceChangeListener();");
		sc.add("private " + propertySheetPageClassName + " propertySheetPage;");
		sc.add("private " + EDITING_DOMAIN(sc) + " editingDomain;");
		sc.add("private " + iBracketHandlerClassName + " bracketHandler;");
		sc.add("private " + LIST(sc) + "<" + I_SELECTION_CHANGED_LISTENER(sc) + "> selectionChangedListeners = new " + LINKED_LIST(sc) + "<" + I_SELECTION_CHANGED_LISTENER(sc) + ">();");
		sc.add("private " + I_SELECTION(sc) + " editorSelection;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("setSourceViewerConfiguration(new " + sourceViewerConfigurationClassName + "(this, this, colorManager));");
		sc.add(RESOURCES_PLUGIN(sc) + ".getWorkspace().addResourceChangeListener(resourceChangeListener, " + I_RESOURCE_CHANGE_EVENT(sc) + ".POST_CHANGE);");
		sc.add("addSelectionChangedListener(this);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addDocumentListenerClass(sc);
		addModelResourceChangeListenerClass(sc);
		addInitializeEditorMethod(sc);
		addGetAdapterMethod(sc);
		addCreatePartControlMethod(sc);
		addInitializeResourceObjectMethod(sc);
		addInitializeResourceObjectFromFileMethod(sc);
		addInitializeResourceObjectFromStorageMethod(sc);
		addDisposeMethod(sc);
		addPerformSaveMethod(sc);
		addInvalidateTextRepresentationMethod(sc);
		addSetFocusMethod(sc);
		addPerformSaveAsMethod(sc);
		addGetResourceSetMethod(sc);
		addGetResourceMethod(sc);
		addSetResourceMethod(sc);
		addGetOutlinePageMethod(sc);
		addGetPropertySheetPageMethod(sc);
		addGetEditingDomainMethod(sc);
		addSetCaretMethod(sc);
		addCreateSourceViewerMethod(sc);
		addAddBackgroundParsingListenerMethod(sc);
		addNotifyBackgroundParsingFinishedMethod(sc);
		addGetBracketHandlerMethod(sc);
		addSetBracketHandlerMethod(sc);
		addCreateActionsMethod(sc);
		addGetAnnotationModelMethod(sc);
		addAddSelectionChangedListenerMethod(sc);
		addGetSelectionMethod(sc);
		addRemoveSelectionChangedListenerMethod(sc);
		addSelectionChangedMethod(sc);
		addSetSelectionMethod1(sc);
		addSetSelectionMethod2(sc);
		addGetViewerMethod(sc);
	}

	private void addSetSelectionMethod1(JavaComposite sc) {
		sc.add("public void setSelection(" + I_SELECTION(sc) + " selection) {");
		sc.add("editorSelection = selection;");
		sc.add("for (" + I_SELECTION_CHANGED_LISTENER(sc) + " listener : selectionChangedListeners) {");
		sc.add("listener.selectionChanged(new " + SELECTION_CHANGED_EVENT(sc) + "(this, selection));");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetSelectionMethod2(JavaComposite sc) {
		sc.add("private boolean setSelection(" + I_SELECTION(sc) + " selection, boolean reveal) {");
		sc.add("if (selection instanceof " + I_STRUCTURED_SELECTION(sc) + ") {");
		sc.add(I_STRUCTURED_SELECTION(sc) + " structuredSelection = (" + I_STRUCTURED_SELECTION(sc) + ") selection;");
		sc.add("Object object = structuredSelection.getFirstElement();");
		sc.add("if (object instanceof " + E_OBJECT(sc) + ") {");
		sc.add(E_OBJECT(sc) + " element = (" + E_OBJECT(sc) + ") object;");
		sc.add(RESOURCE(sc) + " resource = element.eResource();");
		sc.add("if (resource == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (!(resource instanceof " + iTextResourceClassName + ")) {");
		sc.add("return false;");
		sc.add("}");
		sc.add(iTextResourceClassName + " textResource = (" + iTextResourceClassName + ") resource;");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add("int destination = locationMap.getCharStart(element);");
		sc.add("if (destination < 0) {");
		sc.add("destination = 0;");
		sc.add("}");
		sc.add("selectAndReveal(destination, 0);");
		sc.add("int length = locationMap.getCharEnd(element) - destination + 1;");
		sc.add("getSourceViewer().setRangeIndication(destination, length, true);");
		sc.add("getSourceViewer().setSelectedRange(destination, length);");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetViewerMethod(JavaComposite sc) {
		sc.add("public " + VIEWER(sc) + " getViewer() {");
		sc.add("return (" + PROJECTION_VIEWER(sc) + ") getSourceViewer();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSelectionChangedMethod(JavaComposite sc) {
		sc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT(sc) + " event) {");
		sc.add(I_SELECTION(sc) + " selection = event.getSelection();");
		sc.add("setSelection(selection, true);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveSelectionChangedListenerMethod(JavaComposite sc) {
		sc.add("public void removeSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER(sc) + " listener) {");
		sc.add("selectionChangedListeners.remove(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSelectionMethod(JavaComposite sc) {
		sc.add("public " + I_SELECTION(sc) + " getSelection() {");
		sc.add("return editorSelection;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddSelectionChangedListenerMethod(JavaComposite sc) {
		sc.add("public void addSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER(sc) + " listener) {");
		sc.add("selectionChangedListeners.add(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAnnotationModelMethod(JavaComposite sc) {
		sc.add("public " + I_ANNOTATION_MODEL(sc) + " getAnnotationModel() {");
		sc.add("return getDocumentProvider().getAnnotationModel(getEditorInput());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketHandlerMethod(JavaComposite sc) {
		sc.add("public " + iBracketHandlerClassName + " getBracketHandler() {");
		sc.add("return bracketHandler;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetBracketHandlerMethod(JavaComposite sc) {
		sc.add("public void setBracketHandler(" + iBracketHandlerClassName + " bracketHandler) {");
		sc.add("this.bracketHandler = bracketHandler;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeEditorMethod(StringComposite sc) {
		String editorContextID = getContext().getEditorContextID();
		String editorRulerID = getContext().getEditorRulerID();

		sc.add("public void initializeEditor() {");
		sc.add("super.initializeEditor();");
		sc.add("setEditorContextMenuId(\"" + editorContextID + "\");");
		sc.add("setRulerContextMenuId(\"" + editorRulerID + "\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addNotifyBackgroundParsingFinishedMethod(StringComposite sc) {
		sc.add("public void notifyBackgroundParsingFinished() {");
		sc.add("for (" + iBackgroundParsingListenerClassName + " listener : bgParsingListeners) {");
		sc.add("listener.parsingCompleted(getResource());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddBackgroundParsingListenerMethod(StringComposite sc) {
		sc.add("public void addBackgroundParsingListener(" + iBackgroundParsingListenerClassName + " listener) {");
		sc.add("bgParsingListeners.add(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateSourceViewerMethod(JavaComposite sc) {
		sc.add("protected " + I_SOURCE_VIEWER(sc) + " createSourceViewer(" + COMPOSITE(sc) + " parent, " + I_VERTICAL_RULER(sc) + " ruler, int styles) {");
		sc.add(I_SOURCE_VIEWER(sc) + " viewer = new " + PROJECTION_VIEWER(sc) + "(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles) {");
		sc.addLineBreak();
		sc.add("public void setSelection(" + I_SELECTION(sc) + " selection, boolean reveal) {");
		sc.add("if (!" + getResourceClassName() + ".this.setSelection(selection, reveal)) {");
		sc.add("super.setSelection(selection, reveal);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("};");
		sc.addComment("ensure decoration support has been created and configured.");
		sc.add("getSourceViewerDecorationSupport(viewer);");
		sc.add("return viewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	// FIXME This method seems not to be used. Remove it?
	private void addSetCaretMethod(JavaComposite sc) {

		sc.addJavadoc(
				"Sets the caret to the offset of the given element.",
				"@param element has to be contained in the resource of this editor."
		);
		sc.add("public void setCaret(" + E_OBJECT(sc) + " element, String text) {");
		sc.add("try {");
		sc.add("if (element == null || text == null || text.equals(\"\")) {");
		sc.add("return;");
		sc.add("}");
		sc.add(I_SOURCE_VIEWER(sc) + " viewer = getSourceViewer();");
		sc.add(iTextResourceClassName + " textResource = (" + iTextResourceClassName + ") element.eResource();");
		sc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		sc.add("int destination = locationMap.getCharStart(element);");
		sc.add("int length = locationMap.getCharEnd(element) + 1 - destination;");
		sc.addLineBreak();
		sc.add(iTextScannerClassName + " lexer = getResource().getMetaInformation().createLexer();");
		sc.add("try {");
		sc.add("lexer.setText(viewer.getDocument().get(destination, length));");
		sc.add(iTextTokenClassName + " token = lexer.getNextToken();");
		sc.add("String tokenText = token.getText();");
		sc.add("while (tokenText != null) {");
		sc.add("if (token.getText().equals(text)) {");
		sc.add("destination += token.getOffset();");
		sc.add("break;");
		sc.add("}");
		sc.add("token = lexer.getNextToken();");
		sc.add("if (token == null) {");
		sc.add("break;");
		sc.add("}");
		sc.add("tokenText = token.getText();");
		sc.add("}");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION(sc) + " e) {");
		sc.add("}");
		sc.add("destination = ((" + PROJECTION_VIEWER(sc) + ") viewer).modelOffset2WidgetOffset(destination);");
		sc.add("if (destination < 0) {");
		sc.add("destination = 0;");
		sc.add("}");
		sc.add("viewer.getTextWidget().setSelection(destination);");
		sc.add("} catch (Exception e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception in setCaret()\", e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEditingDomainMethod(JavaComposite sc) {
		sc.add("public " + EDITING_DOMAIN(sc) + " getEditingDomain() {");
		sc.add("if (editingDomain == null) {");
		sc.add("editingDomain = new " + editingDomainProviderClassName + "().getEditingDomain(getEditorInput());");
		sc.add("}");
		sc.add("return editingDomain;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPropertySheetPageMethod(JavaComposite sc) {
		sc.add("public " + I_PROPERTY_SHEET_PAGE(sc) + " getPropertySheetPage() {");
		sc.add("if (propertySheetPage == null) {");
		sc.add("propertySheetPage = new " + propertySheetPageClassName + "();");
		sc.addComment(
				"add a slightly modified adapter factory that does not return any " +
				"editors for properties. " +
				"this way, a model can never be modified through the properties " +
				"view."
		);
		sc.add(ADAPTER_FACTORY(sc) + " adapterFactory = new " + adapterFactoryProviderClassName + "().getAdapterFactory();");
		sc.add("propertySheetPage.setPropertySourceProvider(new " + ADAPTER_FACTORY_CONTENT_PROVIDER(sc) + "(adapterFactory) {");
		sc.add("protected " + I_PROPERTY_SOURCE(sc) + " createPropertySource(Object object, " + I_ITEM_PROPERTY_SOURCE(sc) + " itemPropertySource) {");
		sc.add("return new " + PROPERTY_SOURCE(sc) + "(object, itemPropertySource) {");
		sc.add("protected " + I_PROPERTY_DESCRIPTOR(sc) + " createPropertyDescriptor(" + I_ITEM_PROPERTY_DESCRIPTOR(sc) + " itemPropertyDescriptor) {");
		sc.add("return new " + PROPERTY_DESCRIPTOR(sc) + "(object, itemPropertyDescriptor) {");
		sc.add("public " + CELL_EDITOR(sc) + " createPropertyEditor(" + COMPOSITE(sc) + " composite) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("});");
		sc.add("highlighting.addSelectionChangedListener(propertySheetPage);");
		sc.add("}");
		sc.add("return propertySheetPage;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetOutlinePageMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Return the outline page this is associated with this editor. If " +
			"no outline page exists, a new one is created."
		);
		sc.add("private " + outlinePageClassName + " getOutlinePage() {");
		sc.add("if (outlinePage == null) {");
		sc.add("outlinePage = new " + outlinePageClassName + "(this);");
		sc.addComment("Connect highlighting class and outline page for event notification");
		sc.add("outlinePage.addSelectionChangedListener(highlighting);");
		sc.add("highlighting.addSelectionChangedListener(outlinePage);");
		sc.add("}");
		sc.add("return outlinePage;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetResourceMethod(JavaComposite sc) {
		sc.add("private void setResource(" + iTextResourceClassName + " resource) {");
		sc.add("assert resource != null;");
		sc.add("this.resource = resource;");
		sc.add("if (this.resource.getErrors().isEmpty()) {");
		sc.add(ECORE_UTIL(sc) + ".resolveAll(this.resource);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod(StringComposite sc) {
		sc.add("public " + iTextResourceClassName + " getResource() {");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceSetMethod(JavaComposite sc) {
		sc.add("public " + RESOURCE_SET(sc) + " getResourceSet() {");
		sc.add("return getEditingDomain().getResourceSet();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformSaveAsMethod(JavaComposite sc) {
		sc.add("protected void performSaveAs(" + I_PROGRESS_MONITOR(sc) + " progressMonitor) {");
		sc.add(FILE_EDITOR_INPUT(sc) + " input = (" + FILE_EDITOR_INPUT(sc) + ") getEditorInput();");
		sc.add("String path = input.getFile().getFullPath().toString();");
		sc.add(RESOURCE_SET(sc) + " resourceSet = getResourceSet();");
		sc.add(URI(sc) + " platformURI = " + URI(sc) + ".createPlatformResourceURI(path, true);");
		sc.add(RESOURCE(sc) + " oldFile = resourceSet.getResource(platformURI, true);");
		sc.addLineBreak();
		sc.add("super.performSaveAs(progressMonitor);");
		sc.addLineBreak();
		sc.addComment("load and resave - input has been changed to new path by super");
		sc.add(FILE_EDITOR_INPUT(sc) + " newInput = (" + FILE_EDITOR_INPUT(sc) + ") getEditorInput();");
		sc.add("String newPath = newInput.getFile().getFullPath().toString();");
		sc.add(URI(sc) + " newPlatformURI = " + URI(sc) + ".createPlatformResourceURI(newPath, true);");
		sc.add(RESOURCE(sc) + " newFile = resourceSet.createResource(newPlatformURI);");
		sc.addComment("if the extension is the same, saving was already performed by super by saving the plain text");
		sc.add("if (platformURI.fileExtension().equals(newPlatformURI.fileExtension())) {");
		sc.add("oldFile.unload();");
		sc.addComment("save code folding state, is it possible with a new name");
		sc.add("codeFoldingManager.saveCodeFoldingStateFile(getResource().getURI().toString());");
		sc.add("}");
		sc.add("else {");
		sc.add("newFile.getContents().clear();");
		sc.add("newFile.getContents().addAll(oldFile.getContents());");
		sc.add("try {");
		sc.add("oldFile.unload();");
		sc.add("if (newFile.getErrors().isEmpty()) {");
		sc.add("newFile.save(null);");
		sc.add("}");
		sc.add("} catch (Exception e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetFocusMethod(JavaComposite sc) {
		sc.add("public void setFocus() {");
		sc.add("super.setFocus();");
		sc.add("this.invalidateTextRepresentation();");
		sc.addComment("Parse the document again to remove errors that stem from unresolvable proxy objects");
		sc.add("bgParsingStrategy.parse(getSourceViewer().getDocument(), resource, this, 10);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInvalidateTextRepresentationMethod(JavaComposite sc) {
		sc.add("public void invalidateTextRepresentation() {");
		sc.add(I_SOURCE_VIEWER(sc) + " viewer = getSourceViewer();");
		sc.add("if (viewer != null) {");
		sc.add("viewer.invalidateTextPresentation();");
		sc.add("}");
		sc.add("highlighting.resetValues();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformSaveMethod(JavaComposite sc) {
		sc.add("protected void performSave(boolean overwrite, " + I_PROGRESS_MONITOR(sc) + " progressMonitor) {");
		sc.addLineBreak();
		sc.add("super.performSave(overwrite, progressMonitor);");
		sc.addLineBreak();
		sc.addComment("Save code folding state");
		sc.add("codeFoldingManager.saveCodeFoldingStateFile(getResource().getURI().toString());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void registerTextPresentationListener(" + I_TEXT_PRESENTATION_LISTENER(sc) + " listener) {");
		sc.add(I_SOURCE_VIEWER(sc) + " viewer = getSourceViewer();");
		sc.add("if (viewer instanceof " + TEXT_VIEWER(sc) + ") {");
		sc.add("((" + TEXT_VIEWER(sc) + ") viewer).addTextPresentationListener(listener);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDisposeMethod(JavaComposite sc) {
		sc.add("public void dispose() {");
		sc.add("colorManager.dispose();");
		sc.add(RESOURCES_PLUGIN(sc) + ".getWorkspace().removeResourceChangeListener(resourceChangeListener);"); 
		sc.add("super.dispose();");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addInitializeResourceObjectMethod(JavaComposite sc) {
		sc.add("private void initializeResourceObject(" + I_EDITOR_INPUT(sc) + " editorInput) {");
		sc.add("if (editorInput instanceof " + FILE_EDITOR_INPUT(sc) + ") {");
		sc.add("initializeResourceObjectFromFile((" + FILE_EDITOR_INPUT(sc) + ") editorInput);");
		sc.add("} else if (editorInput instanceof " + I_STORAGE_EDITOR_INPUT(sc) + ") {");
		sc.add("initializeResourceObjectFromStorage((" + I_STORAGE_EDITOR_INPUT(sc) + ") editorInput);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeResourceObjectFromStorageMethod(JavaComposite sc) {
		sc.add("private void initializeResourceObjectFromStorage(" + I_STORAGE_EDITOR_INPUT(sc) + " input) {");
		sc.add(URI(sc) + " uri = null;");
		sc.add("try {");
		sc.add(I_STORAGE(sc) + " storage = input.getStorage();");
		sc.add(INPUT_STREAM(sc) + " inputStream = storage.getContents();");
		sc.add("uri = URI.createURI(storage.getName(), true);");
		sc.add(RESOURCE_SET(sc) + " resourceSet = getResourceSet();");
		sc.add(iTextResourceClassName + " resource = (" + iTextResourceClassName + ") resourceSet.createResource(uri);");
		sc.add("resource.load(inputStream, null);");
		sc.add("setResource(resource);");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while loading resource (\" + uri + \") in \" + getClass().getSimpleName() + \".\", e);");
		sc.add("} catch (" + IO_EXCEPTION(sc) + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while loading resource (\" + uri + \") in \" + getClass().getSimpleName() + \".\", e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeResourceObjectFromFileMethod(JavaComposite sc) {
		sc.add("private void initializeResourceObjectFromFile(" + FILE_EDITOR_INPUT(sc) + " input) {");
		sc.add(I_FILE(sc) + " inputFile = input.getFile();");
		
		// TODO activating the DSL nature here is ugly
		sc.add(natureClassName + ".activate(inputFile.getProject());");

		sc.add("String path = inputFile.getFullPath().toString();");
		sc.add(URI(sc) + " uri = " + URI(sc) + ".createPlatformResourceURI(path, true);");
		sc.add(RESOURCE_SET(sc) + " resourceSet = getResourceSet();");
		sc.add(iTextResourceClassName + " loadedResource = (" + iTextResourceClassName + ") resourceSet.getResource(uri, false);");
		sc.add("if (loadedResource == null) {");
		sc.add("try {");
		sc.add(RESOURCE(sc)  + " demandLoadedResource = null;");
		sc.addComment("here we do not use getResource(), because 'resource' might be null, which is ok when initializing the resource object");
		sc.add(iTextResourceClassName + " currentResource = this.resource;");
		sc.add("if (currentResource != null && !currentResource.getURI().fileExtension().equals(uri.fileExtension())) {");
		sc.addComment("do not attempt to load if file extension has changed in a 'save as' operation	");
		sc.add("}");
		sc.add("else {");
		sc.add("demandLoadedResource = resourceSet.getResource(uri, true);");
		sc.add("}");
		sc.add("if (demandLoadedResource instanceof " + iTextResourceClassName + ") {");
		sc.add("setResource((" + iTextResourceClassName + ") demandLoadedResource);");
		sc.add("} else {");
		sc.addComment("the resource was not loaded by an EMFText resource, but some other EMF resource");
		sc.add(uiPluginActivatorClassName + ".showErrorDialog(\"Invalid resource.\", \"The file '\" + uri.lastSegment() + \"' of type '\" + uri.fileExtension() + \"' can not be handled by the " + getResourceClassName() + ".\");");
		sc.addComment("close this editor because it can not present the resource");
		sc.add("close(false);");
		sc.add("}");
		sc.add("} catch (Exception e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while loading resource in \" + this.getClass().getSimpleName() + \".\", e);");
		sc.add("}");
		sc.add("} else {");
		sc.add("setResource(loadedResource);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreatePartControlMethod(JavaComposite sc) {
		sc.add("public void createPartControl(" + COMPOSITE(sc) + " parent) {");
		sc.add("super.createPartControl(parent);");
		sc.addLineBreak();
		sc.addComment("Code Folding");
		sc.add(PROJECTION_VIEWER(sc) + " viewer = (" + PROJECTION_VIEWER(sc) + ") getSourceViewer();");
		sc.addComment("Occurrence initiation, need ITextResource and ISourceViewer.");
		sc.add("highlighting = new " + highlightingClassName + "(getResource(), viewer, colorManager, this);");
		sc.addLineBreak();
		sc.add("projectionSupport = new " + PROJECTION_SUPPORT(sc) + "(viewer, getAnnotationAccess(), getSharedColors());");
		sc.add("projectionSupport.install();");
		sc.addLineBreak();
		sc.addComment("turn projection mode on");
		sc.add("viewer.doOperation(" + PROJECTION_VIEWER(sc) + ".TOGGLE);");
		sc.add("codeFoldingManager = new " + codeFoldingManagerClassName + "(viewer, this);");
		sc.addLineBreak();
		sc.add(I_CONTEXT_SERVICE(sc) + " contextService = ("+ I_CONTEXT_SERVICE(sc) + ") getSite().getService(" + I_CONTEXT_SERVICE(sc) + ".class);");
		sc.add("contextService.activateContext(\"" + getContext().getEditorScopeID() + "\");");
		sc.add("}");
		sc.addLineBreak();
		sc.add("protected void doSetInput(" + I_EDITOR_INPUT(sc) + " editorInput) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add("super.doSetInput(editorInput);");
		sc.add("initializeResourceObject(editorInput);");
		sc.add(I_DOCUMENT(sc) + " document = getDocumentProvider().getDocument(getEditorInput());");
		sc.add("document.addDocumentListener(new DocumentListener());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateActionsMethod(JavaComposite sc) {
		sc.add("public void createActions() {");
		sc.add("super.createActions();");
		sc.add(RESOURCE_BUNDLE(sc) + " resourceBundle = new " + RESOURCE_BUNDLE(sc) + "() {");
		sc.add("public " + ENUMERATION(sc) + "<String> getKeys() {");
		sc.add(LIST(sc) + "<String> keys = new " + ARRAY_LIST(sc) + "<String>(3);");
		sc.add("keys.add(\"SelectAnnotationRulerAction.QuickFix.label\");");
		sc.add("keys.add(\"SelectAnnotationRulerAction.QuickFix.tooltip\");");
		sc.add("keys.add(\"SelectAnnotationRulerAction.QuickFix.description\");");
		sc.add("return " + COLLECTIONS(sc) + ".enumeration(keys);");
		sc.add("}");
		sc.add("public Object handleGetObject(String key) {");
		sc.add("if (key.equals(\"SelectAnnotationRulerAction.QuickFix.label\")) return \"&Quick Fix\";");
		sc.add("if (key.equals(\"SelectAnnotationRulerAction.QuickFix.tooltip\")) return \"Quick Fix\";");
		sc.add("if (key.equals(\"SelectAnnotationRulerAction.QuickFix.description\")) return \"Runs Quick Fix on the annotation's line\";");
		sc.add("return null;");
		sc.add("}");
		sc.add("};");
		sc.add("setAction(" + I_TEXT_EDITOR_ACTION_CONSTANTS(sc) + ".RULER_CLICK, new " + SELECT_MARKER_RULES_ACTION(sc) + "(resourceBundle, \"SelectAnnotationRulerAction.\", this, getVerticalRuler()) {");
		sc.add("public void run() {");
		sc.add("runWithEvent(null);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void runWithEvent(" + EVENT(sc) + " event) {");
		sc.add(I_TEXT_OPERATION_TARGET(sc) + " operation = (" + I_TEXT_OPERATION_TARGET(sc) + ") getAdapter(" + I_TEXT_OPERATION_TARGET(sc) + ".class);");
		sc.add("final int opCode = " + I_SOURCE_VIEWER(sc) + ".QUICK_ASSIST;");
		sc.add("if (operation != null && operation.canDoOperation(opCode)) {");
		sc.add(POSITION(sc) + " position = getPosition();");
		sc.add("if (position != null) {");
		sc.add("selectAndReveal(position.getOffset(), position.getLength());");
		sc.add("}");
		sc.add("operation.doOperation(opCode);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private " + POSITION(sc) + " getPosition() {");
		sc.add(ABSTRACT_MARKER_ANNOTATION_MODEL(sc) + " model = getAnnotationModel();");
		sc.add(I_ANNOTATION_ACCESS_EXTENSION(sc) + "  annotationAccess = getAnnotationAccessExtension();");
		sc.addLineBreak();
		sc.add(I_DOCUMENT(sc) + " document = getDocument();");
		sc.add("if (model == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add(ITERATOR(sc) + "<?> iter = model.getAnnotationIterator();");
		sc.add("int layer = Integer.MIN_VALUE;");
		sc.addLineBreak();
		sc.add("while (iter.hasNext()) {");
		sc.add(ANNOTATION(sc) + " annotation = (" + ANNOTATION(sc) + ") iter.next();");
		sc.add("if (annotation.isMarkedDeleted()) {");
		sc.add("continue;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (annotationAccess != null) {");
		sc.add("int annotationLayer = annotationAccess.getLayer(annotation);");
		sc.add("if (annotationLayer < layer) {");
		sc.add("continue;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add(POSITION(sc) + " position = model.getPosition(annotation);");
		sc.add("if (!includesRulerLine(position, document)) {");
		sc.add("continue;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return position;");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAdapterMethod(JavaComposite sc) {
		sc.add("public Object getAdapter(@SuppressWarnings(\"rawtypes\") Class required) {");
		sc.add("if (" + I_CONTENT_OUTLINE_PAGE(sc) + ".class.equals(required)) {");
		sc.add("return getOutlinePage();");
		sc.add("} else if (required.equals(" + I_PROPERTY_SHEET_PAGE(sc) + ".class)) {");
		sc.add("return getPropertySheetPage();");
		sc.add("}");
		sc.add("return super.getAdapter(required);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addModelResourceChangeListenerClass(JavaComposite sc) {
		sc.addJavadoc(
				"Reacts to changes of the text resource displayed in the editor and " +
				"resources cross-referenced by it. Cross-referenced resources are " +
				"unloaded, the displayed resource is reloaded. An attempt to resolve all " +
				"proxies in the displayed resource is made after each change.",
				"The code pretty much corresponds to what EMF generates for a tree editor."
		);
		sc.add("private class ModelResourceChangeListener implements " + I_RESOURCE_CHANGE_LISTENER(sc) + " {");
		sc.add("public void resourceChanged(" + I_RESOURCE_CHANGE_EVENT(sc) + " event) {");
		sc.add(I_RESOURCE_DELTA(sc) + " delta = event.getDelta();");
		sc.add("try {");
		sc.add("class ResourceDeltaVisitor implements " + I_RESOURCE_DELTA_VISITOR(sc) + " {");
		sc.add("protected " + RESOURCE_SET(sc) + " resourceSet = getResourceSet();");
		sc.addLineBreak();
		sc.add("public boolean visit(" + I_RESOURCE_DELTA(sc) + " delta) {");
		sc.add("if (delta.getResource().getType() != " + I_RESOURCE(sc) + ".FILE) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("int deltaKind = delta.getKind();");
		sc.add("if (deltaKind == " + I_RESOURCE_DELTA(sc) + ".CHANGED && delta.getFlags() != " + I_RESOURCE_DELTA(sc) + ".MARKERS) {");
		sc.add(RESOURCE(sc) + " changedResource = resourceSet.getResource(" + URI(sc) + ".createURI(delta.getFullPath().toString()), false);");
		sc.add("if (changedResource != null) {");
		sc.add("changedResource.unload();");
		sc.add(iTextResourceClassName + " currentResource = getResource();");
		sc.add("if (changedResource.equals(currentResource)) {");
		sc.addComment("reload the resource displayed in the editor");
		sc.add("resourceSet.getResource(currentResource.getURI(), true);");
		sc.add("}");
		// TODO this is kind of strange, since the code is the same as in setResource()
		// I was wondering why setResource() is not called after reloading the resource
		sc.add("if (currentResource != null && currentResource.getErrors().isEmpty()) {");
		sc.add(ECORE_UTIL(sc) + ".resolveAll(currentResource);");
		sc.add("}");
		sc.addComment("reset the selected element in outline and properties by text position");
		sc.add("if (highlighting != null) {");
		sc.add("highlighting.updateEObjectSelection();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();");
		sc.add("delta.accept(visitor);");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " exception) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Unexpected Error: \", exception);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDocumentListenerClass(JavaComposite sc) {
		sc.addJavadoc("A custom document listener that triggers background parsing if needed.");
		sc.add("private final class DocumentListener implements " + I_DOCUMENT_LISTENER(sc) + " {");
		sc.addLineBreak();
		sc.add("public void documentAboutToBeChanged(" + DOCUMENT_EVENT(sc) + " event) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void documentChanged(" + DOCUMENT_EVENT(sc) + " event) {");
		sc.add("bgParsingStrategy.parse(event, getResource(), " + getResourceClassName() + ".this);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
