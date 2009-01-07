package org.emftext.sdk.codegen;

import java.io.PrintWriter;


/**
 * Generates a factory for the TextResource which loads and stores generated resources. 
 * It can be registered at the EMF resource framework.
 * 
 * @see org.emftext.sdk.codegen.TextResourceGenerator
 * @see org.emftext.runtime.resource.ITextResource
 */

public class ResourceFactoryGenerator extends BaseGenerator {
	
	private String textResourceClassName;
	
	/**
	 * @param className The name of the generated CompilationUnit
	 * @param packageName The package name of the generated CompilationUnit
	 * @param textResourceClassName The class name of the generated TextResource 
	 * which is meant to be instantiated by the ResourceFactory.
	 */
	public ResourceFactoryGenerator(GenerationContext context) {
		super(context.getPackageName(), context.getResourceFactoryName());
		this.textResourceClassName = context.getResourceName();
	}

	@Override
	public boolean generate(PrintWriter out) {
        out.println("package " + getResourcePackageName() + ";");
        out.println();
        
		out.println("import " + org.eclipse.emf.common.util.URI.class.getName() + ";");
		out.println("import " + org.eclipse.emf.ecore.resource.Resource.class.getName() + ";");
		
		out.println("public class " + getResourceClassName()+ " implements Resource.Factory {\n\n");
		out.println("\tpublic " + getResourceClassName() + "() {");
		out.println("\t\tsuper();");
		out.println("\t}");
		out.println();
		
		out.println("\tpublic Resource createResource(URI uri) {");
		out.println("\t\treturn new " + textResourceClassName + "(uri);");
		out.println("\t}");
		out.println("}");
    	
    	return true;	
    }
}
