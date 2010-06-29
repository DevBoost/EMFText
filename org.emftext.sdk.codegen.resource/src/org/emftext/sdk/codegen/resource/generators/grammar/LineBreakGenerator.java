package org.emftext.sdk.codegen.resource.generators.grammar;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class LineBreakGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + formattingElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final int tabs;");
		sc.addLineBreak();
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetTabsMethod(sc);
		addToStringMethod(sc);
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + cardinalityClassName + " cardinality, int tabs) {"); 
		sc.add("super(cardinality);"); 
		sc.add("this.tabs = tabs;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetTabsMethod(JavaComposite sc) {
		sc.add("public int getTabs() {"); 
		sc.add("return tabs;"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {"); 
		sc.add("return \"!\" + getTabs();");
		sc.add("}"); 
		sc.addLineBreak();
	}
}
