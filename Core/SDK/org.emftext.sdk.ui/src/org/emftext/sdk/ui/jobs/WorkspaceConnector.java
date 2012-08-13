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
package org.emftext.sdk.ui.jobs;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.emftext.sdk.IPluginDescriptor;
import org.emftext.sdk.codegen.IFileSystemConnector;

/**
 * An implementation of IFileSystemConnector that uses the Eclipse
 * workspace to determine the location of plug-ins.
 */
public class WorkspaceConnector implements IFileSystemConnector {

	public File getProjectFolder(IPluginDescriptor plugin) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(plugin.getName());
		return project.getLocation().toFile().getAbsoluteFile();
	}
}
