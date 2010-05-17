package org.emftext.sdk.codegen.resource.generators.grammar;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class TerminalGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new TerminalGenerator());

	private TerminalGenerator() {
		super();
	}

	private TerminalGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.TERMINAL);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new TerminalGenerator(parent, context);
	}

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final " + E_STRUCTURAL_FEATURE + " feature;");
		sc.add("private final int mandatoryOccurencesAfter;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE + " feature, " + cardinalityClassName + " cardinality, int mandatoryOccurencesAfter) {"); 
		sc.add("super(cardinality, null);");
		sc.add("this.feature = feature;");
		sc.add("this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;");
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {"); 
		sc.add("return feature;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public int getMandatoryOccurencesAfter() {"); 
		sc.add("return mandatoryOccurencesAfter;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("}");
	}
}
