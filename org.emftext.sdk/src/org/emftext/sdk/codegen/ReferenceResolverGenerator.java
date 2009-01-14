package org.emftext.sdk.codegen;

import java.io.PrintWriter;

import org.emftext.runtime.resource.IResolveResult;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;

/**
 * A generator that can create basic stub for a single reference resolver.
 */
public class ReferenceResolverGenerator extends BaseGenerator {
	
	public ReferenceResolverGenerator(GenerationContext context, String resolverClassName) {
		super(context.getResolverPackageName(), resolverClassName);
	}
	
	@Override
	public boolean generate(PrintWriter out) {     
	    out.println("package " + getResourcePackageName() + ";");	
	    out.println();
	    out.println("public class " + getResourceClassName() + " extends " + AbstractReferenceResolver.class.getName() + " {\n");
		generateDoDeResolveMethod(out);
		out.println("}");
		return true;
	}

	private void generateDoDeResolveMethod(PrintWriter out) {
		out.println("\t@Override");
		out.println("\tprotected " + String.class.getName() + " doDeResolve(" + EObject.class.getName() + " element, " + EObject.class.getName() + " container, " + EReference.class.getName() + " reference) {");
		out.println("\t\treturn super.doDeResolve(element, container, reference);");
		out.println("\t}\n");
		out.println("\t@Override");
		out.println("\tprotected void doResolve(" + String.class.getName() + " identifier, " + EObject.class.getName() + " container, " + EReference.class.getName() + " reference, int position, boolean resolveFuzzy, " + IResolveResult.class.getName() + " result) {");
		out.println("\t\tsuper.doResolve(identifier, container, reference, position, resolveFuzzy, result);");
		out.println("\t}");
	}
}
