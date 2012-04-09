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
package org.emftext.sdk.codegen.resource.generators.util;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class UnicodeConverterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A UnicodeConverter can read an input stream and convert " +
			"unicode escape sequences (backslash + uXXXX) to actual " +
			"unicode characters. Each escaped unicode sequence (6 bytes) " +
			"is replaced by the respective UTF-8 byte sequence (1 to 4 " +
			"bytes)."
		);
		// TODO mseifert: information about replaced sequences must be
		// passed to the LocationMap or parser to make sure that the
		// positions of elements found in the stream are correct.
		sc.add("public class " + getResourceClassName() + " extends " + inputStreamProcessorClassName + " {");
		sc.addLineBreak();
		sc.add("private int[] stack = new int[4];");
		sc.add("private int stackPosition = -1;");
		sc.addLineBreak();
		sc.add("private static final char BACKSLASH = '\\\\';");
		sc.addLineBreak();
		
		sc.addJavadoc("The original input stream.");
		sc.add("private " + INPUT_STREAM + " inputStream;");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Creates a new UnicodeConverter that reads from the given stream.",
			"@param inputStream the original stream to read from"
		);
		sc.add("public " + getResourceClassName() + "(" + INPUT_STREAM + " inputStream) {");
		sc.add("this.inputStream = inputStream;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Reads one character from the stream. Escaped unicode characters are " +
			"converted to UTF-8 byte sequences (i.e., up to four bytes)."
		);
		sc.add("@Override");
		sc.addLineBreak();
		sc.add("public int read() throws " + IO_EXCEPTION + " {");
		sc.add("if (!stackIsEmpty()) {");
		sc.add("int result = pop();");
		sc.add("return result;");
		sc.add("}");
		sc.add("int read = inputStream.read();");
		sc.addLineBreak();
		sc.addComment("Must have format \\\\uXXXX where XXXX is a hex number");
		sc.add("if (read >= 0) {");
		sc.add("char c = (char) read;");
		sc.add("if (c == BACKSLASH) {");
		sc.add("int next = inputStream.read();");
		sc.add("char nextChar = (char) next;");
		sc.add("if (nextChar == 'u') {");
		sc.addComment("Now we found the 'u' we need to find another 4 hex digits");
		sc.addComment("Note: shifting left by 4 is the same as multiplying by 16");
		sc.add("int v = 0; // Accumulator");
		sc.add("boolean complete = true;");
		sc.add("int j = 0;");
		sc.add("while (j < 4) {");
		sc.add("next = inputStream.read();");
		sc.add("nextChar = (char) next;");
		sc.add("if (nextChar == 'u') {");
		sc.addComment("ignore more u characters");
		sc.add("continue;");
		sc.add("}");
		sc.add("j++;");
		sc.add("if (next < 0) {");
		sc.add("complete = false;");
		sc.add("break;");
		sc.add("}");
		sc.add("switch (nextChar) {");
		sc.add("case 48: // '0'");
		sc.add("case 49: // '1'");
		sc.add("case 50: // '2'");
		sc.add("case 51: // '3'");
		sc.add("case 52: // '4'");
		sc.add("case 53: // '5'");
		sc.add("case 54: // '6'");
		sc.add("case 55: // '7'");
		sc.add("case 56: // '8'");
		sc.add("case 57: // '9'");
		sc.add("v = ((v << 4) + nextChar) - 48;");
		sc.add("break;");
		sc.addLineBreak();
		sc.add("case 97: // 'a'");
		sc.add("case 98: // 'b'");
		sc.add("case 99: // 'c'");
		sc.add("case 100: // 'd'");
		sc.add("case 101: // 'e'");
		sc.add("case 102: // 'f'");
		sc.add("v = ((v << 4) + 10 + nextChar) - 97;");
		sc.add("break;");
		sc.addLineBreak();
		sc.add("case 65: // 'A'");
		sc.add("case 66: // 'B'");
		sc.add("case 67: // 'C'");
		sc.add("case 68: // 'D'");
		sc.add("case 69: // 'E'");
		sc.add("case 70: // 'F'");
		sc.add("v = ((v << 4) + 10 + nextChar) - 65;");
		sc.add("break;");
		sc.add("default:");
		sc.addComment("this case can never happen if the unicode escape sequences are correct");
		sc.add("v = 0;");
		sc.addComment("clear the accumulator");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.addComment("for each of the 4 digits");
		sc.addLineBreak();
		sc.add("if (complete) {");
		sc.addComment("We got a full conversion");
		sc.add("return encodePushAndReturn(v);");
		sc.add("}");
		sc.add("} else {");
		sc.addComment("was: lookAheadCharacter = next;");
		sc.add("encodePush(next);");
		sc.add("}");
		sc.add("} else {");
		sc.add("return read;");
		sc.add("}");
		sc.add("}");
		sc.addComment("do not encode negative numbers, because they signal EOF");
		sc.add("return read;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private int encodePushAndReturn(int next) {");
		sc.add("byte[] encoded = encode(next);");
		sc.addComment("we must add the bytes backwards because we use a stack");
		sc.addComment("we do not push the first byte since it is returned immediately");
		sc.add("for (int i = encoded.length - 1; i >= 1; i--) {");
		sc.add("push(unsignedByteToInt(encoded[i]));");
		sc.add("}");
		sc.add("return unsignedByteToInt(encoded[0]);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private void encodePush(int next) {");
		sc.add("byte[] encoded = encode(next);");
		sc.addComment("we must add the bytes backwards because we use a stack");
		sc.add("for (int i = encoded.length - 1; i >= 0; i--) {");
		sc.add("push(unsignedByteToInt(encoded[i]));");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private int pop() {");
		sc.add("assert stackPosition >= 0;");
		sc.add("int result = stack[stackPosition];");
		sc.add("stackPosition--;");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private void push(int aByte) {");
		sc.add("stackPosition++;");
		sc.add("assert stackPosition < stack.length;");
		sc.add("stack[stackPosition] = aByte;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private boolean stackIsEmpty() {");
		sc.add("return stackPosition < 0;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static int unsignedByteToInt(byte b) {");
		sc.add("return (int) b & 0xFF;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static byte[] encode(int ch) {");
		sc.addComment("return encode(new int[]{ch});");
		sc.add("int bytesNeeded = 0;");
		sc.add("if (ch < 0x80) {");
		sc.add("++bytesNeeded;");
		sc.add("} else if (ch < 0x0800) {");
		sc.add("bytesNeeded += 2;");
		sc.add("} else if (ch < 0x10000) {");
		sc.add("bytesNeeded += 3;");
		sc.add("} else {");
		sc.add("bytesNeeded += 4;");
		sc.add("}");
		sc.addComment("allocate a byte[] of the necessary size");
		sc.add("byte[] utf8 = new byte[bytesNeeded];");
		sc.addComment("do the conversion from character code points to utf-8");
		sc.add("int bytes = 0;");
		sc.add("if (ch < 0x80) {");
		sc.add("utf8[bytes++] = (byte) ch;");
		sc.add("} else if (ch < 0x0800) {");
		sc.add("utf8[bytes++] = (byte) (ch >> 6 | 0xC0);");
		sc.add("utf8[bytes++] = (byte) (ch & 0x3F | 0x80);");
		sc.add("} else if (ch < 0x10000) {");
		sc.add("utf8[bytes++] = (byte) (ch >> 12 | 0xE0);");
		sc.add("utf8[bytes++] = (byte) (ch >> 6 & 0x3F | 0x80);");
		sc.add("utf8[bytes++] = (byte) (ch & 0x3F | 0x80);");
		sc.add("} else {");
		sc.add("utf8[bytes++] = (byte) (ch >> 18 | 0xF0);");
		sc.add("utf8[bytes++] = (byte) (ch >> 12 & 0x3F | 0x80);");
		sc.add("utf8[bytes++] = (byte) (ch >> 6 & 0x3F | 0x80);");
		sc.add("utf8[bytes++] = (byte) (ch & 0x3F | 0x80);");
		sc.add("}");
		sc.add("return utf8;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static byte[] encode(int[] ch) {");
		sc.addComment("determine how many bytes are needed for the complete conversion");
		sc.add("int bytesNeeded = 0;");
		sc.add("for (int i = 0; i < ch.length; i++) {");
		sc.add("if (ch[i] < 0x80) {");
		sc.add("++bytesNeeded;");
		sc.add("} else if (ch[i] < 0x0800) {");
		sc.add("bytesNeeded += 2;");
		sc.add("} else if (ch[i] < 0x10000) {");
		sc.add("bytesNeeded += 3;");
		sc.add("} else {");
		sc.add("bytesNeeded += 4;");
		sc.add("}");
		sc.add("}");
		sc.addComment("allocate a byte[] of the necessary size");
		sc.add("byte[] utf8 = new byte[bytesNeeded];");
		sc.addComment("do the conversion from character code points to utf-8");
		sc.add("for (int i = 0, bytes = 0; i < ch.length; i++) {");
		sc.add("if (ch[i] < 0x80) {");
		sc.add("utf8[bytes++] = (byte) ch[i];");
		sc.add("} else if (ch[i] < 0x0800) {");
		sc.add("utf8[bytes++] = (byte) (ch[i] >> 6 | 0xC0);");
		sc.add("utf8[bytes++] = (byte) (ch[i] & 0x3F | 0x80);");
		sc.add("} else if (ch[i] < 0x10000) {");
		sc.add("utf8[bytes++] = (byte) (ch[i] >> 12 | 0xE0);");
		sc.add("utf8[bytes++] = (byte) (ch[i] >> 6 & 0x3F | 0x80);");
		sc.add("utf8[bytes++] = (byte) (ch[i] & 0x3F | 0x80);");
		sc.add("} else {");
		sc.add("utf8[bytes++] = (byte) (ch[i] >> 18 | 0xF0);");
		sc.add("utf8[bytes++] = (byte) (ch[i] >> 12 & 0x3F | 0x80);");
		sc.add("utf8[bytes++] = (byte) (ch[i] >> 6 & 0x3F | 0x80);");
		sc.add("utf8[bytes++] = (byte) (ch[i] & 0x3F | 0x80);");
		sc.add("}");
		sc.add("}");
		sc.add("return utf8;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getOutputEncoding() {");
		sc.add("return \"UTF-8\";");
		sc.add("}");
		sc.add("}");
	}
}
