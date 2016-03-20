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
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_EDITOR_SITE;
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
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PART_INIT_EXCEPTION;
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

import de.devboost.codecomposers.java.JavaComposite;

public class EditorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite jc) {
		GenerationContext context = getContext();

		jc.add("package " + getResourcePackageName() + ";");
		jc.addLineBreak();
		jc.addImportsPlaceholder();
		jc.addLineBreak();
		jc.addJavadoc("A text editor for '" + context.getConcreteSyntax().getName() + "' models."
				, "<p>"
				, "This editor has id <code>" + context.getQualifiedClassName(TextResourceUIArtifacts.EDITOR) + "</code>"
				, "The editor's context menu has id <code>" + context.getEditorContextID() + "</code>. "
				, "The editor's ruler context menu has id <code>" + context.getEditorRulerID() + "</code>."
				, "The editor's editing context has id <code>" + context.getEditorScopeID() + "</code>."
				, "</p>");
		jc.add("public class " + getResourceClassName() + " extends " + TEXT_EDITOR(jc) + " implements " + I_EDITING_DOMAIN_PROVIDER(jc) + ", " + I_SELECTION_PROVIDER(jc) + ", " + I_SELECTION_CHANGED_LISTENER(jc) + ", " + I_VIEWER_PROVIDER(jc) + ", " + iResourceProviderClassName + ", " + iBracketHandlerProviderClassName + ", " + iAnnotationModelProviderClassName + " {");
		jc.addLineBreak();

		addFields(jc);
		addConstructor(jc);
		addMethods(jc);

		jc.add("}");
	}
	
	private void addFields(JavaComposite jc) {
		jc.add("private " + highlightingClassName + " highlighting;");
		jc.add("private " + PROJECTION_SUPPORT(jc) + " projectionSupport;");
		jc.add("private " + codeFoldingManagerClassName + " codeFoldingManager;");
		jc.add("private " + backgroundParsingStrategyClassName + " bgParsingStrategy = new " + backgroundParsingStrategyClassName + "();");
		jc.add("private " + COLLECTION(jc) + "<" + iBackgroundParsingListenerClassName + "> bgParsingListeners = new " + ARRAY_LIST(jc) + "<" + iBackgroundParsingListenerClassName + ">();");
		jc.add("private " + colorManagerClassName + " colorManager = new " + colorManagerClassName + "();");
		jc.add("private " + outlinePageClassName + " outlinePage;");
		jc.add("private " + iTextResourceClassName + " resource;");
		jc.add("private " + I_RESOURCE_CHANGE_LISTENER(jc) + " resourceChangeListener = new ModelResourceChangeListener();");
		jc.add("private " + propertySheetPageClassName + " propertySheetPage;");
		jc.add("private " + EDITING_DOMAIN(jc) + " editingDomain;");
		jc.add("private " + iBracketHandlerClassName + " bracketHandler;");
		jc.add("private " + LIST(jc) + "<" + I_SELECTION_CHANGED_LISTENER(jc) + "> selectionChangedListeners = new " + LINKED_LIST(jc) + "<" + I_SELECTION_CHANGED_LISTENER(jc) + ">();");
		jc.add("private " + I_SELECTION(jc) + " editorSelection;");
		jc.addLineBreak();
	}

	private void addConstructor(JavaComposite jc) {
		jc.add("public " + getResourceClassName() + "() {");
		jc.add("super();");
		jc.add("setSourceViewerConfiguration(new " + sourceViewerConfigurationClassName + "(this, this, colorManager));");
		jc.add(RESOURCES_PLUGIN(jc) + ".getWorkspace().addResourceChangeListener(resourceChangeListener, " + I_RESOURCE_CHANGE_EVENT(jc) + ".POST_CHANGE);");
		jc.add("addSelectionChangedListener(this);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addMethods(JavaComposite jc) {
		addDocumentListenerClass(jc);
		addModelResourceChangeListenerClass(jc);
		addInitializeEditorMethod(jc);
		addGetAdapterMethod(jc);
		addCreatePartControlMethod(jc);
		addInitMethod(jc);
		addInitializeResourceObjectMethod(jc);
		addInitializeResourceObjectFromFileMethod(jc);
		addInitializeResourceObjectFromStorageMethod(jc);
		addDisposeMethod(jc);
		addPerformSaveMethod(jc);
		addInvalidateTextRepresentationMethod(jc);
		addSetFocusMethod(jc);
		addPerformSaveAsMethod(jc);
		addGetResourceSetMethod(jc);
		addGetResourceMethod(jc);
		addSetResourceMethod(jc);
		addGetOutlinePageMethod(jc);
		addGetPropertySheetPageMethod(jc);
		addGetEditingDomainMethod(jc);
		addSetCaretMethod(jc);
		addCreateSourceViewerMethod(jc);
		addAddBackgroundParsingListenerMethod(jc);
		addNotifyBackgroundParsingFinishedMethod(jc);
		addGetBracketHandlerMethod(jc);
		addSetBracketHandlerMethod(jc);
		addCreateActionsMethod(jc);
		addGetAnnotationModelMethod(jc);
		addAddSelectionChangedListenerMethod(jc);
		addGetSelectionMethod(jc);
		addRemoveSelectionChangedListenerMethod(jc);
		addSelectionChangedMethod(jc);
		addSetSelectionMethod1(jc);
		addSetSelectionMethod2(jc);
		addGetViewerMethod(jc);
	}

	private void addInitMethod(JavaComposite jc) {
		jc.add("@" + jc.getClassName(Override.class));
		jc.add("public void init(" + I_EDITOR_SITE(jc) + " site, " + I_EDITOR_INPUT(jc) + " input) throws " + PART_INIT_EXCEPTION(jc) + " {");
		jc.add("super.init(site, input);");
		jc.addLineBreak();
		jc.addComment(
			"Show the 'presentation' action set with the 'Toggle Block Selection" +
	        "Mode' and 'Show Whitespace Characters' actions.");
		jc.add(I_WORKBENCH_PAGE(jc) + " page = site.getPage();");
		jc.add("page.showActionSet(\"org.eclipse.ui.edit.text.actionSet.presentation\");");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addSetSelectionMethod1(JavaComposite jc) {
		jc.add("public void setSelection(" + I_SELECTION(jc) + " selection) {");
		jc.add("editorSelection = selection;");
		jc.add("for (" + I_SELECTION_CHANGED_LISTENER(jc) + " listener : selectionChangedListeners) {");
		jc.add("listener.selectionChanged(new " + SELECTION_CHANGED_EVENT(jc) + "(this, selection));");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addSetSelectionMethod2(JavaComposite jc) {
		jc.add("private boolean setSelection(" + I_SELECTION(jc) + " selection, boolean reveal) {");
		jc.add("if (selection instanceof " + I_STRUCTURED_SELECTION(jc) + ") {");
		jc.add(I_STRUCTURED_SELECTION(jc) + " structuredSelection = (" + I_STRUCTURED_SELECTION(jc) + ") selection;");
		jc.add("Object object = structuredSelection.getFirstElement();");
		jc.add("if (object instanceof " + E_OBJECT(jc) + ") {");
		jc.add(E_OBJECT(jc) + " element = (" + E_OBJECT(jc) + ") object;");
		jc.add(RESOURCE(jc) + " resource = element.eResource();");
		jc.add("if (resource == null) {");
		jc.add("return false;");
		jc.add("}");
		jc.add("if (!(resource instanceof " + iTextResourceClassName + ")) {");
		jc.add("return false;");
		jc.add("}");
		jc.add(iTextResourceClassName + " textResource = (" + iTextResourceClassName + ") resource;");
		jc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		jc.add("int destination = locationMap.getCharStart(element);");
		jc.add("if (destination < 0) {");
		jc.add("destination = 0;");
		jc.add("}");
		jc.add("selectAndReveal(destination, 0);");
		jc.add("int length = locationMap.getCharEnd(element) - destination + 1;");
		jc.add("getSourceViewer().setRangeIndication(destination, length, true);");
		jc.add("getSourceViewer().setSelectedRange(destination, length);");
		jc.add("return true;");
		jc.add("}");
		jc.add("}");
		jc.add("return false;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetViewerMethod(JavaComposite jc) {
		jc.add("public " + VIEWER(jc) + " getViewer() {");
		jc.add("return (" + PROJECTION_VIEWER(jc) + ") getSourceViewer();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addSelectionChangedMethod(JavaComposite jc) {
		jc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT(jc) + " event) {");
		jc.add(I_SELECTION(jc) + " selection = event.getSelection();");
		jc.add("setSelection(selection, true);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addRemoveSelectionChangedListenerMethod(JavaComposite jc) {
		jc.add("public void removeSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER(jc) + " listener) {");
		jc.add("selectionChangedListeners.remove(listener);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetSelectionMethod(JavaComposite jc) {
		jc.add("public " + I_SELECTION(jc) + " getSelection() {");
		jc.add("return editorSelection;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addAddSelectionChangedListenerMethod(JavaComposite jc) {
		jc.add("public void addSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER(jc) + " listener) {");
		jc.add("selectionChangedListeners.add(listener);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetAnnotationModelMethod(JavaComposite jc) {
		jc.add("public " + I_ANNOTATION_MODEL(jc) + " getAnnotationModel() {");
		jc.add("return getDocumentProvider().getAnnotationModel(getEditorInput());");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetBracketHandlerMethod(JavaComposite jc) {
		jc.add("public " + iBracketHandlerClassName + " getBracketHandler() {");
		jc.add("return bracketHandler;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addSetBracketHandlerMethod(JavaComposite jc) {
		jc.add("public void setBracketHandler(" + iBracketHandlerClassName + " bracketHandler) {");
		jc.add("this.bracketHandler = bracketHandler;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addInitializeEditorMethod(JavaComposite jc) {
		String editorContextID = getContext().getEditorContextID();
		String editorRulerID = getContext().getEditorRulerID();

		jc.add("public void initializeEditor() {");
		jc.add("super.initializeEditor();");
		jc.add("setEditorContextMenuId(\"" + editorContextID + "\");");
		jc.add("setRulerContextMenuId(\"" + editorRulerID + "\");");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addNotifyBackgroundParsingFinishedMethod(JavaComposite jc) {
		jc.add("public void notifyBackgroundParsingFinished() {");
		jc.add("for (" + iBackgroundParsingListenerClassName + " listener : bgParsingListeners) {");
		jc.add("listener.parsingCompleted(getResource());");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addAddBackgroundParsingListenerMethod(JavaComposite jc) {
		jc.add("public void addBackgroundParsingListener(" + iBackgroundParsingListenerClassName + " listener) {");
		jc.add("bgParsingListeners.add(listener);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addCreateSourceViewerMethod(JavaComposite jc) {
		jc.add("protected " + I_SOURCE_VIEWER(jc) + " createSourceViewer(" + COMPOSITE(jc) + " parent, " + I_VERTICAL_RULER(jc) + " ruler, int styles) {");
		jc.add(I_SOURCE_VIEWER(jc) + " viewer = new " + PROJECTION_VIEWER(jc) + "(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles) {");
		jc.addLineBreak();
		jc.add("public void setSelection(" + I_SELECTION(jc) + " selection, boolean reveal) {");
		jc.add("if (!" + getResourceClassName() + ".this.setSelection(selection, reveal)) {");
		jc.add("super.setSelection(selection, reveal);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("};");
		jc.addComment("ensure decoration support has been created and configured.");
		jc.add("getSourceViewerDecorationSupport(viewer);");
		jc.add("return viewer;");
		jc.add("}");
		jc.addLineBreak();
	}

	// FIXME This method seems not to be used. Remove it?
	private void addSetCaretMethod(JavaComposite jc) {

		jc.addJavadoc(
				"Sets the caret to the offset of the given element.",
				"@param element has to be contained in the resource of this editor."
		);
		jc.add("public void setCaret(" + E_OBJECT(jc) + " element, String text) {");
		jc.add("try {");
		jc.add("if (element == null || text == null || text.equals(\"\")) {");
		jc.add("return;");
		jc.add("}");
		jc.add(I_SOURCE_VIEWER(jc) + " viewer = getSourceViewer();");
		jc.add(iTextResourceClassName + " textResource = (" + iTextResourceClassName + ") element.eResource();");
		jc.add(iLocationMapClassName + " locationMap = textResource.getLocationMap();");
		jc.add("int destination = locationMap.getCharStart(element);");
		jc.add("int length = locationMap.getCharEnd(element) + 1 - destination;");
		jc.addLineBreak();
		jc.add(iTextScannerClassName + " lexer = getResource().getMetaInformation().createLexer();");
		jc.add("try {");
		jc.add("lexer.setText(viewer.getDocument().get(destination, length));");
		jc.add(iTextTokenClassName + " token = lexer.getNextToken();");
		jc.add("String tokenText = token.getText();");
		jc.add("while (tokenText != null) {");
		jc.add("if (token.getText().equals(text)) {");
		jc.add("destination += token.getOffset();");
		jc.add("break;");
		jc.add("}");
		jc.add("token = lexer.getNextToken();");
		jc.add("if (token == null) {");
		jc.add("break;");
		jc.add("}");
		jc.add("tokenText = token.getText();");
		jc.add("}");
		jc.add("} catch (" + BAD_LOCATION_EXCEPTION(jc) + " e) {");
		jc.add("}");
		jc.add("destination = ((" + PROJECTION_VIEWER(jc) + ") viewer).modelOffset2WidgetOffset(destination);");
		jc.add("if (destination < 0) {");
		jc.add("destination = 0;");
		jc.add("}");
		jc.add("viewer.getTextWidget().setSelection(destination);");
		jc.add("} catch (Exception e) {");
		jc.add(uiPluginActivatorClassName + ".logError(\"Exception in setCaret()\", e);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetEditingDomainMethod(JavaComposite jsc) {
		jsc.add("public " + EDITING_DOMAIN(jsc) + " getEditingDomain() {");
		jsc.add("if (editingDomain == null) {");
		jsc.add("editingDomain = new " + editingDomainProviderClassName + "().getEditingDomain(getEditorInput());");
		jsc.add("}");
		jsc.add("return editingDomain;");
		jsc.add("}");
		jsc.addLineBreak();
	}

	private void addGetPropertySheetPageMethod(JavaComposite jc) {
		jc.add("public " + I_PROPERTY_SHEET_PAGE(jc) + " getPropertySheetPage() {");
		jc.add("if (propertySheetPage == null) {");
		jc.add("propertySheetPage = new " + propertySheetPageClassName + "();");
		jc.addComment(
				"add a slightly modified adapter factory that does not return any " +
				"editors for properties. " +
				"this way, a model can never be modified through the properties " +
				"view."
		);
		jc.add(ADAPTER_FACTORY(jc) + " adapterFactory = new " + adapterFactoryProviderClassName + "().getAdapterFactory();");
		jc.add("propertySheetPage.setPropertySourceProvider(new " + ADAPTER_FACTORY_CONTENT_PROVIDER(jc) + "(adapterFactory) {");
		jc.add("protected " + I_PROPERTY_SOURCE(jc) + " createPropertySource(Object object, " + I_ITEM_PROPERTY_SOURCE(jc) + " itemPropertySource) {");
		jc.add("return new " + PROPERTY_SOURCE(jc) + "(object, itemPropertySource) {");
		jc.add("protected " + I_PROPERTY_DESCRIPTOR(jc) + " createPropertyDescriptor(" + I_ITEM_PROPERTY_DESCRIPTOR(jc) + " itemPropertyDescriptor) {");
		jc.add("return new " + PROPERTY_DESCRIPTOR(jc) + "(object, itemPropertyDescriptor) {");
		jc.add("public " + CELL_EDITOR(jc) + " createPropertyEditor(" + COMPOSITE(jc) + " composite) {");
		jc.add("return null;");
		jc.add("}");
		jc.add("};");
		jc.add("}");
		jc.add("};");
		jc.add("}");
		jc.add("});");
		jc.add("highlighting.addSelectionChangedListener(propertySheetPage);");
		jc.add("}");
		jc.add("return propertySheetPage;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetOutlinePageMethod(JavaComposite jc) {
		jc.addJavadoc(
			"Returns the outline page this is associated with this editor. " +
			"If no outline page exists, a new one is created."
		);
		jc.add("private " + outlinePageClassName + " getOutlinePage() {");
		jc.add("if (outlinePage == null) {");
		jc.add("outlinePage = new " + outlinePageClassName + "(this);");
		jc.addComment("Connect highlighting class and outline page for event notification");
		jc.add("outlinePage.addSelectionChangedListener(highlighting);");
		jc.add("highlighting.addSelectionChangedListener(outlinePage);");
		jc.add("}");
		jc.add("return outlinePage;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addSetResourceMethod(JavaComposite jc) {
		jc.add("private void setResource(" + iTextResourceClassName + " resource) {");
		jc.add("assert resource != null;");
		jc.add("this.resource = resource;");
		jc.add("if (this.resource.getErrors().isEmpty()) {");
		jc.add(ECORE_UTIL(jc) + ".resolveAll(this.resource);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetResourceMethod(JavaComposite jc) {
		jc.add("public " + iTextResourceClassName + " getResource() {");
		jc.add("return resource;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetResourceSetMethod(JavaComposite jc) {
		jc.add("public " + RESOURCE_SET(jc) + " getResourceSet() {");
		jc.add("return getEditingDomain().getResourceSet();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addPerformSaveAsMethod(JavaComposite jc) {
		jc.add("protected void performSaveAs(" + I_PROGRESS_MONITOR(jc) + " progressMonitor) {");
		jc.add(FILE_EDITOR_INPUT(jc) + " input = (" + FILE_EDITOR_INPUT(jc) + ") getEditorInput();");
		jc.add("String path = input.getFile().getFullPath().toString();");
		jc.add(RESOURCE_SET(jc) + " resourceSet = getResourceSet();");
		jc.add(URI(jc) + " platformURI = " + URI(jc) + ".createPlatformResourceURI(path, true);");
		jc.add(RESOURCE(jc) + " oldFile = resourceSet.getResource(platformURI, true);");
		jc.addLineBreak();
		jc.add("super.performSaveAs(progressMonitor);");
		jc.addLineBreak();
		jc.addComment("load and resave - input has been changed to new path by super");
		jc.add(FILE_EDITOR_INPUT(jc) + " newInput = (" + FILE_EDITOR_INPUT(jc) + ") getEditorInput();");
		jc.add("String newPath = newInput.getFile().getFullPath().toString();");
		jc.add(URI(jc) + " newPlatformURI = " + URI(jc) + ".createPlatformResourceURI(newPath, true);");
		jc.add(RESOURCE(jc) + " newFile = resourceSet.createResource(newPlatformURI);");
		jc.addComment("if the extension is the same, saving was already performed by super by saving the plain text");
		jc.add("if (platformURI.fileExtension().equals(newPlatformURI.fileExtension())) {");
		jc.add("oldFile.unload();");
		jc.addComment("save code folding state, is it possible with a new name");
		jc.add("codeFoldingManager.saveCodeFoldingStateFile(getResource().getURI().toString());");
		jc.add("}");
		jc.add("else {");
		jc.add("newFile.getContents().clear();");
		jc.add("newFile.getContents().addAll(oldFile.getContents());");
		jc.add("try {");
		jc.add("oldFile.unload();");
		jc.add("if (newFile.getErrors().isEmpty()) {");
		jc.add("newFile.save(null);");
		jc.add("}");
		jc.add("} catch (Exception e) {");
		jc.add("e.printStackTrace();");
		jc.add("}");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addSetFocusMethod(JavaComposite jc) {
		jc.add("public void setFocus() {");
		jc.add("super.setFocus();");
		jc.add("this.invalidateTextRepresentation();");
		jc.addComment("Parse the document again to remove errors that stem from unresolvable proxy objects");
		jc.add("bgParsingStrategy.parse(getSourceViewer().getDocument(), resource, this, 10);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addInvalidateTextRepresentationMethod(JavaComposite jc) {
		jc.add("public void invalidateTextRepresentation() {");
		jc.add(I_SOURCE_VIEWER(jc) + " viewer = getSourceViewer();");
		jc.add("if (viewer != null) {");
		jc.add("viewer.invalidateTextPresentation();");
		jc.add("}");
		jc.add("highlighting.resetValues();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addPerformSaveMethod(JavaComposite jc) {
		jc.add("protected void performSave(boolean overwrite, " + I_PROGRESS_MONITOR(jc) + " progressMonitor) {");
		jc.addLineBreak();
		jc.add("super.performSave(overwrite, progressMonitor);");
		jc.addLineBreak();
		jc.addComment("Save code folding state");
		jc.add("codeFoldingManager.saveCodeFoldingStateFile(getResource().getURI().toString());");
		jc.add("}");
		jc.addLineBreak();
		jc.add("public void registerTextPresentationListener(" + I_TEXT_PRESENTATION_LISTENER(jc) + " listener) {");
		jc.add(I_SOURCE_VIEWER(jc) + " viewer = getSourceViewer();");
		jc.add("if (viewer instanceof " + TEXT_VIEWER(jc) + ") {");
		jc.add("((" + TEXT_VIEWER(jc) + ") viewer).addTextPresentationListener(listener);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addDisposeMethod(JavaComposite jc) {
		jc.add("public void dispose() {");
		jc.add("colorManager.dispose();");
		jc.add(RESOURCES_PLUGIN(jc) + ".getWorkspace().removeResourceChangeListener(resourceChangeListener);"); 
		jc.add("super.dispose();");
		jc.add("}");
		jc.addLineBreak();
	}
	
	private void addInitializeResourceObjectMethod(JavaComposite jc) {
		jc.add("private void initializeResourceObject(" + I_EDITOR_INPUT(jc) + " editorInput) {");
		jc.add("if (editorInput instanceof " + FILE_EDITOR_INPUT(jc) + ") {");
		jc.add("initializeResourceObjectFromFile((" + FILE_EDITOR_INPUT(jc) + ") editorInput);");
		jc.add("} else if (editorInput instanceof " + I_STORAGE_EDITOR_INPUT(jc) + ") {");
		jc.add("initializeResourceObjectFromStorage((" + I_STORAGE_EDITOR_INPUT(jc) + ") editorInput);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addInitializeResourceObjectFromStorageMethod(JavaComposite jc) {
		jc.add("private void initializeResourceObjectFromStorage(" + I_STORAGE_EDITOR_INPUT(jc) + " input) {");
		jc.add(URI(jc) + " uri = null;");
		jc.add("try {");
		jc.add(I_STORAGE(jc) + " storage = input.getStorage();");
		jc.add(INPUT_STREAM(jc) + " inputStream = storage.getContents();");
		jc.add("uri = URI.createURI(storage.getName(), true);");
		jc.add(RESOURCE_SET(jc) + " resourceSet = getResourceSet();");
		jc.add(iTextResourceClassName + " resource = (" + iTextResourceClassName + ") resourceSet.createResource(uri);");
		jc.add("resource.load(inputStream, null);");
		jc.add("setResource(resource);");
		jc.add("} catch (" + CORE_EXCEPTION(jc) + " e) {");
		jc.add(uiPluginActivatorClassName + ".logError(\"Exception while loading resource (\" + uri + \") in \" + getClass().getSimpleName() + \".\", e);");
		jc.add("} catch (" + IO_EXCEPTION(jc) + " e) {");
		jc.add(uiPluginActivatorClassName + ".logError(\"Exception while loading resource (\" + uri + \") in \" + getClass().getSimpleName() + \".\", e);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addInitializeResourceObjectFromFileMethod(JavaComposite jc) {
		jc.add("private void initializeResourceObjectFromFile(" + FILE_EDITOR_INPUT(jc) + " input) {");
		jc.add(I_FILE(jc) + " inputFile = input.getFile();");
		
		// TODO activating the DSL nature here is ugly
		jc.add(natureClassName + ".activate(inputFile.getProject());");

		jc.add("String path = inputFile.getFullPath().toString();");
		jc.add(URI(jc) + " uri = " + URI(jc) + ".createPlatformResourceURI(path, true);");
		jc.add(RESOURCE_SET(jc) + " resourceSet = getResourceSet();");
		jc.add(iTextResourceClassName + " loadedResource = (" + iTextResourceClassName + ") resourceSet.getResource(uri, false);");
		jc.add("if (loadedResource == null) {");
		jc.add("try {");
		jc.add(RESOURCE(jc)  + " demandLoadedResource = null;");
		jc.addComment("here we do not use getResource(), because 'resource' might be null, which is ok when initializing the resource object");
		jc.add(iTextResourceClassName + " currentResource = this.resource;");
		jc.add("if (currentResource != null && !currentResource.getURI().fileExtension().equals(uri.fileExtension())) {");
		jc.addComment("do not attempt to load if file extension has changed in a 'save as' operation	");
		jc.add("}");
		jc.add("else {");
		jc.add("demandLoadedResource = resourceSet.getResource(uri, true);");
		jc.add("}");
		jc.add("if (demandLoadedResource instanceof " + iTextResourceClassName + ") {");
		jc.add("setResource((" + iTextResourceClassName + ") demandLoadedResource);");
		jc.add("} else {");
		jc.addComment("the resource was not loaded by an EMFText resource, but some other EMF resource");
		jc.add(uiPluginActivatorClassName + ".showErrorDialog(\"Invalid resource.\", \"The file '\" + uri.lastSegment() + \"' of type '\" + uri.fileExtension() + \"' can not be handled by the " + getResourceClassName() + ".\");");
		jc.addComment("close this editor because it can not present the resource");
		jc.add("close(false);");
		jc.add("}");
		jc.add("} catch (Exception e) {");
		jc.add(uiPluginActivatorClassName + ".logError(\"Exception while loading resource in \" + this.getClass().getSimpleName() + \".\", e);");
		jc.add("}");
		jc.add("} else {");
		jc.add("setResource(loadedResource);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addCreatePartControlMethod(JavaComposite jc) {
		jc.add("public void createPartControl(" + COMPOSITE(jc) + " parent) {");
		jc.add("super.createPartControl(parent);");
		jc.addLineBreak();
		jc.addComment("Code Folding");
		jc.add(PROJECTION_VIEWER(jc) + " viewer = (" + PROJECTION_VIEWER(jc) + ") getSourceViewer();");
		jc.addComment("Occurrence initiation, need ITextResource and ISourceViewer.");
		jc.add("highlighting = new " + highlightingClassName + "(getResource(), viewer, colorManager, this);");
		jc.addLineBreak();
		jc.add("projectionSupport = new " + PROJECTION_SUPPORT(jc) + "(viewer, getAnnotationAccess(), getSharedColors());");
		jc.add("projectionSupport.install();");
		jc.addLineBreak();
		jc.addComment("turn projection mode on");
		jc.add("viewer.doOperation(" + PROJECTION_VIEWER(jc) + ".TOGGLE);");
		jc.add("codeFoldingManager = new " + codeFoldingManagerClassName + "(viewer, this);");
		jc.addLineBreak();
		jc.add(I_CONTEXT_SERVICE(jc) + " contextService = ("+ I_CONTEXT_SERVICE(jc) + ") getSite().getService(" + I_CONTEXT_SERVICE(jc) + ".class);");
		jc.add("contextService.activateContext(\"" + getContext().getEditorScopeID() + "\");");
		jc.add("}");
		jc.addLineBreak();
		jc.add("protected void doSetInput(" + I_EDITOR_INPUT(jc) + " editorInput) throws " + CORE_EXCEPTION(jc) + " {");
		jc.add("super.doSetInput(editorInput);");
		jc.add("initializeResourceObject(editorInput);");
		jc.add(I_DOCUMENT(jc) + " document = getDocumentProvider().getDocument(getEditorInput());");
		jc.add("document.addDocumentListener(new DocumentListener());");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addCreateActionsMethod(JavaComposite jc) {
		jc.add("public void createActions() {");
		jc.add("super.createActions();");
		jc.add(RESOURCE_BUNDLE(jc) + " resourceBundle = new " + RESOURCE_BUNDLE(jc) + "() {");
		jc.add("public " + ENUMERATION(jc) + "<String> getKeys() {");
		jc.add(LIST(jc) + "<String> keys = new " + ARRAY_LIST(jc) + "<String>(3);");
		jc.add("keys.add(\"SelectAnnotationRulerAction.QuickFix.label\");");
		jc.add("keys.add(\"SelectAnnotationRulerAction.QuickFix.tooltip\");");
		jc.add("keys.add(\"SelectAnnotationRulerAction.QuickFix.description\");");
		jc.add("return " + COLLECTIONS(jc) + ".enumeration(keys);");
		jc.add("}");
		jc.add("public Object handleGetObject(String key) {");
		jc.add("if (key.equals(\"SelectAnnotationRulerAction.QuickFix.label\")) return \"&Quick Fix\";");
		jc.add("if (key.equals(\"SelectAnnotationRulerAction.QuickFix.tooltip\")) return \"Quick Fix\";");
		jc.add("if (key.equals(\"SelectAnnotationRulerAction.QuickFix.description\")) return \"Runs Quick Fix on the annotation's line\";");
		jc.add("return null;");
		jc.add("}");
		jc.add("};");
		jc.add("setAction(" + I_TEXT_EDITOR_ACTION_CONSTANTS(jc) + ".RULER_CLICK, new " + SELECT_MARKER_RULES_ACTION(jc) + "(resourceBundle, \"SelectAnnotationRulerAction.\", this, getVerticalRuler()) {");
		jc.add("public void run() {");
		jc.add("runWithEvent(null);");
		jc.add("}");
		jc.addLineBreak();
		jc.add("public void runWithEvent(" + EVENT(jc) + " event) {");
		jc.add(I_TEXT_OPERATION_TARGET(jc) + " operation = (" + I_TEXT_OPERATION_TARGET(jc) + ") getAdapter(" + I_TEXT_OPERATION_TARGET(jc) + ".class);");
		jc.add("final int opCode = " + I_SOURCE_VIEWER(jc) + ".QUICK_ASSIST;");
		jc.add("if (operation != null && operation.canDoOperation(opCode)) {");
		jc.add(POSITION(jc) + " position = getPosition();");
		jc.add("if (position != null) {");
		jc.add("selectAndReveal(position.getOffset(), position.getLength());");
		jc.add("}");
		jc.add("operation.doOperation(opCode);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("private " + POSITION(jc) + " getPosition() {");
		jc.add(ABSTRACT_MARKER_ANNOTATION_MODEL(jc) + " model = getAnnotationModel();");
		jc.add(I_ANNOTATION_ACCESS_EXTENSION(jc) + "  annotationAccess = getAnnotationAccessExtension();");
		jc.addLineBreak();
		jc.add(I_DOCUMENT(jc) + " document = getDocument();");
		jc.add("if (model == null) {");
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
		jc.add(ITERATOR(jc) + "<?> iter = model.getAnnotationIterator();");
		jc.add("int layer = Integer.MIN_VALUE;");
		jc.addLineBreak();
		jc.add("while (iter.hasNext()) {");
		jc.add(ANNOTATION(jc) + " annotation = (" + ANNOTATION(jc) + ") iter.next();");
		jc.add("if (annotation.isMarkedDeleted()) {");
		jc.add("continue;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("if (annotationAccess != null) {");
		jc.add("int annotationLayer = annotationAccess.getLayer(annotation);");
		jc.add("if (annotationLayer < layer) {");
		jc.add("continue;");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add(POSITION(jc) + " position = model.getPosition(annotation);");
		jc.add("if (!includesRulerLine(position, document)) {");
		jc.add("continue;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return position;");
		jc.add("}");
		jc.add("return null;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("});");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetAdapterMethod(JavaComposite jc) {
		jc.add("public Object getAdapter(@SuppressWarnings(\"rawtypes\") Class required) {");
		jc.add("if (" + I_CONTENT_OUTLINE_PAGE(jc) + ".class.equals(required)) {");
		jc.add("return getOutlinePage();");
		jc.add("} else if (required.equals(" + I_PROPERTY_SHEET_PAGE(jc) + ".class)) {");
		jc.add("return getPropertySheetPage();");
		jc.add("}");
		jc.add("return super.getAdapter(required);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addModelResourceChangeListenerClass(JavaComposite jc) {
		jc.addJavadoc(
				"Reacts to changes of the text resource displayed in the editor and " +
				"resources cross-referenced by it. Cross-referenced resources are " +
				"unloaded, the displayed resource is reloaded. An attempt to resolve all " +
				"proxies in the displayed resource is made after each change.",
				"The code pretty much corresponds to what EMF generates for a tree editor."
		);
		jc.add("private class ModelResourceChangeListener implements " + I_RESOURCE_CHANGE_LISTENER(jc) + " {");
		jc.add("public void resourceChanged(" + I_RESOURCE_CHANGE_EVENT(jc) + " event) {");
		jc.add(I_RESOURCE_DELTA(jc) + " delta = event.getDelta();");
		jc.add("try {");
		jc.add("class ResourceDeltaVisitor implements " + I_RESOURCE_DELTA_VISITOR(jc) + " {");
		jc.add("protected " + RESOURCE_SET(jc) + " resourceSet = getResourceSet();");
		jc.addLineBreak();
		jc.add("public boolean visit(" + I_RESOURCE_DELTA(jc) + " delta) {");
		jc.add("if (delta.getResource().getType() != " + I_RESOURCE(jc) + ".FILE) {");
		jc.add("return true;");
		jc.add("}");
		jc.add("int deltaKind = delta.getKind();");
		jc.add("if (deltaKind == " + I_RESOURCE_DELTA(jc) + ".CHANGED && delta.getFlags() != " + I_RESOURCE_DELTA(jc) + ".MARKERS) {");
		jc.add(URI(jc) + " platformURI = " + URI(jc) + ".createPlatformResourceURI(delta.getFullPath().toString(), true);");
		jc.add(RESOURCE(jc) + " changedResource = resourceSet.getResource(platformURI, false);");
		jc.add("if (changedResource != null) {");
		jc.add("changedResource.unload();");
		jc.add(iTextResourceClassName + " currentResource = getResource();");
		jc.add("if (changedResource.equals(currentResource)) {");
		jc.addComment("reload the resource displayed in the editor");
		jc.add("resourceSet.getResource(currentResource.getURI(), true);");
		jc.add("}");
		// TODO this is kind of strange, since the code is the same as in setResource()
		// I was wondering why setResource() is not called after reloading the resource
		jc.add("if (currentResource != null && currentResource.getErrors().isEmpty()) {");
		jc.add(ECORE_UTIL(jc) + ".resolveAll(currentResource);");
		jc.add("}");
		jc.addComment("reset the selected element in outline and properties by text position");
		jc.add("if (highlighting != null) {");
		jc.add("highlighting.updateEObjectSelection();");
		jc.add("}");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("return true;");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
		jc.add("ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();");
		jc.add("delta.accept(visitor);");
		jc.add("} catch (" + CORE_EXCEPTION(jc) + " exception) {");
		jc.add(uiPluginActivatorClassName + ".logError(\"Unexpected Error: \", exception);");
		jc.add("}");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addDocumentListenerClass(JavaComposite jc) {
		jc.addJavadoc("A custom document listener that triggers background parsing if needed.");
		jc.add("private final class DocumentListener implements " + I_DOCUMENT_LISTENER(jc) + " {");
		jc.addLineBreak();
		jc.add("public void documentAboutToBeChanged(" + DOCUMENT_EVENT(jc) + " event) {");
		jc.add("}");
		jc.addLineBreak();
		jc.add("public void documentChanged(" + DOCUMENT_EVENT(jc) + " event) {");
		jc.add("bgParsingStrategy.parse(event, getResource(), " + getResourceClassName() + ".this);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}
}
