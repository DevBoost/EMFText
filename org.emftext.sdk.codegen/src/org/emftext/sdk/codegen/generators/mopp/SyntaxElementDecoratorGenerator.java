package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.INTEGER;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
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

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addAddIndexToPrintMethod(sc);
		addGetDecoratedElementMethod(sc);
		addGetChildDecoratatorsMethod(sc);
		addGetNextIndexToPrintMethod(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("// the syntax element to be decorated");
		sc.add("private " + syntaxElementClassName + " decoratedElement;");
		sc.addLineBreak();
		sc.add("// an array of child decorators (one decorator per child of the decorated syntax element");
		sc.add("private " + getResourceClassName() + "[] childDecorators;");
		sc.addLineBreak();
		sc.add("// a list of the indices that must be printed");
		sc.add("private " + LIST + "<" + INTEGER+ "> indicesToPrint = new " + ARRAY_LIST + "<" + INTEGER+ ">();");
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

	private void addGetNextIndexToPrintMethod(StringComposite sc) {
		sc.add("public " + INTEGER + " getNextIndexToPrint() {");
		sc.add("if (indicesToPrint.size() == 0) {");
		sc.add("return null;"); 
		sc.add("}");
		sc.add("return indicesToPrint.remove(0);"); 
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddIndexToPrintMethod(StringComposite sc) {
		sc.add("public void addIndexToPrint(" + INTEGER + " index) {");
		sc.add("indicesToPrint.add(index);"); 
		sc.add("}"); 
		sc.addLineBreak();
	}
}
