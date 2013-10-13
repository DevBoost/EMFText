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

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc("The root preference page");
		sc.add("public class " + getResourceClassName() + " extends " + PREFERENCE_PAGE(sc) + " implements " + I_WORKBENCH_PREFERENCE_PAGE(sc) + " {");
		sc.addLineBreak();
		addmethods(sc);
		sc.add("}");
	}

	private void addmethods(JavaComposite sc) {
		addInitMethod(sc);
		addCreateContentsMethod(sc);
	}

	private void addInitMethod(JavaComposite sc) {
		sc.add("public void init(" + I_WORKBENCH(sc) + " workbench) {");
		sc.add("setPreferenceStore(" + uiPluginActivatorClassName + ".getDefault().getPreferenceStore());");
		sc.add("setDescription(\"" + getContext().getCapitalizedConcreteSyntaxName() + " Text Editor Preferences\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateContentsMethod(JavaComposite sc) {
		sc.add("@Override");
		sc.add("protected " + CONTROL(sc) + " createContents(" + COMPOSITE(sc) + " parent) {");
		sc.add(COMPOSITE(sc) + " settingComposite = new " + COMPOSITE(sc) + "(parent, " + SWT(sc) + ".NONE);");
		sc.add(GRID_LAYOUT(sc) + " layout = new " + GRID_LAYOUT(sc) + "();");
		sc.add(GRID_DATA(sc) + " gd;");
		sc.add("layout.numColumns= 1;");
		sc.add("layout.marginHeight= 0;");
		sc.add("layout.marginWidth= 0;");
		sc.add("gd = new " + GRID_DATA(sc) + "(" + GRID_DATA(sc) + ".BEGINNING);");
        sc.add("settingComposite.setLayout(layout);");
        sc.add("settingComposite.setLayoutData(gd);");
        sc.add(LINK(sc) + " link = new " + LINK(sc) + "(settingComposite, " + SWT(sc) + ".NONE);");
        sc.add("link.setText(\"Go to <A href=\\\"http://www.emftext.org\\\">www.emftext.org</A> for more information.\");");
        sc.add("link.setSize(140, 40);");
        sc.add("link.addSelectionListener(new " + SELECTION_LISTENER(sc) + "() {");
        sc.add("public void widgetSelected(" + SELECTION_EVENT(sc) + " e) {");
        sc.add("if (e.text.startsWith(\"http\")) " + PROGRAM(sc) + ".launch(e.text);");
        sc.add("}");
        sc.add("public void widgetDefaultSelected(" + SELECTION_EVENT(sc) + " e) {}");
        sc.add("});");
        sc.add("return settingComposite;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
