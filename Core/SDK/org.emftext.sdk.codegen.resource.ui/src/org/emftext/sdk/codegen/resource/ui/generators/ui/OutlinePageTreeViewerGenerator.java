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

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.ECORE_UTIL_EQUALITY_HELPER;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.FEATURE_MAP;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.E_REFERENCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ELEMENT_COMPARER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.TREE_VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.VIEWER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.VIEWER_FILTER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class OutlinePageTreeViewerGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"This custom implementation of a TreeViewer expands the tree " +
			"automatically up to a specified depth."
		);
		sc.add("public class " + getResourceClassName() + " extends " + TREE_VIEWER(sc) + " {");
		sc.addLineBreak();
		
		addInnerClassTypeFilter(sc);
		addInnerClassFlatEObjectComparer(sc);
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
	}

	private void addInnerClassFlatEObjectComparer(JavaComposite sc) {
		sc.add("private static class FlatEObjectComparer extends " + ECORE_UTIL_EQUALITY_HELPER(sc) + " {");
		sc.addLineBreak();
		sc.add("private static final long serialVersionUID = 1L;");
		sc.addLineBreak();
		sc.add("@Override");
		sc.add("protected boolean haveEqualReference(" + E_OBJECT(sc) + " eObject1, " + E_OBJECT(sc) + " eObject2, " + E_REFERENCE(sc) + " reference) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("@Override");
		sc.add("protected boolean equalFeatureMaps(" + FEATURE_MAP(sc) + " featureMap1, " + FEATURE_MAP(sc) + " featureMap2) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveTypeToFilterMethod(JavaComposite sc) {
		sc.add("public void removeTypeToFilter(" + E_CLASS(sc) + " typeToNotFilter) {");
		sc.add("typeFilter.getFilteredTypes().remove(typeToNotFilter);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddTypeToFilterMethod(JavaComposite sc) {
		sc.add("public void addTypeToFilter(" + E_CLASS(sc) + " typeToFilter) {");
		sc.add("typeFilter.getFilteredTypes().add(typeToFilter);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInnerClassTypeFilter(JavaComposite sc) {
		sc.add("public class TypeFilter extends " + VIEWER_FILTER(sc) + " {");
		sc.addLineBreak();
		sc.add("private " +  sc.declareLinkedHashSet("filteredTypes",E_CLASS(sc)));
		sc.addLineBreak();
		sc.add("@Override");
		sc.add("public boolean select(" + VIEWER(sc) + " viewer, Object parentElement, Object element) {");
		sc.add("if (element instanceof " + E_OBJECT(sc) + ") {");
		sc.add(E_OBJECT(sc) + " eObject = (" + E_OBJECT(sc) + ") element;");
		sc.add("for (" + E_CLASS(sc) + " filteredType : filteredTypes) {");
		sc.add("if (filteredType.isInstance(eObject)) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + SET(sc) + "<" + E_CLASS(sc) + "> getFilteredTypes() {");
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
		addSetSuppressNotificationsMethod(sc);
	}

	private void addSetSuppressNotificationsMethod(JavaComposite sc) {
		sc.add("public void setSuppressNotifications(boolean suppressNotifications) {");
		sc.add("this.suppressNotifications = suppressNotifications;");
		sc.add("}");
		sc.addLineBreak();
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

	private void addSetSelectionMethod(JavaComposite sc) {
		sc.add("public void setSelection(" + I_SELECTION(sc) + " selection, boolean reveal) {");
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
		sc.add("protected void handleSelect(" + SELECTION_EVENT(sc) + " event) {");
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
		sc.add("protected void handleInvalidSelection(" + I_SELECTION(sc) + " selection, " + I_SELECTION(sc) + " newSelection) {");
		sc.addComment("this may not fire a selection changed event to avoid cyclic events between editor and outline");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addFireSelectionChangedMethod(JavaComposite sc) {
		sc.add("protected void fireSelectionChanged(" + SELECTION_CHANGED_EVENT(sc) + " event) {");
		sc.add("if (suppressNotifications) {");
		sc.add("return;");
		sc.add("}");
		sc.add("super.fireSelectionChanged(event);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + COMPOSITE(sc) + " parent, int style) {");
		sc.add("super(parent, style);");
		sc.add("addFilter(typeFilter);");
		sc.add("setComparer(new " + I_ELEMENT_COMPARER(sc) + "() {");
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
		sc.add("if (o1 instanceof " + E_OBJECT(sc) + " && o2 instanceof " + E_OBJECT(sc) + ") {");
		sc.add("return new FlatEObjectComparer().equals((" + E_OBJECT(sc) + ") o1, (" + E_OBJECT(sc) + ") o2);");
		sc.add("}");
		sc.add("String s1 = toString(o1);");
		sc.add("String s2 = toString(o2);");
		sc.add("if (s1 != null) {");
		sc.add("return s1.equals(s2);");
		sc.add("}");
		sc.add("return o1.equals(o2);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private String toString(Object o) {");
		sc.add("if (o instanceof String) {");
		sc.add("return (String) o;");
		sc.add("}");
		sc.add("if (o instanceof " + RESOURCE(sc) + ") {");
		sc.add("return ((" + RESOURCE(sc) + ") o).getURI().toString();");
		sc.add("}");
		sc.add("return null;");
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
