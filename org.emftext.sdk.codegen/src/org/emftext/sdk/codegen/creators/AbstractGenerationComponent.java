package org.emftext.sdk.codegen.creators;

import org.emftext.sdk.codegen.IConfigurableGenerationComponent;
import org.emftext.sdk.codegen.IFileSystemConnector;
import org.emftext.sdk.codegen.IProblemCollector;

public abstract class AbstractGenerationComponent implements IConfigurableGenerationComponent {

	private IFileSystemConnector fileSystemConnector;
	private IProblemCollector problemCollector;

	public IFileSystemConnector getFileSystemConnector() {
		assert fileSystemConnector != null : "No file system connector set in " + this;
		return fileSystemConnector;
	}

	public void setFileSystemConnector(IFileSystemConnector fileSystemConnector) {
		this.fileSystemConnector = fileSystemConnector;
	}

	public IProblemCollector getProblemCollector() {
		return problemCollector;
	}

	public void setProblemCollector(IProblemCollector problemCollector) {
		this.problemCollector = problemCollector;
	}
}
