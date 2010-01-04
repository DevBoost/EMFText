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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_CHANGED_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TREE_VIEWER;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class OutlinePageTreeViewerGenerator extends JavaBaseGenerator {

	public OutlinePageTreeViewerGenerator() {
		super();
	}

	private OutlinePageTreeViewerGenerator(GenerationContext context) {
		super(context, EArtifact.OUTLINE_PAGE_TREE_VIEWER);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// This custom implementation of a TreeViewer expands the tree");
		sc.add("// automatically up to a specified depth.");
		sc.add("public class " + getResourceClassName() + " extends " + TREE_VIEWER + " {");
		sc.addLineBreak();
		
		sc.add("boolean suppressNotifications = false;");
		sc.addLineBreak();
		
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
		return true;
	}

	private void addMethods(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		addSetSelectionMethod(sc);
		addHandleInvalidSelectionMethod(sc);
		addRefreshMethod1(sc);
		addRefreshMethod2(sc);
		addRefreshMethod3(sc);
		addRefreshMethod4(sc);
		addFireSelectionChangedMethod(sc);
	}

	private void addRefreshMethod4(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void refresh(boolean updateLabels) {");
		sc.add("super.refresh(updateLabels);");
		sc.add("expandToLevel(getAutoExpandLevel());");
		sc.add("}");
	}

	private void addRefreshMethod3(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void refresh() {");
		sc.add("super.refresh();");
		sc.add("expandToLevel(getAutoExpandLevel());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRefreshMethod2(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void refresh(Object element) {");
		sc.add("super.refresh(element);");
		sc.add("expandToLevel(getAutoExpandLevel());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRefreshMethod1(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void refresh(Object element, boolean updateLabels) {");
		sc.add("super.refresh(element, updateLabels);");
		sc.add("expandToLevel(getAutoExpandLevel());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetSelectionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void setSelection(" + I_SELECTION + " selection, boolean reveal) {");
		sc.add("if (selection instanceof " + getContext().getQualifiedClassName(EArtifact.E_OBJECT_SELECTION) + ") {");
		sc.add("suppressNotifications = true;");
		sc.add("super.setSelection(selection, reveal);");
		sc.add("suppressNotifications = false;");
		sc.add("}");
		sc.add("}");
		sc.
		addLineBreak();
	}
	
	private void addHandleInvalidSelectionMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("protected void handleInvalidSelection(" + I_SELECTION + " selection, " + I_SELECTION + " newSelection) {");
		sc.add("//this may not fire a selection changed event to avoid cyclic events between editor and outline");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addFireSelectionChangedMethod(StringComposite sc) {
		sc.add("protected void fireSelectionChanged(" + SELECTION_CHANGED_EVENT + " event) {");
		sc.add("if (suppressNotifications == true) return;");
		sc.add("super.fireSelectionChanged(event);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + COMPOSITE + " parent, int style) {");
		sc.add("super(parent, style);");
		sc.add("}");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new OutlinePageTreeViewerGenerator(context);
	}
}
