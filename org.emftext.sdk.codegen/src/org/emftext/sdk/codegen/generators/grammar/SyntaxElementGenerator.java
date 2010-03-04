package org.emftext.sdk.codegen.generators.grammar;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class SyntaxElementGenerator extends JavaBaseGenerator {

	private String cardinalityEnumName;

	public SyntaxElementGenerator() {
		super();
	}

	private SyntaxElementGenerator(GenerationContext context) {
		super(context, EArtifact.SYNTAX_ELEMENT);
		cardinalityEnumName = context.getQualifiedClassName(EArtifact.CARDINALITY);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new SyntaxElementGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// The abstract super class for all elements of a grammar.");
		sc.add("// This class provides methods to traverse the grammar rules.");
		sc.add("public abstract class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + getResourceClassName() + "[] children;");
		sc.add("private " + getResourceClassName() + " parent;");
		sc.add("private " + cardinalityEnumName + " cardinality;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + cardinalityEnumName + " cardinality, " + getResourceClassName() + "[] children) {");
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
		sc.add("public " + cardinalityEnumName + " getCardinality() {");
		sc.add("return cardinality;");
		sc.add("}");
		sc.addLineBreak();
	}
}
