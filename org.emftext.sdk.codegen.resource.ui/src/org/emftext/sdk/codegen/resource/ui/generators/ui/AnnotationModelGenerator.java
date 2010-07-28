package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_ANNOTATION_MODEL;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MARKER_ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.RESOURCE_MARKER_ANNOTATION_MODEL;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class AnnotationModelGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + RESOURCE_MARKER_ANNOTATION_MODEL + " implements " + I_ANNOTATION_MODEL + " {");
		sc.addLineBreak();
		addConstructor(sc);
		addCreateMarkerAnnotationMethod(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + I_RESOURCE + " resource) {");
		sc.add("super(resource);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateMarkerAnnotationMethod(JavaComposite sc) {
		sc.add("protected " + MARKER_ANNOTATION + " createMarkerAnnotation(" + I_MARKER + " marker) {");
		sc.add("return new " + markerAnnotationClassName + "(marker);");
		sc.add("}");
		sc.addLineBreak();
	}
}
