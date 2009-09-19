package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IReferenceResolverGenerator extends BaseGenerator {

	private String iConfigurableClassName;
	private String iReferenceResolveResultClassName;

	public IReferenceResolverGenerator() {
		super();
	}

	private IReferenceResolverGenerator(GenerationContext context) {
		super(context, EArtifact.I_REFERENCE_RESOLVER);
		iConfigurableClassName = getContext().getQualifiedClassName(EArtifact.I_CONFIGURABLE);
		iReferenceResolveResultClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_RESOLVE_RESULT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IReferenceResolverGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A reference resolver tries to resolve a reference to one or many model elements (EObjects).");
		sc.add("// It is called by the EMF proxy resolution mechanism.");
		sc.add("//");
		sc.add("// @param <ContainerType> the type of the container that contains");
		sc.add("// the reference that is resolved by this resolver");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the reference that is");
		sc.add("// resolved by this resolver");
		sc.add("//");
		sc.add("// @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>");
		sc.add("public interface " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> extends " + iConfigurableClassName + " {");
		
		sc.add("// Attempts to resolve a reference string.");
		sc.add("//");
		sc.add("// @param identifier The identifier for the reference.");
		sc.add("// @param container The object that contains the reference.");
		sc.add("// @param reference The reference that points to the target of the reference.");
		sc.add("// @param position The index of the reference (if it has an upper bound greater than 1).");
		sc.add("// @param resolveFuzzy return objects that do not match exactly");
		sc.add("// @param result an object that can be sued to store the result of the resolve operation.");
		sc.add("public void resolve(String identifier, ContainerType container, " + E_REFERENCE + " reference, int position, boolean resolveFuzzy, " + iReferenceResolveResultClassName + "<ReferenceType> result);");
		sc.addLineBreak();
		
		sc.add("// Reverse of the resolve operation: constructs a representing String of the given");
		sc.add("// object.");
		sc.add("//");
		sc.add("// @param element The referenced model element.");
		sc.add("// @param container The object referencing the element.");
		sc.add("// @param reference The reference that holds the element.");
		sc.add("//");
		sc.add("// @return The identification string for the reference");
		sc.add("public String deResolve(ReferenceType element, ContainerType container, " + E_REFERENCE + " reference);");
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
