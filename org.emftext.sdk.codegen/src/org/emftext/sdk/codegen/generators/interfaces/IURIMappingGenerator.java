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

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IURIMappingGenerator extends JavaBaseGenerator {

	private String iReferenceMappingClassName;

	public IURIMappingGenerator() {
		super();
	}

	private IURIMappingGenerator(GenerationContext context) {
		super(context, EArtifact.IURI_MAPPING);
		iReferenceMappingClassName = getContext().getQualifiedClassName(EArtifact.I_REFERENCE_MAPPING);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IURIMappingGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// Implementors of this interface map identifiers to URIs.");
		sc.add("// This is sometime necessary when resolving references depends");
		sc.add("// on the resolution of others.");
		sc.add("//");
		sc.add("// @param <ReferenceType> unused type parameter which is needed to implement IReferenceMapping.");
		sc.add("//");
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> extends " + iReferenceMappingClassName + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.add("// Returns an alternative proxy " + URI + " that should follow EMF's default naming scheme");
		sc.add("// such that it can be resolved by the default resolution mechanism that will be called");
		sc.add("// on this " + URI + " (see <code>Resource.getEObject()</code>).");
		
		sc.add("public " + URI + " getTargetIdentifier();");
		sc.add("}");
		return true;
	}
}
