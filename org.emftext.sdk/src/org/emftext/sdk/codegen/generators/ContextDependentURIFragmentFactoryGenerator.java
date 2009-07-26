package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.*;
import org.emftext.sdk.codegen.generators.BaseGenerator;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import java.io.PrintWriter;

public class ContextDependentURIFragmentFactoryGenerator extends BaseGenerator {

	private String qualifiedContextDependentURIFragmentClassName;

	public ContextDependentURIFragmentFactoryGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getClassName(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY));
		qualifiedContextDependentURIFragmentClassName = context.getQualifiedClassName(EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A factory for ContextDependentURIFragments. Given a feasible reference resolver,");
		sc.add("// the factory returns a matching fragment that used the resolver to resolver proxy");
		sc.add("// objects.");
		sc.add("//");
		sc.add("// @param <ContainerType> the type of the class containing the reference to be resolved");
		sc.add("// @param <ReferenceType> the type of the reference to be resolved");
		sc.add("//");
		sc.add("public class " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + ">  implements " + I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY + "<ContainerType, ReferenceType> {");
		sc.addLineBreak();
		sc.add("private final " + I_REFERENCE_RESOLVER + "<ContainerType, ReferenceType> resolver;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + I_REFERENCE_RESOLVER + "<ContainerType, ReferenceType> resolver) {");
		sc.add("this.resolver = resolver;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + I_CONTEXT_DEPENDENT_URI_FRAGMENT + "<?> create(String identifier, ContainerType container, " + E_REFERENCE + " reference, int positionInReference, " + E_OBJECT + " proxy) {");
		sc.addLineBreak();
		sc.add("return new " + qualifiedContextDependentURIFragmentClassName + "<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {");
		sc.add("public " + I_REFERENCE_RESOLVER + "<ContainerType, ReferenceType> getResolver() {");
		sc.add("return resolver;");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
