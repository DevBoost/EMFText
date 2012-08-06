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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IMetaInformationGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("This interface provides information about a generated EMFText text resource plug-in.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();

		sc.add("public String getURI();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the name of the concrete syntax. This name is used as file extension.",
			"@return the file extension"
		);
		sc.add("public String getSyntaxName();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the relative path to the .cs file within the plug-in.",
			"@return relative path to the .cs specification"
		);
		sc.add("public String getPathToCSDefinition();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns a lexer capable to split the underlying text file into tokens.",
			"@return a new instance of the lexer class."
		);
		sc.add("public " + iTextScannerClassName + " createLexer();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns an instance of the parser. This factory method " +
			"is needed, because we can not create ANTLR parsers using " +
			"the default constructor without arguments, because this constructor " + 
			"does expect the input stream or rather a token stream as arguments. "+
			"Furthermore, the parser implementation can be exchanged by returning " +
			"other parsers in this factory method.",
			"@param inputStream the stream to read from",
			"@param encoding the encoding of the input stream, pass null to use platform default encoding",
			"@return a new instance of the parser class"
		);
		sc.add("public " + iTextParserClassName  + " createParser(" + INPUT_STREAM + " inputStream, String encoding);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns a new instance of the printer.",
			"@param outputStream the stream to print to",
			"@param resource that contains the elements that will be printed",
			"@return a new instance of the printer class"
		);
		sc.add("public " + iTextPrinterClassName  + " createPrinter(" + OUTPUT_STREAM + " outputStream, " + iTextResourceClassName + " resource);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns all meta classes for which syntax was defined. This " +
			"information is used both by the NewFileWizard and the code " +
			"completion."
		);
		sc.add("public " + E_CLASS + "[] getClassesWithSyntax();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns an instance of the reference resolver switch class.");
		sc.add("public " + iReferenceResolverSwitchClassName + " getReferenceResolverSwitch();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns an instance of the token resolver factory.");
		sc.add("public " + iTokenResolverFactoryClassName  + " getTokenResolverFactory();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns a list of the names of all tokens defined in the syntax.");
		sc.add("public String[] getTokenNames();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns the default style that should be used to present tokens of the " +
			"given type.",
			"@param tokenName the name of the token type",
			"@return a style object or null if no default style is set"
		);
		sc.add("public " + iTokenStyleClassName + " getDefaultTokenStyle(String tokenName);");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the default bracket pairs.");
		sc.add("public " + COLLECTION + "<" + iBracketPairClassName + "> getBracketPairs();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns all classes for which folding must be enabled in the editor.");
		sc.add("public " + E_CLASS + "[] getFoldableClasses();");
		sc.addLineBreak();

		sc.add("}");
	}
}
