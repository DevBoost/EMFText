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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IReferenceResolverGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A reference resolver tries to resolve a reference to one or many model elements (EObjects). " +
			"It is called by the EMF proxy resolution mechanism.",
			"@param <ContainerType> the type of the container that contains the reference that is resolved by this resolver",
			"@param <ReferenceType> the type of the reference that is resolved by this resolver"
		);
		sc.add("public interface " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> extends " + iConfigurableClassName + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Attempts to resolve a reference string.",
			"@param identifier The identifier for the reference.",
			"@param container The object that contains the reference.",
			"@param reference The reference that points to the target of the reference.",
			"@param position The index of the reference (if it has an upper bound greater than 1).",
			"@param resolveFuzzy If true, the resolver must return all objects, even the ones that do not match the identifier",
			"@param result an object that can be used to store the result of the resolve operation."
		);
		sc.add("public void resolve(String identifier, ContainerType container, " + E_REFERENCE + " reference, int position, boolean resolveFuzzy, " + iReferenceResolveResultClassName + "<ReferenceType> result);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Reverse of the resolve operation: constructs a String representing the given object.",
			"@param element The referenced model element.",
			"@param container The object referencing the element.",
			"@param reference The reference that holds the element.",
			"@return The identification string for the reference"
		);
		sc.add("public String deResolve(ReferenceType element, ContainerType container, " + E_REFERENCE + " reference);");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
