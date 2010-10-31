package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ChangeReferenceQuickFixGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A quick fix that replaces the target of a reference with another EObject. " +
			"This class is used to implement default quick fixes for references that could not " +
			"be resolved, but can also be used by custom reference resolvers."
		);
		sc.add("public class " + getResourceClassName() + " extends " + quickFixClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private " + E_OBJECT + " container;");
		sc.add("private " + E_REFERENCE + " reference;");
		sc.add("private " + E_OBJECT + " oldTarget;");
		sc.add("private " + E_OBJECT + " newTarget;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String displayString, String imageKey, " + E_OBJECT + " container, " + E_REFERENCE + " reference, " + E_OBJECT + " oldTarget, " + E_OBJECT + " newTarget) {");
		sc.add("super(displayString, imageKey, " + ARRAYS + ".asList(container, reference, oldTarget));");
		sc.add("this.container = container;");
		sc.add("this.reference = reference;");
		sc.add("this.oldTarget = oldTarget;");
		sc.add("this.newTarget = newTarget;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addMethods(JavaComposite sc) {
		addApplyChangesMethod(sc);
	}

	private void addApplyChangesMethod(JavaComposite sc) {
		sc.add("@Override").addLineBreak();
		sc.add("public void applyChanges() {");
		sc.add(ECORE_UTIL + ".replace(container, reference, oldTarget, newTarget);");
		sc.add("}");
		sc.addLineBreak();
	}
}
