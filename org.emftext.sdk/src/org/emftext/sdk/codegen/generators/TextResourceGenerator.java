package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.IInputStreamProcessorProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.InputStreamProcessor;
import org.emftext.runtime.resource.IReferenceResolverSwitch;
import org.emftext.runtime.resource.ITextParser;
import org.emftext.runtime.resource.ITextPrinter;
import org.emftext.runtime.resource.impl.AbstractTextResource;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaStringComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

/**
 * Generates the resource class. The created <code>doLoad()</code> and 
 * <code>doSave()</code> methods will call the generated parser, analyser 
 * and printer.
 * 
 * @see org.emftext.runtime.resource.ITextResource
 */
public class TextResourceGenerator extends BaseGenerator {

	private static final String RESOLVER_SWITCH_FIELD_NAME = "resolverSwitch";
	
	private String csClassName;
	private String resolverSwitchClassName;
	private String printerClassName;
	private String csSyntaxName;
	
	public TextResourceGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getResourceClassName());
		this.csSyntaxName = context.getConcreteSyntax().getName();
		this.csClassName = context.getCapitalizedConcreteSyntaxName();
		this.resolverSwitchClassName = context.getReferenceResolverSwitchClassName();
		this.printerClassName = context.getPrinterName();
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaStringComposite();
		sc.add("package " + getResourcePackageName() + ";");
        sc.addLineBreak();
        
		sc.add("public class " + getResourceClassName() + " extends " + AbstractTextResource.class.getName() + " {");

		sc.add("private " + IReferenceResolverSwitch.class.getName() + " " + RESOLVER_SWITCH_FIELD_NAME + ";\n");
		
		generateConstructors(sc);
        generateDoLoadMethod(sc);
        generateDoSaveMethod(sc);
        generateGetTokenNamesMethod(sc);
        generateGetSyntaxNameMethod(sc);
        generateGetScannerMethod(sc);
        generateGetReferenceResolverSwitchMethod(sc);
    	generateDoUnLoadMethod(sc);

    	sc.add("}");
    	
    	out.print(sc.toString());
    	return true;
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
        sc.add(ITextPrinter.class.getName() + " p = new " + printerClassName + "(outputStream, this);");
        sc.add("for(" + EObject.class.getName() + " root : getContents()) {");
        sc.add("p.print(root);");
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
        
        sc.add(ITextParser.class.getName() + " parser;");
		sc.add("if (encoding == null) {");
        sc.add("parser = new " + csClassName + "Parser(new " + CommonTokenStream.class.getName() + "(new " + csClassName + "Lexer(new " + ANTLRInputStream.class.getName()+ "(actualInputStream))));");
		sc.add("} else {");
        sc.add("parser = new " + csClassName + "Parser(new " + CommonTokenStream.class.getName() + "(new " + csClassName + "Lexer(new " + ANTLRInputStream.class.getName()+ "(actualInputStream, encoding))));");
		sc.add("}");
        sc.add("parser.setResource(this);");
        sc.add("parser.setOptions(options);");
        sc.add(EObject.class.getName() + " root = parser.parse();");
        sc.add("while (root != null) {");
        sc.add("getContents().add(root);");
        sc.add("root = null;");
        sc.add("}\n");
        sc.add("getReferenceResolverSwitch().setOptions(options);");
        sc.add("}");
        sc.addLineBreak();
	}
}
