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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.BYTE_ARRAY_OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.IO_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.util.GenClassUtil;
import org.emftext.sdk.util.StreamUtil;
import org.emftext.sdk.util.StringUtil;

@SyntaxDependent
public class NewFileContentProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final static GenClassUtil genClassUtil = new GenClassUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addMethods(sc);

		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetMetaInformationMethod(sc);
		addGetNewFileContentMethod(sc);
		addGetExampleContentMethod1(sc);
		addGetExampleContentMethod2(sc);
		addGetPrinterMethod(sc);
	}

	private void addGetPrinterMethod(StringComposite sc) {
		sc.add("public " + iTextPrinterClassName + " getPrinter(" + OUTPUT_STREAM + " outputStream) {");
		sc.add("return getMetaInformation().createPrinter(outputStream, new " + textResourceClassName + "());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMetaInformationMethod(StringComposite sc) {
		sc.add("public " + iMetaInformationClassName + " getMetaInformation() {");
		sc.add("return new " + metaInformationClassName + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNewFileContentMethod(StringComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		List<GenClass> startSymbols = syntax.getActiveStartSymbols();
		sc.add("public String getNewFileContent(String newFileName) {");
		sc.add("return getExampleContent(new " + E_CLASS + "[] {");
		for (GenClass startSymbol : startSymbols) {
			sc.add(genClassUtil.getAccessor(startSymbol) + ",");
		}
		sc.add("}, getMetaInformation().getClassesWithSyntax(), newFileName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetExampleContentMethod2(JavaComposite sc) {
		sc.add("protected String getExampleContent(" + E_CLASS + " eClass, " + E_CLASS + "[] allClassesWithSyntax, String newFileName) {");
		sc.addComment("create a minimal model");
		sc.add(E_OBJECT + " root = new " + minimalModelHelperClassName + "().getMinimalModel(eClass, allClassesWithSyntax, newFileName);");
		sc.add("if (root == null) {");
		sc.addComment("could not create a minimal model. returning an empty document is the best we can do.");
		sc.add("return \"\";");
		sc.add("}");
		sc.addComment("use printer to get text for model");
		sc.add(BYTE_ARRAY_OUTPUT_STREAM + " buffer = new " + BYTE_ARRAY_OUTPUT_STREAM + "();");
		sc.add(iTextPrinterClassName + " printer = getPrinter(buffer);");
		sc.add("try {");
		sc.add("printer.print(root);");
		sc.add("} catch (" + IO_EXCEPTION + " e) {");
		sc.add("new " + runtimeUtilClassName + "().logError(\"Exception while generating example content.\", e);");
		sc.add("}");
		sc.add("return buffer.toString();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetExampleContentMethod1(StringComposite sc) {
		sc.add("protected String getExampleContent(" + E_CLASS + "[] startClasses, " + E_CLASS + "[] allClassesWithSyntax, String newFileName) {");
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		Resource resource = syntax.eResource();
		URI newFileURI = resource.getURI().trimFileExtension().appendFileExtension("newfile").appendFileExtension(syntax.getName());
		String newFileContent = null;
		try {
			InputStream newFileStream = resource.getResourceSet().getURIConverter().createInputStream(newFileURI);
			newFileContent = StreamUtil.getContentAsString(newFileStream);
			// replace platform specific line separators with \n,
			// which will be replaced again by platform specific
			// separators when the new file wizard is called, which
			// may happen on a different platform
			newFileContent = newFileContent.replace("\r\n", "\n");
			newFileContent = newFileContent.replace("\r", "\n");
		} catch (IOException ioe) {
			// do nothing - use the minimal model creator instead
		}
		if (newFileContent != null) {
			sc.add("String content = \"" + StringUtil.escapeToJavaString(newFileContent) + "\".replace(\"\\n\", System.getProperty(\"line.separator\"));");
		} else {
			sc.add("String content = \"\";");
			sc.add("for (" + E_CLASS + " next : startClasses) {");
			sc.add("content = getExampleContent(next, allClassesWithSyntax, newFileName);");
			sc.add("if (content.trim().length() > 0) {");
			sc.add("break;");
			sc.add("}");
			sc.add("}");
		}
		sc.add("return content;");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
