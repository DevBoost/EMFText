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
package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;

public class ContextDependentURIFragmentFactoryGenerator extends JavaBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER = 
		new GeneratorProvider<GenerationContext, Object>(new ContextDependentURIFragmentFactoryGenerator());

	private ContextDependentURIFragmentFactoryGenerator() {
		super();
	}

	private ContextDependentURIFragmentFactoryGenerator(ICodeGenerationComponent parent, GenerationContext context) {
		super(parent, context, TextResourceArtifacts.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"A factory for ContextDependentURIFragments. Given a feasible reference resolver, " +
			"this factory returns a matching fragment that used the resolver to resolver proxy " +
			"objects.",
			"@param <ContainerType> the type of the class containing the reference to be resolved",
			"@param <ReferenceType> the type of the reference to be resolved"
		);
		sc.add("public class " + getResourceClassName() + "<ContainerType extends " + E_OBJECT + ", ReferenceType extends " + E_OBJECT + ">  implements " + iContextDependentUriFragmentFactoryClassName + "<ContainerType, ReferenceType> {");
		sc.addLineBreak();
		sc.add("private final " + iReferenceResolverClassName + "<ContainerType, ReferenceType> resolver;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + iReferenceResolverClassName + "<ContainerType, ReferenceType> resolver) {");
		sc.add("this.resolver = resolver;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + iContextDependentUriFragmentClassName + "<?> create(String identifier, ContainerType container, " + E_REFERENCE + " reference, int positionInReference, " + E_OBJECT + " proxy) {");
		sc.addLineBreak();
		sc.add("return new " + contextDependentUriFragmentClassName + "<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {");
		sc.add("public " + iReferenceResolverClassName + "<ContainerType, ReferenceType> getResolver() {");
		sc.add("return resolver;");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("}");
		return true;
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new ContextDependentURIFragmentFactoryGenerator(parent, context);
	}
}
