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
package org.emftext.sdk.codegen.resource.generators.util;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class CastUtilGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public CastUtilGenerator() {
		super();
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Utility class that provides a method to cast objects to " +
			"type parameterized classes without a warning."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("@SuppressWarnings(\"unchecked\")").addLineBreak();
		sc.add("public static <T> T cast(Object temp) {");
		sc.add("return (T) temp;");
		sc.add("}");
		sc.add("}");
	}
}
