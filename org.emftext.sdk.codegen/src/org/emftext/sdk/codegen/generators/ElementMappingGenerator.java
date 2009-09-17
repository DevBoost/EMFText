package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.ABSTRACT_REFERENCE_MAPPING;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_ELEMENT_MAPPING;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;

public class ElementMappingGenerator extends BaseGenerator {

	public ElementMappingGenerator() {
		super();
	}

	private ElementMappingGenerator(GenerationContext context) {
		super(context, EArtifact.ELEMENT_MAPPING);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A basic implementation of the IElementMapping interface.");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the reference that can be mapped to");
		sc.add("//");
		sc.add("public class " + getResourceClassName() + "<ReferenceType> extends " + ABSTRACT_REFERENCE_MAPPING + "<ReferenceType> implements " + I_ELEMENT_MAPPING + "<ReferenceType> {");
		sc.addLineBreak();
		sc.add("private final ReferenceType target;");
		sc.add("private String identifier;");
		sc.add("private String warning;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(String identifier, ReferenceType target, String warning) {");
		sc.add("super();");
		sc.add("this.target = target;");
		sc.add("this.identifier = identifier;");
		sc.add("this.warning = warning;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public ReferenceType getTargetElement() {");
		sc.add("return target;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getIdentifier() {");
		sc.add("return identifier;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getWarning() {");
		sc.add("return warning;");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ElementMappingGenerator(context);
	}
}
