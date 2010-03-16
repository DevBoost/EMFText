package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class CompoundGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;
	private String cardinalityClassName;
	private String choiceClassName;

	public CompoundGenerator() {
		super();
	}

	private CompoundGenerator(GenerationContext context) {
		super(context, EArtifact.COMPOUND);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		cardinalityClassName = context.getQualifiedClassName(EArtifact.CARDINALITY);
		choiceClassName = context.getQualifiedClassName(EArtifact.CHOICE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new CompoundGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + choiceClassName + " choice, " + cardinalityClassName + " cardinality) {");
		sc.add("super(cardinality, new " + syntaxElementClassName + "[] {choice});"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("}");
		return true;
	}
}
