package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_ATTRIBUTE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.OBJECT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.STRING;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class DefaultHoverTextProviderGenerator extends UIJavaBaseGenerator {
	
	public static final GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new DefaultHoverTextProviderGenerator());

	private DefaultHoverTextProviderGenerator() {
		super();
	}

	private DefaultHoverTextProviderGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceUIArtifacts.DEFAULT_HOVER_TEXT_PROVIDER);
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
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
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new DefaultHoverTextProviderGenerator(parent, context);
	}
}
