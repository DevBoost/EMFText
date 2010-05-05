package org.emftext.sdk.codegen.generators.grammar;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ContainmentGenerator extends JavaBaseGenerator {

	public ContainmentGenerator() {
		super();
	}

	private ContainmentGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.CONTAINMENT);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new ContainmentGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + terminalClassName + " {");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE + " feature, " + cardinalityClassName + " cardinality, int mandatoryOccurencesAfter) {"); 
		sc.add("super(feature, cardinality, mandatoryOccurencesAfter);"); 
		sc.add("}"); 
		sc.add("}");
		return true;
	}
}
