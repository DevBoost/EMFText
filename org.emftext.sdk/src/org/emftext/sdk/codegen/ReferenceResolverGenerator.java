package org.emftext.sdk.codegen;

import java.io.PrintWriter;

import org.emftext.runtime.resource.IResolveResult;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.impl.ReferenceResolverImpl;

/**
 * Generates basic stubs for reference resolvers.
 * 
 * TODO mseifert: change suffix for classes from IReferenceResolver to ReferenceResolver 
 */
public class ReferenceResolverGenerator extends BaseGenerator {
	
	public ReferenceResolverGenerator(String resolveClassName, String resolvePackageName){
		super(resolveClassName,resolvePackageName);
	}
	
	@Override
	public boolean generate(PrintWriter out) {     
	    out.println("package " + getResourcePackageName() + ";");	
	    out.println();
	    out.println("import " + EObject.class.getName() + ";");
	    out.println("import " + EReference.class.getName() + ";");
	    out.println();
	    out.println("public class " + getResourceClassName() + " extends " + ReferenceResolverImpl.class.getName() + " {\n");
		out.println("\t@Override");
		out.println("\tprotected String doDeResolve(EObject element, EObject container, EReference reference) {");
		out.println("\t\treturn super.doDeResolve(element, container, reference);");
		out.println("\t}\n");
		out.println("\t@Override");
		out.println("\tprotected void doResolve(String identifier, EObject container, EReference reference, int position, boolean resolveFuzzy, " + IResolveResult.class.getName() + " result) {");
		out.println("\t\tsuper.doResolve(identifier, container, reference, position, resolveFuzzy, result);");
		out.println("\t}");
		out.println("}");
		
		return true;
	}
}
