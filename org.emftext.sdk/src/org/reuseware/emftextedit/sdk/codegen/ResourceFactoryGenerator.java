package org.reuseware.emftextedit.sdk.codegen;

import java.io.PrintWriter;


/**
 * Generates a factory for the TextResource which loads and stores generated resources. 
 * It can be registered at the EMF resource framework.
 * 
 * @see org.reuseware.emftextedit.sdk.codegen.TextResourceGenerator
 * @see org.reuseware.emftextedit.runtime.resource.resueware.emftextedit.resource.TextResource
 */

public class ResourceFactoryGenerator extends BaseGenerator {
	
	private String textResourceClassName;
	
	/**
	 * @param className The name of the generated CompilationUnit
	 * @param packageName The package name of the generated CompilationUnit
	 * @param textResourceClassName The class name of the generated TextResource 
	 * which is meant to be instanciated by the ResourceFactory.
	 */
	public ResourceFactoryGenerator(String className, String packageName, String textResourceClassName) {
		super(className, packageName);
		this.textResourceClassName = textResourceClassName;
	}

	@Override
	public boolean generate(PrintWriter out) {
        out.println("package " + super.getResourcePackageName() + ";");
        out.println();
        
		out.println("import org.eclipse.emf.common.util.URI;");
		out.println("import org.eclipse.emf.ecore.resource.Resource;");
		
		out.println("public class " +super.getResourceClassName()+ " implements Resource.Factory {\n\n");
		out.println("\tpublic " + super.getResourceClassName() + "(){");
		out.println("\t\tsuper();");
		out.println("\t}");
		out.println();
		
		out.println("\tpublic Resource createResource(URI uri){");
		out.println("\t\treturn new " + textResourceClassName + "(uri);");
		out.println("\t}");
		out.println("}");
    	
    	return true;	
    }
	
}
