package org.emftext.sdk.codegen;

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
		out.println("package " + getResourcePackageName() + ";");
		out.println();
        
		out.println("public class " + getResourceClassName() + " extends " + AbstractTextResource.class.getName() + " {");

		out.println("\tprivate " + IReferenceResolverSwitch.class.getName() + " " + RESOLVER_SWITCH_FIELD_NAME + ";\n\n");
		
		generateConstructors(out);
        generateDoLoadMethod(out);
        generateDoSaveMethod(out);
        generateGetTokenNamesMethod(out);
        generateGetSyntaxNameMethod(out);
        generateGetScannerMethod(out);
        generateGetReferenceResolverSwitchMethod(out);
    	generateDoUnLoadMethod(out);

        out.println("}");
    	return true;
    }

	private void generateGetSyntaxNameMethod(PrintWriter out) {
		out.println("\t@Override");
		out.println("\tprotected String getSyntaxName() {");
		out.println("\t\treturn \"" + csSyntaxName + "\";");
		out.println("\t}");
		out.println();
	}

	private void generateDoUnLoadMethod(PrintWriter out) {
		out.println("\tprotected void doUnload(){");
    	out.println("\t\tsuper.doUnload();");
    	out.println("\t\t" + RESOLVER_SWITCH_FIELD_NAME + " = null;");
    	out.println("\t}");
	}

	private void generateGetReferenceResolverSwitchMethod(PrintWriter out) {
		out.println("\tpublic " + IReferenceResolverSwitch.class.getName() + " getReferenceResolverSwitch() {");
        out.println("\t\tif (" + RESOLVER_SWITCH_FIELD_NAME + " == null) {");
        out.println("\t\t\t" + RESOLVER_SWITCH_FIELD_NAME + " = new " + resolverSwitchClassName + "();");
        out.println("\t\t}");
        out.println("\t\treturn " + RESOLVER_SWITCH_FIELD_NAME + ";");
        out.println("\t}");
        out.println();
	}

	private void generateGetScannerMethod(PrintWriter out) {
		out.println("\tpublic Object getScanner() {");
        out.println("\t\treturn new " + csClassName + "Lexer();");
        out.println("\t}");
        out.println();
	}

	private void generateGetTokenNamesMethod(PrintWriter out) {
		out.println("\tpublic String[] getTokenNames() {");
        out.println("\t\treturn new " + csClassName + "Parser(null).getTokenNames();");
        out.println("\t}");
    	out.println();
	}

	private void generateDoSaveMethod(PrintWriter out) {
		out.println("\tprotected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        out.println("\t\t" + ITextPrinter.class.getName() + " p = new " + printerClassName + "(outputStream, this);");
        out.println("\t\tfor(" + EObject.class.getName() + " root : getContents()) {");
        out.println("\t\t\tp.print(root);");
        out.println("\t\t}");
        out.println("\t}");
        out.println();
	}

	private void generateConstructors(PrintWriter out) {
		out.println("\tpublic " + getResourceClassName() + "() {");
		out.println("\t\tsuper();");
		out.println("\t}");
		out.println();
        
		out.println("\tpublic " + getResourceClassName() + "(" + org.eclipse.emf.common.util.URI.class.getName() + " uri) {");
		out.println("\t\tsuper(uri);");
		out.println("\t}");
        out.println();
	}

	private void generateDoLoadMethod(PrintWriter out) {
		out.println("\tprotected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        //out.println("\t\tjava.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);");
        out.println("\t\tjava.lang.String encoding = null;");
        out.println("\t\tjava.io.InputStream actualInputStream = inputStream;");
		out.println("\t\tjava.lang.Object inputStreamPreProcessorProvider = options.get(" + IOptions.class.getName() + ".INPUT_STREAM_PREPROCESSOR_PROVIDER);");
		out.println("\t\tif (inputStreamPreProcessorProvider != null) {");
		out.println("\t\t\tif (inputStreamPreProcessorProvider instanceof " + IInputStreamProcessorProvider.class.getName() + ") {");
		out.println("\t\t\t\t" + IInputStreamProcessorProvider.class.getName() + " provider = (" + IInputStreamProcessorProvider.class.getName() + ") inputStreamPreProcessorProvider;");
		out.println("\t\t\t\t" + InputStreamProcessor.class.getName() + " processor = provider.getInputStreamProcessor(inputStream);");
		out.println("\t\t\t\tactualInputStream = processor;");
		out.println("\t\t\t\tencoding = processor.getOutputEncoding();");
		out.println("\t\t\t}");
		out.println("\t\t}");
		out.println();
        out.println("\t\t" + ITextParser.class.getName() + " parser;");
		out.println("\t\tif (encoding == null) {");
        out.println("\t\t\tparser = new " + csClassName + "Parser(new " + CommonTokenStream.class.getName() + "(new " + csClassName + "Lexer(new " + ANTLRInputStream.class.getName()+ "(actualInputStream))));");
		out.println("\t\t} else {");
        out.println("\t\t\tparser = new " + csClassName + "Parser(new " + CommonTokenStream.class.getName() + "(new " + csClassName + "Lexer(new " + ANTLRInputStream.class.getName()+ "(actualInputStream, encoding))));");
		out.println("\t\t}");
        out.println("\t\tparser.setResource(this);");
        out.println("\t\tparser.setOptions(options);");
        out.println("\t\t" + EObject.class.getName() + " root = parser.parse();");
        out.println("\t\twhile (root != null) {");
        out.println("\t\t\tgetContents().add(root);");
        out.println("\t\t\troot = null;");
        out.println("\t\t}\n");
        out.println("\t\tgetReferenceResolverSwitch().setOptions(options);");
        out.println("\t}");
        out.println();
	}
}
