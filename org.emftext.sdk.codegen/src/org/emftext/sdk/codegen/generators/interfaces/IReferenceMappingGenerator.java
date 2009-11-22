/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IReferenceMappingGenerator extends JavaBaseGenerator {

	public IReferenceMappingGenerator() {
		super();
	}

	private IReferenceMappingGenerator(GenerationContext context) {
		super(context, EArtifact.I_REFERENCE_MAPPING);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IReferenceMappingGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A mapping from an identifier to something else. The");
		sc.add("// &quot;something else&quot; is defined by subclasses");
		sc.add("// of this interface. Implementors of such subclasses");
		sc.add("// are used during the process of resolving references,");
		sc.add("// where identifiers need to be mapped to other object.");
		sc.add("//");
		sc.add("// This interface must not be implemented by clients.");
		sc.add("//");
		sc.add("// @param <ReferenceType> the type of the reference this mapping points to.");
		sc.add("public interface " + getResourceClassName() + "<ReferenceType> {");
		sc.addLineBreak();
		
		sc.add("// Returns the identifier that is mapped.");
		sc.add("public String getIdentifier();");
		sc.addLineBreak();
		
		sc.add("// A mapping can have a warning attached that contains");
		sc.add("// additional information (e.g., when the mapping might");
		sc.add("// be wrong under specific conditions). The warning is");
		sc.add("// meant to be presented to the user together with the");
		sc.add("// mapping result.");
		sc.add("public String getWarning();");
		sc.add("}");
		return true;
	}
}
