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
package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_REFERENCE;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;

public class ContextDependentURIFragmentFactoryGenerator extends JavaBaseGenerator {

	public ContextDependentURIFragmentFactoryGenerator() {
		super();
	}

	private ContextDependentURIFragmentFactoryGenerator(GenerationContext context) {
		super(context, EArtifact.CONTEXT_DEPENDENT_URI_FRAGMENT_FACTORY);
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
		sc.add("private final " + getClassNameHelper().getI_REFERENCE_RESOLVER() + "<ContainerType, ReferenceType> resolver;");
		sc.addLineBreak();
		sc.add("public " + getResourceClassName() + "(" + getClassNameHelper().getI_REFERENCE_RESOLVER() + "<ContainerType, ReferenceType> resolver) {");
		sc.add("this.resolver = resolver;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + getClassNameHelper().getI_CONTEXT_DEPENDENT_URI_FRAGMENT() + "<?> create(String identifier, ContainerType container, " + E_REFERENCE + " reference, int positionInReference, " + E_OBJECT + " proxy) {");
		sc.addLineBreak();
		sc.add("return new " + contextDependentUriFragmentClassName + "<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {");
		sc.add("public " + getClassNameHelper().getI_REFERENCE_RESOLVER() + "<ContainerType, ReferenceType> getResolver() {");
		sc.add("return resolver;");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("}");
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ContextDependentURIFragmentFactoryGenerator(context);
	}
}
