package org.emftext.sdk.codegen.resource.generators.code_completion;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_ATTRIBUTE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class AttributeValueProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("This class provides sets of values for attributes. It is used by the code completion processor.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addGetDefaultValuesMethod(sc);
		sc.add("}");
	}

	private void addGetDefaultValuesMethod(StringComposite sc) {
		sc.add("public Object[] getDefaultValues(" + E_ATTRIBUTE + " attribute) {");
		sc.add("String typeName = attribute.getEType().getName();");
		sc.add("if (\"EString\".equals(typeName)) {");
		sc.add("return new Object[] {\"some\" + " + stringUtilClassName + ".capitalize(attribute.getName())};");
		sc.add("}");
		sc.add("if (\"EBoolean\".equals(typeName)) {");
		sc.add("return new Object[] {Boolean.TRUE, Boolean.FALSE};");
		sc.add("}");
		// TODO mseifert: add more default values for other types
		sc.add("return new Object[] {attribute.getDefaultValue()};");
		sc.add("}");
		sc.addLineBreak();
	}
}
