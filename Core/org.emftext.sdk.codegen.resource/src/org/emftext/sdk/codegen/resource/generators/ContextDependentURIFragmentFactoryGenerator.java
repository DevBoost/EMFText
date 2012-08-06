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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_REFERENCE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;

public class ContextDependentURIFragmentFactoryGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
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
		addFields(sc);
		addConstructor(sc);
		addCreateMethod(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.add("private final " + iReferenceResolverClassName + "<ContainerType, ReferenceType> resolver;");
		sc.addLineBreak();
	}

	private void addConstructor(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + iReferenceResolverClassName + "<ContainerType, ReferenceType> resolver) {");
		sc.add("this.resolver = resolver;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCreateMethod(JavaComposite sc) {
		sc.add("public " + iContextDependentUriFragmentClassName + "<?> create(String identifier, ContainerType container, " + E_REFERENCE + " reference, int positionInReference, " + E_OBJECT + " proxy) {");
		sc.addLineBreak();
		sc.add("return new " + contextDependentUriFragmentClassName + "<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {");
		sc.add("public " + iReferenceResolverClassName + "<ContainerType, ReferenceType> getResolver() {");
		sc.add("return resolver;");
		sc.add("}");
		sc.add("};");
		sc.add("}");
	}

	
}
