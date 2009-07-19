package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_EMF_TEXT_SCANNER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_TEXT_TOKEN;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ScannerlessScannerGenerator extends BaseGenerator {

	private GenerationContext context;

	public ScannerlessScannerGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getScannerlessScannerClassName());
		this.context = context;
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_EMF_TEXT_SCANNER + " {");
		sc.addLineBreak();
		sc.add("private " + LIST + "<" + I_TEXT_TOKEN + "> tokens;");
		sc.addLineBreak();
		
		sc.add("public " + I_TEXT_TOKEN + " getNextToken() {");
		sc.add("if (tokens == null || tokens.isEmpty()) {");
		sc.add("return null;");
		sc.add("} else {");
		sc.add("return tokens.remove(0);");
		sc.add("}");
		sc.add("}");

		sc.add("public void setText(" + STRING + " text) {");
		String scannerlessParserName = context.getScannerlessParserClassName();
		sc.add(scannerlessParserName + " parser = new " + scannerlessParserName + "(new " + BYTE_ARRAY_INPUT_STREAM + "(text.getBytes()), null);");
		sc.add("parser.setScanMode();");
		sc.add("parser.parse();");
		sc.add("tokens = parser.getTokens();");
		sc.add("}");

		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

}
