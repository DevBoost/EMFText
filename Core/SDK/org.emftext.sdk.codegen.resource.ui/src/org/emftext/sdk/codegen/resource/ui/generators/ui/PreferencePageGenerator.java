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

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.LINK;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PROGRAM;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SWT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class PreferencePageGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite jc) {
		
		jc.add("package " + getResourcePackageName() + ";");
		jc.addLineBreak();
		jc.addImportsPlaceholder();
		jc.addLineBreak();
		
		jc.addJavadoc("The root preference page.");
		jc.add("public class " + getResourceClassName() + " extends " + PREFERENCE_PAGE(jc) + " implements " + I_WORKBENCH_PREFERENCE_PAGE(jc) + " {");
		jc.addLineBreak();
		addMethods(jc);
		jc.add("}");
	}

	private void addMethods(JavaComposite jc) {
		addInitMethod(jc);
		addCreateContentsMethod(jc);
	}

	private void addInitMethod(JavaComposite jc) {
		jc.add("public void init(" + I_WORKBENCH(jc) + " workbench) {");
		jc.add("setPreferenceStore(" + uiPluginActivatorClassName + ".getDefault().getPreferenceStore());");
		jc.add("setDescription(" + uiResourceBundleClassName + "." + UIResourceBundleGenerator.ROOT_PREFERENCE_PAGE_DESCRIPTION + ");");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addCreateContentsMethod(JavaComposite jc) {
		jc.add("@Override");
		jc.add("protected " + CONTROL(jc) + " createContents(" + COMPOSITE(jc) + " parent) {");
		jc.add(COMPOSITE(jc) + " settingComposite = new " + COMPOSITE(jc) + "(parent, " + SWT(jc) + ".NONE);");
		jc.add(GRID_LAYOUT(jc) + " layout = new " + GRID_LAYOUT(jc) + "();");
		jc.add(GRID_DATA(jc) + " gd;");
		jc.add("layout.numColumns= 1;");
		jc.add("layout.marginHeight= 0;");
		jc.add("layout.marginWidth= 0;");
		jc.add("gd = new " + GRID_DATA(jc) + "(" + GRID_DATA(jc) + ".BEGINNING);");
        jc.add("settingComposite.setLayout(layout);");
        jc.add("settingComposite.setLayoutData(gd);");
        jc.addLineBreak();
        jc.add(LINK(jc) + " link = new " + LINK(jc) + "(settingComposite, " + SWT(jc) + ".NONE);");
        jc.add("link.setText(" + uiResourceBundleClassName + "." + UIResourceBundleGenerator.ROOT_PREFERENCE_PAGE_TEXT + ");");
        jc.add("link.setSize(140, 40);");
        jc.add("link.addSelectionListener(new " + SELECTION_LISTENER(jc) + "() {");
        jc.add("public void widgetSelected(" + SELECTION_EVENT(jc) + " e) {");
        jc.add("if (e.text.startsWith(\"http\")) " + PROGRAM(jc) + ".launch(e.text);");
        jc.add("}");
        jc.add("public void widgetDefaultSelected(" + SELECTION_EVENT(jc) + " e) {}");
        jc.add("});");
        jc.add("return settingComposite;");
		jc.add("}");
		jc.addLineBreak();
	}
}
