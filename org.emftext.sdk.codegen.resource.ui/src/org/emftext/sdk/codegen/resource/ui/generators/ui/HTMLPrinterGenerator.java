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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FONT_DATA;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.PUSHBACK_READER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.READER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SET;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STRING_READER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STYLE_RANGE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.SWT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.TEXT_PRESENTATION;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class HTMLPrinterGenerator extends UIJavaBaseGenerator {

	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new HTMLPrinterGenerator());

	private HTMLPrinterGenerator() {
		super();
	}

	private HTMLPrinterGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceUIArtifacts.HTML_PRINTER);
	}

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("This class is copied from org.eclipse.jface.internal.text.html.HTMLPrinter.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addJavadoc(
			"Reads the text contents from a reader of HTML contents and translates " +
			"the tags or cut them out.",
			"<p>Moved into HTMLPrinter as inner class from <code>org.eclipse.jface.internal.text.html</code>.</p>"
		);
		
		sc.add("private static final class HTML2TextReader extends " + READER + " {");
		sc.addLineBreak();
		sc.add("private static final String EMPTY_STRING= \"\";");
		sc.add("private " + MAP + "<String, String> fgEntityLookup;");
		sc.add("private " + SET + "<String> fgTags;");
		sc.addLineBreak();
		sc.add("private int fCounter= 0;");
		sc.add("private " + TEXT_PRESENTATION + " fTextPresentation;");
		sc.add("private int fBold= 0;");
		sc.add("private int fStartOffset= -1;");
		sc.add("private boolean fInParagraph= false;");
		sc.add("private boolean fIsPreformattedText= false;");
		sc.add("private boolean fIgnore= false;");
		sc.add("private boolean fHeaderDetected= false;");
		sc.addLineBreak();
		sc.add("protected final String LINE_DELIM= System.getProperty(\"line.separator\", \"\\n\");");
		sc.addLineBreak();
		sc.add("private " + READER + " fReader;");
		sc.add("protected boolean fWasWhiteSpace;");
		sc.add("private int fCharAfterWhiteSpace;");
		sc.addLineBreak();
		
		sc.addJavadoc("Tells whether white space characters are skipped.");
		sc.add("private boolean fSkipWhiteSpace= true;");
		sc.addLineBreak();
		
		sc.add("private boolean fReadFromBuffer;");
		sc.add("private StringBuffer fBuffer;");
		sc.add("private int fIndex;");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Transforms the HTML text from the reader to formatted text.",
			"@param reader the reader",
			"@param presentation If not <code>null</code>, formattings will be applied to the presentation."
		);
		sc.add("public HTML2TextReader(" + READER + " reader, " + TEXT_PRESENTATION + " presentation) {");
		sc.addLineBreak();
		
		sc.add("fReader= reader;");
		sc.add("fBuffer= new StringBuffer();");
		sc.add("fIndex= 0;");
		sc.add("fReadFromBuffer= false;");
		sc.add("fCharAfterWhiteSpace= -1;");
		sc.add("fWasWhiteSpace= true;");
		sc.addLineBreak();
		sc.add("fgTags= new " + LINKED_HASH_SET + "<String>();");
		sc.add("fgTags.add(\"b\");");
		sc.add("fgTags.add(\"br\");");
		sc.add("fgTags.add(\"br/\");");
		sc.add("fgTags.add(\"br /\");");
		sc.add("fgTags.add(\"div\");");
		sc.add("fgTags.add(\"h1\");");
		sc.add("fgTags.add(\"h2\");");
		sc.add("fgTags.add(\"h3\");");
		sc.add("fgTags.add(\"h4\");");
		sc.add("fgTags.add(\"h5\");");
		sc.add("fgTags.add(\"p\");");
		sc.add("fgTags.add(\"dl\");");
		sc.add("fgTags.add(\"dt\");");
		sc.add("fgTags.add(\"dd\");");
		sc.add("fgTags.add(\"li\");");
		sc.add("fgTags.add(\"ul\");");
		sc.add("fgTags.add(\"pre\");");
		sc.add("fgTags.add(\"head\");");
		sc.addLineBreak();
		sc.add("fgEntityLookup= new " + LINKED_HASH_MAP + "<String, String>(7);");
		sc.add("fgEntityLookup.put(\"lt\", \"<\");");
		sc.add("fgEntityLookup.put(\"gt\", \">\");");
		sc.add("fgEntityLookup.put(\"nbsp\", \" \");");
		sc.add("fgEntityLookup.put(\"amp\", \"&\");");
		sc.add("fgEntityLookup.put(\"circ\", \"^\");");
		sc.add("fgEntityLookup.put(\"tilde\", \"~\");");
		sc.add("fgEntityLookup.put(\"quot\", \"\\\"\");");
		sc.add("fTextPresentation= presentation;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public int read() throws " + IO_EXCEPTION + " {");
		sc.add("int c;");
		sc.add("do {");
		sc.addLineBreak();
		sc.add("c= nextChar();");
		sc.add("while (!fReadFromBuffer) {");
		sc.add("String s= computeSubstitution(c);");
		sc.add("if (s == null)");
		sc.add("break;");
		sc.add("if (s.length() > 0)");
		sc.add("fBuffer.insert(0, s);");
		sc.add("c= nextChar();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("} while (fSkipWhiteSpace && fWasWhiteSpace && (c == ' '));");
		sc.add("fWasWhiteSpace= (c == ' ' || c == '\\r' || c == '\\n');");
		sc.add("if (c != -1)");
		sc.add("++ fCounter;");
		sc.add("return c;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("protected void startBold() {");
		sc.add("if (fBold == 0)");
		sc.add("fStartOffset= fCounter;");
		sc.add("++ fBold;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("protected void startPreformattedText() {");
		sc.add("fIsPreformattedText= true;");
		sc.add("setSkipWhitespace(false);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("protected void stopPreformattedText() {");
		sc.add("fIsPreformattedText= false;");
		sc.add("setSkipWhitespace(true);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("protected void stopBold() {");
		sc.add("-- fBold;");
		sc.add("if (fBold == 0) {");
		sc.add("if (fTextPresentation != null) {");
		sc.add("fTextPresentation.addStyleRange(new " + STYLE_RANGE + "(fStartOffset, fCounter - fStartOffset, null, null, " + SWT + ".BOLD));");
		sc.add("}");
		sc.add("fStartOffset= -1;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("@see org.eclipse.jdt.internal.ui.text.SubstitutionTextReader#computeSubstitution(int)");
		sc.add("protected String computeSubstitution(int c) throws " + IO_EXCEPTION + " {");
		sc.addLineBreak();
		sc.add("if (c == '<')");
		sc.add("return  processHTMLTag();");
		sc.add("else if (fIgnore)");
		sc.add("return EMPTY_STRING;");
		sc.add("else if (c == '&')");
		sc.add("return processEntity();");
		sc.add("else if (fIsPreformattedText)");
		sc.add("return processPreformattedText(c);");
		sc.addLineBreak();
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private String html2Text(String html) {");
		sc.addLineBreak();
		sc.add("if (html == null || html.length() == 0)");
		sc.add("return EMPTY_STRING;");
		sc.addLineBreak();
		sc.add("html= html.toLowerCase();");
		sc.addLineBreak();
		sc.add("String tag= html;");
		sc.add("if ('/' == tag.charAt(0))");
		sc.add("tag= tag.substring(1);");
		sc.addLineBreak();
		sc.add("if (!fgTags.contains(tag))");
		sc.add("return EMPTY_STRING;");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.add("if (\"pre\".equals(html)) {");
		sc.add("startPreformattedText();");
		sc.add("return EMPTY_STRING;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (\"/pre\".equals(html)) {");
		sc.add("stopPreformattedText();");
		sc.add("return EMPTY_STRING;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (fIsPreformattedText)");
		sc.add("return EMPTY_STRING;");
		sc.addLineBreak();
		sc.add("if (\"b\".equals(html)) {");
		sc.add("startBold();");
		sc.add("return EMPTY_STRING;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if ((html.length() > 1 && html.charAt(0) == 'h' && Character.isDigit(html.charAt(1))) || \"dt\".equals(html)) {");
		sc.add("startBold();");
		sc.add("return EMPTY_STRING;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (\"dl\".equals(html))");
		sc.add("return LINE_DELIM;");
		sc.addLineBreak();
		sc.add("if (\"dd\".equals(html))");
		sc.add("return \"\t\";");
		sc.addLineBreak();
		// FIXME: this hard-coded prefix does not work for RTL languages, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=91682
		//This return is taken from org.eclipse.jface.internal.text.html.HTMLMessages.properties
		sc.add("if (\"li\".equals(html))");
		sc.add("return LINE_DELIM + \"\\t-\\n \";");
		sc.addLineBreak();
		sc.add("if (\"/b\".equals(html)) {");
		sc.add("stopBold();");
		sc.add("return EMPTY_STRING;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (\"p\".equals(html))  {");
		sc.add("fInParagraph= true;");
		sc.add("return LINE_DELIM;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (\"br\".equals(html) || \"br/\".equals(html)|| \"br /\".equals(html)  || \"div\".equals(html))");
		sc.add("return LINE_DELIM;");
		sc.addLineBreak();
		sc.add("if (\"/p\".equals(html)) {");
		sc.add("boolean inParagraph= fInParagraph;");
		sc.add("fInParagraph= false;");
		sc.add("return inParagraph ? EMPTY_STRING : LINE_DELIM;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if ((html.startsWith(\"/h\") && html.length() > 2 && Character.isDigit(html.charAt(2))) || \"/dt\".equals(html)) {");
		sc.add("stopBold();");
		sc.add("return LINE_DELIM;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (\"/dd\".equals(html))");
		sc.add("return LINE_DELIM;");
		sc.addLineBreak();
		sc.add("if (\"head\".equals(html) && !fHeaderDetected) {");
		sc.add("fHeaderDetected= true;");
		sc.add("fIgnore= true;");
		sc.add("return EMPTY_STRING;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (\"/head\".equals(html) && fHeaderDetected && fIgnore) {");
		sc.add("fIgnore= false;");
		sc.add("return EMPTY_STRING;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("return EMPTY_STRING;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("A '<' has been read. Process a html tag");
		sc.add("private String processHTMLTag() throws " + IO_EXCEPTION + " {");
		sc.addLineBreak();
		sc.add("StringBuffer buf= new StringBuffer();");
		sc.add("int ch;");
		sc.add("do {");
		sc.addLineBreak();
		sc.add("ch= nextChar();");
		sc.addLineBreak();
		sc.add("while (ch != -1 && ch != '>') {");
		sc.add("buf.append(Character.toLowerCase((char) ch));");
		sc.add("ch= nextChar();");
		sc.add("if (ch == '\"'){");
		sc.add("buf.append(Character.toLowerCase((char) ch));");
		sc.add("ch= nextChar();");
		sc.add("while (ch != -1 && ch != '\"'){");
		sc.add("buf.append(Character.toLowerCase((char) ch));");
		sc.add("ch= nextChar();");
		sc.add("}");
		sc.add("}");
		sc.add("if (ch == '<' && !isInComment(buf)) {");
		sc.add("unread(ch);");
		sc.add("return '<' + buf.toString();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (ch == -1)");
		sc.add("return null;");
		sc.addLineBreak();
		sc.add("if (!isInComment(buf) || isCommentEnd(buf)) {");
		sc.add("break;");
		sc.add("}");
		sc.addComment("unfinished comment");
		sc.add("buf.append((char) ch);");
		sc.add("} while (true);");
		sc.addLineBreak();
		sc.add("return html2Text(buf.toString());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private boolean isInComment(StringBuffer buf) {");
		sc.add("return buf.length() >= 3 && \"!--\".equals(buf.substring(0, 3));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private boolean isCommentEnd(StringBuffer buf) {");
		sc.add("int tagLen= buf.length();");
		sc.add("return tagLen >= 5 && \"--\".equals(buf.substring(tagLen - 2));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("private String processPreformattedText(int c) {");
		sc.add("if  (c == '\\r' || c == '\\n')");
		sc.add("fCounter++;");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.add("private void unread(int ch) throws " + IO_EXCEPTION + " {");
		sc.add("((" + PUSHBACK_READER + ") getReader()).unread(ch);");
		sc.add("}");
		sc.addLineBreak();
		sc.add("protected String entity2Text(String symbol) {");
		sc.add("if (symbol.length() > 1 && symbol.charAt(0) == '#') {");
		sc.add("int ch;");
		sc.add("try {");
		sc.add("if (symbol.charAt(1) == 'x') {");
		sc.add("ch= Integer.parseInt(symbol.substring(2), 16);");
		sc.add("} else {");
		sc.add("ch= Integer.parseInt(symbol.substring(1), 10);");
		sc.add("}");
		sc.add("return EMPTY_STRING + (char)ch;");
		sc.add("} catch (NumberFormatException e) {");
		sc.add("}");
		sc.add("} else {");
		sc.add("String str= (String) fgEntityLookup.get(symbol);");
		sc.add("if (str != null) {");
		sc.add("return str;");
		sc.add("}");
		sc.add("}");
		sc.add("return \"&\" + symbol; // not found");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc("A '&' has been read. Process a entity");
		sc.add("private String processEntity() throws " + IO_EXCEPTION + " {");
		sc.add("StringBuffer buf= new StringBuffer();");
		sc.add("int ch= nextChar();");
		sc.add("while (Character.isLetterOrDigit((char)ch) || ch == '#') {");
		sc.add("buf.append((char) ch);");
		sc.add("ch= nextChar();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("if (ch == ';')");
		sc.add("return entity2Text(buf.toString());");
		sc.addLineBreak();
		sc.add("buf.insert(0, '&');");
		sc.add("if (ch != -1)");
		sc.add("buf.append((char) ch);");
		sc.add("return buf.toString();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void close() throws " + IO_EXCEPTION + " {");
		sc.add("fReader.close();");
		sc.addLineBreak();
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public int read(char[] cbuf, int off, int len) throws " + IO_EXCEPTION + " {");
		sc.add("int end= off + len;");
		sc.add("for (int i= off; i < end; i++) {");
		sc.add("int ch= read();");
		sc.add("if (ch == -1) {");
		sc.add("if (i == off)");
		sc.add("return -1;");
		sc.add("return i - off;");
		sc.add("}");
		sc.add("cbuf[i]= (char)ch;");
		sc.add("}");
		sc.add("return len;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the internal reader.",
			"@return the internal reader"
		);
		
		sc.add("protected " + READER + " getReader() {");
		sc.add("return fReader;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the next character.",
			"@return the next character",
			"@throws " + IO_EXCEPTION + " in case reading the character fails"
		);
		
		sc.add("protected int nextChar() throws " + IO_EXCEPTION + " {");
		sc.add("fReadFromBuffer= (fBuffer.length() > 0);");
		sc.add("if (fReadFromBuffer) {");
		sc.add("char ch= fBuffer.charAt(fIndex++);");
		sc.add("if (fIndex >= fBuffer.length()) {");
		sc.add("fBuffer.setLength(0);");
		sc.add("fIndex= 0;");
		sc.add("}");
		sc.add("return ch;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("int ch= fCharAfterWhiteSpace;");
		sc.add("if (ch == -1) {");
		sc.add("ch= fReader.read();");
		sc.add("}");
		sc.add("if (fSkipWhiteSpace && Character.isWhitespace((char)ch)) {");
		sc.add("do {");
		sc.add("ch= fReader.read();");
		sc.add("} while (Character.isWhitespace((char)ch));");
		sc.add("if (ch != -1) {");
		sc.add("fCharAfterWhiteSpace= ch;");
		sc.add("return ' ';");
		sc.add("}");
		sc.add("} else {");
		sc.add("fCharAfterWhiteSpace= -1;");
		sc.add("}");
		sc.add("return ch;");
		sc.add("}");
		
		sc.addJavadoc("@see " + READER + "#ready()");
		sc.add("public boolean ready() throws " + IO_EXCEPTION + " {");
		sc.add("return fReader.ready();");
		sc.add("}");
		sc.addLineBreak();
		sc.addLineBreak();
		
		sc.addJavadoc("@see " + READER + "#reset()");
		sc.add("public void reset() throws " + IO_EXCEPTION + " {");
		sc.add("fReader.reset();");
		sc.add("fWasWhiteSpace= true;");
		sc.add("fCharAfterWhiteSpace= -1;");
		sc.add("fBuffer.setLength(0);");
		sc.add("fIndex= 0;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("protected final void setSkipWhitespace(boolean state) {");
		sc.add("fSkipWhiteSpace= state;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the readable content as string.",
			"@return the readable content as string",
			"@throws " + IO_EXCEPTION + " in case reading fails"
		);
		sc.add("public String getString() throws " + IO_EXCEPTION + " {");
		sc.add("StringBuffer buf= new StringBuffer();");
		sc.add("int ch;");
		sc.add("while ((ch= read()) != -1) {");
		sc.add("buf.append((char)ch);");
		sc.add("}");
		sc.add("return buf.toString();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.addLineBreak();
		sc.addLineBreak();
		sc.add("private static final String UNIT;");
		sc.addComment(
			"See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=155993",
			"if the platform is a mac the UNIT is set to \"px\""
		);
		sc.add("static {");
		sc.add("String platform = " + SWT + ".getPlatform();");
		sc.add("UNIT= (platform.equals(\"carbon\")||platform.equals(\"cocoa\")) ? \"px\" : \"pt\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static void addParagraph(StringBuffer buffer, String paragraph) {");
		sc.add("if (paragraph != null) {");
		sc.add("buffer.append(\"<p>\");");
		sc.add("buffer.append(paragraph);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static void insertPageProlog(StringBuffer buffer, int position, String styleSheet) {");
		sc.addLineBreak();
		sc.add("StringBuffer pageProlog= new StringBuffer(300);");
		sc.addLineBreak();
		sc.add("pageProlog.append(\"<html>\");");
		sc.addLineBreak();
		sc.add("if (styleSheet == null)");
		sc.add("return;");
		sc.addLineBreak();
		sc.add("buffer.append(\"<head><style CHARSET=\\\"ISO-8859-1\\\" TYPE=\\\"text/css\\\">\");");
		sc.add("buffer.append(styleSheet);");
		sc.add("buffer.append(\"</style></head><body>\");");
		sc.addLineBreak();
		sc.add("buffer.insert(position,  pageProlog.toString());");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static void addPageEpilog(StringBuffer buffer) {");
		sc.add("buffer.append(\"</body></html>\");");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static void addSmallHeader(StringBuffer buffer, String header) {");
		sc.add("if (header != null) {");
		sc.add("buffer.append(\"<h5>\");");
		sc.add("buffer.append(header);");
		sc.add("buffer.append(\"</h5>\");");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static String convertTopLevelFont(String styles, " + FONT_DATA + " fontData) {");
		sc.add("boolean bold= (fontData.getStyle() & " + SWT + ".BOLD) != 0;");
		sc.add("boolean italic= (fontData.getStyle() & " + SWT + ".ITALIC) != 0;");
		sc.add("String size= Integer.toString(fontData.getHeight()) + UNIT;");
		sc.add("String family= \"'\" + fontData.getName() + \"',sans-serif\";");
		sc.addLineBreak();
		sc.add("styles= styles.replaceFirst(\"(html\\\\s*\\\\{.*(?:\\\\s|;)font-size:\\\\s*)\\\\d+pt(\\\\;?.*\\\\})\", \"$1\" + size + \"$2\");");
		sc.add("styles= styles.replaceFirst(\"(html\\\\s*\\\\{.*(?:\\\\s|;)font-weight:\\\\s*)\\\\w+(\\\\;?.*\\\\})\", \"$1\" + (bold ? \"bold\" : \"normal\") + \"$2\");");
		sc.add("styles= styles.replaceFirst(\"(html\\\\s*\\\\{.*(?:\\\\s|;)font-style:\\\\s*)\\\\w+(\\\\;?.*\\\\})\", \"$1\" + (italic ? \"italic\" : \"normal\") + \"$2\");");
		sc.add("styles= styles.replaceFirst(\"(html\\\\s*\\\\{.*(?:\\\\s|;)font-family:\\\\s*).+?(;.*\\\\})\", \"$1\" + family + \"$2\");");
		sc.add("return styles;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static void insertStyles(StringBuffer buffer, String[] styles) {");
		sc.add("if (styles == null || styles.length == 0)");
		sc.add("return;");
		sc.addLineBreak();
		sc.add("StringBuffer styleBuf= new StringBuffer(10 * styles.length);");
		sc.add("for (int i= 0; i < styles.length; i++) {");
		sc.add("styleBuf.append(\" style=\\\"\");");
		sc.add("styleBuf.append(styles[i]);");
		sc.add("styleBuf.append('\"');");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment(
			"Find insertion index",
			"a) within existing body tag with trailing space"
		);
		sc.add("int index= buffer.indexOf(\"<body \");");
		sc.add("if (index != -1) {");
		sc.add("buffer.insert(index+5, styleBuf);");
		sc.add("return;");
		sc.add("}");
		sc.addLineBreak();
		sc.addComment("b) within existing body tag without attributes");
		sc.add("index= buffer.indexOf(\"<body>\");");
		sc.add("if (index != -1) {");
		sc.add("buffer.insert(index+5, ' ');");
		sc.add("buffer.insert(index+6, styleBuf);");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public static String html2text(" + STRING_READER + " stringReader,");
		sc.add(TEXT_PRESENTATION + " presentation) throws " + IO_EXCEPTION + " {");
		sc.add("HTML2TextReader html2TextReader = new HTML2TextReader(stringReader, presentation);");
		sc.add("return html2TextReader.getString();");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new HTMLPrinterGenerator(parent, context);
	}
}
