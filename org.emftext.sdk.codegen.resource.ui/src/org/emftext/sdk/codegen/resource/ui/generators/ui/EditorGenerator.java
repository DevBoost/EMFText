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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ADAPTER_FACTORY_CONTENT_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ADAPTER_FACTORY_EDITING_DOMAIN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BASIC_COMMAND_STACK;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CELL_EDITOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPOSED_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.DOCUMENT_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ECORE_ITEM_PROVIDER_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ECORE_UTIL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.EDITING_DOMAIN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FILE_DOCUMENT_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FILE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTENT_OUTLINE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DOCUMENT_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_EDITING_DOMAIN_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ITEM_PROPERTY_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ITEM_PROPERTY_SOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PROPERTY_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PROPERTY_SHEET_PAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PROPERTY_SOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE_CHANGE_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE_CHANGE_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE_DELTA;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE_DELTA_VISITOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SOURCE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_TEXT_PRESENTATION_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_VERTICAL_RULER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PROJECTION_SUPPORT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PROJECTION_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PROPERTY_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PROPERTY_SOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.REFLECTIVE_ITEM_PROVIDER_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE_ITEM_PROVIDER_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RUNNABLE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TEXT_EDITOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TEXT_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.URI;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class EditorGenerator extends UIJavaBaseGenerator {

	public EditorGenerator() {
		super();
	}

	private EditorGenerator(GenerationContext context) {
		super(context, TextResourceUIArtifacts.EDITOR);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc("A text editor for '" + getContext().getConcreteSyntax().getName() + "' models.");
		sc.add("public class " + getResourceClassName() + " extends " + TEXT_EDITOR + " implements " + I_EDITING_DOMAIN_PROVIDER + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
		return true;
	}

	private void addMethods(JavaComposite sc) {
		addMarkerUpdateListenerClass(sc);
		addDocumentListenerClass(sc);
		addModelResourceChangeListenerClass(sc);
		addInitializeEditorMethod(sc);
		addGetAdapterMethod(sc);
		addCreatePartControlMethod(sc);
		addInitializeResourceObjectMethod(sc);
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
		addInitializeEditingDomainMethod(sc);
		addSetCaretMethod(sc);
		addCreateSourceViewerMethod(sc);
		addAddBackgroundParsingListenerMethod(sc);
		addNotifyBackgroundParsingFinishedMethod(sc);
		addRefreshMarkersMethod(sc);
	}

	private void addInitializeEditorMethod(StringComposite sc) {
		sc.add("public void initializeEditor() {");
		sc.add("super.initializeEditor();");
		sc.add("setEditorContextMenuId(\"" + context.getResourcePlugin().getName() + ".EditorContext\");");
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
		sc.add("protected " + I_SOURCE_VIEWER + " createSourceViewer(" + COMPOSITE + " parent, " + I_VERTICAL_RULER + " ruler, int styles) {");
		sc.add(I_SOURCE_VIEWER + " viewer = new " + PROJECTION_VIEWER + "(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);");
		sc.addComment("ensure decoration support has been created and configured.");
		sc.add("getSourceViewerDecorationSupport(viewer);");
		sc.add("return viewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetCaretMethod(JavaComposite sc) {
		
		sc.addJavadoc(
			"Sets the caret to the offset of the given element.",
			"@param element has to be contained in the resource of this editor."
		);
		sc.add("public void setCaret(" + E_OBJECT + " element, String text) {");
		sc.add("try {");
		sc.add("if (element == null || text == null || text.equals(\"\")) {");
		sc.add("return;");
		sc.add("}");
		sc.add(I_SOURCE_VIEWER + " viewer = getSourceViewer();");
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
		sc.add("tokenText = token.getText();");
		sc.add("}");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("destination = ((" + PROJECTION_VIEWER + ") viewer).modelOffset2WidgetOffset(destination);");
		sc.add("if (destination < 0) {");
		sc.add("destination = 0;");
		sc.add("}");
		sc.add("viewer.getTextWidget().setSelection(destination);");
		sc.add("} catch (" + EXCEPTION + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"" + EXCEPTION + " in setCaret()\", e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeEditingDomainMethod(JavaComposite sc) {
		sc.add("private void initializeEditingDomain() {");
		sc.add("adapterFactory = new " + COMPOSED_ADAPTER_FACTORY + "(" + COMPOSED_ADAPTER_FACTORY + ".Descriptor.Registry.INSTANCE);");
		sc.add("adapterFactory.addAdapterFactory(new " + RESOURCE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
		sc.add("adapterFactory.addAdapterFactory(new " + ECORE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
		sc.add("adapterFactory.addAdapterFactory(new " + REFLECTIVE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
		sc.addLineBreak();
		sc.add(BASIC_COMMAND_STACK + " commandStack = new " + BASIC_COMMAND_STACK + "();");
		sc.addComment("CommandStackListeners can listen for changes. Not sure whether this is needed.");
		sc.addLineBreak();
		sc.add("editingDomain = new " + ADAPTER_FACTORY_EDITING_DOMAIN + "(adapterFactory,commandStack, new " + LINKED_HASH_MAP + "<" + RESOURCE + ", Boolean>());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEditingDomainMethod(StringComposite sc) {
		sc.add("public " + EDITING_DOMAIN + " getEditingDomain() {");
		sc.add("return editingDomain;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPropertySheetPageMethod(JavaComposite sc) {
		sc.add("public " + I_PROPERTY_SHEET_PAGE + " getPropertySheetPage() {");
		sc.add("if (propertySheetPage == null) {");
		sc.add("propertySheetPage = new " + propertySheetPageClassName + "();");
		sc.addComment(
			"add a slightly modified adapter factory that does not return any " +
			"editors for properties. " +
			"this way, a model can never be modified through the properties" +
			"view."
		);
		sc.add("propertySheetPage.setPropertySourceProvider(new " + ADAPTER_FACTORY_CONTENT_PROVIDER + "(adapterFactory) {");
		sc.add("protected " + I_PROPERTY_SOURCE + " createPropertySource(" + OBJECT + " object, " + I_ITEM_PROPERTY_SOURCE + " itemPropertySource) {");
		sc.add("return new " + PROPERTY_SOURCE + "(object, itemPropertySource) {");
		sc.add("protected " + I_PROPERTY_DESCRIPTOR + " createPropertyDescriptor(" + I_ITEM_PROPERTY_DESCRIPTOR + " itemPropertyDescriptor) {");
		sc.add("return new " + PROPERTY_DESCRIPTOR + "(object, itemPropertyDescriptor) {");
		sc.add("public " + CELL_EDITOR + " createPropertyEditor(" + COMPOSITE + " composite) {");
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

	private void addGetOutlinePageMethod(StringComposite sc) {
		sc.add("private " + OBJECT + " getOutlinePage() {");
		sc.add("if (outlinePage == null) {");
		sc.add("outlinePage = new " + outlinePageClassName + "(this);");
		sc.add("outlinePage.addSelectionChangedListener(highlighting);");
		sc.add("highlighting.addSelectionChangedListener(outlinePage);");
		sc.add("}");
		sc.add("return outlinePage;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetResourceMethod(StringComposite sc) {
		sc.add("private void setResource(" + iTextResourceClassName + " resource) {");
		sc.add("assert resource != null;");
		sc.add("this.resource = resource;");
		sc.add("if (this.resource.getErrors().isEmpty()) {");
		sc.add(ECORE_UTIL + ".resolveAll(this.resource);");
		sc.add("}");
		sc.add("refreshMarkers(this.resource);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceMethod(StringComposite sc) {
		sc.add("public " + iTextResourceClassName + " getResource() {");
		sc.add("assert resource != null;");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetResourceSetMethod(StringComposite sc) {
		sc.add("public " + RESOURCE_SET + " getResourceSet() {");
		sc.add("return editingDomain.getResourceSet();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformSaveAsMethod(JavaComposite sc) {
		sc.add("protected void performSaveAs(" + I_PROGRESS_MONITOR + " progressMonitor) {");
		sc.add(FILE_EDITOR_INPUT + " input = (" + FILE_EDITOR_INPUT + ") getEditorInput();");
		sc.add("String path = input.getFile().getFullPath().toString();");
		sc.add(RESOURCE_SET + " resourceSet = editingDomain.getResourceSet();");
		sc.add(URI + " platformURI = " + URI + ".createPlatformResourceURI(path, true);");
		sc.add(RESOURCE + " oldFile = resourceSet.getResource(platformURI, true);");
		sc.addLineBreak();
		sc.add("super.performSaveAs(progressMonitor);");
		sc.addLineBreak();
		sc.addComment("load and resave - input has been changed to new path by super");
		sc.add(FILE_EDITOR_INPUT + " newInput = (" + FILE_EDITOR_INPUT + ") getEditorInput();");
		sc.add("String newPath = newInput.getFile().getFullPath().toString();");
		sc.add(URI + " newPlatformURI = " + URI + ".createPlatformResourceURI(newPath, true);");
		sc.add(RESOURCE + " newFile = resourceSet.createResource(newPlatformURI);");
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
		sc.add("} catch (" + EXCEPTION + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetFocusMethod(StringComposite sc) {
		sc.add("public void setFocus() {");
		sc.add("super.setFocus();");
		sc.add("this.invalidateTextRepresentation();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInvalidateTextRepresentationMethod(StringComposite sc) {
		sc.add("public void invalidateTextRepresentation() {");
		sc.add(I_SOURCE_VIEWER + " viewer = getSourceViewer();");
		sc.add("if (viewer != null) {");
		sc.add("viewer.invalidateTextPresentation();");
		sc.add("}");
		sc.add("highlighting.resetValues();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformSaveMethod(JavaComposite sc) {
		sc.add("protected void performSave(boolean overwrite, " + I_PROGRESS_MONITOR + " progressMonitor) {");
		sc.addLineBreak();
		sc.add("super.performSave(overwrite, progressMonitor);");
		sc.addComment("update markers after the resource has been reloaded");
		sc.add("refreshMarkers(getResource());");
		sc.addLineBreak();
		sc.addComment("Save code folding state");
		sc.add("codeFoldingManager.saveCodeFoldingStateFile(getResource().getURI().toString());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void registerTextPresentationListener(" + I_TEXT_PRESENTATION_LISTENER + " listener) {");
		sc.add(I_SOURCE_VIEWER + " viewer = getSourceViewer();");
		sc.add("if (viewer instanceof " + TEXT_VIEWER + ") {");
		sc.add("((" + TEXT_VIEWER + ") viewer).addTextPresentationListener(listener);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDisposeMethod(StringComposite sc) {
		sc.add("public void dispose() {");
		sc.add("colorManager.dispose();");
		sc.add("super.dispose();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeResourceObjectMethod(JavaComposite sc) {
		boolean disableBuilder = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.DISABLE_BUILDER);

		sc.add("private void initializeResourceObject(" + I_EDITOR_INPUT + " editorInput) {");
		sc.add(FILE_EDITOR_INPUT + " input = (" + FILE_EDITOR_INPUT + ") editorInput;");
		sc.add(I_FILE + " inputFile = input.getFile();");
		if (!disableBuilder) {
			// TODO activating the DSL nature here is ugly
			sc.add(natureClassName + ".activate(inputFile.getProject());");
		}
		sc.add("String path = inputFile.getFullPath().toString();");
		sc.add(URI + " uri = " + URI + ".createPlatformResourceURI(path, true);");
		sc.add(RESOURCE_SET + " resourceSet = editingDomain.getResourceSet();");
		sc.add(iTextResourceClassName + " loadedResource = (" + iTextResourceClassName + ") resourceSet.getResource(uri, false);");
		sc.add("if (loadedResource == null) {");
		sc.add("try {");
		sc.add(RESOURCE  + " demandLoadedResource = null;");
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
		sc.add(uiPluginActivatorClassName + ".showErrorDialog(\"No EMFText resource.\", \"The file '\" + uri.lastSegment() + \"' of type '\" + uri.fileExtension() + \"' can not be handled by the " + getResourceClassName() + ".\");");
		sc.addComment("close this editor because it can not present the resource");
		sc.add("close(false);");
		sc.add("}");
		sc.add("} catch (" + EXCEPTION + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while loading resource in \" + this.getClass().getSimpleName() + \".\", e);");
		sc.add("}");
		sc.add("} else {");
		sc.add("setResource(loadedResource);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreatePartControlMethod(JavaComposite sc) {
		sc.add("public void createPartControl(" + COMPOSITE + " parent) {");
		sc.add("super.createPartControl(parent);");
		sc.add("display = parent.getShell().getDisplay();");
		sc.addComment(
			"we might need to refresh the markers, because the display was not set before, which " +
			"prevents updates of the markers"
		);
		sc.add("refreshMarkers(getResource());");
		sc.addLineBreak();
		sc.addComment("Code Folding");
		sc.add(PROJECTION_VIEWER + " viewer = (" + PROJECTION_VIEWER + ") getSourceViewer();");
		sc.addComment("Occurrence initiation, need ITextResource and ISourceViewer.");
		sc.add("highlighting = new " + highlightingClassName + "(getResource(), viewer, colorManager, this);");
		sc.addLineBreak();
		sc.add("projectionSupport = new " + PROJECTION_SUPPORT + "(viewer, getAnnotationAccess(), getSharedColors());");
		sc.add("projectionSupport.install();");
		sc.addLineBreak();
		sc.addComment("turn projection mode on");
		sc.add("viewer.doOperation(" + PROJECTION_VIEWER + ".TOGGLE);");
		sc.add("codeFoldingManager = new " + codeFoldingManagerClassName + "(viewer, this);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("protected void doSetInput(" + I_EDITOR_INPUT + " editorInput) throws " + CORE_EXCEPTION + " {");
		sc.add("super.doSetInput(editorInput);");
		sc.add("initializeResourceObject(editorInput);");
		sc.add(I_DOCUMENT + " document = getDocumentProvider().getDocument(getEditorInput());");
		sc.add("document.addDocumentListener(new DocumentListener());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("setDocumentProvider(new " + FILE_DOCUMENT_PROVIDER + "());");
		sc.add("setSourceViewerConfiguration(new " + editorConfigurationClassName + "(this, colorManager));");
		sc.add("initializeEditingDomain();");
		sc.add("addBackgroundParsingListener(new MarkerUpdateListener());");
		sc.add(RESOURCES_PLUGIN + ".getWorkspace().addResourceChangeListener(resourceChangeListener, " + I_RESOURCE_CHANGE_EVENT + ".POST_CHANGE);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAdapterMethod(StringComposite sc) {
		sc.add("@SuppressWarnings(\"unchecked\")");
		sc.addLineBreak();
		sc.add("public " + OBJECT + " getAdapter(Class required) {");
		sc.add("if (" + I_CONTENT_OUTLINE_PAGE + ".class.equals(required)) {");
		sc.add("return getOutlinePage();");
		sc.add("} else if (required.equals(" + I_PROPERTY_SHEET_PAGE + ".class)) {");
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
		sc.add("private class ModelResourceChangeListener implements " + I_RESOURCE_CHANGE_LISTENER + " {");
		sc.add("public void resourceChanged(" + I_RESOURCE_CHANGE_EVENT + " event) {");
		sc.add(I_RESOURCE_DELTA + " delta = event.getDelta();");
		sc.add("try {");
		sc.add("class ResourceDeltaVisitor implements " + I_RESOURCE_DELTA_VISITOR + " {");
		sc.add("protected " + RESOURCE_SET + " resourceSet = editingDomain.getResourceSet();");
		sc.addLineBreak();
		sc.add("public boolean visit(" + I_RESOURCE_DELTA + " delta) {");
		sc.add("if (delta.getResource().getType() != " + I_RESOURCE + ".FILE) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("int deltaKind = delta.getKind();");
		sc.add("if (deltaKind == " + I_RESOURCE_DELTA + ".CHANGED && delta.getFlags() != " + I_RESOURCE_DELTA + ".MARKERS) {");
		sc.add(RESOURCE + " changedResource = resourceSet.getResource(" + URI + ".createURI(delta.getFullPath().toString()), false);");
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
		sc.add(ECORE_UTIL + ".resolveAll(currentResource);");
		sc.add("}");
		sc.add("refreshMarkers(currentResource);");
		sc.addComment("reset the selected element in outline and properties by text position");
		sc.add("if (highlighting != null) {");
		sc.add("highlighting.setEObjectSelection();");
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
		sc.add("} catch (" + CORE_EXCEPTION + " exception) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Unexpected Error: \", exception);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDocumentListenerClass(JavaComposite sc) {
		sc.addJavadoc("A custom document listener that triggers background parsing if needed.");
		sc.add("private final class DocumentListener implements " + I_DOCUMENT_LISTENER + " {");
		sc.addLineBreak();
		sc.add("public void documentAboutToBeChanged(" + DOCUMENT_EVENT + " event) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void documentChanged(" + DOCUMENT_EVENT + " event) {");
		sc.add("bgParsingStrategy.parse(event, getResource(), " + getResourceClassName() + ".this);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMarkerUpdateListenerClass(StringComposite sc) {
		sc.add("private final class MarkerUpdateListener implements " + iBackgroundParsingListenerClassName + " {");
		sc.add("public void parsingCompleted(" + RESOURCE + " parsedResource) {");
		// TODO again: this is the same code as in setResource()?
		sc.add("if (parsedResource != null && parsedResource.getErrors().isEmpty()) {");
		sc.add(ECORE_UTIL + ".resolveAll(parsedResource);");
		sc.add("}");
		sc.add("refreshMarkers(parsedResource);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addRefreshMarkersMethod(StringComposite sc) {
		sc.add("private void refreshMarkers(final " + RESOURCE + " resourceToRefresh) {");
		sc.add("if (resourceToRefresh == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (display != null) {");
		sc.add("display.asyncExec(new " + RUNNABLE + "() {");
		sc.add("public void run() {");
		sc.add("try {");
		sc.add(markerHelperClassName + ".unmark(resourceToRefresh);");
		sc.add(markerHelperClassName + ".mark(resourceToRefresh);");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add(uiPluginActivatorClassName + ".logError(\"Exception while updating markers on resource\", e);");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + highlightingClassName + " highlighting;");
		sc.add("private " + PROJECTION_SUPPORT + " projectionSupport;");
		sc.add("private " + codeFoldingManagerClassName + " codeFoldingManager;");
		sc.add("private " + backgroundParsingStrategyClassName + " bgParsingStrategy = new " + backgroundParsingStrategyClassName + "();");
		sc.add("private " + COLLECTION + "<" + iBackgroundParsingListenerClassName + "> bgParsingListeners = new " + ARRAY_LIST + "<" + iBackgroundParsingListenerClassName + ">();");
		sc.add("private " + colorManagerClassName + " colorManager = new " + colorManagerClassName + "();");
		sc.add("private " + outlinePageClassName + " outlinePage;");
		sc.add("private " + iTextResourceClassName + " resource;");
		sc.add("private " + I_RESOURCE_CHANGE_LISTENER + " resourceChangeListener = new ModelResourceChangeListener();");
		sc.add("private " + propertySheetPageClassName + " propertySheetPage;");
		sc.add("private " + EDITING_DOMAIN + " editingDomain;");
		sc.add("private " + COMPOSED_ADAPTER_FACTORY + " adapterFactory;");
		sc.add("private " + DISPLAY + " display;");
		sc.addLineBreak();
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new EditorGenerator(context);
	}
}