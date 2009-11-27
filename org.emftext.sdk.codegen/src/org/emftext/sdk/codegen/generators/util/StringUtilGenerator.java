/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.codegen.generators.util;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.ITERATOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.MATCHER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.PATTERN;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class StringUtilGenerator extends JavaBaseGenerator {

	public StringUtilGenerator() {
		super();
	}

	private StringUtilGenerator(GenerationContext context) {
		super(context, EArtifact.STRING_UTIL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new StringUtilGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A utility class that provides some common methods to work");
		sc.add("// with Strings.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public final static String HEX_DIGIT_REGEXP = \"[0-9a-fA-F]\";");
		sc.add("public final static String UNICODE_SEQUENCE_REGEXP = \"\\\\A\\\\\\\\u\" + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP + HEX_DIGIT_REGEXP;");
		sc.addLineBreak();
		
		sc.add("// Capitalizes the first letter of the given string.");
		sc.add("//");
		sc.add("// @param text a string.");
		sc.add("// @return the modified string.");
		sc.add("public static String capitalize(String text) {");
		sc.add("String h = text.substring(0, 1).toUpperCase();");
		sc.add("String t = text.substring(1);");
		sc.add("return h + t;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Returns the part of 'tail' that is not present at the end of");
		sc.add("// 'text'. For example if text = 'abc' and tail = 'cd' this method");
		sc.add("// returns 'd'. If 'tail' can not be found at the end of 'text',");
		sc.add("// 'tail' is returned as is.");
		sc.add("//");
		sc.add("// @param text");
		sc.add("// @param tail");
		sc.add("// @return");
		sc.add("public static String getMissingTail(String text, String tail) {");
		sc.add("for (int i = 1; i < tail.length(); i++) {");
		sc.add("int endIndex = text.length();");
		sc.add("int end = Math.max(0, endIndex);");
		sc.add("int start = Math.max(0, end - i);");
		sc.add("String contentTail = text.substring(start, end);");
		sc.add("String proposalHead = tail.substring(0, i);");
		sc.add("if (contentTail.equals(proposalHead)) {");
		sc.add("return tail.substring(i);");
		sc.add("}");
		sc.add("}");
		sc.add("return tail;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Converts a string that contains upper-case letter and");
		sc.add("// underscores (e.g., constant names) to a camel-case string.");
		sc.add("// For example, MY_CONSTANT is converted to myConstant.");
		sc.add("//");
		sc.add("// @param text the string to convert");
		sc.add("// @return");
		sc.add("public static String convertAllCapsToLowerCamelCase(String text) {");
		sc.add("String lowerCase = text.toLowerCase();");
		sc.add("while (true) {");
		sc.add("int i = lowerCase.indexOf('_');");
		sc.add("if (i < 0) {");
		sc.add("break;");
		sc.add("}");
		sc.add("String head = lowerCase.substring(0, i);");
		sc.add("if (i + 1 == lowerCase.length()) {");
		sc.add("lowerCase = head;");
		sc.add("break;");
		sc.add("} else {");
		sc.add("char charAfterUnderscore = lowerCase.charAt(i + 1);");
		sc.add("char upperCase = Character.toUpperCase(charAfterUnderscore);");
		sc.add("if (i + 2 < lowerCase.length()) {");
		sc.add("String tail = lowerCase.substring(i + 2, lowerCase.length());");
		sc.add("lowerCase = head + upperCase + tail;");
		sc.add("} else {");
		sc.add("lowerCase = head + upperCase;");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return lowerCase;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Concatenates the given parts and puts 'glue' between them.");
		sc.add("//");
		sc.add("// @param parts");
		sc.add("// @param glue");
		sc.add("// @return");
		sc.add("public static String explode(" + COLLECTION + "<String> parts, String glue) {");
		sc.add("StringBuilder sb = new StringBuilder();");
		sc.add(ITERATOR + "<String> it = parts.iterator();");
		sc.add("while (it.hasNext()) {");
		sc.add("String next = it.next();");
		sc.add("sb.append(next);");
		sc.add("if (it.hasNext()) {");
		sc.add("sb.append(glue);");
		sc.add("}");
		sc.add("}");
		sc.add("return sb.toString();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Removes single quotes at the start and end of tokenName.");
		sc.add("//");
		sc.add("// @param tokenName");
		sc.add("// @return");
		
		sc.add("public static String formatTokenName(String tokenName) {");
		sc.add("if (tokenName.length() > 0 && tokenName.startsWith(\"'\")) {");
		sc.add("tokenName = tokenName.substring(1, tokenName.length());");
		sc.add("}");
		sc.add("if (tokenName.length() > 0 && tokenName.endsWith(\"'\")) {");
		sc.add("tokenName = tokenName.substring(0, tokenName.length() - 1);");
		sc.add("}");
		sc.add("return tokenName;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static int getLine(String text, int offset) {");
		sc.add("return getLineAndCharPosition(text, offset)[0];");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static int getCharPositionInLine(String text, int offset) {");
		sc.add("return getLineAndCharPosition(text, offset)[1];");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static Integer[] getLineAndCharPosition(String text, int offset) {");
		sc.add("int index = 0;");
		sc.add("int line = 0;");
		sc.add("int positionInLine = 0;");
		sc.add("while (true) {");
		sc.add("line++;");
		sc.add("positionInLine = offset - index + 1;");
		sc.add("int nextN = text.indexOf(\"\\n\", index);");
		sc.add("int nextR = text.indexOf(\"\\r\", index);");
		sc.add("int nextNorR = Integer.MAX_VALUE;");
		sc.add("if (nextN >= 0) {");
		sc.add("nextNorR = nextN;");
		sc.add("} else if (nextR >= 0 && nextR < nextNorR) {");
		sc.add("nextNorR = nextR;");
		sc.add("} else {");
		sc.add("// found no EOL character");
		sc.add("break;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("index = nextNorR + 1;");
		sc.add("if (index == nextN) {");
		sc.add("index++;");
		sc.add("}");
		sc.add("if (index == nextR) {");
		sc.add("index++;");
		sc.add("}");
		sc.add("if (index > offset) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("return new Integer[] {line, positionInLine};");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static String escapeQuotes(String s) {");
		sc.add("s = s.replace(\"\\\\\", \"\\\\\\\\\");");
		sc.add("s = s.replace(\"\\\"\", \"\\\\\\\"\");");
		sc.addLineBreak();
		sc.add("return s;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static String convertCamelCaseToAllCaps(String qualifiedClassName) {");
		sc.add("StringBuffer sb = new StringBuffer();");
		sc.add("final char[] charArray = qualifiedClassName.toCharArray();");
		sc.add("for (int c = 0; c < charArray.length; c++) {");
		sc.add("char character = charArray[c];");
		sc.add("final boolean isEnd = c + 1 == charArray.length;");
		sc.add("boolean nextIsUpper = !isEnd && Character.isUpperCase(charArray[c + 1]);");
		sc.add("boolean nextNextIsLower = c + 2 < (charArray.length) && Character.isLowerCase(charArray[c + 2]);");
		sc.addLineBreak();
		sc.add("sb.append(Character.toUpperCase(character));");
		sc.add("if (Character.isLowerCase(character) && nextIsUpper) {");
		sc.add("sb.append('_');");
		sc.add("} else {");
		sc.add("if (nextIsUpper && nextNextIsLower) {");
		sc.add("sb.append('_');");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("return sb.toString();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Escapes the given text such that it can be safely embedded in a string");
		sc.add("// literal in Java source code.");
		sc.add("//");
		sc.add("// @param text the text to escape");
		sc.add("// @return the escaped text");
		
		sc.add("public static String escapeToJavaString(String text) {");
		sc.add("//for javac: replace one backslash by two and escape double quotes");
		sc.add("return text.replaceAll(\"\\\\\\\\\", \"\\\\\\\\\\\\\\\\\").replaceAll(\"\\\"\", \"\\\\\\\\\\\"\");");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Escapes the given text such that it can be safely embedded in a string");
		sc.add("// literal in the Java source code contained in an ANTLR grammar. This");
		sc.add("// method is similar to escapeToJavaString(), but does also convert the");
		sc.add("// percent character to its Unicode representation, because the percent");
		sc.add("// character has special meaning in ANTLR grammars.");
		sc.add("//");
		sc.add("// Also, single quotes are escaped. God knows why.");
		sc.add("//");
		sc.add("// @param text the text to escape");
		sc.add("// @return the escaped text");
		
		sc.add("public static String escapeToJavaStringInANTLRGrammar(String text) {");
		sc.add("// we must use the Unicode representation for the % character, because");
		sc.add("// StringTemplate does treat % special");
		sc.add("return escapeToJavaString(text.replaceAll(\"'\", \"\\\\'\")).replace(\"%\", \"\\u0025\");");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("// Escapes the given text such that it can be safely embedded in an");
		sc.add("// ANTLR grammar as keyword (i.e., an in-line token). Single quotes");
		sc.add("// are escaped using a backslash. Backslashes are escaped using a");
		sc.add("// backslash.");
		sc.add("//");
		sc.add("// @param text the text to escape");
		sc.add("// @return the escaped text");
		
		sc.add("public static String escapeToANTLRKeyword(String value) {");
		sc.add("String result = value;");
		sc.add("int index = result.indexOf(\"\\\\\");");
		sc.add("while (index >= 0) {");
		sc.add("String tail = result.substring(index);");
		sc.add("if (!tail.matches(UNICODE_SEQUENCE_REGEXP)) {");
		sc.add("// not Unicode - do escape backslash");
		sc.add("String head = \"\";");
		sc.add("if (index > 0) {");
		sc.add("head = result.substring(0, index - 1);");
		sc.add("}");
		sc.add("result = head + \"\\\\\" + tail;");
		sc.add("}");
		sc.add("index = result.indexOf(\"\\\\\", index + 2);");
		sc.add("}");
		sc.add("result.replaceAll(\"'\", \"\\\\'\");");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static boolean isUnicodeSequence(String text) {");
		sc.add("return text.matches(UNICODE_SEQUENCE_REGEXP);");
		sc.add("}");
		sc.addLineBreak();
		
		addMatchCamelCaseMethod(sc);

		sc.add("}");
		return true;
	}

	private void addMatchCamelCaseMethod(StringComposite sc) {
		sc.add("public static String matchCamelCase(String query, String str) {");
		sc.add("if (!query.matches(\"[A-Za-z\\\\*]+\")) {");
		sc.add("return null;");
		sc.add("}");
		sc.add("String head = \"\";");
		sc.add("int i;");
		sc.add("for (i = 0; i < query.length(); i++) {");
		sc.add("char charI = query.charAt(i);");
		sc.add("if (Character.isLowerCase(charI)) {");
		sc.add("head += charI;");
		sc.add("} else {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("if (i > 0) {");
		sc.add("head += \"[^A-Z]*\";");
		sc.add("}");
		sc.add("String tail = query.substring(i);");
		sc.add("String re = \"\\\\b(\";");
		sc.add("tail = tail.replaceAll(\"\\\\*\", \".*?\");");
		sc.add("re += head + tail.replaceAll(\"([A-Z][^A-Z]*)\", \"$1[^A-Z]*\");");
		sc.add("re +=  \".*?)\\\\b\";");
		sc.add(PATTERN + " regex = " + PATTERN + ".compile(re);");
		sc.add(MATCHER + " m = regex.matcher(str);");
		sc.add("if (m.find()) {");
		sc.add("return m.group();");
		sc.add("} else {");
		sc.add("return null;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
