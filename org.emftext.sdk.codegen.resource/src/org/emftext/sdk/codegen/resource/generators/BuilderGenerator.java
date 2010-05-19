package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class BuilderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public BuilderGenerator() {
		super();
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iBuilderClassName + " {");
		sc.addLineBreak();
		addIsBuildingNeededMethod(sc);
		addBuildMethod(sc);
		sc.add("}");
	}

	private void addIsBuildingNeededMethod(JavaComposite sc) {
		sc.add("public boolean isBuildingNeeded(" + URI + " uri) {");
		sc.addComment("change this to return true to enable building of all resources");
		sc.add("return false;");
		sc.add("}");
	}

	private void addBuildMethod(JavaComposite sc) {
		sc.add("public " + I_STATUS + " build(" + textResourceClassName + " resource, " + I_PROGRESS_MONITOR + " monitor) {");
		sc.addComment("set option " + OptionTypes.OVERRIDE_BUILDER + " to 'false' and then perform build here");
		sc.add("return " + STATUS + ".OK_STATUS;");
		sc.add("}");
		sc.addLineBreak();
	}
}
