package org.emftext.sdk.codegen.generators.interfaces;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IElementMappingGenerator extends BaseGenerator {

	private String iReferenceMappingClassName;

	public IElementMappingGenerator() {
		super();
	}

	private IElementMappingGenerator(GenerationContext context) {
		super(context, EArtifact.I_ELEMENT_MAPPING);
		iReferenceMappingClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_MAPPING);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IElementMappingGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A mapping from an identifier to an EObject.");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the reference this mapping points to.");
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> extends " + iReferenceMappingClassName + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.add("// Returns the target object the identifier is mapped to.");
		sc.add("public ReferenceType getTargetElement();");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}