package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class KeywordGenerator extends JavaBaseGenerator {

	public KeywordGenerator() {
		super();
	}

	private KeywordGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.KEYWORD);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new KeywordGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A class to represent a keyword in the grammar.");
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addGetValueMethod(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private final String value;"); 
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(String value, " + cardinalityClassName + " cardinality) {"); 
		sc.add("super(cardinality, null);"); 
		sc.add("this.value = value;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetValueMethod(StringComposite sc) {
		sc.add("public String getValue() {"); 
		sc.add("return value;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}
}
