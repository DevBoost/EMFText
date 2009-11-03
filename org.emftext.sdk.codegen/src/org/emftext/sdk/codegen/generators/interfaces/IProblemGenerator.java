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

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class IProblemGenerator extends BaseGenerator {

	private String eProblemTypeClassName;

	public IProblemGenerator() {
		super();
	}

	private IProblemGenerator(GenerationContext context) {
		super(context, EArtifact.I_PROBLEM);
		eProblemTypeClassName = getContext().getQualifiedClassName(EArtifact.E_PROBLEM_TYPE);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IProblemGenerator(context);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		
		sc.add("public String getMessage();");
		
		sc.add("public " + eProblemTypeClassName + " getType();");
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
