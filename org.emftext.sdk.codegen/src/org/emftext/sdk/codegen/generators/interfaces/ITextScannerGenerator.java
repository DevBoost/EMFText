package org.emftext.sdk.codegen.generators.interfaces;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ITextScannerGenerator extends BaseGenerator {

	private String iTextTokenClassName;

	public ITextScannerGenerator() {
		super();
	}

	private ITextScannerGenerator(GenerationContext context) {
		super(context, EArtifact.I_TEXT_SCANNER);
		iTextTokenClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_TOKEN);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextScannerGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A common interface for scanners to be used by EMFText.");
		sc.add("// A scanner is initialized with a text and delivers a");
		sc.add("// sequence of tokens.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Sets the text that must be scanned.");
		sc.add("public void setText(String text);");
		sc.addLineBreak();
		
		sc.add("// Returns the next token found in the text.");
		sc.add("public " + iTextTokenClassName + " getNextToken();");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
