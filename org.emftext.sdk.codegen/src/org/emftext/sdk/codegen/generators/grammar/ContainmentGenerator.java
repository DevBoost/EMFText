package org.emftext.sdk.codegen.generators.grammar;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ContainmentGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;
	private String cardinalityClassName;

	public ContainmentGenerator() {
		super();
	}

	private ContainmentGenerator(GenerationContext context) {
		super(context, EArtifact.CONTAINMENT);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		cardinalityClassName = context.getQualifiedClassName(EArtifact.CARDINALITY);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ContainmentGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		sc.add("private final " + E_STRUCTURAL_FEATURE + " feature;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + E_STRUCTURAL_FEATURE + " feature, " + cardinalityClassName + " cardinality) {"); 
		sc.add("super(cardinality, null);"); 
		sc.add("this.feature = feature;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public " + E_STRUCTURAL_FEATURE + " getFeature() {"); 
		sc.add("return feature;"); 
		sc.add("}"); 
		sc.add("}");
		return true;
	}
}
