package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class FormattingElementGenerator extends JavaBaseGenerator {

	public FormattingElementGenerator() {
		super();
	}

	private FormattingElementGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.FORMATTING_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new FormattingElementGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public abstract class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		addConstructor(sc);
		sc.add("}");
		return true;
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + cardinalityClassName + " cardinality) {"); 
		sc.add("super(cardinality, null);"); 
		sc.add("}"); 
		sc.addLineBreak();
	}
}
