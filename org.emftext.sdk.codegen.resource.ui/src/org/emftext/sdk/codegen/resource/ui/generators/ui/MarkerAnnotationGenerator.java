package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_MARKER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_QUICK_FIXABLE_ANNOTATION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.MARKER_ANNOTATION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class MarkerAnnotationGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + MARKER_ANNOTATION + " implements " + I_QUICK_FIXABLE_ANNOTATION + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addSetQuickFixableMethod(sc);
		addIsQuickFixableStateSetMethod(sc);
		addIsQuickFixableMethod(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("boolean quickFixableState;");
		sc.add("boolean isQuickFixable;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + I_MARKER + " marker) {");
		sc.add("super(marker);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetQuickFixableMethod(JavaComposite sc) {
		sc.add("public void setQuickFixable(boolean state) {");
		sc.add("isQuickFixable = state;");
		sc.add("quickFixableState = true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsQuickFixableStateSetMethod(JavaComposite sc) {
		sc.add("public boolean isQuickFixableStateSet() {");
		sc.add("return true;");
		sc.add("//return quickFixableState;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsQuickFixableMethod(JavaComposite sc) {
		sc.add("public boolean isQuickFixable() {");
		sc.add("try {");
		sc.add("return getMarker().getAttribute(" + I_MARKER + ".SOURCE_ID) != null;");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add("// ignore");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}
}
