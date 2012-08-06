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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.*;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class IReferenceCacheGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.addJavadoc("Returns all EObjects of the given type.");
		sc.add("public " + SET + "<" + E_OBJECT + "> getObjects(" + E_CLASS + " type);");
		sc.addLineBreak();

		sc.addJavadoc(
				"Initializes the cache with the object tree that is rooted at <code>root</code>. " +
				"The cache allows to retrieve of objects of a given type or a given name. " +
				"If the cache was already initialized, no action is performed."
			);
			sc.add("public void initialize(" + E_OBJECT + " root);");
			sc.addLineBreak();

		sc.addJavadoc(
			"Returns the map from object names to objects that was created when the cache was initialized."
		);
		sc.add("public " + MAP + "<String, " + SET + "<" + E_OBJECT + ">> getNameToObjectsMap();");
		sc.addLineBreak();

		sc.addJavadoc("Clears the cache.");
		sc.add("public void clear();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
