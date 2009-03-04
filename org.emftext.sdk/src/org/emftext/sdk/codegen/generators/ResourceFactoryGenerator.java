/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;

/**
 * Generates a factory for the TextResource which loads and stores generated resources. 
 * It can be registered to the EMF resource framework.
 * 
 * @see org.emftext.sdk.codegen.generators.TextResourceGenerator
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
		super(context.getPackageName(), context.getResourceFactoryClassName());
		this.textResourceClassName = context.getResourceClassName();
	}

	@Override
	public boolean generate(PrintWriter out) {
		StringComposite sc = new JavaComposite();
		
        sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
        
        sc.add("import " + org.eclipse.emf.common.util.URI.class.getName() + ";");
        sc.add("import " + org.eclipse.emf.ecore.resource.Resource.class.getName() + ";");
		sc.addLineBreak();

        sc.add("public class " + getResourceClassName()+ " implements Resource.Factory {");
        sc.addLineBreak();
        
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public Resource createResource(URI uri) {");
		sc.add("return new " + textResourceClassName + "(uri);");
		sc.add("}");
		
		sc.add("}");
    	
		out.print(sc.toString());
    	return true;	
    }
}
