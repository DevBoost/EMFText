/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.ClassNameConstants.RESOURCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.URI;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

import de.devboost.codecomposers.java.JavaComposite;

/**
 * Generates a factory for the TextResource which loads and stores generated resources. 
 * It can be registered to the EMF resource framework.
 * 
 * @see org.emftext.sdk.codegen.resource.generators.ResourceGenerator
 */
public class ResourceFactoryGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
        sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
        
        sc.add("public class " + getResourceClassName()+ " implements " + RESOURCE(sc) + ".Factory {");
        sc.addLineBreak();
		addConstructor(sc);
		addCreateResourceMethod(sc);
		sc.add("}");
    }

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "() {");
		sc.add("super();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateResourceMethod(JavaComposite sc) {
		sc.add("public " + RESOURCE(sc) + " createResource(" + URI(sc) + " uri) {");
		sc.add("return new " + textResourceClassName + "(uri);");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
