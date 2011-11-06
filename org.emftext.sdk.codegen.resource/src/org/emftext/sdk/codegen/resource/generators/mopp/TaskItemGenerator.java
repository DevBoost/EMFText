package org.emftext.sdk.codegen.resource.generators.mopp;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class TaskItemGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addFieldGet("keyword", "String");
		sc.addFieldGet("message", "String");
		sc.addFieldGet("line", "int");
		sc.addFieldGet("charStart", "int");
		sc.addFieldGet("charEnd", "int");

		sc.addFields();
		addConstructor(sc);
		sc.addGettersSetters();
		sc.add("}");
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(String keyword, String message, int line, int charStart, int charEnd) {");
		sc.add("super();");
		sc.add("this.keyword = keyword;");
		sc.add("this.message = message;");
		sc.add("this.line = line;");
		sc.add("this.charStart = charStart;");
		sc.add("this.charEnd = charEnd;");
		sc.add("}");
		sc.addLineBreak();
	}
}
