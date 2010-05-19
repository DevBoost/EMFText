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
package org.emftext.sdk.codegen.resource.generators;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.ClassParameters;

public class EmptyClassGenerator extends JavaBaseGenerator<ClassParameters> {

	public EmptyClassGenerator() {
		super();
	}

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getContext().getPackageName(getParameters().getTargetPackage()) + ";");
		sc.addLineBreak();

		sc.addJavadoc("This empty class was generated to overwrite exiting classes.");
		sc.add("public class " + getParameters().getClassName() + " {");
		sc.add("}");
	}
}
