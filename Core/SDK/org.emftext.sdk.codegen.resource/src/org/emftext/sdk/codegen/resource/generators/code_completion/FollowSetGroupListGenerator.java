/*******************************************************************************
 * Copyright (c) 2006-2014
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

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class FollowSetGroupListGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite jc) {
		
		jc.add("package " + getResourcePackageName() + ";");
		jc.addLineBreak();
		jc.addImportsPlaceholder();
		jc.addLineBreak();
		
		jc.addJavadoc("This class is used when computing code completion proposals hold groups of expected elements which belong to the same follow set.");
		jc.add("public class " + getResourceClassName() + " {");
		jc.addLineBreak();
		addFields(jc);
		addConstructor(jc);
		addMethods(jc);
		jc.add("}");
	}

	private void addFields(JavaComposite jc) {
		jc.add("private int lastFollowSetID = -1;");
		jc.add("private " + LIST(jc) + "<" + followSetGroupClassName + "> followSetGroups = new " + ARRAY_LIST(jc) + "<" + followSetGroupClassName + ">();");
		jc.addLineBreak();
	}

	private void addConstructor(JavaComposite jc) {
		jc.add("public " + getResourceClassName() + "(" + LIST(jc) + "<" + expectedTerminalClassName + "> expectedTerminals) {");
		jc.add("for (" + expectedTerminalClassName + " expectedTerminal : expectedTerminals) {");
		jc.add("addExpectedTerminal(expectedTerminal);");
		jc.add("}");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addMethods(JavaComposite jc) {
		addAddExpectedTerminalMethod(jc);
		addGetFollowSetGroupsMethod(jc);
		addAddNewGroupMethod(jc);
	}
	
	private void addAddExpectedTerminalMethod(JavaComposite jc) {
		jc.add("private void addExpectedTerminal(" + expectedTerminalClassName + " expectedTerminal) {");
		jc.add(followSetGroupClassName + " group;");
		jc.addLineBreak();
		jc.add("int followSetID = expectedTerminal.getFollowSetID();");
		jc.add("if (followSetID == lastFollowSetID) {");
		jc.add("if (followSetGroups.isEmpty()) {");
		jc.add("group = addNewGroup();");
		jc.add("} else {");
		jc.add("group = followSetGroups.get(followSetGroups.size() - 1);");
		jc.add("}");
		jc.add("} else {");
		jc.add("group = addNewGroup();");
		jc.add("lastFollowSetID = followSetID;");
		jc.add("}");
		jc.addLineBreak();
		jc.add("group.add(expectedTerminal);");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addGetFollowSetGroupsMethod(JavaComposite jc) {
		jc.add("public " + LIST(jc) +"<" + followSetGroupClassName + "> getFollowSetGroups() {");
		jc.add("return followSetGroups;");
		jc.add("}");
		jc.addLineBreak();
	}

	private void addAddNewGroupMethod(JavaComposite jc) {
		jc.add("private " + followSetGroupClassName + " addNewGroup() {");
		jc.add(followSetGroupClassName + " group = new " + followSetGroupClassName + "();");
		jc.add("followSetGroups.add(group);");
		jc.add("return group;");
		jc.add("}");
		jc.addLineBreak();
	}
}
