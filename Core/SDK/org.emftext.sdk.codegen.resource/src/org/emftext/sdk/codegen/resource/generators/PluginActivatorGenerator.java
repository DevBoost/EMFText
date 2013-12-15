/*******************************************************************************
 * Copyright (c) 2006-2013
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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.BUNDLE_CONTEXT;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.PLUGIN;

import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.ActivatorGeneratorUtil;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

@SyntaxDependent
public class PluginActivatorGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);

		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc("A singleton class for the text resource plug-in.");
		String extendsClause = removeEclipseDependentCode ? "" : " extends " + PLUGIN(sc);
		sc.add("public class " + getResourceClassName() + extendsClause + " {");
		sc.addLineBreak();

		if (!removeEclipseDependentCode) {
	addFields(sc);
	addConstructor(sc);
	addMethods(sc);
		} else {
			sc.addComment("This class is empty because option '" + OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE.getLiteral() + "' is set to true.");
		}

		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addStartMethod(sc);
		addStopMethod(sc);
		addGetDefaultMethod(sc);
		new ActivatorGeneratorUtil().addLogMethods(sc, getResourceClassName());
	}

	private void addGetDefaultMethod(StringComposite sc) {
		sc.add("public static " + getResourceClassName() + " getDefault() {");
		sc.add("return plugin;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStopMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void stop(" + BUNDLE_CONTEXT(sc) + " context) throws Exception {");
		sc.add("plugin = null;");
		sc.add("super.stop(context);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addStartMethod(de.devboost.codecomposers.java.JavaComposite sc) {
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

	private void addFields(JavaComposite sc) {
		IPluginDescriptor resourcePlugin = getContext().getResourcePlugin();
		String resourcePluginName = resourcePlugin.getName();

		sc.add("public static final String PLUGIN_ID = \"" + resourcePluginName + "\";");
		sc.addJavadoc(
			"The version of EMFText that was used to generate this plug-in."
		);
		sc.add("public static final String EMFTEXT_SDK_VERSION = \"" + EMFTextSDKPlugin.VERSION + "\";");
		sc.addJavadoc(
			"The ID of the extension point to register default options to be used when loading " +
			"resources with this plug-in."
		);
		sc.add("public static final String EP_DEFAULT_LOAD_OPTIONS_ID = PLUGIN_ID + \".default_load_options\";");
		sc.add("public static final String EP_ADDITIONAL_EXTENSION_PARSER_ID = PLUGIN_ID + \".additional_extension_parser\";");
		sc.add("public static final String DEBUG_MODEL_ID = PLUGIN_ID + \".debugModel\";");
		sc.addLineBreak();
		sc.add("private static " + getResourceClassName() + " plugin;");
		sc.addLineBreak();
	}
}
