package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;

import java.io.PrintWriter;
import org.emftext.sdk.codegen.EArtifact;

public class OutlinePageGenerator extends BaseGenerator {

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

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// Simple Outline Page using the ReflectiveItemAdapters provided by EMF");
		sc.add("public class " + getResourceClassName() + " extends " + PAGE + " implements " + I_SELECTION_PROVIDER + ", " + I_SELECTION_CHANGED_LISTENER + ", " + I_CONTENT_OUTLINE_PAGE + " {");
		sc.addLineBreak();
		
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addMethods(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
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

	private void addSetSelectionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void setSelection(" + I_SELECTION + " selection) {");
		sc.add("if (treeViewer != null) {");
		sc.add("treeViewer.setSelection(selection);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetFocusMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Sets focus to a part in the page.");
		sc.add("public void setFocus() {");
		sc.add("treeViewer.getControl().setFocus();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSelectionChangedMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void selectionChanged(" + SELECTION_CHANGED_EVENT + " event) {");
		sc.add("if (getTreeViewer() != null) {");
		sc.add("getTreeViewer().setSelection(event.getSelection(), true);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveSelectionChangedListenerMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void removeSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER + " listener) {");
		sc.add("if (getTreeViewer() == null) {");
		sc.add("selectionChangedListeners.remove(listener);");
		sc.add("} else {");
		sc.add("getTreeViewer().removeSelectionChangedListener(listener);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void init(" + I_PAGE_SITE + " pageSite) {");
		sc.add("super.init(pageSite);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTreeViewer(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Returns this page's tree viewer.");
		sc.add("//");
		sc.add("// @return this page's tree viewer, or <code>null</code> if");
		sc.add("//         <code>createControl</code> has not been called yet");
		sc.add("protected " + TREE_VIEWER + " getTreeViewer() {");
		sc.add("return treeViewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSelectionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + I_SELECTION + " getSelection() {");
		sc.add("if (treeViewer == null) {");
		sc.add("return " + STRUCTURED_SELECTION + ".EMPTY;");
		sc.add("}");
		sc.add("return treeViewer.getSelection();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetControlMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + CONTROL + " getControl() {");
		sc.add("if (treeViewer == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("return treeViewer.getControl();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddSelectionChangedListenerMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void addSelectionChangedListener(" + I_SELECTION_CHANGED_LISTENER + " listener) {");
		sc.add("if (getTreeViewer() == null) {");
		sc.add("selectionChangedListeners.add(listener);");
		sc.add("} else {");
		sc.add("getTreeViewer().addSelectionChangedListener(listener);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateControlMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void createControl(" + COMPOSITE + " parent) {");
		sc.add("treeViewer = new " + outlinePageTreeViewerClassName + "(parent, " + SWT + ".MULTI | " + SWT + ".H_SCROLL | " + SWT + ".V_SCROLL);");
		sc.add("Object[] listeners = selectionChangedListeners.getListeners();");
		sc.add("for (int i = 0; i < listeners.length; ++i) {");
		sc.add(I_SELECTION_CHANGED_LISTENER + " l = (" + I_SELECTION_CHANGED_LISTENER + ") listeners[i];");
		sc.add("treeViewer.addSelectionChangedListener(l);");
		sc.add("}");
		sc.add("selectionChangedListeners.clear();");
		sc.add(COMPOSED_ADAPTER_FACTORY + " adapterFactory = new " + COMPOSED_ADAPTER_FACTORY + "(");
		sc.add(COMPOSED_ADAPTER_FACTORY + ".Descriptor.Registry.INSTANCE);");
		sc.add("adapterFactory.addAdapterFactory(new " + RESOURCE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
		sc.add("adapterFactory.addAdapterFactory(new " + ECORE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
		sc.add("adapterFactory.addAdapterFactory(new " + REFLECTIVE_ITEM_PROVIDER_ADAPTER_FACTORY + "());");
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

	private void addConstructor(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + editorClassName + " textEditor) {");
		sc.add("super();");
		sc.add("this.editor = textEditor;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private " + editorClassName + " editor;");
		sc.add("private " + TREE_VIEWER + " treeViewer;");
		sc.add("private " + LISTENER_LIST + " selectionChangedListeners = new " + LISTENER_LIST + "();");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new OutlinePageGenerator(context);
	}
}
