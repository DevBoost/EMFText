package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_EMF_TEXT_SCANNER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.COMMON_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LEXER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_RESOURCE_PLUGIN_META_INFORMATION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ANTLR_STRING_STREAM;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ANTLRScannerGenerator extends BaseGenerator {

	public ANTLRScannerGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getClassName(EArtifact.ANTLR_SCANNER));
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_EMF_TEXT_SCANNER + " {");
		sc.addLineBreak();

		sc.add("private " + STRING + "[] tokenNames;");
		sc.add("private " + LEXER + " antlrLexer;");
		sc.addLineBreak();

		sc.add("public " + getResourceClassName() + "(" + I_TEXT_RESOURCE_PLUGIN_META_INFORMATION + " metaInformation, " + LEXER + " antlrLexer) {");
		sc.add("this.tokenNames = metaInformation.getTokenNames();");
		sc.add("this.antlrLexer = antlrLexer;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public " + I_TEXT_TOKEN + " getNextToken() {");
		sc.add("final " + TOKEN + " current = antlrLexer.nextToken();");
		sc.add(I_TEXT_TOKEN + " result = new " + I_TEXT_TOKEN + "() {");
		sc.addLineBreak();
		sc.add("public " + STRING + " getName() {");
		sc.add("return getTokenName(tokenNames, current.getType());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getOffset() {");
		sc.add("return ((" + COMMON_TOKEN + ") current).getStartIndex();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int getLength() {");
		sc.add("return ((" + COMMON_TOKEN + ") current).getStopIndex() - ((" + COMMON_TOKEN + ") current).getStartIndex() + 1;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean canBeUsedForSyntaxHighlighting() {");
		sc.add("int tokenType = current.getType();");
		sc.add("if (tokenType == " + TOKEN + ".EOF) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (tokenType == " + TOKEN + ".UP) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (tokenType == " + TOKEN + ".DOWN) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (tokenType == " + TOKEN + ".EOR_TOKEN_TYPE) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (tokenType == " + TOKEN + ".INVALID_TOKEN_TYPE) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.add("public " + STRING + " getText() {");
		sc.add("return current.getText();");
		sc.add("}");
		sc.add("};");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setText(" + STRING + " text) {");
		sc.add("antlrLexer.setCharStream(new " + ANTLR_STRING_STREAM + "(text));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + STRING + " getTokenName(" + STRING + "[] tokenNames, int index) {");
		sc.add("if (tokenNames == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(STRING + " tokenName = tokenNames[index];");
		sc.add("if (tokenName != null && tokenName.startsWith(\"'\")) {");
		sc.add("tokenName = tokenName.substring(1, tokenName.length() - 1).trim();");
		sc.add("}");
		sc.add("return tokenName;");
		sc.add("}");
		sc.add("}");
		out.write(sc.toString());
		return true;
	}
}
