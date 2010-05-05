package org.emftext.sdk.codegen.generators.util;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class PairGenerator extends JavaBaseGenerator {

	public PairGenerator() {
		super();
	}

	private PairGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.PAIR);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new PairGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A typed pair of objects.",
			"@param <T1> the type of the first (left) object",
			"@param <T2> the type of the second (right) object"
		);
		sc.add("public class " + getResourceClassName() + "<T1, T2> {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		
		sc.add("public T1 getLeft() {");
		sc.add("return left;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public T2 getRight() {");
		sc.add("return right;");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("@Override").addLineBreak();
		sc.add("public int hashCode() {");
		sc.add("final int prime = 31;");
		sc.add("int result = 1;");
		sc.add("result = prime * result + ((left == null) ? 0 : left.hashCode());");
		sc.add("result = prime * result + ((right == null) ? 0 : right.hashCode());");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("@Override").addLineBreak();
		sc.add("public boolean equals(Object obj) {");
		sc.add("if (this == obj) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("if (obj == null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (getClass() != obj.getClass()) {");
		sc.add("return false;");
		sc.add("}");
		sc.add(getResourceClassName() + "<?,?> other = (" + getResourceClassName() + "<?,?>) obj;");
		sc.add("if (left == null) {");
		sc.add("if (other.left != null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("} else if (!left.equals(other.left)) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("if (right == null) {");
		sc.add("if (other.right != null) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("} else if (!right.equals(other.right)) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();

		sc.add("}");
		return true;
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(T1 left, T2 right) {");
		sc.add("this.left = left;");
		sc.add("this.right = right;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addFields(StringComposite sc) {
		sc.add("private T1 left;");
		sc.add("private T2 right;");
		sc.addLineBreak();
	}
}
