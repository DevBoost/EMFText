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

import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.NUMBER_FORMAT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.STATUS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BUTTON;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.GROUP;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PREFERENCE_STORE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH_PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.LABEL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_ADAPTER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.TEXT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class ContentAssistPreferencePageGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc("The preference page for the content assist settings.");
		sc.add("public class " + getResourceClassName() + " extends " + PREFERENCE_PAGE(sc) + " implements " + I_WORKBENCH_PREFERENCE_PAGE(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite jc) {
		jc.add("private " + GROUP(jc) + " grpAuto;");
		jc.add("private " + BUTTON(jc) + " btnActivate;");
		jc.add("private " + LABEL(jc) + " lblAutoActivationDelay;");
		jc.add("private " + TEXT(jc) + " txtDelay;");
		jc.add("private " + LABEL(jc) + " lblAutoActivationTriggers;");
		jc.add("private " + TEXT(jc) + " txtTriggers;");
		jc.addLineBreak();
		jc.addComment("preference values");
		jc.add("private boolean assistEnabled;");
		jc.add("private int activationDelay;");
		jc.add("private String activationTriggers = \"\";");
		jc.addLineBreak();
	}

	private void addConstructor(JavaComposite jc) {
		jc.add("public " + getResourceClassName() + "() {");
		jc.add("initialize();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addMethods(JavaComposite jc) {
		addInitializeMethod(jc);
		addInitMethod(jc);
		addCreateContentsMethod(jc);
		addPerformDefaultsMethod(jc);
		addPerformOkMethod(jc);
		addPerformApplyMethod(jc);
		addUpdatePreferencesMethod(jc);
		addUpdateAutoActivationWidgetsMethod(jc);
	}

	private void addUpdateAutoActivationWidgetsMethod(JavaComposite jc) {
		jc.add("private void updateAutoActivationWidgets() {");
		jc.add("boolean enabled = btnActivate.getSelection();");
		jc.add("lblAutoActivationDelay.setEnabled(enabled);");
		jc.add("lblAutoActivationTriggers.setEnabled(enabled);");
		jc.add("txtDelay.setEnabled(enabled);");
		jc.add("txtTriggers.setEnabled(enabled);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addUpdatePreferencesMethod(JavaComposite jc) {
		jc.add("private boolean updatePreferences() {");
		jc.add("assistEnabled = btnActivate.getSelection();");
		jc.add("String delayText = txtDelay.getText();");
		jc.add("try {");
		jc.add("if(delayText != null && delayText.length() > 0){");
		jc.add("activationDelay = " + INTEGER(jc) + ".parseInt(delayText);");
		jc.add("}");
		jc.add("} catch (" + NUMBER_FORMAT_EXCEPTION(jc) + " exception) {");
		jc.add(pluginActivatorClassName + ".getDefault().getLog().log(");
		jc.add("new " + STATUS(jc) + "(" + I_STATUS(jc) + ".ERROR");
		jc.add(", " + uiPluginActivatorClassName + ".getDefault().getBundle().getSymbolicName()");
		jc.add(", \"Value '\" + delayText + \"' is no valid delay value\"");
		jc.add(", exception)");
		jc.add(");");
		jc.add("return false;");
		jc.add("}");
		jc.add("activationTriggers = txtTriggers.getText();");
		jc.add(I_PREFERENCE_STORE(jc) + " preferenceStore = getPreferenceStore();");
		jc.add("preferenceStore.setValue(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_ENABLED, assistEnabled);");
		jc.add("preferenceStore.setValue(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_DELAY, activationDelay);");
		jc.add("preferenceStore.setValue(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_TRIGGERS, activationTriggers);");
		jc.add("return true;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addPerformApplyMethod(JavaComposite jc) {
		jc.add("protected void performApply() {");
		jc.add("updatePreferences();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addPerformOkMethod(JavaComposite jc) {
		jc.add("public boolean performOk() {");
		jc.add("if (!super.performOk()) {");
		jc.add("return false;");
		jc.add("}");
		jc.add("return updatePreferences();");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addPerformDefaultsMethod(JavaComposite jc) {
		jc.add("protected void performDefaults() {");
		jc.add(I_PREFERENCE_STORE(jc) + " preferenceStore = getPreferenceStore();");
		jc.add("assistEnabled = preferenceStore.getDefaultBoolean(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_ENABLED);");
		jc.add("activationDelay = preferenceStore.getDefaultInt(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_DELAY);");
		jc.add("activationTriggers = preferenceStore.getDefaultString(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_TRIGGERS);");
		jc.addComment("defaults in widgets");
		jc.add("btnActivate.setEnabled(assistEnabled);");
		jc.add("btnActivate.setSelection(assistEnabled);");
		jc.add("txtDelay.setEnabled(assistEnabled);");
		jc.add("txtDelay.setText(String.valueOf(activationDelay));");
		jc.add("txtTriggers.setEnabled(assistEnabled);");
		jc.add("txtTriggers.setText(activationTriggers);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addCreateContentsMethod(JavaComposite jc) {
		jc.add("protected " + CONTROL(jc) + " createContents(" + COMPOSITE(jc) + " parent) {");
		jc.addComment("outer Composite");
		jc.add(COMPOSITE(jc) + " settingComposite = new " + COMPOSITE(jc) + "(parent, " + SWT(jc) + ".NONE);");
		jc.add("settingComposite.setLayout(new " + GRID_LAYOUT(jc) + "(2, false));");
		jc.addLineBreak();
		jc.add("grpAuto = new " + GROUP(jc) + "(settingComposite, " + SWT(jc) + ".SHADOW_NONE);");
		jc.add("grpAuto.setLayoutData(new " + GRID_DATA(jc) + "(" + SWT(jc) + ".FILL, " + SWT(jc) + ".CENTER, true, false, 1, 1));");
		jc.add(GRID_LAYOUT(jc) + " layout = new " + GRID_LAYOUT(jc) + "();");
		jc.add("layout.numColumns = 2;");
		jc.add("grpAuto.setLayout(layout);");
		jc.add("grpAuto.setText(\"Auto Activation\");");
		jc.addLineBreak();
		jc.add("btnActivate = new " + BUTTON(jc) + "(grpAuto, " + SWT(jc) + ".CHECK);");
		jc.add("btnActivate.addSelectionListener(new " + SELECTION_ADAPTER(jc) + "() {");
		jc.add("public void widgetSelected(" + SELECTION_EVENT(jc) + " e) {");
		jc.add("updateAutoActivationWidgets();");
		jc.add("}");
		jc.add("});");
		jc.add("btnActivate.setText(\"Enable auto activation\");");
		jc.add("btnActivate.setSelection(assistEnabled);");
		jc.add("btnActivate.setEnabled(true);");
		jc.add("new " + LABEL(jc) + "(grpAuto, " + SWT(jc) + ".NULL);");
		jc.addLineBreak();
		jc.add("lblAutoActivationDelay = new " + LABEL(jc) + "(grpAuto, " + SWT(jc) + ".NONE);");
		jc.add("lblAutoActivationDelay.setText(\"Auto activation delay (ms):\");");
		jc.addLineBreak();
		jc.add("txtDelay = new " + TEXT(jc) + "(grpAuto, " + SWT(jc) + ".BORDER);");
		jc.add(GRID_DATA(jc) + " gd_txtDelay = new " + GRID_DATA(jc) + "(" + SWT(jc) + ".FILL, " + SWT(jc) + ".CENTER, true, false, 1, 1);");
		jc.add("gd_txtDelay.minimumWidth = 50;");
		jc.add("txtDelay.setLayoutData(gd_txtDelay);");
		jc.add("txtDelay.setText(String.valueOf(activationDelay));");
		jc.addLineBreak();
		jc.add("lblAutoActivationTriggers = new " + LABEL(jc) + "(grpAuto, " + SWT(jc) + ".NONE);");
		jc.add("lblAutoActivationTriggers.setText(\"Auto activation triggers:\");");
		jc.addLineBreak();
		jc.add("txtTriggers = new " + TEXT(jc) + "(grpAuto, " + SWT(jc) + ".BORDER);");
		jc.add("txtTriggers.setLayoutData(new GridData(" + SWT(jc) + ".FILL, " + SWT(jc) + ".CENTER, true, false, 1, 1));");
		jc.add("txtTriggers.setText(activationTriggers);");
		jc.addLineBreak();
		jc.add("updateAutoActivationWidgets();");
		jc.addLineBreak();
		jc.add("return settingComposite;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addInitMethod(JavaComposite jc) {
		jc.add("public void init(" + I_WORKBENCH(jc) + " workbench) {");
		jc.add("setPreferenceStore(" + uiPluginActivatorClassName + ".getDefault().getPreferenceStore());");
		jc.add(I_PREFERENCE_STORE(jc) + " preferenceStore = getPreferenceStore();");
		jc.addComment("init values");
		jc.add("assistEnabled = preferenceStore.getBoolean(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_ENABLED);");
		jc.add("activationDelay = preferenceStore.getInt(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_DELAY);");
		jc.add("activationTriggers = preferenceStore.getString(" + preferenceConstantsClassName + ".EDITOR_CONTENT_ASSIST_TRIGGERS);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addInitializeMethod(JavaComposite jc) {
		jc.add("private void initialize() {");
		jc.add("setDescription(\"Define the behaviour of the content assist\");");
		jc.add("setTitle(\"Content Assist\");");
		jc.add("}");
		jc.addLineBreak();
	}
}
