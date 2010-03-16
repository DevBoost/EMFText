package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class WhiteSpaceGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;
	private String cardinalityClassName;

	public WhiteSpaceGenerator() {
		super();
	}

	private WhiteSpaceGenerator(GenerationContext context) {
		super(context, EArtifact.WHITE_SPACE);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		cardinalityClassName = context.getQualifiedClassName(EArtifact.CARDINALITY);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new WhiteSpaceGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final int amount;"); 
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(int amount, " + cardinalityClassName + " cardinality) {"); 
		sc.add("super(cardinality, null);"); 
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
