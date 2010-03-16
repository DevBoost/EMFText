package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

/**
 * A generator for the class SyntaxElementDecorator. Instances of
 * SyntaxElementDecorator can be used to attach information to 
 * elements of syntax rules.
 */
public class SyntaxElementDecoratorGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;

	public SyntaxElementDecoratorGenerator() {
		super();
	}

	private SyntaxElementDecoratorGenerator(GenerationContext context) {
		super(context, EArtifact.SYNTAX_ELEMENT_DECORATOR);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new SyntaxElementDecoratorGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addAddPrintElementMethod(sc);
		addGetDecoratedElementMethod(sc);
		addGetChildDecoratatorsMethod(sc);
		addGetPrintElementsMethod(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + syntaxElementClassName + " decoratedElement;");
		sc.add("private " + getResourceClassName() + "[] childDecorators;");
		sc.add("private " + LIST + "<" + syntaxElementClassName+ "> printElements = new " + ARRAY_LIST + "<" + syntaxElementClassName+ ">();");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + syntaxElementClassName + " decoratedElement, " + getResourceClassName() + "[] childDecorators) {");
		sc.add("super();"); 
		sc.add("this.decoratedElement = decoratedElement;"); 
		sc.add("this.childDecorators = childDecorators;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}


	private void addGetDecoratedElementMethod(StringComposite sc) {
		sc.add("public " + syntaxElementClassName + " getDecoratedElement() {");
		sc.add("return decoratedElement;"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetChildDecoratatorsMethod(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "[] getChildDecorators() {");
		sc.add("return childDecorators;"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPrintElementsMethod(StringComposite sc) {
		sc.add("public " + LIST + "<" + syntaxElementClassName+ "> getPrintElements() {");
		sc.add("return printElements;"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddPrintElementMethod(StringComposite sc) {
		sc.add("public void addPrintElement(" + syntaxElementClassName + " syntaxElement) {");
		sc.add("printElements.add(syntaxElement);"); 
		sc.add("}"); 
		sc.addLineBreak();
	}
}
