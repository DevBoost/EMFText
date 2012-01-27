package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ContainmentTraceGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A " + getResourceClassName() + " represents a specific path to a structural " +
			"feature by navigating over a set of a structural feature from a start class. " +
			getResourceClassName() + "s are used during code completion to reconstruct " +
			"containment trees that are not created by the parser, for example, " +
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
		sc.addJavadoc("The class where the trace starts.");
		sc.add("private " + E_CLASS + " startClass;");
		sc.addLineBreak();
		sc.addJavadoc("The path of contained features.");
		sc.add("private " + containedFeatureClassName + "[] path;");
		sc.addLineBreak();
	}

	private void addConstructors(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_CLASS + " startClass, " + containedFeatureClassName + "[] path) {");
		sc.add("super();");
		sc.addComment("Verify arguments");
		sc.add("if (startClass != null) {");
		sc.add("if (path.length > 0) {");
		sc.add(E_STRUCTURAL_FEATURE + " feature = path[path.length - 1].getFeature();");
		sc.add("if (!startClass.getEAllStructuralFeatures().contains(feature)) {");
		sc.add("throw new RuntimeException(\"Metaclass \" + startClass.getName() + \" must contain feature \" + feature.getName());");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("this.startClass = startClass;");
		sc.add("this.path = path;");
		sc.add("}");
		sc.addLineBreak();
	}
	private void addMethods(JavaComposite sc) {
		addGetContainerClassMethod(sc);
		addGetFeatureMethod(sc);
		addToStringMethod(sc);
	}

	private void addGetContainerClassMethod(JavaComposite sc) {
		sc.add("public " + E_CLASS + " getStartClass() {");
		sc.add("return startClass;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetFeatureMethod(JavaComposite sc) {
		sc.add("public " + containedFeatureClassName + "[] getPath() {");
		sc.add("return path;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("return (startClass == null ? \"null\" : startClass.getName()) + \"->\" + " + stringUtilClassName + ".explode(path, \"->\");");
		sc.add("}");
		sc.addLineBreak();
	}
}
