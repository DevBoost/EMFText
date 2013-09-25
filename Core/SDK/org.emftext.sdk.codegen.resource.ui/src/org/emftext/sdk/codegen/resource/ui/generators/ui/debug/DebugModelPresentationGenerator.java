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
package org.emftext.sdk.codegen.resource.ui.generators.ui.debug;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_VALUE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FILE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DEBUG_MODEL_PRESENTATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_LABEL_PROVIDER_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_LINE_BREAKPOINT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_VALUE_DETAIL_LISTENER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

public class DebugModelPresentationGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_DEBUG_MODEL_PRESENTATION + " {");
		sc.addLineBreak();
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addAddListenerMethod(sc);
		addDisposeMethod(sc);
		addIsLabelProperty(sc);
		addRemoveListener(sc);
		addGetEditorInputMethod(sc);
		addGetEditorIDMethod(sc);
		addSetAttributeMethod(sc);
		addGetImageMethod(sc);
		addGetTextMethod(sc);
		addComputeDetailMethod(sc);
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddListenerMethod(JavaComposite sc) {
		sc.add("public void addListener(" + I_LABEL_PROVIDER_LISTENER + " listener) {");
		sc.add("// do nothing");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDisposeMethod(JavaComposite sc) {
		sc.add("public void dispose() {");
		sc.add("// do nothing");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsLabelProperty(JavaComposite sc) {
		sc.add("public boolean isLabelProperty(Object element, String property) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemoveListener(JavaComposite sc) {
		sc.add("public void removeListener(" + I_LABEL_PROVIDER_LISTENER + " listener) {");
		sc.add("// do nothing");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEditorInputMethod(JavaComposite sc) {
		sc.add("public " + I_EDITOR_INPUT + " getEditorInput(Object element) {");
		sc.add("if (element instanceof " + I_FILE + ") {");
		sc.add("return new " + FILE_EDITOR_INPUT + "((" + I_FILE + ") element);");
		sc.add("} else if (element instanceof " + I_LINE_BREAKPOINT + ") {");
		sc.add("return new " + FILE_EDITOR_INPUT + "((" + I_FILE + ") ((" + I_LINE_BREAKPOINT + ") element).getMarker().getResource());");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetEditorIDMethod(JavaComposite sc) {
		sc.add("public String getEditorId(" + I_EDITOR_INPUT + " input, Object element) {");
		sc.add("if (element instanceof " + I_FILE + " || element instanceof " + I_LINE_BREAKPOINT + ") {");
		sc.add("return " + uiPluginActivatorClassName + ".EDITOR_ID;");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetAttributeMethod(JavaComposite sc) {
		sc.add("public void setAttribute(String attribute, Object value) {");
		sc.add("// not supported");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetImageMethod(JavaComposite sc) {
		sc.add("public " + IMAGE + " getImage(Object element) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTextMethod(JavaComposite sc) {
		sc.add("public String getText(Object element) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addComputeDetailMethod(JavaComposite sc) {
		sc.add("public void computeDetail(" + I_VALUE + " value, " + I_VALUE_DETAIL_LISTENER + " listener) {");
		sc.addComment("listener.detailComputed(value, \"detail\");");
		sc.add("}");
		sc.addLineBreak();
	}
}
