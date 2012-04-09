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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.OUTPUT_STREAM;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCE_FACTORY;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

@SyntaxDependent
public class MetaInformationGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	private ConcreteSyntaxUtil csUtil = new ConcreteSyntaxUtil();
	private boolean useScalesParser;
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		useScalesParser = OptionManager.INSTANCE.useScalesParser(getContext().getConcreteSyntax());

        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName() + " implements " + iMetaInformationClassName + " {");
        sc.addLineBreak();
    	addMethods(sc);
        sc.add("}");
	}

	private void addCreateNameProviderMethod(StringComposite sc) {
		sc.add("public " + iNameProviderClassName + " createNameProvider() {");
		sc.add("return new " + defaultNameProviderClassName + "();");
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

	private void addMethods(JavaComposite sc) {
		addGetConcreteSyntaxNameMethod(sc);
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
        addCreateResourceFactoryMethod(sc);
        addGetNewFileContentProviderMethod(sc);
        addRegisterResourceFactoryMethod(sc);
        addGetInputStreamPreprocessorProviderOptionKeyMethod(sc);
        addGetResourcePostProcessorProviderOptionKeyMethod(sc);
        addGetLaunchConfigurationTypeMethod(sc);
        addCreateNameProviderMethod(sc);
        addGetSyntaxHighlightableTokenNamesMethod(sc);
	}

	private void addGetLaunchConfigurationTypeMethod(JavaComposite sc) {
		sc.add("public String getLaunchConfigurationType() {");
		sc.add("return \"" + getContext().getLaunchConfigurationTypeID() + "\";");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRegisterResourceFactoryMethod(JavaComposite sc) {
		final String secondaryConcreteSyntaxName = csUtil.getSecondarySyntaxName(getContext().getConcreteSyntax());
		
		sc.add("public void registerResourceFactory() {");
		if (secondaryConcreteSyntaxName == null) {
			sc.add(RESOURCE_FACTORY + ".Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new " + resourceFactoryClassName + "());");
		} else {
			// if this is a secondary syntax, the ResourceFactory is registered 
			// using the 'additional_extension_parser' extension point. 
			// Unfortunately, we do not know the name of the corresponding 
			// registry because it can be implemented in arbitrary ways in the 
			// base resource plug-in.
			sc.addComment(
				"This is a secondary syntax. " +
				"Registering the resource factory is done via the 'additional_extension_parser' extension point."
			);
		}
		sc.add("}");
		sc.addLineBreak();
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
		sc.add("public " + iTokenStyleClassName + " getDefaultTokenStyle(String tokenName) {");
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
		sc.add("public String[] getTokenNames() {");
		if (useScalesParser) {
			sc.add("return new " + scannerlessParserClassName + "().getTokenNames();");
		} else {
			sc.add("return " + antlrParserClassName + ".tokenNames;");
		}
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetSyntaxHighlightableTokenNamesMethod(JavaComposite sc) {
		sc.add("public String[] getSyntaxHighlightableTokenNames() {");
		sc.add(antlrTokenHelperClassName + " tokenHelper = new " + antlrTokenHelperClassName + "();");
		sc.add(sc.declareArrayList("highlightableTokens", "String"));
        sc.add("String[] parserTokenNames = getTokenNames();");
        sc.add("for (int i = 0; i < parserTokenNames.length; i++) {");
		if (useScalesParser) {
	        sc.add("highlightableTokens.add(parserTokenNames[i]);");
		} else {
			sc.addComment("If ANTLR is used we need to normalize the token names");
			sc.add("if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {");
			sc.add("continue;");
			sc.add("}");
			
			sc.add("String tokenName = tokenHelper.getTokenName(parserTokenNames, i);");
			sc.add("if (tokenName == null) {");
			sc.add("continue;");
			sc.add("}");
	        sc.add("highlightableTokens.add(tokenName);");
		}
        sc.add("}");
        sc.add("highlightableTokens.add(" + tokenStyleInformationProviderClassName + ".TASK_ITEM_TOKEN_NAME);");
        sc.add("return highlightableTokens.toArray(new String[highlightableTokens.size()]);");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetPathTOCSDefinitionMethod(StringComposite sc) {
		sc.add("public String getPathToCSDefinition() {");
        sc.add("return \"" + getContext().getSyntaxProjectName() + "/" + getContext().getProjectRelativePathToSyntaxFile() + "\";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void addGetURIMethod(StringComposite sc) {
		sc.add("public String getURI() {");
		sc.add("return \"" + getContext().getConcreteSyntax().getPackage().getNSURI() + "\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetConcreteSyntaxNameMethod(StringComposite sc) {
		sc.add("public String getSyntaxName() {");
    	sc.add("return \"" + getContext().getConcreteSyntax().getName() + "\";");
    	sc.add("}");
        sc.addLineBreak();
	}

	private void addCreateParserMethod(StringComposite sc) {
		String parserClassName = antlrParserClassName;
	    if (OptionManager.INSTANCE.useScalesParser(getContext().getConcreteSyntax())) {
	    	parserClassName = scannerlessParserClassName;
	    }
		
		sc.add("public " + iTextParserClassName + " createParser(" + INPUT_STREAM + " inputStream, String encoding) {");
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

	private void addGetInputStreamPreprocessorProviderOptionKeyMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the key of the option that can be used to register a preprocessor that " +
			"is used as a pipe when loading resources. This key is language-specific. To " +
			"register one preprocessor for multiple resource types, it must be registered " +
			"individually using all keys."
		);
		sc.add("public String getInputStreamPreprocessorProviderOptionKey() {");
		sc.add("return getSyntaxName() + \"_\" + \"INPUT_STREAM_PREPROCESSOR_PROVIDER\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void addGetResourcePostProcessorProviderOptionKeyMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the key of the option that can be used to register a post-processors that " +
			"are invoked after loading resources. This key is language-specific. To " +
			"register one post-processor for multiple resource types, it must be registered " +
			"individually using all keys."
		);
		sc.add("public String getResourcePostProcessorProviderOptionKey() {");
		sc.add("return getSyntaxName() + \"_\" + \"RESOURCE_POSTPROCESSOR_PROVIDER\";");
		sc.add("}");
        sc.addLineBreak();
	}
}
