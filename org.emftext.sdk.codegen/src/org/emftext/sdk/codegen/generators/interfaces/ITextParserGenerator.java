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

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_CLASS;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ITextParserGenerator extends JavaBaseGenerator {

	private String iConfigurableClassName;
	private String iParseResultClassName;
	private String iExpectedElementClassName;

	public ITextParserGenerator() {
		super();
	}

	private ITextParserGenerator(GenerationContext context) {
		super(context, EArtifact.I_TEXT_PARSER);
		iConfigurableClassName = getContext().getQualifiedClassName(EArtifact.I_CONFIGURABLE);
		iParseResultClassName = getContext().getQualifiedClassName(EArtifact.I_PARSE_RESULT);
		iExpectedElementClassName = getContext().getQualifiedClassName(EArtifact.I_EXPECTED_ELEMENT);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ITextParserGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc, PrintWriter out) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A text parser parses a text into a tree of <code>EObject</code>s.");
		sc.add("// It is associated with a <code>TextResource</code>.");
		sc.add("public interface " + getResourceClassName() + " extends " + iConfigurableClassName + " {");
		sc.addLineBreak();
		
		sc.add("// Parses the content given to the parser and create a tree");
		sc.add("// of EObjects. The root of this tree is wrapped together");
		sc.add("// with some commands that might be executed after parsing.");
		sc.add("//");
		sc.add("// @return the result of the parse process");
		sc.add("public " + iParseResultClassName + " parse();");
		sc.addLineBreak();
		
		sc.add("// Parses the document and returns a list of expected elements.");
		sc.add("// Each expected element covers a range in the input stream.");
		sc.add("//");
		sc.add("// If the parser implementation can not determine expected");
		sc.add("// elements null can be returned.");
		sc.add("// This method is used by the code completion to figure out");
		sc.add("// which proposals can be shown to users for a given cursor");
		sc.add("// position.");
		sc.add("//");
		sc.add("// The class 'type' is used as start symbol.");
		sc.add("public " + LIST + "<" + iExpectedElementClassName + "> parseToExpectedElements(" + E_CLASS + " type);");
		sc.addLineBreak();
		
		sc.add("// Signals the parse to terminates the parsing as soon as possible.");
		sc.add("public void terminate();");
		
		sc.add("}");
		out.print(sc.toString());
		return true;
	}
}
