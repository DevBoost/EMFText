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
package org.emftext.sdk.codegen.resource.generators.code_completion;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.SET;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ExpectedEnumerationTerminalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A representation for a range in a document where an enumeration literal (i.e., a set of static strings) is expected.");
		sc.add("public class " + getResourceClassName() + " extends " + abstractExpectedElementClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + enumerationTerminalClassName + " enumerationTerminal;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + enumerationTerminalClassName + " enumerationTerminal) {");
		sc.add("super(enumerationTerminal.getMetaclass());");
		sc.add("this.enumerationTerminal = enumerationTerminal;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetTokenNamesMethod(sc);
		addGetEnumerationTerminalMethod(sc);
		addGetSyntaxElementMethod(sc);
		addToStringMethod(sc);
	}
	
	private void addGetEnumerationTerminalMethod(JavaComposite sc) {
		sc.add("public " + enumerationTerminalClassName + " getEnumerationTerminal() {");
		sc.add("return this.enumerationTerminal;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetSyntaxElementMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the expected enumeration terminal.");
		sc.add("public " + syntaxElementClassName +" getSymtaxElement() {");
		sc.add("return enumerationTerminal;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetTokenNamesMethod(JavaComposite sc) {
		sc.add("public " + SET + "<String> getTokenNames() {");
		sc.addComment(
			"EnumerationTerminals are associated with multiple tokens, " +
			"one for each literal that was mapped to a string"
		);
		sc.add(sc.declareLinkedHashSet("tokenNames", "String"));
		sc.add(MAP + "<String, String> mapping = enumerationTerminal.getLiteralMapping();");
		sc.add("for (String literalName : mapping.keySet()) {");
		sc.add("String text = mapping.get(literalName);");
		sc.add("if (text != null && !\"\".equals(text)) {");
		// TODO using single quotes here is ANTLR specific
		sc.add("tokenNames.add(\"'\" + text + \"'\");");
		sc.add("}");
		sc.add("}");
		sc.add("return tokenNames;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(StringComposite sc) {
		sc.add("public String toString() {");
		sc.add("return \"EnumTerminal \\\"\" + getEnumerationTerminal() + \"\\\"\";");
		sc.add("}");
		sc.addLineBreak();
	}
}
