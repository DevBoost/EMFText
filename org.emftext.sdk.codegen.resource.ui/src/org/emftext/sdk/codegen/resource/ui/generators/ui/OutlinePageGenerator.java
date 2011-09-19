/*******************************************************************************
 * Copyright (c) 2006-2011
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
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ADAPTER_FACTORY_LABEL_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.GROUP_MARKER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_CONTENT_OUTLINE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MENU_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MENU_MANAGER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PAGE_SITE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKBENCH_ACTION_CONSTANTS;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LISTENER_LIST;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MENU;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MENU_MANAGER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TREE_VIEWER;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIGeneratorUtil;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class OutlinePageGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final UIGeneratorUtil generatorUtil = new UIGeneratorUtil();
	
	public void generateJavaContents(JavaComposite sc) {
		String outlineContextMenuID = getContext().getResourceUIPlugin().getName() + ".outlinecontext";
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc("Simple Outline Page using the ReflectiveItemAdapters provided by EMF");
		sc.add("public class " + getResourceClassName() + " extends " + PAGE + " implements " + I_SELECTION_PROVIDER + ", " + I_SELECTION_CHANGED_LISTENER + ", " + I_CONTENT_OUTLINE_PAGE + " {");
		sc.addLineBreak();
		
		addFields(sc, outlineContextMenuID);
		addConstructor(sc);
		addMethods(sc, outlineContextMenuID);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc, String outlineContextMenuID) {
		addCreateControlMethod(sc);
		addCreateContextMenuMethod(sc, outlineContextMenuID);
		addFillContextMenuMethod(sc);
		addAddSelectionChangedListenerMethod(sc);
		addGetControlMethod(sc);
		addGetSelectionMethod(sc);
		addGetTreeViewer(sc);
		addInitMethod(sc);
		addRemoveSelectionChangedListenerMethod(sc);
		addSelectionChangedMethod(sc);
		addSetFocusMethod(sc);
		addSetSelectionMethod(sc);
	}

	private void addSetSelectionMethod(StringComposite sc) {
		sc.add("public void setSelection(" + I_SELECTION + " selection) {");
		sc.add("if (treeViewer != null) {");
		sc.add("treeViewer.setSelection(selection);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetFocusMethod(JavaComposite sc) {
		sc.addJavadoc("Sets focus to a part in the page.");
		sc.add("public void setFocus() {");
		sc.add("treeViewer.getControl().setFocus();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSelectionChangedMethod(StringComposite sc) {
		sc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT + " event) {");
		sc.add("if (getTreeViewer() != null) {");
		sc.add("getTreeViewer().setSelection(event.getSelection(), true);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveSelectionChangedListenerMethod(StringComposite sc) {
		sc.add("public void removeSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER + " listener) {");
		sc.add("if (getTreeViewer() == null) {");
		sc.add("selectionChangedListeners.remove(listener);");
		sc.add("} else {");
		sc.add("getTreeViewer().removeSelectionChangedListener(listener);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitMethod(StringComposite sc) {
		sc.add("public void init(" + I_PAGE_SITE + " pageSite) {");
		sc.add("super.init(pageSite);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTreeViewer(JavaComposite sc) {
		sc.addJavadoc(
			"Returns this page's tree viewer.",
			"@return this page's tree viewer, or <code>null</code> if <code>createControl</code> has not been called yet"
		);
		sc.add("protected " + TREE_VIEWER + " getTreeViewer() {");
		sc.add("return treeViewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSelectionMethod(StringComposite sc) {
		sc.add("public " + I_SELECTION + " getSelection() {");
		sc.add("if (treeViewer == null) {");
		sc.add("return " + STRUCTURED_SELECTION + ".EMPTY;");
		sc.add("}");
		sc.add("return treeViewer.getSelection();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetControlMethod(StringComposite sc) {
		sc.add("public " + CONTROL + " getControl() {");
		sc.add("if (treeViewer == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return treeViewer.getControl();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddSelectionChangedListenerMethod(StringComposite sc) {
		sc.add("public void addSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER + " listener) {");
		sc.add("if (getTreeViewer() == null) {");
		sc.add("selectionChangedListeners.add(listener);");
		sc.add("} else {");
		sc.add("getTreeViewer().addSelectionChangedListener(listener);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateControlMethod(JavaComposite sc) {
		sc.add("public void createControl(" + COMPOSITE + " parent) {");
		sc.add("treeViewer = new " + outlinePageTreeViewerClassName + "(parent, " + SWT + ".MULTI | " + SWT + ".H_SCROLL | " + SWT + ".V_SCROLL);");
		sc.add("Object[] listeners = selectionChangedListeners.getListeners();");
		sc.add("for (int i = 0; i < listeners.length; ++i) {");
		sc.add(I_SELECTION_CHANGED_LISTENER + " l = (" + I_SELECTION_CHANGED_LISTENER + ") listeners[i];");
		sc.add("treeViewer.addSelectionChangedListener(l);");
		sc.add("}");
		sc.add("selectionChangedListeners.clear();");
		generatorUtil.addCreateAdapterFactoryCode(sc);
		sc.add(ADAPTER_FACTORY_CONTENT_PROVIDER + " contentProvider = new " + ADAPTER_FACTORY_CONTENT_PROVIDER + "(adapterFactory);");
		sc.add("treeViewer.setAutoExpandLevel(AUTO_EXPAND_LEVEL);");
		sc.add("treeViewer.setContentProvider(contentProvider);");
		sc.add("treeViewer.setLabelProvider(new " + ADAPTER_FACTORY_LABEL_PROVIDER + "(adapterFactory));");
		sc.add(RESOURCE + " resource = resourceProvider.getResource();");
		sc.add("treeViewer.setInput(resource);");
		sc.add("if (resource != null) {");
		sc.addComment("Select the root object in the view.");
		sc.add("treeViewer.setSelection(new " + STRUCTURED_SELECTION + "(resource), true);");
		sc.add("}");
		sc.add("createContextMenu();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateContextMenuMethod(JavaComposite sc, String outlineContextMenuID) {
		sc.add("private void createContextMenu() {");
		sc.addComment("create menu manager");
		sc.add(MENU_MANAGER + " menuManager = new " + MENU_MANAGER + "();");
		sc.add("menuManager.setRemoveAllWhenShown(true);");
		sc.add("menuManager.addMenuListener(new " + I_MENU_LISTENER + "() {");
		sc.add("public void menuAboutToShow(" + I_MENU_MANAGER + " manager) {");
		sc.add("fillContextMenu(manager);");
		sc.add("}");
		sc.add("});");
		sc.addComment("create menu");
		sc.add(MENU + " menu = menuManager.createContextMenu(treeViewer.getControl());");
		sc.add("treeViewer.getControl().setMenu(menu);");
		sc.addComment("register menu for extension");
		sc.add("getSite().registerContextMenu(\"" + outlineContextMenuID + "\", menuManager, treeViewer);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFillContextMenuMethod(JavaComposite sc) {
		sc.add("private void fillContextMenu(" + I_MENU_MANAGER + " manager) {");
		sc.add("manager.add(new " + GROUP_MARKER + "(" + I_WORKBENCH_ACTION_CONSTANTS + ".MB_ADDITIONS));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iResourceProviderClassName + " resourceProvider) {");
		sc.add("super();");
		sc.add("this.resourceProvider = resourceProvider;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc, String outlineContextMenuID) {
		sc.add("public final static String CONTEXT_MENU_ID = \"" + outlineContextMenuID + "\";");
		sc.addLineBreak();
		sc.addJavadoc("The auto expand level determines the depth to which the outline tree is expanded by default.");
		sc.add("public static int AUTO_EXPAND_LEVEL = 3;");
		sc.addLineBreak();
		sc.addJavadoc(
			"The provider for the resource that is displayed in the outline page. " +
			"Normally this is the current editor."
		);
		sc.add("private " + iResourceProviderClassName + " resourceProvider;");
		sc.add("private " + TREE_VIEWER + " treeViewer;");
		sc.add("private " + LISTENER_LIST + " selectionChangedListeners = new " + LISTENER_LIST + "();");
		sc.addLineBreak();
	}
}
