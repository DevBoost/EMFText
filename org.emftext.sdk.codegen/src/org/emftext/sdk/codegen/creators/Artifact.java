/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.creators;

import java.io.File;
import java.io.InputStream;

/**
 * A default implementation of the IArtifact interface holding the
 * target file and the content stream.
 */
public class Artifact implements IArtifact {

	private File targetFile;
	private InputStream contentStream;
	
	public Artifact(File targetFile, InputStream contentStream) {
		super();
		this.targetFile = targetFile;
		this.contentStream = contentStream;
	}

	public File getTargetFile() {
		return targetFile;
	}

	public InputStream getContentStream() {
		return contentStream;
	}
}
