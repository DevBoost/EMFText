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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.DEFAULT_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_INFORMATION_PRESENTER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_QUICK_ASSIST_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_QUICK_ASSIST_INVOCATION_CONTEXT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.QUICK_ASSIST_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SHELL;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class QuickAssistAssistantGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + QUICK_ASSIST_ASSISTANT + " implements " + I_QUICK_ASSIST_ASSISTANT + " {");
		sc.addLineBreak();
		addConstructor(sc);
		addCanAssistMethod(sc);
		addCanFixMethod(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + editorClassName  + " editor) {");
		sc.add("setQuickAssistProcessor(new " + quickAssistProcessorClassName + "(editor));");
		sc.add("setInformationControlCreator(new " + ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR + "() {");
		sc.add("public " + I_INFORMATION_CONTROL + " doCreateInformationControl(" + SHELL + " parent) {");
		sc.add("return new " + DEFAULT_INFORMATION_CONTROL + "(parent, (" + I_INFORMATION_PRESENTER + ") null);");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanAssistMethod(JavaComposite sc) {
		sc.add("public boolean canAssist(" + I_QUICK_ASSIST_INVOCATION_CONTEXT + " invocationContext) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanFixMethod(JavaComposite sc) {
		sc.add("public boolean canFix(" + ANNOTATION + " annotation) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}
}
