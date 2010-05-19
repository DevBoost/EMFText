package org.emftext.sdk.codegen;


public abstract class AbstractGenerationContext implements IContext {

	private final IFileSystemConnector fileSystemConnector;
	private final IProblemCollector problemCollector;
	
	public AbstractGenerationContext(IFileSystemConnector fileSystemConnector,
			IProblemCollector problemCollector) {
		super();
		if (fileSystemConnector == null) {
			throw new IllegalArgumentException("fileSystemConnector must not be null.");
		}
		this.fileSystemConnector = fileSystemConnector;
		if (problemCollector == null) {
			throw new IllegalArgumentException("problemCollector must not be null.");
		}
		this.problemCollector = problemCollector;
	}

	public IFileSystemConnector getFileSystemConnector() {
		return fileSystemConnector;
	}

	public IProblemCollector getProblemCollector() {
		return problemCollector;
	}
}
