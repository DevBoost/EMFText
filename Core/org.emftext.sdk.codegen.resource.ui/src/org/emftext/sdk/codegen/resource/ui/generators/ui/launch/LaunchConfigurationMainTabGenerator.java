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
package org.emftext.sdk.codegen.resource.ui.generators.ui.launch;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ABSTRACT_LAUNCH_CONFIGURATION_TAB;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BUTTON;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ELEMENT_TREE_SELECTION_DIALOG;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FILE_DIALOG;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.GROUP;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_LAUNCH_CONFIGURATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_LAUNCH_CONFIGURATION_WORKING_COPY;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_SELECTION_STATUS_VALIDATOR;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LABEL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MODIFY_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MODIFY_LISTENER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_ADAPTER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STATUS;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TEXT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.URI;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.VIEWER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.VIEWER_FILTER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.WINDOW;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.WORKBENCH_CONTENT_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.WORKBENCH_LABEL_PROVIDER;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class LaunchConfigurationMainTabGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A class that provides the main tab to parameterize launch configurations" +
			(getContext().isLaunchSupportEnabled() ? "." : " (currently disabled)."),
			"Set the " + OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_MAIN_TAB.getLiteral() + " option to false to " +
			"customize this class."
		);
		sc.add("public class " + getResourceClassName());
		if (getContext().isLaunchSupportEnabled()) {
			sc.add(" extends " + ABSTRACT_LAUNCH_CONFIGURATION_TAB);
		}
		sc.add(" {");
		sc.addLineBreak();
		
		if (getContext().isLaunchSupportEnabled()) {
			addFields(sc);
			addMethods(sc);
		}
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + LABEL + " uriLabel;");
		sc.add("private " + TEXT + " uriText;");
		sc.add("private " + BUTTON + " workspaceButton;");
		sc.add("private " + BUTTON + " fileSystemButton;");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addCreateControlMethod(sc);
		addSetDefaultsMethod(sc);
		addInitializeFromMethod(sc);
		addPerformApplyMethod(sc);
		addGetNameMethod(sc);
		addGetImageMethod(sc);
		addHandleBrowseFileSystemMethod(sc);
		addHandleBrowseWorkspaceMethod(sc);
	}

	private void addHandleBrowseFileSystemMethod(JavaComposite sc) {
		sc.add("protected void handleBrowseFileSystem() {");
		sc.add(FILE_DIALOG + " dialog = new " + FILE_DIALOG + "(getControl().getShell());");
		//sc.add("dialog.setFilterPath(getLocation());");
		sc.add("dialog.setText(\"Select resource to launch\");");
		sc.add("String result = dialog.open();");
		sc.add("if (result != null) {");
		sc.add("uriText.setText(" + URI + ".createFileURI(result).toString());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleBrowseWorkspaceMethod(JavaComposite sc) {
		sc.add("protected void handleBrowseWorkspace() {");
		sc.add(ELEMENT_TREE_SELECTION_DIALOG + " dialog = new " + ELEMENT_TREE_SELECTION_DIALOG + "(getControl().getShell(), new " + WORKBENCH_LABEL_PROVIDER + "(), new " + WORKBENCH_CONTENT_PROVIDER + "());");
		sc.addLineBreak();
		sc.add("dialog.setInput(" + RESOURCES_PLUGIN + ".getWorkspace().getRoot());");
		sc.add("dialog.addFilter(new " + VIEWER_FILTER + "() {");
		sc.addLineBreak();
		sc.add("@Override").addLineBreak();
		sc.add("public boolean select(" + VIEWER +" viewer, Object parentElement, Object element) {");
		sc.add("if (element instanceof " + I_FILE + ") {");
		sc.add(I_FILE + " file = (" + I_FILE + ") element;");
		sc.add("return file.getFileExtension().equals(new " + metaInformationClassName + "().getSyntaxName());");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("});");
		sc.add("dialog.setAllowMultiple(false);");
		sc.add("dialog.setTitle(\"Select model to launch\");");
		sc.add("dialog.setMessage(\"Resource to launch\");");
		sc.add("dialog.setValidator(new " + I_SELECTION_STATUS_VALIDATOR + "() {");
		sc.add("public " + I_STATUS + " validate(Object[] selection) {");
		sc.add("if (selection.length > 0 && selection[0] instanceof " + I_FILE + ")");
		sc.add("return new " + STATUS + "(" + I_STATUS + ".OK, " + uiPluginActivatorClassName + ".PLUGIN_ID, " + I_STATUS + ".OK, \"\", null);");
		sc.addLineBreak();
		sc.add("return new " + STATUS + "(" + I_STATUS + ".ERROR, " + uiPluginActivatorClassName + ".PLUGIN_ID, " + I_STATUS + ".ERROR, \"\", null);");
		sc.add("}");
		sc.add("});");
		sc.add("if (dialog.open() == " + WINDOW + ".OK) {");
		sc.add(I_FILE + " file = (" + I_FILE + ") dialog.getFirstResult();");
		sc.add("uriText.setText(" + URI + ".createPlatformResourceURI(file.getFullPath().makeRelative().toString(), true).toString());");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetImageMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public " + IMAGE + " getImage() {");
		sc.add("return " + imageProviderClassName + ".INSTANCE.getImage(\"" + UIConstants.DEFAULT_ICON_DIR + "/" + UIConstants.Icon.DEFAULT_LAUNCH_TAB_MAIN_ICON.getFilename() + "\");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateControlMethod(JavaComposite sc) {
		sc.add("public void createControl(" + COMPOSITE + " parent) {");
		sc.add(COMPOSITE + " comp = new " + COMPOSITE + "(parent, " + SWT + ".NONE);");
		sc.add(GRID_LAYOUT + " layout = new " + GRID_LAYOUT + "(1, true);");
		sc.add("comp.setLayout(layout);");
		sc.addLineBreak();
		sc.add(GRID_DATA + " gd = new " + GRID_DATA + "(" + GRID_DATA + ".FILL_BOTH);");
		sc.add("gd.grabExcessHorizontalSpace = true;");
		sc.add("gd.horizontalAlignment = " + SWT + ".FILL;");
		sc.add("comp.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add(GROUP + " group = new " + GROUP + "(comp, " + SWT + ".NONE);");
		sc.add("group.setText(\"Launch parameters\");");
		sc.add("group.setLayout(new " + GRID_LAYOUT + "(3, false));");
		sc.add("gd = new " + GRID_DATA + "();");
		sc.add("gd.grabExcessHorizontalSpace = true;");
		sc.add("gd.horizontalAlignment = " + SWT + ".FILL;");
		sc.add("group.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("uriLabel = new " + LABEL + "(group, " + SWT + ".NONE);");
		sc.add("uriLabel.setText(\"Resource to execute:\");");
		sc.add("gd = new " + GRID_DATA + "();");
		sc.add("uriLabel.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("uriText = new " + TEXT + "(group, " + SWT + ".SINGLE | " + SWT + ".BORDER);");
		sc.add("uriText.setLayoutData(new " + GRID_DATA + "(" + GRID_DATA + ".FILL_HORIZONTAL));");
		sc.add("uriText.addModifyListener(new " + MODIFY_LISTENER + "() {");
		sc.add("public void modifyText(" + MODIFY_EVENT + " evt) {");
		//sc.add("validatePage();");
		sc.add("updateLaunchConfigurationDialog();");
		sc.add("}");
		sc.add("});");
		sc.add("gd = new " + GRID_DATA + "();");
		sc.add("gd.grabExcessHorizontalSpace = true;");
		sc.add("gd.horizontalAlignment = " + SWT + ".FILL;");
		sc.add("gd.horizontalSpan = 2;");
		sc.add("uriText.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("workspaceButton = new " + BUTTON + "(group, " + SWT + ".PUSH);");
		sc.add("workspaceButton.setText(\"Workspace...\");");
		sc.add("workspaceButton.addSelectionListener(new " + SELECTION_ADAPTER + "() {");
		sc.add("public void widgetSelected(" + SELECTION_EVENT + " event) {");
		sc.add("handleBrowseWorkspace();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("});");
		sc.add("gd = new " + GRID_DATA + "();");
		sc.add("gd.grabExcessHorizontalSpace = true;");
		sc.add("gd.horizontalAlignment = " + SWT + ".RIGHT;");
		sc.add("gd.horizontalSpan = 2;");
		sc.add("workspaceButton.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("fileSystemButton = new " + BUTTON + "(group, " + SWT + ".PUSH);");
		sc.add("fileSystemButton.setText(\"File System...\");");
		sc.add("fileSystemButton.addSelectionListener(new " + SELECTION_ADAPTER + "() {");
		sc.add("public void widgetSelected(" + SELECTION_EVENT + " event) {");
		sc.add("handleBrowseFileSystem();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("});");
		sc.add("gd = new " + GRID_DATA + "();");
		sc.add("gd.horizontalAlignment = " + SWT + ".RIGHT;");
		sc.add("fileSystemButton.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("setControl(comp);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetDefaultsMethod(JavaComposite sc) {
		sc.add("public void setDefaults(" + I_LAUNCH_CONFIGURATION_WORKING_COPY + " configuration) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeFromMethod(JavaComposite sc) {
		sc.add("public void initializeFrom(" + I_LAUNCH_CONFIGURATION + " configuration) {");
		sc.add("try {");
		sc.add("uriText.setText(configuration.getAttribute(" + launchConfigurationDelegateClassName + ".ATTR_RESOURCE_URI, \"\"));");
		sc.addComment("more initialization code can be added here");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add(pluginActivatorClassName + ".logError(\"Can't initialize launch configuration tab.\", e);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformApplyMethod(JavaComposite sc) {
		sc.add("public void performApply(" + I_LAUNCH_CONFIGURATION_WORKING_COPY + " configuration) {");
		sc.add("configuration.setAttribute(" + launchConfigurationDelegateClassName + ".ATTR_RESOURCE_URI, uriText.getText());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNameMethod(JavaComposite sc) {
		sc.add("public String getName() {");
		sc.add("return \"Main\";");
		sc.add("}");
		sc.addLineBreak();
	}

}
