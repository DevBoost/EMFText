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
 * This class is used to create an example project via the new dialog of Eclipse.
 * The contents of the example project are obtained from a ZIP file named
 * <code>newProject.zip</code> that must be located in the resource.ui plug-in. If
 * not such ZIP file can be found, an empty project containing an example file of
 * the DSL is created.
 */
public class CsNewProjectWizardLogic {
	
	/**
	 * Creates the example project by unzipping the contents of
	 * <code>newProjectZip</code>.
	 */
	public void createExampleProject(org.eclipse.core.runtime.IProgressMonitor monitor, org.eclipse.core.runtime.IPath projectPath, String projectName, String newProjectZip) throws InterruptedException {
		try {
			monitor.beginTask("Creating Example Project", 120);
			
			// Create the project folder
			String projectFolder = projectPath.toOSString() + java.io.File.separator + projectName;
			java.io.File projectFolderFile = new java.io.File(projectFolder);
			
			org.eclipse.core.resources.IWorkspace workspace = org.eclipse.core.resources.ResourcesPlugin.getWorkspace();
			org.eclipse.core.resources.IProject project = workspace.getRoot().getProject(projectName);
			
			// If the project does not exist, we will create it and populate it.
			if (!project.exists()) {
				projectFolderFile.mkdirs();
				monitor.worked(10);
				
				org.osgi.framework.Bundle bundle = org.eclipse.core.runtime.Platform.getBundle("org.emftext.sdk.concretesyntax.resource.cs.ui");
				java.net.URL newProjectZipURL = bundle.getEntry(newProjectZip);
				
				if (newProjectZipURL != null) {
					// Copy plug-in project code
					extractProject(projectFolderFile, newProjectZipURL, new org.eclipse.core.runtime.SubProgressMonitor(monitor, 100));
				}
				
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				
				org.eclipse.core.resources.IProjectDescription desc = workspace.newProjectDescription(project.getName());
				if (!projectPath.equals(workspace.getRoot().getLocation())) {
					desc.setLocation(new org.eclipse.core.runtime.Path(projectFolder));
				}
				
				String natureID = org.emftext.sdk.concretesyntax.resource.cs.mopp.CsNature.NATURE_ID;
				java.util.List<org.eclipse.core.resources.ICommand> buildCommands = new java.util.ArrayList<org.eclipse.core.resources.ICommand>();
				for (String builderID : org.emftext.sdk.concretesyntax.resource.cs.mopp.CsNature.BUILDER_IDS) {
					org.eclipse.core.resources.ICommand command = desc.newCommand();
					command.setBuilderName(builderID);
					buildCommands.add(command);
				}
				
				desc.setNatureIds(new String[] {natureID});
				desc.setBuildSpec(buildCommands.toArray(new org.eclipse.core.resources.ICommand[buildCommands.size()]));
				project.create(desc, monitor);
				// Now, we ensure that the project is open.
				project.open(monitor);
				renameProject(project, projectName);
				
				org.eclipse.core.resources.IFile defaultNewFile = project.getFile("NEW_FILE_PLACEHOLDER");
				if (newProjectZipURL == null) {
					defaultNewFile.create(new java.io.ByteArrayInputStream(new byte[0]), true, null);
				}
				if (defaultNewFile.exists()) {
					org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation info = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation();
					String fileName = "new_file." + info.getSyntaxName();
					String content = info.getNewFileContentProvider().getNewFileContent("new_file." + info.getSyntaxName());
					defaultNewFile.setContents(new java.io.ByteArrayInputStream(content.getBytes()), org.eclipse.core.resources.IFile.FORCE, null);
					defaultNewFile.move(project.getProjectRelativePath().append(fileName), true, null);
				}
			}
			
			monitor.worked(10);
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			
		} catch (java.io.IOException e) {
			throw new RuntimeException(e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			throw new RuntimeException(e);
		} finally {
			monitor.done();
		}
	}
	
	/**
	 * Unzip the project archive to the specified folder
	 * 
	 * @param projectFolderFile The folder where to unzip the project archive
	 * @param monitor Monitor to display progress and/or cancel operation
	 * 
	 * @throws java.io.IOException
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws java.io.FileNotFoundException
	 */
	private void extractProject(java.io.File projectFolderFile, java.net.URL url, org.eclipse.core.runtime.IProgressMonitor monitor) throws java.io.FileNotFoundException, java.io.IOException, InterruptedException {
		
		// Get project archive
		java.net.URL urlZipLocal = org.eclipse.core.runtime.FileLocator.toFileURL(url);
		
		// Walk each element and unzip
		java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(urlZipLocal.getPath());
		
		try {
			// Allow for a hundred work units
			monitor.beginTask("Extracting Project", zipFile.size());
			
			unzip(zipFile, projectFolderFile, monitor);
		} finally {
			zipFile.close();
			monitor.done();
		}
	}
	
	/**
	 * Unzips the platform formatted zip file to specified folder
	 * 
	 * @param zipFile The platform formatted zip file
	 * @param projectFolderFile The folder where to unzip the project archive
	 * @param monitor Monitor to display progress and/or cancel operation
	 * 
	 * @throws java.io.IOException
	 * 
	 * @throws java.io.FileNotFoundException
	 * 
	 * @throws InterruptedException
	 */
	private void unzip(java.util.zip.ZipFile zipFile, java.io.File projectFolderFile, org.eclipse.core.runtime.IProgressMonitor monitor) throws java.io.IOException, java.io.FileNotFoundException, InterruptedException {
		
		java.util.Enumeration<? extends java.util.zip.ZipEntry> e = zipFile.entries();
		
		while (e.hasMoreElements()) {
			java.util.zip.ZipEntry zipEntry = (java.util.zip.ZipEntry) e.nextElement();
			java.io.File file = new java.io.File(projectFolderFile, zipEntry.getName());
			
			if (zipEntry.isDirectory()) {
				file.mkdirs();
			} else {
				
				// Copy files (and make sure parent directory exist)
				java.io.File parentFile = file.getParentFile();
				if (null != parentFile && false == parentFile.exists()) {
					parentFile.mkdirs();
				}
				
				org.eclipse.core.runtime.Path path = new org.eclipse.core.runtime.Path(file.getPath());
				if ("java".equals(path.getFileExtension())) {
					java.io.InputStreamReader is = null;
					java.io.OutputStreamWriter os = null;
					
					try {
						is = new java.io.InputStreamReader(zipFile.getInputStream(zipEntry), "ISO-8859-1");
						os = new java.io.OutputStreamWriter(new java.io.FileOutputStream(file), org.eclipse.core.resources.ResourcesPlugin.getEncoding());
						char[] buffer = new char[102400];
						while (true) {
							int len = is.read(buffer);
							if (len < 0) {
								break;
							}
							os.write(buffer, 0, len);
						}
					} finally {
						if (null != is) {
							is.close();
						}
						if (null != os) {
							os.close();
						}
					}
				} else {
					java.io.InputStream is = null;
					java.io.OutputStream os = null;
					
					try {
						is = zipFile.getInputStream(zipEntry);
						os = new java.io.FileOutputStream(file);
						
						byte[] buffer = new byte[102400];
						while (true) {
							int len = is.read(buffer);
							if (len < 0) {
								break;
							}
							os.write(buffer, 0, len);
						}
					} finally {
						if (null != is) {
							is.close();
						}
						if (null != os) {
							os.close();
						}
					}
				}
			}
			
			monitor.worked(1);
			
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
		}
	}
	
	/**
	 * Renames the specified project to the specified name.
	 * 
	 * @param project a project to rename
	 * @param projectName a new name for the project
	 * 
	 * @throws org.eclipse.core.runtime.CoreException if something goes wrong
	 */
	private void renameProject(org.eclipse.core.resources.IProject project, String projectName) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IProjectDescription description = project.getDescription();
		description.setName(projectName);
		project.move(description, org.eclipse.core.resources.IResource.FORCE | org.eclipse.core.resources.IResource.SHALLOW, null);
	}
	
}
