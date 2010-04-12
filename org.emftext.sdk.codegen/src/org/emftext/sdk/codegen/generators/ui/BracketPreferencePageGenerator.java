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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BUTTON;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLOR_SELECTOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMBO;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMPOSITE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.CONTROL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GRID_DATA;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.GRID_LAYOUT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_EDITOR_PART;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_WORKBENCH_PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LABEL;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PREFERENCE_CONVERTER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PREFERENCE_PAGE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RGB;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_EVENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SELECTION_LISTENER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SET;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.SWT_LIST;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class BracketPreferencePageGenerator extends JavaBaseGenerator {

	public BracketPreferencePageGenerator() {
		super();
	}

	private BracketPreferencePageGenerator(GenerationContext context) {
		super(context, EArtifact.BRACKET_PREFERENCE_PAGE);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"The preference page for the bracket setting with following features:",
			"<ul>",
			"<li>enables bracket matching</li>",
			"<li>chooses matching highlight color</li>",
			"<li>customizes bracket set</li>",
			"</ul>"
		);
		sc.add("public class " + getResourceClassName() + " extends " + PREFERENCE_PAGE + " implements " + I_WORKBENCH_PREFERENCE_PAGE + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addMethods(JavaComposite sc) {
		addInitMethod(sc);
		addCreateContentsMethod(sc);
		addHandleMatchingBracketsSelectionMethod(sc);
		addInitializeLanguageMethod(sc);
		addAddListenersToStyleButtonsMethod(sc);
		addPerformDefaultsMethod(sc);
		addPerformOkMethod(sc);
		addPerformApplyMethod(sc);
		addUpdateActiveEditorMethod(sc);
	}

	private void addUpdateActiveEditorMethod(JavaComposite sc) {
		sc.addJavadoc("Sets the chosen options to the preference store and refreshs it in the editor.");
		sc.add("private void updateActiveEditor() {");
		sc.addComment("set the values after ok or apply");
		sc.add(PREFERENCE_CONVERTER + ".setValue(getPreferenceStore(), BRACKETS_COLOR, matchingBracketsColorEditor.getColorValue());");
		sc.add("getPreferenceStore().setValue(" + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_CHECKBOX, enableCheckbox.getSelection());");
		sc.add("getPreferenceStore().setValue(language + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX, bracketSetTemp.get(language));");
		sc.add(I_WORKBENCH + " workbench = org.eclipse.ui.PlatformUI.getWorkbench();");
		sc.add(I_EDITOR_PART + " editor = workbench.getActiveWorkbenchWindow().getActivePage().getActiveEditor();");
		sc.add("if (editor != null && editor instanceof " + editorClassName + ") {");
		sc.add("((" + editorClassName + ") editor).invalidateTextRepresentation();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformApplyMethod(StringComposite sc) {
		sc.add("protected void performApply() {");
		sc.add("updateActiveEditor();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformOkMethod(StringComposite sc) {
		sc.add("public boolean performOk() {");
		sc.add("if (!super.performOk()) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("updateActiveEditor();");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addPerformDefaultsMethod(JavaComposite sc) {
		sc.addJavadoc("Sets the default values for this preference page.");
		sc.add("protected void performDefaults() {");
		sc.add("enableCheckbox.setSelection(getPreferenceStore().getDefaultBoolean(");
		sc.add(preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_CHECKBOX));");
		sc.add("matchingBracketsColorButton.setEnabled(enableCheckbox.getSelection());");
		sc.add("matchingBracketsColorEditor.setColorValue(" + PREFERENCE_CONVERTER + ".getDefaultColor(getPreferenceStore(), BRACKETS_COLOR));");
		sc.add("bracketSetTemp.put(language, getPreferenceStore().getDefaultString(");
		sc.add("language + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX));");
		sc.add("bracketsTmp.setBrackets(bracketSetTemp.get(language));");
		sc.add("bracketsList.setItems(bracketsTmp.getBracketArray());");
		sc.add("enableClosingInside.setSelection(false);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddListenersToStyleButtonsMethod(StringComposite sc) {
		sc.add("private void addListenersToStyleButtons() {");
		sc.add("enableCheckbox.addSelectionListener(new " + SELECTION_LISTENER + "() {");
		sc.add("public void widgetDefaultSelected(" + SELECTION_EVENT + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void widgetSelected(" + SELECTION_EVENT + " e) {");
		sc.add("matchingBracketsColorButton.setEnabled(enableCheckbox.getSelection());");
		sc.add("}");
		sc.add("});");
		sc.add("addBracketButton.addSelectionListener(new " + SELECTION_LISTENER + "() {");
		sc.addLineBreak();
		sc.add("public void widgetDefaultSelected(" + SELECTION_EVENT + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void widgetSelected(" + SELECTION_EVENT + " e) {");
		sc.add("String open = leftBracketTokensCombo.getText();");
		sc.add("String close = rightBracketTokensCombo.getText();");
		sc.add("if (bracketsTmp.isBracket(open) || bracketsTmp.isBracket(close)) {");
		sc.add("setErrorMessage(\"One or both bracket parts are set!\");");
		sc.add("} else {");
		sc.add("bracketsTmp.addBracketPair(open, close, enableClosingInside.getSelection());");
		sc.add("bracketsList.setItems(bracketsTmp.getBracketArray());");
		sc.add("setErrorMessage(null);");
		sc.add("bracketSetTemp.put(language, bracketsTmp.getBracketString());");
		sc.add("}");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add("removeBracketButton.addSelectionListener(new " + SELECTION_LISTENER + "() {");
		sc.addLineBreak();
		sc.add("public void widgetDefaultSelected(" + SELECTION_EVENT + " e) {");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void widgetSelected(" + SELECTION_EVENT + " e) {");
		sc.add("bracketsTmp.removeBracketPairs(bracketsList.getSelection());");
		sc.add("setErrorMessage(null);");
		sc.add("bracketsList.setItems(bracketsTmp.getBracketArray());");
		sc.add("bracketSetTemp.put(language, bracketsTmp.getBracketString());");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add("bracketsList.addSelectionListener(new " + SELECTION_LISTENER + "() {");
		sc.addLineBreak();
		sc.add("public void widgetSelected(" + SELECTION_EVENT + " e) {");
		sc.add("boolean isClosingInside = true;");
		sc.add("int[] itemIndices = bracketsList.getSelectionIndices();");
		sc.add("for (int index : itemIndices) {");
		sc.add(getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair = bracketsTmp.getBracketPair(index);");
		sc.add("if (bracketPair != null");
		sc.add("&& !bracketPair.isClosingEnabledInside()) {");
		sc.add("isClosingInside = false;");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("enableClosingInside.setSelection(isClosingInside);");
		sc.add("removeBracketButton.setEnabled(itemIndices.length > 0);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void widgetDefaultSelected(" + SELECTION_EVENT + " e) {");
		sc.add("}");
		sc.add("});");
		sc.addLineBreak();
		sc.add("enableClosingInside.addSelectionListener(new " + SELECTION_LISTENER + "() {");
		sc.addLineBreak();
		sc.add("public void widgetSelected(" + SELECTION_EVENT + " e) {");
		sc.add("boolean isClosingInside = enableClosingInside.getSelection();");
		sc.add("int[] itemIndices = bracketsList.getSelectionIndices();");
		sc.add("for (int idx : itemIndices) {");
		sc.add(getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair = bracketsTmp.getBracketPair(idx);");
		sc.add("if (bracketPair != null)");
		sc.add("bracketsTmp.setClosingEnabledInside(bracketPair, isClosingInside);");
		sc.add("}");
		sc.add("bracketSetTemp.put(language, bracketsTmp.getBracketString());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void widgetDefaultSelected(" + SELECTION_EVENT + " e) {");
		sc.add("}");
		sc.add("});");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitializeLanguageMethod(StringComposite sc) {
		sc.add("public void initializeLanguage() {");
		sc.add("bracketSetTemp.put(language, bracketsTmp.getBracketString());");
		sc.add("bracketsTmp.setBrackets(bracketSetTemp.get(language));");
		sc.add("leftBracketTokensCombo.setItems(ALL_LEFT_BRACKETS);");
		sc.add("leftBracketTokensCombo.select(0);");
		sc.add("rightBracketTokensCombo.setItems(ALL_RIGHT_BRACKETS);");
		sc.add("rightBracketTokensCombo.select(0);");
		sc.add("bracketsList.setItems(bracketsTmp.getBracketArray());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHandleMatchingBracketsSelectionMethod(JavaComposite sc) {
		sc.addJavadoc("Initialize and handle the values of this preference page.");
		sc.add("private void handleMatchingBracketsSelection() {");
		sc.addComment("not for the case of none existing language");
		sc.add("enableCheckbox.setSelection(getPreferenceStore().getBoolean(");
		sc.add(preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_CHECKBOX));");
		sc.add("enableClosingInside.setSelection(false);");
		sc.add("matchingBracketsColorButton.setEnabled(getPreferenceStore().getBoolean(");
		sc.add(preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_CHECKBOX));");
		sc.add(RGB + " rgb = " + PREFERENCE_CONVERTER + ".getColor(getPreferenceStore(),");
		sc.add("BRACKETS_COLOR);");
		sc.add("matchingBracketsColorEditor.setColorValue(rgb);");
		sc.add("removeBracketButton.setEnabled(false);");
		sc.addLineBreak();
		sc.add("initializeLanguage();");
		sc.add("bracketsTmp.setBrackets(getPreferenceStore().getString(language + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX));");
		sc.add("String[] brackets = bracketsTmp.getBracketArray();");
		sc.add("if (brackets != null) {");
		sc.add("bracketsList.setItems(brackets);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateContentsMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("protected " + CONTROL + " createContents(" + COMPOSITE + " parent) {");
		sc.addLineBreak();
		sc.addComment("outer Composite");
		sc.add(COMPOSITE + " settingComposite = new " + COMPOSITE + "(parent, " + SWT + ".NONE);");
		sc.add(GRID_LAYOUT + " layout = new " + GRID_LAYOUT + "();");
		sc.add(GRID_DATA + " gd;");
		sc.add("layout.numColumns = 2;");
		sc.add("layout.marginHeight = 0;");
		sc.add("layout.marginWidth = 0;");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING);");
		sc.add("settingComposite.setLayout(layout);");
		sc.add("settingComposite.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("enableCheckbox = new " + BUTTON + "(settingComposite, " + SWT + ".CHECK);");
		sc.add("enableCheckbox.setText(\"Enable\");");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING);");
		sc.add("gd.horizontalAlignment = " + GRID_DATA + ".BEGINNING;");
		sc.add("gd.horizontalSpan = 2;");
		sc.add("enableCheckbox.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("colorEditorLabel = new " + LABEL + "(settingComposite, " + SWT + ".LEFT);");
		sc.add("colorEditorLabel.setText(\"Color:\");");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".HORIZONTAL_ALIGN_BEGINNING);");
		sc.add("gd.horizontalIndent = 20;");
		sc.add("colorEditorLabel.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("matchingBracketsColorEditor = new " + COLOR_SELECTOR + "(settingComposite);");
		sc.add("matchingBracketsColorButton = matchingBracketsColorEditor.getButton();");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".HORIZONTAL_ALIGN_BEGINNING);");
		sc.add("matchingBracketsColorButton.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add(COMPOSITE + " tokenSelectionComposite = new " + COMPOSITE + "(settingComposite, " + SWT + ".NONE);");
		sc.add("layout = new " + GRID_LAYOUT + "();");
		sc.add("layout.numColumns = 3;");
		sc.add("layout.marginHeight = 0;");
		sc.add("layout.marginWidth = 0;");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".FILL_HORIZONTAL);");
		sc.add("gd.horizontalSpan = 2;");
		sc.add("gd.verticalIndent = 20;");
		sc.add("tokenSelectionComposite.setLayout(layout);");
		sc.add("tokenSelectionComposite.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("bracketTokensLabel = new " + LABEL + "(tokenSelectionComposite, " + SWT + ".LEFT);");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING);");
		sc.add("gd.horizontalSpan = 3;");
		sc.add("bracketTokensLabel.setText(\"Add new bracket pair\");");
		sc.add("bracketTokensLabel.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("leftBracketTokensCombo = new " + COMBO + "(tokenSelectionComposite," + SWT + ".DROP_DOWN | " + SWT + ".READ_ONLY);");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING);");
		sc.add("leftBracketTokensCombo.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("rightBracketTokensCombo = new " + COMBO + "(tokenSelectionComposite," + SWT + ".DROP_DOWN | " + SWT + ".READ_ONLY);");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".FILL);");
		sc.add("rightBracketTokensCombo.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("addBracketButton = new " + BUTTON + "(tokenSelectionComposite, " + SWT + ".PUSH);");
		sc.add("addBracketButton.setText(\"Add\");");
		sc.add("addBracketButton.setLayoutData(new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING, " + GRID_DATA + ".BEGINNING, false, false));");
		sc.addLineBreak();

		sc.add(LABEL + " configurePairsLabel = new " + LABEL + "(tokenSelectionComposite, " + SWT + ".LEFT);");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING);");
		sc.add("gd.horizontalSpan = 3;");
		sc.add("gd.verticalIndent = 20;");
		sc.add("configurePairsLabel.setText(\"Configure bracket pairs\");");
		sc.add("configurePairsLabel.setLayoutData(gd);");
		
		sc.add("bracketsList = new " + SWT_LIST + "(tokenSelectionComposite, " + SWT + ".MULTI);");
		sc.add("gd = new " + GRID_DATA + "(" + GRID_DATA + ".CENTER, " + GRID_DATA + ".FILL, false, true);");
		sc.add("gd.horizontalSpan = 2;");
		sc.add("gd.verticalSpan = 4;");
		sc.add("gd.widthHint = 100;");
		sc.add("gd.heightHint = 300;");
		sc.add("bracketsList.setLayoutData(gd);");
		sc.addLineBreak();
		sc.add("enableClosingInside = new " + BUTTON + "(tokenSelectionComposite, " + SWT + ".CHECK);");
		sc.add("enableClosingInside.setText(\"Enable closing inside\");");
		sc.add("enableClosingInside.setToolTipText(\"If this option is enabled, other bracket pair can close inside this pair automatically.\");");
		sc.add("enableClosingInside.setLayoutData(new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING,");
		sc.add(GRID_DATA + ".BEGINNING, false, false));");
		sc.addLineBreak();
		sc.add("removeBracketButton = new " + BUTTON + "(tokenSelectionComposite, " + SWT + ".PUSH);");
		sc.add("removeBracketButton.setText(\"Remove\");");
		sc.add("removeBracketButton.setLayoutData(new " + GRID_DATA + "(" + GRID_DATA + ".BEGINNING,");
		sc.add(GRID_DATA + ".BEGINNING, false, false));");
		sc.addLineBreak();
		sc.add("addListenersToStyleButtons();");
		sc.addLineBreak();
		sc.add("settingComposite.layout(false);");
		sc.add("handleMatchingBracketsSelection();");
		sc.add("return settingComposite;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitMethod(JavaComposite sc) {
		sc.addJavadoc("@see " + I_WORKBENCH_PREFERENCE_PAGE + "#init(" + I_WORKBENCH + ")");
		sc.add("public void init(" + I_WORKBENCH + " workbench) {");
		sc.add("setPreferenceStore(" + pluginActivatorClassName + ".getDefault().getPreferenceStore());");
		sc.add("setDescription(\"Define the coloring of matching brackets.\");");
		sc.addLineBreak();
		sc.add("bracketsTmp = new " + bracketSetClassName + "(null, null);");
		sc.add("for (String languageID : languageIDs) {");
		sc.add("bracketSetTemp.put(languageID, getPreferenceStore().getString(languageID + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX));");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc("Creates a preference page for bracket setting.");
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.addLineBreak();
		sc.add(getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + " metaInformation = new " + metaInformationClassName + "();");
		sc.add("String languageId = metaInformation.getSyntaxName();");
		sc.add("languageIDs.add(languageId);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private static final String[] ALL_LEFT_BRACKETS = new String[] { \"{\", \"(\", \"[\", \"<\", \"\\\"\", \"'\", };");
		sc.add("private static final String[] ALL_RIGHT_BRACKETS = new String[] { \"}\", \")\", \"]\", \">\", \"\\\"\", \"'\", };");
		sc.addLineBreak();
		sc.add("private String BRACKETS_COLOR = " + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_COLOR;");
		sc.addLineBreak();
		sc.add("private " + SET + "<String> languageIDs = new " + LINKED_HASH_SET + "<String>();");
		sc.addLineBreak();
		sc.add("private " + COLOR_SELECTOR + " matchingBracketsColorEditor;");
		sc.add("private " + LABEL + " colorEditorLabel;");
		sc.add("private " + BUTTON + " enableCheckbox;");
		sc.add("private " + BUTTON + " enableClosingInside;");
		sc.add("private " + BUTTON + " matchingBracketsColorButton;");
		sc.add("private " + LABEL + " bracketTokensLabel;");
		sc.add("private " + COMBO + " leftBracketTokensCombo;");
		sc.add("private " + COMBO + " rightBracketTokensCombo;");
		sc.add("private " + SWT_LIST + " bracketsList;");
		sc.add("private " + BUTTON + " addBracketButton;");
		sc.add("private " + BUTTON + " removeBracketButton;");
		sc.add("private " + MAP + "<String, String> bracketSetTemp = new " + LINKED_HASH_MAP + "<String, String>();");
		sc.add("private String language = new " + metaInformationClassName + "().getSyntaxName();");
		sc.addLineBreak();
		sc.add("private " + bracketSetClassName + " bracketsTmp;");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new BracketPreferencePageGenerator(context);
	}
}
