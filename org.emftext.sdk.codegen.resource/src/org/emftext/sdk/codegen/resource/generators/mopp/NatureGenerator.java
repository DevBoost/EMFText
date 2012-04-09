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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_COMMAND;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROJECT_DESCRIPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROJECT_NATURE;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

@SyntaxDependent
public class NatureGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private final NameUtil nameUtil = new NameUtil();

	@Override
	public void generateJavaContents(JavaComposite sc) {
		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		String implementsClause = removeEclipseDependentCode ? "" : " implements " + I_PROJECT_NATURE;
		sc.add("public class " + getResourceClassName() + implementsClause + " {");
		sc.addLineBreak();
		
		if (!removeEclipseDependentCode) {
			addFields(sc);
			addMethods(sc);
		}
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		ConcreteSyntax syntax = getContext().getConcreteSyntax();
		sc.add("public static final String NATURE_ID = \"" + nameUtil.getNatureID(syntax) + "\";");
		sc.addLineBreak();
		sc.add("private " + I_PROJECT + " project;");
		sc.addLineBreak();
		sc.addJavadoc("the IDs of all builders, IDs of additional builders can be added here");
		sc.add("public final static String[] BUILDER_IDS = {" + builderAdapterClassName + ".BUILDER_ID};");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addActivateMethod(sc);
		addDeactivateMethod(sc);
		addHasNatureMethod(sc);
		addConfigureMethod(sc);
		addDeconfigureMethod(sc);
		addGetProjectMethod(sc);
		addSetProjectMethod(sc);
	}

	private void addSetProjectMethod(StringComposite sc) {
		sc.add("public void setProject(" + I_PROJECT + " project) {");
		sc.add("this.project = project;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetProjectMethod(StringComposite sc) {
		sc.add("public " + I_PROJECT + " getProject() {");
		sc.add("return project;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeconfigureMethod(StringComposite sc) {
		sc.add("public void deconfigure() throws " + CORE_EXCEPTION + " {");
		sc.add(I_PROJECT_DESCRIPTION + " description = getProject().getDescription();");
		sc.add(I_COMMAND + "[] commands = description.getBuildSpec();");
		sc.add(I_COMMAND + "[] newCommands = commands;");
		sc.add("for (int j = 0; j < BUILDER_IDS.length; j++) {");
		sc.add("for (int i = 0; i < newCommands.length; ++i) {");
		sc.add("if (newCommands[i].getBuilderName().equals(BUILDER_IDS[j])) {");
		sc.add(I_COMMAND + "[] tempCommands = new " + I_COMMAND + "[newCommands.length - 1];");
		sc.add("System.arraycopy(newCommands, 0, tempCommands, 0, i);");
		sc.add("System.arraycopy(newCommands, i + 1, tempCommands, i, newCommands.length - i - 1);");
		sc.add("newCommands = tempCommands;");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("if (newCommands != commands) {");
		sc.add("description.setBuildSpec(newCommands);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConfigureMethod(StringComposite sc) {
		sc.add("public void configure() throws " + CORE_EXCEPTION + " {");
		sc.add(I_PROJECT_DESCRIPTION + " desc = project.getDescription();");
		sc.add(I_COMMAND + "[] commands = desc.getBuildSpec();");
		sc.addLineBreak();
		sc.add("for (int i = 0; i < commands.length; ++i) {");
		sc.add("if (commands[i].getBuilderName().equals(" + builderAdapterClassName + ".BUILDER_ID)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add(I_COMMAND + "[] newCommands = commands;");
		sc.add("outer: for (int j = 0; j < BUILDER_IDS.length; j++) {");
		sc.add("for (int i = 0; i < commands.length; ++i) {");
		sc.add("if (commands[i].getBuilderName().equals(BUILDER_IDS[j])) {");
		sc.add("continue outer;");
		sc.add("}");
		sc.add("}");
		sc.add(I_COMMAND + "[] tempCommands = new " + I_COMMAND + "[newCommands.length + 1];");
		sc.add("System.arraycopy(newCommands, 0, tempCommands, 0, newCommands.length);");
		sc.add(I_COMMAND + " command = desc.newCommand();");
		sc.add("command.setBuilderName(BUILDER_IDS[j]);");
		sc.add("tempCommands[tempCommands.length - 1] = command;");
		sc.add("newCommands = tempCommands;");
		sc.add("}");
		sc.add("if (newCommands != commands) {");
		sc.add("desc.setBuildSpec(newCommands);");
		sc.add("project.setDescription(desc, null);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasNatureMethod(StringComposite sc) {
		sc.add("public static boolean hasNature(" + I_PROJECT + " project) {");
		sc.add("try {");
		sc.add(I_PROJECT_DESCRIPTION + " description = project.getDescription();");
		sc.add("String[] natures = description.getNatureIds();");
		sc.add("for (int i = 0; i < natures.length; ++i) {");
		sc.add("if (NATURE_ID.equals(natures[i])) {");
		sc.add("return true;");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeactivateMethod(JavaComposite sc) {
		sc.add("public static void deactivate(" + I_PROJECT + " project) {");
		sc.add("try {");
		sc.add(I_PROJECT_DESCRIPTION + " description = project.getDescription();");
		sc.add("String[] natures = description.getNatureIds();");
		sc.addLineBreak();
		sc.add("for (int i = 0; i < natures.length; ++i) {");
		sc.add("if (NATURE_ID.equals(natures[i])) {");
		sc.addComment("Remove the nature");
		sc.add("String[] newNatures = new String[natures.length - 1];");
		sc.add("System.arraycopy(natures, 0, newNatures, 0, i);");
		sc.add("System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);");
		sc.add("description.setNatureIds(newNatures);");
		sc.add("project.setDescription(description, null);");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addActivateMethod(JavaComposite sc) {
		sc.add("public static void activate(" + I_PROJECT + " project) {");
		sc.add("try {");
		sc.add(I_PROJECT_DESCRIPTION + " description = project.getDescription();");
		sc.add("String[] natures = description.getNatureIds();");
		sc.addLineBreak();
		sc.add("for (int i = 0; i < natures.length; ++i) {");
		sc.add("if (NATURE_ID.equals(natures[i])) {");
		sc.addComment("already active");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.addComment("Add the nature");
		sc.add("String[] newNatures = new String[natures.length + 1];");
		sc.add("System.arraycopy(natures, 0, newNatures, 0, natures.length);");
		sc.add("newNatures[natures.length] = NATURE_ID;");
		sc.add("description.setNatureIds(newNatures);");
		sc.add("project.setDescription(description, null);");
		sc.add("} catch (" + CORE_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
