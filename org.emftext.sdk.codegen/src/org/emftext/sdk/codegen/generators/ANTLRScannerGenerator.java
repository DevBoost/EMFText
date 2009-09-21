package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ANTLR_STRING_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LEXER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.TOKEN;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ANTLRScannerGenerator extends BaseGenerator {

	public ANTLRScannerGenerator() {
		super();
	}
	
	private ANTLRScannerGenerator(GenerationContext context) {
		super(context, EArtifact.ANTLR_SCANNER);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " implements " + getClassNameHelper().getI_TEXT_SCANNER() + " {");
		sc.addLineBreak();

		sc.add("private " + LEXER + " antlrLexer;");
		sc.addLineBreak();

		sc.add("public " + getResourceClassName() + "(" + LEXER + " antlrLexer) {");
		sc.add("this.antlrLexer = antlrLexer;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public " + getClassNameHelper().getI_TEXT_TOKEN() + " getNextToken() {");
		sc.add("if (antlrLexer.getCharStream() == null) {");
		sc.add("return null;");
		sc.add("}");
        sc.add("final " + TOKEN + " current = antlrLexer.nextToken();");
		sc.add(getClassNameHelper().getI_TEXT_TOKEN() + " result = new " + getClassNameHelper().getTEXT_TOKEN() + "(current);");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void setText(" + STRING + " text) {");
		sc.add("antlrLexer.setCharStream(new " + ANTLR_STRING_STREAM + "(text));");
		sc.add("}");
		sc.addLineBreak();
		sc.add("}");
		out.write(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ANTLRScannerGenerator(context);
	}
}
