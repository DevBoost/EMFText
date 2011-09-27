package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ContainedFeatureGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A ContainedFeature represents a specific path to a metaclass " +
			"by navigating a structural feature. " +
			"ContainedFeatures are used during code completion to reconstruct " +
			"containment trees that are not create by the parser, for example, " +
			"if the first character of the contained object has not been typed " +
			"yet."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructors(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc("The class to which the feature points.");
		sc.add("private " + E_CLASS + " containerClass;");
		sc.addLineBreak();
		sc.addJavadoc("The feature that points to the container class.");
		sc.add("private " + E_STRUCTURAL_FEATURE + " feature;");
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
}
