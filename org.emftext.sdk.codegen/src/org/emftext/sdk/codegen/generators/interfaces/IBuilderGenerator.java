package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.GenerationContext;
import java.io.PrintWriter;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.IGenerator;

public class IBuilderGenerator extends BaseGenerator {

	private String textResourceClassName;

	public IBuilderGenerator() {
		super();
	}

	private IBuilderGenerator(GenerationContext context) {
		super(context, EArtifact.I_BUILDER);
		textResourceClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IBuilderGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public " + I_STATUS + " build(" + textResourceClassName + " resource, " + I_PROGRESS_MONITOR + " monitor);");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
