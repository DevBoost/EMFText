package org.emftext.sdk.codegen.generators.grammar;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class FormattingElementGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;
	private String cardinalityEnumName;

	public FormattingElementGenerator() {
		super();
	}

	private FormattingElementGenerator(GenerationContext context) {
		super(context, EArtifact.FORMATTING_ELEMENT);
		syntaxElementClassName = context.getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
		cardinalityEnumName = context.getQualifiedClassName(EArtifact.CARDINALITY);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new FormattingElementGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public abstract class " + getResourceClassName() + " extends " + syntaxElementClassName + " {");
		sc.addLineBreak();
		addConstructor(sc);
		sc.add("}");
		return true;
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + cardinalityEnumName + " cardinality) {"); 
		sc.add("super(cardinality, null);"); 
		sc.add("}"); 
		sc.addLineBreak();
	}
}
