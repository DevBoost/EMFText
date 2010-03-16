package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ChoiceGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;
	private String cardinalityClassName;

	public ChoiceGenerator() {
		super();
	}

	private ChoiceGenerator(GenerationContext context) {
		super(context, EArtifact.CHOICE);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		cardinalityClassName = context.getQualifiedClassName(EArtifact.CARDINALITY);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ChoiceGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + cardinalityClassName + " cardinality, " + syntaxElementClassName + "... choices) {"); 
		sc.add("super(cardinality, choices);"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("}");
		return true;
	}
}
