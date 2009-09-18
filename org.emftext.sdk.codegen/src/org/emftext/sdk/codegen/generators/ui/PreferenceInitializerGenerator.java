package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_PREFERENCE_INITIALIZER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PREFERENCE_STORE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class PreferenceInitializerGenerator extends BaseGenerator {

	private String activatorClassName;
	private String bracketSetClassName;
	private String syntaxColoringHelperClassName;
	private String preferenceConstantsClassName;
	private String antlrTokenHelperClassName;
	private String metaInformationClassName;

	public PreferenceInitializerGenerator() {
		super();
	}

	private PreferenceInitializerGenerator(GenerationContext context) {
		super(context, EArtifact.PREFERENCE_INITIALIZER);
		activatorClassName = getContext().getQualifiedClassName(EArtifact.PLUGIN_ACTIVATOR);
		antlrTokenHelperClassName = getContext().getQualifiedClassName(EArtifact.ANTLR_TOKEN_HELPER);
		bracketSetClassName = getContext().getQualifiedClassName(EArtifact.BRACKET_SET);
		syntaxColoringHelperClassName = getContext().getQualifiedClassName(EArtifact.SYNTAX_COLORING_HELPER);
		preferenceConstantsClassName = getContext().getQualifiedClassName(EArtifact.PREFERENCE_CONSTANTS);
		metaInformationClassName = getContext().getQualifiedClassName(EArtifact.META_INFORMATION);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new PreferenceInitializerGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() +";");
		sc.addLineBreak();
		sc.add("// Class used to initialize default preference values.");
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_PREFERENCE_INITIALIZER + " {");
		sc.addLineBreak();
		sc.add("// TODO this should not be used here!");
		sc.add("private final static " + antlrTokenHelperClassName + " tokenHelper = new " + antlrTokenHelperClassName + "();");
		sc.addLineBreak();
		sc.add("public void initializeDefaultPreferences() {");
		sc.addLineBreak();
		sc.add("initializeDefaultSyntaxHighlighting();");
		sc.add("initializeDefaultBrackets();");
		sc.addLineBreak();
		sc.add(I_PREFERENCE_STORE + " store = " + activatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("//Set default value for matching brackets");
		sc.add("store.setDefault(" + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_COLOR, \"192,192,192\");");
		sc.add("store.setDefault(" + preferenceConstantsClassName + ".EDITOR_MATCHING_BRACKETS_CHECKBOX, true);");
		sc.addLineBreak();
		sc.add("//Set default value for occurrences");
		sc.add("store.setDefault(" + preferenceConstantsClassName + ".EDITOR_OCCURRENCE_CHECKBOX, true);");
		sc.add("store.setDefault(" + preferenceConstantsClassName + ".EDITOR_DEFINITION_COLOR, \"240,216,168\");");
		sc.add("store.setDefault(" + preferenceConstantsClassName + ".EDITOR_PROXY_COLOR, \"212,212,212\");");
		sc.addLineBreak();
		sc.add("//store.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_OVERVIEW_RULER, true);");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private void initializeDefaultBrackets() {");
		sc.add(I_PREFERENCE_STORE + " store = " + activatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("initializeDefaultBrackets(store, new " + metaInformationClassName + "());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void initializeDefaultSyntaxHighlighting() {");
		sc.add(I_PREFERENCE_STORE + " store = " + activatorClassName + ".getDefault().getPreferenceStore();");
		sc.add("initializeDefaultSyntaxHighlighting(store, new " + metaInformationClassName + "());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private void initializeDefaultBrackets(" + I_PREFERENCE_STORE + " store, " + getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + " metaInformation) {");
		sc.add("String languageId = metaInformation.getSyntaxName();");
		sc.add("// set default brackets for ITextResource bracket set");
		sc.add(bracketSetClassName + " bracketSet = new " + bracketSetClassName + "(null, languageId);");
		sc.add("final " + COLLECTION + "<" + getClassNameHelper().getI_BRACKET_PAIR() + "> bracketPairs = metaInformation.getBracketPairs();");
		sc.add("if (bracketPairs != null) {");
		sc.add("for (" + getClassNameHelper().getI_BRACKET_PAIR() + " bracketPair : bracketPairs) {");
		sc.add("bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());");
		sc.add("}");
		sc.add("}");
		sc.add("store.setDefault(languageId + " + preferenceConstantsClassName + ".EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("private void initializeDefaultSyntaxHighlighting(" + I_PREFERENCE_STORE + " store, " + getClassNameHelper().getI_TEXT_RESOURCE_PLUGIN_META_INFORMATION() + " metaInformation) {");
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
		sc.add(getClassNameHelper().getI_TOKEN_STYLE() + " style = metaInformation.getDefaultTokenStyle(tokenName);");
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
		out.print(sc.toString());
		return true;
	}
}
