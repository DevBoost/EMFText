package org.emftext.sdk.codegen.resource.generators.grammar;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class WhiteSpaceGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new WhiteSpaceGenerator());

	private WhiteSpaceGenerator() {
		super();
	}

	private WhiteSpaceGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.WHITE_SPACE);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new WhiteSpaceGenerator(parent, context);
	}

	public void generateJavaContents(JavaComposite sc) {
		
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
	}
}
