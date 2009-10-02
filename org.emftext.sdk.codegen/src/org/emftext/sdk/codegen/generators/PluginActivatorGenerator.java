package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_UI_PLUGIN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BUNDLE_CONTEXT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.DISPLAY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_DIALOG_CONSTANTS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MESSAGE_DIALOG;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SHELL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STATUS;

import java.io.PrintWriter;

import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;

public class PluginActivatorGenerator extends BaseGenerator {

	public PluginActivatorGenerator() {
		super();
	}

	private PluginActivatorGenerator(GenerationContext context) {
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
		addLogErrorMethod(sc);
	}

	private void addLogErrorMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("// Helper method for error logging.");
		sc.add("//");
		sc.add("// @param message");
		sc.add("//            the error message");
		sc.add("// @param exception");
		sc.add("//            the exception that describes the error in detail");
		sc.add("// @return the status object describing the error");
		sc.add("//");
		sc.add("public static " + I_STATUS + " logError(String message, Throwable exception) {");
		sc.add(I_STATUS + " status;");
		sc.add("if (exception != null) {");
		sc.add("status = new " + STATUS + "(" + I_STATUS + ".ERROR, " + getResourceClassName() + ".PLUGIN_ID, 0, message, exception);");
		sc.add("} else {");
		sc.add("status = new " + STATUS + "(" + I_STATUS + ".ERROR, " + getResourceClassName() + ".PLUGIN_ID, message);");
		sc.add("}");
			
		sc.add("final " + getResourceClassName() + " pluginInstance = " + getResourceClassName() + ".getDefault();");
		sc.add("if (pluginInstance == null) {");
		sc.add("System.err.println(message);");
		sc.add("if (exception != null) {");
		sc.add("exception.printStackTrace();");
		sc.add("}");
		sc.add("} else {");
		sc.add("pluginInstance.getLog().log(status);");
		sc.add("}");
		sc.add("return status;");
		sc.add("}");
	}

	private void addShowErrorMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public static void showErrorDialog(final String title, final String message) {");
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
		String resourcePluginName = EPlugins.RESOURCE_PLUGIN.getName(getContext().getConcreteSyntax());

		sc.add("public static final String PLUGIN_ID = \"" + resourcePluginName + "\";");
		sc.add("public static final String EMFTEXT_SDK_VERSION = \"" + EMFTextSDKPlugin.VERSION + "\";");
		sc.add("public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + \".default_load_options\";");
		sc.add("public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + \".additional_extension_parser\";");
		sc.addLineBreak();
		sc.add("private static " + getResourceClassName() + " plugin;");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new PluginActivatorGenerator(context);
	}

}
