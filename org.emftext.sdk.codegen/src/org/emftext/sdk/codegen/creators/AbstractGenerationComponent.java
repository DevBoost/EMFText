package org.emftext.sdk.codegen.creators;

import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IFileSystemConnector;
import org.emftext.sdk.codegen.IProblemCollector;

/**
 * An abstract superclass for all participants of a code generation process.
 * All components need a parent that implements the ICodeGenerationComponent
 * interface.
 */
public abstract class AbstractGenerationComponent implements ICodeGenerationComponent {

	private ICodeGenerationComponent parent;

	public AbstractGenerationComponent() {
		super();
	}

	public AbstractGenerationComponent(ICodeGenerationComponent parent) {
		if (parent == null) {
			throw new IllegalArgumentException("Parent must not be null.");
		}
		this.parent = parent;
	}

	public IFileSystemConnector getFileSystemConnector() {
		IFileSystemConnector fileSystemConnector = getParent().getFileSystemConnector();
		assert fileSystemConnector != null : "No file system connector set in " + this;
		return fileSystemConnector;
	}

	public IProblemCollector getProblemCollector() {
		IProblemCollector problemCollector = getParent().getProblemCollector();
		assert problemCollector != null : "No file problem collector set in " + this;
		return problemCollector;
	}

	public ICodeGenerationComponent getParent() {
		return parent;
	}
}
