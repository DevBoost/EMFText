package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.IO_EXCEPTION;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class ITextPrinterGenerator extends BaseGenerator {

	private String iConfigurableClassName;

	public ITextPrinterGenerator() {
		super();
	}

	private ITextPrinterGenerator(GenerationContext context) {
		super(context, EArtifact.I_TEXT_PRINTER);
		iConfigurableClassName = getContext().getQualifiedClassName(EArtifact.I_CONFIGURABLE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextPrinterGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Converts a tree of <code>" + E_OBJECT + "</code>s into a plain text.");
		sc.add("public interface " + getResourceClassName() + " extends " + iConfigurableClassName + " {");
		sc.addLineBreak();
		
		sc.add("// Prints the given <code>" + E_OBJECT + "</code> and its content to some");
		sc.add("// underlying output stream.");
		sc.add("//");
		sc.add("// @param element The element to print.");
		sc.add("// @throws " + IO_EXCEPTION + " if printing to an underlying stream or device fails.");
		sc.add("public void print(" + E_OBJECT + " element) throws " + IO_EXCEPTION + ";");
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
