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

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IElementMappingGenerator extends JavaBaseGenerator<Object> {

	public IElementMappingGenerator() {
		super();
	}

	private IElementMappingGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_ELEMENT_MAPPING);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new IElementMappingGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A mapping from an identifier to an EObject.",
			"@param <ReferenceType> the type of the reference this mapping points to."
		);
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> extends " + iReferenceMappingClassName + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the target object the identifier is mapped to.");
		sc.add("public ReferenceType getTargetElement();");
		sc.add("}");
		return true;
	}
}
