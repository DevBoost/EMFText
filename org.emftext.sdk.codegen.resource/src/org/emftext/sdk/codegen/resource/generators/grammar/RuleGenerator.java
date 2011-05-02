package org.emftext.sdk.codegen.resource.generators.grammar;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class RuleGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A class to represent a rules in the grammar.");
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final " + E_CLASS + " metaclass;"); 
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetMetaclassMethod(sc);
		addGetDefinitionMethod(sc);
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_CLASS + " metaclass, " + choiceClassName + " choice, " + cardinalityClassName + " cardinality) {");
		sc.add("super(cardinality, new " + syntaxElementClassName + "[] {choice});"); 
		sc.add("this.metaclass = metaclass;");
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetMetaclassMethod(JavaComposite sc) {
		sc.add("public " + E_CLASS + " getMetaclass() {"); 
		sc.add("return metaclass;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetDefinitionMethod(JavaComposite sc) {
		sc.add("public " + choiceClassName + " getDefinition() {"); 
		sc.add("return (" + choiceClassName + ") getChildren()[0];"); 
		sc.add("}"); 
		sc.addLineBreak();
	}
}
