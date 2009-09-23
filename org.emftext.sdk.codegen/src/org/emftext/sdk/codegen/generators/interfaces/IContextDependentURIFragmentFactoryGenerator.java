package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IContextDependentURIFragmentFactoryGenerator extends BaseGenerator {

	private String iContextDependentURIFragmentClassName;

	public IContextDependentURIFragmentFactoryGenerator() {
		super();
	}

	private IContextDependentURIFragmentFactoryGenerator(GenerationContext context) {
		super(context, EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
		iContextDependentURIFragmentClassName = getContext().getQualifiedClassName(EArtifact.I_CONTEXT_DEPENDENT_URI_FRAGMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IContextDependentURIFragmentFactoryGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// An interface for factories to create instances of IContextDependentURIFragment.");
		sc.add("//");
		sc.add("// @param <ContainerType> the type of the class containing the reference to be resolved");
		sc.add("// @param <ReferenceType> the type of the reference to be resolved");
		sc.add("//");
		sc.add("// TODO jjohannes: figure out whether this interface must really be exposed");
		
		sc.add("public interface " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> {");
		sc.addLineBreak();
		
		sc.add("// Create a new instance of the IContextDependentURIFragment interface.");
		sc.add("//");
		sc.add("// @param identifier the identifier that references an " + E_OBJECT + "");
		sc.add("// @param container the object that contains the reference");
		sc.add("// @param reference the reference itself");
		sc.add("// @param positionInReference the position of the identifier (if the reference is multiple)");
		sc.add("// @param proxy the proxy that will be resolved later to the actual " + E_OBJECT + "");
		sc.add("// @return");
		sc.add("public " + iContextDependentURIFragmentClassName + "<?> create(String identifier, ContainerType container, " + E_REFERENCE + " reference, int positionInReference, " + E_OBJECT + " proxy);");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}