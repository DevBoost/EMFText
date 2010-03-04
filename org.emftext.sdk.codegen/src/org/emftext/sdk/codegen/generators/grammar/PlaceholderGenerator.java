package org.emftext.sdk.codegen.generators.grammar;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class PlaceholderGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;
	private String cardinalityEnumName;

	public PlaceholderGenerator() {
		super();
	}

	private PlaceholderGenerator(GenerationContext context) {
		super(context, EArtifact.PLACEHOLDER);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		cardinalityEnumName = context.getQualifiedClassName(EArtifact.CARDINALITY);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new PlaceholderGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A class to represent placeholders in a grammar.");
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addGetFeatureMethod(sc);
		addGetTokenNameMethod(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private final " + E_STRUCTURAL_FEATURE + " feature;");
		sc.add("private final " + STRING + " tokenName;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE + " feature, " + STRING + " tokenName, " + cardinalityEnumName + " cardinality) {"); 
		sc.add("super(cardinality, null);"); 
		sc.add("this.feature = feature;"); 
		sc.add("this.tokenName = tokenName;"); 
		sc.add("}"); 
		sc.addLineBreak();
	}

	private void addGetFeatureMethod(StringComposite sc) {
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {");
		sc.add("return feature;");
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
