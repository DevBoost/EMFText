/*******************************************************************************
 * Copyright (c) 2006-2014
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

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BUNDLE_CONTEXT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ABSTRACT_UI_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_DIALOG_CONSTANTS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.MESSAGE_DIALOG;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SHELL;

import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.ActivatorGeneratorUtil;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

// TODO this is a copy of class PluginActivatorGenerator in codegen.resource!
public class UIPluginActivatorGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc("A singleton class for the text resource UI plug-in.");
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_UI_PLUGIN(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addStartMethod(sc);
		addStopMethod(sc);
		addGetDefaultMethod(sc);
		addShowErrorMethod(sc);
		new ActivatorGeneratorUtil().addLogMethods(sc, getResourceClassName());
	}

	private void addShowErrorMethod(JavaComposite sc) {
		sc.add("public static void showErrorDialog(final String title, final String message) {");
		sc.add(DISPLAY(sc) + ".getDefault().asyncExec(new Runnable() {");
		sc.add("public void run() {");
		sc.add(SHELL(sc) + " parent = new " + SHELL(sc) + "();");
		sc.add(MESSAGE_DIALOG(sc) + " dialog = new " + MESSAGE_DIALOG(sc) + "(parent, title, null, message, " + MESSAGE_DIALOG(sc) + ".ERROR, new String[] { " + I_DIALOG_CONSTANTS(sc) + ".OK_LABEL }, 0) {");
		sc.add("};");
		sc.add("dialog.open();");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDefaultMethod(StringComposite sc) {
		sc.add("public static " + getResourceClassName() + " getDefault() {");
		sc.add("return plugin;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStopMethod(JavaComposite sc) {
		sc.add("public void stop(" + BUNDLE_CONTEXT(sc) + " context) throws Exception {");
		sc.add("plugin = null;");
		sc.add("super.stop(context);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStartMethod(JavaComposite sc) {
		sc.add("public void start(" + BUNDLE_CONTEXT(sc) + " context) throws Exception {");
		sc.add("super.start(context);");
		sc.add("plugin = this;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		GenerationContext context = getContext();
		String resourceUIPluginName = context.getResourceUIPlugin().getName();
		String editorClassName = context.getQualifiedClassName(TextResourceUIArtifacts.EDITOR);

		sc.add("public static final String PLUGIN_ID = \"" + resourceUIPluginName + "\";");
		sc.add("public static final String EDITOR_ID = \"" + editorClassName + "\";");
		sc.add("public static final String EMFTEXT_SDK_VERSION = \"" + EMFTextSDKPlugin.VERSION + "\";");
		sc.add("public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + \".default_load_options\";");
		sc.add("public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + \".additional_extension_parser\";");
		sc.addLineBreak();
		sc.add("private static " + getResourceClassName() + " plugin;");
		sc.addLineBreak();
	}
}
