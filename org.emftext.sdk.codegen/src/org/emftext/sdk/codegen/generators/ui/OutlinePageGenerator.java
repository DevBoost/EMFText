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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ADAPTER_FACTORY_CONTENT_PROVIDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ADAPTER_FACTORY_LABEL_PROVIDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_CONTENT_OUTLINE_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PAGE_SITE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION_CHANGED_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION_PROVIDER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LISTENER_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TREE_VIEWER;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GeneratorUtil;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class OutlinePageGenerator extends JavaBaseGenerator {

	private final GeneratorUtil generatorUtil = new GeneratorUtil();

	private String editorClassName;
	private String outlinePageTreeViewerClassName;

	public OutlinePageGenerator() {
		super();
	}

	private OutlinePageGenerator(GenerationContext context) {
		super(context, EArtifact.OUTLINE_PAGE);
		editorClassName = getContext().getQualifiedClassName(EArtifact.EDITOR);
		outlinePageTreeViewerClassName = getContext().getQualifiedClassName(EArtifact.OUTLINE_PAGE_TREE_VIEWER);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// Simple Outline Page using the ReflectiveItemAdapters provided by EMF");
		sc.add("public class " + getResourceClassName() + " extends " + PAGE + " implements " + I_SELECTION_PROVIDER + ", " + I_SELECTION_CHANGED_LISTENER + ", " + I_CONTENT_OUTLINE_PAGE + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addCreateControlMethod(sc);
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

	private void addSetFocusMethod(StringComposite sc) {
		sc.add("// Sets focus to a part in the page.");
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

	private void addGetTreeViewer(StringComposite sc) {
		sc.add("// Returns this page's tree viewer.");
		sc.add("//");
		sc.add("// @return this page's tree viewer, or <code>null</code> if");
		sc.add("//         <code>createControl</code> has not been called yet");
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

	private void addCreateControlMethod(StringComposite sc) {
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
		sc.add("treeViewer.setAutoExpandLevel(3);");
		sc.add("treeViewer.setContentProvider(contentProvider);");
		sc.add("treeViewer.setLabelProvider(new " + ADAPTER_FACTORY_LABEL_PROVIDER + "(adapterFactory));");
		sc.add(RESOURCE_SET + " resourceSet = editor.getResourceSet();");
		sc.add(E_LIST + "<" + RESOURCE + "> resources = resourceSet.getResources();");
		sc.add("treeViewer.setInput(resources.get(0));");
		sc.add("if (!resources.isEmpty()) {");
		sc.add("// Select the root object in the view.");
		sc.add("treeViewer.setSelection(new " + STRUCTURED_SELECTION + "(resources.get(0)), true);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + editorClassName + " textEditor) {");
		sc.add("super();");
		sc.add("this.editor = textEditor;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + editorClassName + " editor;");
		sc.add("private " + TREE_VIEWER + " treeViewer;");
		sc.add("private " + LISTENER_LIST + " selectionChangedListeners = new " + LISTENER_LIST + "();");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new OutlinePageGenerator(context);
	}
}
