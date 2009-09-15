package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_UI_PLUGIN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BUNDLE_CONTEXT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_DIALOG_CONSTANTS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MESSAGE_DIALOG;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SHELL;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;

public class PluginActivatorGenerator extends BaseGenerator {

	public PluginActivatorGenerator(GenerationContext context) {
		super(context, EArtifact.PLUGIN_ACTIVATOR);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A singleton class for the text resource plug-in.");
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_UI_PLUGIN + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);

		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	private void addMethods(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		addStartMethod(sc);
		addStopMethod(sc);
		addGetDefaultMethod(sc);
		addShowErrorMethod(sc);
	}

	private void addShowErrorMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void showErrorDialog(final String title, final String message) {");
		sc.add(DISPLAY + ".getDefault().asyncExec(new Runnable() {");
		sc.add("public void run() {");
		sc.add(SHELL + " parent = new " + SHELL + "();");
		sc.add(MESSAGE_DIALOG + " dialog = new " + MESSAGE_DIALOG + "(parent, title, null, message, " + MESSAGE_DIALOG + ".ERROR,");
		sc.add("new String[] { " + I_DIALOG_CONSTANTS + ".OK_LABEL }, 0) {");
		sc.add("};");
		sc.add("dialog.open();");
		sc.add("}");
		sc.add("});");
		sc.add("}");
	}

	private void addGetDefaultMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public static " + getResourceClassName() + " getDefault() {");
		sc.add("return plugin;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStopMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void stop(" + BUNDLE_CONTEXT + " context) throws Exception {");
		sc.add("plugin = null;");
		sc.add("super.stop(context);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStartMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void start(" + BUNDLE_CONTEXT + " context) throws Exception {");
		sc.add("super.start(context);");
		sc.add("plugin = this;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("private static " + getResourceClassName() + " plugin;");
		sc.addLineBreak();
	}
}
