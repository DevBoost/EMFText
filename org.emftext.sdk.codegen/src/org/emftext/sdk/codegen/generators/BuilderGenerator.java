package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.GenerationContext;
import java.io.PrintWriter;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BuilderGenerator extends BaseGenerator {

	private String iBuilderClassName;
	private String textResourceClassName;

	public BuilderGenerator() {
		super();
	}

	private BuilderGenerator(GenerationContext context) {
		super(context, EArtifact.BUILDER);
		iBuilderClassName = getContext().getQualifiedClassName(EArtifact.I_BUILDER);
		textResourceClassName = getContext().getQualifiedClassName(EArtifact.RESOURCE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new BuilderGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iBuilderClassName + " {");
		sc.addLineBreak();
		addBuildMethod(sc);
		sc.add("}");
		
		out.print(sc.toString());
		return true;
	}

	private void addBuildMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + I_STATUS + " build(" + textResourceClassName + " resource, " + I_PROGRESS_MONITOR + " monitor) {");
		sc.add("// set option " + OptionTypes.OVERRIDE_BUILDER + " to 'false' and then perform build here");
		sc.add("return " + STATUS + ".OK_STATUS;");
		sc.add("}");
		sc.addLineBreak();
	}
}
