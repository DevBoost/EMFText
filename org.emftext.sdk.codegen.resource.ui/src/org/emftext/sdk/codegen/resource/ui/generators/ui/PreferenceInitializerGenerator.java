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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.ABSTRACT_PREFERENCE_INITIALIZER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_PREFERENCE_STORE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class PreferenceInitializerGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() +";");
		sc.addLineBreak();
		
		sc.addJavadoc("A class used to initialize default preference values.");
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_PREFERENCE_INITIALIZER + " {");
		sc.addLineBreak();
		// TODO this should not be used here!
		sc.add("private final static " + antlrTokenHelperClassName + " tokenHelper = new " + antlrTokenHelperClassName + "();");
		sc.addLineBreak();
		sc.add("public void initializeDefaultPreferences() {");
		sc.addLineBreak();
		sc.add("initializeDefaultSyntaxHighlighting();");
		sc.add("initializeDefaultBrackets();");
		sc.addLineBreak();
		sc.add(I_PREFERENCE_STORE + " store = " + uiPluginActivatorClassName + ".getDefault().getPreferenceStore();");
		sc.addComment("Set default value for matching brackets");
		sc.add("store.setDefault(" + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_COLOR, \"192,192,192\");");
		sc.add("store.setDefault(" + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_CHECKBOX, true);");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private void initializeDefaultBrackets() {");
		sc.add(I_PREFERENCE_STORE + " store = " + uiPluginActivatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("initializeDefaultBrackets(store, new " + metaInformationClassName + "());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void initializeDefaultSyntaxHighlighting() {");
		sc.add(I_PREFERENCE_STORE + " store = " + uiPluginActivatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("initializeDefaultSyntaxHighlighting(store, new " + metaInformationClassName + "());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private void initializeDefaultBrackets(" + I_PREFERENCE_STORE + " store, " + iMetaInformationClassName + " metaInformation) {");
		sc.add("String languageId = metaInformation.getSyntaxName();");
		sc.addComment("set default brackets for ITextResource bracket set");
		sc.add(bracketSetClassName + " bracketSet = new " + bracketSetClassName + "(null, null);");
		sc.add("final " + COLLECTION + "<" + iBracketPairClassName + "> bracketPairs = metaInformation.getBracketPairs();");
		sc.add("if (bracketPairs != null) {");
		sc.add("for (" + iBracketPairClassName + " bracketPair : bracketPairs) {");
		sc.add("bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());");
		sc.add("}");
		sc.add("}");
		sc.add("store.setDefault(languageId + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private void initializeDefaultSyntaxHighlighting(" + I_PREFERENCE_STORE + " store, " + iMetaInformationClassName + " metaInformation) {");
		sc.add("String languageId = metaInformation.getSyntaxName();");
		sc.add("String[] tokenNames = metaInformation.getTokenNames();");
		sc.add("if (tokenNames == null) {");
		sc.add("return;");
		sc.add("}");
		sc.add("for (int i = 0; i < tokenNames.length; i++) {");
		sc.add("if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {");
		sc.add("continue;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("String tokenName = tokenHelper.getTokenName(tokenNames, i);");
		sc.add("if (tokenName == null) {");
		sc.add("continue;");
		sc.add("}");
		sc.add(iTokenStyleClassName + " style = metaInformation.getDefaultTokenStyle(tokenName);");
		sc.add("if (style != null) {");
		sc.add("String color = getColorString(style.getColorAsRGB());");
		sc.add("setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());");
		sc.add("} else {");
		sc.add("setProperties(store, languageId, tokenName, \"0,0,0\", false, false, false, false, false);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private void setProperties(" + I_PREFERENCE_STORE + " store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {");
		sc.add("store.setDefault(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageID, tokenName, " + syntaxColoringHelperClassName + ".StyleProperty.BOLD), bold);");
		sc.add("store.setDefault(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageID, tokenName, " + syntaxColoringHelperClassName + ".StyleProperty.COLOR), color);");
		sc.add("store.setDefault(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageID, tokenName, " + syntaxColoringHelperClassName + ".StyleProperty.ENABLE), enable);");
		sc.add("store.setDefault(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageID, tokenName, " + syntaxColoringHelperClassName + ".StyleProperty.ITALIC), italic);");
		sc.add("store.setDefault(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageID, tokenName, " + syntaxColoringHelperClassName + ".StyleProperty.STRIKETHROUGH), strikethrough);");
		sc.add("store.setDefault(" + syntaxColoringHelperClassName + ".getPreferenceKey(languageID, tokenName, " + syntaxColoringHelperClassName + ".StyleProperty.UNDERLINE), underline);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private String getColorString(int[] colorAsRGB) {");
		sc.add("if (colorAsRGB == null) {");
		sc.add("return \"0,0,0\";");
		sc.add("}");
		sc.add("if (colorAsRGB.length != 3) {");
		sc.add("return \"0,0,0\";");
		sc.add("}");
		sc.add("return colorAsRGB[0] + \",\" +colorAsRGB[1] + \",\"+ colorAsRGB[2];");
		sc.add("}");
		sc.add("}");
	}
}
