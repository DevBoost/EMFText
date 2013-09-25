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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_QUICK_FIXABLE_ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MARKER_ANNOTATION;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class MarkerAnnotationGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + MARKER_ANNOTATION + " implements " + I_QUICK_FIXABLE_ANNOTATION + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addSetQuickFixableMethod(sc);
		addIsQuickFixableStateSetMethod(sc);
		addIsQuickFixableMethod(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addComment("private boolean isQuickFixable;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + I_MARKER + " marker) {");
		sc.add("super(marker);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetQuickFixableMethod(JavaComposite sc) {
		sc.add("public void setQuickFixable(boolean state) {");
		sc.addComment("this.isQuickFixable = state;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsQuickFixableStateSetMethod(JavaComposite sc) {
		sc.add("public boolean isQuickFixableStateSet() {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsQuickFixableMethod(JavaComposite sc) {
		sc.add("public boolean isQuickFixable() {");
		sc.add("try {");
		sc.add("return getMarker().getAttribute(" + I_MARKER + ".SOURCE_ID) != null;");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add("// ignore");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
}
