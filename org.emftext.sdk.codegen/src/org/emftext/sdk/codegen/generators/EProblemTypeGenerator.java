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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class EProblemTypeGenerator extends JavaBaseGenerator {

	public EProblemTypeGenerator() {
		super();
	}
	
	public EProblemTypeGenerator(GenerationContext context) {
		super(context, EArtifact.E_PROBLEM_TYPE);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public enum " + getResourceClassName() + " {");
		sc.add("WARNING,ERROR;");
		sc.add("}");

		out.write(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new EProblemTypeGenerator(context);
	}

}
