package org.emftext.sdk.codegen.resource.generators.grammar;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class CardinalityGenerator extends JavaBaseGenerator<Object> {

	public CardinalityGenerator() {
		super();
	}

	private CardinalityGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.CARDINALITY);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new CardinalityGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public enum " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("ONE, PLUS, QUESTIONMARK, STAR;"); 
		sc.addLineBreak();
		sc.add("}");
		return true;
	}
}
