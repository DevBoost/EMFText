package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_COMMAND;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROJECT_DESCRIPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_PROJECT_NATURE;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;

public class NatureGenerator extends JavaBaseGenerator {

	private String builderAdapterClassName;

	public NatureGenerator() {
		super();
	}

	private NatureGenerator(GenerationContext context) {
		super(context, EArtifact.NATURE);
		builderAdapterClassName = getContext().getQualifiedClassName(EArtifact.BUILDER_ADAPTER);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new NatureGenerator(context);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_PROJECT_NATURE + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("public static final String NATURE_ID = \"" + getContext().getNatureID() + "\";");
		sc.addLineBreak();
		sc.add("private " + I_PROJECT + " project;");
		sc.addLineBreak();
		sc.add("// the IDs of all builders, IDs of additional builders can be added here");
		sc.add("public final static String[] BUILDER_IDS = {" + builderAdapterClassName + ".BUILDER_ID};");
		sc.addLineBreak();
	}

	private void addMethods(StringComposite sc) {
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

	private void addDeactivateMethod(StringComposite sc) {
		sc.add("public static void deactivate(" + I_PROJECT + " project) {");
		sc.add("try {");
		sc.add(I_PROJECT_DESCRIPTION + " description = project.getDescription();");
		sc.add("String[] natures = description.getNatureIds();");
		sc.addLineBreak();
		sc.add("for (int i = 0; i < natures.length; ++i) {");
		sc.add("if (NATURE_ID.equals(natures[i])) {");
		sc.add("// Remove the nature");
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

	private void addActivateMethod(StringComposite sc) {
		sc.add("public static void activate(" + I_PROJECT + " project) {");
		sc.add("try {");
		sc.add(I_PROJECT_DESCRIPTION + " description = project.getDescription();");
		sc.add("String[] natures = description.getNatureIds();");
		sc.addLineBreak();
		sc.add("for (int i = 0; i < natures.length; ++i) {");
		sc.add("if (NATURE_ID.equals(natures[i])) {");
		sc.add("// already active");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("// Add the nature");
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
