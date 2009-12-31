package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IBuilderGenerator extends JavaBaseGenerator {

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

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public boolean isBuildingNeeded(" + URI + " uri);");
		sc.addLineBreak();
		sc.add("public " + I_STATUS + " build(" + textResourceClassName + " resource, " + I_PROGRESS_MONITOR + " monitor);");
		sc.add("}");

		return true;
	}
}
