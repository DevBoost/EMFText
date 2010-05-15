/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IContextDependentURIFragmentFactoryGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new IContextDependentURIFragmentFactoryGenerator());

	private IContextDependentURIFragmentFactoryGenerator() {
		super();
	}

	private IContextDependentURIFragmentFactoryGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.I_CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new IContextDependentURIFragmentFactoryGenerator(parent, context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
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
		return true;
	}
}
