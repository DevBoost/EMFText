package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class LineBreakGenerator extends JavaBaseGenerator {

	public LineBreakGenerator() {
		super();
	}

	private LineBreakGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.LINE_BREAK);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new LineBreakGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " extends " + formattingElementClassName + " {");
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
