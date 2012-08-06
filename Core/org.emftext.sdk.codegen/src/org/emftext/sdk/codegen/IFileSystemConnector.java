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
package org.emftext.sdk.codegen;

import java.io.File;

import org.emftext.sdk.IPluginDescriptor;

/**
 * The IFileSystemConnector interface is needed to use code
 * generators both within Eclipse where Plug-ins are located
 * in the workspace and within ANT tasks where Plug-ins are
 * located in the file system.
 */
public interface IFileSystemConnector {

	/**
	 * Returns the folder in the file system where the given plug-in
	 * can be found.
	 * 
	 * @param plugin the plug-in to locate
	 * @return a folder in the file system
	 */
	public File getProjectFolder(IPluginDescriptor plugin);
}
