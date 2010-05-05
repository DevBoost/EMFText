package org.emftext.sdk.codegen.generators.grammar;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class TerminalGenerator extends JavaBaseGenerator {

	public TerminalGenerator() {
		super();
	}

	private TerminalGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.TERMINAL);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new TerminalGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
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
		return true;
	}
}
