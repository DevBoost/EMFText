package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IParseResultGenerator extends BaseGenerator {

	private String iTextResourceClassName;
	private String iCommandClassName;

	public IParseResultGenerator() {
		super();
	}

	private IParseResultGenerator(GenerationContext context) {
		super(context, EArtifact.I_PARSE_RESULT);
		iTextResourceClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_RESOURCE);
		iCommandClassName = getContext().getQualifiedClassName(EArtifact.I_COMMAND);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IParseResultGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// An interface used to access the result of parsing a");
		sc.add("// document.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " getRoot();");
		sc.addLineBreak();
		sc.add("public " + COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> getPostParseCommands();");
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
