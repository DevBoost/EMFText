package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class SequenceGenerator extends JavaBaseGenerator {

	public SequenceGenerator() {
		super();
	}

	private SequenceGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.SEQUENCE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new SequenceGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
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
