/*******************************************************************************
 * Copyright (c) 2006-2011
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

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IHoverTextProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addJavadoc(
			"Returns the hoves text that is shown when the mouse pointer rests over the given object. " +
			"The hover text can contain HTML."
		);
		sc.add("public String getHoverText(" + E_OBJECT + " object);");
		sc.addLineBreak();

		sc.addJavadoc(
			"Returns the hoves text that is shown when the mouse pointer rests over a reference to the given object. " +
			"The hover text can contain HTML."
		);
		sc.add("public String getHoverText(" + E_OBJECT + " container, " + E_OBJECT + " referencedObject);");
		sc.addLineBreak();
		sc.add("}");
	}
}
