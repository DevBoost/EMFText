/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.IInputStreamProcessorProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.InputStreamProcessor;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.ITokenStyle;
import org.emftext.runtime.resource.impl.AbstractTextResource;
import org.emftext.runtime.resource.impl.BasicTokenStyle;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.FontStyle;
import org.emftext.sdk.concretesyntax.TokenStyle;

/**
 * Generates the resource class. The created <code>doLoad()</code> and 
 * <code>doSave()</code> methods will call the generated parser and 
 * printer.
 * 
 * @see org.emftext.runtime.resource.ITextResource
 */
public class TextResourceGenerator extends BaseGenerator {

	private static final String RESOLVER_SWITCH_FIELD_NAME = "resolverSwitch";
	
	private ConcreteSyntax concreteSyntax;
	private String csClassName;
	private String resolverSwitchClassName;
	private String printerClassName;
	private String parserClassName;
	private String csSyntaxName;
	
	public TextResourceGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getResourceClassName());
		this.concreteSyntax = context.getConcreteSyntax();
		this.csSyntaxName = concreteSyntax.getName();
		this.csClassName = context.getCapitalizedConcreteSyntaxName();
		this.resolverSwitchClassName = context.getQualifiedReferenceResolverSwitchClassName();
		this.printerClassName = context.getQualifiedPrinterName();
		this.parserClassName = context.getQualifiedParserClassName();
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + " extends " + AbstractTextResource.class.getName() + " {");

		sc.addLineBreak();
		sc.add("private " + IReferenceResolverSwitch.class.getName() + " " + RESOLVER_SWITCH_FIELD_NAME + ";");
		sc.addLineBreak();
		
		generateConstructors(sc);
        generateDoLoadMethod(sc);
        generateDoSaveMethod(sc);
        generateGetTokenNamesMethod(sc);
        generateGetSyntaxNameMethod(sc);
        generateGetScannerMethod(sc);
        generateGetReferenceResolverSwitchMethod(sc);
    	generateDoUnLoadMethod(sc);
    	generateGetDefaultStyleMethod(sc);

    	sc.add("}");
    	
    	out.print(sc.toString());
    	return true;
    }

	private void generateGetDefaultStyleMethod(StringComposite sc) {
		// TODO mseifert: implement code generation here
		List<TokenStyle> styles = concreteSyntax.getTokenStyles();
		
		sc.add("public " + ITokenStyle.class.getName() + " getDefaultTokenStyle(java.lang.String tokenName) {");
		for (TokenStyle nextStyle : styles) {
			String name = nextStyle.getTokenName();
			sc.add("if (\"" + name + "\".equals(tokenName)) {");
			String rgb = nextStyle.getRgb();
			String color = "new int[] {0x" + rgb.substring(0, 2)+ ", 0x" + rgb.substring(2, 4) + ", 0x" + rgb.substring(4, 6) + "}";
			String bold = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.BOLD));
			String italic = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.ITALIC));
			String strikethrough = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.STRIKETHROUGH));
			String underline = Boolean.toString(nextStyle.getFontStyles().contains(FontStyle.UNDERLINE));
			sc.add("return new " + BasicTokenStyle.class.getName() + "(" + color + ", " + bold + ", " + italic + ", " + strikethrough + ", " + underline + ");");
			sc.add("}");
		}
		sc.add("return null;");
		sc.add("}");
        sc.addLineBreak();
	}

	private void generateGetSyntaxNameMethod(StringComposite sc) {
		sc.add("@Override ");
		sc.add("protected String getSyntaxName() {");
		sc.add("return \"" + csSyntaxName + "\";");
		sc.add("}");
        sc.addLineBreak();
	}

	private void generateDoUnLoadMethod(StringComposite sc) {
		sc.add("protected void doUnload(){");
    	sc.add("super.doUnload();");
    	sc.add(RESOLVER_SWITCH_FIELD_NAME + " = null;");
    	sc.add("}");
	}

	private void generateGetReferenceResolverSwitchMethod(StringComposite sc) {
		sc.add("public " + IReferenceResolverSwitch.class.getName() + " getReferenceResolverSwitch() {");
        sc.add("if (" + RESOLVER_SWITCH_FIELD_NAME + " == null) {");
        sc.add(RESOLVER_SWITCH_FIELD_NAME + " = new " + resolverSwitchClassName + "();");
        sc.add("}");
        sc.add("return " + RESOLVER_SWITCH_FIELD_NAME + ";");
        sc.add("}");
        sc.addLineBreak();
	}

	private void generateGetScannerMethod(StringComposite sc) {
		sc.add("public Object getScanner() {");
        sc.add("return new " + csClassName + "Lexer();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void generateGetTokenNamesMethod(StringComposite sc) {
		sc.add("public String[] getTokenNames() {");
        sc.add("return new " + csClassName + "Parser(null).getTokenNames();");
        sc.add("}");
        sc.addLineBreak();
	}

	private void generateDoSaveMethod(StringComposite sc) {
		sc.add("protected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        sc.add(printerClassName + " printer = new " + printerClassName + "(outputStream, this);");
        sc.add(IReferenceResolverSwitch.class.getName() + " referenceResolverSwitch = getReferenceResolverSwitch();");
        sc.add("referenceResolverSwitch.setOptions(options);");
        sc.add("printer.setReferenceResolverSwitch((" + resolverSwitchClassName + ") referenceResolverSwitch);");
        sc.add("for(" + EObject.class.getName() + " root : getContents()) {");
        sc.add("printer.print(root);");
        sc.add("}");
        sc.add("}");
        sc.addLineBreak();
	}

	private void generateConstructors(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
        sc.addLineBreak();
        
		sc.add("public " + getResourceClassName() + "(" + org.eclipse.emf.common.util.URI.class.getName() + " uri) {");
		sc.add("super(uri);");
		sc.add("}");
        sc.addLineBreak();
	}

	private void generateDoLoadMethod(StringComposite sc) {
		sc.add("protected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        sc.add("resetLocationMap();");
        sc.add("java.lang.String encoding = null;");
        sc.add("java.io.InputStream actualInputStream = inputStream;");
        sc.add("java.lang.Object inputStreamPreProcessorProvider = null;");
        sc.add("if (options!=null) {");
		sc.add("inputStreamPreProcessorProvider = options.get(" + IOptions.class.getName() + ".INPUT_STREAM_PREPROCESSOR_PROVIDER);");
		sc.add("}");
		sc.add("if (inputStreamPreProcessorProvider != null) {");
		sc.add("if (inputStreamPreProcessorProvider instanceof " + IInputStreamProcessorProvider.class.getName() + ") {");
		sc.add(IInputStreamProcessorProvider.class.getName() + " provider = (" + IInputStreamProcessorProvider.class.getName() + ") inputStreamPreProcessorProvider;");
		sc.add(InputStreamProcessor.class.getName() + " processor = provider.getInputStreamProcessor(inputStream);");
		sc.add("actualInputStream = processor;");
		sc.add("encoding = processor.getOutputEncoding();");
		sc.add("}");
		sc.add("}");
        sc.addLineBreak();
        
        sc.add(parserClassName + " parser;");
		sc.add("if (encoding == null) {");
        sc.add("parser = new " + csClassName + "Parser(new " + CommonTokenStream.class.getName() + "(new " + csClassName + "Lexer(new " + ANTLRInputStream.class.getName()+ "(actualInputStream))));");
		sc.add("} else {");
        sc.add("parser = new " + csClassName + "Parser(new " + CommonTokenStream.class.getName() + "(new " + csClassName + "Lexer(new " + ANTLRInputStream.class.getName()+ "(actualInputStream, encoding))));");
		sc.add("}");
        sc.add("parser.setResource(this);");
        sc.add("parser.setOptions(options);");
        sc.add(IReferenceResolverSwitch.class.getName() + " referenceResolverSwitch = getReferenceResolverSwitch();");
        sc.add("referenceResolverSwitch.setOptions(options);");
        sc.add("parser.setReferenceResolverSwitch((" + resolverSwitchClassName + ") referenceResolverSwitch);");
        sc.add(EObject.class.getName() + " root = parser.parse();");
        sc.add("if (root != null) {");
        sc.add("getContents().add(root);");
        sc.add("}");
        sc.add("getReferenceResolverSwitch().setOptions(options);");
        sc.add("runPostProcessors(options);");
        sc.add("}");
        sc.addLineBreak();
	}
}
