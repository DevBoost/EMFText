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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.FILE_LOCATOR;
import static org.emftext.sdk.codegen.resource.generators.ClassNameConstants.I_EXECUTABLE_EXTENSION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BASIC_NEW_PROJECT_RESOURCE_WIZARD;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.BUNDLE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.IMAGE_DESCRIPTOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CONFIGURATION_ELEMENT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_NEW_WIZARD;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_RUNNABLE_WITH_PROGRESS;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_STRUCTURED_SELECTION;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKBENCH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.PATH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.URL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.WIZARD;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.WIZARD_NEW_PROJECT_CREATION_PAGE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.WORKSPACE_MODIFY_OPERATION;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.UIConstants;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class NewProjectWizardGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();

		sc.addJavadoc(
			"This class is based on: " +
			"<i>org.eclipse.gef.examples.ui.pde.internal.wizards.ProjectUnzipperNewWizard</i>.",
			"It is responsible for offering an example project via the new dialog of Eclipse."
		);
		sc.add("public class " + getResourceClassName() + " extends " + WIZARD(sc) + " implements " + I_NEW_WIZARD(sc) + ", " + I_EXECUTABLE_EXTENSION(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc("The name of the ZIP file that is used as content for the new project (relative to the root of the resource UI plug-in).");
		sc.add("public final static String NEW_PROJECT_ZIP_FILE_NAME = " + uiResourceBundleClassName + "." + UIResourceBundleGenerator.NEW_PROJECT_ZIP_FILE_NAME + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The single page provided by this base implementation. It provides all the " + 
			"functionality required to capture the name and location of the target " +
			"project."
		);
		sc.add("private " + WIZARD_NEW_PROJECT_CREATION_PAGE(sc) + " wizardNewProjectCreationPage;");
		sc.addLineBreak();
		
		sc.addJavadoc("The name of the project creation page");
		sc.add("private String pageName = " + uiResourceBundleClassName + "." + UIResourceBundleGenerator.NEW_PROJECT_WIZARD_PAGE_NAME + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("The title of the project creation page");
		sc.add("private String pageTitle = pageName;");
		sc.addLineBreak();
		
		sc.addJavadoc("The description of the project creation page");
		sc.add("private String pageDescription = " + uiResourceBundleClassName + "." + UIResourceBundleGenerator.NEW_PROJECT_WIZARD_PAGE_DESCRIPTION + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("The name of the project in the project creation page");
		sc.add("private String pageProjectName = " + uiResourceBundleClassName + "." + UIResourceBundleGenerator.NEW_PROJECT_WIZARD_PROJECT_NAME + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("The configuration element associated with this new project wizard");		
		sc.add("private " + I_CONFIGURATION_ELEMENT(sc) + " config;");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addPerformFinishMethod(sc);
		addInitMethod(sc);
		addSetInitializationDataMethod(sc);
	}

	private void addPerformFinishMethod(JavaComposite sc) {
		sc.addJavadoc("Creates the example project by delegating the work to " + newProjectWizardLogicClassName + ".");
		sc.add("public boolean performFinish() {");
		sc.addLineBreak();
		sc.add("try {");
		sc.add(I_RUNNABLE_WITH_PROGRESS(sc) + " operation = new " + WORKSPACE_MODIFY_OPERATION(sc) + "() {");
		sc.addLineBreak();
		sc.add("public void execute(" + I_PROGRESS_MONITOR(sc) + " monitor) throws InterruptedException {");
		sc.add("try {");
		sc.add("new " + newProjectWizardLogicClassName + "().createExampleProject(monitor, wizardNewProjectCreationPage.getLocationPath(), wizardNewProjectCreationPage.getProjectName(), " + uiPluginActivatorClassName + ".PLUGIN_ID, NEW_PROJECT_ZIP_FILE_NAME);");
		sc.add("} catch (Exception e) {");
		sc.add("throw new RuntimeException(e);");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.addLineBreak();
		sc.add("getContainer().run(false, true, operation);");
		sc.addLineBreak();
		sc.addComment("Set perspective");
		sc.add(BASIC_NEW_PROJECT_RESOURCE_WIZARD(sc) + ".updatePerspective(config);");
		sc.add("} catch (InterruptedException e) {");
		sc.add("return false;");
		sc.add("} catch (Exception e) {");
		sc.add("return false;");
		sc.add("}");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addInitMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Creates the sole wizard page contributed by this base implementation; the " +
			"standard Eclipse WizardNewProjectCreationPage.",
			"@see " + WIZARD_NEW_PROJECT_CREATION_PAGE(sc) + "#" + WIZARD_NEW_PROJECT_CREATION_PAGE(sc) + "(String)"
		);
		sc.add("public void init(" + I_WORKBENCH(sc) + " workbench, " + I_STRUCTURED_SELECTION(sc) + " selection) {");
		sc.addComment("Set default image for all wizard pages");
		sc.add(I_PATH(sc) + " path = new " + PATH(sc) + "(" + uiResourceBundleClassName + "." + UIResourceBundleGenerator.NEW_PROJECT_WIZARD_PAGE_ICON + ");");
		sc.add(BUNDLE(sc) + " bundle = " + uiPluginActivatorClassName + ".getDefault().getBundle();");
		sc.add(URL(sc) + " url = " + FILE_LOCATOR(sc) + ".find(bundle, path, null);");
		sc.add(IMAGE_DESCRIPTOR(sc) + " descriptor = " + IMAGE_DESCRIPTOR(sc) + ".createFromURL(url);");
		sc.add("setDefaultPageImageDescriptor(descriptor);");
		sc.addLineBreak();
		sc.add("wizardNewProjectCreationPage = new " + WIZARD_NEW_PROJECT_CREATION_PAGE(sc) + "(pageName);");
		sc.add("wizardNewProjectCreationPage.setTitle(pageTitle);");
		sc.add("wizardNewProjectCreationPage.setDescription(pageDescription);");
		sc.add("wizardNewProjectCreationPage.setInitialProjectName(pageProjectName);");
		sc.addLineBreak();
		sc.add("this.addPage(wizardNewProjectCreationPage);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetInitializationDataMethod(JavaComposite sc) {
		sc.add("public void setInitializationData(" + I_CONFIGURATION_ELEMENT(sc) + " config, String propertyName, Object data) throws " + CORE_EXCEPTION(sc) + " {");
		sc.add("this.config = config;");
		sc.add("}");
		sc.addLineBreak();
	}
}
