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
package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OUTPUT_STREAM;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IMetaInformationGenerator extends JavaBaseGenerator {

	private String iTextScannerClassName;
	private String iTextParserClassName;
	private String iTextPrinterClassName;
	private String iTextResourceClassName;
	private String iReferenceResolverSwitchClassName;
	private String iTokenResolverFactoryClassName;
	private String iTokenStyleClassName;
	private String iBracketPairClassName;
	private String iHoverTextProviderClassName;

	public IMetaInformationGenerator() {
		super();
	}

	private IMetaInformationGenerator(GenerationContext context) {
		super(context, EArtifact.I_META_INFORMATION);
		iTextScannerClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_SCANNER);
		iTextParserClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_PARSER);
		iReferenceResolverSwitchClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVER_SWITCH);
		iTokenResolverFactoryClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_RESOLVER_FACTORY);
		iTokenStyleClassName = getContext().getQualifiedClassName(EArtifact.I_TOKEN_STYLE);
		iBracketPairClassName = getContext().getQualifiedClassName(EArtifact.I_BRACKET_PAIR);
		iHoverTextProviderClassName = getContext().getQualifiedClassName(EArtifact.I_HOVER_TEXT_PROVIDER);
		iTextPrinterClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_PRINTER);
		iTextResourceClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_RESOURCE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IMetaInformationGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// This interface provides information about a generated EMFText");
		sc.add("// text resource plug-in.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();

		sc.add("public String getURI();");
		sc.addLineBreak();
		
		sc.add("// Returns the name of the concrete syntax. This name is used");
		sc.add("// as file extension.");
		sc.add("//");
		sc.add("// @return");
		sc.add("public String getSyntaxName();");
		sc.addLineBreak();
		
		sc.add("// Returns the relative path to the .cs file within the plug-in.");
		sc.add("// @return");
		sc.add("public String getPathToCSDefinition();");
		sc.addLineBreak();
		
		sc.add("// Return a lexer capable to split the underlying text file into tokens.");
		sc.add("//");
		sc.add("// @return a lexer instance.");
		sc.add("public " + iTextScannerClassName + " createLexer();");
		sc.addLineBreak();
		
		sc.add("// Returns an instance of the parser. This factory method");
		sc.add("// is needed, because we can not create ANTLR parsers using");
		sc.add("// the default constructor without arguments, because they");
		sc.add("// expect the input stream or rather a token stream.");
		sc.add("//");
		sc.add("// @param inputStream");
		sc.add("// @param encoding");
		sc.add("// @return");
		sc.add("public " + iTextParserClassName  + " createParser(" + INPUT_STREAM + " inputStream, String encoding);");
		sc.addLineBreak();
		
		sc.add("// Returns a new instance of the printer.");
		sc.add("//");
		sc.add("// @param outputStream the stream to print to");
		sc.add("// @param resource");
		sc.add("// @return");
		sc.add("public " + iTextPrinterClassName  + " createPrinter(" + OUTPUT_STREAM + " ouputStream, " + iTextResourceClassName + " resource);");
		sc.addLineBreak();
		
		sc.add("// Returns all meta classes for which syntax was defined. This");
		sc.add("// information is used both by the NewFileWizard and the code");
		sc.add("// completion.");
		sc.add("public " + E_CLASS + "[] getClassesWithSyntax();");
		sc.addLineBreak();
		
		sc.add("// Returns an instance of the reference resolver switch class.");
		sc.add("public " + iReferenceResolverSwitchClassName + " getReferenceResolverSwitch();");
		sc.addLineBreak();
		
		sc.add("// Returns an instance of the token resolver factory.");
		
		sc.add("public " + iTokenResolverFactoryClassName  + " getTokenResolverFactory();");
		sc.addLineBreak();
		
		sc.add("// Returns a list of all tokens defined in the syntax.");
		sc.add("//");
		sc.add("// @return");
		sc.add("public String[] getTokenNames();");
		sc.addLineBreak();
		
		sc.add("// Return the default style that should be used to present tokens of the");
		sc.add("// given type.");
		sc.add("//");
		sc.add("// @param tokenName the name of the token type");
		sc.add("// @return a style object or null if not default style is set");
		sc.add("public " + iTokenStyleClassName + " getDefaultTokenStyle(String tokenName);");
		sc.addLineBreak();
		
		sc.add("// Returns the default bracket pairs.");
		sc.add("//");
		sc.add("// @return");
		sc.add("public " + COLLECTION + "<" + iBracketPairClassName + "> getBracketPairs();");
		sc.addLineBreak();
		
		sc.add("// Returns all classes for which folding should be enabled");
		sc.add("// in the editor.");
		sc.add("public " + E_CLASS + "[] getFoldableClasses();");
		sc.addLineBreak();
		
		sc.add("// @return a hover text provider which provides the hover text of an <code>EObject</code>");
		sc.add("public " + iHoverTextProviderClassName  + " getHoverTextProvider();");
		sc.add("}");
		return true;
	}
}
