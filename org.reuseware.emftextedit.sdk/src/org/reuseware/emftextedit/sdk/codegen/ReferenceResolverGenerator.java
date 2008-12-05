package org.reuseware.emftextedit.sdk.codegen;

import java.io.PrintWriter;

import org.reuseware.emftextedit.runtime.resource.impl.ReferenceResolverImpl;

/**
 * Generates basic stubs for reference resolvers.
 */
public class ReferenceResolverGenerator extends BaseGenerator {
	
	public ReferenceResolverGenerator(String resolveClassName, String resolvePackageName){
		super(resolveClassName,resolvePackageName);
	}
	
	@Override
	public boolean generate(PrintWriter out) {     
	    out.println("package " + getResourcePackageName() + ";");	
	    out.println();
	    out.println("import org.eclipse.emf.ecore.EObject;");
	    out.println("import org.eclipse.emf.ecore.EReference;");
	    out.println("import org.reuseware.emftextedit.runtime.resource.ResolveResult;");
	    out.println();
	    out.println("public class " + getResourceClassName() + " extends " + ReferenceResolverImpl.class.getName() + " {\n");
		out.println("\t@Override");
		out.println("\tprotected String doDeResolve(EObject element, EObject container, EReference reference) {");
		out.println("\t\treturn super.doDeResolve(element, container, reference);");
		out.println("\t}\n");
		out.println("\t@Override");
		out.println("\tprotected void doResolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, ResolveResult result) {");
		out.println("\t\tdoResolve(identifier, container, reference, position, resolveFuzzy, result);");
		out.println("\t}");
		out.println("}");
		
		return true;
	}
}
