package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class CardinalityGenerator extends JavaBaseGenerator {

	public CardinalityGenerator() {
		super();
	}

	private CardinalityGenerator(GenerationContext context) {
		super(context, EArtifact.CARDINALITY);
	}

	public IGenerator newInstance(GenerationContext context) {
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
