/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * This class is based on:
 * <i>org.eclipse.gef.examples.ui.pde.internal.wizards.ProjectUnzipperNewWizard</i>
 * .
 * It is responsible for offering an example project via the new dialog of Eclipse.
 */
public class CsNewProjectWizard extends org.eclipse.jface.wizard.Wizard implements org.eclipse.ui.INewWizard, org.eclipse.core.runtime.IExecutableExtension {
	
	/**
	 * The name of the ZIP file that is used as content for the new project (relative
	 * to the resource UI plugin's root).
	 */
	public final static String NEW_PROJECT_ZIP_FILE_NAME = "newProject.zip";
	
	/**
	 * The single page provided by this base implementation. It provides all the
	 * functionality required to capture the name and location of the target project.
	 */
	private org.eclipse.ui.dialogs.WizardNewProjectCreationPage wizardNewProjectCreationPage;
	
	/**
	 * The name of the project creation page
	 */
	private String pageName = "New " + new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().getSyntaxName() + " Project";
	
	/**
	 * The title of the project creation page
	 */
	private String pageTitle = pageName;
	
	/**
	 * The description of the project creation page
	 */
	private String pageDescription = "Enter a name and select a location where the new project shall be created.";
	
	/**
	 *  The name of the project in the project creation page
	 */
	private String  pageProjectName = "";
	
	/**
	 * The configuration element associated with this new project wizard
	 */
	private org.eclipse.core.runtime.IConfigurationElement config;
	
	/**
	 * Creates the example project by delegating the work to
	 * org.emftext.sdk.concretesyntax.resource.cs.ui.CsNewProjectWizardLogic.
	 */
	public boolean performFinish() {
		
		try {
			org.eclipse.jface.operation.IRunnableWithProgress operation = new org.eclipse.ui.actions.WorkspaceModifyOperation() {
				
				public void execute(org.eclipse.core.runtime.IProgressMonitor monitor) throws InterruptedException {
					try {
						new org.emftext.sdk.concretesyntax.resource.cs.ui.CsNewProjectWizardLogic().createExampleProject(monitor, wizardNewProjectCreationPage.getLocationPath(), wizardNewProjectCreationPage.getProjectName(), org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.PLUGIN_ID, NEW_PROJECT_ZIP_FILE_NAME);
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}
			};
			
			getContainer().run(false, true, operation);
			
			// Set perspective
			org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard.updatePerspective(config);
		} catch (InterruptedException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Creates the sole wizard page contributed by this base implementation; the
	 * standard Eclipse WizardNewProjectCreationPage.
	 * 
	 * @see
	 * org.eclipse.ui.dialogs.WizardNewProjectCreationPage#org.eclipse.ui.dialogs.Wizar
	 * dNewProjectCreationPage(String)
	 */
	public void init(org.eclipse.ui.IWorkbench workbench, org.eclipse.jface.viewers.IStructuredSelection selection) {
		// Set default image for all wizard pages
		org.eclipse.core.runtime.IPath path = new org.eclipse.core.runtime.Path("icons/new_project_wizban.gif");
		org.osgi.framework.Bundle bundle = org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getBundle();
		java.net.URL url = org.eclipse.core.runtime.FileLocator.find(bundle, path, null);
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.eclipse.jface.resource.ImageDescriptor.createFromURL(url);
		setDefaultPageImageDescriptor(descriptor);
		
		wizardNewProjectCreationPage = new org.eclipse.ui.dialogs.WizardNewProjectCreationPage(pageName);
		wizardNewProjectCreationPage.setTitle(pageTitle);
		wizardNewProjectCreationPage.setDescription(pageDescription);
		wizardNewProjectCreationPage.setInitialProjectName(pageProjectName);
		
		this.addPage(wizardNewProjectCreationPage);
	}
	
	public void setInitializationData(org.eclipse.core.runtime.IConfigurationElement config, String propertyName, Object data) throws org.eclipse.core.runtime.CoreException {
		this.config = config;
	}
	
}
