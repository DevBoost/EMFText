package org.emftext.sdk.codegen.generators.mopp;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class LayoutInformationGenerator extends JavaBaseGenerator {

	private String syntaxElementClassName;

	public LayoutInformationGenerator() {
		super();
	}

	private LayoutInformationGenerator(GenerationContext context) {
		super(context, EArtifact.LAYOUT_INFORMATION);
		syntaxElementClassName = getContext().getQualifiedClassName(EArtifact.SYNTAX_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new LayoutInformationGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private final " + syntaxElementClassName + " syntaxElement;");
		sc.add("private final " + OBJECT + " object;");
		sc.add("private final " + STRING + " hiddenTokenText;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + syntaxElementClassName + " syntaxElement, " + OBJECT + " object, " + STRING + " hiddenTokenText) {");
		sc.add("super();");
		sc.add("this.syntaxElement = syntaxElement;");
		sc.add("this.object = object;");
		sc.add("this.hiddenTokenText = hiddenTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(StringComposite sc) {
		addGetSyntaxElementMethod(sc);
		addGetObjectMethod(sc);
		addGetHiddenTokenTextMethod(sc);
	}

	private void addGetSyntaxElementMethod(StringComposite sc) {
		sc.add("public " + syntaxElementClassName + " getSyntaxElement() {");
		sc.add("return syntaxElement;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetObjectMethod(StringComposite sc) {
		sc.add("public " + OBJECT + " getObject() {");
		sc.add("return object;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHiddenTokenTextMethod(StringComposite sc) {
		sc.add("public " + STRING + " getHiddenTokenText() {");
		sc.add("return hiddenTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}
}
