package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IURIMappingGenerator extends BaseGenerator {

	private String iReferenceMappingClassName;

	public IURIMappingGenerator() {
		super();
	}

	private IURIMappingGenerator(GenerationContext context) {
		super(context, EArtifact.IURI_MAPPING);
		iReferenceMappingClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_MAPPING);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IURIMappingGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Implementors of this interface map identifiers to URIs.");
		sc.add("// This is sometime necessary when resolving references depends");
		sc.add("// on the resolution of others.");
		sc.add("//");
		sc.add("// @param <ReferenceType> unused type parameter which is needed to implement IReferenceMapping.");
		sc.add("//");
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> extends " + iReferenceMappingClassName + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.add("// Returns an alternative proxy " + URI + " that should follow EMF's default naming scheme");
		sc.add("// such that it can be resolved by the default resolution mechanism that will be called");
		sc.add("// on this " + URI + " (see <code>Resource.getEObject()</code>).");
		
		sc.add("public " + URI + " getTargetIdentifier();");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
