package org.emftext.sdk.codegen.resource.generators.grammar;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ChoiceGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		addConstructor(sc);
		addToStringMethod(sc);
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + cardinalityClassName + " cardinality, " + syntaxElementClassName + "... choices) {"); 
		sc.add("super(cardinality, choices);"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {"); 
		sc.add("return " + stringUtilClassName + ".explode(getChildren(), \"|\");");
		sc.add("}"); 
		sc.addLineBreak();
	}
}
