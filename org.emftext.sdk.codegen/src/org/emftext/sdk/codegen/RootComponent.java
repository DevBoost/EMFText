package org.emftext.sdk.codegen;

public class RootComponent implements ICodeGenerationComponent {

	private final IFileSystemConnector fileSystemConnector;
	private final IProblemCollector problemCollector;
	
	public RootComponent(IFileSystemConnector fileSystemConnector,
			IProblemCollector problemCollector) {
		super();
		if (fileSystemConnector == null) {
			throw new IllegalArgumentException("fileSystemConnector must not be null.");
		}
		if (problemCollector == null) {
			throw new IllegalArgumentException("problemCollector must not be null.");
		}
		this.fileSystemConnector = fileSystemConnector;
		this.problemCollector = problemCollector;
	}
	
	public IFileSystemConnector getFileSystemConnector() {
		return fileSystemConnector;
	}
	
	public IProblemCollector getProblemCollector() {
		return problemCollector;
	}
}
