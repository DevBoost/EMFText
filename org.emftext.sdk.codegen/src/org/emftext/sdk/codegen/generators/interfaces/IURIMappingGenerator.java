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
package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IURIMappingGenerator extends JavaBaseGenerator {

	public IURIMappingGenerator() {
		super();
	}

	private IURIMappingGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_URI_MAPPING);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new IURIMappingGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Implementors of this interface map identifiers to URIs. " +
			"This is sometimes necessary when resolving references depends " +
			"on the resolution of others.",
			"@param <ReferenceType> unused type parameter which is needed to implement " + iReferenceMappingClassName + "."
		);
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> extends " + iReferenceMappingClassName + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns an alternative proxy URI that should follow EMF's default naming scheme " +
			"such that it can be resolved by the default resolution mechanism that will be called " +
			"on this URI (see <code>Resource.getEObject()</code>)."
		);
		sc.add("public " + URI + " getTargetIdentifier();");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}
