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
package org.emftext.sdk.codegen.antlr.creators;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The {@link SourceCodeStreamFactory} provides access to source code files that
 * are required by the EMFText code generators.
 */
public class SourceCodeStreamFactory {

	/**
	 * Returns a stream from which the source code for class 
	 * <code>className</code> can be read.
	 */
	public InputStream getSourceCodeStream(Class<?> referenceClass,
			String className) throws MalformedURLException, IOException {
		
		String relativePathToSourceFile = className.replace(".", "/") + ".java";
		String referenceClassFileName = referenceClass.getSimpleName() + ".class";
		URL referenceURL = referenceClass.getResource(referenceClassFileName);
		String referencePackageName = referenceClass.getPackage().getName();
		String packagePath = referencePackageName.replace(".", "/");
		String urlString = referenceURL.toString().replace("bin/" + packagePath + "/", "");
		urlString = urlString.replace(packagePath + "/", "");
		urlString = urlString.substring(0, urlString.length() - referenceClassFileName.length());
		String pathToSourceFile = urlString + "src-runtime/" + relativePathToSourceFile;
		URL sourceURL = new URL(pathToSourceFile);
		InputStream sourceStream = sourceURL.openStream();
		return sourceStream;
	}
}
