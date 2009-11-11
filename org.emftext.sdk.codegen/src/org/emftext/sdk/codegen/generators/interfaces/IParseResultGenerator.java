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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IParseResultGenerator extends JavaBaseGenerator {

	private String iTextResourceClassName;
	private String iCommandClassName;

	public IParseResultGenerator() {
		super();
	}

	private IParseResultGenerator(GenerationContext context) {
		super(context, EArtifact.I_PARSE_RESULT);
		iTextResourceClassName = getContext().getQualifiedClassName(EArtifact.I_TEXT_RESOURCE);
		iCommandClassName = getContext().getQualifiedClassName(EArtifact.I_COMMAND);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new IParseResultGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// An interface used to access the result of parsing a");
		sc.add("// document.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		sc.add("public " + E_OBJECT + " getRoot();");
		sc.addLineBreak();
		sc.add("public " + COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> getPostParseCommands();");
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
