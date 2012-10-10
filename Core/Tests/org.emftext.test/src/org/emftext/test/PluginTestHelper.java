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
package org.emftext.test;

import java.io.File;
import java.net.URL;

public class PluginTestHelper {

	public String getPluginRootPath(Class<?> clazz) {
		URL location = clazz.getProtectionDomain().getCodeSource().getLocation();
		String binFolder = location.getFile().replace("%20", " ");
		String rootPathString;
		// we must not use File.separator here as the path is obtained from an URL
		// which uses forward slashes on all OS
		if (binFolder.endsWith("/bin/")) {
			rootPathString = binFolder + File.separator + "..";
		} else {
			rootPathString = binFolder;
		}
		String pluginRootPath = new File(rootPathString).getAbsolutePath();
		return pluginRootPath;
	}

	public String getSourcePackagePath(Class<?> clazz) {
		String pluginRootPath = getPluginRootPath(clazz);
		String packageDirectory = File.separator + "src" + File.separator + clazz.getPackage().getName().replace(".", File.separator) + File.separator;
		String sourcePackagePath = pluginRootPath + packageDirectory;
		return sourcePackagePath;
	}
}
