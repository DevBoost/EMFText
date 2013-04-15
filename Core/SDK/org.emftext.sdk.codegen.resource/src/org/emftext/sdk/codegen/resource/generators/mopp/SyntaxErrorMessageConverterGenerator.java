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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.EARLY_EXIT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.FAILED_PREDICATE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_NOT_SET_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_RANGE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_SET_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_TOKEN_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MISMATCHED_TREE_NODE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.NO_VIABLE_ALT_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RECOGNITION_EXCEPTION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class SyntaxErrorMessageConverterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private String[] tokenNames;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String[] tokenNames) {");
		sc.add("this.tokenNames = tokenNames;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addReportLexicalErrorMethod(sc);
		addReportParseErrorMethod(sc);
		addGetMessageMethod(sc);
		addToStringMethod(sc);
		addGetTokenNameMethod(sc);
	}

	private void addReportLexicalErrorMethod(JavaComposite sc) {
		sc.addJavadoc("Translates errors thrown by the lexer into human readable messages.");
		sc.add("public " + localizedMessageClassName + " translateLexicalError(" + RECOGNITION_EXCEPTION + " e, " + LIST + "<" + RECOGNITION_EXCEPTION + "> lexerExceptions, " + LIST + "<Integer> lexerExceptionPositions)  {");
		sc.add("String message = getMessage(e);");
		sc.add("return new " + localizedMessageClassName + "(message, e.charPositionInLine, e.line, lexerExceptionPositions.get(lexerExceptions.indexOf(e)), lexerExceptionPositions.get(lexerExceptions.indexOf(e)));");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReportParseErrorMethod(JavaComposite sc) {
		sc.addJavadoc("Translates errors thrown by the parser into human readable messages.");
		sc.add("public " + localizedMessageClassName + " translateParseError(" + RECOGNITION_EXCEPTION + " e)  {");
		sc.add("String message = getMessage(e);");
		sc.addLineBreak();
		sc.add("if (e.token instanceof " + COMMON_TOKEN + ") {");
		sc.add(COMMON_TOKEN + " ct = (" + COMMON_TOKEN + ") e.token;");
		sc.add("return new " + localizedMessageClassName + "(message, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());");
		sc.add("} else {");
		sc.add("int position = 1;");
		sc.add("int line = 1;");
		sc.add("if (e.token != null) {");
		sc.add("position = e.token.getCharPositionInLine();");
		sc.add("line = e.token.getLine();");
		sc.add("}");
		// In cases of unexpected errors, produce an error and place it at the beginning of the file (Lies 1--5)
		sc.add("return new " + localizedMessageClassName + "(message, position, line, 1, 5);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMessageMethod(JavaComposite sc) {
		sc.add("protected String getMessage(" + RECOGNITION_EXCEPTION + " e)  {");
		sc.add("String message = e.getMessage();");
		sc.add("if (e instanceof " + MISMATCHED_TOKEN_EXCEPTION + ") {");
		sc.add(MISMATCHED_TOKEN_EXCEPTION + " mte = (" + MISMATCHED_TOKEN_EXCEPTION + ") e;");
		sc.add("String expectedTokenName = getTokenName(mte.expecting);");
		sc.add("message = \"Syntax error on token \\\"\" + toString(e.token) + \"\\\" \";");
		sc.add("message += \"Expected: \\\"\" + expectedTokenName + \"\\\".\";");
		sc.add("} else if (e instanceof " + MISMATCHED_TREE_NODE_EXCEPTION + ") {");
		sc.add(MISMATCHED_TREE_NODE_EXCEPTION + " mtne = (" + MISMATCHED_TREE_NODE_EXCEPTION + ") e;");
		sc.add("String expectedTokenName = getTokenName(mtne.expecting);");
		sc.add("String actualTokenName = getTokenName(mtne.getUnexpectedType());");
		sc.add("message = \"Mismatched tree node: \\\"\" + actualTokenName + \"\\\". Expected: \\\"\" + expectedTokenName + \"\\\"\";");
		sc.add("} else if (e instanceof " + NO_VIABLE_ALT_EXCEPTION + ") {");
		sc.add("message = \"Syntax error on token \\\"\" + toString(e.token) + \"\\\". Check following tokens.\";");
		sc.add("} else if (e instanceof " + EARLY_EXIT_EXCEPTION + ") {");
		sc.add("message = \"Syntax error on token \\\"\" + toString(e.token) + \"\\\". Delete this token.\";");
		sc.add("} else if (e instanceof " + MISMATCHED_SET_EXCEPTION + ") {");
		sc.add(MISMATCHED_SET_EXCEPTION + " mse = (" + MISMATCHED_SET_EXCEPTION + ") e;");
		sc.add("message = \"Mismatched token: \" + toString(e.token) + \"; expecting set \" + mse.expecting;");
		sc.add("} else if (e instanceof " + MISMATCHED_NOT_SET_EXCEPTION + ") {");
		sc.add(MISMATCHED_NOT_SET_EXCEPTION + " mse = (" + MISMATCHED_NOT_SET_EXCEPTION + ") e;");
		sc.add("message = \"Mismatched token: \" +  toString(e.token) + \"; expecting set \" + mse.expecting;");
		sc.add("} else if (e instanceof " + MISMATCHED_RANGE_EXCEPTION + ") {");
		sc.add("message = \"Mismatched token: \" + toString(e.token) + \"; expecting range\";");
		sc.add("} else if (e instanceof " + FAILED_PREDICATE_EXCEPTION + ") {");
		sc.add(FAILED_PREDICATE_EXCEPTION + " fpe = (" + FAILED_PREDICATE_EXCEPTION + ") e;");
		sc.add("message = \"Rule \" + fpe.ruleName + \" failed. Predicate: {\" +  fpe.predicateText + \"}?\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return message;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("protected String toString(" + TOKEN + " token)  {");
		sc.add("if (token == null) {");
		sc.add("return \"<UNKNOWN>\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("StringBuilder result = new StringBuilder();");
		sc.add("String tokenName = getTokenName(token.getType());");
		sc.add("String tokenText = token.getText();");
		sc.add("result.append(tokenText);");
		sc.addComment(
				"We mention the name of the actual token only if it differs " + 
				"from the actual token text to reduce confusion in error messages."
		);
		sc.add("if (tokenText != null && !tokenText.equals(tokenName)) {");
		sc.add("result.append(\" (\");");
		sc.add("result.append(tokenName);");
		sc.add("result.append(\")\");");
		sc.add("}");
		sc.add("return result.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNameMethod(JavaComposite sc) {
		sc.add("protected String getTokenName(int tokenType)  {");
		sc.add("String tokenName = \"<unknown>\";");
		sc.add("if (tokenType < 0) {");
		sc.add("tokenName = \"EOF\";");
		sc.add("} else {");
		sc.add("if (tokenType >= tokenNames.length) {");
		sc.add("return tokenName;");
		sc.add("}");
		sc.add("tokenName = tokenNames[tokenType];");
		sc.add("tokenName = " + stringUtilClassName + ".formatTokenName(tokenName);");
		sc.add("}");
		sc.add("return tokenName;");
		sc.add("}");
		sc.addLineBreak();
	}
}
