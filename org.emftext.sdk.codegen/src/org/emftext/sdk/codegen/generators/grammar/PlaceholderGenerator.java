package org.emftext.sdk.codegen.generators.grammar;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class PlaceholderGenerator extends JavaBaseGenerator {

	public PlaceholderGenerator() {
		super();
	}

	private PlaceholderGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.PLACEHOLDER);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new PlaceholderGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A class to represent placeholders in a grammar.");
		sc.add("public class " + getResourceClassName() + " extends " + terminalClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addGetTokenNameMethod(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private final " + STRING + " tokenName;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE + " feature, " + STRING + " tokenName, " + cardinalityClassName + " cardinality, int mandatoryOccurencesAfter) {"); 
		sc.add("super(feature, cardinality, mandatoryOccurencesAfter);"); 
		sc.add("this.tokenName = tokenName;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetTokenNameMethod(StringComposite sc) {
		sc.add("public " + STRING + " getTokenName() {");
		sc.add("return tokenName;");
		sc.add("}"); 
		sc.addLineBreak();
	}

}
