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

public class IContextDependentURIFragmentFactoryGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"An interface for factories to create instances of " + iContextDependentUriFragmentClassName + ".",
			"@param <ContainerType> the type of the class containing the reference to be resolved",
			"@param <ReferenceType> the type of the reference to be resolved"
		);
		sc.add("public interface " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + "> {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Create a new instance of the " + iContextDependentUriFragmentClassName + " interface.",
			"@param identifier the identifier that references an Object",
			"@param container the object that contains the reference",
			"@param reference the reference itself",
			"@param positionInReference the position of the identifier (if the reference is multiple)",
			"@param proxy the proxy that will be resolved later to the actual EObject",
			"@return the new instance of " + iContextDependentUriFragmentClassName
		);
		sc.add("public " + iContextDependentUriFragmentClassName + "<?> create(String identifier, ContainerType container, " + E_REFERENCE + " reference, int positionInReference, " + E_OBJECT + " proxy);");
		sc.add("}");
	}
}
