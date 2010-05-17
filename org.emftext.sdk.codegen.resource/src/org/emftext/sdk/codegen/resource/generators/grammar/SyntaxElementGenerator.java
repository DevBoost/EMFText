package org.emftext.sdk.codegen.resource.generators.grammar;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class SyntaxElementGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new SyntaxElementGenerator());

	private SyntaxElementGenerator() {
		super();
	}

	private SyntaxElementGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.SYNTAX_ELEMENT);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new SyntaxElementGenerator(parent, context);
	}

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The abstract super class for all elements of a grammar. " + 
			"This class provides methods to traverse the grammar rules."
		);
		sc.add("public abstract class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + getResourceClassName() + "[] children;");
		sc.add("private " + getResourceClassName() + " parent;");
		sc.add("private " + cardinalityClassName + " cardinality;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + cardinalityClassName + " cardinality, " + getResourceClassName() + "[] children) {");
		sc.add("this.cardinality = cardinality;"); 
		sc.add("this.children = children;"); 
		sc.add("if (this.children != null) {"); 
		sc.add("for (" + getResourceClassName() + " child : this.children) {"); 
		sc.add("child.setParent(this);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(StringComposite sc) {
		addSetParentMethod(sc);
		addGetChildrenMethod(sc);
		addGetMetaClassMethod(sc);
		addGetCardinalityMethod(sc);
	}

	private void addSetParentMethod(StringComposite sc) {
		sc.add("public void setParent(" + getResourceClassName() + " parent) {");
		sc.add("assert this.parent == null;");
		sc.add("this.parent = parent;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetChildrenMethod(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "[] getChildren() {");
		sc.add("if (children == null) {");
		sc.add("return new " + getResourceClassName() + "[0];");
		sc.add("}");
		sc.add("return children;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetMetaClassMethod(StringComposite sc) {
		sc.add("public " + E_CLASS + " getMetaclass() {");
		sc.add("return parent.getMetaclass();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCardinalityMethod(StringComposite sc) {
		sc.add("public " + cardinalityClassName + " getCardinality() {");
		sc.add("return cardinality;");
		sc.add("}");
		sc.addLineBreak();
	}
}
