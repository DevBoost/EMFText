package org.emftext.sdk.codegen;

import java.io.PrintWriter;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.InputStreamProcessorProvider;
import org.emftext.runtime.resource.EMFTextParser;
import org.emftext.runtime.resource.EMFTextPrinter;
import org.emftext.runtime.resource.EMFTextTreeAnalyser;
import org.emftext.runtime.resource.impl.TextResourceImpl;

/**
 * Generates the resource. Its <code>doLoad()</code> and <code>doSave()</code> methods will
 * call the generated parser, analyser and printer.
 * 
 * @see org.emftext.runtime.resource.TextResource
 * 
 */
public class TextResourceGenerator extends BaseGenerator {

	private String csClassName;
	private String analyserClassName;
	private String printerClassName;
	
	public TextResourceGenerator(String className, String packageName, String csClassName, String printerClassName, String analyserClassName) {
		super(className, packageName);
		this.csClassName = csClassName;
		this.analyserClassName = analyserClassName;
		this.printerClassName = printerClassName;
	}

	@Override
	public boolean generate(PrintWriter out) {
		out.println("package " + super.getResourcePackageName() + ";");
		out.println("import org.eclipse.emf.common.util.URI;"); 
		out.println("import org.eclipse.emf.ecore.EObject;");
		out.println();
        
		out.println("public class " + super.getResourceClassName() + " extends " + TextResourceImpl.class.getName() + " {");

		out.println("\tprivate " + EMFTextTreeAnalyser.class.getName() + " analyser;\n\n");
		
		out.println("\tpublic " + super.getResourceClassName() + "() {");
		out.println("\t\tsuper();");
		out.println("\t}");
		out.println();
        
		out.println("\tpublic " + super.getResourceClassName() + "(URI uri) {");
		out.println("\t\tsuper(uri);");
		out.println("\t}");
        out.println();
		
        out.println("\tprotected void doLoad(java.io.InputStream inputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        out.println("\t\tjava.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);");
        out.println("\t\tjava.io.InputStream actualInputStream = inputStream;");
		out.println("\t\tObject inputStreamPreProcessorProvider = loadOptions.get(" + IOptions.class.getName() + ".INPUT_STREAM_PREPROCESSOR_PROVIDER);");
		out.println("\t\tif (inputStreamPreProcessorProvider != null) {");
		out.println("\t\t\tif (inputStreamPreProcessorProvider instanceof " + InputStreamProcessorProvider.class.getName() + ") {");
		out.println("\t\t\t\tactualInputStream = ((" + InputStreamProcessorProvider.class.getName() + ") inputStreamPreProcessorProvider).getInputStreamProcessor(inputStream);");
		out.println("\t\t\t}");
		out.println("\t\t}");

        out.println("\t\t" + EMFTextParser.class.getName() + " p = new " + csClassName + "Parser(new " + CommonTokenStream.class.getName() + "(new " + csClassName + "Lexer(new " + ANTLRInputStream.class.getName()+ "(actualInputStream))));");
        out.println("\t\tp.setResource(this);");
        out.println("\t\tp.setOptions(loadOptions);");
        out.println("\t\tEObject root = p.parse();");
        out.println("\t\twhile (root != null) {");
        out.println("\t\t\tgetContents().add(root);");
        out.println("\t\t\troot = null;");
        out.println("\t\t}\n");
        out.println("\t\t" + EMFTextTreeAnalyser.class.getName() + " analyser = getTreeAnalyser();\n");
        out.println("\t\tanalyser.setOptions(loadOptions);");
        out.println("\t\tanalyser.analyse(this);");
        out.println("\t}");
        out.println();
        
        out.println("\tprotected void doSave(java.io.OutputStream outputStream, java.util.Map<?,?> options) throws java.io.IOException {");
        out.println("\t\t" + EMFTextPrinter.class.getName() + " p = new " + printerClassName + "(outputStream, this);");
        out.println("\t\tfor(EObject root : getContents()) {");
        out.println("\t\t\tp.print(root);");
        out.println("\t\t}");
        out.println("\t}");
        out.println();
        
        out.println("\tpublic String[] getTokenNames() {");
        out.println("\t\treturn new " + csClassName + "Parser(null).getTokenNames();");
        out.println("\t}");
    	out.println();
        
        out.println("\tpublic Object getScanner() {");
        out.println("\t\treturn new " + csClassName + "Lexer();");
        out.println("\t}");
        out.println();
        
        out.println("\tpublic " + EMFTextTreeAnalyser.class.getName() + " getTreeAnalyser() {");
        out.println("\t\tif (analyser == null) {");
        out.println("\t\t\tanalyser = new " + analyserClassName + "();");
        out.println("\t\t}");
        out.println("\t\treturn analyser;");
        out.println("\t}");

        out.println("}");
    	
    	return true;
    }


}
