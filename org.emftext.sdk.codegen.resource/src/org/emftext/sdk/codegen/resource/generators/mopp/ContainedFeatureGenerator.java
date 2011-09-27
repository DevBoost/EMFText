package org.emftext.sdk.codegen.resource.generators.mopp;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;
public class ContainedFeatureGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructors(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetContainerClassMethod(sc);
		addGetFeatureMethod(sc);
		addToStringMethod(sc);
	}

	private void addGetContainerClassMethod(JavaComposite sc) {
		sc.add("public " + E_CLASS + " getContainerClass() {");
		sc.add("return containerClass;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFeatureMethod(JavaComposite sc) {
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {");
		sc.add("return feature;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("return (feature == null ? \"null\" : feature.getName()) + \"->\" + (containerClass == null ? \"null\" : containerClass.getName());");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructors(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_CLASS + " containerClass, " + E_STRUCTURAL_FEATURE + " feature) {");
		sc.add("super();");
		sc.add("this.containerClass = containerClass;");
		sc.add("this.feature = feature;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + E_CLASS + " containerClass;");
		sc.add("private " + E_STRUCTURAL_FEATURE + " feature;");
		sc.addLineBreak();
	}

}
