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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ADAPTER_FACTORY_CONTENT_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ADAPTER_FACTORY_LABEL_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.GROUP_MARKER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ACTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ACTION_BARS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONTENT_OUTLINE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_MENU_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_MENU_MANAGER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PAGE_SITE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TOOL_BAR_MANAGER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_ACTION_CONSTANTS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.LISTENER_LIST;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MENU;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MENU_MANAGER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.TREE_VIEWER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIGeneratorUtil;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class OutlinePageGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final UIGeneratorUtil generatorUtil = new UIGeneratorUtil();
	
	public void generateJavaContents(JavaComposite sc) {
		String outlineContextMenuID = getContext().getResourceUIPlugin().getName() + ".outlinecontext";
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc("Simple Outline Page using the ReflectiveItemAdapters provided by EMF");
		sc.add("public class " + getResourceClassName() + " extends " + PAGE(sc) + " implements " + I_SELECTION_PROVIDER(sc) + ", " + I_SELECTION_CHANGED_LISTENER(sc) + ", " + I_CONTENT_OUTLINE_PAGE(sc) + " {");
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
		addCreateActionsMethod(sc);
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

	private void addSetSelectionMethod(JavaComposite sc) {
		sc.add("public void setSelection(" + I_SELECTION(sc) + " selection) {");
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

	private void addSelectionChangedMethod(JavaComposite sc) {
		sc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT(sc) + " event) {");
		sc.add("if (getTreeViewer() != null) {");
		sc.add("getTreeViewer().setSelection(event.getSelection(), true);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveSelectionChangedListenerMethod(JavaComposite sc) {
		sc.add("public void removeSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER(sc) + " listener) {");
		sc.add("if (getTreeViewer() == null) {");
		sc.add("selectionChangedListeners.remove(listener);");
		sc.add("} else {");
		sc.add("getTreeViewer().removeSelectionChangedListener(listener);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitMethod(JavaComposite sc) {
		sc.add("public void init(" + I_PAGE_SITE(sc) + " pageSite) {");
		sc.add("super.init(pageSite);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTreeViewer(JavaComposite sc) {
		sc.addJavadoc(
			"Returns this page's tree viewer.",
			"@return this page's tree viewer, or <code>null</code> if <code>createControl</code> has not been called yet"
		);
		sc.add("protected " + TREE_VIEWER(sc) + " getTreeViewer() {");
		sc.add("return treeViewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSelectionMethod(JavaComposite sc) {
		sc.add("public " + I_SELECTION(sc) + " getSelection() {");
		sc.add("if (treeViewer == null) {");
		sc.add("return " + STRUCTURED_SELECTION(sc) + ".EMPTY;");
		sc.add("}");
		sc.add("return treeViewer.getSelection();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetControlMethod(JavaComposite sc) {
		sc.add("public " + CONTROL(sc) + " getControl() {");
		sc.add("if (treeViewer == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return treeViewer.getControl();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddSelectionChangedListenerMethod(JavaComposite sc) {
		sc.add("public void addSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER(sc) + " listener) {");
		sc.add("if (getTreeViewer() == null) {");
		sc.add("selectionChangedListeners.add(listener);");
		sc.add("} else {");
		sc.add("getTreeViewer().addSelectionChangedListener(listener);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateControlMethod(JavaComposite sc) {
		sc.add("public void createControl(" + COMPOSITE(sc) + " parent) {");
		sc.add("treeViewer = new " + outlinePageTreeViewerClassName + "(parent, " + SWT(sc) + ".MULTI | " + SWT(sc) + ".H_SCROLL | " + SWT(sc) + ".V_SCROLL);");
		sc.add("Object[] listeners = selectionChangedListeners.getListeners();");
		sc.add("for (int i = 0; i < listeners.length; ++i) {");
		sc.add(I_SELECTION_CHANGED_LISTENER(sc) + " l = (" + I_SELECTION_CHANGED_LISTENER(sc) + ") listeners[i];");
		sc.add("treeViewer.addSelectionChangedListener(l);");
		sc.add("}");
		sc.add("selectionChangedListeners.clear();");
		generatorUtil.addCreateAdapterFactoryCode(sc);
		sc.add(ADAPTER_FACTORY_CONTENT_PROVIDER(sc) + " contentProvider = new " + ADAPTER_FACTORY_CONTENT_PROVIDER(sc) + "(adapterFactory);");
		sc.add("treeViewer.setAutoExpandLevel(AUTO_EXPAND_LEVEL);");
		sc.add("treeViewer.setContentProvider(contentProvider);");
		sc.add("treeViewer.setLabelProvider(new " + ADAPTER_FACTORY_LABEL_PROVIDER(sc) + "(adapterFactory));");
		sc.add(RESOURCE(sc) + " resource = resourceProvider.getResource();");
		sc.add("treeViewer.setInput(resource);");
		sc.add("if (resource != null) {");
		sc.addComment("Select the root object in the view.");
		sc.add("treeViewer.setSelection(new " + STRUCTURED_SELECTION(sc) + "(resource), true);");
		sc.add("}");
		sc.add("treeViewer.setComparator(new "+ outlinePageTreeViewerComparatorClassName + "());");
		sc.add("createContextMenu();");
		sc.add("createActions();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateActionsMethod(JavaComposite sc) {
		sc.add("private void createActions() {");
		sc.add(I_PAGE_SITE(sc) + " site = getSite();");
		sc.add(I_ACTION_BARS(sc) + " actionBars = site.getActionBars();");
		sc.add(I_TOOL_BAR_MANAGER(sc) + " toolBarManager = actionBars.getToolBarManager();");
		sc.add(LIST(sc) + "<" + I_ACTION(sc) + "> actions = new " + outlinePageActionProviderClassName + "().getActions(treeViewer);");
		sc.add("for (" + I_ACTION(sc) + " action : actions) {");
		sc.add("toolBarManager.add(action);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateContextMenuMethod(JavaComposite sc, String outlineContextMenuID) {
		sc.add("private void createContextMenu() {");
		sc.addComment("create menu manager");
		sc.add(MENU_MANAGER(sc) + " menuManager = new " + MENU_MANAGER(sc) + "();");
		sc.add("menuManager.setRemoveAllWhenShown(true);");
		sc.add("menuManager.addMenuListener(new " + I_MENU_LISTENER(sc) + "() {");
		sc.add("public void menuAboutToShow(" + I_MENU_MANAGER(sc) + " manager) {");
		sc.add("fillContextMenu(manager);");
		sc.add("}");
		sc.add("});");
		sc.addComment("create menu");
		sc.add(MENU(sc) + " menu = menuManager.createContextMenu(treeViewer.getControl());");
		sc.add("treeViewer.getControl().setMenu(menu);");
		sc.addComment("register menu for extension");
		sc.add("getSite().registerContextMenu(\"" + outlineContextMenuID + "\", menuManager, treeViewer);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFillContextMenuMethod(JavaComposite sc) {
		sc.add("private void fillContextMenu(" + I_MENU_MANAGER(sc) + " manager) {");
		sc.add("manager.add(new " + GROUP_MARKER(sc) + "(" + I_WORKBENCH_ACTION_CONSTANTS(sc) + ".MB_ADDITIONS));");
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
		sc.add("public static int AUTO_EXPAND_LEVEL = 2;");
		sc.addLineBreak();
		sc.addJavadoc(
			"The provider for the resource that is displayed in the outline page. " +
			"Normally this is the current editor."
		);
		sc.add("private " + iResourceProviderClassName + " resourceProvider;");
		sc.add("private " + outlinePageTreeViewerClassName + " treeViewer;");
		sc.add("private " + LISTENER_LIST(sc) + " selectionChangedListeners = new " + LISTENER_LIST(sc) + "();");
		sc.addLineBreak();
	}
}
