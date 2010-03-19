package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class LineBreakGenerator extends JavaBaseGenerator {

	private String cardinalityClassName;
	private String formattingElementName;

	public LineBreakGenerator() {
		super();
	}

	private LineBreakGenerator(GenerationContext context) {
		super(context, EArtifact.LINE_BREAK);
		cardinalityClassName = context.getQualifiedClassName(EArtifact.CARDINALITY);
		formattingElementName = context.getQualifiedClassName(EArtifact.FORMATTING_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new LineBreakGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + formattingElementName + " {");
		sc.addLineBreak();
		sc.add("private final int tabs;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + cardinalityClassName + " cardinality, int tabs) {"); 
		sc.add("super(cardinality);"); 
		sc.add("this.tabs = tabs;"); 
		sc.add("}"); 
		sc.addLineBreak();
		sc.add("public int getTabs() {"); 
		sc.add("return tabs;"); 
		sc.add("}"); 
		sc.add("}");
		return true;
	}
}
