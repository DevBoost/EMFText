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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ITextParserGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A text parser parses a text into a tree of <code>EObject</code>s. " +
			"It is associated with a <code>TextResource</code>."
		);
		sc.add("public interface " + getResourceClassName() + " extends " + iConfigurableClassName + " {");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Parses the content given to the parser and create a tree " +
			"of EObjects. The root of this tree is wrapped together " +
			"with some commands that might be executed after parsing into a result object.",
			"@return the result of the parse process"
		);
		sc.add("public " + iParseResultClassName + " parse();");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Parses the document and returns a list of expected elements. " +
			"Each expected element covers a range in the input stream.",
			"If the parser implementation can not determine expected " +
			"elements null can be returned. " +
			"This method is used by the code completion to figure out " +
			"which proposals can be shown to users for a given cursor position. " +
			"The class <code>type</code> is used as start symbol. If <code>type</code> is " +
			"<code>null</code>, the start symbols from the syntax specification are used. " +
			"The <code>cursorPosition</code> is used to discard expected elements, " + 
			"which will not be needed."
		);
		sc.add("public " + LIST + "<" + expectedTerminalClassName + "> parseToExpectedElements(" + E_CLASS + " type, " + iTextResourceClassName + " dummyResource, int cursorOffset);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Signals the parse to terminate parsing as soon as possible. " +
			"This method must be called from a different thread than the one calling parse().");
		sc.add("public void terminate();");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
