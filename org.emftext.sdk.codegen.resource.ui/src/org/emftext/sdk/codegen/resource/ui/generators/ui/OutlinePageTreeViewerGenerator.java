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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TREE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.*;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class OutlinePageTreeViewerGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"This custom implementation of a TreeViewer expands the tree " +
			"automatically up to a specified depth."
		);
		sc.add("public class " + getResourceClassName() + " extends " + TREE_VIEWER + " {");
		sc.addLineBreak();
		
		addInnerClassTypeFilter(sc);
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
	}

	private void addRemoveTypeToFilterMethod(JavaComposite sc) {
		sc.add("public void removeTypeToFilter(" + E_CLASS + " typeToNotFilter) {");
		sc.add("typeFilter.getFilteredTypes().remove(typeToNotFilter);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddTypeToFilterMethod(JavaComposite sc) {
		sc.add("public void addTypeToFilter(" + E_CLASS + " typeToFilter) {");
		sc.add("typeFilter.getFilteredTypes().add(typeToFilter);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInnerClassTypeFilter(JavaComposite sc) {
		sc.add("public class TypeFilter extends " + VIEWER_FILTER + " {");
		sc.addLineBreak();
		sc.add("private " +  sc.declareLinkedHashSet("filteredTypes", E_CLASS));
		sc.addLineBreak();
		sc.add("@Override").addLineBreak();
		sc.add("public boolean select(" + VIEWER + " viewer, Object parentElement, Object element) {");
		sc.add("if (element instanceof " + E_OBJECT + ") {");
		sc.add(E_OBJECT + " eObject = (" + E_OBJECT + ") element;");
		sc.add("for (" + E_CLASS + " filteredType : filteredTypes) {");
		sc.add("if (filteredType.isInstance(eObject)) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + SET + "<" + E_CLASS + "> getFilteredTypes() {");
		sc.add("return filteredTypes;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private boolean suppressNotifications = false;");
		sc.addLineBreak();
		sc.add("private boolean linkWithEditor = false;");
		sc.addLineBreak();
		sc.add("private boolean autoExpand = false;");
		sc.addLineBreak();
		sc.add("private TypeFilter typeFilter = new TypeFilter();");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addSetSelectionMethod(sc);
		addHandleSelectMethod(sc);
		addHandleInvalidSelectionMethod(sc);
		addRefreshMethod1(sc);
		addRefreshMethod2(sc);
		addRefreshMethod3(sc);
		addRefreshMethod4(sc);
		addSetAutoExpandMethod(sc);
		addExpandToLevelMethod(sc);
		addFireSelectionChangedMethod(sc);
		addSetLinkWithEditorMethod(sc);
		addDoAutoExpandMethod(sc);
		addAddTypeToFilterMethod(sc);
		addRemoveTypeToFilterMethod(sc);
	}

	private void addSetAutoExpandMethod(JavaComposite sc) {
		sc.add("public void setAutoExpand(boolean autoExpand) {");
		sc.add("this.autoExpand = autoExpand;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoAutoExpandMethod(JavaComposite sc) {
		sc.add("private void doAutoExpand() {");
		sc.add("if (!autoExpand) {");
		sc.add("return;");
		sc.add("}");
		sc.add("expandToLevel(getAutoExpandLevel());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addExpandToLevelMethod(JavaComposite sc) {
		sc.add("public void expandToLevel(int level) {");
		sc.addComment(
			"we need to catch exceptions here, because refreshing the outline " +
			"does sometimes cause the LabelProviders to throw exceptions, if the " +
			"model is in some inconsistent state."
		);
		sc.add("try {");
		sc.add("super.expandToLevel(level);");
		sc.add("} catch (Exception e) {");
		// I'm not sure whether we could discard this exception right away, but for the time
		// being let's send it to the error log.
		sc.add(pluginActivatorClassName + ".logError(\"Exception while refreshing outline view\", e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRefreshMethod4(StringComposite sc) {
		sc.add("public void refresh(boolean updateLabels) {");
		sc.add("super.refresh(updateLabels);");
		sc.add("doAutoExpand();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRefreshMethod3(StringComposite sc) {
		sc.add("public void refresh() {");
		sc.add("super.refresh();");
		sc.add("doAutoExpand();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRefreshMethod2(StringComposite sc) {
		sc.add("public void refresh(Object element) {");
		sc.add("super.refresh(element);");
		sc.add("doAutoExpand();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRefreshMethod1(StringComposite sc) {
		sc.add("public void refresh(Object element, boolean updateLabels) {");
		sc.add("super.refresh(element, updateLabels);");
		sc.add("doAutoExpand();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetSelectionMethod(StringComposite sc) {
		sc.add("public void setSelection(" + I_SELECTION + " selection, boolean reveal) {");
		sc.add("if (!linkWithEditor) {");
		sc.add("return;");
		sc.add("}");
		sc.add("if (selection instanceof " + eObjectSelectionClassName + ") {");
		sc.add("suppressNotifications = true;");
		sc.add("super.setSelection(selection, reveal);");
		sc.add("suppressNotifications = false;");
		sc.add("}");
		sc.add("else {");
		sc.add("super.setSelection(selection, reveal);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addHandleSelectMethod(JavaComposite sc) {
		sc.add("protected void handleSelect(" + SELECTION_EVENT + " event) {");
		sc.add("if (event.item == null) {");
		sc.addComment(
			"In the cases of an invalid document, the tree widget in the outline might fire an event " +
			"(with item == null) without user interaction. We do not want to react to that event."
		);		
		sc.add("} else {");
		sc.add("super.handleSelect(event);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addHandleInvalidSelectionMethod(JavaComposite sc) {
		sc.add("protected void handleInvalidSelection(" + I_SELECTION + " selection, " + I_SELECTION + " newSelection) {");
		sc.addComment("this may not fire a selection changed event to avoid cyclic events between editor and outline");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addFireSelectionChangedMethod(StringComposite sc) {
		sc.add("protected void fireSelectionChanged(" + SELECTION_CHANGED_EVENT + " event) {");
		sc.add("if (suppressNotifications == true) {");
		sc.add("return;");
		sc.add("}");
		sc.add("super.fireSelectionChanged(event);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + COMPOSITE + " parent, int style) {");
		sc.add("super(parent, style);");
		sc.add("addFilter(typeFilter);");
		sc.add("setComparer(new " + I_ELEMENT_COMPARER + "() {");
		sc.addLineBreak();
		sc.add("public int hashCode(Object element) {");
		sc.add("String s = toString(element);");
		sc.add("if (s != null) {");
		sc.add("return s.hashCode();");
		sc.add("}");
		sc.add("return element.hashCode();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean equals(Object o1, Object o2) {");
		sc.add("String s1 = toString(o1);");
		sc.add("String s2 = toString(o2);");
		sc.add("if (s1 != null) {");
		sc.add("return s1.equals(s2);");
		sc.add("}");
		sc.add("return o1.equals(o2);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private String toString(Object o) {");
		sc.add("if (o instanceof " + E_OBJECT + ") {");
		sc.add(E_OBJECT + " e = (" + E_OBJECT + ") o;");
		sc.add("String uri = getURI(e);");
		sc.add("return uri;");
		sc.add("}");
		sc.add("if (o instanceof String) {");
		sc.add("return (String) o;");
		sc.add("}");
		sc.add("if (o instanceof " + RESOURCE + ") {");
		sc.add("return ((" + RESOURCE + ") o).getURI().toString();");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private String getURI(" + E_OBJECT + " eObject) {");
		sc.add(LIST + "<String> uriFragmentPath = getFragmentPath(eObject);");
		sc.add("String uriFragment = " + stringUtilClassName + ".explode(uriFragmentPath, \"/\");");
		sc.add("return uriFragment;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private " + LIST + "<String> getFragmentPath(" + E_OBJECT + " eObject) {");
		sc.add(INTERNAL_E_OBJECT + " internalEObject = (" + INTERNAL_E_OBJECT + ") eObject;");
		sc.add(sc.declareArrayList("uriFragmentPath", "String"));
		sc.add("for (" + INTERNAL_E_OBJECT + " container = internalEObject.eInternalContainer(); container != null; container = internalEObject.eInternalContainer()) {");
		sc.add("uriFragmentPath.add(0, container.eURIFragmentSegment(internalEObject.eContainingFeature(), internalEObject));");
		sc.add("internalEObject = container;");
		sc.add("}");
		sc.add("return uriFragmentPath;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("});");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetLinkWithEditorMethod(StringComposite sc) {
		sc.add("public void setLinkWithEditor(boolean on) {");
		sc.add("this.linkWithEditor = on;");
		sc.add("}");
		sc.addLineBreak();
	}
}
