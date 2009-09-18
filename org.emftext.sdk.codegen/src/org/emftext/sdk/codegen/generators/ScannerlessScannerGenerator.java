package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BYTE_ARRAY_INPUT_STREAM;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class ScannerlessScannerGenerator extends BaseGenerator {

	public ScannerlessScannerGenerator() {
		super();
	}

	private ScannerlessScannerGenerator(GenerationContext context) {
		super(context, EArtifact.SCANNERLESS_SCANNER);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + getClassNameHelper().getABSTRACT_EMF_TEXT_SCANNER() + " {");
		sc.addLineBreak();
		sc.add("private " + LIST + "<" + getClassNameHelper().getI_TEXT_TOKEN() + "> tokens;");
		sc.addLineBreak();
		
		sc.add("public " + getClassNameHelper().getI_TEXT_TOKEN() + " getNextToken() {");
		sc.add("if (tokens == null || tokens.isEmpty()) {");
		sc.add("return null;");
		sc.add("} else {");
		sc.add("return tokens.remove(0);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();

		sc.add("public void setText(" + STRING + " text) {");
		String scannerlessParserName = getContext().getClassName(EArtifact.SCANNERLESS_PARSER);
		sc.add(scannerlessParserName + " parser = new " + scannerlessParserName + "(new " + BYTE_ARRAY_INPUT_STREAM + "(text.getBytes()), null);");
		sc.add("parser.setScanMode();");
		sc.add("parser.parse();");
		sc.add("tokens = parser.getTokens();");
		sc.add("}");

		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ScannerlessScannerGenerator(context);
	}

}
