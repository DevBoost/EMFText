package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER_RESOLUTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER_RESOLUTION_GENERATOR;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

// TODO mseifert: complete implementation
public class MarkerResolutionGeneratorGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_MARKER_RESOLUTION_GENERATOR + ", " + I_MARKER_RESOLUTION + " {");
		sc.addLineBreak();
		addGetResolutionsMethod(sc);
		addGetLabelMethod(sc);
		addRunMethod(sc);
		sc.add("}");
	}

	private void addGetResolutionsMethod(JavaComposite sc) {
		sc.add("public " + I_MARKER_RESOLUTION + "[] getResolutions(" + I_MARKER + " marker) {");
		sc.add("return new " + I_MARKER_RESOLUTION + "[] {this};");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLabelMethod(JavaComposite sc) {
		sc.add("public String getLabel() {");
		sc.add("return \"I do fix\";");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRunMethod(JavaComposite sc) {
		sc.add("public void run(" + I_MARKER + " marker) {");
		sc.add("System.out.println(\"CsMarkerResolutionGenerator.run()\");");
		sc.add("}");
		sc.addLineBreak();
	}
}
