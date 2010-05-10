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

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.TextResourceArtifacts;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IReferenceMappingGenerator extends JavaBaseGenerator<Object> {

	public IReferenceMappingGenerator() {
		super();
	}

	private IReferenceMappingGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_REFERENCE_MAPPING);
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new IReferenceMappingGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A mapping from an identifier to something else. The " +
			"&quot;something else&quot; is defined by subclasses " +
			"of this interface. Implementors of such subclasses " +
			"are used during the process of resolving references, " +
			"where identifiers need to be mapped to other objects.", 
			"This interface must not be implemented by clients.",
			"@param <ReferenceType> the type of the reference this mapping points to."
		);
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the identifier that is mapped.");
		sc.add("public String getIdentifier();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A mapping can have a warning attached that contains " +
			"additional information (e.g., when the mapping might " +
			"be wrong under specific conditions). The warning is " +
			"meant to be presented to the user together with the " +
			"mapping result."
		);
		sc.add("public String getWarning();");
		sc.add("}");
		return true;
	}
}
