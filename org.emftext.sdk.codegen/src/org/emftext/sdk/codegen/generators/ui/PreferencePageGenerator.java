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
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKBENCH_PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINK;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PROGRAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class PreferencePageGenerator extends JavaBaseGenerator {

	private String pluginActivatorClassName;

	public PreferencePageGenerator() {
		super();
	}

	private PreferencePageGenerator(GenerationContext context) {
		super(context, EArtifact.PREFERENCE_PAGE);
		pluginActivatorClassName = getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// The root preference page");
		sc.add("//");
		sc.add("public class " + getResourceClassName() + " extends " + PREFERENCE_PAGE + " implements " + I_WORKBENCH_PREFERENCE_PAGE + " {");
		sc.addLineBreak();
		sc.add("public void init(" + I_WORKBENCH + " workbench) {");
		sc.add("setPreferenceStore(" + pluginActivatorClassName + ".getDefault().getPreferenceStore());");
		sc.add("setDescription(\" " + getContext().getCapitalizedConcreteSyntaxName() + " Text Editor Preferences\");");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("@Override");
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
		sc.add("}");
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new PreferencePageGenerator(context);
	}
}
