package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class DefaultHoverTextProviderGenerator extends JavaBaseGenerator {
	
	public DefaultHoverTextProviderGenerator() {
		super();
	}

	private DefaultHoverTextProviderGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.DEFAULT_HOVER_TEXT_PROVIDER);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iHoverTextProviderClassName + " {");
		sc.addLineBreak();
		sc.add("public " + STRING + " getHoverText(" + E_OBJECT + " object) {");
		sc.add("if (object == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_CLASS + " eClass = object.eClass();");
		sc.add("String label = \"<strong>\" + eClass.getName() + \"</strong>\";");
		sc.add("for (" + E_ATTRIBUTE + " attribute : eClass.getEAllAttributes()) {");
		sc.add(OBJECT + " value = null;");
		sc.add("try {");
		sc.add("value = object.eGet(attribute);");
		sc.add("} catch (" + EXCEPTION + " e) {");
		sc.addComment("Exception in eGet, do nothing");
		sc.add("}");
		sc.add("if (value != null && value.toString() != null && !value.toString().equals(\"[]\")) {");
		sc.add("label += \"<br />\" + attribute.getName() + \": \" + object.eGet(attribute).toString();");
		sc.add("}");
		sc.add("}");
		sc.add("return label;");
		sc.add("}");
		sc.add("}");
		
		return true;
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new DefaultHoverTextProviderGenerator(context);
	}
}
