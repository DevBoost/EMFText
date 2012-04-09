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
package org.emftext.sdk.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.emf.common.util.URI;

/**
 * A custom ANT task that allows to assign the URI of a given
 * file to a build property. 
 */
public class CreateURITask extends Task {
	
	private String propertyName;
	private String fileName;

	@Override
	public void execute() throws BuildException {
		if (getPropertyName() == null) {
			throw new BuildException("propertyName is not set.");
		}
		if (getFileName() == null) {
			throw new BuildException("fileName is not set.");
		}
		URI uri = URI.createFileURI(fileName);
		if (uri.isRelative()) {
			URI base = URI.createFileURI(getProject().getBaseDir().getPath() + "/");
			uri = uri.resolve(base);
		}
		getProject().setProperty(getPropertyName(), uri.toString());
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
