package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.runtime.resource.impl.AbstractHoverTextProvider;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

public class HoverTextProviderGenerator extends BaseGenerator {
	
	public HoverTextProviderGenerator(GenerationContext context) {
		super(context, EArtifact.HOVER_TEXT_PROVIDER);
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + AbstractHoverTextProvider.class.getName() + " {");
		sc.addLineBreak();
		sc.add("public " + STRING + " getHoverText(" + E_OBJECT + " object) {");
		sc.add("if (object == null) {");
		sc.add("return null;");
		sc.add("}");
		sc.add(E_CLASS + " eClass = object.eClass();");
		sc.add("String label = \"<strong>\" + eClass.getName() + \"</strong>\";");
		sc.add("for (" + E_ATTRIBUTE + " attribute : eClass.getEAllAttributes()) {");
		sc.add("" + OBJECT + " value = null;");
		sc.add("try {");
		sc.add("value = object.eGet(attribute);");
		sc.add("} catch (" + EXCEPTION + " e) {");
		sc.add("// Exception in eGet, do nothing");
		sc.add("}");
		sc.add("if (value != null && value.toString() != null && !value.toString().equals(\"[]\")) {");
		sc.add("label += \"<br />\" + attribute.getName() + \": \" + object.eGet(attribute).toString();");
		sc.add("}");
		sc.add("}");
		sc.add("return label;");
		sc.add("}");
		sc.add("}");
		
		out.write(sc.toString());
		return true;
	}

}
