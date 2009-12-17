package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STATUS;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BuilderGenerator extends JavaBaseGenerator {

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


	@Override
	public boolean generateJavaContents(StringComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iBuilderClassName + " {");
		sc.addLineBreak();
		addBuildMethod(sc);
		sc.add("}");
		
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
