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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ACTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BUSY_INDICATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE_DESCRIPTOR;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class AbstractOutlinePageActionGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public abstract class " + getResourceClassName() + " extends " + ACTION + " {");
		sc.addLineBreak();
		sc.add("private String preferenceKey = this.getClass().getSimpleName() + \".isChecked\";");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + outlinePageTreeViewerClassName + " treeViewer;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + outlinePageTreeViewerClassName + " treeViewer, String text, int style) {");
		sc.add("super(text, style);");
		sc.add("this.treeViewer = treeViewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addInitializeMethod(sc);
		addRunMethod(sc);
		addRunBusyMethod(sc);
		addRunInternalMethod(sc);
		addValueChangeMethod(sc);
		addKeepStateMethod(sc);
		addGetTreeViewerMethod(sc);
		addGetTreeViewerComparatorMethod(sc);
	}

	private void addGetTreeViewerMethod(JavaComposite sc) {
		sc.add("public " + outlinePageTreeViewerClassName + " getTreeViewer() {");
		sc.add("return treeViewer;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTreeViewerComparatorMethod(JavaComposite sc) {
		sc.add("public " + outlinePageTreeViewerComparatorClassName + " getTreeViewerComparator() {");
		sc.add("return (" + outlinePageTreeViewerComparatorClassName+ ") treeViewer.getComparator();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeMethod(JavaComposite sc) {
		sc.add("public void initialize(String imagePath) {");
		sc.add(IMAGE_DESCRIPTOR + " descriptor = " + imageProviderClassName + ".INSTANCE.getImageDescriptor(imagePath);");
		sc.add("setDisabledImageDescriptor(descriptor);");
		sc.add("setImageDescriptor(descriptor);");
		sc.add("setHoverImageDescriptor(descriptor);");
		sc.add("boolean checked = " + uiPluginActivatorClassName + ".getDefault().getPreferenceStore().getBoolean(preferenceKey);");
		sc.add("valueChanged(checked, false);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRunMethod(JavaComposite sc) {
		sc.add("@Override");
		sc.add("public void run() {");
		sc.add("if (keepState()) {");
		sc.add("valueChanged(isChecked(), true);");
		sc.add("} else {");
		sc.add("runBusy(true);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRunInternalMethod(JavaComposite sc) {
		sc.add("public abstract void runInternal(boolean on);");
		sc.addLineBreak();
		// TODO
		//sc.add("fOutlineViewer.setComparator(fComparator);");
		//sc.add("fDropSupport.setFeedbackEnabled(false);");
		//sc.add("fOutlineViewer.setComparator(fSourcePositonComparator);");
		//sc.add("fDropSupport.setFeedbackEnabled(true);");
	}

	private void addRunBusyMethod(JavaComposite sc) {
		sc.add("public void runBusy(final boolean on) {");
		sc.add(BUSY_INDICATOR + ".showWhile(" + DISPLAY + ".getCurrent(), new Runnable() {");
		sc.add("public void run() {");
		sc.add("runInternal(on);");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addKeepStateMethod(JavaComposite sc) {
		sc.add("public boolean keepState() {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addValueChangeMethod(JavaComposite sc) {
		sc.add("private void valueChanged(boolean on, boolean store) {");
		sc.add("setChecked(on);");
		sc.add("runBusy(on);");
		sc.add("if (store) {");
		sc.add(uiPluginActivatorClassName + ".getDefault().getPreferenceStore().setValue(preferenceKey, on);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
