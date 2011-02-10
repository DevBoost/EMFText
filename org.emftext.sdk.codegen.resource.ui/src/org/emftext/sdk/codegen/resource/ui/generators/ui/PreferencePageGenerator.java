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
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_WORKBENCH_PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LINK;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PROGRAM;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SWT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class PreferencePageGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("The root preference page");
		sc.add("public class " + getResourceClassName() + " extends " + PREFERENCE_PAGE + " implements " + I_WORKBENCH_PREFERENCE_PAGE + " {");
		sc.addLineBreak();
		addmethods(sc);
		sc.add("}");
	}

	private void addmethods(JavaComposite sc) {
		addInitMethod(sc);
		addCreateContentsMethod(sc);
	}

	private void addInitMethod(JavaComposite sc) {
		sc.add("public void init(" + I_WORKBENCH + " workbench) {");
		sc.add("setPreferenceStore(" + uiPluginActivatorClassName + ".getDefault().getPreferenceStore());");
		sc.add("setDescription(\" " + getContext().getCapitalizedConcreteSyntaxName() + " Text Editor Preferences\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateContentsMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("protected " + CONTROL + " createContents(" + COMPOSITE + " parent) {");
		sc.add(COMPOSITE + " settingComposite = new " + COMPOSITE + "(parent, " + SWT + ".NONE);");
		sc.add(GRID_LAYOUT + " layout = new " + GRID_LAYOUT + "();");
		sc.add(GRID_DATA + " gd;");
		sc.add("layout.numColumns= 1;");
		sc.add("layout.marginHeight= 0;");
		sc.add("layout.marginWidth= 0;");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING);");
        sc.add("settingComposite.setLayout(layout);");
        sc.add("settingComposite.setLayoutData(gd);");
        sc.add(LINK + " link = new " + LINK + "(settingComposite, " + SWT + ".NONE);");
        sc.add("link.setText(\"Go to <A href=\\\"http://www.emftext.org\\\">www.emftext.org</A> for more information.\");");
        sc.add("link.setSize(140, 40);");
        sc.add("link.addSelectionListener(new " + SELECTION_LISTENER + "() {");
        sc.add("public void widgetSelected(" + SELECTION_EVENT + " e) {");
        sc.add("if (e.text.startsWith(\"http\")) " + PROGRAM + ".launch(e.text);");
        sc.add("}");
        sc.add("public void widgetDefaultSelected(" + SELECTION_EVENT + " e) {}");
        sc.add("});");
        sc.add("return settingComposite;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
