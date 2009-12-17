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

	private void addFields(org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public static final String NATURE_ID = \"" + getContext().getNatureID() + "\";");
		sc.addLineBreak();
		sc.add("private " + I_PROJECT + " project;");
		sc.addLineBreak();
	}

	private void addMethods(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		addActivateMethod(sc);
		addDeactivateMethod(sc);
		addHasNatureMethod(sc);
		addConfigureMethod(sc);
		addDeconfigureMethod(sc);
		addGetProjectMethod(sc);
		addSetProjectMethod(sc);
	}

	private void addSetProjectMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void setProject(" + I_PROJECT + " project) {");
		sc.add("this.project = project;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetProjectMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public " + I_PROJECT + " getProject() {");
		sc.add("return project;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDeconfigureMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void deconfigure() throws " + CORE_EXCEPTION + " {");
		sc.add(I_PROJECT_DESCRIPTION + " description = getProject().getDescription();");
		sc.add(I_COMMAND + "[] commands = description.getBuildSpec();");
		sc.add("for (int i = 0; i < commands.length; ++i) {");
		sc.add("if (commands[i].getBuilderName().equals(" + builderAdapterClassName + ".BUILDER_ID)) {");
		sc.add(I_COMMAND + "[] newCommands = new " + I_COMMAND + "[commands.length - 1];");
		sc.add("System.arraycopy(commands, 0, newCommands, 0, i);");
		sc.add("System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);");
		sc.add("description.setBuildSpec(newCommands);");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConfigureMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
		sc.add("public void configure() throws " + CORE_EXCEPTION + " {");
		sc.add(I_PROJECT_DESCRIPTION + " desc = project.getDescription();");
		sc.add(I_COMMAND + "[] commands = desc.getBuildSpec();");
		sc.addLineBreak();
		sc.add("for (int i = 0; i < commands.length; ++i) {");
		sc.add("if (commands[i].getBuilderName().equals(" + builderAdapterClassName + ".BUILDER_ID)) {");
		sc.add("return;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		sc.add(I_COMMAND + "[] newCommands = new " + I_COMMAND + "[commands.length + 1];");
		sc.add("System.arraycopy(commands, 0, newCommands, 0, commands.length);");
		sc.add(I_COMMAND + " command = desc.newCommand();");
		sc.add("command.setBuilderName(" + builderAdapterClassName + ".BUILDER_ID);");
		sc.add("newCommands[newCommands.length - 1] = command;");
		sc.add("desc.setBuildSpec(newCommands);");
		sc.add("project.setDescription(desc, null);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasNatureMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
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

	private void addDeactivateMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
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

	private void addActivateMethod(
			org.emftext.sdk.codegen.composites.StringComposite sc) {
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
