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
			throw new BuildException("propertyName is not set.");
		}
		URI uri = URI.createFileURI(fileName);
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
