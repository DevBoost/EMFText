package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class WhiteSpaceGenerator extends JavaBaseGenerator<Object> {

	public WhiteSpaceGenerator() {
		super();
	}

	private WhiteSpaceGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.WHITE_SPACE);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new WhiteSpaceGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + formattingElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final int amount;"); 
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(int amount, " + cardinalityClassName + " cardinality) {"); 
		sc.add("super(cardinality);"); 
		sc.add("this.amount = amount;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public int getAmount() {"); 
		sc.add("return amount;"); 
		sc.add("}");
		sc.add("}");
		return true;
	}
}
