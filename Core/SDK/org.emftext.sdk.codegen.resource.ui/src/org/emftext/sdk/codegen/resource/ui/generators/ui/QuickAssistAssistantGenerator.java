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

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DEFAULT_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_INFORMATION_CONTROL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_INFORMATION_PRESENTER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_QUICK_ASSIST_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_QUICK_ASSIST_INVOCATION_CONTEXT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.QUICK_ASSIST_ASSISTANT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SHELL;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class QuickAssistAssistantGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + QUICK_ASSIST_ASSISTANT(sc) + " implements " + I_QUICK_ASSIST_ASSISTANT(sc) + " {");
		sc.addLineBreak();
		addConstructor(sc);
		addCanAssistMethod(sc);
		addCanFixMethod(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iResourceProviderClassName + " resourceProvider, " + iAnnotationModelProviderClassName + " annotationModelProvider) {");
		sc.add("setQuickAssistProcessor(new " + quickAssistProcessorClassName + "(resourceProvider, annotationModelProvider));");
		sc.add("setInformationControlCreator(new " + ABSTRACT_REUSABLE_INFORMATION_CONTROL_CREATOR(sc) + "() {");
		sc.add("public " + I_INFORMATION_CONTROL(sc) + " doCreateInformationControl(" + SHELL(sc) + " parent) {");
		sc.add("return new " + DEFAULT_INFORMATION_CONTROL(sc) + "(parent, (" + I_INFORMATION_PRESENTER(sc) + ") null);");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanAssistMethod(JavaComposite sc) {
		sc.add("public boolean canAssist(" + I_QUICK_ASSIST_INVOCATION_CONTEXT(sc) + " invocationContext) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCanFixMethod(JavaComposite sc) {
		sc.add("public boolean canFix(" + ANNOTATION(sc) + " annotation) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}
}
