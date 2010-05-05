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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class IParseResultGenerator extends JavaBaseGenerator {

	public IParseResultGenerator() {
		super();
	}

	private IParseResultGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.I_PARSE_RESULT);
	}

	public IGenerator<GenerationContext> newInstance(GenerationContext context) {
		return new IParseResultGenerator(context);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("An interface used to access the result of parsing a document.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the root object of the document.");
		sc.add("public " + E_OBJECT + " getRoot();");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns a list of commands that must be executed after parsing the document.");
		sc.add("public " + COLLECTION + "<" + iCommandClassName + "<" + iTextResourceClassName + ">> getPostParseCommands();");
		sc.addLineBreak();
		
		sc.add("}");
		return true;
	}
}
