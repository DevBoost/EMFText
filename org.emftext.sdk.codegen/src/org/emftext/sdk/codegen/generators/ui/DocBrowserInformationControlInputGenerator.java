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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class DocBrowserInformationControlInputGenerator extends JavaBaseGenerator<Object> {

	public DocBrowserInformationControlInputGenerator() {
		super();
	}

	private DocBrowserInformationControlInputGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.DOC_BROWSER_INFORMATION_CONTROL_INPUT);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"Provides input for the <code>TextHover</code>. The most is copied from " +
			"<code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocBrowserInformationControlInput</code>."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();

		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		
		sc.add("}");
		return true;
	}

	private void addMethods(JavaComposite sc) {
		addGetPreviousMethod(sc);
		addGetNextMethod(sc);
		addResourceMethod(sc);
		addGetHtmlMethod(sc);
		addToStringMethod(sc);
		addGetTokenTextMethod(sc);
		addGetInputElementMethod(sc);
		addGetInputNameMethod(sc);
		addGetLeadingImageWidthMethod(sc);
	}

	private void addGetLeadingImageWidthMethod(StringComposite sc) {
		sc.add("public int getLeadingImageWidth() {");
		sc.add("return 0;");
		sc.add("}");
	}

	private void addGetInputNameMethod(StringComposite sc) {
		sc.add("public String getInputName() {");
		sc.add("return element == null ? \"\" : element.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetInputElementMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " getInputElement() {");
		sc.add("return element == null ? (" + OBJECT + ") htmlContent : element;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenTextMethod(JavaComposite sc) {
		sc.addJavadoc("@return the token text, it is needed for a hyperlink where the caret has to jump to");
		sc.add("public String getTokenText() {");
		sc.add("return tokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(StringComposite sc) {
		sc.add("public String toString() {");
		sc.add("return getHtml();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHtmlMethod(StringComposite sc) {
		sc.add("public String getHtml() {");
		sc.add("return htmlContent;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addResourceMethod(JavaComposite sc) {
		sc.addJavadoc("@return the resource");
		sc.add("public " + RESOURCE + " getResource() {");
		sc.add("return resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNextMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the next input or <code>null</code> if this is the last.",
			"@return the next input or <code>null</code>"
		);
		sc.add("public " + getResourceClassName() + " getNext() {");
		sc.add("return fNext;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPreviousMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the previous input or <code>null</code> if this is the first.",
			"@return the previous input or <code>null</code>"
		);
		sc.add("public " + getResourceClassName() + " getPrevious() {");
		sc.add("return fPrevious;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.addJavadoc(
			"Creates a new browser information control input.",
			"@param previous previous input, or <code>null</code> if none available",
			"@param element the element, or <code>null</code> if none available",
			"@param htmlContent HTML contents, must not be null",
			"@param leadingImageWidth the indent required for the element image"
		);
		sc.add("public " + getResourceClassName() + "(" + getResourceClassName() + " previous, " + E_OBJECT + " element, " + RESOURCE + " resource, String htmlContent, String tokenText) {");
		sc.add("fPrevious= previous;");
		sc.add("if (previous != null) {");
		sc.add("previous.fNext= this;");
		sc.add("}");
		sc.add("assert htmlContent != null;");
		sc.add("this.element = element;");
		sc.add("this.htmlContent = htmlContent;");
		sc.add("this.tokenText = tokenText;");
		sc.add("this.resource = resource;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private final " + getResourceClassName() + " fPrevious;");
		sc.add("private " + getResourceClassName() + " fNext;");
		sc.add("private final " + E_OBJECT + " element;");
		sc.add("private final String htmlContent;");
		sc.add("private final String tokenText;");
		sc.add("private final " + RESOURCE + " resource;");
		sc.addLineBreak();
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new DocBrowserInformationControlInputGenerator(context);
	}
}
