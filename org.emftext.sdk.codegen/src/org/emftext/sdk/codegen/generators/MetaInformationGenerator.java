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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.RESOURCE_FACTORY;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class MetaInformationGenerator extends JavaBaseGenerator {

	public MetaInformationGenerator() {
		super();
	}

	private MetaInformationGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.META_INFORMATION);
	}
	
	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName() + " implements " + iMetaInformationClassName + " {");
        sc.addLineBreak();
    	addMethods(sc);
        sc.add("}");
    	
    	return true;	
	}

	private void addCreateTokenScannerMethod(StringComposite sc) {
		sc.add("public " + tokenScannerClassName + " createTokenScanner(" + colorManagerClassName + " colorManager) {");
		sc.add("return new " + tokenScannerClassName + "(colorManager);");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateResourceFactoryMethod(StringComposite sc) {
		sc.add("public " + RESOURCE_FACTORY + " createResourceFactory() {");
		sc.add("return new " + resourceFactoryClassName + "();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetNewFileContentProviderMethod(StringComposite sc) {
		sc.add("public " + newFileContentProviderClassName + " getNewFileContentProvider() {");
		sc.add("return new " + newFileContentProviderClassName + "();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateColorManagerMethod(StringComposite sc) {
		sc.add("public " + colorManagerClassName + " createColorManager() {");
        sc.add("return new " + colorManagerClassName + "();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateCodeCompletionHelperMethod(StringComposite sc) {
		sc.add("public " + codeCompletionHelperClassName + " createCodeCompletionHelper() {");
        sc.add("return new " + codeCompletionHelperClassName + "();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addMethods(StringComposite sc) {
		addGetConcreteSyntaxName(sc);
    	addGetURIMethod(sc);
    	addCreateLexerMethod(sc);
		addCreateParserMethod(sc);
		addCreatePrinterMethod(sc);
		addGetClassesWithSyntaxMethod(sc);
		addGetStartSymbolsMethod(sc);
        addGetReferenceResolverSwitchMethod(sc);
        addGetTokenResolverFactoryMethod(sc);
        addGetPathTOCSDefinitionMethod(sc);
        addGetTokenNamesMethod(sc);
        addGetDefaultStyleMethod(sc);
        addGetBracketPairsMethod(sc);
        addGetFoldableClassesMethod(sc);
    	addGetHoverTextProviderMethod(sc);
		addCreateColorManagerMethod(sc);
        addCreateTokenScannerMethod(sc);
        addCreateResourceFactoryMethod(sc);
        addGetNewFileContentProviderMethod(sc);
        addCreateCodeCompletionHelperMethod(sc);
	}

	private void addGetStartSymbolsMethod(StringComposite sc) {
		sc.add("public " + E_CLASS + "[] getStartSymbols() {");
		sc.add("return new " + syntaxCoverageInformationProviderClassName + "().getStartSymbols();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFoldableClassesMethod(StringComposite sc) {
		sc.add("public " + E_CLASS + "[] getFoldableClasses() {");
		sc.add("return new " + foldingInformationProviderClassName + "().getFoldableClasses();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetBracketPairsMethod(StringComposite sc) {
		sc.add("public " + COLLECTION + "<" + iBracketPairClassName + "> getBracketPairs() {");
		sc.add("return new " + bracketInformationProviderClassName + "().getBracketPairs();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDefaultStyleMethod(StringComposite sc) {
		sc.add("public " + iTokenStyleClassName + " getDefaultTokenStyle(" + STRING + " tokenName) {");
		sc.add("return new " + tokenStyleInformationProviderClassName + "().getDefaultTokenStyle(tokenName);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetClassesWithSyntaxMethod(StringComposite sc) {
		sc.add("public " + E_CLASS + "[] getClassesWithSyntax() {");
		sc.add("return new " + syntaxCoverageInformationProviderClassName + "().getClassesWithSyntax();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHoverTextProviderMethod(StringComposite sc) {
		sc.add("public " + iHoverTextProviderClassName + " getHoverTextProvider() {");
		sc.add("return new " + hoverTextProviderClassName + "();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateLexerMethod(StringComposite sc) {
		sc.add("public " + iTextScannerClassName+ " createLexer() {");
		if (OptionManager.INSTANCE.useScalesParser(getContext().getConcreteSyntax())) {
			sc.add("return new " + scannerlessScannerClassName + "();");
		} else {
			sc.add("return new " + antlrScannerClassName + "(new " + antlrLexerClassName + "());");
		}
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetTokenNamesMethod(StringComposite sc) {
		sc.add("public " + STRING +"[] getTokenNames() {");
		if (OptionManager.INSTANCE.useScalesParser(getContext().getConcreteSyntax())) {
			sc.add("return new " + scannerlessParserClassName + "().getTokenNames();");
		} else {
			sc.add("return new " + antlrParserClassName + "(null).getTokenNames();");
		}
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetPathTOCSDefinitionMethod(StringComposite sc) {
		sc.add("public " + STRING +" getPathToCSDefinition() {");
        sc.add("return \"" + getContext().getSyntaxProjectName() + "/" + getContext().getProjectRelativePathToSyntaxFile() + "\";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetURIMethod(StringComposite sc) {
		sc.add("public " + STRING +" getURI() {");
		sc.add("return \"" + getContext().getConcreteSyntax().getPackage().getNSURI() + "\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetConcreteSyntaxName(StringComposite sc) {
		sc.add("public " + STRING +" getSyntaxName() {");
    	sc.add("return \"" + getContext().getConcreteSyntax().getName() + "\";");
    	sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateParserMethod(StringComposite sc) {
		String parserClassName = antlrParserClassName;
	    if (OptionManager.INSTANCE.useScalesParser(getContext().getConcreteSyntax())) {
	    	parserClassName = scannerlessParserClassName;
	    }
		
		sc.add("public " + iTextParserClassName + " createParser(" + INPUT_STREAM + " inputStream, " + STRING + " encoding) {");
		sc.add("return new " + parserClassName + "().createInstance(inputStream, encoding);");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addCreatePrinterMethod(StringComposite sc) {
		String usedPrinterClassName;
		boolean useClassicPrinter = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.USE_CLASSIC_PRINTER);

		sc.add("public " + iTextPrinterClassName + " createPrinter(" + OUTPUT_STREAM + " outputStream, " + iTextResourceClassName + " resource) {");
		if (useClassicPrinter) {
			usedPrinterClassName = printerClassName;
		} else {
			usedPrinterClassName = printer2ClassName;
		}
		sc.add("return new " + usedPrinterClassName + "(outputStream, resource);");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("public " + iReferenceResolverSwitchClassName + " getReferenceResolverSwitch() {");
		sc.add("return new " + referenceResolverSwitchClassName + "();");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetTokenResolverFactoryMethod(StringComposite sc) {
		sc.add("public " + iTokenResolverFactoryClassName + " getTokenResolverFactory() {");
		sc.add("return new " + tokenResolverFactoryClassName + "();");
		sc.add("}");
        sc.addLineBreak();
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new MetaInformationGenerator(context);
	}
}
