package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class SequenceGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;
	private String cardinalityClassName;

	public SequenceGenerator() {
		super();
	}

	private SequenceGenerator(GenerationContext context) {
		super(context, EArtifact.SEQUENCE);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		cardinalityClassName = context.getQualifiedClassName(EArtifact.CARDINALITY);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new SequenceGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + cardinalityClassName + " cardinality, " + syntaxElementClassName + "... elements) {");
		sc.add("super(cardinality, elements);"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("}");
		return true;
	}
}
