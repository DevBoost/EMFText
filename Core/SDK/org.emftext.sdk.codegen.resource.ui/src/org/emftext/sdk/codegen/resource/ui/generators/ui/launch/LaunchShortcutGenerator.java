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
package org.emftext.sdk.codegen.resource.ui.generators.ui.launch;

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_LAUNCH_MANAGER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DEBUG_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.DEBUG_UI_TOOLS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_EDITOR_PART;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_FILE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_LAUNCH_CONFIGURATION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_LAUNCH_CONFIGURATION_TYPE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_LAUNCH_CONFIGURATION_WORKING_COPY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_LAUNCH_SHORTCUT2;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.URI;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

public class LaunchShortcutGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
			"A class that converts the current selection or active editor to a launch configuration" +
			(getContext().isLaunchSupportEnabled() ? "." : " (currently disabled)."),
			"Set the " + OptionTypes.OVERRIDE_LAUNCH_SHORTCUT.getLiteral() + " option to false to " +
			"customize this class."
		);
		sc.add("public class " + getResourceClassName());
		if (getContext().isLaunchSupportEnabled()) {
			sc.add(" implements " + I_LAUNCH_SHORTCUT2(sc));
		}
		sc.add(" {");
		sc.addLineBreak();
		if (getContext().isLaunchSupportEnabled()) {
			addMethods(sc);
		}
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addLaunchMethod1(sc);
		addLaunchMethod2(sc);
		addLaunchMethod3(sc);
		addGetLaunchConfigurationsMethod1(sc);
		addGetLaunchConfigurationsMethod2(sc);
		addGetLaunchableResourceMethod1(sc);
		addGetLaunchableResourceMethod2(sc);
	}

	private void addLaunchMethod1(JavaComposite sc) {
		sc.add("public void launch(" + I_SELECTION(sc) + " selection, String mode) {");
		sc.add("if (selection instanceof " + I_STRUCTURED_SELECTION(sc) + ") {");
		sc.add(I_STRUCTURED_SELECTION(sc) + " structuredSelection = (" + I_STRUCTURED_SELECTION(sc) + ") selection;");
		sc.add(ITERATOR(sc) + "<?> it = structuredSelection.iterator();");
		sc.add("while (it.hasNext()) {");
		sc.add("Object object = it.next();");
		sc.add("if (object instanceof " + I_FILE(sc) + ") {");
		sc.add(I_FILE(sc) + " file = (" + I_FILE(sc) + ") object;");
		sc.add("launch(file, mode);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLaunchMethod2(JavaComposite sc) {
		sc.add("public void launch(" + I_EDITOR_PART(sc) + " editorPart, String mode) {");
		sc.add(I_EDITOR_INPUT(sc) + " editorInput = editorPart.getEditorInput();");
		sc.add("if (editorInput instanceof " + I_FILE_EDITOR_INPUT(sc) + ") {");
		sc.add(I_FILE_EDITOR_INPUT(sc) + " fileInput = (" + I_FILE_EDITOR_INPUT(sc) + ") editorInput;");
		sc.add("launch(fileInput.getFile(), mode);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addLaunchMethod3(JavaComposite sc) {
		sc.add("private void launch(" + I_FILE(sc) + " file, String mode) {");
		sc.add("try {");
		sc.add(I_LAUNCH_MANAGER(sc) + " lm = " + DEBUG_PLUGIN(sc) + ".getDefault().getLaunchManager();");
		sc.add(I_LAUNCH_CONFIGURATION_TYPE(sc) + " type = lm.getLaunchConfigurationType(new " + metaInformationClassName + "().getLaunchConfigurationType());");
		sc.add(I_LAUNCH_CONFIGURATION_WORKING_COPY(sc) + " workingCopy = type.newInstance(null, file.getName());");
		sc.add(URI(sc) + " uri = " + URI(sc) + ".createPlatformResourceURI(file.getFullPath().toString(), true);");
		sc.add("workingCopy.setAttribute(" + launchConfigurationDelegateClassName + ".ATTR_RESOURCE_URI, uri.toString());");
		sc.add(I_LAUNCH_CONFIGURATION(sc) + " configuration = workingCopy.doSave();");
		sc.add(DEBUG_UI_TOOLS(sc) + ".launch(configuration, mode);");
		sc.add("} catch (" + CORE_EXCEPTION(sc) + " e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Exception while launching selection\", e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLaunchConfigurationsMethod1(JavaComposite sc) {
		sc.add("public " + I_LAUNCH_CONFIGURATION(sc) + "[] getLaunchConfigurations(" + I_SELECTION(sc) + " selection) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLaunchConfigurationsMethod2(JavaComposite sc) {
		sc.add("public " + I_LAUNCH_CONFIGURATION(sc) + "[] getLaunchConfigurations(" + I_EDITOR_PART(sc) + " editorPart) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLaunchableResourceMethod1(JavaComposite sc) {
		sc.add("public " + I_RESOURCE(sc) + " getLaunchableResource(" + I_SELECTION(sc) + " selection) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLaunchableResourceMethod2(JavaComposite sc) {
		sc.add("public " + I_RESOURCE(sc) + " getLaunchableResource(" + I_EDITOR_PART(sc) + " editorPart) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}
}
