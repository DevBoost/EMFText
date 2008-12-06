package org.emftext.sdk.codegen;

import java.io.PrintWriter;

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
    	out.println("import java.io.IOException;");
		out.println("import java.io.InputStream;");
		out.println("import java.io.OutputStream;");
		out.println("import java.util.Map;");
		
        out.println("import org.antlr.runtime.ANTLRInputStream;");
        out.println("import org.antlr.runtime.CommonTokenStream;");

		out.println("import org.eclipse.emf.common.util.URI;"); 
		out.println("import org.eclipse.emf.ecore.EObject;");
		
		out.println("import org.reuseware.emftextedit.runtime.resource.*;");
		out.println("import org.reuseware.emftextedit.runtime.resource.impl.*;");
		out.println();
        
		out.println("public class " + super.getResourceClassName() + " extends TextResourceImpl {");

		out.println("\tprivate EMFTextTreeAnalyser analyser;\n\n");
		
		out.println("\tpublic " + super.getResourceClassName() + "(){");
		out.println("\t\tsuper();");
		out.println("\t}");
		out.println();
        
		out.println("\tpublic " + super.getResourceClassName() + "(URI uri){");
		out.println("\t\tsuper(uri);");
		out.println("\t}");
        out.println();
		
        out.println("\tprotected void doLoad(InputStream inputStream, Map<?,?> options) throws IOException {");
        out.println("\t\tjava.util.Map<Object, Object> loadOptions = addDefaultLoadOptions(options);");
        out.println("\t\tEMFTextParser p = new " + csClassName + "Parser(new CommonTokenStream(new " + csClassName + "Lexer(new ANTLRInputStream(inputStream))));");
        out.println("\t\tp.setResource(this);");
        out.println("\t\tp.setOptions(loadOptions);");
        out.println("\t\tEObject root = p.parse();");
        out.println("\t\twhile (root != null) {");
        out.println("\t\t\tgetContents().add(root);");
        out.println("\t\t\troot = null; //p.parse();");
        out.println("\t\t}\n");
        out.println("\t\tEMFTextTreeAnalyser analyser = getTreeAnalyser();\n");
        out.println("\t\tanalyser.setOptions(loadOptions);");
        out.println("\t\tanalyser.analyse(this);");
        out.println("\t}");
        out.println();
        
        out.println("\tprotected void doSave(OutputStream outputStream, Map<?,?> options) throws IOException {");
        out.println("\t\tEMFTextPrinter p = new " + printerClassName + "(outputStream, this);");
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
        
        out.println("\tpublic EMFTextTreeAnalyser getTreeAnalyser() {");
        out.println("\t\tif (analyser == null) {");
        out.println("\t\t\tanalyser = new " + analyserClassName + "();");
        out.println("\t\t}");
        out.println("\t\treturn analyser;");
        out.println("\t}");

        out.println("}");
    	
    	return true;
    }


}
